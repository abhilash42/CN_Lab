package in.juspay.widget.qrscanner.com.google.zxing.p029b;

import in.juspay.widget.qrscanner.com.google.zxing.C1223a;
import in.juspay.widget.qrscanner.com.google.zxing.C1244j;
import in.juspay.widget.qrscanner.com.google.zxing.C1246m;
import in.juspay.widget.qrscanner.com.google.zxing.C1265c;
import in.juspay.widget.qrscanner.com.google.zxing.C1283d;
import in.juspay.widget.qrscanner.com.google.zxing.C1289k;
import in.juspay.widget.qrscanner.com.google.zxing.C1290l;
import in.juspay.widget.qrscanner.com.google.zxing.NotFoundException;
import in.juspay.widget.qrscanner.com.google.zxing.common.C1268b;
import in.juspay.widget.qrscanner.com.google.zxing.common.C1271e;
import in.juspay.widget.qrscanner.com.google.zxing.common.C1274g;
import in.juspay.widget.qrscanner.com.google.zxing.p029b.p030a.C1236e;
import in.juspay.widget.qrscanner.com.google.zxing.p029b.p030a.C1240i;
import in.juspay.widget.qrscanner.com.google.zxing.p029b.p031b.C1249c;
import java.util.List;
import java.util.Map;

public class C1245a implements C1244j {
    private static final C1246m[] f2751a = new C1246m[0];
    private final C1236e f2752b = new C1236e();

    public C1289k mo762a(C1265c c1265c) {
        return mo763a(c1265c, null);
    }

    public final C1289k mo763a(C1265c c1265c, Map<C1283d, ?> map) {
        C1271e a;
        C1246m[] b;
        if (map == null || !map.containsKey(C1283d.PURE_BARCODE)) {
            C1274g a2 = new C1249c(c1265c.m4846a()).m4756a((Map) map);
            a = this.f2752b.m4699a(a2.m4890a(), (Map) map);
            b = a2.m4891b();
        } else {
            a = this.f2752b.m4699a(C1245a.m4731a(c1265c.m4846a()), (Map) map);
            b = f2751a;
        }
        if (a.m4882e() instanceof C1240i) {
            ((C1240i) a.m4882e()).m4710a(b);
        }
        C1289k c1289k = new C1289k(a.m4879b(), a.m4878a(), b, C1223a.QR_CODE);
        List c = a.m4880c();
        if (c != null) {
            c1289k.m4949a(C1290l.BYTE_SEGMENTS, c);
        }
        String d = a.m4881d();
        if (d != null) {
            c1289k.m4949a(C1290l.ERROR_CORRECTION_LEVEL, d);
        }
        if (a.m4883f()) {
            c1289k.m4949a(C1290l.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(a.m4885h()));
            c1289k.m4949a(C1290l.STRUCTURED_APPEND_PARITY, Integer.valueOf(a.m4884g()));
        }
        return c1289k;
    }

    public void mo764a() {
    }

    private static C1268b m4731a(C1268b c1268b) {
        int[] a = c1268b.m4865a();
        int[] b = c1268b.m4867b();
        if (a == null || b == null) {
            throw NotFoundException.m4639a();
        }
        float a2 = C1245a.m4730a(a, c1268b);
        int i = a[1];
        int i2 = b[1];
        int i3 = a[0];
        int i4 = b[0];
        if (i3 >= i4 || i >= i2) {
            throw NotFoundException.m4639a();
        }
        if (i2 - i != i4 - i3) {
            i4 = (i2 - i) + i3;
            if (i4 >= c1268b.m4868c()) {
                throw NotFoundException.m4639a();
            }
        }
        int round = Math.round(((float) ((i4 - i3) + 1)) / a2);
        int round2 = Math.round(((float) ((i2 - i) + 1)) / a2);
        if (round <= 0 || round2 <= 0) {
            throw NotFoundException.m4639a();
        } else if (round2 != round) {
            throw NotFoundException.m4639a();
        } else {
            int i5 = (int) (a2 / 2.0f);
            int i6 = i + i5;
            i = i3 + i5;
            i4 = (((int) (((float) (round - 1)) * a2)) + i) - i4;
            if (i4 <= 0) {
                i3 = i;
            } else if (i4 > i5) {
                throw NotFoundException.m4639a();
            } else {
                i3 = i - i4;
            }
            i4 = (((int) (((float) (round2 - 1)) * a2)) + i6) - i2;
            if (i4 <= 0) {
                i4 = i6;
            } else if (i4 > i5) {
                throw NotFoundException.m4639a();
            } else {
                i4 = i6 - i4;
            }
            C1268b c1268b2 = new C1268b(round, round2);
            for (i = 0; i < round2; i++) {
                i5 = i4 + ((int) (((float) i) * a2));
                for (i6 = 0; i6 < round; i6++) {
                    if (c1268b.m4864a(((int) (((float) i6) * a2)) + i3, i5)) {
                        c1268b2.m4866b(i6, i);
                    }
                }
            }
            return c1268b2;
        }
    }

    private static float m4730a(int[] iArr, C1268b c1268b) {
        int d = c1268b.m4870d();
        int c = c1268b.m4868c();
        int i = iArr[0];
        boolean z = true;
        int i2 = iArr[1];
        int i3 = i;
        int i4 = 0;
        while (i3 < c && i2 < d) {
            boolean z2;
            if (z != c1268b.m4864a(i3, i2)) {
                i = i4 + 1;
                if (i == 5) {
                    break;
                }
                boolean z3;
                if (z) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                int i5 = i;
                z2 = z3;
                i4 = i5;
            } else {
                z2 = z;
            }
            i3++;
            i2++;
            z = z2;
        }
        if (i3 != c && i2 != d) {
            return ((float) (i3 - iArr[0])) / 7.0f;
        }
        throw NotFoundException.m4639a();
    }
}
