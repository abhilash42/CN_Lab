package in.juspay.widget.qrscanner.com.google.zxing.common;

public final class C1277k {
    private final float f2854a;
    private final float f2855b;
    private final float f2856c;
    private final float f2857d;
    private final float f2858e;
    private final float f2859f;
    private final float f2860g;
    private final float f2861h;
    private final float f2862i;

    private C1277k(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.f2854a = f;
        this.f2855b = f4;
        this.f2856c = f7;
        this.f2857d = f2;
        this.f2858e = f5;
        this.f2859f = f8;
        this.f2860g = f3;
        this.f2861h = f6;
        this.f2862i = f9;
    }

    public static C1277k m4901a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        return C1277k.m4900a(f9, f10, f11, f12, f13, f14, f15, f16).m4904a(C1277k.m4902b(f, f2, f3, f4, f5, f6, f7, f8));
    }

    public void m4905a(float[] fArr) {
        int length = fArr.length;
        float f = this.f2854a;
        float f2 = this.f2855b;
        float f3 = this.f2856c;
        float f4 = this.f2857d;
        float f5 = this.f2858e;
        float f6 = this.f2859f;
        float f7 = this.f2860g;
        float f8 = this.f2861h;
        float f9 = this.f2862i;
        for (int i = 0; i < length; i += 2) {
            float f10 = fArr[i];
            float f11 = fArr[i + 1];
            float f12 = ((f3 * f10) + (f6 * f11)) + f9;
            fArr[i] = (((f * f10) + (f4 * f11)) + f7) / f12;
            fArr[i + 1] = (((f10 * f2) + (f11 * f5)) + f8) / f12;
        }
    }

    public static C1277k m4900a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float f9 = ((f - f3) + f5) - f7;
        float f10 = ((f2 - f4) + f6) - f8;
        if (f9 == 0.0f && f10 == 0.0f) {
            return new C1277k(f3 - f, f5 - f3, f, f4 - f2, f6 - f4, f2, 0.0f, 0.0f, 1.0f);
        }
        float f11 = f3 - f5;
        float f12 = f7 - f5;
        float f13 = f4 - f6;
        float f14 = f8 - f6;
        float f15 = (f11 * f14) - (f12 * f13);
        float f16 = ((f14 * f9) - (f12 * f10)) / f15;
        float f17 = ((f10 * f11) - (f9 * f13)) / f15;
        return new C1277k((f3 - f) + (f16 * f3), (f7 - f) + (f17 * f7), f, (f16 * f4) + (f4 - f2), (f17 * f8) + (f8 - f2), f2, f16, f17, 1.0f);
    }

    public static C1277k m4902b(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        return C1277k.m4900a(f, f2, f3, f4, f5, f6, f7, f8).m4903a();
    }

    C1277k m4903a() {
        return new C1277k((this.f2858e * this.f2862i) - (this.f2859f * this.f2861h), (this.f2859f * this.f2860g) - (this.f2857d * this.f2862i), (this.f2857d * this.f2861h) - (this.f2858e * this.f2860g), (this.f2856c * this.f2861h) - (this.f2855b * this.f2862i), (this.f2854a * this.f2862i) - (this.f2856c * this.f2860g), (this.f2855b * this.f2860g) - (this.f2854a * this.f2861h), (this.f2855b * this.f2859f) - (this.f2856c * this.f2858e), (this.f2856c * this.f2857d) - (this.f2854a * this.f2859f), (this.f2854a * this.f2858e) - (this.f2855b * this.f2857d));
    }

    C1277k m4904a(C1277k c1277k) {
        return new C1277k(((this.f2854a * c1277k.f2854a) + (this.f2857d * c1277k.f2855b)) + (this.f2860g * c1277k.f2856c), ((this.f2854a * c1277k.f2857d) + (this.f2857d * c1277k.f2858e)) + (this.f2860g * c1277k.f2859f), ((this.f2854a * c1277k.f2860g) + (this.f2857d * c1277k.f2861h)) + (this.f2860g * c1277k.f2862i), ((this.f2855b * c1277k.f2854a) + (this.f2858e * c1277k.f2855b)) + (this.f2861h * c1277k.f2856c), ((this.f2855b * c1277k.f2857d) + (this.f2858e * c1277k.f2858e)) + (this.f2861h * c1277k.f2859f), ((this.f2855b * c1277k.f2860g) + (this.f2858e * c1277k.f2861h)) + (this.f2861h * c1277k.f2862i), ((this.f2856c * c1277k.f2854a) + (this.f2859f * c1277k.f2855b)) + (this.f2862i * c1277k.f2856c), ((this.f2856c * c1277k.f2857d) + (this.f2859f * c1277k.f2858e)) + (this.f2862i * c1277k.f2859f), ((this.f2856c * c1277k.f2860g) + (this.f2859f * c1277k.f2861h)) + (this.f2862i * c1277k.f2862i));
    }
}
