package in.juspay.widget.qrscanner.com.google.zxing.common;

import java.util.Arrays;

public final class C1267a implements Cloneable {
    private int[] f2798a;
    private int f2799b;

    public /* synthetic */ Object clone() {
        return m4860c();
    }

    public C1267a() {
        this.f2799b = 0;
        this.f2798a = new int[1];
    }

    C1267a(int[] iArr, int i) {
        this.f2798a = iArr;
        this.f2799b = i;
    }

    public int m4852a() {
        return this.f2799b;
    }

    public int m4858b() {
        return (this.f2799b + 7) / 8;
    }

    private void m4850b(int i) {
        if (i > this.f2798a.length * 32) {
            Object c = C1267a.m4851c(i);
            System.arraycopy(this.f2798a, 0, c, 0, this.f2798a.length);
            this.f2798a = c;
        }
    }

    public boolean m4857a(int i) {
        return (this.f2798a[i / 32] & (1 << (i & 31))) != 0;
    }

    public void m4856a(boolean z) {
        m4850b(this.f2799b + 1);
        if (z) {
            int[] iArr = this.f2798a;
            int i = this.f2799b / 32;
            iArr[i] = iArr[i] | (1 << (this.f2799b & 31));
        }
        this.f2799b++;
    }

    public void m4853a(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        m4850b(this.f2799b + i2);
        while (i2 > 0) {
            m4856a(((i >> (i2 + -1)) & 1) == 1);
            i2--;
        }
    }

    public void m4855a(C1267a c1267a) {
        int i = c1267a.f2799b;
        m4850b(this.f2799b + i);
        for (int i2 = 0; i2 < i; i2++) {
            m4856a(c1267a.m4857a(i2));
        }
    }

    public void m4859b(C1267a c1267a) {
        if (this.f2799b != c1267a.f2799b) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        for (int i = 0; i < this.f2798a.length; i++) {
            int[] iArr = this.f2798a;
            iArr[i] = iArr[i] ^ c1267a.f2798a[i];
        }
    }

    public void m4854a(int i, byte[] bArr, int i2, int i3) {
        int i4 = 0;
        int i5 = i;
        while (i4 < i3) {
            int i6 = i5;
            i5 = 0;
            for (int i7 = 0; i7 < 8; i7++) {
                if (m4857a(i6)) {
                    i5 |= 1 << (7 - i7);
                }
                i6++;
            }
            bArr[i2 + i4] = (byte) i5;
            i4++;
            i5 = i6;
        }
    }

    private static int[] m4851c(int i) {
        return new int[((i + 31) / 32)];
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1267a)) {
            return false;
        }
        C1267a c1267a = (C1267a) obj;
        if (this.f2799b == c1267a.f2799b && Arrays.equals(this.f2798a, c1267a.f2798a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f2799b * 31) + Arrays.hashCode(this.f2798a);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.f2799b);
        for (int i = 0; i < this.f2799b; i++) {
            if ((i & 7) == 0) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(m4857a(i) ? 'X' : '.');
        }
        return stringBuilder.toString();
    }

    public C1267a m4860c() {
        return new C1267a((int[]) this.f2798a.clone(), this.f2799b);
    }
}
