package io.fabric.unity.android;

import android.os.Bundle;
import io.fabric.sdk.android.Kit;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
class KitInstantiator {
    static final String TWITTERAUTH_KEY = "io.fabric.twittercore.key";
    static final String TWITTERAUTH_SECRET = "io.fabric.twittercore.secret";
    private static final String TWITTER_AUTH_CLASSNAME = "com.twitter.sdk.android.core.TwitterAuthConfig";
    static final String TWITTER_CORE = "TwitterCore";
    private final Bundle manifestMetadata;

    public KitInstantiator() {
        this(new Bundle());
    }

    public KitInstantiator(Bundle manifestMetadata) {
        this.manifestMetadata = manifestMetadata;
    }

    public Kit[] createKitsFromKitData(KitData[] kitDataArray) {
        int kitCount = kitDataArray.length;
        Kit[] kits = new Kit[kitCount];
        for (int i = 0; i < kitCount; i++) {
            try {
                kits[i] = instantiateKit(kitDataArray[i]);
            } catch (FabricInitializationException initEx) {
                throw initEx;
            } catch (Exception e) {
                throw new FabricInitializationException("Could not instantiate kits", e);
            }
        }
        return kits;
    }

    private Kit instantiateKit(KitData kitData) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        Class<? extends U> clsAsSubclass = Class.forName(kitData.fullyQualifiedClassName).asSubclass(Kit.class);
        if (!TWITTER_CORE.equals(kitData.kitName)) {
            return (Kit) clsAsSubclass.getConstructor(new Class[0]).newInstance(new Object[0]);
        }
        if (!this.manifestMetadata.containsKey(TWITTERAUTH_KEY) || !this.manifestMetadata.containsKey(TWITTERAUTH_SECRET)) {
            throw new FabricInitializationException("Could not find Twitter key and secret.");
        }
        String key = this.manifestMetadata.getString(TWITTERAUTH_KEY);
        String secret = this.manifestMetadata.getString(TWITTERAUTH_SECRET);
        return instantiateTwitterKit(kitData.fullyQualifiedClassName, key, secret);
    }

    private Kit instantiateTwitterKit(String fullyQualifiedClassName, String key, String secret) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        Class<? extends U> clsAsSubclass = Class.forName(fullyQualifiedClassName).asSubclass(Kit.class);
        Class<?> authClass = Class.forName(TWITTER_AUTH_CLASSNAME);
        Object twitterAuthObj = authClass.getConstructor(String.class, String.class).newInstance(key, secret);
        return (Kit) clsAsSubclass.getConstructor(authClass).newInstance(twitterAuthObj);
    }
}
