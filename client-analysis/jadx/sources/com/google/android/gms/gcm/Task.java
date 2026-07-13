package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.facebook.applinks.AppLinkData;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class Task implements Parcelable {
    public static final int EXTRAS_LIMIT_BYTES = 10240;
    public static final int NETWORK_STATE_ANY = 2;
    public static final int NETWORK_STATE_CONNECTED = 0;
    public static final int NETWORK_STATE_UNMETERED = 1;
    protected static final long UNINITIALIZED = -1;
    private final Bundle mExtras;
    private final String mTag;
    private final String zzaMh;
    private final boolean zzaMi;
    private final boolean zzaMj;
    private final int zzaMk;
    private final boolean zzaMl;
    private final zzd zzaMm;

    public static abstract class Builder {
        protected Bundle extras;
        protected String gcmTaskService;
        protected boolean isPersisted;
        protected int requiredNetworkState;
        protected boolean requiresCharging;
        protected String tag;
        protected boolean updateCurrent;
        protected zzd zzaMn = zzd.zzaMc;

        public abstract Task build();

        protected void checkConditions() {
            zzx.zzb(this.gcmTaskService != null, "Must provide an endpoint for this task by calling setService(ComponentName).");
            GcmNetworkManager.zzdT(this.tag);
            Task.zza(this.zzaMn);
            if (this.isPersisted) {
                Task.zzG(this.extras);
            }
        }

        public abstract Builder setExtras(Bundle bundle);

        public abstract Builder setPersisted(boolean z);

        public abstract Builder setRequiredNetwork(int i);

        public abstract Builder setRequiresCharging(boolean z);

        public abstract Builder setService(Class<? extends GcmTaskService> cls);

        public abstract Builder setTag(String str);

        public abstract Builder setUpdateCurrent(boolean z);
    }

    @Deprecated
    Task(Parcel in) {
        Log.e("Task", "Constructing a Task object using a parcel.");
        this.zzaMh = in.readString();
        this.mTag = in.readString();
        this.zzaMi = in.readInt() == 1;
        this.zzaMj = in.readInt() == 1;
        this.zzaMk = 2;
        this.zzaMl = false;
        this.zzaMm = zzd.zzaMc;
        this.mExtras = null;
    }

    Task(Builder builder) {
        this.zzaMh = builder.gcmTaskService;
        this.mTag = builder.tag;
        this.zzaMi = builder.updateCurrent;
        this.zzaMj = builder.isPersisted;
        this.zzaMk = builder.requiredNetworkState;
        this.zzaMl = builder.requiresCharging;
        this.zzaMm = builder.zzaMn;
        this.mExtras = builder.extras;
    }

    private static boolean zzD(Object obj) {
        return (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof String) || (obj instanceof Boolean);
    }

    public static void zzG(Bundle bundle) {
        if (bundle != null) {
            Parcel parcelObtain = Parcel.obtain();
            bundle.writeToParcel(parcelObtain, 0);
            int iDataSize = parcelObtain.dataSize();
            if (iDataSize > 10240) {
                parcelObtain.recycle();
                throw new IllegalArgumentException("Extras exceeding maximum size(10240 bytes): " + iDataSize);
            }
            parcelObtain.recycle();
            Iterator<String> it = bundle.keySet().iterator();
            while (it.hasNext()) {
                if (!zzD(bundle.get(it.next()))) {
                    throw new IllegalArgumentException("Only the following extra parameter types are supported: Integer, Long, Double, String, and Boolean. ");
                }
            }
        }
    }

    public static void zza(zzd zzdVar) {
        if (zzdVar != null) {
            int iZzym = zzdVar.zzym();
            if (iZzym != 1 && iZzym != 0) {
                throw new IllegalArgumentException("Must provide a valid RetryPolicy: " + iZzym);
            }
            int iZzyn = zzdVar.zzyn();
            int iZzyo = zzdVar.zzyo();
            if (iZzym == 0 && iZzyn < 0) {
                throw new IllegalArgumentException("InitialBackoffSeconds can't be negative: " + iZzyn);
            }
            if (iZzym == 1 && iZzyn < 10) {
                throw new IllegalArgumentException("RETRY_POLICY_LINEAR must have an initial backoff at least 10 seconds.");
            }
            if (iZzyo < iZzyn) {
                throw new IllegalArgumentException("MaximumBackoffSeconds must be greater than InitialBackoffSeconds: " + zzdVar.zzyo());
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public int getRequiredNetwork() {
        return this.zzaMk;
    }

    public boolean getRequiresCharging() {
        return this.zzaMl;
    }

    public String getServiceName() {
        return this.zzaMh;
    }

    public String getTag() {
        return this.mTag;
    }

    public boolean isPersisted() {
        return this.zzaMj;
    }

    public boolean isUpdateCurrent() {
        return this.zzaMi;
    }

    public void toBundle(Bundle bundle) {
        bundle.putString("tag", this.mTag);
        bundle.putBoolean("update_current", this.zzaMi);
        bundle.putBoolean("persisted", this.zzaMj);
        bundle.putString("service", this.zzaMh);
        bundle.putInt("requiredNetwork", this.zzaMk);
        bundle.putBoolean("requiresCharging", this.zzaMl);
        bundle.putBundle("retryStrategy", this.zzaMm.zzF(new Bundle()));
        bundle.putBundle(AppLinkData.ARGUMENTS_EXTRAS_KEY, this.mExtras);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzaMh);
        parcel.writeString(this.mTag);
        parcel.writeInt(this.zzaMi ? 1 : 0);
        parcel.writeInt(this.zzaMj ? 1 : 0);
    }
}
