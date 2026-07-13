package com.unity3d.ads.adunit;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.unity3d.ads.api.AdUnit;
import com.unity3d.ads.api.VideoPlayer;
import com.unity3d.ads.log.DeviceLog;
import com.unity3d.ads.misc.ViewUtilities;
import com.unity3d.ads.video.VideoPlayerView;
import com.unity3d.ads.webview.WebViewApp;
import com.unity3d.ads.webview.WebViewEventCategory;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AdUnitActivity extends Activity {
    public static final String EXTRA_ACTIVITY_ID = "activityId";
    public static final String EXTRA_KEEP_SCREEN_ON = "keepScreenOn";
    public static final String EXTRA_KEY_EVENT_LIST = "keyEvents";
    public static final String EXTRA_ORIENTATION = "orientation";
    public static final String EXTRA_SYSTEM_UI_VISIBILITY = "systemUiVisibility";
    public static final String EXTRA_VIEWS = "views";
    private int _activityId;
    boolean _keepScreenOn;
    private ArrayList<Integer> _keyEventList;
    private RelativeLayout _layout;
    private int _orientation = -1;
    private int _systemUiVisibility;
    private RelativeLayout _videoContainer;
    private String[] _views;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        AdUnitEvent event;
        super.onCreate(savedInstanceState);
        if (WebViewApp.getCurrentApp() == null) {
            DeviceLog.error("Unity Ads web app is null, closing Unity Ads activity from onCreate");
            finish();
            return;
        }
        AdUnit.setAdUnitActivity(this);
        createLayout();
        ViewUtilities.removeViewFromParent(this._layout);
        addContentView(this._layout, this._layout.getLayoutParams());
        if (savedInstanceState == null) {
            this._views = getIntent().getStringArrayExtra(EXTRA_VIEWS);
            this._keyEventList = getIntent().getIntegerArrayListExtra(EXTRA_KEY_EVENT_LIST);
            if (getIntent().hasExtra(EXTRA_ORIENTATION)) {
                this._orientation = getIntent().getIntExtra(EXTRA_ORIENTATION, -1);
            }
            if (getIntent().hasExtra(EXTRA_SYSTEM_UI_VISIBILITY)) {
                this._systemUiVisibility = getIntent().getIntExtra(EXTRA_SYSTEM_UI_VISIBILITY, 0);
            }
            if (getIntent().hasExtra(EXTRA_ACTIVITY_ID)) {
                this._activityId = getIntent().getIntExtra(EXTRA_ACTIVITY_ID, -1);
            }
            event = AdUnitEvent.ON_CREATE;
        } else {
            this._views = savedInstanceState.getStringArray(EXTRA_VIEWS);
            this._orientation = savedInstanceState.getInt(EXTRA_ORIENTATION, -1);
            this._systemUiVisibility = savedInstanceState.getInt(EXTRA_SYSTEM_UI_VISIBILITY, 0);
            this._keyEventList = savedInstanceState.getIntegerArrayList(EXTRA_KEY_EVENT_LIST);
            this._keepScreenOn = savedInstanceState.getBoolean(EXTRA_KEEP_SCREEN_ON);
            this._activityId = savedInstanceState.getInt(EXTRA_ACTIVITY_ID, -1);
            setKeepScreenOn(this._keepScreenOn);
            event = AdUnitEvent.ON_RESTORE;
        }
        setOrientation(this._orientation);
        setSystemUiVisibility(this._systemUiVisibility);
        if (this._views != null && Arrays.asList(this._views).contains("videoplayer")) {
            createVideoPlayer();
        }
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.ADUNIT, event, Integer.valueOf(this._activityId));
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (WebViewApp.getCurrentApp() == null) {
            if (!isFinishing()) {
                DeviceLog.error("Unity Ads web app is null, closing Unity Ads activity from onStart");
                finish();
                return;
            }
            return;
        }
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.ADUNIT, AdUnitEvent.ON_START, Integer.valueOf(this._activityId));
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        if (WebViewApp.getCurrentApp() == null) {
            if (!isFinishing()) {
                DeviceLog.error("Unity Ads web app is null, closing Unity Ads activity from onStop");
                finish();
                return;
            }
            return;
        }
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.ADUNIT, AdUnitEvent.ON_STOP, Integer.valueOf(this._activityId));
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (WebViewApp.getCurrentApp() == null) {
            if (!isFinishing()) {
                DeviceLog.error("Unity Ads web app is null, closing Unity Ads activity from onResume");
                finish();
                return;
            }
            return;
        }
        setViews(this._views);
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.ADUNIT, AdUnitEvent.ON_RESUME, Integer.valueOf(this._activityId));
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        if (WebViewApp.getCurrentApp() == null) {
            if (!isFinishing()) {
                DeviceLog.error("Unity Ads web app is null, closing Unity Ads activity from onPause");
                finish();
                return;
            }
            return;
        }
        if (isFinishing()) {
            ViewUtilities.removeViewFromParent(WebViewApp.getCurrentApp().getWebView());
        }
        destroyVideoPlayer();
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.ADUNIT, AdUnitEvent.ON_PAUSE, Boolean.valueOf(isFinishing()), Integer.valueOf(this._activityId));
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(EXTRA_ORIENTATION, this._orientation);
        outState.putInt(EXTRA_SYSTEM_UI_VISIBILITY, this._systemUiVisibility);
        outState.putIntegerArrayList(EXTRA_KEY_EVENT_LIST, this._keyEventList);
        outState.putBoolean(EXTRA_KEEP_SCREEN_ON, this._keepScreenOn);
        outState.putStringArray(EXTRA_VIEWS, this._views);
        outState.putInt(EXTRA_ACTIVITY_ID, this._activityId);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (WebViewApp.getCurrentApp() == null) {
            if (!isFinishing()) {
                DeviceLog.error("Unity Ads web app is null, closing Unity Ads activity from onDestroy");
                finish();
                return;
            }
            return;
        }
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.ADUNIT, AdUnitEvent.ON_DESTROY, Boolean.valueOf(isFinishing()), Integer.valueOf(this._activityId));
        if (AdUnit.getCurrentAdUnitActivityId() == this._activityId) {
            AdUnit.setAdUnitActivity(null);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (this._keyEventList == null || !this._keyEventList.contains(Integer.valueOf(keyCode))) {
            return false;
        }
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.ADUNIT, AdUnitEvent.KEY_DOWN, Integer.valueOf(keyCode), Long.valueOf(event.getEventTime()), Long.valueOf(event.getDownTime()), Integer.valueOf(event.getRepeatCount()), Integer.valueOf(this._activityId));
        return true;
    }

    public void setViewFrame(String view, int x, int y, int width, int height) {
        View targetView = null;
        if (view.equals("adunit")) {
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(width, height);
            params.setMargins(x, y, 0, 0);
            this._layout.setLayoutParams(params);
        } else if (view.equals("videoplayer")) {
            targetView = this._videoContainer;
        } else if (view.equals("webview")) {
            targetView = WebViewApp.getCurrentApp().getWebView();
        }
        if (targetView != null) {
            RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(width, height);
            params2.setMargins(x, y, 0, 0);
            targetView.setLayoutParams(params2);
        }
    }

    public Map<String, Integer> getViewFrame(String view) {
        View targetView = null;
        if (view.equals("adunit")) {
            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) this._layout.getLayoutParams();
            HashMap<String, Integer> map = new HashMap<>();
            map.put("x", Integer.valueOf(params.leftMargin));
            map.put("y", Integer.valueOf(params.topMargin));
            map.put(SettingsJsonConstants.ICON_WIDTH_KEY, Integer.valueOf(this._layout.getWidth()));
            map.put(SettingsJsonConstants.ICON_HEIGHT_KEY, Integer.valueOf(this._layout.getHeight()));
            return map;
        }
        if (view.equals("videoplayer")) {
            targetView = this._videoContainer;
        } else if (view.equals("webview")) {
            targetView = WebViewApp.getCurrentApp().getWebView();
        }
        if (targetView != null) {
            RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) targetView.getLayoutParams();
            HashMap<String, Integer> map2 = new HashMap<>();
            map2.put("x", Integer.valueOf(params2.leftMargin));
            map2.put("y", Integer.valueOf(params2.topMargin));
            map2.put(SettingsJsonConstants.ICON_WIDTH_KEY, Integer.valueOf(targetView.getWidth()));
            map2.put(SettingsJsonConstants.ICON_HEIGHT_KEY, Integer.valueOf(targetView.getHeight()));
            return map2;
        }
        return null;
    }

    public void setViews(String[] views) {
        String[] actualViews;
        if (views == null) {
            actualViews = new String[0];
        } else {
            actualViews = views;
        }
        Collection<?> newViews = new ArrayList<>(Arrays.asList(actualViews));
        if (this._views == null) {
            this._views = new String[0];
        }
        ArrayList<String> removedViews = new ArrayList<>(Arrays.asList(this._views));
        removedViews.removeAll(newViews);
        Iterator<String> it = removedViews.iterator();
        while (it.hasNext()) {
            switch (it.next()) {
                case "videoplayer":
                    destroyVideoPlayer();
                    break;
                case "webview":
                    ViewUtilities.removeViewFromParent(WebViewApp.getCurrentApp().getWebView());
                    break;
            }
        }
        this._views = actualViews;
        for (String view : actualViews) {
            if (view != null) {
                if (view.equals("videoplayer")) {
                    createVideoPlayer();
                    handleViewPlacement(this._videoContainer);
                } else if (!view.equals("webview")) {
                    continue;
                } else if (WebViewApp.getCurrentApp() != null) {
                    handleViewPlacement(WebViewApp.getCurrentApp().getWebView());
                } else {
                    DeviceLog.error("WebApp IS NULL!");
                    throw new NullPointerException();
                }
            }
        }
    }

    private void handleViewPlacement(View view) {
        if (view.getParent() != null && view.getParent().equals(this._layout)) {
            this._layout.bringChildToFront(view);
            return;
        }
        ViewUtilities.removeViewFromParent(view);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(-1, -1);
        params.addRule(13);
        params.setMargins(0, 0, 0, 0);
        view.setPadding(0, 0, 0, 0);
        this._layout.addView(view, params);
    }

    public String[] getViews() {
        return this._views;
    }

    public void setOrientation(int orientation) {
        this._orientation = orientation;
        setRequestedOrientation(orientation);
    }

    public boolean setKeepScreenOn(boolean keepScreenOn) {
        this._keepScreenOn = keepScreenOn;
        if (getWindow() == null) {
            return false;
        }
        if (keepScreenOn) {
            getWindow().addFlags(128);
        } else {
            getWindow().clearFlags(128);
        }
        return true;
    }

    public boolean setSystemUiVisibility(int flags) {
        this._systemUiVisibility = flags;
        if (Build.VERSION.SDK_INT < 11) {
            return false;
        }
        try {
            getWindow().getDecorView().setSystemUiVisibility(flags);
            return true;
        } catch (Exception e) {
            DeviceLog.exception("Error while setting SystemUIVisibility", e);
            return false;
        }
    }

    public void setKeyEventList(ArrayList<Integer> keyevents) {
        this._keyEventList = keyevents;
    }

    private void createLayout() {
        if (this._layout == null) {
            this._layout = new RelativeLayout(this);
            this._layout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            ViewUtilities.setBackground(this._layout, new ColorDrawable(ViewCompat.MEASURED_STATE_MASK));
        }
    }

    private void createVideoPlayer() {
        if (this._videoContainer == null) {
            this._videoContainer = new RelativeLayout(this);
        }
        if (VideoPlayer.getVideoPlayerView() == null) {
            VideoPlayer.setVideoPlayerView(new VideoPlayerView(this));
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(-1, -1);
            params.addRule(13);
            VideoPlayer.getVideoPlayerView().setLayoutParams(params);
            this._videoContainer.addView(VideoPlayer.getVideoPlayerView());
        }
    }

    private void destroyVideoPlayer() {
        if (VideoPlayer.getVideoPlayerView() != null) {
            VideoPlayer.getVideoPlayerView().stopVideoProgressTimer();
            VideoPlayer.getVideoPlayerView().stopPlayback();
            ViewUtilities.removeViewFromParent(VideoPlayer.getVideoPlayerView());
        }
        VideoPlayer.setVideoPlayerView(null);
        if (this._videoContainer != null) {
            ViewUtilities.removeViewFromParent(this._videoContainer);
            this._videoContainer = null;
        }
    }
}
