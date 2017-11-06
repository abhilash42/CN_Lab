package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.p012a.C0453g;
import java.lang.ref.WeakReference;

/* compiled from: VectorEnabledTintResources */
public class at extends Resources {
    private final WeakReference<Context> f1586a;

    public static boolean m3008a() {
        return C0453g.m2008j() && VERSION.SDK_INT <= 20;
    }

    public at(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f1586a = new WeakReference(context);
    }

    public Drawable getDrawable(int i) {
        Context context = (Context) this.f1586a.get();
        if (context != null) {
            return C0632l.m3110a().m3135a(context, this, i);
        }
        return super.getDrawable(i);
    }

    final Drawable m3009a(int i) {
        return super.getDrawable(i);
    }
}
