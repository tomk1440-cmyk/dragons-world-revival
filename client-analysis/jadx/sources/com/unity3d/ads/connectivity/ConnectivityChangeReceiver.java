package com.unity3d.ads.connectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.unity3d.ads.properties.ClientProperties;

/* JADX INFO: loaded from: classes.dex */
public class ConnectivityChangeReceiver extends BroadcastReceiver {
    private static ConnectivityChangeReceiver _receiver = null;

    public static void register() {
        if (_receiver == null) {
            _receiver = new ConnectivityChangeReceiver();
            ClientProperties.getApplicationContext().registerReceiver(_receiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    public static void unregister() {
        if (_receiver != null) {
            ClientProperties.getApplicationContext().unregisterReceiver(_receiver);
            _receiver = null;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        NetworkInfo ni;
        if (intent.getBooleanExtra("noConnectivity", false)) {
            ConnectivityMonitor.disconnected();
            return;
        }
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService("connectivity");
        if (cm != null && (ni = cm.getActiveNetworkInfo()) != null && ni.isConnected()) {
            ConnectivityMonitor.connected();
        }
    }
}
