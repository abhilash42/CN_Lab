package com.google.android.gms.internal;

import android.content.Context;
import java.util.regex.Pattern;

public final class C1073c {
    private static Pattern f2145a = null;

    public static int m3904a(int i) {
        return i / 1000;
    }

    public static boolean m3905a(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }
}
