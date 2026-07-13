package com.google.android.gms.nearby.messages.devices;

import com.google.android.gms.common.internal.zzx;
import java.nio.ByteBuffer;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
class zze extends zza {
    public zze(byte[] bArr) {
        super(zzu(bArr));
    }

    private static byte[] zzu(byte[] bArr) {
        zzx.zzb(bArr.length == 16 || bArr.length == 18 || bArr.length == 20, "Prefix must be a UUID, a UUID and a major, or a UUID, a major, and a minor.");
        return bArr;
    }

    @Override // com.google.android.gms.nearby.messages.devices.zza
    public String toString() {
        return "IBeaconIdPrefix{proximityUuid=" + zzEu() + ", major=" + zzEx() + ", minor=" + zzEy() + '}';
    }

    public UUID zzEu() {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(getBytes());
        return new UUID(byteBufferWrap.getLong(), byteBufferWrap.getLong());
    }

    public Short zzEx() {
        byte[] bytes = getBytes();
        if (bytes.length >= 18) {
            return Short.valueOf(ByteBuffer.wrap(bytes).getShort(16));
        }
        return null;
    }

    public Short zzEy() {
        byte[] bytes = getBytes();
        if (bytes.length == 20) {
            return Short.valueOf(ByteBuffer.wrap(bytes).getShort(18));
        }
        return null;
    }
}
