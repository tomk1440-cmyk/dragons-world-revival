package com.google.android.gms.vision.face.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
class zzf extends com.google.android.gms.dynamic.zzg<zzd> {
    private static zzf zzboa;

    zzf() {
        super("com.google.android.gms.vision.client.DynamiteNativeFaceDetectorCreator");
    }

    static zzc zza(Context context, FaceSettingsParcel faceSettingsParcel) {
        if (zzboa == null) {
            zzboa = new zzf();
        }
        return zzboa.zzb(context, faceSettingsParcel);
    }

    private zzc zzb(Context context, FaceSettingsParcel faceSettingsParcel) {
        try {
            return zzaB(context).zza(com.google.android.gms.dynamic.zze.zzC(context), faceSettingsParcel);
        } catch (Exception e) {
            Log.e("FaceDetectorHandle", "Could not create native face detector", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.dynamic.zzg
    /* JADX INFO: renamed from: zzei, reason: merged with bridge method [inline-methods] */
    public zzd zzd(IBinder iBinder) {
        return zzd.zza.zzeh(iBinder);
    }
}
