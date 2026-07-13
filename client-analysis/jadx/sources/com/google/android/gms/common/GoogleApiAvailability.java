package com.google.android.gms.common;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.ProgressBar;

/* JADX INFO: loaded from: classes.dex */
public class GoogleApiAvailability extends zzc {
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    private static final GoogleApiAvailability zzafE = new GoogleApiAvailability();
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE;

    GoogleApiAvailability() {
    }

    public static GoogleApiAvailability getInstance() {
        return zzafE;
    }

    public Dialog getErrorDialog(Activity activity, int errorCode, int requestCode) {
        return GooglePlayServicesUtil.getErrorDialog(errorCode, activity, requestCode);
    }

    public Dialog getErrorDialog(Activity activity, int errorCode, int requestCode, DialogInterface.OnCancelListener cancelListener) {
        return GooglePlayServicesUtil.getErrorDialog(errorCode, activity, requestCode, cancelListener);
    }

    @Override // com.google.android.gms.common.zzc
    @Nullable
    public PendingIntent getErrorResolutionPendingIntent(Context context, int errorCode, int requestCode) {
        return super.getErrorResolutionPendingIntent(context, errorCode, requestCode);
    }

    @Override // com.google.android.gms.common.zzc
    public final String getErrorString(int errorCode) {
        return super.getErrorString(errorCode);
    }

    @Override // com.google.android.gms.common.zzc
    @Nullable
    public String getOpenSourceSoftwareLicenseInfo(Context context) {
        return super.getOpenSourceSoftwareLicenseInfo(context);
    }

    @Override // com.google.android.gms.common.zzc
    public int isGooglePlayServicesAvailable(Context context) {
        return super.isGooglePlayServicesAvailable(context);
    }

    @Override // com.google.android.gms.common.zzc
    public final boolean isUserResolvableError(int errorCode) {
        return super.isUserResolvableError(errorCode);
    }

    public boolean showErrorDialogFragment(Activity activity, int errorCode, int requestCode) {
        return GooglePlayServicesUtil.showErrorDialogFragment(errorCode, activity, requestCode);
    }

    public boolean showErrorDialogFragment(Activity activity, int errorCode, int requestCode, DialogInterface.OnCancelListener cancelListener) {
        return GooglePlayServicesUtil.showErrorDialogFragment(errorCode, activity, requestCode, cancelListener);
    }

    public void showErrorNotification(Context context, int errorCode) {
        GooglePlayServicesUtil.showErrorNotification(errorCode, context);
    }

    public Dialog zza(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, null, R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(activity.getResources().getString(com.google.android.gms.R.string.common_google_play_services_updating_text, GooglePlayServicesUtil.zzao(activity)));
        builder.setTitle(com.google.android.gms.R.string.common_google_play_services_updating_title);
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog alertDialogCreate = builder.create();
        GooglePlayServicesUtil.zza(activity, onCancelListener, "GooglePlayServicesUpdatingDialog", alertDialogCreate);
        return alertDialogCreate;
    }

    @Override // com.google.android.gms.common.zzc
    @Nullable
    public PendingIntent zza(Context context, int i, int i2, @Nullable String str) {
        return super.zza(context, i, i2, str);
    }

    @Override // com.google.android.gms.common.zzc
    @Nullable
    public Intent zza(Context context, int i, @Nullable String str) {
        return super.zza(context, i, str);
    }

    @Override // com.google.android.gms.common.zzc
    public int zzaj(Context context) {
        return super.zzaj(context);
    }

    @Override // com.google.android.gms.common.zzc
    @Nullable
    @Deprecated
    public Intent zzbu(int i) {
        return super.zzbu(i);
    }

    @Override // com.google.android.gms.common.zzc
    public boolean zzd(Context context, int i) {
        return super.zzd(context, i);
    }
}
