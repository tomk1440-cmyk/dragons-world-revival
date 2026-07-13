package com.google.ads.mediation;

import com.google.ads.mediation.MediationServerParameters;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface MediationAdapter<ADDITIONAL_PARAMETERS, SERVER_PARAMETERS extends MediationServerParameters> {
    void destroy();

    Class<ADDITIONAL_PARAMETERS> getAdditionalParametersType();

    Class<SERVER_PARAMETERS> getServerParametersType();
}
