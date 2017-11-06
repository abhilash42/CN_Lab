package org.npci.upi.security.pinactivitycomponent.widget;

import android.view.View;
import android.view.View.OnClickListener;

class C1624d implements OnClickListener {
    final /* synthetic */ FormItemEditText f4465a;

    C1624d(FormItemEditText formItemEditText) {
        this.f4465a = formItemEditText;
    }

    public void onClick(View view) {
        this.f4465a.setSelection(this.f4465a.getText().length());
        if (this.f4465a.f4434r != null) {
            this.f4465a.f4434r.onClick(view);
        }
    }
}
