package com.google.android.gms.plus;

import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public interface Account {
    @Deprecated
    void clearDefaultAccount(GoogleApiClient googleApiClient);

    @RequiresPermission("android.permission.GET_ACCOUNTS")
    String getAccountName(GoogleApiClient googleApiClient);

    PendingResult<Status> revokeAccessAndDisconnect(GoogleApiClient googleApiClient);
}
