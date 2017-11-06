package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.C1032p;
import com.google.android.gms.measurement.internal.C1164y;

public class C1100a {
    private final C1164y f2247a;

    public interface C1099a {
        void m4056a(String str, String str2, Bundle bundle);
    }

    public C1100a(C1164y c1164y) {
        C1032p.m3678a((Object) c1164y);
        this.f2247a = c1164y;
    }

    public static C1100a m4057a(Context context) {
        return C1164y.m4496a(context).m4522j();
    }

    public void m4058a(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.f2247a.m4521i().m4121a(str, str2, bundle);
    }
}
