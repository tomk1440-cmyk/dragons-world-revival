package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class zzfk<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final zzez zzCK;

    public zzfk(zzez zzezVar) {
        this.zzCK = zzezVar;
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public void onClick(MediationBannerAdapter<?, ?> adapter) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaI("Adapter called onClick.");
        if (!com.google.android.gms.ads.internal.client.zzn.zzcS().zzhJ()) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaK("onClick must be called on the main UI thread.");
            com.google.android.gms.ads.internal.util.client.zza.zzMS.post(new Runnable() { // from class: com.google.android.gms.internal.zzfk.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        zzfk.this.zzCK.onAdClicked();
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdClicked.", e);
                    }
                }
            });
        } else {
            try {
                this.zzCK.onAdClicked();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdClicked.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public void onDismissScreen(MediationBannerAdapter<?, ?> adapter) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaI("Adapter called onDismissScreen.");
        if (!com.google.android.gms.ads.internal.client.zzn.zzcS().zzhJ()) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaK("onDismissScreen must be called on the main UI thread.");
            com.google.android.gms.ads.internal.util.client.zza.zzMS.post(new Runnable() { // from class: com.google.android.gms.internal.zzfk.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        zzfk.this.zzCK.onAdClosed();
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdClosed.", e);
                    }
                }
            });
        } else {
            try {
                this.zzCK.onAdClosed();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdClosed.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public void onDismissScreen(MediationInterstitialAdapter<?, ?> adapter) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaI("Adapter called onDismissScreen.");
        if (!com.google.android.gms.ads.internal.client.zzn.zzcS().zzhJ()) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaK("onDismissScreen must be called on the main UI thread.");
            com.google.android.gms.ads.internal.util.client.zza.zzMS.post(new Runnable() { // from class: com.google.android.gms.internal.zzfk.9
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        zzfk.this.zzCK.onAdClosed();
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdClosed.", e);
                    }
                }
            });
        } else {
            try {
                this.zzCK.onAdClosed();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdClosed.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> adapter, final AdRequest.ErrorCode errorCode) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaI("Adapter called onFailedToReceiveAd with error. " + errorCode);
        if (!com.google.android.gms.ads.internal.client.zzn.zzcS().zzhJ()) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaK("onFailedToReceiveAd must be called on the main UI thread.");
            com.google.android.gms.ads.internal.util.client.zza.zzMS.post(new Runnable() { // from class: com.google.android.gms.internal.zzfk.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        zzfk.this.zzCK.onAdFailedToLoad(zzfl.zza(errorCode));
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdFailedToLoad.", e);
                    }
                }
            });
        } else {
            try {
                this.zzCK.onAdFailedToLoad(zzfl.zza(errorCode));
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> adapter, final AdRequest.ErrorCode errorCode) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaI("Adapter called onFailedToReceiveAd with error " + errorCode + ".");
        if (!com.google.android.gms.ads.internal.client.zzn.zzcS().zzhJ()) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaK("onFailedToReceiveAd must be called on the main UI thread.");
            com.google.android.gms.ads.internal.util.client.zza.zzMS.post(new Runnable() { // from class: com.google.android.gms.internal.zzfk.10
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        zzfk.this.zzCK.onAdFailedToLoad(zzfl.zza(errorCode));
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdFailedToLoad.", e);
                    }
                }
            });
        } else {
            try {
                this.zzCK.onAdFailedToLoad(zzfl.zza(errorCode));
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public void onLeaveApplication(MediationBannerAdapter<?, ?> adapter) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaI("Adapter called onLeaveApplication.");
        if (!com.google.android.gms.ads.internal.client.zzn.zzcS().zzhJ()) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaK("onLeaveApplication must be called on the main UI thread.");
            com.google.android.gms.ads.internal.util.client.zza.zzMS.post(new Runnable() { // from class: com.google.android.gms.internal.zzfk.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        zzfk.this.zzCK.onAdLeftApplication();
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdLeftApplication.", e);
                    }
                }
            });
        } else {
            try {
                this.zzCK.onAdLeftApplication();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdLeftApplication.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> adapter) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaI("Adapter called onLeaveApplication.");
        if (!com.google.android.gms.ads.internal.client.zzn.zzcS().zzhJ()) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaK("onLeaveApplication must be called on the main UI thread.");
            com.google.android.gms.ads.internal.util.client.zza.zzMS.post(new Runnable() { // from class: com.google.android.gms.internal.zzfk.11
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        zzfk.this.zzCK.onAdLeftApplication();
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdLeftApplication.", e);
                    }
                }
            });
        } else {
            try {
                this.zzCK.onAdLeftApplication();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdLeftApplication.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public void onPresentScreen(MediationBannerAdapter<?, ?> adapter) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaI("Adapter called onPresentScreen.");
        if (!com.google.android.gms.ads.internal.client.zzn.zzcS().zzhJ()) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaK("onPresentScreen must be called on the main UI thread.");
            com.google.android.gms.ads.internal.util.client.zza.zzMS.post(new Runnable() { // from class: com.google.android.gms.internal.zzfk.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        zzfk.this.zzCK.onAdOpened();
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdOpened.", e);
                    }
                }
            });
        } else {
            try {
                this.zzCK.onAdOpened();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdOpened.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public void onPresentScreen(MediationInterstitialAdapter<?, ?> adapter) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaI("Adapter called onPresentScreen.");
        if (!com.google.android.gms.ads.internal.client.zzn.zzcS().zzhJ()) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaK("onPresentScreen must be called on the main UI thread.");
            com.google.android.gms.ads.internal.util.client.zza.zzMS.post(new Runnable() { // from class: com.google.android.gms.internal.zzfk.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        zzfk.this.zzCK.onAdOpened();
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdOpened.", e);
                    }
                }
            });
        } else {
            try {
                this.zzCK.onAdOpened();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdOpened.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public void onReceivedAd(MediationBannerAdapter<?, ?> adapter) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaI("Adapter called onReceivedAd.");
        if (!com.google.android.gms.ads.internal.client.zzn.zzcS().zzhJ()) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaK("onReceivedAd must be called on the main UI thread.");
            com.google.android.gms.ads.internal.util.client.zza.zzMS.post(new Runnable() { // from class: com.google.android.gms.internal.zzfk.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        zzfk.this.zzCK.onAdLoaded();
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdLoaded.", e);
                    }
                }
            });
        } else {
            try {
                this.zzCK.onAdLoaded();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdLoaded.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public void onReceivedAd(MediationInterstitialAdapter<?, ?> adapter) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaI("Adapter called onReceivedAd.");
        if (!com.google.android.gms.ads.internal.client.zzn.zzcS().zzhJ()) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaK("onReceivedAd must be called on the main UI thread.");
            com.google.android.gms.ads.internal.util.client.zza.zzMS.post(new Runnable() { // from class: com.google.android.gms.internal.zzfk.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        zzfk.this.zzCK.onAdLoaded();
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdLoaded.", e);
                    }
                }
            });
        } else {
            try {
                this.zzCK.onAdLoaded();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdLoaded.", e);
            }
        }
    }
}
