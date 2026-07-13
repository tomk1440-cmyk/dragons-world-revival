package com.socialquantum.dw.utils.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.facebook.internal.ServerProtocol;
import com.unity3d.player.UnityPlayer;

/* JADX INFO: loaded from: classes.dex */
public class YesNoDialogExecutor implements Runnable {
    private Activity mContext;
    private String mMessage;
    private String mNoTitle;
    private String mTitle;
    private String mYesTitle;

    YesNoDialogExecutor(Activity _context, String _title, String _message, String _yesTitle, String _noTitle) {
        this.mContext = _context;
        this.mTitle = _title;
        this.mMessage = _message;
        this.mYesTitle = _yesTitle;
        this.mNoTitle = _noTitle;
    }

    @Override // java.lang.Runnable
    public void run() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        builder.setCancelable(false);
        builder.setTitle(this.mTitle);
        builder.setMessage(this.mMessage);
        builder.setPositiveButton(this.mYesTitle, new DialogInterface.OnClickListener() { // from class: com.socialquantum.dw.utils.dialogs.YesNoDialogExecutor.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                UnityPlayer.UnitySendMessage("AndroidListener", "OkClicked", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(this.mNoTitle, new DialogInterface.OnClickListener() { // from class: com.socialquantum.dw.utils.dialogs.YesNoDialogExecutor.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                UnityPlayer.UnitySendMessage("AndroidListener", "CancelClicked", "false");
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
