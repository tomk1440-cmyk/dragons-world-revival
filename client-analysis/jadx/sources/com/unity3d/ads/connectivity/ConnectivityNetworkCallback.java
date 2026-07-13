package com.unity3d.ads.connectivity;

import android.annotation.TargetApi;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import com.unity3d.ads.properties.ClientProperties;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(21)
public class ConnectivityNetworkCallback extends ConnectivityManager.NetworkCallback {
    private static ConnectivityNetworkCallback _impl = null;

    public static void register() {
        if (_impl == null) {
            _impl = new ConnectivityNetworkCallback();
            ConnectivityManager cm = (ConnectivityManager) ClientProperties.getApplicationContext().getSystemService("connectivity");
            cm.registerNetworkCallback(new NetworkRequest.Builder().build(), _impl);
        }
    }

    public static void unregister() {
        if (_impl != null) {
            ConnectivityManager cm = (ConnectivityManager) ClientProperties.getApplicationContext().getSystemService("connectivity");
            cm.unregisterNetworkCallback(_impl);
            _impl = null;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        ConnectivityMonitor.connected();
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        ConnectivityMonitor.disconnected();
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network network, NetworkCapabilities capabilities) {
        ConnectivityMonitor.connectionStatusChanged();
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLinkPropertiesChanged(Network network, LinkProperties properties) {
        ConnectivityMonitor.connectionStatusChanged();
    }
}
