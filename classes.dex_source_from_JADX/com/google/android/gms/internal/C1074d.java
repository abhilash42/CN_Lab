package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Process;
import com.google.android.gms.common.internal.C1000c;

public class C1074d {
    public static boolean m3906a() {
        return C1000c.f1951a && C1067b.m3887b() && C1067b.m3882a() == Process.myUid();
    }

    public static boolean m3907a(Context context, String str) {
        try {
            return (context.getPackageManager().getApplicationInfo(str, 0).flags & 2097152) != 0;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
