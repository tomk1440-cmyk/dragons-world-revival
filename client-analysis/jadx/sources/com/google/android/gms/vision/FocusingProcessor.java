package com.google.android.gms.vision;

import android.util.Log;
import android.util.SparseArray;

/* JADX INFO: loaded from: classes.dex */
public abstract class FocusingProcessor<T> implements Detector.Processor<T> {
    private Detector<T> zzbmN;
    private Tracker<T> zzbnd;
    private int zzbng;
    private int zzbne = 3;
    private boolean zzbnf = false;
    private int zzbnh = 0;

    public FocusingProcessor(Detector<T> detector, Tracker<T> tracker) {
        this.zzbmN = detector;
        this.zzbnd = tracker;
    }

    @Override // com.google.android.gms.vision.Detector.Processor
    public void receiveDetections(Detector.Detections<T> detections) {
        SparseArray<T> detectedItems = detections.getDetectedItems();
        if (detectedItems.size() == 0) {
            if (this.zzbnh == this.zzbne) {
                this.zzbnd.onDone();
                this.zzbnf = false;
            } else {
                this.zzbnd.onMissing(detections);
            }
            this.zzbnh++;
            return;
        }
        this.zzbnh = 0;
        if (this.zzbnf) {
            T t = detectedItems.get(this.zzbng);
            if (t != null) {
                this.zzbnd.onUpdate(detections, t);
                return;
            } else {
                this.zzbnd.onDone();
                this.zzbnf = false;
            }
        }
        int iSelectFocus = selectFocus(detections);
        T t2 = detectedItems.get(iSelectFocus);
        if (t2 == null) {
            Log.w("FocusingProcessor", "Invalid focus selected: " + iSelectFocus);
            return;
        }
        this.zzbnf = true;
        this.zzbng = iSelectFocus;
        this.zzbmN.setFocus(this.zzbng);
        this.zzbnd.onNewItem(this.zzbng, t2);
        this.zzbnd.onUpdate(detections, t2);
    }

    @Override // com.google.android.gms.vision.Detector.Processor
    public void release() {
        this.zzbnd.onDone();
    }

    public abstract int selectFocus(Detector.Detections<T> detections);

    protected void zzkq(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Invalid max gap: " + i);
        }
        this.zzbne = i;
    }
}
