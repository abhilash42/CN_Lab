package in.juspay.widget.qrscanner.com.google.zxing.p029b.p031b;

import in.juspay.widget.qrscanner.com.google.zxing.C1246m;
import in.juspay.widget.qrscanner.com.google.zxing.C1283d;
import in.juspay.widget.qrscanner.com.google.zxing.C1291n;
import in.juspay.widget.qrscanner.com.google.zxing.NotFoundException;
import in.juspay.widget.qrscanner.com.google.zxing.common.C1268b;
import in.juspay.widget.qrscanner.com.google.zxing.common.C1272i;
import in.juspay.widget.qrscanner.com.google.zxing.common.C1274g;
import in.juspay.widget.qrscanner.com.google.zxing.common.C1277k;
import in.juspay.widget.qrscanner.com.google.zxing.common.p033a.C1266a;
import in.juspay.widget.qrscanner.com.google.zxing.p029b.p030a.C1243j;
import java.util.Map;

public class C1249c {
    private final C1268b f2765a;
    private C1291n f2766b;

    public C1249c(C1268b c1268b) {
        this.f2765a = c1268b;
    }

    public final C1274g m4756a(Map<C1283d, ?> map) {
        C1291n c1291n;
        if (map == null) {
            c1291n = null;
        } else {
            c1291n = (C1291n) map.get(C1283d.NEED_RESULT_POINT_CALLBACK);
        }
        this.f2766b = c1291n;
        return m4755a(new C1254e(this.f2765a, this.f2766b).m4772a((Map) map));
    }

    protected final C1274g m4755a(C1255f c1255f) {
        C1246m b = c1255f.m4775b();
        C1246m c = c1255f.m4776c();
        C1246m a = c1255f.m4774a();
        float a2 = m4753a(b, c, a);
        if (a2 < 1.0f) {
            throw NotFoundException.m4639a();
        }
        C1246m[] c1246mArr;
        int a3 = C1249c.m4749a(b, c, a, a2);
        C1243j a4 = C1243j.m4717a(a3);
        int d = a4.m4725d() - 7;
        C1246m c1246m = null;
        if (a4.m4723b().length > 0) {
            float a5 = (c.m4738a() - b.m4738a()) + a.m4738a();
            float b2 = (c.m4739b() - b.m4739b()) + a.m4739b();
            float f = 1.0f - (3.0f / ((float) d));
            int a6 = (int) (((a5 - b.m4738a()) * f) + b.m4738a());
            d = (int) (b.m4739b() + (f * (b2 - b.m4739b())));
            int i = 4;
            while (i <= 16) {
                try {
                    c1246m = m4754a(a2, a6, d, (float) i);
                    break;
                } catch (NotFoundException e) {
                    i <<= 1;
                }
            }
        }
        C1268b a7 = C1249c.m4750a(this.f2765a, C1249c.m4751a(b, c, a, c1246m, a3), a3);
        if (c1246m == null) {
            c1246mArr = new C1246m[]{a, b, c};
        } else {
            c1246mArr = new C1246m[]{a, b, c, c1246m};
        }
        return new C1274g(a7, c1246mArr);
    }

    private static C1277k m4751a(C1246m c1246m, C1246m c1246m2, C1246m c1246m3, C1246m c1246m4, int i) {
        float a;
        float b;
        float f;
        float f2;
        float f3 = ((float) i) - 3.5f;
        if (c1246m4 != null) {
            a = c1246m4.m4738a();
            b = c1246m4.m4739b();
            f = f3 - 3.0f;
            f2 = f;
        } else {
            a = (c1246m2.m4738a() - c1246m.m4738a()) + c1246m3.m4738a();
            b = (c1246m2.m4739b() - c1246m.m4739b()) + c1246m3.m4739b();
            f = f3;
            f2 = f3;
        }
        return C1277k.m4901a(3.5f, 3.5f, f3, 3.5f, f2, f, 3.5f, f3, c1246m.m4738a(), c1246m.m4739b(), c1246m2.m4738a(), c1246m2.m4739b(), a, b, c1246m3.m4738a(), c1246m3.m4739b());
    }

    private static C1268b m4750a(C1268b c1268b, C1277k c1277k, int i) {
        return C1272i.m4886a().mo765a(c1268b, i, i, c1277k);
    }

    private static int m4749a(C1246m c1246m, C1246m c1246m2, C1246m c1246m3, float f) {
        int a = ((C1266a.m4849a(C1246m.m4735a(c1246m, c1246m2) / f) + C1266a.m4849a(C1246m.m4735a(c1246m, c1246m3) / f)) / 2) + 7;
        switch (a & 3) {
            case 0:
                return a + 1;
            case 2:
                return a - 1;
            case 3:
                throw NotFoundException.m4639a();
            default:
                return a;
        }
    }

    protected final float m4753a(C1246m c1246m, C1246m c1246m2, C1246m c1246m3) {
        return (m4748a(c1246m, c1246m2) + m4748a(c1246m, c1246m3)) / 2.0f;
    }

    private float m4748a(C1246m c1246m, C1246m c1246m2) {
        float a = m4747a((int) c1246m.m4738a(), (int) c1246m.m4739b(), (int) c1246m2.m4738a(), (int) c1246m2.m4739b());
        float a2 = m4747a((int) c1246m2.m4738a(), (int) c1246m2.m4739b(), (int) c1246m.m4738a(), (int) c1246m.m4739b());
        if (Float.isNaN(a)) {
            return a2 / 7.0f;
        }
        if (Float.isNaN(a2)) {
            return a / 7.0f;
        }
        return (a + a2) / 14.0f;
    }

    private float m4747a(int i, int i2, int i3, int i4) {
        float f;
        int i5;
        int i6 = 0;
        float b = m4752b(i, i2, i3, i4);
        int i7 = i - (i3 - i);
        if (i7 < 0) {
            f = ((float) i) / ((float) (i - i7));
            i5 = 0;
        } else if (i7 >= this.f2765a.m4868c()) {
            f = ((float) ((this.f2765a.m4868c() - 1) - i)) / ((float) (i7 - i));
            i5 = this.f2765a.m4868c() - 1;
        } else {
            i5 = i7;
            f = 1.0f;
        }
        i7 = (int) (((float) i2) - (f * ((float) (i4 - i2))));
        if (i7 < 0) {
            f = ((float) i2) / ((float) (i2 - i7));
        } else if (i7 >= this.f2765a.m4870d()) {
            f = ((float) ((this.f2765a.m4870d() - 1) - i2)) / ((float) (i7 - i2));
            i6 = this.f2765a.m4870d() - 1;
        } else {
            i6 = i7;
            f = 1.0f;
        }
        return (m4752b(i, i2, (int) ((f * ((float) (i5 - i))) + ((float) i)), i6) + b) - 1.0f;
    }

    private float m4752b(int i, int i2, int i3, int i4) {
        Object obj;
        if (Math.abs(i4 - i2) > Math.abs(i3 - i)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            int i5 = i4;
            i4 = i3;
            i3 = i5;
            int i6 = i2;
            i2 = i;
            i = i6;
        }
        int abs = Math.abs(i4 - i2);
        int abs2 = Math.abs(i3 - i);
        int i7 = (-abs) / 2;
        int i8 = i2 < i4 ? 1 : -1;
        int i9 = i < i3 ? 1 : -1;
        int i10 = 0;
        int i11 = i4 + i8;
        int i12 = i2;
        int i13 = i7;
        i7 = i;
        while (i12 != i11) {
            int i14;
            int i15;
            int i16;
            if (obj != null) {
                i14 = i7;
            } else {
                i14 = i12;
            }
            if (obj != null) {
                i15 = i12;
            } else {
                i15 = i7;
            }
            if ((i10 == 1) != this.f2765a.m4864a(i14, i15)) {
                i15 = i10;
            } else if (i10 == 2) {
                return C1266a.m4848a(i12, i7, i2, i);
            } else {
                i15 = i10 + 1;
            }
            i10 = i13 + abs2;
            if (i10 <= 0) {
                i16 = i7;
                i7 = i10;
            } else if (i7 == i3) {
                i9 = i15;
                break;
            } else {
                i16 = i7 + i9;
                i7 = i10 - abs;
            }
            i12 += i8;
            i10 = i15;
            i13 = i7;
            i7 = i16;
        }
        i9 = i10;
        if (i9 == 2) {
            return C1266a.m4848a(i4 + i8, i3, i2, i);
        }
        return Float.NaN;
    }

    protected final C1247a m4754a(float f, int i, int i2, float f2) {
        int i3 = (int) (f2 * f);
        int max = Math.max(0, i - i3);
        int min = Math.min(this.f2765a.m4868c() - 1, i + i3);
        if (((float) (min - max)) < f * 3.0f) {
            throw NotFoundException.m4639a();
        }
        int max2 = Math.max(0, i2 - i3);
        int min2 = Math.min(this.f2765a.m4870d() - 1, i3 + i2);
        if (((float) (min2 - max2)) < f * 3.0f) {
            throw NotFoundException.m4639a();
        }
        return new C1248b(this.f2765a, max, max2, min - max, min2 - max2, f, this.f2766b).m4746a();
    }
}
