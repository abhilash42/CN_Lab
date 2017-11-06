package org.npci.upi.security.pinactivitycomponent;

import android.view.View;
import android.view.View.OnClickListener;

class C1602c implements OnClickListener {
    final /* synthetic */ Keypad f4359a;

    C1602c(Keypad keypad) {
        this.f4359a = keypad;
    }

    public void onClick(View view) {
        if (this.f4359a.f4317e != null) {
            this.f4359a.f4317e.mo890a(view, 7);
        }
    }
}
