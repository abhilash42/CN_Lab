package com.google.android.gms.iid;

import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.iid.C1052d.C1053a;

public class MessengerCompat implements Parcelable {
    public static final Creator<MessengerCompat> CREATOR = new C10511();
    Messenger f2098a;
    C1052d f2099b;

    static class C10511 implements Creator<MessengerCompat> {
        C10511() {
        }

        public MessengerCompat m3809a(Parcel parcel) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            return readStrongBinder != null ? new MessengerCompat(readStrongBinder) : null;
        }

        public MessengerCompat[] m3810a(int i) {
            return new MessengerCompat[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m3809a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m3810a(i);
        }
    }

    private final class C1054a extends C1053a {
        Handler f2096a;
        final /* synthetic */ MessengerCompat f2097b;

        C1054a(MessengerCompat messengerCompat, Handler handler) {
            this.f2097b = messengerCompat;
            this.f2096a = handler;
        }

        public void mo722a(Message message) {
            message.arg2 = Binder.getCallingUid();
            this.f2096a.dispatchMessage(message);
        }
    }

    public MessengerCompat(Handler handler) {
        if (VERSION.SDK_INT >= 21) {
            this.f2098a = new Messenger(handler);
        } else {
            this.f2099b = new C1054a(this, handler);
        }
    }

    public MessengerCompat(IBinder iBinder) {
        if (VERSION.SDK_INT >= 21) {
            this.f2098a = new Messenger(iBinder);
        } else {
            this.f2099b = C1053a.m3812a(iBinder);
        }
    }

    public static int m3814a(Message message) {
        return VERSION.SDK_INT >= 21 ? m3815c(message) : message.arg2;
    }

    private static int m3815c(Message message) {
        return message.sendingUid;
    }

    public IBinder m3816a() {
        return this.f2098a != null ? this.f2098a.getBinder() : this.f2099b.asBinder();
    }

    public void m3817b(Message message) {
        if (this.f2098a != null) {
            this.f2098a.send(message);
        } else {
            this.f2099b.mo722a(message);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj != null) {
            try {
                z = m3816a().equals(((MessengerCompat) obj).m3816a());
            } catch (ClassCastException e) {
            }
        }
        return z;
    }

    public int hashCode() {
        return m3816a().hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.f2098a != null) {
            parcel.writeStrongBinder(this.f2098a.getBinder());
        } else {
            parcel.writeStrongBinder(this.f2099b.asBinder());
        }
    }
}
