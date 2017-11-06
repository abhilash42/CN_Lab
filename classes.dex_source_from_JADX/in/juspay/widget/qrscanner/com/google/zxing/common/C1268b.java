package in.juspay.widget.qrscanner.com.google.zxing.common;

import java.util.Arrays;

public final class C1268b implements Cloneable {
    private final int f2800a;
    private final int f2801b;
    private final int f2802c;
    private final int[] f2803d;

    public /* synthetic */ Object clone() {
        return m4871e();
    }

    public C1268b(int i) {
        this(i, i);
    }

    public C1268b(int i, int i2) {
        if (i < 1 || i2 < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f2800a = i;
        this.f2801b = i2;
        this.f2802c = (i + 31) / 32;
        this.f2803d = new int[(this.f2802c * i2)];
    }

    private C1268b(int i, int i2, int i3, int[] iArr) {
        this.f2800a = i;
        this.f2801b = i2;
        this.f2802c = i3;
        this.f2803d = iArr;
    }

    public boolean m4864a(int i, int i2) {
        return ((this.f2803d[(this.f2802c * i2) + (i / 32)] >>> (i & 31)) & 1) != 0;
    }

    public void m4866b(int i, int i2) {
        int i3 = (this.f2802c * i2) + (i / 32);
        int[] iArr = this.f2803d;
        iArr[i3] = iArr[i3] | (1 << (i & 31));
    }

    public void m4869c(int i, int i2) {
        int i3 = (this.f2802c * i2) + (i / 32);
        int[] iArr = this.f2803d;
        iArr[i3] = iArr[i3] ^ (1 << (i & 31));
    }

    public void m4863a(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        } else if (i4 < 1 || i3 < 1) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        } else {
            int i5 = i + i3;
            int i6 = i2 + i4;
            if (i6 > this.f2801b || i5 > this.f2800a) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i2 < i6) {
                int i7 = i2 * this.f2802c;
                for (int i8 = i; i8 < i5; i8++) {
                    int[] iArr = this.f2803d;
                    int i9 = (i8 / 32) + i7;
                    iArr[i9] = iArr[i9] | (1 << (i8 & 31));
                }
                i2++;
            }
        }
    }

    public int[] m4865a() {
        int i = 0;
        while (i < this.f2803d.length && this.f2803d[i] == 0) {
            i++;
        }
        if (i == this.f2803d.length) {
            return null;
        }
        int i2 = i / this.f2802c;
        int i3 = (i % this.f2802c) * 32;
        int i4 = this.f2803d[i];
        i = 0;
        while ((i4 << (31 - i)) == 0) {
            i++;
        }
        i3 += i;
        return new int[]{i3, i2};
    }

    public int[] m4867b() {
        int length = this.f2803d.length - 1;
        while (length >= 0 && this.f2803d[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i = length / this.f2802c;
        int i2 = (length % this.f2802c) * 32;
        int i3 = this.f2803d[length];
        length = 31;
        while ((i3 >>> length) == 0) {
            length--;
        }
        i2 += length;
        return new int[]{i2, i};
    }

    public int m4868c() {
        return this.f2800a;
    }

    public int m4870d() {
        return this.f2801b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1268b)) {
            return false;
        }
        C1268b c1268b = (C1268b) obj;
        if (this.f2800a == c1268b.f2800a && this.f2801b == c1268b.f2801b && this.f2802c == c1268b.f2802c && Arrays.equals(this.f2803d, c1268b.f2803d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.f2800a * 31) + this.f2800a) * 31) + this.f2801b) * 31) + this.f2802c) * 31) + Arrays.hashCode(this.f2803d);
    }

    public String toString() {
        return m4862a("X ", "  ");
    }

    public String m4862a(String str, String str2) {
        return m4861a(str, str2, "\n");
    }

    private String m4861a(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder(this.f2801b * (this.f2800a + 1));
        for (int i = 0; i < this.f2801b; i++) {
            for (int i2 = 0; i2 < this.f2800a; i2++) {
                String str4;
                if (m4864a(i2, i)) {
                    str4 = str;
                } else {
                    str4 = str2;
                }
                stringBuilder.append(str4);
            }
            stringBuilder.append(str3);
        }
        return stringBuilder.toString();
    }

    public C1268b m4871e() {
        return new C1268b(this.f2800a, this.f2801b, this.f2802c, (int[]) this.f2803d.clone());
    }
}
