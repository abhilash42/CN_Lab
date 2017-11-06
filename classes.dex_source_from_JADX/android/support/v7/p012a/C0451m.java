package android.support.v7.p012a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.p013b.C0509a.C0498a;
import android.support.v7.view.C0494b;
import android.support.v7.view.C0494b.C0476a;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

/* compiled from: AppCompatDialog */
public class C0451m extends Dialog implements C0433f {
    private C0453g f801a;

    public C0451m(Context context, int i) {
        super(context, C0451m.m1996a(context, i));
        m1997a().mo374a(null);
        m1997a().mo369h();
    }

    protected void onCreate(Bundle bundle) {
        m1997a().mo390g();
        super.onCreate(bundle);
        m1997a().mo374a(bundle);
    }

    public void setContentView(int i) {
        m1997a().mo381b(i);
    }

    public void setContentView(View view) {
        m1997a().mo376a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        m1997a().mo377a(view, layoutParams);
    }

    public View findViewById(int i) {
        return m1997a().mo371a(i);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        m1997a().mo365a(charSequence);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        m1997a().mo365a(getContext().getString(i));
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        m1997a().mo383b(view, layoutParams);
    }

    protected void onStop() {
        super.onStop();
        m1997a().mo386c();
    }

    public boolean m2000a(int i) {
        return m1997a().mo387c(i);
    }

    public void invalidateOptionsMenu() {
        m1997a().mo389e();
    }

    public C0453g m1997a() {
        if (this.f801a == null) {
            this.f801a = C0453g.m2005a((Dialog) this, (C0433f) this);
        }
        return this.f801a;
    }

    private static int m1996a(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0498a.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public void mo344a(C0494b c0494b) {
    }

    public void mo345b(C0494b c0494b) {
    }

    public C0494b mo343a(C0476a c0476a) {
        return null;
    }
}
