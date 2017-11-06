package org.npci.upi.security.pinactivitycomponent;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import org.npci.upi.security.pinactivitycomponent.widget.C1621c;

class C1619v implements OnClickListener {
    final /* synthetic */ C1621c f4396a;
    final /* synthetic */ String f4397b;
    final /* synthetic */ String f4398c;
    final /* synthetic */ Drawable f4399d;
    final /* synthetic */ Drawable f4400e;
    final /* synthetic */ C1601b f4401f;

    C1619v(C1601b c1601b, C1621c c1621c, String str, String str2, Drawable drawable, Drawable drawable2) {
        this.f4401f = c1601b;
        this.f4396a = c1621c;
        this.f4397b = str;
        this.f4398c = str2;
        this.f4399d = drawable;
        this.f4400e = drawable2;
    }

    public void onClick(View view) {
        boolean c = this.f4396a.mo900c();
        this.f4396a.mo899a(c ? this.f4397b : this.f4398c, c ? this.f4399d : this.f4400e, this, 0, true, true);
    }
}
