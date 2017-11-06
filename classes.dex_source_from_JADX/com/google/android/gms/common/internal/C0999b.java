package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C1033a;
import com.google.android.gms.common.internal.safeparcel.zza;

public class C0999b implements Creator<ValidateAccountRequest> {
    static void m3470a(ValidateAccountRequest validateAccountRequest, Parcel parcel, int i) {
        int a = C1033a.m3688a(parcel);
        C1033a.m3690a(parcel, 1, validateAccountRequest.f1942a);
        C1033a.m3690a(parcel, 2, validateAccountRequest.m3462a());
        C1033a.m3693a(parcel, 3, validateAccountRequest.f1943b, false);
        C1033a.m3699a(parcel, 4, validateAccountRequest.m3463b(), i, false);
        C1033a.m3692a(parcel, 5, validateAccountRequest.m3465d(), false);
        C1033a.m3697a(parcel, 6, validateAccountRequest.m3464c(), false);
        C1033a.m3689a(parcel, a);
    }

    public ValidateAccountRequest m3471a(Parcel parcel) {
        int i = 0;
        String str = null;
        int b = zza.m3711b(parcel);
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.m3706a(parcel);
            switch (zza.m3705a(a)) {
                case 1:
                    i2 = zza.m3715d(parcel, a);
                    break;
                case 2:
                    i = zza.m3715d(parcel, a);
                    break;
                case 3:
                    iBinder = zza.m3720i(parcel, a);
                    break;
                case 4:
                    scopeArr = (Scope[]) zza.m3713b(parcel, a, Scope.CREATOR);
                    break;
                case 5:
                    bundle = zza.m3721j(parcel, a);
                    break;
                case 6:
                    str = zza.m3719h(parcel, a);
                    break;
                default:
                    zza.m3712b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ValidateAccountRequest(i2, i, iBinder, scopeArr, bundle, str);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public ValidateAccountRequest[] m3472a(int i) {
        return new ValidateAccountRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3471a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3472a(i);
    }
}
