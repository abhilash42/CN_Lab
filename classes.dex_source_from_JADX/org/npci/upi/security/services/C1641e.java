package org.npci.upi.security.services;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class C1641e extends Binder implements C1640d {
    public C1641e() {
        attachInterface(this, "org.npci.upi.security.services.CLResultReceiver");
    }

    public static C1640d m6636a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("org.npci.upi.security.services.CLResultReceiver");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof C1640d)) ? new C1645f(iBinder) : (C1640d) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        Bundle bundle = null;
        switch (i) {
            case 1:
                parcel.enforceInterface("org.npci.upi.security.services.CLResultReceiver");
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                mo908a(bundle);
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("org.npci.upi.security.services.CLResultReceiver");
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                mo909b(bundle);
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("org.npci.upi.security.services.CLResultReceiver");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
