package com.socialquantum.dw.utils;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import com.unity3d.player.UnityPlayer;

/* JADX INFO: loaded from: classes.dex */
public class ClipBoardUtil {
    public void Copy(String text) {
        Activity context = UnityPlayer.currentActivity;
        CopyExecutor executor = new CopyExecutor(text, context);
        context.runOnUiThread(executor);
    }

    class CopyExecutor implements Runnable {
        private Activity mActivity;
        private String mText;

        CopyExecutor(String copyText, Activity context) {
            this.mActivity = context;
            this.mText = copyText;
        }

        @Override // java.lang.Runnable
        public void run() {
            ClipboardManager mClipBoard = (ClipboardManager) this.mActivity.getSystemService("clipboard");
            ClipData currentClip = ClipData.newPlainText("Text to copy", this.mText);
            if (currentClip != null) {
                mClipBoard.setPrimaryClip(currentClip);
            }
        }
    }
}
