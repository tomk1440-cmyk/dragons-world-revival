package com.google.android.gms.vision.barcode.internal.client;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class zzd {
    private final Context mContext;
    private final BarcodeDetectorOptions zzbnv;
    private final Object zzpV = new Object();
    private zzb zzbnx = null;

    static class zza extends zzg<zzc> {
        private static zza zzbny;

        zza() {
            super("com.google.android.gms.vision.client.DynamiteNativeBarcodeDetectorCreator");
        }

        static zzb zza(Context context, BarcodeDetectorOptions barcodeDetectorOptions) {
            if (zzbny == null) {
                zzbny = new zza();
            }
            return zzbny.zzb(context, barcodeDetectorOptions);
        }

        private zzb zzb(Context context, BarcodeDetectorOptions barcodeDetectorOptions) {
            try {
                return zzaB(context).zza(zze.zzC(context), barcodeDetectorOptions);
            } catch (RemoteException e) {
                Log.e("NativeBarcodeDetectorHandle", "Error creating native barcode detector", e);
                return null;
            } catch (zzg.zza e2) {
                Log.e("NativeBarcodeDetectorHandle", "Error creating native barcode detector", e2);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.dynamic.zzg
        /* JADX INFO: renamed from: zzef, reason: merged with bridge method [inline-methods] */
        public zzc zzd(IBinder iBinder) {
            return zzc.zza.zzee(iBinder);
        }
    }

    public zzd(Context context, BarcodeDetectorOptions barcodeDetectorOptions) {
        this.mContext = context;
        this.zzbnv = barcodeDetectorOptions;
        zzIg();
    }

    private zzb zzIg() {
        zzb zzbVar;
        synchronized (this.zzpV) {
            if (this.zzbnx == null) {
                this.zzbnx = zza.zza(this.mContext, this.zzbnv);
            }
            zzbVar = this.zzbnx;
        }
        return zzbVar;
    }

    public boolean isOperational() {
        return zzIg() != null;
    }

    public Barcode[] zza(Bitmap bitmap, FrameMetadataParcel frameMetadataParcel) {
        zzb zzbVarZzIg = zzIg();
        if (zzbVarZzIg == null) {
            return new Barcode[0];
        }
        try {
            return zzbVarZzIg.zzb(zze.zzC(bitmap), frameMetadataParcel);
        } catch (RemoteException e) {
            Log.e("NativeBarcodeDetectorHandle", "Error calling native barcode detector", e);
            return new Barcode[0];
        }
    }

    public Barcode[] zza(ByteBuffer byteBuffer, FrameMetadataParcel frameMetadataParcel) {
        zzb zzbVarZzIg = zzIg();
        if (zzbVarZzIg == null) {
            return new Barcode[0];
        }
        try {
            return zzbVarZzIg.zza(zze.zzC(byteBuffer), frameMetadataParcel);
        } catch (RemoteException e) {
            Log.e("NativeBarcodeDetectorHandle", "Error calling native barcode detector", e);
            return new Barcode[0];
        }
    }
}
