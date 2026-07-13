package com.socialquantum.googleplay.extention;

import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import com.prime31.GameHelper;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PlayGameService.java */
/* JADX INFO: loaded from: classes.dex */
class PlusFriendsLoader extends BaseFriendsLoader implements ResultCallback<People.LoadPeopleResult> {
    private static String TAG = "PlayGameService_Plus";

    public PlusFriendsLoader(GameHelper helper) {
        super(helper);
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public void onResult(People.LoadPeopleResult loadPeopleResult) {
        String id;
        Log.i(TAG, "friend result...");
        if (loadPeopleResult.getStatus().getStatusCode() == 0) {
            PersonBuffer personBuffer = loadPeopleResult.getPersonBuffer();
            try {
                if (this.friends == null) {
                    this.friends = new ArrayList<>();
                    this.mFriendCounter = 0;
                }
                int count = personBuffer.getCount();
                Log.i(TAG, "person count: " + count);
                for (int i = 0; i < count; i++) {
                    JSONObject o = new JSONObject();
                    Person profile = personBuffer.get(i);
                    try {
                        if (profile.hasId() && (id = profile.getId()) != null) {
                            o.put(ShareConstants.WEB_DIALOG_PARAM_ID, id);
                            if (profile.hasDisplayName()) {
                                o.put("first_name", profile.getDisplayName());
                            }
                            o.put("name", profile.getName());
                            o.put("nickname", profile.getNickname());
                            this.friends.add(o);
                            this.mFriendCounter++;
                            Log.i(TAG, "friend loaded " + id + " : " + profile.getDisplayName());
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                String nextPageToken = loadPeopleResult.getNextPageToken();
                Log.i(TAG, "nextPageToken : " + nextPageToken);
                loadNextPage(nextPageToken);
                personBuffer.release();
                return;
            } catch (Exception ex) {
                Log.e(TAG, "[GooglePlayServices] onPeopleLoaded exception: " + ex.getMessage());
                personBuffer.release();
                loadPeopleError();
                return;
            } finally {
                personBuffer.release();
            }
        }
        loadPeopleError();
        Log.e(TAG, "Error requesting visible circles: " + loadPeopleResult.getStatus());
    }

    @Override // com.socialquantum.googleplay.extention.BaseFriendsLoader
    void createFriendsQuery(String nextPageToken) {
        PendingResult<People.LoadPeopleResult> mPeopleResult = Plus.PeopleApi.loadVisible(this.helper.getApiClient(), 0, nextPageToken);
        mPeopleResult.setResultCallback(this);
    }

    @Override // com.socialquantum.googleplay.extention.BaseFriendsLoader
    void createFriendsQuery() {
        createFriendsQuery(null);
    }

    /* JADX WARN: Code duplicated, block: B:5:0x0008 A[Catch: Exception -> 0x0049, TryCatch #0 {Exception -> 0x0049, blocks: (B:3:0x0002, B:7:0x001a, B:9:0x0020, B:13:0x006a, B:5:0x0008), top: B:16:0x0002 }] */
    private void loadNextPage(String nextPageToken) {
        if (nextPageToken == null) {
            Log.d(TAG, "Precomplete");
            loadPeopleComplete();
            Log.d(TAG, "[GooglePlayServices] friends are loaded");
        } else {
            try {
                if (nextPageToken.length() == 0) {
                    Log.d(TAG, "Precomplete");
                    loadPeopleComplete();
                    Log.d(TAG, "[GooglePlayServices] friends are loaded");
                } else if (isSignedIn()) {
                    PendingResult<People.LoadPeopleResult> mPeopleResult = Plus.PeopleApi.loadVisible(this.helper.getApiClient(), 1, nextPageToken);
                    mPeopleResult.setResultCallback(this);
                    Log.i(TAG, "[GooglePlayServices] continue loading friends from plus client page token: " + nextPageToken);
                } else {
                    Log.e(TAG, "[GooglePlayServices] loading friends from next page error: plus client is null or not connected");
                    loadPeopleError();
                }
            } catch (Exception ex) {
                Log.e(TAG, "[GooglePlayServices] loading friends from next page exception: " + ex.getMessage());
                loadPeopleError();
            }
        }
    }
}
