package in.juspay.widget.qrscanner.com.google.zxing;

public abstract class C1285f {
    private final int f2905a;
    private final int f2906b;

    public abstract byte[] mo767a();

    public abstract byte[] mo768a(int i, byte[] bArr);

    protected C1285f(int i, int i2) {
        this.f2905a = i;
        this.f2906b = i2;
    }

    public final int m4935b() {
        return this.f2905a;
    }

    public final int m4936c() {
        return this.f2906b;
    }

    public final String toString() {
        byte[] bArr = new byte[this.f2905a];
        StringBuilder stringBuilder = new StringBuilder(this.f2906b * (this.f2905a + 1));
        byte[] bArr2 = bArr;
        for (int i = 0; i < this.f2906b; i++) {
            bArr2 = mo768a(i, bArr2);
            for (int i2 = 0; i2 < this.f2905a; i2++) {
                char c;
                int i3 = bArr2[i2] & 255;
                if (i3 < 64) {
                    c = '#';
                } else if (i3 < 128) {
                    c = '+';
                } else if (i3 < 192) {
                    c = '.';
                } else {
                    c = ' ';
                }
                stringBuilder.append(c);
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
