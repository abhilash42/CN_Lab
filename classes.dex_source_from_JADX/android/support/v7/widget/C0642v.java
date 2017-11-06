package android.support.v7.widget;

import android.content.Context;
import android.support.v7.p013b.C0509a.C0498a;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* compiled from: AppCompatSeekBar */
public class C0642v extends SeekBar {
    private C0643w f1705a;
    private C0632l f1706b;

    public C0642v(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0498a.seekBarStyle);
    }

    public C0642v(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1706b = C0632l.m3110a();
        this.f1705a = new C0643w(this, this.f1706b);
        this.f1705a.mo584a(attributeSet, i);
    }
}
