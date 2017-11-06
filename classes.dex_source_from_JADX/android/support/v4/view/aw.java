package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* compiled from: ViewPropertyAnimatorCompat */
public final class aw {
    static final C0302g f564a;
    private WeakReference<View> f565b;
    private Runnable f566c = null;
    private Runnable f567d = null;
    private int f568e = -1;

    /* compiled from: ViewPropertyAnimatorCompat */
    interface C0302g {
        long mo248a(aw awVar, View view);

        void mo249a(aw awVar, View view, float f);

        void mo250a(aw awVar, View view, long j);

        void mo251a(aw awVar, View view, ba baVar);

        void mo252a(aw awVar, View view, bc bcVar);

        void mo253a(aw awVar, View view, Interpolator interpolator);

        void mo254b(aw awVar, View view);

        void mo255b(aw awVar, View view, float f);

        void mo256b(aw awVar, View view, long j);

        void mo257c(aw awVar, View view);

        void mo258c(aw awVar, View view, float f);

        void mo259d(aw awVar, View view, float f);
    }

    /* compiled from: ViewPropertyAnimatorCompat */
    static class C0303a implements C0302g {
        WeakHashMap<View, Runnable> f560a = null;

        /* compiled from: ViewPropertyAnimatorCompat */
        class C0301a implements Runnable {
            WeakReference<View> f557a;
            aw f558b;
            final /* synthetic */ C0303a f559c;

            private C0301a(C0303a c0303a, aw awVar, View view) {
                this.f559c = c0303a;
                this.f557a = new WeakReference(view);
                this.f558b = awVar;
            }

            public void run() {
                View view = (View) this.f557a.get();
                if (view != null) {
                    this.f559c.m1414d(this.f558b, view);
                }
            }
        }

        C0303a() {
        }

        public void mo250a(aw awVar, View view, long j) {
        }

        public void mo249a(aw awVar, View view, float f) {
            m1415e(awVar, view);
        }

        public void mo255b(aw awVar, View view, float f) {
            m1415e(awVar, view);
        }

        public long mo248a(aw awVar, View view) {
            return 0;
        }

        public void mo253a(aw awVar, View view, Interpolator interpolator) {
        }

        public void mo256b(aw awVar, View view, long j) {
        }

        public void mo258c(aw awVar, View view, float f) {
            m1415e(awVar, view);
        }

        public void mo259d(aw awVar, View view, float f) {
            m1415e(awVar, view);
        }

        public void mo254b(aw awVar, View view) {
            m1415e(awVar, view);
        }

        public void mo257c(aw awVar, View view) {
            m1413a(view);
            m1414d(awVar, view);
        }

        public void mo251a(aw awVar, View view, ba baVar) {
            view.setTag(2113929216, baVar);
        }

        public void mo252a(aw awVar, View view, bc bcVar) {
        }

        private void m1414d(aw awVar, View view) {
            ba baVar;
            Object tag = view.getTag(2113929216);
            if (tag instanceof ba) {
                baVar = (ba) tag;
            } else {
                baVar = null;
            }
            Runnable a = awVar.f566c;
            Runnable b = awVar.f567d;
            awVar.f566c = null;
            awVar.f567d = null;
            if (a != null) {
                a.run();
            }
            if (baVar != null) {
                baVar.mo260a(view);
                baVar.mo261b(view);
            }
            if (b != null) {
                b.run();
            }
            if (this.f560a != null) {
                this.f560a.remove(view);
            }
        }

        private void m1413a(View view) {
            if (this.f560a != null) {
                Runnable runnable = (Runnable) this.f560a.get(view);
                if (runnable != null) {
                    view.removeCallbacks(runnable);
                }
            }
        }

        private void m1415e(aw awVar, View view) {
            Runnable runnable;
            if (this.f560a != null) {
                runnable = (Runnable) this.f560a.get(view);
            } else {
                runnable = null;
            }
            if (runnable == null) {
                runnable = new C0301a(awVar, view);
                if (this.f560a == null) {
                    this.f560a = new WeakHashMap();
                }
                this.f560a.put(view, runnable);
            }
            view.removeCallbacks(runnable);
            view.post(runnable);
        }
    }

    /* compiled from: ViewPropertyAnimatorCompat */
    static class C0305b extends C0303a {
        WeakHashMap<View, Integer> f563b = null;

        /* compiled from: ViewPropertyAnimatorCompat */
        static class C0304a implements ba {
            aw f561a;
            boolean f562b;

            C0304a(aw awVar) {
                this.f561a = awVar;
            }

            public void mo260a(View view) {
                ba baVar;
                this.f562b = false;
                if (this.f561a.f568e >= 0) {
                    ag.m1264a(view, 2, null);
                }
                if (this.f561a.f566c != null) {
                    Runnable a = this.f561a.f566c;
                    this.f561a.f566c = null;
                    a.run();
                }
                Object tag = view.getTag(2113929216);
                if (tag instanceof ba) {
                    baVar = (ba) tag;
                } else {
                    baVar = null;
                }
                if (baVar != null) {
                    baVar.mo260a(view);
                }
            }

            public void mo261b(View view) {
                if (this.f561a.f568e >= 0) {
                    ag.m1264a(view, this.f561a.f568e, null);
                    this.f561a.f568e = -1;
                }
                if (VERSION.SDK_INT >= 16 || !this.f562b) {
                    ba baVar;
                    if (this.f561a.f567d != null) {
                        Runnable b = this.f561a.f567d;
                        this.f561a.f567d = null;
                        b.run();
                    }
                    Object tag = view.getTag(2113929216);
                    if (tag instanceof ba) {
                        baVar = (ba) tag;
                    } else {
                        baVar = null;
                    }
                    if (baVar != null) {
                        baVar.mo261b(view);
                    }
                    this.f562b = true;
                }
            }

            public void mo262c(View view) {
                ba baVar;
                Object tag = view.getTag(2113929216);
                if (tag instanceof ba) {
                    baVar = (ba) tag;
                } else {
                    baVar = null;
                }
                if (baVar != null) {
                    baVar.mo262c(view);
                }
            }
        }

        C0305b() {
        }

        public void mo250a(aw awVar, View view, long j) {
            ax.m1467a(view, j);
        }

        public void mo249a(aw awVar, View view, float f) {
            ax.m1466a(view, f);
        }

        public void mo255b(aw awVar, View view, float f) {
            ax.m1471b(view, f);
        }

        public long mo248a(aw awVar, View view) {
            return ax.m1465a(view);
        }

        public void mo253a(aw awVar, View view, Interpolator interpolator) {
            ax.m1469a(view, interpolator);
        }

        public void mo256b(aw awVar, View view, long j) {
            ax.m1472b(view, j);
        }

        public void mo258c(aw awVar, View view, float f) {
            ax.m1474c(view, f);
        }

        public void mo259d(aw awVar, View view, float f) {
            ax.m1475d(view, f);
        }

        public void mo254b(aw awVar, View view) {
            ax.m1470b(view);
        }

        public void mo257c(aw awVar, View view) {
            ax.m1473c(view);
        }

        public void mo251a(aw awVar, View view, ba baVar) {
            view.setTag(2113929216, baVar);
            ax.m1468a(view, new C0304a(awVar));
        }
    }

    /* compiled from: ViewPropertyAnimatorCompat */
    static class C0306d extends C0305b {
        C0306d() {
        }

        public void mo251a(aw awVar, View view, ba baVar) {
            ay.m1476a(view, baVar);
        }
    }

    /* compiled from: ViewPropertyAnimatorCompat */
    static class C0307c extends C0306d {
        C0307c() {
        }
    }

    /* compiled from: ViewPropertyAnimatorCompat */
    static class C0308e extends C0307c {
        C0308e() {
        }

        public void mo252a(aw awVar, View view, bc bcVar) {
            az.m1477a(view, bcVar);
        }
    }

    /* compiled from: ViewPropertyAnimatorCompat */
    static class C0309f extends C0308e {
        C0309f() {
        }
    }

    aw(View view) {
        this.f565b = new WeakReference(view);
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f564a = new C0309f();
        } else if (i >= 19) {
            f564a = new C0308e();
        } else if (i >= 18) {
            f564a = new C0307c();
        } else if (i >= 16) {
            f564a = new C0306d();
        } else if (i >= 14) {
            f564a = new C0305b();
        } else {
            f564a = new C0303a();
        }
    }

    public aw m1455a(long j) {
        View view = (View) this.f565b.get();
        if (view != null) {
            f564a.mo250a(this, view, j);
        }
        return this;
    }

    public aw m1454a(float f) {
        View view = (View) this.f565b.get();
        if (view != null) {
            f564a.mo249a(this, view, f);
        }
        return this;
    }

    public aw m1459b(float f) {
        View view = (View) this.f565b.get();
        if (view != null) {
            f564a.mo255b(this, view, f);
        }
        return this;
    }

    public long m1453a() {
        View view = (View) this.f565b.get();
        if (view != null) {
            return f564a.mo248a(this, view);
        }
        return 0;
    }

    public aw m1458a(Interpolator interpolator) {
        View view = (View) this.f565b.get();
        if (view != null) {
            f564a.mo253a(this, view, interpolator);
        }
        return this;
    }

    public aw m1460b(long j) {
        View view = (View) this.f565b.get();
        if (view != null) {
            f564a.mo256b(this, view, j);
        }
        return this;
    }

    public aw m1462c(float f) {
        View view = (View) this.f565b.get();
        if (view != null) {
            f564a.mo258c(this, view, f);
        }
        return this;
    }

    public aw m1464d(float f) {
        View view = (View) this.f565b.get();
        if (view != null) {
            f564a.mo259d(this, view, f);
        }
        return this;
    }

    public void m1461b() {
        View view = (View) this.f565b.get();
        if (view != null) {
            f564a.mo254b(this, view);
        }
    }

    public void m1463c() {
        View view = (View) this.f565b.get();
        if (view != null) {
            f564a.mo257c(this, view);
        }
    }

    public aw m1456a(ba baVar) {
        View view = (View) this.f565b.get();
        if (view != null) {
            f564a.mo251a(this, view, baVar);
        }
        return this;
    }

    public aw m1457a(bc bcVar) {
        View view = (View) this.f565b.get();
        if (view != null) {
            f564a.mo252a(this, view, bcVar);
        }
        return this;
    }
}
