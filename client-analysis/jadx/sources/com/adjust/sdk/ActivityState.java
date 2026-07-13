package com.adjust.sdk;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class ActivityState implements Serializable, Cloneable {
    private static int ORDER_ID_MAXCOUNT = 10;
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("uuid", String.class), new ObjectStreamField("enabled", Boolean.TYPE), new ObjectStreamField("askingAttribution", Boolean.TYPE), new ObjectStreamField("eventCount", Integer.TYPE), new ObjectStreamField("sessionCount", Integer.TYPE), new ObjectStreamField("subsessionCount", Integer.TYPE), new ObjectStreamField("sessionLength", Long.TYPE), new ObjectStreamField("timeSpent", Long.TYPE), new ObjectStreamField("lastActivity", Long.TYPE), new ObjectStreamField("lastInterval", Long.TYPE), new ObjectStreamField("updatePackages", Boolean.TYPE), new ObjectStreamField("orderIds", LinkedList.class), new ObjectStreamField("pushToken", String.class), new ObjectStreamField("adid", String.class)};
    private static final long serialVersionUID = 9039439291143138148L;
    private transient ILogger logger = AdjustFactory.getLogger();
    protected String uuid = Util.createUuid();
    protected boolean enabled = true;
    protected boolean askingAttribution = false;
    protected int eventCount = 0;
    protected int sessionCount = 0;
    protected int subsessionCount = -1;
    protected long sessionLength = -1;
    protected long timeSpent = -1;
    protected long lastActivity = -1;
    protected long lastInterval = -1;
    protected boolean updatePackages = false;
    protected LinkedList<String> orderIds = null;
    protected String pushToken = null;
    protected String adid = null;

    protected ActivityState() {
    }

    protected void resetSessionAttributes(long now) {
        this.subsessionCount = 1;
        this.sessionLength = 0L;
        this.timeSpent = 0L;
        this.lastActivity = now;
        this.lastInterval = -1L;
    }

    protected void addOrderId(String orderId) {
        if (this.orderIds == null) {
            this.orderIds = new LinkedList<>();
        }
        if (this.orderIds.size() >= ORDER_ID_MAXCOUNT) {
            this.orderIds.removeLast();
        }
        this.orderIds.addFirst(orderId);
    }

    protected boolean findOrderId(String orderId) {
        if (this.orderIds == null) {
            return false;
        }
        return this.orderIds.contains(orderId);
    }

    public String toString() {
        return String.format(Locale.US, "ec:%d sc:%d ssc:%d sl:%.1f ts:%.1f la:%s uuid:%s", Integer.valueOf(this.eventCount), Integer.valueOf(this.sessionCount), Integer.valueOf(this.subsessionCount), Double.valueOf(this.sessionLength / 1000.0d), Double.valueOf(this.timeSpent / 1000.0d), stamp(this.lastActivity), this.uuid);
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other != null && getClass() == other.getClass()) {
            ActivityState otherActivityState = (ActivityState) other;
            return Util.equalString(this.uuid, otherActivityState.uuid) && Util.equalBoolean(Boolean.valueOf(this.enabled), Boolean.valueOf(otherActivityState.enabled)) && Util.equalBoolean(Boolean.valueOf(this.askingAttribution), Boolean.valueOf(otherActivityState.askingAttribution)) && Util.equalInt(Integer.valueOf(this.eventCount), Integer.valueOf(otherActivityState.eventCount)) && Util.equalInt(Integer.valueOf(this.sessionCount), Integer.valueOf(otherActivityState.sessionCount)) && Util.equalInt(Integer.valueOf(this.subsessionCount), Integer.valueOf(otherActivityState.subsessionCount)) && Util.equalLong(Long.valueOf(this.sessionLength), Long.valueOf(otherActivityState.sessionLength)) && Util.equalLong(Long.valueOf(this.timeSpent), Long.valueOf(otherActivityState.timeSpent)) && Util.equalLong(Long.valueOf(this.lastInterval), Long.valueOf(otherActivityState.lastInterval)) && Util.equalBoolean(Boolean.valueOf(this.updatePackages), Boolean.valueOf(otherActivityState.updatePackages)) && Util.equalObject(this.orderIds, otherActivityState.orderIds) && Util.equalString(this.pushToken, otherActivityState.pushToken) && Util.equalString(this.adid, otherActivityState.adid);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = Util.hashString(this.uuid) + 629;
        return (((((((((((((((((((((((hashCode * 37) + Util.hashBoolean(Boolean.valueOf(this.enabled))) * 37) + Util.hashBoolean(Boolean.valueOf(this.askingAttribution))) * 37) + this.eventCount) * 37) + this.sessionCount) * 37) + this.subsessionCount) * 37) + Util.hashLong(Long.valueOf(this.sessionLength))) * 37) + Util.hashLong(Long.valueOf(this.timeSpent))) * 37) + Util.hashLong(Long.valueOf(this.lastInterval))) * 37) + Util.hashBoolean(Boolean.valueOf(this.updatePackages))) * 37) + Util.hashObject(this.orderIds)) * 37) + Util.hashString(this.pushToken)) * 37) + Util.hashString(this.adid);
    }

    private void readObject(ObjectInputStream stream) throws ClassNotFoundException, IOException {
        ObjectInputStream.GetField fields = stream.readFields();
        this.eventCount = Util.readIntField(fields, "eventCount", 0);
        this.sessionCount = Util.readIntField(fields, "sessionCount", 0);
        this.subsessionCount = Util.readIntField(fields, "subsessionCount", -1);
        this.sessionLength = Util.readLongField(fields, "sessionLength", -1L);
        this.timeSpent = Util.readLongField(fields, "timeSpent", -1L);
        this.lastActivity = Util.readLongField(fields, "lastActivity", -1L);
        this.lastInterval = Util.readLongField(fields, "lastInterval", -1L);
        this.uuid = Util.readStringField(fields, "uuid", null);
        this.enabled = Util.readBooleanField(fields, "enabled", true);
        this.askingAttribution = Util.readBooleanField(fields, "askingAttribution", false);
        this.updatePackages = Util.readBooleanField(fields, "updatePackages", false);
        this.orderIds = (LinkedList) Util.readObjectField(fields, "orderIds", null);
        this.pushToken = Util.readStringField(fields, "pushToken", null);
        this.adid = Util.readStringField(fields, "adid", null);
        if (this.uuid == null) {
            this.uuid = Util.createUuid();
        }
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
    }

    private static String stamp(long dateMillis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(dateMillis);
        return String.format(Locale.US, "%02d:%02d:%02d", 11, 12, 13);
    }
}
