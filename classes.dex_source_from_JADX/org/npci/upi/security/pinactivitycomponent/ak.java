package org.npci.upi.security.pinactivitycomponent;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ak implements OnTouchListener {
    final /* synthetic */ GetCredential f4330a;

    ak(GetCredential getCredential) {
        this.f4330a = getCredential;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1 || !this.f4330a.m6456t()) {
            return false;
        }
        this.f4330a.m6445b(false);
        return true;
    }
}
