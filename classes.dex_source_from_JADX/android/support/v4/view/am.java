package android.support.v4.view;

import android.view.View;

/* compiled from: ViewCompatJB */
class am {
    public static void m1328a(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void m1330a(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void m1331a(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static int m1332b(View view) {
        return view.getImportantForAccessibility();
    }

    public static void m1329a(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public static int m1333c(View view) {
        return view.getMinimumHeight();
    }

    public static void m1334d(View view) {
        view.requestFitSystemWindows();
    }

    public static boolean m1335e(View view) {
        return view.hasOverlappingRendering();
    }
}
