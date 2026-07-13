package com.socialquantum.dw.utils.memory;

import android.app.ActivityManager;
import android.os.Debug;
import android.util.Log;
import com.unity3d.player.UnityPlayer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MemoryUsageUtil {
    private static int mAppPid = -1;

    public static long GetAvailableMemory() {
        ActivityManager.MemoryInfo mi = GetUnityActivityMemoryInfo();
        long availableMegabytes = mi.availMem;
        return availableMegabytes;
    }

    public static long GetMemoryThreshold() {
        ActivityManager.MemoryInfo mi = GetUnityActivityMemoryInfo();
        long thresholdMegabytes = mi.threshold;
        return thresholdMegabytes;
    }

    public static boolean IsLowMemory() {
        return GetUnityActivityMemoryInfo().lowMemory;
    }

    private static ActivityManager.MemoryInfo GetUnityActivityMemoryInfo() {
        ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager) UnityPlayer.currentActivity.getSystemService("activity");
        activityManager.getMemoryInfo(mi);
        return mi;
    }

    public static long GetRuntimeTotalMemory() {
        return Runtime.getRuntime().totalMemory();
    }

    public static long GetRuntimeFreeMemory() {
        return Runtime.getRuntime().freeMemory();
    }

    public static long GetRuntimeMaxMemory() {
        return Runtime.getRuntime().maxMemory();
    }

    public static long GetHeapAllocatedSize() {
        return Debug.getNativeHeapAllocatedSize();
    }

    public static long GetPssMemory() {
        ActivityManager activityManager = (ActivityManager) UnityPlayer.currentActivity.getSystemService("activity");
        if (mAppPid < 0) {
            List<ActivityManager.RunningAppProcessInfo> pidsTask = activityManager.getRunningAppProcesses();
            Log.i("MemInfo", "pkg name: " + UnityPlayer.currentActivity.getPackageName());
            for (int i = 0; i < pidsTask.size(); i++) {
                Log.i("MemInfo", "pidsTask.get(i).processName: " + pidsTask.get(i).processName);
                if (pidsTask.get(i).processName.equalsIgnoreCase(UnityPlayer.currentActivity.getPackageName())) {
                    Log.i("MemInfo", "pid: " + pidsTask.get(i).pid);
                    mAppPid = pidsTask.get(i).pid;
                    break;
                }
                Log.i("MemInfo", "pid: " + pidsTask.get(i).pid);
            }
        }
        if (mAppPid > 0) {
            int[] pids = {mAppPid};
            Debug.MemoryInfo[] memoryInfoArray = activityManager.getProcessMemoryInfo(pids);
            if (memoryInfoArray.length > 0) {
                long memory = memoryInfoArray[0].getTotalPss();
                Log.i("MemInfo", "our pid: " + mAppPid + " memory: " + memory);
                return memory;
            }
        }
        return 0L;
    }
}
