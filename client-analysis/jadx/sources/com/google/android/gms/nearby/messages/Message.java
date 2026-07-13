package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.devices.NearbyDevice;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class Message implements SafeParcelable {
    public static final int MAX_CONTENT_SIZE_BYTES = 102400;
    public static final int MAX_TYPE_LENGTH = 32;
    private final byte[] content;
    private final String type;
    final int versionCode;
    private final String zzamD;
    private final NearbyDevice[] zzbbA;
    public static final Parcelable.Creator<Message> CREATOR = new zza();
    private static final NearbyDevice[] zzbbz = {NearbyDevice.zzbcd};

    Message(int versionCode, byte[] content, String namespace, String type, NearbyDevice[] devices) {
        this.versionCode = versionCode;
        this.type = (String) zzx.zzz(type);
        this.zzamD = namespace == null ? "" : namespace;
        if (zzR(this.zzamD, this.type)) {
            zzx.zzb(content == null, "Content must be null for a device presence message.");
        } else {
            zzx.zzz(content);
            zzx.zzb(content.length <= 102400, "Content length(%d) must not exceed MAX_CONTENT_SIZE_BYTES(%d)", Integer.valueOf(content.length), Integer.valueOf(MAX_CONTENT_SIZE_BYTES));
        }
        this.content = content;
        this.zzbbA = (devices == null || devices.length == 0) ? zzbbz : devices;
        zzx.zzb(type.length() <= 32, "Type length(%d) must not exceed MAX_TYPE_LENGTH(%d)", Integer.valueOf(type.length()), 32);
    }

    public Message(byte[] content) {
        this(content, "", "");
    }

    public Message(byte[] content, String type) {
        this(content, "", type);
    }

    public Message(byte[] content, String namespace, String type) {
        this(content, namespace, type, zzbbz);
    }

    public Message(byte[] content, String namespace, String type, NearbyDevice[] devices) {
        this(2, content, namespace, type, devices);
    }

    public static boolean zzR(String str, String str2) {
        return str.equals("__reserved_namespace") && str2.equals("__device_presence");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Message)) {
            return false;
        }
        Message message = (Message) object;
        return TextUtils.equals(this.zzamD, message.zzamD) && TextUtils.equals(this.type, message.type) && Arrays.equals(this.content, message.content);
    }

    public byte[] getContent() {
        return this.content;
    }

    public String getNamespace() {
        return this.zzamD;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzamD, this.type, Integer.valueOf(Arrays.hashCode(this.content)));
    }

    public String toString() {
        return "Message{namespace='" + this.zzamD + "', type='" + this.type + "', content=[" + (this.content == null ? 0 : this.content.length) + " bytes], devices=" + Arrays.toString(zzEn()) + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    public NearbyDevice[] zzEn() {
        return this.zzbbA;
    }
}
