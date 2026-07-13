package com.google.android.gms.location.places;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.places.internal.zzn;

/* JADX INFO: loaded from: classes.dex */
public class PlaceLikelihoodBuffer extends AbstractDataBuffer<PlaceLikelihood> implements Result {
    private final Context mContext;
    private final Status zzUX;
    private final String zzaPy;
    private final int zzvr;

    public static class zza {
        static int zzhP(int i) {
            switch (i) {
                case 100:
                case Quests.SELECT_COMPLETED_UNCLAIMED /* 101 */:
                case 102:
                case Quests.SELECT_RECENTLY_FAILED /* 103 */:
                case LocationRequest.PRIORITY_LOW_POWER /* 104 */:
                case LocationRequest.PRIORITY_NO_POWER /* 105 */:
                case 106:
                case 107:
                case 108:
                    return i;
                default:
                    throw new IllegalArgumentException("invalid source: " + i);
            }
        }
    }

    public PlaceLikelihoodBuffer(DataHolder dataHolder, int source, Context context) {
        super(dataHolder);
        this.mContext = context;
        this.zzUX = PlacesStatusCodes.zzhU(dataHolder.getStatusCode());
        this.zzvr = zza.zzhP(source);
        if (dataHolder == null || dataHolder.zzpZ() == null) {
            this.zzaPy = null;
        } else {
            this.zzaPy = dataHolder.zzpZ().getString("com.google.android.gms.location.places.PlaceLikelihoodBuffer.ATTRIBUTIONS_EXTRA_KEY");
        }
    }

    public static int zzH(Bundle bundle) {
        return bundle.getInt("com.google.android.gms.location.places.PlaceLikelihoodBuffer.SOURCE_EXTRA_KEY");
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public PlaceLikelihood get(int position) {
        return new zzn(this.zzahi, position, this.mContext);
    }

    @Nullable
    public CharSequence getAttributions() {
        return this.zzaPy;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzUX;
    }

    public String toString() {
        return zzw.zzy(this).zzg("status", getStatus()).zzg("attributions", this.zzaPy).toString();
    }
}
