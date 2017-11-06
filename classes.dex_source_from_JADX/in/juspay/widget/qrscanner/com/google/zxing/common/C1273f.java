package in.juspay.widget.qrscanner.com.google.zxing.common;

import in.juspay.widget.qrscanner.com.google.zxing.NotFoundException;

public final class C1273f extends C1272i {
    public C1268b mo765a(C1268b c1268b, int i, int i2, C1277k c1277k) {
        if (i <= 0 || i2 <= 0) {
            throw NotFoundException.m4639a();
        }
        C1268b c1268b2 = new C1268b(i, i2);
        float[] fArr = new float[(i * 2)];
        for (int i3 = 0; i3 < i2; i3++) {
            int i4;
            int length = fArr.length;
            float f = ((float) i3) + 0.5f;
            for (i4 = 0; i4 < length; i4 += 2) {
                fArr[i4] = ((float) (i4 / 2)) + 0.5f;
                fArr[i4 + 1] = f;
            }
            c1277k.m4905a(fArr);
            C1272i.m4887a(c1268b, fArr);
            i4 = 0;
            while (i4 < length) {
                try {
                    if (c1268b.m4864a((int) fArr[i4], (int) fArr[i4 + 1])) {
                        c1268b2.m4866b(i4 / 2, i3);
                    }
                    i4 += 2;
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw NotFoundException.m4639a();
                }
            }
        }
        return c1268b2;
    }
}
