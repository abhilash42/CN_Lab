package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1033a;
import com.google.android.gms.common.internal.safeparcel.zza;

public class C1136o implements Creator<EventParcel> {
    static void m4342a(EventParcel eventParcel, Parcel parcel, int i) {
        int a = C1033a.m3688a(parcel);
        C1033a.m3690a(parcel, 1, eventParcel.f2265a);
        C1033a.m3697a(parcel, 2, eventParcel.f2266b, false);
        C1033a.m3694a(parcel, 3, eventParcel.f2267c, i, false);
        C1033a.m3697a(parcel, 4, eventParcel.f2268d, false);
        C1033a.m3691a(parcel, 5, eventParcel.f2269e);
        C1033a.m3689a(parcel, a);
    }

    public EventParcel m4343a(Parcel parcel) {
        String str = null;
        int b = zza.m3711b(parcel);
        int i = 0;
        long j = 0;
        EventParams eventParams = null;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a = zza.m3706a(parcel);
            switch (zza.m3705a(a)) {
                case 1:
                    i = zza.m3715d(parcel, a);
                    break;
                case 2:
                    str2 = zza.m3719h(parcel, a);
                    break;
                case 3:
                    eventParams = (EventParams) zza.m3708a(parcel, a, EventParams.CREATOR);
                    break;
                case 4:
                    str = zza.m3719h(parcel, a);
                    break;
                case 5:
                    j = zza.m3716e(parcel, a);
                    break;
                default:
                    zza.m3712b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new EventParcel(i, str2, eventParams, str, j);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public EventParcel[] m4344a(int i) {
        return new EventParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4343a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4344a(i);
    }
}
