package com.google.android.gms.vision.barcode;

import android.content.Context;
import android.util.SparseArray;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.internal.client.BarcodeDetectorOptions;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;

/* JADX INFO: loaded from: classes.dex */
public final class BarcodeDetector extends Detector<Barcode> {
    private final com.google.android.gms.vision.barcode.internal.client.zzd zzbnu;

    public static class Builder {
        private Context mContext;
        private BarcodeDetectorOptions zzbnv = new BarcodeDetectorOptions();

        public Builder(Context context) {
            this.mContext = context;
        }

        public BarcodeDetector build() {
            return new BarcodeDetector(new com.google.android.gms.vision.barcode.internal.client.zzd(this.mContext, this.zzbnv));
        }

        public Builder setBarcodeFormats(int format) {
            this.zzbnv.zzbnw = format;
            return this;
        }
    }

    private BarcodeDetector() {
        throw new IllegalStateException("Default constructor called");
    }

    private BarcodeDetector(com.google.android.gms.vision.barcode.internal.client.zzd nativeDetector) {
        this.zzbnu = nativeDetector;
    }

    @Override // com.google.android.gms.vision.Detector
    public SparseArray<Barcode> detect(Frame frame) {
        if (frame == null) {
            throw new IllegalArgumentException("No frame supplied.");
        }
        frame.getMetadata();
        FrameMetadataParcel frameMetadataParcelZzc = FrameMetadataParcel.zzc(frame);
        Barcode[] barcodeArrZza = frame.getBitmap() != null ? this.zzbnu.zza(frame.getBitmap(), frameMetadataParcelZzc) : this.zzbnu.zza(frame.getGrayscaleImageData(), frameMetadataParcelZzc);
        SparseArray<Barcode> sparseArray = new SparseArray<>(barcodeArrZza.length);
        for (Barcode barcode : barcodeArrZza) {
            sparseArray.append(barcode.rawValue.hashCode(), barcode);
        }
        return sparseArray;
    }

    @Override // com.google.android.gms.vision.Detector
    public boolean isOperational() {
        return this.zzbnu.isOperational();
    }
}
