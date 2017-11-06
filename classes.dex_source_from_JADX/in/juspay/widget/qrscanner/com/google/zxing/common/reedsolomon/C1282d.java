package in.juspay.widget.qrscanner.com.google.zxing.common.reedsolomon;

import java.util.ArrayList;
import java.util.List;

public final class C1282d {
    private final C1279a f2883a;
    private final List<C1280b> f2884b = new ArrayList();

    public C1282d(C1279a c1279a) {
        this.f2883a = c1279a;
        this.f2884b.add(new C1280b(c1279a, new int[]{1}));
    }

    private C1280b m4931a(int i) {
        if (i >= this.f2884b.size()) {
            C1280b c1280b = (C1280b) this.f2884b.get(this.f2884b.size() - 1);
            C1280b c1280b2 = c1280b;
            for (int size = this.f2884b.size(); size <= i; size++) {
                c1280b2 = c1280b2.m4923b(new C1280b(this.f2883a, new int[]{1, this.f2883a.m4908a((size - 1) + this.f2883a.m4916d())}));
                this.f2884b.add(c1280b2);
            }
        }
        return (C1280b) this.f2884b.get(i);
    }

    public void m4932a(int[] iArr, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        C1280b a = m4931a(i);
        Object obj = new int[length];
        System.arraycopy(iArr, 0, obj, 0, length);
        obj = new C1280b(this.f2883a, obj).m4918a(i, 1).m4926c(a)[1].m4920a();
        int length2 = i - obj.length;
        for (int i2 = 0; i2 < length2; i2++) {
            iArr[length + i2] = 0;
        }
        System.arraycopy(obj, 0, iArr, length + length2, obj.length);
    }
}
