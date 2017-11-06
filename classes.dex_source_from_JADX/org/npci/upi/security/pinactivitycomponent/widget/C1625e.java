package org.npci.upi.security.pinactivitycomponent.widget;

import android.view.View;
import android.view.View.OnLongClickListener;

class C1625e implements OnLongClickListener {
    final /* synthetic */ FormItemEditText f4466a;

    C1625e(FormItemEditText formItemEditText) {
        this.f4466a = formItemEditText;
    }

    public boolean onLongClick(View view) {
        this.f4466a.setSelection(this.f4466a.getText().length());
        return true;
    }
}
