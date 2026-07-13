package com.socialquantum.googleplay.extention;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.Requests;
import com.prime31.GameHelper;
import com.prime31.PlayGameServicesPlugin;
import com.unity3d.player.UnityPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(14)
public class PlayGameService {
    private static PlayGameService _instance;
    JSONObject friendsJsonObject;
    int mFriendCounter;
    private static String TAG = "PlayGameService";
    private static String objName = "GooglePlusReceiver";
    private static String onFriendsRecieved = "OnFriendsReceived";
    private static String onFriendsRecievedError = "OnFriendsReceivedError";
    private int plusStatus = 0;
    private int playStatus = 0;
    private GameHelper helper = PlayGameServicesPlugin.instance().helper;

    private PlayGameService() {
    }

    public static PlayGameService instance() {
        if (_instance == null) {
            Log.i(TAG, "Create instance");
            _instance = new PlayGameService();
        }
        return _instance;
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    public void OpenSettings() {
        Intent settings = new Intent();
        settings.setPackage("com.google.android.gms");
        settings.addCategory("android.intent.category.LAUNCHER");
        settings.addFlags(67108864);
        UnityPlayer.currentActivity.startActivityForResult(settings, 90005);
    }

    public void OpenGameSettings() {
        Intent settings = new Intent("com.google.android.gms.games.SHOW_SETTINGS");
        settings.putExtra("com.google.android.gms.games.GAME_PACKAGE_NAME", "com.socialquantum2.magiczoo");
        settings.addFlags(67108864);
        UnityPlayer.currentActivity.startActivityForResult(settings, 90004);
    }

    public void forceDisconnect() {
        runSafelyOnUiThread(new Runnable() { // from class: com.socialquantum.googleplay.extention.PlayGameService.1
            @Override // java.lang.Runnable
            public void run() {
                PlayGameService.this.helper.getApiClient().disconnect();
                PlayGameService.this.SendPrime31Message("userSignedOut", "");
            }
        });
    }

    public String getGiftSendersId() {
        ArrayList<GameRequest> rqsts;
        String result = "";
        if (this.helper != null && (rqsts = this.helper.getRequests()) != null) {
            for (GameRequest request : rqsts) {
                String data = new String(request.getData());
                result = result + request.getSender().getPlayerId() + "*" + data + ";";
            }
        }
        Log.e(TAG, "gift result " + result);
        return result;
    }

    public void clearGifts() {
        ArrayList<GameRequest> rqsts;
        if (this.helper != null && (rqsts = this.helper.getRequests()) != null) {
            handleRequests(rqsts);
            this.helper.clearRequests();
        }
    }

    private void handleRequests(ArrayList<GameRequest> requests) {
        if (requests != null) {
            GoogleApiClient client = this.helper.getApiClient();
            ArrayList<String> requestIds = new ArrayList<>();
            final HashMap<String, GameRequest> gameRequestMap = new HashMap<>();
            for (GameRequest request : requests) {
                String requestId = request.getRequestId();
                requestIds.add(requestId);
                gameRequestMap.put(requestId, request);
            }
            Games.Requests.acceptRequests(client, requestIds).setResultCallback(new ResultCallback<Requests.UpdateRequestsResult>() { // from class: com.socialquantum.googleplay.extention.PlayGameService.2
                @Override // com.google.android.gms.common.api.ResultCallback
                public void onResult(Requests.UpdateRequestsResult result) {
                    for (String requestId2 : result.getRequestIds()) {
                        if (gameRequestMap.containsKey(requestId2) && result.getRequestOutcome(requestId2) == 0) {
                            switch (((GameRequest) gameRequestMap.get(requestId2)).getType()) {
                            }
                        }
                    }
                }
            });
        }
    }

    public boolean inviteFriend(String userId, String message) {
        Log.e(TAG, "invite friend " + userId);
        if (userId == null) {
            Log.e(TAG, "User is is null");
            return false;
        }
        if (isSignedIn()) {
            Log.e(TAG, "Inviting friends");
            PackageManager pm = UnityPlayer.currentActivity.getApplicationContext().getPackageManager();
            Drawable icon = pm.getApplicationIcon(UnityPlayer.currentActivity.getApplicationInfo());
            Bitmap img = drawableToBitmap(icon);
            Intent intent = Games.Requests.getSendIntent(this.helper.getApiClient(), 1, userId.getBytes(), 1, img, " ");
            Bundle b = new Bundle();
            b.putString("key", "value");
            UnityPlayer.currentActivity.startActivityForResult(intent, 321654987);
            return true;
        }
        Log.i(TAG, "can't create invite environment");
        return false;
    }

    public boolean queryFriends() {
        clearLoadStatus();
        this.friendsJsonObject = new JSONObject();
        PlusFriendsLoader plusFriends = new PlusFriendsLoader(this.helper);
        plusFriends.addListener(new IFriendsLoaderListener() { // from class: com.socialquantum.googleplay.extention.PlayGameService.3
            @Override // com.socialquantum.googleplay.extention.IFriendsLoaderListener
            public void LoadFriends(int status, ArrayList<JSONObject> result) {
                PlayGameService.this.plusStatus = status;
                if (status == 1) {
                    PlayGameService.this.mergeLoadedFriends(result);
                }
            }
        });
        plusFriends.quertyFriends();
        PlayFriendsLoader playFriends = new PlayFriendsLoader(this.helper);
        playFriends.addListener(new IFriendsLoaderListener() { // from class: com.socialquantum.googleplay.extention.PlayGameService.4
            @Override // com.socialquantum.googleplay.extention.IFriendsLoaderListener
            public void LoadFriends(int status, ArrayList<JSONObject> result) {
                PlayGameService.this.playStatus = status;
                if (status == 1) {
                    PlayGameService.this.mergeLoadedFriends(result);
                }
            }
        });
        return playFriends.quertyFriends();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeLoadedFriends(ArrayList<JSONObject> friendsList) {
        if (friendsList != null) {
            for (JSONObject key : friendsList) {
                try {
                    String id = key.getString(ShareConstants.WEB_DIALOG_PARAM_ID);
                    this.friendsJsonObject.put(id, key);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (this.plusStatus > 0 && this.playStatus > 0) {
                Log.i(TAG, "friendsJsonObject : " + this.friendsJsonObject);
                loadPeopleComplete();
            }
            if (this.plusStatus == 2 && this.playStatus == 2) {
                loadPeopleError();
            }
        }
    }

    private void loadPeopleError() {
        if (this.mFriendCounter > 0) {
            UnityPlayer.UnitySendMessage(objName, onFriendsRecieved, this.friendsJsonObject.toString());
            Log.i(TAG, "[GooglePlayServices] WARNING!!! not load all friends");
        } else {
            UnityPlayer.UnitySendMessage(objName, onFriendsRecievedError, this.friendsJsonObject.toString());
        }
    }

    private void loadPeopleComplete() {
        Log.i(TAG, "loadPeopleComplete: " + this.friendsJsonObject.toString());
        UnityPlayer.UnitySendMessage(objName, onFriendsRecieved, this.friendsJsonObject.toString());
    }

    private void clearLoadStatus() {
        this.plusStatus = 0;
        this.playStatus = 0;
    }

    protected void runSafelyOnUiThread(final Runnable r) {
        UnityPlayer.currentActivity.runOnUiThread(new Runnable() { // from class: com.socialquantum.googleplay.extention.PlayGameService.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    r.run();
                } catch (Exception var2) {
                    Log.e(PlayGameService.TAG, "Exception running command on UI thread: " + var2.getMessage());
                }
            }
        });
    }

    protected void SendPrime31Message(String method, String message) {
        UnityPlayer.UnitySendMessage("GPGManager", method, message);
    }

    private boolean isSignedIn() {
        return this.helper.getApiClient() != null && this.helper.getApiClient().isConnected();
    }
}
