package com.google.android.gms.vision;

import android.util.SparseArray;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class MultiProcessor<T> implements Detector.Processor<T> {
    private int zzbne;
    private Factory<T> zzbnq;
    private SparseArray<MultiProcessor<T>.zza> zzbnr;

    public static class Builder<T> {
        private MultiProcessor<T> zzbns = new MultiProcessor<>();

        public Builder(Factory<T> factory) {
            if (factory == null) {
                throw new IllegalArgumentException("No factory supplied.");
            }
            ((MultiProcessor) this.zzbns).zzbnq = factory;
        }

        public MultiProcessor<T> build() {
            return this.zzbns;
        }

        public Builder<T> setMaxGapFrames(int maxGapFrames) {
            if (maxGapFrames < 0) {
                throw new IllegalArgumentException("Invalid max gap: " + maxGapFrames);
            }
            ((MultiProcessor) this.zzbns).zzbne = maxGapFrames;
            return this;
        }
    }

    public interface Factory<T> {
        Tracker<T> create(T t);
    }

    private class zza {
        private Tracker<T> zzbnd;
        private int zzbnh;

        private zza() {
            this.zzbnh = 0;
        }

        static /* synthetic */ int zzb(zza zzaVar) {
            int i = zzaVar.zzbnh;
            zzaVar.zzbnh = i + 1;
            return i;
        }
    }

    private MultiProcessor() {
        this.zzbnr = new SparseArray<>();
        this.zzbne = 3;
    }

    private void zza(Detector.Detections<T> detections) {
        SparseArray<T> detectedItems = detections.getDetectedItems();
        for (int i = 0; i < detectedItems.size(); i++) {
            int iKeyAt = detectedItems.keyAt(i);
            T tValueAt = detectedItems.valueAt(i);
            if (this.zzbnr.get(iKeyAt) == null) {
                MultiProcessor<T>.zza zzaVar = new zza();
                ((zza) zzaVar).zzbnd = this.zzbnq.create(tValueAt);
                ((zza) zzaVar).zzbnd.onNewItem(iKeyAt, tValueAt);
                this.zzbnr.append(iKeyAt, zzaVar);
            }
        }
    }

    private void zzb(Detector.Detections<T> detections) {
        SparseArray<T> detectedItems = detections.getDetectedItems();
        HashSet hashSet = new HashSet();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.zzbnr.size()) {
                break;
            }
            int iKeyAt = this.zzbnr.keyAt(i2);
            if (detectedItems.get(iKeyAt) == null) {
                MultiProcessor<T>.zza zzaVarValueAt = this.zzbnr.valueAt(i2);
                zza.zzb(zzaVarValueAt);
                if (((zza) zzaVarValueAt).zzbnh >= this.zzbne) {
                    ((zza) zzaVarValueAt).zzbnd.onDone();
                    hashSet.add(Integer.valueOf(iKeyAt));
                } else {
                    ((zza) zzaVarValueAt).zzbnd.onMissing(detections);
                }
            }
            i = i2 + 1;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            this.zzbnr.delete(((Integer) it.next()).intValue());
        }
    }

    private void zzc(Detector.Detections<T> detections) {
        SparseArray<T> detectedItems = detections.getDetectedItems();
        for (int i = 0; i < detectedItems.size(); i++) {
            int iKeyAt = detectedItems.keyAt(i);
            T tValueAt = detectedItems.valueAt(i);
            MultiProcessor<T>.zza zzaVar = this.zzbnr.get(iKeyAt);
            ((zza) zzaVar).zzbnh = 0;
            ((zza) zzaVar).zzbnd.onUpdate(detections, tValueAt);
        }
    }

    @Override // com.google.android.gms.vision.Detector.Processor
    public void receiveDetections(Detector.Detections<T> detections) {
        zza(detections);
        zzb(detections);
        zzc(detections);
    }

    @Override // com.google.android.gms.vision.Detector.Processor
    public void release() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.zzbnr.size()) {
                this.zzbnr.clear();
                return;
            } else {
                ((zza) this.zzbnr.valueAt(i2)).zzbnd.onDone();
                i = i2 + 1;
            }
        }
    }
}
