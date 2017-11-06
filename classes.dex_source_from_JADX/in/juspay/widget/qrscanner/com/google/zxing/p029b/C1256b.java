package in.juspay.widget.qrscanner.com.google.zxing.p029b;

import in.juspay.widget.qrscanner.com.google.zxing.C1223a;
import in.juspay.widget.qrscanner.com.google.zxing.C1284e;
import in.juspay.widget.qrscanner.com.google.zxing.common.C1268b;
import in.juspay.widget.qrscanner.com.google.zxing.p029b.p030a.C1237f;
import in.juspay.widget.qrscanner.com.google.zxing.p029b.p032c.C1258b;
import in.juspay.widget.qrscanner.com.google.zxing.p029b.p032c.C1260c;
import in.juspay.widget.qrscanner.com.google.zxing.p029b.p032c.C1263f;
import java.util.Map;

public final class C1256b {
    public C1268b m4778a(String str, C1223a c1223a, int i, int i2, Map<C1284e, ?> map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (c1223a != C1223a.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + c1223a);
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
        } else {
            C1237f c1237f;
            int parseInt;
            C1237f c1237f2 = C1237f.L;
            if (map != null) {
                if (map.containsKey(C1284e.ERROR_CORRECTION)) {
                    c1237f2 = C1237f.valueOf(map.get(C1284e.ERROR_CORRECTION).toString());
                }
                if (map.containsKey(C1284e.MARGIN)) {
                    c1237f = c1237f2;
                    parseInt = Integer.parseInt(map.get(C1284e.MARGIN).toString());
                    return C1256b.m4777a(C1260c.m4795a(str, c1237f, (Map) map), i, i2, parseInt);
                }
            }
            c1237f = c1237f2;
            parseInt = 4;
            return C1256b.m4777a(C1260c.m4795a(str, c1237f, (Map) map), i, i2, parseInt);
        }
    }

    private static C1268b m4777a(C1263f c1263f, int i, int i2, int i3) {
        C1258b a = c1263f.m4838a();
        if (a == null) {
            throw new IllegalStateException();
        }
        int b = a.m4786b();
        int a2 = a.m4782a();
        int i4 = (i3 * 2) + b;
        int i5 = (i3 * 2) + a2;
        int max = Math.max(i, i4);
        int max2 = Math.max(i2, i5);
        int min = Math.min(max / i4, max2 / i5);
        i5 = (max - (b * min)) / 2;
        i4 = (max2 - (a2 * min)) / 2;
        C1268b c1268b = new C1268b(max, max2);
        max2 = i4;
        for (int i6 = 0; i6 < a2; i6++) {
            max = 0;
            i4 = i5;
            while (max < b) {
                if (a.m4781a(max, i6) == (byte) 1) {
                    c1268b.m4863a(i4, max2, min, min);
                }
                max++;
                i4 += min;
            }
            max2 += min;
        }
        return c1268b;
    }
}
