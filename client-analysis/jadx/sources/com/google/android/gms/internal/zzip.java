package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class zzip {

    private static abstract class zza extends zzim {
        private zza() {
        }

        @Override // com.google.android.gms.internal.zzim
        public void onStop() {
        }
    }

    public interface zzb {
        void zze(Bundle bundle);
    }

    public static Future zza(final Context context, final int i) {
        return new zza() { // from class: com.google.android.gms.internal.zzip.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.android.gms.internal.zzim
            public void zzbr() {
                SharedPreferences.Editor editorEdit = zzip.zzw(context).edit();
                editorEdit.putInt("webview_cache_version", i);
                editorEdit.apply();
            }
        }.zzgd();
    }

    public static Future zza(final Context context, final zzb zzbVar) {
        return new zza() { // from class: com.google.android.gms.internal.zzip.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.android.gms.internal.zzim
            public void zzbr() {
                SharedPreferences sharedPreferencesZzw = zzip.zzw(context);
                Bundle bundle = new Bundle();
                bundle.putBoolean("use_https", sharedPreferencesZzw.getBoolean("use_https", true));
                if (zzbVar != null) {
                    zzbVar.zze(bundle);
                }
            }
        }.zzgd();
    }

    public static Future zza(final Context context, final boolean z) {
        return new zza() { // from class: com.google.android.gms.internal.zzip.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.android.gms.internal.zzim
            public void zzbr() {
                SharedPreferences.Editor editorEdit = zzip.zzw(context).edit();
                editorEdit.putBoolean("use_https", z);
                editorEdit.apply();
            }
        }.zzgd();
    }

    public static Future zzb(final Context context, final zzb zzbVar) {
        return new zza() { // from class: com.google.android.gms.internal.zzip.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.android.gms.internal.zzim
            public void zzbr() {
                SharedPreferences sharedPreferencesZzw = zzip.zzw(context);
                Bundle bundle = new Bundle();
                bundle.putInt("webview_cache_version", sharedPreferencesZzw.getInt("webview_cache_version", 0));
                if (zzbVar != null) {
                    zzbVar.zze(bundle);
                }
            }
        }.zzgd();
    }

    public static Future zzb(final Context context, final boolean z) {
        return new zza() { // from class: com.google.android.gms.internal.zzip.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.android.gms.internal.zzim
            public void zzbr() {
                SharedPreferences.Editor editorEdit = zzip.zzw(context).edit();
                editorEdit.putBoolean("content_url_opted_out", z);
                editorEdit.apply();
            }
        }.zzgd();
    }

    public static Future zzc(final Context context, final zzb zzbVar) {
        return new zza() { // from class: com.google.android.gms.internal.zzip.6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.android.gms.internal.zzim
            public void zzbr() {
                SharedPreferences sharedPreferencesZzw = zzip.zzw(context);
                Bundle bundle = new Bundle();
                bundle.putBoolean("content_url_opted_out", sharedPreferencesZzw.getBoolean("content_url_opted_out", true));
                if (zzbVar != null) {
                    zzbVar.zze(bundle);
                }
            }
        }.zzgd();
    }

    public static Future zzd(final Context context, final zzb zzbVar) {
        return new zza() { // from class: com.google.android.gms.internal.zzip.8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.android.gms.internal.zzim
            public void zzbr() {
                SharedPreferences sharedPreferencesZzw = zzip.zzw(context);
                Bundle bundle = new Bundle();
                bundle.putString("content_url_hashes", sharedPreferencesZzw.getString("content_url_hashes", ""));
                if (zzbVar != null) {
                    zzbVar.zze(bundle);
                }
            }
        }.zzgd();
    }

    public static Future zzd(final Context context, final String str) {
        return new zza() { // from class: com.google.android.gms.internal.zzip.7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.android.gms.internal.zzim
            public void zzbr() {
                SharedPreferences.Editor editorEdit = zzip.zzw(context).edit();
                editorEdit.putString("content_url_hashes", str);
                editorEdit.apply();
            }
        }.zzgd();
    }

    public static SharedPreferences zzw(Context context) {
        return context.getSharedPreferences("admob", 0);
    }
}
