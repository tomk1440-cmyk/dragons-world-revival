package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class Strategy implements SafeParcelable {
    public static final int DISCOVERY_MODE_BROADCAST = 1;
    public static final int DISCOVERY_MODE_DEFAULT = 3;
    public static final int DISCOVERY_MODE_SCAN = 2;
    public static final int DISTANCE_TYPE_DEFAULT = 0;
    public static final int DISTANCE_TYPE_EARSHOT = 1;
    public static final int TTL_SECONDS_DEFAULT = 300;
    public static final int TTL_SECONDS_MAX = 86400;
    final int mVersionCode;

    @Deprecated
    final int zzbbL;
    final int zzbbM;
    final int zzbbN;

    @Deprecated
    final boolean zzbbO;
    final int zzbbP;
    final int zzbbQ;
    public static final Parcelable.Creator<Strategy> CREATOR = new zzd();
    public static final Strategy DEFAULT = new Builder().build();
    public static final int TTL_SECONDS_INFINITE = Integer.MAX_VALUE;
    public static final Strategy BLE_ONLY = new Builder().zzjg(2).setTtlSeconds(TTL_SECONDS_INFINITE).build();

    @Deprecated
    public static final Strategy zzbbK = BLE_ONLY;

    public static class Builder {
        private int zzbbR = 3;
        private int zzbbS = Strategy.TTL_SECONDS_DEFAULT;
        private int zzbbT = 0;
        private int zzbbU = -1;

        public Strategy build() {
            if (this.zzbbU == 2 && this.zzbbT == 1) {
                throw new IllegalStateException("Cannot set EARSHOT with BLE only mode.");
            }
            return new Strategy(2, 0, this.zzbbS, this.zzbbT, false, this.zzbbU, this.zzbbR);
        }

        public Builder setDiscoveryMode(int discoveryMode) {
            this.zzbbR = discoveryMode;
            return this;
        }

        public Builder setDistanceType(int distanceType) {
            this.zzbbT = distanceType;
            return this;
        }

        public Builder setTtlSeconds(int ttlSeconds) {
            zzx.zzb(ttlSeconds == Integer.MAX_VALUE || (ttlSeconds > 0 && ttlSeconds <= 86400), "mTtlSeconds(%d) must either be TTL_SECONDS_INFINITE, or it must be between 1 and TTL_SECONDS_MAX(%d) inclusive", Integer.valueOf(ttlSeconds), Integer.valueOf(Strategy.TTL_SECONDS_MAX));
            this.zzbbS = ttlSeconds;
            return this;
        }

        public Builder zzjg(int i) {
            this.zzbbU = i;
            return this;
        }
    }

    Strategy(int versionCode, int broadcastScanStrategy, int ttlSeconds, int distanceType, boolean isBleBeaconStrategy, int discoveryMedium, int discoveryMode) {
        this.mVersionCode = versionCode;
        this.zzbbL = broadcastScanStrategy;
        if (broadcastScanStrategy != 0) {
            switch (broadcastScanStrategy) {
                case 2:
                    this.zzbbQ = 1;
                    break;
                case 3:
                    this.zzbbQ = 2;
                    break;
                default:
                    this.zzbbQ = 3;
                    break;
            }
        } else {
            this.zzbbQ = discoveryMode;
        }
        this.zzbbN = distanceType;
        this.zzbbO = isBleBeaconStrategy;
        if (isBleBeaconStrategy) {
            this.zzbbP = 2;
            this.zzbbM = TTL_SECONDS_INFINITE;
        }
        this.zzbbM = ttlSeconds;
        switch (discoveryMedium) {
            case -1:
            case 0:
            case 1:
            case 6:
                this.zzbbP = -1;
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            default:
                this.zzbbP = discoveryMedium;
                break;
        }
    }

    private static String zzjd(int i) {
        switch (i) {
            case 0:
                return "DEFAULT";
            case 1:
                return "EARSHOT";
            default:
                return "UNKNOWN:" + i;
        }
    }

    private static String zzje(int i) {
        if (i == -1) {
            return "DEFAULT";
        }
        ArrayList arrayList = new ArrayList();
        if ((i & 4) > 0) {
            arrayList.add("AUDIO");
        }
        if ((i & 2) > 0) {
            arrayList.add("BLE");
        }
        return arrayList.isEmpty() ? "UNKNOWN:" + i : arrayList.toString();
    }

    private static String zzjf(int i) {
        if (i == 3) {
            return "DEFAULT";
        }
        ArrayList arrayList = new ArrayList();
        if ((i & 1) > 0) {
            arrayList.add("BROADCAST");
        }
        if ((i & 2) > 0) {
            arrayList.add("SCAN");
        }
        return arrayList.isEmpty() ? "UNKNOWN:" + i : arrayList.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Strategy)) {
            return false;
        }
        Strategy strategy = (Strategy) other;
        return this.mVersionCode == strategy.mVersionCode && this.zzbbQ == strategy.zzbbQ && this.zzbbM == strategy.zzbbM && this.zzbbN == strategy.zzbbN && this.zzbbP == strategy.zzbbP;
    }

    public int hashCode() {
        return (((((((this.mVersionCode * 31) + this.zzbbQ) * 31) + this.zzbbM) * 31) + this.zzbbN) * 31) + this.zzbbP;
    }

    public String toString() {
        return "Strategy{ttlSeconds=" + this.zzbbM + ", distanceType=" + zzjd(this.zzbbN) + ", discoveryMedium=" + zzje(this.zzbbP) + ", discoveryMode=" + zzjf(this.zzbbQ) + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzd.zza(this, out, flags);
    }

    public int zzEr() {
        return this.zzbbP;
    }

    public int zzEs() {
        return this.zzbbQ;
    }
}
