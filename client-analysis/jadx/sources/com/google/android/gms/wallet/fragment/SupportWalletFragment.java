package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.dynamic.zzh;
import com.google.android.gms.internal.zzrx;
import com.google.android.gms.internal.zzry;
import com.google.android.gms.internal.zzsf;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

/* JADX INFO: loaded from: classes.dex */
public final class SupportWalletFragment extends Fragment {
    private zzb zzbpW;
    private WalletFragmentOptions zzbqa;
    private WalletFragmentInitParams zzbqb;
    private MaskedWalletRequest zzbqc;
    private MaskedWallet zzbqd;
    private Boolean zzbqe;
    private boolean mCreated = false;
    private final zzh zzbpX = zzh.zza(this);
    private final zzc zzbpY = new zzc();
    private zza zzbpZ = new zza(this);
    private final Fragment zzalg = this;

    public interface OnStateChangedListener {
        void onStateChanged(SupportWalletFragment supportWalletFragment, int i, int i2, Bundle bundle);
    }

    static class zza extends zzry.zza {
        private OnStateChangedListener zzbqf;
        private final SupportWalletFragment zzbqg;

        zza(SupportWalletFragment supportWalletFragment) {
            this.zzbqg = supportWalletFragment;
        }

        @Override // com.google.android.gms.internal.zzry
        public void zza(int i, int i2, Bundle bundle) {
            if (this.zzbqf != null) {
                this.zzbqf.onStateChanged(this.zzbqg, i, i2, bundle);
            }
        }

        public void zza(OnStateChangedListener onStateChangedListener) {
            this.zzbqf = onStateChangedListener;
        }
    }

    private static class zzb implements LifecycleDelegate {
        private final zzrx zzbqh;

        private zzb(zzrx zzrxVar) {
            this.zzbqh = zzrxVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getState() {
            try {
                return this.zzbqh.getState();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void initialize(WalletFragmentInitParams startParams) {
            try {
                this.zzbqh.initialize(startParams);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            try {
                this.zzbqh.onActivityResult(requestCode, resultCode, data);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEnabled(boolean enabled) {
            try {
                this.zzbqh.setEnabled(enabled);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateMaskedWallet(MaskedWallet maskedWallet) {
            try {
                this.zzbqh.updateMaskedWallet(maskedWallet);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateMaskedWalletRequest(MaskedWalletRequest request) {
            try {
                this.zzbqh.updateMaskedWalletRequest(request);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onCreate(Bundle savedInstanceState) {
            try {
                this.zzbqh.onCreate(savedInstanceState);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) zze.zzp(this.zzbqh.onCreateView(zze.zzC(inflater), zze.zzC(container), savedInstanceState));
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onDestroy() {
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onDestroyView() {
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.zzbqh.zza(zze.zzC(activity), (WalletFragmentOptions) attrs.getParcelable("extraWalletFragmentOptions"), savedInstanceState);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onLowMemory() {
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onPause() {
            try {
                this.zzbqh.onPause();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onResume() {
            try {
                this.zzbqh.onResume();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onSaveInstanceState(Bundle outState) {
            try {
                this.zzbqh.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onStart() {
            try {
                this.zzbqh.onStart();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onStop() {
            try {
                this.zzbqh.onStop();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class zzc extends com.google.android.gms.dynamic.zza<zzb> implements View.OnClickListener {
        private zzc() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentActivity activity = SupportWalletFragment.this.zzalg.getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity), activity, -1);
        }

        @Override // com.google.android.gms.dynamic.zza
        protected void zza(FrameLayout frameLayout) {
            WalletFragmentStyle fragmentStyle;
            Button button = new Button(SupportWalletFragment.this.zzalg.getActivity());
            button.setText(R.string.wallet_buy_button_place_holder);
            int iZza = -1;
            int iZza2 = -2;
            if (SupportWalletFragment.this.zzbqa != null && (fragmentStyle = SupportWalletFragment.this.zzbqa.getFragmentStyle()) != null) {
                DisplayMetrics displayMetrics = SupportWalletFragment.this.zzalg.getResources().getDisplayMetrics();
                iZza = fragmentStyle.zza("buyButtonWidth", displayMetrics, -1);
                iZza2 = fragmentStyle.zza("buyButtonHeight", displayMetrics, -2);
            }
            button.setLayoutParams(new ViewGroup.LayoutParams(iZza, iZza2));
            button.setOnClickListener(this);
            frameLayout.addView(button);
        }

        @Override // com.google.android.gms.dynamic.zza
        protected void zza(zzf<zzb> zzfVar) {
            FragmentActivity activity = SupportWalletFragment.this.zzalg.getActivity();
            if (SupportWalletFragment.this.zzbpW == null && SupportWalletFragment.this.mCreated && activity != null) {
                try {
                    zzrx zzrxVarZza = zzsf.zza(activity, SupportWalletFragment.this.zzbpX, SupportWalletFragment.this.zzbqa, SupportWalletFragment.this.zzbpZ);
                    SupportWalletFragment.this.zzbpW = new zzb(zzrxVarZza);
                    SupportWalletFragment.this.zzbqa = null;
                    zzfVar.zza(SupportWalletFragment.this.zzbpW);
                    if (SupportWalletFragment.this.zzbqb != null) {
                        SupportWalletFragment.this.zzbpW.initialize(SupportWalletFragment.this.zzbqb);
                        SupportWalletFragment.this.zzbqb = null;
                    }
                    if (SupportWalletFragment.this.zzbqc != null) {
                        SupportWalletFragment.this.zzbpW.updateMaskedWalletRequest(SupportWalletFragment.this.zzbqc);
                        SupportWalletFragment.this.zzbqc = null;
                    }
                    if (SupportWalletFragment.this.zzbqd != null) {
                        SupportWalletFragment.this.zzbpW.updateMaskedWallet(SupportWalletFragment.this.zzbqd);
                        SupportWalletFragment.this.zzbqd = null;
                    }
                    if (SupportWalletFragment.this.zzbqe != null) {
                        SupportWalletFragment.this.zzbpW.setEnabled(SupportWalletFragment.this.zzbqe.booleanValue());
                        SupportWalletFragment.this.zzbqe = null;
                    }
                } catch (GooglePlayServicesNotAvailableException e) {
                }
            }
        }
    }

    public static SupportWalletFragment newInstance(WalletFragmentOptions options) {
        SupportWalletFragment supportWalletFragment = new SupportWalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", options);
        supportWalletFragment.zzalg.setArguments(bundle);
        return supportWalletFragment;
    }

    public int getState() {
        if (this.zzbpW != null) {
            return this.zzbpW.getState();
        }
        return 0;
    }

    public void initialize(WalletFragmentInitParams initParams) {
        if (this.zzbpW != null) {
            this.zzbpW.initialize(initParams);
            this.zzbqb = null;
        } else {
            if (this.zzbqb != null) {
                Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
                return;
            }
            this.zzbqb = initParams;
            if (this.zzbqc != null) {
                Log.w("SupportWalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }
            if (this.zzbqd != null) {
                Log.w("SupportWalletFragment", "updateMaskedWallet() was called before initialize()");
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.zzbpW != null) {
            this.zzbpW.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        WalletFragmentOptions walletFragmentOptions;
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
            WalletFragmentInitParams walletFragmentInitParams = (WalletFragmentInitParams) savedInstanceState.getParcelable("walletFragmentInitParams");
            if (walletFragmentInitParams != null) {
                if (this.zzbqb != null) {
                    Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
                }
                this.zzbqb = walletFragmentInitParams;
            }
            if (this.zzbqc == null) {
                this.zzbqc = (MaskedWalletRequest) savedInstanceState.getParcelable("maskedWalletRequest");
            }
            if (this.zzbqd == null) {
                this.zzbqd = (MaskedWallet) savedInstanceState.getParcelable("maskedWallet");
            }
            if (savedInstanceState.containsKey("walletFragmentOptions")) {
                this.zzbqa = (WalletFragmentOptions) savedInstanceState.getParcelable("walletFragmentOptions");
            }
            if (savedInstanceState.containsKey("enabled")) {
                this.zzbqe = Boolean.valueOf(savedInstanceState.getBoolean("enabled"));
            }
        } else if (this.zzalg.getArguments() != null && (walletFragmentOptions = (WalletFragmentOptions) this.zzalg.getArguments().getParcelable("extraWalletFragmentOptions")) != null) {
            walletFragmentOptions.zzbc(this.zzalg.getActivity());
            this.zzbqa = walletFragmentOptions;
        }
        this.mCreated = true;
        this.zzbpY.onCreate(savedInstanceState);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.zzbpY.onCreateView(inflater, container, savedInstanceState);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mCreated = false;
    }

    @Override // android.support.v4.app.Fragment
    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        if (this.zzbqa == null) {
            this.zzbqa = WalletFragmentOptions.zzb(activity, attrs);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("attrKeyWalletFragmentOptions", this.zzbqa);
        this.zzbpY.onInflate(activity, bundle, savedInstanceState);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.zzbpY.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.zzbpY.onResume();
        FragmentManager supportFragmentManager = this.zzalg.getActivity().getSupportFragmentManager();
        Fragment fragmentFindFragmentByTag = supportFragmentManager.findFragmentByTag(GooglePlayServicesUtil.GMS_ERROR_DIALOG);
        if (fragmentFindFragmentByTag != null) {
            supportFragmentManager.beginTransaction().remove(fragmentFindFragmentByTag).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.zzalg.getActivity()), this.zzalg.getActivity(), -1);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        this.zzbpY.onSaveInstanceState(outState);
        if (this.zzbqb != null) {
            outState.putParcelable("walletFragmentInitParams", this.zzbqb);
            this.zzbqb = null;
        }
        if (this.zzbqc != null) {
            outState.putParcelable("maskedWalletRequest", this.zzbqc);
            this.zzbqc = null;
        }
        if (this.zzbqd != null) {
            outState.putParcelable("maskedWallet", this.zzbqd);
            this.zzbqd = null;
        }
        if (this.zzbqa != null) {
            outState.putParcelable("walletFragmentOptions", this.zzbqa);
            this.zzbqa = null;
        }
        if (this.zzbqe != null) {
            outState.putBoolean("enabled", this.zzbqe.booleanValue());
            this.zzbqe = null;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.zzbpY.onStart();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.zzbpY.onStop();
    }

    public void setEnabled(boolean enabled) {
        if (this.zzbpW == null) {
            this.zzbqe = Boolean.valueOf(enabled);
        } else {
            this.zzbpW.setEnabled(enabled);
            this.zzbqe = null;
        }
    }

    public void setOnStateChangedListener(OnStateChangedListener listener) {
        this.zzbpZ.zza(listener);
    }

    public void updateMaskedWallet(MaskedWallet maskedWallet) {
        if (this.zzbpW == null) {
            this.zzbqd = maskedWallet;
        } else {
            this.zzbpW.updateMaskedWallet(maskedWallet);
            this.zzbqd = null;
        }
    }

    public void updateMaskedWalletRequest(MaskedWalletRequest request) {
        if (this.zzbpW == null) {
            this.zzbqc = request;
        } else {
            this.zzbpW.updateMaskedWalletRequest(request);
            this.zzbqc = null;
        }
    }
}
