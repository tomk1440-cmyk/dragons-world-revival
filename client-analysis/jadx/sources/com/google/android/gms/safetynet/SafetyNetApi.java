package com.google.android.gms.safetynet;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface SafetyNetApi {

    public interface AttestationResult extends Result {
        String getJwsResult();
    }

    public interface SafeBrowsingResult extends Result {
        String getMetadata();
    }

    PendingResult<AttestationResult> attest(GoogleApiClient googleApiClient, byte[] bArr);

    PendingResult<SafeBrowsingResult> lookupUri(GoogleApiClient googleApiClient, List<Integer> list, String str);
}
