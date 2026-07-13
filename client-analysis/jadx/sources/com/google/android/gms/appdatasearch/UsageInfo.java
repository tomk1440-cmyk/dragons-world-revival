package com.google.android.gms.appdatasearch;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzpm;
import com.google.android.gms.internal.zzsu;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes.dex */
public class UsageInfo implements SafeParcelable {
    public static final zzj CREATOR = new zzj();
    final int mVersionCode;
    final DocumentId zzUs;
    final long zzUt;
    int zzUu;
    final DocumentContents zzUv;
    final boolean zzUw;
    int zzUx;
    int zzUy;
    public final String zzvp;

    public static final class zza {
        private String zzOJ;
        private DocumentId zzUs;
        private DocumentContents zzUv;
        private long zzUt = -1;
        private int zzUu = -1;
        private int zzUx = -1;
        private boolean zzUw = false;
        private int zzUy = 0;

        public zza zzO(boolean z) {
            this.zzUw = z;
            return this;
        }

        public zza zza(DocumentContents documentContents) {
            this.zzUv = documentContents;
            return this;
        }

        public zza zza(DocumentId documentId) {
            this.zzUs = documentId;
            return this;
        }

        public zza zzar(int i) {
            this.zzUu = i;
            return this;
        }

        public zza zzas(int i) {
            this.zzUy = i;
            return this;
        }

        public UsageInfo zzmi() {
            return new UsageInfo(this.zzUs, this.zzUt, this.zzUu, this.zzOJ, this.zzUv, this.zzUw, this.zzUx, this.zzUy);
        }

        public zza zzw(long j) {
            this.zzUt = j;
            return this;
        }
    }

    UsageInfo(int versionCode, DocumentId documentId, long timestamp, int usageType, String query, DocumentContents document, boolean isDeviceOnly, int taskPosition, int eventStatus) {
        this.mVersionCode = versionCode;
        this.zzUs = documentId;
        this.zzUt = timestamp;
        this.zzUu = usageType;
        this.zzvp = query;
        this.zzUv = document;
        this.zzUw = isDeviceOnly;
        this.zzUx = taskPosition;
        this.zzUy = eventStatus;
    }

    private UsageInfo(DocumentId documentId, long timestampMs, int usageType, String query, DocumentContents document, boolean isDeviceOnly, int taskPosition, int eventStatus) {
        this(1, documentId, timestampMs, usageType, query, document, isDeviceOnly, taskPosition, eventStatus);
    }

    public UsageInfo(String packageName, Intent viewIntent, String title, Uri webUrl, String schemaOrgType, List<AppIndexApi.AppIndexingLink> outLinks, int eventStatus) {
        this(1, zza(packageName, viewIntent), System.currentTimeMillis(), 0, (String) null, zza(viewIntent, title, webUrl, schemaOrgType, outLinks).zzme(), false, -1, eventStatus);
    }

    public static DocumentContents.zza zza(Intent intent, String str, Uri uri, String str2, List<AppIndexApi.AppIndexingLink> list) {
        String string;
        DocumentContents.zza zzaVar = new DocumentContents.zza();
        zzaVar.zza(zzbD(str));
        if (uri != null) {
            zzaVar.zza(zzi(uri));
        }
        if (list != null) {
            zzaVar.zza(zzs(list));
        }
        String action = intent.getAction();
        if (action != null) {
            zzaVar.zza(zzo("intent_action", action));
        }
        String dataString = intent.getDataString();
        if (dataString != null) {
            zzaVar.zza(zzo("intent_data", dataString));
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            zzaVar.zza(zzo("intent_activity", component.getClassName()));
        }
        Bundle extras = intent.getExtras();
        if (extras != null && (string = extras.getString("intent_extra_data_key")) != null) {
            zzaVar.zza(zzo("intent_extra_data", string));
        }
        return zzaVar.zzbz(str2).zzL(true);
    }

    public static DocumentId zza(String str, Intent intent) {
        return zzn(str, zzg(intent));
    }

    private static DocumentSection zzbD(String str) {
        return new DocumentSection(str, new RegisterSectionInfo.zza("title").zzap(1).zzN(true).zzbC("name").zzmh(), "text1");
    }

    private static String zzg(Intent intent) {
        String uri = intent.toUri(1);
        CRC32 crc32 = new CRC32();
        try {
            crc32.update(uri.getBytes("UTF-8"));
            return Long.toHexString(crc32.getValue());
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }

    private static DocumentSection zzi(Uri uri) {
        return new DocumentSection(uri.toString(), new RegisterSectionInfo.zza("web_url").zzap(4).zzM(true).zzbC("url").zzmh());
    }

    private static DocumentId zzn(String str, String str2) {
        return new DocumentId(str, "", str2);
    }

    private static DocumentSection zzo(String str, String str2) {
        return new DocumentSection(str2, new RegisterSectionInfo.zza(str).zzM(true).zzmh(), str);
    }

    private static DocumentSection zzs(List<AppIndexApi.AppIndexingLink> list) {
        zzpm.zza zzaVar = new zzpm.zza();
        zzpm.zza.C0164zza[] c0164zzaArr = new zzpm.zza.C0164zza[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= c0164zzaArr.length) {
                zzaVar.zzaMo = c0164zzaArr;
                return new DocumentSection(zzsu.toByteArray(zzaVar), new RegisterSectionInfo.zza("outlinks").zzM(true).zzbC(".private:outLinks").zzbB("blob").zzmh());
            }
            c0164zzaArr[i2] = new zzpm.zza.C0164zza();
            AppIndexApi.AppIndexingLink appIndexingLink = list.get(i2);
            c0164zzaArr[i2].zzaMq = appIndexingLink.appIndexingUrl.toString();
            c0164zzaArr[i2].viewId = appIndexingLink.viewId;
            if (appIndexingLink.webUrl != null) {
                c0164zzaArr[i2].zzaMr = appIndexingLink.webUrl.toString();
            }
            i = i2 + 1;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzj zzjVar = CREATOR;
        return 0;
    }

    public String toString() {
        return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d, status=%d]", this.zzUs, Long.valueOf(this.zzUt), Integer.valueOf(this.zzUu), Integer.valueOf(this.zzUy));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzj zzjVar = CREATOR;
        zzj.zza(this, dest, flags);
    }
}
