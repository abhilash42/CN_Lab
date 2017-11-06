package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.C0361s;
import android.support.v4.view.ag;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* compiled from: AutoScrollHelper */
public abstract class C0375a implements OnTouchListener {
    private static final int f639r = ViewConfiguration.getTapTimeout();
    private final C0373a f640a = new C0373a();
    private final Interpolator f641b = new AccelerateInterpolator();
    private final View f642c;
    private Runnable f643d;
    private float[] f644e = new float[]{0.0f, 0.0f};
    private float[] f645f = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private int f646g;
    private int f647h;
    private float[] f648i = new float[]{0.0f, 0.0f};
    private float[] f649j = new float[]{0.0f, 0.0f};
    private float[] f650k = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private boolean f651l;
    private boolean f652m;
    private boolean f653n;
    private boolean f654o;
    private boolean f655p;
    private boolean f656q;

    /* compiled from: AutoScrollHelper */
    private static class C0373a {
        private int f627a;
        private int f628b;
        private float f629c;
        private float f630d;
        private long f631e = Long.MIN_VALUE;
        private long f632f = 0;
        private int f633g = 0;
        private int f634h = 0;
        private long f635i = -1;
        private float f636j;
        private int f637k;

        public void m1681a(int i) {
            this.f627a = i;
        }

        public void m1683b(int i) {
            this.f628b = i;
        }

        public void m1679a() {
            this.f631e = AnimationUtils.currentAnimationTimeMillis();
            this.f635i = -1;
            this.f632f = this.f631e;
            this.f636j = 0.5f;
            this.f633g = 0;
            this.f634h = 0;
        }

        public void m1682b() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f637k = C0375a.m1698b((int) (currentAnimationTimeMillis - this.f631e), 0, this.f628b);
            this.f636j = m1678a(currentAnimationTimeMillis);
            this.f635i = currentAnimationTimeMillis;
        }

        public boolean m1684c() {
            return this.f635i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f635i + ((long) this.f637k);
        }

        private float m1678a(long j) {
            if (j < this.f631e) {
                return 0.0f;
            }
            if (this.f635i < 0 || j < this.f635i) {
                return C0375a.m1697b(((float) (j - this.f631e)) / ((float) this.f627a), 0.0f, 1.0f) * 0.5f;
            }
            long j2 = j - this.f635i;
            return (C0375a.m1697b(((float) j2) / ((float) this.f637k), 0.0f, 1.0f) * this.f636j) + (1.0f - this.f636j);
        }

        private float m1677a(float f) {
            return ((-4.0f * f) * f) + (4.0f * f);
        }

        public void m1685d() {
            if (this.f632f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float a = m1677a(m1678a(currentAnimationTimeMillis));
            long j = currentAnimationTimeMillis - this.f632f;
            this.f632f = currentAnimationTimeMillis;
            this.f633g = (int) ((((float) j) * a) * this.f629c);
            this.f634h = (int) ((((float) j) * a) * this.f630d);
        }

        public void m1680a(float f, float f2) {
            this.f629c = f;
            this.f630d = f2;
        }

        public int m1686e() {
            return (int) (this.f629c / Math.abs(this.f629c));
        }

        public int m1687f() {
            return (int) (this.f630d / Math.abs(this.f630d));
        }

        public int m1688g() {
            return this.f633g;
        }

        public int m1689h() {
            return this.f634h;
        }
    }

    /* compiled from: AutoScrollHelper */
    private class C0374b implements Runnable {
        final /* synthetic */ C0375a f638a;

        private C0374b(C0375a c0375a) {
            this.f638a = c0375a;
        }

        public void run() {
            if (this.f638a.f654o) {
                if (this.f638a.f652m) {
                    this.f638a.f652m = false;
                    this.f638a.f640a.m1679a();
                }
                C0373a c = this.f638a.f640a;
                if (c.m1684c() || !this.f638a.m1694a()) {
                    this.f638a.f654o = false;
                    return;
                }
                if (this.f638a.f653n) {
                    this.f638a.f653n = false;
                    this.f638a.m1705d();
                }
                c.m1685d();
                this.f638a.mo320a(c.m1688g(), c.m1689h());
                ag.m1269a(this.f638a.f642c, (Runnable) this);
            }
        }
    }

    public abstract void mo320a(int i, int i2);

    public abstract boolean mo321e(int i);

    public abstract boolean mo322f(int i);

    public C0375a(View view) {
        this.f642c = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((1575.0f * displayMetrics.density) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        m1711a((float) i, (float) i);
        m1715b((float) i2, (float) i2);
        m1712a(1);
        m1721e(Float.MAX_VALUE, Float.MAX_VALUE);
        m1719d(0.2f, 0.2f);
        m1717c(1.0f, 1.0f);
        m1716b(f639r);
        m1718c(500);
        m1720d(500);
    }

    public C0375a m1713a(boolean z) {
        if (this.f655p && !z) {
            m1703c();
        }
        this.f655p = z;
        return this;
    }

    public C0375a m1711a(float f, float f2) {
        this.f650k[0] = f / 1000.0f;
        this.f650k[1] = f2 / 1000.0f;
        return this;
    }

    public C0375a m1715b(float f, float f2) {
        this.f649j[0] = f / 1000.0f;
        this.f649j[1] = f2 / 1000.0f;
        return this;
    }

    public C0375a m1717c(float f, float f2) {
        this.f648i[0] = f / 1000.0f;
        this.f648i[1] = f2 / 1000.0f;
        return this;
    }

    public C0375a m1712a(int i) {
        this.f646g = i;
        return this;
    }

    public C0375a m1719d(float f, float f2) {
        this.f644e[0] = f;
        this.f644e[1] = f2;
        return this;
    }

    public C0375a m1721e(float f, float f2) {
        this.f645f[0] = f;
        this.f645f[1] = f2;
        return this;
    }

    public C0375a m1716b(int i) {
        this.f647h = i;
        return this;
    }

    public C0375a m1718c(int i) {
        this.f640a.m1681a(i);
        return this;
    }

    public C0375a m1720d(int i) {
        this.f640a.m1683b(i);
        return this;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = true;
        if (!this.f655p) {
            return false;
        }
        switch (C0361s.m1615a(motionEvent)) {
            case 0:
                this.f653n = true;
                this.f651l = false;
                break;
            case 1:
            case 3:
                m1703c();
                break;
            case 2:
                break;
        }
        this.f640a.m1680a(m1692a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.f642c.getWidth()), m1692a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.f642c.getHeight()));
        if (!this.f654o && m1694a()) {
            m1699b();
        }
        if (!(this.f656q && this.f654o)) {
            z = false;
        }
        return z;
    }

    private boolean m1694a() {
        C0373a c0373a = this.f640a;
        int f = c0373a.m1687f();
        int e = c0373a.m1686e();
        return (f != 0 && mo322f(f)) || (e != 0 && mo321e(e));
    }

    private void m1699b() {
        if (this.f643d == null) {
            this.f643d = new C0374b();
        }
        this.f654o = true;
        this.f652m = true;
        if (this.f651l || this.f647h <= 0) {
            this.f643d.run();
        } else {
            ag.m1270a(this.f642c, this.f643d, (long) this.f647h);
        }
        this.f651l = true;
    }

    private void m1703c() {
        if (this.f652m) {
            this.f654o = false;
        } else {
            this.f640a.m1682b();
        }
    }

    private float m1692a(int i, float f, float f2, float f3) {
        float a = m1691a(this.f644e[i], f2, this.f645f[i], f);
        if (a == 0.0f) {
            return 0.0f;
        }
        float f4 = this.f648i[i];
        float f5 = this.f649j[i];
        float f6 = this.f650k[i];
        f4 *= f3;
        if (a > 0.0f) {
            return C0375a.m1697b(a * f4, f5, f6);
        }
        return -C0375a.m1697b((-a) * f4, f5, f6);
    }

    private float m1691a(float f, float f2, float f3, float f4) {
        float f5;
        float b = C0375a.m1697b(f * f2, 0.0f, f3);
        b = m1708f(f2 - f4, b) - m1708f(f4, b);
        if (b < 0.0f) {
            f5 = -this.f641b.getInterpolation(-b);
        } else if (b <= 0.0f) {
            return 0.0f;
        } else {
            f5 = this.f641b.getInterpolation(b);
        }
        return C0375a.m1697b(f5, -1.0f, 1.0f);
    }

    private float m1708f(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        switch (this.f646g) {
            case 0:
            case 1:
                if (f >= f2) {
                    return 0.0f;
                }
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                if (this.f654o && this.f646g == 1) {
                    return 1.0f;
                }
                return 0.0f;
            case 2:
                if (f < 0.0f) {
                    return f / (-f2);
                }
                return 0.0f;
            default:
                return 0.0f;
        }
    }

    private static int m1698b(int i, int i2, int i3) {
        if (i > i3) {
            return i3;
        }
        if (i < i2) {
            return i2;
        }
        return i;
    }

    private static float m1697b(float f, float f2, float f3) {
        if (f > f3) {
            return f3;
        }
        if (f < f2) {
            return f2;
        }
        return f;
    }

    private void m1705d() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f642c.onTouchEvent(obtain);
        obtain.recycle();
    }
}
