package org.npci.upi.security.pinactivitycomponent;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import org.npci.upi.security.pinactivitycomponent.widget.C1621c;

class C1616s implements OnClickListener {
    final /* synthetic */ C1621c f4385a;
    final /* synthetic */ String f4386b;
    final /* synthetic */ String f4387c;
    final /* synthetic */ Drawable f4388d;
    final /* synthetic */ Drawable f4389e;
    final /* synthetic */ C1615r f4390f;

    C1616s(C1615r c1615r, C1621c c1621c, String str, String str2, Drawable drawable, Drawable drawable2) {
        this.f4390f = c1615r;
        this.f4385a = c1621c;
        this.f4386b = str;
        this.f4387c = str2;
        this.f4388d = drawable;
        this.f4389e = drawable2;
    }

    public void onClick(View view) {
        boolean c = this.f4385a.mo900c();
        this.f4385a.mo899a(c ? this.f4386b : this.f4387c, c ? this.f4388d : this.f4389e, this, 0, true, true);
    }
}
