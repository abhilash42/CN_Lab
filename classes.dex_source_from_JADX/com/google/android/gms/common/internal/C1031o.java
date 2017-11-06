package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class C1031o {

    public static final class C1030a {
        private final List<String> f2025a;
        private final Object f2026b;

        private C1030a(Object obj) {
            this.f2026b = C1032p.m3678a(obj);
            this.f2025a = new ArrayList();
        }

        public C1030a m3674a(String str, Object obj) {
            this.f2025a.add(((String) C1032p.m3678a((Object) str)) + "=" + String.valueOf(obj));
            return this;
        }

        public String toString() {
            StringBuilder append = new StringBuilder(100).append(this.f2026b.getClass().getSimpleName()).append('{');
            int size = this.f2025a.size();
            for (int i = 0; i < size; i++) {
                append.append((String) this.f2025a.get(i));
                if (i < size - 1) {
                    append.append(", ");
                }
            }
            return append.append('}').toString();
        }
    }

    public static int m3675a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static C1030a m3676a(Object obj) {
        return new C1030a(obj);
    }

    public static boolean m3677a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
