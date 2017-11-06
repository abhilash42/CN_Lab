package org.npci.upi.security.pinactivitycomponent.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class C1626f implements AnimatorUpdateListener {
    final /* synthetic */ FormItemEditText f4467a;

    C1626f(FormItemEditText formItemEditText) {
        this.f4467a = formItemEditText;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f4467a.f4429m.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        this.f4467a.invalidate();
    }
}
