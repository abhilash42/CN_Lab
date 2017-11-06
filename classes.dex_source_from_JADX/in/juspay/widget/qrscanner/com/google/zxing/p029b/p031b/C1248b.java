package in.juspay.widget.qrscanner.com.google.zxing.p029b.p031b;

import in.juspay.widget.qrscanner.com.google.zxing.C1246m;
import in.juspay.widget.qrscanner.com.google.zxing.C1291n;
import in.juspay.widget.qrscanner.com.google.zxing.NotFoundException;
import in.juspay.widget.qrscanner.com.google.zxing.common.C1268b;
import java.util.ArrayList;
import java.util.List;

final class C1248b {
    private final C1268b f2756a;
    private final List<C1247a> f2757b = new ArrayList(5);
    private final int f2758c;
    private final int f2759d;
    private final int f2760e;
    private final int f2761f;
    private final float f2762g;
    private final int[] f2763h;
    private final C1291n f2764i;

    C1248b(C1268b c1268b, int i, int i2, int i3, int i4, float f, C1291n c1291n) {
        this.f2756a = c1268b;
        this.f2758c = i;
        this.f2759d = i2;
        this.f2760e = i3;
        this.f2761f = i4;
        this.f2762g = f;
        this.f2763h = new int[3];
        this.f2764i = c1291n;
    }

    C1247a m4746a() {
        int i = this.f2758c;
        int i2 = this.f2761f;
        int i3 = i + this.f2760e;
        int i4 = this.f2759d + (i2 / 2);
        int[] iArr = new int[3];
        for (int i5 = 0; i5 < i2; i5++) {
            int i6;
            C1247a a;
            if ((i5 & 1) == 0) {
                i6 = (i5 + 1) / 2;
            } else {
                i6 = -((i5 + 1) / 2);
            }
            int i7 = i4 + i6;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            i6 = i;
            while (i6 < i3 && !this.f2756a.m4864a(i6, i7)) {
                i6++;
            }
            i6 = 0;
            for (int i8 = i6; i8 < i3; i8++) {
                if (!this.f2756a.m4864a(i8, i7)) {
                    if (i6 == 1) {
                        i6++;
                    }
                    iArr[i6] = iArr[i6] + 1;
                } else if (i6 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i6 == 2) {
                    if (m4745a(iArr)) {
                        a = m4744a(iArr, i7, i8);
                        if (a != null) {
                            return a;
                        }
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i6 = 1;
                } else {
                    i6++;
                    iArr[i6] = iArr[i6] + 1;
                }
            }
            if (m4745a(iArr)) {
                a = m4744a(iArr, i7, i3);
                if (a != null) {
                    return a;
                }
            }
        }
        if (!this.f2757b.isEmpty()) {
            return (C1247a) this.f2757b.get(0);
        }
        throw NotFoundException.m4639a();
    }

    private static float m4743a(int[] iArr, int i) {
        return ((float) (i - iArr[2])) - (((float) iArr[1]) / 2.0f);
    }

    private boolean m4745a(int[] iArr) {
        float f = this.f2762g;
        float f2 = f / 2.0f;
        for (int i = 0; i < 3; i++) {
            if (Math.abs(f - ((float) iArr[i])) >= f2) {
                return false;
            }
        }
        return true;
    }

    private float m4742a(int i, int i2, int i3, int i4) {
        C1268b c1268b = this.f2756a;
        int d = c1268b.m4870d();
        int[] iArr = this.f2763h;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i5 = i;
        while (i5 >= 0 && c1268b.m4864a(i2, i5) && iArr[1] <= i3) {
            iArr[1] = iArr[1] + 1;
            i5--;
        }
        if (i5 < 0 || iArr[1] > i3) {
            return Float.NaN;
        }
        while (i5 >= 0 && !c1268b.m4864a(i2, i5) && iArr[0] <= i3) {
            iArr[0] = iArr[0] + 1;
            i5--;
        }
        if (iArr[0] > i3) {
            return Float.NaN;
        }
        i5 = i + 1;
        while (i5 < d && c1268b.m4864a(i2, i5) && iArr[1] <= i3) {
            iArr[1] = iArr[1] + 1;
            i5++;
        }
        if (i5 == d || iArr[1] > i3) {
            return Float.NaN;
        }
        while (i5 < d && !c1268b.m4864a(i2, i5) && iArr[2] <= i3) {
            iArr[2] = iArr[2] + 1;
            i5++;
        }
        if (iArr[2] > i3 || Math.abs(((iArr[0] + iArr[1]) + iArr[2]) - i4) * 5 >= i4 * 2 || !m4745a(iArr)) {
            return Float.NaN;
        }
        return C1248b.m4743a(iArr, i5);
    }

    private C1247a m4744a(int[] iArr, int i, int i2) {
        int i3 = (iArr[0] + iArr[1]) + iArr[2];
        float a = C1248b.m4743a(iArr, i2);
        float a2 = m4742a(i, (int) a, iArr[1] * 2, i3);
        if (!Float.isNaN(a2)) {
            float f = ((float) ((iArr[0] + iArr[1]) + iArr[2])) / 3.0f;
            for (C1247a c1247a : this.f2757b) {
                if (c1247a.m4740a(f, a2, a)) {
                    return c1247a.m4741b(a2, a, f);
                }
            }
            C1246m c1247a2 = new C1247a(a, a2, f);
            this.f2757b.add(c1247a2);
            if (this.f2764i != null) {
                this.f2764i.mo782a(c1247a2);
            }
        }
        return null;
    }
}
