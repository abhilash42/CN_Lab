package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ConnectionEvent extends C1034f implements SafeParcelable {
    public static final Creator<ConnectionEvent> CREATOR = new C1035a();
    final int f2027a;
    private final long f2028b;
    private int f2029c;
    private final String f2030d;
    private final String f2031e;
    private final String f2032f;
    private final String f2033g;
    private final String f2034h;
    private final String f2035i;
    private final long f2036j;
    private final long f2037k;
    private long f2038l;

    ConnectionEvent(int i, long j, int i2, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this.f2027a = i;
        this.f2028b = j;
        this.f2029c = i2;
        this.f2030d = str;
        this.f2031e = str2;
        this.f2032f = str3;
        this.f2033g = str4;
        this.f2038l = -1;
        this.f2034h = str5;
        this.f2035i = str6;
        this.f2036j = j2;
        this.f2037k = j3;
    }

    public ConnectionEvent(long j, int i, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this(1, j, i, str, str2, str3, str4, str5, str6, j2, j3);
    }

    public long mo718a() {
        return this.f2028b;
    }

    public int mo719b() {
        return this.f2029c;
    }

    public String m3729c() {
        return this.f2030d;
    }

    public String m3730d() {
        return this.f2031e;
    }

    public int describeContents() {
        return 0;
    }

    public String m3731e() {
        return this.f2032f;
    }

    public String m3732f() {
        return this.f2033g;
    }

    public String m3733g() {
        return this.f2034h;
    }

    public String m3734h() {
        return this.f2035i;
    }

    public long mo720i() {
        return this.f2038l;
    }

    public long m3736j() {
        return this.f2037k;
    }

    public long m3737k() {
        return this.f2036j;
    }

    public String mo721l() {
        return "\t" + m3729c() + "/" + m3730d() + "\t" + m3731e() + "/" + m3732f() + "\t" + (this.f2034h == null ? "" : this.f2034h) + "\t" + m3736j();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1035a.m3739a(this, parcel, i);
    }
}
