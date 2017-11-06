package org.npci.upi.security.services;

import android.os.IBinder;
import android.os.Parcel;

class C1644c implements C1636a {
    private IBinder f4486a;

    C1644c(IBinder iBinder) {
        this.f4486a = iBinder;
    }

    public String mo905a(String str, String str2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.npci.upi.security.services.CLRemoteService");
            obtain.writeString(str);
            obtain.writeString(str2);
            this.f4486a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo906a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, C1640d c1640d) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.npci.upi.security.services.CLRemoteService");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeString(str3);
            obtain.writeString(str4);
            obtain.writeString(str5);
            obtain.writeString(str6);
            obtain.writeString(str7);
            obtain.writeString(str8);
            obtain.writeStrongBinder(c1640d != null ? c1640d.asBinder() : null);
            this.f4486a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public boolean mo907a(String str, String str2, String str3, String str4) {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.npci.upi.security.services.CLRemoteService");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeString(str3);
            obtain.writeString(str4);
            this.f4486a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            obtain2.recycle();
            obtain.recycle();
            return z;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f4486a;
    }
}
