package com.google.android.gms.internal;

import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public final class zzsi {

    public static class zza {
        public final zzsj zzbty;
        public final List<Asset> zzbtz;

        public zza(zzsj zzsjVar, List<Asset> list) {
            this.zzbty = zzsjVar;
            this.zzbtz = list;
        }
    }

    private static int zza(String str, zzsj.zza.C0187zza[] c0187zzaArr) {
        int i = 14;
        for (zzsj.zza.C0187zza c0187zza : c0187zzaArr) {
            if (i != 14) {
                if (c0187zza.type != i) {
                    throw new IllegalArgumentException("The ArrayList elements should all be the same type, but ArrayList with key " + str + " contains items of type " + i + " and " + c0187zza.type);
                }
            } else if (c0187zza.type == 9 || c0187zza.type == 2 || c0187zza.type == 6) {
                i = c0187zza.type;
            } else if (c0187zza.type != 14) {
                throw new IllegalArgumentException("Unexpected TypedValue type: " + c0187zza.type + " for key " + str);
            }
        }
        return i;
    }

    static int zza(List<Asset> list, Asset asset) {
        list.add(asset);
        return list.size() - 1;
    }

    public static zza zza(DataMap dataMap) {
        zzsj zzsjVar = new zzsj();
        ArrayList arrayList = new ArrayList();
        zzsjVar.zzbtA = zza(dataMap, arrayList);
        return new zza(zzsjVar, arrayList);
    }

    private static zzsj.zza.C0187zza zza(List<Asset> list, Object obj) {
        int i;
        int i2 = 0;
        zzsj.zza.C0187zza c0187zza = new zzsj.zza.C0187zza();
        if (obj == null) {
            c0187zza.type = 14;
            return c0187zza;
        }
        c0187zza.zzbtE = new zzsj.zza.C0187zza.C0188zza();
        if (obj instanceof String) {
            c0187zza.type = 2;
            c0187zza.zzbtE.zzbtG = (String) obj;
        } else if (obj instanceof Integer) {
            c0187zza.type = 6;
            c0187zza.zzbtE.zzbtK = ((Integer) obj).intValue();
        } else if (obj instanceof Long) {
            c0187zza.type = 5;
            c0187zza.zzbtE.zzbtJ = ((Long) obj).longValue();
        } else if (obj instanceof Double) {
            c0187zza.type = 3;
            c0187zza.zzbtE.zzbtH = ((Double) obj).doubleValue();
        } else if (obj instanceof Float) {
            c0187zza.type = 4;
            c0187zza.zzbtE.zzbtI = ((Float) obj).floatValue();
        } else if (obj instanceof Boolean) {
            c0187zza.type = 8;
            c0187zza.zzbtE.zzbtM = ((Boolean) obj).booleanValue();
        } else if (obj instanceof Byte) {
            c0187zza.type = 7;
            c0187zza.zzbtE.zzbtL = ((Byte) obj).byteValue();
        } else if (obj instanceof byte[]) {
            c0187zza.type = 1;
            c0187zza.zzbtE.zzbtF = (byte[]) obj;
        } else if (obj instanceof String[]) {
            c0187zza.type = 11;
            c0187zza.zzbtE.zzbtP = (String[]) obj;
        } else if (obj instanceof long[]) {
            c0187zza.type = 12;
            c0187zza.zzbtE.zzbtQ = (long[]) obj;
        } else if (obj instanceof float[]) {
            c0187zza.type = 15;
            c0187zza.zzbtE.zzbtR = (float[]) obj;
        } else if (obj instanceof Asset) {
            c0187zza.type = 13;
            c0187zza.zzbtE.zzbtS = zza(list, (Asset) obj);
        } else if (obj instanceof DataMap) {
            c0187zza.type = 9;
            DataMap dataMap = (DataMap) obj;
            TreeSet treeSet = new TreeSet(dataMap.keySet());
            zzsj.zza[] zzaVarArr = new zzsj.zza[treeSet.size()];
            Iterator it = treeSet.iterator();
            while (true) {
                int i3 = i2;
                if (!it.hasNext()) {
                    break;
                }
                String str = (String) it.next();
                zzaVarArr[i3] = new zzsj.zza();
                zzaVarArr[i3].name = str;
                zzaVarArr[i3].zzbtC = zza(list, dataMap.get(str));
                i2 = i3 + 1;
            }
            c0187zza.zzbtE.zzbtN = zzaVarArr;
        } else {
            if (!(obj instanceof ArrayList)) {
                throw new RuntimeException("newFieldValueFromValue: unexpected value " + obj.getClass().getSimpleName());
            }
            c0187zza.type = 10;
            ArrayList arrayList = (ArrayList) obj;
            zzsj.zza.C0187zza[] c0187zzaArr = new zzsj.zza.C0187zza[arrayList.size()];
            Object obj2 = null;
            int size = arrayList.size();
            int i4 = 0;
            int i5 = 14;
            while (i4 < size) {
                Object obj3 = arrayList.get(i4);
                zzsj.zza.C0187zza c0187zzaZza = zza(list, obj3);
                if (c0187zzaZza.type != 14 && c0187zzaZza.type != 2 && c0187zzaZza.type != 6 && c0187zzaZza.type != 9) {
                    throw new IllegalArgumentException("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a " + obj3.getClass());
                }
                if (i5 == 14 && c0187zzaZza.type != 14) {
                    i = c0187zzaZza.type;
                } else {
                    if (c0187zzaZza.type != i5) {
                        throw new IllegalArgumentException("ArrayList elements must all be of the sameclass, but this one contains a " + obj2.getClass() + " and a " + obj3.getClass());
                    }
                    obj3 = obj2;
                    i = i5;
                }
                c0187zzaArr[i4] = c0187zzaZza;
                i4++;
                i5 = i;
                obj2 = obj3;
            }
            c0187zza.zzbtE.zzbtO = c0187zzaArr;
        }
        return c0187zza;
    }

    public static DataMap zza(zza zzaVar) {
        DataMap dataMap = new DataMap();
        for (zzsj.zza zzaVar2 : zzaVar.zzbty.zzbtA) {
            zza(zzaVar.zzbtz, dataMap, zzaVar2.name, zzaVar2.zzbtC);
        }
        return dataMap;
    }

    private static ArrayList zza(List<Asset> list, zzsj.zza.C0187zza.C0188zza c0188zza, int i) {
        ArrayList arrayList = new ArrayList(c0188zza.zzbtO.length);
        for (zzsj.zza.C0187zza c0187zza : c0188zza.zzbtO) {
            if (c0187zza.type == 14) {
                arrayList.add(null);
            } else if (i == 9) {
                DataMap dataMap = new DataMap();
                zzsj.zza[] zzaVarArr = c0187zza.zzbtE.zzbtN;
                for (zzsj.zza zzaVar : zzaVarArr) {
                    zza(list, dataMap, zzaVar.name, zzaVar.zzbtC);
                }
                arrayList.add(dataMap);
            } else if (i == 2) {
                arrayList.add(c0187zza.zzbtE.zzbtG);
            } else {
                if (i != 6) {
                    throw new IllegalArgumentException("Unexpected typeOfArrayList: " + i);
                }
                arrayList.add(Integer.valueOf(c0187zza.zzbtE.zzbtK));
            }
        }
        return arrayList;
    }

    private static void zza(List<Asset> list, DataMap dataMap, String str, zzsj.zza.C0187zza c0187zza) {
        int i = c0187zza.type;
        if (i == 14) {
            dataMap.putString(str, null);
            return;
        }
        zzsj.zza.C0187zza.C0188zza c0188zza = c0187zza.zzbtE;
        if (i == 1) {
            dataMap.putByteArray(str, c0188zza.zzbtF);
            return;
        }
        if (i == 11) {
            dataMap.putStringArray(str, c0188zza.zzbtP);
            return;
        }
        if (i == 12) {
            dataMap.putLongArray(str, c0188zza.zzbtQ);
            return;
        }
        if (i == 15) {
            dataMap.putFloatArray(str, c0188zza.zzbtR);
            return;
        }
        if (i == 2) {
            dataMap.putString(str, c0188zza.zzbtG);
            return;
        }
        if (i == 3) {
            dataMap.putDouble(str, c0188zza.zzbtH);
            return;
        }
        if (i == 4) {
            dataMap.putFloat(str, c0188zza.zzbtI);
            return;
        }
        if (i == 5) {
            dataMap.putLong(str, c0188zza.zzbtJ);
            return;
        }
        if (i == 6) {
            dataMap.putInt(str, c0188zza.zzbtK);
            return;
        }
        if (i == 7) {
            dataMap.putByte(str, (byte) c0188zza.zzbtL);
            return;
        }
        if (i == 8) {
            dataMap.putBoolean(str, c0188zza.zzbtM);
            return;
        }
        if (i == 13) {
            if (list == null) {
                throw new RuntimeException("populateBundle: unexpected type for: " + str);
            }
            dataMap.putAsset(str, list.get((int) c0188zza.zzbtS));
            return;
        }
        if (i == 9) {
            DataMap dataMap2 = new DataMap();
            for (zzsj.zza zzaVar : c0188zza.zzbtN) {
                zza(list, dataMap2, zzaVar.name, zzaVar.zzbtC);
            }
            dataMap.putDataMap(str, dataMap2);
            return;
        }
        if (i != 10) {
            throw new RuntimeException("populateBundle: unexpected type " + i);
        }
        int iZza = zza(str, c0188zza.zzbtO);
        ArrayList<Integer> arrayListZza = zza(list, c0188zza, iZza);
        if (iZza == 14) {
            dataMap.putStringArrayList(str, arrayListZza);
            return;
        }
        if (iZza == 9) {
            dataMap.putDataMapArrayList(str, arrayListZza);
        } else if (iZza == 2) {
            dataMap.putStringArrayList(str, arrayListZza);
        } else {
            if (iZza != 6) {
                throw new IllegalStateException("Unexpected typeOfArrayList: " + iZza);
            }
            dataMap.putIntegerArrayList(str, arrayListZza);
        }
    }

    private static zzsj.zza[] zza(DataMap dataMap, List<Asset> list) {
        TreeSet treeSet = new TreeSet(dataMap.keySet());
        zzsj.zza[] zzaVarArr = new zzsj.zza[treeSet.size()];
        int i = 0;
        Iterator it = treeSet.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return zzaVarArr;
            }
            String str = (String) it.next();
            Object obj = dataMap.get(str);
            zzaVarArr[i2] = new zzsj.zza();
            zzaVarArr[i2].name = str;
            zzaVarArr[i2].zzbtC = zza(list, obj);
            i = i2 + 1;
        }
    }
}
