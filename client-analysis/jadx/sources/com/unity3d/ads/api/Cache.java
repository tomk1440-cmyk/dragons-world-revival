package com.unity3d.ads.api;

import android.annotation.TargetApi;
import android.media.MediaMetadataRetriever;
import android.util.Base64;
import android.util.SparseArray;
import com.facebook.share.internal.ShareConstants;
import com.unity3d.ads.cache.CacheError;
import com.unity3d.ads.cache.CacheThread;
import com.unity3d.ads.device.Device;
import com.unity3d.ads.log.DeviceLog;
import com.unity3d.ads.misc.Utilities;
import com.unity3d.ads.properties.SdkProperties;
import com.unity3d.ads.request.WebRequestError;
import com.unity3d.ads.webview.bridge.WebViewCallback;
import com.unity3d.ads.webview.bridge.WebViewExposed;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Cache {
    @WebViewExposed
    public static void download(String url, String fileId, JSONArray headers, WebViewCallback callback) {
        if (CacheThread.isActive()) {
            callback.error(CacheError.FILE_ALREADY_CACHING, new Object[0]);
            return;
        }
        if (!Device.isActiveNetworkConnected()) {
            callback.error(CacheError.NO_INTERNET, new Object[0]);
            return;
        }
        try {
            HashMap<String, List<String>> mappedHeaders = Request.getHeadersMap(headers);
            CacheThread.download(url, fileIdToFilename(fileId), mappedHeaders);
            callback.invoke(new Object[0]);
        } catch (Exception e) {
            DeviceLog.exception("Error mapping headers for the request", e);
            callback.error(WebRequestError.MAPPING_HEADERS_FAILED, url, fileId);
        }
    }

    @WebViewExposed
    public static void stop(WebViewCallback callback) {
        if (!CacheThread.isActive()) {
            callback.error(CacheError.NOT_CACHING, new Object[0]);
        } else {
            CacheThread.cancel();
            callback.invoke(new Object[0]);
        }
    }

    @WebViewExposed
    public static void isCaching(WebViewCallback callback) {
        callback.invoke(Boolean.valueOf(CacheThread.isActive()));
    }

    @WebViewExposed
    public static void getFileContent(String fileId, String encoding, WebViewCallback callback) {
        String fileName = fileIdToFilename(fileId);
        File f = new File(fileName);
        if (f.exists()) {
            try {
                byte[] byteData = Utilities.readFileBytes(f);
                String fileContents = new String(byteData);
                if (encoding != null && encoding.length() > 0) {
                    if (encoding.equals("UTF-8")) {
                        try {
                            fileContents = new String(byteData, "UTF-8");
                        } catch (UnsupportedEncodingException e) {
                            callback.error(CacheError.UNSUPPORTED_ENCODING, fileId, fileName, encoding);
                            return;
                        }
                    } else if (encoding.equals("Base64")) {
                        fileContents = Base64.encodeToString(byteData, 2);
                    } else {
                        callback.error(CacheError.UNSUPPORTED_ENCODING, fileId, fileName, encoding);
                        return;
                    }
                }
                callback.invoke(fileContents);
                return;
            } catch (IOException e2) {
                callback.error(CacheError.FILE_IO_ERROR, fileId, fileName, e2.getMessage() + ", " + e2.getClass().getName());
                return;
            }
        }
        callback.error(CacheError.FILE_NOT_FOUND, fileId, fileName);
    }

    @WebViewExposed
    public static void getFiles(WebViewCallback callback) {
        File cacheDirectory = SdkProperties.getCacheDirectory();
        if (cacheDirectory != null) {
            DeviceLog.debug("Unity Ads cache: checking app directory for Unity Ads cached files");
            FilenameFilter filter = new FilenameFilter() { // from class: com.unity3d.ads.api.Cache.1
                @Override // java.io.FilenameFilter
                public boolean accept(File dir, String filename) {
                    return filename.startsWith(SdkProperties.getCacheFilePrefix());
                }
            };
            File[] fileList = cacheDirectory.listFiles(filter);
            if (fileList == null || fileList.length == 0) {
                callback.invoke(new JSONArray());
            }
            try {
                JSONArray files = new JSONArray();
                for (File f : fileList) {
                    String name = f.getName().substring(SdkProperties.getCacheFilePrefix().length());
                    DeviceLog.debug("Unity Ads cache: found " + name + ", " + f.length() + " bytes");
                    files.put(getFileJson(name));
                }
                callback.invoke(files);
            } catch (JSONException e) {
                DeviceLog.exception("Error creating JSON", e);
                callback.error(CacheError.JSON_ERROR, new Object[0]);
            }
        }
    }

    @WebViewExposed
    public static void getFileInfo(String fileId, WebViewCallback callback) {
        try {
            JSONObject result = getFileJson(fileId);
            callback.invoke(result);
        } catch (JSONException e) {
            DeviceLog.exception("Error creating JSON", e);
            callback.error(CacheError.JSON_ERROR, new Object[0]);
        }
    }

    @WebViewExposed
    public static void getFilePath(String fileId, WebViewCallback callback) {
        File f = new File(fileIdToFilename(fileId));
        if (f.exists()) {
            callback.invoke(fileIdToFilename(fileId));
        } else {
            callback.error(CacheError.FILE_NOT_FOUND, new Object[0]);
        }
    }

    @WebViewExposed
    public static void deleteFile(String fileId, WebViewCallback callback) {
        File file = new File(fileIdToFilename(fileId));
        if (file.delete()) {
            callback.invoke(new Object[0]);
        } else {
            callback.error(CacheError.FILE_IO_ERROR, new Object[0]);
        }
    }

    @WebViewExposed
    public static void getHash(String fileId, WebViewCallback callback) {
        callback.invoke(Utilities.Sha256(fileId));
    }

    @WebViewExposed
    public static void setTimeouts(Integer connectTimeout, Integer readTimeout, WebViewCallback callback) {
        CacheThread.setConnectTimeout(connectTimeout.intValue());
        CacheThread.setReadTimeout(readTimeout.intValue());
        callback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void getTimeouts(WebViewCallback callback) {
        callback.invoke(Integer.valueOf(CacheThread.getConnectTimeout()), Integer.valueOf(CacheThread.getReadTimeout()));
    }

    @WebViewExposed
    public static void setProgressInterval(Integer interval, WebViewCallback callback) {
        CacheThread.setProgressInterval(interval.intValue());
        callback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void getProgressInterval(WebViewCallback callback) {
        callback.invoke(Integer.valueOf(CacheThread.getProgressInterval()));
    }

    @WebViewExposed
    public static void getFreeSpace(WebViewCallback callback) {
        callback.invoke(Long.valueOf(Device.getFreeSpace(SdkProperties.getCacheDirectory())));
    }

    @WebViewExposed
    public static void getTotalSpace(WebViewCallback callback) {
        callback.invoke(Long.valueOf(Device.getTotalSpace(SdkProperties.getCacheDirectory())));
    }

    @WebViewExposed
    public static void getMetaData(String fileId, JSONArray requestedMetaDatas, WebViewCallback webViewCallback) {
        String videoFile = fileIdToFilename(fileId);
        try {
            SparseArray<String> returnValues = getMetaData(videoFile, requestedMetaDatas);
            JSONArray returnJsonArray = new JSONArray();
            for (int i = 0; i < returnValues.size(); i++) {
                JSONArray entryJsonArray = new JSONArray();
                entryJsonArray.put(returnValues.keyAt(i));
                entryJsonArray.put(returnValues.valueAt(i));
                returnJsonArray.put(entryJsonArray);
            }
            webViewCallback.invoke(returnJsonArray);
        } catch (IOException e) {
            webViewCallback.error(CacheError.FILE_IO_ERROR, e.getMessage());
        } catch (RuntimeException e2) {
            webViewCallback.error(CacheError.INVALID_ARGUMENT, e2.getMessage());
        } catch (JSONException e3) {
            webViewCallback.error(CacheError.JSON_ERROR, e3.getMessage());
        }
    }

    @TargetApi(10)
    private static SparseArray<String> getMetaData(String videoFile, JSONArray requestedMetaDatas) throws JSONException, IOException, RuntimeException {
        File f = new File(videoFile);
        SparseArray<String> returnArray = new SparseArray<>();
        if (f.exists()) {
            MediaMetadataRetriever metadataRetriever = new MediaMetadataRetriever();
            metadataRetriever.setDataSource(f.getAbsolutePath());
            for (int i = 0; i < requestedMetaDatas.length(); i++) {
                int metaDataKey = requestedMetaDatas.getInt(i);
                String metaDataValue = metadataRetriever.extractMetadata(metaDataKey);
                if (metaDataValue != null) {
                    returnArray.put(metaDataKey, metaDataValue);
                }
            }
            return returnArray;
        }
        throw new IOException("File: " + f.getAbsolutePath() + " doesn't exist");
    }

    private static String fileIdToFilename(String fileId) {
        return SdkProperties.getCacheDirectory() + "/" + SdkProperties.getCacheFilePrefix() + fileId;
    }

    private static JSONObject getFileJson(String fileId) throws JSONException {
        JSONObject fileJson = new JSONObject();
        fileJson.put(ShareConstants.WEB_DIALOG_PARAM_ID, fileId);
        File f = new File(fileIdToFilename(fileId));
        if (f.exists()) {
            fileJson.put("found", true);
            fileJson.put("size", f.length());
            fileJson.put("mtime", f.lastModified());
        } else {
            fileJson.put("found", false);
        }
        return fileJson;
    }
}
