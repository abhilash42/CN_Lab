package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.p013b.C0509a.C0505h;
import android.support.v7.view.menu.C0530m.C0527a;
import android.support.v7.view.menu.C0532l.C0473a;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

/* compiled from: ListMenuPresenter */
public class C0537e implements C0532l, OnItemClickListener {
    Context f1105a;
    LayoutInflater f1106b;
    C0538f f1107c;
    ExpandedMenuView f1108d;
    int f1109e;
    int f1110f;
    C0536a f1111g;
    private int f1112h;
    private C0473a f1113i;

    /* compiled from: ListMenuPresenter */
    private class C0536a extends BaseAdapter {
        final /* synthetic */ C0537e f1103a;
        private int f1104b = -1;

        public /* synthetic */ Object getItem(int i) {
            return m2434a(i);
        }

        public C0536a(C0537e c0537e) {
            this.f1103a = c0537e;
            m2435a();
        }

        public int getCount() {
            int size = this.f1103a.f1107c.m2493l().size() - this.f1103a.f1112h;
            return this.f1104b < 0 ? size : size - 1;
        }

        public C0541h m2434a(int i) {
            ArrayList l = this.f1103a.f1107c.m2493l();
            int a = this.f1103a.f1112h + i;
            if (this.f1104b >= 0 && a >= this.f1104b) {
                a++;
            }
            return (C0541h) l.get(a);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            if (view == null) {
                inflate = this.f1103a.f1106b.inflate(this.f1103a.f1110f, viewGroup, false);
            } else {
                inflate = view;
            }
            ((C0527a) inflate).mo452a(m2434a(i), 0);
            return inflate;
        }

        void m2435a() {
            C0541h r = this.f1103a.f1107c.m2499r();
            if (r != null) {
                ArrayList l = this.f1103a.f1107c.m2493l();
                int size = l.size();
                for (int i = 0; i < size; i++) {
                    if (((C0541h) l.get(i)) == r) {
                        this.f1104b = i;
                        return;
                    }
                }
            }
            this.f1104b = -1;
        }

        public void notifyDataSetChanged() {
            m2435a();
            super.notifyDataSetChanged();
        }
    }

    public C0537e(Context context, int i) {
        this(i, 0);
        this.f1105a = context;
        this.f1106b = LayoutInflater.from(this.f1105a);
    }

    public C0537e(int i, int i2) {
        this.f1110f = i;
        this.f1109e = i2;
    }

    public void mo470a(Context context, C0538f c0538f) {
        if (this.f1109e != 0) {
            this.f1105a = new ContextThemeWrapper(context, this.f1109e);
            this.f1106b = LayoutInflater.from(this.f1105a);
        } else if (this.f1105a != null) {
            this.f1105a = context;
            if (this.f1106b == null) {
                this.f1106b = LayoutInflater.from(this.f1105a);
            }
        }
        this.f1107c = c0538f;
        if (this.f1111g != null) {
            this.f1111g.notifyDataSetChanged();
        }
    }

    public C0530m m2437a(ViewGroup viewGroup) {
        if (this.f1108d == null) {
            this.f1108d = (ExpandedMenuView) this.f1106b.inflate(C0505h.abc_expanded_menu_layout, viewGroup, false);
            if (this.f1111g == null) {
                this.f1111g = new C0536a(this);
            }
            this.f1108d.setAdapter(this.f1111g);
            this.f1108d.setOnItemClickListener(this);
        }
        return this.f1108d;
    }

    public ListAdapter m2438a() {
        if (this.f1111g == null) {
            this.f1111g = new C0536a(this);
        }
        return this.f1111g;
    }

    public void mo474b(boolean z) {
        if (this.f1111g != null) {
            this.f1111g.notifyDataSetChanged();
        }
    }

    public void m2441a(C0473a c0473a) {
        this.f1113i = c0473a;
    }

    public boolean mo473a(C0553p c0553p) {
        if (!c0553p.hasVisibleItems()) {
            return false;
        }
        new C0539g(c0553p).m2501a(null);
        if (this.f1113i != null) {
            this.f1113i.mo402a(c0553p);
        }
        return true;
    }

    public void mo471a(C0538f c0538f, boolean z) {
        if (this.f1113i != null) {
            this.f1113i.mo401a(c0538f, z);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f1107c.m2473a(this.f1111g.m2434a(i), (C0532l) this, 0);
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
}
