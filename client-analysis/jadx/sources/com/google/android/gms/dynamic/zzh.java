package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class zzh extends zzc.zza {
    private Fragment zzalg;

    private zzh(Fragment fragment) {
        this.zzalg = fragment;
    }

    public static zzh zza(Fragment fragment) {
        if (fragment != null) {
            return new zzh(fragment);
        }
        return null;
    }

    @Override // com.google.android.gms.dynamic.zzc
    public Bundle getArguments() {
        return this.zzalg.getArguments();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public int getId() {
        return this.zzalg.getId();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean getRetainInstance() {
        return this.zzalg.getRetainInstance();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public String getTag() {
        return this.zzalg.getTag();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public int getTargetRequestCode() {
        return this.zzalg.getTargetRequestCode();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean getUserVisibleHint() {
        return this.zzalg.getUserVisibleHint();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public zzd getView() {
        return zze.zzC(this.zzalg.getView());
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean isAdded() {
        return this.zzalg.isAdded();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean isDetached() {
        return this.zzalg.isDetached();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean isHidden() {
        return this.zzalg.isHidden();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean isInLayout() {
        return this.zzalg.isInLayout();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean isRemoving() {
        return this.zzalg.isRemoving();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean isResumed() {
        return this.zzalg.isResumed();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean isVisible() {
        return this.zzalg.isVisible();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public void setHasOptionsMenu(boolean hasMenu) {
        this.zzalg.setHasOptionsMenu(hasMenu);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public void setMenuVisibility(boolean menuVisible) {
        this.zzalg.setMenuVisibility(menuVisible);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public void setRetainInstance(boolean retain) {
        this.zzalg.setRetainInstance(retain);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.zzalg.setUserVisibleHint(isVisibleToUser);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public void startActivity(Intent intent) {
        this.zzalg.startActivity(intent);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public void startActivityForResult(Intent intent, int requestCode) {
        this.zzalg.startActivityForResult(intent, requestCode);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public void zzn(zzd zzdVar) {
        this.zzalg.registerForContextMenu((View) zze.zzp(zzdVar));
    }

    @Override // com.google.android.gms.dynamic.zzc
    public void zzo(zzd zzdVar) {
        this.zzalg.unregisterForContextMenu((View) zze.zzp(zzdVar));
    }

    @Override // com.google.android.gms.dynamic.zzc
    public zzd zztV() {
        return zze.zzC(this.zzalg.getActivity());
    }

    @Override // com.google.android.gms.dynamic.zzc
    public zzc zztW() {
        return zza(this.zzalg.getParentFragment());
    }

    @Override // com.google.android.gms.dynamic.zzc
    public zzd zztX() {
        return zze.zzC(this.zzalg.getResources());
    }

    @Override // com.google.android.gms.dynamic.zzc
    public zzc zztY() {
        return zza(this.zzalg.getTargetFragment());
    }
}
