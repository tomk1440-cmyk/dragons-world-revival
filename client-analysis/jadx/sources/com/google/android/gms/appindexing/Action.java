package com.google.android.gms.appindexing;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.FitnessActivities;

/* JADX INFO: loaded from: classes.dex */
public final class Action extends Thing {
    public static final String STATUS_TYPE_ACTIVE = "http://schema.org/ActiveActionStatus";
    public static final String STATUS_TYPE_COMPLETED = "http://schema.org/CompletedActionStatus";
    public static final String STATUS_TYPE_FAILED = "http://schema.org/FailedActionStatus";
    public static final String TYPE_ACTIVATE = "http://schema.org/ActivateAction";
    public static final String TYPE_ADD = "http://schema.org/AddAction";
    public static final String TYPE_BOOKMARK = "http://schema.org/BookmarkAction";
    public static final String TYPE_COMMUNICATE = "http://schema.org/CommunicateAction";
    public static final String TYPE_FILM = "http://schema.org/FilmAction";
    public static final String TYPE_LIKE = "http://schema.org/LikeAction";
    public static final String TYPE_LISTEN = "http://schema.org/ListenAction";
    public static final String TYPE_PHOTOGRAPH = "http://schema.org/PhotographAction";
    public static final String TYPE_RESERVE = "http://schema.org/ReserveAction";
    public static final String TYPE_SEARCH = "http://schema.org/SearchAction";
    public static final String TYPE_VIEW = "http://schema.org/ViewAction";
    public static final String TYPE_WANT = "http://schema.org/WantAction";
    public static final String TYPE_WATCH = "http://schema.org/WatchAction";

    public static final class Builder extends Thing.Builder {
        public Builder(String actionType) {
            zzx.zzz(actionType);
            super.put(ShareConstants.MEDIA_TYPE, actionType);
        }

        @Override // com.google.android.gms.appindexing.Thing.Builder
        public Action build() {
            zzx.zzb(this.zzUH.get("object"), "setObject is required before calling build().");
            zzx.zzb(this.zzUH.get(ShareConstants.MEDIA_TYPE), "setType is required before calling build().");
            Bundle bundle = (Bundle) this.zzUH.getParcelable("object");
            zzx.zzb(bundle.get("name"), "Must call setObject() with a valid name. Example: setObject(new Thing.Builder().setName(name).setUrl(url))");
            zzx.zzb(bundle.get("url"), "Must call setObject() with a valid app URI. Example: setObject(new Thing.Builder().setName(name).setUrl(url))");
            return new Action(this.zzUH);
        }

        @Override // com.google.android.gms.appindexing.Thing.Builder
        public Builder put(String key, Thing value) {
            return (Builder) super.put(key, value);
        }

        @Override // com.google.android.gms.appindexing.Thing.Builder
        public Builder put(String key, String value) {
            return (Builder) super.put(key, value);
        }

        @Override // com.google.android.gms.appindexing.Thing.Builder
        public Builder put(String key, boolean value) {
            return (Builder) super.put(key, value);
        }

        @Override // com.google.android.gms.appindexing.Thing.Builder
        public Builder put(String key, Thing[] values) {
            return (Builder) super.put(key, values);
        }

        @Override // com.google.android.gms.appindexing.Thing.Builder
        public Builder put(String key, String[] values) {
            return (Builder) super.put(key, values);
        }

        public Builder setActionStatus(String actionStatusType) {
            zzx.zzz(actionStatusType);
            return (Builder) super.put(FitnessActivities.EXTRA_STATUS, actionStatusType);
        }

        @Override // com.google.android.gms.appindexing.Thing.Builder
        public Builder setName(String name) {
            return (Builder) super.put("name", name);
        }

        public Builder setObject(Thing thing) {
            zzx.zzz(thing);
            return (Builder) super.put("object", thing);
        }

        @Override // com.google.android.gms.appindexing.Thing.Builder
        public Builder setUrl(Uri url) {
            if (url != null) {
                super.put("url", url.toString());
            }
            return this;
        }
    }

    private Action(Bundle propertyBundle) {
        super(propertyBundle);
    }

    public static Action newAction(String actionType, String objectName, Uri objectAppUri) {
        return newAction(actionType, objectName, null, objectAppUri);
    }

    public static Action newAction(String actionType, String objectName, Uri objectId, Uri objectAppUri) {
        return new Builder(actionType).setObject(new Thing.Builder().setName(objectName).setId(objectId == null ? null : objectId.toString()).setUrl(objectAppUri).build()).build();
    }
}
