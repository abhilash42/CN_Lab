package org.npci.upi.security.pinactivitycomponent.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ag;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import java.util.ArrayList;
import org.npci.upi.security.pinactivitycomponent.C1597a.C1594f;

public class C1622a extends FrameLayout implements C1621c {
    private ArrayList f4443a;
    private int f4444b;
    private int f4445c;
    private Object f4446d;

    public C1622a(Context context) {
        super(context);
    }

    private void m6594a(View view) {
        if (VERSION.SDK_INT >= 12) {
            view.animate().x(0.0f);
        } else {
            ag.m1279c(view, 0.0f);
        }
    }

    private void m6595a(View view, boolean z) {
        int i = z ? this.f4445c * -1 : this.f4445c;
        if (VERSION.SDK_INT >= 12) {
            view.animate().x((float) i);
        } else {
            ag.m1279c(view, (float) i);
        }
    }

    private void m6596e() {
        for (int i = 0; i < this.f4443a.size(); i++) {
            ((C1623b) this.f4443a.get(i)).setText("");
        }
        m6600b();
    }

    public void mo899a(String str, Drawable drawable, OnClickListener onClickListener, int i, boolean z, boolean z2) {
        for (int i2 = 0; i2 < this.f4443a.size(); i2++) {
            ((C1623b) this.f4443a.get(i2)).mo899a(str, drawable, onClickListener, i, z, z2);
        }
    }

    public void m6598a(ArrayList arrayList, C1599o c1599o) {
        this.f4443a = arrayList;
        addView((View) this.f4443a.get(0));
        ((C1623b) this.f4443a.get(0)).setFormItemListener(c1599o);
        this.f4444b = 0;
        this.f4445c = getResources().getDisplayMetrics().widthPixels;
        for (int i = 1; i < this.f4443a.size(); i++) {
            View view = (C1623b) this.f4443a.get(i);
            view.setFormItemListener(c1599o);
            ag.m1279c(view, (float) this.f4445c);
            addView(view);
        }
    }

    public boolean m6599a() {
        if (this.f4444b >= this.f4443a.size() - 1) {
            return false;
        }
        m6595a((C1623b) this.f4443a.get(this.f4444b), true);
        m6594a((C1623b) this.f4443a.get(this.f4444b + 1));
        this.f4444b++;
        ((C1623b) this.f4443a.get(this.f4444b)).requestFocus();
        return true;
    }

    public boolean m6600b() {
        if (this.f4444b == 0) {
            return false;
        }
        m6595a((C1623b) this.f4443a.get(this.f4444b), false);
        m6594a((C1623b) this.f4443a.get(this.f4444b - 1));
        this.f4444b--;
        ((C1623b) this.f4443a.get(this.f4444b)).requestFocus();
        return true;
    }

    public boolean mo900c() {
        return ((C1623b) this.f4443a.get(this.f4444b)).mo900c();
    }

    public boolean mo901d() {
        String inputValue = ((C1623b) this.f4443a.get(this.f4444b)).getInputValue();
        if (((C1623b) this.f4443a.get(this.f4444b)).getInputLength() != inputValue.length()) {
            ((C1623b) this.f4443a.get(this.f4444b)).requestFocus();
            return false;
        } else if (this.f4444b != this.f4443a.size() - 1) {
            return !m6599a();
        } else {
            ((C1623b) this.f4443a.get(this.f4444b)).requestFocus();
            int i = 0;
            while (i < this.f4443a.size()) {
                if (((C1623b) this.f4443a.get(i)).getInputValue().equals(inputValue)) {
                    i++;
                } else {
                    m6596e();
                    ((C1623b) this.f4443a.get(i)).getFormItemListener().mo897a((View) this, getContext().getString(C1594f.info_pins_dont_match));
                    return false;
                }
            }
            return true;
        }
    }

    public Object getFormDataTag() {
        return this.f4446d == null ? ((C1623b) this.f4443a.get(0)).getFormDataTag() : this.f4446d;
    }

    public String getInputValue() {
        return ((C1623b) this.f4443a.get(0)).getInputValue();
    }

    public void setFormDataTag(Object obj) {
        this.f4446d = obj;
    }

    public void setText(String str) {
        for (int i = 0; i < this.f4443a.size(); i++) {
            ((C1623b) this.f4443a.get(i)).setText(str);
        }
    }
}
