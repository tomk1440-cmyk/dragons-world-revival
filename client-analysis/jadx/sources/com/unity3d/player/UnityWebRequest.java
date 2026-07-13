package com.unity3d.player;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.security.cert.CertPathValidatorException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes.dex */
class UnityWebRequest implements Runnable {
    private long a;
    private String b;
    private String c;
    private Map d;
    private int e;
    private long f;

    UnityWebRequest(long j, String str, Map map, String str2, int i) {
        this.a = j;
        this.b = str2;
        this.c = str;
        this.d = map;
        this.e = i;
    }

    private static native void contentLengthCallback(long j, int i);

    private static native boolean downloadCallback(long j, ByteBuffer byteBuffer, int i);

    private static native void errorCallback(long j, int i, String str);

    private boolean hasTimedOut() {
        return this.e > 0 && System.currentTimeMillis() - this.f >= ((long) this.e);
    }

    private static native void headerCallback(long j, String str, String str2);

    private static native void responseCodeCallback(long j, int i);

    private static native int uploadCallback(long j, ByteBuffer byteBuffer);

    protected void badProtocolCallback(String str) {
        errorCallback(this.a, 4, str);
    }

    protected void contentLengthCallback(int i) {
        contentLengthCallback(this.a, i);
    }

    protected boolean downloadCallback(ByteBuffer byteBuffer, int i) {
        return downloadCallback(this.a, byteBuffer, i);
    }

    protected void errorCallback(String str) {
        errorCallback(this.a, 2, str);
    }

    protected void headerCallback(String str, String str2) {
        headerCallback(this.a, str, str2);
    }

    protected void headerCallback(Map map) {
        if (map == null || map.size() == 0) {
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (str == null) {
                str = "Status";
            }
            Iterator it = ((List) entry.getValue()).iterator();
            while (it.hasNext()) {
                headerCallback(str, (String) it.next());
            }
        }
    }

    protected void malformattedUrlCallback(String str) {
        errorCallback(this.a, 5, str);
    }

    protected void responseCodeCallback(int i) {
        responseCodeCallback(this.a, i);
    }

    @Override // java.lang.Runnable
    public void run() {
        InputStream inputStream;
        SSLSocketFactory sSLSocketFactoryA;
        this.f = System.currentTimeMillis();
        try {
            URL url = new URL(this.b);
            URLConnection uRLConnectionOpenConnection = url.openConnection();
            uRLConnectionOpenConnection.setConnectTimeout(this.e);
            uRLConnectionOpenConnection.setReadTimeout(this.e);
            if ((uRLConnectionOpenConnection instanceof HttpsURLConnection) && (sSLSocketFactoryA = a.a()) != null) {
                ((HttpsURLConnection) uRLConnectionOpenConnection).setSSLSocketFactory(sSLSocketFactoryA);
            }
            if (url.getProtocol().equalsIgnoreCase("file") && !url.getHost().isEmpty()) {
                malformattedUrlCallback("file:// must use an absolute path");
                return;
            }
            if (uRLConnectionOpenConnection instanceof HttpURLConnection) {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                    httpURLConnection.setRequestMethod(this.c);
                    httpURLConnection.setInstanceFollowRedirects(false);
                } catch (ProtocolException e) {
                    badProtocolCallback(e.toString());
                    return;
                }
            }
            if (this.d != null) {
                for (Map.Entry entry : this.d.entrySet()) {
                    uRLConnectionOpenConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(131072);
            if (uploadCallback(null) > 0) {
                uRLConnectionOpenConnection.setDoOutput(true);
                try {
                    OutputStream outputStream = uRLConnectionOpenConnection.getOutputStream();
                    int iUploadCallback = uploadCallback(byteBufferAllocateDirect);
                    while (iUploadCallback > 0) {
                        if (hasTimedOut()) {
                            outputStream.close();
                            errorCallback(this.a, 14, "WebRequest timed out.");
                            return;
                        } else {
                            outputStream.write(byteBufferAllocateDirect.array(), byteBufferAllocateDirect.arrayOffset(), iUploadCallback);
                            iUploadCallback = uploadCallback(byteBufferAllocateDirect);
                        }
                    }
                } catch (Exception e2) {
                    errorCallback(e2.toString());
                    return;
                }
            }
            if (uRLConnectionOpenConnection instanceof HttpURLConnection) {
                try {
                    responseCodeCallback(((HttpURLConnection) uRLConnectionOpenConnection).getResponseCode());
                } catch (SocketTimeoutException e3) {
                    errorCallback(this.a, 14, e3.toString());
                    return;
                } catch (UnknownHostException e4) {
                    unknownHostCallback(e4.toString());
                    return;
                } catch (SSLException e5) {
                    sslCannotConnectCallback(e5);
                    return;
                } catch (IOException e6) {
                    errorCallback(e6.toString());
                    return;
                }
            }
            Map<String, List<String>> headerFields = uRLConnectionOpenConnection.getHeaderFields();
            headerCallback(headerFields);
            if ((headerFields == null || !headerFields.containsKey("content-length")) && uRLConnectionOpenConnection.getContentLength() != -1) {
                headerCallback("content-length", String.valueOf(uRLConnectionOpenConnection.getContentLength()));
            }
            if ((headerFields == null || !headerFields.containsKey("content-type")) && uRLConnectionOpenConnection.getContentType() != null) {
                headerCallback("content-type", uRLConnectionOpenConnection.getContentType());
            }
            int contentLength = uRLConnectionOpenConnection.getContentLength();
            if (contentLength > 0) {
                contentLengthCallback(contentLength);
            }
            try {
                if (uRLConnectionOpenConnection instanceof HttpURLConnection) {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) uRLConnectionOpenConnection;
                    responseCodeCallback(httpURLConnection2.getResponseCode());
                    inputStream = httpURLConnection2.getErrorStream();
                } else {
                    inputStream = null;
                }
                if (inputStream == null) {
                    inputStream = uRLConnectionOpenConnection.getInputStream();
                }
                ReadableByteChannel readableByteChannelNewChannel = Channels.newChannel(inputStream);
                for (int i = readableByteChannelNewChannel.read(byteBufferAllocateDirect); i != -1; i = readableByteChannelNewChannel.read(byteBufferAllocateDirect)) {
                    if (hasTimedOut()) {
                        readableByteChannelNewChannel.close();
                        errorCallback(this.a, 14, "WebRequest timed out.");
                        return;
                    } else {
                        if (!downloadCallback(byteBufferAllocateDirect, i)) {
                            break;
                        }
                        byteBufferAllocateDirect.clear();
                    }
                }
                readableByteChannelNewChannel.close();
            } catch (SocketTimeoutException e7) {
                errorCallback(this.a, 14, e7.toString());
            } catch (UnknownHostException e8) {
                unknownHostCallback(e8.toString());
            } catch (SSLException e9) {
                sslCannotConnectCallback(e9);
            } catch (IOException e10) {
                errorCallback(this.a, 14, e10.toString());
            } catch (Exception e11) {
                errorCallback(e11.toString());
            }
        } catch (MalformedURLException e12) {
            malformattedUrlCallback(e12.toString());
        } catch (IOException e13) {
            errorCallback(e13.toString());
        }
    }

    protected void sslCannotConnectCallback(SSLException sSLException) {
        String string = sSLException.toString();
        int i = 16;
        for (Throwable cause = sSLException; cause != null; cause = cause.getCause()) {
            if (cause instanceof SSLKeyException) {
                i = 23;
                break;
            } else {
                if ((cause instanceof SSLPeerUnverifiedException) || (cause instanceof CertPathValidatorException)) {
                    i = 25;
                    break;
                }
            }
        }
        errorCallback(this.a, i, string);
    }

    protected void unknownHostCallback(String str) {
        errorCallback(this.a, 7, str);
    }

    protected int uploadCallback(ByteBuffer byteBuffer) {
        return uploadCallback(this.a, byteBuffer);
    }
}
