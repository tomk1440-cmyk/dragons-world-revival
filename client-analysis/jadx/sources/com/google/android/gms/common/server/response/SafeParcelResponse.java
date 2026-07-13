package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmo;
import com.google.android.gms.internal.zznb;
import com.google.android.gms.internal.zznc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class SafeParcelResponse extends FastJsonResponse implements SafeParcelable {
    public static final zze CREATOR = new zze();
    private final String mClassName;
    private final int mVersionCode;
    private final FieldMappingDictionary zzamT;
    private final Parcel zzana;
    private final int zzanb;
    private int zzanc;
    private int zzand;

    SafeParcelResponse(int versionCode, Parcel parcel, FieldMappingDictionary fieldMappingDictionary) {
        this.mVersionCode = versionCode;
        this.zzana = (Parcel) zzx.zzz(parcel);
        this.zzanb = 2;
        this.zzamT = fieldMappingDictionary;
        if (this.zzamT == null) {
            this.mClassName = null;
        } else {
            this.mClassName = this.zzamT.zzrB();
        }
        this.zzanc = 2;
    }

    private SafeParcelResponse(SafeParcelable safeParcelable, FieldMappingDictionary dictionary, String className) {
        this.mVersionCode = 1;
        this.zzana = Parcel.obtain();
        safeParcelable.writeToParcel(this.zzana, 0);
        this.zzanb = 1;
        this.zzamT = (FieldMappingDictionary) zzx.zzz(dictionary);
        this.mClassName = (String) zzx.zzz(className);
        this.zzanc = 2;
    }

    private static HashMap<Integer, Map.Entry<String, FastJsonResponse.Field<?, ?>>> zzN(Map<String, FastJsonResponse.Field<?, ?>> map) {
        HashMap<Integer, Map.Entry<String, FastJsonResponse.Field<?, ?>>> map2 = new HashMap<>();
        for (Map.Entry<String, FastJsonResponse.Field<?, ?>> entry : map.entrySet()) {
            map2.put(Integer.valueOf(entry.getValue().zzrs()), entry);
        }
        return map2;
    }

    public static <T extends FastJsonResponse & SafeParcelable> SafeParcelResponse zza(T t) {
        String canonicalName = t.getClass().getCanonicalName();
        return new SafeParcelResponse(t, zzb(t), canonicalName);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void zza(FieldMappingDictionary fieldMappingDictionary, FastJsonResponse fastJsonResponse) {
        Class<?> cls = fastJsonResponse.getClass();
        if (fieldMappingDictionary.zzb(cls)) {
            return;
        }
        Map<String, FastJsonResponse.Field<?, ?>> mapZzrl = fastJsonResponse.zzrl();
        fieldMappingDictionary.zza(cls, mapZzrl);
        Iterator<String> it = mapZzrl.keySet().iterator();
        while (it.hasNext()) {
            FastJsonResponse.Field<?, ?> field = mapZzrl.get(it.next());
            Class<? extends FastJsonResponse> clsZzrt = field.zzrt();
            if (clsZzrt != null) {
                try {
                    zza(fieldMappingDictionary, clsZzrt.newInstance());
                } catch (IllegalAccessException e) {
                    throw new IllegalStateException("Could not access object of type " + field.zzrt().getCanonicalName(), e);
                } catch (InstantiationException e2) {
                    throw new IllegalStateException("Could not instantiate an object of type " + field.zzrt().getCanonicalName(), e2);
                }
            }
        }
    }

    private void zza(StringBuilder sb, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"").append(zznb.zzcU(obj.toString())).append("\"");
                return;
            case 8:
                sb.append("\"").append(zzmo.zzj((byte[]) obj)).append("\"");
                return;
            case 9:
                sb.append("\"").append(zzmo.zzk((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                zznc.zza(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }

    private void zza(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Parcel parcel, int i) {
        switch (field.zzrk()) {
            case 0:
                zzb(sb, field, zza(field, Integer.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i))));
                return;
            case 1:
                zzb(sb, field, zza(field, com.google.android.gms.common.internal.safeparcel.zza.zzk(parcel, i)));
                return;
            case 2:
                zzb(sb, field, zza(field, Long.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, i))));
                return;
            case 3:
                zzb(sb, field, zza(field, Float.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, i))));
                return;
            case 4:
                zzb(sb, field, zza(field, Double.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzn(parcel, i))));
                return;
            case 5:
                zzb(sb, field, zza(field, com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, i)));
                return;
            case 6:
                zzb(sb, field, zza(field, Boolean.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, i))));
                return;
            case 7:
                zzb(sb, field, zza(field, com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, i)));
                return;
            case 8:
            case 9:
                zzb(sb, field, zza(field, com.google.android.gms.common.internal.safeparcel.zza.zzs(parcel, i)));
                return;
            case 10:
                zzb(sb, field, zza(field, zzl(com.google.android.gms.common.internal.safeparcel.zza.zzr(parcel, i))));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown field out type = " + field.zzrk());
        }
    }

    private void zza(StringBuilder sb, String str, FastJsonResponse.Field<?, ?> field, Parcel parcel, int i) {
        sb.append("\"").append(str).append("\":");
        if (field.zzrv()) {
            zza(sb, field, parcel, i);
        } else {
            zzb(sb, field, parcel, i);
        }
    }

    private void zza(StringBuilder sb, Map<String, FastJsonResponse.Field<?, ?>> map, Parcel parcel) {
        HashMap<Integer, Map.Entry<String, FastJsonResponse.Field<?, ?>>> mapZzN = zzN(map);
        sb.append('{');
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        boolean z = false;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            Map.Entry<String, FastJsonResponse.Field<?, ?>> entry = mapZzN.get(Integer.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)));
            if (entry != null) {
                if (z) {
                    sb.append(",");
                }
                zza(sb, entry.getKey(), entry.getValue(), parcel, iZzat);
                z = true;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        sb.append('}');
    }

    private static FieldMappingDictionary zzb(FastJsonResponse fastJsonResponse) {
        FieldMappingDictionary fieldMappingDictionary = new FieldMappingDictionary(fastJsonResponse.getClass());
        zza(fieldMappingDictionary, fastJsonResponse);
        fieldMappingDictionary.zzrz();
        fieldMappingDictionary.zzry();
        return fieldMappingDictionary;
    }

    private void zzb(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Parcel parcel, int i) {
        if (field.zzrq()) {
            sb.append("[");
            switch (field.zzrk()) {
                case 0:
                    zzmn.zza(sb, com.google.android.gms.common.internal.safeparcel.zza.zzv(parcel, i));
                    break;
                case 1:
                    zzmn.zza(sb, com.google.android.gms.common.internal.safeparcel.zza.zzx(parcel, i));
                    break;
                case 2:
                    zzmn.zza(sb, com.google.android.gms.common.internal.safeparcel.zza.zzw(parcel, i));
                    break;
                case 3:
                    zzmn.zza(sb, com.google.android.gms.common.internal.safeparcel.zza.zzy(parcel, i));
                    break;
                case 4:
                    zzmn.zza(sb, com.google.android.gms.common.internal.safeparcel.zza.zzz(parcel, i));
                    break;
                case 5:
                    zzmn.zza(sb, com.google.android.gms.common.internal.safeparcel.zza.zzA(parcel, i));
                    break;
                case 6:
                    zzmn.zza(sb, com.google.android.gms.common.internal.safeparcel.zza.zzu(parcel, i));
                    break;
                case 7:
                    zzmn.zza(sb, com.google.android.gms.common.internal.safeparcel.zza.zzB(parcel, i));
                    break;
                case 8:
                case 9:
                case 10:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case 11:
                    Parcel[] parcelArrZzF = com.google.android.gms.common.internal.safeparcel.zza.zzF(parcel, i);
                    int length = parcelArrZzF.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 > 0) {
                            sb.append(",");
                        }
                        parcelArrZzF[i2].setDataPosition(0);
                        zza(sb, field.zzrx(), parcelArrZzF[i2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            sb.append("]");
            return;
        }
        switch (field.zzrk()) {
            case 0:
                sb.append(com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i));
                return;
            case 1:
                sb.append(com.google.android.gms.common.internal.safeparcel.zza.zzk(parcel, i));
                return;
            case 2:
                sb.append(com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, i));
                return;
            case 3:
                sb.append(com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, i));
                return;
            case 4:
                sb.append(com.google.android.gms.common.internal.safeparcel.zza.zzn(parcel, i));
                return;
            case 5:
                sb.append(com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, i));
                return;
            case 6:
                sb.append(com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, i));
                return;
            case 7:
                sb.append("\"").append(zznb.zzcU(com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, i))).append("\"");
                return;
            case 8:
                sb.append("\"").append(zzmo.zzj(com.google.android.gms.common.internal.safeparcel.zza.zzs(parcel, i))).append("\"");
                return;
            case 9:
                sb.append("\"").append(zzmo.zzk(com.google.android.gms.common.internal.safeparcel.zza.zzs(parcel, i)));
                sb.append("\"");
                return;
            case 10:
                Bundle bundleZzr = com.google.android.gms.common.internal.safeparcel.zza.zzr(parcel, i);
                Set<String> setKeySet = bundleZzr.keySet();
                setKeySet.size();
                sb.append("{");
                boolean z = true;
                for (String str : setKeySet) {
                    if (!z) {
                        sb.append(",");
                    }
                    sb.append("\"").append(str).append("\"");
                    sb.append(":");
                    sb.append("\"").append(zznb.zzcU(bundleZzr.getString(str))).append("\"");
                    z = false;
                }
                sb.append("}");
                return;
            case 11:
                Parcel parcelZzE = com.google.android.gms.common.internal.safeparcel.zza.zzE(parcel, i);
                parcelZzE.setDataPosition(0);
                zza(sb, field.zzrx(), parcelZzE);
                return;
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    private void zzb(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Object obj) {
        if (field.zzrp()) {
            zzb(sb, field, (ArrayList<?>) obj);
        } else {
            zza(sb, field.zzrj(), obj);
        }
    }

    private void zzb(StringBuilder sb, FastJsonResponse.Field<?, ?> field, ArrayList<?> arrayList) {
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(",");
            }
            zza(sb, field.zzrj(), arrayList.get(i));
        }
        sb.append("]");
    }

    public static HashMap<String, String> zzl(Bundle bundle) {
        HashMap<String, String> map = new HashMap<>();
        for (String str : bundle.keySet()) {
            map.put(str, bundle.getString(str));
        }
        return map;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zze zzeVar = CREATOR;
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public String toString() {
        zzx.zzb(this.zzamT, "Cannot convert to JSON on client side.");
        Parcel parcelZzrD = zzrD();
        parcelZzrD.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        zza(sb, this.zzamT.zzcR(this.mClassName), parcelZzrD);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zze zzeVar = CREATOR;
        zze.zza(this, out, flags);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected Object zzcN(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected boolean zzcO(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public Parcel zzrD() {
        switch (this.zzanc) {
            case 0:
                this.zzand = com.google.android.gms.common.internal.safeparcel.zzb.zzav(this.zzana);
                com.google.android.gms.common.internal.safeparcel.zzb.zzI(this.zzana, this.zzand);
                this.zzanc = 2;
                break;
            case 1:
                com.google.android.gms.common.internal.safeparcel.zzb.zzI(this.zzana, this.zzand);
                this.zzanc = 2;
                break;
        }
        return this.zzana;
    }

    FieldMappingDictionary zzrE() {
        switch (this.zzanb) {
            case 0:
                return null;
            case 1:
                return this.zzamT;
            case 2:
                return this.zzamT;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.zzanb);
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Map<String, FastJsonResponse.Field<?, ?>> zzrl() {
        if (this.zzamT == null) {
            return null;
        }
        return this.zzamT.zzcR(this.mClassName);
    }
}
