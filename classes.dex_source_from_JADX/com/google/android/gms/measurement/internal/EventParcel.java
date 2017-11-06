package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class EventParcel implements SafeParcelable {
    public static final C1136o CREATOR = new C1136o();
    public final int f2265a;
    public final String f2266b;
    public final EventParams f2267c;
    public final String f2268d;
    public final long f2269e;

    EventParcel(int i, String str, EventParams eventParams, String str2, long j) {
        this.f2265a = i;
        this.f2266b = str;
        this.f2267c = eventParams;
        this.f2268d = str2;
        this.f2269e = j;
    }

    public EventParcel(String str, EventParams eventParams, String str2, long j) {
        this.f2265a = 1;
        this.f2266b = str;
        this.f2267c = eventParams;
        this.f2268d = str2;
        this.f2269e = j;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "origin=" + this.f2268d + ",name=" + this.f2266b + ",params=" + this.f2267c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1136o.m4342a(this, parcel, i);
    }
}
