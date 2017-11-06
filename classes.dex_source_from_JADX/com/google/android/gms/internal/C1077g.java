package com.google.android.gms.internal;

import android.content.res.Configuration;
import android.content.res.Resources;

public final class C1077g {
    public static boolean m3913a(Resources resources) {
        if (resources == null) {
            return false;
        }
        return (C1078h.m3915a() && ((resources.getConfiguration().screenLayout & 15) > 3)) || C1077g.m3914b(resources);
    }

    private static boolean m3914b(Resources resources) {
        Configuration configuration = resources.getConfiguration();
        return C1078h.m3917b() && (configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600;
    }
}
