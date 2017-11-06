package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.view.ag;
import android.support.v7.view.menu.C0530m.C0527a;
import android.support.v7.view.menu.C0532l.C0473a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* compiled from: BaseMenuPresenter */
public abstract class C0533b implements C0532l {
    protected Context f1089a;
    protected Context f1090b;
    protected C0538f f1091c;
    protected LayoutInflater f1092d;
    protected LayoutInflater f1093e;
    protected C0530m f1094f;
    private C0473a f1095g;
    private int f1096h;
    private int f1097i;
    private int f1098j;

    public abstract void mo577a(C0541h c0541h, C0527a c0527a);

    public C0533b(Context context, int i, int i2) {
        this.f1089a = context;
        this.f1092d = LayoutInflater.from(context);
        this.f1096h = i;
        this.f1097i = i2;
    }

    public void mo470a(Context context, C0538f c0538f) {
        this.f1090b = context;
        this.f1093e = LayoutInflater.from(this.f1090b);
        this.f1091c = c0538f;
    }

    public C0530m mo575a(ViewGroup viewGroup) {
        if (this.f1094f == null) {
            this.f1094f = (C0530m) this.f1092d.inflate(this.f1096h, viewGroup, false);
            this.f1094f.mo457a(this.f1091c);
            mo474b(true);
        }
        return this.f1094f;
    }

    public void mo474b(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f1094f;
        if (viewGroup != null) {
            int i;
            if (this.f1091c != null) {
                this.f1091c.m2491j();
                ArrayList i2 = this.f1091c.m2490i();
                int size = i2.size();
                int i3 = 0;
                i = 0;
                while (i3 < size) {
                    int i4;
                    C0541h c0541h = (C0541h) i2.get(i3);
                    if (mo579a(i, c0541h)) {
                        View childAt = viewGroup.getChildAt(i);
                        C0541h itemData = childAt instanceof C0527a ? ((C0527a) childAt).getItemData() : null;
                        View a = mo576a(c0541h, childAt, viewGroup);
                        if (c0541h != itemData) {
                            a.setPressed(false);
                            ag.m1294p(a);
                        }
                        if (a != childAt) {
                            m2420a(a, i);
                        }
                        i4 = i + 1;
                    } else {
                        i4 = i;
                    }
                    i3++;
                    i = i4;
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (!mo580a(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    protected void m2420a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f1094f).addView(view, i);
    }

    protected boolean mo580a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public void m2419a(C0473a c0473a) {
        this.f1095g = c0473a;
    }

    public C0473a m2412a() {
        return this.f1095g;
    }

    public C0527a m2425b(ViewGroup viewGroup) {
        return (C0527a) this.f1092d.inflate(this.f1097i, viewGroup, false);
    }

    public View mo576a(C0541h c0541h, View view, ViewGroup viewGroup) {
        C0527a c0527a;
        if (view instanceof C0527a) {
            c0527a = (C0527a) view;
        } else {
            c0527a = m2425b(viewGroup);
        }
        mo577a(c0541h, c0527a);
        return (View) c0527a;
    }

    public boolean mo579a(int i, C0541h c0541h) {
        return true;
    }

    public void mo471a(C0538f c0538f, boolean z) {
        if (this.f1095g != null) {
            this.f1095g.mo401a(c0538f, z);
        }
    }

    public boolean mo473a(C0553p c0553p) {
        if (this.f1095g != null) {
            return this.f1095g.mo402a(c0553p);
        }
        return false;
    }

    public boolean mo475b() {
        return false;
    }

    public boolean mo472a(C0538f c0538f, C0541h c0541h) {
        return false;
    }

    public boolean mo476b(C0538f c0538f, C0541h c0541h) {
        return false;
    }

    public void m2415a(int i) {
        this.f1098j = i;
    }
}
