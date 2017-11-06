package in.juspay.widget.qrscanner.com.google.zxing.common.reedsolomon;

public final class C1281c {
    private final C1279a f2882a;

    public C1281c(C1279a c1279a) {
        this.f2882a = c1279a;
    }

    public void m4930a(int[] iArr, int i) {
        int i2 = 0;
        C1280b c1280b = new C1280b(this.f2882a, iArr);
        int[] iArr2 = new int[i];
        int i3 = 1;
        for (int i4 = 0; i4 < i; i4++) {
            int b = c1280b.m4922b(this.f2882a.m4908a(this.f2882a.m4916d() + i4));
            iArr2[(iArr2.length - 1) - i4] = b;
            if (b != 0) {
                i3 = 0;
            }
        }
        if (i3 == 0) {
            C1280b[] a = m4929a(this.f2882a.m4910a(i, 1), new C1280b(this.f2882a, iArr2), i);
            C1280b c1280b2 = a[0];
            C1280b c1280b3 = a[1];
            int[] a2 = m4927a(c1280b2);
            int[] a3 = m4928a(c1280b3, a2);
            while (i2 < a2.length) {
                int length = (iArr.length - 1) - this.f2882a.m4911b(a2[i2]);
                if (length < 0) {
                    throw new ReedSolomonException("Bad error location");
                }
                iArr[length] = C1279a.m4907b(iArr[length], a3[i2]);
                i2++;
            }
        }
    }

    private C1280b[] m4929a(C1280b c1280b, C1280b c1280b2, int i) {
        if (c1280b.m4921b() >= c1280b2.m4921b()) {
            C1280b c1280b3 = c1280b2;
            c1280b2 = c1280b;
            c1280b = c1280b3;
        }
        C1280b a = this.f2882a.m4909a();
        C1280b b = this.f2882a.m4912b();
        while (c1280b.m4921b() >= i / 2) {
            if (c1280b.m4925c()) {
                throw new ReedSolomonException("r_{i-1} was zero");
            }
            C1280b a2 = this.f2882a.m4909a();
            int c = this.f2882a.m4914c(c1280b.m4917a(c1280b.m4921b()));
            C1280b c1280b4 = a2;
            a2 = c1280b2;
            while (a2.m4921b() >= c1280b.m4921b() && !a2.m4925c()) {
                int b2 = a2.m4921b() - c1280b.m4921b();
                int c2 = this.f2882a.m4915c(a2.m4917a(a2.m4921b()), c);
                c1280b4 = c1280b4.m4919a(this.f2882a.m4910a(b2, c2));
                a2 = a2.m4919a(c1280b.m4918a(b2, c2));
            }
            a = c1280b4.m4923b(b).m4919a(a);
            if (a2.m4921b() >= c1280b.m4921b()) {
                throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
            }
            c1280b2 = c1280b;
            c1280b = a2;
            c1280b3 = b;
            b = a;
            a = c1280b3;
        }
        int a3 = b.m4917a(0);
        if (a3 == 0) {
            throw new ReedSolomonException("sigmaTilde(0) was zero");
        }
        a3 = this.f2882a.m4914c(a3);
        b = b.m4924c(a3);
        a = c1280b.m4924c(a3);
        return new C1280b[]{b, a};
    }

    private int[] m4927a(C1280b c1280b) {
        int i = 0;
        int i2 = 1;
        int b = c1280b.m4921b();
        if (b == 1) {
            return new int[]{c1280b.m4917a(1)};
        }
        int[] iArr = new int[b];
        while (i2 < this.f2882a.m4913c() && i < b) {
            if (c1280b.m4922b(i2) == 0) {
                iArr[i] = this.f2882a.m4914c(i2);
                i++;
            }
            i2++;
        }
        if (i == b) {
            return iArr;
        }
        throw new ReedSolomonException("Error locator degree does not match number of roots");
    }

    private int[] m4928a(C1280b c1280b, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            int c = this.f2882a.m4914c(iArr[i]);
            int i2 = 1;
            int i3 = 0;
            while (i3 < length) {
                int c2;
                if (i != i3) {
                    c2 = this.f2882a.m4915c(iArr[i3], c);
                    c2 = this.f2882a.m4915c(i2, (c2 & 1) == 0 ? c2 | 1 : c2 & -2);
                } else {
                    c2 = i2;
                }
                i3++;
                i2 = c2;
            }
            iArr2[i] = this.f2882a.m4915c(c1280b.m4922b(c), this.f2882a.m4914c(i2));
            if (this.f2882a.m4916d() != 0) {
                iArr2[i] = this.f2882a.m4915c(iArr2[i], c);
            }
        }
        return iArr2;
    }
}
