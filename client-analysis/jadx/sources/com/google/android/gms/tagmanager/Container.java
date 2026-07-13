package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzrs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class Container {
    private final Context mContext;
    private final String zzbhM;
    private final DataLayer zzbhN;
    private zzcp zzbhO;
    private volatile long zzbhR;
    private Map<String, FunctionCallMacroCallback> zzbhP = new HashMap();
    private Map<String, FunctionCallTagCallback> zzbhQ = new HashMap();
    private volatile String zzbhS = "";

    public interface FunctionCallMacroCallback {
        Object getValue(String str, Map<String, Object> map);
    }

    public interface FunctionCallTagCallback {
        void execute(String str, Map<String, Object> map);
    }

    private class zza implements zzt.zza {
        private zza() {
        }

        @Override // com.google.android.gms.tagmanager.zzt.zza
        public Object zzc(String str, Map<String, Object> map) {
            FunctionCallMacroCallback functionCallMacroCallbackZzfP = Container.this.zzfP(str);
            if (functionCallMacroCallbackZzfP == null) {
                return null;
            }
            return functionCallMacroCallbackZzfP.getValue(str, map);
        }
    }

    private class zzb implements zzt.zza {
        private zzb() {
        }

        @Override // com.google.android.gms.tagmanager.zzt.zza
        public Object zzc(String str, Map<String, Object> map) {
            FunctionCallTagCallback functionCallTagCallbackZzfQ = Container.this.zzfQ(str);
            if (functionCallTagCallbackZzfQ != null) {
                functionCallTagCallbackZzfQ.execute(str, map);
            }
            return zzdf.zzHE();
        }
    }

    Container(Context context, DataLayer dataLayer, String containerId, long lastRefreshTime, com.google.android.gms.internal.zzaf.zzj resource) {
        this.mContext = context;
        this.zzbhN = dataLayer;
        this.zzbhM = containerId;
        this.zzbhR = lastRefreshTime;
        zza(resource.zzju);
        if (resource.zzjt != null) {
            zza(resource.zzjt);
        }
    }

    Container(Context context, DataLayer dataLayer, String containerId, long lastRefreshTime, zzrs.zzc resource) {
        this.mContext = context;
        this.zzbhN = dataLayer;
        this.zzbhM = containerId;
        this.zzbhR = lastRefreshTime;
        zza(resource);
    }

    private synchronized zzcp zzGc() {
        return this.zzbhO;
    }

    private void zza(com.google.android.gms.internal.zzaf.zzf zzfVar) {
        if (zzfVar == null) {
            throw new NullPointerException();
        }
        try {
            zza(zzrs.zzb(zzfVar));
        } catch (zzrs.zzg e) {
            zzbg.e("Not loading resource: " + zzfVar + " because it is invalid: " + e.toString());
        }
    }

    private void zza(zzrs.zzc zzcVar) {
        this.zzbhS = zzcVar.getVersion();
        zza(new zzcp(this.mContext, zzcVar, this.zzbhN, new zza(), new zzb(), zzfS(this.zzbhS)));
        if (getBoolean("_gtm.loadEventEnabled")) {
            this.zzbhN.pushEvent("gtm.load", DataLayer.mapOf("gtm.id", this.zzbhM));
        }
    }

    private synchronized void zza(zzcp zzcpVar) {
        this.zzbhO = zzcpVar;
    }

    private void zza(com.google.android.gms.internal.zzaf.zzi[] zziVarArr) {
        ArrayList arrayList = new ArrayList();
        for (com.google.android.gms.internal.zzaf.zzi zziVar : zziVarArr) {
            arrayList.add(zziVar);
        }
        zzGc().zzF(arrayList);
    }

    public boolean getBoolean(String key) {
        zzcp zzcpVarZzGc = zzGc();
        if (zzcpVarZzGc == null) {
            zzbg.e("getBoolean called for closed container.");
            return zzdf.zzHC().booleanValue();
        }
        try {
            return zzdf.zzk(zzcpVarZzGc.zzgn(key).getObject()).booleanValue();
        } catch (Exception e) {
            zzbg.e("Calling getBoolean() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzdf.zzHC().booleanValue();
        }
    }

    public String getContainerId() {
        return this.zzbhM;
    }

    public double getDouble(String key) {
        zzcp zzcpVarZzGc = zzGc();
        if (zzcpVarZzGc == null) {
            zzbg.e("getDouble called for closed container.");
            return zzdf.zzHB().doubleValue();
        }
        try {
            return zzdf.zzj(zzcpVarZzGc.zzgn(key).getObject()).doubleValue();
        } catch (Exception e) {
            zzbg.e("Calling getDouble() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzdf.zzHB().doubleValue();
        }
    }

    public long getLastRefreshTime() {
        return this.zzbhR;
    }

    public long getLong(String key) {
        zzcp zzcpVarZzGc = zzGc();
        if (zzcpVarZzGc == null) {
            zzbg.e("getLong called for closed container.");
            return zzdf.zzHA().longValue();
        }
        try {
            return zzdf.zzi(zzcpVarZzGc.zzgn(key).getObject()).longValue();
        } catch (Exception e) {
            zzbg.e("Calling getLong() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzdf.zzHA().longValue();
        }
    }

    public String getString(String key) {
        zzcp zzcpVarZzGc = zzGc();
        if (zzcpVarZzGc == null) {
            zzbg.e("getString called for closed container.");
            return zzdf.zzHE();
        }
        try {
            return zzdf.zzg(zzcpVarZzGc.zzgn(key).getObject());
        } catch (Exception e) {
            zzbg.e("Calling getString() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzdf.zzHE();
        }
    }

    public boolean isDefault() {
        return getLastRefreshTime() == 0;
    }

    public void registerFunctionCallMacroCallback(String customMacroName, FunctionCallMacroCallback customMacroCallback) {
        if (customMacroCallback == null) {
            throw new NullPointerException("Macro handler must be non-null");
        }
        synchronized (this.zzbhP) {
            this.zzbhP.put(customMacroName, customMacroCallback);
        }
    }

    public void registerFunctionCallTagCallback(String customTagName, FunctionCallTagCallback customTagCallback) {
        if (customTagCallback == null) {
            throw new NullPointerException("Tag callback must be non-null");
        }
        synchronized (this.zzbhQ) {
            this.zzbhQ.put(customTagName, customTagCallback);
        }
    }

    void release() {
        this.zzbhO = null;
    }

    public void unregisterFunctionCallMacroCallback(String customMacroName) {
        synchronized (this.zzbhP) {
            this.zzbhP.remove(customMacroName);
        }
    }

    public void unregisterFunctionCallTagCallback(String customTagName) {
        synchronized (this.zzbhQ) {
            this.zzbhQ.remove(customTagName);
        }
    }

    public String zzGb() {
        return this.zzbhS;
    }

    FunctionCallMacroCallback zzfP(String str) {
        FunctionCallMacroCallback functionCallMacroCallback;
        synchronized (this.zzbhP) {
            functionCallMacroCallback = this.zzbhP.get(str);
        }
        return functionCallMacroCallback;
    }

    public FunctionCallTagCallback zzfQ(String str) {
        FunctionCallTagCallback functionCallTagCallback;
        synchronized (this.zzbhQ) {
            functionCallTagCallback = this.zzbhQ.get(str);
        }
        return functionCallTagCallback;
    }

    public void zzfR(String str) {
        zzGc().zzfR(str);
    }

    zzah zzfS(String str) {
        if (zzcb.zzGU().zzGV().equals(zzcb.zza.CONTAINER_DEBUG)) {
        }
        return new zzbo();
    }
}
