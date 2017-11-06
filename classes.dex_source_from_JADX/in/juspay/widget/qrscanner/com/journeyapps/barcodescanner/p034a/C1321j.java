package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.p034a;

import android.graphics.Rect;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.C1346l;

public class C1321j extends C1317l {
    private static final String f3077a = C1321j.class.getSimpleName();

    private static float m5094a(float f) {
        if (f < 1.0f) {
            return 1.0f / f;
        }
        return f;
    }

    protected float mo779a(C1346l c1346l, C1346l c1346l2) {
        if (c1346l.f3130a <= 0 || c1346l.f3131b <= 0) {
            return 0.0f;
        }
        float a = (1.0f / C1321j.m5094a((((float) c1346l.f3130a) * 1.0f) / ((float) c1346l2.f3130a))) / C1321j.m5094a((((float) c1346l.f3131b) * 1.0f) / ((float) c1346l2.f3131b));
        float a2 = C1321j.m5094a(((((float) c1346l.f3130a) * 1.0f) / ((float) c1346l.f3131b)) / ((((float) c1346l2.f3130a) * 1.0f) / ((float) c1346l2.f3131b)));
        return a * (((1.0f / a2) / a2) / a2);
    }

    public Rect mo780b(C1346l c1346l, C1346l c1346l2) {
        return new Rect(0, 0, c1346l2.f3130a, c1346l2.f3131b);
    }
}
