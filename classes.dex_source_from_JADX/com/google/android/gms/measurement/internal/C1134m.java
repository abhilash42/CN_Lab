package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.C1032p;

class C1134m {
    final String f2370a;
    final String f2371b;
    final long f2372c;
    final long f2373d;
    final long f2374e;

    C1134m(String str, String str2, long j, long j2, long j3) {
        boolean z = true;
        C1032p.m3680a(str);
        C1032p.m3680a(str2);
        C1032p.m3685b(j >= 0);
        if (j2 < 0) {
            z = false;
        }
        C1032p.m3685b(z);
        this.f2370a = str;
        this.f2371b = str2;
        this.f2372c = j;
        this.f2373d = j2;
        this.f2374e = j3;
    }

    C1134m m4338a(long j) {
        return new C1134m(this.f2370a, this.f2371b, this.f2372c + 1, this.f2373d + 1, j);
    }
}
