package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.C0104g.C0101a;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

/* compiled from: BackStackRecord */
final class BackStackState implements Parcelable {
    public static final Creator<BackStackState> CREATOR = new C00431();
    final int[] f113a;
    final int f114b;
    final int f115c;
    final String f116d;
    final int f117e;
    final int f118f;
    final CharSequence f119g;
    final int f120h;
    final CharSequence f121i;
    final ArrayList<String> f122j;
    final ArrayList<String> f123k;

    /* compiled from: BackStackRecord */
    static class C00431 implements Creator<BackStackState> {
        C00431() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m116a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m117a(i);
        }

        public BackStackState m116a(Parcel parcel) {
            return new BackStackState(parcel);
        }

        public BackStackState[] m117a(int i) {
            return new BackStackState[i];
        }
    }

    public BackStackState(C0104g c0104g) {
        int i = 0;
        for (C0101a c0101a = c0104g.f288c; c0101a != null; c0101a = c0101a.f272a) {
            if (c0101a.f280i != null) {
                i += c0101a.f280i.size();
            }
        }
        this.f113a = new int[(i + (c0104g.f290e * 7))];
        if (c0104g.f297l) {
            i = 0;
            for (C0101a c0101a2 = c0104g.f288c; c0101a2 != null; c0101a2 = c0101a2.f272a) {
                int i2 = i + 1;
                this.f113a[i] = c0101a2.f274c;
                int i3 = i2 + 1;
                this.f113a[i2] = c0101a2.f275d != null ? c0101a2.f275d.f158p : -1;
                int i4 = i3 + 1;
                this.f113a[i3] = c0101a2.f276e;
                i2 = i4 + 1;
                this.f113a[i4] = c0101a2.f277f;
                i4 = i2 + 1;
                this.f113a[i2] = c0101a2.f278g;
                i2 = i4 + 1;
                this.f113a[i4] = c0101a2.f279h;
                if (c0101a2.f280i != null) {
                    int size = c0101a2.f280i.size();
                    i4 = i2 + 1;
                    this.f113a[i2] = size;
                    i2 = 0;
                    while (i2 < size) {
                        i3 = i4 + 1;
                        this.f113a[i4] = ((Fragment) c0101a2.f280i.get(i2)).f158p;
                        i2++;
                        i4 = i3;
                    }
                    i = i4;
                } else {
                    i = i2 + 1;
                    this.f113a[i2] = 0;
                }
            }
            this.f114b = c0104g.f295j;
            this.f115c = c0104g.f296k;
            this.f116d = c0104g.f299n;
            this.f117e = c0104g.f301p;
            this.f118f = c0104g.f302q;
            this.f119g = c0104g.f303r;
            this.f120h = c0104g.f304s;
            this.f121i = c0104g.f305t;
            this.f122j = c0104g.f306u;
            this.f123k = c0104g.f307v;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public BackStackState(Parcel parcel) {
        this.f113a = parcel.createIntArray();
        this.f114b = parcel.readInt();
        this.f115c = parcel.readInt();
        this.f116d = parcel.readString();
        this.f117e = parcel.readInt();
        this.f118f = parcel.readInt();
        this.f119g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f120h = parcel.readInt();
        this.f121i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f122j = parcel.createStringArrayList();
        this.f123k = parcel.createStringArrayList();
    }

    public C0104g m118a(C0125q c0125q) {
        C0104g c0104g = new C0104g(c0125q);
        int i = 0;
        int i2 = 0;
        while (i2 < this.f113a.length) {
            C0101a c0101a = new C0101a();
            int i3 = i2 + 1;
            c0101a.f274c = this.f113a[i2];
            if (C0125q.f361a) {
                Log.v("FragmentManager", "Instantiate " + c0104g + " op #" + i + " base fragment #" + this.f113a[i3]);
            }
            int i4 = i3 + 1;
            i2 = this.f113a[i3];
            if (i2 >= 0) {
                c0101a.f275d = (Fragment) c0125q.f367f.get(i2);
            } else {
                c0101a.f275d = null;
            }
            i3 = i4 + 1;
            c0101a.f276e = this.f113a[i4];
            i4 = i3 + 1;
            c0101a.f277f = this.f113a[i3];
            i3 = i4 + 1;
            c0101a.f278g = this.f113a[i4];
            int i5 = i3 + 1;
            c0101a.f279h = this.f113a[i3];
            i4 = i5 + 1;
            int i6 = this.f113a[i5];
            if (i6 > 0) {
                c0101a.f280i = new ArrayList(i6);
                i3 = 0;
                while (i3 < i6) {
                    if (C0125q.f361a) {
                        Log.v("FragmentManager", "Instantiate " + c0104g + " set remove fragment #" + this.f113a[i4]);
                    }
                    i5 = i4 + 1;
                    c0101a.f280i.add((Fragment) c0125q.f367f.get(this.f113a[i4]));
                    i3++;
                    i4 = i5;
                }
            }
            c0104g.f291f = c0101a.f276e;
            c0104g.f292g = c0101a.f277f;
            c0104g.f293h = c0101a.f278g;
            c0104g.f294i = c0101a.f279h;
            c0104g.m359a(c0101a);
            i++;
            i2 = i4;
        }
        c0104g.f295j = this.f114b;
        c0104g.f296k = this.f115c;
        c0104g.f299n = this.f116d;
        c0104g.f301p = this.f117e;
        c0104g.f297l = true;
        c0104g.f302q = this.f118f;
        c0104g.f303r = this.f119g;
        c0104g.f304s = this.f120h;
        c0104g.f305t = this.f121i;
        c0104g.f306u = this.f122j;
        c0104g.f307v = this.f123k;
        c0104g.m358a(1);
        return c0104g;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f113a);
        parcel.writeInt(this.f114b);
        parcel.writeInt(this.f115c);
        parcel.writeString(this.f116d);
        parcel.writeInt(this.f117e);
        parcel.writeInt(this.f118f);
        TextUtils.writeToParcel(this.f119g, parcel, 0);
        parcel.writeInt(this.f120h);
        TextUtils.writeToParcel(this.f121i, parcel, 0);
        parcel.writeStringList(this.f122j);
        parcel.writeStringList(this.f123k);
    }
}
