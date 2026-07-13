package com.google.android.gms.games.internal;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.internal.zzne;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class PopupManager {
    protected GamesClientImpl zzaFJ;
    protected PopupLocationInfo zzaFK;

    public static final class PopupLocationInfo {
        public int bottom;
        public int gravity;
        public int left;
        public int right;
        public int top;
        public IBinder zzaFL;
        public int zzaFM;

        private PopupLocationInfo(int gravity, IBinder windowToken) {
            this.zzaFM = -1;
            this.left = 0;
            this.top = 0;
            this.right = 0;
            this.bottom = 0;
            this.gravity = gravity;
            this.zzaFL = windowToken;
        }

        public Bundle zzxg() {
            Bundle bundle = new Bundle();
            bundle.putInt("popupLocationInfo.gravity", this.gravity);
            bundle.putInt("popupLocationInfo.displayId", this.zzaFM);
            bundle.putInt("popupLocationInfo.left", this.left);
            bundle.putInt("popupLocationInfo.top", this.top);
            bundle.putInt("popupLocationInfo.right", this.right);
            bundle.putInt("popupLocationInfo.bottom", this.bottom);
            return bundle;
        }
    }

    @TargetApi(12)
    private static final class PopupManagerHCMR1 extends PopupManager implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {
        private boolean zzaEe;
        private WeakReference<View> zzaFN;

        protected PopupManagerHCMR1(GamesClientImpl gamesClientImpl, int gravity) {
            super(gamesClientImpl, gravity);
            this.zzaEe = false;
        }

        @TargetApi(17)
        private void zzq(View view) {
            Display display;
            int displayId = -1;
            if (zzne.zzsi() && (display = view.getDisplay()) != null) {
                displayId = display.getDisplayId();
            }
            IBinder windowToken = view.getWindowToken();
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int width = view.getWidth();
            int height = view.getHeight();
            this.zzaFK.zzaFM = displayId;
            this.zzaFK.zzaFL = windowToken;
            this.zzaFK.left = iArr[0];
            this.zzaFK.top = iArr[1];
            this.zzaFK.right = iArr[0] + width;
            this.zzaFK.bottom = iArr[1] + height;
            if (this.zzaEe) {
                zzxh();
                this.zzaEe = false;
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            View view;
            if (this.zzaFN == null || (view = this.zzaFN.get()) == null) {
                return;
            }
            zzq(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v) {
            zzq(v);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v) {
            this.zzaFJ.zzwR();
            v.removeOnAttachStateChangeListener(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.games.internal.PopupManager
        protected void zzgv(int i) {
            this.zzaFK = new PopupLocationInfo(i, null);
        }

        @Override // com.google.android.gms.games.internal.PopupManager
        @TargetApi(16)
        public void zzp(View view) {
            this.zzaFJ.zzwR();
            if (this.zzaFN != null) {
                View decorView = this.zzaFN.get();
                Context context = this.zzaFJ.getContext();
                if (decorView == null && (context instanceof Activity)) {
                    decorView = ((Activity) context).getWindow().getDecorView();
                }
                if (decorView != null) {
                    decorView.removeOnAttachStateChangeListener(this);
                    ViewTreeObserver viewTreeObserver = decorView.getViewTreeObserver();
                    if (zzne.zzsh()) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    } else {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    }
                }
            }
            this.zzaFN = null;
            Context context2 = this.zzaFJ.getContext();
            if (view == null && (context2 instanceof Activity)) {
                View viewFindViewById = ((Activity) context2).findViewById(R.id.content);
                if (viewFindViewById == null) {
                    viewFindViewById = ((Activity) context2).getWindow().getDecorView();
                }
                GamesLog.zzz("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view. Note that this may not work as expected in multi-screen environments");
                view = viewFindViewById;
            }
            if (view == null) {
                GamesLog.zzA("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
                return;
            }
            zzq(view);
            this.zzaFN = new WeakReference<>(view);
            view.addOnAttachStateChangeListener(this);
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // com.google.android.gms.games.internal.PopupManager
        public void zzxh() {
            if (this.zzaFK.zzaFL != null) {
                super.zzxh();
            } else {
                this.zzaEe = this.zzaFN != null;
            }
        }
    }

    private PopupManager(GamesClientImpl gamesClientImpl, int gravity) {
        this.zzaFJ = gamesClientImpl;
        zzgv(gravity);
    }

    public static PopupManager zza(GamesClientImpl gamesClientImpl, int i) {
        return zzne.zzse() ? new PopupManagerHCMR1(gamesClientImpl, i) : new PopupManager(gamesClientImpl, i);
    }

    public void setGravity(int gravity) {
        this.zzaFK.gravity = gravity;
    }

    protected void zzgv(int i) {
        this.zzaFK = new PopupLocationInfo(i, new Binder());
    }

    public void zzp(View view) {
    }

    public void zzxh() {
        this.zzaFJ.zza(this.zzaFK.zzaFL, this.zzaFK.zzxg());
    }

    public Bundle zzxi() {
        return this.zzaFK.zzxg();
    }

    public IBinder zzxj() {
        return this.zzaFK.zzaFL;
    }

    public PopupLocationInfo zzxk() {
        return this.zzaFK;
    }
}
