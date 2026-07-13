package com.google.android.gms.fitness;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Scope;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zza {
    public static Scope zza(Scope scope) {
        if (scope.equals(new Scope(Scopes.FITNESS_ACTIVITY_READ))) {
            return new Scope(Scopes.FITNESS_ACTIVITY_READ_WRITE);
        }
        if (scope.equals(new Scope(Scopes.FITNESS_LOCATION_READ))) {
            return new Scope(Scopes.FITNESS_LOCATION_READ_WRITE);
        }
        if (scope.equals(new Scope(Scopes.FITNESS_BODY_READ))) {
            return new Scope(Scopes.FITNESS_BODY_READ_WRITE);
        }
        return scope.equals(new Scope(Scopes.FITNESS_NUTRITION_READ)) ? new Scope(Scopes.FITNESS_NUTRITION_READ_WRITE) : scope;
    }

    public static Set<Scope> zze(Collection<Scope> collection) {
        HashSet hashSet = new HashSet(collection.size());
        for (Scope scope : collection) {
            Scope scopeZza = zza(scope);
            if (scopeZza.equals(scope) || !collection.contains(scopeZza)) {
                hashSet.add(scope);
            }
        }
        return hashSet;
    }
}
