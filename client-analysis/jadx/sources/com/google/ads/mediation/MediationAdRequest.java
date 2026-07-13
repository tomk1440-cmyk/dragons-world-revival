package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class MediationAdRequest {
    private final Date zzbf;
    private final AdRequest.Gender zzbg;
    private final Set<String> zzbh;
    private final boolean zzbi;
    private final Location zzbj;

    public MediationAdRequest(Date birthday, AdRequest.Gender gender, Set<String> keywords, boolean isTesting, Location location) {
        this.zzbf = birthday;
        this.zzbg = gender;
        this.zzbh = keywords;
        this.zzbi = isTesting;
        this.zzbj = location;
    }

    public Integer getAgeInYears() {
        if (this.zzbf == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTime(this.zzbf);
        Integer numValueOf = Integer.valueOf(calendar2.get(1) - calendar.get(1));
        return (calendar2.get(2) < calendar.get(2) || (calendar2.get(2) == calendar.get(2) && calendar2.get(5) < calendar.get(5))) ? Integer.valueOf(numValueOf.intValue() - 1) : numValueOf;
    }

    public Date getBirthday() {
        return this.zzbf;
    }

    public AdRequest.Gender getGender() {
        return this.zzbg;
    }

    public Set<String> getKeywords() {
        return this.zzbh;
    }

    public Location getLocation() {
        return this.zzbj;
    }

    public boolean isTesting() {
        return this.zzbi;
    }
}
