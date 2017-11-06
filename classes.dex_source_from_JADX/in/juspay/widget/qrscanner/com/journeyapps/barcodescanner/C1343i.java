package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner;

import in.juspay.widget.qrscanner.com.google.zxing.C1223a;
import in.juspay.widget.qrscanner.com.google.zxing.C1244j;
import in.juspay.widget.qrscanner.com.google.zxing.C1283d;
import in.juspay.widget.qrscanner.com.google.zxing.C1286g;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

public class C1343i implements C1338f {
    private Collection<C1223a> f3122a;
    private Map<C1283d, ?> f3123b;
    private String f3124c;

    public C1337e mo785a(Map<C1283d, ?> map) {
        Map enumMap = new EnumMap(C1283d.class);
        enumMap.putAll(map);
        if (this.f3123b != null) {
            enumMap.putAll(this.f3123b);
        }
        if (this.f3122a != null) {
            enumMap.put(C1283d.POSSIBLE_FORMATS, this.f3122a);
        }
        if (this.f3124c != null) {
            enumMap.put(C1283d.CHARACTER_SET, this.f3124c);
        }
        C1244j c1286g = new C1286g();
        c1286g.m4941a(enumMap);
        return new C1337e(c1286g);
    }
}
