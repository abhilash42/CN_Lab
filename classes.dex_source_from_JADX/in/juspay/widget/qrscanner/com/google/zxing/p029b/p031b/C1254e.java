package in.juspay.widget.qrscanner.com.google.zxing.p029b.p031b;

import in.juspay.widget.qrscanner.com.google.zxing.C1246m;
import in.juspay.widget.qrscanner.com.google.zxing.C1283d;
import in.juspay.widget.qrscanner.com.google.zxing.C1291n;
import in.juspay.widget.qrscanner.com.google.zxing.NotFoundException;
import in.juspay.widget.qrscanner.com.google.zxing.common.C1268b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class C1254e {
    private final C1268b f2771a;
    private final List<C1250d> f2772b = new ArrayList();
    private boolean f2773c;
    private final int[] f2774d = new int[5];
    private final C1291n f2775e;

    private static final class C1252a implements Serializable, Comparator<C1250d> {
        private final float f2769a;

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m4761a((C1250d) obj, (C1250d) obj2);
        }

        private C1252a(float f) {
            this.f2769a = f;
        }

        public int m4761a(C1250d c1250d, C1250d c1250d2) {
            if (c1250d2.m4760d() != c1250d.m4760d()) {
                return c1250d2.m4760d() - c1250d.m4760d();
            }
            float abs = Math.abs(c1250d2.m4759c() - this.f2769a);
            float abs2 = Math.abs(c1250d.m4759c() - this.f2769a);
            if (abs < abs2) {
                return 1;
            }
            return abs == abs2 ? 0 : -1;
        }
    }

    private static final class C1253b implements Serializable, Comparator<C1250d> {
        private final float f2770a;

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m4762a((C1250d) obj, (C1250d) obj2);
        }

        private C1253b(float f) {
            this.f2770a = f;
        }

        public int m4762a(C1250d c1250d, C1250d c1250d2) {
            float abs = Math.abs(c1250d2.m4759c() - this.f2770a);
            float abs2 = Math.abs(c1250d.m4759c() - this.f2770a);
            if (abs < abs2) {
                return -1;
            }
            return abs == abs2 ? 0 : 1;
        }
    }

    public C1254e(C1268b c1268b, C1291n c1291n) {
        this.f2771a = c1268b;
        this.f2775e = c1291n;
    }

    final C1255f m4772a(Map<C1283d, ?> map) {
        Object obj = (map == null || !map.containsKey(C1283d.TRY_HARDER)) ? null : 1;
        boolean z = map != null && map.containsKey(C1283d.PURE_BARCODE);
        int d = this.f2771a.m4870d();
        int c = this.f2771a.m4868c();
        int i = (d * 3) / 228;
        if (i < 3 || obj != null) {
            i = 3;
        }
        boolean z2 = false;
        int[] iArr = new int[5];
        int i2 = i - 1;
        int i3 = i;
        while (i2 < d && !r4) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            i = 0;
            int i4 = 0;
            while (i4 < c) {
                if (this.f2771a.m4864a(i4, i2)) {
                    if ((i & 1) == 1) {
                        i++;
                    }
                    iArr[i] = iArr[i] + 1;
                } else if ((i & 1) != 0) {
                    iArr[i] = iArr[i] + 1;
                } else if (i != 4) {
                    i++;
                    iArr[i] = iArr[i] + 1;
                } else if (!C1254e.m4765a(iArr)) {
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = iArr[4];
                    iArr[3] = 1;
                    iArr[4] = 0;
                    i = 3;
                } else if (m4773a(iArr, i2, i4, z)) {
                    boolean c2;
                    i3 = 2;
                    if (this.f2773c) {
                        c2 = m4770c();
                    } else {
                        i = m4768b();
                        if (i > iArr[2]) {
                            i4 = i2 + ((i - iArr[2]) - 2);
                            i = c - 1;
                        } else {
                            i = i4;
                            i4 = i2;
                        }
                        i2 = i4;
                        i4 = i;
                        c2 = z2;
                    }
                    iArr[0] = 0;
                    iArr[1] = 0;
                    iArr[2] = 0;
                    iArr[3] = 0;
                    iArr[4] = 0;
                    z2 = c2;
                    i = 0;
                } else {
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = iArr[4];
                    iArr[3] = 1;
                    iArr[4] = 0;
                    i = 3;
                }
                i4++;
            }
            if (C1254e.m4765a(iArr) && m4773a(iArr, i2, c, z)) {
                i3 = iArr[0];
                if (this.f2773c) {
                    z2 = m4770c();
                }
            }
            i2 += i3;
        }
        C1246m[] d2 = m4771d();
        C1246m.m4737a(d2);
        return new C1255f(d2);
    }

    private static float m4763a(int[] iArr, int i) {
        return ((float) ((i - iArr[4]) - iArr[3])) - (((float) iArr[2]) / 2.0f);
    }

    protected static boolean m4765a(int[] iArr) {
        boolean z = true;
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = ((float) i) / 7.0f;
        float f2 = f / 2.0f;
        if (Math.abs(f - ((float) iArr[0])) >= f2 || Math.abs(f - ((float) iArr[1])) >= f2 || Math.abs((3.0f * f) - ((float) iArr[2])) >= 3.0f * f2 || Math.abs(f - ((float) iArr[3])) >= f2 || Math.abs(f - ((float) iArr[4])) >= f2) {
            z = false;
        }
        return z;
    }

    private int[] m4766a() {
        this.f2774d[0] = 0;
        this.f2774d[1] = 0;
        this.f2774d[2] = 0;
        this.f2774d[3] = 0;
        this.f2774d[4] = 0;
        return this.f2774d;
    }

    private boolean m4764a(int i, int i2, int i3, int i4) {
        int[] a = m4766a();
        int i5 = 0;
        while (i >= i5 && i2 >= i5 && this.f2771a.m4864a(i2 - i5, i - i5)) {
            a[2] = a[2] + 1;
            i5++;
        }
        if (i < i5 || i2 < i5) {
            return false;
        }
        while (i >= i5 && i2 >= i5 && !this.f2771a.m4864a(i2 - i5, i - i5) && a[1] <= i3) {
            a[1] = a[1] + 1;
            i5++;
        }
        if (i < i5 || i2 < i5 || a[1] > i3) {
            return false;
        }
        while (i >= i5 && i2 >= i5 && this.f2771a.m4864a(i2 - i5, i - i5) && a[0] <= i3) {
            a[0] = a[0] + 1;
            i5++;
        }
        if (a[0] > i3) {
            return false;
        }
        int d = this.f2771a.m4870d();
        int c = this.f2771a.m4868c();
        i5 = 1;
        while (i + i5 < d && i2 + i5 < c && this.f2771a.m4864a(i2 + i5, i + i5)) {
            a[2] = a[2] + 1;
            i5++;
        }
        if (i + i5 >= d || i2 + i5 >= c) {
            return false;
        }
        while (i + i5 < d && i2 + i5 < c && !this.f2771a.m4864a(i2 + i5, i + i5) && a[3] < i3) {
            a[3] = a[3] + 1;
            i5++;
        }
        if (i + i5 >= d || i2 + i5 >= c || a[3] >= i3) {
            return false;
        }
        while (i + i5 < d && i2 + i5 < c && this.f2771a.m4864a(i2 + i5, i + i5) && a[4] < i3) {
            a[4] = a[4] + 1;
            i5++;
        }
        if (a[4] >= i3) {
            return false;
        }
        return Math.abs(((((a[0] + a[1]) + a[2]) + a[3]) + a[4]) - i4) < i4 * 2 && C1254e.m4765a(a);
    }

    private float m4767b(int i, int i2, int i3, int i4) {
        C1268b c1268b = this.f2771a;
        int d = c1268b.m4870d();
        int[] a = m4766a();
        int i5 = i;
        while (i5 >= 0 && c1268b.m4864a(i2, i5)) {
            a[2] = a[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !c1268b.m4864a(i2, i5) && a[1] <= i3) {
            a[1] = a[1] + 1;
            i5--;
        }
        if (i5 < 0 || a[1] > i3) {
            return Float.NaN;
        }
        while (i5 >= 0 && c1268b.m4864a(i2, i5) && a[0] <= i3) {
            a[0] = a[0] + 1;
            i5--;
        }
        if (a[0] > i3) {
            return Float.NaN;
        }
        i5 = i + 1;
        while (i5 < d && c1268b.m4864a(i2, i5)) {
            a[2] = a[2] + 1;
            i5++;
        }
        if (i5 == d) {
            return Float.NaN;
        }
        while (i5 < d && !c1268b.m4864a(i2, i5) && a[3] < i3) {
            a[3] = a[3] + 1;
            i5++;
        }
        if (i5 == d || a[3] >= i3) {
            return Float.NaN;
        }
        while (i5 < d && c1268b.m4864a(i2, i5) && a[4] < i3) {
            a[4] = a[4] + 1;
            i5++;
        }
        if (a[4] >= i3 || Math.abs(((((a[0] + a[1]) + a[2]) + a[3]) + a[4]) - i4) * 5 >= i4 * 2 || !C1254e.m4765a(a)) {
            return Float.NaN;
        }
        return C1254e.m4763a(a, i5);
    }

    private float m4769c(int i, int i2, int i3, int i4) {
        C1268b c1268b = this.f2771a;
        int c = c1268b.m4868c();
        int[] a = m4766a();
        int i5 = i;
        while (i5 >= 0 && c1268b.m4864a(i5, i2)) {
            a[2] = a[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !c1268b.m4864a(i5, i2) && a[1] <= i3) {
            a[1] = a[1] + 1;
            i5--;
        }
        if (i5 < 0 || a[1] > i3) {
            return Float.NaN;
        }
        while (i5 >= 0 && c1268b.m4864a(i5, i2) && a[0] <= i3) {
            a[0] = a[0] + 1;
            i5--;
        }
        if (a[0] > i3) {
            return Float.NaN;
        }
        i5 = i + 1;
        while (i5 < c && c1268b.m4864a(i5, i2)) {
            a[2] = a[2] + 1;
            i5++;
        }
        if (i5 == c) {
            return Float.NaN;
        }
        while (i5 < c && !c1268b.m4864a(i5, i2) && a[3] < i3) {
            a[3] = a[3] + 1;
            i5++;
        }
        if (i5 == c || a[3] >= i3) {
            return Float.NaN;
        }
        while (i5 < c && c1268b.m4864a(i5, i2) && a[4] < i3) {
            a[4] = a[4] + 1;
            i5++;
        }
        if (a[4] >= i3 || Math.abs(((((a[0] + a[1]) + a[2]) + a[3]) + a[4]) - i4) * 5 >= i4 || !C1254e.m4765a(a)) {
            return Float.NaN;
        }
        return C1254e.m4763a(a, i5);
    }

    protected final boolean m4773a(int[] iArr, int i, int i2, boolean z) {
        boolean z2 = false;
        int i3 = (((iArr[0] + iArr[1]) + iArr[2]) + iArr[3]) + iArr[4];
        float a = C1254e.m4763a(iArr, i2);
        float b = m4767b(i, (int) a, iArr[2], i3);
        if (Float.isNaN(b)) {
            return false;
        }
        float c = m4769c((int) a, (int) b, iArr[2], i3);
        if (Float.isNaN(c)) {
            return false;
        }
        if (z && !m4764a((int) b, (int) c, iArr[2], i3)) {
            return false;
        }
        float f = ((float) i3) / 7.0f;
        for (int i4 = 0; i4 < this.f2772b.size(); i4++) {
            C1250d c1250d = (C1250d) this.f2772b.get(i4);
            if (c1250d.m4757a(f, b, c)) {
                this.f2772b.set(i4, c1250d.m4758b(b, c, f));
                z2 = true;
                break;
            }
        }
        if (!z2) {
            C1246m c1250d2 = new C1250d(c, b, f);
            this.f2772b.add(c1250d2);
            if (this.f2775e != null) {
                this.f2775e.mo782a(c1250d2);
            }
        }
        return true;
    }

    private int m4768b() {
        if (this.f2772b.size() <= 1) {
            return 0;
        }
        C1246m c1246m = null;
        for (C1246m c1246m2 : this.f2772b) {
            C1246m c1246m22;
            if (c1246m22.m4760d() < 2) {
                c1246m22 = c1246m;
            } else if (c1246m != null) {
                this.f2773c = true;
                return ((int) (Math.abs(c1246m.m4738a() - c1246m22.m4738a()) - Math.abs(c1246m.m4739b() - c1246m22.m4739b()))) / 2;
            }
            c1246m = c1246m22;
        }
        return 0;
    }

    private boolean m4770c() {
        float f = 0.0f;
        int size = this.f2772b.size();
        float f2 = 0.0f;
        int i = 0;
        for (C1250d c1250d : this.f2772b) {
            float c;
            int i2;
            if (c1250d.m4760d() >= 2) {
                c = c1250d.m4759c() + f2;
                i2 = i + 1;
            } else {
                c = f2;
                i2 = i;
            }
            i = i2;
            f2 = c;
        }
        if (i < 3) {
            return false;
        }
        float f3 = f2 / ((float) size);
        for (C1250d c1250d2 : this.f2772b) {
            f += Math.abs(c1250d2.m4759c() - f3);
        }
        if (f <= 0.05f * f2) {
            return true;
        }
        return false;
    }

    private C1250d[] m4771d() {
        float f = 0.0f;
        int size = this.f2772b.size();
        if (size < 3) {
            throw NotFoundException.m4639a();
        }
        if (size > 3) {
            float c;
            float f2 = 0.0f;
            float f3 = 0.0f;
            for (C1250d c2 : this.f2772b) {
                c = c2.m4759c();
                f3 += c;
                f2 = (c * c) + f2;
            }
            f3 /= (float) size;
            c = (float) Math.sqrt((double) ((f2 / ((float) size)) - (f3 * f3)));
            Collections.sort(this.f2772b, new C1253b(f3));
            float max = Math.max(0.2f * f3, c);
            int i = 0;
            while (i < this.f2772b.size() && this.f2772b.size() > 3) {
                if (Math.abs(((C1250d) this.f2772b.get(i)).m4759c() - f3) > max) {
                    this.f2772b.remove(i);
                    i--;
                }
                i++;
            }
        }
        if (this.f2772b.size() > 3) {
            for (C1250d c22 : this.f2772b) {
                f += c22.m4759c();
            }
            Collections.sort(this.f2772b, new C1252a(f / ((float) this.f2772b.size())));
            this.f2772b.subList(3, this.f2772b.size()).clear();
        }
        return new C1250d[]{(C1250d) this.f2772b.get(0), (C1250d) this.f2772b.get(1), (C1250d) this.f2772b.get(2)};
    }
}
