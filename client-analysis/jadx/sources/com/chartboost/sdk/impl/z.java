package com.chartboost.sdk.impl;

import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public class z extends ai {
    static final Logger a = Logger.getLogger("com.mongodb");
    static final boolean b = Boolean.getBoolean("DEBUG.MONGO");
    public static final ByteOrder c;
    static final int d;
    static final ba e;

    static {
        if (a.getLevel() == null) {
            if (b) {
                a.setLevel(Level.ALL);
            } else {
                a.setLevel(Level.WARNING);
            }
        }
        c = ByteOrder.LITTLE_ENDIAN;
        d = Integer.parseInt(System.getProperty("MONGO.POOLSIZE", "10"));
        e = new ba(-1, -1, -1);
    }
}
