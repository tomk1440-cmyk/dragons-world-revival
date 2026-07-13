package com.socialquantum.device.memory;

import android.util.Log;
import com.unity3d.player.UnityPlayer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class MemoryUtil {
    private static MemoryUtil _instance;
    private final String TAG = "MemoryUtil";
    private final int CHUNK_ARRAY_SIZE = 1000000;
    private ArrayList memoryList = new ArrayList();

    private MemoryUtil() {
    }

    public static MemoryUtil Instance() {
        if (_instance == null) {
            _instance = new MemoryUtil();
        }
        return _instance;
    }

    public void createMemoryChunk() {
        Log.d("MemoryUtil", "Created memory chunk of size 4MB");
        this.memoryList.add(new int[1000000]);
    }

    public void reportMemory(int level) {
        try {
            UnityPlayer.UnitySendMessage("DeviceBridge", "HandleMemoryWarning", String.valueOf(level));
        } catch (Error | Exception e) {
            Log.w("MemoryUtil", "LowMemoryWarning : " + level);
        }
    }
}
