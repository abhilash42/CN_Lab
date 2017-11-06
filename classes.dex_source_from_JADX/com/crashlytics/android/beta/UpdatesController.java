package com.crashlytics.android.beta;

import android.content.Context;
import io.fabric.sdk.android.services.network.C1570d;
import io.fabric.sdk.android.services.p020b.C1486k;
import io.fabric.sdk.android.services.p020b.C1493o;
import io.fabric.sdk.android.services.p022e.C1540f;
import io.fabric.sdk.android.services.p037d.C1533c;

interface UpdatesController {
    void initialize(Context context, Beta beta, C1493o c1493o, C1540f c1540f, BuildProperties buildProperties, C1533c c1533c, C1486k c1486k, C1570d c1570d);

    boolean isActivityLifecycleTriggered();
}
