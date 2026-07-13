package com.google.android.gms.ads.internal.overlay;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.google.android.gms.internal.zzhb;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzo extends FrameLayout implements View.OnClickListener {
    private final ImageButton zzEW;
    private final zzs zzEX;

    public zzo(Context context, int i, zzs zzsVar) {
        super(context);
        this.zzEX = zzsVar;
        setOnClickListener(this);
        this.zzEW = new ImageButton(context);
        this.zzEW.setImageResource(R.drawable.btn_dialog);
        this.zzEW.setBackgroundColor(0);
        this.zzEW.setOnClickListener(this);
        this.zzEW.setPadding(0, 0, 0, 0);
        this.zzEW.setContentDescription("Interstitial close button");
        int iZzb = com.google.android.gms.ads.internal.client.zzn.zzcS().zzb(context, i);
        addView(this.zzEW, new FrameLayout.LayoutParams(iZzb, iZzb, 17));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.zzEX != null) {
            this.zzEX.zzfm();
        }
    }

    public void zza(boolean z, boolean z2) {
        if (!z2) {
            this.zzEW.setVisibility(0);
        } else if (z) {
            this.zzEW.setVisibility(4);
        } else {
            this.zzEW.setVisibility(8);
        }
    }
}
