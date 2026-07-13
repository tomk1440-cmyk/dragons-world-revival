package com.crashlytics.android.answers;

/* JADX INFO: loaded from: classes.dex */
public class RatingEvent extends PredefinedEvent<RatingEvent> {
    static final String CONTENT_ID_ATTRIBUTE = "contentId";
    static final String CONTENT_NAME_ATTRIBUTE = "contentName";
    static final String CONTENT_TYPE_ATTRIBUTE = "contentType";
    static final String RATING_ATTRIBUTE = "rating";
    static final String TYPE = "rating";

    public RatingEvent putContentId(String contentId) {
        this.predefinedAttributes.put(CONTENT_ID_ATTRIBUTE, contentId);
        return this;
    }

    public RatingEvent putContentName(String contentName) {
        this.predefinedAttributes.put(CONTENT_NAME_ATTRIBUTE, contentName);
        return this;
    }

    public RatingEvent putContentType(String contentType) {
        this.predefinedAttributes.put(CONTENT_TYPE_ATTRIBUTE, contentType);
        return this;
    }

    public RatingEvent putRating(int rating) {
        this.predefinedAttributes.put("rating", Integer.valueOf(rating));
        return this;
    }

    @Override // com.crashlytics.android.answers.PredefinedEvent
    String getPredefinedType() {
        return "rating";
    }
}
