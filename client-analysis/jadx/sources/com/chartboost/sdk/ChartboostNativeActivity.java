package com.chartboost.sdk;

import android.app.NativeActivity;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public abstract class ChartboostNativeActivity extends NativeActivity implements ChartboostDelegate {
    private Chartboost a;

    protected abstract String getChartboostAppID();

    protected abstract String getChartboostAppSignature();

    @Override // android.app.NativeActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.a = Chartboost.sharedChartboost();
        this.a.setImpressionsUseActivities(true);
        this.a.onCreate(this, getChartboostAppID(), getChartboostAppSignature(), this);
    }

    @Override // android.app.NativeActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        this.a.onStart(this);
        this.a.startSession();
    }

    @Override // android.app.NativeActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        this.a.onStop(this);
    }

    @Override // android.app.NativeActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.a.onDestroy(this);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (!this.a.onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override // com.chartboost.sdk.ChartboostDelegate
    public boolean shouldRequestInterstitial(String location) {
        return true;
    }

    @Override // com.chartboost.sdk.ChartboostDelegate
    public boolean shouldDisplayInterstitial(String location) {
        return true;
    }

    @Override // com.chartboost.sdk.ChartboostDelegate
    public void didCacheInterstitial(String location) {
    }

    @Override // com.chartboost.sdk.ChartboostDelegate
    public void didFailToLoadInterstitial(String location) {
    }

    @Override // com.chartboost.sdk.ChartboostDelegate
    public void didDismissInterstitial(String location) {
    }

    @Override // com.chartboost.sdk.ChartboostDelegate
    public void didCloseInterstitial(String location) {
    }

    @Override // com.chartboost.sdk.ChartboostDelegate
    public void didClickInterstitial(String location) {
    }

    @Override // com.chartboost.sdk.ChartboostDelegate
    public void didShowInterstitial(String location) {
    }

    @Override // com.chartboost.sdk.ChartboostDelegate
    public boolean shouldDisplayLoadingViewForMoreApps() {
        return true;
    }

    @Override // com.chartboost.sdk.ChartboostDelegate
    public boolean shouldRequestMoreApps() {
        return true;
    }

    @Override // com.chartboost.sdk.ChartboostDelegate
    public void didCacheMoreApps() {
    }

    @Override // com.chartboost.sdk.ChartboostDelegate
    public boolean shouldDisplayMoreApps() {
        return true;
    }

    @Override // com.chartboost.sdk.ChartboostDelegate
    public void didFailToLoadMoreApps() {
    }

    @Override // com.chartboost.sdk.ChartboostDelegate
    public void didDismissMoreApps() {
    }

    @Override // com.chartboost.sdk.ChartboostDelegate
    public void didCloseMoreApps() {
    }

    @Override // com.chartboost.sdk.ChartboostDelegate
    public void didClickMoreApps() {
    }

    @Override // com.chartboost.sdk.ChartboostDelegate
    public void didShowMoreApps() {
    }

    @Override // com.chartboost.sdk.ChartboostDelegate
    public boolean shouldRequestInterstitialsInFirstSession() {
        return true;
    }

    @Override // com.chartboost.sdk.ChartboostDelegate
    public void didFailToLoadUrl(String url) {
    }
}
