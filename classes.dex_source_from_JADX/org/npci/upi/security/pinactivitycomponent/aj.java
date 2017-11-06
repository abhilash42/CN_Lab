package org.npci.upi.security.pinactivitycomponent;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import org.npci.upi.security.pinactivitycomponent.C1597a.C1592d;

class aj implements OnTouchListener {
    final /* synthetic */ GetCredential f4329a;

    aj(GetCredential getCredential) {
        this.f4329a = getCredential;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() != C1592d.transaction_details_scroller || motionEvent.getAction() != 1 || !this.f4329a.m6456t()) {
            return false;
        }
        this.f4329a.m6445b(false);
        return true;
    }
}
