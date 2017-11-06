package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

/* compiled from: VelocityTrackerCompat */
public final class ae {
    static final C0273c f548a;

    /* compiled from: VelocityTrackerCompat */
    interface C0273c {
        float mo192a(VelocityTracker velocityTracker, int i);

        float mo193b(VelocityTracker velocityTracker, int i);
    }

    /* compiled from: VelocityTrackerCompat */
    static class C0274a implements C0273c {
        C0274a() {
        }

        public float mo192a(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getXVelocity();
        }

        public float mo193b(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getYVelocity();
        }
    }

    /* compiled from: VelocityTrackerCompat */
    static class C0275b implements C0273c {
        C0275b() {
        }

        public float mo192a(VelocityTracker velocityTracker, int i) {
            return af.m1118a(velocityTracker, i);
        }

        public float mo193b(VelocityTracker velocityTracker, int i) {
            return af.m1119b(velocityTracker, i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            f548a = new C0275b();
        } else {
            f548a = new C0274a();
        }
    }

    public static float m1116a(VelocityTracker velocityTracker, int i) {
        return f548a.mo192a(velocityTracker, i);
    }

    public static float m1117b(VelocityTracker velocityTracker, int i) {
        return f548a.mo193b(velocityTracker, i);
    }
}
