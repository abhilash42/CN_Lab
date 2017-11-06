package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1033a;
import com.google.android.gms.common.internal.safeparcel.zza;

public class C1125e implements Creator<UserAttributeParcel> {
    static void m4206a(UserAttributeParcel userAttributeParcel, Parcel parcel, int i) {
        int a = C1033a.m3688a(parcel);
        C1033a.m3690a(parcel, 1, userAttributeParcel.f2270a);
        C1033a.m3697a(parcel, 2, userAttributeParcel.f2271b, false);
        C1033a.m3691a(parcel, 3, userAttributeParcel.f2272c);
        C1033a.m3696a(parcel, 4, userAttributeParcel.f2273d, false);
        C1033a.m3695a(parcel, 5, userAttributeParcel.f2274e, false);
        C1033a.m3697a(parcel, 6, userAttributeParcel.f2275f, false);
        C1033a.m3697a(parcel, 7, userAttributeParcel.f2276g, false);
        C1033a.m3689a(parcel, a);
    }

    public UserAttributeParcel m4207a(Parcel parcel) {
        String str = null;
        int b = zza.m3711b(parcel);
        int i = 0;
        long j = 0;
        String str2 = null;
        Float f = null;
        Long l = null;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int a = zza.m3706a(parcel);
            switch (zza.m3705a(a)) {
                case 1:
                    i = zza.m3715d(parcel, a);
                    break;
                case 2:
                    str3 = zza.m3719h(parcel, a);
                    break;
                case 3:
                    j = zza.m3716e(parcel, a);
                    break;
                case 4:
                    l = zza.m3717f(parcel, a);
                    break;
                case 5:
                    f = zza.m3718g(parcel, a);
                    break;
                case 6:
                    str2 = zza.m3719h(parcel, a);
                    break;
                case 7:
                    str = zza.m3719h(parcel, a);
                    break;
                default:
                    zza.m3712b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new UserAttributeParcel(i, str3, j, l, f, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public UserAttributeParcel[] m4208a(int i) {
        return new UserAttributeParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4207a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4208a(i);
    }
}
