package com.socialquantum.dw.utils.android;

import android.util.Log;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class OdinGenerator {
    private static final String CHAR_SET = "iso-8859-1";
    private static final String SHA1_ALGORITHM = "SHA-1";
    private static final String TAG = "OdinGenerator";

    private static String convertToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 15;
            int two_halfs = 0;
            while (true) {
                if (halfbyte >= 0 && halfbyte <= 9) {
                    buf.append((char) (halfbyte + 48));
                } else {
                    buf.append((char) ((halfbyte - 10) + 97));
                }
                halfbyte = data[i] & 15;
                int two_halfs2 = two_halfs + 1;
                if (two_halfs >= 1) {
                    break;
                }
                two_halfs = two_halfs2;
            }
        }
        return buf.toString();
    }

    public static String SHA1(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] bArr = new byte[40];
            md.update(text.getBytes(CHAR_SET), 0, text.length());
            byte[] sha1hash = md.digest();
            return convertToHex(sha1hash);
        } catch (Exception e) {
            Log.e(TAG, "SHA generation exception " + e);
            return null;
        }
    }
}
