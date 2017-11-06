package com.crashlytics.android.answers;

import java.util.HashSet;
import java.util.Set;

class SamplingEventFilter implements EventFilter {
    static final Set<Type> EVENTS_TYPE_TO_SAMPLE = new C06691();
    final int samplingRate;

    static class C06691 extends HashSet<Type> {
        C06691() {
            add(Type.START);
            add(Type.RESUME);
            add(Type.PAUSE);
            add(Type.STOP);
        }
    }

    public SamplingEventFilter(int i) {
        this.samplingRate = i;
    }

    public boolean skipEvent(SessionEvent sessionEvent) {
        boolean z;
        if (EVENTS_TYPE_TO_SAMPLE.contains(sessionEvent.type) && sessionEvent.sessionEventMetadata.betaDeviceToken == null) {
            z = true;
        } else {
            z = false;
        }
        boolean z2;
        if (Math.abs(sessionEvent.sessionEventMetadata.installationId.hashCode() % this.samplingRate) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && r3) {
            return true;
        }
        return false;
    }
}
