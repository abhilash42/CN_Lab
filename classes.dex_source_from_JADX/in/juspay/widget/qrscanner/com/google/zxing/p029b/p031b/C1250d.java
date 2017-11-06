package in.juspay.widget.qrscanner.com.google.zxing.p029b.p031b;

import in.juspay.widget.qrscanner.com.google.zxing.C1246m;

public final class C1250d extends C1246m {
    private final float f2767a;
    private final int f2768b;

    C1250d(float f, float f2, float f3) {
        this(f, f2, f3, 1);
    }

    private C1250d(float f, float f2, float f3, int i) {
        super(f, f2);
        this.f2767a = f3;
        this.f2768b = i;
    }

    public float m4759c() {
        return this.f2767a;
    }

    int m4760d() {
        return this.f2768b;
    }

    boolean m4757a(float f, float f2, float f3) {
        if (Math.abs(f2 - m4739b()) > f || Math.abs(f3 - m4738a()) > f) {
            return false;
        }
        float abs = Math.abs(f - this.f2767a);
        if (abs <= 1.0f || abs <= this.f2767a) {
            return true;
        }
        return false;
    }

    C1250d m4758b(float f, float f2, float f3) {
        int i = this.f2768b + 1;
        return new C1250d(((((float) this.f2768b) * m4738a()) + f2) / ((float) i), ((((float) this.f2768b) * m4739b()) + f) / ((float) i), ((((float) this.f2768b) * this.f2767a) + f3) / ((float) i), i);
    }
}
