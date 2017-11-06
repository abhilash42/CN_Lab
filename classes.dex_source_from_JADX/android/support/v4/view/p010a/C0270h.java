package android.support.v4.view.p010a;

import android.os.Build.VERSION;

/* compiled from: AccessibilityRecordCompat */
public class C0270h {
    private static final C0265c f544a;
    private final Object f545b;

    /* compiled from: AccessibilityRecordCompat */
    interface C0265c {
        void mo184a(Object obj, int i);

        void mo185a(Object obj, boolean z);

        void mo186b(Object obj, int i);

        void mo187c(Object obj, int i);

        void mo188d(Object obj, int i);

        void mo189e(Object obj, int i);

        void mo190f(Object obj, int i);

        void mo191g(Object obj, int i);
    }

    /* compiled from: AccessibilityRecordCompat */
    static class C0266e implements C0265c {
        C0266e() {
        }

        public void mo184a(Object obj, int i) {
        }

        public void mo186b(Object obj, int i) {
        }

        public void mo190f(Object obj, int i) {
        }

        public void mo191g(Object obj, int i) {
        }

        public void mo187c(Object obj, int i) {
        }

        public void mo188d(Object obj, int i) {
        }

        public void mo185a(Object obj, boolean z) {
        }

        public void mo189e(Object obj, int i) {
        }
    }

    /* compiled from: AccessibilityRecordCompat */
    static class C0267a extends C0266e {
        C0267a() {
        }

        public void mo184a(Object obj, int i) {
            C0271i.m1082a(obj, i);
        }

        public void mo186b(Object obj, int i) {
            C0271i.m1084b(obj, i);
        }

        public void mo187c(Object obj, int i) {
            C0271i.m1085c(obj, i);
        }

        public void mo188d(Object obj, int i) {
            C0271i.m1086d(obj, i);
        }

        public void mo185a(Object obj, boolean z) {
            C0271i.m1083a(obj, z);
        }

        public void mo189e(Object obj, int i) {
            C0271i.m1087e(obj, i);
        }
    }

    /* compiled from: AccessibilityRecordCompat */
    static class C0268b extends C0267a {
        C0268b() {
        }

        public void mo190f(Object obj, int i) {
            C0272j.m1088a(obj, i);
        }

        public void mo191g(Object obj, int i) {
            C0272j.m1089b(obj, i);
        }
    }

    /* compiled from: AccessibilityRecordCompat */
    static class C0269d extends C0268b {
        C0269d() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f544a = new C0269d();
        } else if (VERSION.SDK_INT >= 15) {
            f544a = new C0268b();
        } else if (VERSION.SDK_INT >= 14) {
            f544a = new C0267a();
        } else {
            f544a = new C0266e();
        }
    }

    public C0270h(Object obj) {
        this.f545b = obj;
    }

    public void m1075a(boolean z) {
        f544a.mo185a(this.f545b, z);
    }

    public void m1074a(int i) {
        f544a.mo186b(this.f545b, i);
    }

    public void m1076b(int i) {
        f544a.mo184a(this.f545b, i);
    }

    public void m1077c(int i) {
        f544a.mo189e(this.f545b, i);
    }

    public void m1078d(int i) {
        f544a.mo187c(this.f545b, i);
    }

    public void m1079e(int i) {
        f544a.mo188d(this.f545b, i);
    }

    public void m1080f(int i) {
        f544a.mo190f(this.f545b, i);
    }

    public void m1081g(int i) {
        f544a.mo191g(this.f545b, i);
    }

    public int hashCode() {
        return this.f545b == null ? 0 : this.f545b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        C0270h c0270h = (C0270h) obj;
        if (this.f545b == null) {
            if (c0270h.f545b != null) {
                return false;
            }
            return true;
        } else if (this.f545b.equals(c0270h.f545b)) {
            return true;
        } else {
            return false;
        }
    }
}
