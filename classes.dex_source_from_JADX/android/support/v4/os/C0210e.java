package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

/* compiled from: ParcelableCompatHoneycombMR2 */
class C0210e<T> implements ClassLoaderCreator<T> {
    private final C0209d<T> f506a;

    public C0210e(C0209d<T> c0209d) {
        this.f506a = c0209d;
    }

    public T createFromParcel(Parcel parcel) {
        return this.f506a.mo123a(parcel, null);
    }

    public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.f506a.mo123a(parcel, classLoader);
    }

    public T[] newArray(int i) {
        return this.f506a.mo124a(i);
    }
}
