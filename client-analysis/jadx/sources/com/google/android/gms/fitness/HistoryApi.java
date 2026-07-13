package com.google.android.gms.fitness;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataUpdateRequest;
import com.google.android.gms.fitness.result.DailyTotalResult;
import com.google.android.gms.fitness.result.DataReadResult;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public interface HistoryApi {

    public static class ViewIntentBuilder {
        private final Context mContext;
        private long zzRD;
        private final DataType zzavT;
        private DataSource zzavU;
        private long zzavV;
        private String zzavW;

        public ViewIntentBuilder(Context context, DataType dataType) {
            this.mContext = context;
            this.zzavT = dataType;
        }

        private Intent zzl(Intent intent) {
            Intent intent2;
            ResolveInfo resolveInfoResolveActivity;
            if (this.zzavW == null || (resolveInfoResolveActivity = this.mContext.getPackageManager().resolveActivity((intent2 = new Intent(intent).setPackage(this.zzavW)), 0)) == null) {
                return intent;
            }
            intent2.setComponent(new ComponentName(this.zzavW, resolveInfoResolveActivity.activityInfo.name));
            return intent2;
        }

        public Intent build() {
            zzx.zza(this.zzRD > 0, "Start time must be set");
            zzx.zza(this.zzavV > this.zzRD, "End time must be set and after start time");
            Intent intent = new Intent(Fitness.ACTION_VIEW);
            intent.setType(DataType.getMimeType(this.zzavU.getDataType()));
            intent.putExtra(Fitness.EXTRA_START_TIME, this.zzRD);
            intent.putExtra(Fitness.EXTRA_END_TIME, this.zzavV);
            zzc.zza(this.zzavU, intent, DataSource.EXTRA_DATA_SOURCE);
            return zzl(intent);
        }

        public ViewIntentBuilder setDataSource(DataSource dataSource) {
            zzx.zzb(dataSource.getDataType().equals(this.zzavT), "Data source %s is not for the data type %s", dataSource, this.zzavT);
            this.zzavU = dataSource;
            return this;
        }

        public ViewIntentBuilder setPreferredApplication(String packageName) {
            this.zzavW = packageName;
            return this;
        }

        public ViewIntentBuilder setTimeInterval(long start, long end, TimeUnit timeUnit) {
            this.zzRD = timeUnit.toMillis(start);
            this.zzavV = timeUnit.toMillis(end);
            return this;
        }
    }

    PendingResult<Status> deleteData(GoogleApiClient googleApiClient, DataDeleteRequest dataDeleteRequest);

    PendingResult<Status> insertData(GoogleApiClient googleApiClient, DataSet dataSet);

    @RequiresPermission(anyOf = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.BODY_SENSORS"}, conditional = true)
    PendingResult<DailyTotalResult> readDailyTotal(GoogleApiClient googleApiClient, DataType dataType);

    @RequiresPermission(anyOf = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.BODY_SENSORS"}, conditional = true)
    PendingResult<DataReadResult> readData(GoogleApiClient googleApiClient, DataReadRequest dataReadRequest);

    PendingResult<Status> updateData(GoogleApiClient googleApiClient, DataUpdateRequest dataUpdateRequest);
}
