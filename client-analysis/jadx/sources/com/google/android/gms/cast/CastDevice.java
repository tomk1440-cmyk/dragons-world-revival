package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CastDevice implements SafeParcelable {
    public static final int CAPABILITY_AUDIO_IN = 8;
    public static final int CAPABILITY_AUDIO_OUT = 4;
    public static final int CAPABILITY_MULTIZONE_GROUP = 32;
    public static final int CAPABILITY_VIDEO_IN = 2;
    public static final int CAPABILITY_VIDEO_OUT = 1;
    public static final Parcelable.Creator<CastDevice> CREATOR = new zzb();
    private final int mVersionCode;
    private int zzBc;
    private String zzZT;
    String zzZU;
    private Inet4Address zzZV;
    private String zzZW;
    private String zzZX;
    private String zzZY;
    private int zzZZ;
    private List<WebImage> zzaaa;
    private int zzaab;
    private String zzaac;

    private CastDevice() {
        this(4, null, null, null, null, null, -1, new ArrayList(), 0, -1, null);
    }

    CastDevice(int versionCode, String deviceId, String hostAddress, String friendlyName, String modelName, String deviceVersion, int servicePort, List<WebImage> icons, int capabilities, int status, String serviceInstanceName) {
        this.mVersionCode = versionCode;
        this.zzZT = zzbZ(deviceId);
        this.zzZU = zzbZ(hostAddress);
        if (!TextUtils.isEmpty(this.zzZU)) {
            try {
                InetAddress byName = InetAddress.getByName(this.zzZU);
                if (byName instanceof Inet4Address) {
                    this.zzZV = (Inet4Address) byName;
                }
            } catch (UnknownHostException e) {
                Log.i("CastDevice", "Unable to convert host address (" + this.zzZU + ") to ipaddress: " + e.getMessage());
            }
        }
        this.zzZW = zzbZ(friendlyName);
        this.zzZX = zzbZ(modelName);
        this.zzZY = zzbZ(deviceVersion);
        this.zzZZ = servicePort;
        this.zzaaa = icons == null ? new ArrayList<>() : icons;
        this.zzaab = capabilities;
        this.zzBc = status;
        this.zzaac = zzbZ(serviceInstanceName);
    }

    public static CastDevice getFromBundle(Bundle extras) {
        if (extras == null) {
            return null;
        }
        extras.setClassLoader(CastDevice.class.getClassLoader());
        return (CastDevice) extras.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
    }

    private static String zzbZ(String str) {
        return str == null ? "" : str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CastDevice)) {
            return false;
        }
        CastDevice castDevice = (CastDevice) obj;
        if (this.zzZT == null) {
            return castDevice.zzZT == null;
        }
        return zzf.zza(this.zzZT, castDevice.zzZT) && zzf.zza(this.zzZV, castDevice.zzZV) && zzf.zza(this.zzZX, castDevice.zzZX) && zzf.zza(this.zzZW, castDevice.zzZW) && zzf.zza(this.zzZY, castDevice.zzZY) && this.zzZZ == castDevice.zzZZ && zzf.zza(this.zzaaa, castDevice.zzaaa) && this.zzaab == castDevice.zzaab && this.zzBc == castDevice.zzBc && zzf.zza(this.zzaac, castDevice.zzaac);
    }

    public int getCapabilities() {
        return this.zzaab;
    }

    public String getDeviceId() {
        return this.zzZT.startsWith("__cast_nearby__") ? this.zzZT.substring("__cast_nearby__".length() + 1) : this.zzZT;
    }

    public String getDeviceVersion() {
        return this.zzZY;
    }

    public String getFriendlyName() {
        return this.zzZW;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0072  */
    public WebImage getIcon(int preferredWidth, int preferredHeight) {
        WebImage webImage;
        WebImage webImage2 = null;
        if (this.zzaaa.isEmpty()) {
            return null;
        }
        if (preferredWidth <= 0 || preferredHeight <= 0) {
            return this.zzaaa.get(0);
        }
        WebImage webImage3 = null;
        for (WebImage webImage4 : this.zzaaa) {
            int width = webImage4.getWidth();
            int height = webImage4.getHeight();
            if (width < preferredWidth || height < preferredHeight) {
                if (width >= preferredWidth || height >= preferredHeight || (webImage2 != null && (webImage2.getWidth() >= width || webImage2.getHeight() >= height))) {
                    webImage4 = webImage2;
                    webImage = webImage3;
                } else {
                    webImage = webImage3;
                }
            } else if (webImage3 == null || (webImage3.getWidth() > width && webImage3.getHeight() > height)) {
                WebImage webImage5 = webImage2;
                webImage = webImage4;
                webImage4 = webImage5;
            } else {
                webImage4 = webImage2;
                webImage = webImage3;
            }
            webImage3 = webImage;
            webImage2 = webImage4;
        }
        if (webImage3 == null) {
            webImage3 = webImage2 != null ? webImage2 : this.zzaaa.get(0);
        }
        return webImage3;
    }

    public List<WebImage> getIcons() {
        return Collections.unmodifiableList(this.zzaaa);
    }

    public Inet4Address getIpAddress() {
        return this.zzZV;
    }

    public String getModelName() {
        return this.zzZX;
    }

    public int getServicePort() {
        return this.zzZZ;
    }

    public int getStatus() {
        return this.zzBc;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasCapabilities(int[] capabilities) {
        if (capabilities == null) {
            return false;
        }
        for (int i : capabilities) {
            if (!hasCapability(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasCapability(int capability) {
        return (this.zzaab & capability) == capability;
    }

    public boolean hasIcons() {
        return !this.zzaaa.isEmpty();
    }

    public int hashCode() {
        if (this.zzZT == null) {
            return 0;
        }
        return this.zzZT.hashCode();
    }

    public boolean isOnLocalNetwork() {
        return !this.zzZT.startsWith("__cast_nearby__");
    }

    public boolean isSameDevice(CastDevice castDevice) {
        if (castDevice == null) {
            return false;
        }
        if (this.zzZT == null) {
            return castDevice.zzZT == null;
        }
        return zzf.zza(this.zzZT, castDevice.zzZT);
    }

    public void putInBundle(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", this);
    }

    public String toString() {
        return String.format("\"%s\" (%s)", this.zzZW, this.zzZT);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }

    public String zzny() {
        return this.zzZT;
    }

    public String zznz() {
        return this.zzaac;
    }
}
