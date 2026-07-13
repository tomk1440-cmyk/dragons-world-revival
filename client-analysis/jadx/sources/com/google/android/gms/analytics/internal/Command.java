package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class Command implements Parcelable {

    @Deprecated
    public static final Parcelable.Creator<Command> CREATOR = new Parcelable.Creator<Command>() { // from class: com.google.android.gms.analytics.internal.Command.1
        @Override // android.os.Parcelable.Creator
        @Deprecated
        /* JADX INFO: renamed from: zzag, reason: merged with bridge method [inline-methods] */
        public Command[] newArray(int i) {
            return new Command[i];
        }

        @Override // android.os.Parcelable.Creator
        @Deprecated
        /* JADX INFO: renamed from: zzq, reason: merged with bridge method [inline-methods] */
        public Command createFromParcel(Parcel parcel) {
            return new Command(parcel);
        }
    };
    private String mValue;
    private String zzRt;
    private String zzyv;

    @Deprecated
    public Command() {
    }

    @Deprecated
    Command(Parcel in) {
        readFromParcel(in);
    }

    @Deprecated
    private void readFromParcel(Parcel in) {
        this.zzyv = in.readString();
        this.zzRt = in.readString();
        this.mValue = in.readString();
    }

    @Override // android.os.Parcelable
    @Deprecated
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzyv;
    }

    public String getValue() {
        return this.mValue;
    }

    @Override // android.os.Parcelable
    @Deprecated
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(this.zzyv);
        out.writeString(this.zzRt);
        out.writeString(this.mValue);
    }
}
