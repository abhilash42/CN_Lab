package android.support.v4.view.p011b;

import android.view.animation.Interpolator;

/* compiled from: LookupTableInterpolator */
abstract class C0314b implements Interpolator {
    private final float[] f576a;
    private final float f577b = (1.0f / ((float) (this.f576a.length - 1)));

    public C0314b(float[] fArr) {
        this.f576a = fArr;
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) (((float) (this.f576a.length - 1)) * f), this.f576a.length - 2);
        float f2 = (f - (((float) min) * this.f577b)) / this.f577b;
        return ((this.f576a[min + 1] - this.f576a[min]) * f2) + this.f576a[min];
    }
}
