package android.support.v4.widget;

import android.os.Build.VERSION;
import android.widget.TextView;

/* compiled from: TextViewCompat */
public final class C0426x {
    static final C0420f f684a;

    /* compiled from: TextViewCompat */
    interface C0420f {
        int mo340a(TextView textView);

        void mo341a(TextView textView, int i);
    }

    /* compiled from: TextViewCompat */
    static class C0421b implements C0420f {
        C0421b() {
        }

        public int mo340a(TextView textView) {
            return C0428z.m1900a(textView);
        }

        public void mo341a(TextView textView, int i) {
            C0428z.m1903a(textView, i);
        }
    }

    /* compiled from: TextViewCompat */
    static class C0422e extends C0421b {
        C0422e() {
        }

        public int mo340a(TextView textView) {
            return aa.m1724a(textView);
        }
    }

    /* compiled from: TextViewCompat */
    static class C0423c extends C0422e {
        C0423c() {
        }
    }

    /* compiled from: TextViewCompat */
    static class C0424d extends C0423c {
        C0424d() {
        }
    }

    /* compiled from: TextViewCompat */
    static class C0425a extends C0424d {
        C0425a() {
        }

        public void mo341a(TextView textView, int i) {
            C0427y.m1899a(textView, i);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f684a = new C0425a();
        } else if (i >= 18) {
            f684a = new C0424d();
        } else if (i >= 17) {
            f684a = new C0423c();
        } else if (i >= 16) {
            f684a = new C0422e();
        } else {
            f684a = new C0421b();
        }
    }

    public static int m1897a(TextView textView) {
        return f684a.mo340a(textView);
    }

    public static void m1898a(TextView textView, int i) {
        f684a.mo341a(textView, i);
    }
}
