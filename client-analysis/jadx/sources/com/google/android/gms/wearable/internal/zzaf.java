package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzaf extends com.google.android.gms.common.data.zzc implements DataItem {
    private final int zzaDQ;

    public zzaf(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.zzaDQ = i2;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public Map<String, DataItemAsset> getAssets() {
        HashMap map = new HashMap(this.zzaDQ);
        for (int i = 0; i < this.zzaDQ; i++) {
            zzac zzacVar = new zzac(this.zzahi, this.zzaje + i);
            if (zzacVar.getDataItemKey() != null) {
                map.put(zzacVar.getDataItemKey(), zzacVar);
            }
        }
        return map;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public byte[] getData() {
        return getByteArray(ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    @Override // com.google.android.gms.wearable.DataItem
    public Uri getUri() {
        return Uri.parse(getString("path"));
    }

    @Override // com.google.android.gms.wearable.DataItem
    public DataItem setData(byte[] data) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return toString(Log.isLoggable("DataItem", 3));
    }

    public String toString(boolean verbose) {
        byte[] data = getData();
        Map<String, DataItemAsset> assets = getAssets();
        StringBuilder sb = new StringBuilder("DataItemInternal{ ");
        sb.append("uri=" + getUri());
        sb.append(", dataSz=" + (data == null ? "null" : Integer.valueOf(data.length)));
        sb.append(", numAssets=" + assets.size());
        if (verbose && !assets.isEmpty()) {
            sb.append(", assets=[");
            String str = "";
            Iterator<Map.Entry<String, DataItemAsset>> it = assets.entrySet().iterator();
            while (true) {
                String str2 = str;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, DataItemAsset> next = it.next();
                sb.append(str2 + next.getKey() + ": " + next.getValue().getId());
                str = ", ";
            }
            sb.append("]");
        }
        sb.append(" }");
        return sb.toString();
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzIM, reason: merged with bridge method [inline-methods] */
    public DataItem freeze() {
        return new zzad(this);
    }
}
