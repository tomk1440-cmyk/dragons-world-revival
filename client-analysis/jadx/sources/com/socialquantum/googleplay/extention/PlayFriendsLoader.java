package com.socialquantum.googleplay.extention;

import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.Players;
import com.prime31.GameHelper;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PlayGameService.java */
/* JADX INFO: loaded from: classes.dex */
class PlayFriendsLoader extends BaseFriendsLoader implements ResultCallback<Players.LoadPlayersResult> {
    private static String TAG = "PlayGameService_Play";

    public PlayFriendsLoader(GameHelper helper) {
        super(helper);
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public void onResult(Players.LoadPlayersResult loadPeopleResult) {
        Log.i(TAG, "friend result...");
        if (loadPeopleResult.getStatus().getStatusCode() == 0) {
            Log.i(TAG, "StatusCodes.SUCCESS");
            PlayerBuffer personBuffer = loadPeopleResult.getPlayers();
            try {
                if (this.friends == null) {
                    this.friends = new ArrayList<>();
                    this.mFriendCounter = 0;
                }
                int count = personBuffer.getCount();
                Log.i(TAG, "person count: " + count);
                for (int i = 0; i < count; i++) {
                    JSONObject o = new JSONObject();
                    Player profile = personBuffer.get(i);
                    try {
                        String id = profile.getPlayerId();
                        if (id != null) {
                            o.put(ShareConstants.WEB_DIALOG_PARAM_ID, id);
                            o.put("first_name", profile.getDisplayName());
                            o.put("last_play_time", profile.getLastPlayedWithTimestamp());
                            o.put("level", profile.getLevelInfo());
                            o.put("name", profile.getName());
                            o.put("ret_time", profile.getRetrievedTimestamp());
                            o.put("title", profile.getTitle());
                            o.put("has_icon", profile.hasIconImage());
                            this.friends.add(o);
                            this.mFriendCounter++;
                            Log.i(TAG, "friend loaded " + id + " : " + profile.getDisplayName());
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                Log.e(TAG, "PreEx");
                personBuffer.release();
                Log.e(TAG, "AfterRelease");
                loadPeopleComplete();
                Log.e(TAG, "AfterRelease2");
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
        PendingResult<Players.LoadPlayersResult> res = Games.Players.loadConnectedPlayers(this.helper.getApiClient(), false);
        res.setResultCallback(this);
    }

    @Override // com.socialquantum.googleplay.extention.BaseFriendsLoader
    void createFriendsQuery() {
        PendingResult<Players.LoadPlayersResult> res = Games.Players.loadConnectedPlayers(this.helper.getApiClient(), false);
        res.setResultCallback(this);
    }
}
