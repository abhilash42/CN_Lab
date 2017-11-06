package io.fabric.sdk.android.services.p020b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import io.fabric.sdk.android.C1457c;

/* compiled from: ApiKey */
public class C1479g {
    public String m5631a(Context context) {
        Object b = m5632b(context);
        if (TextUtils.isEmpty(b)) {
            b = m5633c(context);
        }
        if (TextUtils.isEmpty(b)) {
            m5634d(context);
        }
        return b;
    }

    protected String m5632b(Context context) {
        String str = null;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                str = bundle.getString("io.fabric.ApiKey");
                if (str == null) {
                    C1457c.m5546h().mo811a("Fabric", "Falling back to Crashlytics key lookup from Manifest");
                    str = bundle.getString("com.crashlytics.ApiKey");
                }
            }
        } catch (Exception e) {
            C1457c.m5546h().mo811a("Fabric", "Caught non-fatal exception while retrieving apiKey: " + e);
        }
        return str;
    }

    protected String m5633c(Context context) {
        int a = C1482i.m5638a(context, "io.fabric.ApiKey", "string");
        if (a == 0) {
            C1457c.m5546h().mo811a("Fabric", "Falling back to Crashlytics key lookup from Strings");
            a = C1482i.m5638a(context, "com.crashlytics.ApiKey", "string");
        }
        if (a != 0) {
            return context.getResources().getString(a);
        }
        return null;
    }

    protected void m5634d(Context context) {
        if (C1457c.m5547i() || C1482i.m5675i(context)) {
            throw new IllegalArgumentException(m5630a());
        }
        C1457c.m5546h().mo818e("Fabric", m5630a());
    }

    protected String m5630a() {
        return "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>";
    }
}
