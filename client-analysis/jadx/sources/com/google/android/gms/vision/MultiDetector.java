package com.google.android.gms.vision;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MultiDetector extends Detector<Object> {
    private List<Detector<? extends Object>> zzbno;

    public static class Builder {
        private MultiDetector zzbnp = new MultiDetector();

        public Builder add(Detector<? extends Object> detector) {
            this.zzbnp.zzbno.add(detector);
            return this;
        }

        public MultiDetector build() {
            if (this.zzbnp.zzbno.size() == 0) {
                throw new RuntimeException("No underlying detectors added to MultiDetector.");
            }
            return this.zzbnp;
        }
    }

    private MultiDetector() {
        this.zzbno = new ArrayList();
    }

    @Override // com.google.android.gms.vision.Detector
    public SparseArray<Object> detect(Frame frame) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        Iterator<Detector<? extends Object>> it = this.zzbno.iterator();
        while (it.hasNext()) {
            SparseArray<? extends Object> sparseArrayDetect = it.next().detect(frame);
            for (int i = 0; i < sparseArrayDetect.size(); i++) {
                int iKeyAt = sparseArrayDetect.keyAt(i);
                if (sparseArray.get(iKeyAt) != null) {
                    throw new IllegalStateException("Detection ID overlap for id = " + iKeyAt + ".  This means that one of the detectors is not using global IDs.");
                }
                sparseArray.append(iKeyAt, sparseArrayDetect.valueAt(i));
            }
        }
        return sparseArray;
    }

    @Override // com.google.android.gms.vision.Detector
    public boolean isOperational() {
        Iterator<Detector<? extends Object>> it = this.zzbno.iterator();
        while (it.hasNext()) {
            if (!it.next().isOperational()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.vision.Detector
    public void receiveFrame(Frame frame) {
        Iterator<Detector<? extends Object>> it = this.zzbno.iterator();
        while (it.hasNext()) {
            it.next().receiveFrame(frame);
        }
    }

    @Override // com.google.android.gms.vision.Detector
    public void release() {
        Iterator<Detector<? extends Object>> it = this.zzbno.iterator();
        while (it.hasNext()) {
            it.next().release();
        }
        this.zzbno.clear();
    }

    @Override // com.google.android.gms.vision.Detector
    public void setProcessor(Detector.Processor<Object> processor) {
        throw new UnsupportedOperationException("MultiDetector.setProcessor is not supported.  You should set a processor instance on each underlying detector instead.");
    }
}
