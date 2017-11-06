package in.juspay.widget.qrscanner.com.google.zxing.p029b.p030a;

import in.juspay.widget.qrscanner.com.google.zxing.FormatException;
import in.juspay.widget.qrscanner.com.google.zxing.common.C1268b;

final class C1224a {
    private final C1268b f2700a;
    private C1243j f2701b;
    private C1238g f2702c;
    private boolean f2703d;

    C1224a(C1268b c1268b) {
        int d = c1268b.m4870d();
        if (d < 21 || (d & 3) != 1) {
            throw FormatException.m4638a();
        }
        this.f2700a = c1268b;
    }

    C1238g m4670a() {
        int i = 0;
        if (this.f2702c != null) {
            return this.f2702c;
        }
        int i2;
        int i3 = 0;
        for (i2 = 0; i2 < 6; i2++) {
            i3 = m4669a(i2, 8, i3);
        }
        i3 = m4669a(8, 7, m4669a(8, 8, m4669a(7, 8, i3)));
        for (i2 = 5; i2 >= 0; i2--) {
            i3 = m4669a(8, i2, i3);
        }
        int d = this.f2700a.m4870d();
        int i4 = d - 7;
        for (i2 = d - 1; i2 >= i4; i2--) {
            i = m4669a(8, i2, i);
        }
        for (i2 = d - 8; i2 < d; i2++) {
            i = m4669a(i2, 8, i);
        }
        this.f2702c = C1238g.m4703b(i3, i);
        if (this.f2702c != null) {
            return this.f2702c;
        }
        throw FormatException.m4638a();
    }

    C1243j m4672b() {
        if (this.f2701b != null) {
            return this.f2701b;
        }
        int d = this.f2700a.m4870d();
        int i = (d - 17) / 4;
        if (i <= 6) {
            return C1243j.m4718b(i);
        }
        int i2 = d - 11;
        int i3 = 0;
        for (int i4 = 5; i4 >= 0; i4--) {
            for (i = d - 9; i >= i2; i--) {
                i3 = m4669a(i, i4, i3);
            }
        }
        C1243j c = C1243j.m4719c(i3);
        if (c == null || c.m4725d() != d) {
            int i5 = 0;
            for (int i6 = 5; i6 >= 0; i6--) {
                for (i = d - 9; i >= i2; i--) {
                    i5 = m4669a(i6, i, i5);
                }
            }
            c = C1243j.m4719c(i5);
            if (c == null || c.m4725d() != d) {
                throw FormatException.m4638a();
            }
            this.f2701b = c;
            return c;
        }
        this.f2701b = c;
        return c;
    }

    private int m4669a(int i, int i2, int i3) {
        return this.f2703d ? this.f2700a.m4864a(i2, i) : this.f2700a.m4864a(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    byte[] m4673c() {
        C1238g a = m4670a();
        C1243j b = m4672b();
        C1226c c1226c = C1226c.values()[a.m4706b()];
        int d = this.f2700a.m4870d();
        c1226c.m4679a(this.f2700a, d);
        C1268b e = b.m4726e();
        byte[] bArr = new byte[b.m4724c()];
        int i = d - 1;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        while (i > 0) {
            if (i == 6) {
                i--;
            }
            for (int i6 = 0; i6 < d; i6++) {
                int i7;
                if (i5 != 0) {
                    i7 = (d - 1) - i6;
                } else {
                    i7 = i6;
                }
                for (int i8 = 0; i8 < 2; i8++) {
                    if (!e.m4864a(i - i8, i7)) {
                        i2++;
                        i3 <<= 1;
                        if (this.f2700a.m4864a(i - i8, i7)) {
                            i3 |= 1;
                        }
                        if (i2 == 8) {
                            i2 = i4 + 1;
                            bArr[i4] = (byte) i3;
                            i3 = 0;
                            i4 = i2;
                            i2 = 0;
                        }
                    }
                }
            }
            i -= 2;
            i5 ^= 1;
        }
        if (i4 == b.m4724c()) {
            return bArr;
        }
        throw FormatException.m4638a();
    }

    void m4674d() {
        if (this.f2702c != null) {
            C1226c.values()[this.f2702c.m4706b()].m4679a(this.f2700a, this.f2700a.m4870d());
        }
    }

    void m4671a(boolean z) {
        this.f2701b = null;
        this.f2702c = null;
        this.f2703d = z;
    }

    void m4675e() {
        for (int i = 0; i < this.f2700a.m4868c(); i++) {
            for (int i2 = i + 1; i2 < this.f2700a.m4870d(); i2++) {
                if (this.f2700a.m4864a(i, i2) != this.f2700a.m4864a(i2, i)) {
                    this.f2700a.m4869c(i2, i);
                    this.f2700a.m4869c(i, i2);
                }
            }
        }
    }
}
