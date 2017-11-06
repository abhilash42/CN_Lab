package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.p013b.C0509a.C0499b;
import android.support.v7.p013b.C0509a.C0508k;
import android.support.v7.view.menu.C0530m.C0527a;
import android.support.v7.view.menu.C0538f.C0529b;
import android.support.v7.widget.ActionMenuView.C0528a;
import android.support.v7.widget.aa;
import android.support.v7.widget.ag;
import android.support.v7.widget.ag.C0524b;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Toast;

public class ActionMenuItemView extends aa implements C0527a, C0528a, OnClickListener, OnLongClickListener {
    private C0541h f1047a;
    private CharSequence f1048b;
    private Drawable f1049c;
    private C0529b f1050d;
    private C0524b f1051e;
    private C0526b f1052f;
    private boolean f1053g;
    private boolean f1054h;
    private int f1055i;
    private int f1056j;
    private int f1057k;

    private class C0525a extends C0524b {
        final /* synthetic */ ActionMenuItemView f1043a;

        public C0525a(ActionMenuItemView actionMenuItemView) {
            this.f1043a = actionMenuItemView;
            super(actionMenuItemView);
        }

        public ag mo446a() {
            if (this.f1043a.f1052f != null) {
                return this.f1043a.f1052f.mo573a();
            }
            return null;
        }

        protected boolean mo447b() {
            if (this.f1043a.f1050d == null || !this.f1043a.f1050d.mo458a(this.f1043a.f1047a)) {
                return false;
            }
            ag a = mo446a();
            if (a == null || !a.m2884k()) {
                return false;
            }
            return true;
        }
    }

    public static abstract class C0526b {
        public abstract ag mo573a();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f1053g = resources.getBoolean(C0499b.abc_config_allowActionMenuItemTextWithIcon);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0508k.ActionMenuItemView, i, 0);
        this.f1055i = obtainStyledAttributes.getDimensionPixelSize(C0508k.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.f1057k = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        setOnLongClickListener(this);
        this.f1056j = -1;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        this.f1053g = getContext().getResources().getBoolean(C0499b.abc_config_allowActionMenuItemTextWithIcon);
        m2383e();
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.f1056j = i;
        super.setPadding(i, i2, i3, i4);
    }

    public C0541h getItemData() {
        return this.f1047a;
    }

    public void mo452a(C0541h c0541h, int i) {
        this.f1047a = c0541h;
        setIcon(c0541h.getIcon());
        setTitle(c0541h.m2511a((C0527a) this));
        setId(c0541h.getItemId());
        setVisibility(c0541h.isVisible() ? 0 : 8);
        setEnabled(c0541h.isEnabled());
        if (c0541h.hasSubMenu() && this.f1051e == null) {
            this.f1051e = new C0525a(this);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f1047a.hasSubMenu() && this.f1051e != null && this.f1051e.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onClick(View view) {
        if (this.f1050d != null) {
            this.f1050d.mo458a(this.f1047a);
        }
    }

    public void setItemInvoker(C0529b c0529b) {
        this.f1050d = c0529b;
    }

    public void setPopupCallback(C0526b c0526b) {
        this.f1052f = c0526b;
    }

    public boolean mo453a() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.f1054h != z) {
            this.f1054h = z;
            if (this.f1047a != null) {
                this.f1047a.m2526h();
            }
        }
    }

    private void m2383e() {
        int i = 0;
        int i2 = !TextUtils.isEmpty(this.f1048b) ? 1 : 0;
        if (this.f1049c == null || (this.f1047a.m2531m() && (this.f1053g || this.f1054h))) {
            i = 1;
        }
        setText((i2 & i) != 0 ? this.f1048b : null);
    }

    public void setIcon(Drawable drawable) {
        this.f1049c = drawable;
        if (drawable != null) {
            float f;
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.f1057k) {
                f = ((float) this.f1057k) / ((float) intrinsicWidth);
                intrinsicWidth = this.f1057k;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            }
            if (intrinsicHeight > this.f1057k) {
                f = ((float) this.f1057k) / ((float) intrinsicHeight);
                intrinsicHeight = this.f1057k;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        m2383e();
    }

    public boolean m2386b() {
        return !TextUtils.isEmpty(getText());
    }

    public void setTitle(CharSequence charSequence) {
        this.f1048b = charSequence;
        setContentDescription(this.f1048b);
        m2383e();
    }

    public boolean mo454c() {
        return m2386b() && this.f1047a.getIcon() == null;
    }

    public boolean mo455d() {
        return m2386b();
    }

    public boolean onLongClick(View view) {
        if (m2386b()) {
            return false;
        }
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = iArr[1] + (height / 2);
        width = (width / 2) + iArr[0];
        if (android.support.v4.view.ag.m1283e(view) == 0) {
            width = context.getResources().getDisplayMetrics().widthPixels - width;
        }
        Toast makeText = Toast.makeText(context, this.f1047a.getTitle(), 0);
        if (i < rect.height()) {
            makeText.setGravity(8388661, width, (iArr[1] + height) - rect.top);
        } else {
            makeText.setGravity(81, 0, height);
        }
        makeText.show();
        return true;
    }

    protected void onMeasure(int i, int i2) {
        boolean b = m2386b();
        if (b && this.f1056j >= 0) {
            super.setPadding(this.f1056j, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        size = mode == Integer.MIN_VALUE ? Math.min(size, this.f1055i) : this.f1055i;
        if (mode != 1073741824 && this.f1055i > 0 && measuredWidth < size) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
        }
        if (!b && this.f1049c != null) {
            super.setPadding((getMeasuredWidth() - this.f1049c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }
}
