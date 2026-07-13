package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.CastStatusCodes;
import com.google.android.gms.cast.games.GameManagerClient;
import com.google.android.gms.cast.games.GameManagerState;
import com.google.android.gms.cast.games.PlayerInfo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class zzli extends com.google.android.gms.cast.internal.zzc {
    static final String NAMESPACE = com.google.android.gms.cast.internal.zzf.zzci("com.google.cast.games");
    private static final com.google.android.gms.cast.internal.zzl zzaaf = new com.google.android.gms.cast.internal.zzl("GameManagerChannel");
    private final List<com.google.android.gms.cast.internal.zzp> zzacA;
    private final String zzacB;
    private final Cast.CastApi zzacC;
    private final GoogleApiClient zzacD;
    private zzlj zzacE;
    private boolean zzacF;
    private GameManagerState zzacG;
    private GameManagerState zzacH;
    private String zzacI;
    private JSONObject zzacJ;
    private long zzacK;
    private GameManagerClient.Listener zzacL;
    private String zzacM;
    private final Map<String, String> zzacz;
    private final SharedPreferences zzvx;

    public abstract class zza extends zzb<GameManagerClient.GameManagerResult> {
        public zza() {
            super();
            this.zzacm = new com.google.android.gms.cast.internal.zzo() { // from class: com.google.android.gms.internal.zzli.zza.1
                @Override // com.google.android.gms.cast.internal.zzo
                public void zza(long j, int i, Object obj) {
                    try {
                        if (obj == null) {
                            zza.this.zza(new zze(new Status(i, null, null), null, j, null));
                            return;
                        }
                        zzlk zzlkVar = (zzlk) obj;
                        String playerId = zzlkVar.getPlayerId();
                        if (i == 0 && playerId != null) {
                            zzli.this.zzacM = playerId;
                        }
                        zza.this.zza(new zze(new Status(i, zzlkVar.zznZ(), null), playerId, zzlkVar.getRequestId(), zzlkVar.getExtraMessageData()));
                    } catch (ClassCastException e) {
                        zza.this.zza(zza.this.zzc(new Status(13)));
                    }
                }

                @Override // com.google.android.gms.cast.internal.zzo
                public void zzy(long j) {
                    zza.this.zza(zza.this.zzc(new Status(2103)));
                }
            };
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzr, reason: merged with bridge method [inline-methods] */
        public GameManagerClient.GameManagerResult zzc(Status status) {
            return new zze(status, null, -1L, null);
        }
    }

    public abstract class zzb<R extends Result> extends com.google.android.gms.cast.internal.zzb<R> {
        protected com.google.android.gms.cast.internal.zzo zzacm;

        public zzb() {
            super(zzli.this.zzacD);
        }

        public abstract void execute();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(com.google.android.gms.cast.internal.zze zzeVar) {
            execute();
        }

        public com.google.android.gms.cast.internal.zzo zznW() {
            return this.zzacm;
        }
    }

    public abstract class zzc extends zzb<GameManagerClient.GameManagerInstanceResult> {
        private GameManagerClient zzacV;

        public zzc(GameManagerClient gameManagerClient) {
            super();
            this.zzacV = gameManagerClient;
            this.zzacm = new com.google.android.gms.cast.internal.zzo() { // from class: com.google.android.gms.internal.zzli.zzc.1
                @Override // com.google.android.gms.cast.internal.zzo
                public void zza(long j, int i, Object obj) {
                    try {
                        if (obj == null) {
                            zzc.this.zza(new zzd(new Status(i, null, null), zzc.this.zzacV));
                        } else {
                            zzlk zzlkVar = (zzlk) obj;
                            zzlj zzljVarZzod = zzlkVar.zzod();
                            if (zzljVarZzod == null || com.google.android.gms.cast.internal.zzf.zza("1.0.0", zzljVarZzod.getVersion())) {
                                zzc.this.zza(new zzd(new Status(i, zzlkVar.zznZ(), null), zzc.this.zzacV));
                            } else {
                                zzc.this.zza(zzc.this.zzc(new Status(GameManagerClient.STATUS_INCORRECT_VERSION, String.format(Locale.ROOT, "Incorrect Game Manager SDK version. Receiver: %s Sender: %s", zzljVarZzod.getVersion(), "1.0.0"))));
                                zzli.this.zzacE = null;
                            }
                        }
                    } catch (ClassCastException e) {
                        zzc.this.zza(zzc.this.zzc(new Status(13)));
                    }
                }

                @Override // com.google.android.gms.cast.internal.zzo
                public void zzy(long j) {
                    zzc.this.zza(zzc.this.zzc(new Status(2103)));
                }
            };
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzs, reason: merged with bridge method [inline-methods] */
        public GameManagerClient.GameManagerInstanceResult zzc(Status status) {
            return new zzd(status, null);
        }
    }

    private static final class zzd implements GameManagerClient.GameManagerInstanceResult {
        private final Status zzUX;
        private final GameManagerClient zzacV;

        zzd(Status status, GameManagerClient gameManagerClient) {
            this.zzUX = status;
            this.zzacV = gameManagerClient;
        }

        @Override // com.google.android.gms.cast.games.GameManagerClient.GameManagerInstanceResult
        public GameManagerClient getGameManagerClient() {
            return this.zzacV;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class zze implements GameManagerClient.GameManagerResult {
        private final Status zzUX;
        private final String zzacX;
        private final long zzacY;
        private final JSONObject zzacZ;

        zze(Status status, String str, long j, JSONObject jSONObject) {
            this.zzUX = status;
            this.zzacX = str;
            this.zzacY = j;
            this.zzacZ = jSONObject;
        }

        @Override // com.google.android.gms.cast.games.GameManagerClient.GameManagerResult
        public JSONObject getExtraMessageData() {
            return this.zzacZ;
        }

        @Override // com.google.android.gms.cast.games.GameManagerClient.GameManagerResult
        public String getPlayerId() {
            return this.zzacX;
        }

        @Override // com.google.android.gms.cast.games.GameManagerClient.GameManagerResult
        public long getRequestId() {
            return this.zzacY;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    public zzli(GoogleApiClient googleApiClient, String str, Cast.CastApi castApi) throws IllegalStateException, IllegalArgumentException {
        super(NAMESPACE, "CastGameManagerChannel", null);
        this.zzacz = new ConcurrentHashMap();
        this.zzacF = false;
        this.zzacK = 0L;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("castSessionId cannot be null.");
        }
        if (googleApiClient == null || !googleApiClient.isConnected() || !googleApiClient.hasConnectedApi(Cast.API)) {
            throw new IllegalArgumentException("googleApiClient needs to be connected and contain the Cast.API API.");
        }
        this.zzacA = new ArrayList();
        this.zzacB = str;
        this.zzacC = castApi;
        this.zzacD = googleApiClient;
        Context applicationContext = googleApiClient.getContext().getApplicationContext();
        this.zzvx = applicationContext.getApplicationContext().getSharedPreferences(String.format(Locale.ROOT, "%s.%s", applicationContext.getPackageName(), "game_manager_channel_data"), 0);
        this.zzacH = null;
        this.zzacG = new zzlm(0, 0, "", null, new ArrayList(), "", -1);
    }

    private JSONObject zza(long j, String str, int i, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("requestId", j);
            jSONObject2.put(ShareConstants.MEDIA_TYPE, i);
            jSONObject2.put("extraMessageData", jSONObject);
            jSONObject2.put("playerId", str);
            jSONObject2.put("playerToken", zzce(str));
            return jSONObject2;
        } catch (JSONException e) {
            zzaaf.zzf("JSONException when trying to create a message: %s", e.getMessage());
            return null;
        }
    }

    private synchronized void zza(zzlk zzlkVar) {
        synchronized (this) {
            boolean z = zzlkVar.zznY() == 1;
            this.zzacH = this.zzacG;
            if (z && zzlkVar.zzod() != null) {
                this.zzacE = zzlkVar.zzod();
            }
            if (isInitialized()) {
                ArrayList arrayList = new ArrayList();
                for (zzlo zzloVar : zzlkVar.zzoa()) {
                    String playerId = zzloVar.getPlayerId();
                    arrayList.add(new zzln(playerId, zzloVar.getPlayerState(), zzloVar.getPlayerData(), this.zzacz.containsKey(playerId)));
                }
                this.zzacG = new zzlm(zzlkVar.getLobbyState(), zzlkVar.getGameplayState(), zzlkVar.zzob(), zzlkVar.getGameData(), arrayList, this.zzacE.zznX(), this.zzacE.getMaxPlayers());
                PlayerInfo player = this.zzacG.getPlayer(zzlkVar.getPlayerId());
                if (player != null && player.isControllable() && zzlkVar.zznY() == 2) {
                    this.zzacI = zzlkVar.getPlayerId();
                    this.zzacJ = zzlkVar.getExtraMessageData();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(String str, int i, JSONObject jSONObject, com.google.android.gms.cast.internal.zzo zzoVar) {
        final long j = 1 + this.zzacK;
        this.zzacK = j;
        JSONObject jSONObjectZza = zza(j, str, i, jSONObject);
        if (jSONObjectZza == null) {
            zzoVar.zza(-1L, 2001, null);
            zzaaf.zzf("Not sending request because it was invalid.", new Object[0]);
            return;
        }
        com.google.android.gms.cast.internal.zzp zzpVar = new com.google.android.gms.cast.internal.zzp(30000L);
        zzpVar.zza(j, zzoVar);
        this.zzacA.add(zzpVar);
        zzW(true);
        this.zzacC.sendMessage(this.zzacD, getNamespace(), jSONObjectZza.toString()).setResultCallback(new ResultCallback<Status>() { // from class: com.google.android.gms.internal.zzli.4
            @Override // com.google.android.gms.common.api.ResultCallback
            /* JADX INFO: renamed from: zzp, reason: merged with bridge method [inline-methods] */
            public void onResult(Status status) {
                if (status.isSuccess()) {
                    return;
                }
                zzli.this.zzb(j, status.getStatusCode());
            }
        });
    }

    private void zzb(long j, int i, Object obj) {
        Iterator<com.google.android.gms.cast.internal.zzp> it = this.zzacA.iterator();
        while (it.hasNext()) {
            if (it.next().zzc(j, i, obj)) {
                it.remove();
            }
        }
    }

    private int zzbg(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 2001;
            case 2:
                return CastStatusCodes.NOT_ALLOWED;
            case 3:
                return GameManagerClient.STATUS_INCORRECT_VERSION;
            case 4:
                return GameManagerClient.STATUS_TOO_MANY_PLAYERS;
            default:
                zzaaf.zzf("Unknown GameManager protocol status code: " + i, new Object[0]);
                return 13;
        }
    }

    private synchronized void zznR() throws IllegalStateException {
        if (!isInitialized()) {
            throw new IllegalStateException("Attempted to perform an operation on the GameManagerChannel before it is initialized.");
        }
        if (isDisposed()) {
            throw new IllegalStateException("Attempted to perform an operation on the GameManagerChannel after it has been disposed.");
        }
    }

    private void zznS() {
        if (this.zzacL != null) {
            if (this.zzacH != null && !this.zzacG.equals(this.zzacH)) {
                this.zzacL.onStateChanged(this.zzacG, this.zzacH);
            }
            if (this.zzacJ != null && this.zzacI != null) {
                this.zzacL.onGameMessageReceived(this.zzacI, this.zzacJ);
            }
        }
        this.zzacH = null;
        this.zzacI = null;
        this.zzacJ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void zznT() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("castSessionId", this.zzacB);
            jSONObject.put("playerTokenMap", new JSONObject(this.zzacz));
            this.zzvx.edit().putString("save_data", jSONObject.toString()).commit();
        } catch (JSONException e) {
            zzaaf.zzf("Error while saving data: %s", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void zznU() {
        String string = this.zzvx.getString("save_data", null);
        if (string != null) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (this.zzacB.equals(jSONObject.getString("castSessionId"))) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("playerTokenMap");
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        this.zzacz.put(next, jSONObject2.getString(next));
                    }
                    this.zzacK = 0L;
                }
            } catch (JSONException e) {
                zzaaf.zzf("Error while loading data: %s", e.getMessage());
            }
        }
    }

    public synchronized void dispose() throws IllegalStateException {
        if (!this.zzacF) {
            this.zzacG = null;
            this.zzacH = null;
            this.zzacI = null;
            this.zzacJ = null;
            this.zzacF = true;
            try {
                this.zzacC.removeMessageReceivedCallbacks(this.zzacD, getNamespace());
            } catch (IOException e) {
                zzaaf.zzf("Exception while detaching game manager channel.", e);
            }
        }
    }

    public synchronized GameManagerState getCurrentState() throws IllegalStateException {
        zznR();
        return this.zzacG;
    }

    public synchronized String getLastUsedPlayerId() throws IllegalStateException {
        zznR();
        return this.zzacM;
    }

    public synchronized boolean isDisposed() {
        return this.zzacF;
    }

    public synchronized boolean isInitialized() {
        return this.zzacE != null;
    }

    public synchronized void sendGameMessage(String playerId, JSONObject extraMessageData) throws IllegalStateException {
        zznR();
        long j = 1 + this.zzacK;
        this.zzacK = j;
        JSONObject jSONObjectZza = zza(j, playerId, 7, extraMessageData);
        if (jSONObjectZza != null) {
            this.zzacC.sendMessage(this.zzacD, getNamespace(), jSONObjectZza.toString());
        }
    }

    public synchronized PendingResult<GameManagerClient.GameManagerResult> sendGameRequest(final String playerId, final JSONObject extraMessageData) throws IllegalStateException {
        zznR();
        return this.zzacD.zzb(new zza() { // from class: com.google.android.gms.internal.zzli.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.android.gms.internal.zzli.zzb
            public void execute() {
                zzli.this.zza(playerId, 6, extraMessageData, zznW());
            }
        });
    }

    public synchronized void setListener(GameManagerClient.Listener listener) {
        this.zzacL = listener;
    }

    public synchronized PendingResult<GameManagerClient.GameManagerInstanceResult> zza(GameManagerClient gameManagerClient) throws IllegalArgumentException {
        try {
            if (gameManagerClient == null) {
                throw new IllegalArgumentException("gameManagerClient can't be null.");
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.zzacD.zzb(new zzc(gameManagerClient) { // from class: com.google.android.gms.internal.zzli.1
            @Override // com.google.android.gms.internal.zzli.zzb
            public void execute() {
                try {
                    zzli.this.zzacC.setMessageReceivedCallbacks(zzli.this.zzacD, zzli.this.getNamespace(), new Cast.MessageReceivedCallback() { // from class: com.google.android.gms.internal.zzli.1.1
                        @Override // com.google.android.gms.cast.Cast.MessageReceivedCallback
                        public void onMessageReceived(CastDevice castDevice, String namespace, String message) {
                            zzli.this.zzcf(message);
                        }
                    });
                    zzli.this.zznU();
                    zzli.this.zznT();
                    zzli.this.zza((String) null, 1100, (JSONObject) null, zznW());
                } catch (IOException | IllegalStateException e) {
                    zznW().zza(-1L, 8, null);
                }
            }
        });
    }

    public synchronized PendingResult<GameManagerClient.GameManagerResult> zza(final String str, final int i, final JSONObject jSONObject) throws IllegalStateException {
        zznR();
        return this.zzacD.zzb(new zza() { // from class: com.google.android.gms.internal.zzli.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.android.gms.internal.zzli.zzb
            public void execute() {
                int iZzbh = zzll.zzbh(i);
                if (iZzbh != 0) {
                    zzli.this.zza(str, iZzbh, jSONObject, zznW());
                } else {
                    zznW().zza(-1L, 2001, null);
                    zzli.zzaaf.zzf("sendPlayerRequest for unsupported playerState: %d", Integer.valueOf(i));
                }
            }
        });
    }

    @Override // com.google.android.gms.cast.internal.zzd
    public void zzb(long j, int i) {
        zzb(j, i, null);
    }

    public synchronized String zzce(String str) throws IllegalStateException {
        return str == null ? null : this.zzacz.get(str);
    }

    @Override // com.google.android.gms.cast.internal.zzd
    public final void zzcf(String str) {
        zzaaf.zzb("message received: %s", str);
        try {
            zzlk zzlkVarZzi = zzlk.zzi(new JSONObject(str));
            if (zzlkVarZzi == null) {
                zzaaf.zzf("Could not parse game manager message from string: %s", str);
                return;
            }
            if ((isInitialized() || zzlkVarZzi.zzod() != null) && !isDisposed()) {
                boolean z = zzlkVarZzi.zznY() == 1;
                if (z && !TextUtils.isEmpty(zzlkVarZzi.zzoc())) {
                    this.zzacz.put(zzlkVarZzi.getPlayerId(), zzlkVarZzi.zzoc());
                    zznT();
                }
                if (zzlkVarZzi.getStatusCode() == 0) {
                    zza(zzlkVarZzi);
                } else {
                    zzaaf.zzf("Not updating from game message because the message contains error code: %d", Integer.valueOf(zzlkVarZzi.getStatusCode()));
                }
                int iZzbg = zzbg(zzlkVarZzi.getStatusCode());
                if (z) {
                    zzb(zzlkVarZzi.getRequestId(), iZzbg, zzlkVarZzi);
                }
                if (isInitialized() && iZzbg == 0) {
                    zznS();
                }
            }
        } catch (JSONException e) {
            zzaaf.zzf("Message is malformed (%s); ignoring: %s", e.getMessage(), str);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzc
    protected boolean zzz(long j) {
        boolean z;
        Iterator<com.google.android.gms.cast.internal.zzp> it = this.zzacA.iterator();
        while (it.hasNext()) {
            if (it.next().zzd(j, 15)) {
                it.remove();
            }
        }
        synchronized (com.google.android.gms.cast.internal.zzp.zzaeB) {
            Iterator<com.google.android.gms.cast.internal.zzp> it2 = this.zzacA.iterator();
            while (it2.hasNext()) {
                if (it2.next().zzoA()) {
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }
}
