package com.google.android.gms.internal;

import android.os.Binder;

public abstract class C1067b<T> {
    private static final Object f2138c = new Object();
    private static C1072a f2139d = null;
    private static int f2140e = 0;
    private static String f2141f = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    protected final String f2142a;
    protected final T f2143b;
    private T f2144g = null;

    private interface C1072a {
        Boolean m3900a(String str, Boolean bool);

        Integer m3901a(String str, Integer num);

        Long m3902a(String str, Long l);

        String m3903a(String str, String str2);
    }

    protected C1067b(String str, T t) {
        this.f2142a = str;
        this.f2143b = t;
    }

    public static int m3882a() {
        return f2140e;
    }

    public static C1067b<Integer> m3883a(String str, Integer num) {
        return new C1067b<Integer>(str, num) {
            protected /* synthetic */ Object mo727a(String str) {
                return m3897b(str);
            }

            protected Integer m3897b(String str) {
                return C1067b.f2139d.m3901a(this.a, (Integer) this.b);
            }
        };
    }

    public static C1067b<Long> m3884a(String str, Long l) {
        return new C1067b<Long>(str, l) {
            protected /* synthetic */ Object mo727a(String str) {
                return m3895b(str);
            }

            protected Long m3895b(String str) {
                return C1067b.f2139d.m3902a(this.a, (Long) this.b);
            }
        };
    }

    public static C1067b<String> m3885a(String str, String str2) {
        return new C1067b<String>(str, str2) {
            protected /* synthetic */ Object mo727a(String str) {
                return m3899b(str);
            }

            protected String m3899b(String str) {
                return C1067b.f2139d.m3903a(this.a, (String) this.b);
            }
        };
    }

    public static C1067b<Boolean> m3886a(String str, boolean z) {
        return new C1067b<Boolean>(str, Boolean.valueOf(z)) {
            protected /* synthetic */ Object mo727a(String str) {
                return m3893b(str);
            }

            protected Boolean m3893b(String str) {
                return C1067b.f2139d.m3900a(this.a, (Boolean) this.b);
            }
        };
    }

    public static boolean m3887b() {
        return f2139d != null;
    }

    protected abstract T mo727a(String str);

    public final T m3890c() {
        return this.f2144g != null ? this.f2144g : mo727a(this.f2142a);
    }

    public final T m3891d() {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            T c = m3890c();
            return c;
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }
}
