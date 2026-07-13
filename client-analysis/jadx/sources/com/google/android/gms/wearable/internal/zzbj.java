package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;

/* JADX INFO: loaded from: classes.dex */
final class zzbj implements ChannelApi.ChannelListener {
    private final String zzVo;
    private final ChannelApi.ChannelListener zzbtb;

    zzbj(String str, ChannelApi.ChannelListener channelListener) {
        this.zzVo = (String) com.google.android.gms.common.internal.zzx.zzz(str);
        this.zzbtb = (ChannelApi.ChannelListener) com.google.android.gms.common.internal.zzx.zzz(channelListener);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof zzbj)) {
            return false;
        }
        zzbj zzbjVar = (zzbj) o;
        return this.zzbtb.equals(zzbjVar.zzbtb) && this.zzVo.equals(zzbjVar.zzVo);
    }

    public int hashCode() {
        return (this.zzVo.hashCode() * 31) + this.zzbtb.hashCode();
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void onChannelClosed(Channel channel, int closeReason, int appSpecificErrorCode) {
        this.zzbtb.onChannelClosed(channel, closeReason, appSpecificErrorCode);
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void onChannelOpened(Channel channel) {
        this.zzbtb.onChannelOpened(channel);
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void onInputClosed(Channel channel, int closeReason, int appSpecificErrorCode) {
        this.zzbtb.onInputClosed(channel, closeReason, appSpecificErrorCode);
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void onOutputClosed(Channel channel, int closeReason, int appSpecificErrorCode) {
        this.zzbtb.onOutputClosed(channel, closeReason, appSpecificErrorCode);
    }
}
