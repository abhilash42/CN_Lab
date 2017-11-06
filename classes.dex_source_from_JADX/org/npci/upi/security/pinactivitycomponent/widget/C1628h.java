package org.npci.upi.security.pinactivitycomponent.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class C1628h implements AnimatorUpdateListener {
    final /* synthetic */ int f4469a;
    final /* synthetic */ FormItemEditText f4470b;

    C1628h(FormItemEditText formItemEditText, int i) {
        this.f4470b = formItemEditText;
        this.f4469a = i;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f4470b.f4427k[this.f4469a] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f4470b.invalidate();
    }
}
