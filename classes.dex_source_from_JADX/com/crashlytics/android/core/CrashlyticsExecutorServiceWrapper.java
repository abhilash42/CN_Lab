package com.crashlytics.android.core;

import android.os.Looper;
import io.fabric.sdk.android.C1457c;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

class CrashlyticsExecutorServiceWrapper {
    private final ExecutorService executorService;

    public CrashlyticsExecutorServiceWrapper(ExecutorService executorService) {
        this.executorService = executorService;
    }

    <T> T executeSyncLoggingException(Callable<T> callable) {
        try {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                return this.executorService.submit(callable).get(4, TimeUnit.SECONDS);
            }
            return this.executorService.submit(callable).get();
        } catch (RejectedExecutionException e) {
            C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Executor is shut down because we're handling a fatal crash.");
            return null;
        } catch (Throwable e2) {
            C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "Failed to execute task.", e2);
            return null;
        }
    }

    Future<?> executeAsync(final Runnable runnable) {
        try {
            return this.executorService.submit(new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } catch (Throwable e) {
                        C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "Failed to execute task.", e);
                    }
                }
            });
        } catch (RejectedExecutionException e) {
            C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }

    <T> Future<T> executeAsync(final Callable<T> callable) {
        try {
            return this.executorService.submit(new Callable<T>() {
                public T call() {
                    try {
                        return callable.call();
                    } catch (Throwable e) {
                        C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "Failed to execute task.", e);
                        return null;
                    }
                }
            });
        } catch (RejectedExecutionException e) {
            C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }
}
