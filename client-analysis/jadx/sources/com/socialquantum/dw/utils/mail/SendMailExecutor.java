package com.socialquantum.dw.utils.mail;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class SendMailExecutor implements Runnable {
    private String attachmentFile;
    private String email;
    private Activity mActivity;
    private Boolean mIsHtml;
    private String text;
    private String theme;

    SendMailExecutor(Activity _context, String _email, String _theme, String _text, Boolean _isHtml, String _attachmentFile) {
        this.mActivity = _context;
        this.email = _email;
        this.theme = _theme;
        this.text = _text;
        this.mIsHtml = _isHtml;
        this.attachmentFile = _attachmentFile;
    }

    SendMailExecutor(Activity _context, String _email, String _theme, String _text, Boolean _isHtml) {
        this.mActivity = _context;
        this.email = _email;
        this.theme = _theme;
        this.text = _text;
        this.mIsHtml = _isHtml;
    }

    @Override // java.lang.Runnable
    public void run() {
        Intent emailIntent = new Intent("android.intent.action.SEND");
        emailIntent.setType("plain/text");
        emailIntent.putExtra("android.intent.extra.EMAIL", new String[]{this.email});
        emailIntent.putExtra("android.intent.extra.SUBJECT", this.theme);
        if (this.mIsHtml.booleanValue()) {
            emailIntent.putExtra("android.intent.extra.TEXT", Html.fromHtml(this.text));
        } else {
            emailIntent.putExtra("android.intent.extra.TEXT", this.text);
        }
        if (this.attachmentFile != null && !this.attachmentFile.isEmpty()) {
            Uri uri = Uri.fromFile(new File(this.attachmentFile));
            emailIntent.putExtra("android.intent.extra.STREAM", uri);
        }
        this.mActivity.startActivity(Intent.createChooser(emailIntent, "Select application..."));
    }
}
