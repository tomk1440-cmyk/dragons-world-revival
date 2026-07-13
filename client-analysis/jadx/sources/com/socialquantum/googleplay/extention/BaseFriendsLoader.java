package com.socialquantum.googleplay.extention;

import android.util.Log;
import com.prime31.GameHelper;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: PlayGameService.java */
/* JADX INFO: loaded from: classes.dex */
abstract class BaseFriendsLoader {
    public static final int ERROR = 2;
    public static final int OK = 1;
    private static String TAG = "PlayGameService_Base";
    protected ArrayList<JSONObject> friends;
    protected GameHelper helper;
    private List<IFriendsLoaderListener> listeners = new ArrayList();
    protected int mFriendCounter;

    abstract void createFriendsQuery();

    abstract void createFriendsQuery(String str);

    public BaseFriendsLoader(GameHelper helper) {
        this.helper = helper;
    }

    protected boolean isSignedIn() {
        return this.helper.getApiClient() != null && this.helper.getApiClient().isConnected();
    }

    public void addListener(IFriendsLoaderListener toAdd) {
        this.listeners.add(toAdd);
    }

    protected void loadPeopleError() {
        for (IFriendsLoaderListener listener : this.listeners) {
            listener.LoadFriends(2, null);
        }
    }

    protected void loadPeopleComplete() {
        for (IFriendsLoaderListener listener : this.listeners) {
            listener.LoadFriends(1, this.friends);
        }
    }

    public boolean quertyFriends() {
        Log.i(TAG, "start friend request");
        if (isSignedIn()) {
            Log.i(TAG, "is signed in");
            this.friends = new ArrayList<>();
            this.mFriendCounter = 0;
            createFriendsQuery();
            Log.i(TAG, "can't query friends. No connected clients");
            return false;
        }
        Log.i(TAG, "querying friends from plus client");
        return true;
    }
}
