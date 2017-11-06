package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

/* compiled from: ViewCompatHC */
class aj {
    static long m1312a() {
        return ValueAnimator.getFrameDelay();
    }

    public static void m1314a(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    public static int m1311a(View view) {
        return view.getLayerType();
    }

    public static int m1310a(int i, int i2, int i3) {
        return View.resolveSizeAndState(i, i2, i3);
    }

    public static int m1316b(View view) {
        return view.getMeasuredWidthAndState();
    }

    public static int m1319c(View view) {
        return view.getMeasuredState();
    }

    public static float m1321d(View view) {
        return view.getTranslationY();
    }

    public static float m1322e(View view) {
        return view.getY();
    }

    public static void m1313a(View view, float f) {
        view.setTranslationY(f);
    }

    public static void m1317b(View view, float f) {
        view.setAlpha(f);
    }

    public static void m1320c(View view, float f) {
        view.setX(f);
    }

    public static void m1323f(View view) {
        view.jumpDrawablesToCurrentState();
    }

    public static void m1315a(View view, boolean z) {
        view.setSaveFromParentEnabled(z);
    }

    public static void m1318b(View view, boolean z) {
        view.setActivated(z);
    }
}
