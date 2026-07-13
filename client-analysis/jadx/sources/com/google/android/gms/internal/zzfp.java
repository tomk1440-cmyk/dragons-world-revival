package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.R;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzfp extends zzfs {
    private final Context mContext;
    private final Map<String, String> zzxA;

    public zzfp(zzjp zzjpVar, Map<String, String> map) {
        super(zzjpVar, "storePicture");
        this.zzxA = map;
        this.mContext = zzjpVar.zzhP();
    }

    public void execute() {
        if (this.mContext == null) {
            zzam("Activity context is not available");
            return;
        }
        if (!com.google.android.gms.ads.internal.zzr.zzbC().zzM(this.mContext).zzdl()) {
            zzam("Feature is not supported by the device.");
            return;
        }
        final String str = this.zzxA.get("iurl");
        if (TextUtils.isEmpty(str)) {
            zzam("Image url cannot be empty.");
            return;
        }
        if (!URLUtil.isValidUrl(str)) {
            zzam("Invalid image url: " + str);
            return;
        }
        final String strZzal = zzal(str);
        if (!com.google.android.gms.ads.internal.zzr.zzbC().zzaE(strZzal)) {
            zzam("Image type not recognized: " + strZzal);
            return;
        }
        AlertDialog.Builder builderZzL = com.google.android.gms.ads.internal.zzr.zzbC().zzL(this.mContext);
        builderZzL.setTitle(com.google.android.gms.ads.internal.zzr.zzbF().zzd(R.string.store_picture_title, "Save image"));
        builderZzL.setMessage(com.google.android.gms.ads.internal.zzr.zzbF().zzd(R.string.store_picture_message, "Allow Ad to store image in Picture gallery?"));
        builderZzL.setPositiveButton(com.google.android.gms.ads.internal.zzr.zzbF().zzd(R.string.accept, "Accept"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.zzfp.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                try {
                    ((DownloadManager) zzfp.this.mContext.getSystemService("download")).enqueue(zzfp.this.zzf(str, strZzal));
                } catch (IllegalStateException e) {
                    zzfp.this.zzam("Could not store picture.");
                }
            }
        });
        builderZzL.setNegativeButton(com.google.android.gms.ads.internal.zzr.zzbF().zzd(R.string.decline, "Decline"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.zzfp.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                zzfp.this.zzam("User canceled the download.");
            }
        });
        builderZzL.create().show();
    }

    String zzal(String str) {
        return Uri.parse(str).getLastPathSegment();
    }

    DownloadManager.Request zzf(String str, String str2) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
        com.google.android.gms.ads.internal.zzr.zzbE().zza(request);
        return request;
    }
}
