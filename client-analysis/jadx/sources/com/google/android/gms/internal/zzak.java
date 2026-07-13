package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.ads.afma.nano.NanoAfmaSignals;
import com.google.android.gms.common.api.GoogleApiClient;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzak implements zzaj {
    protected static GoogleApiClient zznG;
    protected DisplayMetrics zznE;
    protected zzap zznF;
    protected MotionEvent zznx;
    protected LinkedList<MotionEvent> zzny = new LinkedList<>();
    protected long zznz = 0;
    protected long zznA = 0;
    protected long zznB = 0;
    protected long zznC = 0;
    private boolean zznD = false;

    protected zzak(Context context, zzap zzapVar) {
        this.zznF = zzapVar;
        try {
            this.zznE = context.getResources().getDisplayMetrics();
        } catch (UnsupportedOperationException e) {
            this.zznE = new DisplayMetrics();
            this.zznE.density = 1.0f;
        }
    }

    private String zza(Context context, String str, boolean z) {
        NanoAfmaSignals.AFMASignals aFMASignalsZzc;
        try {
            if (z) {
                aFMASignalsZzc = zzd(context);
                this.zznD = true;
            } else {
                aFMASignalsZzc = zzc(context);
            }
            return (aFMASignalsZzc == null || aFMASignalsZzc.getSerializedSize() == 0) ? Integer.toString(5) : zza(aFMASignalsZzc, str);
        } catch (UnsupportedEncodingException e) {
            return Integer.toString(7);
        } catch (IOException e2) {
            return Integer.toString(3);
        } catch (NoSuchAlgorithmException e3) {
            return Integer.toString(7);
        }
    }

    protected String zza(NanoAfmaSignals.AFMASignals aFMASignals, String str) throws NoSuchAlgorithmException, IOException {
        return zza(zzsu.toByteArray(aFMASignals), str);
    }

    String zza(byte[] bArr, String str) throws NoSuchAlgorithmException, IOException {
        byte[] bArrArray;
        if (bArr.length > 239) {
            NanoAfmaSignals.AFMASignals aFMASignals = new NanoAfmaSignals.AFMASignals();
            aFMASignals.psnSignal = 1L;
            bArr = zzsu.toByteArray(aFMASignals);
        }
        if (bArr.length < 239) {
            byte[] bArr2 = new byte[239 - bArr.length];
            new SecureRandom().nextBytes(bArr2);
            bArrArray = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            bArrArray = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).array();
        }
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(bArrArray);
        byte[] bArrArray2 = ByteBuffer.allocate(256).put(messageDigest.digest()).put(bArrArray).array();
        byte[] bArr3 = new byte[256];
        new zzai().zzb(bArrArray2, bArr3);
        if (str != null && str.length() > 0) {
            zza(str, bArr3);
        }
        return this.zznF.zza(bArr3, true);
    }

    @Override // com.google.android.gms.internal.zzaj
    public void zza(int i, int i2, int i3) {
        if (this.zznx != null) {
            this.zznx.recycle();
        }
        this.zznx = MotionEvent.obtain(0L, i3, 1, i * this.zznE.density, i2 * this.zznE.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
    }

    @Override // com.google.android.gms.internal.zzaj
    public void zza(MotionEvent motionEvent) {
        if (this.zznD) {
            this.zznC = 0L;
            this.zznB = 0L;
            this.zznA = 0L;
            this.zznz = 0L;
            Iterator<MotionEvent> it = this.zzny.iterator();
            while (it.hasNext()) {
                it.next().recycle();
            }
            this.zzny.clear();
            this.zznx = null;
            this.zznD = false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.zznz++;
                break;
            case 1:
                this.zznx = MotionEvent.obtain(motionEvent);
                this.zzny.add(this.zznx);
                if (this.zzny.size() > 6) {
                    this.zzny.remove().recycle();
                }
                this.zznB++;
                break;
            case 2:
                this.zznA += (long) (motionEvent.getHistorySize() + 1);
                break;
            case 3:
                this.zznC++;
                break;
        }
    }

    void zza(String str, byte[] bArr) throws UnsupportedEncodingException {
        if (str.length() > 32) {
            str = str.substring(0, 32);
        }
        new zzsl(str.getBytes("UTF-8")).zzC(bArr);
    }

    @Override // com.google.android.gms.internal.zzaj
    public String zzb(Context context) {
        return zza(context, (String) null, false);
    }

    @Override // com.google.android.gms.internal.zzaj
    public String zzb(Context context, String str) {
        return zza(context, str, true);
    }

    protected abstract NanoAfmaSignals.AFMASignals zzc(Context context);

    protected abstract NanoAfmaSignals.AFMASignals zzd(Context context);

    protected String zzk(String str) {
        if (str == null || !str.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
            return str;
        }
        UUID uuidFromString = UUID.fromString(str);
        byte[] bArr = new byte[16];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.putLong(uuidFromString.getMostSignificantBits());
        byteBufferWrap.putLong(uuidFromString.getLeastSignificantBits());
        return this.zznF.zza(bArr, true);
    }
}
