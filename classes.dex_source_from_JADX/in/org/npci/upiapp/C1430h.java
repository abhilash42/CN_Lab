package in.org.npci.upiapp;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;

/* compiled from: TabLayoutUtils */
public class C1430h {
    private static final int[] f3553a = new int[]{2130772086};

    public static void m5418a(Context context) {
        int i = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f3553a);
        if (!obtainStyledAttributes.hasValue(0)) {
            i = 1;
        }
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
        if (i != 0) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }

    public static ValueAnimator m5417a() {
        return new ValueAnimator();
    }

    static int m5416a(int i, int i2, float f) {
        return Math.round(((float) (i2 - i)) * f) + i;
    }
}
