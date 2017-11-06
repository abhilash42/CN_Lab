package org.npci.upi.security.pinactivitycomponent;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v4.view.ag;

class al extends AnimatorListenerAdapter {
    final /* synthetic */ boolean f4331a;
    final /* synthetic */ int f4332b;
    final /* synthetic */ GetCredential f4333c;

    al(GetCredential getCredential, boolean z, int i) {
        this.f4333c = getCredential;
        this.f4331a = z;
        this.f4332b = i;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        if (!this.f4331a) {
            this.f4333c.f4311y.setVisibility(8);
            this.f4333c.f4312z.setVisibility(8);
            this.f4333c.f4294A.resetTransition();
        }
    }

    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        if (this.f4331a) {
            this.f4333c.f4294A.startTransition(300);
            this.f4333c.f4311y.setVisibility(0);
            this.f4333c.f4312z.setVisibility(0);
            if (ag.m1291m(this.f4333c.f4311y) == 0.0f) {
                this.f4333c.f4311y.setY((float) (this.f4332b * -1));
                return;
            }
            return;
        }
        this.f4333c.f4294A.reverseTransition(300);
    }
}
