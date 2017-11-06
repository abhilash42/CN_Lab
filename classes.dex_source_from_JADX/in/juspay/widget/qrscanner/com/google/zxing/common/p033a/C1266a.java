package in.juspay.widget.qrscanner.com.google.zxing.common.p033a;

public final class C1266a {
    public static int m4849a(float f) {
        return (int) ((f < 0.0f ? -0.5f : 0.5f) + f);
    }

    public static float m4847a(float f, float f2, float f3, float f4) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        return (float) Math.sqrt((double) ((f5 * f5) + (f6 * f6)));
    }

    public static float m4848a(int i, int i2, int i3, int i4) {
        int i5 = i - i3;
        int i6 = i2 - i4;
        return (float) Math.sqrt((double) ((i5 * i5) + (i6 * i6)));
    }
}
