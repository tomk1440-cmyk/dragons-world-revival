package com.google.android.gms.tagmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class PreviewActivity extends Activity {
    private void zzm(String str, String str2, String str3) {
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        alertDialogCreate.setTitle(str);
        alertDialogCreate.setMessage(str2);
        alertDialogCreate.setButton(-1, str3, new DialogInterface.OnClickListener() { // from class: com.google.android.gms.tagmanager.PreviewActivity.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alertDialogCreate.show();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            zzbg.zzaJ("Preview activity");
            Uri data = getIntent().getData();
            if (!TagManager.getInstance(this).zzp(data)) {
                String str = "Cannot preview the app with the uri: " + data + ". Launching current version instead.";
                zzbg.zzaK(str);
                zzm("Preview failure", str, "Continue");
            }
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            if (launchIntentForPackage == null) {
                zzbg.zzaJ("No launch activity found for package name: " + getPackageName());
            } else {
                zzbg.zzaJ("Invoke the launch activity for package name: " + getPackageName());
                startActivity(launchIntentForPackage);
            }
        } catch (Exception e) {
            zzbg.e("Calling preview threw an exception: " + e.getMessage());
        }
    }
}
