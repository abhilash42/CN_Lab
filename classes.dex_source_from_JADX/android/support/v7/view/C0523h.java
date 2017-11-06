package android.support.v7.view;

import android.support.v4.view.aw;
import android.support.v4.view.ba;
import android.support.v4.view.bb;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ViewPropertyAnimatorCompatSet */
public class C0523h {
    private final ArrayList<aw> f1027a = new ArrayList();
    private long f1028b = -1;
    private Interpolator f1029c;
    private ba f1030d;
    private boolean f1031e;
    private final bb f1032f = new C05221(this);

    /* compiled from: ViewPropertyAnimatorCompatSet */
    class C05221 extends bb {
        final /* synthetic */ C0523h f1024a;
        private boolean f1025b = false;
        private int f1026c = 0;

        C05221(C0523h c0523h) {
            this.f1024a = c0523h;
        }

        public void mo260a(View view) {
            if (!this.f1025b) {
                this.f1025b = true;
                if (this.f1024a.f1030d != null) {
                    this.f1024a.f1030d.mo260a(null);
                }
            }
        }

        void m2347a() {
            this.f1026c = 0;
            this.f1025b = false;
            this.f1024a.m2353c();
        }

        public void mo261b(View view) {
            int i = this.f1026c + 1;
            this.f1026c = i;
            if (i == this.f1024a.f1027a.size()) {
                if (this.f1024a.f1030d != null) {
                    this.f1024a.f1030d.mo261b(null);
                }
                m2347a();
            }
        }
    }

    public C0523h m2355a(aw awVar) {
        if (!this.f1031e) {
            this.f1027a.add(awVar);
        }
        return this;
    }

    public C0523h m2356a(aw awVar, aw awVar2) {
        this.f1027a.add(awVar);
        awVar2.m1460b(awVar.m1453a());
        this.f1027a.add(awVar2);
        return this;
    }

    public void m2359a() {
        if (!this.f1031e) {
            Iterator it = this.f1027a.iterator();
            while (it.hasNext()) {
                aw awVar = (aw) it.next();
                if (this.f1028b >= 0) {
                    awVar.m1455a(this.f1028b);
                }
                if (this.f1029c != null) {
                    awVar.m1458a(this.f1029c);
                }
                if (this.f1030d != null) {
                    awVar.m1456a(this.f1032f);
                }
                awVar.m1463c();
            }
            this.f1031e = true;
        }
    }

    private void m2353c() {
        this.f1031e = false;
    }

    public void m2360b() {
        if (this.f1031e) {
            Iterator it = this.f1027a.iterator();
            while (it.hasNext()) {
                ((aw) it.next()).m1461b();
            }
            this.f1031e = false;
        }
    }

    public C0523h m2354a(long j) {
        if (!this.f1031e) {
            this.f1028b = j;
        }
        return this;
    }

    public C0523h m2358a(Interpolator interpolator) {
        if (!this.f1031e) {
            this.f1029c = interpolator;
        }
        return this;
    }

    public C0523h m2357a(ba baVar) {
        if (!this.f1031e) {
            this.f1030d = baVar;
        }
        return this;
    }
}
