package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.view.C0321d;
import android.support.v4.view.ag;
import android.support.v7.p013b.C0509a.C0503f;
import android.support.v7.p013b.C0509a.C0505h;
import android.support.v7.p013b.C0509a.C0506i;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

public class ActivityChooserView extends ViewGroup {
    C0321d f1308a;
    private final C0567a f1309b;
    private final C0568b f1310c;
    private final af f1311d;
    private final FrameLayout f1312e;
    private final ImageView f1313f;
    private final FrameLayout f1314g;
    private final int f1315h;
    private final DataSetObserver f1316i;
    private final OnGlobalLayoutListener f1317j;
    private ag f1318k;
    private OnDismissListener f1319l;
    private boolean f1320m;
    private int f1321n;
    private boolean f1322o;
    private int f1323p;

    public static class InnerLayout extends af {
        private static final int[] f1300a = new int[]{16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            ar a = ar.m2939a(context, attributeSet, f1300a);
            setBackgroundDrawable(a.m2943a(0));
            a.m2944a();
        }
    }

    private class C0567a extends BaseAdapter {
        final /* synthetic */ ActivityChooserView f1301a;
        private C0621e f1302b;
        private int f1303c;
        private boolean f1304d;
        private boolean f1305e;
        private boolean f1306f;

        public void m2689a(C0621e c0621e) {
            C0621e d = this.f1301a.f1309b.m2694d();
            if (d != null && this.f1301a.isShown()) {
                d.unregisterObserver(this.f1301a.f1316i);
            }
            this.f1302b = c0621e;
            if (c0621e != null && this.f1301a.isShown()) {
                c0621e.registerObserver(this.f1301a.f1316i);
            }
            notifyDataSetChanged();
        }

        public int getItemViewType(int i) {
            if (this.f1306f && i == getCount() - 1) {
                return 1;
            }
            return 0;
        }

        public int getViewTypeCount() {
            return 3;
        }

        public int getCount() {
            int a = this.f1302b.m3074a();
            if (!(this.f1304d || this.f1302b.m3078b() == null)) {
                a--;
            }
            a = Math.min(a, this.f1303c);
            if (this.f1306f) {
                return a + 1;
            }
            return a;
        }

        public Object getItem(int i) {
            switch (getItemViewType(i)) {
                case 0:
                    if (!(this.f1304d || this.f1302b.m3078b() == null)) {
                        i++;
                    }
                    return this.f1302b.m3076a(i);
                case 1:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    if (view == null || view.getId() != C0503f.list_item) {
                        view = LayoutInflater.from(this.f1301a.getContext()).inflate(C0505h.abc_activity_chooser_view_list_item, viewGroup, false);
                    }
                    PackageManager packageManager = this.f1301a.getContext().getPackageManager();
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                    ((ImageView) view.findViewById(C0503f.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                    ((TextView) view.findViewById(C0503f.title)).setText(resolveInfo.loadLabel(packageManager));
                    if (this.f1304d && i == 0 && this.f1305e) {
                        ag.m1276b(view, true);
                        return view;
                    }
                    ag.m1276b(view, false);
                    return view;
                case 1:
                    if (view != null && view.getId() == 1) {
                        return view;
                    }
                    view = LayoutInflater.from(this.f1301a.getContext()).inflate(C0505h.abc_activity_chooser_view_list_item, viewGroup, false);
                    view.setId(1);
                    ((TextView) view.findViewById(C0503f.title)).setText(this.f1301a.getContext().getString(C0506i.abc_activity_chooser_view_see_all));
                    return view;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public int m2687a() {
            int i = 0;
            int i2 = this.f1303c;
            this.f1303c = Integer.MAX_VALUE;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i3 = 0;
            while (i < count) {
                view = getView(i, view, null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i3 = Math.max(i3, view.getMeasuredWidth());
                i++;
            }
            this.f1303c = i2;
            return i3;
        }

        public void m2688a(int i) {
            if (this.f1303c != i) {
                this.f1303c = i;
                notifyDataSetChanged();
            }
        }

        public ResolveInfo m2692b() {
            return this.f1302b.m3078b();
        }

        public void m2690a(boolean z) {
            if (this.f1306f != z) {
                this.f1306f = z;
                notifyDataSetChanged();
            }
        }

        public int m2693c() {
            return this.f1302b.m3074a();
        }

        public C0621e m2694d() {
            return this.f1302b;
        }

        public void m2691a(boolean z, boolean z2) {
            if (this.f1304d != z || this.f1305e != z2) {
                this.f1304d = z;
                this.f1305e = z2;
                notifyDataSetChanged();
            }
        }

        public boolean m2695e() {
            return this.f1304d;
        }
    }

    private class C0568b implements OnClickListener, OnLongClickListener, OnItemClickListener, OnDismissListener {
        final /* synthetic */ ActivityChooserView f1307a;

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (((C0567a) adapterView.getAdapter()).getItemViewType(i)) {
                case 0:
                    this.f1307a.m2708b();
                    if (!this.f1307a.f1320m) {
                        if (!this.f1307a.f1309b.m2695e()) {
                            i++;
                        }
                        Intent b = this.f1307a.f1309b.m2694d().m3077b(i);
                        if (b != null) {
                            b.addFlags(524288);
                            this.f1307a.getContext().startActivity(b);
                            return;
                        }
                        return;
                    } else if (i > 0) {
                        this.f1307a.f1309b.m2694d().m3079c(i);
                        return;
                    } else {
                        return;
                    }
                case 1:
                    this.f1307a.m2698a(Integer.MAX_VALUE);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public void onClick(View view) {
            if (view == this.f1307a.f1314g) {
                this.f1307a.m2708b();
                Intent b = this.f1307a.f1309b.m2694d().m3077b(this.f1307a.f1309b.m2694d().m3075a(this.f1307a.f1309b.m2692b()));
                if (b != null) {
                    b.addFlags(524288);
                    this.f1307a.getContext().startActivity(b);
                }
            } else if (view == this.f1307a.f1312e) {
                this.f1307a.f1320m = false;
                this.f1307a.m2698a(this.f1307a.f1321n);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public boolean onLongClick(View view) {
            if (view == this.f1307a.f1314g) {
                if (this.f1307a.f1309b.getCount() > 0) {
                    this.f1307a.f1320m = true;
                    this.f1307a.m2698a(this.f1307a.f1321n);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }

        public void onDismiss() {
            m2696a();
            if (this.f1307a.f1308a != null) {
                this.f1307a.f1308a.m1514a(false);
            }
        }

        private void m2696a() {
            if (this.f1307a.f1319l != null) {
                this.f1307a.f1319l.onDismiss();
            }
        }
    }

    public void setActivityChooserModel(C0621e c0621e) {
        this.f1309b.m2689a(c0621e);
        if (m2709c()) {
            m2708b();
            m2707a();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f1313f.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.f1313f.setContentDescription(getContext().getString(i));
    }

    public void setProvider(C0321d c0321d) {
        this.f1308a = c0321d;
    }

    public boolean m2707a() {
        if (m2709c() || !this.f1322o) {
            return false;
        }
        this.f1320m = false;
        m2698a(this.f1321n);
        return true;
    }

    private void m2698a(int i) {
        if (this.f1309b.m2694d() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.f1317j);
        boolean z = this.f1314g.getVisibility() == 0;
        int c = this.f1309b.m2693c();
        int i2;
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i == Integer.MAX_VALUE || c <= r3 + i) {
            this.f1309b.m2690a(false);
            this.f1309b.m2688a(i);
        } else {
            this.f1309b.m2690a(true);
            this.f1309b.m2688a(i - 1);
        }
        ag listPopupWindow = getListPopupWindow();
        if (!listPopupWindow.m2884k()) {
            if (this.f1320m || !z) {
                this.f1309b.m2691a(true, z);
            } else {
                this.f1309b.m2691a(false, false);
            }
            listPopupWindow.m2877f(Math.min(this.f1309b.m2687a(), this.f1315h));
            listPopupWindow.mo588c();
            if (this.f1308a != null) {
                this.f1308a.m1514a(true);
            }
            listPopupWindow.m2886m().setContentDescription(getContext().getString(C0506i.abc_activitychooserview_choose_application));
        }
    }

    public boolean m2708b() {
        if (m2709c()) {
            getListPopupWindow().m2882i();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.f1317j);
            }
        }
        return true;
    }

    public boolean m2709c() {
        return getListPopupWindow().m2884k();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        C0621e d = this.f1309b.m2694d();
        if (d != null) {
            d.registerObserver(this.f1316i);
        }
        this.f1322o = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0621e d = this.f1309b.m2694d();
        if (d != null) {
            d.unregisterObserver(this.f1316i);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f1317j);
        }
        if (m2709c()) {
            m2708b();
        }
        this.f1322o = false;
    }

    protected void onMeasure(int i, int i2) {
        View view = this.f1311d;
        if (this.f1314g.getVisibility() != 0) {
            i2 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f1311d.layout(0, 0, i3 - i, i4 - i2);
        if (!m2709c()) {
            m2708b();
        }
    }

    public C0621e getDataModel() {
        return this.f1309b.m2694d();
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f1319l = onDismissListener;
    }

    public void setInitialActivityCount(int i) {
        this.f1321n = i;
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.f1323p = i;
    }

    private ag getListPopupWindow() {
        if (this.f1318k == null) {
            this.f1318k = new ag(getContext());
            this.f1318k.mo586a(this.f1309b);
            this.f1318k.m2864a((View) this);
            this.f1318k.m2868a(true);
            this.f1318k.m2865a(this.f1310c);
            this.f1318k.m2867a(this.f1310c);
        }
        return this.f1318k;
    }
}
