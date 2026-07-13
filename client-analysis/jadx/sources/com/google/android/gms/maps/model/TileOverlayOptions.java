package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class TileOverlayOptions implements SafeParcelable {
    public static final zzo CREATOR = new zzo();
    private final int mVersionCode;
    private com.google.android.gms.maps.model.internal.zzi zzaTP;
    private TileProvider zzaTQ;
    private boolean zzaTR;
    private float zzaTh;
    private boolean zzaTi;

    public TileOverlayOptions() {
        this.zzaTi = true;
        this.zzaTR = true;
        this.mVersionCode = 1;
    }

    TileOverlayOptions(int versionCode, IBinder delegate, boolean visible, float zIndex, boolean fadeIn) {
        this.zzaTi = true;
        this.zzaTR = true;
        this.mVersionCode = versionCode;
        this.zzaTP = com.google.android.gms.maps.model.internal.zzi.zza.zzdm(delegate);
        this.zzaTQ = this.zzaTP == null ? null : new TileProvider() { // from class: com.google.android.gms.maps.model.TileOverlayOptions.1
            private final com.google.android.gms.maps.model.internal.zzi zzaTS;

            {
                this.zzaTS = TileOverlayOptions.this.zzaTP;
            }

            @Override // com.google.android.gms.maps.model.TileProvider
            public Tile getTile(int x, int y, int zoom) {
                try {
                    return this.zzaTS.getTile(x, y, zoom);
                } catch (RemoteException e) {
                    return null;
                }
            }
        };
        this.zzaTi = visible;
        this.zzaTh = zIndex;
        this.zzaTR = fadeIn;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TileOverlayOptions fadeIn(boolean fadeIn) {
        this.zzaTR = fadeIn;
        return this;
    }

    public boolean getFadeIn() {
        return this.zzaTR;
    }

    public TileProvider getTileProvider() {
        return this.zzaTQ;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public float getZIndex() {
        return this.zzaTh;
    }

    public boolean isVisible() {
        return this.zzaTi;
    }

    public TileOverlayOptions tileProvider(final TileProvider tileProvider) {
        this.zzaTQ = tileProvider;
        this.zzaTP = this.zzaTQ == null ? null : new com.google.android.gms.maps.model.internal.zzi.zza() { // from class: com.google.android.gms.maps.model.TileOverlayOptions.2
            @Override // com.google.android.gms.maps.model.internal.zzi
            public Tile getTile(int x, int y, int zoom) {
                return tileProvider.getTile(x, y, zoom);
            }
        };
        return this;
    }

    public TileOverlayOptions visible(boolean visible) {
        this.zzaTi = visible;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzo.zza(this, out, flags);
    }

    public TileOverlayOptions zIndex(float zIndex) {
        this.zzaTh = zIndex;
        return this;
    }

    IBinder zzAm() {
        return this.zzaTP.asBinder();
    }
}
