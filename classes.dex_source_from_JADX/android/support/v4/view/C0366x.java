package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

/* compiled from: NestedScrollingChildHelper */
public class C0366x {
    private final View f593a;
    private ViewParent f594b;
    private boolean f595c;
    private int[] f596d;

    public C0366x(View view) {
        this.f593a = view;
    }

    public void m1629a(boolean z) {
        if (this.f595c) {
            ag.m1298t(this.f593a);
        }
        this.f595c = z;
    }

    public boolean m1630a() {
        return this.f595c;
    }

    public boolean m1636b() {
        return this.f594b != null;
    }

    public boolean m1633a(int i) {
        if (m1636b()) {
            return true;
        }
        if (m1630a()) {
            View view = this.f593a;
            for (ViewParent parent = this.f593a.getParent(); parent != null; parent = parent.getParent()) {
                if (au.m1391a(parent, view, this.f593a, i)) {
                    this.f594b = parent;
                    au.m1392b(parent, view, this.f593a, i);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    public void m1637c() {
        if (this.f594b != null) {
            au.m1386a(this.f594b, this.f593a);
            this.f594b = null;
        }
    }

    public boolean m1634a(int i, int i2, int i3, int i4, int[] iArr) {
        if (!m1630a() || this.f594b == null) {
            return false;
        }
        if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
            int i5;
            int i6;
            if (iArr != null) {
                this.f593a.getLocationInWindow(iArr);
                int i7 = iArr[0];
                i5 = iArr[1];
                i6 = i7;
            } else {
                i5 = 0;
                i6 = 0;
            }
            au.m1387a(this.f594b, this.f593a, i, i2, i3, i4);
            if (iArr != null) {
                this.f593a.getLocationInWindow(iArr);
                iArr[0] = iArr[0] - i6;
                iArr[1] = iArr[1] - i5;
            }
            return true;
        } else if (iArr == null) {
            return false;
        } else {
            iArr[0] = 0;
            iArr[1] = 0;
            return false;
        }
    }

    public boolean m1635a(int i, int i2, int[] iArr, int[] iArr2) {
        if (!m1630a() || this.f594b == null) {
            return false;
        }
        if (i != 0 || i2 != 0) {
            int i3;
            int i4;
            if (iArr2 != null) {
                this.f593a.getLocationInWindow(iArr2);
                i3 = iArr2[0];
                i4 = iArr2[1];
            } else {
                i4 = 0;
                i3 = 0;
            }
            if (iArr == null) {
                if (this.f596d == null) {
                    this.f596d = new int[2];
                }
                iArr = this.f596d;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            au.m1388a(this.f594b, this.f593a, i, i2, iArr);
            if (iArr2 != null) {
                this.f593a.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i3;
                iArr2[1] = iArr2[1] - i4;
            }
            if (iArr[0] == 0 && iArr[1] == 0) {
                return false;
            }
            return true;
        } else if (iArr2 == null) {
            return false;
        } else {
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
    }

    public boolean m1632a(float f, float f2, boolean z) {
        if (!m1630a() || this.f594b == null) {
            return false;
        }
        return au.m1390a(this.f594b, this.f593a, f, f2, z);
    }

    public boolean m1631a(float f, float f2) {
        if (!m1630a() || this.f594b == null) {
            return false;
        }
        return au.m1389a(this.f594b, this.f593a, f, f2);
    }
}
