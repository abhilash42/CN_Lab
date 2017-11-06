package in.org.npci.upiapp.utils;

import android.content.Context;

/* compiled from: PixelUtil */
public class C1443f {
    public static int m5486a(Context context, int i) {
        return Math.round(((float) i) * C1443f.m5485a(context));
    }

    private static float m5485a(Context context) {
        return context.getResources().getDisplayMetrics().xdpi / 160.0f;
    }
}
