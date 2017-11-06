package in.juspay.widget.qrscanner.com.google.zxing.p029b.p030a;

import in.juspay.widget.qrscanner.com.google.zxing.p029b.p030a.C1243j.C1241a;
import in.juspay.widget.qrscanner.com.google.zxing.p029b.p030a.C1243j.C1242b;

final class C1225b {
    private final int f2704a;
    private final byte[] f2705b;

    private C1225b(int i, byte[] bArr) {
        this.f2704a = i;
        this.f2705b = bArr;
    }

    static C1225b[] m4676a(byte[] bArr, C1243j c1243j, C1237f c1237f) {
        if (bArr.length != c1243j.m4724c()) {
            throw new IllegalArgumentException();
        }
        int i;
        C1242b a = c1243j.m4722a(c1237f);
        C1241a[] d = a.m4716d();
        int i2 = 0;
        for (C1241a a2 : d) {
            i2 += a2.m4711a();
        }
        C1225b[] c1225bArr = new C1225b[i2];
        int length = d.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            C1241a c1241a = d[i3];
            i2 = i4;
            i4 = 0;
            while (i4 < c1241a.m4711a()) {
                int b = c1241a.m4712b();
                i = i2 + 1;
                c1225bArr[i2] = new C1225b(b, new byte[(a.m4713a() + b)]);
                i4++;
                i2 = i;
            }
            i3++;
            i4 = i2;
        }
        i = c1225bArr[0].f2705b.length;
        i2 = c1225bArr.length - 1;
        while (i2 >= 0 && c1225bArr[i2].f2705b.length != i) {
            i2--;
        }
        length = i2 + 1;
        i -= a.m4713a();
        int i5 = 0;
        i2 = 0;
        while (i5 < i) {
            i3 = i2;
            i2 = 0;
            while (i2 < i4) {
                int i6 = i3 + 1;
                c1225bArr[i2].f2705b[i5] = bArr[i3];
                i2++;
                i3 = i6;
            }
            i5++;
            i2 = i3;
        }
        i3 = length;
        while (i3 < i4) {
            i6 = i2 + 1;
            c1225bArr[i3].f2705b[i] = bArr[i2];
            i3++;
            i2 = i6;
        }
        int length2 = c1225bArr[0].f2705b.length;
        while (i < length2) {
            i3 = 0;
            i6 = i2;
            while (i3 < i4) {
                i5 = i6 + 1;
                c1225bArr[i3].f2705b[i3 < length ? i : i + 1] = bArr[i6];
                i3++;
                i6 = i5;
            }
            i++;
            i2 = i6;
        }
        return c1225bArr;
    }

    int m4677a() {
        return this.f2704a;
    }

    byte[] m4678b() {
        return this.f2705b;
    }
}
