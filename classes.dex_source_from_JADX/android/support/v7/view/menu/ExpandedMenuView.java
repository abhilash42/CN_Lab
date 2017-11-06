package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.view.menu.C0538f.C0529b;
import android.support.v7.widget.ar;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public final class ExpandedMenuView extends ListView implements C0529b, C0530m, OnItemClickListener {
    private static final int[] f1058a = new int[]{16842964, 16843049};
    private C0538f f1059b;
    private int f1060c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        ar a = ar.m2940a(context, attributeSet, f1058a, i, 0);
        if (a.m2955f(0)) {
            setBackgroundDrawable(a.m2943a(0));
        }
        if (a.m2955f(1)) {
            setDivider(a.m2943a(1));
        }
        a.m2944a();
    }

    public void mo457a(C0538f c0538f) {
        this.f1059b = c0538f;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public boolean mo458a(C0541h c0541h) {
        return this.f1059b.m2472a((MenuItem) c0541h, 0);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        mo458a((C0541h) getAdapter().getItem(i));
    }

    public int getWindowAnimations() {
        return this.f1060c;
    }
}
