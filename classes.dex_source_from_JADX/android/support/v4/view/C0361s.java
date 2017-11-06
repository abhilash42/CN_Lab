package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.MotionEvent;

/* compiled from: MotionEventCompat */
public final class C0361s {
    static final C0356e f592a;

    /* compiled from: MotionEventCompat */
    interface C0356e {
        int mo284a(MotionEvent motionEvent);

        int mo285a(MotionEvent motionEvent, int i);

        int mo286b(MotionEvent motionEvent, int i);

        float mo287c(MotionEvent motionEvent, int i);

        float mo288d(MotionEvent motionEvent, int i);

        float mo289e(MotionEvent motionEvent, int i);
    }

    /* compiled from: MotionEventCompat */
    static class C0357a implements C0356e {
        C0357a() {
        }

        public int mo285a(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return 0;
            }
            return -1;
        }

        public int mo286b(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return 0;
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        public float mo287c(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return motionEvent.getX();
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        public float mo288d(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return motionEvent.getY();
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        public int mo284a(MotionEvent motionEvent) {
            return 0;
        }

        public float mo289e(MotionEvent motionEvent, int i) {
            return 0.0f;
        }
    }

    /* compiled from: MotionEventCompat */
    static class C0358b extends C0357a {
        C0358b() {
        }

        public int mo285a(MotionEvent motionEvent, int i) {
            return C0362t.m1623a(motionEvent, i);
        }

        public int mo286b(MotionEvent motionEvent, int i) {
            return C0362t.m1624b(motionEvent, i);
        }

        public float mo287c(MotionEvent motionEvent, int i) {
            return C0362t.m1625c(motionEvent, i);
        }

        public float mo288d(MotionEvent motionEvent, int i) {
            return C0362t.m1626d(motionEvent, i);
        }
    }

    /* compiled from: MotionEventCompat */
    static class C0359c extends C0358b {
        C0359c() {
        }

        public int mo284a(MotionEvent motionEvent) {
            return C0363u.m1627a(motionEvent);
        }
    }

    /* compiled from: MotionEventCompat */
    static class C0360d extends C0359c {
        C0360d() {
        }

        public float mo289e(MotionEvent motionEvent, int i) {
            return C0364v.m1628a(motionEvent, i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 12) {
            f592a = new C0360d();
        } else if (VERSION.SDK_INT >= 9) {
            f592a = new C0359c();
        } else if (VERSION.SDK_INT >= 5) {
            f592a = new C0358b();
        } else {
            f592a = new C0357a();
        }
    }

    public static int m1615a(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static int m1617b(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    public static int m1616a(MotionEvent motionEvent, int i) {
        return f592a.mo285a(motionEvent, i);
    }

    public static int m1618b(MotionEvent motionEvent, int i) {
        return f592a.mo286b(motionEvent, i);
    }

    public static float m1619c(MotionEvent motionEvent, int i) {
        return f592a.mo287c(motionEvent, i);
    }

    public static float m1621d(MotionEvent motionEvent, int i) {
        return f592a.mo288d(motionEvent, i);
    }

    public static int m1620c(MotionEvent motionEvent) {
        return f592a.mo284a(motionEvent);
    }

    public static float m1622e(MotionEvent motionEvent, int i) {
        return f592a.mo289e(motionEvent, i);
    }
}
