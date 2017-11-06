package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C1032p;
import java.util.Iterator;

public class C1133l {
    final String f2364a;
    final String f2365b;
    final String f2366c;
    final long f2367d;
    final long f2368e;
    final EventParams f2369f;

    C1133l(C1164y c1164y, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        C1032p.m3680a(str2);
        C1032p.m3680a(str3);
        this.f2364a = str2;
        this.f2365b = str3;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f2366c = str;
        this.f2367d = j;
        this.f2368e = j2;
        if (this.f2368e != 0 && this.f2368e > this.f2367d) {
            c1164y.m4518f().m4412o().m4387a("Event created with reverse previous/current timestamps");
        }
        this.f2369f = m4336a(c1164y, bundle);
    }

    private C1133l(C1164y c1164y, String str, String str2, String str3, long j, long j2, EventParams eventParams) {
        C1032p.m3680a(str2);
        C1032p.m3680a(str3);
        C1032p.m3678a((Object) eventParams);
        this.f2364a = str2;
        this.f2365b = str3;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f2366c = str;
        this.f2367d = j;
        this.f2368e = j2;
        if (this.f2368e != 0 && this.f2368e > this.f2367d) {
            c1164y.m4518f().m4412o().m4387a("Event created with reverse previous/current timestamps");
        }
        this.f2369f = eventParams;
    }

    private EventParams m4336a(C1164y c1164y, Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return new EventParams(new Bundle());
        }
        Bundle bundle2 = new Bundle(bundle);
        Iterator it = bundle2.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str == null) {
                it.remove();
            } else {
                Object a = c1164y.m4523k().m4214a(str, bundle2.get(str));
                if (a == null) {
                    it.remove();
                } else {
                    c1164y.m4523k().m4215a(bundle2, str, a);
                }
            }
        }
        return new EventParams(bundle2);
    }

    C1133l m4337a(C1164y c1164y, long j) {
        return new C1133l(c1164y, this.f2366c, this.f2364a, this.f2365b, this.f2367d, j, this.f2369f);
    }

    public String toString() {
        return "Event{appId='" + this.f2364a + '\'' + ", name='" + this.f2365b + '\'' + ", params=" + this.f2369f + '}';
    }
}
