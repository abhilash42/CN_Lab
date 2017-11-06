package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.p034a;

import android.graphics.Rect;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.C1346l;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class C1317l {
    private static final String f3069a = C1317l.class.getSimpleName();

    public abstract Rect mo780b(C1346l c1346l, C1346l c1346l2);

    public C1346l m5082a(List<C1346l> list, C1346l c1346l) {
        return (C1346l) m5084b((List) list, c1346l).get(0);
    }

    public List<C1346l> m5084b(List<C1346l> list, final C1346l c1346l) {
        if (c1346l != null) {
            Collections.sort(list, new Comparator<C1346l>(this) {
                final /* synthetic */ C1317l f3079b;

                public /* synthetic */ int compare(Object obj, Object obj2) {
                    return m5099a((C1346l) obj, (C1346l) obj2);
                }

                public int m5099a(C1346l c1346l, C1346l c1346l2) {
                    return Float.compare(this.f3079b.mo779a(c1346l2, c1346l), this.f3079b.mo779a(c1346l, c1346l));
                }
            });
        }
        return list;
    }

    protected float mo779a(C1346l c1346l, C1346l c1346l2) {
        return 0.5f;
    }
}
