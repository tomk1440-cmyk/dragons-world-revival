package com.google.android.gms.fitness;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;

/* JADX INFO: loaded from: classes.dex */
public interface SessionsApi {

    public static class ViewIntentBuilder {
        private final Context mContext;
        private String zzavW;
        private Session zzavX;
        private boolean zzavY = false;

        public ViewIntentBuilder(Context context) {
            this.mContext = context;
        }

        private Intent zzl(Intent intent) {
            Intent intent2;
            ResolveInfo resolveInfoResolveActivity;
            if (this.zzavW == null || (resolveInfoResolveActivity = this.mContext.getPackageManager().resolveActivity((intent2 = new Intent(intent).setPackage(this.zzavW)), 0)) == null) {
                return intent;
            }
            intent2.setComponent(new ComponentName(this.zzavW, resolveInfoResolveActivity.activityInfo.name));
            return intent2;
        }

        public Intent build() {
            zzx.zza(this.zzavX != null, "Session must be set");
            Intent intent = new Intent(Fitness.ACTION_VIEW);
            intent.setType(Session.getMimeType(this.zzavX.getActivity()));
            zzc.zza(this.zzavX, intent, Session.EXTRA_SESSION);
            if (!this.zzavY) {
                this.zzavW = this.zzavX.getAppPackageName();
            }
            return zzl(intent);
        }

        public ViewIntentBuilder setPreferredApplication(String packageName) {
            this.zzavW = packageName;
            this.zzavY = true;
            return this;
        }

        public ViewIntentBuilder setSession(Session session) {
            this.zzavX = session;
            return this;
        }
    }

    PendingResult<Status> insertSession(GoogleApiClient googleApiClient, SessionInsertRequest sessionInsertRequest);

    @RequiresPermission(anyOf = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.BODY_SENSORS"}, conditional = true)
    PendingResult<SessionReadResult> readSession(GoogleApiClient googleApiClient, SessionReadRequest sessionReadRequest);

    PendingResult<Status> registerForSessions(GoogleApiClient googleApiClient, PendingIntent pendingIntent);

    PendingResult<Status> startSession(GoogleApiClient googleApiClient, Session session);

    PendingResult<SessionStopResult> stopSession(GoogleApiClient googleApiClient, String str);

    PendingResult<Status> unregisterForSessions(GoogleApiClient googleApiClient, PendingIntent pendingIntent);
}
