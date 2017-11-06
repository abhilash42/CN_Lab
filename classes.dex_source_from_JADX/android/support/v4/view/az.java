package android.support.v4.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

/* compiled from: ViewPropertyAnimatorCompatKK */
class az {
    public static void m1477a(final View view, final bc bcVar) {
        AnimatorUpdateListener animatorUpdateListener = null;
        if (bcVar != null) {
            animatorUpdateListener = new AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    bcVar.mo422a(view);
                }
            };
        }
        view.animate().setUpdateListener(animatorUpdateListener);
    }
}
