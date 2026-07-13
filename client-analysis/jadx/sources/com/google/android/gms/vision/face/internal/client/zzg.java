package com.google.android.gms.vision.face.internal.client;

import android.content.Context;
import android.graphics.PointF;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.Landmark;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class zzg {
    private final Context mContext;
    private final FaceSettingsParcel zzbob;
    private final Object zzpV = new Object();
    private zzc zzboc = null;
    private boolean zzbod = false;

    public zzg(Context context, FaceSettingsParcel faceSettingsParcel) {
        this.mContext = context;
        this.zzbob = faceSettingsParcel;
        zzIi();
    }

    private zzc zzIi() {
        zzc zzcVar;
        synchronized (this.zzpV) {
            if (this.zzboc != null) {
                zzcVar = this.zzboc;
            } else {
                this.zzboc = zzf.zza(this.mContext, this.zzbob);
                if (!this.zzbod && this.zzboc == null) {
                    Log.w("FaceDetectorHandle", "Native face detector not yet available.  Reverting to no-op detection.");
                    this.zzbod = true;
                } else if (this.zzbod && this.zzboc != null) {
                    Log.w("FaceDetectorHandle", "Native face detector is now available.");
                }
                zzcVar = this.zzboc;
            }
        }
        return zzcVar;
    }

    private Face zza(FaceParcel faceParcel) {
        return new Face(faceParcel.id, new PointF(faceParcel.centerX, faceParcel.centerY), faceParcel.width, faceParcel.height, faceParcel.zzbnP, faceParcel.zzbnQ, zzb(faceParcel), faceParcel.zzbnS, faceParcel.zzbnT, faceParcel.zzbnU);
    }

    private Landmark zza(LandmarkParcel landmarkParcel) {
        return new Landmark(new PointF(landmarkParcel.x, landmarkParcel.y), landmarkParcel.type);
    }

    private Landmark[] zzb(FaceParcel faceParcel) {
        LandmarkParcel[] landmarkParcelArr = faceParcel.zzbnR;
        if (landmarkParcelArr == null) {
            return new Landmark[0];
        }
        Landmark[] landmarkArr = new Landmark[landmarkParcelArr.length];
        for (int i = 0; i < landmarkParcelArr.length; i++) {
            landmarkArr[i] = zza(landmarkParcelArr[i]);
        }
        return landmarkArr;
    }

    public boolean isOperational() {
        return zzIi() != null;
    }

    public void zzIh() {
        synchronized (this.zzpV) {
            if (this.zzboc == null) {
                return;
            }
            try {
                this.zzboc.zzIh();
            } catch (RemoteException e) {
                Log.e("FaceDetectorHandle", "Could not finalize native face detector", e);
            }
        }
    }

    public Face[] zzb(ByteBuffer byteBuffer, FrameMetadataParcel frameMetadataParcel) {
        zzc zzcVarZzIi = zzIi();
        if (zzcVarZzIi == null) {
            return new Face[0];
        }
        try {
            FaceParcel[] faceParcelArrZzc = zzcVarZzIi.zzc(com.google.android.gms.dynamic.zze.zzC(byteBuffer), frameMetadataParcel);
            Face[] faceArr = new Face[faceParcelArrZzc.length];
            for (int i = 0; i < faceParcelArrZzc.length; i++) {
                faceArr[i] = zza(faceParcelArrZzc[i]);
            }
            return faceArr;
        } catch (RemoteException e) {
            Log.e("FaceDetectorHandle", "Could not call native face detector", e);
            return new Face[0];
        }
    }

    public boolean zzkJ(int i) {
        zzc zzcVarZzIi = zzIi();
        if (zzcVarZzIi == null) {
            return false;
        }
        try {
            return zzcVarZzIi.zzkJ(i);
        } catch (RemoteException e) {
            Log.e("FaceDetectorHandle", "Could not call native face detector", e);
            return false;
        }
    }
}
