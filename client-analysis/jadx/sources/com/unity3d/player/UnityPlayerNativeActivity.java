package com.unity3d.player;

import android.os.Bundle;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class UnityPlayerNativeActivity extends UnityPlayerActivity {
    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        Log.w("Unity", "UnityPlayerNativeActivity has been deprecated, please update your AndroidManifest to use UnityPlayerActivity instead");
        super.onCreate(bundle);
    }
}
