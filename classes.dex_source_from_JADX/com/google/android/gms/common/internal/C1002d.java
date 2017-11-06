package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.C0737a;
import com.google.android.gms.common.api.C0744c.C0739a;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.C1092m;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class C1002d {
    private final Account f1953a;
    private final Set<Scope> f1954b;
    private final Set<Scope> f1955c;
    private final Map<C0737a<?>, C1001a> f1956d;
    private final int f1957e;
    private final View f1958f;
    private final String f1959g;
    private final String f1960h;
    private final C1092m f1961i;

    public static final class C1001a {
        public final Set<Scope> f1952a;
    }

    public C1002d(Account account, Set<Scope> set, Map<C0737a<?>, C1001a> map, int i, View view, String str, String str2, C1092m c1092m) {
        Map map2;
        this.f1953a = account;
        this.f1954b = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        if (map == null) {
            map2 = Collections.EMPTY_MAP;
        }
        this.f1956d = map2;
        this.f1958f = view;
        this.f1957e = i;
        this.f1959g = str;
        this.f1960h = str2;
        this.f1961i = c1092m;
        Set hashSet = new HashSet(this.f1954b);
        for (C1001a c1001a : this.f1956d.values()) {
            hashSet.addAll(c1001a.f1952a);
        }
        this.f1955c = Collections.unmodifiableSet(hashSet);
    }

    public static C1002d m3474a(Context context) {
        return new C0739a(context).m3190a();
    }

    public Account m3475a() {
        return this.f1953a;
    }

    public Set<Scope> m3476b() {
        return this.f1955c;
    }

    public String m3477c() {
        return this.f1960h;
    }
}
