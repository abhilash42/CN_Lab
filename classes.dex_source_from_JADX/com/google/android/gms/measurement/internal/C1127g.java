package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1033a;
import com.google.android.gms.common.internal.safeparcel.zza;

public class C1127g implements Creator<AppMetadata> {
    static void m4241a(AppMetadata appMetadata, Parcel parcel, int i) {
        int a = C1033a.m3688a(parcel);
        C1033a.m3690a(parcel, 1, appMetadata.f2252a);
        C1033a.m3697a(parcel, 2, appMetadata.f2253b, false);
        C1033a.m3697a(parcel, 3, appMetadata.f2254c, false);
        C1033a.m3697a(parcel, 4, appMetadata.f2255d, false);
        C1033a.m3697a(parcel, 5, appMetadata.f2256e, false);
        C1033a.m3691a(parcel, 6, appMetadata.f2257f);
        C1033a.m3691a(parcel, 7, appMetadata.f2258g);
        C1033a.m3697a(parcel, 8, appMetadata.f2259h, false);
        C1033a.m3698a(parcel, 9, appMetadata.f2260i);
        C1033a.m3689a(parcel, a);
    }

    public AppMetadata m4242a(Parcel parcel) {
        long j = 0;
        boolean z = false;
        String str = null;
        int b = zza.m3711b(parcel);
        long j2 = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.m3706a(parcel);
            switch (zza.m3705a(a)) {
                case 1:
                    i = zza.m3715d(parcel, a);
                    break;
                case 2:
                    str5 = zza.m3719h(parcel, a);
                    break;
                case 3:
                    str4 = zza.m3719h(parcel, a);
                    break;
                case 4:
                    str3 = zza.m3719h(parcel, a);
                    break;
                case 5:
                    str2 = zza.m3719h(parcel, a);
                    break;
                case 6:
                    j2 = zza.m3716e(parcel, a);
                    break;
                case 7:
                    j = zza.m3716e(parcel, a);
                    break;
                case 8:
                    str = zza.m3719h(parcel, a);
                    break;
                case 9:
                    z = zza.m3714c(parcel, a);
                    break;
                default:
                    zza.m3712b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AppMetadata(i, str5, str4, str3, str2, j2, j, str, z);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public AppMetadata[] m4243a(int i) {
        return new AppMetadata[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4242a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4243a(i);
    }
}
