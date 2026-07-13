package com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.internal.zzaz;
import com.google.android.gms.wearable.internal.zzbb;
import com.google.android.gms.wearable.internal.zzbm;
import com.google.android.gms.wearable.internal.zzbp;
import com.google.android.gms.wearable.internal.zzbr;
import com.google.android.gms.wearable.internal.zzl;
import com.google.android.gms.wearable.internal.zzw;
import com.google.android.gms.wearable.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public class Wearable {
    public static final DataApi DataApi = new zzx();
    public static final CapabilityApi CapabilityApi = new com.google.android.gms.wearable.internal.zzj();
    public static final MessageApi MessageApi = new zzaz();
    public static final NodeApi NodeApi = new zzbb();
    public static final ChannelApi ChannelApi = new zzl();
    public static final zzc zzbrj = new com.google.android.gms.wearable.internal.zzg();
    public static final zza zzbrk = new com.google.android.gms.wearable.internal.zze();
    public static final zzf zzbrl = new zzw();
    public static final zzi zzbrm = new zzbm();
    public static final zzk zzbrn = new zzbr();
    public static final Api.zzc<zzbp> zzUI = new Api.zzc<>();
    private static final Api.zza<zzbp, WearableOptions> zzUJ = new Api.zza<zzbp, WearableOptions>() { // from class: com.google.android.gms.wearable.Wearable.1
        @Override // com.google.android.gms.common.api.Api.zza
        public zzbp zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, WearableOptions wearableOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            if (wearableOptions == null) {
                new WearableOptions(new WearableOptions.Builder());
            }
            return new zzbp(context, looper, connectionCallbacks, onConnectionFailedListener, zzfVar);
        }
    };
    public static final Api<WearableOptions> API = new Api<>("Wearable.API", zzUJ, zzUI);

    public static final class WearableOptions implements Api.ApiOptions.Optional {

        public static class Builder {
            public WearableOptions build() {
                return new WearableOptions(this);
            }
        }

        private WearableOptions(Builder builder) {
        }
    }

    private Wearable() {
    }
}
