package android.support.v4.view.p010a;

import android.graphics.Rect;
import android.os.Build.VERSION;

/* compiled from: AccessibilityNodeInfoCompat */
public class C0249b {
    private static final C0240d f534a;
    private final Object f535b;

    /* compiled from: AccessibilityNodeInfoCompat */
    interface C0240d {
        int mo155a(Object obj);

        void mo156a(Object obj, int i);

        void mo157a(Object obj, Rect rect);

        void mo158a(Object obj, CharSequence charSequence);

        void mo159a(Object obj, boolean z);

        CharSequence mo160b(Object obj);

        void mo161b(Object obj, Rect rect);

        CharSequence mo162c(Object obj);

        CharSequence mo163d(Object obj);

        CharSequence mo164e(Object obj);

        boolean mo165f(Object obj);

        boolean mo166g(Object obj);

        boolean mo167h(Object obj);

        boolean mo168i(Object obj);

        boolean mo169j(Object obj);

        boolean mo170k(Object obj);

        boolean mo171l(Object obj);

        boolean mo172m(Object obj);

        boolean mo173n(Object obj);

        boolean mo174o(Object obj);

        String mo175p(Object obj);
    }

    /* compiled from: AccessibilityNodeInfoCompat */
    static class C0241i implements C0240d {
        C0241i() {
        }

        public void mo156a(Object obj, int i) {
        }

        public int mo155a(Object obj) {
            return 0;
        }

        public void mo157a(Object obj, Rect rect) {
        }

        public void mo161b(Object obj, Rect rect) {
        }

        public CharSequence mo160b(Object obj) {
            return null;
        }

        public CharSequence mo162c(Object obj) {
            return null;
        }

        public CharSequence mo163d(Object obj) {
            return null;
        }

        public CharSequence mo164e(Object obj) {
            return null;
        }

        public boolean mo165f(Object obj) {
            return false;
        }

        public boolean mo166g(Object obj) {
            return false;
        }

        public boolean mo167h(Object obj) {
            return false;
        }

        public boolean mo168i(Object obj) {
            return false;
        }

        public boolean mo169j(Object obj) {
            return false;
        }

        public boolean mo170k(Object obj) {
            return false;
        }

        public boolean mo171l(Object obj) {
            return false;
        }

        public boolean mo172m(Object obj) {
            return false;
        }

        public boolean mo173n(Object obj) {
            return false;
        }

        public boolean mo174o(Object obj) {
            return false;
        }

        public void mo158a(Object obj, CharSequence charSequence) {
        }

        public void mo159a(Object obj, boolean z) {
        }

        public String mo175p(Object obj) {
            return null;
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat */
    static class C0242c extends C0241i {
        C0242c() {
        }

        public void mo156a(Object obj, int i) {
            C0250c.m1005a(obj, i);
        }

        public int mo155a(Object obj) {
            return C0250c.m1004a(obj);
        }

        public void mo157a(Object obj, Rect rect) {
            C0250c.m1006a(obj, rect);
        }

        public void mo161b(Object obj, Rect rect) {
            C0250c.m1010b(obj, rect);
        }

        public CharSequence mo160b(Object obj) {
            return C0250c.m1009b(obj);
        }

        public CharSequence mo162c(Object obj) {
            return C0250c.m1011c(obj);
        }

        public CharSequence mo163d(Object obj) {
            return C0250c.m1012d(obj);
        }

        public CharSequence mo164e(Object obj) {
            return C0250c.m1013e(obj);
        }

        public boolean mo165f(Object obj) {
            return C0250c.m1014f(obj);
        }

        public boolean mo166g(Object obj) {
            return C0250c.m1015g(obj);
        }

        public boolean mo167h(Object obj) {
            return C0250c.m1016h(obj);
        }

        public boolean mo168i(Object obj) {
            return C0250c.m1017i(obj);
        }

        public boolean mo169j(Object obj) {
            return C0250c.m1018j(obj);
        }

        public boolean mo170k(Object obj) {
            return C0250c.m1019k(obj);
        }

        public boolean mo171l(Object obj) {
            return C0250c.m1020l(obj);
        }

        public boolean mo172m(Object obj) {
            return C0250c.m1021m(obj);
        }

        public boolean mo173n(Object obj) {
            return C0250c.m1022n(obj);
        }

        public boolean mo174o(Object obj) {
            return C0250c.m1023o(obj);
        }

        public void mo158a(Object obj, CharSequence charSequence) {
            C0250c.m1007a(obj, charSequence);
        }

        public void mo159a(Object obj, boolean z) {
            C0250c.m1008a(obj, z);
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat */
    static class C0243e extends C0242c {
        C0243e() {
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat */
    static class C0244f extends C0243e {
        C0244f() {
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat */
    static class C0245g extends C0244f {
        C0245g() {
        }

        public String mo175p(Object obj) {
            return C0251d.m1024a(obj);
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat */
    static class C0246h extends C0245g {
        C0246h() {
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat */
    static class C0247a extends C0246h {
        C0247a() {
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat */
    static class C0248b extends C0247a {
        C0248b() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 22) {
            f534a = new C0248b();
        } else if (VERSION.SDK_INT >= 21) {
            f534a = new C0247a();
        } else if (VERSION.SDK_INT >= 19) {
            f534a = new C0246h();
        } else if (VERSION.SDK_INT >= 18) {
            f534a = new C0245g();
        } else if (VERSION.SDK_INT >= 17) {
            f534a = new C0244f();
        } else if (VERSION.SDK_INT >= 16) {
            f534a = new C0243e();
        } else if (VERSION.SDK_INT >= 14) {
            f534a = new C0242c();
        } else {
            f534a = new C0241i();
        }
    }

    public C0249b(Object obj) {
        this.f535b = obj;
    }

    public Object mo136a() {
        return this.f535b;
    }

    public int m987b() {
        return f534a.mo155a(this.f535b);
    }

    public void m983a(int i) {
        f534a.mo156a(this.f535b, i);
    }

    public void m984a(Rect rect) {
        f534a.mo157a(this.f535b, rect);
    }

    public void m988b(Rect rect) {
        f534a.mo161b(this.f535b, rect);
    }

    public boolean m989c() {
        return f534a.mo165f(this.f535b);
    }

    public boolean m990d() {
        return f534a.mo166g(this.f535b);
    }

    public boolean m991e() {
        return f534a.mo169j(this.f535b);
    }

    public boolean m992f() {
        return f534a.mo170k(this.f535b);
    }

    public boolean m993g() {
        return f534a.mo174o(this.f535b);
    }

    public boolean m994h() {
        return f534a.mo167h(this.f535b);
    }

    public boolean m995i() {
        return f534a.mo171l(this.f535b);
    }

    public boolean m996j() {
        return f534a.mo168i(this.f535b);
    }

    public boolean m997k() {
        return f534a.mo172m(this.f535b);
    }

    public boolean m998l() {
        return f534a.mo173n(this.f535b);
    }

    public void m986a(boolean z) {
        f534a.mo159a(this.f535b, z);
    }

    public CharSequence m999m() {
        return f534a.mo163d(this.f535b);
    }

    public CharSequence m1000n() {
        return f534a.mo160b(this.f535b);
    }

    public void m985a(CharSequence charSequence) {
        f534a.mo158a(this.f535b, charSequence);
    }

    public CharSequence m1001o() {
        return f534a.mo164e(this.f535b);
    }

    public CharSequence m1002p() {
        return f534a.mo162c(this.f535b);
    }

    public String m1003q() {
        return f534a.mo175p(this.f535b);
    }

    public int hashCode() {
        return this.f535b == null ? 0 : this.f535b.hashCode();
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
        C0249b c0249b = (C0249b) obj;
        if (this.f535b == null) {
            if (c0249b.f535b != null) {
                return false;
            }
            return true;
        } else if (this.f535b.equals(c0249b.f535b)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        m984a(rect);
        stringBuilder.append("; boundsInParent: " + rect);
        m988b(rect);
        stringBuilder.append("; boundsInScreen: " + rect);
        stringBuilder.append("; packageName: ").append(m999m());
        stringBuilder.append("; className: ").append(m1000n());
        stringBuilder.append("; text: ").append(m1001o());
        stringBuilder.append("; contentDescription: ").append(m1002p());
        stringBuilder.append("; viewId: ").append(m1003q());
        stringBuilder.append("; checkable: ").append(m989c());
        stringBuilder.append("; checked: ").append(m990d());
        stringBuilder.append("; focusable: ").append(m991e());
        stringBuilder.append("; focused: ").append(m992f());
        stringBuilder.append("; selected: ").append(m993g());
        stringBuilder.append("; clickable: ").append(m994h());
        stringBuilder.append("; longClickable: ").append(m995i());
        stringBuilder.append("; enabled: ").append(m996j());
        stringBuilder.append("; password: ").append(m997k());
        stringBuilder.append("; scrollable: " + m998l());
        stringBuilder.append("; [");
        int b = m987b();
        while (b != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(b);
            b &= numberOfTrailingZeros ^ -1;
            stringBuilder.append(C0249b.m981b(numberOfTrailingZeros));
            if (b != 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static String m981b(int i) {
        switch (i) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case CodedOutputStream.DEFAULT_BUFFER_SIZE /*4096*/:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }
}
