package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

/* compiled from: Fragment */
final class FragmentState implements Parcelable {
    public static final Creator<FragmentState> CREATOR = new C00471();
    final String f172a;
    final int f173b;
    final boolean f174c;
    final int f175d;
    final int f176e;
    final String f177f;
    final boolean f178g;
    final boolean f179h;
    final Bundle f180i;
    Bundle f181j;
    Fragment f182k;

    /* compiled from: Fragment */
    static class C00471 implements Creator<FragmentState> {
        C00471() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m201a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m202a(i);
        }

        public FragmentState m201a(Parcel parcel) {
            return new FragmentState(parcel);
        }

        public FragmentState[] m202a(int i) {
            return new FragmentState[i];
        }
    }

    public FragmentState(Fragment fragment) {
        this.f172a = fragment.getClass().getName();
        this.f173b = fragment.f158p;
        this.f174c = fragment.f166x;
        this.f175d = fragment.f132F;
        this.f176e = fragment.f133G;
        this.f177f = fragment.f134H;
        this.f178g = fragment.f137K;
        this.f179h = fragment.f136J;
        this.f180i = fragment.f160r;
    }

    public FragmentState(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f172a = parcel.readString();
        this.f173b = parcel.readInt();
        this.f174c = parcel.readInt() != 0;
        this.f175d = parcel.readInt();
        this.f176e = parcel.readInt();
        this.f177f = parcel.readString();
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f178g = z;
        if (parcel.readInt() == 0) {
            z2 = false;
        }
        this.f179h = z2;
        this.f180i = parcel.readBundle();
        this.f181j = parcel.readBundle();
    }

    public Fragment m203a(C0110o c0110o, Fragment fragment) {
        if (this.f182k != null) {
            return this.f182k;
        }
        Context g = c0110o.m397g();
        if (this.f180i != null) {
            this.f180i.setClassLoader(g.getClassLoader());
        }
        this.f182k = Fragment.m124a(g, this.f172a, this.f180i);
        if (this.f181j != null) {
            this.f181j.setClassLoader(g.getClassLoader());
            this.f182k.f156n = this.f181j;
        }
        this.f182k.m141a(this.f173b, fragment);
        this.f182k.f166x = this.f174c;
        this.f182k.f168z = true;
        this.f182k.f132F = this.f175d;
        this.f182k.f133G = this.f176e;
        this.f182k.f134H = this.f177f;
        this.f182k.f137K = this.f178g;
        this.f182k.f136J = this.f179h;
        this.f182k.f128B = c0110o.f321d;
        if (C0125q.f361a) {
            Log.v("FragmentManager", "Instantiated fragment " + this.f182k);
        }
        return this.f182k;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.f172a);
        parcel.writeInt(this.f173b);
        parcel.writeInt(this.f174c ? 1 : 0);
        parcel.writeInt(this.f175d);
        parcel.writeInt(this.f176e);
        parcel.writeString(this.f177f);
        if (this.f178g) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.f179h) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeBundle(this.f180i);
        parcel.writeBundle(this.f181j);
    }
}
