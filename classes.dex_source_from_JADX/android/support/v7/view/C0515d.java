package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources.Theme;
import android.support.v7.p013b.C0509a.C0507j;
import android.view.LayoutInflater;

/* compiled from: ContextThemeWrapper */
public class C0515d extends ContextWrapper {
    private int f973a;
    private Theme f974b;
    private LayoutInflater f975c;

    public C0515d(Context context, int i) {
        super(context);
        this.f973a = i;
    }

    public C0515d(Context context, Theme theme) {
        super(context);
        this.f974b = theme;
    }

    public void setTheme(int i) {
        if (this.f973a != i) {
            this.f973a = i;
            m2303b();
        }
    }

    public int m2304a() {
        return this.f973a;
    }

    public Theme getTheme() {
        if (this.f974b != null) {
            return this.f974b;
        }
        if (this.f973a == 0) {
            this.f973a = C0507j.Theme_AppCompat_Light;
        }
        m2303b();
        return this.f974b;
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f975c == null) {
            this.f975c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f975c;
    }

    protected void m2305a(Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    private void m2303b() {
        boolean z = this.f974b == null;
        if (z) {
            this.f974b = getResources().newTheme();
            Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f974b.setTo(theme);
            }
        }
        m2305a(this.f974b, this.f973a, z);
    }
}
