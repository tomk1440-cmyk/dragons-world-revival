package com.google.android.gms.appinvite;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class PreviewActivity extends Activity {
    public static final String ACTION_PREVIEW = "com.google.android.gms.appinvite.ACTION_PREVIEW";
    public static final String EXTRA_LAYOUT_RES_ID = "com.google.android.gms.appinvite.LAYOUT_RES_ID";
    public static final String EXTRA_TABS = "com.google.android.gms.appinvite.TABS";
    public static final String EXTRA_VIEWS = "com.google.android.gms.appinvite.VIEWS";
    public static final String KEY_TAB_CONTENT_ID = "tabContentId";
    public static final String KEY_TAB_TAG = "tabTag";
    public static final String KEY_TEXT_VIEW_IS_TITLE = "TextView_isTitle";
    public static final String KEY_TEXT_VIEW_TEXT = "TextView_text";
    public static final String KEY_TEXT_VIEW_TEXT_COLOR = "TextView_textColor";
    public static final String KEY_VIEW_BACKGROUND_COLOR = "View_backgroundColor";
    public static final String KEY_VIEW_ID = "View_id";
    public static final String KEY_VIEW_MIN_HEIGHT = "View_minHeight";
    public static final String KEY_VIEW_ON_CLICK_LISTENER = "View_onClickListener";
    public static final String KEY_WEB_VIEW_DATA = "WebView_data";
    public static final String ON_CLICK_LISTENER_CLOSE = "close";

    private View zza(Context context, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = LayoutInflater.from(context).inflate(bundle.getInt(EXTRA_LAYOUT_RES_ID), viewGroup, false);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(EXTRA_VIEWS);
        if (parcelableArrayList != null) {
            Iterator it = parcelableArrayList.iterator();
            while (it.hasNext()) {
                zza(viewInflate, (Bundle) it.next());
            }
        }
        return viewInflate;
    }

    private void zza(View view, Bundle bundle) {
        View viewFindViewById = view.findViewById(bundle.getInt(KEY_VIEW_ID));
        for (String str : bundle.keySet()) {
            switch (str) {
                case "View_backgroundColor":
                    viewFindViewById.setBackgroundColor(bundle.getInt(str));
                    break;
                case "View_minHeight":
                    viewFindViewById.setMinimumHeight(bundle.getInt(str));
                    break;
                case "View_onClickListener":
                    switch (bundle.getString(str)) {
                        case "close":
                            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.gms.appinvite.PreviewActivity.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    PreviewActivity.this.finish();
                                }
                            });
                            break;
                    }
                    break;
                case "TextView_text":
                    if (viewFindViewById instanceof TextView) {
                        ((TextView) viewFindViewById).setText(bundle.getCharSequence(str));
                        break;
                    } else {
                        break;
                    }
                    break;
                case "TextView_textColor":
                    if (viewFindViewById instanceof TextView) {
                        ((TextView) viewFindViewById).setTextColor(bundle.getInt(str));
                        break;
                    } else {
                        break;
                    }
                    break;
                case "TextView_isTitle":
                    if (!(viewFindViewById instanceof TextView) || !bundle.getBoolean(str)) {
                        break;
                    } else {
                        setTitle(((TextView) viewFindViewById).getText());
                        break;
                    }
                    break;
                case "WebView_data":
                    if (viewFindViewById instanceof ViewGroup) {
                        WebView webView = new WebView(this);
                        webView.loadData(bundle.getString(str), "text/html; charset=utf-8", "UTF-8");
                        ((ViewGroup) viewFindViewById).addView(webView, new ViewGroup.LayoutParams(-1, -1));
                        break;
                    } else {
                        break;
                    }
                    break;
            }
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getCallingActivity() == null || !"com.google.android.gms".equals(getCallingActivity().getPackageName())) {
            finish();
            return;
        }
        try {
            Context contextCreatePackageContext = createPackageContext("com.google.android.gms", 0);
            Bundle extras = getIntent().getExtras();
            View viewZza = zza(contextCreatePackageContext, null, extras);
            if (viewZza == null) {
                finish();
                return;
            }
            TabHost tabHost = (TabHost) viewZza.findViewById(R.id.tabhost);
            TabWidget tabWidget = (TabWidget) viewZza.findViewById(R.id.tabs);
            ArrayList<Bundle> parcelableArrayList = extras.getParcelableArrayList(EXTRA_TABS);
            if (tabHost != null && tabWidget != null && parcelableArrayList != null) {
                tabHost.setup();
                for (Bundle bundle : parcelableArrayList) {
                    TabHost.TabSpec tabSpecNewTabSpec = tabHost.newTabSpec(bundle.getString(KEY_TAB_TAG));
                    tabSpecNewTabSpec.setContent(bundle.getInt(KEY_TAB_CONTENT_ID));
                    tabSpecNewTabSpec.setIndicator(zza(contextCreatePackageContext, tabWidget, bundle));
                    tabHost.addTab(tabSpecNewTabSpec);
                }
            }
            setContentView(viewZza);
        } catch (PackageManager.NameNotFoundException e) {
            finish();
        }
    }
}
