package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.C1032p;

public final class C0737a<O> {
    private final C0733a<?, O> f1770a;
    private final C0735c<?, O> f1771b = null;
    private final C0734b<?> f1772c;
    private final C0736d<?> f1773d;
    private final String f1774e;

    public static abstract class C0733a<T, O> {
    }

    public static final class C0734b<C> {
    }

    public interface C0735c<T, O> {
    }

    public static final class C0736d<C> {
    }

    public <C> C0737a(String str, C0733a<C, O> c0733a, C0734b<C> c0734b) {
        C1032p.m3679a((Object) c0733a, (Object) "Cannot construct an Api with a null ClientBuilder");
        C1032p.m3679a((Object) c0734b, (Object) "Cannot construct an Api with a null ClientKey");
        this.f1774e = str;
        this.f1770a = c0733a;
        this.f1772c = c0734b;
        this.f1773d = null;
    }
}
