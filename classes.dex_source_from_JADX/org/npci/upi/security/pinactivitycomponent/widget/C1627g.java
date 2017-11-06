package org.npci.upi.security.pinactivitycomponent.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class C1627g implements AnimatorListener {
    final /* synthetic */ FormItemEditText f4468a;

    C1627g(FormItemEditText formItemEditText) {
        this.f4468a = formItemEditText;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.f4468a.f4435s.m6620a(this.f4468a.getText());
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
