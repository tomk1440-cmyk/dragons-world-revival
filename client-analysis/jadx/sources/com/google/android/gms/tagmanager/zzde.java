package com.google.android.gms.tagmanager;

/* JADX INFO: loaded from: classes.dex */
class zzde extends Number implements Comparable<zzde> {
    private double zzblB;
    private long zzblC;
    private boolean zzblD = false;

    private zzde(double d) {
        this.zzblB = d;
    }

    private zzde(long j) {
        this.zzblC = j;
    }

    public static zzde zza(Double d) {
        return new zzde(d.doubleValue());
    }

    public static zzde zzam(long j) {
        return new zzde(j);
    }

    public static zzde zzgs(String str) throws NumberFormatException {
        try {
            return new zzde(Long.parseLong(str));
        } catch (NumberFormatException e) {
            try {
                return new zzde(Double.parseDouble(str));
            } catch (NumberFormatException e2) {
                throw new NumberFormatException(str + " is not a valid TypedNumber");
            }
        }
    }

    @Override // java.lang.Number
    public byte byteValue() {
        return (byte) longValue();
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return zzHv() ? this.zzblC : this.zzblB;
    }

    public boolean equals(Object other) {
        return (other instanceof zzde) && compareTo((zzde) other) == 0;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) doubleValue();
    }

    public int hashCode() {
        return new Long(longValue()).hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        return zzHx();
    }

    @Override // java.lang.Number
    public long longValue() {
        return zzHw();
    }

    @Override // java.lang.Number
    public short shortValue() {
        return zzHy();
    }

    public String toString() {
        return zzHv() ? Long.toString(this.zzblC) : Double.toString(this.zzblB);
    }

    public boolean zzHu() {
        return !zzHv();
    }

    public boolean zzHv() {
        return this.zzblD;
    }

    public long zzHw() {
        return zzHv() ? this.zzblC : (long) this.zzblB;
    }

    public int zzHx() {
        return (int) longValue();
    }

    public short zzHy() {
        return (short) longValue();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public int compareTo(zzde zzdeVar) {
        return (zzHv() && zzdeVar.zzHv()) ? new Long(this.zzblC).compareTo(Long.valueOf(zzdeVar.zzblC)) : Double.compare(doubleValue(), zzdeVar.doubleValue());
    }
}
