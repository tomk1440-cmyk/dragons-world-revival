package com.adjust.sdk;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AdjustAttribution implements Serializable {
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("trackerToken", String.class), new ObjectStreamField("trackerName", String.class), new ObjectStreamField("network", String.class), new ObjectStreamField("campaign", String.class), new ObjectStreamField("adgroup", String.class), new ObjectStreamField("creative", String.class), new ObjectStreamField("clickLabel", String.class), new ObjectStreamField("adid", String.class)};
    private static final long serialVersionUID = 1;
    public String adgroup;
    public String adid;
    public String campaign;
    public String clickLabel;
    public String creative;
    public String network;
    public String trackerName;
    public String trackerToken;

    public static AdjustAttribution fromJson(JSONObject jsonObject, String adid) {
        if (jsonObject == null) {
            return null;
        }
        AdjustAttribution attribution = new AdjustAttribution();
        attribution.trackerToken = jsonObject.optString("tracker_token", null);
        attribution.trackerName = jsonObject.optString("tracker_name", null);
        attribution.network = jsonObject.optString("network", null);
        attribution.campaign = jsonObject.optString("campaign", null);
        attribution.adgroup = jsonObject.optString("adgroup", null);
        attribution.creative = jsonObject.optString("creative", null);
        attribution.clickLabel = jsonObject.optString("click_label", null);
        attribution.adid = adid;
        return attribution;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other != null && getClass() == other.getClass()) {
            AdjustAttribution otherAttribution = (AdjustAttribution) other;
            return Util.equalString(this.trackerToken, otherAttribution.trackerToken) && Util.equalString(this.trackerName, otherAttribution.trackerName) && Util.equalString(this.network, otherAttribution.network) && Util.equalString(this.campaign, otherAttribution.campaign) && Util.equalString(this.adgroup, otherAttribution.adgroup) && Util.equalString(this.creative, otherAttribution.creative) && Util.equalString(this.clickLabel, otherAttribution.clickLabel) && Util.equalString(this.adid, otherAttribution.adid);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = Util.hashString(this.trackerToken) + 629;
        return (((((((((((((hashCode * 37) + Util.hashString(this.trackerName)) * 37) + Util.hashString(this.network)) * 37) + Util.hashString(this.campaign)) * 37) + Util.hashString(this.adgroup)) * 37) + Util.hashString(this.creative)) * 37) + Util.hashString(this.clickLabel)) * 37) + Util.hashString(this.adid);
    }

    public String toString() {
        return String.format(Locale.US, "tt:%s tn:%s net:%s cam:%s adg:%s cre:%s cl:%s adid:%s", this.trackerToken, this.trackerName, this.network, this.campaign, this.adgroup, this.creative, this.clickLabel, this.adid);
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream stream) throws ClassNotFoundException, IOException {
        stream.defaultReadObject();
    }
}
