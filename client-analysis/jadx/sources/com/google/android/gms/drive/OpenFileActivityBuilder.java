package com.google.android.gms.drive;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.drive.internal.zzu;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.FilterHolder;

/* JADX INFO: loaded from: classes.dex */
public class OpenFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private String zzapg;
    private String[] zzaph;
    private Filter zzapi;
    private DriveId zzapj;

    public IntentSender build(GoogleApiClient apiClient) {
        zzx.zza(apiClient.isConnected(), "Client must be connected");
        if (this.zzaph == null) {
            this.zzaph = new String[0];
        }
        if (this.zzaph.length > 0 && this.zzapi != null) {
            throw new IllegalStateException("Cannot use a selection filter and set mimetypes simultaneously");
        }
        try {
            return ((zzu) apiClient.zza(Drive.zzUI)).zzte().zza(new OpenFileIntentSenderRequest(this.zzapg, this.zzaph, this.zzapj, this.zzapi == null ? null : new FilterHolder(this.zzapi)));
        } catch (RemoteException e) {
            throw new RuntimeException("Unable to connect Drive Play Service", e);
        }
    }

    public OpenFileActivityBuilder setActivityStartFolder(DriveId folder) {
        this.zzapj = (DriveId) zzx.zzz(folder);
        return this;
    }

    public OpenFileActivityBuilder setActivityTitle(String title) {
        this.zzapg = (String) zzx.zzz(title);
        return this;
    }

    public OpenFileActivityBuilder setMimeType(String[] mimeTypes) {
        zzx.zzb(mimeTypes != null, "mimeTypes may not be null");
        this.zzaph = mimeTypes;
        return this;
    }

    public OpenFileActivityBuilder setSelectionFilter(Filter filter) {
        zzx.zzb(filter != null, "filter may not be null");
        zzx.zzb(com.google.android.gms.drive.query.internal.zzg.zza(filter) ? false : true, "FullTextSearchFilter cannot be used as a selection filter");
        this.zzapi = filter;
        return this;
    }
}
