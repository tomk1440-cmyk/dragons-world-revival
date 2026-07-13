package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.ChannelIOException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class zzp extends InputStream {
    private final InputStream zzbsj;
    private volatile zzm zzbsk;

    public zzp(InputStream inputStream) {
        this.zzbsj = (InputStream) com.google.android.gms.common.internal.zzx.zzz(inputStream);
    }

    private int zzlK(int i) throws ChannelIOException {
        zzm zzmVar;
        if (i != -1 || (zzmVar = this.zzbsk) == null) {
            return i;
        }
        throw new ChannelIOException("Channel closed unexpectedly before stream was finished", zzmVar.zzbsa, zzmVar.zzbsb);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.zzbsj.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.zzbsj.close();
    }

    @Override // java.io.InputStream
    public void mark(int readlimit) {
        this.zzbsj.mark(readlimit);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.zzbsj.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return zzlK(this.zzbsj.read());
    }

    @Override // java.io.InputStream
    public int read(byte[] buffer) throws IOException {
        return zzlK(this.zzbsj.read(buffer));
    }

    @Override // java.io.InputStream
    public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        return zzlK(this.zzbsj.read(buffer, byteOffset, byteCount));
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.zzbsj.reset();
    }

    @Override // java.io.InputStream
    public long skip(long byteCount) throws IOException {
        return this.zzbsj.skip(byteCount);
    }

    zzu zzIJ() {
        return new zzu() { // from class: com.google.android.gms.wearable.internal.zzp.1
            @Override // com.google.android.gms.wearable.internal.zzu
            public void zzb(zzm zzmVar) {
                zzp.this.zza(zzmVar);
            }
        };
    }

    void zza(zzm zzmVar) {
        this.zzbsk = (zzm) com.google.android.gms.common.internal.zzx.zzz(zzmVar);
    }
}
