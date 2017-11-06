package org.npci.upi.security.pinactivitycomponent;

import android.view.View;
import android.view.View.OnClickListener;

class aq implements OnClickListener {
    final /* synthetic */ int f4347a;
    final /* synthetic */ Keypad f4348b;

    aq(Keypad keypad, int i) {
        this.f4348b = keypad;
        this.f4347a = i;
    }

    public void onClick(View view) {
        if (this.f4348b.f4317e != null) {
            this.f4348b.f4317e.mo890a(view, this.f4347a + 7);
        }
    }
}
