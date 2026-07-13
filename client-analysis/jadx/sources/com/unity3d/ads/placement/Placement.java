package com.unity3d.ads.placement;

import com.unity3d.ads.UnityAds;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class Placement {
    private static String _defaultPlacement;
    private static HashMap<String, UnityAds.PlacementState> _placementReadyMap;

    public static void setDefaultPlacement(String placement) {
        _defaultPlacement = placement;
    }

    public static void setPlacementState(String placement, String placementState) {
        if (_placementReadyMap == null) {
            _placementReadyMap = new HashMap<>();
        }
        _placementReadyMap.put(placement, UnityAds.PlacementState.valueOf(placementState));
    }

    public static boolean isReady(String placement) {
        return getPlacementState(placement) == UnityAds.PlacementState.READY;
    }

    public static boolean isReady() {
        return getPlacementState() == UnityAds.PlacementState.READY;
    }

    public static UnityAds.PlacementState getPlacementState(String placement) {
        return currentState(placement);
    }

    public static UnityAds.PlacementState getPlacementState() {
        return _defaultPlacement == null ? UnityAds.PlacementState.NOT_AVAILABLE : getPlacementState(_defaultPlacement);
    }

    public static void reset() {
        _placementReadyMap = null;
        _defaultPlacement = null;
    }

    public static String getDefaultPlacement() {
        return _defaultPlacement;
    }

    private static UnityAds.PlacementState currentState(String placement) {
        return (_placementReadyMap == null || !_placementReadyMap.containsKey(placement)) ? UnityAds.PlacementState.NOT_AVAILABLE : _placementReadyMap.get(placement);
    }
}
