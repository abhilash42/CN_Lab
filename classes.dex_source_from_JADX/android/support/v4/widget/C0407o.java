package android.support.v4.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.PopupWindow;

/* compiled from: PopupWindowCompat */
public final class C0407o {
    static final C0401f f675a;

    /* compiled from: PopupWindowCompat */
    interface C0401f {
        void mo323a(PopupWindow popupWindow, int i);

        void mo324a(PopupWindow popupWindow, View view, int i, int i2, int i3);

        void mo325a(PopupWindow popupWindow, boolean z);
    }

    /* compiled from: PopupWindowCompat */
    static class C0402c implements C0401f {
        C0402c() {
        }

        public void mo324a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            popupWindow.showAsDropDown(view, i, i2);
        }

        public void mo325a(PopupWindow popupWindow, boolean z) {
        }

        public void mo323a(PopupWindow popupWindow, int i) {
        }
    }

    /* compiled from: PopupWindowCompat */
    static class C0403d extends C0402c {
        C0403d() {
        }

        public void mo323a(PopupWindow popupWindow, int i) {
            C0410r.m1825a(popupWindow, i);
        }
    }

    /* compiled from: PopupWindowCompat */
    static class C0404e extends C0403d {
        C0404e() {
        }

        public void mo324a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            C0411s.m1826a(popupWindow, view, i, i2, i3);
        }
    }

    /* compiled from: PopupWindowCompat */
    static class C0405a extends C0404e {
        C0405a() {
        }

        public void mo325a(PopupWindow popupWindow, boolean z) {
            C0408p.m1822a(popupWindow, z);
        }
    }

    /* compiled from: PopupWindowCompat */
    static class C0406b extends C0405a {
        C0406b() {
        }

        public void mo325a(PopupWindow popupWindow, boolean z) {
            C0409q.m1824a(popupWindow, z);
        }

        public void mo323a(PopupWindow popupWindow, int i) {
            C0409q.m1823a(popupWindow, i);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f675a = new C0406b();
        } else if (i >= 21) {
            f675a = new C0405a();
        } else if (i >= 19) {
            f675a = new C0404e();
        } else if (i >= 9) {
            f675a = new C0403d();
        } else {
            f675a = new C0402c();
        }
    }

    public static void m1820a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        f675a.mo324a(popupWindow, view, i, i2, i3);
    }

    public static void m1821a(PopupWindow popupWindow, boolean z) {
        f675a.mo325a(popupWindow, z);
    }

    public static void m1819a(PopupWindow popupWindow, int i) {
        f675a.mo323a(popupWindow, i);
    }
}
