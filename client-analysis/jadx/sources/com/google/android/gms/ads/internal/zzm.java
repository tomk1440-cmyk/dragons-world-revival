package com.google.android.gms.ads.internal;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.applinks.AppLinkData;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzdf;
import com.google.android.gms.internal.zzes;
import com.google.android.gms.internal.zzfb;
import com.google.android.gms.internal.zzfc;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjp;
import com.google.android.gms.internal.zzjq;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzm {
    private static com.google.android.gms.ads.internal.formats.zzd zza(zzfb zzfbVar) throws RemoteException {
        return new com.google.android.gms.ads.internal.formats.zzd(zzfbVar.getHeadline(), zzfbVar.getImages(), zzfbVar.getBody(), zzfbVar.zzdK(), zzfbVar.getCallToAction(), zzfbVar.getStarRating(), zzfbVar.getStore(), zzfbVar.getPrice(), null, zzfbVar.getExtras());
    }

    private static com.google.android.gms.ads.internal.formats.zze zza(zzfc zzfcVar) throws RemoteException {
        return new com.google.android.gms.ads.internal.formats.zze(zzfcVar.getHeadline(), zzfcVar.getImages(), zzfcVar.getBody(), zzfcVar.zzdO(), zzfcVar.getCallToAction(), zzfcVar.getAdvertiser(), null, zzfcVar.getExtras());
    }

    static zzdf zza(final zzfb zzfbVar, final zzfc zzfcVar, final zzf.zza zzaVar) {
        return new zzdf() { // from class: com.google.android.gms.ads.internal.zzm.5
            @Override // com.google.android.gms.internal.zzdf
            public void zza(zzjp zzjpVar, Map<String, String> map) {
                View view = zzjpVar.getView();
                if (view == null) {
                    return;
                }
                try {
                    if (zzfbVar != null) {
                        if (zzfbVar.getOverrideClickHandling()) {
                            zzm.zza(zzjpVar);
                        } else {
                            zzfbVar.zzc(com.google.android.gms.dynamic.zze.zzC(view));
                            zzaVar.onClick();
                        }
                    } else if (zzfcVar != null) {
                        if (zzfcVar.getOverrideClickHandling()) {
                            zzm.zza(zzjpVar);
                        } else {
                            zzfcVar.zzc(com.google.android.gms.dynamic.zze.zzC(view));
                            zzaVar.onClick();
                        }
                    }
                } catch (RemoteException e) {
                    zzin.zzd("Unable to call handleClick on mapper", e);
                }
            }
        };
    }

    static zzdf zza(final CountDownLatch countDownLatch) {
        return new zzdf() { // from class: com.google.android.gms.ads.internal.zzm.3
            @Override // com.google.android.gms.internal.zzdf
            public void zza(zzjp zzjpVar, Map<String, String> map) {
                countDownLatch.countDown();
                View view = zzjpVar.getView();
                if (view == null) {
                    return;
                }
                view.setVisibility(0);
            }
        };
    }

    private static String zza(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap == null) {
            zzin.zzaK("Bitmap is null. Returning empty string");
            return "";
        }
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return "data:image/png;base64," + Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    static String zza(zzch zzchVar) {
        if (zzchVar == null) {
            zzin.zzaK("Image is null. Returning empty string");
            return "";
        }
        try {
            Uri uri = zzchVar.getUri();
            if (uri != null) {
                return uri.toString();
            }
        } catch (RemoteException e) {
            zzin.zzaK("Unable to get image uri. Trying data uri next");
        }
        return zzb(zzchVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject zza(Bundle bundle, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (bundle == null || TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject(str);
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (bundle.containsKey(next)) {
                if ("image".equals(jSONObject2.getString(next))) {
                    Object obj = bundle.get(next);
                    if (obj instanceof Bitmap) {
                        jSONObject.put(next, zza((Bitmap) obj));
                    } else {
                        zzin.zzaK("Invalid type. An image type extra should return a bitmap");
                    }
                } else if (bundle.get(next) instanceof Bitmap) {
                    zzin.zzaK("Invalid asset type. Bitmap should be returned only for image type");
                } else {
                    jSONObject.put(next, String.valueOf(bundle.get(next)));
                }
            }
        }
        return jSONObject;
    }

    public static void zza(zzif zzifVar, zzf.zza zzaVar) {
        if (zzg(zzifVar)) {
            zzjp zzjpVar = zzifVar.zzED;
            View view = zzjpVar.getView();
            if (view == null) {
                zzin.zzaK("AdWebView is null");
                return;
            }
            try {
                List<String> list = zzifVar.zzCp.zzBM;
                if (list == null || list.isEmpty()) {
                    zzin.zzaK("No template ids present in mediation response");
                    return;
                }
                zzfb zzfbVarZzeF = zzifVar.zzCq.zzeF();
                zzfc zzfcVarZzeG = zzifVar.zzCq.zzeG();
                if (list.contains("2") && zzfbVarZzeF != null) {
                    zzfbVarZzeF.zzd(com.google.android.gms.dynamic.zze.zzC(view));
                    if (!zzfbVarZzeF.getOverrideImpressionRecording()) {
                        zzfbVarZzeF.recordImpression();
                    }
                    zzjpVar.zzhU().zza("/nativeExpressViewClicked", zza(zzfbVarZzeF, (zzfc) null, zzaVar));
                    return;
                }
                if (!list.contains(AppEventsConstants.EVENT_PARAM_VALUE_YES) || zzfcVarZzeG == null) {
                    zzin.zzaK("No matching template id and mapper");
                    return;
                }
                zzfcVarZzeG.zzd(com.google.android.gms.dynamic.zze.zzC(view));
                if (!zzfcVarZzeG.getOverrideImpressionRecording()) {
                    zzfcVarZzeG.recordImpression();
                }
                zzjpVar.zzhU().zza("/nativeExpressViewClicked", zza((zzfb) null, zzfcVarZzeG, zzaVar));
            } catch (RemoteException e) {
                zzin.zzd("Error occurred while recording impression and registering for clicks", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(zzjp zzjpVar) {
        View.OnClickListener onClickListenerZzif = zzjpVar.zzif();
        if (onClickListenerZzif != null) {
            onClickListenerZzif.onClick(zzjpVar.getView());
        }
    }

    private static void zza(final zzjp zzjpVar, final com.google.android.gms.ads.internal.formats.zzd zzdVar, final String str) {
        zzjpVar.zzhU().zza(new zzjq.zza() { // from class: com.google.android.gms.ads.internal.zzm.1
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // com.google.android.gms.internal.zzjq.zza
            public void zza(zzjp zzjpVar2, boolean z) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("headline", zzdVar.getHeadline());
                    jSONObject.put("body", zzdVar.getBody());
                    jSONObject.put("call_to_action", zzdVar.getCallToAction());
                    jSONObject.put(InAppPurchaseMetaData.KEY_PRICE, zzdVar.getPrice());
                    jSONObject.put("star_rating", String.valueOf(zzdVar.getStarRating()));
                    jSONObject.put("store", zzdVar.getStore());
                    jSONObject.put(SettingsJsonConstants.APP_ICON_KEY, zzm.zza(zzdVar.zzdK()));
                    JSONArray jSONArray = new JSONArray();
                    List images = zzdVar.getImages();
                    if (images != null) {
                        Iterator it = images.iterator();
                        while (it.hasNext()) {
                            jSONArray.put(zzm.zza(zzm.zzc(it.next())));
                        }
                    }
                    jSONObject.put("images", jSONArray);
                    jSONObject.put(AppLinkData.ARGUMENTS_EXTRAS_KEY, zzm.zza(zzdVar.getExtras(), str));
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("assets", jSONObject);
                    jSONObject2.put("template_id", "2");
                    zzjpVar.zza("google.afma.nativeExpressAds.loadAssets", jSONObject2);
                } catch (JSONException e) {
                    zzin.zzd("Exception occurred when loading assets", e);
                }
            }
        });
    }

    private static void zza(final zzjp zzjpVar, final com.google.android.gms.ads.internal.formats.zze zzeVar, final String str) {
        zzjpVar.zzhU().zza(new zzjq.zza() { // from class: com.google.android.gms.ads.internal.zzm.2
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // com.google.android.gms.internal.zzjq.zza
            public void zza(zzjp zzjpVar2, boolean z) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("headline", zzeVar.getHeadline());
                    jSONObject.put("body", zzeVar.getBody());
                    jSONObject.put("call_to_action", zzeVar.getCallToAction());
                    jSONObject.put("advertiser", zzeVar.getAdvertiser());
                    jSONObject.put("logo", zzm.zza(zzeVar.zzdO()));
                    JSONArray jSONArray = new JSONArray();
                    List images = zzeVar.getImages();
                    if (images != null) {
                        Iterator it = images.iterator();
                        while (it.hasNext()) {
                            jSONArray.put(zzm.zza(zzm.zzc(it.next())));
                        }
                    }
                    jSONObject.put("images", jSONArray);
                    jSONObject.put(AppLinkData.ARGUMENTS_EXTRAS_KEY, zzm.zza(zzeVar.getExtras(), str));
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("assets", jSONObject);
                    jSONObject2.put("template_id", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                    zzjpVar.zza("google.afma.nativeExpressAds.loadAssets", jSONObject2);
                } catch (JSONException e) {
                    zzin.zzd("Exception occurred when loading assets", e);
                }
            }
        });
    }

    private static void zza(zzjp zzjpVar, CountDownLatch countDownLatch) {
        zzjpVar.zzhU().zza("/nativeExpressAssetsLoaded", zza(countDownLatch));
        zzjpVar.zzhU().zza("/nativeExpressAssetsLoadingFailed", zzb(countDownLatch));
    }

    public static boolean zza(zzjp zzjpVar, zzes zzesVar, CountDownLatch countDownLatch) {
        boolean zZzb = false;
        try {
            zZzb = zzb(zzjpVar, zzesVar, countDownLatch);
        } catch (RemoteException e) {
            zzin.zzd("Unable to invoke load assets", e);
        } catch (RuntimeException e2) {
            countDownLatch.countDown();
            throw e2;
        }
        if (!zZzb) {
            countDownLatch.countDown();
        }
        return zZzb;
    }

    static zzdf zzb(final CountDownLatch countDownLatch) {
        return new zzdf() { // from class: com.google.android.gms.ads.internal.zzm.4
            @Override // com.google.android.gms.internal.zzdf
            public void zza(zzjp zzjpVar, Map<String, String> map) {
                zzin.zzaK("Adapter returned an ad, but assets substitution failed");
                countDownLatch.countDown();
                zzjpVar.destroy();
            }
        };
    }

    private static String zzb(zzch zzchVar) {
        String strZza;
        try {
            com.google.android.gms.dynamic.zzd zzdVarZzdJ = zzchVar.zzdJ();
            if (zzdVarZzdJ == null) {
                zzin.zzaK("Drawable is null. Returning empty string");
                strZza = "";
            } else {
                Drawable drawable = (Drawable) com.google.android.gms.dynamic.zze.zzp(zzdVarZzdJ);
                if (drawable instanceof BitmapDrawable) {
                    strZza = zza(((BitmapDrawable) drawable).getBitmap());
                } else {
                    zzin.zzaK("Drawable is not an instance of BitmapDrawable. Returning empty string");
                    strZza = "";
                }
            }
            return strZza;
        } catch (RemoteException e) {
            zzin.zzaK("Unable to get drawable. Returning empty string");
            return "";
        }
    }

    private static boolean zzb(zzjp zzjpVar, zzes zzesVar, CountDownLatch countDownLatch) throws RemoteException {
        View view = zzjpVar.getView();
        if (view == null) {
            zzin.zzaK("AdWebView is null");
            return false;
        }
        view.setVisibility(4);
        List<String> list = zzesVar.zzCp.zzBM;
        if (list == null || list.isEmpty()) {
            zzin.zzaK("No template ids present in mediation response");
            return false;
        }
        zza(zzjpVar, countDownLatch);
        zzfb zzfbVarZzeF = zzesVar.zzCq.zzeF();
        zzfc zzfcVarZzeG = zzesVar.zzCq.zzeG();
        if (list.contains("2") && zzfbVarZzeF != null) {
            zza(zzjpVar, zza(zzfbVarZzeF), zzesVar.zzCp.zzBL);
        } else {
            if (!list.contains(AppEventsConstants.EVENT_PARAM_VALUE_YES) || zzfcVarZzeG == null) {
                zzin.zzaK("No matching template id and mapper");
                return false;
            }
            zza(zzjpVar, zza(zzfcVarZzeG), zzesVar.zzCp.zzBL);
        }
        String str = zzesVar.zzCp.zzBJ;
        String str2 = zzesVar.zzCp.zzBK;
        if (str2 != null) {
            zzjpVar.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
        } else {
            zzjpVar.loadData(str, "text/html", "UTF-8");
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzch zzc(Object obj) {
        if (obj instanceof IBinder) {
            return zzch.zza.zzt((IBinder) obj);
        }
        return null;
    }

    public static View zzf(zzif zzifVar) {
        View view;
        if (zzifVar == null) {
            zzin.e("AdState is null");
            return null;
        }
        if (zzg(zzifVar)) {
            return zzifVar.zzED.getView();
        }
        try {
            com.google.android.gms.dynamic.zzd view2 = zzifVar.zzCq.getView();
            if (view2 == null) {
                zzin.zzaK("View in mediation adapter is null.");
                view = null;
            } else {
                view = (View) com.google.android.gms.dynamic.zze.zzp(view2);
            }
            return view;
        } catch (RemoteException e) {
            zzin.zzd("Could not get View from mediation adapter.", e);
            return null;
        }
    }

    public static boolean zzg(zzif zzifVar) {
        return (zzifVar == null || !zzifVar.zzHT || zzifVar.zzCp == null || zzifVar.zzCp.zzBJ == null) ? false : true;
    }
}
