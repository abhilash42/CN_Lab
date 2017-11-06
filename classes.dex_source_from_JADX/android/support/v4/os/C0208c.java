package android.support.v4.os;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ParcelableCompat */
public final class C0208c {

    /* compiled from: ParcelableCompat */
    static class C0207a<T> implements Creator<T> {
        final C0209d<T> f505a;

        public C0207a(C0209d<T> c0209d) {
            this.f505a = c0209d;
        }

        public T createFromParcel(Parcel parcel) {
            return this.f505a.mo123a(parcel, null);
        }

        public T[] newArray(int i) {
            return this.f505a.mo124a(i);
        }
    }

    public static <T> Creator<T> m820a(C0209d<T> c0209d) {
        if (VERSION.SDK_INT >= 13) {
            return C0211f.m823a(c0209d);
        }
        return new C0207a(c0209d);
    }
}
