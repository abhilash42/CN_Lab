package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* compiled from: ViewPropertyAnimatorCompatJB */
class ay {
    public static void m1476a(final View view, final ba baVar) {
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
