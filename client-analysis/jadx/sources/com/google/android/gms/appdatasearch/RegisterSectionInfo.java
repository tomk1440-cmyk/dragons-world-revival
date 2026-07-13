package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RegisterSectionInfo implements SafeParcelable {
    public static final zzi CREATOR = new zzi();
    final int mVersionCode;
    public final String name;
    public final int weight;
    public final String zzUd;
    public final boolean zzUe;
    public final boolean zzUf;
    public final String zzUg;
    public final Feature[] zzUh;
    final int[] zzUi;
    public final String zzUj;

    public static final class zza {
        private final String mName;
        private String zzUk;
        private boolean zzUl;
        private boolean zzUn;
        private String zzUo;
        private BitSet zzUq;
        private String zzUr;
        private int zzUm = 1;
        private final List<Feature> zzUp = new ArrayList();

        public zza(String str) {
            this.mName = str;
        }

        public zza zzM(boolean z) {
            this.zzUl = z;
            return this;
        }

        public zza zzN(boolean z) {
            this.zzUn = z;
            return this;
        }

        public zza zzap(int i) {
            if (this.zzUq == null) {
                this.zzUq = new BitSet();
            }
            this.zzUq.set(i);
            return this;
        }

        public zza zzbB(String str) {
            this.zzUk = str;
            return this;
        }

        public zza zzbC(String str) {
            this.zzUr = str;
            return this;
        }

        public RegisterSectionInfo zzmh() {
            int i = 0;
            int[] iArr = null;
            if (this.zzUq != null) {
                iArr = new int[this.zzUq.cardinality()];
                int iNextSetBit = this.zzUq.nextSetBit(0);
                while (iNextSetBit >= 0) {
                    iArr[i] = iNextSetBit;
                    iNextSetBit = this.zzUq.nextSetBit(iNextSetBit + 1);
                    i++;
                }
            }
            return new RegisterSectionInfo(this.mName, this.zzUk, this.zzUl, this.zzUm, this.zzUn, this.zzUo, (Feature[]) this.zzUp.toArray(new Feature[this.zzUp.size()]), iArr, this.zzUr);
        }
    }

    RegisterSectionInfo(int versionCode, String name, String format, boolean noIndex, int weight, boolean indexPrefixes, String subsectionSeparator, Feature[] features, int[] semanticLabels, String schemaOrgProperty) {
        this.mVersionCode = versionCode;
        this.name = name;
        this.zzUd = format;
        this.zzUe = noIndex;
        this.weight = weight;
        this.zzUf = indexPrefixes;
        this.zzUg = subsectionSeparator;
        this.zzUh = features;
        this.zzUi = semanticLabels;
        this.zzUj = schemaOrgProperty;
    }

    RegisterSectionInfo(String name, String format, boolean noIndex, int weight, boolean indexPrefixes, String subsectionSeparator, Feature[] features, int[] semanticLabels, String schemaOrgProperty) {
        this(2, name, format, noIndex, weight, indexPrefixes, subsectionSeparator, features, semanticLabels, schemaOrgProperty);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzi zziVar = CREATOR;
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzi zziVar = CREATOR;
        zzi.zza(this, out, flags);
    }
}
