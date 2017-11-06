package android.support.v4.view;

import android.view.MotionEvent;

/* compiled from: MotionEventCompatEclair */
class C0362t {
    public static int m1623a(MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    public static int m1624b(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    public static float m1625c(MotionEvent motionEvent, int i) {
        return motionEvent.getX(i);
    }

    public static float m1626d(MotionEvent motionEvent, int i) {
        return motionEvent.getY(i);
    }
}
