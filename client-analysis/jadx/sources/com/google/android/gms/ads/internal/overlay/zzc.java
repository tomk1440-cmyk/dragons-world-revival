package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzir;
import com.prime31.util.IabHelperImpl;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzhb
@TargetApi(14)
public class zzc extends zzi implements AudioManager.OnAudioFocusChangeListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    private static final Map<Integer, String> zzDN = new HashMap();
    private final zzt zzDO;
    private int zzDP;
    private int zzDQ;
    private MediaPlayer zzDR;
    private Uri zzDS;
    private int zzDT;
    private int zzDU;
    private int zzDV;
    private int zzDW;
    private int zzDX;
    private float zzDY;
    private boolean zzDZ;
    private boolean zzEa;
    private int zzEb;
    private zzh zzEc;

    static {
        zzDN.put(Integer.valueOf(IabHelperImpl.IABHELPER_SEND_INTENT_FAILED), "MEDIA_ERROR_IO");
        zzDN.put(Integer.valueOf(IabHelperImpl.IABHELPER_MISSING_TOKEN), "MEDIA_ERROR_MALFORMED");
        zzDN.put(Integer.valueOf(IabHelperImpl.IABHELPER_INVALID_CONSUMPTION), "MEDIA_ERROR_UNSUPPORTED");
        zzDN.put(-110, "MEDIA_ERROR_TIMED_OUT");
        zzDN.put(100, "MEDIA_ERROR_SERVER_DIED");
        zzDN.put(1, "MEDIA_ERROR_UNKNOWN");
        zzDN.put(1, "MEDIA_INFO_UNKNOWN");
        zzDN.put(700, "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        zzDN.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        zzDN.put(701, "MEDIA_INFO_BUFFERING_START");
        zzDN.put(702, "MEDIA_INFO_BUFFERING_END");
        zzDN.put(800, "MEDIA_INFO_BAD_INTERLEAVING");
        zzDN.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        zzDN.put(802, "MEDIA_INFO_METADATA_UPDATE");
        zzDN.put(901, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
        zzDN.put(902, "MEDIA_INFO_SUBTITLE_TIMED_OUT");
    }

    public zzc(Context context, zzt zztVar) {
        super(context);
        this.zzDP = 0;
        this.zzDQ = 0;
        this.zzDY = 1.0f;
        setSurfaceTextureListener(this);
        this.zzDO = zztVar;
        this.zzDO.zza((zzi) this);
    }

    private void zzb(float f) {
        if (this.zzDR == null) {
            zzin.zzaK("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
        } else {
            try {
                this.zzDR.setVolume(f, f);
            } catch (IllegalStateException e) {
            }
        }
    }

    private void zzfa() {
        zzin.v("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.zzDS == null || surfaceTexture == null) {
            return;
        }
        zzv(false);
        try {
            this.zzDR = new MediaPlayer();
            this.zzDR.setOnBufferingUpdateListener(this);
            this.zzDR.setOnCompletionListener(this);
            this.zzDR.setOnErrorListener(this);
            this.zzDR.setOnInfoListener(this);
            this.zzDR.setOnPreparedListener(this);
            this.zzDR.setOnVideoSizeChangedListener(this);
            this.zzDV = 0;
            this.zzDR.setDataSource(getContext(), this.zzDS);
            this.zzDR.setSurface(new Surface(surfaceTexture));
            this.zzDR.setAudioStreamType(3);
            this.zzDR.setScreenOnWhilePlaying(true);
            this.zzDR.prepareAsync();
            zzw(1);
        } catch (IOException | IllegalArgumentException e) {
            zzin.zzd("Failed to initialize MediaPlayer at " + this.zzDS, e);
            onError(this.zzDR, 1, 0);
        }
    }

    private void zzfb() {
        if (!zzfe() || this.zzDR.getCurrentPosition() <= 0 || this.zzDQ == 3) {
            return;
        }
        zzin.v("AdMediaPlayerView nudging MediaPlayer");
        zzb(0.0f);
        this.zzDR.start();
        int currentPosition = this.zzDR.getCurrentPosition();
        long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzr.zzbG().currentTimeMillis();
        while (zzfe() && this.zzDR.getCurrentPosition() == currentPosition && com.google.android.gms.ads.internal.zzr.zzbG().currentTimeMillis() - jCurrentTimeMillis <= 250) {
        }
        this.zzDR.pause();
        zzfj();
    }

    private void zzfc() {
        AudioManager audioManagerZzfk = zzfk();
        if (audioManagerZzfk == null || this.zzEa) {
            return;
        }
        if (audioManagerZzfk.requestAudioFocus(this, 3, 2) == 1) {
            zzfh();
        } else {
            zzin.zzaK("AdMediaPlayerView audio focus request failed");
        }
    }

    private void zzfd() {
        zzin.v("AdMediaPlayerView abandon audio focus");
        AudioManager audioManagerZzfk = zzfk();
        if (audioManagerZzfk == null || !this.zzEa) {
            return;
        }
        if (audioManagerZzfk.abandonAudioFocus(this) == 1) {
            this.zzEa = false;
        } else {
            zzin.zzaK("AdMediaPlayerView abandon audio focus failed");
        }
    }

    private boolean zzfe() {
        return (this.zzDR == null || this.zzDP == -1 || this.zzDP == 0 || this.zzDP == 1) ? false : true;
    }

    private void zzfh() {
        zzin.v("AdMediaPlayerView audio focus gained");
        this.zzEa = true;
        zzfj();
    }

    private void zzfi() {
        zzin.v("AdMediaPlayerView audio focus lost");
        this.zzEa = false;
        zzfj();
    }

    private void zzfj() {
        if (this.zzDZ || !this.zzEa) {
            zzb(0.0f);
        } else {
            zzb(this.zzDY);
        }
    }

    private AudioManager zzfk() {
        return (AudioManager) getContext().getSystemService("audio");
    }

    private void zzv(boolean z) {
        zzin.v("AdMediaPlayerView release");
        if (this.zzDR != null) {
            this.zzDR.reset();
            this.zzDR.release();
            this.zzDR = null;
            zzw(0);
            if (z) {
                this.zzDQ = 0;
                zzx(0);
            }
            zzfd();
        }
    }

    private void zzw(int i) {
        if (i == 3) {
            this.zzDO.zzfO();
        } else if (this.zzDP == 3 && i != 3) {
            this.zzDO.zzfP();
        }
        this.zzDP = i;
    }

    private void zzx(int i) {
        this.zzDQ = i;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public int getCurrentPosition() {
        if (zzfe()) {
            return this.zzDR.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public int getDuration() {
        if (zzfe()) {
            return this.zzDR.getDuration();
        }
        return -1;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public int getVideoHeight() {
        if (this.zzDR != null) {
            return this.zzDR.getVideoHeight();
        }
        return 0;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public int getVideoWidth() {
        if (this.zzDR != null) {
            return this.zzDR.getVideoWidth();
        }
        return 0;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int focusChange) {
        if (focusChange > 0) {
            zzfh();
        } else if (focusChange < 0) {
            zzfi();
        }
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mp, int percent) {
        this.zzDV = percent;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mp) {
        zzin.v("AdMediaPlayerView completion");
        zzw(5);
        zzx(5);
        zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzc.2
            @Override // java.lang.Runnable
            public void run() {
                if (zzc.this.zzEc != null) {
                    zzc.this.zzEc.zzfB();
                }
            }
        });
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mp, int what, int extra) {
        final String str = zzDN.get(Integer.valueOf(what));
        final String str2 = zzDN.get(Integer.valueOf(extra));
        zzin.zzaK("AdMediaPlayerView MediaPlayer error: " + str + ":" + str2);
        zzw(-1);
        zzx(-1);
        zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzc.3
            @Override // java.lang.Runnable
            public void run() {
                if (zzc.this.zzEc != null) {
                    zzc.this.zzEc.zzg(str, str2);
                }
            }
        });
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mp, int what, int extra) {
        zzin.v("AdMediaPlayerView MediaPlayer info: " + zzDN.get(Integer.valueOf(what)) + ":" + zzDN.get(Integer.valueOf(extra)));
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int defaultSize = getDefaultSize(this.zzDT, widthMeasureSpec);
        int defaultSize2 = getDefaultSize(this.zzDU, heightMeasureSpec);
        if (this.zzDT > 0 && this.zzDU > 0) {
            int mode = View.MeasureSpec.getMode(widthMeasureSpec);
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
            defaultSize2 = View.MeasureSpec.getSize(heightMeasureSpec);
            if (mode == 1073741824 && mode2 == 1073741824) {
                if (this.zzDT * defaultSize2 < this.zzDU * size) {
                    defaultSize = (this.zzDT * defaultSize2) / this.zzDU;
                } else if (this.zzDT * defaultSize2 > this.zzDU * size) {
                    defaultSize2 = (this.zzDU * size) / this.zzDT;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode == 1073741824) {
                int i = (this.zzDU * size) / this.zzDT;
                if (mode2 != Integer.MIN_VALUE || i <= defaultSize2) {
                    defaultSize2 = i;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode2 == 1073741824) {
                defaultSize = (this.zzDT * defaultSize2) / this.zzDU;
                if (mode == Integer.MIN_VALUE && defaultSize > size) {
                    defaultSize = size;
                }
            } else {
                int i2 = this.zzDT;
                int i3 = this.zzDU;
                if (mode2 != Integer.MIN_VALUE || i3 <= defaultSize2) {
                    defaultSize2 = i3;
                    defaultSize = i2;
                } else {
                    defaultSize = (this.zzDT * defaultSize2) / this.zzDU;
                }
                if (mode == Integer.MIN_VALUE && defaultSize > size) {
                    defaultSize2 = (this.zzDU * size) / this.zzDT;
                    defaultSize = size;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
        if (Build.VERSION.SDK_INT == 16) {
            if ((this.zzDW > 0 && this.zzDW != defaultSize) || (this.zzDX > 0 && this.zzDX != defaultSize2)) {
                zzfb();
            }
            this.zzDW = defaultSize;
            this.zzDX = defaultSize2;
        }
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        zzin.v("AdMediaPlayerView prepared");
        zzw(2);
        this.zzDO.zzfz();
        zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzc.1
            @Override // java.lang.Runnable
            public void run() {
                if (zzc.this.zzEc != null) {
                    zzc.this.zzEc.zzfz();
                }
            }
        });
        this.zzDT = mediaPlayer.getVideoWidth();
        this.zzDU = mediaPlayer.getVideoHeight();
        if (this.zzEb != 0) {
            seekTo(this.zzEb);
        }
        zzfb();
        zzin.zzaJ("AdMediaPlayerView stream dimensions: " + this.zzDT + " x " + this.zzDU);
        if (this.zzDQ == 3) {
            play();
        }
        zzfc();
        zzfj();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        zzin.v("AdMediaPlayerView surface created");
        zzfa();
        zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzc.4
            @Override // java.lang.Runnable
            public void run() {
                if (zzc.this.zzEc != null) {
                    zzc.this.zzEc.zzfy();
                }
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        zzin.v("AdMediaPlayerView surface destroyed");
        if (this.zzDR != null && this.zzEb == 0) {
            this.zzEb = this.zzDR.getCurrentPosition();
        }
        zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzc.5
            @Override // java.lang.Runnable
            public void run() {
                if (zzc.this.zzEc != null) {
                    zzc.this.zzEc.onPaused();
                    zzc.this.zzEc.zzfC();
                }
            }
        });
        zzv(true);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int w, int h) {
        zzin.v("AdMediaPlayerView surface changed");
        boolean z = this.zzDQ == 3;
        boolean z2 = this.zzDT == w && this.zzDU == h;
        if (this.zzDR != null && z && z2) {
            if (this.zzEb != 0) {
                seekTo(this.zzEb);
            }
            play();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
        this.zzDO.zzb(this);
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
        zzin.v("AdMediaPlayerView size changed: " + width + " x " + height);
        this.zzDT = mp.getVideoWidth();
        this.zzDU = mp.getVideoHeight();
        if (this.zzDT == 0 || this.zzDU == 0) {
            return;
        }
        requestLayout();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public void pause() {
        zzin.v("AdMediaPlayerView pause");
        if (zzfe() && this.zzDR.isPlaying()) {
            this.zzDR.pause();
            zzw(4);
            zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzc.7
                @Override // java.lang.Runnable
                public void run() {
                    if (zzc.this.zzEc != null) {
                        zzc.this.zzEc.onPaused();
                    }
                }
            });
        }
        zzx(4);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public void play() {
        zzin.v("AdMediaPlayerView play");
        if (zzfe()) {
            this.zzDR.start();
            zzw(3);
            zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzc.6
                @Override // java.lang.Runnable
                public void run() {
                    if (zzc.this.zzEc != null) {
                        zzc.this.zzEc.zzfA();
                    }
                }
            });
        }
        zzx(3);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public void seekTo(int millis) {
        zzin.v("AdMediaPlayerView seek " + millis);
        if (!zzfe()) {
            this.zzEb = millis;
        } else {
            this.zzDR.seekTo(millis);
            this.zzEb = 0;
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public void setMimeType(String mimeType) {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public void setVideoPath(String path) {
        setVideoURI(Uri.parse(path));
    }

    public void setVideoURI(Uri uri) {
        this.zzDS = uri;
        this.zzEb = 0;
        zzfa();
        requestLayout();
        invalidate();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public void stop() {
        zzin.v("AdMediaPlayerView stop");
        if (this.zzDR != null) {
            this.zzDR.stop();
            this.zzDR.release();
            this.zzDR = null;
            zzw(0);
            zzx(0);
            zzfd();
        }
        this.zzDO.onStop();
    }

    @Override // android.view.View
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public void zza(float f) {
        this.zzDY = f;
        zzfj();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public void zza(zzh zzhVar) {
        this.zzEc = zzhVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public String zzeZ() {
        return "MediaPlayer";
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public void zzff() {
        this.zzDZ = true;
        zzfj();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public void zzfg() {
        this.zzDZ = false;
        zzfj();
    }
}
