package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.p034a;

import android.graphics.Rect;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.C1346l;
import java.util.List;

public class C1319h {
    private static final String f3071a = C1319h.class.getSimpleName();
    private C1346l f3072b;
    private int f3073c;
    private boolean f3074d = false;
    private C1317l f3075e = new C1320i();

    public C1319h(int i, C1346l c1346l) {
        this.f3073c = i;
        this.f3072b = c1346l;
    }

    public int m5087a() {
        return this.f3073c;
    }

    public void m5091a(C1317l c1317l) {
        this.f3075e = c1317l;
    }

    public C1346l m5090a(boolean z) {
        if (this.f3072b == null) {
            return null;
        }
        if (z) {
            return this.f3072b.m5147a();
        }
        return this.f3072b;
    }

    public C1346l m5089a(List<C1346l> list, boolean z) {
        return this.f3075e.m5082a((List) list, m5090a(z));
    }

    public Rect m5088a(C1346l c1346l) {
        return this.f3075e.mo780b(c1346l, this.f3072b);
    }
}
