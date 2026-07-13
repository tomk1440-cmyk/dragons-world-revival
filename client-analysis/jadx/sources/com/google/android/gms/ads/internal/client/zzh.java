package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.zzhb;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzh {
    public static final zzh zzug = new zzh();

    protected zzh() {
    }

    public static zzh zzcO() {
        return zzug;
    }

    public AdRequestParcel zza(Context context, zzaa zzaaVar) {
        Date birthday = zzaaVar.getBirthday();
        long time = birthday != null ? birthday.getTime() : -1L;
        String contentUrl = zzaaVar.getContentUrl();
        int gender = zzaaVar.getGender();
        Set<String> keywords = zzaaVar.getKeywords();
        List listUnmodifiableList = !keywords.isEmpty() ? Collections.unmodifiableList(new ArrayList(keywords)) : null;
        boolean zIsTestDevice = zzaaVar.isTestDevice(context);
        int iZzdd = zzaaVar.zzdd();
        Location location = zzaaVar.getLocation();
        Bundle networkExtrasBundle = zzaaVar.getNetworkExtrasBundle(AdMobAdapter.class);
        boolean manualImpressionsEnabled = zzaaVar.getManualImpressionsEnabled();
        String publisherProvidedId = zzaaVar.getPublisherProvidedId();
        SearchAdRequest searchAdRequestZzda = zzaaVar.zzda();
        SearchAdRequestParcel searchAdRequestParcel = searchAdRequestZzda != null ? new SearchAdRequestParcel(searchAdRequestZzda) : null;
        String strZza = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            strZza = zzn.zzcS().zza(Thread.currentThread().getStackTrace(), applicationContext.getPackageName());
        }
        return new AdRequestParcel(7, time, networkExtrasBundle, gender, listUnmodifiableList, zIsTestDevice, iZzdd, manualImpressionsEnabled, publisherProvidedId, searchAdRequestParcel, location, contentUrl, zzaaVar.zzdc(), zzaaVar.getCustomTargeting(), Collections.unmodifiableList(new ArrayList(zzaaVar.zzde())), zzaaVar.zzcZ(), strZza, zzaaVar.isDesignedForFamilies());
    }

    public RewardedVideoAdRequestParcel zza(Context context, zzaa zzaaVar, String str) {
        return new RewardedVideoAdRequestParcel(zza(context, zzaaVar), str);
    }
}
