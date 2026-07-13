package com.socialquantum.dw.utils.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.facebook.appevents.AppEventsConstants;
import com.unity3d.player.UnityPlayer;

/* JADX INFO: loaded from: classes.dex */
public class RateUsDialogExecutor implements Runnable {
    private Activity mContext;
    private String mLaterTitle;
    private String mMessage;
    private String mNoTitle;
    private String mTitle;
    private String mYesTitle;

    RateUsDialogExecutor(Activity _context, String _title, String _message, String _yesTitle, String _noTitle, String _laterTitle) {
        this.mContext = _context;
        this.mTitle = _title;
        this.mMessage = _message;
        this.mYesTitle = _yesTitle;
        this.mNoTitle = _noTitle;
        this.mLaterTitle = _laterTitle;
    }

    @Override // java.lang.Runnable
    public void run() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        builder.setCancelable(false);
        builder.setTitle(this.mTitle);
        builder.setMessage(this.mMessage);
        builder.setPositiveButton(this.mNoTitle, new DialogInterface.OnClickListener() { // from class: com.socialquantum.dw.utils.dialogs.RateUsDialogExecutor.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                UnityPlayer.UnitySendMessage("AndroidListener", "HandleRateUsResult", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                dialog.dismiss();
            }
        });
        builder.setNeutralButton(this.mYesTitle, new DialogInterface.OnClickListener() { // from class: com.socialquantum.dw.utils.dialogs.RateUsDialogExecutor.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                UnityPlayer.UnitySendMessage("AndroidListener", "HandleRateUsResult", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(this.mLaterTitle, new DialogInterface.OnClickListener() { // from class: com.socialquantum.dw.utils.dialogs.RateUsDialogExecutor.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                UnityPlayer.UnitySendMessage("AndroidListener", "HandleRateUsResult", "2");
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
