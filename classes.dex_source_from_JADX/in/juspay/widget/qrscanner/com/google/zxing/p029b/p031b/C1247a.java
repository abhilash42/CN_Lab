package in.juspay.widget.qrscanner.com.google.zxing.p029b.p031b;

import in.juspay.widget.qrscanner.com.google.zxing.C1246m;

public final class C1247a extends C1246m {
    private final float f2755a;

    C1247a(float f, float f2, float f3) {
        super(f, f2);
        this.f2755a = f3;
    }

    boolean m4740a(float f, float f2, float f3) {
        if (Math.abs(f2 - m4739b()) > f || Math.abs(f3 - m4738a()) > f) {
            return false;
        }
        float abs = Math.abs(f - this.f2755a);
        if (abs <= 1.0f || abs <= this.f2755a) {
            return true;
        }
        return false;
    }

    C1247a m4741b(float f, float f2, float f3) {
        return new C1247a((m4738a() + f2) / 2.0f, (m4739b() + f) / 2.0f, (this.f2755a + f3) / 2.0f);
    }
}
