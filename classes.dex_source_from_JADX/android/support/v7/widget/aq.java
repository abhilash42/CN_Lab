package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* compiled from: TintResources */
class aq extends ai {
    private final WeakReference<Context> f1560a;

    public aq(Context context, Resources resources) {
        super(resources);
        this.f1560a = new WeakReference(context);
    }

    public Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        Context context = (Context) this.f1560a.get();
        if (!(drawable == null || context == null)) {
            C0632l.m3110a();
            C0632l.m3116a(context, i, drawable);
        }
        return drawable;
    }
}
