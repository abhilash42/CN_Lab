package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/* compiled from: TintTypedArray */
public class ar {
    private final Context f1561a;
    private final TypedArray f1562b;

    public static ar m2939a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new ar(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static ar m2940a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new ar(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    private ar(Context context, TypedArray typedArray) {
        this.f1561a = context;
        this.f1562b = typedArray;
    }

    public Drawable m2943a(int i) {
        if (this.f1562b.hasValue(i)) {
            int resourceId = this.f1562b.getResourceId(i, 0);
            if (resourceId != 0) {
                return C0632l.m3110a().m3133a(this.f1561a, resourceId);
            }
        }
        return this.f1562b.getDrawable(i);
    }

    public Drawable m2947b(int i) {
        if (this.f1562b.hasValue(i)) {
            int resourceId = this.f1562b.getResourceId(i, 0);
            if (resourceId != 0) {
                return C0632l.m3110a().m3134a(this.f1561a, resourceId, true);
            }
        }
        return null;
    }

    public CharSequence m2949c(int i) {
        return this.f1562b.getText(i);
    }

    public String m2951d(int i) {
        return this.f1562b.getString(i);
    }

    public boolean m2945a(int i, boolean z) {
        return this.f1562b.getBoolean(i, z);
    }

    public int m2942a(int i, int i2) {
        return this.f1562b.getInt(i, i2);
    }

    public float m2941a(int i, float f) {
        return this.f1562b.getFloat(i, f);
    }

    public int m2946b(int i, int i2) {
        return this.f1562b.getColor(i, i2);
    }

    public int m2948c(int i, int i2) {
        return this.f1562b.getInteger(i, i2);
    }

    public int m2950d(int i, int i2) {
        return this.f1562b.getDimensionPixelOffset(i, i2);
    }

    public int m2952e(int i, int i2) {
        return this.f1562b.getDimensionPixelSize(i, i2);
    }

    public int m2954f(int i, int i2) {
        return this.f1562b.getLayoutDimension(i, i2);
    }

    public int m2956g(int i, int i2) {
        return this.f1562b.getResourceId(i, i2);
    }

    public CharSequence[] m2953e(int i) {
        return this.f1562b.getTextArray(i);
    }

    public boolean m2955f(int i) {
        return this.f1562b.hasValue(i);
    }

    public void m2944a() {
        this.f1562b.recycle();
    }
}
