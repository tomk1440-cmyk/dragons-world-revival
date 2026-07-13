package com.prime31;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.plus.Plus;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class GameHelper implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    public static final int CLIENT_ALL = 11;
    public static final int CLIENT_GAMES = 1;
    public static final int CLIENT_NONE = 0;
    public static final int CLIENT_PLUS = 2;
    public static final int CLIENT_SNAPSHOT = 8;
    static final int DEFAULT_MAX_SIGN_IN_ATTEMPTS = 3;
    static final int RC_RESOLVE = 9001;
    static final int RC_UNUSED = 9002;
    static final String TAG = "Prime31-GH";
    Activity mActivity;
    Context mAppContext;
    Invitation mInvitation;
    int mRequestedClients;
    ArrayList<GameRequest> mRequests;
    TurnBasedMatch mTurnBasedMatch;
    private boolean mSetupDone = false;
    private boolean mConnecting = false;
    boolean mExpectingResolution = false;
    public boolean mSignInCancelled = false;
    GoogleApiClient.Builder mGoogleApiClientBuilder = null;
    Games.GamesOptions mGamesApiOptions = Games.GamesOptions.builder().build();
    Plus.PlusOptions mPlusApiOptions = Plus.PlusOptions.builder().build();
    GoogleApiClient mGoogleApiClient = null;
    boolean mConnectOnStart = true;
    boolean mUserInitiatedSignIn = false;
    ConnectionResult mConnectionResult = null;
    SignInFailureReason mSignInFailureReason = null;
    boolean mShowErrorDialogs = true;
    boolean mDebugLog = false;
    GameHelperListener mListener = null;
    int mMaxAutoSignInAttempts = 3;
    private final String GAMEHELPER_SHARED_PREFS = "GAMEHELPER_SHARED_PREFS";
    private final String KEY_SIGN_IN_CANCELLATIONS = "KEY_SIGN_IN_CANCELLATIONS";
    Handler mHandler = new Handler();

    public interface GameHelperListener {
        void onSignInFailed();

        void onSignInSucceeded();
    }

    public GameHelper(Activity activity, int clientsToUse) {
        this.mActivity = null;
        this.mAppContext = null;
        this.mRequestedClients = 0;
        this.mActivity = activity;
        this.mAppContext = activity.getApplicationContext();
        this.mRequestedClients = clientsToUse;
    }

    public void setMaxAutoSignInAttempts(int max) {
        this.mMaxAutoSignInAttempts = max;
    }

    void assertConfigured(String operation) {
        if (!this.mSetupDone) {
            String error = "GameHelper error: Operation attempted without setup: " + operation + ". The setup() method must be called before attempting any other operation.";
            logError(error);
            throw new IllegalStateException(error);
        }
    }

    private void doApiOptionsPreCheck() {
        if (this.mGoogleApiClientBuilder != null) {
            logError("GameHelper: you cannot call set*ApiOptions after the client builder has been created. Call it before calling createApiClientBuilder() or setup().");
            throw new IllegalStateException("GameHelper: you cannot call set*ApiOptions after the client builder has been created. Call it before calling createApiClientBuilder() or setup().");
        }
    }

    public void setGamesApiOptions(Games.GamesOptions options) {
        doApiOptionsPreCheck();
        this.mGamesApiOptions = options;
    }

    public void setPlusApiOptions(Plus.PlusOptions options) {
        doApiOptionsPreCheck();
        this.mPlusApiOptions = options;
    }

    public GoogleApiClient.Builder createApiClientBuilder() {
        if (this.mSetupDone) {
            logError("GameHelper: you called GameHelper.createApiClientBuilder() after calling setup. You can only get a client builder BEFORE performing setup.");
            throw new IllegalStateException("GameHelper: you called GameHelper.createApiClientBuilder() after calling setup. You can only get a client builder BEFORE performing setup.");
        }
        GoogleApiClient.Builder builder = new GoogleApiClient.Builder(this.mActivity, this, this);
        if ((this.mRequestedClients & 1) != 0) {
            builder.addApi(Games.API, this.mGamesApiOptions);
            builder.addScope(Games.SCOPE_GAMES);
        }
        if ((this.mRequestedClients & 2) != 0) {
            builder.addApi(Plus.API);
            builder.addScope(Plus.SCOPE_PLUS_LOGIN);
        }
        if ((this.mRequestedClients & 8) != 0) {
            builder.addScope(Drive.SCOPE_APPFOLDER);
            builder.addApi(Drive.API);
        }
        this.mGoogleApiClientBuilder = builder;
        return builder;
    }

    public void setup(GameHelperListener listener) {
        if (this.mSetupDone) {
            logError("GameHelper: you cannot call GameHelper.setup() more than once!");
            throw new IllegalStateException("GameHelper: you cannot call GameHelper.setup() more than once!");
        }
        this.mListener = listener;
        debugLog("Setup: requested clients: " + this.mRequestedClients);
        if (this.mGoogleApiClientBuilder == null) {
            createApiClientBuilder();
        }
        this.mGoogleApiClient = this.mGoogleApiClientBuilder.build();
        this.mGoogleApiClientBuilder = null;
        this.mSetupDone = true;
    }

    public GoogleApiClient getApiClient() {
        if (this.mGoogleApiClient == null) {
            throw new IllegalStateException("No GoogleApiClient. Did you call setup()?");
        }
        return this.mGoogleApiClient;
    }

    public boolean isSignedIn() {
        return this.mGoogleApiClient != null && this.mGoogleApiClient.isConnected();
    }

    public boolean isConnecting() {
        return this.mConnecting;
    }

    public boolean hasSignInError() {
        return this.mSignInFailureReason != null;
    }

    public SignInFailureReason getSignInError() {
        return this.mSignInFailureReason;
    }

    public void setShowErrorDialogs(boolean show) {
        this.mShowErrorDialogs = show;
    }

    public void onStart(Activity act) {
        this.mActivity = act;
        this.mAppContext = act.getApplicationContext();
        debugLog("onStart");
        assertConfigured("onStart");
        if (this.mConnectOnStart) {
            if (this.mGoogleApiClient.isConnected()) {
                Log.w(TAG, "GameHelper: client was already connected on onStart()");
                return;
            }
            debugLog("Connecting client.");
            this.mConnecting = true;
            this.mGoogleApiClient.connect();
            return;
        }
        debugLog("Not attempting to connect becase mConnectOnStart=false");
        debugLog("Instead, reporting a sign-in failure.");
        this.mHandler.postDelayed(new Runnable() { // from class: com.prime31.GameHelper.1
            @Override // java.lang.Runnable
            public void run() {
                GameHelper.this.notifyListener(false);
            }
        }, 1000L);
    }

    public void onStop() {
        debugLog("onStop");
        assertConfigured("onStop");
        if (this.mGoogleApiClient.isConnected()) {
            debugLog("Disconnecting client due to onStop");
            this.mGoogleApiClient.disconnect();
        } else {
            debugLog("Client already disconnected when we got onStop.");
        }
        this.mConnecting = false;
        this.mExpectingResolution = false;
        this.mActivity = null;
    }

    public String getInvitationId() {
        if (!this.mGoogleApiClient.isConnected()) {
            Log.w(TAG, "Warning: getInvitationId() should only be called when signed in, that is, after getting onSignInSuceeded()");
        }
        if (this.mInvitation == null) {
            return null;
        }
        return this.mInvitation.getInvitationId();
    }

    public Invitation getInvitation() {
        if (!this.mGoogleApiClient.isConnected()) {
            Log.w(TAG, "Warning: getInvitation() should only be called when signed in, that is, after getting onSignInSuceeded()");
        }
        return this.mInvitation;
    }

    public boolean hasInvitation() {
        return this.mInvitation != null;
    }

    public boolean hasTurnBasedMatch() {
        return this.mTurnBasedMatch != null;
    }

    public boolean hasRequests() {
        return this.mRequests != null;
    }

    public void clearInvitation() {
        this.mInvitation = null;
    }

    public void clearTurnBasedMatch() {
        this.mTurnBasedMatch = null;
    }

    public void clearRequests() {
        this.mRequests = null;
    }

    public TurnBasedMatch getTurnBasedMatch() {
        if (!this.mGoogleApiClient.isConnected()) {
            Log.w(TAG, "Warning: getTurnBasedMatch() should only be called when signed in, that is, after getting onSignInSuceeded()");
        }
        return this.mTurnBasedMatch;
    }

    public ArrayList<GameRequest> getRequests() {
        if (!this.mGoogleApiClient.isConnected()) {
            Log.w(TAG, "Warning: getRequests() should only be called when signed in, that is, after getting onSignInSuceeded()");
        }
        return this.mRequests;
    }

    public void enableDebugLog(boolean enabled) {
        this.mDebugLog = enabled;
        if (enabled) {
            debugLog("Debug log enabled.");
        }
    }

    @Deprecated
    public void enableDebugLog(boolean enabled, String tag) {
        Log.w(TAG, "GameHelper.enableDebugLog(boolean,String) is deprecated. Use GameHelper.enableDebugLog(boolean)");
        enableDebugLog(enabled);
    }

    public void signOut() {
        if (!this.mGoogleApiClient.isConnected()) {
            debugLog("signOut: was already disconnected, ignoring.");
            return;
        }
        if ((this.mRequestedClients & 2) != 0) {
            debugLog("Clearing default account on PlusClient.");
            Plus.AccountApi.clearDefaultAccount(this.mGoogleApiClient);
        }
        if ((this.mRequestedClients & 1) != 0) {
            debugLog("Signing out from the Google API Client.");
            Games.signOut(this.mGoogleApiClient);
        }
        debugLog("Disconnecting client.");
        this.mConnectOnStart = false;
        this.mConnecting = false;
        this.mGoogleApiClient.disconnect();
    }

    public void onActivityResult(int requestCode, int responseCode, Intent intent) {
        debugLog("onActivityResult: req=" + (requestCode == 9001 ? "RC_RESOLVE" : String.valueOf(requestCode)) + ", resp=" + GameHelperUtils.activityResponseCodeToString(responseCode));
        if (requestCode != 9001) {
            debugLog("onActivityResult: request code not meant for us. Ignoring.");
            return;
        }
        this.mExpectingResolution = false;
        if (!this.mConnecting) {
            debugLog("onActivityResult: ignoring because we are not connecting.");
            return;
        }
        if (responseCode == -1) {
            debugLog("onAR: Resolution was RESULT_OK, so connecting current client again.");
            connect();
            return;
        }
        if (responseCode == 10001) {
            debugLog("onAR: Resolution was RECONNECT_REQUIRED, so reconnecting.");
            connect();
            return;
        }
        if (responseCode == 0) {
            debugLog("onAR: Got a cancellation result, so disconnecting.");
            this.mSignInCancelled = true;
            this.mConnectOnStart = false;
            this.mUserInitiatedSignIn = false;
            this.mSignInFailureReason = null;
            this.mConnecting = false;
            this.mGoogleApiClient.disconnect();
            int prevCancellations = getSignInCancellations();
            int newCancellations = incrementSignInCancellations();
            debugLog("onAR: # of cancellations " + prevCancellations + " --> " + newCancellations + ", max " + this.mMaxAutoSignInAttempts);
            notifyListener(false);
            return;
        }
        debugLog("onAR: responseCode=" + GameHelperUtils.activityResponseCodeToString(responseCode) + ", so giving up.");
        giveUp(new SignInFailureReason(this.mConnectionResult.getErrorCode(), responseCode));
    }

    void notifyListener(boolean success) {
        String str;
        StringBuilder sb = new StringBuilder("Notifying LISTENER of sign-in ");
        if (success) {
            str = "SUCCESS";
        } else {
            str = this.mSignInFailureReason != null ? "FAILURE (error)" : "FAILURE (no error)";
        }
        debugLog(sb.append(str).toString());
        if (this.mListener != null) {
            if (success) {
                this.mListener.onSignInSucceeded();
            } else {
                this.mListener.onSignInFailed();
            }
        }
    }

    public void beginUserInitiatedSignIn() {
        debugLog("beginUserInitiatedSignIn: resetting attempt count.");
        resetSignInCancellations();
        this.mSignInCancelled = false;
        this.mConnectOnStart = true;
        if (this.mGoogleApiClient.isConnected()) {
            logWarn("beginUserInitiatedSignIn() called when already connected. Calling listener directly to notify of success.");
            notifyListener(true);
            return;
        }
        if (this.mConnecting) {
            logWarn("beginUserInitiatedSignIn() called when already connecting. Be patient! You can only call this method after you get an onSignInSucceeded() or onSignInFailed() callback. Suggestion: disable the sign-in button on startup and also when it's clicked, and re-enable when you get the callback.");
            return;
        }
        debugLog("Starting USER-INITIATED sign-in flow.");
        this.mUserInitiatedSignIn = true;
        if (this.mConnectionResult != null) {
            debugLog("beginUserInitiatedSignIn: continuing pending sign-in flow.");
            this.mConnecting = true;
            resolveConnectionResult();
        } else {
            debugLog("beginUserInitiatedSignIn: starting new sign-in flow.");
            this.mConnecting = true;
            connect();
        }
    }

    void connect() {
        if (this.mGoogleApiClient.isConnected()) {
            debugLog("Already connected.");
            return;
        }
        debugLog("Starting connection.");
        this.mConnecting = true;
        this.mInvitation = null;
        this.mTurnBasedMatch = null;
        this.mGoogleApiClient.connect();
    }

    public void reconnectClient() {
        if (!this.mGoogleApiClient.isConnected()) {
            Log.w(TAG, "reconnectClient() called when client is not connected.");
            connect();
        } else {
            debugLog("Reconnecting client.");
            this.mGoogleApiClient.reconnect();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnected(Bundle connectionHint) {
        debugLog("onConnected: connected!");
        if (connectionHint != null) {
            debugLog("onConnected: connection hint provided. Checking for invite.");
            Invitation inv = (Invitation) connectionHint.getParcelable(Multiplayer.EXTRA_INVITATION);
            if (inv != null && inv.getInvitationId() != null) {
                debugLog("onConnected: connection hint has a room invite!");
                this.mInvitation = inv;
                debugLog("Invitation ID: " + this.mInvitation.getInvitationId());
            }
            this.mRequests = Games.Requests.getGameRequestsFromBundle(connectionHint);
            if (!this.mRequests.isEmpty()) {
                debugLog("onConnected: connection hint has " + this.mRequests.size() + " request(s)");
            }
            debugLog("onConnected: connection hint provided. Checking for TBMP game.");
            this.mTurnBasedMatch = (TurnBasedMatch) connectionHint.getParcelable(Multiplayer.EXTRA_TURN_BASED_MATCH);
        }
        succeedSignIn();
    }

    void succeedSignIn() {
        debugLog("succeedSignIn");
        this.mSignInFailureReason = null;
        this.mConnectOnStart = true;
        this.mUserInitiatedSignIn = false;
        this.mConnecting = false;
        notifyListener(true);
    }

    int getSignInCancellations() {
        SharedPreferences sp = this.mAppContext.getSharedPreferences("GAMEHELPER_SHARED_PREFS", 0);
        return sp.getInt("KEY_SIGN_IN_CANCELLATIONS", 0);
    }

    int incrementSignInCancellations() {
        int cancellations = getSignInCancellations();
        SharedPreferences.Editor editor = this.mAppContext.getSharedPreferences("GAMEHELPER_SHARED_PREFS", 0).edit();
        editor.putInt("KEY_SIGN_IN_CANCELLATIONS", cancellations + 1);
        editor.commit();
        return cancellations + 1;
    }

    void resetSignInCancellations() {
        SharedPreferences.Editor editor = this.mAppContext.getSharedPreferences("GAMEHELPER_SHARED_PREFS", 0).edit();
        editor.putInt("KEY_SIGN_IN_CANCELLATIONS", 0);
        editor.commit();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public void onConnectionFailed(ConnectionResult result) {
        boolean shouldResolve;
        debugLog("onConnectionFailed");
        this.mConnectionResult = result;
        debugLog("Connection failure:");
        debugLog("   - code: " + GameHelperUtils.errorCodeToString(this.mConnectionResult.getErrorCode()));
        debugLog("   - resolvable: " + this.mConnectionResult.hasResolution());
        debugLog("   - details: " + this.mConnectionResult.toString());
        int cancellations = getSignInCancellations();
        if (this.mUserInitiatedSignIn) {
            debugLog("onConnectionFailed: WILL resolve because user initiated sign-in.");
            shouldResolve = true;
        } else if (this.mSignInCancelled) {
            debugLog("onConnectionFailed WILL NOT resolve (user already cancelled once).");
            shouldResolve = false;
        } else if (cancellations < this.mMaxAutoSignInAttempts) {
            debugLog("onConnectionFailed: WILL resolve because we have below the max# of attempts, " + cancellations + " < " + this.mMaxAutoSignInAttempts);
            shouldResolve = true;
        } else {
            shouldResolve = false;
            debugLog("onConnectionFailed: Will NOT resolve; not user-initiated and max attempts reached: " + cancellations + " >= " + this.mMaxAutoSignInAttempts);
        }
        if (!shouldResolve) {
            debugLog("onConnectionFailed: since we won't resolve, failing now.");
            this.mConnectionResult = result;
            this.mConnecting = false;
            notifyListener(false);
            return;
        }
        debugLog("onConnectionFailed: resolving problem...");
        resolveConnectionResult();
    }

    void resolveConnectionResult() {
        if (this.mExpectingResolution) {
            debugLog("We're already expecting the result of a previous resolution.");
            return;
        }
        if (this.mActivity == null) {
            Log.e(TAG, "Ignoring attempt to resolve connection result without an active Activity.");
            return;
        }
        debugLog("resolveConnectionResult: trying to resolve result: " + this.mConnectionResult);
        if (this.mConnectionResult.hasResolution()) {
            debugLog("Result has resolution. Starting it.");
            try {
                this.mExpectingResolution = true;
                this.mConnectionResult.startResolutionForResult(this.mActivity, 9001);
                return;
            } catch (IntentSender.SendIntentException e) {
                debugLog("SendIntentException, so connecting again.");
                connect();
                return;
            }
        }
        debugLog("resolveConnectionResult: result has no resolution. Giving up.");
        giveUp(new SignInFailureReason(this.mConnectionResult.getErrorCode()));
    }

    public void disconnect() {
        if (this.mGoogleApiClient.isConnected()) {
            debugLog("Disconnecting client.");
            this.mGoogleApiClient.disconnect();
        } else {
            Log.w(TAG, "disconnect() called when client was already disconnected.");
        }
    }

    void giveUp(SignInFailureReason reason) {
        this.mConnectOnStart = false;
        disconnect();
        this.mSignInFailureReason = reason;
        if (reason.mActivityResultCode == 10004) {
            GameHelperUtils.printMisconfiguredDebugInfo(this.mAppContext);
        }
        showFailureDialog();
        this.mConnecting = false;
        notifyListener(false);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnectionSuspended(int cause) {
        debugLog("onConnectionSuspended, cause=" + cause);
        disconnect();
        this.mSignInFailureReason = null;
        debugLog("Making extraordinary call to onSignInFailed callback");
        this.mConnecting = false;
        notifyListener(false);
    }

    public void showFailureDialog() {
        if (this.mSignInFailureReason != null) {
            int errorCode = this.mSignInFailureReason.getServiceErrorCode();
            int actResp = this.mSignInFailureReason.getActivityResultCode();
            if (this.mShowErrorDialogs) {
                showFailureDialog(this.mActivity, actResp, errorCode);
            } else {
                debugLog("Not showing error dialog because mShowErrorDialogs==false. Error was: " + this.mSignInFailureReason);
            }
        }
    }

    public static void showFailureDialog(Activity activity, int actResp, int errorCode) {
        Dialog errorDialog;
        if (activity == null) {
            Log.e("GameHelper", "*** No Activity. Can't show failure dialog!");
            return;
        }
        switch (actResp) {
            case GamesActivityResultCodes.RESULT_SIGN_IN_FAILED /* 10002 */:
                errorDialog = makeSimpleDialog(activity, GameHelperUtils.getString(activity, 1));
                break;
            case GamesActivityResultCodes.RESULT_LICENSE_FAILED /* 10003 */:
                errorDialog = makeSimpleDialog(activity, GameHelperUtils.getString(activity, 3));
                break;
            case GamesActivityResultCodes.RESULT_APP_MISCONFIGURED /* 10004 */:
                errorDialog = makeSimpleDialog(activity, GameHelperUtils.getString(activity, 2));
                break;
            default:
                errorDialog = GooglePlayServicesUtil.getErrorDialog(errorCode, activity, 9002, null);
                if (errorDialog == null) {
                    Log.e("GameHelper", "No standard error dialog available. Making fallback dialog.");
                    errorDialog = makeSimpleDialog(activity, String.valueOf(GameHelperUtils.getString(activity, 0)) + " " + GameHelperUtils.errorCodeToString(errorCode));
                }
                break;
        }
        errorDialog.show();
    }

    static Dialog makeSimpleDialog(Activity activity, String text) {
        return new AlertDialog.Builder(activity).setMessage(text).setNeutralButton(R.string.ok, (DialogInterface.OnClickListener) null).create();
    }

    static Dialog makeSimpleDialog(Activity activity, String title, String text) {
        return new AlertDialog.Builder(activity).setMessage(text).setTitle(title).setNeutralButton(R.string.ok, (DialogInterface.OnClickListener) null).create();
    }

    public Dialog makeSimpleDialog(String text) {
        if (this.mActivity != null) {
            return makeSimpleDialog(this.mActivity, text);
        }
        logError("*** makeSimpleDialog failed: no current Activity!");
        return null;
    }

    public Dialog makeSimpleDialog(String title, String text) {
        if (this.mActivity != null) {
            return makeSimpleDialog(this.mActivity, title, text);
        }
        logError("*** makeSimpleDialog failed: no current Activity!");
        return null;
    }

    void debugLog(String message) {
        if (this.mDebugLog) {
            Log.d(TAG, "GameHelper: " + message);
        }
    }

    void logWarn(String message) {
        Log.w(TAG, "!!! GameHelper WARNING: " + message);
    }

    void logError(String message) {
        Log.e(TAG, "*** GameHelper ERROR: " + message);
    }

    public static class SignInFailureReason {
        public static final int NO_ACTIVITY_RESULT_CODE = -100;
        int mActivityResultCode;
        int mServiceErrorCode;

        public int getServiceErrorCode() {
            return this.mServiceErrorCode;
        }

        public int getActivityResultCode() {
            return this.mActivityResultCode;
        }

        public SignInFailureReason(int serviceErrorCode, int activityResultCode) {
            this.mServiceErrorCode = 0;
            this.mActivityResultCode = -100;
            this.mServiceErrorCode = serviceErrorCode;
            this.mActivityResultCode = activityResultCode;
        }

        public SignInFailureReason(int serviceErrorCode) {
            this(serviceErrorCode, -100);
        }

        public String toString() {
            return "SignInFailureReason(serviceErrorCode:" + GameHelperUtils.errorCodeToString(this.mServiceErrorCode) + (this.mActivityResultCode == -100 ? ")" : ",activityResultCode:" + GameHelperUtils.activityResponseCodeToString(this.mActivityResultCode) + ")");
        }
    }

    public void setConnectOnStart(boolean connectOnStart) {
        debugLog("Forcing mConnectOnStart=" + connectOnStart);
        this.mConnectOnStart = connectOnStart;
    }
}
