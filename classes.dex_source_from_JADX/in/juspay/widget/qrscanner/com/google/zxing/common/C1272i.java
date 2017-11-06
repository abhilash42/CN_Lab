package in.juspay.widget.qrscanner.com.google.zxing.common;

import in.juspay.widget.qrscanner.com.google.zxing.NotFoundException;

public abstract class C1272i {
    private static C1272i f2847a = new C1273f();

    public abstract C1268b mo765a(C1268b c1268b, int i, int i2, C1277k c1277k);

    public static C1272i m4886a() {
        return f2847a;
    }

    protected static void m4887a(C1268b c1268b, float[] fArr) {
        int i;
        int c = c1268b.m4868c();
        int d = c1268b.m4870d();
        Object obj = 1;
        for (i = 0; i < fArr.length && r2 != null; i += 2) {
            int i2 = (int) fArr[i];
            int i3 = (int) fArr[i + 1];
            if (i2 < -1 || i2 > c || i3 < -1 || i3 > d) {
                throw NotFoundException.m4639a();
            }
            if (i2 == -1) {
                fArr[i] = 0.0f;
                obj = 1;
            } else if (i2 == c) {
                fArr[i] = (float) (c - 1);
                i2 = 1;
            } else {
                obj = null;
            }
            if (i3 == -1) {
                fArr[i + 1] = 0.0f;
                obj = 1;
            } else if (i3 == d) {
                fArr[i + 1] = (float) (d - 1);
                i2 = 1;
            }
        }
        Object obj2 = 1;
        for (i2 = fArr.length - 2; i2 >= 0 && r0 != null; i2 -= 2) {
            i = (int) fArr[i2];
            i3 = (int) fArr[i2 + 1];
            if (i < -1 || i > c || i3 < -1 || i3 > d) {
                throw NotFoundException.m4639a();
            }
            if (i == -1) {
                fArr[i2] = 0.0f;
                obj2 = 1;
            } else if (i == c) {
                fArr[i2] = (float) (c - 1);
                i = 1;
            } else {
                obj2 = null;
            }
            if (i3 == -1) {
                fArr[i2 + 1] = 0.0f;
                obj2 = 1;
            } else if (i3 == d) {
                fArr[i2 + 1] = (float) (d - 1);
                i = 1;
            }
        }
    }
}
