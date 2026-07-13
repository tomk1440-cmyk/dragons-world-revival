package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class zze {
    public static final zze zzakF = zza("\t\n\u000b\f\r \u0085\u1680\u2028\u2029\u205f\u3000 \u180e ").zza(zza(8192, 8202));
    public static final zze zzakG = zza("\t\n\u000b\f\r \u0085\u1680\u2028\u2029\u205f\u3000").zza(zza(8192, 8198)).zza(zza(8200, 8202));
    public static final zze zzakH = zza(0, 127);
    public static final zze zzakI;
    public static final zze zzakJ;
    public static final zze zzakK;
    public static final zze zzakL;
    public static final zze zzakM;
    public static final zze zzakN;
    public static final zze zzakO;
    public static final zze zzakP;
    public static final zze zzakQ;
    public static final zze zzakR;
    public static final zze zzakS;
    public static final zze zzakT;

    private static class zza extends zze {
        List<zze> zzala;

        zza(List<zze> list) {
            this.zzala = list;
        }

        @Override // com.google.android.gms.common.internal.zze
        public zze zza(zze zzeVar) {
            ArrayList arrayList = new ArrayList(this.zzala);
            arrayList.add(zzx.zzz(zzeVar));
            return new zza(arrayList);
        }

        @Override // com.google.android.gms.common.internal.zze
        public boolean zzd(char c) {
            Iterator<zze> it = this.zzala.iterator();
            while (it.hasNext()) {
                if (it.next().zzd(c)) {
                    return true;
                }
            }
            return false;
        }
    }

    static {
        zze zzeVarZza = zza('0', '9');
        zze zzeVarZza2 = zzeVarZza;
        for (char c : "٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray()) {
            zzeVarZza2 = zzeVarZza2.zza(zza(c, (char) (c + '\t')));
        }
        zzakI = zzeVarZza2;
        zzakJ = zza('\t', '\r').zza(zza((char) 28, ' ')).zza(zzc((char) 5760)).zza(zzc((char) 6158)).zza(zza((char) 8192, (char) 8198)).zza(zza((char) 8200, (char) 8203)).zza(zza((char) 8232, (char) 8233)).zza(zzc((char) 8287)).zza(zzc((char) 12288));
        zzakK = new zze() { // from class: com.google.android.gms.common.internal.zze.1
            @Override // com.google.android.gms.common.internal.zze
            public boolean zzd(char c2) {
                return Character.isDigit(c2);
            }
        };
        zzakL = new zze() { // from class: com.google.android.gms.common.internal.zze.5
            @Override // com.google.android.gms.common.internal.zze
            public boolean zzd(char c2) {
                return Character.isLetter(c2);
            }
        };
        zzakM = new zze() { // from class: com.google.android.gms.common.internal.zze.6
            @Override // com.google.android.gms.common.internal.zze
            public boolean zzd(char c2) {
                return Character.isLetterOrDigit(c2);
            }
        };
        zzakN = new zze() { // from class: com.google.android.gms.common.internal.zze.7
            @Override // com.google.android.gms.common.internal.zze
            public boolean zzd(char c2) {
                return Character.isUpperCase(c2);
            }
        };
        zzakO = new zze() { // from class: com.google.android.gms.common.internal.zze.8
            @Override // com.google.android.gms.common.internal.zze
            public boolean zzd(char c2) {
                return Character.isLowerCase(c2);
            }
        };
        zzakP = zza((char) 0, (char) 31).zza(zza((char) 127, (char) 159));
        zzakQ = zza((char) 0, ' ').zza(zza((char) 127, (char) 160)).zza(zzc((char) 173)).zza(zza((char) 1536, (char) 1539)).zza(zza("\u06dd\u070f\u1680឴឵\u180e")).zza(zza((char) 8192, (char) 8207)).zza(zza((char) 8232, (char) 8239)).zza(zza((char) 8287, (char) 8292)).zza(zza((char) 8298, (char) 8303)).zza(zzc((char) 12288)).zza(zza((char) 55296, (char) 63743)).zza(zza("\ufeff\ufff9\ufffa\ufffb"));
        zzakR = zza((char) 0, (char) 1273).zza(zzc((char) 1470)).zza(zza((char) 1488, (char) 1514)).zza(zzc((char) 1523)).zza(zzc((char) 1524)).zza(zza((char) 1536, (char) 1791)).zza(zza((char) 1872, (char) 1919)).zza(zza((char) 3584, (char) 3711)).zza(zza((char) 7680, (char) 8367)).zza(zza((char) 8448, (char) 8506)).zza(zza((char) 64336, (char) 65023)).zza(zza((char) 65136, (char) 65279)).zza(zza((char) 65377, (char) 65500));
        zzakS = new zze() { // from class: com.google.android.gms.common.internal.zze.9
            @Override // com.google.android.gms.common.internal.zze
            public zze zza(zze zzeVar) {
                zzx.zzz(zzeVar);
                return this;
            }

            @Override // com.google.android.gms.common.internal.zze
            public boolean zzb(CharSequence charSequence) {
                zzx.zzz(charSequence);
                return true;
            }

            @Override // com.google.android.gms.common.internal.zze
            public boolean zzd(char c2) {
                return true;
            }
        };
        zzakT = new zze() { // from class: com.google.android.gms.common.internal.zze.10
            @Override // com.google.android.gms.common.internal.zze
            public zze zza(zze zzeVar) {
                return (zze) zzx.zzz(zzeVar);
            }

            @Override // com.google.android.gms.common.internal.zze
            public boolean zzb(CharSequence charSequence) {
                return charSequence.length() == 0;
            }

            @Override // com.google.android.gms.common.internal.zze
            public boolean zzd(char c2) {
                return false;
            }
        };
    }

    public static zze zza(final char c, final char c2) {
        zzx.zzac(c2 >= c);
        return new zze() { // from class: com.google.android.gms.common.internal.zze.4
            @Override // com.google.android.gms.common.internal.zze
            public boolean zzd(char c3) {
                return c <= c3 && c3 <= c2;
            }
        };
    }

    public static zze zza(CharSequence charSequence) {
        switch (charSequence.length()) {
            case 0:
                return zzakT;
            case 1:
                return zzc(charSequence.charAt(0));
            case 2:
                final char cCharAt = charSequence.charAt(0);
                final char cCharAt2 = charSequence.charAt(1);
                return new zze() { // from class: com.google.android.gms.common.internal.zze.2
                    @Override // com.google.android.gms.common.internal.zze
                    public boolean zzd(char c) {
                        return c == cCharAt || c == cCharAt2;
                    }
                };
            default:
                final char[] charArray = charSequence.toString().toCharArray();
                Arrays.sort(charArray);
                return new zze() { // from class: com.google.android.gms.common.internal.zze.3
                    @Override // com.google.android.gms.common.internal.zze
                    public boolean zzd(char c) {
                        return Arrays.binarySearch(charArray, c) >= 0;
                    }
                };
        }
    }

    public static zze zzc(final char c) {
        return new zze() { // from class: com.google.android.gms.common.internal.zze.11
            @Override // com.google.android.gms.common.internal.zze
            public zze zza(zze zzeVar) {
                return zzeVar.zzd(c) ? zzeVar : super.zza(zzeVar);
            }

            @Override // com.google.android.gms.common.internal.zze
            public boolean zzd(char c2) {
                return c2 == c;
            }
        };
    }

    public zze zza(zze zzeVar) {
        return new zza(Arrays.asList(this, (zze) zzx.zzz(zzeVar)));
    }

    public boolean zzb(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!zzd(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public abstract boolean zzd(char c);
}
