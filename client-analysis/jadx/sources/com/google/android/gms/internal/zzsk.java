package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzsk extends zzso<zzsk> {
    public String[] zzbtT;
    public int[] zzbtU;
    public byte[][] zzbtV;

    public zzsk() {
        zzIW();
    }

    public static zzsk zzB(byte[] bArr) throws zzst {
        return (zzsk) zzsu.mergeFrom(new zzsk(), bArr);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzsk)) {
            return false;
        }
        zzsk zzskVar = (zzsk) o;
        if (!zzss.equals(this.zzbtT, zzskVar.zzbtT) || !zzss.equals(this.zzbtU, zzskVar.zzbtU) || !zzss.zza(this.zzbtV, zzskVar.zzbtV)) {
            return false;
        }
        if (this.zzbuj == null || this.zzbuj.isEmpty()) {
            return zzskVar.zzbuj == null || zzskVar.zzbuj.isEmpty();
        }
        return this.zzbuj.equals(zzskVar.zzbuj);
    }

    public int hashCode() {
        return ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + zzss.hashCode(this.zzbtT)) * 31) + zzss.hashCode(this.zzbtU)) * 31) + zzss.zza(this.zzbtV)) * 31);
    }

    @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
    public void writeTo(zzsn output) throws IOException {
        if (this.zzbtT != null && this.zzbtT.length > 0) {
            for (int i = 0; i < this.zzbtT.length; i++) {
                String str = this.zzbtT[i];
                if (str != null) {
                    output.zzn(1, str);
                }
            }
        }
        if (this.zzbtU != null && this.zzbtU.length > 0) {
            for (int i2 = 0; i2 < this.zzbtU.length; i2++) {
                output.zzA(2, this.zzbtU[i2]);
            }
        }
        if (this.zzbtV != null && this.zzbtV.length > 0) {
            for (int i3 = 0; i3 < this.zzbtV.length; i3++) {
                byte[] bArr = this.zzbtV[i3];
                if (bArr != null) {
                    output.zza(3, bArr);
                }
            }
        }
        super.writeTo(output);
    }

    public zzsk zzIW() {
        this.zzbtT = zzsx.zzbuB;
        this.zzbtU = zzsx.zzbuw;
        this.zzbtV = zzsx.zzbuC;
        this.zzbuj = null;
        this.zzbuu = -1;
        return this;
    }

    @Override // com.google.android.gms.internal.zzsu
    /* JADX INFO: renamed from: zzO, reason: merged with bridge method [inline-methods] */
    public zzsk mergeFrom(zzsm zzsmVar) throws IOException {
        while (true) {
            int iZzIX = zzsmVar.zzIX();
            switch (iZzIX) {
                case 0:
                    break;
                case 10:
                    int iZzc = zzsx.zzc(zzsmVar, 10);
                    int length = this.zzbtT == null ? 0 : this.zzbtT.length;
                    String[] strArr = new String[iZzc + length];
                    if (length != 0) {
                        System.arraycopy(this.zzbtT, 0, strArr, 0, length);
                    }
                    while (length < strArr.length - 1) {
                        strArr[length] = zzsmVar.readString();
                        zzsmVar.zzIX();
                        length++;
                    }
                    strArr[length] = zzsmVar.readString();
                    this.zzbtT = strArr;
                    break;
                case 16:
                    int iZzc2 = zzsx.zzc(zzsmVar, 16);
                    int length2 = this.zzbtU == null ? 0 : this.zzbtU.length;
                    int[] iArr = new int[iZzc2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.zzbtU, 0, iArr, 0, length2);
                    }
                    while (length2 < iArr.length - 1) {
                        iArr[length2] = zzsmVar.zzJb();
                        zzsmVar.zzIX();
                        length2++;
                    }
                    iArr[length2] = zzsmVar.zzJb();
                    this.zzbtU = iArr;
                    break;
                case 18:
                    int iZzmq = zzsmVar.zzmq(zzsmVar.zzJf());
                    int position = zzsmVar.getPosition();
                    int i = 0;
                    while (zzsmVar.zzJk() > 0) {
                        zzsmVar.zzJb();
                        i++;
                    }
                    zzsmVar.zzms(position);
                    int length3 = this.zzbtU == null ? 0 : this.zzbtU.length;
                    int[] iArr2 = new int[i + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.zzbtU, 0, iArr2, 0, length3);
                    }
                    while (length3 < iArr2.length) {
                        iArr2[length3] = zzsmVar.zzJb();
                        length3++;
                    }
                    this.zzbtU = iArr2;
                    zzsmVar.zzmr(iZzmq);
                    break;
                case 26:
                    int iZzc3 = zzsx.zzc(zzsmVar, 26);
                    int length4 = this.zzbtV == null ? 0 : this.zzbtV.length;
                    byte[][] bArr = new byte[iZzc3 + length4][];
                    if (length4 != 0) {
                        System.arraycopy(this.zzbtV, 0, bArr, 0, length4);
                    }
                    while (length4 < bArr.length - 1) {
                        bArr[length4] = zzsmVar.readBytes();
                        zzsmVar.zzIX();
                        length4++;
                    }
                    bArr[length4] = zzsmVar.readBytes();
                    this.zzbtV = bArr;
                    break;
                default:
                    if (!zza(zzsmVar, iZzIX)) {
                    }
                    break;
            }
        }
        return this;
    }

    @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
    protected int zzz() {
        int length;
        int iZzz = super.zzz();
        if (this.zzbtT == null || this.zzbtT.length <= 0) {
            length = iZzz;
        } else {
            int iZzgO = 0;
            int i = 0;
            for (int i2 = 0; i2 < this.zzbtT.length; i2++) {
                String str = this.zzbtT[i2];
                if (str != null) {
                    i++;
                    iZzgO += zzsn.zzgO(str);
                }
            }
            length = iZzz + iZzgO + (i * 1);
        }
        if (this.zzbtU != null && this.zzbtU.length > 0) {
            int iZzmx = 0;
            for (int i3 = 0; i3 < this.zzbtU.length; i3++) {
                iZzmx += zzsn.zzmx(this.zzbtU[i3]);
            }
            length = length + iZzmx + (this.zzbtU.length * 1);
        }
        if (this.zzbtV == null || this.zzbtV.length <= 0) {
            return length;
        }
        int iZzG = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < this.zzbtV.length; i5++) {
            byte[] bArr = this.zzbtV[i5];
            if (bArr != null) {
                i4++;
                iZzG += zzsn.zzG(bArr);
            }
        }
        return length + iZzG + (i4 * 1);
    }
}
