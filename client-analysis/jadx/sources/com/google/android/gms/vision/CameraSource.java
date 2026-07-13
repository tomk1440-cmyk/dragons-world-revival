package com.google.android.gms.vision;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.os.SystemClock;
import android.support.annotation.RequiresPermission;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import com.google.android.gms.common.images.Size;
import com.google.android.gms.nearby.messages.Strategy;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CameraSource {

    @SuppressLint({"InlinedApi"})
    public static final int CAMERA_FACING_BACK = 0;

    @SuppressLint({"InlinedApi"})
    public static final int CAMERA_FACING_FRONT = 1;
    private Context mContext;
    private int zzDE;
    private Camera zzbmA;
    private int zzbmB;
    private Size zzbmC;
    private float zzbmD;
    private int zzbmE;
    private int zzbmF;
    private boolean zzbmG;
    private SurfaceView zzbmH;
    private SurfaceTexture zzbmI;
    private boolean zzbmJ;
    private Thread zzbmK;
    private zzb zzbmL;
    private Map<byte[], ByteBuffer> zzbmM;
    private final Object zzbmz;

    public static class Builder {
        private final Detector<?> zzbmN;
        private CameraSource zzbmO = new CameraSource();

        public Builder(Context context, Detector<?> detector) {
            if (context == null) {
                throw new IllegalArgumentException("No context supplied.");
            }
            if (detector == null) {
                throw new IllegalArgumentException("No detector supplied.");
            }
            this.zzbmN = detector;
            this.zzbmO.mContext = context;
        }

        public CameraSource build() {
            CameraSource cameraSource = this.zzbmO;
            CameraSource cameraSource2 = this.zzbmO;
            cameraSource2.getClass();
            cameraSource.zzbmL = cameraSource2.new zzb(this.zzbmN);
            return this.zzbmO;
        }

        public Builder setAutoFocusEnabled(boolean autoFocusEnabled) {
            this.zzbmO.zzbmG = autoFocusEnabled;
            return this;
        }

        public Builder setFacing(int facing) {
            if (facing != 0 && facing != 1) {
                throw new IllegalArgumentException("Invalid camera: " + facing);
            }
            this.zzbmO.zzbmB = facing;
            return this;
        }

        public Builder setRequestedFps(float fps) {
            if (fps <= 0.0f) {
                throw new IllegalArgumentException("Invalid fps: " + fps);
            }
            this.zzbmO.zzbmD = fps;
            return this;
        }

        public Builder setRequestedPreviewSize(int width, int height) {
            if (width <= 0 || width > 1000000 || height <= 0 || height > 1000000) {
                throw new IllegalArgumentException("Invalid preview size: " + width + "x" + height);
            }
            this.zzbmO.zzbmE = width;
            this.zzbmO.zzbmF = height;
            return this;
        }
    }

    public interface PictureCallback {
        void onPictureTaken(byte[] bArr);
    }

    public interface ShutterCallback {
        void onShutter();
    }

    private class zza implements Camera.PreviewCallback {
        private zza() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] data, Camera camera) {
            CameraSource.this.zzbmL.zza(data, camera);
        }
    }

    private class zzb implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled;
        private Detector<?> zzbmN;
        private long zzbmR;
        private ByteBuffer zzbmT;
        private long zzRD = SystemClock.elapsedRealtime();
        private final Object zzpV = new Object();
        private boolean zzbmQ = true;
        private int zzbmS = 0;

        static {
            $assertionsDisabled = !CameraSource.class.desiredAssertionStatus();
        }

        zzb(Detector<?> detector) {
            this.zzbmN = detector;
        }

        @SuppressLint({"Assert"})
        void release() {
            if (!$assertionsDisabled && CameraSource.this.zzbmK.getState() != Thread.State.TERMINATED) {
                throw new AssertionError();
            }
            this.zzbmN.release();
            this.zzbmN = null;
        }

        @Override // java.lang.Runnable
        @SuppressLint({"InlinedApi"})
        public void run() {
            Frame frameBuild;
            ByteBuffer byteBuffer;
            while (true) {
                synchronized (this.zzpV) {
                    if (this.zzbmQ && this.zzbmT == null) {
                        try {
                            this.zzpV.wait();
                        } catch (InterruptedException e) {
                            Log.d("CameraSource", "Frame processing loop terminated.", e);
                            return;
                        }
                    }
                    if (!this.zzbmQ) {
                        return;
                    }
                    frameBuild = new Frame.Builder().setImageData(this.zzbmT, CameraSource.this.zzbmC.getWidth(), CameraSource.this.zzbmC.getHeight(), 17).setId(this.zzbmS).setTimestampMillis(this.zzbmR).setRotation(CameraSource.this.zzDE).build();
                    byteBuffer = this.zzbmT;
                    this.zzbmT = null;
                }
                try {
                    try {
                        this.zzbmN.receiveFrame(frameBuild);
                        CameraSource.this.zzbmA.addCallbackBuffer(byteBuffer.array());
                    } catch (Throwable th) {
                        Log.e("CameraSource", "Exception thrown from receiver.", th);
                        CameraSource.this.zzbmA.addCallbackBuffer(byteBuffer.array());
                    }
                } catch (Throwable th2) {
                    CameraSource.this.zzbmA.addCallbackBuffer(byteBuffer.array());
                    throw th2;
                }
            }
        }

        void setActive(boolean active) {
            synchronized (this.zzpV) {
                this.zzbmQ = active;
                this.zzpV.notifyAll();
            }
        }

        void zza(byte[] bArr, Camera camera) {
            synchronized (this.zzpV) {
                if (this.zzbmT != null) {
                    camera.addCallbackBuffer(this.zzbmT.array());
                    this.zzbmT = null;
                }
                this.zzbmR = SystemClock.elapsedRealtime() - this.zzRD;
                this.zzbmS++;
                this.zzbmT = (ByteBuffer) CameraSource.this.zzbmM.get(bArr);
                this.zzpV.notifyAll();
            }
        }
    }

    private class zzc implements Camera.PictureCallback {
        private PictureCallback zzbmU;

        private zzc() {
        }

        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] data, Camera camera) {
            if (this.zzbmU != null) {
                this.zzbmU.onPictureTaken(data);
            }
            synchronized (CameraSource.this.zzbmz) {
                if (CameraSource.this.zzbmA != null) {
                    CameraSource.this.zzbmA.startPreview();
                }
            }
        }
    }

    private class zzd implements Camera.ShutterCallback {
        private ShutterCallback zzbmV;

        private zzd() {
        }

        @Override // android.hardware.Camera.ShutterCallback
        public void onShutter() {
            if (this.zzbmV != null) {
                this.zzbmV.onShutter();
            }
        }
    }

    private static class zze {
        private Size zzbmW;
        private Size zzbmX;

        public zze(Camera.Size size, Camera.Size size2) {
            this.zzbmW = new Size(size.width, size.height);
            this.zzbmX = new Size(size2.width, size2.height);
        }

        public Size zzIc() {
            return this.zzbmW;
        }

        public Size zzId() {
            return this.zzbmX;
        }
    }

    private CameraSource() {
        this.zzbmz = new Object();
        this.zzbmB = 0;
        this.zzbmD = 30.0f;
        this.zzbmE = 1024;
        this.zzbmF = 768;
        this.zzbmG = false;
        this.zzbmM = new HashMap();
    }

    @SuppressLint({"InlinedApi"})
    private Camera zzIb() {
        int iZzkp = zzkp(this.zzbmB);
        if (iZzkp == -1) {
            throw new RuntimeException("Could not find requested camera.");
        }
        Camera cameraOpen = Camera.open(iZzkp);
        zze zzeVarZza = zza(cameraOpen, this.zzbmE, this.zzbmF);
        if (zzeVarZza == null) {
            throw new RuntimeException("Could not find suitable preview size.");
        }
        Size sizeZzId = zzeVarZza.zzId();
        this.zzbmC = zzeVarZza.zzIc();
        int[] iArrZza = zza(cameraOpen, this.zzbmD);
        if (iArrZza == null) {
            throw new RuntimeException("Could not find suitable preview frames per second range.");
        }
        Camera.Parameters parameters = cameraOpen.getParameters();
        parameters.setPictureSize(sizeZzId.getWidth(), sizeZzId.getHeight());
        parameters.setPreviewSize(this.zzbmC.getWidth(), this.zzbmC.getHeight());
        parameters.setPreviewFpsRange(iArrZza[0], iArrZza[1]);
        parameters.setPreviewFormat(17);
        zza(cameraOpen, parameters, iZzkp);
        if (this.zzbmG) {
            if (parameters.getSupportedFocusModes().contains("continuous-video")) {
                parameters.setFocusMode("continuous-video");
            } else {
                Log.i("CameraSource", "Camera auto focus is not supported on this device.");
            }
        }
        cameraOpen.setParameters(parameters);
        cameraOpen.setPreviewCallbackWithBuffer(new zza());
        cameraOpen.addCallbackBuffer(zza(this.zzbmC));
        cameraOpen.addCallbackBuffer(zza(this.zzbmC));
        cameraOpen.addCallbackBuffer(zza(this.zzbmC));
        cameraOpen.addCallbackBuffer(zza(this.zzbmC));
        return cameraOpen;
    }

    private static zze zza(Camera camera, int i, int i2) {
        int i3;
        zze zzeVar;
        List<zze> listZza = zza(camera);
        zze zzeVar2 = null;
        int i4 = Strategy.TTL_SECONDS_INFINITE;
        for (zze zzeVar3 : listZza) {
            Size sizeZzIc = zzeVar3.zzIc();
            int iAbs = Math.abs(sizeZzIc.getHeight() - i2) + Math.abs(sizeZzIc.getWidth() - i);
            if (iAbs < i4) {
                zzeVar = zzeVar3;
                i3 = iAbs;
            } else {
                i3 = i4;
                zzeVar = zzeVar2;
            }
            i4 = i3;
            zzeVar2 = zzeVar;
        }
        return zzeVar2;
    }

    private static List<zze> zza(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
        ArrayList arrayList = new ArrayList();
        for (Camera.Size size : supportedPreviewSizes) {
            float f = size.width / size.height;
            for (Camera.Size size2 : supportedPictureSizes) {
                if (Math.abs(f - (size2.width / size2.height)) < 0.01f) {
                    arrayList.add(new zze(size, size2));
                    break;
                }
            }
        }
        if (arrayList.size() == 0) {
            Log.w("CameraSource", "No preview sizes have a corresponding same-aspect-ratio picture size");
            Iterator<Camera.Size> it = supportedPreviewSizes.iterator();
            while (it.hasNext()) {
                arrayList.add(new zze(it.next(), null));
            }
        }
        return arrayList;
    }

    private void zza(Camera camera, Camera.Parameters parameters, int i) {
        int i2;
        int i3;
        int i4;
        int rotation = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
        switch (rotation) {
            case 0:
                i2 = 0;
                break;
            case 1:
                i2 = 90;
                break;
            case 2:
                i2 = 180;
                break;
            case 3:
                i2 = 270;
                break;
            default:
                Log.e("CameraSource", "Bad rotation value: " + rotation);
                i2 = 0;
                break;
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        if (cameraInfo.facing == 1) {
            i4 = (i2 + cameraInfo.orientation) % 360;
            i3 = (360 - i4) % 360;
        } else {
            i3 = ((cameraInfo.orientation - i2) + 360) % 360;
            i4 = i3;
        }
        this.zzDE = i4 / 90;
        camera.setDisplayOrientation(i3);
        parameters.setRotation(i4);
    }

    @SuppressLint({"InlinedApi"})
    private byte[] zza(Size size) {
        byte[] bArr = new byte[((int) Math.ceil(((double) (ImageFormat.getBitsPerPixel(17) * (size.getHeight() * size.getWidth()))) / 8.0d)) + 1];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        if (!byteBufferWrap.hasArray() || byteBufferWrap.array() != bArr) {
            throw new IllegalStateException("Failed to create valid buffer for camera source.");
        }
        this.zzbmM.put(bArr, byteBufferWrap);
        return bArr;
    }

    @SuppressLint({"InlinedApi"})
    private int[] zza(Camera camera, float f) {
        int i;
        int[] iArr;
        int i2 = (int) (1000.0f * f);
        int[] iArr2 = null;
        int i3 = Strategy.TTL_SECONDS_INFINITE;
        for (int[] iArr3 : camera.getParameters().getSupportedPreviewFpsRange()) {
            int iAbs = Math.abs(i2 - iArr3[0]) + Math.abs(i2 - iArr3[1]);
            if (iAbs < i3) {
                iArr = iArr3;
                i = iAbs;
            } else {
                i = i3;
                iArr = iArr2;
            }
            i3 = i;
            iArr2 = iArr;
        }
        return iArr2;
    }

    private static int zzkp(int i) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == i) {
                return i2;
            }
        }
        return -1;
    }

    public int getCameraFacing() {
        return this.zzbmB;
    }

    public Size getPreviewSize() {
        return this.zzbmC;
    }

    public void release() {
        synchronized (this.zzbmz) {
            stop();
            this.zzbmL.release();
        }
    }

    @RequiresPermission("android.permission.CAMERA")
    public CameraSource start() throws IOException {
        synchronized (this.zzbmz) {
            if (this.zzbmA == null) {
                this.zzbmA = zzIb();
                if (Build.VERSION.SDK_INT >= 11) {
                    this.zzbmI = new SurfaceTexture(100);
                    this.zzbmA.setPreviewTexture(this.zzbmI);
                    this.zzbmJ = true;
                } else {
                    this.zzbmH = new SurfaceView(this.mContext);
                    this.zzbmA.setPreviewDisplay(this.zzbmH.getHolder());
                    this.zzbmJ = false;
                }
                this.zzbmA.startPreview();
                this.zzbmK = new Thread(this.zzbmL);
                this.zzbmL.setActive(true);
                this.zzbmK.start();
            }
        }
        return this;
    }

    @RequiresPermission("android.permission.CAMERA")
    public CameraSource start(SurfaceHolder surfaceHolder) throws IOException {
        synchronized (this.zzbmz) {
            if (this.zzbmA == null) {
                this.zzbmA = zzIb();
                this.zzbmA.setPreviewDisplay(surfaceHolder);
                this.zzbmA.startPreview();
                this.zzbmK = new Thread(this.zzbmL);
                this.zzbmL.setActive(true);
                this.zzbmK.start();
                this.zzbmJ = false;
            }
        }
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0019 A[Catch: all -> 0x0046, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x000d, B:8:0x0013, B:9:0x0015, B:11:0x0019, B:12:0x0024, B:14:0x0028, B:15:0x002e, B:24:0x0049, B:27:0x0051, B:16:0x0036, B:17:0x003b, B:20:0x003e), top: B:32:0x0003, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:14:0x0028 A[Catch: all -> 0x0046, Exception -> 0x0050, TRY_LEAVE, TryCatch #0 {Exception -> 0x0050, blocks: (B:12:0x0024, B:14:0x0028, B:24:0x0049), top: B:30:0x0024, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:16:0x0036 A[Catch: all -> 0x0046, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x000d, B:8:0x0013, B:9:0x0015, B:11:0x0019, B:12:0x0024, B:14:0x0028, B:15:0x002e, B:24:0x0049, B:27:0x0051, B:16:0x0036, B:17:0x003b, B:20:0x003e), top: B:32:0x0003, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x0049 A[Catch: all -> 0x0046, Exception -> 0x0050, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x0050, blocks: (B:12:0x0024, B:14:0x0028, B:24:0x0049), top: B:30:0x0024, outer: #1 }] */
    public void stop() {
        synchronized (this.zzbmz) {
            this.zzbmL.setActive(false);
            if (this.zzbmK != null) {
                try {
                    this.zzbmK.join();
                } catch (InterruptedException e) {
                    Log.d("CameraSource", "Frame processing thread interrupted on release.");
                }
                this.zzbmK = null;
                if (this.zzbmA != null) {
                    this.zzbmA.stopPreview();
                    this.zzbmA.setPreviewCallbackWithBuffer(null);
                    try {
                        if (this.zzbmJ) {
                            this.zzbmA.setPreviewTexture(null);
                        } else {
                            this.zzbmA.setPreviewDisplay(null);
                        }
                    } catch (Exception e2) {
                        Log.e("CameraSource", "Failed to clear camera preview: " + e2);
                    }
                    this.zzbmA.release();
                    this.zzbmA = null;
                    this.zzbmM.clear();
                } else {
                    this.zzbmM.clear();
                }
            } else if (this.zzbmA != null) {
                this.zzbmA.stopPreview();
                this.zzbmA.setPreviewCallbackWithBuffer(null);
                if (this.zzbmJ) {
                    this.zzbmA.setPreviewTexture(null);
                } else {
                    this.zzbmA.setPreviewDisplay(null);
                }
                this.zzbmA.release();
                this.zzbmA = null;
                this.zzbmM.clear();
            } else {
                this.zzbmM.clear();
            }
            throw th;
        }
    }

    public void takePicture(ShutterCallback shutter, PictureCallback jpeg) {
        synchronized (this.zzbmz) {
            if (this.zzbmA != null) {
                zzd zzdVar = new zzd();
                zzdVar.zzbmV = shutter;
                zzc zzcVar = new zzc();
                zzcVar.zzbmU = jpeg;
                this.zzbmA.takePicture(zzdVar, null, null, zzcVar);
            }
        }
    }
}
