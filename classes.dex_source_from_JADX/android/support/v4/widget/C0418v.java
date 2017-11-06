package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

/* compiled from: ScrollerCompatGingerbread */
class C0418v {
    public static Object m1879a(Context context, Interpolator interpolator) {
        return interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    public static boolean m1883a(Object obj) {
        return ((OverScroller) obj).isFinished();
    }

    public static int m1885b(Object obj) {
        return ((OverScroller) obj).getCurrX();
    }

    public static int m1886c(Object obj) {
        return ((OverScroller) obj).getCurrY();
    }

    public static boolean m1887d(Object obj) {
        return ((OverScroller) obj).computeScrollOffset();
    }

    public static void m1880a(Object obj, int i, int i2, int i3, int i4) {
        ((OverScroller) obj).startScroll(i, i2, i3, i4);
    }

    public static void m1881a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        ((OverScroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public static void m1882a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        ((OverScroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public static void m1888e(Object obj) {
        ((OverScroller) obj).abortAnimation();
    }

    public static int m1889f(Object obj) {
        return ((OverScroller) obj).getFinalY();
    }

    public static boolean m1884a(Object obj, int i, int i2, int i3, int i4, int i5, int i6) {
        return ((OverScroller) obj).springBack(i, i2, i3, i4, i5, i6);
    }
}
