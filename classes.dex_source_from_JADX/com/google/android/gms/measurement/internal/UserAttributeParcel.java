package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.C1032p;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class UserAttributeParcel implements SafeParcelable {
    public static final C1125e CREATOR = new C1125e();
    public final int f2270a;
    public final String f2271b;
    public final long f2272c;
    public final Long f2273d;
    public final Float f2274e;
    public final String f2275f;
    public final String f2276g;

    UserAttributeParcel(int i, String str, long j, Long l, Float f, String str2, String str3) {
        this.f2270a = i;
        this.f2271b = str;
        this.f2272c = j;
        this.f2273d = l;
        this.f2274e = f;
        this.f2275f = str2;
        this.f2276g = str3;
    }

    UserAttributeParcel(String str, long j, Object obj, String str2) {
        C1032p.m3680a(str);
        this.f2270a = 1;
        this.f2271b = str;
        this.f2272c = j;
        this.f2276g = str2;
        if (obj == null) {
            this.f2273d = null;
            this.f2274e = null;
            this.f2275f = null;
        } else if (obj instanceof Long) {
            this.f2273d = (Long) obj;
            this.f2274e = null;
            this.f2275f = null;
        } else if (obj instanceof Float) {
            this.f2273d = null;
            this.f2274e = (Float) obj;
            this.f2275f = null;
        } else if (obj instanceof String) {
            this.f2273d = null;
            this.f2274e = null;
            this.f2275f = (String) obj;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    public Object m4069a() {
        return this.f2273d != null ? this.f2273d : this.f2274e != null ? this.f2274e : this.f2275f != null ? this.f2275f : null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1125e.m4206a(this, parcel, i);
    }
}
