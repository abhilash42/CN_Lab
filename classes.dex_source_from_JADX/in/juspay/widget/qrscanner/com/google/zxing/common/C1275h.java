package in.juspay.widget.qrscanner.com.google.zxing.common;

import in.juspay.widget.qrscanner.com.google.zxing.C1264b;
import in.juspay.widget.qrscanner.com.google.zxing.C1285f;
import in.juspay.widget.qrscanner.com.google.zxing.NotFoundException;

public class C1275h extends C1264b {
    private static final byte[] f2850a = new byte[0];
    private byte[] f2851b = f2850a;
    private final int[] f2852c = new int[32];

    public C1275h(C1285f c1285f) {
        super(c1285f);
    }

    public C1268b mo766b() {
        int i;
        C1285f a = m4844a();
        int b = a.m4935b();
        int c = a.m4936c();
        C1268b c1268b = new C1268b(b, c);
        m4893a(b);
        int[] iArr = this.f2852c;
        for (i = 1; i < 5; i++) {
            int i2;
            byte[] a2 = a.mo768a((c * i) / 5, this.f2851b);
            int i3 = (b * 4) / 5;
            for (i2 = b / 5; i2 < i3; i2++) {
                int i4 = (a2[i2] & 255) >> 3;
                iArr[i4] = iArr[i4] + 1;
            }
        }
        int a3 = C1275h.m4892a(iArr);
        byte[] a4 = a.mo767a();
        for (i = 0; i < c; i++) {
            int i5 = i * b;
            for (i2 = 0; i2 < b; i2++) {
                if ((a4[i5 + i2] & 255) < a3) {
                    c1268b.m4866b(i2, i);
                }
            }
        }
        return c1268b;
    }

    private void m4893a(int i) {
        if (this.f2851b.length < i) {
            this.f2851b = new byte[i];
        }
        for (int i2 = 0; i2 < 32; i2++) {
            this.f2852c[i2] = 0;
        }
    }

    private static int m4892a(int[] iArr) {
        int i;
        int i2 = 0;
        int length = iArr.length;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (i = 0; i < length; i++) {
            if (iArr[i] > i3) {
                i3 = iArr[i];
                i4 = i;
            }
            if (iArr[i] > i5) {
                i5 = iArr[i];
            }
        }
        i = 0;
        int i6 = 0;
        while (i2 < length) {
            i3 = i2 - i4;
            i3 *= iArr[i2] * i3;
            if (i3 > i) {
                i = i2;
            } else {
                i3 = i;
                i = i6;
            }
            i2++;
            i6 = i;
            i = i3;
        }
        if (i4 <= i6) {
            int i7 = i6;
            i6 = i4;
            i4 = i7;
        }
        if (i4 - i6 <= length / 16) {
            throw NotFoundException.m4639a();
        }
        length = i4 - 1;
        i = -1;
        i2 = i4 - 1;
        while (i2 > i6) {
            i3 = i2 - i6;
            i3 = ((i3 * i3) * (i4 - i2)) * (i5 - iArr[i2]);
            if (i3 > i) {
                i = i2;
            } else {
                i3 = i;
                i = length;
            }
            i2--;
            length = i;
            i = i3;
        }
        return length << 3;
    }
}
