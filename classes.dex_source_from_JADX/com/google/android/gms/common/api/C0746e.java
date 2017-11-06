package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1033a;
import com.google.android.gms.common.internal.safeparcel.zza;

public class C0746e implements Creator<Status> {
    static void m3199a(Status status, Parcel parcel, int i) {
        int a = C1033a.m3688a(parcel);
        C1033a.m3690a(parcel, 1, status.m3188e());
        C1033a.m3690a(parcel, 1000, status.m3186c());
        C1033a.m3697a(parcel, 2, status.m3185b(), false);
        C1033a.m3694a(parcel, 3, status.m3184a(), i, false);
        C1033a.m3689a(parcel, a);
    }

    public Status m3200a(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int i = 0;
        int b = zza.m3711b(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.m3706a(parcel);
            switch (zza.m3705a(a)) {
                case 1:
                    i = zza.m3715d(parcel, a);
                    break;
                case 2:
                    str = zza.m3719h(parcel, a);
                    break;
                case 3:
                    pendingIntent = (PendingIntent) zza.m3708a(parcel, a, PendingIntent.CREATOR);
                    break;
                case 1000:
                    i2 = zza.m3715d(parcel, a);
                    break;
                default:
                    zza.m3712b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new Status(i2, i, str, pendingIntent);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Status[] m3201a(int i) {
        return new Status[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3200a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3201a(i);
    }
}
