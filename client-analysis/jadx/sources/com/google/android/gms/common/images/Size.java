package com.google.android.gms.common.images;

/* JADX INFO: loaded from: classes.dex */
public final class Size {
    private final int zzoG;
    private final int zzoH;

    public Size(int width, int height) {
        this.zzoG = width;
        this.zzoH = height;
    }

    public static Size parseSize(String string) throws NumberFormatException {
        if (string == null) {
            throw new IllegalArgumentException("string must not be null");
        }
        int iIndexOf = string.indexOf(42);
        if (iIndexOf < 0) {
            iIndexOf = string.indexOf(120);
        }
        if (iIndexOf < 0) {
            throw zzcC(string);
        }
        try {
            return new Size(Integer.parseInt(string.substring(0, iIndexOf)), Integer.parseInt(string.substring(iIndexOf + 1)));
        } catch (NumberFormatException e) {
            throw zzcC(string);
        }
    }

    private static NumberFormatException zzcC(String str) {
        throw new NumberFormatException("Invalid Size: \"" + str + "\"");
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return this.zzoG == size.zzoG && this.zzoH == size.zzoH;
    }

    public int getHeight() {
        return this.zzoH;
    }

    public int getWidth() {
        return this.zzoG;
    }

    public int hashCode() {
        return this.zzoH ^ ((this.zzoG << 16) | (this.zzoG >>> 16));
    }

    public String toString() {
        return this.zzoG + "x" + this.zzoH;
    }
}
