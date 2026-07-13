package com.google.android.gms.tagmanager;

import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class DataLayer {
    public static final String EVENT_KEY = "event";
    public static final Object OBJECT_NOT_PRESENT = new Object();
    static final String[] zzbir = "gtm.lifetime".toString().split("\\.");
    private static final Pattern zzbis = Pattern.compile("(\\d+)\\s*([smhd]?)");
    private final ConcurrentHashMap<zzb, Integer> zzbit;
    private final Map<String, Object> zzbiu;
    private final ReentrantLock zzbiv;
    private final LinkedList<Map<String, Object>> zzbiw;
    private final zzc zzbix;
    private final CountDownLatch zzbiy;

    static final class zza {
        public final Object zzNc;
        public final String zzvs;

        zza(String str, Object obj) {
            this.zzvs = str;
            this.zzNc = obj;
        }

        public boolean equals(Object o) {
            if (!(o instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) o;
            return this.zzvs.equals(zzaVar.zzvs) && this.zzNc.equals(zzaVar.zzNc);
        }

        public int hashCode() {
            return Arrays.hashCode(new Integer[]{Integer.valueOf(this.zzvs.hashCode()), Integer.valueOf(this.zzNc.hashCode())});
        }

        public String toString() {
            return "Key: " + this.zzvs + " value: " + this.zzNc.toString();
        }
    }

    interface zzb {
        void zzQ(Map<String, Object> map);
    }

    interface zzc {

        public interface zza {
            void zzB(List<zza> list);
        }

        void zza(zza zzaVar);

        void zza(List<zza> list, long j);

        void zzfZ(String str);
    }

    DataLayer() {
        this(new zzc() { // from class: com.google.android.gms.tagmanager.DataLayer.1
            @Override // com.google.android.gms.tagmanager.DataLayer.zzc
            public void zza(zzc.zza zzaVar) {
                zzaVar.zzB(new ArrayList());
            }

            @Override // com.google.android.gms.tagmanager.DataLayer.zzc
            public void zza(List<zza> list, long j) {
            }

            @Override // com.google.android.gms.tagmanager.DataLayer.zzc
            public void zzfZ(String str) {
            }
        });
    }

    DataLayer(zzc persistentStore) {
        this.zzbix = persistentStore;
        this.zzbit = new ConcurrentHashMap<>();
        this.zzbiu = new HashMap();
        this.zzbiv = new ReentrantLock();
        this.zzbiw = new LinkedList<>();
        this.zzbiy = new CountDownLatch(1);
        zzGn();
    }

    public static List<Object> listOf(Object... objects) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objects) {
            arrayList.add(obj);
        }
        return arrayList;
    }

    public static Map<String, Object> mapOf(Object... objects) {
        if (objects.length % 2 != 0) {
            throw new IllegalArgumentException("expected even number of key-value pairs");
        }
        HashMap map = new HashMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objects.length) {
                return map;
            }
            if (!(objects[i2] instanceof String)) {
                throw new IllegalArgumentException("key is not a string: " + objects[i2]);
            }
            map.put((String) objects[i2], objects[i2 + 1]);
            i = i2 + 2;
        }
    }

    private void zzGn() {
        this.zzbix.zza(new zzc.zza() { // from class: com.google.android.gms.tagmanager.DataLayer.2
            @Override // com.google.android.gms.tagmanager.DataLayer.zzc.zza
            public void zzB(List<zza> list) {
                for (zza zzaVar : list) {
                    DataLayer.this.zzS(DataLayer.this.zzn(zzaVar.zzvs, zzaVar.zzNc));
                }
                DataLayer.this.zzbiy.countDown();
            }
        });
    }

    private void zzGo() {
        int i = 0;
        do {
            int i2 = i;
            Map<String, Object> mapPoll = this.zzbiw.poll();
            if (mapPoll == null) {
                return;
            }
            zzX(mapPoll);
            i = i2 + 1;
        } while (i <= 500);
        this.zzbiw.clear();
        throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzS(Map<String, Object> map) {
        this.zzbiv.lock();
        try {
            this.zzbiw.offer(map);
            if (this.zzbiv.getHoldCount() == 1) {
                zzGo();
            }
            zzT(map);
        } finally {
            this.zzbiv.unlock();
        }
    }

    private void zzT(Map<String, Object> map) {
        Long lZzU = zzU(map);
        if (lZzU == null) {
            return;
        }
        List<zza> listZzW = zzW(map);
        listZzW.remove("gtm.lifetime");
        this.zzbix.zza(listZzW, lZzU.longValue());
    }

    private Long zzU(Map<String, Object> map) {
        Object objZzV = zzV(map);
        if (objZzV == null) {
            return null;
        }
        return zzfY(objZzV.toString());
    }

    private Object zzV(Map<String, Object> map) {
        String[] strArr = zzbir;
        int length = strArr.length;
        int i = 0;
        Object obj = map;
        while (i < length) {
            String str = strArr[i];
            if (!(obj instanceof Map)) {
                return null;
            }
            i++;
            obj = ((Map) obj).get(str);
        }
        return obj;
    }

    private List<zza> zzW(Map<String, Object> map) {
        ArrayList arrayList = new ArrayList();
        zza(map, "", arrayList);
        return arrayList;
    }

    private void zzX(Map<String, Object> map) {
        synchronized (this.zzbiu) {
            for (String str : map.keySet()) {
                zzd(zzn(str, map.get(str)), this.zzbiu);
            }
        }
        zzY(map);
    }

    private void zzY(Map<String, Object> map) {
        Iterator<zzb> it = this.zzbit.keySet().iterator();
        while (it.hasNext()) {
            it.next().zzQ(map);
        }
    }

    private void zza(Map<String, Object> map, String str, Collection<zza> collection) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String str2 = str + (str.length() == 0 ? "" : ".") + entry.getKey();
            if (entry.getValue() instanceof Map) {
                zza((Map) entry.getValue(), str2, collection);
            } else if (!str2.equals("gtm.lifetime")) {
                collection.add(new zza(str2, entry.getValue()));
            }
        }
    }

    static Long zzfY(String str) {
        long j;
        Matcher matcher = zzbis.matcher(str);
        if (!matcher.matches()) {
            zzbg.zzaJ("unknown _lifetime: " + str);
            return null;
        }
        try {
            j = Long.parseLong(matcher.group(1));
        } catch (NumberFormatException e) {
            zzbg.zzaK("illegal number in _lifetime value: " + str);
            j = 0;
        }
        if (j <= 0) {
            zzbg.zzaJ("non-positive _lifetime: " + str);
            return null;
        }
        String strGroup = matcher.group(2);
        if (strGroup.length() == 0) {
            return Long.valueOf(j);
        }
        switch (strGroup.charAt(0)) {
            case 'd':
                return Long.valueOf(j * 1000 * 60 * 60 * 24);
            case LocationRequest.PRIORITY_LOW_POWER /* 104 */:
                return Long.valueOf(j * 1000 * 60 * 60);
            case 'm':
                return Long.valueOf(j * 1000 * 60);
            case 's':
                return Long.valueOf(j * 1000);
            default:
                zzbg.zzaK("unknown units in _lifetime: " + str);
                return null;
        }
    }

    public Object get(String key) {
        synchronized (this.zzbiu) {
            Map<String, Object> map = this.zzbiu;
            String[] strArrSplit = key.split("\\.");
            int length = strArrSplit.length;
            Object obj = map;
            int i = 0;
            while (i < length) {
                String str = strArrSplit[i];
                if (!(obj instanceof Map)) {
                    return null;
                }
                Object obj2 = ((Map) obj).get(str);
                if (obj2 == null) {
                    return null;
                }
                i++;
                obj = obj2;
            }
            return obj;
        }
    }

    public void push(String key, Object value) {
        push(zzn(key, value));
    }

    public void push(Map<String, Object> update) {
        try {
            this.zzbiy.await();
        } catch (InterruptedException e) {
            zzbg.zzaK("DataLayer.push: unexpected InterruptedException");
        }
        zzS(update);
    }

    public void pushEvent(String eventName, Map<String, Object> update) {
        HashMap map = new HashMap(update);
        map.put("event", eventName);
        push(map);
    }

    public String toString() {
        String string;
        synchronized (this.zzbiu) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Object> entry : this.zzbiu.entrySet()) {
                sb.append(String.format("{\n\tKey: %s\n\tValue: %s\n}\n", entry.getKey(), entry.getValue()));
            }
            string = sb.toString();
        }
        return string;
    }

    void zza(zzb zzbVar) {
        this.zzbit.put(zzbVar, 0);
    }

    void zzb(List<Object> list, List<Object> list2) {
        while (list2.size() < list.size()) {
            list2.add(null);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            Object obj = list.get(i2);
            if (obj instanceof List) {
                if (!(list2.get(i2) instanceof List)) {
                    list2.set(i2, new ArrayList());
                }
                zzb((List) obj, (List) list2.get(i2));
            } else if (obj instanceof Map) {
                if (!(list2.get(i2) instanceof Map)) {
                    list2.set(i2, new HashMap());
                }
                zzd((Map) obj, (Map) list2.get(i2));
            } else if (obj != OBJECT_NOT_PRESENT) {
                list2.set(i2, obj);
            }
            i = i2 + 1;
        }
    }

    void zzd(Map<String, Object> map, Map<String, Object> map2) {
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof List) {
                if (!(map2.get(str) instanceof List)) {
                    map2.put(str, new ArrayList());
                }
                zzb((List) obj, (List) map2.get(str));
            } else if (obj instanceof Map) {
                if (!(map2.get(str) instanceof Map)) {
                    map2.put(str, new HashMap());
                }
                zzd((Map) obj, (Map) map2.get(str));
            } else {
                map2.put(str, obj);
            }
        }
    }

    void zzfX(String str) {
        push(str, null);
        this.zzbix.zzfZ(str);
    }

    Map<String, Object> zzn(String str, Object obj) {
        HashMap map = new HashMap();
        String[] strArrSplit = str.toString().split("\\.");
        int i = 0;
        HashMap map2 = map;
        while (i < strArrSplit.length - 1) {
            HashMap map3 = new HashMap();
            map2.put(strArrSplit[i], map3);
            i++;
            map2 = map3;
        }
        map2.put(strArrSplit[strArrSplit.length - 1], obj);
        return map;
    }
}
