package android.support.v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.C0316b.C0315a;
import android.support.v4.view.C0318c.C0232a;
import android.support.v4.view.p010a.C0249b;
import android.support.v4.view.p010a.C0260e;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: AccessibilityDelegateCompat */
public class C0220a {
    private static final C0249b f524b;
    private static final Object f525c = f524b.mo136a();
    final Object f526a = f524b.mo137a(this);

    /* compiled from: AccessibilityDelegateCompat */
    interface C0249b {
        C0260e mo135a(Object obj, View view);

        Object mo136a();

        Object mo137a(C0220a c0220a);

        void mo138a(Object obj, View view, int i);

        void mo139a(Object obj, View view, android.support.v4.view.p010a.C0249b c0249b);

        boolean mo140a(Object obj, View view, int i, Bundle bundle);

        boolean mo141a(Object obj, View view, AccessibilityEvent accessibilityEvent);

        boolean mo142a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        void mo143b(Object obj, View view, AccessibilityEvent accessibilityEvent);

        void mo144c(Object obj, View view, AccessibilityEvent accessibilityEvent);

        void mo145d(Object obj, View view, AccessibilityEvent accessibilityEvent);
    }

    /* compiled from: AccessibilityDelegateCompat */
    static class C0251d implements C0249b {
        C0251d() {
        }

        public Object mo136a() {
            return null;
        }

        public Object mo137a(C0220a c0220a) {
            return null;
        }

        public boolean mo141a(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            return false;
        }

        public void mo143b(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public void mo139a(Object obj, View view, C0249b c0249b) {
        }

        public void mo144c(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public boolean mo142a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return true;
        }

        public void mo138a(Object obj, View view, int i) {
        }

        public void mo145d(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public C0260e mo135a(Object obj, View view) {
            return null;
        }

        public boolean mo140a(Object obj, View view, int i, Bundle bundle) {
            return false;
        }
    }

    /* compiled from: AccessibilityDelegateCompat */
    static class C0239a extends C0251d {
        C0239a() {
        }

        public Object mo136a() {
            return C0316b.m1478a();
        }

        public Object mo137a(final C0220a c0220a) {
            return C0316b.m1479a(new C0315a(this) {
                final /* synthetic */ C0239a f530b;

                public boolean mo130a(View view, AccessibilityEvent accessibilityEvent) {
                    return c0220a.m838b(view, accessibilityEvent);
                }

                public void mo132b(View view, AccessibilityEvent accessibilityEvent) {
                    c0220a.mo127d(view, accessibilityEvent);
                }

                public void mo129a(View view, Object obj) {
                    c0220a.mo125a(view, new C0249b(obj));
                }

                public void mo133c(View view, AccessibilityEvent accessibilityEvent) {
                    c0220a.m839c(view, accessibilityEvent);
                }

                public boolean mo131a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return c0220a.m837a(viewGroup, view, accessibilityEvent);
                }

                public void mo128a(View view, int i) {
                    c0220a.m833a(view, i);
                }

                public void mo134d(View view, AccessibilityEvent accessibilityEvent) {
                    c0220a.m835a(view, accessibilityEvent);
                }
            });
        }

        public boolean mo141a(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            return C0316b.m1482a(obj, view, accessibilityEvent);
        }

        public void mo143b(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            C0316b.m1484b(obj, view, accessibilityEvent);
        }

        public void mo139a(Object obj, View view, C0249b c0249b) {
            C0316b.m1481a(obj, view, c0249b.mo136a());
        }

        public void mo144c(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            C0316b.m1485c(obj, view, accessibilityEvent);
        }

        public boolean mo142a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return C0316b.m1483a(obj, viewGroup, view, accessibilityEvent);
        }

        public void mo138a(Object obj, View view, int i) {
            C0316b.m1480a(obj, view, i);
        }

        public void mo145d(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            C0316b.m1486d(obj, view, accessibilityEvent);
        }
    }

    /* compiled from: AccessibilityDelegateCompat */
    static class C0250c extends C0239a {
        C0250c() {
        }

        public Object mo137a(final C0220a c0220a) {
            return C0318c.m1504a(new C0232a(this) {
                final /* synthetic */ C0250c f532b;

                public boolean mo150a(View view, AccessibilityEvent accessibilityEvent) {
                    return c0220a.m838b(view, accessibilityEvent);
                }

                public void mo152b(View view, AccessibilityEvent accessibilityEvent) {
                    c0220a.mo127d(view, accessibilityEvent);
                }

                public void mo148a(View view, Object obj) {
                    c0220a.mo125a(view, new C0249b(obj));
                }

                public void mo153c(View view, AccessibilityEvent accessibilityEvent) {
                    c0220a.m839c(view, accessibilityEvent);
                }

                public boolean mo151a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return c0220a.m837a(viewGroup, view, accessibilityEvent);
                }

                public void mo147a(View view, int i) {
                    c0220a.m833a(view, i);
                }

                public void mo154d(View view, AccessibilityEvent accessibilityEvent) {
                    c0220a.m835a(view, accessibilityEvent);
                }

                public Object mo146a(View view) {
                    C0260e a = c0220a.m831a(view);
                    return a != null ? a.m1044a() : null;
                }

                public boolean mo149a(View view, int i, Bundle bundle) {
                    return c0220a.mo126a(view, i, bundle);
                }
            });
        }

        public C0260e mo135a(Object obj, View view) {
            Object a = C0318c.m1505a(obj, view);
            if (a != null) {
                return new C0260e(a);
            }
            return null;
        }

        public boolean mo140a(Object obj, View view, int i, Bundle bundle) {
            return C0318c.m1506a(obj, view, i, bundle);
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f524b = new C0250c();
        } else if (VERSION.SDK_INT >= 14) {
            f524b = new C0239a();
        } else {
            f524b = new C0251d();
        }
    }

    Object m832a() {
        return this.f526a;
    }

    public void m833a(View view, int i) {
        f524b.mo138a(f525c, view, i);
    }

    public void m835a(View view, AccessibilityEvent accessibilityEvent) {
        f524b.mo145d(f525c, view, accessibilityEvent);
    }

    public boolean m838b(View view, AccessibilityEvent accessibilityEvent) {
        return f524b.mo141a(f525c, view, accessibilityEvent);
    }

    public void m839c(View view, AccessibilityEvent accessibilityEvent) {
        f524b.mo144c(f525c, view, accessibilityEvent);
    }

    public void mo127d(View view, AccessibilityEvent accessibilityEvent) {
        f524b.mo143b(f525c, view, accessibilityEvent);
    }

    public void mo125a(View view, C0249b c0249b) {
        f524b.mo139a(f525c, view, c0249b);
    }

    public boolean m837a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return f524b.mo142a(f525c, viewGroup, view, accessibilityEvent);
    }

    public C0260e m831a(View view) {
        return f524b.mo135a(f525c, view);
    }

    public boolean mo126a(View view, int i, Bundle bundle) {
        return f524b.mo140a(f525c, view, i, bundle);
    }
}
