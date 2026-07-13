package com.socialquantum.dw.utils.dialogs;

import com.socialquantum.dw.utils.CurrentActivity;

/* JADX INFO: loaded from: classes.dex */
public class DialogViewer {
    public String ShowOkDialog(String _title, String _message, String _buttonName) {
        OkDialogExecutor executor = new OkDialogExecutor(CurrentActivity.value, _title, _message, _buttonName);
        CurrentActivity.value.runOnUiThread(executor);
        return "dialog OK";
    }

    public String ShowYesNoDialog(String _title, String _message, String _yesTitle, String _noTitle) {
        YesNoDialogExecutor executor = new YesNoDialogExecutor(CurrentActivity.value, _title, _message, _yesTitle, _noTitle);
        CurrentActivity.value.runOnUiThread(executor);
        return "dialog YesNo";
    }

    public String ShowRateUsdDialog(String _title, String _message, String _yesTitle, String _noTitle, String _laterButton) {
        RateUsDialogExecutor executor = new RateUsDialogExecutor(CurrentActivity.value, _title, _message, _yesTitle, _noTitle, _laterButton);
        CurrentActivity.value.runOnUiThread(executor);
        return "dialog RateUs";
    }
}
