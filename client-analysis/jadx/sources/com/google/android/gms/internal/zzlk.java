package com.google.android.gms.internal;

import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.games.Games;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class zzlk {
    private static final com.google.android.gms.cast.internal.zzl zzaaf = new com.google.android.gms.cast.internal.zzl("GameManagerMessage");
    protected final zzlj zzacE;
    protected final String zzacX;
    protected final long zzacY;
    protected final JSONObject zzacZ;
    protected final int zzadd;
    protected final int zzade;
    protected final String zzadf;
    protected final int zzadg;
    protected final int zzadh;
    protected final List<zzlo> zzadi;
    protected final JSONObject zzadj;
    protected final String zzadk;
    protected final String zzadl;

    public zzlk(int i, int i2, String str, JSONObject jSONObject, int i3, int i4, List<zzlo> list, JSONObject jSONObject2, String str2, String str3, long j, String str4, zzlj zzljVar) {
        this.zzadd = i;
        this.zzade = i2;
        this.zzadf = str;
        this.zzacZ = jSONObject;
        this.zzadg = i3;
        this.zzadh = i4;
        this.zzadi = list;
        this.zzadj = jSONObject2;
        this.zzadk = str2;
        this.zzacX = str3;
        this.zzacY = j;
        this.zzadl = str4;
        this.zzacE = zzljVar;
    }

    private static List<zzlo> zzb(JSONArray jSONArray) {
        zzlo zzloVar;
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                try {
                    zzloVar = new zzlo(jSONObjectOptJSONObject);
                } catch (JSONException e) {
                    zzaaf.zzc(e, "Exception when attempting to parse PlayerInfoMessageComponent at index %d", Integer.valueOf(i));
                    zzloVar = null;
                }
                if (zzloVar != null) {
                    arrayList.add(zzloVar);
                }
            }
        }
        return arrayList;
    }

    protected static zzlk zzi(JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt(ShareConstants.MEDIA_TYPE, -1);
        try {
            switch (iOptInt) {
                case 1:
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("gameManagerConfig");
                    return new zzlk(iOptInt, jSONObject.optInt("statusCode"), jSONObject.optString("errorDescription"), jSONObject.optJSONObject("extraMessageData"), jSONObject.optInt("gameplayState"), jSONObject.optInt("lobbyState"), zzb(jSONObject.optJSONArray(Games.EXTRA_PLAYER_IDS)), jSONObject.optJSONObject("gameData"), jSONObject.optString("gameStatusText"), jSONObject.optString("playerId"), jSONObject.optLong("requestId"), jSONObject.optString("playerToken"), jSONObjectOptJSONObject != null ? new zzlj(jSONObjectOptJSONObject) : null);
                case 2:
                    return new zzlk(iOptInt, jSONObject.optInt("statusCode"), jSONObject.optString("errorDescription"), jSONObject.optJSONObject("extraMessageData"), jSONObject.optInt("gameplayState"), jSONObject.optInt("lobbyState"), zzb(jSONObject.optJSONArray(Games.EXTRA_PLAYER_IDS)), jSONObject.optJSONObject("gameData"), jSONObject.optString("gameStatusText"), jSONObject.optString("playerId"), -1L, null, null);
                default:
                    zzaaf.zzf("Unrecognized Game Message type %d", Integer.valueOf(iOptInt));
                    return null;
            }
        } catch (JSONException e) {
            zzaaf.zzc(e, "Exception while parsing GameManagerMessage from json", new Object[0]);
        }
    }

    public final JSONObject getExtraMessageData() {
        return this.zzacZ;
    }

    public final JSONObject getGameData() {
        return this.zzadj;
    }

    public final int getGameplayState() {
        return this.zzadg;
    }

    public final int getLobbyState() {
        return this.zzadh;
    }

    public final String getPlayerId() {
        return this.zzacX;
    }

    public final long getRequestId() {
        return this.zzacY;
    }

    public final int getStatusCode() {
        return this.zzade;
    }

    public final int zznY() {
        return this.zzadd;
    }

    public final String zznZ() {
        return this.zzadf;
    }

    public final List<zzlo> zzoa() {
        return this.zzadi;
    }

    public final String zzob() {
        return this.zzadk;
    }

    public final String zzoc() {
        return this.zzadl;
    }

    public final zzlj zzod() {
        return this.zzacE;
    }
}
