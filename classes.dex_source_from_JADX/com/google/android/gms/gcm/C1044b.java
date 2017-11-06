package com.google.android.gms.gcm;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.iid.C1055a;
import java.util.regex.Pattern;

public class C1044b {
    private static C1044b f2077a;
    private static final Pattern f2078c = Pattern.compile("/topics/[a-zA-Z0-9-_.~%]{1,900}");
    private C1055a f2079b;

    private C1044b(Context context) {
        this.f2079b = C1055a.m3822b(context);
    }

    public static synchronized C1044b m3775a(Context context) {
        C1044b c1044b;
        synchronized (C1044b.class) {
            if (f2077a == null) {
                f2077a = new C1044b(context);
            }
            c1044b = f2077a;
        }
        return c1044b;
    }

    public void m3776a(String str, String str2, Bundle bundle) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Invalid appInstanceToken: " + str);
        } else if (str2 == null || !f2078c.matcher(str2).matches()) {
            throw new IllegalArgumentException("Invalid topic name: " + str2);
        } else {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("gcm.topic", str2);
            this.f2079b.m3823a(str, str2, bundle);
        }
    }
}
