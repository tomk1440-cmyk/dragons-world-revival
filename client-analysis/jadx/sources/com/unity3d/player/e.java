package com.unity3d.player;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public final class e implements b {
    private static boolean a(PackageItemInfo packageItemInfo) {
        try {
            return packageItemInfo.metaData.getBoolean("unityplayer.SkipPermissionsDialog");
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.unity3d.player.b
    public final void a(Activity activity, final Runnable runnable) {
        if (activity == null) {
            return;
        }
        PackageManager packageManager = activity.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(activity.getComponentName(), 128);
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(activity.getPackageName(), 128);
            if (a(activityInfo) || a(applicationInfo)) {
                runnable.run();
                return;
            }
        } catch (Exception e) {
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(activity.getPackageName(), 4096);
            if (packageInfo.requestedPermissions == null) {
                packageInfo.requestedPermissions = new String[0];
            }
            final LinkedList linkedList = new LinkedList();
            for (String str : packageInfo.requestedPermissions) {
                try {
                    if (packageManager.getPermissionInfo(str, 128).protectionLevel == 1 && activity.checkCallingOrSelfPermission(str) != 0) {
                        linkedList.add(str);
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    d.Log(5, "Failed to get permission info for " + str + ", manifest likely missing custom permission declaration");
                    d.Log(5, "Permission " + str + " ignored");
                }
            }
            if (linkedList.isEmpty()) {
                runnable.run();
                return;
            }
            final FragmentManager fragmentManager = activity.getFragmentManager();
            Fragment fragment = new Fragment() { // from class: com.unity3d.player.e.1
                @Override // android.app.Fragment
                public final void onCreate(Bundle bundle) {
                    super.onCreate(bundle);
                    requestPermissions((String[]) linkedList.toArray(new String[0]), 15881);
                }

                @Override // android.app.Fragment
                public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                    if (i != 15881) {
                        return;
                    }
                    for (int i2 = 0; i2 < strArr.length && i2 < iArr.length; i2++) {
                        d.Log(4, strArr[i2] + (iArr[i2] == 0 ? " granted" : " denied"));
                    }
                    FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
                    fragmentTransactionBeginTransaction.remove(this);
                    fragmentTransactionBeginTransaction.commit();
                    runnable.run();
                }
            };
            FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
            fragmentTransactionBeginTransaction.add(0, fragment);
            fragmentTransactionBeginTransaction.commit();
        } catch (Exception e3) {
            d.Log(6, "Unable to query for permission: " + e3.getMessage());
        }
    }
}
