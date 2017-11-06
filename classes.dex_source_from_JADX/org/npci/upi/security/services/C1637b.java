package org.npci.upi.security.services;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class C1637b extends Binder implements C1636a {
    public C1637b() {
        attachInterface(this, "org.npci.upi.security.services.CLRemoteService");
    }

    public static C1636a m6625a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("org.npci.upi.security.services.CLRemoteService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof C1636a)) ? new C1644c(iBinder) : (C1636a) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("org.npci.upi.security.services.CLRemoteService");
                String a = mo905a(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case 2:
                parcel.enforceInterface("org.npci.upi.security.services.CLRemoteService");
                boolean a2 = mo907a(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(a2 ? 1 : 0);
                return true;
            case 3:
                parcel.enforceInterface("org.npci.upi.security.services.CLRemoteService");
                mo906a(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), C1641e.m6636a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("org.npci.upi.security.services.CLRemoteService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
