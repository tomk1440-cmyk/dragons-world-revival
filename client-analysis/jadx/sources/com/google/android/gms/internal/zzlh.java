package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.IdpTokenType;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class zzlh extends zzlg {
    public static final List<String> zzYf = Collections.singletonList("email");
    private Class<?> zzYg;
    private Class<?> zzYh;
    private Object zzYi;
    private Object zzYj;

    public zzlh(Activity activity, List<String> list) {
        super(activity, zzYf, list);
    }

    public static void zzag(Context context) throws IllegalStateException {
        com.google.android.gms.common.internal.zzx.zzz(context);
        try {
            try {
                Class.forName("com.facebook.FacebookSdk").getDeclaredMethod("sdkInitialize", Context.class, Integer.TYPE).invoke(null, context.getApplicationContext(), 64206);
                Class<?> cls = Class.forName("com.facebook.login.LoginManager");
                cls.getDeclaredMethod("logOut", new Class[0]).invoke(cls.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]), new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                Log.e("AuthSignInClient", "Facebook logout error.", e);
                throw new IllegalStateException("No supported Facebook SDK version found to use Facebook logout.");
            }
        } catch (ClassNotFoundException e2) {
            try {
                Class<?> cls2 = Class.forName("com.facebook.Session");
                Object objInvoke = cls2.getDeclaredMethod("getActiveSession", new Class[0]).invoke(null, new Object[0]);
                if (objInvoke != null) {
                    cls2.getDeclaredMethod("closeAndClearTokenInformation", new Class[0]).invoke(objInvoke, new Object[0]);
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e3) {
                Log.e("AuthSignInClient", "Facebook logout error.", e3);
                throw new IllegalStateException("No supported Facebook SDK version found to use Facebook logout.");
            }
        }
    }

    private void zznv() throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        if (this.zzYj != null) {
            Class.forName("com.facebook.login.LoginManager").getDeclaredMethod("logInWithReadPermissions", Activity.class, Collection.class).invoke(this.zzYj, this.mActivity, new ArrayList(zzns()));
            return;
        }
        Class<?> cls = Class.forName("com.facebook.Session$OpenRequest");
        Object objNewInstance = cls.getConstructor(Activity.class).newInstance(this.mActivity);
        cls.getDeclaredMethod("setPermissions", List.class).invoke(objNewInstance, new ArrayList(zzns()));
        cls.getDeclaredMethod("setRequestCode", Integer.TYPE).invoke(objNewInstance, 64206);
        Class<?> cls2 = Class.forName("com.facebook.Session");
        cls.getDeclaredMethod("setCallback", Class.forName("com.facebook.Session$StatusCallback")).invoke(objNewInstance, zznw());
        Object objNewInstance2 = cls2.getConstructor(Context.class).newInstance(this.mActivity);
        cls2.getDeclaredMethod("setActiveSession", cls2).invoke(null, objNewInstance2);
        cls2.getDeclaredMethod("openForRead", cls).invoke(objNewInstance2, objNewInstance);
    }

    private Object zznw() throws ClassNotFoundException {
        final Class<?> cls = Class.forName("com.facebook.Session");
        Class<?> cls2 = Class.forName("com.facebook.Session$StatusCallback");
        return Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, new InvocationHandler() { // from class: com.google.android.gms.internal.zzlh.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Class<?> cls3 = Class.forName("com.facebook.SessionState");
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (!method.getName().equals("call") || parameterTypes.length != 3 || parameterTypes[0] != cls || parameterTypes[1] != cls3 || parameterTypes[2] != Exception.class) {
                    throw new ExceptionInInitializerError("Method not supported!");
                }
                if (!((Boolean) cls.getDeclaredMethod("isOpened", new Class[0]).invoke(args[0], new Object[0])).booleanValue()) {
                    return null;
                }
                zzlh.this.zznt().zzk(zzlh.this.zza(IdpTokenType.zzXA, (String) cls.getDeclaredMethod("getAccessToken", new Class[0]).invoke(args[0], new Object[0]), zzlh.this.zznu()));
                return null;
            }
        });
    }

    @Override // com.google.android.gms.internal.zzlf
    public void zza(zzlf.zza zzaVar) {
        zzb(null, null, (zzlf.zza) com.google.android.gms.common.internal.zzx.zzz(zzaVar));
        try {
            zznv();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.google.android.gms.internal.zzlf
    public void zza(String str, zzlf.zza zzaVar) {
        zzb((String) com.google.android.gms.common.internal.zzx.zzz(str), null, (zzlf.zza) com.google.android.gms.common.internal.zzx.zzz(zzaVar));
        try {
            zznv();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.google.android.gms.internal.zzlf
    public void zza(String str, String str2, zzlf.zza zzaVar) {
        zzb((String) com.google.android.gms.common.internal.zzx.zzz(str), (String) com.google.android.gms.common.internal.zzx.zzz(str2), (zzlf.zza) com.google.android.gms.common.internal.zzx.zzz(zzaVar));
        try {
            zznv();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.google.android.gms.internal.zzlf
    public boolean zza(int i, int i2, Intent intent, zzlf.zza zzaVar) {
        zzb(zzaVar);
        if (i != 64206 && this.zzYg == null) {
            return false;
        }
        if (this.zzYg != null && this.zzYh != null && this.zzYi != null) {
            try {
                if (((Boolean) this.zzYg.getDeclaredMethod("isFacebookRequestCode", Integer.TYPE).invoke(null, Integer.valueOf(i))).booleanValue()) {
                    return ((Boolean) this.zzYh.getDeclaredMethod("onActivityResult", Integer.TYPE, Integer.TYPE, Intent.class).invoke(this.zzYi, Integer.valueOf(i), Integer.valueOf(i2), intent)).booleanValue();
                }
                return false;
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Class<?> cls = Class.forName("com.facebook.Session");
            Object objInvoke = cls.getDeclaredMethod("getActiveSession", new Class[0]).invoke(null, new Object[0]);
            Method declaredMethod = cls.getDeclaredMethod("onActivityResult", Activity.class, Integer.TYPE, Integer.TYPE, Intent.class);
            if (objInvoke == null) {
                return false;
            }
            return ((Boolean) declaredMethod.invoke(objInvoke, this.mActivity, Integer.valueOf(i), Integer.valueOf(i2), intent)).booleanValue();
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.google.android.gms.internal.zzlf
    public com.google.android.gms.auth.api.signin.zzd zzmU() {
        return com.google.android.gms.auth.api.signin.zzd.FACEBOOK;
    }
}
