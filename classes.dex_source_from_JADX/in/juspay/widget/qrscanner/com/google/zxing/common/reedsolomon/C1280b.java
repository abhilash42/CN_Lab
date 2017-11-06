package in.juspay.widget.qrscanner.com.google.zxing.common.reedsolomon;

final class C1280b {
    private final C1279a f2880a;
    private final int[] f2881b;

    C1280b(C1279a c1279a, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f2880a = c1279a;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.f2881b = iArr;
            return;
        }
        int i = 1;
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.f2881b = new int[]{0};
            return;
        }
        this.f2881b = new int[(length - i)];
        System.arraycopy(iArr, i, this.f2881b, 0, this.f2881b.length);
    }

    int[] m4920a() {
        return this.f2881b;
    }

    int m4921b() {
        return this.f2881b.length - 1;
    }

    boolean m4925c() {
        return this.f2881b[0] == 0;
    }

    int m4917a(int i) {
        return this.f2881b[(this.f2881b.length - 1) - i];
    }

    int m4922b(int i) {
        int i2 = 0;
        if (i == 0) {
            return m4917a(0);
        }
        int i3;
        if (i == 1) {
            int[] iArr = this.f2881b;
            int length = iArr.length;
            i3 = 0;
            while (i2 < length) {
                int b = C1279a.m4907b(i3, iArr[i2]);
                i2++;
                i3 = b;
            }
            return i3;
        }
        i2 = this.f2881b[0];
        int length2 = this.f2881b.length;
        i3 = i2;
        i2 = 1;
        while (i2 < length2) {
            b = C1279a.m4907b(this.f2880a.m4915c(i, i3), this.f2881b[i2]);
            i2++;
            i3 = b;
        }
        return i3;
    }

    C1280b m4919a(C1280b c1280b) {
        if (!this.f2880a.equals(c1280b.f2880a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (m4925c()) {
            return c1280b;
        } else {
            if (c1280b.m4925c()) {
                return this;
            }
            Object obj = this.f2881b;
            Object obj2 = c1280b.f2881b;
            if (obj.length <= obj2.length) {
                Object obj3 = obj2;
                obj2 = obj;
                obj = obj3;
            }
            Object obj4 = new int[obj.length];
            int length = obj.length - r1.length;
            System.arraycopy(obj, 0, obj4, 0, length);
            for (int i = length; i < obj.length; i++) {
                obj4[i] = C1279a.m4907b(r1[i - length], obj[i]);
            }
            return new C1280b(this.f2880a, obj4);
        }
    }

    C1280b m4923b(C1280b c1280b) {
        if (!this.f2880a.equals(c1280b.f2880a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (m4925c() || c1280b.m4925c()) {
            return this.f2880a.m4909a();
        } else {
            int[] iArr = this.f2881b;
            int length = iArr.length;
            int[] iArr2 = c1280b.f2881b;
            int length2 = iArr2.length;
            int[] iArr3 = new int[((length + length2) - 1)];
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                for (int i3 = 0; i3 < length2; i3++) {
                    iArr3[i + i3] = C1279a.m4907b(iArr3[i + i3], this.f2880a.m4915c(i2, iArr2[i3]));
                }
            }
            return new C1280b(this.f2880a, iArr3);
        }
    }

    C1280b m4924c(int i) {
        if (i == 0) {
            return this.f2880a.m4909a();
        }
        if (i == 1) {
            return this;
        }
        int length = this.f2881b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f2880a.m4915c(this.f2881b[i2], i);
        }
        return new C1280b(this.f2880a, iArr);
    }

    C1280b m4918a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f2880a.m4909a();
        } else {
            int length = this.f2881b.length;
            int[] iArr = new int[(length + i)];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.f2880a.m4915c(this.f2881b[i3], i2);
            }
            return new C1280b(this.f2880a, iArr);
        }
    }

    C1280b[] m4926c(C1280b c1280b) {
        if (!this.f2880a.equals(c1280b.f2880a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (c1280b.m4925c()) {
            throw new IllegalArgumentException("Divide by 0");
        } else {
            C1280b a = this.f2880a.m4909a();
            int c = this.f2880a.m4914c(c1280b.m4917a(c1280b.m4921b()));
            C1280b c1280b2 = a;
            a = this;
            while (a.m4921b() >= c1280b.m4921b() && !a.m4925c()) {
                int b = a.m4921b() - c1280b.m4921b();
                int c2 = this.f2880a.m4915c(a.m4917a(a.m4921b()), c);
                C1280b a2 = c1280b.m4918a(b, c2);
                c1280b2 = c1280b2.m4919a(this.f2880a.m4910a(b, c2));
                a = a.m4919a(a2);
            }
            return new C1280b[]{c1280b2, a};
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(m4921b() * 8);
        for (int b = m4921b(); b >= 0; b--) {
            int a = m4917a(b);
            if (a != 0) {
                if (a < 0) {
                    stringBuilder.append(" - ");
                    a = -a;
                } else if (stringBuilder.length() > 0) {
                    stringBuilder.append(" + ");
                }
                if (b == 0 || a != 1) {
                    a = this.f2880a.m4911b(a);
                    if (a == 0) {
                        stringBuilder.append('1');
                    } else if (a == 1) {
                        stringBuilder.append('a');
                    } else {
                        stringBuilder.append("a^");
                        stringBuilder.append(a);
                    }
                }
                if (b != 0) {
                    if (b == 1) {
                        stringBuilder.append('x');
                    } else {
                        stringBuilder.append("x^");
                        stringBuilder.append(b);
                    }
                }
            }
        }
        return stringBuilder.toString();
    }
}
