package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.C1032p;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Iterator;

public class EventParams implements SafeParcelable, Iterable<String> {
    public static final C1135n CREATOR = new C1135n();
    public final int f2263a;
    private final Bundle f2264b;

    class C11021 implements Iterator<String> {
        Iterator<String> f2261a = this.f2262b.f2264b.keySet().iterator();
        final /* synthetic */ EventParams f2262b;

        C11021(EventParams eventParams) {
            this.f2262b = eventParams;
        }

        public String m4064a() {
            return (String) this.f2261a.next();
        }

        public boolean hasNext() {
            return this.f2261a.hasNext();
        }

        public /* synthetic */ Object next() {
            return m4064a();
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove not supported");
        }
    }

    EventParams(int i, Bundle bundle) {
        this.f2263a = i;
        this.f2264b = bundle;
    }

    EventParams(Bundle bundle) {
        C1032p.m3678a((Object) bundle);
        this.f2264b = bundle;
        this.f2263a = 1;
    }

    public int m4066a() {
        return this.f2264b.size();
    }

    Object m4067a(String str) {
        return this.f2264b.get(str);
    }

    public Bundle m4068b() {
        return new Bundle(this.f2264b);
    }

    public int describeContents() {
        return 0;
    }

    public Iterator<String> iterator() {
        return new C11021(this);
    }

    public String toString() {
        return this.f2264b.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1135n.m4339a(this, parcel, i);
    }
}
