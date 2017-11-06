package com.crashlytics.android.beta;

import android.annotation.SuppressLint;
import android.content.Context;
import io.fabric.sdk.android.C1457c;
import io.fabric.sdk.android.services.network.C1570d;
import io.fabric.sdk.android.services.p020b.C1479g;
import io.fabric.sdk.android.services.p020b.C1486k;
import io.fabric.sdk.android.services.p020b.C1493o;
import io.fabric.sdk.android.services.p020b.C1493o.C1492a;
import io.fabric.sdk.android.services.p022e.C1540f;
import io.fabric.sdk.android.services.p037d.C1533c;
import java.util.concurrent.atomic.AtomicBoolean;

abstract class AbstractCheckForUpdatesController implements UpdatesController {
    static final long LAST_UPDATE_CHECK_DEFAULT = 0;
    static final String LAST_UPDATE_CHECK_KEY = "last_update_check";
    private static final long MILLIS_PER_SECOND = 1000;
    private Beta beta;
    private C1540f betaSettings;
    private BuildProperties buildProps;
    private Context context;
    private C1486k currentTimeProvider;
    private final AtomicBoolean externallyReady;
    private C1570d httpRequestFactory;
    private C1493o idManager;
    private final AtomicBoolean initialized;
    private long lastCheckTimeMillis;
    private C1533c preferenceStore;

    public AbstractCheckForUpdatesController() {
        this(false);
    }

    public AbstractCheckForUpdatesController(boolean z) {
        this.initialized = new AtomicBoolean();
        this.lastCheckTimeMillis = LAST_UPDATE_CHECK_DEFAULT;
        this.externallyReady = new AtomicBoolean(z);
    }

    public void initialize(Context context, Beta beta, C1493o c1493o, C1540f c1540f, BuildProperties buildProperties, C1533c c1533c, C1486k c1486k, C1570d c1570d) {
        this.context = context;
        this.beta = beta;
        this.idManager = c1493o;
        this.betaSettings = c1540f;
        this.buildProps = buildProperties;
        this.preferenceStore = c1533c;
        this.currentTimeProvider = c1486k;
        this.httpRequestFactory = c1570d;
        if (signalInitialized()) {
            checkForUpdates();
        }
    }

    protected boolean signalExternallyReady() {
        this.externallyReady.set(true);
        return this.initialized.get();
    }

    boolean signalInitialized() {
        this.initialized.set(true);
        return this.externallyReady.get();
    }

    @SuppressLint({"CommitPrefEdits"})
    protected void checkForUpdates() {
        synchronized (this.preferenceStore) {
            if (this.preferenceStore.mo843a().contains(LAST_UPDATE_CHECK_KEY)) {
                this.preferenceStore.mo844a(this.preferenceStore.mo845b().remove(LAST_UPDATE_CHECK_KEY));
            }
        }
        long a = this.currentTimeProvider.mo830a();
        long j = ((long) this.betaSettings.f3861b) * MILLIS_PER_SECOND;
        C1457c.m5546h().mo811a(Beta.TAG, "Check for updates delay: " + j);
        C1457c.m5546h().mo811a(Beta.TAG, "Check for updates last check time: " + getLastCheckTimeMillis());
        j += getLastCheckTimeMillis();
        C1457c.m5546h().mo811a(Beta.TAG, "Check for updates current time: " + a + ", next check time: " + j);
        if (a >= j) {
            try {
                performUpdateCheck();
            } finally {
                setLastCheckTimeMillis(a);
            }
        } else {
            C1457c.m5546h().mo811a(Beta.TAG, "Check for updates next check time was not passed");
        }
    }

    private void performUpdateCheck() {
        C1457c.m5546h().mo811a(Beta.TAG, "Performing update check");
        new CheckForUpdatesRequest(this.beta, this.beta.getOverridenSpiEndpoint(), this.betaSettings.f3860a, this.httpRequestFactory, new CheckForUpdatesResponseTransform()).invoke(new C1479g().m5631a(this.context), (String) this.idManager.m5703i().get(C1492a.FONT_TOKEN), this.buildProps);
    }

    void setLastCheckTimeMillis(long j) {
        this.lastCheckTimeMillis = j;
    }

    long getLastCheckTimeMillis() {
        return this.lastCheckTimeMillis;
    }
}
