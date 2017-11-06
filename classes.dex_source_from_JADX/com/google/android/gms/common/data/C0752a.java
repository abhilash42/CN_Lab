package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1033a;
import com.google.android.gms.common.internal.safeparcel.zza;

public class C0752a implements Creator<DataHolder> {
    static void m3222a(DataHolder dataHolder, Parcel parcel, int i) {
        int a = C1033a.m3688a(parcel);
        C1033a.m3700a(parcel, 1, dataHolder.m3216c(), false);
        C1033a.m3690a(parcel, 1000, dataHolder.m3215b());
        C1033a.m3699a(parcel, 2, dataHolder.m3217d(), i, false);
        C1033a.m3690a(parcel, 3, dataHolder.m3218e());
        C1033a.m3692a(parcel, 4, dataHolder.m3219f(), false);
        C1033a.m3689a(parcel, a);
    }

    public DataHolder m3223a(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int b = zza.m3711b(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.m3706a(parcel);
            switch (zza.m3705a(a)) {
                case 1:
                    strArr = zza.m3722k(parcel, a);
                    break;
                case 2:
                    cursorWindowArr = (CursorWindow[]) zza.m3713b(parcel, a, CursorWindow.CREATOR);
                    break;
                case 3:
                    i = zza.m3715d(parcel, a);
                    break;
                case 4:
                    bundle = zza.m3721j(parcel, a);
                    break;
                case 1000:
                    i2 = zza.m3715d(parcel, a);
                    break;
                default:
                    zza.m3712b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.zza("Overread allowed size end=" + b, parcel);
        }
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i, bundle);
        dataHolder.m3214a();
        return dataHolder;
    }

    public DataHolder[] m3224a(int i) {
        return new DataHolder[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3223a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3224a(i);
    }
}
