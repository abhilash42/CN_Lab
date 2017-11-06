package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public class C1033a {
    public static int m3688a(Parcel parcel) {
        return C1033a.m3702b(parcel, 20293);
    }

    public static void m3689a(Parcel parcel, int i) {
        C1033a.m3704c(parcel, i);
    }

    public static void m3690a(Parcel parcel, int i, int i2) {
        C1033a.m3703b(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void m3691a(Parcel parcel, int i, long j) {
        C1033a.m3703b(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void m3692a(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle != null) {
            int b = C1033a.m3702b(parcel, i);
            parcel.writeBundle(bundle);
            C1033a.m3704c(parcel, b);
        } else if (z) {
            C1033a.m3703b(parcel, i, 0);
        }
    }

    public static void m3693a(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int b = C1033a.m3702b(parcel, i);
            parcel.writeStrongBinder(iBinder);
            C1033a.m3704c(parcel, b);
        } else if (z) {
            C1033a.m3703b(parcel, i, 0);
        }
    }

    public static void m3694a(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int b = C1033a.m3702b(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            C1033a.m3704c(parcel, b);
        } else if (z) {
            C1033a.m3703b(parcel, i, 0);
        }
    }

    public static void m3695a(Parcel parcel, int i, Float f, boolean z) {
        if (f != null) {
            C1033a.m3703b(parcel, i, 4);
            parcel.writeFloat(f.floatValue());
        } else if (z) {
            C1033a.m3703b(parcel, i, 0);
        }
    }

    public static void m3696a(Parcel parcel, int i, Long l, boolean z) {
        if (l != null) {
            C1033a.m3703b(parcel, i, 8);
            parcel.writeLong(l.longValue());
        } else if (z) {
            C1033a.m3703b(parcel, i, 0);
        }
    }

    public static void m3697a(Parcel parcel, int i, String str, boolean z) {
        if (str != null) {
            int b = C1033a.m3702b(parcel, i);
            parcel.writeString(str);
            C1033a.m3704c(parcel, b);
        } else if (z) {
            C1033a.m3703b(parcel, i, 0);
        }
    }

    public static void m3698a(Parcel parcel, int i, boolean z) {
        C1033a.m3703b(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static <T extends Parcelable> void m3699a(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr != null) {
            int b = C1033a.m3702b(parcel, i);
            parcel.writeInt(r3);
            for (Parcelable parcelable : tArr) {
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    C1033a.m3701a(parcel, parcelable, i2);
                }
            }
            C1033a.m3704c(parcel, b);
        } else if (z) {
            C1033a.m3703b(parcel, i, 0);
        }
    }

    public static void m3700a(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr != null) {
            int b = C1033a.m3702b(parcel, i);
            parcel.writeStringArray(strArr);
            C1033a.m3704c(parcel, b);
        } else if (z) {
            C1033a.m3703b(parcel, i, 0);
        }
    }

    private static <T extends Parcelable> void m3701a(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    private static int m3702b(Parcel parcel, int i) {
        parcel.writeInt(-65536 | i);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void m3703b(Parcel parcel, int i, int i2) {
        if (i2 >= 65535) {
            parcel.writeInt(-65536 | i);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt((i2 << 16) | i);
    }

    private static void m3704c(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        int i2 = dataPosition - i;
        parcel.setDataPosition(i - 4);
        parcel.writeInt(i2);
        parcel.setDataPosition(dataPosition);
    }
}
