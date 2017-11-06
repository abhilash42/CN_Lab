package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.animation.Interpolator;

/* compiled from: ViewPropertyAnimatorCompatICS */
class ax {
    public static void m1467a(View view, long j) {
        view.animate().setDuration(j);
    }

    public static void m1466a(View view, float f) {
        view.animate().alpha(f);
    }

    public static void m1471b(View view, float f) {
        view.animate().translationY(f);
    }

    public static long m1465a(View view) {
        return view.animate().getDuration();
    }

    public static void m1469a(View view, Interpolator interpolator) {
        view.animate().setInterpolator(interpolator);
    }

    public static void m1472b(View view, long j) {
        view.animate().setStartDelay(j);
    }

    public static void m1474c(View view, float f) {
        view.animate().scaleX(f);
    }

    public static void m1475d(View view, float f) {
        view.animate().scaleY(f);
    }

    public static void m1470b(View view) {
        view.animate().cancel();
    }

    public static void m1473c(View view) {
        view.animate().start();
    }

    public static void m1468a(final View view, final ba baVar) {
        if (baVar != null) {
            view.animate().setListener(new AnimatorListenerAdapter() {
                public void onAnimationCancel(Animator animator) {
                    baVar.mo262c(view);
                }

                public void onAnimationEnd(Animator animator) {
                    baVar.mo261b(view);
                }

                public void onAnimationStart(Animator animator) {
                    baVar.mo260a(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }
}
