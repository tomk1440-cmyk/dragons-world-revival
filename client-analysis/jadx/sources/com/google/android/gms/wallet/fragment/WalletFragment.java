package com.google.android.gms.wallet.fragment;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
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
import com.google.android.gms.internal.zzrx;
import com.google.android.gms.internal.zzry;
import com.google.android.gms.internal.zzsf;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(12)
public final class WalletFragment extends Fragment {
    private WalletFragmentOptions zzbqa;
    private WalletFragmentInitParams zzbqb;
    private MaskedWalletRequest zzbqc;
    private MaskedWallet zzbqd;
    private Boolean zzbqe;
    private zzb zzbqj;
    private boolean mCreated = false;
    private final com.google.android.gms.dynamic.zzb zzbqk = com.google.android.gms.dynamic.zzb.zza(this);
    private final zzc zzbql = new zzc();
    private zza zzbqm = new zza(this);
    private final Fragment zzavH = this;

    public interface OnStateChangedListener {
        void onStateChanged(WalletFragment walletFragment, int i, int i2, Bundle bundle);
    }

    static class zza extends zzry.zza {
        private OnStateChangedListener zzbqn;
        private final WalletFragment zzbqo;

        zza(WalletFragment walletFragment) {
            this.zzbqo = walletFragment;
        }

        @Override // com.google.android.gms.internal.zzry
        public void zza(int i, int i2, Bundle bundle) {
            if (this.zzbqn != null) {
                this.zzbqn.onStateChanged(this.zzbqo, i, i2, bundle);
            }
        }

        public void zza(OnStateChangedListener onStateChangedListener) {
            this.zzbqn = onStateChangedListener;
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
            Activity activity = WalletFragment.this.zzavH.getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity), activity, -1);
        }

        @Override // com.google.android.gms.dynamic.zza
        protected void zza(FrameLayout frameLayout) {
            WalletFragmentStyle fragmentStyle;
            Button button = new Button(WalletFragment.this.zzavH.getActivity());
            button.setText(R.string.wallet_buy_button_place_holder);
            int iZza = -1;
            int iZza2 = -2;
            if (WalletFragment.this.zzbqa != null && (fragmentStyle = WalletFragment.this.zzbqa.getFragmentStyle()) != null) {
                DisplayMetrics displayMetrics = WalletFragment.this.zzavH.getResources().getDisplayMetrics();
                iZza = fragmentStyle.zza("buyButtonWidth", displayMetrics, -1);
                iZza2 = fragmentStyle.zza("buyButtonHeight", displayMetrics, -2);
            }
            button.setLayoutParams(new ViewGroup.LayoutParams(iZza, iZza2));
            button.setOnClickListener(this);
            frameLayout.addView(button);
        }

        @Override // com.google.android.gms.dynamic.zza
        protected void zza(zzf<zzb> zzfVar) {
            Activity activity = WalletFragment.this.zzavH.getActivity();
            if (WalletFragment.this.zzbqj == null && WalletFragment.this.mCreated && activity != null) {
                try {
                    zzrx zzrxVarZza = zzsf.zza(activity, WalletFragment.this.zzbqk, WalletFragment.this.zzbqa, WalletFragment.this.zzbqm);
                    WalletFragment.this.zzbqj = new zzb(zzrxVarZza);
                    WalletFragment.this.zzbqa = null;
                    zzfVar.zza(WalletFragment.this.zzbqj);
                    if (WalletFragment.this.zzbqb != null) {
                        WalletFragment.this.zzbqj.initialize(WalletFragment.this.zzbqb);
                        WalletFragment.this.zzbqb = null;
                    }
                    if (WalletFragment.this.zzbqc != null) {
                        WalletFragment.this.zzbqj.updateMaskedWalletRequest(WalletFragment.this.zzbqc);
                        WalletFragment.this.zzbqc = null;
                    }
                    if (WalletFragment.this.zzbqd != null) {
                        WalletFragment.this.zzbqj.updateMaskedWallet(WalletFragment.this.zzbqd);
                        WalletFragment.this.zzbqd = null;
                    }
                    if (WalletFragment.this.zzbqe != null) {
                        WalletFragment.this.zzbqj.setEnabled(WalletFragment.this.zzbqe.booleanValue());
                        WalletFragment.this.zzbqe = null;
                    }
                } catch (GooglePlayServicesNotAvailableException e) {
                }
            }
        }
    }

    public static WalletFragment newInstance(WalletFragmentOptions options) {
        WalletFragment walletFragment = new WalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", options);
        walletFragment.zzavH.setArguments(bundle);
        return walletFragment;
    }

    public int getState() {
        if (this.zzbqj != null) {
            return this.zzbqj.getState();
        }
        return 0;
    }

    public void initialize(WalletFragmentInitParams initParams) {
        if (this.zzbqj != null) {
            this.zzbqj.initialize(initParams);
            this.zzbqb = null;
        } else {
            if (this.zzbqb != null) {
                Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
                return;
            }
            this.zzbqb = initParams;
            if (this.zzbqc != null) {
                Log.w("WalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }
            if (this.zzbqd != null) {
                Log.w("WalletFragment", "updateMaskedWallet() was called before initialize()");
            }
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.zzbqj != null) {
            this.zzbqj.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        WalletFragmentOptions walletFragmentOptions;
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
            WalletFragmentInitParams walletFragmentInitParams = (WalletFragmentInitParams) savedInstanceState.getParcelable("walletFragmentInitParams");
            if (walletFragmentInitParams != null) {
                if (this.zzbqb != null) {
                    Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
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
        } else if (this.zzavH.getArguments() != null && (walletFragmentOptions = (WalletFragmentOptions) this.zzavH.getArguments().getParcelable("extraWalletFragmentOptions")) != null) {
            walletFragmentOptions.zzbc(this.zzavH.getActivity());
            this.zzbqa = walletFragmentOptions;
        }
        this.mCreated = true;
        this.zzbql.onCreate(savedInstanceState);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.zzbql.onCreateView(inflater, container, savedInstanceState);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mCreated = false;
    }

    @Override // android.app.Fragment
    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        if (this.zzbqa == null) {
            this.zzbqa = WalletFragmentOptions.zzb(activity, attrs);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("attrKeyWalletFragmentOptions", this.zzbqa);
        this.zzbql.onInflate(activity, bundle, savedInstanceState);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        this.zzbql.onPause();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.zzbql.onResume();
        FragmentManager fragmentManager = this.zzavH.getActivity().getFragmentManager();
        Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag(GooglePlayServicesUtil.GMS_ERROR_DIALOG);
        if (fragmentFindFragmentByTag != null) {
            fragmentManager.beginTransaction().remove(fragmentFindFragmentByTag).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.zzavH.getActivity()), this.zzavH.getActivity(), -1);
        }
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        this.zzbql.onSaveInstanceState(outState);
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

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.zzbql.onStart();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.zzbql.onStop();
    }

    public void setEnabled(boolean enabled) {
        if (this.zzbqj == null) {
            this.zzbqe = Boolean.valueOf(enabled);
        } else {
            this.zzbqj.setEnabled(enabled);
            this.zzbqe = null;
        }
    }

    public void setOnStateChangedListener(OnStateChangedListener listener) {
        this.zzbqm.zza(listener);
    }

    public void updateMaskedWallet(MaskedWallet maskedWallet) {
        if (this.zzbqj == null) {
            this.zzbqd = maskedWallet;
        } else {
            this.zzbqj.updateMaskedWallet(maskedWallet);
            this.zzbqd = null;
        }
    }

    public void updateMaskedWalletRequest(MaskedWalletRequest request) {
        if (this.zzbqj == null) {
            this.zzbqc = request;
        } else {
            this.zzbqj.updateMaskedWalletRequest(request);
            this.zzbqc = null;
        }
    }
}
