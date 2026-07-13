package com.crashlytics.android.answers;

/* JADX INFO: loaded from: classes.dex */
public class SignUpEvent extends PredefinedEvent<SignUpEvent> {
    static final String METHOD_ATTRIBUTE = "method";
    static final String SUCCESS_ATTRIBUTE = "success";
    static final String TYPE = "signUp";

    public SignUpEvent putMethod(String signUpMethod) {
        this.predefinedAttributes.put(METHOD_ATTRIBUTE, signUpMethod);
        return this;
    }

    public SignUpEvent putSuccess(boolean signUpSucceeded) {
        this.predefinedAttributes.put("success", Boolean.toString(signUpSucceeded));
        return this;
    }

    @Override // com.crashlytics.android.answers.PredefinedEvent
    String getPredefinedType() {
        return TYPE;
    }
}
