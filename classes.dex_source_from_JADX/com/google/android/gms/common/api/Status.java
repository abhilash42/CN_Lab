package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C1031o;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class Status implements SafeParcelable {
    public static final Creator<Status> CREATOR = new C0746e();
    public static final Status f1761a = new Status(0);
    public static final Status f1762b = new Status(14);
    public static final Status f1763c = new Status(8);
    public static final Status f1764d = new Status(15);
    public static final Status f1765e = new Status(16);
    private final int f1766f;
    private final int f1767g;
    private final String f1768h;
    private final PendingIntent f1769i;

    public Status(int i) {
        this(i, null);
    }

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.f1766f = i;
        this.f1767g = i2;
        this.f1768h = str;
        this.f1769i = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, null);
    }

    private String m3183f() {
        return this.f1768h != null ? this.f1768h : C0738b.m3189a(this.f1767g);
    }

    PendingIntent m3184a() {
        return this.f1769i;
    }

    public String m3185b() {
        return this.f1768h;
    }

    int m3186c() {
        return this.f1766f;
    }

    public boolean m3187d() {
        return this.f1767g <= 0;
    }

    public int describeContents() {
        return 0;
    }

    public int m3188e() {
        return this.f1767g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f1766f == status.f1766f && this.f1767g == status.f1767g && C1031o.m3677a(this.f1768h, status.f1768h) && C1031o.m3677a(this.f1769i, status.f1769i);
    }

    public int hashCode() {
        return C1031o.m3675a(Integer.valueOf(this.f1766f), Integer.valueOf(this.f1767g), this.f1768h, this.f1769i);
    }

    public String toString() {
        return C1031o.m3676a((Object) this).m3674a("statusCode", m3183f()).m3674a("resolution", this.f1769i).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0746e.m3199a(this, parcel, i);
    }
}
