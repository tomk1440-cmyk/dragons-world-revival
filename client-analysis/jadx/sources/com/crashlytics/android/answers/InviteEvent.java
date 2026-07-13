package com.crashlytics.android.answers;

/* JADX INFO: loaded from: classes.dex */
public class InviteEvent extends PredefinedEvent<InviteEvent> {
    static final String METHOD_ATTRIBUTE = "method";
    static final String TYPE = "invite";

    public InviteEvent putMethod(String inviteMethod) {
        this.predefinedAttributes.put(METHOD_ATTRIBUTE, inviteMethod);
        return this;
    }

    @Override // com.crashlytics.android.answers.PredefinedEvent
    String getPredefinedType() {
        return TYPE;
    }
}
