package org.npci.upi.security.pinactivitycomponent.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class C1633m implements OnTouchListener {
    final /* synthetic */ C1623b f4474a;

    C1633m(C1623b c1623b) {
        this.f4474a = c1623b;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f4474a.f4453g != null && motionEvent.getAction() == 1) {
            this.f4474a.f4453g.mo898b(this.f4474a.f4454h);
        }
        return false;
    }
}
