package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.devices.NearbyDeviceFilter;
import com.google.android.gms.nearby.messages.internal.MessageType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MessageFilter implements SafeParcelable {
    public static final Parcelable.Creator<MessageFilter> CREATOR = new zzb();
    public static final MessageFilter INCLUDE_ALL_MY_TYPES = new Builder().includeAllMyTypes().build();
    final int mVersionCode;
    private final List<MessageType> zzbbB;
    private final List<NearbyDeviceFilter> zzbbC;
    private final boolean zzbbD;

    public static final class Builder {
        private boolean zzbbD;
        private final List<MessageType> zzbbE = new ArrayList();
        private final List<NearbyDeviceFilter> zzbbC = new ArrayList();

        private Builder zzS(String str, String str2) {
            this.zzbbE.add(new MessageType(str, str2));
            return this;
        }

        public MessageFilter build() {
            zzx.zza(this.zzbbD || !this.zzbbE.isEmpty(), "At least one of the include methods must be called.");
            return new MessageFilter(this.zzbbE, this.zzbbC, this.zzbbD);
        }

        public Builder includeAllMyTypes() {
            this.zzbbD = true;
            return this;
        }

        public Builder includeFilter(MessageFilter filter) {
            this.zzbbE.addAll(filter.zzEo());
            this.zzbbC.addAll(filter.zzEq());
            this.zzbbD |= filter.zzEp();
            return this;
        }

        public Builder includeNamespacedType(String namespace, String type) {
            zzx.zzb((namespace == null || namespace.isEmpty() || namespace.contains("*")) ? false : true, "namespace(%s) cannot be null, empty or contain (*).", namespace);
            zzx.zzb((type == null || type.contains("*")) ? false : true, "type(%s) cannot be null or contain (*).", type);
            return zzS(namespace, type);
        }
    }

    MessageFilter(int versionCode, List<MessageType> messageTypes, List<NearbyDeviceFilter> deviceFilters, boolean includeAllMyTypes) {
        this.mVersionCode = versionCode;
        this.zzbbB = Collections.unmodifiableList((List) zzx.zzz(messageTypes));
        this.zzbbD = includeAllMyTypes;
        this.zzbbC = Collections.unmodifiableList(deviceFilters == null ? Collections.emptyList() : deviceFilters);
    }

    private MessageFilter(List<MessageType> messageTypes, List<NearbyDeviceFilter> deviceFilters, boolean includeAllMyTypes) {
        this(1, messageTypes, deviceFilters, includeAllMyTypes);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MessageFilter)) {
            return false;
        }
        MessageFilter messageFilter = (MessageFilter) o;
        return this.zzbbD == messageFilter.zzbbD && zzw.equal(this.zzbbB, messageFilter.zzbbB) && zzw.equal(this.zzbbC, messageFilter.zzbbC);
    }

    public int hashCode() {
        return zzw.hashCode(this.zzbbB, this.zzbbC, Boolean.valueOf(this.zzbbD));
    }

    public String toString() {
        return "MessageFilter{includeAllMyTypes=" + this.zzbbD + ", messageTypes=" + this.zzbbB + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }

    List<MessageType> zzEo() {
        return this.zzbbB;
    }

    boolean zzEp() {
        return this.zzbbD;
    }

    List<NearbyDeviceFilter> zzEq() {
        return this.zzbbC;
    }
}
