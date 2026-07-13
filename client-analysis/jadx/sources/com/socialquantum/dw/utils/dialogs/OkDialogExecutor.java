package com.socialquantum.dw.utils.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.unity3d.player.UnityPlayer;

/* JADX INFO: loaded from: classes.dex */
public class OkDialogExecutor implements Runnable {
    private String mButtonTitle;
    private Activity mContext;
    private String mMessage;
    private String mTitle;

    OkDialogExecutor(Activity _context, String _title, String _message, String _buttonTitle) {
        this.mContext = _context;
        this.mTitle = _title;
        this.mMessage = _message;
        this.mButtonTitle = _buttonTitle;
    }

    @Override // java.lang.Runnable
    public void run() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        builder.setCancelable(false);
        builder.setTitle(this.mTitle);
        builder.setMessage(this.mMessage);
        builder.setInverseBackgroundForced(true);
        builder.setPositiveButton(this.mButtonTitle, new DialogInterface.OnClickListener() { // from class: com.socialquantum.dw.utils.dialogs.OkDialogExecutor.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                UnityPlayer.UnitySendMessage("AndroidListener", "OkClicked", "Message to send");
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
