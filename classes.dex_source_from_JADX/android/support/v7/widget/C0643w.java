package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* compiled from: AppCompatSeekBarHelper */
class C0643w extends C0639s {
    private static final int[] f1707b = new int[]{16843074};
    private final SeekBar f1708c;

    C0643w(SeekBar seekBar, C0632l c0632l) {
        super(seekBar, c0632l);
        this.f1708c = seekBar;
    }

    void mo584a(AttributeSet attributeSet, int i) {
        super.mo584a(attributeSet, i);
        ar a = ar.m2940a(this.f1708c.getContext(), attributeSet, f1707b, i, 0);
        Drawable b = a.m2947b(0);
        if (b != null) {
            this.f1708c.setThumb(b);
        }
        a.m2944a();
    }
}
