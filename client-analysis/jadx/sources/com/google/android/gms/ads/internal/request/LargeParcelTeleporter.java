package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzna;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class LargeParcelTeleporter implements SafeParcelable {
    public static final Parcelable.Creator<LargeParcelTeleporter> CREATOR = new zzl();
    final int mVersionCode;
    ParcelFileDescriptor zzIq;
    private Parcelable zzIr;
    private boolean zzIs;

    LargeParcelTeleporter(int versionCode, ParcelFileDescriptor parcelFileDescriptor) {
        this.mVersionCode = versionCode;
        this.zzIq = parcelFileDescriptor;
        this.zzIr = null;
        this.zzIs = true;
    }

    public LargeParcelTeleporter(SafeParcelable teleportee) {
        this.mVersionCode = 1;
        this.zzIq = null;
        this.zzIr = teleportee;
        this.zzIs = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        if (this.zzIq == null) {
            Parcel parcelObtain = Parcel.obtain();
            try {
                this.zzIr.writeToParcel(parcelObtain, 0);
                byte[] bArrMarshall = parcelObtain.marshall();
                parcelObtain.recycle();
                this.zzIq = zzf(bArrMarshall);
            } catch (Throwable th) {
                parcelObtain.recycle();
                throw th;
            }
        }
        zzl.zza(this, dest, flags);
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0052 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T extends SafeParcelable> T zza(Parcelable.Creator<T> creator) {
        if (this.zzIs) {
            if (this.zzIq == null) {
                zzin.e("File descriptor is empty, returning null.");
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.zzIq));
            try {
                byte[] bArr = new byte[dataInputStream.readInt()];
                dataInputStream.readFully(bArr, 0, bArr.length);
                zzna.zzb(dataInputStream);
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.unmarshall(bArr, 0, bArr.length);
                    parcelObtain.setDataPosition(0);
                    this.zzIr = creator.createFromParcel(parcelObtain);
                    parcelObtain.recycle();
                    this.zzIs = false;
                } catch (Throwable th) {
                    parcelObtain.recycle();
                    throw th;
                }
            } catch (IOException e) {
                throw new IllegalStateException("Could not read from parcel file descriptor", e);
            }
        }
        return (T) this.zzIr;
    }

    protected <T> ParcelFileDescriptor zzf(final byte[] bArr) {
        final ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        try {
            ParcelFileDescriptor[] parcelFileDescriptorArrCreatePipe = ParcelFileDescriptor.createPipe();
            autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptorArrCreatePipe[1]);
            try {
                new Thread(new Runnable() { // from class: com.google.android.gms.ads.internal.request.LargeParcelTeleporter.1
                    /* JADX WARN: Code duplicated, block: B:18:0x003e  */
                    /* JADX WARN: Code duplicated, block: B:20:0x0044  */
                    @Override // java.lang.Runnable
                    public void run() throws Throwable {
                        DataOutputStream dataOutputStream;
                        try {
                            dataOutputStream = new DataOutputStream(autoCloseOutputStream);
                            try {
                                try {
                                    dataOutputStream.writeInt(bArr.length);
                                    dataOutputStream.write(bArr);
                                    if (dataOutputStream == null) {
                                        zzna.zzb(autoCloseOutputStream);
                                    } else {
                                        zzna.zzb(dataOutputStream);
                                    }
                                } catch (IOException e) {
                                    e = e;
                                    zzin.zzb("Error transporting the ad response", e);
                                    zzr.zzbF().zzb((Throwable) e, true);
                                    if (dataOutputStream == null) {
                                        zzna.zzb(autoCloseOutputStream);
                                    } else {
                                        zzna.zzb(dataOutputStream);
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (dataOutputStream == null) {
                                    zzna.zzb(autoCloseOutputStream);
                                } else {
                                    zzna.zzb(dataOutputStream);
                                }
                                throw th;
                            }
                        } catch (IOException e2) {
                            e = e2;
                            dataOutputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                            dataOutputStream = null;
                            if (dataOutputStream == null) {
                                zzna.zzb(autoCloseOutputStream);
                            } else {
                                zzna.zzb(dataOutputStream);
                            }
                            throw th;
                        }
                    }
                }).start();
                return parcelFileDescriptorArrCreatePipe[0];
            } catch (IOException e) {
                e = e;
                zzin.zzb("Error transporting the ad response", e);
                zzr.zzbF().zzb((Throwable) e, true);
                zzna.zzb(autoCloseOutputStream);
                return null;
            }
        } catch (IOException e2) {
            e = e2;
            autoCloseOutputStream = null;
        }
    }
}
