package android.support.v4.view.p010a;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.p010a.C0262f.C0253a;
import android.support.v4.view.p010a.C0264g.C0257a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompat */
public class C0260e {
    private static final C0252a f540a;
    private final Object f541b;

    /* compiled from: AccessibilityNodeProviderCompat */
    interface C0252a {
        Object mo179a(C0260e c0260e);
    }

    /* compiled from: AccessibilityNodeProviderCompat */
    static class C0255d implements C0252a {
        C0255d() {
        }

        public Object mo179a(C0260e c0260e) {
            return null;
        }
    }

    /* compiled from: AccessibilityNodeProviderCompat */
    static class C0256b extends C0255d {
        C0256b() {
        }

        public Object mo179a(final C0260e c0260e) {
            return C0262f.m1048a(new C0253a(this) {
                final /* synthetic */ C0256b f537b;

                public boolean mo178a(int i, int i2, Bundle bundle) {
                    return c0260e.m1046a(i, i2, bundle);
                }

                public List<Object> mo177a(String str, int i) {
                    List a = c0260e.m1045a(str, i);
                    List<Object> arrayList = new ArrayList();
                    int size = a.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(((C0249b) a.get(i2)).mo136a());
                    }
                    return arrayList;
                }

                public Object mo176a(int i) {
                    C0249b a = c0260e.m1043a(i);
                    if (a == null) {
                        return null;
                    }
                    return a.mo136a();
                }
            });
        }
    }

    /* compiled from: AccessibilityNodeProviderCompat */
    static class C0259c extends C0255d {
        C0259c() {
        }

        public Object mo179a(final C0260e c0260e) {
            return C0264g.m1049a(new C0257a(this) {
                final /* synthetic */ C0259c f539b;

                public boolean mo182a(int i, int i2, Bundle bundle) {
                    return c0260e.m1046a(i, i2, bundle);
                }

                public List<Object> mo181a(String str, int i) {
                    List a = c0260e.m1045a(str, i);
                    List<Object> arrayList = new ArrayList();
                    int size = a.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(((C0249b) a.get(i2)).mo136a());
                    }
                    return arrayList;
                }

                public Object mo180a(int i) {
                    C0249b a = c0260e.m1043a(i);
                    if (a == null) {
                        return null;
                    }
                    return a.mo136a();
                }

                public Object mo183b(int i) {
                    C0249b b = c0260e.m1047b(i);
                    if (b == null) {
                        return null;
                    }
                    return b.mo136a();
                }
            });
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            f540a = new C0259c();
        } else if (VERSION.SDK_INT >= 16) {
            f540a = new C0256b();
        } else {
            f540a = new C0255d();
        }
    }

    public C0260e() {
        this.f541b = f540a.mo179a(this);
    }

    public C0260e(Object obj) {
        this.f541b = obj;
    }

    public Object m1044a() {
        return this.f541b;
    }

    public C0249b m1043a(int i) {
        return null;
    }

    public boolean m1046a(int i, int i2, Bundle bundle) {
        return false;
    }

    public List<C0249b> m1045a(String str, int i) {
        return null;
    }

    public C0249b m1047b(int i) {
        return null;
    }
}
