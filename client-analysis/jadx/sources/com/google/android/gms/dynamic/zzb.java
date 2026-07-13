package com.google.android.gms.dynamic;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"NewApi"})
public final class zzb extends zzc.zza {
    private Fragment zzavH;

    private zzb(Fragment fragment) {
        this.zzavH = fragment;
    }

    public static zzb zza(Fragment fragment) {
        if (fragment != null) {
            return new zzb(fragment);
        }
        return null;
    }

    @Override // com.google.android.gms.dynamic.zzc
    public Bundle getArguments() {
        return this.zzavH.getArguments();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public int getId() {
        return this.zzavH.getId();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean getRetainInstance() {
        return this.zzavH.getRetainInstance();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public String getTag() {
        return this.zzavH.getTag();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public int getTargetRequestCode() {
        return this.zzavH.getTargetRequestCode();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean getUserVisibleHint() {
        return this.zzavH.getUserVisibleHint();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public zzd getView() {
        return zze.zzC(this.zzavH.getView());
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean isAdded() {
        return this.zzavH.isAdded();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean isDetached() {
        return this.zzavH.isDetached();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean isHidden() {
        return this.zzavH.isHidden();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean isInLayout() {
        return this.zzavH.isInLayout();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean isRemoving() {
        return this.zzavH.isRemoving();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean isResumed() {
        return this.zzavH.isResumed();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean isVisible() {
        return this.zzavH.isVisible();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public void setHasOptionsMenu(boolean hasMenu) {
        this.zzavH.setHasOptionsMenu(hasMenu);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public void setMenuVisibility(boolean menuVisible) {
        this.zzavH.setMenuVisibility(menuVisible);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public void setRetainInstance(boolean retain) {
        this.zzavH.setRetainInstance(retain);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.zzavH.setUserVisibleHint(isVisibleToUser);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public void startActivity(Intent intent) {
        this.zzavH.startActivity(intent);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public void startActivityForResult(Intent intent, int requestCode) {
        this.zzavH.startActivityForResult(intent, requestCode);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public void zzn(zzd zzdVar) {
        this.zzavH.registerForContextMenu((View) zze.zzp(zzdVar));
    }

    @Override // com.google.android.gms.dynamic.zzc
    public void zzo(zzd zzdVar) {
        this.zzavH.unregisterForContextMenu((View) zze.zzp(zzdVar));
    }

    @Override // com.google.android.gms.dynamic.zzc
    public zzd zztV() {
        return zze.zzC(this.zzavH.getActivity());
    }

    @Override // com.google.android.gms.dynamic.zzc
    public zzc zztW() {
        return zza(this.zzavH.getParentFragment());
    }

    @Override // com.google.android.gms.dynamic.zzc
    public zzd zztX() {
        return zze.zzC(this.zzavH.getResources());
    }

    @Override // com.google.android.gms.dynamic.zzc
    public zzc zztY() {
        return zza(this.zzavH.getTargetFragment());
    }
}
