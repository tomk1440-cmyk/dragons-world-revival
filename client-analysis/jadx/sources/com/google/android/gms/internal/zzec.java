package com.google.android.gms.internal;

import android.os.Parcel;
import android.util.Base64;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes.dex */
@zzhb
class zzec {
    final int zzAC;
    final String zzpS;
    final AdRequestParcel zzqH;

    zzec(AdRequestParcel adRequestParcel, String str, int i) {
        this.zzqH = adRequestParcel;
        this.zzpS = str;
        this.zzAC = i;
    }

    zzec(zzea zzeaVar) {
        this(zzeaVar.zzei(), zzeaVar.getAdUnitId(), zzeaVar.getNetworkType());
    }

    zzec(String str) throws IOException {
        String[] strArrSplit = str.split("\u0000");
        if (strArrSplit.length != 3) {
            throw new IOException("Incorrect field count for QueueSeed.");
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.zzpS = new String(Base64.decode(strArrSplit[0], 0), "UTF-8");
                this.zzAC = Integer.parseInt(strArrSplit[1]);
                byte[] bArrDecode = Base64.decode(strArrSplit[2], 0);
                parcelObtain.unmarshall(bArrDecode, 0, bArrDecode.length);
                parcelObtain.setDataPosition(0);
                this.zzqH = AdRequestParcel.CREATOR.createFromParcel(parcelObtain);
                parcelObtain.recycle();
            } catch (IllegalArgumentException e) {
                throw new IOException("Malformed QueueSeed encoding.");
            }
        } catch (Throwable th) {
            parcelObtain.recycle();
            throw th;
        }
    }

    String zzem() {
        String str;
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                String strEncodeToString = Base64.encodeToString(this.zzpS.getBytes("UTF-8"), 0);
                String string = Integer.toString(this.zzAC);
                this.zzqH.writeToParcel(parcelObtain, 0);
                str = strEncodeToString + "\u0000" + string + "\u0000" + Base64.encodeToString(parcelObtain.marshall(), 0);
                parcelObtain.recycle();
            } catch (UnsupportedEncodingException e) {
                zzin.e("QueueSeed encode failed because UTF-8 is not available.");
                parcelObtain.recycle();
                str = "";
            }
            return str;
        } catch (Throwable th) {
            parcelObtain.recycle();
            throw th;
        }
    }
}
