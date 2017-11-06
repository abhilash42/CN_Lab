package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1033a;
import com.google.android.gms.common.internal.safeparcel.zza;

public class C0753e implements Creator<ConnectionResult> {
    static void m3225a(ConnectionResult connectionResult, Parcel parcel, int i) {
        int a = C1033a.m3688a(parcel);
        C1033a.m3690a(parcel, 1, connectionResult.f1749b);
        C1033a.m3690a(parcel, 2, connectionResult.m3178b());
        C1033a.m3694a(parcel, 3, connectionResult.m3179c(), i, false);
        C1033a.m3697a(parcel, 4, connectionResult.m3180d(), false);
        C1033a.m3689a(parcel, a);
    }

    public ConnectionResult m3226a(Parcel parcel) {
        String str = null;
        int i = 0;
        int b = zza.m3711b(parcel);
        PendingIntent pendingIntent = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            PendingIntent pendingIntent2;
            int i3;
            String str2;
            int a = zza.m3706a(parcel);
            String str3;
            switch (zza.m3705a(a)) {
                case 1:
                    str3 = str;
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = zza.m3715d(parcel, a);
                    str2 = str3;
                    break;
                case 2:
                    i = i2;
                    PendingIntent pendingIntent3 = pendingIntent;
                    i3 = zza.m3715d(parcel, a);
                    str2 = str;
                    pendingIntent2 = pendingIntent3;
                    break;
                case 3:
                    i3 = i;
                    i = i2;
                    str3 = str;
                    pendingIntent2 = (PendingIntent) zza.m3708a(parcel, a, PendingIntent.CREATOR);
                    str2 = str3;
                    break;
                case 4:
                    str2 = zza.m3719h(parcel, a);
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = i2;
                    break;
                default:
                    zza.m3712b(parcel, a);
                    str2 = str;
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = i2;
                    break;
            }
            i2 = i;
            i = i3;
            pendingIntent = pendingIntent2;
            str = str2;
        }
        if (parcel.dataPosition() == b) {
            return new ConnectionResult(i2, i, pendingIntent, str);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public ConnectionResult[] m3227a(int i) {
        return new ConnectionResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3226a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3227a(i);
    }
}
