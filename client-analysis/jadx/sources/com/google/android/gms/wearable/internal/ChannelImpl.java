package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class ChannelImpl implements SafeParcelable, Channel {
    public static final Parcelable.Creator<ChannelImpl> CREATOR = new zzo();
    private final String mPath;
    final int mVersionCode;
    private final String zzVo;
    private final String zzbrb;

    static final class zza implements Channel.GetInputStreamResult {
        private final Status zzUX;
        private final InputStream zzbsh;

        zza(Status status, InputStream inputStream) {
            this.zzUX = (Status) com.google.android.gms.common.internal.zzx.zzz(status);
            this.zzbsh = inputStream;
        }

        @Override // com.google.android.gms.wearable.Channel.GetInputStreamResult
        public InputStream getInputStream() {
            return this.zzbsh;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }

        @Override // com.google.android.gms.common.api.Releasable
        public void release() {
            if (this.zzbsh != null) {
                try {
                    this.zzbsh.close();
                } catch (IOException e) {
                }
            }
        }
    }

    static final class zzb implements Channel.GetOutputStreamResult {
        private final Status zzUX;
        private final OutputStream zzbsi;

        zzb(Status status, OutputStream outputStream) {
            this.zzUX = (Status) com.google.android.gms.common.internal.zzx.zzz(status);
            this.zzbsi = outputStream;
        }

        @Override // com.google.android.gms.wearable.Channel.GetOutputStreamResult
        public OutputStream getOutputStream() {
            return this.zzbsi;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }

        @Override // com.google.android.gms.common.api.Releasable
        public void release() {
            if (this.zzbsi != null) {
                try {
                    this.zzbsi.close();
                } catch (IOException e) {
                }
            }
        }
    }

    ChannelImpl(int versionCode, String token, String nodeId, String path) {
        this.mVersionCode = versionCode;
        this.zzVo = (String) com.google.android.gms.common.internal.zzx.zzz(token);
        this.zzbrb = (String) com.google.android.gms.common.internal.zzx.zzz(nodeId);
        this.mPath = (String) com.google.android.gms.common.internal.zzx.zzz(path);
    }

    private static com.google.android.gms.wearable.internal.zzb.zza<ChannelApi.ChannelListener> zza(final String str, final IntentFilter[] intentFilterArr) {
        return new com.google.android.gms.wearable.internal.zzb.zza<ChannelApi.ChannelListener>() { // from class: com.google.android.gms.wearable.internal.ChannelImpl.7
            /* JADX INFO: renamed from: zza, reason: avoid collision after fix types in other method */
            public void zza2(zzbp zzbpVar, com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, ChannelApi.ChannelListener channelListener, com.google.android.gms.common.api.internal.zzq<ChannelApi.ChannelListener> zzqVar) throws RemoteException {
                zzbpVar.zza(zzbVar, channelListener, zzqVar, str, intentFilterArr);
            }

            @Override // com.google.android.gms.wearable.internal.zzb.zza
            public /* bridge */ /* synthetic */ void zza(zzbp zzbpVar, com.google.android.gms.common.api.internal.zza.zzb zzbVar, ChannelApi.ChannelListener channelListener, com.google.android.gms.common.api.internal.zzq<ChannelApi.ChannelListener> zzqVar) throws RemoteException {
                zza2(zzbpVar, (com.google.android.gms.common.api.internal.zza.zzb<Status>) zzbVar, channelListener, zzqVar);
            }
        };
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult<Status> addListener(GoogleApiClient client, ChannelApi.ChannelListener listener) {
        return com.google.android.gms.wearable.internal.zzb.zza(client, zza(this.zzVo, new IntentFilter[]{zzbn.zzgM(ChannelApi.ACTION_CHANNEL_EVENT)}), listener);
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult<Status> close(GoogleApiClient client) {
        return client.zza(new zzi<Status>(client) { // from class: com.google.android.gms.wearable.internal.ChannelImpl.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzbp zzbpVar) throws RemoteException {
                zzbpVar.zzt(this, ChannelImpl.this.zzVo);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult<Status> close(GoogleApiClient client, final int errorCode) {
        return client.zza(new zzi<Status>(client) { // from class: com.google.android.gms.wearable.internal.ChannelImpl.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzbp zzbpVar) throws RemoteException {
                zzbpVar.zzh(this, ChannelImpl.this.zzVo, errorCode);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ChannelImpl)) {
            return false;
        }
        ChannelImpl channelImpl = (ChannelImpl) other;
        return this.zzVo.equals(channelImpl.zzVo) && com.google.android.gms.common.internal.zzw.equal(channelImpl.zzbrb, this.zzbrb) && com.google.android.gms.common.internal.zzw.equal(channelImpl.mPath, this.mPath) && channelImpl.mVersionCode == this.mVersionCode;
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult<Channel.GetInputStreamResult> getInputStream(GoogleApiClient client) {
        return client.zza(new zzi<Channel.GetInputStreamResult>(client) { // from class: com.google.android.gms.wearable.internal.ChannelImpl.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzbp zzbpVar) throws RemoteException {
                zzbpVar.zzu(this, ChannelImpl.this.zzVo);
            }

            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzbt, reason: merged with bridge method [inline-methods] */
            public Channel.GetInputStreamResult zzc(Status status) {
                return new zza(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.Channel
    public String getNodeId() {
        return this.zzbrb;
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult<Channel.GetOutputStreamResult> getOutputStream(GoogleApiClient client) {
        return client.zza(new zzi<Channel.GetOutputStreamResult>(client) { // from class: com.google.android.gms.wearable.internal.ChannelImpl.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzbp zzbpVar) throws RemoteException {
                zzbpVar.zzv(this, ChannelImpl.this.zzVo);
            }

            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzbu, reason: merged with bridge method [inline-methods] */
            public Channel.GetOutputStreamResult zzc(Status status) {
                return new zzb(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.Channel
    public String getPath() {
        return this.mPath;
    }

    public String getToken() {
        return this.zzVo;
    }

    public int hashCode() {
        return this.zzVo.hashCode();
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult<Status> receiveFile(GoogleApiClient client, final Uri uri, final boolean append) {
        com.google.android.gms.common.internal.zzx.zzb(client, "client is null");
        com.google.android.gms.common.internal.zzx.zzb(uri, "uri is null");
        return client.zza(new zzi<Status>(client) { // from class: com.google.android.gms.wearable.internal.ChannelImpl.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzbp zzbpVar) throws RemoteException {
                zzbpVar.zza(this, ChannelImpl.this.zzVo, uri, append);
            }

            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult<Status> removeListener(GoogleApiClient client, ChannelApi.ChannelListener listener) {
        com.google.android.gms.common.internal.zzx.zzb(client, "client is null");
        com.google.android.gms.common.internal.zzx.zzb(listener, "listener is null");
        return client.zza(new zzl.zzb(client, listener, this.zzVo));
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult<Status> sendFile(GoogleApiClient client, Uri uri) {
        return sendFile(client, uri, 0L, -1L);
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult<Status> sendFile(GoogleApiClient client, final Uri uri, final long startOffset, final long length) {
        com.google.android.gms.common.internal.zzx.zzb(client, "client is null");
        com.google.android.gms.common.internal.zzx.zzb(this.zzVo, "token is null");
        com.google.android.gms.common.internal.zzx.zzb(uri, "uri is null");
        com.google.android.gms.common.internal.zzx.zzb(startOffset >= 0, "startOffset is negative: %s", Long.valueOf(startOffset));
        com.google.android.gms.common.internal.zzx.zzb(length >= 0 || length == -1, "invalid length: %s", Long.valueOf(length));
        return client.zza(new zzi<Status>(client) { // from class: com.google.android.gms.wearable.internal.ChannelImpl.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzbp zzbpVar) throws RemoteException {
                zzbpVar.zza(this, ChannelImpl.this.zzVo, uri, startOffset, length);
            }

            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    public String toString() {
        return "ChannelImpl{versionCode=" + this.mVersionCode + ", token='" + this.zzVo + "', nodeId='" + this.zzbrb + "', path='" + this.mPath + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzo.zza(this, dest, flags);
    }
}
