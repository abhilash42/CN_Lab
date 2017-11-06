package android.support.v7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.ag;
import android.support.v7.p013b.C0509a.C0498a;
import android.util.AttributeSet;
import android.widget.RatingBar;

/* compiled from: AppCompatRatingBar */
public class C0641u extends RatingBar {
    private C0639s f1703a;
    private C0632l f1704b;

    public C0641u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0498a.ratingBarStyle);
    }

    public C0641u(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1704b = C0632l.m3110a();
        this.f1703a = new C0639s(this, this.f1704b);
        this.f1703a.mo584a(attributeSet, i);
    }

    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap a = this.f1703a.m3144a();
        if (a != null) {
            setMeasuredDimension(ag.m1258a(a.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
