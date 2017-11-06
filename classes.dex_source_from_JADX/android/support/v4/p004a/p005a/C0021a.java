package android.support.v4.p004a.p005a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

/* compiled from: ResourcesCompat */
public final class C0021a {
    public static Drawable m74a(Resources resources, int i, Theme theme) {
        if (VERSION.SDK_INT >= 21) {
            return C0022b.m75a(resources, i, theme);
        }
        return resources.getDrawable(i);
    }
}
