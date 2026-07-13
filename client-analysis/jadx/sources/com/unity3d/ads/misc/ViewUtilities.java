package com.unity3d.ads.misc;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.unity3d.ads.log.DeviceLog;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class ViewUtilities {
    public static void removeViewFromParent(View view) {
        if (view != null && view.getParent() != null) {
            try {
                ((ViewGroup) view.getParent()).removeView(view);
            } catch (Exception e) {
                DeviceLog.exception("Error while removing view from it's parent", e);
            }
        }
    }

    public static void setBackground(View view, Drawable drawable) {
        String methodName = "setBackground";
        int sdk = Build.VERSION.SDK_INT;
        if (sdk < 16) {
            methodName = "setBackgroundDrawable";
        }
        try {
            Method setBackground = View.class.getMethod(methodName, Drawable.class);
            setBackground.invoke(view, drawable);
        } catch (Exception e) {
            DeviceLog.exception("Couldn't run" + methodName, e);
        }
    }
}
