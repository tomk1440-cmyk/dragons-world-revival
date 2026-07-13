package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.internal.GamesLog;
import com.google.android.gms.internal.zzna;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes.dex */
public final class SnapshotContentsEntity implements SafeParcelable, SnapshotContents {
    private final int mVersionCode;
    private Contents zzara;
    private static final Object zzaKK = new Object();
    public static final SnapshotContentsEntityCreator CREATOR = new SnapshotContentsEntityCreator();

    SnapshotContentsEntity(int versionCode, Contents contents) {
        this.mVersionCode = versionCode;
        this.zzara = contents;
    }

    public SnapshotContentsEntity(Contents contents) {
        this(1, contents);
    }

    private boolean zza(int i, byte[] bArr, int i2, int i3, boolean z) {
        zzx.zza(!isClosed(), "Must provide a previously opened SnapshotContents");
        synchronized (zzaKK) {
            FileOutputStream fileOutputStream = new FileOutputStream(this.zzara.getParcelFileDescriptor().getFileDescriptor());
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            try {
                FileChannel channel = fileOutputStream.getChannel();
                channel.position(i);
                bufferedOutputStream.write(bArr, i2, i3);
                if (z) {
                    channel.truncate(bArr.length);
                }
                bufferedOutputStream.flush();
            } catch (IOException e) {
                GamesLog.zza("SnapshotContentsEntity", "Failed to write snapshot data", e);
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotContents
    public void close() {
        this.zzara = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotContents
    public ParcelFileDescriptor getParcelFileDescriptor() {
        zzx.zza(!isClosed(), "Cannot mutate closed contents!");
        return this.zzara.getParcelFileDescriptor();
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotContents
    public boolean isClosed() {
        return this.zzara == null;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotContents
    public boolean modifyBytes(int dstOffset, byte[] content, int srcOffset, int count) {
        return zza(dstOffset, content, srcOffset, content.length, false);
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotContents
    public byte[] readFully() throws IOException {
        byte[] bArrZza;
        zzx.zza(isClosed() ? false : true, "Must provide a previously opened Snapshot");
        synchronized (zzaKK) {
            FileInputStream fileInputStream = new FileInputStream(this.zzara.getParcelFileDescriptor().getFileDescriptor());
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            try {
                fileInputStream.getChannel().position(0L);
                bArrZza = zzna.zza(bufferedInputStream, false);
                fileInputStream.getChannel().position(0L);
            } catch (IOException e) {
                GamesLog.zzb("SnapshotContentsEntity", "Failed to read snapshot data", e);
                throw e;
            }
        }
        return bArrZza;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotContents
    public boolean writeBytes(byte[] content) {
        return zza(0, content, 0, content.length, true);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        SnapshotContentsEntityCreator.zza(this, out, flags);
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotContents
    public Contents zzsx() {
        return this.zzara;
    }
}
