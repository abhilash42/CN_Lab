package org.npci.upi.security.pinactivitycomponent;

import android.os.Handler;
import android.os.Looper;
import java.util.TimerTask;

class C1606i extends TimerTask {
    long f4365a = (System.currentTimeMillis() - 45000);
    final /* synthetic */ C1614q f4366b;
    final /* synthetic */ int f4367c;
    final /* synthetic */ C1600h f4368d;

    C1606i(C1600h c1600h, C1614q c1614q, int i) {
        this.f4368d = c1600h;
        this.f4366b = c1614q;
        this.f4367c = i;
    }

    public void run() {
        C1613p a = this.f4366b.m6552a(this.f4367c, this.f4365a - 2000);
        if (a != null) {
            new Handler(Looper.getMainLooper()).post(new C1607j(this, a));
        }
        this.f4365a = System.currentTimeMillis();
    }
}
