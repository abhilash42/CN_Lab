package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.C0325e;
import android.support.v4.view.C0346n;
import android.support.v4.view.C0353p;
import android.support.v4.view.C0361s;
import android.support.v4.view.ag;
import android.support.v7.p012a.C0432a.C0429a;
import android.support.v7.p013b.C0509a.C0498a;
import android.support.v7.p013b.C0509a.C0508k;
import android.support.v7.view.C0514c;
import android.support.v7.view.C0521g;
import android.support.v7.view.menu.C0532l;
import android.support.v7.view.menu.C0532l.C0473a;
import android.support.v7.view.menu.C0538f;
import android.support.v7.view.menu.C0538f.C0457a;
import android.support.v7.view.menu.C0541h;
import android.support.v7.view.menu.C0553p;
import android.support.v7.widget.ActionMenuView.C0566e;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private boolean f1387A;
    private final ArrayList<View> f1388B;
    private final ArrayList<View> f1389C;
    private final int[] f1390D;
    private C0581c f1391E;
    private final C0566e f1392F;
    private as f1393G;
    private C0614d f1394H;
    private C0579a f1395I;
    private C0473a f1396J;
    private C0457a f1397K;
    private boolean f1398L;
    private final Runnable f1399M;
    private final C0632l f1400N;
    View f1401a;
    private ActionMenuView f1402b;
    private TextView f1403c;
    private TextView f1404d;
    private ImageButton f1405e;
    private ImageView f1406f;
    private Drawable f1407g;
    private CharSequence f1408h;
    private ImageButton f1409i;
    private Context f1410j;
    private int f1411k;
    private int f1412l;
    private int f1413m;
    private int f1414n;
    private int f1415o;
    private int f1416p;
    private int f1417q;
    private int f1418r;
    private int f1419s;
    private final aj f1420t;
    private int f1421u;
    private CharSequence f1422v;
    private CharSequence f1423w;
    private int f1424x;
    private int f1425y;
    private boolean f1426z;

    class C05751 implements C0566e {
        final /* synthetic */ Toolbar f1378a;

        C05751(Toolbar toolbar) {
            this.f1378a = toolbar;
        }

        public boolean mo529a(MenuItem menuItem) {
            if (this.f1378a.f1391E != null) {
                return this.f1378a.f1391E.m2755a(menuItem);
            }
            return false;
        }
    }

    class C05762 implements Runnable {
        final /* synthetic */ Toolbar f1379a;

        C05762(Toolbar toolbar) {
            this.f1379a = toolbar;
        }

        public void run() {
            this.f1379a.m2791d();
        }
    }

    class C05773 implements OnClickListener {
        final /* synthetic */ Toolbar f1380a;

        C05773(Toolbar toolbar) {
            this.f1380a = toolbar;
        }

        public void onClick(View view) {
            this.f1380a.m2795h();
        }
    }

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C05781();
        int f1381a;
        boolean f1382b;

        static class C05781 implements Creator<SavedState> {
            C05781() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m2745a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m2746a(i);
            }

            public SavedState m2745a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m2746a(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f1381a = parcel.readInt();
            this.f1382b = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1381a);
            parcel.writeInt(this.f1382b ? 1 : 0);
        }
    }

    private class C0579a implements C0532l {
        C0538f f1383a;
        C0541h f1384b;
        final /* synthetic */ Toolbar f1385c;

        private C0579a(Toolbar toolbar) {
            this.f1385c = toolbar;
        }

        public void mo470a(Context context, C0538f c0538f) {
            if (!(this.f1383a == null || this.f1384b == null)) {
                this.f1383a.mo497d(this.f1384b);
            }
            this.f1383a = c0538f;
        }

        public void mo474b(boolean z) {
            Object obj = null;
            if (this.f1384b != null) {
                if (this.f1383a != null) {
                    int size = this.f1383a.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f1383a.getItem(i) == this.f1384b) {
                            obj = 1;
                            break;
                        }
                    }
                }
                if (obj == null) {
                    mo476b(this.f1383a, this.f1384b);
                }
            }
        }

        public boolean mo473a(C0553p c0553p) {
            return false;
        }

        public void mo471a(C0538f c0538f, boolean z) {
        }

        public boolean mo475b() {
            return false;
        }

        public boolean mo472a(C0538f c0538f, C0541h c0541h) {
            this.f1385c.m2778p();
            if (this.f1385c.f1409i.getParent() != this.f1385c) {
                this.f1385c.addView(this.f1385c.f1409i);
            }
            this.f1385c.f1401a = c0541h.getActionView();
            this.f1384b = c0541h;
            if (this.f1385c.f1401a.getParent() != this.f1385c) {
                LayoutParams i = this.f1385c.m2796i();
                i.a = 8388611 | (this.f1385c.f1414n & 112);
                i.f1386b = 2;
                this.f1385c.f1401a.setLayoutParams(i);
                this.f1385c.addView(this.f1385c.f1401a);
            }
            this.f1385c.m2797j();
            this.f1385c.requestLayout();
            c0541h.m2523e(true);
            if (this.f1385c.f1401a instanceof C0514c) {
                ((C0514c) this.f1385c.f1401a).mo482a();
            }
            return true;
        }

        public boolean mo476b(C0538f c0538f, C0541h c0541h) {
            if (this.f1385c.f1401a instanceof C0514c) {
                ((C0514c) this.f1385c.f1401a).mo483b();
            }
            this.f1385c.removeView(this.f1385c.f1401a);
            this.f1385c.removeView(this.f1385c.f1409i);
            this.f1385c.f1401a = null;
            this.f1385c.m2798k();
            this.f1384b = null;
            this.f1385c.requestLayout();
            c0541h.m2523e(false);
            return true;
        }
    }

    public static class C0580b extends C0429a {
        int f1386b;

        public C0580b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1386b = 0;
        }

        public C0580b(int i, int i2) {
            super(i, i2);
            this.f1386b = 0;
            this.a = 8388627;
        }

        public C0580b(C0580b c0580b) {
            super((C0429a) c0580b);
            this.f1386b = 0;
            this.f1386b = c0580b.f1386b;
        }

        public C0580b(C0429a c0429a) {
            super(c0429a);
            this.f1386b = 0;
        }

        public C0580b(MarginLayoutParams marginLayoutParams) {
            super((LayoutParams) marginLayoutParams);
            this.f1386b = 0;
            m2754a(marginLayoutParams);
        }

        public C0580b(LayoutParams layoutParams) {
            super(layoutParams);
            this.f1386b = 0;
        }

        void m2754a(MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    public interface C0581c {
        boolean m2755a(MenuItem menuItem);
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m2796i();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m2781a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m2782a(layoutParams);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0498a.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1420t = new aj();
        this.f1421u = 8388627;
        this.f1388B = new ArrayList();
        this.f1389C = new ArrayList();
        this.f1390D = new int[2];
        this.f1392F = new C05751(this);
        this.f1399M = new C05762(this);
        ar a = ar.m2940a(getContext(), attributeSet, C0508k.Toolbar, i, 0);
        this.f1412l = a.m2956g(C0508k.Toolbar_titleTextAppearance, 0);
        this.f1413m = a.m2956g(C0508k.Toolbar_subtitleTextAppearance, 0);
        this.f1421u = a.m2948c(C0508k.Toolbar_android_gravity, this.f1421u);
        this.f1414n = 48;
        int d = a.m2950d(C0508k.Toolbar_titleMargins, 0);
        this.f1419s = d;
        this.f1418r = d;
        this.f1417q = d;
        this.f1416p = d;
        d = a.m2950d(C0508k.Toolbar_titleMarginStart, -1);
        if (d >= 0) {
            this.f1416p = d;
        }
        d = a.m2950d(C0508k.Toolbar_titleMarginEnd, -1);
        if (d >= 0) {
            this.f1417q = d;
        }
        d = a.m2950d(C0508k.Toolbar_titleMarginTop, -1);
        if (d >= 0) {
            this.f1418r = d;
        }
        d = a.m2950d(C0508k.Toolbar_titleMarginBottom, -1);
        if (d >= 0) {
            this.f1419s = d;
        }
        this.f1415o = a.m2952e(C0508k.Toolbar_maxButtonHeight, -1);
        d = a.m2950d(C0508k.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int d2 = a.m2950d(C0508k.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        this.f1420t.m2892b(a.m2952e(C0508k.Toolbar_contentInsetLeft, 0), a.m2952e(C0508k.Toolbar_contentInsetRight, 0));
        if (!(d == Integer.MIN_VALUE && d2 == Integer.MIN_VALUE)) {
            this.f1420t.m2889a(d, d2);
        }
        this.f1407g = a.m2943a(C0508k.Toolbar_collapseIcon);
        this.f1408h = a.m2949c(C0508k.Toolbar_collapseContentDescription);
        CharSequence c = a.m2949c(C0508k.Toolbar_title);
        if (!TextUtils.isEmpty(c)) {
            setTitle(c);
        }
        c = a.m2949c(C0508k.Toolbar_subtitle);
        if (!TextUtils.isEmpty(c)) {
            setSubtitle(c);
        }
        this.f1410j = getContext();
        setPopupTheme(a.m2956g(C0508k.Toolbar_popupTheme, 0));
        Drawable a2 = a.m2943a(C0508k.Toolbar_navigationIcon);
        if (a2 != null) {
            setNavigationIcon(a2);
        }
        c = a.m2949c(C0508k.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(c)) {
            setNavigationContentDescription(c);
        }
        a2 = a.m2943a(C0508k.Toolbar_logo);
        if (a2 != null) {
            setLogo(a2);
        }
        c = a.m2949c(C0508k.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(c)) {
            setLogoDescription(c);
        }
        if (a.m2955f(C0508k.Toolbar_titleTextColor)) {
            setTitleTextColor(a.m2946b(C0508k.Toolbar_titleTextColor, -1));
        }
        if (a.m2955f(C0508k.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(a.m2946b(C0508k.Toolbar_subtitleTextColor, -1));
        }
        a.m2944a();
        this.f1400N = C0632l.m3110a();
    }

    public void setPopupTheme(int i) {
        if (this.f1411k != i) {
            this.f1411k = i;
            if (i == 0) {
                this.f1410j = getContext();
            } else {
                this.f1410j = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.f1411k;
    }

    public void onRtlPropertiesChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        aj ajVar = this.f1420t;
        if (i != 1) {
            z = false;
        }
        ajVar.m2890a(z);
    }

    public void setLogo(int i) {
        setLogo(this.f1400N.m3133a(getContext(), i));
    }

    public boolean m2787a() {
        return getVisibility() == 0 && this.f1402b != null && this.f1402b.m2673a();
    }

    public boolean m2789b() {
        return this.f1402b != null && this.f1402b.m2683g();
    }

    public boolean m2790c() {
        return this.f1402b != null && this.f1402b.m2684h();
    }

    public boolean m2791d() {
        return this.f1402b != null && this.f1402b.m2681e();
    }

    public boolean m2792e() {
        return this.f1402b != null && this.f1402b.m2682f();
    }

    public void m2785a(C0538f c0538f, C0614d c0614d) {
        if (c0538f != null || this.f1402b != null) {
            m2776n();
            C0538f d = this.f1402b.m2680d();
            if (d != c0538f) {
                if (d != null) {
                    d.m2477b(this.f1394H);
                    d.m2477b(this.f1395I);
                }
                if (this.f1395I == null) {
                    this.f1395I = new C0579a();
                }
                c0614d.m3051d(true);
                if (c0538f != null) {
                    c0538f.m2467a((C0532l) c0614d, this.f1410j);
                    c0538f.m2467a(this.f1395I, this.f1410j);
                } else {
                    c0614d.mo470a(this.f1410j, null);
                    this.f1395I.mo470a(this.f1410j, null);
                    c0614d.mo474b(true);
                    this.f1395I.mo474b(true);
                }
                this.f1402b.setPopupTheme(this.f1411k);
                this.f1402b.setPresenter(c0614d);
                this.f1394H = c0614d;
            }
        }
    }

    public void m2793f() {
        if (this.f1402b != null) {
            this.f1402b.m2685i();
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            m2774l();
            if (!m2773d(this.f1406f)) {
                m2763a(this.f1406f, true);
            }
        } else if (this.f1406f != null && m2773d(this.f1406f)) {
            removeView(this.f1406f);
            this.f1389C.remove(this.f1406f);
        }
        if (this.f1406f != null) {
            this.f1406f.setImageDrawable(drawable);
        }
    }

    public Drawable getLogo() {
        return this.f1406f != null ? this.f1406f.getDrawable() : null;
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m2774l();
        }
        if (this.f1406f != null) {
            this.f1406f.setContentDescription(charSequence);
        }
    }

    public CharSequence getLogoDescription() {
        return this.f1406f != null ? this.f1406f.getContentDescription() : null;
    }

    private void m2774l() {
        if (this.f1406f == null) {
            this.f1406f = new ImageView(getContext());
        }
    }

    public boolean m2794g() {
        return (this.f1395I == null || this.f1395I.f1384b == null) ? false : true;
    }

    public void m2795h() {
        C0541h c0541h = this.f1395I == null ? null : this.f1395I.f1384b;
        if (c0541h != null) {
            c0541h.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.f1422v;
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1403c == null) {
                Context context = getContext();
                this.f1403c = new TextView(context);
                this.f1403c.setSingleLine();
                this.f1403c.setEllipsize(TruncateAt.END);
                if (this.f1412l != 0) {
                    this.f1403c.setTextAppearance(context, this.f1412l);
                }
                if (this.f1424x != 0) {
                    this.f1403c.setTextColor(this.f1424x);
                }
            }
            if (!m2773d(this.f1403c)) {
                m2763a(this.f1403c, true);
            }
        } else if (this.f1403c != null && m2773d(this.f1403c)) {
            removeView(this.f1403c);
            this.f1389C.remove(this.f1403c);
        }
        if (this.f1403c != null) {
            this.f1403c.setText(charSequence);
        }
        this.f1422v = charSequence;
    }

    public CharSequence getSubtitle() {
        return this.f1423w;
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1404d == null) {
                Context context = getContext();
                this.f1404d = new TextView(context);
                this.f1404d.setSingleLine();
                this.f1404d.setEllipsize(TruncateAt.END);
                if (this.f1413m != 0) {
                    this.f1404d.setTextAppearance(context, this.f1413m);
                }
                if (this.f1425y != 0) {
                    this.f1404d.setTextColor(this.f1425y);
                }
            }
            if (!m2773d(this.f1404d)) {
                m2763a(this.f1404d, true);
            }
        } else if (this.f1404d != null && m2773d(this.f1404d)) {
            removeView(this.f1404d);
            this.f1389C.remove(this.f1404d);
        }
        if (this.f1404d != null) {
            this.f1404d.setText(charSequence);
        }
        this.f1423w = charSequence;
    }

    public void m2784a(Context context, int i) {
        this.f1412l = i;
        if (this.f1403c != null) {
            this.f1403c.setTextAppearance(context, i);
        }
    }

    public void m2788b(Context context, int i) {
        this.f1413m = i;
        if (this.f1404d != null) {
            this.f1404d.setTextAppearance(context, i);
        }
    }

    public void setTitleTextColor(int i) {
        this.f1424x = i;
        if (this.f1403c != null) {
            this.f1403c.setTextColor(i);
        }
    }

    public void setSubtitleTextColor(int i) {
        this.f1425y = i;
        if (this.f1404d != null) {
            this.f1404d.setTextColor(i);
        }
    }

    public CharSequence getNavigationContentDescription() {
        return this.f1405e != null ? this.f1405e.getContentDescription() : null;
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m2777o();
        }
        if (this.f1405e != null) {
            this.f1405e.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(this.f1400N.m3133a(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            m2777o();
            if (!m2773d(this.f1405e)) {
                m2763a(this.f1405e, true);
            }
        } else if (this.f1405e != null && m2773d(this.f1405e)) {
            removeView(this.f1405e);
            this.f1389C.remove(this.f1405e);
        }
        if (this.f1405e != null) {
            this.f1405e.setImageDrawable(drawable);
        }
    }

    public Drawable getNavigationIcon() {
        return this.f1405e != null ? this.f1405e.getDrawable() : null;
    }

    public void setNavigationOnClickListener(OnClickListener onClickListener) {
        m2777o();
        this.f1405e.setOnClickListener(onClickListener);
    }

    public Menu getMenu() {
        m2775m();
        return this.f1402b.getMenu();
    }

    public void setOverflowIcon(Drawable drawable) {
        m2775m();
        this.f1402b.setOverflowIcon(drawable);
    }

    public Drawable getOverflowIcon() {
        m2775m();
        return this.f1402b.getOverflowIcon();
    }

    private void m2775m() {
        m2776n();
        if (this.f1402b.m2680d() == null) {
            C0538f c0538f = (C0538f) this.f1402b.getMenu();
            if (this.f1395I == null) {
                this.f1395I = new C0579a();
            }
            this.f1402b.setExpandedActionViewsExclusive(true);
            c0538f.m2467a(this.f1395I, this.f1410j);
        }
    }

    private void m2776n() {
        if (this.f1402b == null) {
            this.f1402b = new ActionMenuView(getContext());
            this.f1402b.setPopupTheme(this.f1411k);
            this.f1402b.setOnMenuItemClickListener(this.f1392F);
            this.f1402b.m2672a(this.f1396J, this.f1397K);
            LayoutParams i = m2796i();
            i.a = 8388613 | (this.f1414n & 112);
            this.f1402b.setLayoutParams(i);
            m2763a(this.f1402b, false);
        }
    }

    private MenuInflater getMenuInflater() {
        return new C0521g(getContext());
    }

    public void setOnMenuItemClickListener(C0581c c0581c) {
        this.f1391E = c0581c;
    }

    public void m2783a(int i, int i2) {
        this.f1420t.m2889a(i, i2);
    }

    public int getContentInsetStart() {
        return this.f1420t.m2893c();
    }

    public int getContentInsetEnd() {
        return this.f1420t.m2894d();
    }

    public int getContentInsetLeft() {
        return this.f1420t.m2888a();
    }

    public int getContentInsetRight() {
        return this.f1420t.m2891b();
    }

    private void m2777o() {
        if (this.f1405e == null) {
            this.f1405e = new ImageButton(getContext(), null, C0498a.toolbarNavigationButtonStyle);
            LayoutParams i = m2796i();
            i.a = 8388611 | (this.f1414n & 112);
            this.f1405e.setLayoutParams(i);
        }
    }

    private void m2778p() {
        if (this.f1409i == null) {
            this.f1409i = new ImageButton(getContext(), null, C0498a.toolbarNavigationButtonStyle);
            this.f1409i.setImageDrawable(this.f1407g);
            this.f1409i.setContentDescription(this.f1408h);
            LayoutParams i = m2796i();
            i.a = 8388611 | (this.f1414n & 112);
            i.f1386b = 2;
            this.f1409i.setLayoutParams(i);
            this.f1409i.setOnClickListener(new C05773(this));
        }
    }

    private void m2763a(View view, boolean z) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = m2796i();
        } else if (checkLayoutParams(layoutParams)) {
            C0580b c0580b = (C0580b) layoutParams;
        } else {
            layoutParams = m2782a(layoutParams);
        }
        layoutParams.f1386b = 1;
        if (!z || this.f1401a == null) {
            addView(view, layoutParams);
            return;
        }
        view.setLayoutParams(layoutParams);
        this.f1389C.add(view);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        if (!(this.f1395I == null || this.f1395I.f1384b == null)) {
            savedState.f1381a = this.f1395I.f1384b.getItemId();
        }
        savedState.f1382b = m2789b();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            Menu d = this.f1402b != null ? this.f1402b.m2680d() : null;
            if (!(savedState.f1381a == 0 || this.f1395I == null || d == null)) {
                MenuItem findItem = d.findItem(savedState.f1381a);
                if (findItem != null) {
                    C0353p.m1589b(findItem);
                }
            }
            if (savedState.f1382b) {
                m2779q();
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private void m2779q() {
        removeCallbacks(this.f1399M);
        post(this.f1399M);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f1399M);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = C0361s.m1615a(motionEvent);
        if (a == 0) {
            this.f1426z = false;
        }
        if (!this.f1426z) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a == 0 && !onTouchEvent) {
                this.f1426z = true;
            }
        }
        if (a == 1 || a == 3) {
            this.f1426z = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int a = C0361s.m1615a(motionEvent);
        if (a == 9) {
            this.f1387A = false;
        }
        if (!this.f1387A) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (a == 9 && !onHoverEvent) {
                this.f1387A = true;
            }
        }
        if (a == 10 || a == 3) {
            this.f1387A = false;
        }
        return true;
    }

    private void m2762a(View view, int i, int i2, int i3, int i4, int i5) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height);
        int mode = MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private int m2758a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + max) + i2, marginLayoutParams.width), getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private boolean m2780r() {
        if (!this.f1398L) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m2765a(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int max;
        int i5 = 0;
        int i6 = 0;
        int[] iArr = this.f1390D;
        if (au.m3012a(this)) {
            i3 = 0;
            i4 = 1;
        } else {
            i3 = 1;
            i4 = 0;
        }
        int i7 = 0;
        if (m2765a(this.f1405e)) {
            m2762a(this.f1405e, i, 0, i2, 0, this.f1415o);
            i7 = this.f1405e.getMeasuredWidth() + m2767b(this.f1405e);
            max = Math.max(0, this.f1405e.getMeasuredHeight() + m2770c(this.f1405e));
            i6 = au.m3010a(0, ag.m1285g(this.f1405e));
            i5 = max;
        }
        if (m2765a(this.f1409i)) {
            m2762a(this.f1409i, i, 0, i2, 0, this.f1415o);
            i7 = this.f1409i.getMeasuredWidth() + m2767b(this.f1409i);
            i5 = Math.max(i5, this.f1409i.getMeasuredHeight() + m2770c(this.f1409i));
            i6 = au.m3010a(i6, ag.m1285g(this.f1409i));
        }
        int contentInsetStart = getContentInsetStart();
        int max2 = 0 + Math.max(contentInsetStart, i7);
        iArr[i4] = Math.max(0, contentInsetStart - i7);
        i7 = 0;
        if (m2765a(this.f1402b)) {
            m2762a(this.f1402b, i, max2, i2, 0, this.f1415o);
            i7 = this.f1402b.getMeasuredWidth() + m2767b(this.f1402b);
            i5 = Math.max(i5, this.f1402b.getMeasuredHeight() + m2770c(this.f1402b));
            i6 = au.m3010a(i6, ag.m1285g(this.f1402b));
        }
        contentInsetStart = getContentInsetEnd();
        max2 += Math.max(contentInsetStart, i7);
        iArr[i3] = Math.max(0, contentInsetStart - i7);
        if (m2765a(this.f1401a)) {
            max2 += m2758a(this.f1401a, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.f1401a.getMeasuredHeight() + m2770c(this.f1401a));
            i6 = au.m3010a(i6, ag.m1285g(this.f1401a));
        }
        if (m2765a(this.f1406f)) {
            max2 += m2758a(this.f1406f, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.f1406f.getMeasuredHeight() + m2770c(this.f1406f));
            i6 = au.m3010a(i6, ag.m1285g(this.f1406f));
        }
        i4 = getChildCount();
        i3 = 0;
        int i8 = i5;
        i5 = i6;
        while (i3 < i4) {
            View childAt = getChildAt(i3);
            if (((C0580b) childAt.getLayoutParams()).f1386b != 0) {
                i7 = i5;
                contentInsetStart = i8;
            } else if (m2765a(childAt)) {
                max2 += m2758a(childAt, i, max2, i2, 0, iArr);
                max = Math.max(i8, childAt.getMeasuredHeight() + m2770c(childAt));
                i7 = au.m3010a(i5, ag.m1285g(childAt));
                contentInsetStart = max;
            } else {
                i7 = i5;
                contentInsetStart = i8;
            }
            i3++;
            i5 = i7;
            i8 = contentInsetStart;
        }
        contentInsetStart = 0;
        i7 = 0;
        i6 = this.f1418r + this.f1419s;
        max = this.f1416p + this.f1417q;
        if (m2765a(this.f1403c)) {
            m2758a(this.f1403c, i, max2 + max, i2, i6, iArr);
            contentInsetStart = m2767b(this.f1403c) + this.f1403c.getMeasuredWidth();
            i7 = this.f1403c.getMeasuredHeight() + m2770c(this.f1403c);
            i5 = au.m3010a(i5, ag.m1285g(this.f1403c));
        }
        if (m2765a(this.f1404d)) {
            contentInsetStart = Math.max(contentInsetStart, m2758a(this.f1404d, i, max2 + max, i2, i6 + i7, iArr));
            i7 += this.f1404d.getMeasuredHeight() + m2770c(this.f1404d);
            i5 = au.m3010a(i5, ag.m1285g(this.f1404d));
        }
        contentInsetStart += max2;
        i7 = Math.max(i8, i7) + (getPaddingTop() + getPaddingBottom());
        contentInsetStart = ag.m1258a(Math.max(contentInsetStart + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, -16777216 & i5);
        i7 = ag.m1258a(Math.max(i7, getSuggestedMinimumHeight()), i2, i5 << 16);
        if (m2780r()) {
            i7 = 0;
        }
        setMeasuredDimension(contentInsetStart, i7);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Object obj;
        int i5;
        int i6;
        int i7;
        int measuredHeight;
        int measuredWidth;
        if (ag.m1283e(this) == 1) {
            obj = 1;
        } else {
            obj = null;
        }
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i8 = width - paddingRight;
        int[] iArr = this.f1390D;
        iArr[1] = 0;
        iArr[0] = 0;
        int k = ag.m1289k(this);
        if (!m2765a(this.f1405e)) {
            i5 = paddingLeft;
        } else if (obj != null) {
            i8 = m2768b(this.f1405e, i8, iArr, k);
            i5 = paddingLeft;
        } else {
            i5 = m2759a(this.f1405e, paddingLeft, iArr, k);
        }
        if (m2765a(this.f1409i)) {
            if (obj != null) {
                i8 = m2768b(this.f1409i, i8, iArr, k);
            } else {
                i5 = m2759a(this.f1409i, i5, iArr, k);
            }
        }
        if (m2765a(this.f1402b)) {
            if (obj != null) {
                i5 = m2759a(this.f1402b, i5, iArr, k);
            } else {
                i8 = m2768b(this.f1402b, i8, iArr, k);
            }
        }
        iArr[0] = Math.max(0, getContentInsetLeft() - i5);
        iArr[1] = Math.max(0, getContentInsetRight() - ((width - paddingRight) - i8));
        i5 = Math.max(i5, getContentInsetLeft());
        i8 = Math.min(i8, (width - paddingRight) - getContentInsetRight());
        if (m2765a(this.f1401a)) {
            if (obj != null) {
                i8 = m2768b(this.f1401a, i8, iArr, k);
            } else {
                i5 = m2759a(this.f1401a, i5, iArr, k);
            }
        }
        if (!m2765a(this.f1406f)) {
            i6 = i8;
            i7 = i5;
        } else if (obj != null) {
            i6 = m2768b(this.f1406f, i8, iArr, k);
            i7 = i5;
        } else {
            i6 = i8;
            i7 = m2759a(this.f1406f, i5, iArr, k);
        }
        boolean a = m2765a(this.f1403c);
        boolean a2 = m2765a(this.f1404d);
        i5 = 0;
        if (a) {
            C0580b c0580b = (C0580b) this.f1403c.getLayoutParams();
            i5 = 0 + (c0580b.bottomMargin + (c0580b.topMargin + this.f1403c.getMeasuredHeight()));
        }
        if (a2) {
            c0580b = (C0580b) this.f1404d.getLayoutParams();
            measuredHeight = (c0580b.bottomMargin + (c0580b.topMargin + this.f1404d.getMeasuredHeight())) + i5;
        } else {
            measuredHeight = i5;
        }
        if (a || a2) {
            int paddingTop2;
            c0580b = (C0580b) (a ? this.f1403c : this.f1404d).getLayoutParams();
            C0580b c0580b2 = (C0580b) (a2 ? this.f1404d : this.f1403c).getLayoutParams();
            Object obj2 = ((!a || this.f1403c.getMeasuredWidth() <= 0) && (!a2 || this.f1404d.getMeasuredWidth() <= 0)) ? null : 1;
            switch (this.f1421u & 112) {
                case 48:
                    paddingTop2 = (c0580b.topMargin + getPaddingTop()) + this.f1418r;
                    break;
                case 80:
                    paddingTop2 = (((height - paddingBottom) - c0580b2.bottomMargin) - this.f1419s) - measuredHeight;
                    break;
                default:
                    paddingTop2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                    if (paddingTop2 < c0580b.topMargin + this.f1418r) {
                        i8 = c0580b.topMargin + this.f1418r;
                    } else {
                        measuredHeight = (((height - paddingBottom) - measuredHeight) - paddingTop2) - paddingTop;
                        if (measuredHeight < c0580b.bottomMargin + this.f1419s) {
                            i8 = Math.max(0, paddingTop2 - ((c0580b2.bottomMargin + this.f1419s) - measuredHeight));
                        } else {
                            i8 = paddingTop2;
                        }
                    }
                    paddingTop2 = paddingTop + i8;
                    break;
            }
            if (obj != null) {
                i8 = (obj2 != null ? this.f1416p : 0) - iArr[1];
                i5 = i6 - Math.max(0, i8);
                iArr[1] = Math.max(0, -i8);
                if (a) {
                    c0580b = (C0580b) this.f1403c.getLayoutParams();
                    measuredWidth = i5 - this.f1403c.getMeasuredWidth();
                    i6 = this.f1403c.getMeasuredHeight() + paddingTop2;
                    this.f1403c.layout(measuredWidth, paddingTop2, i5, i6);
                    paddingTop2 = i6 + c0580b.bottomMargin;
                    i6 = measuredWidth - this.f1417q;
                } else {
                    i6 = i5;
                }
                if (a2) {
                    c0580b = (C0580b) this.f1404d.getLayoutParams();
                    measuredWidth = c0580b.topMargin + paddingTop2;
                    measuredHeight = this.f1404d.getMeasuredHeight() + measuredWidth;
                    this.f1404d.layout(i5 - this.f1404d.getMeasuredWidth(), measuredWidth, i5, measuredHeight);
                    i8 = c0580b.bottomMargin + measuredHeight;
                    i8 = i5 - this.f1417q;
                } else {
                    i8 = i5;
                }
                if (obj2 != null) {
                    i8 = Math.min(i6, i8);
                } else {
                    i8 = i5;
                }
                i6 = i8;
            } else {
                i8 = (obj2 != null ? this.f1416p : 0) - iArr[0];
                i7 += Math.max(0, i8);
                iArr[0] = Math.max(0, -i8);
                if (a) {
                    c0580b = (C0580b) this.f1403c.getLayoutParams();
                    i5 = this.f1403c.getMeasuredWidth() + i7;
                    measuredWidth = this.f1403c.getMeasuredHeight() + paddingTop2;
                    this.f1403c.layout(i7, paddingTop2, i5, measuredWidth);
                    i8 = c0580b.bottomMargin + measuredWidth;
                    measuredWidth = i5 + this.f1417q;
                    i5 = i8;
                } else {
                    measuredWidth = i7;
                    i5 = paddingTop2;
                }
                if (a2) {
                    c0580b = (C0580b) this.f1404d.getLayoutParams();
                    i5 += c0580b.topMargin;
                    paddingTop2 = this.f1404d.getMeasuredWidth() + i7;
                    measuredHeight = this.f1404d.getMeasuredHeight() + i5;
                    this.f1404d.layout(i7, i5, paddingTop2, measuredHeight);
                    i8 = c0580b.bottomMargin + measuredHeight;
                    i8 = this.f1417q + paddingTop2;
                } else {
                    i8 = i7;
                }
                if (obj2 != null) {
                    i7 = Math.max(measuredWidth, i8);
                }
            }
        }
        m2764a(this.f1388B, 3);
        int size = this.f1388B.size();
        i5 = i7;
        for (measuredWidth = 0; measuredWidth < size; measuredWidth++) {
            i5 = m2759a((View) this.f1388B.get(measuredWidth), i5, iArr, k);
        }
        m2764a(this.f1388B, 5);
        i7 = this.f1388B.size();
        for (measuredWidth = 0; measuredWidth < i7; measuredWidth++) {
            i6 = m2768b((View) this.f1388B.get(measuredWidth), i6, iArr, k);
        }
        m2764a(this.f1388B, 1);
        measuredWidth = m2760a(this.f1388B, iArr);
        i8 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (measuredWidth / 2);
        measuredWidth += i8;
        if (i8 < i5) {
            i8 = i5;
        } else if (measuredWidth > i6) {
            i8 -= measuredWidth - i6;
        }
        paddingLeft = this.f1388B.size();
        measuredWidth = i8;
        for (i5 = 0; i5 < paddingLeft; i5++) {
            measuredWidth = m2759a((View) this.f1388B.get(i5), measuredWidth, iArr, k);
        }
        this.f1388B.clear();
    }

    private int m2760a(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        int i5 = i2;
        int i6 = i;
        while (i3 < size) {
            View view = (View) list.get(i3);
            C0580b c0580b = (C0580b) view.getLayoutParams();
            i6 = c0580b.leftMargin - i6;
            i = c0580b.rightMargin - i5;
            int max = Math.max(0, i6);
            int max2 = Math.max(0, i);
            i6 = Math.max(0, -i6);
            i5 = Math.max(0, -i);
            i3++;
            i4 += (view.getMeasuredWidth() + max) + max2;
        }
        return i4;
    }

    private int m2759a(View view, int i, int[] iArr, int i2) {
        C0580b c0580b = (C0580b) view.getLayoutParams();
        int i3 = c0580b.leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        i3 = m2757a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, i3, max + measuredWidth, view.getMeasuredHeight() + i3);
        return (c0580b.rightMargin + measuredWidth) + max;
    }

    private int m2768b(View view, int i, int[] iArr, int i2) {
        C0580b c0580b = (C0580b) view.getLayoutParams();
        int i3 = c0580b.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        i3 = m2757a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, i3, max, view.getMeasuredHeight() + i3);
        return max - (c0580b.leftMargin + measuredWidth);
    }

    private int m2757a(View view, int i) {
        C0580b c0580b = (C0580b) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        switch (m2756a(c0580b.a)) {
            case 48:
                return getPaddingTop() - i2;
            case 80:
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - c0580b.bottomMargin) - i2;
            default:
                int i3;
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                i2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                if (i2 < c0580b.topMargin) {
                    i3 = c0580b.topMargin;
                } else {
                    measuredHeight = (((height - paddingBottom) - measuredHeight) - i2) - paddingTop;
                    i3 = measuredHeight < c0580b.bottomMargin ? Math.max(0, i2 - (c0580b.bottomMargin - measuredHeight)) : i2;
                }
                return i3 + paddingTop;
        }
    }

    private int m2756a(int i) {
        int i2 = i & 112;
        switch (i2) {
            case 16:
            case 48:
            case 80:
                return i2;
            default:
                return this.f1421u & 112;
        }
    }

    private void m2764a(List<View> list, int i) {
        int i2 = 1;
        int i3 = 0;
        if (ag.m1283e(this) != 1) {
            i2 = 0;
        }
        int childCount = getChildCount();
        int a = C0325e.m1523a(i, ag.m1283e(this));
        list.clear();
        C0580b c0580b;
        if (i2 != 0) {
            for (i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                c0580b = (C0580b) childAt.getLayoutParams();
                if (c0580b.f1386b == 0 && m2765a(childAt) && m2766b(c0580b.a) == a) {
                    list.add(childAt);
                }
            }
            return;
        }
        while (i3 < childCount) {
            View childAt2 = getChildAt(i3);
            c0580b = (C0580b) childAt2.getLayoutParams();
            if (c0580b.f1386b == 0 && m2765a(childAt2) && m2766b(c0580b.a) == a) {
                list.add(childAt2);
            }
            i3++;
        }
    }

    private int m2766b(int i) {
        int e = ag.m1283e(this);
        int a = C0325e.m1523a(i, e) & 7;
        switch (a) {
            case 1:
            case 3:
            case 5:
                return a;
            default:
                return e == 1 ? 5 : 3;
        }
    }

    private boolean m2765a(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int m2767b(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return C0346n.m1559b(marginLayoutParams) + C0346n.m1558a(marginLayoutParams);
    }

    private int m2770c(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    public C0580b m2781a(AttributeSet attributeSet) {
        return new C0580b(getContext(), attributeSet);
    }

    protected C0580b m2782a(LayoutParams layoutParams) {
        if (layoutParams instanceof C0580b) {
            return new C0580b((C0580b) layoutParams);
        }
        if (layoutParams instanceof C0429a) {
            return new C0580b((C0429a) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new C0580b((MarginLayoutParams) layoutParams);
        }
        return new C0580b(layoutParams);
    }

    protected C0580b m2796i() {
        return new C0580b(-2, -2);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof C0580b);
    }

    public ac getWrapper() {
        if (this.f1393G == null) {
            this.f1393G = new as(this, true);
        }
        return this.f1393G;
    }

    void m2797j() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((C0580b) childAt.getLayoutParams()).f1386b == 2 || childAt == this.f1402b)) {
                removeViewAt(childCount);
                this.f1389C.add(childAt);
            }
        }
    }

    void m2798k() {
        for (int size = this.f1389C.size() - 1; size >= 0; size--) {
            addView((View) this.f1389C.get(size));
        }
        this.f1389C.clear();
    }

    private boolean m2773d(View view) {
        return view.getParent() == this || this.f1389C.contains(view);
    }

    public void setCollapsible(boolean z) {
        this.f1398L = z;
        requestLayout();
    }

    public void m2786a(C0473a c0473a, C0457a c0457a) {
        this.f1396J = c0473a;
        this.f1397K = c0457a;
        if (this.f1402b != null) {
            this.f1402b.m2672a(c0473a, c0457a);
        }
    }
}
