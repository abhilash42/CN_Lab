package org.npci.upi.security.pinactivitycomponent.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class C1629i implements AnimatorUpdateListener {
    final /* synthetic */ FormItemEditText f4471a;

    C1629i(FormItemEditText formItemEditText) {
        this.f4471a = formItemEditText;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f4471a.f4429m.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
