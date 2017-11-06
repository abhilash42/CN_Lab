package io.fabric.sdk.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

/* compiled from: ActivityLifecycleManager */
public class C1450a {
    private final Application f3623a;
    private C1449a f3624b;

    /* compiled from: ActivityLifecycleManager */
    public static abstract class C0663b {
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }
    }

    /* compiled from: ActivityLifecycleManager */
    private static class C1449a {
        private final Set<ActivityLifecycleCallbacks> f3621a = new HashSet();
        private final Application f3622b;

        C1449a(Application application) {
            this.f3622b = application;
        }

        @TargetApi(14)
        private void m5500a() {
            for (ActivityLifecycleCallbacks unregisterActivityLifecycleCallbacks : this.f3621a) {
                this.f3622b.unregisterActivityLifecycleCallbacks(unregisterActivityLifecycleCallbacks);
            }
        }

        @TargetApi(14)
        private boolean m5503a(final C0663b c0663b) {
            if (this.f3622b == null) {
                return false;
            }
            ActivityLifecycleCallbacks c14481 = new ActivityLifecycleCallbacks(this) {
                final /* synthetic */ C1449a f3620b;

                public void onActivityCreated(Activity activity, Bundle bundle) {
                    c0663b.onActivityCreated(activity, bundle);
                }

                public void onActivityStarted(Activity activity) {
                    c0663b.onActivityStarted(activity);
                }

                public void onActivityResumed(Activity activity) {
                    c0663b.onActivityResumed(activity);
                }

                public void onActivityPaused(Activity activity) {
                    c0663b.onActivityPaused(activity);
                }

                public void onActivityStopped(Activity activity) {
                    c0663b.onActivityStopped(activity);
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    c0663b.onActivitySaveInstanceState(activity, bundle);
                }

                public void onActivityDestroyed(Activity activity) {
                    c0663b.onActivityDestroyed(activity);
                }
            };
            this.f3622b.registerActivityLifecycleCallbacks(c14481);
            this.f3621a.add(c14481);
            return true;
        }
    }

    public C1450a(Context context) {
        this.f3623a = (Application) context.getApplicationContext();
        if (VERSION.SDK_INT >= 14) {
            this.f3624b = new C1449a(this.f3623a);
        }
    }

    public boolean m5505a(C0663b c0663b) {
        return this.f3624b != null && this.f3624b.m5503a(c0663b);
    }

    public void m5504a() {
        if (this.f3624b != null) {
            this.f3624b.m5500a();
        }
    }
}
