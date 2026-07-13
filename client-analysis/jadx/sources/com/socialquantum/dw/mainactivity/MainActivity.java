package com.socialquantum.dw.mainactivity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.socialquantum.device.memory.DeviceMemoryActivity;
import java.io.File;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(14)
public class MainActivity extends Activity {
    private String TAG = "MainActivity";
    private DeviceMemoryActivity deviceMemoryActivity;

    @Override // android.app.Activity
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        Log.d(this.TAG, "onCreate called!");
        try {
            ReadUrlReference(getApplicationContext(), getIntent(), this.TAG);
            Intent intent = new Intent(this, (Class<?>) UnityPlayerActivity.class);
            intent.addFlags(65536);
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                intent.putExtras(extras);
            }
            startActivity(intent);
        } catch (Exception e) {
            Log.e(this.TAG, "FAIL : " + e);
        } finally {
            Log.i(this.TAG, "Creation ok");
            finish();
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        Log.d(this.TAG, "onStart called!");
    }

    private void ReadUrlReference(Context context, Intent intent, String logCaption) {
        String urlText = intent.getDataString();
        if (urlText == null) {
            Log.d(this.TAG, "Ad reference url is not specified (url == null)");
        } else {
            SaveUrlReferenceToFile(getApplicationContext(), urlText, logCaption);
        }
    }

    private void SaveUrlReferenceToFile(Context context, String sourceUri, String logCaption) {
        String reward;
        Log.d(this.TAG, "sourceUri: " + sourceUri);
        try {
            String decodedUriText = Uri.decode(sourceUri);
            Log.d(this.TAG, "decodedUri: " + decodedUriText);
            Uri url = Uri.parse(decodedUriText);
            if (url != null && (reward = url.getQueryParameter("reward")) != null && !reward.isEmpty()) {
                String[] rewardValues = reward.split("\\.");
                String rewardId = rewardValues[0];
                String filename = "reward_" + rewardId;
                File file = new File(context.getExternalFilesDir(null), filename);
                FileOutputStream outputStream = new FileOutputStream(file);
                outputStream.write(url.getQuery().getBytes());
                outputStream.close();
                Log.d(this.TAG, "File saved: " + file.getPath());
            }
        } catch (Exception e) {
            Log.d(this.TAG, "Exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
