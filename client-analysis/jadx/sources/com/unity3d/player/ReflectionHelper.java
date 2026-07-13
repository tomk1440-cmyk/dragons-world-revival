package com.unity3d.player;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class ReflectionHelper {
    protected static final boolean LOGV = false;
    protected static boolean LOG = false;
    private static a[] a = new a[4096];

    private static class a {
        public volatile Member a;
        private final Class b;
        private final String c;
        private final String d;
        private final int e;

        a(Class cls, String str, String str2) {
            this.b = cls;
            this.c = str;
            this.d = str2;
            this.e = ((((this.b.hashCode() + 527) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.e == aVar.e && this.d.equals(aVar.d) && this.c.equals(aVar.c) && this.b.equals(aVar.b);
        }

        public final int hashCode() {
            return this.e;
        }
    }

    ReflectionHelper() {
    }

    private static float a(Class cls, Class cls2) {
        if (cls.equals(cls2)) {
            return 1.0f;
        }
        if (!cls.isPrimitive() && !cls2.isPrimitive()) {
            try {
                if (cls.asSubclass(cls2) != null) {
                    return 0.5f;
                }
            } catch (ClassCastException e) {
            }
            try {
                if (cls2.asSubclass(cls) != null) {
                    return 0.1f;
                }
            } catch (ClassCastException e2) {
            }
        }
        return 0.0f;
    }

    private static float a(Class cls, Class[] clsArr, Class[] clsArr2) {
        int i = 0;
        if (clsArr2.length == 0) {
            return 0.1f;
        }
        if ((clsArr == null ? 0 : clsArr.length) + 1 != clsArr2.length) {
            return 0.0f;
        }
        float fA = 1.0f;
        if (clsArr != null) {
            int length = clsArr.length;
            int i2 = 0;
            while (i < length) {
                fA *= a(clsArr[i], clsArr2[i2]);
                i++;
                i2++;
            }
        }
        return fA * a(cls, clsArr2[clsArr2.length - 1]);
    }

    private static Class a(String str, int[] iArr) {
        while (iArr[0] < str.length()) {
            int i = iArr[0];
            iArr[0] = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt != '(' && cCharAt != ')') {
                if (cCharAt != 'L') {
                    if (cCharAt != 'Z') {
                        if (cCharAt != 'I') {
                            if (cCharAt != 'F') {
                                if (cCharAt != 'V') {
                                    if (cCharAt != 'B') {
                                        if (cCharAt != 'S') {
                                            if (cCharAt != 'J') {
                                                if (cCharAt != 'D') {
                                                    if (cCharAt != '[') {
                                                        d.Log(5, "! parseType; " + cCharAt + " is not known!");
                                                        break;
                                                    }
                                                    return Array.newInstance((Class<?>) a(str, iArr), 0).getClass();
                                                }
                                                return Double.TYPE;
                                            }
                                            return Long.TYPE;
                                        }
                                        return Short.TYPE;
                                    }
                                    return Byte.TYPE;
                                }
                                return Void.TYPE;
                            }
                            return Float.TYPE;
                        }
                        return Integer.TYPE;
                    }
                    return Boolean.TYPE;
                }
                int iIndexOf = str.indexOf(59, iArr[0]);
                if (iIndexOf == -1) {
                    break;
                }
                String strSubstring = str.substring(iArr[0], iIndexOf);
                iArr[0] = iIndexOf + 1;
                try {
                    return Class.forName(strSubstring.replace('/', '.'));
                } catch (ClassNotFoundException e) {
                    break;
                }
            }
        }
        return null;
    }

    private static void a(a aVar, Member member) {
        aVar.a = member;
        a[aVar.hashCode() & (a.length - 1)] = aVar;
    }

    private static boolean a(a aVar) {
        a aVar2 = a[aVar.hashCode() & (a.length - 1)];
        if (!aVar.equals(aVar2)) {
            return false;
        }
        aVar.a = aVar2.a;
        return true;
    }

    private static Class[] a(String str) {
        Class clsA;
        int[] iArr = {0};
        ArrayList arrayList = new ArrayList();
        while (iArr[0] < str.length() && (clsA = a(str, iArr)) != null) {
            arrayList.add(clsA);
        }
        Class[] clsArr = new Class[arrayList.size()];
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            clsArr[i] = (Class) it.next();
            i++;
        }
        return clsArr;
    }

    protected static Constructor getConstructorID(Class cls, String str) {
        Constructor<?> constructor;
        Constructor<?> constructor2;
        Constructor<?> constructor3;
        Constructor<?> constructor4 = null;
        a aVar = new a(cls, "", str);
        if (a(aVar)) {
            constructor2 = (Constructor) aVar.a;
        } else {
            Class[] clsArrA = a(str);
            float f = 0.0f;
            Constructor<?>[] constructors = cls.getConstructors();
            int length = constructors.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    constructor = constructor4;
                    break;
                }
                constructor = constructors[i];
                float fA = a(Void.TYPE, constructor.getParameterTypes(), clsArrA);
                if (fA <= f) {
                    fA = f;
                    constructor3 = constructor4;
                } else {
                    if (fA == 1.0f) {
                        break;
                    }
                    constructor3 = constructor;
                }
                i++;
                constructor4 = constructor3;
                f = fA;
            }
            a(aVar, constructor);
            constructor2 = constructor;
        }
        if (constructor2 == null) {
            throw new NoSuchMethodError("<init>" + str + " in class " + cls.getName());
        }
        return constructor2;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00ac  */
    protected static Field getFieldID(Class cls, String str, String str2, boolean z) {
        Field field;
        float fA;
        Field field2;
        a aVar = new a(cls, str, str2);
        if (a(aVar)) {
            field = (Field) aVar.a;
        } else {
            Class[] clsArrA = a(str2);
            field = null;
            float f = 0.0f;
            while (cls != null) {
                Field[] declaredFields = cls.getDeclaredFields();
                int length = declaredFields.length;
                int i = 0;
                Field field3 = field;
                while (true) {
                    if (i >= length) {
                        field = field3;
                        break;
                    }
                    Field field4 = declaredFields[i];
                    if (z == Modifier.isStatic(field4.getModifiers()) && field4.getName().compareTo(str) == 0) {
                        fA = a(field4.getType(), (Class[]) null, clsArrA);
                        if (fA <= f) {
                            fA = f;
                            field2 = field3;
                        } else {
                            if (fA == 1.0f) {
                                f = fA;
                                field = field4;
                                break;
                            }
                            field2 = field4;
                        }
                    } else {
                        fA = f;
                        field2 = field3;
                    }
                    i++;
                    field3 = field2;
                    f = fA;
                }
                if (f == 1.0f || cls.isPrimitive() || cls.isInterface() || cls.equals(Object.class) || cls.equals(Void.TYPE)) {
                    break;
                }
                cls = cls.getSuperclass();
            }
            a(aVar, field);
        }
        if (field != null) {
            return field;
        }
        Object[] objArr = new Object[4];
        objArr[0] = z ? "static" : "non-static";
        objArr[1] = str;
        objArr[2] = str2;
        objArr[3] = cls.getName();
        throw new NoSuchFieldError(String.format("no %s field with name='%s' signature='%s' in class L%s;", objArr));
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00af  */
    protected static Method getMethodID(Class cls, String str, String str2, boolean z) {
        Method method;
        float fA;
        Method method2;
        a aVar = new a(cls, str, str2);
        if (a(aVar)) {
            method = (Method) aVar.a;
        } else {
            Class[] clsArrA = a(str2);
            method = null;
            float f = 0.0f;
            while (cls != null) {
                Method[] declaredMethods = cls.getDeclaredMethods();
                int length = declaredMethods.length;
                int i = 0;
                Method method3 = method;
                while (true) {
                    if (i >= length) {
                        method = method3;
                        break;
                    }
                    Method method4 = declaredMethods[i];
                    if (z == Modifier.isStatic(method4.getModifiers()) && method4.getName().compareTo(str) == 0) {
                        fA = a(method4.getReturnType(), method4.getParameterTypes(), clsArrA);
                        if (fA <= f) {
                            fA = f;
                            method2 = method3;
                        } else {
                            if (fA == 1.0f) {
                                f = fA;
                                method = method4;
                                break;
                            }
                            method2 = method4;
                        }
                    } else {
                        fA = f;
                        method2 = method3;
                    }
                    i++;
                    method3 = method2;
                    f = fA;
                }
                if (f == 1.0f || cls.isPrimitive() || cls.isInterface() || cls.equals(Object.class) || cls.equals(Void.TYPE)) {
                    break;
                }
                cls = cls.getSuperclass();
            }
            a(aVar, method);
        }
        if (method != null) {
            return method;
        }
        Object[] objArr = new Object[4];
        objArr[0] = z ? "static" : "non-static";
        objArr[1] = str;
        objArr[2] = str2;
        objArr[3] = cls.getName();
        throw new NoSuchMethodError(String.format("no %s method with name='%s' signature='%s' in class L%s;", objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeProxyFinalize(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native Object nativeProxyInvoke(int i, String str, Object[] objArr);

    protected static Object newProxyInstance(int i, Class cls) {
        return newProxyInstance(i, new Class[]{cls});
    }

    protected static Object newProxyInstance(final int i, final Class[] clsArr) {
        return Proxy.newProxyInstance(ReflectionHelper.class.getClassLoader(), clsArr, new InvocationHandler() { // from class: com.unity3d.player.ReflectionHelper.1
            protected final void finalize() throws Throwable {
                try {
                    ReflectionHelper.nativeProxyFinalize(i);
                } finally {
                    super.finalize();
                }
            }

            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                return ReflectionHelper.nativeProxyInvoke(i, method.getName(), objArr);
            }
        });
    }
}
