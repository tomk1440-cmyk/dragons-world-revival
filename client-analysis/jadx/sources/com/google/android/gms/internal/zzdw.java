package com.google.android.gms.internal;

import android.os.Handler;
import android.os.RemoteException;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzhb
class zzdw {
    private final List<zza> zzpH = new LinkedList();

    interface zza {
        void zzb(zzdx zzdxVar) throws RemoteException;
    }

    zzdw() {
    }

    void zza(final zzdx zzdxVar) {
        Handler handler = zzir.zzMc;
        for (final zza zzaVar : this.zzpH) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.zzdw.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        zzaVar.zzb(zzdxVar);
                    } catch (RemoteException e) {
                        zzin.zzd("Could not propagate interstitial ad event.", e);
                    }
                }
            });
        }
    }

    void zzc(com.google.android.gms.ads.internal.zzk zzkVar) {
        zzkVar.zza(new com.google.android.gms.ads.internal.client.zzq.zza() { // from class: com.google.android.gms.internal.zzdw.1
            @Override // com.google.android.gms.ads.internal.client.zzq
            public void onAdClosed() throws RemoteException {
                zzdw.this.zzpH.add(new zza() { // from class: com.google.android.gms.internal.zzdw.1.1
                    @Override // com.google.android.gms.internal.zzdw.zza
                    public void zzb(zzdx zzdxVar) throws RemoteException {
                        if (zzdxVar.zzpK != null) {
                            zzdxVar.zzpK.onAdClosed();
                        }
                        com.google.android.gms.ads.internal.zzr.zzbN().zzee();
                    }
                });
            }

            @Override // com.google.android.gms.ads.internal.client.zzq
            public void onAdFailedToLoad(final int errorCode) throws RemoteException {
                zzdw.this.zzpH.add(new zza() { // from class: com.google.android.gms.internal.zzdw.1.2
                    @Override // com.google.android.gms.internal.zzdw.zza
                    public void zzb(zzdx zzdxVar) throws RemoteException {
                        if (zzdxVar.zzpK != null) {
                            zzdxVar.zzpK.onAdFailedToLoad(errorCode);
                        }
                    }
                });
                zzin.v("Pooled interstitial failed to load.");
            }

            @Override // com.google.android.gms.ads.internal.client.zzq
            public void onAdLeftApplication() throws RemoteException {
                zzdw.this.zzpH.add(new zza() { // from class: com.google.android.gms.internal.zzdw.1.3
                    @Override // com.google.android.gms.internal.zzdw.zza
                    public void zzb(zzdx zzdxVar) throws RemoteException {
                        if (zzdxVar.zzpK != null) {
                            zzdxVar.zzpK.onAdLeftApplication();
                        }
                    }
                });
            }

            @Override // com.google.android.gms.ads.internal.client.zzq
            public void onAdLoaded() throws RemoteException {
                zzdw.this.zzpH.add(new zza() { // from class: com.google.android.gms.internal.zzdw.1.4
                    @Override // com.google.android.gms.internal.zzdw.zza
                    public void zzb(zzdx zzdxVar) throws RemoteException {
                        if (zzdxVar.zzpK != null) {
                            zzdxVar.zzpK.onAdLoaded();
                        }
                    }
                });
                zzin.v("Pooled interstitial loaded.");
            }

            @Override // com.google.android.gms.ads.internal.client.zzq
            public void onAdOpened() throws RemoteException {
                zzdw.this.zzpH.add(new zza() { // from class: com.google.android.gms.internal.zzdw.1.5
                    @Override // com.google.android.gms.internal.zzdw.zza
                    public void zzb(zzdx zzdxVar) throws RemoteException {
                        if (zzdxVar.zzpK != null) {
                            zzdxVar.zzpK.onAdOpened();
                        }
                    }
                });
            }
        });
        zzkVar.zza(new com.google.android.gms.ads.internal.client.zzw.zza() { // from class: com.google.android.gms.internal.zzdw.2
            @Override // com.google.android.gms.ads.internal.client.zzw
            public void onAppEvent(final String name, final String info) throws RemoteException {
                zzdw.this.zzpH.add(new zza() { // from class: com.google.android.gms.internal.zzdw.2.1
                    @Override // com.google.android.gms.internal.zzdw.zza
                    public void zzb(zzdx zzdxVar) throws RemoteException {
                        if (zzdxVar.zzAq != null) {
                            zzdxVar.zzAq.onAppEvent(name, info);
                        }
                    }
                });
            }
        });
        zzkVar.zza(new zzgd.zza() { // from class: com.google.android.gms.internal.zzdw.3
            @Override // com.google.android.gms.internal.zzgd
            public void zza(final zzgc zzgcVar) throws RemoteException {
                zzdw.this.zzpH.add(new zza() { // from class: com.google.android.gms.internal.zzdw.3.1
                    @Override // com.google.android.gms.internal.zzdw.zza
                    public void zzb(zzdx zzdxVar) throws RemoteException {
                        if (zzdxVar.zzAr != null) {
                            zzdxVar.zzAr.zza(zzgcVar);
                        }
                    }
                });
            }
        });
        zzkVar.zza(new zzcf.zza() { // from class: com.google.android.gms.internal.zzdw.4
            @Override // com.google.android.gms.internal.zzcf
            public void zza(final zzce zzceVar) throws RemoteException {
                zzdw.this.zzpH.add(new zza() { // from class: com.google.android.gms.internal.zzdw.4.1
                    @Override // com.google.android.gms.internal.zzdw.zza
                    public void zzb(zzdx zzdxVar) throws RemoteException {
                        if (zzdxVar.zzAs != null) {
                            zzdxVar.zzAs.zza(zzceVar);
                        }
                    }
                });
            }
        });
        zzkVar.zza(new com.google.android.gms.ads.internal.client.zzp.zza() { // from class: com.google.android.gms.internal.zzdw.5
            @Override // com.google.android.gms.ads.internal.client.zzp
            public void onAdClicked() throws RemoteException {
                zzdw.this.zzpH.add(new zza() { // from class: com.google.android.gms.internal.zzdw.5.1
                    @Override // com.google.android.gms.internal.zzdw.zza
                    public void zzb(zzdx zzdxVar) throws RemoteException {
                        if (zzdxVar.zzAt != null) {
                            zzdxVar.zzAt.onAdClicked();
                        }
                    }
                });
            }
        });
        zzkVar.zza(new com.google.android.gms.ads.internal.reward.client.zzd.zza() { // from class: com.google.android.gms.internal.zzdw.6
            @Override // com.google.android.gms.ads.internal.reward.client.zzd
            public void onRewardedVideoAdClosed() throws RemoteException {
                zzdw.this.zzpH.add(new zza() { // from class: com.google.android.gms.internal.zzdw.6.4
                    @Override // com.google.android.gms.internal.zzdw.zza
                    public void zzb(zzdx zzdxVar) throws RemoteException {
                        if (zzdxVar.zzAu != null) {
                            zzdxVar.zzAu.onRewardedVideoAdClosed();
                        }
                    }
                });
            }

            @Override // com.google.android.gms.ads.internal.reward.client.zzd
            public void onRewardedVideoAdFailedToLoad(final int errorCode) throws RemoteException {
                zzdw.this.zzpH.add(new zza() { // from class: com.google.android.gms.internal.zzdw.6.7
                    @Override // com.google.android.gms.internal.zzdw.zza
                    public void zzb(zzdx zzdxVar) throws RemoteException {
                        if (zzdxVar.zzAu != null) {
                            zzdxVar.zzAu.onRewardedVideoAdFailedToLoad(errorCode);
                        }
                    }
                });
            }

            @Override // com.google.android.gms.ads.internal.reward.client.zzd
            public void onRewardedVideoAdLeftApplication() throws RemoteException {
                zzdw.this.zzpH.add(new zza() { // from class: com.google.android.gms.internal.zzdw.6.6
                    @Override // com.google.android.gms.internal.zzdw.zza
                    public void zzb(zzdx zzdxVar) throws RemoteException {
                        if (zzdxVar.zzAu != null) {
                            zzdxVar.zzAu.onRewardedVideoAdLeftApplication();
                        }
                    }
                });
            }

            @Override // com.google.android.gms.ads.internal.reward.client.zzd
            public void onRewardedVideoAdLoaded() throws RemoteException {
                zzdw.this.zzpH.add(new zza() { // from class: com.google.android.gms.internal.zzdw.6.1
                    @Override // com.google.android.gms.internal.zzdw.zza
                    public void zzb(zzdx zzdxVar) throws RemoteException {
                        if (zzdxVar.zzAu != null) {
                            zzdxVar.zzAu.onRewardedVideoAdLoaded();
                        }
                    }
                });
            }

            @Override // com.google.android.gms.ads.internal.reward.client.zzd
            public void onRewardedVideoAdOpened() throws RemoteException {
                zzdw.this.zzpH.add(new zza() { // from class: com.google.android.gms.internal.zzdw.6.2
                    @Override // com.google.android.gms.internal.zzdw.zza
                    public void zzb(zzdx zzdxVar) throws RemoteException {
                        if (zzdxVar.zzAu != null) {
                            zzdxVar.zzAu.onRewardedVideoAdOpened();
                        }
                    }
                });
            }

            @Override // com.google.android.gms.ads.internal.reward.client.zzd
            public void onRewardedVideoStarted() throws RemoteException {
                zzdw.this.zzpH.add(new zza() { // from class: com.google.android.gms.internal.zzdw.6.3
                    @Override // com.google.android.gms.internal.zzdw.zza
                    public void zzb(zzdx zzdxVar) throws RemoteException {
                        if (zzdxVar.zzAu != null) {
                            zzdxVar.zzAu.onRewardedVideoStarted();
                        }
                    }
                });
            }

            @Override // com.google.android.gms.ads.internal.reward.client.zzd
            public void zza(final com.google.android.gms.ads.internal.reward.client.zza zzaVar) throws RemoteException {
                zzdw.this.zzpH.add(new zza() { // from class: com.google.android.gms.internal.zzdw.6.5
                    @Override // com.google.android.gms.internal.zzdw.zza
                    public void zzb(zzdx zzdxVar) throws RemoteException {
                        if (zzdxVar.zzAu != null) {
                            zzdxVar.zzAu.zza(zzaVar);
                        }
                    }
                });
            }
        });
    }
}
