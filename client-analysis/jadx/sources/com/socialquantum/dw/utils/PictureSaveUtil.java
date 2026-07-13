package com.socialquantum.dw.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.images.ImageManager;
import com.unity3d.player.UnityPlayer;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class PictureSaveUtil {
    static final String PROFILE_PICTURE_SAVED_KEY = "profile_picture_saved";
    private static final String TAG = "PictureSaveUtil";

    public static void savePictureFromResources(final String pictureUri, final String savePath) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.socialquantum.dw.utils.PictureSaveUtil.1
            @Override // java.lang.Runnable
            public void run() {
                PictureSaveUtil.savePictureFromResourcesPrivate(pictureUri, savePath);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void savePictureFromResourcesPrivate(String pictureUri, final String savePath) {
        ImageManager manager = ImageManager.create(UnityPlayer.currentActivity.getApplicationContext());
        Uri uri = Uri.parse(pictureUri);
        manager.loadImage(new ImageManager.OnImageLoadedListener() { // from class: com.socialquantum.dw.utils.PictureSaveUtil.2
            @Override // com.google.android.gms.common.images.ImageManager.OnImageLoadedListener
            public void onImageLoaded(Uri arg0, Drawable drawable, boolean arg2) {
                if (drawable != null && (drawable instanceof BitmapDrawable)) {
                    Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                    FileOutputStream fileStream = null;
                    try {
                        FileOutputStream fileStream2 = new FileOutputStream(savePath);
                        fileStream = fileStream2;
                    } catch (FileNotFoundException e) {
                        Log.d(PictureSaveUtil.TAG, "Cannot create image file: " + e.getMessage());
                    }
                    if (fileStream != null) {
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileStream);
                        try {
                            fileStream.close();
                            Context currentContext = UnityPlayer.currentActivity.getApplicationContext();
                            SharedPreferences prefs = currentContext.getSharedPreferences(currentContext.getPackageName(), 0);
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putInt(PictureSaveUtil.PROFILE_PICTURE_SAVED_KEY, 1);
                            editor.commit();
                        } catch (IOException e2) {
                            Log.d(PictureSaveUtil.TAG, "Cannot save image file: " + e2.getMessage());
                        }
                    }
                }
            }
        }, uri);
    }
}
