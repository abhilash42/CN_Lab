package android.support.v7.p012a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

/* compiled from: AppCompatDelegate */
public abstract class C0453g {
    private static int f803a = -1;
    private static boolean f804b = false;

    public abstract C0432a mo364a();

    public abstract View mo371a(int i);

    public abstract void mo373a(Configuration configuration);

    public abstract void mo374a(Bundle bundle);

    public abstract void mo376a(View view);

    public abstract void mo377a(View view, LayoutParams layoutParams);

    public abstract void mo365a(CharSequence charSequence);

    public abstract MenuInflater mo366b();

    public abstract void mo381b(int i);

    public abstract void mo382b(Bundle bundle);

    public abstract void mo383b(View view, LayoutParams layoutParams);

    public abstract void mo386c();

    public abstract void mo367c(Bundle bundle);

    public abstract boolean mo387c(int i);

    public abstract void mo388d();

    public abstract void mo389e();

    public abstract void mo368f();

    public abstract void mo390g();

    public abstract boolean mo369h();

    public static C0453g m2004a(Activity activity, C0433f c0433f) {
        return C0453g.m2006a(activity, activity.getWindow(), c0433f);
    }

    public static C0453g m2005a(Dialog dialog, C0433f c0433f) {
        return C0453g.m2006a(dialog.getContext(), dialog.getWindow(), c0433f);
    }

    private static C0453g m2006a(Context context, Window window, C0433f c0433f) {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            return new C0463k(context, window, c0433f);
        }
        if (i >= 14) {
            return new C0461j(context, window, c0433f);
        }
        if (i >= 11) {
            return new C0459i(context, window, c0433f);
        }
        return new C0458l(context, window, c0433f);
    }

    C0453g() {
    }

    public static int m2007i() {
        return f803a;
    }

    public static boolean m2008j() {
        return f804b;
    }
}
