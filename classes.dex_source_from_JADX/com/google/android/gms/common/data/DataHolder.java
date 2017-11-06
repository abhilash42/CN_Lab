package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.C1032p;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;

public final class DataHolder implements SafeParcelable {
    public static final C0752a CREATOR = new C0752a();
    private static final C0750a f1803l = new C0750a(new String[0], null) {
    };
    Bundle f1804a;
    int[] f1805b;
    int f1806c;
    boolean f1807d = false;
    private final int f1808e;
    private final String[] f1809f;
    private final CursorWindow[] f1810g;
    private final int f1811h;
    private final Bundle f1812i;
    private Object f1813j;
    private boolean f1814k = true;

    public static class C0750a {
        private final String[] f1797a;
        private final ArrayList<HashMap<String, Object>> f1798b;
        private final String f1799c;
        private final HashMap<Object, Integer> f1800d;
        private boolean f1801e;
        private String f1802f;

        private C0750a(String[] strArr, String str) {
            this.f1797a = (String[]) C1032p.m3678a((Object) strArr);
            this.f1798b = new ArrayList();
            this.f1799c = str;
            this.f1800d = new HashMap();
            this.f1801e = false;
            this.f1802f = null;
        }
    }

    public static class zzb extends RuntimeException {
    }

    DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.f1808e = i;
        this.f1809f = strArr;
        this.f1810g = cursorWindowArr;
        this.f1811h = i2;
        this.f1812i = bundle;
    }

    public void m3214a() {
        int i;
        int i2 = 0;
        this.f1804a = new Bundle();
        for (i = 0; i < this.f1809f.length; i++) {
            this.f1804a.putInt(this.f1809f[i], i);
        }
        this.f1805b = new int[this.f1810g.length];
        i = 0;
        while (i2 < this.f1810g.length) {
            this.f1805b[i2] = i;
            i += this.f1810g[i2].getNumRows() - (i - this.f1810g[i2].getStartPosition());
            i2++;
        }
        this.f1806c = i;
    }

    int m3215b() {
        return this.f1808e;
    }

    String[] m3216c() {
        return this.f1809f;
    }

    CursorWindow[] m3217d() {
        return this.f1810g;
    }

    public int describeContents() {
        return 0;
    }

    public int m3218e() {
        return this.f1811h;
    }

    public Bundle m3219f() {
        return this.f1812i;
    }

    protected void finalize() {
        try {
            if (this.f1814k && this.f1810g.length > 0 && !m3220g()) {
                Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (" + (this.f1813j == null ? "internal object: " + toString() : this.f1813j.toString()) + ")");
                m3221h();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public boolean m3220g() {
        boolean z;
        synchronized (this) {
            z = this.f1807d;
        }
        return z;
    }

    public void m3221h() {
        synchronized (this) {
            if (!this.f1807d) {
                this.f1807d = true;
                for (CursorWindow close : this.f1810g) {
                    close.close();
                }
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0752a.m3222a(this, parcel, i);
    }
}
