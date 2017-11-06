package com.google.android.gms.internal;

import com.google.android.gms.common.api.C0737a;
import com.google.android.gms.common.api.C0737a.C0733a;
import com.google.android.gms.common.api.C0737a.C0734b;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.p023a.p024a.C0728a;

public final class C1089k {
    public static final C0734b<Object> f2193a = new C0734b();
    public static final C0734b<Object> f2194b = new C0734b();
    public static final C0733a<Object, C1092m> f2195c = new C10871();
    static final C0733a<Object, Object> f2196d = new C10882();
    public static final Scope f2197e = new Scope("profile");
    public static final Scope f2198f = new Scope("email");
    public static final C0737a<C1092m> f2199g = new C0737a("SignIn.API", f2195c, f2193a);
    public static final C0737a<Object> f2200h = new C0737a("SignIn.INTERNAL_API", f2196d, f2194b);
    public static final C0727l f2201i = new C0728a();

    static class C10871 extends C0733a<Object, C1092m> {
        C10871() {
        }
    }

    static class C10882 extends C0733a<Object, Object> {
        C10882() {
        }
    }
}
