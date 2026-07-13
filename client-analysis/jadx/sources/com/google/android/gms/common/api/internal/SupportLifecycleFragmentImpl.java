package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.annotation.KeepName;

/* JADX INFO: loaded from: classes.dex */
@KeepName
public class SupportLifecycleFragmentImpl extends zzw {
    @Override // com.google.android.gms.common.api.internal.zzw
    protected void zzb(int i, ConnectionResult connectionResult) {
        GooglePlayServicesUtil.showErrorDialogFragment(connectionResult.getErrorCode(), getActivity(), this, 2, this);
    }

    @Override // com.google.android.gms.common.api.internal.zzw
    protected void zzc(int i, ConnectionResult connectionResult) {
        final Dialog dialogZza = zzpQ().zza(getActivity(), this);
        this.zzaiD = zzn.zza(getActivity().getApplicationContext(), new zzn() { // from class: com.google.android.gms.common.api.internal.SupportLifecycleFragmentImpl.1
            @Override // com.google.android.gms.common.api.internal.zzn
            protected void zzpJ() {
                SupportLifecycleFragmentImpl.this.zzpP();
                dialogZza.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zzw
    /* JADX INFO: renamed from: zzpS, reason: merged with bridge method [inline-methods] */
    public GoogleApiAvailability zzpQ() {
        return GoogleApiAvailability.getInstance();
    }
}
