package org.npci.upi.security.pinactivitycomponent.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class C1630j implements AnimatorListener {
    final /* synthetic */ FormItemEditText f4472a;

    C1630j(FormItemEditText formItemEditText) {
        this.f4472a = formItemEditText;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.f4472a.f4435s.m6620a(this.f4472a.getText());
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
