package org.npci.upi.security.pinactivitycomponent;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import org.npci.upi.security.pinactivitycomponent.widget.C1623b;

class C1611n implements OnClickListener {
    final /* synthetic */ C1623b f4374a;
    final /* synthetic */ C1610m f4375b;

    C1611n(C1610m c1610m, C1623b c1623b) {
        this.f4375b = c1610m;
        this.f4374a = c1623b;
    }

    public void onClick(View view) {
        this.f4375b.f4373a.m6518a(this.f4374a);
        Bundle bundle = new Bundle();
        bundle.putString(CLConstants.OUTPUT_KEY_ACTION, "TRIGGER_OTP");
        ((GetCredential) this.f4375b.f4373a.ao).m6469o().m6579d().send(2, bundle);
    }
}
