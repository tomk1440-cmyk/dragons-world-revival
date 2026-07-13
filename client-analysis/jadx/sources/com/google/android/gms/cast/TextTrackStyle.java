package com.google.android.gms.cast;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zznb;
import com.google.android.gms.internal.zzne;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class TextTrackStyle {
    public static final int COLOR_UNSPECIFIED = 0;
    public static final float DEFAULT_FONT_SCALE = 1.0f;
    public static final int EDGE_TYPE_DEPRESSED = 4;
    public static final int EDGE_TYPE_DROP_SHADOW = 2;
    public static final int EDGE_TYPE_NONE = 0;
    public static final int EDGE_TYPE_OUTLINE = 1;
    public static final int EDGE_TYPE_RAISED = 3;
    public static final int EDGE_TYPE_UNSPECIFIED = -1;
    public static final int FONT_FAMILY_CASUAL = 4;
    public static final int FONT_FAMILY_CURSIVE = 5;
    public static final int FONT_FAMILY_MONOSPACED_SANS_SERIF = 1;
    public static final int FONT_FAMILY_MONOSPACED_SERIF = 3;
    public static final int FONT_FAMILY_SANS_SERIF = 0;
    public static final int FONT_FAMILY_SERIF = 2;
    public static final int FONT_FAMILY_SMALL_CAPITALS = 6;
    public static final int FONT_FAMILY_UNSPECIFIED = -1;
    public static final int FONT_STYLE_BOLD = 1;
    public static final int FONT_STYLE_BOLD_ITALIC = 3;
    public static final int FONT_STYLE_ITALIC = 2;
    public static final int FONT_STYLE_NORMAL = 0;
    public static final int FONT_STYLE_UNSPECIFIED = -1;
    public static final int WINDOW_TYPE_NONE = 0;
    public static final int WINDOW_TYPE_NORMAL = 1;
    public static final int WINDOW_TYPE_ROUNDED = 2;
    public static final int WINDOW_TYPE_UNSPECIFIED = -1;
    private JSONObject zzaaU;
    private float zzaco;
    private int zzacp;
    private int zzacq;
    private int zzacr;
    private int zzacs;
    private int zzact;
    private int zzacu;
    private String zzacv;
    private int zzacw;
    private int zzacx;
    private int zzxO;

    public TextTrackStyle() {
        clear();
    }

    private void clear() {
        this.zzaco = 1.0f;
        this.zzacp = 0;
        this.zzxO = 0;
        this.zzacq = -1;
        this.zzacr = 0;
        this.zzacs = -1;
        this.zzact = 0;
        this.zzacu = 0;
        this.zzacv = null;
        this.zzacw = -1;
        this.zzacx = -1;
        this.zzaaU = null;
    }

    @TargetApi(19)
    public static TextTrackStyle fromSystemSettings(Context context) {
        TextTrackStyle textTrackStyle = new TextTrackStyle();
        if (!zzne.zzsk()) {
            return textTrackStyle;
        }
        CaptioningManager captioningManager = (CaptioningManager) context.getSystemService("captioning");
        textTrackStyle.setFontScale(captioningManager.getFontScale());
        CaptioningManager.CaptionStyle userStyle = captioningManager.getUserStyle();
        textTrackStyle.setBackgroundColor(userStyle.backgroundColor);
        textTrackStyle.setForegroundColor(userStyle.foregroundColor);
        switch (userStyle.edgeType) {
            case 1:
                textTrackStyle.setEdgeType(1);
                break;
            case 2:
                textTrackStyle.setEdgeType(2);
                break;
            default:
                textTrackStyle.setEdgeType(0);
                break;
        }
        textTrackStyle.setEdgeColor(userStyle.edgeColor);
        Typeface typeface = userStyle.getTypeface();
        if (typeface != null) {
            if (Typeface.MONOSPACE.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(1);
            } else if (!Typeface.SANS_SERIF.equals(typeface) && Typeface.SERIF.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(2);
            } else {
                textTrackStyle.setFontGenericFamily(0);
            }
            boolean zIsBold = typeface.isBold();
            boolean zIsItalic = typeface.isItalic();
            if (zIsBold && zIsItalic) {
                textTrackStyle.setFontStyle(3);
            } else if (zIsBold) {
                textTrackStyle.setFontStyle(1);
            } else if (zIsItalic) {
                textTrackStyle.setFontStyle(2);
            } else {
                textTrackStyle.setFontStyle(0);
            }
        }
        return textTrackStyle;
    }

    private String zzL(int i) {
        return String.format("#%02X%02X%02X%02X", Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Integer.valueOf(Color.alpha(i)));
    }

    private int zzcd(String str) {
        if (str == null || str.length() != 9 || str.charAt(0) != '#') {
            return 0;
        }
        try {
            return Color.argb(Integer.parseInt(str.substring(7, 9), 16), Integer.parseInt(str.substring(1, 3), 16), Integer.parseInt(str.substring(3, 5), 16), Integer.parseInt(str.substring(5, 7), 16));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextTrackStyle)) {
            return false;
        }
        TextTrackStyle textTrackStyle = (TextTrackStyle) other;
        if ((this.zzaaU == null) != (textTrackStyle.zzaaU == null)) {
            return false;
        }
        if (this.zzaaU == null || textTrackStyle.zzaaU == null || zznb.zze(this.zzaaU, textTrackStyle.zzaaU)) {
            return this.zzaco == textTrackStyle.zzaco && this.zzacp == textTrackStyle.zzacp && this.zzxO == textTrackStyle.zzxO && this.zzacq == textTrackStyle.zzacq && this.zzacr == textTrackStyle.zzacr && this.zzacs == textTrackStyle.zzacs && this.zzacu == textTrackStyle.zzacu && zzf.zza(this.zzacv, textTrackStyle.zzacv) && this.zzacw == textTrackStyle.zzacw && this.zzacx == textTrackStyle.zzacx;
        }
        return false;
    }

    public int getBackgroundColor() {
        return this.zzxO;
    }

    public JSONObject getCustomData() {
        return this.zzaaU;
    }

    public int getEdgeColor() {
        return this.zzacr;
    }

    public int getEdgeType() {
        return this.zzacq;
    }

    public String getFontFamily() {
        return this.zzacv;
    }

    public int getFontGenericFamily() {
        return this.zzacw;
    }

    public float getFontScale() {
        return this.zzaco;
    }

    public int getFontStyle() {
        return this.zzacx;
    }

    public int getForegroundColor() {
        return this.zzacp;
    }

    public int getWindowColor() {
        return this.zzact;
    }

    public int getWindowCornerRadius() {
        return this.zzacu;
    }

    public int getWindowType() {
        return this.zzacs;
    }

    public int hashCode() {
        return zzw.hashCode(Float.valueOf(this.zzaco), Integer.valueOf(this.zzacp), Integer.valueOf(this.zzxO), Integer.valueOf(this.zzacq), Integer.valueOf(this.zzacr), Integer.valueOf(this.zzacs), Integer.valueOf(this.zzact), Integer.valueOf(this.zzacu), this.zzacv, Integer.valueOf(this.zzacw), Integer.valueOf(this.zzacx), this.zzaaU);
    }

    public void setBackgroundColor(int backgroundColor) {
        this.zzxO = backgroundColor;
    }

    public void setCustomData(JSONObject customData) {
        this.zzaaU = customData;
    }

    public void setEdgeColor(int edgeColor) {
        this.zzacr = edgeColor;
    }

    public void setEdgeType(int edgeType) {
        if (edgeType < 0 || edgeType > 4) {
            throw new IllegalArgumentException("invalid edgeType");
        }
        this.zzacq = edgeType;
    }

    public void setFontFamily(String fontFamily) {
        this.zzacv = fontFamily;
    }

    public void setFontGenericFamily(int fontGenericFamily) {
        if (fontGenericFamily < 0 || fontGenericFamily > 6) {
            throw new IllegalArgumentException("invalid fontGenericFamily");
        }
        this.zzacw = fontGenericFamily;
    }

    public void setFontScale(float fontScale) {
        this.zzaco = fontScale;
    }

    public void setFontStyle(int fontStyle) {
        if (fontStyle < 0 || fontStyle > 3) {
            throw new IllegalArgumentException("invalid fontStyle");
        }
        this.zzacx = fontStyle;
    }

    public void setForegroundColor(int foregroundColor) {
        this.zzacp = foregroundColor;
    }

    public void setWindowColor(int windowColor) {
        this.zzact = windowColor;
    }

    public void setWindowCornerRadius(int windowCornerRadius) {
        if (windowCornerRadius < 0) {
            throw new IllegalArgumentException("invalid windowCornerRadius");
        }
        this.zzacu = windowCornerRadius;
    }

    public void setWindowType(int windowType) {
        if (windowType < 0 || windowType > 2) {
            throw new IllegalArgumentException("invalid windowType");
        }
        this.zzacs = windowType;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fontScale", this.zzaco);
            if (this.zzacp != 0) {
                jSONObject.put("foregroundColor", zzL(this.zzacp));
            }
            if (this.zzxO != 0) {
                jSONObject.put("backgroundColor", zzL(this.zzxO));
            }
            switch (this.zzacq) {
                case 0:
                    jSONObject.put("edgeType", "NONE");
                    break;
                case 1:
                    jSONObject.put("edgeType", "OUTLINE");
                    break;
                case 2:
                    jSONObject.put("edgeType", "DROP_SHADOW");
                    break;
                case 3:
                    jSONObject.put("edgeType", "RAISED");
                    break;
                case 4:
                    jSONObject.put("edgeType", "DEPRESSED");
                    break;
            }
            if (this.zzacr != 0) {
                jSONObject.put("edgeColor", zzL(this.zzacr));
            }
            switch (this.zzacs) {
                case 0:
                    jSONObject.put("windowType", "NONE");
                    break;
                case 1:
                    jSONObject.put("windowType", "NORMAL");
                    break;
                case 2:
                    jSONObject.put("windowType", "ROUNDED_CORNERS");
                    break;
            }
            if (this.zzact != 0) {
                jSONObject.put("windowColor", zzL(this.zzact));
            }
            if (this.zzacs == 2) {
                jSONObject.put("windowRoundedCornerRadius", this.zzacu);
            }
            if (this.zzacv != null) {
                jSONObject.put("fontFamily", this.zzacv);
            }
            switch (this.zzacw) {
                case 0:
                    jSONObject.put("fontGenericFamily", "SANS_SERIF");
                    break;
                case 1:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SANS_SERIF");
                    break;
                case 2:
                    jSONObject.put("fontGenericFamily", "SERIF");
                    break;
                case 3:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SERIF");
                    break;
                case 4:
                    jSONObject.put("fontGenericFamily", "CASUAL");
                    break;
                case 5:
                    jSONObject.put("fontGenericFamily", "CURSIVE");
                    break;
                case 6:
                    jSONObject.put("fontGenericFamily", "SMALL_CAPITALS");
                    break;
            }
            switch (this.zzacx) {
                case 0:
                    jSONObject.put("fontStyle", "NORMAL");
                    break;
                case 1:
                    jSONObject.put("fontStyle", "BOLD");
                    break;
                case 2:
                    jSONObject.put("fontStyle", "ITALIC");
                    break;
                case 3:
                    jSONObject.put("fontStyle", "BOLD_ITALIC");
                    break;
            }
            if (this.zzaaU != null) {
                jSONObject.put("customData", this.zzaaU);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public void zzg(JSONObject jSONObject) throws JSONException {
        clear();
        this.zzaco = (float) jSONObject.optDouble("fontScale", 1.0d);
        this.zzacp = zzcd(jSONObject.optString("foregroundColor"));
        this.zzxO = zzcd(jSONObject.optString("backgroundColor"));
        if (jSONObject.has("edgeType")) {
            String string = jSONObject.getString("edgeType");
            if ("NONE".equals(string)) {
                this.zzacq = 0;
            } else if ("OUTLINE".equals(string)) {
                this.zzacq = 1;
            } else if ("DROP_SHADOW".equals(string)) {
                this.zzacq = 2;
            } else if ("RAISED".equals(string)) {
                this.zzacq = 3;
            } else if ("DEPRESSED".equals(string)) {
                this.zzacq = 4;
            }
        }
        this.zzacr = zzcd(jSONObject.optString("edgeColor"));
        if (jSONObject.has("windowType")) {
            String string2 = jSONObject.getString("windowType");
            if ("NONE".equals(string2)) {
                this.zzacs = 0;
            } else if ("NORMAL".equals(string2)) {
                this.zzacs = 1;
            } else if ("ROUNDED_CORNERS".equals(string2)) {
                this.zzacs = 2;
            }
        }
        this.zzact = zzcd(jSONObject.optString("windowColor"));
        if (this.zzacs == 2) {
            this.zzacu = jSONObject.optInt("windowRoundedCornerRadius", 0);
        }
        this.zzacv = jSONObject.optString("fontFamily", null);
        if (jSONObject.has("fontGenericFamily")) {
            String string3 = jSONObject.getString("fontGenericFamily");
            if ("SANS_SERIF".equals(string3)) {
                this.zzacw = 0;
            } else if ("MONOSPACED_SANS_SERIF".equals(string3)) {
                this.zzacw = 1;
            } else if ("SERIF".equals(string3)) {
                this.zzacw = 2;
            } else if ("MONOSPACED_SERIF".equals(string3)) {
                this.zzacw = 3;
            } else if ("CASUAL".equals(string3)) {
                this.zzacw = 4;
            } else if ("CURSIVE".equals(string3)) {
                this.zzacw = 5;
            } else if ("SMALL_CAPITALS".equals(string3)) {
                this.zzacw = 6;
            }
        }
        if (jSONObject.has("fontStyle")) {
            String string4 = jSONObject.getString("fontStyle");
            if ("NORMAL".equals(string4)) {
                this.zzacx = 0;
            } else if ("BOLD".equals(string4)) {
                this.zzacx = 1;
            } else if ("ITALIC".equals(string4)) {
                this.zzacx = 2;
            } else if ("BOLD_ITALIC".equals(string4)) {
                this.zzacx = 3;
            }
        }
        this.zzaaU = jSONObject.optJSONObject("customData");
    }
}
