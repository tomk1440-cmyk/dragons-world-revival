package com.prime31;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.achievement.Achievement;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.event.Event;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.PlusShare;
import com.prime31.GPS.utils.Base64;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PlayGameServicesPlugin extends PlayGameServicesPluginBase implements GameHelper.GameHelperListener, QuestUpdateListener {
    private static final int _leaderboardRequestCode = 68787;
    private static final int _questListRequestCode = 22;
    private static final int _savedGamesRequestCode = 33;
    private static final int _shareRequestCode = 34543;
    private boolean _didDisregardFailedAuth;
    private ImageManager _imageManager;
    private long _initTimeInSeconds;
    public GameHelper helper;
    private boolean _enableDebugLog = false;
    private String _achievementMetadataJson = "[]";
    private String _leaderboardMetadataJson = "[]";
    private int MAX_SNAPSHOT_RESOLVE_RETRIES = 3;

    /* JADX INFO: Access modifiers changed from: private */
    public String jsonFromAchievementBuffer(AchievementBuffer buffer) {
        JSONArray jsonArr = new JSONArray();
        try {
            for (Achievement a : buffer) {
                JSONObject json = new JSONObject();
                json.put("achievementId", a.getAchievementId());
                json.put(ServerProtocol.DIALOG_PARAM_STATE, a.getState());
                json.put(ShareConstants.MEDIA_TYPE, a.getType());
                json.put("name", a.getName());
                json.put("achievementDescription", a.getDescription());
                json.put("revealedIconUrl", a.getRevealedImageUri());
                json.put("unlockedIconUrl", a.getUnlockedImageUri());
                json.put("xpValue", a.getXpValue());
                if (a.getType() == 1) {
                    json.put("completedSteps", a.getCurrentSteps());
                    json.put("numberOfSteps", a.getTotalSteps());
                    if (a.getCurrentSteps() == 0) {
                        json.put("progress", 0);
                    } else {
                        json.put("progress", a.getCurrentSteps() / a.getTotalSteps());
                    }
                    json.put("formattedCompletedSteps", a.getFormattedCurrentSteps());
                    json.put("formattedNumberOfSteps", a.getFormattedTotalSteps());
                }
                json.put("lastUpdatedTimestamp", a.getLastUpdatedTimestamp());
                jsonArr.put(json);
            }
        } catch (JSONException e) {
            Log.i("Prime31", "Error creating JSON: " + e);
        } finally {
            buffer.close();
        }
        return jsonArr.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String jsonFromLeaderboardBuffer(LeaderboardBuffer buffer) {
        JSONArray jsonArr = new JSONArray();
        try {
            for (Leaderboard l : buffer) {
                JSONObject json = new JSONObject();
                json.put("iconUrl", l.getIconImageUri());
                json.put("leaderboardId", l.getLeaderboardId());
                json.put("order", l.getScoreOrder());
                json.put("title", l.getDisplayName());
                jsonArr.put(json);
            }
        } catch (JSONException e) {
            Log.i("Prime31", "Error creating JSON" + e);
        } finally {
            buffer.close();
        }
        return jsonArr.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject jsonFromLeaderboardScore(LeaderboardScore s, String leaderboardId) {
        JSONObject json = new JSONObject();
        try {
            json.put("leaderboardId", leaderboardId);
            json.put("value", s.getRawScore());
            json.put("scoreTag", s.getScoreTag());
            json.put("formattedScore", s.getDisplayScore());
            json.put("formattedRank", s.getDisplayRank());
            json.put("rank", s.getRank());
            json.put("playerId", s.getScoreHolder().getPlayerId());
            json.put("displayName", s.getScoreHolder().getDisplayName());
            json.put("avatarUrl", s.getScoreHolder().getIconImageUri());
            json.put("avatarUrlHiRes", s.getScoreHolder().getHiResImageUri());
            json.put("writeTimestamp", s.getTimestampMillis());
        } catch (JSONException e) {
            Log.i("Prime31", "Error creating JSON" + e);
        }
        return json;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String jsonFromLeaderboardScoreBuffer(LeaderboardScoreBuffer buffer, String leaderboardId) {
        JSONArray jsonArr = new JSONArray();
        for (LeaderboardScore s : buffer) {
            jsonArr.put(jsonFromLeaderboardScore(s, leaderboardId));
        }
        return jsonArr.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String jsonFromEventBuffer(EventBuffer buffer) {
        JSONArray jsonArr = new JSONArray();
        try {
            for (Event e : buffer) {
                JSONObject json = new JSONObject();
                json.put("count", e.getValue());
                json.put("eventDescription", e.getDescription());
                json.put("eventId", e.getEventId());
                json.put("imageUrl", e.getIconImageUrl());
                json.put("name", e.getName());
                json.put("visible", e.isVisible());
                jsonArr.put(json);
            }
        } catch (JSONException e2) {
            Log.i("Prime31", "Error creating JSON" + e2);
        } finally {
            buffer.close();
        }
        return jsonArr.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String jsonFromQuestBuffer(QuestBuffer buffer) {
        JSONArray jsonArr = new JSONArray();
        try {
            for (Quest q : buffer) {
                jsonArr.put(jsonObjectFromQuest(q));
            }
            buffer.close();
            return jsonArr.toString();
        } catch (Throwable th) {
            buffer.close();
            throw th;
        }
    }

    private JSONObject jsonObjectFromQuest(Quest quest) {
        JSONObject json = new JSONObject();
        try {
            json.put("questId", quest.getQuestId());
            json.put("name", quest.getName());
            json.put("questDescription", quest.getDescription());
            json.put("iconUrl", quest.getIconImageUrl());
            json.put("bannerUrl", quest.getBannerImageUrl());
            json.put(ServerProtocol.DIALOG_PARAM_STATE, quest.getState() - 1);
            json.put("startTimestamp", quest.getStartTimestamp());
            json.put("expirationTimestamp", quest.getEndTimestamp());
            json.put("acceptedTimestamp", quest.getAcceptedTimestamp());
            json.put("currentMilestone", jsonObjectFromQuestMilestone(quest.getCurrentMilestone()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    private JSONObject jsonObjectFromSnapshotMetadata(SnapshotMetadata metadata) {
        JSONObject json = new JSONObject();
        try {
            json.put("lastModifiedTimestamp", metadata.getLastModifiedTimestamp());
            json.put("description", metadata.getDescription());
            json.put("name", metadata.getUniqueName());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject jsonObjectFromSnapshot(Snapshot snapshot) {
        JSONObject json = new JSONObject();
        try {
            json.put("metadata", jsonObjectFromSnapshotMetadata(snapshot.getMetadata()));
            json.put(ShareConstants.WEB_DIALOG_PARAM_DATA, Base64.encode(snapshot.getSnapshotContents().readFully()));
        } catch (IOException e) {
            Log.e("Prime31", "error reading snapshot data. stack trace to follow");
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return json;
    }

    private JSONObject jsonObjectFromQuestMilestone(Milestone milestone) {
        return jsonObjectFromQuestMilestone(milestone, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject jsonObjectFromQuestMilestone(Milestone milestone, Quest quest) {
        JSONObject json = new JSONObject();
        try {
            json.put("questMilestoneId", milestone.getMilestoneId());
            json.put("eventId", milestone.getEventId());
            if (quest != null) {
                json.put("questId", quest.getQuestId());
            }
            json.put(ServerProtocol.DIALOG_PARAM_STATE, Math.max(0, Math.min(milestone.getState() - 2, 2)));
            json.put("currentCount", milestone.getCurrentProgress());
            json.put("targetCount", milestone.getTargetProgress());
            String reward = new String(milestone.getCompletionRewardData(), "UTF-8");
            json.put("rewardData", reward);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return json;
    }

    public void loadBasicModelData() {
        Games.Achievements.load(this.helper.getApiClient(), true).setResultCallback(new ResultCallback<Achievements.LoadAchievementsResult>() { // from class: com.prime31.PlayGameServicesPlugin.1
            @Override // com.google.android.gms.common.api.ResultCallback
            public void onResult(Achievements.LoadAchievementsResult res) {
                if (res.getStatus().isSuccess()) {
                    PlayGameServicesPlugin.this._achievementMetadataJson = PlayGameServicesPlugin.this.jsonFromAchievementBuffer(res.getAchievements());
                    PlayGameServicesPlugin.this.UnitySendMessage("reloadDataForKeySucceeded", "GPGModelAllAchievementMetadataKey");
                    return;
                }
                PlayGameServicesPlugin.this.UnitySendMessage("reloadDataForKeyFailed", "Unknown error: " + res.getStatus().toString());
            }
        });
        Games.Leaderboards.loadLeaderboardMetadata(this.helper.getApiClient(), true).setResultCallback(new ResultCallback<Leaderboards.LeaderboardMetadataResult>() { // from class: com.prime31.PlayGameServicesPlugin.2
            @Override // com.google.android.gms.common.api.ResultCallback
            public void onResult(Leaderboards.LeaderboardMetadataResult res) {
                if (res.getStatus().isSuccess()) {
                    PlayGameServicesPlugin.this._leaderboardMetadataJson = PlayGameServicesPlugin.this.jsonFromLeaderboardBuffer(res.getLeaderboards());
                    PlayGameServicesPlugin.this.UnitySendMessage("reloadDataForKeySucceeded", "GPGModelAllLeaderboardMetadataKey");
                    return;
                }
                PlayGameServicesPlugin.this.UnitySendMessage("reloadDataForKeyFailed", "Unknown error: " + res.getStatus().toString());
            }
        });
    }

    public static String gamesStatusErrorCodeToString(int code) {
        switch (code) {
            case 0:
                return "STATUS_OK";
            case 1:
                return "STATUS_INTERNAL_ERROR";
            case 2:
                return "STATUS_CLIENT_RECONNECT_REQUIRED";
            case 3:
                return "STATUS_NETWORK_ERROR_STALE_DATA";
            case 4:
                return "STATUS_NETWORK_ERROR_NO_DATA";
            case 5:
                return "STATUS_NETWORK_ERROR_OPERATION_DEFERRED";
            case 7:
                return "STATUS_LICENSE_CHECK_FAILED";
            case 4000:
                return "STATUS_SNAPSHOT_NOT_FOUND";
            case 4001:
                return "STATUS_SNAPSHOT_CONTENTS_UNAVAILABLE";
            case 4002:
                return "STATUS_SNAPSHOT_CONTENTS_UNAVAILABLE";
            case 4003:
                return "STATUS_SNAPSHOT_COMMIT_FAILED";
            case 4004:
                return "STATUS_SNAPSHOT_CONFLICT";
            case 4005:
                return "STATUS_SNAPSHOT_FOLDER_UNAVAILABLE";
            case 4006:
                return "STATUS_SNAPSHOT_CONFLICT_MISSING";
            case GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER /* 6001 */:
                return "STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER";
            case GamesStatusCodes.STATUS_MULTIPLAYER_DISABLED /* 6003 */:
                return "STATUS_MULTIPLAYER_DISABLED";
            case GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_OPERATION /* 6004 */:
                return "STATUS_MULTIPLAYER_ERROR_INVALID_OPERATION";
            case GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_PARTICIPANT_STATE /* 6500 */:
                return "STATUS_MATCH_ERROR_INVALID_PARTICIPANT_STATE";
            case GamesStatusCodes.STATUS_MATCH_ERROR_INACTIVE_MATCH /* 6501 */:
                return "STATUS_MATCH_ERROR_INACTIVE_MATCH";
            case GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_MATCH_STATE /* 6502 */:
                return "STATUS_MATCH_ERROR_INVALID_MATCH_STATE";
            case GamesStatusCodes.STATUS_MATCH_ERROR_OUT_OF_DATE_VERSION /* 6503 */:
                return "STATUS_MATCH_ERROR_OUT_OF_DATE_VERSION";
            case GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_MATCH_RESULTS /* 6504 */:
                return "STATUS_MATCH_ERROR_INVALID_MATCH_RESULTS";
            case GamesStatusCodes.STATUS_MATCH_ERROR_ALREADY_REMATCHED /* 6505 */:
                return "STATUS_MATCH_ERROR_ALREADY_REMATCHED";
            case GamesStatusCodes.STATUS_MATCH_ERROR_LOCALLY_MODIFIED /* 6507 */:
                return "STATUS_MATCH_ERROR_LOCALLY_MODIFIED";
            default:
                Log.e("Prime31", "received an error code we did not recognize: " + code);
                return "UKNOWN_ERROR";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, Object> playerToMap(Player player) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("avatarUri", player.getIconImageUri());
        map.put("avatarUrl", player.getIconImageUrl());
        map.put("avatarUriHiRes", player.getHiResImageUri());
        map.put("avatarUrlHiRes", player.getHiResImageUrl());
        map.put("name", player.getDisplayName());
        map.put("playerId", player.getPlayerId());
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldDisableDrive() {
        try {
            ApplicationInfo ai = getActivity().getPackageManager().getApplicationInfo(getActivity().getPackageName(), 128);
            Bundle bundle = ai.metaData;
            if (bundle.containsKey("com.prime31.PlayGameServicesPlugin.DisableDrive")) {
                Log.i("Prime31", "found meta-data tag to disable Drive API scope");
                return true;
            }
        } catch (Exception e) {
            Log.i("Prime31", "Failed to load meta-data, NameNotFound: " + e.getMessage());
        }
        return false;
    }

    public static void onCreate(Bundle savedInstanceState) {
        try {
            Class.forName("android.os.AsyncTask");
        } catch (Throwable th) {
        }
        Log.i("Prime31", "onCreate. calling through to init");
        instance().init();
    }

    public static void onStart() {
        Log.i("Prime31", "onStart. calling through to onStart");
        instance().helper.onStart(instance().getActivity());
    }

    public static void onResume() {
        turnBasedMultiplayerInstance().onResume();
    }

    public static void onStop() {
        instance().helper.onStop();
        realtimeMultiplayerInstance().leaveRoom(true);
    }

    public static void onActivityResult(int requestCode, int responseCode, Intent intent) {
        instance().helper.onActivityResult(requestCode, responseCode, intent);
        if (responseCode == 10004) {
            Log.i("Prime31", "This log is here to tell you Google has returned the following error: RESULT_APP_MISCONFIGURED");
        }
        if (requestCode == _leaderboardRequestCode && responseCode == 10001) {
            Log.i("Prime31", "Activity done. User potentially signed out");
            if (!instance().helper.getApiClient().isConnected()) {
                Log.i("Prime31", "detected a disconnected Google API client. checking actual property. isSignedIn: " + instance().isSignedIn());
            } else {
                Log.i("Prime31", "detected a connected Google API client. disconnecting it now");
                instance().helper.disconnect();
            }
            instance().UnitySendMessage("userSignedOut", "");
            return;
        }
        if (requestCode == _shareRequestCode) {
            if (responseCode == -1) {
                Log.i("Prime31", "share RESULT OK");
                instance().UnitySendMessage("finishedSharing", "");
                return;
            } else {
                Log.i("Prime31", "share RESULT NOT OK");
                instance().UnitySendMessage("finishedSharing", "User canceled");
                return;
            }
        }
        if (requestCode == 22) {
            Log.i("Prime31", "quest list complete");
            if (responseCode == -1) {
                Log.i("Prime31", "quest list OK response. searching for selected quest...");
                Quest quest = (Quest) intent.getParcelableExtra(Quests.EXTRA_QUEST);
                if (quest.getState() == 4) {
                    Log.i("Prime31", "user chose quest in completed state. claiming now...");
                    instance().claimQuest(quest.getQuestId(), quest.getCurrentMilestone().getMilestoneId());
                    instance().onQuestCompleted(quest);
                }
                instance().UnitySendMessage("questListLauncherAcceptedQuest", instance().jsonObjectFromQuest(quest).toString());
                return;
            }
            return;
        }
        if (requestCode == 33) {
            if (intent != null && responseCode == -1) {
                if (intent.hasExtra(Snapshots.EXTRA_SNAPSHOT_METADATA)) {
                    SnapshotMetadata snapshotMetadata = Games.Snapshots.getSnapshotFromBundle(intent.getExtras());
                    instance().UnitySendMessage("snapshotListUserSelectedSnapshot", instance().jsonObjectFromSnapshotMetadata(snapshotMetadata).toString());
                    return;
                } else {
                    if (intent.hasExtra(Snapshots.EXTRA_SNAPSHOT_NEW)) {
                        instance().UnitySendMessage("snapshotListUserRequestedNewSnapshot", "");
                        return;
                    }
                    return;
                }
            }
            instance().UnitySendMessage("snapshotListCanceled", "");
            return;
        }
        turnBasedMultiplayerInstance().onActivityResult(requestCode, responseCode, intent);
        realtimeMultiplayerInstance().onActivityResult(requestCode, responseCode, intent);
    }

    public String getAuthToken(String scope) {
        if (scope == null || scope == "") {
            scope = "oauth2:https://www.googleapis.com/auth/plus.login";
        }
        try {
            String accountName = Plus.AccountApi.getAccountName(this.helper.getApiClient());
            Log.i("Prime31", "using scope: " + scope + ", account: " + accountName);
            return GoogleAuthUtil.getToken(getActivity(), accountName, scope);
        } catch (Exception e) {
            Log.i("Prime31", "Exception getting auth token: " + e);
            return null;
        }
    }

    public String getToken(String projectId, String scope) {
        return null;
    }

    public String getLaunchInvitation() {
        if (this.helper == null || !this.helper.hasInvitation()) {
            return null;
        }
        String inviteId = this.helper.getInvitationId();
        this.helper.clearInvitation();
        return inviteId;
    }

    public void attemptSilentAuthentication() {
        runSafelyOnUiThread(new Runnable() { // from class: com.prime31.PlayGameServicesPlugin.3
            @Override // java.lang.Runnable
            public void run() {
                PlayGameServicesPlugin.this.helper.setConnectOnStart(true);
                Log.i("Prime31", "setting connectOnStart back to true. We toggled it to false at launch to avoid showing any UI.");
                PlayGameServicesPlugin.this.helper.onStart(PlayGameServicesPlugin.instance().getActivity());
            }
        });
    }

    public void init() {
        runSafelyOnUiThread(new Runnable() { // from class: com.prime31.PlayGameServicesPlugin.4
            @Override // java.lang.Runnable
            public void run() {
                PlayGameServicesPlugin.this._initTimeInSeconds = System.currentTimeMillis() / 1000;
                int clients = 11;
                if (PlayGameServicesPlugin.this.shouldDisableDrive()) {
                    clients = 3;
                }
                PlayGameServicesPlugin.this.helper = new GameHelper(PlayGameServicesPlugin.this.getActivity(), clients);
                PlayGameServicesPlugin.this.helper.setConnectOnStart(false);
                Log.i("Prime31", "setting connectOnStart to false due to Play SDK bug where silent authentication is not always silent and displays some UI.");
                PlayGameServicesPlugin.this.helper.enableDebugLog(PlayGameServicesPlugin.this._enableDebugLog);
                PlayGameServicesPlugin.this.helper.setShowErrorDialogs(false);
                PlayGameServicesPlugin.this.helper.setMaxAutoSignInAttempts(3);
                PlayGameServicesPlugin.this.helper.setup(PlayGameServicesPlugin.this);
            }
        });
    }

    public void authenticate() {
        if (this.helper != null && this.helper.mActivity == null) {
            this.helper.mActivity = getActivity();
        }
        runSafelyOnUiThread(new Runnable() { // from class: com.prime31.PlayGameServicesPlugin.5
            @Override // java.lang.Runnable
            public void run() {
                if (PlayGameServicesPlugin.this.helper.getApiClient().isConnected()) {
                    Log.i("Prime31", "Google API Client is connected. Force disconnecting it now before attempting authentication");
                    PlayGameServicesPlugin.this.helper.getApiClient().disconnect();
                }
                PlayGameServicesPlugin.this.helper.beginUserInitiatedSignIn();
            }
        });
    }

    public void signOut() {
        runSafelyOnUiThread(new Runnable() { // from class: com.prime31.PlayGameServicesPlugin.6
            @Override // java.lang.Runnable
            public void run() {
                PlayGameServicesPlugin.this.helper.signOut();
            }
        });
    }

    public boolean isSignedIn() {
        if (this.helper == null || !this.helper.isSignedIn()) {
            return false;
        }
        try {
            Games.Players.getCurrentPlayerId(this.helper.getApiClient());
            Games.Players.getCurrentPlayer(this.helper.getApiClient());
            return true;
        } catch (SecurityException e) {
            Log.i("Prime31", "SecurityException thrown which indicates we actually arent signed in. performing signOut now to reset all flags");
            runSafelyOnUiThread(new Runnable() { // from class: com.prime31.PlayGameServicesPlugin.7
                @Override // java.lang.Runnable
                public void run() {
                    PlayGameServicesPlugin.this.helper.signOut();
                }
            });
            return false;
        }
    }

    public String getLocalPlayerInfo() {
        try {
            Player player = Games.Players.getCurrentPlayer(this.helper.getApiClient());
            return jsonize(playerToMap(player));
        } catch (Exception e) {
            Log.i("Prime31", "Exception getting local player info: " + e);
            return "{}";
        }
    }

    public void loadPlayer(String playerId) {
        Games.Players.loadPlayer(this.helper.getApiClient(), playerId).setResultCallback(new ResultCallback<Players.LoadPlayersResult>() { // from class: com.prime31.PlayGameServicesPlugin.8
            @Override // com.google.android.gms.common.api.ResultCallback
            public void onResult(Players.LoadPlayersResult res) {
                int statusCode = res.getStatus().getStatusCode();
                if (statusCode == 0 && res.getPlayers().getCount() > 0) {
                    Player player = res.getPlayers().get(0);
                    PlayGameServicesPlugin.this.UnitySendMessage("loadPlayerCompleted", PlayGameServicesPlugin.this.jsonize(PlayGameServicesPlugin.this.playerToMap(player)));
                } else {
                    PlayGameServicesPlugin.this.UnitySendMessage("loadPlayerCompleted", PlayGameServicesPlugin.gamesStatusErrorCodeToString(statusCode));
                }
            }
        });
    }

    public void setToastSettings(final int placement) {
        Log.i("Prime31", "revision 17+ of the Play Game Services library does not currently support changing the toast placement");
        runSafelyOnUiThread(new Runnable() { // from class: com.prime31.PlayGameServicesPlugin.9
            /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0002. Please report as an issue. */
            @Override // java.lang.Runnable
            public void run() {
                switch (placement) {
                }
            }
        });
    }

    public void enableDebugLog(boolean shouldEnable) {
        if (this.helper != null) {
            this.helper.enableDebugLog(shouldEnable);
        } else {
            this._enableDebugLog = shouldEnable;
        }
    }

    public void loadProfileImageForUri(String uriString) {
        if (uriString == null || uriString.length() == 0) {
            Log.i("Prime31", "invalid or null profile image uri. aborting load.");
            return;
        }
        final Uri uri = Uri.parse(uriString);
        if (this._imageManager == null) {
            this._imageManager = ImageManager.create(getActivity());
        }
        Log.i("Prime31", "converted to uri and starting load: " + uri);
        runSafelyOnUiThread(new Runnable() { // from class: com.prime31.PlayGameServicesPlugin.10
            @Override // java.lang.Runnable
            public void run() {
                ImageManager imageManager = PlayGameServicesPlugin.this._imageManager;
                final Uri uri2 = uri;
                imageManager.loadImage(new ImageManager.OnImageLoadedListener() { // from class: com.prime31.PlayGameServicesPlugin.10.1
                    public void onImageLoaded(Uri uriArg, Drawable drawable) {
                        Log.i("Prime31", "onImageLoaded with uri: " + uriArg);
                        try {
                            Bitmap bitmap = PlayGameServicesPlugin.drawableToBitmap(drawable);
                            List<String> segments = uri2.getPathSegments();
                            String filename = String.valueOf(Environment.getExternalStorageDirectory().toString()) + "/" + segments.get(segments.size() - 2) + "-" + segments.get(segments.size() - 1) + ".png";
                            Log.i("Prime31", "save profile image to location: " + filename);
                            FileOutputStream out = new FileOutputStream(filename);
                            bitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
                            PlayGameServicesPlugin.this.UnitySendMessage("profileImageLoadedAtPath", filename);
                        } catch (Exception e) {
                            Log.i("Prime31", "Error fetching profile image" + e);
                        }
                    }

                    @Override // com.google.android.gms.common.images.ImageManager.OnImageLoadedListener
                    public void onImageLoaded(Uri uriArg, Drawable drawable, boolean arg2) {
                        Log.i("Prime31", "onImageLoaded with uri: " + uriArg);
                        try {
                            Bitmap bitmap = PlayGameServicesPlugin.drawableToBitmap(drawable);
                            List<String> segments = uri2.getPathSegments();
                            String filename = String.valueOf(Environment.getExternalStorageDirectory().toString()) + "/" + segments.get(segments.size() - 2) + "-" + segments.get(segments.size() - 1) + ".png";
                            Log.i("Prime31", "save profile image to location: " + filename);
                            FileOutputStream out = new FileOutputStream(filename);
                            bitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
                            PlayGameServicesPlugin.this.UnitySendMessage("profileImageLoadedAtPath", filename);
                        } catch (Exception e) {
                            Log.i("Prime31", "Error fetching profile image" + e);
                        }
                    }
                }, uri);
            }
        });
    }

    public void showShareDialog(final String prefillText, final String urlToShare) {
        runSafelyOnUiThread(new Runnable() { // from class: com.prime31.PlayGameServicesPlugin.11
            @Override // java.lang.Runnable
            public void run() {
                Log.i("Prime31", "preparing share dialog with text: " + prefillText + " and url: " + urlToShare);
                PlusShare.Builder builder = new PlusShare.Builder(PlayGameServicesPlugin.this.getActivity()).setType("text/plain");
                if (prefillText != null) {
                    builder.setText(prefillText);
                }
                if (urlToShare != null) {
                    builder.setContentUrl(Uri.parse(urlToShare));
                }
                PlayGameServicesPlugin.this.getActivity().startActivityForResult(builder.getIntent(), PlayGameServicesPlugin._shareRequestCode);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap drawableToBitmap(Drawable drawable) {
        int width = drawable.getIntrinsicWidth();
        if (width <= 0) {
            width = 1;
        }
        int height = drawable.getIntrinsicHeight();
        if (height <= 0) {
            height = 1;
        }
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    public void showAchievements() {
        runSafelyOnUiThread(new Runnable() { // from class: com.prime31.PlayGameServicesPlugin.12
            @Override // java.lang.Runnable
            public void run() {
                PlayGameServicesPlugin.this.getActivity().startActivityForResult(Games.Achievements.getAchievementsIntent(PlayGameServicesPlugin.this.helper.getApiClient()), PlayGameServicesPlugin._leaderboardRequestCode);
            }
        });
    }

    public void revealAchievement(final String achievementId) {
        runSafelyOnUiThread(new Runnable() { // from class: com.prime31.PlayGameServicesPlugin.13
            @Override // java.lang.Runnable
            public void run() {
                Games.Achievements.revealImmediate(PlayGameServicesPlugin.this.helper.getApiClient(), achievementId).setResultCallback(new AchievementListener(PlayGameServicesPlugin.this, "revealAchievementSucceeded", "revealAchievementFailed", achievementId));
            }
        });
    }

    public void unlockAchievement(final String achievementId, boolean showsCompletionNotification) {
        runSafelyOnUiThread(new Runnable() { // from class: com.prime31.PlayGameServicesPlugin.14
            @Override // java.lang.Runnable
            public void run() {
                Games.Achievements.unlockImmediate(PlayGameServicesPlugin.this.helper.getApiClient(), achievementId).setResultCallback(new AchievementListener(PlayGameServicesPlugin.this, "unlockAchievementSucceeded", "unlockAchievementFailed", achievementId));
            }
        });
    }

    public void incrementAchievement(final String achievementId, final int numSteps) {
        runSafelyOnUiThread(new Runnable() { // from class: com.prime31.PlayGameServicesPlugin.15
            @Override // java.lang.Runnable
            public void run() {
                Games.Achievements.incrementImmediate(PlayGameServicesPlugin.this.helper.getApiClient(), achievementId, numSteps).setResultCallback(new AchievementListener(PlayGameServicesPlugin.this, "incrementAchievementSucceeded", "incrementAchievementFailed", achievementId));
            }
        });
    }

    public String getAllAchievementMetadata() {
        return this._achievementMetadataJson;
    }

    public void showLeaderboard(final String leaderboardId) {
        runSafelyOnUiThread(new Runnable() { // from class: com.prime31.PlayGameServicesPlugin.16
            @Override // java.lang.Runnable
            public void run() {
                PlayGameServicesPlugin.this.getActivity().startActivityForResult(Games.Leaderboards.getLeaderboardIntent(PlayGameServicesPlugin.this.helper.getApiClient(), leaderboardId), PlayGameServicesPlugin._leaderboardRequestCode);
            }
        });
    }

    public void showLeaderboards() {
        runSafelyOnUiThread(new Runnable() { // from class: com.prime31.PlayGameServicesPlugin.17
            @Override // java.lang.Runnable
            public void run() {
                PlayGameServicesPlugin.this.getActivity().startActivityForResult(Games.Leaderboards.getAllLeaderboardsIntent(PlayGameServicesPlugin.this.helper.getApiClient()), PlayGameServicesPlugin._leaderboardRequestCode);
            }
        });
    }

    public void submitScore(final String leaderboardId, final long score, final String scoreTag) {
        runSafelyOnUiThread(new Runnable() { // from class: com.prime31.PlayGameServicesPlugin.18
            @Override // java.lang.Runnable
            public void run() {
                Games.Leaderboards.submitScoreImmediate(PlayGameServicesPlugin.this.helper.getApiClient(), leaderboardId, score, scoreTag != null ? scoreTag : "").setResultCallback(new ScoreSubmitListener(PlayGameServicesPlugin.this, "submitScoreSucceeded", "submitScoreFailed", leaderboardId));
            }
        });
    }

    public void loadScoresForLeaderboard(final String leaderboardId, final int timeScope, final boolean isSocial, final boolean personalWindow) {
        runSafelyOnUiThread(new Runnable() { // from class: com.prime31.PlayGameServicesPlugin.19
            @Override // java.lang.Runnable
            public void run() {
                int collection = isSocial ? 1 : 0;
                ScoreLoadListener listener = new ScoreLoadListener(PlayGameServicesPlugin.this, "loadScoresSucceeded", "loadScoresFailed", leaderboardId);
                if (personalWindow) {
                    Games.Leaderboards.loadPlayerCenteredScores(PlayGameServicesPlugin.this.helper.getApiClient(), leaderboardId, timeScope - 1, collection, 25).setResultCallback(listener);
                } else {
                    Games.Leaderboards.loadTopScores(PlayGameServicesPlugin.this.helper.getApiClient(), leaderboardId, timeScope - 1, collection, 25).setResultCallback(listener);
                }
            }
        });
    }

    public void loadCurrentPlayerLeaderboardScore(final String leaderboardId, int timeScope, boolean isSocial) {
        int collection = isSocial ? 1 : 0;
        Games.Leaderboards.loadCurrentPlayerLeaderboardScore(this.helper.getApiClient(), leaderboardId, timeScope - 1, collection).setResultCallback(new ResultCallback<Leaderboards.LoadPlayerScoreResult>() { // from class: com.prime31.PlayGameServicesPlugin.20
            @Override // com.google.android.gms.common.api.ResultCallback
            public void onResult(Leaderboards.LoadPlayerScoreResult loadPlayerScoreResult) {
                if (loadPlayerScoreResult != null && loadPlayerScoreResult.getStatus().getStatusCode() == 0 && loadPlayerScoreResult.getScore() != null) {
                    JSONObject json = PlayGameServicesPlugin.this.jsonFromLeaderboardScore(loadPlayerScoreResult.getScore(), leaderboardId);
                    PlayGameServicesPlugin.this.UnitySendMessage("loadCurrentPlayerLeaderboardScoreSucceeded", json.toString());
                } else {
                    String errorString = PlayGameServicesPlugin.gamesStatusErrorCodeToString(loadPlayerScoreResult.getStatus().getStatusCode());
                    String errorJson = PlayGameServicesPlugin.this.jsonizeIdentiferAndError(leaderboardId, errorString);
                    PlayGameServicesPlugin.this.UnitySendMessage("loadCurrentPlayerLeaderboardScoreFailed", errorJson);
                }
            }
        });
    }

    public String getAllLeaderboardMetadata() {
        return this._leaderboardMetadataJson;
    }

    public void incrementEvent(String eventId, int steps) {
        Games.Events.increment(this.helper.getApiClient(), eventId, steps);
    }

    public void loadAllEvents() {
        Games.Events.load(this.helper.getApiClient(), true).setResultCallback(new ResultCallback<Events.LoadEventsResult>() { // from class: com.prime31.PlayGameServicesPlugin.21
            @Override // com.google.android.gms.common.api.ResultCallback
            public void onResult(Events.LoadEventsResult res) {
                if (res.getStatus().isSuccess()) {
                    PlayGameServicesPlugin.this.UnitySendMessage("allEventsLoaded", PlayGameServicesPlugin.this.jsonFromEventBuffer(res.getEvents()));
                } else {
                    Log.i("Prime31", "Games.Events.load failed with error: " + PlayGameServicesPlugin.gamesStatusErrorCodeToString(res.getStatus().getStatusCode()));
                }
            }
        });
    }

    public void loadAllQuests() {
        Games.Quests.load(this.helper.getApiClient(), Quests.SELECT_ALL_QUESTS, 0, true).setResultCallback(new ResultCallback<Quests.LoadQuestsResult>() { // from class: com.prime31.PlayGameServicesPlugin.22
            @Override // com.google.android.gms.common.api.ResultCallback
            public void onResult(Quests.LoadQuestsResult res) {
                if (res.getStatus().isSuccess()) {
                    PlayGameServicesPlugin.this.UnitySendMessage("allQuestsLoaded", PlayGameServicesPlugin.this.jsonFromQuestBuffer(res.getQuests()));
                } else {
                    Log.i("Prime31", "Games.Quests.load failed with error: " + PlayGameServicesPlugin.gamesStatusErrorCodeToString(res.getStatus().getStatusCode()));
                }
            }
        });
    }

    public void showStateChangedPopup(final String questId) {
        runSafelyOnUiThread(new Runnable() { // from class: com.prime31.PlayGameServicesPlugin.23
            @Override // java.lang.Runnable
            public void run() {
                Games.Quests.showStateChangedPopup(PlayGameServicesPlugin.this.helper.getApiClient(), questId);
            }
        });
    }

    public void showQuestList() {
        runSafelyOnUiThread(new Runnable() { // from class: com.prime31.PlayGameServicesPlugin.24
            @Override // java.lang.Runnable
            public void run() {
                Intent questsIntent = Games.Quests.getQuestsIntent(PlayGameServicesPlugin.this.helper.getApiClient(), Quests.SELECT_ALL_QUESTS);
                PlayGameServicesPlugin.this.getActivity().startActivityForResult(questsIntent, 22);
            }
        });
    }

    public void claimQuest(final String questId, final String questMilestoneId) {
        runSafelyOnUiThread(new Runnable() { // from class: com.prime31.PlayGameServicesPlugin.25
            @Override // java.lang.Runnable
            public void run() {
                Games.Quests.claim(PlayGameServicesPlugin.this.helper.getApiClient(), questId, questMilestoneId).setResultCallback(new ResultCallback<Quests.ClaimMilestoneResult>() { // from class: com.prime31.PlayGameServicesPlugin.25.1
                    @Override // com.google.android.gms.common.api.ResultCallback
                    public void onResult(Quests.ClaimMilestoneResult res) {
                        if (res.getStatus().isSuccess()) {
                            PlayGameServicesPlugin.this.UnitySendMessage("questListLauncherClaimedRewardsForQuestMilestone", PlayGameServicesPlugin.this.jsonObjectFromQuestMilestone(res.getQuest().getCurrentMilestone(), res.getQuest()).toString());
                        } else {
                            Log.i("Prime31", "Games.Quests.claim failed with error: " + PlayGameServicesPlugin.gamesStatusErrorCodeToString(res.getStatus().getStatusCode()));
                        }
                    }
                });
            }
        });
    }

    public void showSnapshotList(final int maxSavedGamesToShow, final String title, final boolean allowAddButton, final boolean allowDelete) {
        runSafelyOnUiThread(new Runnable() { // from class: com.prime31.PlayGameServicesPlugin.26
            @Override // java.lang.Runnable
            public void run() {
                Intent savedGamesIntent = Games.Snapshots.getSelectSnapshotIntent(PlayGameServicesPlugin.this.helper.getApiClient(), title, allowAddButton, allowDelete, maxSavedGamesToShow);
                PlayGameServicesPlugin.this.getActivity().startActivityForResult(savedGamesIntent, 33);
            }
        });
    }

    public void loadSnapshot(final String snapshotName) {
        runSafelyOnUiThread(new Runnable() { // from class: com.prime31.PlayGameServicesPlugin.27
            @Override // java.lang.Runnable
            public void run() {
                final String str = snapshotName;
                AsyncTask<Void, Void, Integer> task = new AsyncTask<Void, Void, Integer>() { // from class: com.prime31.PlayGameServicesPlugin.27.1
                    Snapshot snapshot = null;

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    public Integer doInBackground(Void... params) {
                        try {
                            Snapshots.OpenSnapshotResult result = (Snapshots.OpenSnapshotResult) Games.Snapshots.open(PlayGameServicesPlugin.this.helper.getApiClient(), str, true).await();
                            int status = result.getStatus().getStatusCode();
                            if (status == 0) {
                                this.snapshot = result.getSnapshot();
                            } else if (status == 4004) {
                                Log.i("Prime31", "STATUS_SNAPSHOT_CONFLICT. processing open result now...");
                                this.snapshot = PlayGameServicesPlugin.this.processSnapshotOpenResult(result, 0, 2);
                                if (this.snapshot != null) {
                                    status = 0;
                                }
                            } else {
                                Log.e("Prime31", "Error while loading: " + status);
                            }
                            return Integer.valueOf(status);
                        } catch (Exception e) {
                            Log.e("Prime31", "loadSnapshot failed catastrophically: " + e);
                            return 4001;
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    public void onPostExecute(Integer status) {
                        if (status.intValue() == 0) {
                            Log.i("Prime31", "STATUS_OK. proceeding to send the snapshot back to Unity");
                            PlayGameServicesPlugin.this.UnitySendMessage("loadSnapshotSucceeded", PlayGameServicesPlugin.this.jsonObjectFromSnapshot(this.snapshot).toString());
                        } else {
                            String statusString = PlayGameServicesPlugin.gamesStatusErrorCodeToString(status.intValue());
                            PlayGameServicesPlugin.this.UnitySendMessage("loadSnapshotFailed", statusString);
                        }
                    }
                };
                task.execute(new Void[0]);
            }
        });
    }

    public void saveSnapshot(final String snapshotName, final boolean createIfMissing, final byte[] data, final String description, final int conflictPolicy) {
        if (this.helper.getApiClient() == null) {
            Log.i("Prime31", "Aborting operation due to a null API client. This usually occurs when your game is backgrounded while attempting to access any Play SDK features.");
        } else {
            runSafelyOnUiThread(new Runnable() { // from class: com.prime31.PlayGameServicesPlugin.28
                @Override // java.lang.Runnable
                public void run() {
                    final String str = snapshotName;
                    final boolean z = createIfMissing;
                    final int i = conflictPolicy;
                    final String str2 = description;
                    final byte[] bArr = data;
                    AsyncTask<Void, Void, Integer> updateTask = new AsyncTask<Void, Void, Integer>() { // from class: com.prime31.PlayGameServicesPlugin.28.1
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // android.os.AsyncTask
                        public Integer doInBackground(Void... params) {
                            Snapshot snapshot;
                            if (PlayGameServicesPlugin.this.helper.getApiClient() != null) {
                                try {
                                    Snapshots.OpenSnapshotResult openResult = (Snapshots.OpenSnapshotResult) Games.Snapshots.open(PlayGameServicesPlugin.this.helper.getApiClient(), str, z).await();
                                    int status = openResult.getStatus().getStatusCode();
                                    Log.i("Prime31", "snapshots.open result: " + status);
                                    if (status == 4004) {
                                        Log.i("Prime31", "conflict found. handling now");
                                        snapshot = PlayGameServicesPlugin.this.processSnapshotOpenResult(openResult, 0, i);
                                        if (snapshot != null) {
                                            status = 0;
                                        }
                                    } else {
                                        if (!openResult.getStatus().isSuccess()) {
                                            Log.w("Prime31", "Could not open Snapshot for update.");
                                            return Integer.valueOf(status);
                                        }
                                        Log.i("Prime31", "should be all good opening snapshot. fetching from result now");
                                        snapshot = openResult.getSnapshot();
                                    }
                                    if (snapshot == null) {
                                        Log.i("Prime31", "snapshot is null so we cant write the data to it. bailing out.");
                                        return 4001;
                                    }
                                    SnapshotMetadataChange metadataChange = new SnapshotMetadataChange.Builder().setDescription(str2).build();
                                    Log.i("Prime31", "writing " + String.valueOf(bArr.length) + " bytes into snapshot contents");
                                    snapshot.getSnapshotContents().writeBytes(bArr);
                                    Snapshots.CommitSnapshotResult commit = (Snapshots.CommitSnapshotResult) Games.Snapshots.commitAndClose(PlayGameServicesPlugin.this.helper.getApiClient(), snapshot, metadataChange).await();
                                    if (!commit.getStatus().isSuccess()) {
                                        Log.w("Prime31", "Failed to commit Snapshot.");
                                        return Integer.valueOf(commit.getStatus().getStatusCode());
                                    }
                                    return Integer.valueOf(status);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    return 1;
                                }
                            }
                            Log.i("Prime31", "Aborting operation due to a null API client. This usually occurs when your game is backgrounded while attempting to access any Play SDK features.");
                            return 14;
                        }

                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // android.os.AsyncTask
                        public void onPostExecute(Integer status) {
                            if (status.intValue() == 0) {
                                PlayGameServicesPlugin.this.UnitySendMessage("saveSnapshotSucceeded", "");
                            } else {
                                String statusString = PlayGameServicesPlugin.gamesStatusErrorCodeToString(status.intValue());
                                PlayGameServicesPlugin.this.UnitySendMessage("saveSnapshotFailed", statusString);
                            }
                        }
                    };
                    updateTask.execute(new Void[0]);
                }
            });
        }
    }

    public void deleteSnapshot(final String snapshotName) {
        runSafelyOnUiThread(new Runnable() { // from class: com.prime31.PlayGameServicesPlugin.29
            @Override // java.lang.Runnable
            public void run() {
                final String str = snapshotName;
                AsyncTask<Void, Void, Integer> task = new AsyncTask<Void, Void, Integer>() { // from class: com.prime31.PlayGameServicesPlugin.29.1
                    Snapshot snapshot = null;

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    public Integer doInBackground(Void... params) {
                        if (PlayGameServicesPlugin.this.helper.getApiClient() != null) {
                            Snapshots.OpenSnapshotResult result = (Snapshots.OpenSnapshotResult) Games.Snapshots.open(PlayGameServicesPlugin.this.helper.getApiClient(), str, true).await();
                            int status = result.getStatus().getStatusCode();
                            if (status == 0) {
                                this.snapshot = result.getSnapshot();
                            } else if (status != 4004) {
                                Log.e("Prime31", "Error while deleting snapshot: " + status);
                            } else {
                                this.snapshot = PlayGameServicesPlugin.this.processSnapshotOpenResult(result, 0, 2);
                                if (this.snapshot != null) {
                                    status = 0;
                                }
                            }
                            if (status == 0) {
                                Snapshots.DeleteSnapshotResult res = (Snapshots.DeleteSnapshotResult) Games.Snapshots.delete(PlayGameServicesPlugin.this.helper.getApiClient(), this.snapshot.getMetadata()).await();
                                String statusString = PlayGameServicesPlugin.gamesStatusErrorCodeToString(res.getStatus().getStatusCode());
                                Log.i("Prime31", "deleteSnapshot result: " + statusString);
                            } else {
                                String statusString2 = PlayGameServicesPlugin.gamesStatusErrorCodeToString(status);
                                Log.e("Prime31", "deletSnapshotFailed: " + statusString2);
                            }
                            return Integer.valueOf(status);
                        }
                        Log.i("Prime31", "Aborting operation due to a null API client. This usually occurs when your game is backgrounded while attempting to access any Play SDK features.");
                        return 14;
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    public void onPostExecute(Integer status) {
                    }
                };
                task.execute(new Void[0]);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Snapshot processSnapshotOpenResult(Snapshots.OpenSnapshotResult result, int retryCount, int conflictPolicy) {
        int retryCount2 = retryCount + 1;
        int status = result.getStatus().getStatusCode();
        Log.i("Prime31", "save Result status: " + status);
        if (status == 0) {
            return result.getSnapshot();
        }
        if (status == 4002) {
            if (result.getSnapshot() != null) {
                return result.getSnapshot();
            }
            return result.getConflictingSnapshot();
        }
        if (status == 4004) {
            Snapshot snapshot = result.getSnapshot();
            Snapshot conflictSnapshot = result.getConflictingSnapshot();
            Snapshot mResolvedSnapshot = snapshot;
            if (snapshot.getMetadata().getLastModifiedTimestamp() < conflictSnapshot.getMetadata().getLastModifiedTimestamp()) {
                mResolvedSnapshot = conflictSnapshot;
            }
            Snapshots.OpenSnapshotResult resolveResult = (Snapshots.OpenSnapshotResult) Games.Snapshots.resolveConflict(this.helper.getApiClient(), result.getConflictId(), mResolvedSnapshot).await();
            if (retryCount2 < this.MAX_SNAPSHOT_RESOLVE_RETRIES) {
                return processSnapshotOpenResult(resolveResult, retryCount2, conflictPolicy);
            }
            Log.e("Prime31", "Could not resolve snapshot conflicts");
        }
        return null;
    }

    class ListenerBase {
        protected String _failedMethod;
        protected String _id;
        protected String _reportedScoreString;
        protected String _successMethod;

        ListenerBase() {
        }
    }

    class AchievementListener extends ListenerBase implements ResultCallback<Achievements.UpdateAchievementResult> {
        public AchievementListener(String successMethod, String failedMethod) {
            super();
            this._failedMethod = failedMethod;
            this._successMethod = successMethod;
        }

        public AchievementListener(PlayGameServicesPlugin playGameServicesPlugin, String successMethod, String failedMethod, String id) {
            this(successMethod, failedMethod);
            this._id = id;
        }

        public AchievementListener(PlayGameServicesPlugin playGameServicesPlugin, String successMethod, String failedMethod, long reportedScore) {
            this(successMethod, failedMethod);
            this._reportedScoreString = String.valueOf(reportedScore);
        }

        @Override // com.google.android.gms.common.api.ResultCallback
        public void onResult(Achievements.UpdateAchievementResult res) {
            int statusCode = res.getStatus().getStatusCode();
            String error = null;
            switch (statusCode) {
                case 0:
                case 3003:
                    String resString = String.valueOf(res.getAchievementId()) + "," + (statusCode == 3003 ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    PlayGameServicesPlugin.this.UnitySendMessage(this._successMethod, resString);
                    break;
                case 1:
                case 3:
                case 4:
                case 5:
                case 3000:
                case 3001:
                case 3002:
                    error = "Network or unknown error: " + String.valueOf(statusCode);
                    break;
                case 2:
                    error = "Reconnect required: " + String.valueOf(statusCode);
                    PlayGameServicesPlugin.this.helper.reconnectClient();
                    break;
                case 7:
                    error = "License check failed: " + String.valueOf(statusCode);
                    break;
                default:
                    error = "Unknown error: " + String.valueOf(statusCode);
                    break;
            }
            if (error != null) {
                PlayGameServicesPlugin.this.UnitySendMessage(this._failedMethod, PlayGameServicesPlugin.this.jsonizeIdentiferAndError(this._id, error));
            }
        }
    }

    class ScoreSubmitListener extends ListenerBase implements ResultCallback<Leaderboards.SubmitScoreResult> {
        public ScoreSubmitListener(String successMethod, String failedMethod) {
            super();
            this._failedMethod = failedMethod;
            this._successMethod = successMethod;
        }

        public ScoreSubmitListener(PlayGameServicesPlugin playGameServicesPlugin, String successMethod, String failedMethod, String id) {
            this(successMethod, failedMethod);
            this._id = id;
        }

        public ScoreSubmitListener(PlayGameServicesPlugin playGameServicesPlugin, String successMethod, String failedMethod, long reportedScore) {
            this(successMethod, failedMethod);
            this._reportedScoreString = String.valueOf(reportedScore);
        }

        @Override // com.google.android.gms.common.api.ResultCallback
        public void onResult(Leaderboards.SubmitScoreResult res) {
            int statusCode = res.getStatus().getStatusCode();
            String error = null;
            switch (statusCode) {
                case 0:
                    ScoreSubmissionData scoreResult = res.getScoreData();
                    ScoreSubmissionData.Result dailyResult = scoreResult.getScoreResult(0);
                    ScoreSubmissionData.Result allTimeResult = scoreResult.getScoreResult(2);
                    ScoreSubmissionData.Result weeklyResult = scoreResult.getScoreResult(1);
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("leaderboardId", scoreResult.getLeaderboardId());
                    map.put("isHighScoreForLocalPlayerToday", Boolean.valueOf(dailyResult != null && dailyResult.newBest));
                    map.put("isHighScoreForLocalPlayerThisWeek", Boolean.valueOf(weeklyResult != null && weeklyResult.newBest));
                    map.put("isHighScoreForLocalPlayerAllTime", Boolean.valueOf(allTimeResult != null && allTimeResult.newBest));
                    map.put("reportedScoreValue", this._reportedScoreString);
                    if (dailyResult != null) {
                        map.put("highScoreForLocalPlayerToday", jsonObjectFromResult(dailyResult, scoreResult.getLeaderboardId()));
                    }
                    if (weeklyResult != null) {
                        map.put("highScoreForLocalPlayerThisWeek", jsonObjectFromResult(weeklyResult, scoreResult.getLeaderboardId()));
                    }
                    if (allTimeResult != null) {
                        map.put("highScoreForLocalPlayerAllTime", jsonObjectFromResult(allTimeResult, scoreResult.getLeaderboardId()));
                    }
                    PlayGameServicesPlugin.this.UnitySendMessage(this._successMethod, PlayGameServicesPlugin.this.jsonize(map));
                    break;
                case 1:
                case 5:
                    error = "Network or unknown error: " + String.valueOf(statusCode);
                    break;
                case 2:
                    error = "Reconnect required: " + String.valueOf(statusCode);
                    PlayGameServicesPlugin.this.helper.reconnectClient();
                    break;
                case 3:
                case 4:
                case 6:
                default:
                    error = "Unknown error: " + String.valueOf(statusCode);
                    break;
                case 7:
                    error = "License check failed: " + String.valueOf(statusCode);
                    break;
            }
            if (error != null) {
                PlayGameServicesPlugin.this.UnitySendMessage(this._failedMethod, PlayGameServicesPlugin.this.jsonizeIdentiferAndError(this._id, error));
            }
        }

        private JSONObject jsonObjectFromResult(ScoreSubmissionData.Result result, String leaderboardId) {
            JSONObject json = new JSONObject();
            try {
                json.put("formattedScore", result.formattedScore);
                json.put("value", result.rawScore);
                json.put("leaderboardId", leaderboardId);
            } catch (JSONException e) {
                Log.i("Prime31", "Error creating JSON" + e);
            }
            return json;
        }
    }

    class ScoreLoadListener extends ListenerBase implements ResultCallback<Leaderboards.LoadScoresResult> {
        public ScoreLoadListener(String successMethod, String failedMethod) {
            super();
            this._failedMethod = failedMethod;
            this._successMethod = successMethod;
        }

        public ScoreLoadListener(PlayGameServicesPlugin playGameServicesPlugin, String successMethod, String failedMethod, String id) {
            this(successMethod, failedMethod);
            this._id = id;
        }

        public ScoreLoadListener(PlayGameServicesPlugin playGameServicesPlugin, String successMethod, String failedMethod, long reportedScore) {
            this(successMethod, failedMethod);
            this._reportedScoreString = String.valueOf(reportedScore);
        }

        @Override // com.google.android.gms.common.api.ResultCallback
        public void onResult(Leaderboards.LoadScoresResult res) {
            int statusCode = res.getStatus().getStatusCode();
            String error = null;
            switch (statusCode) {
                case 0:
                    Log.i("Prime31", "total scores loaded: " + res.getScores().getCount());
                    String json = PlayGameServicesPlugin.this.jsonFromLeaderboardScoreBuffer(res.getScores(), this._id);
                    PlayGameServicesPlugin.this.UnitySendMessage(this._successMethod, json);
                    break;
                case 1:
                case 3:
                case 4:
                    error = "Network or unknown error: " + String.valueOf(statusCode);
                    break;
                case 2:
                    error = "Reconnect required: " + String.valueOf(statusCode);
                    PlayGameServicesPlugin.this.helper.reconnectClient();
                    break;
                case 5:
                case 6:
                default:
                    error = "Unknown error: " + String.valueOf(statusCode);
                    break;
                case 7:
                    error = "License check failed: " + String.valueOf(statusCode);
                    break;
            }
            if (error != null) {
                PlayGameServicesPlugin.this.UnitySendMessage(this._failedMethod, PlayGameServicesPlugin.this.jsonizeIdentiferAndError(this._id, error));
            }
        }
    }

    @Override // com.prime31.GameHelper.GameHelperListener
    public void onSignInSucceeded() {
        loadBasicModelData();
        UnitySendMessage("authenticationSucceeded", Games.Players.getCurrentPlayerId(this.helper.getApiClient()));
        Games.Invitations.registerInvitationListener(this.helper.getApiClient(), realtimeMultiplayerInstance());
        Games.Quests.registerQuestUpdateListener(this.helper.getApiClient(), this);
        PlayGameServicesPluginBase.turnBasedMultiplayerInstance().onResume();
    }

    @Override // com.prime31.GameHelper.GameHelperListener
    public void onSignInFailed() {
        if (!this._didDisregardFailedAuth) {
            long secondsSinceInit = (System.currentTimeMillis() / 1000) - this._initTimeInSeconds;
            if (secondsSinceInit < 5) {
                Log.i("Prime31", "we only launched " + secondsSinceInit + " seconds ago so this is the Google 'failed auth bug'. Disregarding only this failure and moving on.");
                this._didDisregardFailedAuth = true;
                return;
            }
        }
        String error = "Unknown error";
        if (this.helper.hasSignInError()) {
            error = this.helper.getSignInError().toString();
        } else if (this.helper.mSignInCancelled) {
            error = "Canceled";
        }
        Log.i("Prime31", "onSignInFailed: " + error);
        UnitySendMessage("authenticationFailed", error);
    }

    @Override // com.google.android.gms.games.quest.QuestUpdateListener
    public void onQuestCompleted(Quest quest) {
        UnitySendMessage("questCompleted", jsonObjectFromQuest(quest).toString());
    }
}
