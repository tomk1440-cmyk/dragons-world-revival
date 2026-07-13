package com.prime31.util;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.android.vending.billing.IInAppBillingService;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class IabHelperImpl {
    public static final int BILLING_RESPONSE_RESULT_BILLING_UNAVAILABLE = 3;
    public static final int BILLING_RESPONSE_RESULT_DEVELOPER_ERROR = 5;
    public static final int BILLING_RESPONSE_RESULT_ERROR = 6;
    public static final int BILLING_RESPONSE_RESULT_ITEM_ALREADY_OWNED = 7;
    public static final int BILLING_RESPONSE_RESULT_ITEM_NOT_OWNED = 8;
    public static final int BILLING_RESPONSE_RESULT_ITEM_UNAVAILABLE = 4;
    public static final int BILLING_RESPONSE_RESULT_OK = 0;
    public static final int BILLING_RESPONSE_RESULT_SERVICE_UNAVAILABLE = 2;
    public static final int BILLING_RESPONSE_RESULT_USER_CANCELED = 1;
    public static final String GET_SKU_DETAILS_ITEM_LIST = "ITEM_ID_LIST";
    public static final String GET_SKU_DETAILS_ITEM_TYPE_LIST = "ITEM_TYPE_LIST";
    public static final int IABHELPER_BAD_RESPONSE = -1002;
    public static final int IABHELPER_ERROR_BASE = -1000;
    public static final int IABHELPER_INVALID_CONSUMPTION = -1010;
    public static final int IABHELPER_MISSING_TOKEN = -1007;
    public static final int IABHELPER_REMOTE_EXCEPTION = -1001;
    public static final int IABHELPER_SEND_INTENT_FAILED = -1004;
    public static final int IABHELPER_SUBSCRIPTIONS_NOT_AVAILABLE = -1009;
    public static final int IABHELPER_SUBSCRIPTION_UPDATE_NOT_AVAILABLE = -1011;
    public static final int IABHELPER_UNKNOWN_ERROR = -1008;
    public static final int IABHELPER_UNKNOWN_PURCHASE_RESPONSE = -1006;
    public static final int IABHELPER_USER_CANCELLED = -1005;
    public static final int IABHELPER_VERIFICATION_FAILED = -1003;
    public static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";
    public static final String ITEM_TYPE_INAPP = "inapp";
    public static final String ITEM_TYPE_SUBS = "subs";
    public static final String RESPONSE_BUY_INTENT = "BUY_INTENT";
    public static final String RESPONSE_CODE = "RESPONSE_CODE";
    public static final String RESPONSE_GET_SKU_DETAILS_LIST = "DETAILS_LIST";
    public static final String RESPONSE_INAPP_ITEM_LIST = "INAPP_PURCHASE_ITEM_LIST";
    public static final String RESPONSE_INAPP_PURCHASE_DATA = "INAPP_PURCHASE_DATA";
    public static final String RESPONSE_INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
    public static final String RESPONSE_INAPP_SIGNATURE = "INAPP_DATA_SIGNATURE";
    public static final String RESPONSE_INAPP_SIGNATURE_LIST = "INAPP_DATA_SIGNATURE_LIST";
    public static boolean autoVerifySignatures = true;
    Context mContext;
    OnIabPurchaseFinishedListener mPurchaseListener;
    String mPurchasingItemType;
    int mRequestCode;
    IInAppBillingService mService;
    ServiceConnection mServiceConn;
    String mSignatureBase64;
    boolean mDebugLog = false;
    String mDebugTag = "Prime31-IABH";
    boolean mSetupDone = false;
    boolean mDisposed = false;
    boolean mDisposeAfterAsync = false;
    boolean mSubscriptionsSupported = false;
    boolean mSubscriptionUpdateSupported = false;
    boolean mAsyncInProgress = false;
    private final Object mAsyncInProgressLock = new Object();
    String mAsyncOperation = "";

    public interface OnConsumeFinishedListener {
        void onConsumeFinished(Purchase purchase, IabResult iabResult);
    }

    public interface OnConsumeMultiFinishedListener {
        void onConsumeMultiFinished(List<Purchase> list, List<IabResult> list2);
    }

    public interface OnIabPurchaseFinishedListener {
        void onIabPurchaseCompleteAwaitingVerification(String str, String str2);

        void onIabPurchaseFinished(IabResult iabResult, Purchase purchase);
    }

    public interface OnIabSetupFinishedListener {
        void onIabSetupFinished(IabResult iabResult);
    }

    public interface QueryInventoryFinishedListener {
        void onQueryInventoryFinished(IabResult iabResult, Inventory inventory);
    }

    public IabHelperImpl(Context ctx, String base64PublicKey) {
        this.mSignatureBase64 = null;
        this.mContext = ctx.getApplicationContext();
        this.mSignatureBase64 = base64PublicKey;
        logDebug("IAB helper created.");
    }

    public void enableDebugLogging(boolean enable, String tag) {
        checkNotDisposed();
        this.mDebugLog = enable;
        this.mDebugTag = tag;
    }

    public void enableDebugLogging(boolean enable) {
        checkNotDisposed();
        this.mDebugLog = enable;
    }

    public void startSetup(final OnIabSetupFinishedListener listener) {
        checkNotDisposed();
        if (this.mSetupDone) {
            throw new IllegalStateException("IAB helper is already set up.");
        }
        logDebug("Starting in-app billing setup.");
        this.mServiceConn = new ServiceConnection() { // from class: com.prime31.util.IabHelperImpl.1
            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
                IabHelperImpl.this.logDebug("Billing service disconnected.");
                IabHelperImpl.this.mService = null;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder service) {
                if (!IabHelperImpl.this.mDisposed) {
                    IabHelperImpl.this.logDebug("Billing service connected.");
                    IabHelperImpl.this.mService = IInAppBillingService.Stub.asInterface(service);
                    String packageName = IabHelperImpl.this.mContext.getPackageName();
                    try {
                        IabHelperImpl.this.logDebug("Checking for in-app billing 3 support.");
                        int response = IabHelperImpl.this.mService.isBillingSupported(3, packageName, IabHelperImpl.ITEM_TYPE_INAPP);
                        if (response != 0) {
                            if (listener != null) {
                                listener.onIabSetupFinished(new IabResult(response, "Error checking for billing v3 support."));
                            }
                            IabHelperImpl.this.mSubscriptionsSupported = false;
                            IabHelperImpl.this.mSubscriptionUpdateSupported = false;
                            return;
                        }
                        IabHelperImpl.this.logDebug("In-app billing version 3 supported for " + packageName);
                        if (IabHelperImpl.this.mService.isBillingSupported(5, packageName, IabHelperImpl.ITEM_TYPE_SUBS) == 0) {
                            IabHelperImpl.this.logDebug("Subscription re-signup AVAILABLE.");
                            IabHelperImpl.this.mSubscriptionUpdateSupported = true;
                        } else {
                            IabHelperImpl.this.logDebug("Subscription re-signup not available.");
                            IabHelperImpl.this.mSubscriptionUpdateSupported = false;
                        }
                        if (IabHelperImpl.this.mSubscriptionUpdateSupported) {
                            IabHelperImpl.this.mSubscriptionsSupported = true;
                        } else {
                            int response2 = IabHelperImpl.this.mService.isBillingSupported(3, packageName, IabHelperImpl.ITEM_TYPE_SUBS);
                            if (response2 == 0) {
                                IabHelperImpl.this.logDebug("Subscriptions AVAILABLE.");
                                IabHelperImpl.this.mSubscriptionsSupported = true;
                            } else {
                                IabHelperImpl.this.logDebug("Subscriptions NOT AVAILABLE. Response: " + response2);
                                IabHelperImpl.this.mSubscriptionsSupported = false;
                                IabHelperImpl.this.mSubscriptionUpdateSupported = false;
                            }
                        }
                        IabHelperImpl.this.mSetupDone = true;
                        if (listener != null) {
                            listener.onIabSetupFinished(new IabResult(0, "Setup successful."));
                        }
                    } catch (RemoteException e) {
                        if (listener != null) {
                            listener.onIabSetupFinished(new IabResult(IabHelperImpl.IABHELPER_REMOTE_EXCEPTION, "RemoteException while setting up in-app billing."));
                        }
                        e.printStackTrace();
                    }
                }
            }
        };
        Log.i(this.mDebugTag, "setting Intent package to com.android.vending");
        Intent serviceIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        serviceIntent.setPackage("com.android.vending");
        List<ResolveInfo> intentServices = this.mContext.getPackageManager().queryIntentServices(serviceIntent, 0);
        if (intentServices != null && !intentServices.isEmpty()) {
            this.mContext.bindService(serviceIntent, this.mServiceConn, 1);
        } else if (listener != null) {
            listener.onIabSetupFinished(new IabResult(3, "Billing service unavailable on device."));
        }
    }

    public void dispose() throws IabAsyncInProgressException {
        synchronized (this.mAsyncInProgressLock) {
            if (this.mAsyncInProgress) {
                throw new IabAsyncInProgressException("Can't dispose because an async operation (" + this.mAsyncOperation + ") is in progress.");
            }
        }
        logDebug("Disposing.");
        this.mSetupDone = false;
        if (this.mServiceConn != null) {
            logDebug("Unbinding from service.");
            if (this.mContext != null) {
                this.mContext.unbindService(this.mServiceConn);
            }
        }
        this.mDisposed = true;
        this.mContext = null;
        this.mServiceConn = null;
        this.mService = null;
        this.mPurchaseListener = null;
    }

    public void disposeWhenFinished() {
        synchronized (this.mAsyncInProgressLock) {
            if (this.mAsyncInProgress) {
                logDebug("Will dispose after async operation finishes.");
                this.mDisposeAfterAsync = true;
            } else {
                try {
                    dispose();
                } catch (IabAsyncInProgressException e) {
                }
            }
        }
    }

    private void checkNotDisposed() {
        if (this.mDisposed) {
            throw new IllegalStateException("IabHelper was disposed of, so it cannot be used.");
        }
    }

    public boolean subscriptionsSupported() {
        checkNotDisposed();
        return this.mSubscriptionsSupported;
    }

    public void launchPurchaseFlow(Activity act, String sku, int requestCode, OnIabPurchaseFinishedListener listener) throws IabAsyncInProgressException {
        launchPurchaseFlow(act, sku, requestCode, listener, "");
    }

    public void launchPurchaseFlow(Activity act, String sku, int requestCode, OnIabPurchaseFinishedListener listener, String extraData) throws IabAsyncInProgressException {
        launchPurchaseFlow(act, sku, ITEM_TYPE_INAPP, null, requestCode, listener, extraData);
    }

    public void launchSubscriptionPurchaseFlow(Activity act, String sku, int requestCode, OnIabPurchaseFinishedListener listener) throws IabAsyncInProgressException {
        launchSubscriptionPurchaseFlow(act, sku, requestCode, listener, "");
    }

    public void launchSubscriptionPurchaseFlow(Activity act, String sku, int requestCode, OnIabPurchaseFinishedListener listener, String extraData) throws IabAsyncInProgressException {
        launchPurchaseFlow(act, sku, ITEM_TYPE_SUBS, null, requestCode, listener, extraData);
    }

    public boolean launchPurchaseFlow(Activity act, String sku, String itemType, List<String> oldSkus, int requestCode, OnIabPurchaseFinishedListener listener, String extraData) throws IabAsyncInProgressException {
        Bundle buyIntentBundle;
        checkNotDisposed();
        checkSetupDone("launchPurchaseFlow");
        flagStartAsync("launchPurchaseFlow");
        if (itemType.equals(ITEM_TYPE_SUBS) && !this.mSubscriptionsSupported) {
            IabResult r = new IabResult(IABHELPER_SUBSCRIPTIONS_NOT_AVAILABLE, "Subscriptions are not available.");
            flagEndAsync();
            if (listener != null) {
                listener.onIabPurchaseFinished(r, null);
            }
            return false;
        }
        try {
            logDebug("Constructing buy intent for " + sku + ", item type: " + itemType);
            if (oldSkus == null || oldSkus.isEmpty()) {
                buyIntentBundle = this.mService.getBuyIntent(3, this.mContext.getPackageName(), sku, itemType, extraData);
            } else {
                if (!this.mSubscriptionUpdateSupported) {
                    IabResult r2 = new IabResult(IABHELPER_SUBSCRIPTION_UPDATE_NOT_AVAILABLE, "Subscription updates are not available.");
                    flagEndAsync();
                    if (listener != null) {
                        listener.onIabPurchaseFinished(r2, null);
                    }
                    return false;
                }
                buyIntentBundle = this.mService.getBuyIntentToReplaceSkus(5, this.mContext.getPackageName(), oldSkus, sku, itemType, extraData);
            }
            int response = getResponseCodeFromBundle(buyIntentBundle);
            if (response != 0) {
                logError("Unable to buy item, Error response: " + getResponseDesc(response));
                flagEndAsync();
                IabResult result = new IabResult(response, "Unable to buy item");
                if (listener != null) {
                    listener.onIabPurchaseFinished(result, null);
                }
                return false;
            }
            PendingIntent pendingIntent = (PendingIntent) buyIntentBundle.getParcelable(RESPONSE_BUY_INTENT);
            logDebug("Launching buy intent for " + sku + ". Request code: " + requestCode);
            this.mRequestCode = requestCode;
            this.mPurchaseListener = listener;
            this.mPurchasingItemType = itemType;
            IntentSender intentSender = pendingIntent.getIntentSender();
            Intent intent = new Intent();
            Integer num = 0;
            int iIntValue = num.intValue();
            Integer num2 = 0;
            int iIntValue2 = num2.intValue();
            Integer num3 = 0;
            act.startIntentSenderForResult(intentSender, requestCode, intent, iIntValue, iIntValue2, num3.intValue());
            return true;
        } catch (IntentSender.SendIntentException e) {
            logError("SendIntentException while launching purchase flow for sku " + sku);
            e.printStackTrace();
            flagEndAsync();
            IabResult result2 = new IabResult(IABHELPER_SEND_INTENT_FAILED, "Failed to send intent.");
            if (listener != null) {
                listener.onIabPurchaseFinished(result2, null);
            }
        } catch (RemoteException e2) {
            logError("RemoteException while launching purchase flow for sku " + sku);
            e2.printStackTrace();
            flagEndAsync();
            IabResult result3 = new IabResult(IABHELPER_REMOTE_EXCEPTION, "Remote exception while starting purchase flow");
            if (listener != null) {
                listener.onIabPurchaseFinished(result3, null);
            }
        }
    }

    public boolean handleActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != this.mRequestCode) {
            return false;
        }
        checkNotDisposed();
        checkSetupDone("handleActivityResult");
        flagEndAsync();
        if (data == null) {
            logError("Null data in IAB activity result.");
            IabResult result = new IabResult(IABHELPER_BAD_RESPONSE, "Null data in IAB result");
            if (this.mPurchaseListener != null) {
                this.mPurchaseListener.onIabPurchaseFinished(result, null);
            }
            return true;
        }
        int responseCode = getResponseCodeFromIntent(data);
        String purchaseData = data.getStringExtra(RESPONSE_INAPP_PURCHASE_DATA);
        String dataSignature = data.getStringExtra(RESPONSE_INAPP_SIGNATURE);
        if (resultCode == -1 && responseCode == 0) {
            logDebug("Successful resultcode from purchase activity.");
            logDebug("Purchase data: " + purchaseData);
            logDebug("Data signature: " + dataSignature);
            logDebug("Extras: " + data.getExtras());
            logDebug("Expected item type: " + this.mPurchasingItemType);
            if (purchaseData == null || dataSignature == null) {
                logError("BUG: either purchaseData or dataSignature is null.");
                logDebug("Extras: " + data.getExtras().toString());
                IabResult result2 = new IabResult(IABHELPER_UNKNOWN_ERROR, "IAB returned null purchaseData or dataSignature");
                if (this.mPurchaseListener != null) {
                    this.mPurchaseListener.onIabPurchaseFinished(result2, null);
                }
                return true;
            }
            try {
                Purchase purchase = new Purchase(this.mPurchasingItemType, purchaseData, dataSignature);
                try {
                    String sku = purchase.getSku();
                    if (this.mPurchaseListener != null) {
                        this.mPurchaseListener.onIabPurchaseCompleteAwaitingVerification(purchaseData, dataSignature);
                    }
                    if (autoVerifySignatures && !purchase.isTestSku() && !Security.verifyPurchase(this.mSignatureBase64, purchaseData, dataSignature)) {
                        logError("Purchase signature verification FAILED for sku " + sku);
                        IabResult result3 = new IabResult(IABHELPER_VERIFICATION_FAILED, "Signature verification failed for sku " + sku);
                        if (this.mPurchaseListener != null) {
                            this.mPurchaseListener.onIabPurchaseFinished(result3, purchase);
                        }
                        return true;
                    }
                    logDebug("Purchase signature successfully verified.");
                    if (this.mPurchaseListener != null) {
                        this.mPurchaseListener.onIabPurchaseFinished(new IabResult(0, "Success"), purchase);
                    }
                } catch (JSONException e) {
                    e = e;
                    logError("Failed to parse purchase data.");
                    e.printStackTrace();
                    IabResult result4 = new IabResult(IABHELPER_BAD_RESPONSE, "Failed to parse purchase data.");
                    if (this.mPurchaseListener != null) {
                        this.mPurchaseListener.onIabPurchaseFinished(result4, null);
                    }
                    return true;
                }
            } catch (JSONException e2) {
                e = e2;
            }
        } else if (resultCode == -1) {
            logDebug("Result code was OK but in-app billing response was not OK: " + getResponseDesc(responseCode));
            if (this.mPurchaseListener != null) {
                IabResult result5 = new IabResult(responseCode, "Problem purchashing item.");
                this.mPurchaseListener.onIabPurchaseFinished(result5, null);
            }
        } else if (resultCode == 0) {
            logDebug("Purchase canceled - Response: " + getResponseDesc(responseCode));
            IabResult result6 = new IabResult(IABHELPER_USER_CANCELLED, "User canceled.");
            if (this.mPurchaseListener != null) {
                this.mPurchaseListener.onIabPurchaseFinished(result6, null);
            }
        } else {
            logError("Purchase failed. Result code: " + Integer.toString(resultCode) + ". Response: " + getResponseDesc(responseCode));
            IabResult result7 = new IabResult(IABHELPER_UNKNOWN_PURCHASE_RESPONSE, "Unknown purchase response.");
            if (this.mPurchaseListener != null) {
                this.mPurchaseListener.onIabPurchaseFinished(result7, null);
            }
        }
        return true;
    }

    public Inventory queryInventory() throws IabException {
        return queryInventory(false, null, null);
    }

    public Inventory queryInventory(boolean querySkuDetails, List<String> moreItemSkus, List<String> moreSubsSkus) throws IabException {
        int r;
        int r2;
        checkNotDisposed();
        checkSetupDone("queryInventory");
        try {
            Inventory inv = new Inventory();
            int r3 = queryPurchases(inv, ITEM_TYPE_INAPP);
            if (r3 != 0) {
                throw new IabException(r3, "Error refreshing inventory (querying owned items).");
            }
            if (querySkuDetails && (r2 = querySkuDetails(ITEM_TYPE_INAPP, inv, moreItemSkus)) != 0) {
                throw new IabException(r2, "Error refreshing inventory (querying prices of items).");
            }
            if (this.mSubscriptionsSupported) {
                int r4 = queryPurchases(inv, ITEM_TYPE_SUBS);
                if (r4 != 0) {
                    throw new IabException(r4, "Error refreshing inventory (querying owned subscriptions).");
                }
                if (querySkuDetails && (r = querySkuDetails(ITEM_TYPE_SUBS, inv, moreSubsSkus)) != 0) {
                    throw new IabException(r, "Error refreshing inventory (querying prices of subscriptions).");
                }
            }
            return inv;
        } catch (RemoteException e) {
            throw new IabException(IABHELPER_REMOTE_EXCEPTION, "Remote exception while refreshing inventory.", e);
        } catch (JSONException e2) {
            throw new IabException(IABHELPER_BAD_RESPONSE, "Error parsing JSON response while refreshing inventory.", e2);
        }
    }

    public void queryInventoryAsync(final boolean querySkuDetails, final List<String> moreItemSkus, final List<String> moreSubsSkus, final QueryInventoryFinishedListener listener) throws IabAsyncInProgressException {
        final Handler handler = new Handler();
        checkNotDisposed();
        checkSetupDone("queryInventory");
        flagStartAsync("refresh inventory");
        new Thread(new Runnable() { // from class: com.prime31.util.IabHelperImpl.2
            @Override // java.lang.Runnable
            public void run() {
                IabResult result = new IabResult(0, "Inventory refresh successful.");
                Inventory inv = null;
                try {
                    inv = IabHelperImpl.this.queryInventory(querySkuDetails, moreItemSkus, moreSubsSkus);
                } catch (IabException ex) {
                    result = ex.getResult();
                }
                IabHelperImpl.this.flagEndAsync();
                final IabResult result_f = result;
                final Inventory inv_f = inv;
                if (!IabHelperImpl.this.mDisposed && listener != null) {
                    Handler handler2 = handler;
                    final QueryInventoryFinishedListener queryInventoryFinishedListener = listener;
                    handler2.post(new Runnable() { // from class: com.prime31.util.IabHelperImpl.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            queryInventoryFinishedListener.onQueryInventoryFinished(result_f, inv_f);
                        }
                    });
                }
            }
        }).start();
    }

    public void queryInventoryAsync(QueryInventoryFinishedListener listener) throws IabAsyncInProgressException {
        queryInventoryAsync(false, null, null, listener);
    }

    void consume(Purchase itemInfo) throws IabException {
        checkNotDisposed();
        checkSetupDone("consume");
        if (!itemInfo._itemType.equals(ITEM_TYPE_INAPP)) {
            throw new IabException(IABHELPER_INVALID_CONSUMPTION, "Items of type '" + itemInfo._itemType + "' can't be consumed.");
        }
        try {
            String token = itemInfo.getToken();
            String sku = itemInfo.getSku();
            if (token == null || token.equals("")) {
                logError("Can't consume " + sku + ". No token.");
                throw new IabException(IABHELPER_MISSING_TOKEN, "PurchaseInfo is missing token for sku: " + sku + " " + itemInfo);
            }
            logDebug("Consuming sku: " + sku + ", token: " + token);
            int response = this.mService.consumePurchase(3, this.mContext.getPackageName(), token);
            if (response == 0) {
                logDebug("Successfully consumed sku: " + sku);
            } else {
                logDebug("Error consuming consuming sku " + sku + ". " + getResponseDesc(response));
                throw new IabException(response, "Error consuming sku " + sku);
            }
        } catch (RemoteException e) {
            throw new IabException(IABHELPER_REMOTE_EXCEPTION, "Remote exception while consuming. PurchaseInfo: " + itemInfo, e);
        }
    }

    public void consumeAsync(Purchase purchase, OnConsumeFinishedListener listener) throws IabAsyncInProgressException {
        checkNotDisposed();
        checkSetupDone("consume");
        List<Purchase> purchases = new ArrayList<>();
        purchases.add(purchase);
        consumeAsyncInternal(purchases, listener, null);
    }

    public void consumeAsync(List<Purchase> purchases, OnConsumeMultiFinishedListener listener) throws IabAsyncInProgressException {
        checkNotDisposed();
        checkSetupDone("consume");
        consumeAsyncInternal(purchases, null, listener);
    }

    public static String getResponseDesc(int code) {
        String[] iab_msgs = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
        String[] iabhelper_msgs = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split("/");
        if (code <= -1000) {
            int index = (-1000) - code;
            if (index >= 0 && index < iabhelper_msgs.length) {
                return iabhelper_msgs[index];
            }
            return String.valueOf(String.valueOf(code)) + ":Unknown IAB Helper Error";
        }
        if (code < 0 || code >= iab_msgs.length) {
            return String.valueOf(String.valueOf(code)) + ":Unknown";
        }
        return iab_msgs[code];
    }

    void checkSetupDone(String operation) {
        if (!this.mSetupDone) {
            logError("Illegal state for operation (" + operation + "): IAB helper is not set up.");
            throw new IllegalStateException("IAB helper is not set up. Can't perform operation: " + operation);
        }
    }

    int getResponseCodeFromBundle(Bundle b) {
        Object o = b.get(RESPONSE_CODE);
        if (o == null) {
            logDebug("Bundle with null response code, assuming OK (known issue)");
            return 0;
        }
        if (o instanceof Integer) {
            return ((Integer) o).intValue();
        }
        if (o instanceof Long) {
            return (int) ((Long) o).longValue();
        }
        logError("Unexpected type for bundle response code.");
        logError(o.getClass().getName());
        throw new RuntimeException("Unexpected type for bundle response code: " + o.getClass().getName());
    }

    int getResponseCodeFromIntent(Intent i) {
        Object o = i.getExtras().get(RESPONSE_CODE);
        if (o == null) {
            logError("Intent with no response code, assuming OK (known issue)");
            return 0;
        }
        if (o instanceof Integer) {
            return ((Integer) o).intValue();
        }
        if (o instanceof Long) {
            return (int) ((Long) o).longValue();
        }
        logError("Unexpected type for intent response code.");
        logError(o.getClass().getName());
        throw new RuntimeException("Unexpected type for intent response code: " + o.getClass().getName());
    }

    void flagStartAsync(String operation) throws IabAsyncInProgressException {
        synchronized (this.mAsyncInProgressLock) {
            if (this.mAsyncInProgress) {
                throw new IabAsyncInProgressException("Can't start async operation (" + operation + ") because another async operation (" + this.mAsyncOperation + ") is in progress.");
            }
            this.mAsyncOperation = operation;
            this.mAsyncInProgress = true;
            logDebug("Starting async operation: " + operation);
        }
    }

    void flagEndAsync() {
        synchronized (this.mAsyncInProgressLock) {
            logDebug("Ending async operation: " + this.mAsyncOperation);
            this.mAsyncOperation = "";
            this.mAsyncInProgress = false;
            if (this.mDisposeAfterAsync) {
                try {
                    dispose();
                } catch (IabAsyncInProgressException e) {
                }
            }
        }
    }

    public static class IabAsyncInProgressException extends Exception {
        public IabAsyncInProgressException(String message) {
            super(message);
        }
    }

    int queryPurchases(Inventory inv, String itemType) throws JSONException, RemoteException {
        logDebug("Querying owned items, item type: " + itemType);
        logDebug("Package name: " + this.mContext.getPackageName());
        boolean verificationFailed = false;
        String continueToken = null;
        do {
            logDebug("Calling getPurchases with continuation token: " + continueToken);
            Bundle ownedItems = this.mService.getPurchases(3, this.mContext.getPackageName(), itemType, continueToken);
            int response = getResponseCodeFromBundle(ownedItems);
            logDebug("Owned items response: " + String.valueOf(response));
            if (response != 0) {
                logDebug("getPurchases() failed: " + getResponseDesc(response));
                return response;
            }
            if (!ownedItems.containsKey(RESPONSE_INAPP_ITEM_LIST) || !ownedItems.containsKey(RESPONSE_INAPP_PURCHASE_DATA_LIST) || !ownedItems.containsKey(RESPONSE_INAPP_SIGNATURE_LIST)) {
                logError("Bundle returned from getPurchases() doesn't contain required fields.");
                return IABHELPER_BAD_RESPONSE;
            }
            ArrayList<String> ownedSkus = ownedItems.getStringArrayList(RESPONSE_INAPP_ITEM_LIST);
            ArrayList<String> purchaseDataList = ownedItems.getStringArrayList(RESPONSE_INAPP_PURCHASE_DATA_LIST);
            ArrayList<String> signatureList = ownedItems.getStringArrayList(RESPONSE_INAPP_SIGNATURE_LIST);
            for (int i = 0; i < purchaseDataList.size(); i++) {
                String purchaseData = purchaseDataList.get(i);
                String signature = signatureList.get(i);
                String sku = ownedSkus.get(i);
                boolean purchaseIsVerified = true;
                if (autoVerifySignatures) {
                    logDebug("verified sku: " + sku);
                    purchaseIsVerified = Security.verifyPurchase(this.mSignatureBase64, purchaseData, signature);
                }
                Purchase purchase = new Purchase(itemType, purchaseData, signature);
                if (purchase.isTestSku()) {
                    purchaseIsVerified = true;
                    logDebug("skipping signature verification because this is a test product");
                }
                if (purchaseIsVerified) {
                    logDebug("Sku is owned: " + sku);
                    if (TextUtils.isEmpty(purchase.getToken())) {
                        logWarn("BUG: empty/null token!");
                        logDebug("Purchase data: " + purchaseData);
                    }
                    inv.addPurchase(purchase);
                } else {
                    logWarn("Purchase signature verification **FAILED**. Not adding item.");
                    logDebug("   Purchase data: " + purchaseData);
                    logDebug("   Signature: " + signature);
                    verificationFailed = true;
                }
            }
            continueToken = ownedItems.getString(INAPP_CONTINUATION_TOKEN);
            logDebug("Continuation token: " + continueToken);
        } while (!TextUtils.isEmpty(continueToken));
        return verificationFailed ? IABHELPER_VERIFICATION_FAILED : 0;
    }

    int querySkuDetails(String itemType, Inventory inv, List<String> moreSkus) throws JSONException, RemoteException {
        logDebug("Querying SKU details.");
        ArrayList<String> skuList = new ArrayList<>();
        skuList.addAll(inv.getAllOwnedSkus(itemType));
        if (moreSkus != null) {
            for (String sku : moreSkus) {
                if (!skuList.contains(sku)) {
                    skuList.add(sku);
                }
            }
        }
        if (skuList.size() == 0) {
            logDebug("queryPrices: nothing to do because there are no SKUs.");
            return 0;
        }
        ArrayList<ArrayList<String>> packs = new ArrayList<>();
        int n = skuList.size() / 20;
        int mod = skuList.size() % 20;
        for (int i = 0; i < n; i++) {
            ArrayList<String> tempList = new ArrayList<>();
            for (String s : skuList.subList(i * 20, (i * 20) + 20)) {
                tempList.add(s);
            }
            packs.add(tempList);
        }
        if (mod != 0) {
            ArrayList<String> tempList2 = new ArrayList<>();
            for (String s2 : skuList.subList(n * 20, (n * 20) + mod)) {
                tempList2.add(s2);
            }
            packs.add(tempList2);
        }
        for (ArrayList<String> skuPartList : packs) {
            Bundle querySkus = new Bundle();
            querySkus.putStringArrayList(GET_SKU_DETAILS_ITEM_LIST, skuPartList);
            Bundle skuDetails = this.mService.getSkuDetails(3, this.mContext.getPackageName(), itemType, querySkus);
            if (!skuDetails.containsKey(RESPONSE_GET_SKU_DETAILS_LIST)) {
                int response = getResponseCodeFromBundle(skuDetails);
                if (response != 0) {
                    logDebug("getSkuDetails() failed: " + getResponseDesc(response));
                    return response;
                }
                logError("getSkuDetails() returned a bundle with neither an error nor a detail list.");
                return IABHELPER_BAD_RESPONSE;
            }
            ArrayList<String> responseList = skuDetails.getStringArrayList(RESPONSE_GET_SKU_DETAILS_LIST);
            for (String thisResponse : responseList) {
                SkuDetails d = new SkuDetails(itemType, thisResponse);
                logDebug("Got sku details: " + d);
                inv.addSkuDetails(d);
            }
        }
        return 0;
    }

    void consumeAsyncInternal(final List<Purchase> purchases, final OnConsumeFinishedListener singleListener, final OnConsumeMultiFinishedListener multiListener) throws IabAsyncInProgressException {
        final Handler handler = new Handler();
        flagStartAsync("consume");
        new Thread(new Runnable() { // from class: com.prime31.util.IabHelperImpl.3
            @Override // java.lang.Runnable
            public void run() {
                final List<IabResult> results = new ArrayList<>();
                for (Purchase purchase : purchases) {
                    try {
                        IabHelperImpl.this.consume(purchase);
                        results.add(new IabResult(0, "Successful consume of sku " + purchase.getSku()));
                    } catch (IabException ex) {
                        results.add(ex.getResult());
                    }
                }
                IabHelperImpl.this.flagEndAsync();
                if (!IabHelperImpl.this.mDisposed && singleListener != null) {
                    Handler handler2 = handler;
                    final OnConsumeFinishedListener onConsumeFinishedListener = singleListener;
                    final List list = purchases;
                    handler2.post(new Runnable() { // from class: com.prime31.util.IabHelperImpl.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            onConsumeFinishedListener.onConsumeFinished((Purchase) list.get(0), (IabResult) results.get(0));
                        }
                    });
                }
                if (!IabHelperImpl.this.mDisposed && multiListener != null) {
                    Handler handler3 = handler;
                    final OnConsumeMultiFinishedListener onConsumeMultiFinishedListener = multiListener;
                    final List list2 = purchases;
                    handler3.post(new Runnable() { // from class: com.prime31.util.IabHelperImpl.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            onConsumeMultiFinishedListener.onConsumeMultiFinished(list2, results);
                        }
                    });
                }
            }
        }).start();
    }

    void logDebug(String msg) {
        if (this.mDebugLog) {
            Log.d(this.mDebugTag, msg);
        }
    }

    void logError(String msg) {
        Log.e(this.mDebugTag, "In-app billing error: " + msg);
    }

    void logWarn(String msg) {
        Log.w(this.mDebugTag, "In-app billing warning: " + msg);
    }
}
