package com.unity3d.ads.cache;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.unity3d.ads.log.DeviceLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class CacheDirectory {
    private static final String TEST_FILE_NAME = "UnityAdsTest.txt";
    private String _cacheDirName;
    private boolean _initialized = false;
    private File _cacheDirectory = null;

    public CacheDirectory(String cacheDirName) {
        this._cacheDirName = cacheDirName;
    }

    public File getCacheDirectory(Context context) {
        if (this._initialized) {
            return this._cacheDirectory;
        }
        this._initialized = true;
        if (Build.VERSION.SDK_INT > 18) {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                File externalCache = createCacheDirectory(context.getExternalCacheDir(), this._cacheDirName);
                if (testCacheDirectory(externalCache)) {
                    this._cacheDirectory = externalCache;
                    DeviceLog.debug("Unity Ads is using external cache directory: " + externalCache.getAbsolutePath());
                    return this._cacheDirectory;
                }
            } else {
                DeviceLog.debug("External media not mounted");
            }
        }
        File internalCache = context.getFilesDir();
        if (testCacheDirectory(internalCache)) {
            this._cacheDirectory = internalCache;
            DeviceLog.debug("Unity Ads is using internal cache directory: " + internalCache.getAbsolutePath());
            return this._cacheDirectory;
        }
        DeviceLog.error("Unity Ads failed to initialize cache directory");
        return null;
    }

    public File createCacheDirectory(File baseDir, String newDir) {
        if (baseDir == null) {
            return null;
        }
        File directory = new File(baseDir, newDir);
        directory.mkdirs();
        if (directory.isDirectory()) {
            return directory;
        }
        return null;
    }

    public boolean testCacheDirectory(File directory) {
        boolean z = false;
        if (directory != null && directory.isDirectory()) {
            try {
                byte[] inData = "test".getBytes("UTF-8");
                byte[] outData = new byte[inData.length];
                File testFile = new File(directory, TEST_FILE_NAME);
                FileOutputStream fos = new FileOutputStream(testFile);
                fos.write(inData);
                fos.flush();
                fos.close();
                if (directory.listFiles() == null) {
                    DeviceLog.debug("Failed to list files in directory " + directory.getAbsolutePath());
                } else {
                    FileInputStream fis = new FileInputStream(testFile);
                    int readCount = fis.read(outData, 0, outData.length);
                    fis.close();
                    if (!testFile.delete()) {
                        DeviceLog.debug("Failed to delete testfile " + testFile.getAbsoluteFile());
                    } else if (readCount != outData.length) {
                        DeviceLog.debug("Read buffer size mismatch");
                    } else {
                        String result = new String(outData, "UTF-8");
                        if (result.equals("test")) {
                            z = true;
                        } else {
                            DeviceLog.debug("Read buffer content mismatch");
                        }
                    }
                }
            } catch (Exception e) {
                DeviceLog.debug("Unity Ads exception while testing cache directory " + directory.getAbsolutePath() + ": " + e.getMessage());
            }
        }
        return z;
    }
}
