package com.socialquantum.dw.utils.mail;

import com.unity3d.player.UnityPlayer;

/* JADX INFO: loaded from: classes.dex */
public class SendMailUtil {
    public static void SendMail(String email, String theme, String text) {
        SendMailExecutor executor = new SendMailExecutor(UnityPlayer.currentActivity, email, theme, text, true);
        UnityPlayer.currentActivity.runOnUiThread(executor);
    }

    public static void SendMailWithAttachment(String email, String theme, String text, String attachmentFile) {
        SendMailExecutor executor = new SendMailExecutor(UnityPlayer.currentActivity, email, theme, text, true, attachmentFile);
        UnityPlayer.currentActivity.runOnUiThread(executor);
    }
}
