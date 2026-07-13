package com.socialquantum.dw.utils.storage;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class FileSystem {
    public static void SaveUrlReferenceToFile(Context context, String sourceUri, String logCaption) {
        Log.d(logCaption, "sourceUri: " + sourceUri);
        try {
            String decodedUriText = Uri.decode(sourceUri);
            Log.d(logCaption, "decodedUri: " + decodedUriText);
            Uri url = Uri.parse(decodedUriText);
            String reward = url.getQueryParameter("reward");
            String[] rewardValues = reward.split("\\.");
            String rewardId = rewardValues[0];
            String filename = "reward_" + rewardId;
            File file = new File(context.getExternalFilesDir(null), filename);
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(url.getQuery().getBytes());
            outputStream.close();
            Log.d(logCaption, "File saved: " + file.getPath());
        } catch (Exception e) {
            Log.d(logCaption, "Exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
