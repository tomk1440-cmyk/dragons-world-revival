package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
class DrawableCompatEclair {
    DrawableCompatEclair() {
    }

    public static Drawable wrapForTinting(Drawable drawable) {
        if (!(drawable instanceof TintAwareDrawable)) {
            return new DrawableWrapperEclair(drawable);
        }
        return drawable;
    }
}
