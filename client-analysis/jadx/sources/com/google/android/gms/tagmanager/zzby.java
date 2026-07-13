package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzmt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class zzby implements zzau {
    private static final String zzQR = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", "gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time");
    private final Context mContext;
    private final zzb zzbjE;
    private volatile zzac zzbjF;
    private final zzav zzbjG;
    private final String zzbjH;
    private long zzbjI;
    private final int zzbjJ;
    private zzmq zzqW;

    class zza implements zzcx.zza {
        zza() {
        }

        @Override // com.google.android.gms.tagmanager.zzcx.zza
        public void zza(zzaq zzaqVar) {
            zzby.this.zzq(zzaqVar.zzGD());
        }

        @Override // com.google.android.gms.tagmanager.zzcx.zza
        public void zzb(zzaq zzaqVar) {
            zzby.this.zzq(zzaqVar.zzGD());
            zzbg.v("Permanent failure dispatching hitId: " + zzaqVar.zzGD());
        }

        @Override // com.google.android.gms.tagmanager.zzcx.zza
        public void zzc(zzaq zzaqVar) {
            long jZzGE = zzaqVar.zzGE();
            if (jZzGE == 0) {
                zzby.this.zzd(zzaqVar.zzGD(), zzby.this.zzqW.currentTimeMillis());
            } else if (jZzGE + 14400000 < zzby.this.zzqW.currentTimeMillis()) {
                zzby.this.zzq(zzaqVar.zzGD());
                zzbg.v("Giving up on failed hitId: " + zzaqVar.zzGD());
            }
        }
    }

    class zzb extends SQLiteOpenHelper {
        private boolean zzbjL;
        private long zzbjM;

        zzb(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
            this.zzbjM = 0L;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0048  */
        private boolean zza(String str, SQLiteDatabase sQLiteDatabase) throws Throwable {
            Cursor cursor;
            Cursor cursor2 = null;
            try {
                Cursor cursorQuery = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean zMoveToFirst = cursorQuery.moveToFirst();
                    if (cursorQuery == null) {
                        return zMoveToFirst;
                    }
                    cursorQuery.close();
                    return zMoveToFirst;
                } catch (SQLiteException e) {
                    cursor = cursorQuery;
                    try {
                        zzbg.zzaK("Error querying for table " + str);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return false;
                    } catch (Throwable th) {
                        cursor2 = cursor;
                        th = th;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursorQuery;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
            }
        }

        private void zzc(SQLiteDatabase sQLiteDatabase) {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM gtm_hits WHERE 0", null);
            HashSet hashSet = new HashSet();
            try {
                for (String str : cursorRawQuery.getColumnNames()) {
                    hashSet.add(str);
                }
                cursorRawQuery.close();
                if (!hashSet.remove("hit_id") || !hashSet.remove("hit_url") || !hashSet.remove("hit_time") || !hashSet.remove("hit_first_send_time")) {
                    throw new SQLiteException("Database column missing");
                }
                if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                }
            } catch (Throwable th) {
                cursorRawQuery.close();
                throw th;
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public SQLiteDatabase getWritableDatabase() {
            if (this.zzbjL && this.zzbjM + 3600000 > zzby.this.zzqW.currentTimeMillis()) {
                throw new SQLiteException("Database creation failed");
            }
            SQLiteDatabase writableDatabase = null;
            this.zzbjL = true;
            this.zzbjM = zzby.this.zzqW.currentTimeMillis();
            try {
                writableDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                zzby.this.mContext.getDatabasePath(zzby.this.zzbjH).delete();
            }
            if (writableDatabase == null) {
                writableDatabase = super.getWritableDatabase();
            }
            this.zzbjL = false;
            return writableDatabase;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase db) {
            zzal.zzbo(db.getPath());
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase db) {
            if (Build.VERSION.SDK_INT < 15) {
                Cursor cursorRawQuery = db.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    cursorRawQuery.moveToFirst();
                    cursorRawQuery.close();
                } catch (Throwable th) {
                    cursorRawQuery.close();
                    throw th;
                }
            }
            if (zza("gtm_hits", db)) {
                zzc(db);
            } else {
                db.execSQL(zzby.zzQR);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    zzby(zzav zzavVar, Context context) {
        this(zzavVar, context, "gtm_urls.db", 2000);
    }

    zzby(zzav zzavVar, Context context, String str, int i) {
        this.mContext = context.getApplicationContext();
        this.zzbjH = str;
        this.zzbjG = zzavVar;
        this.zzqW = zzmt.zzsc();
        this.zzbjE = new zzb(this.mContext, this.zzbjH);
        this.zzbjF = new zzcx(this.mContext, new zza());
        this.zzbjI = 0L;
        this.zzbjJ = i;
    }

    private void zzGQ() throws Throwable {
        int iZzGR = (zzGR() - this.zzbjJ) + 1;
        if (iZzGR > 0) {
            List<String> listZzkl = zzkl(iZzGR);
            zzbg.v("Store full, deleting " + listZzkl.size() + " hits to make room.");
            zzf((String[]) listZzkl.toArray(new String[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzd(long j, long j2) {
        SQLiteDatabase sQLiteDatabaseZzgb = zzgb("Error opening database for getNumStoredHits.");
        if (sQLiteDatabaseZzgb == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_first_send_time", Long.valueOf(j2));
        try {
            sQLiteDatabaseZzgb.update("gtm_hits", contentValues, "hit_id=?", new String[]{String.valueOf(j)});
        } catch (SQLiteException e) {
            zzbg.zzaK("Error setting HIT_FIRST_DISPATCH_TIME for hitId: " + j);
            zzq(j);
        }
    }

    private SQLiteDatabase zzgb(String str) {
        try {
            return this.zzbjE.getWritableDatabase();
        } catch (SQLiteException e) {
            zzbg.zzaK(str);
            return null;
        }
    }

    private void zzh(long j, String str) {
        SQLiteDatabase sQLiteDatabaseZzgb = zzgb("Error opening database for putHit");
        if (sQLiteDatabaseZzgb == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_time", Long.valueOf(j));
        contentValues.put("hit_url", str);
        contentValues.put("hit_first_send_time", (Integer) 0);
        try {
            sQLiteDatabaseZzgb.insert("gtm_hits", null, contentValues);
            this.zzbjG.zzax(false);
        } catch (SQLiteException e) {
            zzbg.zzaK("Error storing hit");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzq(long j) {
        zzf(new String[]{String.valueOf(j)});
    }

    @Override // com.google.android.gms.tagmanager.zzau
    public void dispatch() throws Throwable {
        zzbg.v("GTM Dispatch running...");
        if (this.zzbjF.zzGw()) {
            List<zzaq> listZzkm = zzkm(40);
            if (listZzkm.isEmpty()) {
                zzbg.v("...nothing to dispatch");
                this.zzbjG.zzax(true);
            } else {
                this.zzbjF.zzE(listZzkm);
                if (zzGS() > 0) {
                    zzcu.zzHo().dispatch();
                }
            }
        }
    }

    int zzGR() {
        Cursor cursorRawQuery = null;
        int i = 0;
        SQLiteDatabase sQLiteDatabaseZzgb = zzgb("Error opening database for getNumStoredHits.");
        try {
            if (sQLiteDatabaseZzgb != null) {
                try {
                    cursorRawQuery = sQLiteDatabaseZzgb.rawQuery("SELECT COUNT(*) from gtm_hits", null);
                    i = cursorRawQuery.moveToFirst() ? (int) cursorRawQuery.getLong(0) : 0;
                } catch (SQLiteException e) {
                    zzbg.zzaK("Error getting numStoredHits");
                }
            }
            return i;
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0040  */
    int zzGS() throws Throwable {
        Cursor cursor;
        int count;
        Cursor cursor2 = null;
        SQLiteDatabase sQLiteDatabaseZzgb = zzgb("Error opening database for getNumStoredHits.");
        if (sQLiteDatabaseZzgb == null) {
            return 0;
        }
        try {
            Cursor cursorQuery = sQLiteDatabaseZzgb.query("gtm_hits", new String[]{"hit_id", "hit_first_send_time"}, "hit_first_send_time=0", null, null, null, null);
            try {
                count = cursorQuery.getCount();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (SQLiteException e) {
                cursor = cursorQuery;
                try {
                    zzbg.zzaK("Error getting num untried hits");
                    if (cursor != null) {
                        cursor.close();
                        count = 0;
                    } else {
                        count = 0;
                    }
                } catch (Throwable th) {
                    cursor2 = cursor;
                    th = th;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor2 = cursorQuery;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
        }
        return count;
    }

    void zzf(String[] strArr) {
        SQLiteDatabase sQLiteDatabaseZzgb;
        if (strArr == null || strArr.length == 0 || (sQLiteDatabaseZzgb = zzgb("Error opening database for deleteHits.")) == null) {
            return;
        }
        try {
            sQLiteDatabaseZzgb.delete("gtm_hits", String.format("HIT_ID in (%s)", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))), strArr);
            this.zzbjG.zzax(zzGR() == 0);
        } catch (SQLiteException e) {
            zzbg.zzaK("Error deleting hits");
        }
    }

    @Override // com.google.android.gms.tagmanager.zzau
    public void zzg(long j, String str) throws Throwable {
        zzjN();
        zzGQ();
        zzh(j, str);
    }

    int zzjN() {
        long jCurrentTimeMillis = this.zzqW.currentTimeMillis();
        if (jCurrentTimeMillis <= this.zzbjI + 86400000) {
            return 0;
        }
        this.zzbjI = jCurrentTimeMillis;
        SQLiteDatabase sQLiteDatabaseZzgb = zzgb("Error opening database for deleteStaleHits.");
        if (sQLiteDatabaseZzgb == null) {
            return 0;
        }
        int iDelete = sQLiteDatabaseZzgb.delete("gtm_hits", "HIT_TIME < ?", new String[]{Long.toString(this.zzqW.currentTimeMillis() - 2592000000L)});
        this.zzbjG.zzax(zzGR() == 0);
        return iDelete;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0082  */
    List<String> zzkl(int i) throws Throwable {
        Cursor cursorQuery;
        ArrayList arrayList = new ArrayList();
        if (i <= 0) {
            zzbg.zzaK("Invalid maxHits specified. Skipping");
            return arrayList;
        }
        SQLiteDatabase sQLiteDatabaseZzgb = zzgb("Error opening database for peekHitIds.");
        if (sQLiteDatabaseZzgb == null) {
            return arrayList;
        }
        try {
            cursorQuery = sQLiteDatabaseZzgb.query("gtm_hits", new String[]{"hit_id"}, null, null, null, null, String.format("%s ASC", "hit_id"), Integer.toString(i));
            try {
                try {
                    if (cursorQuery.moveToFirst()) {
                        do {
                            arrayList.add(String.valueOf(cursorQuery.getLong(0)));
                        } while (cursorQuery.moveToNext());
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (SQLiteException e) {
                    e = e;
                    zzbg.zzaK("Error in peekHits fetching hitIds: " + e.getMessage());
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00f2  */
    public List<zzaq> zzkm(int i) throws Throwable {
        SQLiteException sQLiteException;
        Cursor cursor;
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        SQLiteDatabase sQLiteDatabaseZzgb = zzgb("Error opening database for peekHits");
        if (sQLiteDatabaseZzgb == null) {
            return arrayList2;
        }
        Cursor cursor2 = null;
        try {
            Cursor cursorQuery = sQLiteDatabaseZzgb.query("gtm_hits", new String[]{"hit_id", "hit_time", "hit_first_send_time"}, null, null, null, null, String.format("%s ASC", "hit_id"), Integer.toString(i));
            try {
                try {
                    ArrayList<zzaq> arrayList3 = new ArrayList();
                    try {
                        if (cursorQuery.moveToFirst()) {
                            do {
                                arrayList3.add(new zzaq(cursorQuery.getLong(0), cursorQuery.getLong(1), cursorQuery.getLong(2)));
                            } while (cursorQuery.moveToNext());
                        }
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        try {
                            try {
                                Cursor cursorQuery2 = sQLiteDatabaseZzgb.query("gtm_hits", new String[]{"hit_id", "hit_url"}, null, null, null, null, String.format("%s ASC", "hit_id"), Integer.toString(i));
                                try {
                                    if (cursorQuery2.moveToFirst()) {
                                        int i2 = 0;
                                        while (true) {
                                            if (((SQLiteCursor) cursorQuery2).getWindow().getNumRows() > 0) {
                                                ((zzaq) arrayList3.get(i2)).zzgf(cursorQuery2.getString(1));
                                            } else {
                                                zzbg.zzaK(String.format("HitString for hitId %d too large.  Hit will be deleted.", Long.valueOf(((zzaq) arrayList3.get(i2)).zzGD())));
                                            }
                                            int i3 = i2 + 1;
                                            if (!cursorQuery2.moveToNext()) {
                                                break;
                                            }
                                            i2 = i3;
                                        }
                                    }
                                    if (cursorQuery2 != null) {
                                        cursorQuery2.close();
                                    }
                                    return arrayList3;
                                } catch (SQLiteException e) {
                                    e = e;
                                    cursorQuery = cursorQuery2;
                                    zzbg.zzaK("Error in peekHits fetching hit url: " + e.getMessage());
                                    ArrayList arrayList4 = new ArrayList();
                                    boolean z = false;
                                    for (zzaq zzaqVar : arrayList3) {
                                        if (TextUtils.isEmpty(zzaqVar.zzGF())) {
                                            if (z) {
                                                break;
                                            }
                                            z = true;
                                        }
                                        arrayList4.add(zzaqVar);
                                    }
                                    if (cursorQuery != null) {
                                        cursorQuery.close();
                                    }
                                    return arrayList4;
                                } catch (Throwable th) {
                                    th = th;
                                    cursorQuery = cursorQuery2;
                                    if (cursorQuery != null) {
                                        cursorQuery.close();
                                    }
                                    throw th;
                                }
                            } catch (SQLiteException e2) {
                                e = e2;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (SQLiteException e3) {
                        sQLiteException = e3;
                        cursor = cursorQuery;
                        arrayList = arrayList3;
                        try {
                            zzbg.zzaK("Error in peekHits fetching hitIds: " + sQLiteException.getMessage());
                            if (cursor == null) {
                                return arrayList;
                            }
                            cursor.close();
                            return arrayList;
                        } catch (Throwable th3) {
                            th = th3;
                            cursor2 = cursor;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            throw th;
                        }
                    }
                } catch (SQLiteException e4) {
                    sQLiteException = e4;
                    cursor = cursorQuery;
                    arrayList = arrayList2;
                }
            } catch (Throwable th4) {
                th = th4;
                cursor2 = cursorQuery;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e5) {
            sQLiteException = e5;
            cursor = null;
            arrayList = arrayList2;
        } catch (Throwable th5) {
            th = th5;
        }
    }
}
