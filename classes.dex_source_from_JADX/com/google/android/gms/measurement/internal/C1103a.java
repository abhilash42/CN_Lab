package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.C1032p;

class C1103a {
    final String f2277a;
    final String f2278b;
    final String f2279c;
    final String f2280d;
    final long f2281e;
    final long f2282f;
    final String f2283g;
    final String f2284h;
    final long f2285i;
    final long f2286j;
    final boolean f2287k;

    C1103a(String str, String str2, String str3, String str4, long j, long j2, String str5, String str6, long j3, long j4, boolean z) {
        C1032p.m3680a(str);
        C1032p.m3685b(j >= 0);
        this.f2277a = str;
        this.f2278b = str2;
        if (TextUtils.isEmpty(str3)) {
            str3 = null;
        }
        this.f2279c = str3;
        this.f2280d = str4;
        this.f2281e = j;
        this.f2282f = j2;
        this.f2283g = str5;
        this.f2284h = str6;
        this.f2285i = j3;
        this.f2286j = j4;
        this.f2287k = z;
    }

    public C1103a m4070a(long j) {
        return new C1103a(this.f2277a, this.f2278b, this.f2279c, this.f2280d, this.f2281e, this.f2282f, this.f2283g, this.f2284h, this.f2285i, j, this.f2287k);
    }

    public C1103a m4071a(C1146t c1146t, long j) {
        C1032p.m3678a((Object) c1146t);
        long j2 = this.f2281e + 1;
        if (j2 > 2147483647L) {
            c1146t.m4412o().m4387a("Bundle index overflow");
            j2 = 0;
        }
        return new C1103a(this.f2277a, this.f2278b, this.f2279c, this.f2280d, j2, j, this.f2283g, this.f2284h, this.f2285i, this.f2286j, this.f2287k);
    }

    public C1103a m4072a(String str, long j) {
        return new C1103a(this.f2277a, this.f2278b, str, this.f2280d, this.f2281e, this.f2282f, this.f2283g, this.f2284h, j, this.f2286j, this.f2287k);
    }

    public C1103a m4073a(String str, String str2) {
        return new C1103a(this.f2277a, str, this.f2279c, str2, this.f2281e, this.f2282f, this.f2283g, this.f2284h, this.f2285i, this.f2286j, this.f2287k);
    }

    public C1103a m4074a(boolean z) {
        return new C1103a(this.f2277a, this.f2278b, this.f2279c, this.f2280d, this.f2281e, this.f2282f, this.f2283g, this.f2284h, this.f2285i, this.f2286j, z);
    }

    public C1103a m4075b(String str, String str2) {
        return new C1103a(this.f2277a, this.f2278b, this.f2279c, this.f2280d, this.f2281e, this.f2282f, str, str2, this.f2285i, this.f2286j, this.f2287k);
    }
}
