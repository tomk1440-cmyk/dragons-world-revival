package com.chartboost.sdk.impl;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class ag {
    private static Pattern a = Pattern.compile("\\s+", 40);

    public static class a extends RuntimeException {
        final String a;

        a(String str) {
            super(str);
            this.a = str;
        }

        @Override // java.lang.Throwable
        public String toString() {
            return this.a;
        }
    }

    public static void a(int i, int i2) {
        if (i != i2) {
            throw new a(i + " != " + i2);
        }
    }
}
