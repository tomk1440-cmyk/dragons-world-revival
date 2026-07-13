package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.v4.media.TransportMediator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public final class PasswordSpecification implements SafeParcelable {
    public static final zzf CREATOR = new zzf();
    public static final PasswordSpecification zzWl = new zza().zzh(12, 16).zzbG("abcdefghijkmnopqrstxyzABCDEFGHJKLMNPQRSTXY3456789").zze("abcdefghijkmnopqrstxyz", 1).zze("ABCDEFGHJKLMNPQRSTXY", 1).zze("3456789", 1).zzmA();
    public static final PasswordSpecification zzWm = new zza().zzh(12, 16).zzbG("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890").zze("abcdefghijklmnopqrstuvwxyz", 1).zze("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1).zze("1234567890", 1).zzmA();
    final int mVersionCode;
    final String zzWn;
    final List<String> zzWo;
    final List<Integer> zzWp;
    final int zzWq;
    final int zzWr;
    private final int[] zzWs = zzmz();
    private final Random zzuy = new SecureRandom();

    public static class zza {
        private final TreeSet<Character> zzWt = new TreeSet<>();
        private final List<String> zzWo = new ArrayList();
        private final List<Integer> zzWp = new ArrayList();
        private int zzWq = 12;
        private int zzWr = 16;

        private void zzmB() {
            int i;
            int iIntValue = 0;
            Iterator<Integer> it = this.zzWp.iterator();
            while (true) {
                i = iIntValue;
                if (!it.hasNext()) {
                    break;
                } else {
                    iIntValue = it.next().intValue() + i;
                }
            }
            if (i > this.zzWr) {
                throw new zzb("required character count cannot be greater than the max password size");
            }
        }

        private void zzmC() {
            boolean[] zArr = new boolean[95];
            Iterator<String> it = this.zzWo.iterator();
            while (it.hasNext()) {
                for (char c : it.next().toCharArray()) {
                    if (zArr[c - ' ']) {
                        throw new zzb("character " + c + " occurs in more than one required character set");
                    }
                    zArr[c - ' '] = true;
                }
            }
        }

        private TreeSet<Character> zzq(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                throw new zzb(str2 + " cannot be null or empty");
            }
            TreeSet<Character> treeSet = new TreeSet<>();
            for (char c : str.toCharArray()) {
                if (PasswordSpecification.zzb(c, 32, TransportMediator.KEYCODE_MEDIA_PLAY)) {
                    throw new zzb(str2 + " must only contain ASCII printable characters");
                }
                treeSet.add(Character.valueOf(c));
            }
            return treeSet;
        }

        public zza zzbG(@NonNull String str) {
            this.zzWt.addAll(zzq(str, "allowedChars"));
            return this;
        }

        public zza zze(@NonNull String str, int i) {
            if (i < 1) {
                throw new zzb("count must be at least 1");
            }
            this.zzWo.add(PasswordSpecification.zzb(zzq(str, "requiredChars")));
            this.zzWp.add(Integer.valueOf(i));
            return this;
        }

        public zza zzh(int i, int i2) {
            if (i < 1) {
                throw new zzb("minimumSize must be at least 1");
            }
            if (i > i2) {
                throw new zzb("maximumSize must be greater than or equal to minimumSize");
            }
            this.zzWq = i;
            this.zzWr = i2;
            return this;
        }

        public PasswordSpecification zzmA() {
            if (this.zzWt.isEmpty()) {
                throw new zzb("no allowed characters specified");
            }
            zzmB();
            zzmC();
            return new PasswordSpecification(1, PasswordSpecification.zzb(this.zzWt), this.zzWo, this.zzWp, this.zzWq, this.zzWr);
        }
    }

    public static class zzb extends Error {
        public zzb(String str) {
            super(str);
        }
    }

    PasswordSpecification(int version, String allowedChars, List<String> requiredCharSets, List<Integer> requiredCharCounts, int minimumSize, int maximumSize) {
        this.mVersionCode = version;
        this.zzWn = allowedChars;
        this.zzWo = Collections.unmodifiableList(requiredCharSets);
        this.zzWp = Collections.unmodifiableList(requiredCharCounts);
        this.zzWq = minimumSize;
        this.zzWr = maximumSize;
    }

    private int zza(char c) {
        return c - ' ';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzb(Collection<Character> collection) {
        char[] cArr = new char[collection.size()];
        int i = 0;
        Iterator<Character> it = collection.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return new String(cArr);
            }
            i = i2 + 1;
            cArr[i2] = it.next().charValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzb(int i, int i2, int i3) {
        return i < i2 || i > i3;
    }

    private int[] zzmz() {
        int[] iArr = new int[95];
        Arrays.fill(iArr, -1);
        Iterator<String> it = this.zzWo.iterator();
        int i = 0;
        while (it.hasNext()) {
            for (char c : it.next().toCharArray()) {
                iArr[zza(c)] = i;
            }
            i++;
        }
        return iArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzf.zza(this, out, flags);
    }
}
