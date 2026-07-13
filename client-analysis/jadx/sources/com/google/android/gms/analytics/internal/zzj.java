package com.google.android.gms.analytics.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.internal.zzmz;
import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class zzj extends zzd implements Closeable {
    private static final String zzQR = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", "hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id");
    private static final String zzQS = String.format("SELECT MAX(%s) FROM %s WHERE 1;", "hit_time", "hits2");
    private final zza zzQT;
    private final zzaj zzQU;
    private final zzaj zzQV;

    class zza extends SQLiteOpenHelper {
        zza(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        }

        private void zza(SQLiteDatabase sQLiteDatabase) {
            Set<String> setZzb = zzb(sQLiteDatabase, "hits2");
            for (String str : new String[]{"hit_id", "hit_string", "hit_time", "hit_url"}) {
                if (!setZzb.remove(str)) {
                    throw new SQLiteException("Database hits2 is missing required column: " + str);
                }
            }
            boolean z = setZzb.remove("hit_app_id") ? false : true;
            if (!setZzb.isEmpty()) {
                throw new SQLiteException("Database hits2 has extra columns");
            }
            if (z) {
                sQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id INTEGER");
            }
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0039  */
        private boolean zza(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
            Cursor cursorQuery;
            Cursor cursor = null;
            try {
                cursorQuery = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    try {
                        boolean zMoveToFirst = cursorQuery.moveToFirst();
                        if (cursorQuery == null) {
                            return zMoveToFirst;
                        }
                        cursorQuery.close();
                        return zMoveToFirst;
                    } catch (SQLiteException e) {
                        e = e;
                        zzj.this.zzc("Error querying for table", str, e);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursorQuery = null;
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }

        private Set<String> zzb(SQLiteDatabase sQLiteDatabase, String str) {
            HashSet hashSet = new HashSet();
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM " + str + " LIMIT 0", null);
            try {
                for (String str2 : cursorRawQuery.getColumnNames()) {
                    hashSet.add(str2);
                }
                cursorRawQuery.close();
                return hashSet;
            } catch (Throwable th) {
                cursorRawQuery.close();
                throw th;
            }
        }

        private void zzb(SQLiteDatabase sQLiteDatabase) {
            Set<String> setZzb = zzb(sQLiteDatabase, "properties");
            for (String str : new String[]{"app_uid", "cid", "tid", NativeProtocol.WEB_DIALOG_PARAMS, "adid", "hits_count"}) {
                if (!setZzb.remove(str)) {
                    throw new SQLiteException("Database properties is missing required column: " + str);
                }
            }
            if (!setZzb.isEmpty()) {
                throw new SQLiteException("Database properties table has extra columns");
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public SQLiteDatabase getWritableDatabase() {
            if (!zzj.this.zzQV.zzv(3600000L)) {
                throw new SQLiteException("Database open failed");
            }
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e) {
                zzj.this.zzQV.start();
                zzj.this.zzbh("Opening the database failed, dropping the table and recreating it");
                zzj.this.getContext().getDatabasePath(zzj.this.zzjQ()).delete();
                try {
                    SQLiteDatabase writableDatabase = super.getWritableDatabase();
                    zzj.this.zzQV.clear();
                    return writableDatabase;
                } catch (SQLiteException e2) {
                    zzj.this.zze("Failed to open freshly created database", e2);
                    throw e2;
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase database) {
            zzx.zzbo(database.getPath());
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase database) {
            if (Build.VERSION.SDK_INT < 15) {
                Cursor cursorRawQuery = database.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    cursorRawQuery.moveToFirst();
                    cursorRawQuery.close();
                } catch (Throwable th) {
                    cursorRawQuery.close();
                    throw th;
                }
            }
            if (zza(database, "hits2")) {
                zza(database);
            } else {
                database.execSQL(zzj.zzQR);
            }
            if (zza(database, "properties")) {
                zzb(database);
            } else {
                database.execSQL("CREATE TABLE IF NOT EXISTS properties ( app_uid INTEGER NOT NULL, cid TEXT NOT NULL, tid TEXT NOT NULL, params TEXT NOT NULL, adid INTEGER NOT NULL, hits_count INTEGER NOT NULL, PRIMARY KEY (app_uid, cid, tid)) ;");
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        }
    }

    zzj(zzf zzfVar) {
        super(zzfVar);
        this.zzQU = new zzaj(zzjl());
        this.zzQV = new zzaj(zzjl());
        this.zzQT = new zza(zzfVar.getContext(), zzjQ());
    }

    private static String zzI(Map<String, String> map) {
        com.google.android.gms.common.internal.zzx.zzz(map);
        Uri.Builder builder = new Uri.Builder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builder.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        String encodedQuery = builder.build().getEncodedQuery();
        return encodedQuery == null ? "" : encodedQuery;
    }

    private long zza(String str, String[] strArr, long j) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = getWritableDatabase().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    j = cursorRawQuery.getLong(0);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                } else if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return j;
            } catch (SQLiteException e) {
                zzd("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    private long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = getWritableDatabase().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j = cursorRawQuery.getLong(0);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return j;
            } catch (SQLiteException e) {
                zzd("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private String zzd(zzab zzabVar) {
        return zzabVar.zzlt() ? zzjn().zzkF() : zzjn().zzkG();
    }

    private static String zze(zzab zzabVar) {
        com.google.android.gms.common.internal.zzx.zzz(zzabVar);
        Uri.Builder builder = new Uri.Builder();
        for (Map.Entry<String, String> entry : zzabVar.zzn().entrySet()) {
            String key = entry.getKey();
            if (!"ht".equals(key) && !"qt".equals(key) && !"AppUID".equals(key)) {
                builder.appendQueryParameter(key, entry.getValue());
            }
        }
        String encodedQuery = builder.build().getEncodedQuery();
        return encodedQuery == null ? "" : encodedQuery;
    }

    private void zzjP() throws Throwable {
        int iZzkP = zzjn().zzkP();
        long jZzjG = zzjG();
        if (jZzjG > iZzkP - 1) {
            List<Long> listZzo = zzo((jZzjG - ((long) iZzkP)) + 1);
            zzd("Store full, deleting hits to make room, count", Integer.valueOf(listZzo.size()));
            zzo(listZzo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String zzjQ() {
        if (zzjn().zzkr() && !zzjn().zzks()) {
            return zzjn().zzkS();
        }
        return zzjn().zzkR();
    }

    public void beginTransaction() {
        zzjv();
        getWritableDatabase().beginTransaction();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.zzQT.close();
        } catch (SQLiteException e) {
            zze("Sql error closing database", e);
        } catch (IllegalStateException e2) {
            zze("Error closing database", e2);
        }
    }

    public void endTransaction() {
        zzjv();
        getWritableDatabase().endTransaction();
    }

    SQLiteDatabase getWritableDatabase() {
        try {
            return this.zzQT.getWritableDatabase();
        } catch (SQLiteException e) {
            zzd("Error opening database", e);
            throw e;
        }
    }

    boolean isEmpty() {
        return zzjG() == 0;
    }

    public void setTransactionSuccessful() {
        zzjv();
        getWritableDatabase().setTransactionSuccessful();
    }

    public long zza(long j, String str, String str2) {
        com.google.android.gms.common.internal.zzx.zzcM(str);
        com.google.android.gms.common.internal.zzx.zzcM(str2);
        zzjv();
        zzjk();
        return zza("SELECT hits_count FROM properties WHERE app_uid=? AND cid=? AND tid=?", new String[]{String.valueOf(j), str, str2}, 0L);
    }

    public void zza(long j, String str) {
        com.google.android.gms.common.internal.zzx.zzcM(str);
        zzjv();
        zzjk();
        int iDelete = getWritableDatabase().delete("properties", "app_uid=? AND cid<>?", new String[]{String.valueOf(j), str});
        if (iDelete > 0) {
            zza("Deleted property records", Integer.valueOf(iDelete));
        }
    }

    public void zzb(zzh zzhVar) {
        com.google.android.gms.common.internal.zzx.zzz(zzhVar);
        zzjv();
        zzjk();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        String strZzI = zzI(zzhVar.zzn());
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_uid", Long.valueOf(zzhVar.zzjD()));
        contentValues.put("cid", zzhVar.getClientId());
        contentValues.put("tid", zzhVar.zzjE());
        contentValues.put("adid", Integer.valueOf(zzhVar.zzjF() ? 1 : 0));
        contentValues.put("hits_count", Long.valueOf(zzhVar.zzjG()));
        contentValues.put(NativeProtocol.WEB_DIALOG_PARAMS, strZzI);
        try {
            if (writableDatabase.insertWithOnConflict("properties", null, contentValues, 5) == -1) {
                zzbh("Failed to insert/update a property (got -1)");
            }
        } catch (SQLiteException e) {
            zze("Error storing a property", e);
        }
    }

    Map<String, String> zzbi(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            if (!str.startsWith("?")) {
                str = "?" + str;
            }
            return zzmz.zza(new URI(str), "UTF-8");
        } catch (URISyntaxException e) {
            zze("Error parsing hit parameters", e);
            return new HashMap(0);
        }
    }

    Map<String, String> zzbj(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            return zzmz.zza(new URI("?" + str), "UTF-8");
        } catch (URISyntaxException e) {
            zze("Error parsing property parameters", e);
            return new HashMap(0);
        }
    }

    public void zzc(zzab zzabVar) throws Throwable {
        com.google.android.gms.common.internal.zzx.zzz(zzabVar);
        zzjk();
        zzjv();
        String strZze = zze(zzabVar);
        if (strZze.length() > 8192) {
            zzjm().zza(zzabVar, "Hit length exceeds the maximum allowed size");
            return;
        }
        zzjP();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_string", strZze);
        contentValues.put("hit_time", Long.valueOf(zzabVar.zzlr()));
        contentValues.put("hit_app_id", Integer.valueOf(zzabVar.zzlp()));
        contentValues.put("hit_url", zzd(zzabVar));
        try {
            long jInsert = writableDatabase.insert("hits2", null, contentValues);
            if (jInsert == -1) {
                zzbh("Failed to insert a hit (got -1)");
            } else {
                zzb("Hit saved to database. db-id, hit", Long.valueOf(jInsert), zzabVar);
            }
        } catch (SQLiteException e) {
            zze("Error storing a hit", e);
        }
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void zziJ() {
    }

    public long zzjG() {
        zzjk();
        zzjv();
        return zzb("SELECT COUNT(*) FROM hits2", (String[]) null);
    }

    public void zzjL() {
        zzjk();
        zzjv();
        getWritableDatabase().delete("hits2", null, null);
    }

    public void zzjM() {
        zzjk();
        zzjv();
        getWritableDatabase().delete("properties", null, null);
    }

    public int zzjN() {
        zzjk();
        zzjv();
        if (!this.zzQU.zzv(86400000L)) {
            return 0;
        }
        this.zzQU.start();
        zzbd("Deleting stale hits (if any)");
        int iDelete = getWritableDatabase().delete("hits2", "hit_time < ?", new String[]{Long.toString(zzjl().currentTimeMillis() - 2592000000L)});
        zza("Deleted stale hits, count", Integer.valueOf(iDelete));
        return iDelete;
    }

    public long zzjO() {
        zzjk();
        zzjv();
        return zza(zzQS, (String[]) null, 0L);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x006e  */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0073: MOVE (r10 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:25:0x0073 */
    public List<Long> zzo(long j) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor;
        Cursor cursor2 = null;
        zzjk();
        zzjv();
        if (j <= 0) {
            return Collections.emptyList();
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ArrayList arrayList = new ArrayList();
        try {
            try {
                cursorQuery = writableDatabase.query("hits2", new String[]{"hit_id"}, null, null, null, null, String.format("%s ASC", "hit_id"), Long.toString(j));
                try {
                    if (cursorQuery.moveToFirst()) {
                        do {
                            arrayList.add(Long.valueOf(cursorQuery.getLong(0)));
                        } while (cursorQuery.moveToNext());
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (SQLiteException e) {
                    e = e;
                    zzd("Error selecting hit ids", e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
        return arrayList;
    }

    public void zzo(List<Long> list) {
        com.google.android.gms.common.internal.zzx.zzz(list);
        zzjk();
        zzjv();
        if (list.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder("hit_id");
        sb.append(" in (");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                sb.append(")");
                String string = sb.toString();
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    zza("Deleting dispatched hits. count", Integer.valueOf(list.size()));
                    int iDelete = writableDatabase.delete("hits2", string, null);
                    if (iDelete != list.size()) {
                        zzb("Deleted fewer hits then expected", Integer.valueOf(list.size()), Integer.valueOf(iDelete), string);
                        return;
                    }
                    return;
                } catch (SQLiteException e) {
                    zze("Error deleting hits", e);
                    throw e;
                }
            }
            Long l = list.get(i2);
            if (l == null || l.longValue() == 0) {
                throw new SQLiteException("Invalid hit id");
            }
            if (i2 > 0) {
                sb.append(",");
            }
            sb.append(l);
            i = i2 + 1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x009e  */
    public List<zzab> zzp(long j) {
        Cursor cursor;
        Cursor cursor2 = null;
        com.google.android.gms.common.internal.zzx.zzac(j >= 0);
        zzjk();
        zzjv();
        try {
            try {
                Cursor cursorQuery = getWritableDatabase().query("hits2", new String[]{"hit_id", "hit_time", "hit_string", "hit_url", "hit_app_id"}, null, null, null, null, String.format("%s ASC", "hit_id"), Long.toString(j));
                try {
                    ArrayList arrayList = new ArrayList();
                    if (cursorQuery.moveToFirst()) {
                        do {
                            arrayList.add(new zzab(this, zzbi(cursorQuery.getString(2)), cursorQuery.getLong(1), zzam.zzbx(cursorQuery.getString(3)), cursorQuery.getLong(0), cursorQuery.getInt(4)));
                        } while (cursorQuery.moveToNext());
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return arrayList;
                } catch (SQLiteException e) {
                    e = e;
                    cursor = cursorQuery;
                    try {
                        zze("Error loading hits from the database", e);
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursor = null;
        }
    }

    public void zzq(long j) {
        zzjk();
        zzjv();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Long.valueOf(j));
        zza("Deleting hit, id", Long.valueOf(j));
        zzo(arrayList);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00b4  */
    public List<zzh> zzr(long j) throws Throwable {
        Cursor cursor;
        zzjv();
        zzjk();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor cursor2 = null;
        try {
            try {
                String[] strArr = {"cid", "tid", "adid", "hits_count", NativeProtocol.WEB_DIALOG_PARAMS};
                int iZzkQ = zzjn().zzkQ();
                Cursor cursorQuery = writableDatabase.query("properties", strArr, "app_uid=?", new String[]{String.valueOf(j)}, null, null, null, String.valueOf(iZzkQ));
                try {
                    ArrayList arrayList = new ArrayList();
                    if (cursorQuery.moveToFirst()) {
                        do {
                            String string = cursorQuery.getString(0);
                            String string2 = cursorQuery.getString(1);
                            boolean z = cursorQuery.getInt(2) != 0;
                            long j2 = cursorQuery.getInt(3);
                            Map<String, String> mapZzbj = zzbj(cursorQuery.getString(4));
                            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                                zzc("Read property with empty client id or tracker id", string, string2);
                            } else {
                                arrayList.add(new zzh(j, string, string2, z, j2, mapZzbj));
                            }
                        } while (cursorQuery.moveToNext());
                    }
                    if (arrayList.size() >= iZzkQ) {
                        zzbg("Sending hits to too many properties. Campaign report might be incorrect");
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return arrayList;
                } catch (SQLiteException e) {
                    e = e;
                    cursor = cursorQuery;
                    try {
                        zze("Error loading hits from the database", e);
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursor = null;
            }
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }
}
