package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.p034a;

import android.graphics.Rect;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.C1346l;

public class C1318g extends C1317l {
    private static final String f3070a = C1318g.class.getSimpleName();

    protected float mo779a(C1346l c1346l, C1346l c1346l2) {
        if (c1346l.f3130a <= 0 || c1346l.f3131b <= 0) {
            return 0.0f;
        }
        C1346l b = c1346l.m5149b(c1346l2);
        float f = (((float) b.f3130a) * 1.0f) / ((float) c1346l.f3130a);
        if (f > 1.0f) {
            f = (float) Math.pow((double) (1.0f / f), 1.1d);
        }
        float f2 = ((((float) b.f3131b) * 1.0f) / ((float) c1346l2.f3131b)) + ((((float) b.f3130a) * 1.0f) / ((float) c1346l2.f3130a));
        return f * ((1.0f / f2) / f2);
    }

    public Rect mo780b(C1346l c1346l, C1346l c1346l2) {
        C1346l b = c1346l.m5149b(c1346l2);
        int i = (b.f3130a - c1346l2.f3130a) / 2;
        int i2 = (b.f3131b - c1346l2.f3131b) / 2;
        return new Rect(-i, -i2, b.f3130a - i, b.f3131b - i2);
    }
}
