package com.google.android.gms.cast.internal;

import com.google.android.gms.common.api.Api;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;

/* JADX INFO: loaded from: classes.dex */
public final class zzk {
    public static final Api.zzc<zze> zzUI = new Api.zzc<>();
    public static final Charset zzaec;

    static {
        Charset charsetForName = null;
        try {
            charsetForName = Charset.forName("UTF-8");
        } catch (IllegalCharsetNameException e) {
        } catch (UnsupportedCharsetException e2) {
        }
        zzaec = charsetForName;
    }
}
