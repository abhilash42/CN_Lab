package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class zza {

    public static class zza extends RuntimeException {
        public zza(String str, Parcel parcel) {
            super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        }
    }

    public static int m3705a(int i) {
        return 65535 & i;
    }

    public static int m3706a(Parcel parcel) {
        return parcel.readInt();
    }

    public static int m3707a(Parcel parcel, int i) {
        return (i & -65536) != -65536 ? (i >> 16) & 65535 : parcel.readInt();
    }

    public static <T extends Parcelable> T m3708a(Parcel parcel, int i, Creator<T> creator) {
        int a = m3707a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(a + dataPosition);
        return parcelable;
    }

    private static void m3709a(Parcel parcel, int i, int i2) {
        int a = m3707a(parcel, i);
        if (a != i2) {
            throw new zza("Expected size " + i2 + " got " + a + " (0x" + Integer.toHexString(a) + ")", parcel);
        }
    }

    private static void m3710a(Parcel parcel, int i, int i2, int i3) {
        if (i2 != i3) {
            throw new zza("Expected size " + i3 + " got " + i2 + " (0x" + Integer.toHexString(i2) + ")", parcel);
        }
    }

    public static int m3711b(Parcel parcel) {
        int a = m3706a(parcel);
        int a2 = m3707a(parcel, a);
        int dataPosition = parcel.dataPosition();
        if (m3705a(a) != 20293) {
            throw new zza("Expected object header. Got 0x" + Integer.toHexString(a), parcel);
        }
        a = dataPosition + a2;
        if (a >= dataPosition && a <= parcel.dataSize()) {
            return a;
        }
        throw new zza("Size read is invalid start=" + dataPosition + " end=" + a, parcel);
    }

    public static void m3712b(Parcel parcel, int i) {
        parcel.setDataPosition(m3707a(parcel, i) + parcel.dataPosition());
    }

    public static <T> T[] m3713b(Parcel parcel, int i, Creator<T> creator) {
        int a = m3707a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        T[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArray;
    }

    public static boolean m3714c(Parcel parcel, int i) {
        m3709a(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static int m3715d(Parcel parcel, int i) {
        m3709a(parcel, i, 4);
        return parcel.readInt();
    }

    public static long m3716e(Parcel parcel, int i) {
        m3709a(parcel, i, 8);
        return parcel.readLong();
    }

    public static Long m3717f(Parcel parcel, int i) {
        int a = m3707a(parcel, i);
        if (a == 0) {
            return null;
        }
        m3710a(parcel, i, a, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static Float m3718g(Parcel parcel, int i) {
        int a = m3707a(parcel, i);
        if (a == 0) {
            return null;
        }
        m3710a(parcel, i, a, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static String m3719h(Parcel parcel, int i) {
        int a = m3707a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(a + dataPosition);
        return readString;
    }

    public static IBinder m3720i(Parcel parcel, int i) {
        int a = m3707a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(a + dataPosition);
        return readStrongBinder;
    }

    public static Bundle m3721j(Parcel parcel, int i) {
        int a = m3707a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(a + dataPosition);
        return readBundle;
    }

    public static String[] m3722k(Parcel parcel, int i) {
        int a = m3707a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(a + dataPosition);
        return createStringArray;
    }
}
