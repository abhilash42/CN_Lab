package io.fabric.sdk.android.services.p020b;

import android.os.Process;

/* compiled from: BackgroundPriorityRunnable */
public abstract class C0719h implements Runnable {
    protected abstract void onRun();

    public final void run() {
        Process.setThreadPriority(10);
        onRun();
    }
}
