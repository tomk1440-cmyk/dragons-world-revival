package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.CameraPosition;

/* JADX INFO: loaded from: classes.dex */
public final class GoogleMapOptions implements SafeParcelable {
    public static final zza CREATOR = new zza();
    private final int mVersionCode;
    private Boolean zzaRP;
    private Boolean zzaRQ;
    private int zzaRR;
    private CameraPosition zzaRS;
    private Boolean zzaRT;
    private Boolean zzaRU;
    private Boolean zzaRV;
    private Boolean zzaRW;
    private Boolean zzaRX;
    private Boolean zzaRY;
    private Boolean zzaRZ;
    private Boolean zzaSa;
    private Boolean zzaSb;

    public GoogleMapOptions() {
        this.zzaRR = -1;
        this.mVersionCode = 1;
    }

    GoogleMapOptions(int versionCode, byte zOrderOnTop, byte useViewLifecycleInFragment, int mapType, CameraPosition camera, byte zoomControlsEnabled, byte compassEnabled, byte scrollGesturesEnabled, byte zoomGesturesEnabled, byte tiltGesturesEnabled, byte rotateGesturesEnabled, byte liteMode, byte mapToolbarEnabled, byte ambientEnabled) {
        this.zzaRR = -1;
        this.mVersionCode = versionCode;
        this.zzaRP = com.google.android.gms.maps.internal.zza.zza(zOrderOnTop);
        this.zzaRQ = com.google.android.gms.maps.internal.zza.zza(useViewLifecycleInFragment);
        this.zzaRR = mapType;
        this.zzaRS = camera;
        this.zzaRT = com.google.android.gms.maps.internal.zza.zza(zoomControlsEnabled);
        this.zzaRU = com.google.android.gms.maps.internal.zza.zza(compassEnabled);
        this.zzaRV = com.google.android.gms.maps.internal.zza.zza(scrollGesturesEnabled);
        this.zzaRW = com.google.android.gms.maps.internal.zza.zza(zoomGesturesEnabled);
        this.zzaRX = com.google.android.gms.maps.internal.zza.zza(tiltGesturesEnabled);
        this.zzaRY = com.google.android.gms.maps.internal.zza.zza(rotateGesturesEnabled);
        this.zzaRZ = com.google.android.gms.maps.internal.zza.zza(liteMode);
        this.zzaSa = com.google.android.gms.maps.internal.zza.zza(mapToolbarEnabled);
        this.zzaSb = com.google.android.gms.maps.internal.zza.zza(ambientEnabled);
    }

    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return null;
        }
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attrs, R.styleable.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_mapType)) {
            googleMapOptions.mapType(typedArrayObtainAttributes.getInt(R.styleable.MapAttrs_mapType, -1));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_zOrderOnTop)) {
            googleMapOptions.zOrderOnTop(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_zOrderOnTop, false));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_useViewLifecycle)) {
            googleMapOptions.useViewLifecycleInFragment(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_useViewLifecycle, false));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiCompass)) {
            googleMapOptions.compassEnabled(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiCompass, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiRotateGestures)) {
            googleMapOptions.rotateGesturesEnabled(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiRotateGestures, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiScrollGestures)) {
            googleMapOptions.scrollGesturesEnabled(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiScrollGestures, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiTiltGestures)) {
            googleMapOptions.tiltGesturesEnabled(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiTiltGestures, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiZoomGestures)) {
            googleMapOptions.zoomGesturesEnabled(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiZoomGestures, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiZoomControls)) {
            googleMapOptions.zoomControlsEnabled(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiZoomControls, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_liteMode)) {
            googleMapOptions.liteMode(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_liteMode, false));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiMapToolbar)) {
            googleMapOptions.mapToolbarEnabled(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiMapToolbar, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_ambientEnabled)) {
            googleMapOptions.ambientEnabled(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_ambientEnabled, false));
        }
        googleMapOptions.camera(CameraPosition.createFromAttributes(context, attrs));
        typedArrayObtainAttributes.recycle();
        return googleMapOptions;
    }

    public GoogleMapOptions ambientEnabled(boolean enabled) {
        this.zzaSb = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions camera(CameraPosition camera) {
        this.zzaRS = camera;
        return this;
    }

    public GoogleMapOptions compassEnabled(boolean enabled) {
        this.zzaRU = Boolean.valueOf(enabled);
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Boolean getAmbientEnabled() {
        return this.zzaSb;
    }

    public CameraPosition getCamera() {
        return this.zzaRS;
    }

    public Boolean getCompassEnabled() {
        return this.zzaRU;
    }

    public Boolean getLiteMode() {
        return this.zzaRZ;
    }

    public Boolean getMapToolbarEnabled() {
        return this.zzaSa;
    }

    public int getMapType() {
        return this.zzaRR;
    }

    public Boolean getRotateGesturesEnabled() {
        return this.zzaRY;
    }

    public Boolean getScrollGesturesEnabled() {
        return this.zzaRV;
    }

    public Boolean getTiltGesturesEnabled() {
        return this.zzaRX;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.zzaRQ;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public Boolean getZOrderOnTop() {
        return this.zzaRP;
    }

    public Boolean getZoomControlsEnabled() {
        return this.zzaRT;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.zzaRW;
    }

    public GoogleMapOptions liteMode(boolean enabled) {
        this.zzaRZ = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions mapToolbarEnabled(boolean enabled) {
        this.zzaSa = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions mapType(int mapType) {
        this.zzaRR = mapType;
        return this;
    }

    public GoogleMapOptions rotateGesturesEnabled(boolean enabled) {
        this.zzaRY = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions scrollGesturesEnabled(boolean enabled) {
        this.zzaRV = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions tiltGesturesEnabled(boolean enabled) {
        this.zzaRX = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions useViewLifecycleInFragment(boolean useViewLifecycleInFragment) {
        this.zzaRQ = Boolean.valueOf(useViewLifecycleInFragment);
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    public GoogleMapOptions zOrderOnTop(boolean zOrderOnTop) {
        this.zzaRP = Boolean.valueOf(zOrderOnTop);
        return this;
    }

    public GoogleMapOptions zoomControlsEnabled(boolean enabled) {
        this.zzaRT = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions zoomGesturesEnabled(boolean enabled) {
        this.zzaRW = Boolean.valueOf(enabled);
        return this;
    }

    byte zzzK() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaRP);
    }

    byte zzzL() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaRQ);
    }

    byte zzzM() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaRT);
    }

    byte zzzN() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaRU);
    }

    byte zzzO() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaRV);
    }

    byte zzzP() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaRW);
    }

    byte zzzQ() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaRX);
    }

    byte zzzR() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaRY);
    }

    byte zzzS() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaRZ);
    }

    byte zzzT() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaSa);
    }

    byte zzzU() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaSb);
    }
}
