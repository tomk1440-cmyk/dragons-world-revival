package com.prime31;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;

/* JADX INFO: loaded from: classes.dex */
public class AuthenticationProxyActivity extends Activity implements GameHelper.GameHelperListener {
    private static final String TAG = "Prime31-GHProxy";
    private boolean _attemptedUserInitiatedSignIn;
    private GameHelper _helper;

    public interface AuthenticationProxyGameHelperListener {
        void onSignInFailed(String str);

        void onSignInSucceeded(String str, TurnBasedMatch turnBasedMatch, Invitation invitation);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
        this._helper = new GameHelper(this, 11);
        this._helper.enableDebugLog(true);
        this._helper.setShowErrorDialogs(false);
        this._helper.setMaxAutoSignInAttempts(0);
        this._helper.setup(this);
        View v = new View(this);
        v.setBackgroundColor(1090519039);
        setContentView(v);
        super.onCreate(savedInstanceState);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i(TAG, "onActivityResult. resultCode: " + resultCode);
        this._helper.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override // android.app.Activity
    protected void onStart() {
        Log.i(TAG, "onStart");
        this._helper.onStart(this);
    }

    @Override // android.app.Activity
    protected void onStop() {
        Log.i(TAG, "onStop");
        this._helper.onStop();
    }

    @Override // com.prime31.GameHelper.GameHelperListener
    public void onSignInFailed() {
        if (!this._attemptedUserInitiatedSignIn) {
            Log.i(TAG, "onSignInFailed. but we have not yet tried forcing a user initiated sign in so doing that now.");
            this._attemptedUserInitiatedSignIn = true;
            this._helper.beginUserInitiatedSignIn();
        } else {
            Log.i(TAG, "onSignInFailed. this was a user initiated sign in so it is a true failure");
            if (this._helper.hasSignInError()) {
                this._helper.getSignInError().toString();
            }
            finish();
        }
    }

    @Override // com.prime31.GameHelper.GameHelperListener
    public void onSignInSucceeded() {
        Log.i(TAG, "onSignInSucceeded");
        finish();
    }
}
