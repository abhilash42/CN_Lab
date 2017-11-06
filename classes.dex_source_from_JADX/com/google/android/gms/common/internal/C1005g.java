package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C1033a;
import com.google.android.gms.common.internal.safeparcel.zza;

public class C1005g implements Creator<GetServiceRequest> {
    static void m3483a(GetServiceRequest getServiceRequest, Parcel parcel, int i) {
        int a = C1033a.m3688a(parcel);
        C1033a.m3690a(parcel, 1, getServiceRequest.f1934a);
        C1033a.m3690a(parcel, 2, getServiceRequest.f1935b);
        C1033a.m3690a(parcel, 3, getServiceRequest.f1936c);
        C1033a.m3697a(parcel, 4, getServiceRequest.f1937d, false);
        C1033a.m3693a(parcel, 5, getServiceRequest.f1938e, false);
        C1033a.m3699a(parcel, 6, getServiceRequest.f1939f, i, false);
        C1033a.m3692a(parcel, 7, getServiceRequest.f1940g, false);
        C1033a.m3694a(parcel, 8, getServiceRequest.f1941h, i, false);
        C1033a.m3689a(parcel, a);
    }

    public GetServiceRequest m3484a(Parcel parcel) {
        int i = 0;
        Account account = null;
        int b = zza.m3711b(parcel);
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.m3706a(parcel);
            switch (zza.m3705a(a)) {
                case 1:
                    i3 = zza.m3715d(parcel, a);
                    break;
                case 2:
                    i2 = zza.m3715d(parcel, a);
                    break;
                case 3:
                    i = zza.m3715d(parcel, a);
                    break;
                case 4:
                    str = zza.m3719h(parcel, a);
                    break;
                case 5:
                    iBinder = zza.m3720i(parcel, a);
                    break;
                case 6:
                    scopeArr = (Scope[]) zza.m3713b(parcel, a, Scope.CREATOR);
                    break;
                case 7:
                    bundle = zza.m3721j(parcel, a);
                    break;
                case 8:
                    account = (Account) zza.m3708a(parcel, a, Account.CREATOR);
                    break;
                default:
                    zza.m3712b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GetServiceRequest(i3, i2, i, str, iBinder, scopeArr, bundle, account);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public GetServiceRequest[] m3485a(int i) {
        return new GetServiceRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3484a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3485a(i);
    }
}
