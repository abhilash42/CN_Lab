package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface C1139q extends IInterface {

    public static abstract class C1141a extends Binder implements C1139q {

        private static class C1140a implements C1139q {
            private IBinder f2395a;

            C1140a(IBinder iBinder) {
                this.f2395a = iBinder;
            }

            public void mo750a(AppMetadata appMetadata) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (appMetadata != null) {
                        obtain.writeInt(1);
                        appMetadata.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2395a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo751a(EventParcel eventParcel, AppMetadata appMetadata) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (eventParcel != null) {
                        obtain.writeInt(1);
                        eventParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (appMetadata != null) {
                        obtain.writeInt(1);
                        appMetadata.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2395a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo752a(EventParcel eventParcel, String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (eventParcel != null) {
                        obtain.writeInt(1);
                        eventParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f2395a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo753a(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (userAttributeParcel != null) {
                        obtain.writeInt(1);
                        userAttributeParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (appMetadata != null) {
                        obtain.writeInt(1);
                        appMetadata.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2395a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f2395a;
            }

            public void mo754b(AppMetadata appMetadata) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (appMetadata != null) {
                        obtain.writeInt(1);
                        appMetadata.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2395a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C1141a() {
            attachInterface(this, "com.google.android.gms.measurement.internal.IMeasurementService");
        }

        public static C1139q m4364a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1139q)) ? new C1140a(iBinder) : (C1139q) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            AppMetadata appMetadata = null;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    EventParcel a = parcel.readInt() != 0 ? EventParcel.CREATOR.m4343a(parcel) : null;
                    if (parcel.readInt() != 0) {
                        appMetadata = AppMetadata.CREATOR.m4242a(parcel);
                    }
                    mo751a(a, appMetadata);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    UserAttributeParcel a2 = parcel.readInt() != 0 ? UserAttributeParcel.CREATOR.m4207a(parcel) : null;
                    if (parcel.readInt() != 0) {
                        appMetadata = AppMetadata.CREATOR.m4242a(parcel);
                    }
                    mo753a(a2, appMetadata);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (parcel.readInt() != 0) {
                        appMetadata = AppMetadata.CREATOR.m4242a(parcel);
                    }
                    mo750a(appMetadata);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    EventParcel a3;
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (parcel.readInt() != 0) {
                        a3 = EventParcel.CREATOR.m4343a(parcel);
                    }
                    mo752a(a3, parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (parcel.readInt() != 0) {
                        appMetadata = AppMetadata.CREATOR.m4242a(parcel);
                    }
                    mo754b(appMetadata);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.measurement.internal.IMeasurementService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void mo750a(AppMetadata appMetadata);

    void mo751a(EventParcel eventParcel, AppMetadata appMetadata);

    void mo752a(EventParcel eventParcel, String str, String str2);

    void mo753a(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata);

    void mo754b(AppMetadata appMetadata);
}
