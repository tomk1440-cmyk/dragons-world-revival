package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.support.annotation.RequiresPermission;
import android.view.View;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.ILocationSourceDelegate;
import com.google.android.gms.maps.internal.zzab;
import com.google.android.gms.maps.internal.zzg;
import com.google.android.gms.maps.internal.zzi;
import com.google.android.gms.maps.internal.zzj;
import com.google.android.gms.maps.internal.zzk;
import com.google.android.gms.maps.internal.zzl;
import com.google.android.gms.maps.internal.zzm;
import com.google.android.gms.maps.internal.zzn;
import com.google.android.gms.maps.internal.zzp;
import com.google.android.gms.maps.internal.zzq;
import com.google.android.gms.maps.internal.zzr;
import com.google.android.gms.maps.internal.zzs;
import com.google.android.gms.maps.internal.zzu;
import com.google.android.gms.maps.internal.zzv;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.IPolylineDelegate;
import com.google.android.gms.maps.model.internal.zzc;
import com.google.android.gms.maps.model.internal.zzd;
import com.google.android.gms.maps.model.internal.zzf;
import com.google.android.gms.maps.model.internal.zzh;

/* JADX INFO: loaded from: classes.dex */
public final class GoogleMap {
    public static final int MAP_TYPE_HYBRID = 4;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MAP_TYPE_TERRAIN = 3;
    private final IGoogleMapDelegate zzaRr;
    private UiSettings zzaRs;

    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);
    }

    public interface OnGroundOverlayClickListener {
        void onGroundOverlayClick(GroundOverlay groundOverlay);
    }

    public interface OnIndoorStateChangeListener {
        void onIndoorBuildingFocused();

        void onIndoorLevelActivated(IndoorBuilding indoorBuilding);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    public interface OnInfoWindowCloseListener {
        void onInfoWindowClose(Marker marker);
    }

    public interface OnInfoWindowLongClickListener {
        void onInfoWindowLongClick(Marker marker);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    public interface OnMyLocationButtonClickListener {
        boolean onMyLocationButtonClick();
    }

    @Deprecated
    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    public interface OnPolygonClickListener {
        void onPolygonClick(Polygon polygon);
    }

    public interface OnPolylineClickListener {
        void onPolylineClick(Polyline polyline);
    }

    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    private static final class zza extends com.google.android.gms.maps.internal.zzb.zza {
        private final CancelableCallback zzaRO;

        zza(CancelableCallback cancelableCallback) {
            this.zzaRO = cancelableCallback;
        }

        @Override // com.google.android.gms.maps.internal.zzb
        public void onCancel() {
            this.zzaRO.onCancel();
        }

        @Override // com.google.android.gms.maps.internal.zzb
        public void onFinish() {
            this.zzaRO.onFinish();
        }
    }

    protected GoogleMap(IGoogleMapDelegate map) {
        this.zzaRr = (IGoogleMapDelegate) zzx.zzz(map);
    }

    public final Circle addCircle(CircleOptions options) {
        try {
            return new Circle(this.zzaRr.addCircle(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions options) {
        try {
            zzc zzcVarAddGroundOverlay = this.zzaRr.addGroundOverlay(options);
            if (zzcVarAddGroundOverlay != null) {
                return new GroundOverlay(zzcVarAddGroundOverlay);
            }
            return null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Marker addMarker(MarkerOptions options) {
        try {
            zzf zzfVarAddMarker = this.zzaRr.addMarker(options);
            if (zzfVarAddMarker != null) {
                return new Marker(zzfVarAddMarker);
            }
            return null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polygon addPolygon(PolygonOptions options) {
        try {
            return new Polygon(this.zzaRr.addPolygon(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polyline addPolyline(PolylineOptions options) {
        try {
            return new Polyline(this.zzaRr.addPolyline(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions options) {
        try {
            zzh zzhVarAddTileOverlay = this.zzaRr.addTileOverlay(options);
            if (zzhVarAddTileOverlay != null) {
                return new TileOverlay(zzhVarAddTileOverlay);
            }
            return null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update) {
        try {
            this.zzaRr.animateCamera(update.zzzH());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update, int durationMs, CancelableCallback callback) {
        try {
            this.zzaRr.animateCameraWithDurationAndCallback(update.zzzH(), durationMs, callback == null ? null : new zza(callback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update, CancelableCallback callback) {
        try {
            this.zzaRr.animateCameraWithCallback(update.zzzH(), callback == null ? null : new zza(callback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void clear() {
        try {
            this.zzaRr.clear();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final CameraPosition getCameraPosition() {
        try {
            return this.zzaRr.getCameraPosition();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public IndoorBuilding getFocusedBuilding() {
        try {
            zzd focusedBuilding = this.zzaRr.getFocusedBuilding();
            if (focusedBuilding != null) {
                return new IndoorBuilding(focusedBuilding);
            }
            return null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getMapType() {
        try {
            return this.zzaRr.getMapType();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMaxZoomLevel() {
        try {
            return this.zzaRr.getMaxZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMinZoomLevel() {
        try {
            return this.zzaRr.getMinZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public final Location getMyLocation() {
        try {
            return this.zzaRr.getMyLocation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Projection getProjection() {
        try {
            return new Projection(this.zzaRr.getProjection());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final UiSettings getUiSettings() {
        try {
            if (this.zzaRs == null) {
                this.zzaRs = new UiSettings(this.zzaRr.getUiSettings());
            }
            return this.zzaRs;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isBuildingsEnabled() {
        try {
            return this.zzaRr.isBuildingsEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isIndoorEnabled() {
        try {
            return this.zzaRr.isIndoorEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isMyLocationEnabled() {
        try {
            return this.zzaRr.isMyLocationEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return this.zzaRr.isTrafficEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void moveCamera(CameraUpdate update) {
        try {
            this.zzaRr.moveCamera(update.zzzH());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setBuildingsEnabled(boolean enabled) {
        try {
            this.zzaRr.setBuildingsEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setContentDescription(String description) {
        try {
            this.zzaRr.setContentDescription(description);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean setIndoorEnabled(boolean enabled) {
        try {
            return this.zzaRr.setIndoorEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setInfoWindowAdapter(final InfoWindowAdapter adapter) {
        try {
            if (adapter == null) {
                this.zzaRr.setInfoWindowAdapter(null);
            } else {
                this.zzaRr.setInfoWindowAdapter(new com.google.android.gms.maps.internal.zzd.zza() { // from class: com.google.android.gms.maps.GoogleMap.3
                    @Override // com.google.android.gms.maps.internal.zzd
                    public com.google.android.gms.dynamic.zzd zzb(zzf zzfVar) {
                        return zze.zzC(adapter.getInfoWindow(new Marker(zzfVar)));
                    }

                    @Override // com.google.android.gms.maps.internal.zzd
                    public com.google.android.gms.dynamic.zzd zzc(zzf zzfVar) {
                        return zze.zzC(adapter.getInfoContents(new Marker(zzfVar)));
                    }
                });
            }
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setLocationSource(final LocationSource source) {
        try {
            if (source == null) {
                this.zzaRr.setLocationSource(null);
            } else {
                this.zzaRr.setLocationSource(new ILocationSourceDelegate.zza() { // from class: com.google.android.gms.maps.GoogleMap.11
                    @Override // com.google.android.gms.maps.internal.ILocationSourceDelegate
                    public void activate(final zzk listener) {
                        source.activate(new LocationSource.OnLocationChangedListener() { // from class: com.google.android.gms.maps.GoogleMap.11.1
                            @Override // com.google.android.gms.maps.LocationSource.OnLocationChangedListener
                            public void onLocationChanged(Location location) {
                                try {
                                    listener.zzd(location);
                                } catch (RemoteException e) {
                                    throw new RuntimeRemoteException(e);
                                }
                            }
                        });
                    }

                    @Override // com.google.android.gms.maps.internal.ILocationSourceDelegate
                    public void deactivate() {
                        source.deactivate();
                    }
                });
            }
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMapType(int type) {
        try {
            this.zzaRr.setMapType(type);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public final void setMyLocationEnabled(boolean enabled) {
        try {
            this.zzaRr.setMyLocationEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnCameraChangeListener(final OnCameraChangeListener listener) {
        try {
            if (listener == null) {
                this.zzaRr.setOnCameraChangeListener(null);
            } else {
                this.zzaRr.setOnCameraChangeListener(new com.google.android.gms.maps.internal.zze.zza() { // from class: com.google.android.gms.maps.GoogleMap.12
                    @Override // com.google.android.gms.maps.internal.zze
                    public void onCameraChange(CameraPosition position) {
                        listener.onCameraChange(position);
                    }
                });
            }
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnGroundOverlayClickListener(final OnGroundOverlayClickListener listener) {
        try {
            if (listener == null) {
                this.zzaRr.setOnGroundOverlayClickListener(null);
            } else {
                this.zzaRr.setOnGroundOverlayClickListener(new com.google.android.gms.maps.internal.zzf.zza() { // from class: com.google.android.gms.maps.GoogleMap.7
                    @Override // com.google.android.gms.maps.internal.zzf
                    public void zza(zzc zzcVar) {
                        listener.onGroundOverlayClick(new GroundOverlay(zzcVar));
                    }
                });
            }
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnIndoorStateChangeListener(final OnIndoorStateChangeListener listener) {
        try {
            if (listener == null) {
                this.zzaRr.setOnIndoorStateChangeListener(null);
            } else {
                this.zzaRr.setOnIndoorStateChangeListener(new zzg.zza() { // from class: com.google.android.gms.maps.GoogleMap.1
                    @Override // com.google.android.gms.maps.internal.zzg
                    public void onIndoorBuildingFocused() {
                        listener.onIndoorBuildingFocused();
                    }

                    @Override // com.google.android.gms.maps.internal.zzg
                    public void zza(zzd zzdVar) {
                        listener.onIndoorLevelActivated(new IndoorBuilding(zzdVar));
                    }
                });
            }
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnInfoWindowClickListener(final OnInfoWindowClickListener listener) {
        try {
            if (listener == null) {
                this.zzaRr.setOnInfoWindowClickListener(null);
            } else {
                this.zzaRr.setOnInfoWindowClickListener(new com.google.android.gms.maps.internal.zzh.zza() { // from class: com.google.android.gms.maps.GoogleMap.17
                    @Override // com.google.android.gms.maps.internal.zzh
                    public void zzh(zzf zzfVar) {
                        listener.onInfoWindowClick(new Marker(zzfVar));
                    }
                });
            }
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnInfoWindowCloseListener(final OnInfoWindowCloseListener listener) {
        try {
            if (listener == null) {
                this.zzaRr.setOnInfoWindowCloseListener(null);
            } else {
                this.zzaRr.setOnInfoWindowCloseListener(new zzi.zza() { // from class: com.google.android.gms.maps.GoogleMap.2
                    @Override // com.google.android.gms.maps.internal.zzi
                    public void zza(zzf zzfVar) {
                        listener.onInfoWindowClose(new Marker(zzfVar));
                    }
                });
            }
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnInfoWindowLongClickListener(final OnInfoWindowLongClickListener listener) {
        try {
            if (listener == null) {
                this.zzaRr.setOnInfoWindowLongClickListener(null);
            } else {
                this.zzaRr.setOnInfoWindowLongClickListener(new zzj.zza() { // from class: com.google.android.gms.maps.GoogleMap.18
                    @Override // com.google.android.gms.maps.internal.zzj
                    public void zzi(zzf zzfVar) {
                        listener.onInfoWindowLongClick(new Marker(zzfVar));
                    }
                });
            }
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnMapClickListener(final OnMapClickListener listener) {
        try {
            if (listener == null) {
                this.zzaRr.setOnMapClickListener(null);
            } else {
                this.zzaRr.setOnMapClickListener(new zzl.zza() { // from class: com.google.android.gms.maps.GoogleMap.13
                    @Override // com.google.android.gms.maps.internal.zzl
                    public void onMapClick(LatLng point) {
                        listener.onMapClick(point);
                    }
                });
            }
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setOnMapLoadedCallback(final OnMapLoadedCallback callback) {
        try {
            if (callback == null) {
                this.zzaRr.setOnMapLoadedCallback(null);
            } else {
                this.zzaRr.setOnMapLoadedCallback(new zzm.zza() { // from class: com.google.android.gms.maps.GoogleMap.6
                    @Override // com.google.android.gms.maps.internal.zzm
                    public void onMapLoaded() throws RemoteException {
                        callback.onMapLoaded();
                    }
                });
            }
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnMapLongClickListener(final OnMapLongClickListener listener) {
        try {
            if (listener == null) {
                this.zzaRr.setOnMapLongClickListener(null);
            } else {
                this.zzaRr.setOnMapLongClickListener(new zzn.zza() { // from class: com.google.android.gms.maps.GoogleMap.14
                    @Override // com.google.android.gms.maps.internal.zzn
                    public void onMapLongClick(LatLng point) {
                        listener.onMapLongClick(point);
                    }
                });
            }
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnMarkerClickListener(final OnMarkerClickListener listener) {
        try {
            if (listener == null) {
                this.zzaRr.setOnMarkerClickListener(null);
            } else {
                this.zzaRr.setOnMarkerClickListener(new zzp.zza() { // from class: com.google.android.gms.maps.GoogleMap.15
                    @Override // com.google.android.gms.maps.internal.zzp
                    public boolean zzd(zzf zzfVar) {
                        return listener.onMarkerClick(new Marker(zzfVar));
                    }
                });
            }
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnMarkerDragListener(final OnMarkerDragListener listener) {
        try {
            if (listener == null) {
                this.zzaRr.setOnMarkerDragListener(null);
            } else {
                this.zzaRr.setOnMarkerDragListener(new zzq.zza() { // from class: com.google.android.gms.maps.GoogleMap.16
                    @Override // com.google.android.gms.maps.internal.zzq
                    public void zze(zzf zzfVar) {
                        listener.onMarkerDragStart(new Marker(zzfVar));
                    }

                    @Override // com.google.android.gms.maps.internal.zzq
                    public void zzf(zzf zzfVar) {
                        listener.onMarkerDragEnd(new Marker(zzfVar));
                    }

                    @Override // com.google.android.gms.maps.internal.zzq
                    public void zzg(zzf zzfVar) {
                        listener.onMarkerDrag(new Marker(zzfVar));
                    }
                });
            }
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnMyLocationButtonClickListener(final OnMyLocationButtonClickListener listener) {
        try {
            if (listener == null) {
                this.zzaRr.setOnMyLocationButtonClickListener(null);
            } else {
                this.zzaRr.setOnMyLocationButtonClickListener(new zzr.zza() { // from class: com.google.android.gms.maps.GoogleMap.5
                    @Override // com.google.android.gms.maps.internal.zzr
                    public boolean onMyLocationButtonClick() throws RemoteException {
                        return listener.onMyLocationButtonClick();
                    }
                });
            }
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public final void setOnMyLocationChangeListener(final OnMyLocationChangeListener listener) {
        try {
            if (listener == null) {
                this.zzaRr.setOnMyLocationChangeListener(null);
            } else {
                this.zzaRr.setOnMyLocationChangeListener(new zzs.zza() { // from class: com.google.android.gms.maps.GoogleMap.4
                    @Override // com.google.android.gms.maps.internal.zzs
                    public void zzq(com.google.android.gms.dynamic.zzd zzdVar) {
                        listener.onMyLocationChange((Location) zze.zzp(zzdVar));
                    }
                });
            }
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnPolygonClickListener(final OnPolygonClickListener listener) {
        try {
            if (listener == null) {
                this.zzaRr.setOnPolygonClickListener(null);
            } else {
                this.zzaRr.setOnPolygonClickListener(new zzu.zza() { // from class: com.google.android.gms.maps.GoogleMap.8
                    @Override // com.google.android.gms.maps.internal.zzu
                    public void zza(com.google.android.gms.maps.model.internal.zzg zzgVar) {
                        listener.onPolygonClick(new Polygon(zzgVar));
                    }
                });
            }
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnPolylineClickListener(final OnPolylineClickListener listener) {
        try {
            if (listener == null) {
                this.zzaRr.setOnPolylineClickListener(null);
            } else {
                this.zzaRr.setOnPolylineClickListener(new zzv.zza() { // from class: com.google.android.gms.maps.GoogleMap.9
                    @Override // com.google.android.gms.maps.internal.zzv
                    public void zza(IPolylineDelegate iPolylineDelegate) {
                        listener.onPolylineClick(new Polyline(iPolylineDelegate));
                    }
                });
            }
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setPadding(int left, int top, int right, int bottom) {
        try {
            this.zzaRr.setPadding(left, top, right, bottom);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setTrafficEnabled(boolean enabled) {
        try {
            this.zzaRr.setTrafficEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void snapshot(SnapshotReadyCallback callback) {
        snapshot(callback, null);
    }

    public final void snapshot(final SnapshotReadyCallback callback, Bitmap bitmap) {
        try {
            this.zzaRr.snapshot(new zzab.zza() { // from class: com.google.android.gms.maps.GoogleMap.10
                @Override // com.google.android.gms.maps.internal.zzab
                public void onSnapshotReady(Bitmap snapshot) throws RemoteException {
                    callback.onSnapshotReady(snapshot);
                }

                @Override // com.google.android.gms.maps.internal.zzab
                public void zzr(com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException {
                    callback.onSnapshotReady((Bitmap) zze.zzp(zzdVar));
                }
            }, (zze) (bitmap != null ? zze.zzC(bitmap) : null));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void stopAnimation() {
        try {
            this.zzaRr.stopAnimation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    IGoogleMapDelegate zzzJ() {
        return this.zzaRr;
    }
}
