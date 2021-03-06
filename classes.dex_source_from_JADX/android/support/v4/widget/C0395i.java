package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;

/* compiled from: EdgeEffectCompatIcs */
class C0395i {
    public static Object m1793a(Context context) {
        return new EdgeEffect(context);
    }

    public static void m1794a(Object obj, int i, int i2) {
        ((EdgeEffect) obj).setSize(i, i2);
    }

    public static boolean m1795a(Object obj) {
        return ((EdgeEffect) obj).isFinished();
    }

    public static void m1799b(Object obj) {
        ((EdgeEffect) obj).finish();
    }

    public static boolean m1796a(Object obj, float f) {
        ((EdgeEffect) obj).onPull(f);
        return true;
    }

    public static boolean m1800c(Object obj) {
        EdgeEffect edgeEffect = (EdgeEffect) obj;
        edgeEffect.onRelease();
        return edgeEffect.isFinished();
    }

    public static boolean m1797a(Object obj, int i) {
        ((EdgeEffect) obj).onAbsorb(i);
        return true;
    }

    public static boolean m1798a(Object obj, Canvas canvas) {
        return ((EdgeEffect) obj).draw(canvas);
    }
}
