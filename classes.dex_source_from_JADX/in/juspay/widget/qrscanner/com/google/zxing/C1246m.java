package in.juspay.widget.qrscanner.com.google.zxing;

import in.juspay.widget.qrscanner.com.google.zxing.common.p033a.C1266a;

public class C1246m {
    private final float f2753a;
    private final float f2754b;

    public C1246m(float f, float f2) {
        this.f2753a = f;
        this.f2754b = f2;
    }

    public final float m4738a() {
        return this.f2753a;
    }

    public final float m4739b() {
        return this.f2754b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C1246m)) {
            return false;
        }
        C1246m c1246m = (C1246m) obj;
        if (this.f2753a == c1246m.f2753a && this.f2754b == c1246m.f2754b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f2753a) * 31) + Float.floatToIntBits(this.f2754b);
    }

    public final String toString() {
        return "(" + this.f2753a + ',' + this.f2754b + ')';
    }

    public static void m4737a(C1246m[] c1246mArr) {
        C1246m c1246m;
        C1246m c1246m2;
        C1246m c1246m3;
        float a = C1246m.m4735a(c1246mArr[0], c1246mArr[1]);
        float a2 = C1246m.m4735a(c1246mArr[1], c1246mArr[2]);
        float a3 = C1246m.m4735a(c1246mArr[0], c1246mArr[2]);
        if (a2 >= a && a2 >= a3) {
            c1246m = c1246mArr[0];
            c1246m2 = c1246mArr[1];
            c1246m3 = c1246mArr[2];
        } else if (a3 < a2 || a3 < a) {
            c1246m = c1246mArr[2];
            c1246m2 = c1246mArr[0];
            c1246m3 = c1246mArr[1];
        } else {
            c1246m = c1246mArr[1];
            c1246m2 = c1246mArr[0];
            c1246m3 = c1246mArr[2];
        }
        if (C1246m.m4736a(c1246m2, c1246m, c1246m3) >= 0.0f) {
            C1246m c1246m4 = c1246m3;
            c1246m3 = c1246m2;
            c1246m2 = c1246m4;
        }
        c1246mArr[0] = c1246m3;
        c1246mArr[1] = c1246m;
        c1246mArr[2] = c1246m2;
    }

    public static float m4735a(C1246m c1246m, C1246m c1246m2) {
        return C1266a.m4847a(c1246m.f2753a, c1246m.f2754b, c1246m2.f2753a, c1246m2.f2754b);
    }

    private static float m4736a(C1246m c1246m, C1246m c1246m2, C1246m c1246m3) {
        float f = c1246m2.f2753a;
        float f2 = c1246m2.f2754b;
        return ((c1246m3.f2753a - f) * (c1246m.f2754b - f2)) - ((c1246m.f2753a - f) * (c1246m3.f2754b - f2));
    }
}
