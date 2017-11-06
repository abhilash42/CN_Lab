package com.crashlytics.android.beta;

import android.annotation.TargetApi;
import android.app.Activity;
import io.fabric.sdk.android.C1450a;
import io.fabric.sdk.android.C1450a.C0663b;
import java.util.concurrent.ExecutorService;

@TargetApi(14)
class ActivityLifecycleCheckForUpdatesController extends AbstractCheckForUpdatesController {
    private final C0663b callbacks = new C06751();
    private final ExecutorService executorService;

    class C06751 extends C0663b {

        class C06741 implements Runnable {
            C06741() {
            }

            public void run() {
                ActivityLifecycleCheckForUpdatesController.this.checkForUpdates();
            }
        }

        C06751() {
        }

        public void onActivityStarted(Activity activity) {
            if (ActivityLifecycleCheckForUpdatesController.this.signalExternallyReady()) {
                ActivityLifecycleCheckForUpdatesController.this.executorService.submit(new C06741());
            }
        }
    }

    public ActivityLifecycleCheckForUpdatesController(C1450a c1450a, ExecutorService executorService) {
        this.executorService = executorService;
        c1450a.m5505a(this.callbacks);
    }

    public boolean isActivityLifecycleTriggered() {
        return true;
    }
}
