package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p004a.C0023a;
import android.support.v4.view.ad;
import android.support.v4.view.ag;
import android.support.v7.p013b.C0509a.C0498a;
import android.support.v7.p013b.C0509a.C0505h;
import android.support.v7.p013b.C0509a.C0508k;
import android.support.v7.view.C0515d;
import android.support.v7.widget.ag.C0524b;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

/* compiled from: AppCompatSpinner */
public class C0650x extends Spinner implements ad {
    private static final boolean f1722a;
    private static final boolean f1723b;
    private static final int[] f1724c = new int[]{16843505};
    private C0632l f1725d;
    private C0622g f1726e;
    private Context f1727f;
    private C0524b f1728g;
    private SpinnerAdapter f1729h;
    private boolean f1730i;
    private C0649b f1731j;
    private int f1732k;
    private final Rect f1733l;

    /* compiled from: AppCompatSpinner */
    private static class C0645a implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter f1711a;
        private ListAdapter f1712b;

        public C0645a(SpinnerAdapter spinnerAdapter, Theme theme) {
            this.f1711a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f1712b = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (C0650x.f1722a && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            } else if (spinnerAdapter instanceof an) {
                an anVar = (an) spinnerAdapter;
                if (anVar.m2934a() == null) {
                    anVar.m2935a(theme);
                }
            }
        }

        public int getCount() {
            return this.f1711a == null ? 0 : this.f1711a.getCount();
        }

        public Object getItem(int i) {
            return this.f1711a == null ? null : this.f1711a.getItem(i);
        }

        public long getItemId(int i) {
            return this.f1711a == null ? -1 : this.f1711a.getItemId(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            return this.f1711a == null ? null : this.f1711a.getDropDownView(i, view, viewGroup);
        }

        public boolean hasStableIds() {
            return this.f1711a != null && this.f1711a.hasStableIds();
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f1711a != null) {
                this.f1711a.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f1711a != null) {
                this.f1711a.unregisterDataSetObserver(dataSetObserver);
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f1712b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.f1712b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }
    }

    /* compiled from: AppCompatSpinner */
    private class C0649b extends ag {
        final /* synthetic */ C0650x f1718a;
        private CharSequence f1719c;
        private ListAdapter f1720d;
        private final Rect f1721e = new Rect();

        /* compiled from: AppCompatSpinner */
        class C06472 implements OnGlobalLayoutListener {
            final /* synthetic */ C0649b f1715a;

            C06472(C0649b c0649b) {
                this.f1715a = c0649b;
            }

            public void onGlobalLayout() {
                if (this.f1715a.m3152b(this.f1715a.f1718a)) {
                    this.f1715a.mo587b();
                    super.mo588c();
                    return;
                }
                this.f1715a.m2882i();
            }
        }

        public C0649b(final C0650x c0650x, Context context, AttributeSet attributeSet, int i) {
            this.f1718a = c0650x;
            super(context, attributeSet, i);
            m2864a((View) c0650x);
            m2868a(true);
            m2862a(0);
            m2865a(new OnItemClickListener(this) {
                final /* synthetic */ C0649b f1714b;

                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.f1714b.f1718a.setSelection(i);
                    if (this.f1714b.f1718a.getOnItemClickListener() != null) {
                        this.f1714b.f1718a.performItemClick(view, i, this.f1714b.f1720d.getItemId(i));
                    }
                    this.f1714b.m2882i();
                }
            });
        }

        public void mo586a(ListAdapter listAdapter) {
            super.mo586a(listAdapter);
            this.f1720d = listAdapter;
        }

        public CharSequence mo585a() {
            return this.f1719c;
        }

        public void m3155a(CharSequence charSequence) {
            this.f1719c = charSequence;
        }

        void mo587b() {
            int i;
            int i2;
            Drawable d = m2872d();
            if (d != null) {
                d.getPadding(this.f1718a.f1733l);
                i = au.m3012a(this.f1718a) ? this.f1718a.f1733l.right : -this.f1718a.f1733l.left;
            } else {
                Rect b = this.f1718a.f1733l;
                this.f1718a.f1733l.right = 0;
                b.left = 0;
                i = 0;
            }
            int paddingLeft = this.f1718a.getPaddingLeft();
            int paddingRight = this.f1718a.getPaddingRight();
            int width = this.f1718a.getWidth();
            if (this.f1718a.f1732k == -2) {
                int a = this.f1718a.m3159a((SpinnerAdapter) this.f1720d, m2872d());
                i2 = (this.f1718a.getContext().getResources().getDisplayMetrics().widthPixels - this.f1718a.f1733l.left) - this.f1718a.f1733l.right;
                if (a <= i2) {
                    i2 = a;
                }
                m2877f(Math.max(i2, (width - paddingLeft) - paddingRight));
            } else if (this.f1718a.f1732k == -1) {
                m2877f((width - paddingLeft) - paddingRight);
            } else {
                m2877f(this.f1718a.f1732k);
            }
            if (au.m3012a(this.f1718a)) {
                i2 = ((width - paddingRight) - m2880h()) + i;
            } else {
                i2 = i + paddingLeft;
            }
            m2869b(i2);
        }

        public void mo588c() {
            boolean k = m2884k();
            mo587b();
            m2879g(2);
            super.mo588c();
            m2886m().setChoiceMode(1);
            m2881h(this.f1718a.getSelectedItemPosition());
            if (!k) {
                ViewTreeObserver viewTreeObserver = this.f1718a.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    final OnGlobalLayoutListener c06472 = new C06472(this);
                    viewTreeObserver.addOnGlobalLayoutListener(c06472);
                    m2867a(new OnDismissListener(this) {
                        final /* synthetic */ C0649b f1717b;

                        public void onDismiss() {
                            ViewTreeObserver viewTreeObserver = this.f1717b.f1718a.getViewTreeObserver();
                            if (viewTreeObserver != null) {
                                viewTreeObserver.removeGlobalOnLayoutListener(c06472);
                            }
                        }
                    });
                }
            }
        }

        private boolean m3152b(View view) {
            return ag.m1300v(view) && view.getGlobalVisibleRect(this.f1721e);
        }
    }

    static {
        boolean z;
        if (VERSION.SDK_INT >= 23) {
            z = true;
        } else {
            z = false;
        }
        f1722a = z;
        if (VERSION.SDK_INT >= 16) {
            z = true;
        } else {
            z = false;
        }
        f1723b = z;
    }

    public C0650x(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0498a.spinnerStyle);
    }

    public C0650x(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public C0650x(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    public C0650x(Context context, AttributeSet attributeSet, int i, int i2, Theme theme) {
        TypedArray obtainStyledAttributes;
        Throwable e;
        CharSequence[] e2;
        SpinnerAdapter arrayAdapter;
        super(context, attributeSet, i);
        this.f1733l = new Rect();
        ar a = ar.m2940a(context, attributeSet, C0508k.Spinner, i, 0);
        this.f1725d = C0632l.m3110a();
        this.f1726e = new C0622g(this, this.f1725d);
        if (theme != null) {
            this.f1727f = new C0515d(context, theme);
        } else {
            int g = a.m2956g(C0508k.Spinner_popupTheme, 0);
            if (g != 0) {
                this.f1727f = new C0515d(context, g);
            } else {
                this.f1727f = !f1722a ? context : null;
            }
        }
        if (this.f1727f != null) {
            final C0649b c0649b;
            ar a2;
            if (i2 == -1) {
                if (VERSION.SDK_INT >= 11) {
                    try {
                        obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1724c, i, 0);
                        try {
                            if (obtainStyledAttributes.hasValue(0)) {
                                i2 = obtainStyledAttributes.getInt(0, 0);
                            }
                            if (obtainStyledAttributes != null) {
                                obtainStyledAttributes.recycle();
                            }
                        } catch (Exception e3) {
                            e = e3;
                            try {
                                Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                                if (obtainStyledAttributes != null) {
                                    obtainStyledAttributes.recycle();
                                }
                                if (i2 == 1) {
                                    c0649b = new C0649b(this, this.f1727f, attributeSet, i);
                                    a2 = ar.m2940a(this.f1727f, attributeSet, C0508k.Spinner, i, 0);
                                    this.f1732k = a2.m2954f(C0508k.Spinner_android_dropDownWidth, -2);
                                    c0649b.m2863a(a2.m2943a(C0508k.Spinner_android_popupBackground));
                                    c0649b.m3155a(a.m2951d(C0508k.Spinner_android_prompt));
                                    a2.m2944a();
                                    this.f1731j = c0649b;
                                    this.f1728g = new C0524b(this, this) {
                                        final /* synthetic */ C0650x f1710b;

                                        public ag mo446a() {
                                            return c0649b;
                                        }

                                        public boolean mo447b() {
                                            if (!this.f1710b.f1731j.m2884k()) {
                                                this.f1710b.f1731j.mo588c();
                                            }
                                            return true;
                                        }
                                    };
                                }
                                e2 = a.m2953e(C0508k.Spinner_android_entries);
                                if (e2 != null) {
                                    arrayAdapter = new ArrayAdapter(context, 17367048, e2);
                                    arrayAdapter.setDropDownViewResource(C0505h.support_simple_spinner_dropdown_item);
                                    setAdapter(arrayAdapter);
                                }
                                a.m2944a();
                                this.f1730i = true;
                                if (this.f1729h != null) {
                                    setAdapter(this.f1729h);
                                    this.f1729h = null;
                                }
                                this.f1726e.m3086a(attributeSet, i);
                            } catch (Throwable th) {
                                e = th;
                                if (obtainStyledAttributes != null) {
                                    obtainStyledAttributes.recycle();
                                }
                                throw e;
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        obtainStyledAttributes = null;
                        Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                        if (i2 == 1) {
                            c0649b = new C0649b(this, this.f1727f, attributeSet, i);
                            a2 = ar.m2940a(this.f1727f, attributeSet, C0508k.Spinner, i, 0);
                            this.f1732k = a2.m2954f(C0508k.Spinner_android_dropDownWidth, -2);
                            c0649b.m2863a(a2.m2943a(C0508k.Spinner_android_popupBackground));
                            c0649b.m3155a(a.m2951d(C0508k.Spinner_android_prompt));
                            a2.m2944a();
                            this.f1731j = c0649b;
                            this.f1728g = /* anonymous class already generated */;
                        }
                        e2 = a.m2953e(C0508k.Spinner_android_entries);
                        if (e2 != null) {
                            arrayAdapter = new ArrayAdapter(context, 17367048, e2);
                            arrayAdapter.setDropDownViewResource(C0505h.support_simple_spinner_dropdown_item);
                            setAdapter(arrayAdapter);
                        }
                        a.m2944a();
                        this.f1730i = true;
                        if (this.f1729h != null) {
                            setAdapter(this.f1729h);
                            this.f1729h = null;
                        }
                        this.f1726e.m3086a(attributeSet, i);
                    } catch (Throwable th2) {
                        e = th2;
                        obtainStyledAttributes = null;
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                        throw e;
                    }
                }
                i2 = 1;
            }
            if (i2 == 1) {
                c0649b = new C0649b(this, this.f1727f, attributeSet, i);
                a2 = ar.m2940a(this.f1727f, attributeSet, C0508k.Spinner, i, 0);
                this.f1732k = a2.m2954f(C0508k.Spinner_android_dropDownWidth, -2);
                c0649b.m2863a(a2.m2943a(C0508k.Spinner_android_popupBackground));
                c0649b.m3155a(a.m2951d(C0508k.Spinner_android_prompt));
                a2.m2944a();
                this.f1731j = c0649b;
                this.f1728g = /* anonymous class already generated */;
            }
        }
        e2 = a.m2953e(C0508k.Spinner_android_entries);
        if (e2 != null) {
            arrayAdapter = new ArrayAdapter(context, 17367048, e2);
            arrayAdapter.setDropDownViewResource(C0505h.support_simple_spinner_dropdown_item);
            setAdapter(arrayAdapter);
        }
        a.m2944a();
        this.f1730i = true;
        if (this.f1729h != null) {
            setAdapter(this.f1729h);
            this.f1729h = null;
        }
        this.f1726e.m3086a(attributeSet, i);
    }

    public Context getPopupContext() {
        if (this.f1731j != null) {
            return this.f1727f;
        }
        if (f1722a) {
            return super.getPopupContext();
        }
        return null;
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.f1731j != null) {
            this.f1731j.m2863a(drawable);
        } else if (f1723b) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(C0023a.m77a(getPopupContext(), i));
    }

    public Drawable getPopupBackground() {
        if (this.f1731j != null) {
            return this.f1731j.m2872d();
        }
        if (f1723b) {
            return super.getPopupBackground();
        }
        return null;
    }

    public void setDropDownVerticalOffset(int i) {
        if (this.f1731j != null) {
            this.f1731j.m2871c(i);
        } else if (f1723b) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public int getDropDownVerticalOffset() {
        if (this.f1731j != null) {
            return this.f1731j.m2878g();
        }
        if (f1723b) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    public void setDropDownHorizontalOffset(int i) {
        if (this.f1731j != null) {
            this.f1731j.m2869b(i);
        } else if (f1723b) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public int getDropDownHorizontalOffset() {
        if (this.f1731j != null) {
            return this.f1731j.m2876f();
        }
        if (f1723b) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    public void setDropDownWidth(int i) {
        if (this.f1731j != null) {
            this.f1732k = i;
        } else if (f1723b) {
            super.setDropDownWidth(i);
        }
    }

    public int getDropDownWidth() {
        if (this.f1731j != null) {
            return this.f1732k;
        }
        if (f1723b) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.f1730i) {
            super.setAdapter(spinnerAdapter);
            if (this.f1731j != null) {
                this.f1731j.mo586a(new C0645a(spinnerAdapter, (this.f1727f == null ? getContext() : this.f1727f).getTheme()));
                return;
            }
            return;
        }
        this.f1729h = spinnerAdapter;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1731j != null && this.f1731j.m2884k()) {
            this.f1731j.m2882i();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f1728g == null || !this.f1728g.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1731j != null && MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), m3159a(getAdapter(), getBackground())), MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public boolean performClick() {
        if (this.f1731j == null) {
            return super.performClick();
        }
        if (!this.f1731j.m2884k()) {
            this.f1731j.mo588c();
        }
        return true;
    }

    public void setPrompt(CharSequence charSequence) {
        if (this.f1731j != null) {
            this.f1731j.m3155a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public CharSequence getPrompt() {
        return this.f1731j != null ? this.f1731j.mo585a() : super.getPrompt();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1726e != null) {
            this.f1726e.m3082a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1726e != null) {
            this.f1726e.m3085a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1726e != null) {
            this.f1726e.m3083a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1726e != null ? this.f1726e.m3081a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1726e != null) {
            this.f1726e.m3084a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1726e != null ? this.f1726e.m3087b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1726e != null) {
            this.f1726e.m3089c();
        }
    }

    private int m3159a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int max2 = Math.max(0, max - (15 - (min - max)));
        View view = null;
        int i = 0;
        max = 0;
        while (max2 < min) {
            View view2;
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != max) {
                view2 = null;
            } else {
                itemViewType = max;
                view2 = view;
            }
            view = spinnerAdapter.getView(max2, view2, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i = Math.max(i, view.getMeasuredWidth());
            max2++;
            max = itemViewType;
        }
        if (drawable == null) {
            return i;
        }
        drawable.getPadding(this.f1733l);
        return (this.f1733l.left + this.f1733l.right) + i;
    }
}
