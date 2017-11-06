package android.support.v4.p004a;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;

/* compiled from: IntentCompat */
public final class C0032f {
    private static final C0028a f89a;

    /* compiled from: IntentCompat */
    interface C0028a {
        Intent mo26a(ComponentName componentName);
    }

    /* compiled from: IntentCompat */
    static class C0029b implements C0028a {
        C0029b() {
        }

        public Intent mo26a(ComponentName componentName) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setComponent(componentName);
            intent.addCategory("android.intent.category.LAUNCHER");
            return intent;
        }
    }

    /* compiled from: IntentCompat */
    static class C0030c extends C0029b {
        C0030c() {
        }

        public Intent mo26a(ComponentName componentName) {
            return C0033g.m93a(componentName);
        }
    }

    /* compiled from: IntentCompat */
    static class C0031d extends C0030c {
        C0031d() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 15) {
            f89a = new C0031d();
        } else if (i >= 11) {
            f89a = new C0030c();
        } else {
            f89a = new C0029b();
        }
    }

    public static Intent m92a(ComponentName componentName) {
        return f89a.mo26a(componentName);
    }
}
