package org.npci.upi.security.pinactivitycomponent.widget;

import android.text.Editable;
import android.text.TextWatcher;

class C1632l implements TextWatcher {
    final /* synthetic */ C1623b f4473a;

    C1632l(C1623b c1623b) {
        this.f4473a = c1623b;
    }

    public void afterTextChanged(Editable editable) {
        if (this.f4473a.f4447a) {
            this.f4473a.f4460n = editable.toString();
        } else if (this.f4473a.f4461o) {
            this.f4473a.f4460n = editable.toString();
        } else if (editable.length() == 0) {
            this.f4473a.f4460n = "";
        } else if (this.f4473a.f4460n.length() > editable.length()) {
            this.f4473a.f4460n = this.f4473a.f4460n.substring(0, this.f4473a.f4460n.length() - 1);
        } else {
            char charAt = editable.toString().charAt(editable.length() - 1);
            if (charAt != '●') {
                this.f4473a.f4460n = this.f4473a.f4460n.concat("" + charAt);
                this.f4473a.f4452f.setText(this.f4473a.f4460n.replaceAll(".", "●"));
                return;
            }
            this.f4473a.f4452f.setSelection(editable.length());
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f4473a.f4453g != null && this.f4473a.f4452f.getText() != null && this.f4473a.f4452f.getText().length() >= this.f4473a.f4450d) {
            this.f4473a.f4453g.mo896a(this.f4473a.f4454h, this.f4473a.f4452f.getText().toString());
        }
    }
}
