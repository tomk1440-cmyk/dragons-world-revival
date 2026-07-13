package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzjf {

    public interface zza<D, R> {
        R zzf(D d);
    }

    public static <A, B> zzjg<B> zza(final zzjg<A> zzjgVar, final zza<A, B> zzaVar) {
        final zzjd zzjdVar = new zzjd();
        zzjgVar.zzb(new Runnable() { // from class: com.google.android.gms.internal.zzjf.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    zzjdVar.zzg(zzaVar.zzf(zzjgVar.get()));
                } catch (InterruptedException | CancellationException | ExecutionException e) {
                    zzjdVar.cancel(true);
                }
            }
        });
        return zzjdVar;
    }

    public static <V> zzjg<List<V>> zzl(final List<zzjg<V>> list) {
        final zzjd zzjdVar = new zzjd();
        final int size = list.size();
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        Iterator<zzjg<V>> it = list.iterator();
        while (it.hasNext()) {
            it.next().zzb(new Runnable() { // from class: com.google.android.gms.internal.zzjf.2
                @Override // java.lang.Runnable
                public void run() {
                    if (atomicInteger.incrementAndGet() >= size) {
                        try {
                            zzjdVar.zzg(zzjf.zzm(list));
                        } catch (InterruptedException | ExecutionException e) {
                            zzin.zzd("Unable to convert list of futures to a future of list", e);
                        }
                    }
                }
            });
        }
        return zzjdVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <V> List<V> zzm(List<zzjg<V>> list) throws ExecutionException, InterruptedException {
        ArrayList arrayList = new ArrayList();
        Iterator<zzjg<V>> it = list.iterator();
        while (it.hasNext()) {
            V v = it.next().get();
            if (v != null) {
                arrayList.add(v);
            }
        }
        return arrayList;
    }
}
