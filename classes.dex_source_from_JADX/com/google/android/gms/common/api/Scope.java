package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C1032p;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class Scope implements SafeParcelable {
    public static final Creator<Scope> CREATOR = new C0745d();
    final int f1759a;
    private final String f1760b;

    Scope(int i, String str) {
        C1032p.m3681a(str, (Object) "scopeUri must not be null or empty");
        this.f1759a = i;
        this.f1760b = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public String m3182a() {
        return this.f1760b;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj ? true : !(obj instanceof Scope) ? false : this.f1760b.equals(((Scope) obj).f1760b);
    }

    public int hashCode() {
        return this.f1760b.hashCode();
    }

    public String toString() {
        return this.f1760b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0745d.m3196a(this, parcel, i);
    }
}
