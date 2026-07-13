package com.socialquantum.dw.utils.storage;

import android.os.Environment;
import android.os.StatFs;

/* JADX INFO: loaded from: classes.dex */
public class StorageUsageUtil {
    public static long getTotalSpace() {
        StatFs fs = getStatFs();
        long blocks = fs.getBlockCount();
        long blockSize = fs.getBlockSize();
        return blockSize * blocks;
    }

    public static long getFreeSpace() {
        StatFs fs = getStatFs();
        long blocks = fs.getAvailableBlocks();
        long blockSize = fs.getBlockSize();
        return blockSize * blocks;
    }

    public static boolean isStorageAvailable() {
        return Environment.getExternalStorageState() == "mounted";
    }

    private static StatFs getStatFs() {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        return new StatFs(path);
    }
}
