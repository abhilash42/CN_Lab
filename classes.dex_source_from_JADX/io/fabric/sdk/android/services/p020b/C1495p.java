package io.fabric.sdk.android.services.p020b;

import android.content.Context;
import io.fabric.sdk.android.C1457c;
import io.fabric.sdk.android.services.p021a.C0677d;
import io.fabric.sdk.android.services.p021a.C1469b;

/* compiled from: InstallerPackageNameProvider */
public class C1495p {
    private final C0677d<String> f3755a = new C14941(this);
    private final C1469b<String> f3756b = new C1469b();

    /* compiled from: InstallerPackageNameProvider */
    class C14941 implements C0677d<String> {
        final /* synthetic */ C1495p f3754a;

        C14941(C1495p c1495p) {
            this.f3754a = c1495p;
        }

        public /* synthetic */ Object load(Context context) {
            return m5709a(context);
        }

        public String m5709a(Context context) {
            String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
            return installerPackageName == null ? "" : installerPackageName;
        }
    }

    public String m5710a(Context context) {
        try {
            String str = (String) this.f3756b.mo826a(context, this.f3755a);
            if ("".equals(str)) {
                return null;
            }
            return str;
        } catch (Throwable e) {
            C1457c.m5546h().mo819e("Fabric", "Failed to determine installer package name", e);
            return null;
        }
    }
}
