package com.google.android.gms.wearable.internal;

import android.util.Log;
import com.google.android.gms.wearable.ChannelIOException;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class zzq extends OutputStream {
    private volatile zzm zzbsk;
    private final OutputStream zzbsm;

    public zzq(OutputStream outputStream) {
        this.zzbsm = (OutputStream) com.google.android.gms.common.internal.zzx.zzz(outputStream);
    }

    private IOException zza(IOException iOException) {
        zzm zzmVar = this.zzbsk;
        if (zzmVar == null) {
            return iOException;
        }
        if (Log.isLoggable("ChannelOutputStream", 2)) {
            Log.v("ChannelOutputStream", "Caught IOException, but channel has been closed. Translating to ChannelIOException.", iOException);
        }
        return new ChannelIOException("Channel closed unexpectedly before stream was finished", zzmVar.zzbsa, zzmVar.zzbsb);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.zzbsm.close();
        } catch (IOException e) {
            throw zza(e);
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        try {
            this.zzbsm.flush();
        } catch (IOException e) {
            throw zza(e);
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        try {
            this.zzbsm.write(i);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] buffer) throws IOException {
        try {
            this.zzbsm.write(buffer);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] buffer, int offset, int count) throws IOException {
        try {
            this.zzbsm.write(buffer, offset, count);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    zzu zzIJ() {
        return new zzu() { // from class: com.google.android.gms.wearable.internal.zzq.1
            @Override // com.google.android.gms.wearable.internal.zzu
            public void zzb(zzm zzmVar) {
                zzq.this.zzc(zzmVar);
            }
        };
    }

    void zzc(zzm zzmVar) {
        this.zzbsk = zzmVar;
    }
}
