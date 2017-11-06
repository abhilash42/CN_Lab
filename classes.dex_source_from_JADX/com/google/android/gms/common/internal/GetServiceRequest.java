package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.C0747b;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C0996l.C0997a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collection;

public class GetServiceRequest implements SafeParcelable {
    public static final Creator<GetServiceRequest> CREATOR = new C1005g();
    final int f1934a;
    final int f1935b;
    int f1936c;
    String f1937d;
    IBinder f1938e;
    Scope[] f1939f;
    Bundle f1940g;
    Account f1941h;

    public GetServiceRequest(int i) {
        this.f1934a = 2;
        this.f1936c = C0747b.f1793a;
        this.f1935b = i;
    }

    GetServiceRequest(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account) {
        this.f1934a = i;
        this.f1935b = i2;
        this.f1936c = i3;
        this.f1937d = str;
        if (i < 2) {
            this.f1941h = m3456a(iBinder);
        } else {
            this.f1938e = iBinder;
            this.f1941h = account;
        }
        this.f1939f = scopeArr;
        this.f1940g = bundle;
    }

    private Account m3456a(IBinder iBinder) {
        return iBinder != null ? C0998a.m3468a(C0997a.m3467a(iBinder)) : null;
    }

    public GetServiceRequest m3457a(Account account) {
        this.f1941h = account;
        return this;
    }

    public GetServiceRequest m3458a(Bundle bundle) {
        this.f1940g = bundle;
        return this;
    }

    public GetServiceRequest m3459a(C0996l c0996l) {
        if (c0996l != null) {
            this.f1938e = c0996l.asBinder();
        }
        return this;
    }

    public GetServiceRequest m3460a(String str) {
        this.f1937d = str;
        return this;
    }

    public GetServiceRequest m3461a(Collection<Scope> collection) {
        this.f1939f = (Scope[]) collection.toArray(new Scope[collection.size()]);
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1005g.m3483a(this, parcel, i);
    }
}
