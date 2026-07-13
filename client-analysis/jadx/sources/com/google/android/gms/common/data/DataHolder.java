package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@KeepName
public final class DataHolder implements SafeParcelable {
    public static final zze CREATOR = new zze();
    private static final zza zzajq = new zza(new String[0], null) { // from class: com.google.android.gms.common.data.DataHolder.1
    };
    boolean mClosed;
    private final int mVersionCode;
    private final int zzade;
    private final String[] zzaji;
    Bundle zzajj;
    private final CursorWindow[] zzajk;
    private final Bundle zzajl;
    int[] zzajm;
    int zzajn;
    private Object zzajo;
    private boolean zzajp;

    public static class zza {
        private final String[] zzaji;
        private final ArrayList<HashMap<String, Object>> zzajr;
        private final String zzajs;
        private final HashMap<Object, Integer> zzajt;
        private boolean zzaju;
        private String zzajv;

        private zza(String[] strArr, String str) {
            this.zzaji = (String[]) zzx.zzz(strArr);
            this.zzajr = new ArrayList<>();
            this.zzajs = str;
            this.zzajt = new HashMap<>();
            this.zzaju = false;
            this.zzajv = null;
        }
    }

    public static class zzb extends RuntimeException {
        public zzb(String str) {
            super(str);
        }
    }

    DataHolder(int versionCode, String[] columns, CursorWindow[] windows, int statusCode, Bundle metadata) {
        this.mClosed = false;
        this.zzajp = true;
        this.mVersionCode = versionCode;
        this.zzaji = columns;
        this.zzajk = windows;
        this.zzade = statusCode;
        this.zzajl = metadata;
    }

    private DataHolder(zza builder, int statusCode, Bundle metadata) {
        this(builder.zzaji, zza(builder, -1), statusCode, metadata);
    }

    public DataHolder(String[] columns, CursorWindow[] windows, int statusCode, Bundle metadata) {
        this.mClosed = false;
        this.zzajp = true;
        this.mVersionCode = 1;
        this.zzaji = (String[]) zzx.zzz(columns);
        this.zzajk = (CursorWindow[]) zzx.zzz(windows);
        this.zzade = statusCode;
        this.zzajl = metadata;
        zzqd();
    }

    public static DataHolder zza(int i, Bundle bundle) {
        return new DataHolder(zzajq, i, bundle);
    }

    private static CursorWindow[] zza(zza zzaVar, int i) {
        int i2;
        boolean z;
        CursorWindow cursorWindow;
        if (zzaVar.zzaji.length == 0) {
            return new CursorWindow[0];
        }
        List listSubList = (i < 0 || i >= zzaVar.zzajr.size()) ? zzaVar.zzajr : zzaVar.zzajr.subList(0, i);
        int size = listSubList.size();
        CursorWindow cursorWindow2 = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow2);
        cursorWindow2.setNumColumns(zzaVar.zzaji.length);
        int i3 = 0;
        boolean z2 = false;
        while (i3 < size) {
            try {
                if (!cursorWindow2.allocRow()) {
                    Log.d("DataHolder", "Allocating additional cursor window for large data set (row " + i3 + ")");
                    cursorWindow2 = new CursorWindow(false);
                    cursorWindow2.setStartPosition(i3);
                    cursorWindow2.setNumColumns(zzaVar.zzaji.length);
                    arrayList.add(cursorWindow2);
                    if (!cursorWindow2.allocRow()) {
                        Log.e("DataHolder", "Unable to allocate row to hold data.");
                        arrayList.remove(cursorWindow2);
                        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                    }
                }
                Map map = (Map) listSubList.get(i3);
                boolean zPutDouble = true;
                for (int i4 = 0; i4 < zzaVar.zzaji.length && zPutDouble; i4++) {
                    String str = zzaVar.zzaji[i4];
                    Object obj = map.get(str);
                    if (obj == null) {
                        zPutDouble = cursorWindow2.putNull(i3, i4);
                    } else if (obj instanceof String) {
                        zPutDouble = cursorWindow2.putString((String) obj, i3, i4);
                    } else if (obj instanceof Long) {
                        zPutDouble = cursorWindow2.putLong(((Long) obj).longValue(), i3, i4);
                    } else if (obj instanceof Integer) {
                        zPutDouble = cursorWindow2.putLong(((Integer) obj).intValue(), i3, i4);
                    } else if (obj instanceof Boolean) {
                        zPutDouble = cursorWindow2.putLong(((Boolean) obj).booleanValue() ? 1L : 0L, i3, i4);
                    } else if (obj instanceof byte[]) {
                        zPutDouble = cursorWindow2.putBlob((byte[]) obj, i3, i4);
                    } else if (obj instanceof Double) {
                        zPutDouble = cursorWindow2.putDouble(((Double) obj).doubleValue(), i3, i4);
                    } else {
                        if (!(obj instanceof Float)) {
                            throw new IllegalArgumentException("Unsupported object for column " + str + ": " + obj);
                        }
                        zPutDouble = cursorWindow2.putDouble(((Float) obj).floatValue(), i3, i4);
                    }
                }
                if (zPutDouble) {
                    i2 = i3;
                    z = false;
                    cursorWindow = cursorWindow2;
                } else {
                    if (z2) {
                        throw new zzb("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                    }
                    Log.d("DataHolder", "Couldn't populate window data for row " + i3 + " - allocating new window.");
                    cursorWindow2.freeLastRow();
                    CursorWindow cursorWindow3 = new CursorWindow(false);
                    cursorWindow3.setStartPosition(i3);
                    cursorWindow3.setNumColumns(zzaVar.zzaji.length);
                    arrayList.add(cursorWindow3);
                    i2 = i3 - 1;
                    cursorWindow = cursorWindow3;
                    z = true;
                }
                z2 = z;
                cursorWindow2 = cursorWindow;
                i3 = i2 + 1;
            } catch (RuntimeException e) {
                int size2 = arrayList.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    ((CursorWindow) arrayList.get(i5)).close();
                }
                throw e;
            }
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    public static DataHolder zzbI(int i) {
        return zza(i, (Bundle) null);
    }

    private void zzg(String str, int i) {
        if (this.zzajj == null || !this.zzajj.containsKey(str)) {
            throw new IllegalArgumentException("No such column: " + str);
        }
        if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        }
        if (i < 0 || i >= this.zzajn) {
            throw new CursorIndexOutOfBoundsException(i, this.zzajn);
        }
    }

    public void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                for (int i = 0; i < this.zzajk.length; i++) {
                    this.zzajk[i].close();
                }
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected void finalize() throws Throwable {
        try {
            if (this.zzajp && this.zzajk.length > 0 && !isClosed()) {
                Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (" + (this.zzajo == null ? "internal object: " + toString() : this.zzajo.toString()) + ")");
                close();
            }
        } finally {
            super.finalize();
        }
    }

    public int getCount() {
        return this.zzajn;
    }

    public int getStatusCode() {
        return this.zzade;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags);
    }

    public void zza(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        zzg(str, i);
        this.zzajk[i2].copyStringToBuffer(i, this.zzajj.getInt(str), charArrayBuffer);
    }

    public long zzb(String str, int i, int i2) {
        zzg(str, i);
        return this.zzajk[i2].getLong(i, this.zzajj.getInt(str));
    }

    public int zzbH(int i) {
        int i2 = 0;
        zzx.zzab(i >= 0 && i < this.zzajn);
        while (i2 < this.zzajm.length) {
            if (i < this.zzajm[i2]) {
                i2--;
                break;
            }
            i2++;
        }
        return i2 == this.zzajm.length ? i2 - 1 : i2;
    }

    public int zzc(String str, int i, int i2) {
        zzg(str, i);
        return this.zzajk[i2].getInt(i, this.zzajj.getInt(str));
    }

    public boolean zzcz(String str) {
        return this.zzajj.containsKey(str);
    }

    public String zzd(String str, int i, int i2) {
        zzg(str, i);
        return this.zzajk[i2].getString(i, this.zzajj.getInt(str));
    }

    public boolean zze(String str, int i, int i2) {
        zzg(str, i);
        return Long.valueOf(this.zzajk[i2].getLong(i, this.zzajj.getInt(str))).longValue() == 1;
    }

    public float zzf(String str, int i, int i2) {
        zzg(str, i);
        return this.zzajk[i2].getFloat(i, this.zzajj.getInt(str));
    }

    public byte[] zzg(String str, int i, int i2) {
        zzg(str, i);
        return this.zzajk[i2].getBlob(i, this.zzajj.getInt(str));
    }

    public Uri zzh(String str, int i, int i2) {
        String strZzd = zzd(str, i, i2);
        if (strZzd == null) {
            return null;
        }
        return Uri.parse(strZzd);
    }

    public boolean zzi(String str, int i, int i2) {
        zzg(str, i);
        return this.zzajk[i2].isNull(i, this.zzajj.getInt(str));
    }

    public Bundle zzpZ() {
        return this.zzajl;
    }

    public void zzqd() {
        this.zzajj = new Bundle();
        for (int i = 0; i < this.zzaji.length; i++) {
            this.zzajj.putInt(this.zzaji[i], i);
        }
        this.zzajm = new int[this.zzajk.length];
        int numRows = 0;
        for (int i2 = 0; i2 < this.zzajk.length; i2++) {
            this.zzajm[i2] = numRows;
            numRows += this.zzajk[i2].getNumRows() - (numRows - this.zzajk[i2].getStartPosition());
        }
        this.zzajn = numRows;
    }

    String[] zzqe() {
        return this.zzaji;
    }

    CursorWindow[] zzqf() {
        return this.zzajk;
    }

    public void zzu(Object obj) {
        this.zzajo = obj;
    }
}
