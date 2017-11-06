package in.juspay.widget.qrscanner.com.google.zxing.common;

public final class C1269c {
    private final byte[] f2804a;
    private int f2805b;
    private int f2806c;

    public C1269c(byte[] bArr) {
        this.f2804a = bArr;
    }

    public int m4873a(int i) {
        if (i < 1 || i > 32 || i > m4872a()) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        int i2;
        int i3;
        if (this.f2806c > 0) {
            i2 = 8 - this.f2806c;
            i3 = i < i2 ? i : i2;
            i2 -= i3;
            i2 = (((255 >> (8 - i3)) << i2) & this.f2804a[this.f2805b]) >> i2;
            i -= i3;
            this.f2806c = i3 + this.f2806c;
            if (this.f2806c == 8) {
                this.f2806c = 0;
                this.f2805b++;
            }
            i3 = i2;
            i2 = i;
        } else {
            i3 = 0;
            i2 = i;
        }
        if (i2 <= 0) {
            return i3;
        }
        while (i2 >= 8) {
            i3 = (i3 << 8) | (this.f2804a[this.f2805b] & 255);
            this.f2805b++;
            i2 -= 8;
        }
        if (i2 <= 0) {
            return i3;
        }
        int i4 = 8 - i2;
        i3 = (i3 << i2) | ((((255 >> i4) << i4) & this.f2804a[this.f2805b]) >> i4);
        this.f2806c = i2 + this.f2806c;
        return i3;
    }

    public int m4872a() {
        return ((this.f2804a.length - this.f2805b) * 8) - this.f2806c;
    }
}
