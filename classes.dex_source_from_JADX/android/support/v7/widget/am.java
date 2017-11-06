package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.p002b.C0170a;
import android.util.TypedValue;

/* compiled from: ThemeUtils */
class am {
    static final int[] f1543a = new int[]{-16842910};
    static final int[] f1544b = new int[]{16842908};
    static final int[] f1545c = new int[]{16843518};
    static final int[] f1546d = new int[]{16842919};
    static final int[] f1547e = new int[]{16842912};
    static final int[] f1548f = new int[]{16842913};
    static final int[] f1549g = new int[]{-16842919, -16842908};
    static final int[] f1550h = new int[0];
    private static final ThreadLocal<TypedValue> f1551i = new ThreadLocal();
    private static final int[] f1552j = new int[1];

    public static int m2929a(Context context, int i) {
        f1552j[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, f1552j);
        try {
            int color = obtainStyledAttributes.getColor(0, 0);
            return color;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static ColorStateList m2932b(Context context, int i) {
        f1552j[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, f1552j);
        try {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(0);
            return colorStateList;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int m2933c(Context context, int i) {
        ColorStateList b = m2932b(context, i);
        if (b != null && b.isStateful()) {
            return b.getColorForState(f1543a, b.getDefaultColor());
        }
        TypedValue a = m2931a();
        context.getTheme().resolveAttribute(16842803, a, true);
        return m2930a(context, i, a.getFloat());
    }

    private static TypedValue m2931a() {
        TypedValue typedValue = (TypedValue) f1551i.get();
        if (typedValue != null) {
            return typedValue;
        }
        typedValue = new TypedValue();
        f1551i.set(typedValue);
        return typedValue;
    }

    static int m2930a(Context context, int i, float f) {
        int a = m2929a(context, i);
        return C0170a.m712b(a, Math.round(((float) Color.alpha(a)) * f));
    }
}
