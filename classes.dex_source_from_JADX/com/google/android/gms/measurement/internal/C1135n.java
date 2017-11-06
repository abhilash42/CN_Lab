package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1033a;
import com.google.android.gms.common.internal.safeparcel.zza;

public class C1135n implements Creator<EventParams> {
    static void m4339a(EventParams eventParams, Parcel parcel, int i) {
        int a = C1033a.m3688a(parcel);
        C1033a.m3690a(parcel, 1, eventParams.f2263a);
        C1033a.m3692a(parcel, 2, eventParams.m4068b(), false);
        C1033a.m3689a(parcel, a);
    }

    public EventParams m4340a(Parcel parcel) {
        int b = zza.m3711b(parcel);
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < b) {
            int a = zza.m3706a(parcel);
            switch (zza.m3705a(a)) {
                case 1:
                    i = zza.m3715d(parcel, a);
                    break;
                case 2:
                    bundle = zza.m3721j(parcel, a);
                    break;
                default:
                    zza.m3712b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new EventParams(i, bundle);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public EventParams[] m4341a(int i) {
        return new EventParams[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4340a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4341a(i);
    }
}
