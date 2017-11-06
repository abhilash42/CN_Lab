package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1033a;
import com.google.android.gms.common.internal.safeparcel.zza;

public class C0745d implements Creator<Scope> {
    static void m3196a(Scope scope, Parcel parcel, int i) {
        int a = C1033a.m3688a(parcel);
        C1033a.m3690a(parcel, 1, scope.f1759a);
        C1033a.m3697a(parcel, 2, scope.m3182a(), false);
        C1033a.m3689a(parcel, a);
    }

    public Scope m3197a(Parcel parcel) {
        int b = zza.m3711b(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = zza.m3706a(parcel);
            switch (zza.m3705a(a)) {
                case 1:
                    i = zza.m3715d(parcel, a);
                    break;
                case 2:
                    str = zza.m3719h(parcel, a);
                    break;
                default:
                    zza.m3712b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new Scope(i, str);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Scope[] m3198a(int i) {
        return new Scope[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3197a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3198a(i);
    }
}
