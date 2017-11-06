package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.v7.p012a.C0453g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: TintContextWrapper */
public class ao extends ContextWrapper {
    private static final ArrayList<WeakReference<ao>> f1553a = new ArrayList();
    private Resources f1554b;
    private final Theme f1555c;

    public static Context m2936a(Context context) {
        if (!m2937b(context)) {
            return context;
        }
        Context context2;
        int size = f1553a.size();
        for (int i = 0; i < size; i++) {
            WeakReference weakReference = (WeakReference) f1553a.get(i);
            context2 = weakReference != null ? (ao) weakReference.get() : null;
            if (context2 != null && context2.getBaseContext() == context) {
                return context2;
            }
        }
        context2 = new ao(context);
        f1553a.add(new WeakReference(context2));
        return context2;
    }

    private static boolean m2937b(Context context) {
        if ((context instanceof ao) || (context.getResources() instanceof aq) || (context.getResources() instanceof at)) {
            return false;
        }
        if (!C0453g.m2008j() || VERSION.SDK_INT <= 20) {
            return true;
        }
        return false;
    }

    private ao(Context context) {
        super(context);
        if (at.m3008a()) {
            this.f1555c = getResources().newTheme();
            this.f1555c.setTo(context.getTheme());
            return;
        }
        this.f1555c = null;
    }

    public Theme getTheme() {
        return this.f1555c == null ? super.getTheme() : this.f1555c;
    }

    public void setTheme(int i) {
        if (this.f1555c == null) {
            super.setTheme(i);
        } else {
            this.f1555c.applyStyle(i, true);
        }
    }

    public Resources getResources() {
        if (this.f1554b == null) {
            this.f1554b = this.f1555c == null ? new aq(this, super.getResources()) : new at(this, super.getResources());
        }
        return this.f1554b;
    }
}
