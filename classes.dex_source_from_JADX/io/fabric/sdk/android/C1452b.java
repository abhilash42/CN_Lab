package io.fabric.sdk.android;

import android.util.Log;

/* compiled from: DefaultLogger */
public class C1452b implements C1451k {
    private int f3625a;

    public C1452b(int i) {
        this.f3625a = i;
    }

    public C1452b() {
        this.f3625a = 4;
    }

    public boolean mo813a(String str, int i) {
        return this.f3625a <= i;
    }

    public void mo812a(String str, String str2, Throwable th) {
        if (mo813a(str, 3)) {
            Log.d(str, str2, th);
        }
    }

    public void m5523b(String str, String str2, Throwable th) {
        if (mo813a(str, 2)) {
            Log.v(str, str2, th);
        }
    }

    public void m5525c(String str, String str2, Throwable th) {
        if (mo813a(str, 4)) {
            Log.i(str, str2, th);
        }
    }

    public void mo817d(String str, String str2, Throwable th) {
        if (mo813a(str, 5)) {
            Log.w(str, str2, th);
        }
    }

    public void mo819e(String str, String str2, Throwable th) {
        if (mo813a(str, 6)) {
            Log.e(str, str2, th);
        }
    }

    public void mo811a(String str, String str2) {
        mo812a(str, str2, null);
    }

    public void mo814b(String str, String str2) {
        m5523b(str, str2, null);
    }

    public void mo815c(String str, String str2) {
        m5525c(str, str2, null);
    }

    public void mo816d(String str, String str2) {
        mo817d(str, str2, null);
    }

    public void mo818e(String str, String str2) {
        mo819e(str, str2, null);
    }

    public void mo809a(int i, String str, String str2) {
        mo810a(i, str, str2, false);
    }

    public void mo810a(int i, String str, String str2, boolean z) {
        if (z || mo813a(str, i)) {
            Log.println(i, str, str2);
        }
    }
}
