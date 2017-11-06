package in.juspay.widget.qrscanner.com.google.zxing;

import in.juspay.widget.qrscanner.com.google.zxing.p029b.C1245a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class C1286g implements C1244j {
    private Map<C1283d, ?> f2907a;
    private C1244j[] f2908b;

    public C1289k mo762a(C1265c c1265c) {
        m4941a(null);
        return m4937c(c1265c);
    }

    public C1289k mo763a(C1265c c1265c, Map<C1283d, ?> map) {
        m4941a((Map) map);
        return m4937c(c1265c);
    }

    public C1289k m4942b(C1265c c1265c) {
        if (this.f2908b == null) {
            m4941a(null);
        }
        return m4937c(c1265c);
    }

    public void m4941a(Map<C1283d, ?> map) {
        this.f2907a = map;
        Collection collection;
        Collection arrayList;
        if (map == null || map.containsKey(C1283d.TRY_HARDER)) {
            if (map != null) {
                collection = null;
            } else {
                collection = (Collection) map.get(C1283d.POSSIBLE_FORMATS);
            }
            arrayList = new ArrayList();
            if (collection != null && collection.contains(C1223a.QR_CODE)) {
                arrayList.add(new C1245a());
            }
            if (arrayList.isEmpty()) {
                arrayList.add(new C1245a());
            }
            this.f2908b = (C1244j[]) arrayList.toArray(new C1244j[arrayList.size()]);
        }
        if (map != null) {
            collection = (Collection) map.get(C1283d.POSSIBLE_FORMATS);
        } else {
            collection = null;
        }
        arrayList = new ArrayList();
        arrayList.add(new C1245a());
        if (arrayList.isEmpty()) {
            arrayList.add(new C1245a());
        }
        this.f2908b = (C1244j[]) arrayList.toArray(new C1244j[arrayList.size()]);
    }

    public void mo764a() {
        if (this.f2908b != null) {
            for (C1244j a : this.f2908b) {
                a.mo764a();
            }
        }
    }

    private C1289k m4937c(C1265c c1265c) {
        if (this.f2908b != null) {
            C1244j[] c1244jArr = this.f2908b;
            int length = c1244jArr.length;
            int i = 0;
            while (i < length) {
                try {
                    return c1244jArr[i].mo763a(c1265c, this.f2907a);
                } catch (ReaderException e) {
                    i++;
                }
            }
        }
        throw NotFoundException.m4639a();
    }
}
