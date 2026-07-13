package com.google.android.gms.iid;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class InstanceID {
    public static final String ERROR_BACKOFF = "RETRY_LATER";
    public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
    public static final String ERROR_MISSING_INSTANCEID_SERVICE = "MISSING_INSTANCEID_SERVICE";
    public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    public static final String ERROR_TIMEOUT = "TIMEOUT";
    static Map<String, InstanceID> zzaMP = new HashMap();
    private static zzd zzaMQ;
    private static zzc zzaMR;
    static String zzaMV;
    Context mContext;
    KeyPair zzaMS;
    String zzaMT;
    long zzaMU;

    protected InstanceID(Context context, String subtype, Bundle options) {
        this.zzaMT = "";
        this.mContext = context.getApplicationContext();
        this.zzaMT = subtype;
    }

    public static InstanceID getInstance(Context context) {
        return zza(context, null);
    }

    public static synchronized InstanceID zza(Context context, Bundle bundle) {
        InstanceID instanceID;
        String string = bundle == null ? "" : bundle.getString("subtype");
        String str = string == null ? "" : string;
        Context applicationContext = context.getApplicationContext();
        if (zzaMQ == null) {
            zzaMQ = new zzd(applicationContext);
            zzaMR = new zzc(applicationContext);
        }
        zzaMV = Integer.toString(zzaL(applicationContext));
        instanceID = zzaMP.get(str);
        if (instanceID == null) {
            instanceID = new InstanceID(applicationContext, str, bundle);
            zzaMP.put(str, instanceID);
        }
        return instanceID;
    }

    static String zza(KeyPair keyPair) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            bArrDigest[0] = (byte) (((bArrDigest[0] & 15) + 112) & 255);
            return Base64.encodeToString(bArrDigest, 0, 8, 11);
        } catch (NoSuchAlgorithmException e) {
            Log.w("InstanceID", "Unexpected error, device missing required alghorithms");
            return null;
        }
    }

    static int zzaL(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("InstanceID", "Never happens: can't find own package " + e);
            return 0;
        }
    }

    static String zzn(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    public void deleteInstanceID() throws IOException {
        zzb("*", "*", null);
        zzyA();
    }

    public void deleteToken(String authorizedEntity, String scope) throws IOException {
        zzb(authorizedEntity, scope, null);
    }

    public long getCreationTime() {
        String str;
        if (this.zzaMU == 0 && (str = zzaMQ.get(this.zzaMT, "cre")) != null) {
            this.zzaMU = Long.parseLong(str);
        }
        return this.zzaMU;
    }

    public String getId() {
        return zza(zzyz());
    }

    public String getToken(String authorizedEntity, String scope) throws IOException {
        return getToken(authorizedEntity, scope, null);
    }

    public String getToken(String authorizedEntity, String scope, Bundle extras) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        String strZzi = zzyD() ? null : zzaMQ.zzi(this.zzaMT, authorizedEntity, scope);
        if (strZzi == null) {
            if (extras == null) {
                extras = new Bundle();
            }
            boolean z = "jwt".equals(extras.getString(ShareConstants.MEDIA_TYPE)) ? false : extras.getString("ttl") == null;
            strZzi = zzc(authorizedEntity, scope, extras);
            Log.w("InstanceID", "token: " + strZzi);
            if (strZzi != null && z) {
                zzaMQ.zza(this.zzaMT, authorizedEntity, scope, strZzi, zzaMV);
            }
        }
        return strZzi;
    }

    public void zzb(String str, String str2, Bundle bundle) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        zzaMQ.zzj(this.zzaMT, str, str2);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("sender", str);
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("subscription", str);
        bundle.putString("delete", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        bundle.putString("X-delete", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        bundle.putString("subtype", "".equals(this.zzaMT) ? str : this.zzaMT);
        if (!"".equals(this.zzaMT)) {
            str = this.zzaMT;
        }
        bundle.putString("X-subtype", str);
        zzaMR.zzu(zzaMR.zza(bundle, zzyz()));
    }

    public String zzc(String str, String str2, Bundle bundle) throws IOException {
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("sender", str);
        String str3 = "".equals(this.zzaMT) ? str : this.zzaMT;
        if (!bundle.containsKey("legacy.register")) {
            bundle.putString("subscription", str);
            bundle.putString("subtype", str3);
            bundle.putString("X-subscription", str);
            bundle.putString("X-subtype", str3);
        }
        return zzaMR.zzu(zzaMR.zza(bundle, zzyz()));
    }

    void zzyA() {
        this.zzaMU = 0L;
        zzaMQ.zzee(this.zzaMT);
        this.zzaMS = null;
    }

    public zzd zzyB() {
        return zzaMQ;
    }

    zzc zzyC() {
        return zzaMR;
    }

    boolean zzyD() {
        String str;
        String str2 = zzaMQ.get("appVersion");
        if (str2 == null || !str2.equals(zzaMV) || (str = zzaMQ.get("lastToken")) == null) {
            return true;
        }
        return (System.currentTimeMillis() / 1000) - Long.valueOf(Long.parseLong(str)).longValue() > 604800;
    }

    KeyPair zzyz() {
        if (this.zzaMS == null) {
            this.zzaMS = zzaMQ.zzed(this.zzaMT);
        }
        if (this.zzaMS == null) {
            this.zzaMU = System.currentTimeMillis();
            this.zzaMS = zzaMQ.zzd(this.zzaMT, this.zzaMU);
        }
        return this.zzaMS;
    }
}
