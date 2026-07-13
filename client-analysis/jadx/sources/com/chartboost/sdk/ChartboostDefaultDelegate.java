package com.chartboost.sdk;

/* JADX INFO: loaded from: classes.dex */
public abstract class ChartboostDefaultDelegate implements ChartboostDelegate {
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
