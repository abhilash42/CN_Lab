package org.npci.upi.security.pinactivitycomponent;

import android.view.KeyEvent;
import android.view.View;

class ah implements C1598f {
    final /* synthetic */ GetCredential f4327a;

    ah(GetCredential getCredential) {
        this.f4327a = getCredential;
    }

    public void mo890a(View view, int i) {
        this.f4327a.dispatchKeyEvent(new KeyEvent(0, i));
        if (i == 66 && this.f4327a.f4308v != null) {
            this.f4327a.f4308v.mo895a();
        }
    }
}
