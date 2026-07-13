package com.unity3d.ads.request;

/* JADX INFO: loaded from: classes.dex */
public interface IResolveHostListener {
    void onFailed(String str, ResolveHostError resolveHostError, String str2);

    void onResolve(String str, String str2);
}
