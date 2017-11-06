package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1033a;
import com.google.android.gms.common.internal.safeparcel.zza;

public class C1035a implements Creator<ConnectionEvent> {
    static void m3739a(ConnectionEvent connectionEvent, Parcel parcel, int i) {
        int a = C1033a.m3688a(parcel);
        C1033a.m3690a(parcel, 1, connectionEvent.f2027a);
        C1033a.m3691a(parcel, 2, connectionEvent.mo718a());
        C1033a.m3697a(parcel, 4, connectionEvent.m3729c(), false);
        C1033a.m3697a(parcel, 5, connectionEvent.m3730d(), false);
        C1033a.m3697a(parcel, 6, connectionEvent.m3731e(), false);
        C1033a.m3697a(parcel, 7, connectionEvent.m3732f(), false);
        C1033a.m3697a(parcel, 8, connectionEvent.m3733g(), false);
        C1033a.m3691a(parcel, 10, connectionEvent.m3737k());
        C1033a.m3691a(parcel, 11, connectionEvent.m3736j());
        C1033a.m3690a(parcel, 12, connectionEvent.mo719b());
        C1033a.m3697a(parcel, 13, connectionEvent.m3734h(), false);
        C1033a.m3689a(parcel, a);
    }

    public ConnectionEvent m3740a(Parcel parcel) {
        int b = zza.m3711b(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        long j2 = 0;
        long j3 = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.m3706a(parcel);
            switch (zza.m3705a(a)) {
                case 1:
                    i = zza.m3715d(parcel, a);
                    break;
                case 2:
                    j = zza.m3716e(parcel, a);
                    break;
                case 4:
                    str = zza.m3719h(parcel, a);
                    break;
                case 5:
                    str2 = zza.m3719h(parcel, a);
                    break;
                case 6:
                    str3 = zza.m3719h(parcel, a);
                    break;
                case 7:
                    str4 = zza.m3719h(parcel, a);
                    break;
                case 8:
                    str5 = zza.m3719h(parcel, a);
                    break;
                case 10:
                    j2 = zza.m3716e(parcel, a);
                    break;
                case 11:
                    j3 = zza.m3716e(parcel, a);
                    break;
                case 12:
                    i2 = zza.m3715d(parcel, a);
                    break;
                case 13:
                    str6 = zza.m3719h(parcel, a);
                    break;
                default:
                    zza.m3712b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ConnectionEvent(i, j, i2, str, str2, str3, str4, str5, str6, j2, j3);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public ConnectionEvent[] m3741a(int i) {
        return new ConnectionEvent[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3740a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3741a(i);
    }
}
