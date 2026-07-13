package com.crashlytics.android.core;

/* JADX INFO: loaded from: classes.dex */
class CreateReportRequest {
    public final String apiKey;
    public final Report report;

    public CreateReportRequest(String apiKey, Report report) {
        this.apiKey = apiKey;
        this.report = report;
    }
}
