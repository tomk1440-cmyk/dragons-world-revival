package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.CompletionListener;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;
import com.google.android.gms.drive.events.TransferProgressEvent;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class zzae extends zzao.zza {
    private final int zzanf;
    private final com.google.android.gms.drive.events.zzf zzarC;
    private final zza zzarD;
    private final List<Integer> zzarE = new ArrayList();

    private static class zza extends Handler {
        private final Context mContext;

        private zza(Looper looper, Context context) {
            super(looper);
            this.mContext = context;
        }

        private static void zza(com.google.android.gms.drive.events.zzm zzmVar, QueryResultEventParcelable queryResultEventParcelable) {
            DataHolder dataHolderZzsX = queryResultEventParcelable.zzsX();
            if (dataHolderZzsX != null) {
                final MetadataBuffer metadataBuffer = new MetadataBuffer(dataHolderZzsX);
                zzmVar.zza(new com.google.android.gms.drive.events.zzk() { // from class: com.google.android.gms.drive.internal.zzae.zza.1
                });
            }
            if (queryResultEventParcelable.zzsY()) {
                zzmVar.zzcJ(queryResultEventParcelable.zzsZ());
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Pair pair = (Pair) msg.obj;
                    com.google.android.gms.drive.events.zzf zzfVar = (com.google.android.gms.drive.events.zzf) pair.first;
                    DriveEvent driveEvent = (DriveEvent) pair.second;
                    switch (driveEvent.getType()) {
                        case 1:
                            ((ChangeListener) zzfVar).onChange((ChangeEvent) driveEvent);
                            break;
                        case 2:
                            ((CompletionListener) zzfVar).onCompletion((CompletionEvent) driveEvent);
                            break;
                        case 3:
                            zza((com.google.android.gms.drive.events.zzm) zzfVar, (QueryResultEventParcelable) driveEvent);
                            break;
                        case 4:
                            ((com.google.android.gms.drive.events.zzc) zzfVar).zza((ChangesAvailableEvent) driveEvent);
                            break;
                        case 5:
                        case 6:
                        case 7:
                        default:
                            zzz.zzz("EventCallback", "Unexpected event: " + driveEvent);
                            break;
                        case 8:
                            ((com.google.android.gms.drive.events.zzi) zzfVar).zza(new com.google.android.gms.drive.events.internal.zza(((TransferProgressEvent) driveEvent).zzta()));
                            break;
                    }
                    break;
                default:
                    zzz.zze(this.mContext, "EventCallback", "Don't know how to handle this event");
                    break;
            }
        }

        public void zza(com.google.android.gms.drive.events.zzf zzfVar, DriveEvent driveEvent) {
            sendMessage(obtainMessage(1, new Pair(zzfVar, driveEvent)));
        }
    }

    public zzae(Looper looper, Context context, int i, com.google.android.gms.drive.events.zzf zzfVar) {
        this.zzanf = i;
        this.zzarC = zzfVar;
        this.zzarD = new zza(looper, context);
    }

    @Override // com.google.android.gms.drive.internal.zzao
    public void zzc(OnEventResponse onEventResponse) throws RemoteException {
        DriveEvent driveEventZzts = onEventResponse.zzts();
        com.google.android.gms.common.internal.zzx.zzab(this.zzanf == driveEventZzts.getType());
        com.google.android.gms.common.internal.zzx.zzab(this.zzarE.contains(Integer.valueOf(driveEventZzts.getType())));
        this.zzarD.zza(this.zzarC, driveEventZzts);
    }

    public void zzdg(int i) {
        this.zzarE.add(Integer.valueOf(i));
    }

    public boolean zzdh(int i) {
        return this.zzarE.contains(Integer.valueOf(i));
    }
}
