package com.google.android.gms.measurement.internal;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzqb;
import com.google.android.gms.internal.zzsn;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class zzaj extends zzy {
    zzaj(zzw zzwVar) {
        super(zzwVar);
    }

    public static boolean zzI(Bundle bundle) {
        return bundle.getLong("_c") == 1;
    }

    public static boolean zzQ(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    private Object zza(int i, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Float)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1L : 0L);
        }
        if (obj instanceof Double) {
            return Float.valueOf((float) ((Double) obj).doubleValue());
        }
        if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
            return null;
        }
        String strValueOf = String.valueOf(obj);
        if (strValueOf.length() <= i) {
            return strValueOf;
        }
        if (z) {
            return strValueOf.substring(0, i);
        }
        return null;
    }

    private void zza(String str, String str2, int i, Object obj) {
        if (obj == null) {
            zzAo().zzCH().zzj(str + " value can't be null. Ignoring " + str, str2);
            return;
        }
        if ((obj instanceof Long) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Boolean) || (obj instanceof Double)) {
            return;
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            String strValueOf = String.valueOf(obj);
            if (strValueOf.length() > i) {
                zzAo().zzCH().zze("Ignoring " + str + ". Value is too long. name, value length", str2, Integer.valueOf(strValueOf.length()));
            }
        }
    }

    private static void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    private static void zza(StringBuilder sb, int i, zzqb.zze zzeVar) {
        if (zzeVar == null) {
            return;
        }
        zza(sb, i);
        sb.append("bundle {\n");
        zza(sb, i, "protocol_version", zzeVar.zzbal);
        zza(sb, i, "platform", zzeVar.zzbat);
        zza(sb, i, "gmp_version", zzeVar.zzbax);
        zza(sb, i, "uploading_gmp_version", zzeVar.zzbay);
        zza(sb, i, "gmp_app_id", zzeVar.zzaVt);
        zza(sb, i, "app_id", zzeVar.appId);
        zza(sb, i, "app_version", zzeVar.zzaMV);
        zza(sb, i, "dev_cert_hash", zzeVar.zzbaC);
        zza(sb, i, "app_store", zzeVar.zzaVu);
        zza(sb, i, "upload_timestamp_millis", zzeVar.zzbao);
        zza(sb, i, "start_timestamp_millis", zzeVar.zzbap);
        zza(sb, i, "end_timestamp_millis", zzeVar.zzbaq);
        zza(sb, i, "previous_bundle_start_timestamp_millis", zzeVar.zzbar);
        zza(sb, i, "previous_bundle_end_timestamp_millis", zzeVar.zzbas);
        zza(sb, i, "app_instance_id", zzeVar.zzbaB);
        zza(sb, i, "resettable_device_id", zzeVar.zzbaz);
        zza(sb, i, "limited_ad_tracking", zzeVar.zzbaA);
        zza(sb, i, "os_version", zzeVar.osVersion);
        zza(sb, i, "device_model", zzeVar.zzbau);
        zza(sb, i, "user_default_language", zzeVar.zzbav);
        zza(sb, i, "time_zone_offset_minutes", zzeVar.zzbaw);
        zza(sb, i, "bundle_sequential_index", zzeVar.zzbaD);
        zza(sb, i, "service_upload", zzeVar.zzbaE);
        zza(sb, i, "health_monitor", zzeVar.zzaVx);
        zza(sb, i, zzeVar.zzban);
        zza(sb, i, zzeVar.zzbaF);
        zza(sb, i, zzeVar.zzbam);
        zza(sb, i);
        sb.append("}\n");
    }

    private static void zza(StringBuilder sb, int i, String str, zzqb.zzf zzfVar) {
        int i2 = 0;
        if (zzfVar == null) {
            return;
        }
        int i3 = i + 1;
        zza(sb, i3);
        sb.append(str);
        sb.append(" {\n");
        if (zzfVar.zzbaH != null) {
            zza(sb, i3 + 1);
            sb.append("results: ");
            long[] jArr = zzfVar.zzbaH;
            int length = jArr.length;
            int i4 = 0;
            int i5 = 0;
            while (i4 < length) {
                Long lValueOf = Long.valueOf(jArr[i4]);
                int i6 = i5 + 1;
                if (i5 != 0) {
                    sb.append(", ");
                }
                sb.append(lValueOf);
                i4++;
                i5 = i6;
            }
            sb.append('\n');
        }
        if (zzfVar.zzbaG != null) {
            zza(sb, i3 + 1);
            sb.append("status: ");
            long[] jArr2 = zzfVar.zzbaG;
            int length2 = jArr2.length;
            int i7 = 0;
            while (i2 < length2) {
                Long lValueOf2 = Long.valueOf(jArr2[i2]);
                int i8 = i7 + 1;
                if (i7 != 0) {
                    sb.append(", ");
                }
                sb.append(lValueOf2);
                i2++;
                i7 = i8;
            }
            sb.append('\n');
        }
        zza(sb, i3);
        sb.append("}\n");
    }

    private static void zza(StringBuilder sb, int i, String str, Object obj) {
        if (obj == null) {
            return;
        }
        zza(sb, i + 1);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }

    private static void zza(StringBuilder sb, int i, zzqb.zza[] zzaVarArr) {
        if (zzaVarArr == null) {
            return;
        }
        int i2 = i + 1;
        for (zzqb.zza zzaVar : zzaVarArr) {
            if (zzaVar != null) {
                zza(sb, i2);
                sb.append("audience_membership {\n");
                zza(sb, i2, "audience_id", zzaVar.zzaZr);
                zza(sb, i2, "new_audience", zzaVar.zzbac);
                zza(sb, i2, "current_data", zzaVar.zzbaa);
                zza(sb, i2, "previous_data", zzaVar.zzbab);
                zza(sb, i2);
                sb.append("}\n");
            }
        }
    }

    private static void zza(StringBuilder sb, int i, zzqb.zzb[] zzbVarArr) {
        if (zzbVarArr == null) {
            return;
        }
        int i2 = i + 1;
        for (zzqb.zzb zzbVar : zzbVarArr) {
            if (zzbVar != null) {
                zza(sb, i2);
                sb.append("event {\n");
                zza(sb, i2, "name", zzbVar.name);
                zza(sb, i2, "timestamp_millis", zzbVar.zzbaf);
                zza(sb, i2, "previous_timestamp_millis", zzbVar.zzbag);
                zza(sb, i2, "count", zzbVar.count);
                zza(sb, i2, zzbVar.zzbae);
                zza(sb, i2);
                sb.append("}\n");
            }
        }
    }

    private static void zza(StringBuilder sb, int i, zzqb.zzc[] zzcVarArr) {
        if (zzcVarArr == null) {
            return;
        }
        int i2 = i + 1;
        for (zzqb.zzc zzcVar : zzcVarArr) {
            if (zzcVar != null) {
                zza(sb, i2);
                sb.append("event {\n");
                zza(sb, i2, "name", zzcVar.name);
                zza(sb, i2, "string_value", zzcVar.zzamJ);
                zza(sb, i2, "int_value", zzcVar.zzbai);
                zza(sb, i2, "float_value", zzcVar.zzaZo);
                zza(sb, i2);
                sb.append("}\n");
            }
        }
    }

    private static void zza(StringBuilder sb, int i, zzqb.zzg[] zzgVarArr) {
        if (zzgVarArr == null) {
            return;
        }
        int i2 = i + 1;
        for (zzqb.zzg zzgVar : zzgVarArr) {
            if (zzgVar != null) {
                zza(sb, i2);
                sb.append("user_property {\n");
                zza(sb, i2, "set_timestamp_millis", zzgVar.zzbaJ);
                zza(sb, i2, "name", zzgVar.name);
                zza(sb, i2, "string_value", zzgVar.zzamJ);
                zza(sb, i2, "int_value", zzgVar.zzbai);
                zza(sb, i2, "float_value", zzgVar.zzaZo);
                zza(sb, i2);
                sb.append("}\n");
            }
        }
    }

    public static boolean zza(Context context, Class<? extends Service> cls) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, cls), 4);
            return serviceInfo != null && serviceInfo.enabled;
        } catch (PackageManager.NameNotFoundException e) {
        }
    }

    public static boolean zza(Context context, Class<? extends BroadcastReceiver> cls, boolean z) {
        try {
            ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, cls), 2);
            return receiverInfo != null && receiverInfo.enabled && (!z || receiverInfo.exported);
        } catch (PackageManager.NameNotFoundException e) {
        }
    }

    public static boolean zza(long[] jArr, int i) {
        return i < jArr.length * 64 && (jArr[i / 64] & (1 << (i % 64))) != 0;
    }

    public static long[] zza(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = 0;
            for (int i2 = 0; i2 < 64 && (i * 64) + i2 < bitSet.length(); i2++) {
                if (bitSet.get((i * 64) + i2)) {
                    jArr[i] = jArr[i] | (1 << i2);
                }
            }
        }
        return jArr;
    }

    public static String zzb(zzqb.zzd zzdVar) {
        if (zzdVar == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        if (zzdVar.zzbaj != null) {
            for (zzqb.zze zzeVar : zzdVar.zzbaj) {
                if (zzeVar != null) {
                    zza(sb, 1, zzeVar);
                }
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    static MessageDigest zzbv(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 2) {
                return null;
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                if (messageDigest != null) {
                    return messageDigest;
                }
                i = i2 + 1;
            } catch (NoSuchAlgorithmException e) {
            }
        }
    }

    static boolean zzfq(String str) {
        com.google.android.gms.common.internal.zzx.zzcM(str);
        return str.charAt(0) != '_';
    }

    private int zzfu(String str) {
        return "_ldl".equals(str) ? zzCp().zzBG() : zzCp().zzBF();
    }

    public static boolean zzfv(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
    }

    static long zzq(byte[] bArr) {
        int i = 0;
        com.google.android.gms.common.internal.zzx.zzz(bArr);
        com.google.android.gms.common.internal.zzx.zzab(bArr.length > 0);
        long j = 0;
        for (int length = bArr.length - 1; length >= 0 && length >= bArr.length - 8; length--) {
            j += (((long) bArr[length]) & 255) << i;
            i += 8;
        }
        return j;
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzp zzAo() {
        return super.zzAo();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ void zzCd() {
        super.zzCd();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzc zzCe() {
        return super.zzCe();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzab zzCf() {
        return super.zzCf();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzn zzCg() {
        return super.zzCg();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzg zzCh() {
        return super.zzCh();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzac zzCi() {
        return super.zzCi();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zze zzCj() {
        return super.zzCj();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzaj zzCk() {
        return super.zzCk();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzu zzCl() {
        return super.zzCl();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzad zzCm() {
        return super.zzCm();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzv zzCn() {
        return super.zzCn();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzt zzCo() {
        return super.zzCo();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzd zzCp() {
        return super.zzCp();
    }

    public void zza(Bundle bundle, String str, Object obj) {
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof Float) {
            bundle.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
        } else if (str != null) {
            zzAo().zzCH().zze("Not putting event parameter. Invalid value type. name, type", str, obj.getClass().getSimpleName());
        }
    }

    public void zza(zzqb.zzc zzcVar, Object obj) {
        com.google.android.gms.common.internal.zzx.zzz(obj);
        zzcVar.zzamJ = null;
        zzcVar.zzbai = null;
        zzcVar.zzaZo = null;
        if (obj instanceof String) {
            zzcVar.zzamJ = (String) obj;
            return;
        }
        if (obj instanceof Long) {
            zzcVar.zzbai = (Long) obj;
        } else if (obj instanceof Float) {
            zzcVar.zzaZo = (Float) obj;
        } else {
            zzAo().zzCE().zzj("Ignoring invalid (type) event param value", obj);
        }
    }

    public void zza(zzqb.zzg zzgVar, Object obj) {
        com.google.android.gms.common.internal.zzx.zzz(obj);
        zzgVar.zzamJ = null;
        zzgVar.zzbai = null;
        zzgVar.zzaZo = null;
        if (obj instanceof String) {
            zzgVar.zzamJ = (String) obj;
            return;
        }
        if (obj instanceof Long) {
            zzgVar.zzbai = (Long) obj;
        } else if (obj instanceof Float) {
            zzgVar.zzaZo = (Float) obj;
        } else {
            zzAo().zzCE().zzj("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public byte[] zza(zzqb.zzd zzdVar) {
        try {
            byte[] bArr = new byte[zzdVar.getSerializedSize()];
            zzsn zzsnVarZzE = zzsn.zzE(bArr);
            zzdVar.writeTo(zzsnVarZzE);
            zzsnVarZzE.zzJo();
            return bArr;
        } catch (IOException e) {
            zzAo().zzCE().zzj("Data loss. Failed to serialize batch", e);
            return null;
        }
    }

    @WorkerThread
    public boolean zzbk(String str) {
        zzjk();
        if (getContext().checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzAo().zzCJ().zzj("Permission not granted", str);
        return false;
    }

    void zzc(String str, int i, String str2) {
        if (str2 == null) {
            throw new IllegalArgumentException(str + " name is required and can't be null");
        }
        if (str2.length() == 0) {
            throw new IllegalArgumentException(str + " name is required and can't be empty");
        }
        char cCharAt = str2.charAt(0);
        if (!Character.isLetter(cCharAt) && cCharAt != '_') {
            throw new IllegalArgumentException(str + " name must start with a letter or _");
        }
        for (int i2 = 1; i2 < str2.length(); i2++) {
            char cCharAt2 = str2.charAt(i2);
            if (cCharAt2 != '_' && !Character.isLetterOrDigit(cCharAt2)) {
                throw new IllegalArgumentException(str + " name must consist of letters, digits or _ (underscores)");
            }
        }
        if (str2.length() > i) {
            throw new IllegalArgumentException(str + " name is too long. The maximum supported length is " + i);
        }
    }

    public boolean zzc(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(zzjl().currentTimeMillis() - j) > j2;
    }

    public void zzfr(String str) {
        zzc("event", zzCp().zzBB(), str);
    }

    public void zzfs(String str) {
        zzc("user attribute", zzCp().zzBC(), str);
    }

    public void zzft(String str) {
        zzc("event param", zzCp().zzBC(), str);
    }

    public byte[] zzg(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            zzAo().zzCE().zzj("Failed to gzip content", e);
            throw e;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ void zzjj() {
        super.zzjj();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ void zzjk() {
        super.zzjk();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzmq zzjl() {
        return super.zzjl();
    }

    public Object zzk(String str, Object obj) {
        return zza(zzfv(str) ? zzCp().zzBE() : zzCp().zzBD(), obj, false);
    }

    public void zzl(String str, Object obj) {
        if ("_ldl".equals(str)) {
            zza("user attribute referrer", str, zzfu(str), obj);
        } else {
            zza("user attribute", str, zzfu(str), obj);
        }
    }

    public Object zzm(String str, Object obj) {
        return "_ldl".equals(str) ? zza(zzfu(str), obj, true) : zza(zzfu(str), obj, false);
    }

    public byte[] zzp(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int i = gZIPInputStream.read(bArr2);
                if (i <= 0) {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, i);
            }
        } catch (IOException e) {
            zzAo().zzCE().zzj("Failed to ungzip content", e);
            throw e;
        }
    }

    public long zzr(byte[] bArr) {
        com.google.android.gms.common.internal.zzx.zzz(bArr);
        MessageDigest messageDigestZzbv = zzbv("MD5");
        if (messageDigestZzbv != null) {
            return zzq(messageDigestZzbv.digest(bArr));
        }
        zzAo().zzCE().zzfg("Failed to get MD5");
        return 0L;
    }
}
