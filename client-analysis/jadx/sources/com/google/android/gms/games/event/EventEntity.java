package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zzms;

/* JADX INFO: loaded from: classes.dex */
public final class EventEntity implements SafeParcelable, Event {
    public static final EventEntityCreator CREATOR = new EventEntityCreator();
    private final String mName;
    private final int mVersionCode;
    private final Uri zzaCd;
    private final String zzaCo;
    private final String zzaDU;
    private final long zzaDV;
    private final String zzaDW;
    private final PlayerEntity zzaDq;
    private final String zzaxl;
    private final boolean zzsj;

    EventEntity(int versionCode, String eventId, String name, String description, Uri iconImageUri, String iconImageUrl, Player player, long value, String formattedValue, boolean isVisible) {
        this.mVersionCode = versionCode;
        this.zzaDU = eventId;
        this.mName = name;
        this.zzaxl = description;
        this.zzaCd = iconImageUri;
        this.zzaCo = iconImageUrl;
        this.zzaDq = new PlayerEntity(player);
        this.zzaDV = value;
        this.zzaDW = formattedValue;
        this.zzsj = isVisible;
    }

    public EventEntity(Event event) {
        this.mVersionCode = 1;
        this.zzaDU = event.getEventId();
        this.mName = event.getName();
        this.zzaxl = event.getDescription();
        this.zzaCd = event.getIconImageUri();
        this.zzaCo = event.getIconImageUrl();
        this.zzaDq = (PlayerEntity) event.getPlayer().freeze();
        this.zzaDV = event.getValue();
        this.zzaDW = event.getFormattedValue();
        this.zzsj = event.isVisible();
    }

    static int zza(Event event) {
        return zzw.hashCode(event.getEventId(), event.getName(), event.getDescription(), event.getIconImageUri(), event.getIconImageUrl(), event.getPlayer(), Long.valueOf(event.getValue()), event.getFormattedValue(), Boolean.valueOf(event.isVisible()));
    }

    static boolean zza(Event event, Object obj) {
        if (!(obj instanceof Event)) {
            return false;
        }
        if (event == obj) {
            return true;
        }
        Event event2 = (Event) obj;
        return zzw.equal(event2.getEventId(), event.getEventId()) && zzw.equal(event2.getName(), event.getName()) && zzw.equal(event2.getDescription(), event.getDescription()) && zzw.equal(event2.getIconImageUri(), event.getIconImageUri()) && zzw.equal(event2.getIconImageUrl(), event.getIconImageUrl()) && zzw.equal(event2.getPlayer(), event.getPlayer()) && zzw.equal(Long.valueOf(event2.getValue()), Long.valueOf(event.getValue())) && zzw.equal(event2.getFormattedValue(), event.getFormattedValue()) && zzw.equal(Boolean.valueOf(event2.isVisible()), Boolean.valueOf(event.isVisible()));
    }

    static String zzb(Event event) {
        return zzw.zzy(event).zzg("Id", event.getEventId()).zzg("Name", event.getName()).zzg("Description", event.getDescription()).zzg("IconImageUri", event.getIconImageUri()).zzg("IconImageUrl", event.getIconImageUrl()).zzg("Player", event.getPlayer()).zzg("Value", Long.valueOf(event.getValue())).zzg("FormattedValue", event.getFormattedValue()).zzg("isVisible", Boolean.valueOf(event.isVisible())).toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.common.data.Freezable
    public Event freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.event.Event
    public String getDescription() {
        return this.zzaxl;
    }

    @Override // com.google.android.gms.games.event.Event
    public void getDescription(CharArrayBuffer dataOut) {
        zzms.zzb(this.zzaxl, dataOut);
    }

    @Override // com.google.android.gms.games.event.Event
    public String getEventId() {
        return this.zzaDU;
    }

    @Override // com.google.android.gms.games.event.Event
    public String getFormattedValue() {
        return this.zzaDW;
    }

    @Override // com.google.android.gms.games.event.Event
    public void getFormattedValue(CharArrayBuffer dataOut) {
        zzms.zzb(this.zzaDW, dataOut);
    }

    @Override // com.google.android.gms.games.event.Event
    public Uri getIconImageUri() {
        return this.zzaCd;
    }

    @Override // com.google.android.gms.games.event.Event
    public String getIconImageUrl() {
        return this.zzaCo;
    }

    @Override // com.google.android.gms.games.event.Event
    public String getName() {
        return this.mName;
    }

    @Override // com.google.android.gms.games.event.Event
    public void getName(CharArrayBuffer dataOut) {
        zzms.zzb(this.mName, dataOut);
    }

    @Override // com.google.android.gms.games.event.Event
    public Player getPlayer() {
        return this.zzaDq;
    }

    @Override // com.google.android.gms.games.event.Event
    public long getValue() {
        return this.zzaDV;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zza(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.games.event.Event
    public boolean isVisible() {
        return this.zzsj;
    }

    public String toString() {
        return zzb(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        EventEntityCreator.zza(this, out, flags);
    }
}
