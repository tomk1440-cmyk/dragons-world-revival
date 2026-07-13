package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.moments.ItemScope;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class ItemScopeEntity extends FastSafeParcelableJsonResponse implements ItemScope {
    public static final zza CREATOR = new zza();
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap<>();
    String mName;
    final int mVersionCode;
    String zzF;
    String zzJN;
    double zzaNF;
    double zzaNG;
    String zzaxl;
    final Set<Integer> zzbeN;
    ItemScopeEntity zzbeO;
    List<String> zzbeP;
    ItemScopeEntity zzbeQ;
    String zzbeR;
    String zzbeS;
    String zzbeT;
    List<ItemScopeEntity> zzbeU;
    int zzbeV;
    List<ItemScopeEntity> zzbeW;
    ItemScopeEntity zzbeX;
    List<ItemScopeEntity> zzbeY;
    String zzbeZ;
    String zzbfA;
    String zzbfB;
    String zzbfC;
    ItemScopeEntity zzbfD;
    String zzbfE;
    String zzbfF;
    String zzbfG;
    String zzbfH;
    String zzbfa;
    ItemScopeEntity zzbfb;
    String zzbfc;
    String zzbfd;
    List<ItemScopeEntity> zzbfe;
    String zzbff;
    String zzbfg;
    String zzbfh;
    String zzbfi;
    String zzbfj;
    String zzbfk;
    String zzbfl;
    String zzbfm;
    ItemScopeEntity zzbfn;
    String zzbfo;
    String zzbfp;
    String zzbfq;
    ItemScopeEntity zzbfr;
    ItemScopeEntity zzbfs;
    ItemScopeEntity zzbft;
    List<ItemScopeEntity> zzbfu;
    String zzbfv;
    String zzbfw;
    String zzbfx;
    String zzbfy;
    ItemScopeEntity zzbfz;
    String zztZ;
    String zzyv;

    static {
        zzbeM.put("about", FastJsonResponse.Field.zza("about", 2, ItemScopeEntity.class));
        zzbeM.put("additionalName", FastJsonResponse.Field.zzm("additionalName", 3));
        zzbeM.put("address", FastJsonResponse.Field.zza("address", 4, ItemScopeEntity.class));
        zzbeM.put("addressCountry", FastJsonResponse.Field.zzl("addressCountry", 5));
        zzbeM.put("addressLocality", FastJsonResponse.Field.zzl("addressLocality", 6));
        zzbeM.put("addressRegion", FastJsonResponse.Field.zzl("addressRegion", 7));
        zzbeM.put("associated_media", FastJsonResponse.Field.zzb("associated_media", 8, ItemScopeEntity.class));
        zzbeM.put("attendeeCount", FastJsonResponse.Field.zzi("attendeeCount", 9));
        zzbeM.put("attendees", FastJsonResponse.Field.zzb("attendees", 10, ItemScopeEntity.class));
        zzbeM.put("audio", FastJsonResponse.Field.zza("audio", 11, ItemScopeEntity.class));
        zzbeM.put("author", FastJsonResponse.Field.zzb("author", 12, ItemScopeEntity.class));
        zzbeM.put("bestRating", FastJsonResponse.Field.zzl("bestRating", 13));
        zzbeM.put("birthDate", FastJsonResponse.Field.zzl("birthDate", 14));
        zzbeM.put("byArtist", FastJsonResponse.Field.zza("byArtist", 15, ItemScopeEntity.class));
        zzbeM.put(ShareConstants.FEED_CAPTION_PARAM, FastJsonResponse.Field.zzl(ShareConstants.FEED_CAPTION_PARAM, 16));
        zzbeM.put("contentSize", FastJsonResponse.Field.zzl("contentSize", 17));
        zzbeM.put("contentUrl", FastJsonResponse.Field.zzl("contentUrl", 18));
        zzbeM.put("contributor", FastJsonResponse.Field.zzb("contributor", 19, ItemScopeEntity.class));
        zzbeM.put("dateCreated", FastJsonResponse.Field.zzl("dateCreated", 20));
        zzbeM.put("dateModified", FastJsonResponse.Field.zzl("dateModified", 21));
        zzbeM.put("datePublished", FastJsonResponse.Field.zzl("datePublished", 22));
        zzbeM.put("description", FastJsonResponse.Field.zzl("description", 23));
        zzbeM.put("duration", FastJsonResponse.Field.zzl("duration", 24));
        zzbeM.put("embedUrl", FastJsonResponse.Field.zzl("embedUrl", 25));
        zzbeM.put("endDate", FastJsonResponse.Field.zzl("endDate", 26));
        zzbeM.put("familyName", FastJsonResponse.Field.zzl("familyName", 27));
        zzbeM.put("gender", FastJsonResponse.Field.zzl("gender", 28));
        zzbeM.put("geo", FastJsonResponse.Field.zza("geo", 29, ItemScopeEntity.class));
        zzbeM.put("givenName", FastJsonResponse.Field.zzl("givenName", 30));
        zzbeM.put(SettingsJsonConstants.ICON_HEIGHT_KEY, FastJsonResponse.Field.zzl(SettingsJsonConstants.ICON_HEIGHT_KEY, 31));
        zzbeM.put(ShareConstants.WEB_DIALOG_PARAM_ID, FastJsonResponse.Field.zzl(ShareConstants.WEB_DIALOG_PARAM_ID, 32));
        zzbeM.put("image", FastJsonResponse.Field.zzl("image", 33));
        zzbeM.put("inAlbum", FastJsonResponse.Field.zza("inAlbum", 34, ItemScopeEntity.class));
        zzbeM.put("latitude", FastJsonResponse.Field.zzj("latitude", 36));
        zzbeM.put("location", FastJsonResponse.Field.zza("location", 37, ItemScopeEntity.class));
        zzbeM.put("longitude", FastJsonResponse.Field.zzj("longitude", 38));
        zzbeM.put("name", FastJsonResponse.Field.zzl("name", 39));
        zzbeM.put("partOfTVSeries", FastJsonResponse.Field.zza("partOfTVSeries", 40, ItemScopeEntity.class));
        zzbeM.put("performers", FastJsonResponse.Field.zzb("performers", 41, ItemScopeEntity.class));
        zzbeM.put("playerType", FastJsonResponse.Field.zzl("playerType", 42));
        zzbeM.put("postOfficeBoxNumber", FastJsonResponse.Field.zzl("postOfficeBoxNumber", 43));
        zzbeM.put("postalCode", FastJsonResponse.Field.zzl("postalCode", 44));
        zzbeM.put("ratingValue", FastJsonResponse.Field.zzl("ratingValue", 45));
        zzbeM.put("reviewRating", FastJsonResponse.Field.zza("reviewRating", 46, ItemScopeEntity.class));
        zzbeM.put("startDate", FastJsonResponse.Field.zzl("startDate", 47));
        zzbeM.put("streetAddress", FastJsonResponse.Field.zzl("streetAddress", 48));
        zzbeM.put("text", FastJsonResponse.Field.zzl("text", 49));
        zzbeM.put("thumbnail", FastJsonResponse.Field.zza("thumbnail", 50, ItemScopeEntity.class));
        zzbeM.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, FastJsonResponse.Field.zzl(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, 51));
        zzbeM.put("tickerSymbol", FastJsonResponse.Field.zzl("tickerSymbol", 52));
        zzbeM.put(ShareConstants.MEDIA_TYPE, FastJsonResponse.Field.zzl(ShareConstants.MEDIA_TYPE, 53));
        zzbeM.put("url", FastJsonResponse.Field.zzl("url", 54));
        zzbeM.put(SettingsJsonConstants.ICON_WIDTH_KEY, FastJsonResponse.Field.zzl(SettingsJsonConstants.ICON_WIDTH_KEY, 55));
        zzbeM.put("worstRating", FastJsonResponse.Field.zzl("worstRating", 56));
    }

    public ItemScopeEntity() {
        this.mVersionCode = 1;
        this.zzbeN = new HashSet();
    }

    ItemScopeEntity(Set<Integer> indicatorSet, int versionCode, ItemScopeEntity about, List<String> additionalName, ItemScopeEntity address, String addressCountry, String addressLocality, String addressRegion, List<ItemScopeEntity> associated_media, int attendeeCount, List<ItemScopeEntity> attendees, ItemScopeEntity audio, List<ItemScopeEntity> author, String bestRating, String birthDate, ItemScopeEntity byArtist, String caption, String contentSize, String contentUrl, List<ItemScopeEntity> contributor, String dateCreated, String dateModified, String datePublished, String description, String duration, String embedUrl, String endDate, String familyName, String gender, ItemScopeEntity geo, String givenName, String height, String id, String image, ItemScopeEntity inAlbum, double latitude, ItemScopeEntity location, double longitude, String name, ItemScopeEntity partOfTVSeries, List<ItemScopeEntity> performers, String playerType, String postOfficeBoxNumber, String postalCode, String ratingValue, ItemScopeEntity reviewRating, String startDate, String streetAddress, String text, ItemScopeEntity thumbnail, String thumbnailUrl, String tickerSymbol, String type, String url, String width, String worstRating) {
        this.zzbeN = indicatorSet;
        this.mVersionCode = versionCode;
        this.zzbeO = about;
        this.zzbeP = additionalName;
        this.zzbeQ = address;
        this.zzbeR = addressCountry;
        this.zzbeS = addressLocality;
        this.zzbeT = addressRegion;
        this.zzbeU = associated_media;
        this.zzbeV = attendeeCount;
        this.zzbeW = attendees;
        this.zzbeX = audio;
        this.zzbeY = author;
        this.zzbeZ = bestRating;
        this.zzbfa = birthDate;
        this.zzbfb = byArtist;
        this.zzbfc = caption;
        this.zzbfd = contentSize;
        this.zztZ = contentUrl;
        this.zzbfe = contributor;
        this.zzbff = dateCreated;
        this.zzbfg = dateModified;
        this.zzbfh = datePublished;
        this.zzaxl = description;
        this.zzbfi = duration;
        this.zzbfj = embedUrl;
        this.zzbfk = endDate;
        this.zzbfl = familyName;
        this.zzbfm = gender;
        this.zzbfn = geo;
        this.zzbfo = givenName;
        this.zzbfp = height;
        this.zzyv = id;
        this.zzbfq = image;
        this.zzbfr = inAlbum;
        this.zzaNF = latitude;
        this.zzbfs = location;
        this.zzaNG = longitude;
        this.mName = name;
        this.zzbft = partOfTVSeries;
        this.zzbfu = performers;
        this.zzbfv = playerType;
        this.zzbfw = postOfficeBoxNumber;
        this.zzbfx = postalCode;
        this.zzbfy = ratingValue;
        this.zzbfz = reviewRating;
        this.zzbfA = startDate;
        this.zzbfB = streetAddress;
        this.zzbfC = text;
        this.zzbfD = thumbnail;
        this.zzbfE = thumbnailUrl;
        this.zzbfF = tickerSymbol;
        this.zzJN = type;
        this.zzF = url;
        this.zzbfG = width;
        this.zzbfH = worstRating;
    }

    public ItemScopeEntity(Set<Integer> indicatorSet, ItemScopeEntity about, List<String> additionalName, ItemScopeEntity address, String addressCountry, String addressLocality, String addressRegion, List<ItemScopeEntity> associated_media, int attendeeCount, List<ItemScopeEntity> attendees, ItemScopeEntity audio, List<ItemScopeEntity> author, String bestRating, String birthDate, ItemScopeEntity byArtist, String caption, String contentSize, String contentUrl, List<ItemScopeEntity> contributor, String dateCreated, String dateModified, String datePublished, String description, String duration, String embedUrl, String endDate, String familyName, String gender, ItemScopeEntity geo, String givenName, String height, String id, String image, ItemScopeEntity inAlbum, double latitude, ItemScopeEntity location, double longitude, String name, ItemScopeEntity partOfTVSeries, List<ItemScopeEntity> performers, String playerType, String postOfficeBoxNumber, String postalCode, String ratingValue, ItemScopeEntity reviewRating, String startDate, String streetAddress, String text, ItemScopeEntity thumbnail, String thumbnailUrl, String tickerSymbol, String type, String url, String width, String worstRating) {
        this.zzbeN = indicatorSet;
        this.mVersionCode = 1;
        this.zzbeO = about;
        this.zzbeP = additionalName;
        this.zzbeQ = address;
        this.zzbeR = addressCountry;
        this.zzbeS = addressLocality;
        this.zzbeT = addressRegion;
        this.zzbeU = associated_media;
        this.zzbeV = attendeeCount;
        this.zzbeW = attendees;
        this.zzbeX = audio;
        this.zzbeY = author;
        this.zzbeZ = bestRating;
        this.zzbfa = birthDate;
        this.zzbfb = byArtist;
        this.zzbfc = caption;
        this.zzbfd = contentSize;
        this.zztZ = contentUrl;
        this.zzbfe = contributor;
        this.zzbff = dateCreated;
        this.zzbfg = dateModified;
        this.zzbfh = datePublished;
        this.zzaxl = description;
        this.zzbfi = duration;
        this.zzbfj = embedUrl;
        this.zzbfk = endDate;
        this.zzbfl = familyName;
        this.zzbfm = gender;
        this.zzbfn = geo;
        this.zzbfo = givenName;
        this.zzbfp = height;
        this.zzyv = id;
        this.zzbfq = image;
        this.zzbfr = inAlbum;
        this.zzaNF = latitude;
        this.zzbfs = location;
        this.zzaNG = longitude;
        this.mName = name;
        this.zzbft = partOfTVSeries;
        this.zzbfu = performers;
        this.zzbfv = playerType;
        this.zzbfw = postOfficeBoxNumber;
        this.zzbfx = postalCode;
        this.zzbfy = ratingValue;
        this.zzbfz = reviewRating;
        this.zzbfA = startDate;
        this.zzbfB = streetAddress;
        this.zzbfC = text;
        this.zzbfD = thumbnail;
        this.zzbfE = thumbnailUrl;
        this.zzbfF = tickerSymbol;
        this.zzJN = type;
        this.zzF = url;
        this.zzbfG = width;
        this.zzbfH = worstRating;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zza zzaVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ItemScopeEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ItemScopeEntity itemScopeEntity = (ItemScopeEntity) obj;
        for (FastJsonResponse.Field<?, ?> field : zzbeM.values()) {
            if (zza(field)) {
                if (itemScopeEntity.zza(field) && zzb(field).equals(itemScopeEntity.zzb(field))) {
                }
                return false;
            }
            if (itemScopeEntity.zza(field)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public ItemScope getAbout() {
        return this.zzbeO;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public List<String> getAdditionalName() {
        return this.zzbeP;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public ItemScope getAddress() {
        return this.zzbeQ;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getAddressCountry() {
        return this.zzbeR;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getAddressLocality() {
        return this.zzbeS;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getAddressRegion() {
        return this.zzbeT;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public List<ItemScope> getAssociated_media() {
        return (ArrayList) this.zzbeU;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public int getAttendeeCount() {
        return this.zzbeV;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public List<ItemScope> getAttendees() {
        return (ArrayList) this.zzbeW;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public ItemScope getAudio() {
        return this.zzbeX;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public List<ItemScope> getAuthor() {
        return (ArrayList) this.zzbeY;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getBestRating() {
        return this.zzbeZ;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getBirthDate() {
        return this.zzbfa;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public ItemScope getByArtist() {
        return this.zzbfb;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getCaption() {
        return this.zzbfc;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getContentSize() {
        return this.zzbfd;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getContentUrl() {
        return this.zztZ;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public List<ItemScope> getContributor() {
        return (ArrayList) this.zzbfe;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getDateCreated() {
        return this.zzbff;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getDateModified() {
        return this.zzbfg;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getDatePublished() {
        return this.zzbfh;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getDescription() {
        return this.zzaxl;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getDuration() {
        return this.zzbfi;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getEmbedUrl() {
        return this.zzbfj;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getEndDate() {
        return this.zzbfk;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getFamilyName() {
        return this.zzbfl;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getGender() {
        return this.zzbfm;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public ItemScope getGeo() {
        return this.zzbfn;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getGivenName() {
        return this.zzbfo;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getHeight() {
        return this.zzbfp;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getId() {
        return this.zzyv;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getImage() {
        return this.zzbfq;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public ItemScope getInAlbum() {
        return this.zzbfr;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public double getLatitude() {
        return this.zzaNF;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public ItemScope getLocation() {
        return this.zzbfs;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public double getLongitude() {
        return this.zzaNG;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getName() {
        return this.mName;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public ItemScope getPartOfTVSeries() {
        return this.zzbft;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public List<ItemScope> getPerformers() {
        return (ArrayList) this.zzbfu;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getPlayerType() {
        return this.zzbfv;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getPostOfficeBoxNumber() {
        return this.zzbfw;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getPostalCode() {
        return this.zzbfx;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getRatingValue() {
        return this.zzbfy;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public ItemScope getReviewRating() {
        return this.zzbfz;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getStartDate() {
        return this.zzbfA;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getStreetAddress() {
        return this.zzbfB;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getText() {
        return this.zzbfC;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public ItemScope getThumbnail() {
        return this.zzbfD;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getThumbnailUrl() {
        return this.zzbfE;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getTickerSymbol() {
        return this.zzbfF;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getType() {
        return this.zzJN;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getUrl() {
        return this.zzF;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getWidth() {
        return this.zzbfG;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getWorstRating() {
        return this.zzbfH;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasAbout() {
        return this.zzbeN.contains(2);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasAdditionalName() {
        return this.zzbeN.contains(3);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasAddress() {
        return this.zzbeN.contains(4);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasAddressCountry() {
        return this.zzbeN.contains(5);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasAddressLocality() {
        return this.zzbeN.contains(6);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasAddressRegion() {
        return this.zzbeN.contains(7);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasAssociated_media() {
        return this.zzbeN.contains(8);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasAttendeeCount() {
        return this.zzbeN.contains(9);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasAttendees() {
        return this.zzbeN.contains(10);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasAudio() {
        return this.zzbeN.contains(11);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasAuthor() {
        return this.zzbeN.contains(12);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasBestRating() {
        return this.zzbeN.contains(13);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasBirthDate() {
        return this.zzbeN.contains(14);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasByArtist() {
        return this.zzbeN.contains(15);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasCaption() {
        return this.zzbeN.contains(16);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasContentSize() {
        return this.zzbeN.contains(17);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasContentUrl() {
        return this.zzbeN.contains(18);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasContributor() {
        return this.zzbeN.contains(19);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasDateCreated() {
        return this.zzbeN.contains(20);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasDateModified() {
        return this.zzbeN.contains(21);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasDatePublished() {
        return this.zzbeN.contains(22);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasDescription() {
        return this.zzbeN.contains(23);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasDuration() {
        return this.zzbeN.contains(24);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasEmbedUrl() {
        return this.zzbeN.contains(25);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasEndDate() {
        return this.zzbeN.contains(26);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasFamilyName() {
        return this.zzbeN.contains(27);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasGender() {
        return this.zzbeN.contains(28);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasGeo() {
        return this.zzbeN.contains(29);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasGivenName() {
        return this.zzbeN.contains(30);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasHeight() {
        return this.zzbeN.contains(31);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasId() {
        return this.zzbeN.contains(32);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasImage() {
        return this.zzbeN.contains(33);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasInAlbum() {
        return this.zzbeN.contains(34);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasLatitude() {
        return this.zzbeN.contains(36);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasLocation() {
        return this.zzbeN.contains(37);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasLongitude() {
        return this.zzbeN.contains(38);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasName() {
        return this.zzbeN.contains(39);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasPartOfTVSeries() {
        return this.zzbeN.contains(40);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasPerformers() {
        return this.zzbeN.contains(41);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasPlayerType() {
        return this.zzbeN.contains(42);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasPostOfficeBoxNumber() {
        return this.zzbeN.contains(43);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasPostalCode() {
        return this.zzbeN.contains(44);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasRatingValue() {
        return this.zzbeN.contains(45);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasReviewRating() {
        return this.zzbeN.contains(46);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasStartDate() {
        return this.zzbeN.contains(47);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasStreetAddress() {
        return this.zzbeN.contains(48);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasText() {
        return this.zzbeN.contains(49);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasThumbnail() {
        return this.zzbeN.contains(50);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasThumbnailUrl() {
        return this.zzbeN.contains(51);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasTickerSymbol() {
        return this.zzbeN.contains(52);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasType() {
        return this.zzbeN.contains(53);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasUrl() {
        return this.zzbeN.contains(54);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasWidth() {
        return this.zzbeN.contains(55);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasWorstRating() {
        return this.zzbeN.contains(56);
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
        zza zzaVar = CREATOR;
        zza.zza(this, out, flags);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    /* JADX INFO: renamed from: zzFl, reason: merged with bridge method [inline-methods] */
    public HashMap<String, FastJsonResponse.Field<?, ?>> zzrl() {
        return zzbeM;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzFm, reason: merged with bridge method [inline-methods] */
    public ItemScopeEntity freeze() {
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
                return this.zzbeO;
            case 3:
                return this.zzbeP;
            case 4:
                return this.zzbeQ;
            case 5:
                return this.zzbeR;
            case 6:
                return this.zzbeS;
            case 7:
                return this.zzbeT;
            case 8:
                return this.zzbeU;
            case 9:
                return Integer.valueOf(this.zzbeV);
            case 10:
                return this.zzbeW;
            case 11:
                return this.zzbeX;
            case 12:
                return this.zzbeY;
            case 13:
                return this.zzbeZ;
            case 14:
                return this.zzbfa;
            case 15:
                return this.zzbfb;
            case 16:
                return this.zzbfc;
            case 17:
                return this.zzbfd;
            case 18:
                return this.zztZ;
            case 19:
                return this.zzbfe;
            case 20:
                return this.zzbff;
            case 21:
                return this.zzbfg;
            case 22:
                return this.zzbfh;
            case 23:
                return this.zzaxl;
            case 24:
                return this.zzbfi;
            case 25:
                return this.zzbfj;
            case 26:
                return this.zzbfk;
            case 27:
                return this.zzbfl;
            case 28:
                return this.zzbfm;
            case 29:
                return this.zzbfn;
            case 30:
                return this.zzbfo;
            case 31:
                return this.zzbfp;
            case 32:
                return this.zzyv;
            case 33:
                return this.zzbfq;
            case 34:
                return this.zzbfr;
            case 35:
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
            case 36:
                return Double.valueOf(this.zzaNF);
            case 37:
                return this.zzbfs;
            case 38:
                return Double.valueOf(this.zzaNG);
            case 39:
                return this.mName;
            case 40:
                return this.zzbft;
            case 41:
                return this.zzbfu;
            case 42:
                return this.zzbfv;
            case 43:
                return this.zzbfw;
            case 44:
                return this.zzbfx;
            case 45:
                return this.zzbfy;
            case 46:
                return this.zzbfz;
            case 47:
                return this.zzbfA;
            case Place.TYPE_HINDU_TEMPLE /* 48 */:
                return this.zzbfB;
            case Place.TYPE_HOME_GOODS_STORE /* 49 */:
                return this.zzbfC;
            case 50:
                return this.zzbfD;
            case Place.TYPE_INSURANCE_AGENCY /* 51 */:
                return this.zzbfE;
            case Place.TYPE_JEWELRY_STORE /* 52 */:
                return this.zzbfF;
            case Place.TYPE_LAUNDRY /* 53 */:
                return this.zzJN;
            case Place.TYPE_LAWYER /* 54 */:
                return this.zzF;
            case Place.TYPE_LIBRARY /* 55 */:
                return this.zzbfG;
            case Place.TYPE_LIQUOR_STORE /* 56 */:
                return this.zzbfH;
        }
    }
}
