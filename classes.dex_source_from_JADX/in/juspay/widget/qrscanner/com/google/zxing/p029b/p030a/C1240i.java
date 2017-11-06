package in.juspay.widget.qrscanner.com.google.zxing.p029b.p030a;

import in.juspay.widget.qrscanner.com.google.zxing.C1246m;

public final class C1240i {
    private final boolean f2740a;

    C1240i(boolean z) {
        this.f2740a = z;
    }

    public void m4710a(C1246m[] c1246mArr) {
        if (this.f2740a && c1246mArr != null && c1246mArr.length >= 3) {
            C1246m c1246m = c1246mArr[0];
            c1246mArr[0] = c1246mArr[2];
            c1246mArr[2] = c1246m;
        }
    }
}
