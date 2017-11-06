package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.p013b.C0509a.C0498a;
import android.support.v7.p013b.C0509a.C0501d;
import android.support.v7.p013b.C0509a.C0505h;
import android.support.v7.view.menu.C0530m.C0527a;
import android.support.v7.view.menu.C0532l.C0473a;
import android.support.v7.widget.ag;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import java.util.ArrayList;

/* compiled from: MenuPopupHelper */
public class C0550k implements C0532l, OnKeyListener, OnGlobalLayoutListener, OnItemClickListener, OnDismissListener {
    static final int f1181a = C0505h.abc_popup_menu_item_layout;
    boolean f1182b;
    private final Context f1183c;
    private final LayoutInflater f1184d;
    private final C0538f f1185e;
    private final C0549a f1186f;
    private final boolean f1187g;
    private final int f1188h;
    private final int f1189i;
    private final int f1190j;
    private View f1191k;
    private ag f1192l;
    private ViewTreeObserver f1193m;
    private C0473a f1194n;
    private ViewGroup f1195o;
    private boolean f1196p;
    private int f1197q;
    private int f1198r;

    /* compiled from: MenuPopupHelper */
    private class C0549a extends BaseAdapter {
        final /* synthetic */ C0550k f1178a;
        private C0538f f1179b;
        private int f1180c = -1;

        public /* synthetic */ Object getItem(int i) {
            return m2550a(i);
        }

        public C0549a(C0550k c0550k, C0538f c0538f) {
            this.f1178a = c0550k;
            this.f1179b = c0538f;
            m2551a();
        }

        public int getCount() {
            ArrayList l = this.f1178a.f1187g ? this.f1179b.m2493l() : this.f1179b.m2490i();
            if (this.f1180c < 0) {
                return l.size();
            }
            return l.size() - 1;
        }

        public C0541h m2550a(int i) {
            ArrayList l = this.f1178a.f1187g ? this.f1179b.m2493l() : this.f1179b.m2490i();
            if (this.f1180c >= 0 && i >= this.f1180c) {
                i++;
            }
            return (C0541h) l.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            if (view == null) {
                inflate = this.f1178a.f1184d.inflate(C0550k.f1181a, viewGroup, false);
            } else {
                inflate = view;
            }
            C0527a c0527a = (C0527a) inflate;
            if (this.f1178a.f1182b) {
                ((ListMenuItemView) inflate).setForceShowIcon(true);
            }
            c0527a.mo452a(m2550a(i), 0);
            return inflate;
        }

        void m2551a() {
            C0541h r = this.f1178a.f1185e.m2499r();
            if (r != null) {
                ArrayList l = this.f1178a.f1185e.m2493l();
                int size = l.size();
                for (int i = 0; i < size; i++) {
                    if (((C0541h) l.get(i)) == r) {
                        this.f1180c = i;
                        return;
                    }
                }
            }
            this.f1180c = -1;
        }

        public void notifyDataSetChanged() {
            m2551a();
            super.notifyDataSetChanged();
        }
    }

    public C0550k(Context context, C0538f c0538f, View view) {
        this(context, c0538f, view, false, C0498a.popupMenuStyle);
    }

    public C0550k(Context context, C0538f c0538f, View view, boolean z, int i) {
        this(context, c0538f, view, z, i, 0);
    }

    public C0550k(Context context, C0538f c0538f, View view, boolean z, int i, int i2) {
        this.f1198r = 0;
        this.f1183c = context;
        this.f1184d = LayoutInflater.from(context);
        this.f1185e = c0538f;
        this.f1186f = new C0549a(this, this.f1185e);
        this.f1187g = z;
        this.f1189i = i;
        this.f1190j = i2;
        Resources resources = context.getResources();
        this.f1188h = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0501d.abc_config_prefDialogWidth));
        this.f1191k = view;
        c0538f.m2467a((C0532l) this, context);
    }

    public void m2561a(View view) {
        this.f1191k = view;
    }

    public void m2562a(boolean z) {
        this.f1182b = z;
    }

    public void m2557a(int i) {
        this.f1198r = i;
    }

    public void m2556a() {
        if (!m2569d()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public ag m2568c() {
        return this.f1192l;
    }

    public boolean m2569d() {
        boolean z = false;
        this.f1192l = new ag(this.f1183c, null, this.f1189i, this.f1190j);
        this.f1192l.m2867a((OnDismissListener) this);
        this.f1192l.m2865a((OnItemClickListener) this);
        this.f1192l.mo586a(this.f1186f);
        this.f1192l.m2868a(true);
        View view = this.f1191k;
        if (view == null) {
            return false;
        }
        if (this.f1193m == null) {
            z = true;
        }
        this.f1193m = view.getViewTreeObserver();
        if (z) {
            this.f1193m.addOnGlobalLayoutListener(this);
        }
        this.f1192l.m2864a(view);
        this.f1192l.m2873d(this.f1198r);
        if (!this.f1196p) {
            this.f1197q = m2555g();
            this.f1196p = true;
        }
        this.f1192l.m2877f(this.f1197q);
        this.f1192l.m2879g(2);
        this.f1192l.mo588c();
        this.f1192l.m2886m().setOnKeyListener(this);
        return true;
    }

    public void m2570e() {
        if (m2571f()) {
            this.f1192l.m2882i();
        }
    }

    public void onDismiss() {
        this.f1192l = null;
        this.f1185e.close();
        if (this.f1193m != null) {
            if (!this.f1193m.isAlive()) {
                this.f1193m = this.f1191k.getViewTreeObserver();
            }
            this.f1193m.removeGlobalOnLayoutListener(this);
            this.f1193m = null;
        }
    }

    public boolean m2571f() {
        return this.f1192l != null && this.f1192l.m2884k();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C0549a c0549a = this.f1186f;
        c0549a.f1179b.m2472a(c0549a.m2550a(i), 0);
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        m2570e();
        return true;
    }

    private int m2555g() {
        ListAdapter listAdapter = this.f1186f;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i = 0;
        int i2 = 0;
        View view = null;
        int i3 = 0;
        while (i < count) {
            View view2;
            int itemViewType = listAdapter.getItemViewType(i);
            if (itemViewType != i2) {
                i2 = itemViewType;
                view2 = null;
            } else {
                view2 = view;
            }
            if (this.f1195o == null) {
                this.f1195o = new FrameLayout(this.f1183c);
            }
            view = listAdapter.getView(i, view2, this.f1195o);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            itemViewType = view.getMeasuredWidth();
            if (itemViewType >= this.f1188h) {
                return this.f1188h;
            }
            if (itemViewType <= i3) {
                itemViewType = i3;
            }
            i++;
            i3 = itemViewType;
        }
        return i3;
    }

    public void onGlobalLayout() {
        if (m2571f()) {
            View view = this.f1191k;
            if (view == null || !view.isShown()) {
                m2570e();
            } else if (m2571f()) {
                this.f1192l.mo588c();
            }
        }
    }

    public void mo470a(Context context, C0538f c0538f) {
    }

    public void mo474b(boolean z) {
        this.f1196p = false;
        if (this.f1186f != null) {
            this.f1186f.notifyDataSetChanged();
        }
    }

    public void m2560a(C0473a c0473a) {
        this.f1194n = c0473a;
    }

    public boolean mo473a(C0553p c0553p) {
        if (c0553p.hasVisibleItems()) {
            boolean z;
            C0550k c0550k = new C0550k(this.f1183c, c0553p, this.f1191k);
            c0550k.m2560a(this.f1194n);
            int size = c0553p.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = c0553p.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
            }
            z = false;
            c0550k.m2562a(z);
            if (c0550k.m2569d()) {
                if (this.f1194n == null) {
                    return true;
                }
                this.f1194n.mo402a(c0553p);
                return true;
            }
        }
        return false;
    }

    public void mo471a(C0538f c0538f, boolean z) {
        if (c0538f == this.f1185e) {
            m2570e();
            if (this.f1194n != null) {
                this.f1194n.mo401a(c0538f, z);
            }
        }
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
