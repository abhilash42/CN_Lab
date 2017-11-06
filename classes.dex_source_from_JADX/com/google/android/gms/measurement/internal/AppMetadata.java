package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C1032p;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AppMetadata implements SafeParcelable {
    public static final C1127g CREATOR = new C1127g();
    public final int f2252a;
    public final String f2253b;
    public final String f2254c;
    public final String f2255d;
    public final String f2256e;
    public final long f2257f;
    public final long f2258g;
    public final String f2259h;
    public final boolean f2260i;

    AppMetadata(int i, String str, String str2, String str3, String str4, long j, long j2, String str5, boolean z) {
        this.f2252a = i;
        this.f2253b = str;
        this.f2254c = str2;
        this.f2255d = str3;
        this.f2256e = str4;
        this.f2257f = j;
        this.f2258g = j2;
        this.f2259h = str5;
        if (i >= 3) {
            this.f2260i = z;
        } else {
            this.f2260i = true;
        }
    }

    AppMetadata(String str, String str2, String str3, String str4, long j, long j2, String str5, boolean z) {
        C1032p.m3680a(str);
        this.f2252a = 3;
        this.f2253b = str;
        if (TextUtils.isEmpty(str2)) {
            str2 = null;
        }
        this.f2254c = str2;
        this.f2255d = str3;
        this.f2256e = str4;
        this.f2257f = j;
        this.f2258g = j2;
        this.f2259h = str5;
        this.f2260i = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1127g.m4241a(this, parcel, i);
    }
}
