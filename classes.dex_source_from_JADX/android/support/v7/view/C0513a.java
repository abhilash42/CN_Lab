package android.support.v7.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.ar;
import android.support.v7.p013b.C0509a.C0498a;
import android.support.v7.p013b.C0509a.C0499b;
import android.support.v7.p013b.C0509a.C0501d;
import android.support.v7.p013b.C0509a.C0504g;
import android.support.v7.p013b.C0509a.C0508k;
import android.view.ViewConfiguration;

/* compiled from: ActionBarPolicy */
public class C0513a {
    private Context f972a;

    public static C0513a m2293a(Context context) {
        return new C0513a(context);
    }

    private C0513a(Context context) {
        this.f972a = context;
    }

    public int m2294a() {
        return this.f972a.getResources().getInteger(C0504g.abc_max_action_buttons);
    }

    public boolean m2295b() {
        if (VERSION.SDK_INT < 19 && ar.m1362b(ViewConfiguration.get(this.f972a))) {
            return false;
        }
        return true;
    }

    public int m2296c() {
        return this.f972a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean m2297d() {
        if (this.f972a.getApplicationInfo().targetSdkVersion >= 16) {
            return this.f972a.getResources().getBoolean(C0499b.abc_action_bar_embed_tabs);
        }
        return this.f972a.getResources().getBoolean(C0499b.abc_action_bar_embed_tabs_pre_jb);
    }

    public int m2298e() {
        TypedArray obtainStyledAttributes = this.f972a.obtainStyledAttributes(null, C0508k.ActionBar, C0498a.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(C0508k.ActionBar_height, 0);
        Resources resources = this.f972a.getResources();
        if (!m2297d()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(C0501d.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean m2299f() {
        return this.f972a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int m2300g() {
        return this.f972a.getResources().getDimensionPixelSize(C0501d.abc_action_bar_stacked_tab_max_width);
    }
}
