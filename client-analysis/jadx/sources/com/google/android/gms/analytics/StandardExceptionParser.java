package com.google.android.gms.analytics;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.analytics.internal.zzae;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public class StandardExceptionParser implements ExceptionParser {
    private final TreeSet<String> zzPr = new TreeSet<>();

    public StandardExceptionParser(Context context, Collection<String> additionalPackages) {
        setIncludedPackages(context, additionalPackages);
    }

    protected StackTraceElement getBestStackTraceElement(Throwable t) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        if (stackTrace == null || stackTrace.length == 0) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            Iterator<String> it = this.zzPr.iterator();
            while (it.hasNext()) {
                if (className.startsWith(it.next())) {
                    return stackTraceElement;
                }
            }
        }
        return stackTrace[0];
    }

    protected Throwable getCause(Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    @Override // com.google.android.gms.analytics.ExceptionParser
    public String getDescription(String threadName, Throwable t) {
        return getDescription(getCause(t), getBestStackTraceElement(getCause(t)), threadName);
    }

    protected String getDescription(Throwable cause, StackTraceElement element, String threadName) {
        StringBuilder sb = new StringBuilder();
        sb.append(cause.getClass().getSimpleName());
        if (element != null) {
            String[] strArrSplit = element.getClassName().split("\\.");
            String str = "unknown";
            if (strArrSplit != null && strArrSplit.length > 0) {
                str = strArrSplit[strArrSplit.length - 1];
            }
            sb.append(String.format(" (@%s:%s:%s)", str, element.getMethodName(), Integer.valueOf(element.getLineNumber())));
        }
        if (threadName != null) {
            sb.append(String.format(" {%s}", threadName));
        }
        return sb.toString();
    }

    public void setIncludedPackages(Context context, Collection<String> additionalPackages) {
        this.zzPr.clear();
        HashSet<String> hashSet = new HashSet();
        if (additionalPackages != null) {
            hashSet.addAll(additionalPackages);
        }
        if (context != null) {
            try {
                String packageName = context.getApplicationContext().getPackageName();
                this.zzPr.add(packageName);
                ActivityInfo[] activityInfoArr = context.getApplicationContext().getPackageManager().getPackageInfo(packageName, 1).activities;
                if (activityInfoArr != null) {
                    for (ActivityInfo activityInfo : activityInfoArr) {
                        hashSet.add(activityInfo.packageName);
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                zzae.zzaJ("No package found");
            }
        }
        for (String str : hashSet) {
            boolean z = true;
            for (String str2 : this.zzPr) {
                if (!str.startsWith(str2)) {
                    if (!str2.startsWith(str)) {
                        break;
                    }
                    this.zzPr.remove(str2);
                    break;
                }
                z = false;
            }
            if (z) {
                this.zzPr.add(str);
            }
        }
    }
}
