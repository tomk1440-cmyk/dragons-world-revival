package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class zzr extends zzt implements Place {
    private final String zzaPH;

    public zzr(DataHolder dataHolder, int i, Context context) {
        super(dataHolder, i);
        this.zzaPH = zzG("place_id", "");
    }

    private PlaceImpl zzzA() {
        PlaceImpl placeImplZzzx = new PlaceImpl.zza().zzeo(getAddress().toString()).zzy(zzzq()).zzem(getId()).zzan(zzzr()).zza(getLatLng()).zzf(zzzo()).zzen(getName().toString()).zzep(getPhoneNumber().toString()).zzhX(getPriceLevel()).zzg(getRating()).zzx(getPlaceTypes()).zza(getViewport()).zzo(getWebsiteUri()).zzzx();
        placeImplZzzx.setLocale(getLocale());
        return placeImplZzzx;
    }

    private List<String> zzzq() {
        return zzb("place_attributions", Collections.emptyList());
    }

    @Override // com.google.android.gms.location.places.Place
    public CharSequence getAddress() {
        return zzG("place_address", "");
    }

    @Override // com.google.android.gms.location.places.Place
    public CharSequence getAttributions() {
        return zzc.zzj(zzzq());
    }

    @Override // com.google.android.gms.location.places.Place
    public String getId() {
        return this.zzaPH;
    }

    @Override // com.google.android.gms.location.places.Place
    public LatLng getLatLng() {
        return (LatLng) zza("place_lat_lng", LatLng.CREATOR);
    }

    @Override // com.google.android.gms.location.places.Place
    public Locale getLocale() {
        String strZzG = zzG("place_locale", "");
        return !TextUtils.isEmpty(strZzG) ? new Locale(strZzG) : Locale.getDefault();
    }

    @Override // com.google.android.gms.location.places.Place
    public CharSequence getName() {
        return zzG("place_name", "");
    }

    @Override // com.google.android.gms.location.places.Place
    public CharSequence getPhoneNumber() {
        return zzG("place_phone_number", "");
    }

    @Override // com.google.android.gms.location.places.Place
    public List<Integer> getPlaceTypes() {
        return zza("place_types", Collections.emptyList());
    }

    @Override // com.google.android.gms.location.places.Place
    public int getPriceLevel() {
        return zzz("place_price_level", -1);
    }

    @Override // com.google.android.gms.location.places.Place
    public float getRating() {
        return zzb("place_rating", -1.0f);
    }

    @Override // com.google.android.gms.location.places.Place
    public LatLngBounds getViewport() {
        return (LatLngBounds) zza("place_viewport", LatLngBounds.CREATOR);
    }

    @Override // com.google.android.gms.location.places.Place
    public Uri getWebsiteUri() {
        String strZzG = zzG("place_website_uri", null);
        if (strZzG == null) {
            return null;
        }
        return Uri.parse(strZzG);
    }

    public float zzzo() {
        return zzb("place_level_number", 0.0f);
    }

    public boolean zzzr() {
        return zzl("place_is_permanently_closed", false);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzzw, reason: merged with bridge method [inline-methods] */
    public Place freeze() {
        return zzzA();
    }
}
