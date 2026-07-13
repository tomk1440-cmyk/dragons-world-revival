package com.google.android.gms.games.internal.notification;

import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.common.internal.zzw;

/* JADX INFO: loaded from: classes.dex */
public final class GameNotificationRef extends zzc implements GameNotification {
    GameNotificationRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public long getId() {
        return getLong("_id");
    }

    public String getText() {
        return getString("text");
    }

    public String getTitle() {
        return getString("title");
    }

    public int getType() {
        return getInteger(ShareConstants.MEDIA_TYPE);
    }

    public String toString() {
        return zzw.zzy(this).zzg("Id", Long.valueOf(getId())).zzg("NotificationId", zzxt()).zzg("Type", Integer.valueOf(getType())).zzg("Title", getTitle()).zzg("Ticker", zzxu()).zzg("Text", getText()).zzg("CoalescedText", zzxv()).zzg("isAcknowledged", Boolean.valueOf(zzxw())).zzg("isSilent", Boolean.valueOf(zzxx())).toString();
    }

    public String zzxt() {
        return getString("notification_id");
    }

    public String zzxu() {
        return getString("ticker");
    }

    public String zzxv() {
        return getString("coalesced_text");
    }

    public boolean zzxw() {
        return getInteger("acknowledged") > 0;
    }

    public boolean zzxx() {
        return getInteger("alert_level") == 0;
    }
}
