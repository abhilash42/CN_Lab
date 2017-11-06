package org.npci.upi.security.pinactivitycomponent;

import android.support.v4.p004a.C0023a;
import org.npci.upi.security.pinactivitycomponent.C1597a.C1591c;
import org.npci.upi.security.pinactivitycomponent.C1597a.C1594f;
import org.npci.upi.security.pinactivitycomponent.widget.C1623b;

class C1610m implements Runnable {
    final /* synthetic */ C1600h f4373a;

    C1610m(C1600h c1600h) {
        this.f4373a = c1600h;
    }

    public void run() {
        if (this.f4373a.f4356g != -1 && (this.f4373a.f4355f.get(this.f4373a.f4356g) instanceof C1623b)) {
            C1623b c1623b = (C1623b) this.f4373a.f4355f.get(this.f4373a.f4356g);
            c1623b.m6617a(false);
            c1623b.mo899a(this.f4373a.m139a(C1594f.action_resend), C0023a.m77a(this.f4373a.m176h(), C1591c.ic_action_reload), new C1611n(this, c1623b), 0, true, true);
        }
    }
}
