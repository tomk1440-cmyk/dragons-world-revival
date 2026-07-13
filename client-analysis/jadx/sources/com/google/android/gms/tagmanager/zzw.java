package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzmt;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
class zzw implements DataLayer.zzc {
    private static final String zzbiB = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", "datalayer", "ID", "key", "value", "expires");
    private final Context mContext;
    private final Executor zzbiC;
    private zza zzbiD;
    private int zzbiE;
    private zzmq zzqW;

    class zza extends SQLiteOpenHelper {
        zza(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
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
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
            HashSet hashSet = new HashSet();
            try {
                for (String str : cursorRawQuery.getColumnNames()) {
                    hashSet.add(str);
                }
                cursorRawQuery.close();
                if (!hashSet.remove("key") || !hashSet.remove("value") || !hashSet.remove("ID") || !hashSet.remove("expires")) {
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
            SQLiteDatabase writableDatabase = null;
            try {
                writableDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                zzw.this.mContext.getDatabasePath("google_tagmanager.db").delete();
            }
            return writableDatabase == null ? super.getWritableDatabase() : writableDatabase;
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
            if (zza("datalayer", db)) {
                zzc(db);
            } else {
                db.execSQL(zzw.zzbiB);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    private static class zzb {
        final byte[] zzbiK;
        final String zzvs;

        zzb(String str, byte[] bArr) {
            this.zzvs = str;
            this.zzbiK = bArr;
        }

        public String toString() {
            return "KeyAndSerialized: key = " + this.zzvs + " serialized hash = " + Arrays.hashCode(this.zzbiK);
        }
    }

    public zzw(Context context) {
        this(context, zzmt.zzsc(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
    }

    zzw(Context context, zzmq zzmqVar, String str, int i, Executor executor) {
        this.mContext = context;
        this.zzqW = zzmqVar;
        this.zzbiE = i;
        this.zzbiC = executor;
        this.zzbiD = new zza(this.mContext, str);
    }

    private List<DataLayer.zza> zzC(List<zzb> list) {
        ArrayList arrayList = new ArrayList();
        for (zzb zzbVar : list) {
            arrayList.add(new DataLayer.zza(zzbVar.zzvs, zzw(zzbVar.zzbiK)));
        }
        return arrayList;
    }

    private List<zzb> zzD(List<DataLayer.zza> list) {
        ArrayList arrayList = new ArrayList();
        for (DataLayer.zza zzaVar : list) {
            arrayList.add(new zzb(zzaVar.zzvs, zzJ(zzaVar.zzNc)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<DataLayer.zza> zzGr() {
        try {
            zzal(this.zzqW.currentTimeMillis());
            return zzC(zzGs());
        } finally {
            zzGu();
        }
    }

    private List<zzb> zzGs() {
        SQLiteDatabase sQLiteDatabaseZzgb = zzgb("Error opening database for loadSerialized.");
        ArrayList arrayList = new ArrayList();
        if (sQLiteDatabaseZzgb == null) {
            return arrayList;
        }
        Cursor cursorQuery = sQLiteDatabaseZzgb.query("datalayer", new String[]{"key", "value"}, null, null, null, null, "ID", null);
        while (cursorQuery.moveToNext()) {
            try {
                arrayList.add(new zzb(cursorQuery.getString(0), cursorQuery.getBlob(1)));
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }
        cursorQuery.close();
        return arrayList;
    }

    private int zzGt() {
        Cursor cursorRawQuery = null;
        int i = 0;
        SQLiteDatabase sQLiteDatabaseZzgb = zzgb("Error opening database for getNumStoredEntries.");
        try {
            if (sQLiteDatabaseZzgb != null) {
                try {
                    cursorRawQuery = sQLiteDatabaseZzgb.rawQuery("SELECT COUNT(*) from datalayer", null);
                    i = cursorRawQuery.moveToFirst() ? (int) cursorRawQuery.getLong(0) : 0;
                } catch (SQLiteException e) {
                    zzbg.zzaK("Error getting numStoredEntries");
                }
            }
            return i;
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    private void zzGu() {
        try {
            this.zzbiD.close();
        } catch (SQLiteException e) {
        }
    }

    private byte[] zzJ(Object obj) throws Throwable {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        byte[] byteArray = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                byteArray = byteArrayOutputStream.toByteArray();
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e) {
                    }
                }
                byteArrayOutputStream.close();
            } catch (IOException e2) {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th = th2;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e4) {
                        throw th;
                    }
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e5) {
            objectOutputStream = null;
        } catch (Throwable th3) {
            objectOutputStream = null;
            th = th3;
        }
        return byteArray;
    }

    private void zzal(long j) {
        SQLiteDatabase sQLiteDatabaseZzgb = zzgb("Error opening database for deleteOlderThan.");
        if (sQLiteDatabaseZzgb == null) {
            return;
        }
        try {
            zzbg.v("Deleted " + sQLiteDatabaseZzgb.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)}) + " expired items");
        } catch (SQLiteException e) {
            zzbg.zzaK("Error deleting old entries.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void zzb(List<zzb> list, long j) {
        try {
            long jCurrentTimeMillis = this.zzqW.currentTimeMillis();
            zzal(jCurrentTimeMillis);
            zzkf(list.size());
            zzc(list, jCurrentTimeMillis + j);
            zzGu();
        } catch (Throwable th) {
            zzGu();
            throw th;
        }
    }

    private void zzc(List<zzb> list, long j) {
        SQLiteDatabase sQLiteDatabaseZzgb = zzgb("Error opening database for writeEntryToDatabase.");
        if (sQLiteDatabaseZzgb == null) {
            return;
        }
        for (zzb zzbVar : list) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("expires", Long.valueOf(j));
            contentValues.put("key", zzbVar.zzvs);
            contentValues.put("value", zzbVar.zzbiK);
            sQLiteDatabaseZzgb.insert("datalayer", null, contentValues);
        }
    }

    private void zze(String[] strArr) {
        SQLiteDatabase sQLiteDatabaseZzgb;
        if (strArr == null || strArr.length == 0 || (sQLiteDatabaseZzgb = zzgb("Error opening database for deleteEntries.")) == null) {
            return;
        }
        try {
            sQLiteDatabaseZzgb.delete("datalayer", String.format("%s in (%s)", "ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))), strArr);
        } catch (SQLiteException e) {
            zzbg.zzaK("Error deleting entries " + Arrays.toString(strArr));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzga(String str) {
        SQLiteDatabase sQLiteDatabaseZzgb = zzgb("Error opening database for clearKeysWithPrefix.");
        try {
            if (sQLiteDatabaseZzgb == null) {
                return;
            }
            zzbg.v("Cleared " + sQLiteDatabaseZzgb.delete("datalayer", "key = ? OR key LIKE ?", new String[]{str, str + ".%"}) + " items");
        } catch (SQLiteException e) {
            zzbg.zzaK("Error deleting entries with key prefix: " + str + " (" + e + ").");
        } finally {
            zzGu();
        }
    }

    private SQLiteDatabase zzgb(String str) {
        try {
            return this.zzbiD.getWritableDatabase();
        } catch (SQLiteException e) {
            zzbg.zzaK(str);
            return null;
        }
    }

    private void zzkf(int i) throws Throwable {
        int iZzGt = (zzGt() - this.zzbiE) + i;
        if (iZzGt > 0) {
            List<String> listZzkg = zzkg(iZzGt);
            zzbg.zzaJ("DataLayer store full, deleting " + listZzkg.size() + " entries to make room.");
            zze((String[]) listZzkg.toArray(new String[0]));
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0082  */
    private List<String> zzkg(int i) throws Throwable {
        Cursor cursorQuery;
        ArrayList arrayList = new ArrayList();
        if (i <= 0) {
            zzbg.zzaK("Invalid maxEntries specified. Skipping.");
            return arrayList;
        }
        SQLiteDatabase sQLiteDatabaseZzgb = zzgb("Error opening database for peekEntryIds.");
        if (sQLiteDatabaseZzgb == null) {
            return arrayList;
        }
        try {
            cursorQuery = sQLiteDatabaseZzgb.query("datalayer", new String[]{"ID"}, null, null, null, null, String.format("%s ASC", "ID"), Integer.toString(i));
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
                    zzbg.zzaK("Error in peekEntries fetching entryIds: " + e.getMessage());
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

    private Object zzw(byte[] bArr) throws Throwable {
        ObjectInputStream objectInputStream;
        Throwable th;
        Object object = null;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                object = objectInputStream.readObject();
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e) {
                    }
                }
                byteArrayInputStream.close();
            } catch (IOException e2) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayInputStream.close();
            } catch (ClassNotFoundException e4) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e5) {
                    }
                }
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th = th2;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e6) {
                        throw th;
                    }
                }
                byteArrayInputStream.close();
                throw th;
            }
        } catch (IOException e7) {
            objectInputStream = null;
        } catch (ClassNotFoundException e8) {
            objectInputStream = null;
        } catch (Throwable th3) {
            objectInputStream = null;
            th = th3;
        }
        return object;
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.zzc
    public void zza(final DataLayer.zzc.zza zzaVar) {
        this.zzbiC.execute(new Runnable() { // from class: com.google.android.gms.tagmanager.zzw.2
            @Override // java.lang.Runnable
            public void run() {
                zzaVar.zzB(zzw.this.zzGr());
            }
        });
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.zzc
    public void zza(List<DataLayer.zza> list, final long j) {
        final List<zzb> listZzD = zzD(list);
        this.zzbiC.execute(new Runnable() { // from class: com.google.android.gms.tagmanager.zzw.1
            @Override // java.lang.Runnable
            public void run() {
                zzw.this.zzb(listZzD, j);
            }
        });
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.zzc
    public void zzfZ(final String str) {
        this.zzbiC.execute(new Runnable() { // from class: com.google.android.gms.tagmanager.zzw.3
            @Override // java.lang.Runnable
            public void run() {
                zzw.this.zzga(str);
            }
        });
    }
}
