package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.p009e.C0189a;
import android.view.View;
import com.google.android.gms.common.C0747b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0737a.C0733a;
import com.google.android.gms.common.internal.C1002d;
import com.google.android.gms.common.internal.C1002d.C1001a;
import com.google.android.gms.common.internal.C1032p;
import com.google.android.gms.internal.C1089k;
import com.google.android.gms.internal.C1092m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public abstract class C0744c {
    private static final Set<C0744c> f1792a = Collections.newSetFromMap(new WeakHashMap());

    public static final class C0739a {
        private Account f1775a;
        private final Set<Scope> f1776b = new HashSet();
        private final Set<Scope> f1777c = new HashSet();
        private int f1778d;
        private View f1779e;
        private String f1780f;
        private String f1781g;
        private final Map<C0737a<?>, C1001a> f1782h = new C0189a();
        private final Context f1783i;
        private final Map<C0737a<?>, Object> f1784j = new C0189a();
        private int f1785k = -1;
        private Looper f1786l;
        private C0747b f1787m = C0747b.m3202a();
        private C0733a<? extends Object, C1092m> f1788n = C1089k.f2195c;
        private final ArrayList<C0740b> f1789o = new ArrayList();
        private final ArrayList<C0741c> f1790p = new ArrayList();
        private C1092m f1791q;

        public C0739a(Context context) {
            this.f1783i = context;
            this.f1786l = context.getMainLooper();
            this.f1780f = context.getPackageName();
            this.f1781g = context.getClass().getName();
        }

        public C1002d m3190a() {
            if (this.f1784j.containsKey(C1089k.f2199g)) {
                C1032p.m3683a(this.f1791q == null, (Object) "SignIn.API can't be used in conjunction with requestServerAuthCode.");
                this.f1791q = (C1092m) this.f1784j.get(C1089k.f2199g);
            }
            return new C1002d(this.f1775a, this.f1776b, this.f1782h, this.f1778d, this.f1779e, this.f1780f, this.f1781g, this.f1791q != null ? this.f1791q : C1092m.f2209a);
        }
    }

    public interface C0740b {
        void mo747a(int i);

        void mo748a(Bundle bundle);
    }

    public interface C0741c {
        void mo749a(ConnectionResult connectionResult);
    }

    public interface C0742d {
    }

    public interface C0743e {
        void mo667a(ConnectionResult connectionResult);

        void mo668b(ConnectionResult connectionResult);
    }
}
