package com.google.android.gms.vision.barcode;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import android.support.v4.widget.ExploreByTouchHelper;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.Strategy;

/* JADX INFO: loaded from: classes.dex */
public class Barcode implements SafeParcelable {
    public static final int ALL_FORMATS = 0;
    public static final int AZTEC = 4096;
    public static final int CALENDAR_EVENT = 11;
    public static final int CODABAR = 8;
    public static final int CODE_128 = 1;
    public static final int CODE_39 = 2;
    public static final int CODE_93 = 4;
    public static final int CONTACT_INFO = 1;
    public static final zzb CREATOR = new zzb();
    public static final int DATA_MATRIX = 16;
    public static final int DRIVER_LICENSE = 12;
    public static final int EAN_13 = 32;
    public static final int EAN_8 = 64;
    public static final int EMAIL = 2;
    public static final int GEO = 10;
    public static final int ISBN = 3;
    public static final int ITF = 128;
    public static final int PDF417 = 2048;
    public static final int PHONE = 4;
    public static final int PRODUCT = 5;
    public static final int QR_CODE = 256;
    public static final int SMS = 6;
    public static final int TEXT = 7;
    public static final int UPC_A = 512;
    public static final int UPC_E = 1024;
    public static final int URL = 8;
    public static final int WIFI = 9;
    public CalendarEvent calendarEvent;
    public ContactInfo contactInfo;
    public Point[] cornerPoints;
    public String displayValue;
    public DriverLicense driverLicense;
    public Email email;
    public int format;
    public GeoPoint geoPoint;
    public Phone phone;
    public String rawValue;
    public Sms sms;
    public UrlBookmark url;
    public int valueFormat;
    final int versionCode;
    public WiFi wifi;

    public static class Address implements SafeParcelable {
        public static final zza CREATOR = new zza();
        public static final int HOME = 2;
        public static final int UNKNOWN = 0;
        public static final int WORK = 1;
        public String[] addressLines;
        public int type;
        final int versionCode;

        public Address() {
            this.versionCode = 1;
        }

        public Address(int versionCode, int type, String[] addressLines) {
            this.versionCode = versionCode;
            this.type = type;
            this.addressLines = addressLines;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zza zzaVar = CREATOR;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            zza zzaVar = CREATOR;
            zza.zza(this, parcel, flags);
        }
    }

    public static class CalendarDateTime implements SafeParcelable {
        public static final zzc CREATOR = new zzc();
        public int day;
        public int hours;
        public boolean isUtc;
        public int minutes;
        public int month;
        public String rawValue;
        public int seconds;
        final int versionCode;
        public int year;

        public CalendarDateTime() {
            this.versionCode = 1;
        }

        public CalendarDateTime(int versionCode, int year, int month, int day, int hours, int minutes, int seconds, boolean isUtc, String rawValue) {
            this.versionCode = versionCode;
            this.year = year;
            this.month = month;
            this.day = day;
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
            this.isUtc = isUtc;
            this.rawValue = rawValue;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzc zzcVar = CREATOR;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            zzc zzcVar = CREATOR;
            zzc.zza(this, parcel, flags);
        }
    }

    public static class CalendarEvent implements SafeParcelable {
        public static final zzd CREATOR = new zzd();
        public String description;
        public CalendarDateTime end;
        public String location;
        public String organizer;
        public CalendarDateTime start;
        public String status;
        public String summary;
        final int versionCode;

        public CalendarEvent() {
            this.versionCode = 1;
        }

        public CalendarEvent(int versionCode, String summary, String description, String location, String organizer, String status, CalendarDateTime start, CalendarDateTime end) {
            this.versionCode = versionCode;
            this.summary = summary;
            this.description = description;
            this.location = location;
            this.organizer = organizer;
            this.status = status;
            this.start = start;
            this.end = end;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzd zzdVar = CREATOR;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            zzd zzdVar = CREATOR;
            zzd.zza(this, parcel, flags);
        }
    }

    public static class ContactInfo implements SafeParcelable {
        public static final zze CREATOR = new zze();
        public Address[] addresses;
        public Email[] emails;
        public PersonName name;
        public String organization;
        public Phone[] phones;
        public String title;
        public String[] urls;
        final int versionCode;

        public ContactInfo() {
            this.versionCode = 1;
        }

        public ContactInfo(int versionCode, PersonName name, String organization, String title, Phone[] phones, Email[] emails, String[] urls, Address[] addresses) {
            this.versionCode = versionCode;
            this.name = name;
            this.organization = organization;
            this.title = title;
            this.phones = phones;
            this.emails = emails;
            this.urls = urls;
            this.addresses = addresses;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zze zzeVar = CREATOR;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            zze zzeVar = CREATOR;
            zze.zza(this, parcel, flags);
        }
    }

    public static class DriverLicense implements SafeParcelable {
        public static final zzf CREATOR = new zzf();
        public String addressCity;
        public String addressState;
        public String addressStreet;
        public String addressZip;
        public String birthDate;
        public String documentType;
        public String expiryDate;
        public String firstName;
        public String gender;
        public String issueDate;
        public String issuingCountry;
        public String lastName;
        public String licenseNumber;
        public String middleName;
        final int versionCode;

        public DriverLicense() {
            this.versionCode = 1;
        }

        public DriverLicense(int versionCode, String documentType, String firstName, String middleName, String lastName, String gender, String addressStreet, String addressCity, String addressState, String addressZip, String licenseNumber, String issueDate, String expiryDate, String birthDate, String issuingCountry) {
            this.versionCode = versionCode;
            this.documentType = documentType;
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
            this.gender = gender;
            this.addressStreet = addressStreet;
            this.addressCity = addressCity;
            this.addressState = addressState;
            this.addressZip = addressZip;
            this.licenseNumber = licenseNumber;
            this.issueDate = issueDate;
            this.expiryDate = expiryDate;
            this.birthDate = birthDate;
            this.issuingCountry = issuingCountry;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzf zzfVar = CREATOR;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            zzf zzfVar = CREATOR;
            zzf.zza(this, parcel, flags);
        }
    }

    public static class Email implements SafeParcelable {
        public static final zzg CREATOR = new zzg();
        public static final int HOME = 2;
        public static final int UNKNOWN = 0;
        public static final int WORK = 1;
        public String address;
        public String body;
        public String subject;
        public int type;
        final int versionCode;

        public Email() {
            this.versionCode = 1;
        }

        public Email(int versionCode, int type, String address, String subject, String body) {
            this.versionCode = versionCode;
            this.type = type;
            this.address = address;
            this.subject = subject;
            this.body = body;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzg zzgVar = CREATOR;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            zzg zzgVar = CREATOR;
            zzg.zza(this, parcel, flags);
        }
    }

    public static class GeoPoint implements SafeParcelable {
        public static final zzh CREATOR = new zzh();
        public double lat;
        public double lng;
        final int versionCode;

        public GeoPoint() {
            this.versionCode = 1;
        }

        public GeoPoint(int versionCode, double lat, double lng) {
            this.versionCode = versionCode;
            this.lat = lat;
            this.lng = lng;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzh zzhVar = CREATOR;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            zzh zzhVar = CREATOR;
            zzh.zza(this, parcel, flags);
        }
    }

    public static class PersonName implements SafeParcelable {
        public static final zzi CREATOR = new zzi();
        public String first;
        public String formattedName;
        public String last;
        public String middle;
        public String prefix;
        public String pronunciation;
        public String suffix;
        final int versionCode;

        public PersonName() {
            this.versionCode = 1;
        }

        public PersonName(int versionCode, String formattedName, String pronunciation, String prefix, String first, String middle, String last, String suffix) {
            this.versionCode = versionCode;
            this.formattedName = formattedName;
            this.pronunciation = pronunciation;
            this.prefix = prefix;
            this.first = first;
            this.middle = middle;
            this.last = last;
            this.suffix = suffix;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzi zziVar = CREATOR;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            zzi zziVar = CREATOR;
            zzi.zza(this, parcel, flags);
        }
    }

    public static class Phone implements SafeParcelable {
        public static final zzj CREATOR = new zzj();
        public static final int FAX = 3;
        public static final int HOME = 2;
        public static final int MOBILE = 4;
        public static final int UNKNOWN = 0;
        public static final int WORK = 1;
        public String number;
        public int type;
        final int versionCode;

        public Phone() {
            this.versionCode = 1;
        }

        public Phone(int versionCode, int type, String number) {
            this.versionCode = versionCode;
            this.type = type;
            this.number = number;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzj zzjVar = CREATOR;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            zzj zzjVar = CREATOR;
            zzj.zza(this, parcel, flags);
        }
    }

    public static class Sms implements SafeParcelable {
        public static final zzk CREATOR = new zzk();
        public String message;
        public String phoneNumber;
        final int versionCode;

        public Sms() {
            this.versionCode = 1;
        }

        public Sms(int versionCode, String message, String phoneNumber) {
            this.versionCode = versionCode;
            this.message = message;
            this.phoneNumber = phoneNumber;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzk zzkVar = CREATOR;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            zzk zzkVar = CREATOR;
            zzk.zza(this, parcel, flags);
        }
    }

    public static class UrlBookmark implements SafeParcelable {
        public static final zzl CREATOR = new zzl();
        public String title;
        public String url;
        final int versionCode;

        public UrlBookmark() {
            this.versionCode = 1;
        }

        public UrlBookmark(int versionCode, String title, String url) {
            this.versionCode = versionCode;
            this.title = title;
            this.url = url;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzl zzlVar = CREATOR;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            zzl zzlVar = CREATOR;
            zzl.zza(this, parcel, flags);
        }
    }

    public static class WiFi implements SafeParcelable {
        public static final zzm CREATOR = new zzm();
        public static final int OPEN = 1;
        public static final int WEP = 3;
        public static final int WPA = 2;
        public int encryptionType;
        public String password;
        public String ssid;
        final int versionCode;

        public WiFi() {
            this.versionCode = 1;
        }

        public WiFi(int versionCode, String ssid, String password, int encryptionType) {
            this.versionCode = versionCode;
            this.ssid = ssid;
            this.password = password;
            this.encryptionType = encryptionType;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzm zzmVar = CREATOR;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            zzm zzmVar = CREATOR;
            zzm.zza(this, parcel, flags);
        }
    }

    public Barcode() {
        this.versionCode = 1;
    }

    public Barcode(int versionCode, int format, String rawValue, String displayValue, int valueFormat, Point[] cornerPoints, Email email, Phone phone, Sms sms, WiFi wifi, UrlBookmark url, GeoPoint geoPoint, CalendarEvent calendarEvent, ContactInfo contactInfo, DriverLicense driverLicense) {
        this.versionCode = versionCode;
        this.format = format;
        this.rawValue = rawValue;
        this.displayValue = displayValue;
        this.valueFormat = valueFormat;
        this.cornerPoints = cornerPoints;
        this.email = email;
        this.phone = phone;
        this.sms = sms;
        this.wifi = wifi;
        this.url = url;
        this.geoPoint = geoPoint;
        this.calendarEvent = calendarEvent;
        this.contactInfo = contactInfo;
        this.driverLicense = driverLicense;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzb zzbVar = CREATOR;
        return 0;
    }

    public Rect getBoundingBox() {
        int iMin = Strategy.TTL_SECONDS_INFINITE;
        int iMax = ExploreByTouchHelper.INVALID_ID;
        int iMax2 = Integer.MIN_VALUE;
        int iMin2 = Integer.MAX_VALUE;
        for (int i = 0; i < this.cornerPoints.length; i++) {
            Point point = this.cornerPoints[i];
            iMin2 = Math.min(iMin2, point.x);
            iMax2 = Math.max(iMax2, point.x);
            iMin = Math.min(iMin, point.y);
            iMax = Math.max(iMax, point.y);
        }
        return new Rect(iMin2, iMin, iMax2, iMax);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        zzb zzbVar = CREATOR;
        zzb.zza(this, parcel, flags);
    }
}
