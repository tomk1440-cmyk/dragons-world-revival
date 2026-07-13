package com.google.android.gms.wallet;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzsd;
import com.google.android.gms.internal.zzse;
import com.google.android.gms.internal.zzsg;
import com.google.android.gms.internal.zzsh;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class Wallet {
    private static final Api.zzc<zzse> zzUI = new Api.zzc<>();
    private static final Api.zza<zzse, WalletOptions> zzUJ = new Api.zza<zzse, WalletOptions>() { // from class: com.google.android.gms.wallet.Wallet.1
        @Override // com.google.android.gms.common.api.Api.zza
        public zzse zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, WalletOptions walletOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            if (walletOptions == null) {
                walletOptions = new WalletOptions();
            }
            return new zzse(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener, walletOptions.environment, walletOptions.theme, walletOptions.zzbpL);
        }
    };
    public static final Api<WalletOptions> API = new Api<>("Wallet.API", zzUJ, zzUI);
    public static final Payments Payments = new zzsd();
    public static final com.google.android.gms.wallet.wobs.zzj zzbpJ = new zzsh();
    public static final com.google.android.gms.wallet.firstparty.zza zzbpK = new zzsg();

    public static final class WalletOptions implements Api.ApiOptions.HasOptions {
        public final int environment;
        public final int theme;
        private final boolean zzbpL;

        public static final class Builder {
            private int zzbpM = 3;
            private int mTheme = 0;
            private boolean zzbpN = true;

            public WalletOptions build() {
                return new WalletOptions(this);
            }

            public Builder setEnvironment(int environment) {
                if (environment != 0 && environment != 2 && environment != 1 && environment != 3) {
                    throw new IllegalArgumentException(String.format(Locale.US, "Invalid environment value %d", Integer.valueOf(environment)));
                }
                this.zzbpM = environment;
                return this;
            }

            public Builder setTheme(int theme) {
                if (theme != 0 && theme != 1) {
                    throw new IllegalArgumentException(String.format(Locale.US, "Invalid theme value %d", Integer.valueOf(theme)));
                }
                this.mTheme = theme;
                return this;
            }

            public Builder useGoogleWallet() {
                this.zzbpN = false;
                return this;
            }
        }

        private WalletOptions() {
            this(new Builder());
        }

        private WalletOptions(Builder builder) {
            this.environment = builder.zzbpM;
            this.theme = builder.mTheme;
            this.zzbpL = builder.zzbpN;
        }
    }

    public static abstract class zza<R extends Result> extends com.google.android.gms.common.api.internal.zza.AbstractC0049zza<R, zzse> {
        public zza(GoogleApiClient googleApiClient) {
            super(Wallet.zzUI, googleApiClient);
        }
    }

    public static abstract class zzb extends zza<Status> {
        public zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    private Wallet() {
    }

    @Deprecated
    public static void changeMaskedWallet(GoogleApiClient googleApiClient, String googleTransactionId, String merchantTransactionId, int requestCode) {
        Payments.changeMaskedWallet(googleApiClient, googleTransactionId, merchantTransactionId, requestCode);
    }

    @Deprecated
    public static void checkForPreAuthorization(GoogleApiClient googleApiClient, int requestCode) {
        Payments.checkForPreAuthorization(googleApiClient, requestCode);
    }

    @Deprecated
    public static void loadFullWallet(GoogleApiClient googleApiClient, FullWalletRequest request, int requestCode) {
        Payments.loadFullWallet(googleApiClient, request, requestCode);
    }

    @Deprecated
    public static void loadMaskedWallet(GoogleApiClient googleApiClient, MaskedWalletRequest request, int requestCode) {
        Payments.loadMaskedWallet(googleApiClient, request, requestCode);
    }

    @Deprecated
    public static void notifyTransactionStatus(GoogleApiClient googleApiClient, NotifyTransactionStatusRequest request) {
        Payments.notifyTransactionStatus(googleApiClient, request);
    }
}
