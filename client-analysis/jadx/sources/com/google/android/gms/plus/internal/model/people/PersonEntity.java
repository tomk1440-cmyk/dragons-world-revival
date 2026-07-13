package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.people.Person;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class PersonEntity extends FastSafeParcelableJsonResponse implements Person {
    public static final com.google.android.gms.plus.internal.model.people.zza CREATOR = new com.google.android.gms.plus.internal.model.people.zza();
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap<>();
    final int mVersionCode;
    String zzF;
    String zzWQ;
    String zzaaL;
    final Set<Integer> zzbeN;
    String zzbfL;
    AgeRangeEntity zzbfM;
    String zzbfN;
    String zzbfO;
    int zzbfP;
    CoverEntity zzbfQ;
    String zzbfR;
    ImageEntity zzbfS;
    boolean zzbfT;
    NameEntity zzbfU;
    String zzbfV;
    int zzbfW;
    List<OrganizationsEntity> zzbfX;
    List<PlacesLivedEntity> zzbfY;
    int zzbfZ;
    int zzbga;
    String zzbgb;
    List<UrlsEntity> zzbgc;
    boolean zzbgd;
    int zztT;
    String zzyv;

    public static final class AgeRangeEntity extends FastSafeParcelableJsonResponse implements Person.AgeRange {
        public static final zzb CREATOR = new zzb();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap<>();
        final int mVersionCode;
        final Set<Integer> zzbeN;
        int zzbge;
        int zzbgf;

        static {
            zzbeM.put("max", FastJsonResponse.Field.zzi("max", 2));
            zzbeM.put("min", FastJsonResponse.Field.zzi("min", 3));
        }

        public AgeRangeEntity() {
            this.mVersionCode = 1;
            this.zzbeN = new HashSet();
        }

        AgeRangeEntity(Set<Integer> indicatorSet, int versionCode, int max, int min) {
            this.zzbeN = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbge = max;
            this.zzbgf = min;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzb zzbVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof AgeRangeEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            AgeRangeEntity ageRangeEntity = (AgeRangeEntity) obj;
            for (FastJsonResponse.Field<?, ?> field : zzbeM.values()) {
                if (zza(field)) {
                    if (ageRangeEntity.zza(field) && zzb(field).equals(ageRangeEntity.zzb(field))) {
                    }
                    return false;
                }
                if (ageRangeEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.plus.model.people.Person.AgeRange
        public int getMax() {
            return this.zzbge;
        }

        @Override // com.google.android.gms.plus.model.people.Person.AgeRange
        public int getMin() {
            return this.zzbgf;
        }

        @Override // com.google.android.gms.plus.model.people.Person.AgeRange
        public boolean hasMax() {
            return this.zzbeN.contains(2);
        }

        @Override // com.google.android.gms.plus.model.people.Person.AgeRange
        public boolean hasMin() {
            return this.zzbeN.contains(3);
        }

        public int hashCode() {
            int iHashCode = 0;
            Iterator<FastJsonResponse.Field<?, ?>> it = zzbeM.values().iterator();
            while (true) {
                int i = iHashCode;
                if (!it.hasNext()) {
                    return i;
                }
                FastJsonResponse.Field<?, ?> next = it.next();
                if (zza(next)) {
                    iHashCode = zzb(next).hashCode() + i + next.zzrs();
                } else {
                    iHashCode = i;
                }
            }
        }

        @Override // com.google.android.gms.common.data.Freezable
        public boolean isDataValid() {
            return true;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            zzb zzbVar = CREATOR;
            zzb.zza(this, out, flags);
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        /* JADX INFO: renamed from: zzFl, reason: merged with bridge method [inline-methods] */
        public HashMap<String, FastJsonResponse.Field<?, ?>> zzrl() {
            return zzbeM;
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* JADX INFO: renamed from: zzFq, reason: merged with bridge method [inline-methods] */
        public AgeRangeEntity freeze() {
            return this;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected boolean zza(FastJsonResponse.Field field) {
            return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected Object zzb(FastJsonResponse.Field field) {
            switch (field.zzrs()) {
                case 2:
                    return Integer.valueOf(this.zzbge);
                case 3:
                    return Integer.valueOf(this.zzbgf);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
            }
        }
    }

    public static final class CoverEntity extends FastSafeParcelableJsonResponse implements Person.Cover {
        public static final zzc CREATOR = new zzc();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap<>();
        final int mVersionCode;
        final Set<Integer> zzbeN;
        CoverInfoEntity zzbgg;
        CoverPhotoEntity zzbgh;
        int zzbgi;

        public static final class CoverInfoEntity extends FastSafeParcelableJsonResponse implements Person.Cover.CoverInfo {
            public static final zzd CREATOR = new zzd();
            private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap<>();
            final int mVersionCode;
            final Set<Integer> zzbeN;
            int zzbgj;
            int zzbgk;

            static {
                zzbeM.put("leftImageOffset", FastJsonResponse.Field.zzi("leftImageOffset", 2));
                zzbeM.put("topImageOffset", FastJsonResponse.Field.zzi("topImageOffset", 3));
            }

            public CoverInfoEntity() {
                this.mVersionCode = 1;
                this.zzbeN = new HashSet();
            }

            CoverInfoEntity(Set<Integer> indicatorSet, int versionCode, int leftImageOffset, int topImageOffset) {
                this.zzbeN = indicatorSet;
                this.mVersionCode = versionCode;
                this.zzbgj = leftImageOffset;
                this.zzbgk = topImageOffset;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                zzd zzdVar = CREATOR;
                return 0;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof CoverInfoEntity)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                CoverInfoEntity coverInfoEntity = (CoverInfoEntity) obj;
                for (FastJsonResponse.Field<?, ?> field : zzbeM.values()) {
                    if (zza(field)) {
                        if (coverInfoEntity.zza(field) && zzb(field).equals(coverInfoEntity.zzb(field))) {
                        }
                        return false;
                    }
                    if (coverInfoEntity.zza(field)) {
                        return false;
                    }
                }
                return true;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverInfo
            public int getLeftImageOffset() {
                return this.zzbgj;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverInfo
            public int getTopImageOffset() {
                return this.zzbgk;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverInfo
            public boolean hasLeftImageOffset() {
                return this.zzbeN.contains(2);
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverInfo
            public boolean hasTopImageOffset() {
                return this.zzbeN.contains(3);
            }

            public int hashCode() {
                int iHashCode = 0;
                Iterator<FastJsonResponse.Field<?, ?>> it = zzbeM.values().iterator();
                while (true) {
                    int i = iHashCode;
                    if (!it.hasNext()) {
                        return i;
                    }
                    FastJsonResponse.Field<?, ?> next = it.next();
                    if (zza(next)) {
                        iHashCode = zzb(next).hashCode() + i + next.zzrs();
                    } else {
                        iHashCode = i;
                    }
                }
            }

            @Override // com.google.android.gms.common.data.Freezable
            public boolean isDataValid() {
                return true;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel out, int flags) {
                zzd zzdVar = CREATOR;
                zzd.zza(this, out, flags);
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            /* JADX INFO: renamed from: zzFl, reason: merged with bridge method [inline-methods] */
            public HashMap<String, FastJsonResponse.Field<?, ?>> zzrl() {
                return zzbeM;
            }

            @Override // com.google.android.gms.common.data.Freezable
            /* JADX INFO: renamed from: zzFs, reason: merged with bridge method [inline-methods] */
            public CoverInfoEntity freeze() {
                return this;
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            protected boolean zza(FastJsonResponse.Field field) {
                return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            protected Object zzb(FastJsonResponse.Field field) {
                switch (field.zzrs()) {
                    case 2:
                        return Integer.valueOf(this.zzbgj);
                    case 3:
                        return Integer.valueOf(this.zzbgk);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
                }
            }
        }

        public static final class CoverPhotoEntity extends FastSafeParcelableJsonResponse implements Person.Cover.CoverPhoto {
            public static final zze CREATOR = new zze();
            private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap<>();
            final int mVersionCode;
            String zzF;
            final Set<Integer> zzbeN;
            int zzoG;
            int zzoH;

            static {
                zzbeM.put(SettingsJsonConstants.ICON_HEIGHT_KEY, FastJsonResponse.Field.zzi(SettingsJsonConstants.ICON_HEIGHT_KEY, 2));
                zzbeM.put("url", FastJsonResponse.Field.zzl("url", 3));
                zzbeM.put(SettingsJsonConstants.ICON_WIDTH_KEY, FastJsonResponse.Field.zzi(SettingsJsonConstants.ICON_WIDTH_KEY, 4));
            }

            public CoverPhotoEntity() {
                this.mVersionCode = 1;
                this.zzbeN = new HashSet();
            }

            CoverPhotoEntity(Set<Integer> indicatorSet, int versionCode, int height, String url, int width) {
                this.zzbeN = indicatorSet;
                this.mVersionCode = versionCode;
                this.zzoH = height;
                this.zzF = url;
                this.zzoG = width;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                zze zzeVar = CREATOR;
                return 0;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof CoverPhotoEntity)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                CoverPhotoEntity coverPhotoEntity = (CoverPhotoEntity) obj;
                for (FastJsonResponse.Field<?, ?> field : zzbeM.values()) {
                    if (zza(field)) {
                        if (coverPhotoEntity.zza(field) && zzb(field).equals(coverPhotoEntity.zzb(field))) {
                        }
                        return false;
                    }
                    if (coverPhotoEntity.zza(field)) {
                        return false;
                    }
                }
                return true;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto
            public int getHeight() {
                return this.zzoH;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto
            public String getUrl() {
                return this.zzF;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto
            public int getWidth() {
                return this.zzoG;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto
            public boolean hasHeight() {
                return this.zzbeN.contains(2);
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto
            public boolean hasUrl() {
                return this.zzbeN.contains(3);
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto
            public boolean hasWidth() {
                return this.zzbeN.contains(4);
            }

            public int hashCode() {
                int iHashCode = 0;
                Iterator<FastJsonResponse.Field<?, ?>> it = zzbeM.values().iterator();
                while (true) {
                    int i = iHashCode;
                    if (!it.hasNext()) {
                        return i;
                    }
                    FastJsonResponse.Field<?, ?> next = it.next();
                    if (zza(next)) {
                        iHashCode = zzb(next).hashCode() + i + next.zzrs();
                    } else {
                        iHashCode = i;
                    }
                }
            }

            @Override // com.google.android.gms.common.data.Freezable
            public boolean isDataValid() {
                return true;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel out, int flags) {
                zze zzeVar = CREATOR;
                zze.zza(this, out, flags);
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            /* JADX INFO: renamed from: zzFl, reason: merged with bridge method [inline-methods] */
            public HashMap<String, FastJsonResponse.Field<?, ?>> zzrl() {
                return zzbeM;
            }

            @Override // com.google.android.gms.common.data.Freezable
            /* JADX INFO: renamed from: zzFt, reason: merged with bridge method [inline-methods] */
            public CoverPhotoEntity freeze() {
                return this;
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            protected boolean zza(FastJsonResponse.Field field) {
                return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            protected Object zzb(FastJsonResponse.Field field) {
                switch (field.zzrs()) {
                    case 2:
                        return Integer.valueOf(this.zzoH);
                    case 3:
                        return this.zzF;
                    case 4:
                        return Integer.valueOf(this.zzoG);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
                }
            }
        }

        static {
            zzbeM.put("coverInfo", FastJsonResponse.Field.zza("coverInfo", 2, CoverInfoEntity.class));
            zzbeM.put("coverPhoto", FastJsonResponse.Field.zza("coverPhoto", 3, CoverPhotoEntity.class));
            zzbeM.put("layout", FastJsonResponse.Field.zza("layout", 4, new StringToIntConverter().zzh("banner", 0), false));
        }

        public CoverEntity() {
            this.mVersionCode = 1;
            this.zzbeN = new HashSet();
        }

        CoverEntity(Set<Integer> indicatorSet, int versionCode, CoverInfoEntity coverInfo, CoverPhotoEntity coverPhoto, int layout) {
            this.zzbeN = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbgg = coverInfo;
            this.zzbgh = coverPhoto;
            this.zzbgi = layout;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzc zzcVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof CoverEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            CoverEntity coverEntity = (CoverEntity) obj;
            for (FastJsonResponse.Field<?, ?> field : zzbeM.values()) {
                if (zza(field)) {
                    if (coverEntity.zza(field) && zzb(field).equals(coverEntity.zzb(field))) {
                    }
                    return false;
                }
                if (coverEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Cover
        public Person.Cover.CoverInfo getCoverInfo() {
            return this.zzbgg;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Cover
        public Person.Cover.CoverPhoto getCoverPhoto() {
            return this.zzbgh;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Cover
        public int getLayout() {
            return this.zzbgi;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Cover
        public boolean hasCoverInfo() {
            return this.zzbeN.contains(2);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Cover
        public boolean hasCoverPhoto() {
            return this.zzbeN.contains(3);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Cover
        public boolean hasLayout() {
            return this.zzbeN.contains(4);
        }

        public int hashCode() {
            int iHashCode = 0;
            Iterator<FastJsonResponse.Field<?, ?>> it = zzbeM.values().iterator();
            while (true) {
                int i = iHashCode;
                if (!it.hasNext()) {
                    return i;
                }
                FastJsonResponse.Field<?, ?> next = it.next();
                if (zza(next)) {
                    iHashCode = zzb(next).hashCode() + i + next.zzrs();
                } else {
                    iHashCode = i;
                }
            }
        }

        @Override // com.google.android.gms.common.data.Freezable
        public boolean isDataValid() {
            return true;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            zzc zzcVar = CREATOR;
            zzc.zza(this, out, flags);
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        /* JADX INFO: renamed from: zzFl, reason: merged with bridge method [inline-methods] */
        public HashMap<String, FastJsonResponse.Field<?, ?>> zzrl() {
            return zzbeM;
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* JADX INFO: renamed from: zzFr, reason: merged with bridge method [inline-methods] */
        public CoverEntity freeze() {
            return this;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected boolean zza(FastJsonResponse.Field field) {
            return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected Object zzb(FastJsonResponse.Field field) {
            switch (field.zzrs()) {
                case 2:
                    return this.zzbgg;
                case 3:
                    return this.zzbgh;
                case 4:
                    return Integer.valueOf(this.zzbgi);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
            }
        }
    }

    public static final class ImageEntity extends FastSafeParcelableJsonResponse implements Person.Image {
        public static final zzf CREATOR = new zzf();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap<>();
        final int mVersionCode;
        String zzF;
        final Set<Integer> zzbeN;

        static {
            zzbeM.put("url", FastJsonResponse.Field.zzl("url", 2));
        }

        public ImageEntity() {
            this.mVersionCode = 1;
            this.zzbeN = new HashSet();
        }

        public ImageEntity(String url) {
            this.zzbeN = new HashSet();
            this.mVersionCode = 1;
            this.zzF = url;
            this.zzbeN.add(2);
        }

        ImageEntity(Set<Integer> indicatorSet, int versionCode, String url) {
            this.zzbeN = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzF = url;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzf zzfVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ImageEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ImageEntity imageEntity = (ImageEntity) obj;
            for (FastJsonResponse.Field<?, ?> field : zzbeM.values()) {
                if (zza(field)) {
                    if (imageEntity.zza(field) && zzb(field).equals(imageEntity.zzb(field))) {
                    }
                    return false;
                }
                if (imageEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Image
        public String getUrl() {
            return this.zzF;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Image
        public boolean hasUrl() {
            return this.zzbeN.contains(2);
        }

        public int hashCode() {
            int iHashCode = 0;
            Iterator<FastJsonResponse.Field<?, ?>> it = zzbeM.values().iterator();
            while (true) {
                int i = iHashCode;
                if (!it.hasNext()) {
                    return i;
                }
                FastJsonResponse.Field<?, ?> next = it.next();
                if (zza(next)) {
                    iHashCode = zzb(next).hashCode() + i + next.zzrs();
                } else {
                    iHashCode = i;
                }
            }
        }

        @Override // com.google.android.gms.common.data.Freezable
        public boolean isDataValid() {
            return true;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            zzf zzfVar = CREATOR;
            zzf.zza(this, out, flags);
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        /* JADX INFO: renamed from: zzFl, reason: merged with bridge method [inline-methods] */
        public HashMap<String, FastJsonResponse.Field<?, ?>> zzrl() {
            return zzbeM;
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* JADX INFO: renamed from: zzFu, reason: merged with bridge method [inline-methods] */
        public ImageEntity freeze() {
            return this;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected boolean zza(FastJsonResponse.Field field) {
            return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected Object zzb(FastJsonResponse.Field field) {
            switch (field.zzrs()) {
                case 2:
                    return this.zzF;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
            }
        }
    }

    public static final class NameEntity extends FastSafeParcelableJsonResponse implements Person.Name {
        public static final zzg CREATOR = new zzg();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap<>();
        final int mVersionCode;
        final Set<Integer> zzbeN;
        String zzbfl;
        String zzbfo;
        String zzbgl;
        String zzbgm;
        String zzbgn;
        String zzbgo;

        static {
            zzbeM.put("familyName", FastJsonResponse.Field.zzl("familyName", 2));
            zzbeM.put("formatted", FastJsonResponse.Field.zzl("formatted", 3));
            zzbeM.put("givenName", FastJsonResponse.Field.zzl("givenName", 4));
            zzbeM.put("honorificPrefix", FastJsonResponse.Field.zzl("honorificPrefix", 5));
            zzbeM.put("honorificSuffix", FastJsonResponse.Field.zzl("honorificSuffix", 6));
            zzbeM.put("middleName", FastJsonResponse.Field.zzl("middleName", 7));
        }

        public NameEntity() {
            this.mVersionCode = 1;
            this.zzbeN = new HashSet();
        }

        NameEntity(Set<Integer> indicatorSet, int versionCode, String familyName, String formatted, String givenName, String honorificPrefix, String honorificSuffix, String middleName) {
            this.zzbeN = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbfl = familyName;
            this.zzbgl = formatted;
            this.zzbfo = givenName;
            this.zzbgm = honorificPrefix;
            this.zzbgn = honorificSuffix;
            this.zzbgo = middleName;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzg zzgVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof NameEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            NameEntity nameEntity = (NameEntity) obj;
            for (FastJsonResponse.Field<?, ?> field : zzbeM.values()) {
                if (zza(field)) {
                    if (nameEntity.zza(field) && zzb(field).equals(nameEntity.zzb(field))) {
                    }
                    return false;
                }
                if (nameEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public String getFamilyName() {
            return this.zzbfl;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public String getFormatted() {
            return this.zzbgl;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public String getGivenName() {
            return this.zzbfo;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public String getHonorificPrefix() {
            return this.zzbgm;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public String getHonorificSuffix() {
            return this.zzbgn;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public String getMiddleName() {
            return this.zzbgo;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public boolean hasFamilyName() {
            return this.zzbeN.contains(2);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public boolean hasFormatted() {
            return this.zzbeN.contains(3);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public boolean hasGivenName() {
            return this.zzbeN.contains(4);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public boolean hasHonorificPrefix() {
            return this.zzbeN.contains(5);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public boolean hasHonorificSuffix() {
            return this.zzbeN.contains(6);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public boolean hasMiddleName() {
            return this.zzbeN.contains(7);
        }

        public int hashCode() {
            int iHashCode = 0;
            Iterator<FastJsonResponse.Field<?, ?>> it = zzbeM.values().iterator();
            while (true) {
                int i = iHashCode;
                if (!it.hasNext()) {
                    return i;
                }
                FastJsonResponse.Field<?, ?> next = it.next();
                if (zza(next)) {
                    iHashCode = zzb(next).hashCode() + i + next.zzrs();
                } else {
                    iHashCode = i;
                }
            }
        }

        @Override // com.google.android.gms.common.data.Freezable
        public boolean isDataValid() {
            return true;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            zzg zzgVar = CREATOR;
            zzg.zza(this, out, flags);
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        /* JADX INFO: renamed from: zzFl, reason: merged with bridge method [inline-methods] */
        public HashMap<String, FastJsonResponse.Field<?, ?>> zzrl() {
            return zzbeM;
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* JADX INFO: renamed from: zzFv, reason: merged with bridge method [inline-methods] */
        public NameEntity freeze() {
            return this;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected boolean zza(FastJsonResponse.Field field) {
            return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected Object zzb(FastJsonResponse.Field field) {
            switch (field.zzrs()) {
                case 2:
                    return this.zzbfl;
                case 3:
                    return this.zzbgl;
                case 4:
                    return this.zzbfo;
                case 5:
                    return this.zzbgm;
                case 6:
                    return this.zzbgn;
                case 7:
                    return this.zzbgo;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
            }
        }
    }

    public static final class OrganizationsEntity extends FastSafeParcelableJsonResponse implements Person.Organizations {
        public static final zzh CREATOR = new zzh();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap<>();
        String mName;
        final int mVersionCode;
        int zzabB;
        String zzapg;
        String zzaxl;
        final Set<Integer> zzbeN;
        String zzbfA;
        String zzbfk;
        String zzbgp;
        String zzbgq;
        boolean zzbgr;

        static {
            zzbeM.put("department", FastJsonResponse.Field.zzl("department", 2));
            zzbeM.put("description", FastJsonResponse.Field.zzl("description", 3));
            zzbeM.put("endDate", FastJsonResponse.Field.zzl("endDate", 4));
            zzbeM.put("location", FastJsonResponse.Field.zzl("location", 5));
            zzbeM.put("name", FastJsonResponse.Field.zzl("name", 6));
            zzbeM.put("primary", FastJsonResponse.Field.zzk("primary", 7));
            zzbeM.put("startDate", FastJsonResponse.Field.zzl("startDate", 8));
            zzbeM.put("title", FastJsonResponse.Field.zzl("title", 9));
            zzbeM.put(ShareConstants.MEDIA_TYPE, FastJsonResponse.Field.zza(ShareConstants.MEDIA_TYPE, 10, new StringToIntConverter().zzh("work", 0).zzh("school", 1), false));
        }

        public OrganizationsEntity() {
            this.mVersionCode = 1;
            this.zzbeN = new HashSet();
        }

        OrganizationsEntity(Set<Integer> indicatorSet, int versionCode, String department, String description, String endDate, String location, String name, boolean primary, String startDate, String title, int type) {
            this.zzbeN = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbgp = department;
            this.zzaxl = description;
            this.zzbfk = endDate;
            this.zzbgq = location;
            this.mName = name;
            this.zzbgr = primary;
            this.zzbfA = startDate;
            this.zzapg = title;
            this.zzabB = type;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzh zzhVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof OrganizationsEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            OrganizationsEntity organizationsEntity = (OrganizationsEntity) obj;
            for (FastJsonResponse.Field<?, ?> field : zzbeM.values()) {
                if (zza(field)) {
                    if (organizationsEntity.zza(field) && zzb(field).equals(organizationsEntity.zzb(field))) {
                    }
                    return false;
                }
                if (organizationsEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public String getDepartment() {
            return this.zzbgp;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public String getDescription() {
            return this.zzaxl;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public String getEndDate() {
            return this.zzbfk;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public String getLocation() {
            return this.zzbgq;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public String getName() {
            return this.mName;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public String getStartDate() {
            return this.zzbfA;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public String getTitle() {
            return this.zzapg;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public int getType() {
            return this.zzabB;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public boolean hasDepartment() {
            return this.zzbeN.contains(2);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public boolean hasDescription() {
            return this.zzbeN.contains(3);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public boolean hasEndDate() {
            return this.zzbeN.contains(4);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public boolean hasLocation() {
            return this.zzbeN.contains(5);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public boolean hasName() {
            return this.zzbeN.contains(6);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public boolean hasPrimary() {
            return this.zzbeN.contains(7);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public boolean hasStartDate() {
            return this.zzbeN.contains(8);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public boolean hasTitle() {
            return this.zzbeN.contains(9);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public boolean hasType() {
            return this.zzbeN.contains(10);
        }

        public int hashCode() {
            int iHashCode = 0;
            Iterator<FastJsonResponse.Field<?, ?>> it = zzbeM.values().iterator();
            while (true) {
                int i = iHashCode;
                if (!it.hasNext()) {
                    return i;
                }
                FastJsonResponse.Field<?, ?> next = it.next();
                if (zza(next)) {
                    iHashCode = zzb(next).hashCode() + i + next.zzrs();
                } else {
                    iHashCode = i;
                }
            }
        }

        @Override // com.google.android.gms.common.data.Freezable
        public boolean isDataValid() {
            return true;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public boolean isPrimary() {
            return this.zzbgr;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            zzh zzhVar = CREATOR;
            zzh.zza(this, out, flags);
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        /* JADX INFO: renamed from: zzFl, reason: merged with bridge method [inline-methods] */
        public HashMap<String, FastJsonResponse.Field<?, ?>> zzrl() {
            return zzbeM;
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* JADX INFO: renamed from: zzFw, reason: merged with bridge method [inline-methods] */
        public OrganizationsEntity freeze() {
            return this;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected boolean zza(FastJsonResponse.Field field) {
            return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected Object zzb(FastJsonResponse.Field field) {
            switch (field.zzrs()) {
                case 2:
                    return this.zzbgp;
                case 3:
                    return this.zzaxl;
                case 4:
                    return this.zzbfk;
                case 5:
                    return this.zzbgq;
                case 6:
                    return this.mName;
                case 7:
                    return Boolean.valueOf(this.zzbgr);
                case 8:
                    return this.zzbfA;
                case 9:
                    return this.zzapg;
                case 10:
                    return Integer.valueOf(this.zzabB);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
            }
        }
    }

    public static final class PlacesLivedEntity extends FastSafeParcelableJsonResponse implements Person.PlacesLived {
        public static final zzi CREATOR = new zzi();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap<>();
        String mValue;
        final int mVersionCode;
        final Set<Integer> zzbeN;
        boolean zzbgr;

        static {
            zzbeM.put("primary", FastJsonResponse.Field.zzk("primary", 2));
            zzbeM.put("value", FastJsonResponse.Field.zzl("value", 3));
        }

        public PlacesLivedEntity() {
            this.mVersionCode = 1;
            this.zzbeN = new HashSet();
        }

        PlacesLivedEntity(Set<Integer> indicatorSet, int versionCode, boolean primary, String value) {
            this.zzbeN = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbgr = primary;
            this.mValue = value;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzi zziVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof PlacesLivedEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            PlacesLivedEntity placesLivedEntity = (PlacesLivedEntity) obj;
            for (FastJsonResponse.Field<?, ?> field : zzbeM.values()) {
                if (zza(field)) {
                    if (placesLivedEntity.zza(field) && zzb(field).equals(placesLivedEntity.zzb(field))) {
                    }
                    return false;
                }
                if (placesLivedEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.plus.model.people.Person.PlacesLived
        public String getValue() {
            return this.mValue;
        }

        @Override // com.google.android.gms.plus.model.people.Person.PlacesLived
        public boolean hasPrimary() {
            return this.zzbeN.contains(2);
        }

        @Override // com.google.android.gms.plus.model.people.Person.PlacesLived
        public boolean hasValue() {
            return this.zzbeN.contains(3);
        }

        public int hashCode() {
            int iHashCode = 0;
            Iterator<FastJsonResponse.Field<?, ?>> it = zzbeM.values().iterator();
            while (true) {
                int i = iHashCode;
                if (!it.hasNext()) {
                    return i;
                }
                FastJsonResponse.Field<?, ?> next = it.next();
                if (zza(next)) {
                    iHashCode = zzb(next).hashCode() + i + next.zzrs();
                } else {
                    iHashCode = i;
                }
            }
        }

        @Override // com.google.android.gms.common.data.Freezable
        public boolean isDataValid() {
            return true;
        }

        @Override // com.google.android.gms.plus.model.people.Person.PlacesLived
        public boolean isPrimary() {
            return this.zzbgr;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            zzi zziVar = CREATOR;
            zzi.zza(this, out, flags);
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        /* JADX INFO: renamed from: zzFl, reason: merged with bridge method [inline-methods] */
        public HashMap<String, FastJsonResponse.Field<?, ?>> zzrl() {
            return zzbeM;
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* JADX INFO: renamed from: zzFx, reason: merged with bridge method [inline-methods] */
        public PlacesLivedEntity freeze() {
            return this;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected boolean zza(FastJsonResponse.Field field) {
            return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected Object zzb(FastJsonResponse.Field field) {
            switch (field.zzrs()) {
                case 2:
                    return Boolean.valueOf(this.zzbgr);
                case 3:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
            }
        }
    }

    public static final class UrlsEntity extends FastSafeParcelableJsonResponse implements Person.Urls {
        public static final zzj CREATOR = new zzj();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap<>();
        String mValue;
        final int mVersionCode;
        String zzaUO;
        int zzabB;
        final Set<Integer> zzbeN;
        private final int zzbgs;

        static {
            zzbeM.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, FastJsonResponse.Field.zzl(PlusShare.KEY_CALL_TO_ACTION_LABEL, 5));
            zzbeM.put(ShareConstants.MEDIA_TYPE, FastJsonResponse.Field.zza(ShareConstants.MEDIA_TYPE, 6, new StringToIntConverter().zzh("home", 0).zzh("work", 1).zzh("blog", 2).zzh(Scopes.PROFILE, 3).zzh("other", 4).zzh("otherProfile", 5).zzh("contributor", 6).zzh("website", 7), false));
            zzbeM.put("value", FastJsonResponse.Field.zzl("value", 4));
        }

        public UrlsEntity() {
            this.zzbgs = 4;
            this.mVersionCode = 1;
            this.zzbeN = new HashSet();
        }

        UrlsEntity(Set<Integer> indicatorSet, int versionCode, String label, int type, String value, int type_DEPRECATED_FENACHO) {
            this.zzbgs = 4;
            this.zzbeN = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzaUO = label;
            this.zzabB = type;
            this.mValue = value;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzj zzjVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof UrlsEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            UrlsEntity urlsEntity = (UrlsEntity) obj;
            for (FastJsonResponse.Field<?, ?> field : zzbeM.values()) {
                if (zza(field)) {
                    if (urlsEntity.zza(field) && zzb(field).equals(urlsEntity.zzb(field))) {
                    }
                    return false;
                }
                if (urlsEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Urls
        public String getLabel() {
            return this.zzaUO;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Urls
        public int getType() {
            return this.zzabB;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Urls
        public String getValue() {
            return this.mValue;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Urls
        public boolean hasLabel() {
            return this.zzbeN.contains(5);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Urls
        public boolean hasType() {
            return this.zzbeN.contains(6);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Urls
        public boolean hasValue() {
            return this.zzbeN.contains(4);
        }

        public int hashCode() {
            int iHashCode = 0;
            Iterator<FastJsonResponse.Field<?, ?>> it = zzbeM.values().iterator();
            while (true) {
                int i = iHashCode;
                if (!it.hasNext()) {
                    return i;
                }
                FastJsonResponse.Field<?, ?> next = it.next();
                if (zza(next)) {
                    iHashCode = zzb(next).hashCode() + i + next.zzrs();
                } else {
                    iHashCode = i;
                }
            }
        }

        @Override // com.google.android.gms.common.data.Freezable
        public boolean isDataValid() {
            return true;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            zzj zzjVar = CREATOR;
            zzj.zza(this, out, flags);
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        /* JADX INFO: renamed from: zzFl, reason: merged with bridge method [inline-methods] */
        public HashMap<String, FastJsonResponse.Field<?, ?>> zzrl() {
            return zzbeM;
        }

        @Deprecated
        public int zzFy() {
            return 4;
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* JADX INFO: renamed from: zzFz, reason: merged with bridge method [inline-methods] */
        public UrlsEntity freeze() {
            return this;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected boolean zza(FastJsonResponse.Field field) {
            return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected Object zzb(FastJsonResponse.Field field) {
            switch (field.zzrs()) {
                case 4:
                    return this.mValue;
                case 5:
                    return this.zzaUO;
                case 6:
                    return Integer.valueOf(this.zzabB);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
            }
        }
    }

    public static class zza {
        public static int zzfH(String str) {
            if (str.equals("person")) {
                return 0;
            }
            if (str.equals("page")) {
                return 1;
            }
            throw new IllegalArgumentException("Unknown objectType string: " + str);
        }
    }

    static {
        zzbeM.put("aboutMe", FastJsonResponse.Field.zzl("aboutMe", 2));
        zzbeM.put("ageRange", FastJsonResponse.Field.zza("ageRange", 3, AgeRangeEntity.class));
        zzbeM.put("birthday", FastJsonResponse.Field.zzl("birthday", 4));
        zzbeM.put("braggingRights", FastJsonResponse.Field.zzl("braggingRights", 5));
        zzbeM.put("circledByCount", FastJsonResponse.Field.zzi("circledByCount", 6));
        zzbeM.put("cover", FastJsonResponse.Field.zza("cover", 7, CoverEntity.class));
        zzbeM.put("currentLocation", FastJsonResponse.Field.zzl("currentLocation", 8));
        zzbeM.put("displayName", FastJsonResponse.Field.zzl("displayName", 9));
        zzbeM.put("gender", FastJsonResponse.Field.zza("gender", 12, new StringToIntConverter().zzh("male", 0).zzh("female", 1).zzh("other", 2), false));
        zzbeM.put(ShareConstants.WEB_DIALOG_PARAM_ID, FastJsonResponse.Field.zzl(ShareConstants.WEB_DIALOG_PARAM_ID, 14));
        zzbeM.put("image", FastJsonResponse.Field.zza("image", 15, ImageEntity.class));
        zzbeM.put("isPlusUser", FastJsonResponse.Field.zzk("isPlusUser", 16));
        zzbeM.put("language", FastJsonResponse.Field.zzl("language", 18));
        zzbeM.put("name", FastJsonResponse.Field.zza("name", 19, NameEntity.class));
        zzbeM.put("nickname", FastJsonResponse.Field.zzl("nickname", 20));
        zzbeM.put("objectType", FastJsonResponse.Field.zza("objectType", 21, new StringToIntConverter().zzh("person", 0).zzh("page", 1), false));
        zzbeM.put("organizations", FastJsonResponse.Field.zzb("organizations", 22, OrganizationsEntity.class));
        zzbeM.put("placesLived", FastJsonResponse.Field.zzb("placesLived", 23, PlacesLivedEntity.class));
        zzbeM.put("plusOneCount", FastJsonResponse.Field.zzi("plusOneCount", 24));
        zzbeM.put("relationshipStatus", FastJsonResponse.Field.zza("relationshipStatus", 25, new StringToIntConverter().zzh("single", 0).zzh("in_a_relationship", 1).zzh("engaged", 2).zzh("married", 3).zzh("its_complicated", 4).zzh("open_relationship", 5).zzh("widowed", 6).zzh("in_domestic_partnership", 7).zzh("in_civil_union", 8), false));
        zzbeM.put("tagline", FastJsonResponse.Field.zzl("tagline", 26));
        zzbeM.put("url", FastJsonResponse.Field.zzl("url", 27));
        zzbeM.put("urls", FastJsonResponse.Field.zzb("urls", 28, UrlsEntity.class));
        zzbeM.put("verified", FastJsonResponse.Field.zzk("verified", 29));
    }

    public PersonEntity() {
        this.mVersionCode = 1;
        this.zzbeN = new HashSet();
    }

    public PersonEntity(String displayName, String id, ImageEntity image, int objectType, String url) {
        this.mVersionCode = 1;
        this.zzbeN = new HashSet();
        this.zzWQ = displayName;
        this.zzbeN.add(9);
        this.zzyv = id;
        this.zzbeN.add(14);
        this.zzbfS = image;
        this.zzbeN.add(15);
        this.zzbfW = objectType;
        this.zzbeN.add(21);
        this.zzF = url;
        this.zzbeN.add(27);
    }

    PersonEntity(Set<Integer> indicatorSet, int versionCode, String aboutMe, AgeRangeEntity ageRange, String birthday, String braggingRights, int circledByCount, CoverEntity cover, String currentLocation, String displayName, int gender, String id, ImageEntity image, boolean isPlusUser, String language, NameEntity name, String nickname, int objectType, List<OrganizationsEntity> organizations, List<PlacesLivedEntity> placesLived, int plusOneCount, int relationshipStatus, String tagline, String url, List<UrlsEntity> urls, boolean verified) {
        this.zzbeN = indicatorSet;
        this.mVersionCode = versionCode;
        this.zzbfL = aboutMe;
        this.zzbfM = ageRange;
        this.zzbfN = birthday;
        this.zzbfO = braggingRights;
        this.zzbfP = circledByCount;
        this.zzbfQ = cover;
        this.zzbfR = currentLocation;
        this.zzWQ = displayName;
        this.zztT = gender;
        this.zzyv = id;
        this.zzbfS = image;
        this.zzbfT = isPlusUser;
        this.zzaaL = language;
        this.zzbfU = name;
        this.zzbfV = nickname;
        this.zzbfW = objectType;
        this.zzbfX = organizations;
        this.zzbfY = placesLived;
        this.zzbfZ = plusOneCount;
        this.zzbga = relationshipStatus;
        this.zzbgb = tagline;
        this.zzF = url;
        this.zzbgc = urls;
        this.zzbgd = verified;
    }

    public static PersonEntity zzv(byte[] bArr) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        PersonEntity personEntityCreateFromParcel = CREATOR.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        return personEntityCreateFromParcel;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        com.google.android.gms.plus.internal.model.people.zza zzaVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PersonEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        PersonEntity personEntity = (PersonEntity) obj;
        for (FastJsonResponse.Field<?, ?> field : zzbeM.values()) {
            if (zza(field)) {
                if (personEntity.zza(field) && zzb(field).equals(personEntity.zzb(field))) {
                }
                return false;
            }
            if (personEntity.zza(field)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public String getAboutMe() {
        return this.zzbfL;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public Person.AgeRange getAgeRange() {
        return this.zzbfM;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public String getBirthday() {
        return this.zzbfN;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public String getBraggingRights() {
        return this.zzbfO;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public int getCircledByCount() {
        return this.zzbfP;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public Person.Cover getCover() {
        return this.zzbfQ;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public String getCurrentLocation() {
        return this.zzbfR;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public String getDisplayName() {
        return this.zzWQ;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public int getGender() {
        return this.zztT;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public String getId() {
        return this.zzyv;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public Person.Image getImage() {
        return this.zzbfS;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public String getLanguage() {
        return this.zzaaL;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public Person.Name getName() {
        return this.zzbfU;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public String getNickname() {
        return this.zzbfV;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public int getObjectType() {
        return this.zzbfW;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public List<Person.Organizations> getOrganizations() {
        return (ArrayList) this.zzbfX;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public List<Person.PlacesLived> getPlacesLived() {
        return (ArrayList) this.zzbfY;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public int getPlusOneCount() {
        return this.zzbfZ;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public int getRelationshipStatus() {
        return this.zzbga;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public String getTagline() {
        return this.zzbgb;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public String getUrl() {
        return this.zzF;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public List<Person.Urls> getUrls() {
        return (ArrayList) this.zzbgc;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasAboutMe() {
        return this.zzbeN.contains(2);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasAgeRange() {
        return this.zzbeN.contains(3);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasBirthday() {
        return this.zzbeN.contains(4);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasBraggingRights() {
        return this.zzbeN.contains(5);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasCircledByCount() {
        return this.zzbeN.contains(6);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasCover() {
        return this.zzbeN.contains(7);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasCurrentLocation() {
        return this.zzbeN.contains(8);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasDisplayName() {
        return this.zzbeN.contains(9);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasGender() {
        return this.zzbeN.contains(12);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasId() {
        return this.zzbeN.contains(14);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasImage() {
        return this.zzbeN.contains(15);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasIsPlusUser() {
        return this.zzbeN.contains(16);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasLanguage() {
        return this.zzbeN.contains(18);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasName() {
        return this.zzbeN.contains(19);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasNickname() {
        return this.zzbeN.contains(20);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasObjectType() {
        return this.zzbeN.contains(21);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasOrganizations() {
        return this.zzbeN.contains(22);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasPlacesLived() {
        return this.zzbeN.contains(23);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasPlusOneCount() {
        return this.zzbeN.contains(24);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasRelationshipStatus() {
        return this.zzbeN.contains(25);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasTagline() {
        return this.zzbeN.contains(26);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasUrl() {
        return this.zzbeN.contains(27);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasUrls() {
        return this.zzbeN.contains(28);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean hasVerified() {
        return this.zzbeN.contains(29);
    }

    public int hashCode() {
        int iHashCode = 0;
        Iterator<FastJsonResponse.Field<?, ?>> it = zzbeM.values().iterator();
        while (true) {
            int i = iHashCode;
            if (!it.hasNext()) {
                return i;
            }
            FastJsonResponse.Field<?, ?> next = it.next();
            if (zza(next)) {
                iHashCode = zzb(next).hashCode() + i + next.zzrs();
            } else {
                iHashCode = i;
            }
        }
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean isPlusUser() {
        return this.zzbfT;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public boolean isVerified() {
        return this.zzbgd;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        com.google.android.gms.plus.internal.model.people.zza zzaVar = CREATOR;
        com.google.android.gms.plus.internal.model.people.zza.zza(this, out, flags);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    /* JADX INFO: renamed from: zzFl, reason: merged with bridge method [inline-methods] */
    public HashMap<String, FastJsonResponse.Field<?, ?>> zzrl() {
        return zzbeM;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzFp, reason: merged with bridge method [inline-methods] */
    public PersonEntity freeze() {
        return this;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected boolean zza(FastJsonResponse.Field field) {
        return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected Object zzb(FastJsonResponse.Field field) {
        switch (field.zzrs()) {
            case 2:
                return this.zzbfL;
            case 3:
                return this.zzbfM;
            case 4:
                return this.zzbfN;
            case 5:
                return this.zzbfO;
            case 6:
                return Integer.valueOf(this.zzbfP);
            case 7:
                return this.zzbfQ;
            case 8:
                return this.zzbfR;
            case 9:
                return this.zzWQ;
            case 10:
            case 11:
            case 13:
            case 17:
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
            case 12:
                return Integer.valueOf(this.zztT);
            case 14:
                return this.zzyv;
            case 15:
                return this.zzbfS;
            case 16:
                return Boolean.valueOf(this.zzbfT);
            case 18:
                return this.zzaaL;
            case 19:
                return this.zzbfU;
            case 20:
                return this.zzbfV;
            case 21:
                return Integer.valueOf(this.zzbfW);
            case 22:
                return this.zzbfX;
            case 23:
                return this.zzbfY;
            case 24:
                return Integer.valueOf(this.zzbfZ);
            case 25:
                return Integer.valueOf(this.zzbga);
            case 26:
                return this.zzbgb;
            case 27:
                return this.zzF;
            case 28:
                return this.zzbgc;
            case 29:
                return Boolean.valueOf(this.zzbgd);
        }
    }
}
