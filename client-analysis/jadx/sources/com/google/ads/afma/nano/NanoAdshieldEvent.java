package com.google.ads.afma.nano;

import com.google.android.gms.internal.zzsm;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzss;
import com.google.android.gms.internal.zzst;
import com.google.android.gms.internal.zzsu;
import com.google.android.gms.internal.zzsx;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface NanoAdshieldEvent {

    public static final class AdShieldEvent extends zzsu {
        private static volatile AdShieldEvent[] zzaK;
        public String appId;

        public AdShieldEvent() {
            clear();
        }

        public static AdShieldEvent[] emptyArray() {
            if (zzaK == null) {
                synchronized (zzss.zzbut) {
                    if (zzaK == null) {
                        zzaK = new AdShieldEvent[0];
                    }
                }
            }
            return zzaK;
        }

        public static AdShieldEvent parseFrom(zzsm input) throws IOException {
            return new AdShieldEvent().mergeFrom(input);
        }

        public static AdShieldEvent parseFrom(byte[] data) throws zzst {
            return (AdShieldEvent) zzsu.mergeFrom(new AdShieldEvent(), data);
        }

        public AdShieldEvent clear() {
            this.appId = "";
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        public AdShieldEvent mergeFrom(zzsm input) throws IOException {
            while (true) {
                int iZzIX = input.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 10:
                        this.appId = input.readString();
                        break;
                    default:
                        if (!zzsx.zzb(input, iZzIX)) {
                        }
                        break;
                }
            }
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        public void writeTo(zzsn output) throws IOException {
            if (!this.appId.equals("")) {
                output.zzn(1, this.appId);
            }
            super.writeTo(output);
        }

        @Override // com.google.android.gms.internal.zzsu
        protected int zzz() {
            int iZzz = super.zzz();
            return !this.appId.equals("") ? iZzz + zzsn.zzo(1, this.appId) : iZzz;
        }
    }
}
