package com.unity3d.ads.misc;

import android.os.Handler;
import android.os.Looper;
import com.facebook.appevents.AppEventsConstants;
import com.unity3d.ads.log.DeviceLog;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
public class Utilities {
    public static void runOnUiThread(Runnable runnable) {
        runOnUiThread(runnable, 0L);
    }

    public static void runOnUiThread(Runnable runnable, long delay) {
        Handler handler = new Handler(Looper.getMainLooper());
        if (delay > 0) {
            handler.postDelayed(runnable, delay);
        } else {
            handler.post(runnable);
        }
    }

    public static String Sha256(String input) {
        return Sha256(input.getBytes());
    }

    public static String Sha256(byte[] input) {
        if (input == null) {
            return null;
        }
        try {
            MessageDigest m = MessageDigest.getInstance("SHA-256");
            m.update(input, 0, input.length);
            return toHexString(m.digest());
        } catch (NoSuchAlgorithmException e) {
            DeviceLog.exception("SHA-256 algorithm not found", e);
            return null;
        }
    }

    public static String toHexString(byte[] array) {
        String output = "";
        for (byte rawByte : array) {
            int b = rawByte & 255;
            if (b <= 15) {
                output = output + AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            output = output + Integer.toHexString(b);
        }
        return output;
    }

    public static boolean writeFile(File fileToWrite, String content) throws Throwable {
        if (fileToWrite == null) {
            return false;
        }
        FileOutputStream fos = null;
        boolean success = true;
        try {
            try {
                FileOutputStream fos2 = new FileOutputStream(fileToWrite);
                try {
                    fos2.write(content.getBytes());
                    fos2.flush();
                    if (fos2 != null) {
                        try {
                            fos2.close();
                        } catch (Exception e) {
                            DeviceLog.exception("Error closing FileOutputStream", e);
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    fos = fos2;
                    success = false;
                    DeviceLog.exception("Could not write file", e);
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (Exception e3) {
                            DeviceLog.exception("Error closing FileOutputStream", e3);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fos = fos2;
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (Exception e4) {
                            DeviceLog.exception("Error closing FileOutputStream", e4);
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
            }
            if (success) {
                DeviceLog.debug("Wrote file: " + fileToWrite.getAbsolutePath());
                return success;
            }
            return success;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String readFile(File fileToRead) {
        if (fileToRead == null) {
            return null;
        }
        String fileContent = "";
        BufferedReader br = null;
        FileReader fr = null;
        if (fileToRead.exists() && fileToRead.canRead()) {
            try {
                FileReader fr2 = new FileReader(fileToRead);
                try {
                    BufferedReader br2 = new BufferedReader(fr2);
                    while (true) {
                        try {
                            String line = br2.readLine();
                            if (line == null) {
                                break;
                            }
                            fileContent = fileContent.concat(line);
                        } catch (Exception e) {
                            e = e;
                            fr = fr2;
                            br = br2;
                            DeviceLog.exception("Problem reading file", e);
                            fileContent = null;
                        }
                    }
                    fr = fr2;
                    br = br2;
                } catch (Exception e2) {
                    e = e2;
                    fr = fr2;
                }
            } catch (Exception e3) {
                e = e3;
            }
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e4) {
                    DeviceLog.exception("Couldn't close BufferedReader", e4);
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                    return fileContent;
                } catch (Exception e5) {
                    DeviceLog.exception("Couldn't close FileReader", e5);
                    return fileContent;
                }
            }
            return fileContent;
        }
        DeviceLog.error("File did not exist or couldn't be read");
        return null;
    }

    public static byte[] readFileBytes(File file) throws IOException {
        if (file == null) {
            return null;
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        InputStream inputStream = new FileInputStream(file);
        byte[] buffer = new byte[4096];
        while (true) {
            int read = inputStream.read(buffer);
            if (read != -1) {
                outputStream.write(buffer, 0, read);
            } else {
                outputStream.close();
                inputStream.close();
                return outputStream.toByteArray();
            }
        }
    }
}
