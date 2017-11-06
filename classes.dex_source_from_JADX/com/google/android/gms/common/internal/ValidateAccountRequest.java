package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValidateAccountRequest implements SafeParcelable {
    public static final Creator<ValidateAccountRequest> CREATOR = new C0999b();
    final int f1942a;
    final IBinder f1943b;
    private final int f1944c;
    private final Scope[] f1945d;
    private final Bundle f1946e;
    private final String f1947f;

    ValidateAccountRequest(int i, int i2, IBinder iBinder, Scope[] scopeArr, Bundle bundle, String str) {
        this.f1942a = i;
        this.f1944c = i2;
        this.f1943b = iBinder;
        this.f1945d = scopeArr;
        this.f1946e = bundle;
        this.f1947f = str;
    }

    public int m3462a() {
        return this.f1944c;
    }

    public Scope[] m3463b() {
        return this.f1945d;
    }

    public String m3464c() {
        return this.f1947f;
    }

    public Bundle m3465d() {
        return this.f1946e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0999b.m3470a(this, parcel, i);
    }
}
