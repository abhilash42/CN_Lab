package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.concurrency.p019a.C1514a;
import java.util.Random;

class RandomBackoff implements C1514a {
    final C1514a backoff;
    final double jitterPercent;
    final Random random;

    public RandomBackoff(C1514a c1514a, double d) {
        this(c1514a, d, new Random());
    }

    public RandomBackoff(C1514a c1514a, double d, Random random) {
        if (d < 0.0d || d > 1.0d) {
            throw new IllegalArgumentException("jitterPercent must be between 0.0 and 1.0");
        } else if (c1514a == null) {
            throw new NullPointerException("backoff must not be null");
        } else if (random == null) {
            throw new NullPointerException("random must not be null");
        } else {
            this.backoff = c1514a;
            this.jitterPercent = d;
            this.random = random;
        }
    }

    public long getDelayMillis(int i) {
        return (long) (randomJitter() * ((double) this.backoff.getDelayMillis(i)));
    }

    double randomJitter() {
        double d = 1.0d - this.jitterPercent;
        return d + (((this.jitterPercent + 1.0d) - d) * this.random.nextDouble());
    }
}
