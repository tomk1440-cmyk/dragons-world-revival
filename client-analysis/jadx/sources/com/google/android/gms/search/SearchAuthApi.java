package com.google.android.gms.search;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public interface SearchAuthApi {

    public interface GoogleNowAuthResult extends Result {
        GoogleNowAuthState getGoogleNowAuthState();
    }

    PendingResult<Status> clearToken(GoogleApiClient googleApiClient, String str);

    PendingResult<GoogleNowAuthResult> getGoogleNowAuth(GoogleApiClient googleApiClient, String str);
}
