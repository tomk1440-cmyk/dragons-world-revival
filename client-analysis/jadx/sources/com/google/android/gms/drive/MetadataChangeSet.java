package com.google.android.gms.drive;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.zznm;
import com.google.android.gms.internal.zzno;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class MetadataChangeSet {
    public static final int CUSTOM_PROPERTY_SIZE_LIMIT_BYTES = 124;
    public static final int INDEXABLE_TEXT_SIZE_LIMIT_BYTES = 131072;
    public static final int MAX_PRIVATE_PROPERTIES_PER_RESOURCE_PER_APP = 30;
    public static final int MAX_PUBLIC_PROPERTIES_PER_RESOURCE = 30;
    public static final int MAX_TOTAL_PROPERTIES_PER_RESOURCE = 100;
    public static final MetadataChangeSet zzapd = new MetadataChangeSet(MetadataBundle.zztE());
    private final MetadataBundle zzape;

    public static class Builder {
        private final MetadataBundle zzape = MetadataBundle.zztE();
        private AppVisibleCustomProperties.zza zzapf;

        private int zzda(String str) {
            if (str == null) {
                return 0;
            }
            return str.getBytes().length;
        }

        private String zzj(String str, int i, int i2) {
            return String.format("%s must be no more than %d bytes, but is %d bytes.", str, Integer.valueOf(i), Integer.valueOf(i2));
        }

        private void zzk(String str, int i, int i2) {
            zzx.zzb(i2 <= i, zzj(str, i, i2));
        }

        private AppVisibleCustomProperties.zza zzsN() {
            if (this.zzapf == null) {
                this.zzapf = new AppVisibleCustomProperties.zza();
            }
            return this.zzapf;
        }

        public MetadataChangeSet build() {
            if (this.zzapf != null) {
                this.zzape.zzc(zznm.zzasW, this.zzapf.zztA());
            }
            return new MetadataChangeSet(this.zzape);
        }

        public Builder deleteCustomProperty(CustomPropertyKey key) {
            zzx.zzb(key, "key");
            zzsN().zza(key, null);
            return this;
        }

        public Builder setCustomProperty(CustomPropertyKey key, String value) {
            zzx.zzb(key, "key");
            zzx.zzb(value, "value");
            zzk("The total size of key string and value string of a custom property", MetadataChangeSet.CUSTOM_PROPERTY_SIZE_LIMIT_BYTES, zzda(key.getKey()) + zzda(value));
            zzsN().zza(key, value);
            return this;
        }

        public Builder setDescription(String description) {
            this.zzape.zzc(zznm.zzasX, description);
            return this;
        }

        public Builder setIndexableText(String text) {
            zzk("Indexable text size", 131072, zzda(text));
            this.zzape.zzc(zznm.zzatd, text);
            return this;
        }

        public Builder setLastViewedByMeDate(Date date) {
            this.zzape.zzc(zzno.zzatN, date);
            return this;
        }

        public Builder setMimeType(String mimeType) {
            this.zzape.zzc(zznm.zzatr, mimeType);
            return this;
        }

        public Builder setPinned(boolean pinned) {
            this.zzape.zzc(zznm.zzatj, Boolean.valueOf(pinned));
            return this;
        }

        public Builder setStarred(boolean starred) {
            this.zzape.zzc(zznm.zzaty, Boolean.valueOf(starred));
            return this;
        }

        public Builder setTitle(String title) {
            this.zzape.zzc(zznm.zzatA, title);
            return this;
        }

        public Builder setViewed(boolean viewed) {
            this.zzape.zzc(zznm.zzatq, Boolean.valueOf(viewed));
            return this;
        }
    }

    public MetadataChangeSet(MetadataBundle bag) {
        this.zzape = bag.zztF();
    }

    public Map<CustomPropertyKey, String> getCustomPropertyChangeMap() {
        AppVisibleCustomProperties appVisibleCustomProperties = (AppVisibleCustomProperties) this.zzape.zza(zznm.zzasW);
        return appVisibleCustomProperties == null ? Collections.emptyMap() : appVisibleCustomProperties.zztz();
    }

    public String getDescription() {
        return (String) this.zzape.zza(zznm.zzasX);
    }

    public String getIndexableText() {
        return (String) this.zzape.zza(zznm.zzatd);
    }

    public Date getLastViewedByMeDate() {
        return (Date) this.zzape.zza(zzno.zzatN);
    }

    public String getMimeType() {
        return (String) this.zzape.zza(zznm.zzatr);
    }

    public String getTitle() {
        return (String) this.zzape.zza(zznm.zzatA);
    }

    public Boolean isPinned() {
        return (Boolean) this.zzape.zza(zznm.zzatj);
    }

    public Boolean isStarred() {
        return (Boolean) this.zzape.zza(zznm.zzaty);
    }

    public Boolean isViewed() {
        return (Boolean) this.zzape.zza(zznm.zzatq);
    }

    public <T> MetadataChangeSet zza(MetadataField<T> metadataField, T t) {
        MetadataChangeSet metadataChangeSetZzsM = zzsM();
        metadataChangeSetZzsM.zzsL().zzc(metadataField, t);
        return metadataChangeSetZzsM;
    }

    public MetadataBundle zzsL() {
        return this.zzape;
    }

    public MetadataChangeSet zzsM() {
        return new MetadataChangeSet(zzsL());
    }
}
