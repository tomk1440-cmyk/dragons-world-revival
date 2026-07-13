package com.facebook.appevents;

/* JADX INFO: loaded from: classes.dex */
enum FlushReason {
    EXPLICIT,
    TIMER,
    SESSION_CHANGE,
    PERSISTED_EVENTS,
    EVENT_THRESHOLD,
    EAGER_FLUSHING_EVENT
}
