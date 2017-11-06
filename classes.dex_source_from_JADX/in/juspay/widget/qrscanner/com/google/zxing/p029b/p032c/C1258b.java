package in.juspay.widget.qrscanner.com.google.zxing.p029b.p032c;

import java.lang.reflect.Array;

public final class C1258b {
    private final byte[][] f2781a;
    private final int f2782b;
    private final int f2783c;

    public C1258b(int i, int i2) {
        this.f2781a = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{i2, i});
        this.f2782b = i;
        this.f2783c = i2;
    }

    public int m4782a() {
        return this.f2783c;
    }

    public int m4786b() {
        return this.f2782b;
    }

    public byte m4781a(int i, int i2) {
        return this.f2781a[i2][i];
    }

    public byte[][] m4787c() {
        return this.f2781a;
    }

    public void m4784a(int i, int i2, int i3) {
        this.f2781a[i2][i] = (byte) i3;
    }

    public void m4785a(int i, int i2, boolean z) {
        this.f2781a[i2][i] = (byte) (z ? 1 : 0);
    }

    public void m4783a(byte b) {
        for (int i = 0; i < this.f2783c; i++) {
            for (int i2 = 0; i2 < this.f2782b; i2++) {
                this.f2781a[i][i2] = b;
            }
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(((this.f2782b * 2) * this.f2783c) + 2);
        for (int i = 0; i < this.f2783c; i++) {
            for (int i2 = 0; i2 < this.f2782b; i2++) {
                switch (this.f2781a[i][i2]) {
                    case (byte) 0:
                        stringBuilder.append(" 0");
                        break;
                    case (byte) 1:
                        stringBuilder.append(" 1");
                        break;
                    default:
                        stringBuilder.append("  ");
                        break;
                }
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
