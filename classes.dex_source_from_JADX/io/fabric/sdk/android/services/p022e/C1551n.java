package io.fabric.sdk.android.services.p022e;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import io.fabric.sdk.android.C1457c;
import io.fabric.sdk.android.services.p020b.C1482i;

/* compiled from: IconRequest */
public class C1551n {
    public final String f3874a;
    public final int f3875b;
    public final int f3876c;
    public final int f3877d;

    public C1551n(String str, int i, int i2, int i3) {
        this.f3874a = str;
        this.f3875b = i;
        this.f3876c = i2;
        this.f3877d = i3;
    }

    public static C1551n m5837a(Context context, String str) {
        if (str != null) {
            try {
                int l = C1482i.m5678l(context);
                C1457c.m5546h().mo811a("Fabric", "App icon resource ID is " + l);
                Options options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeResource(context.getResources(), l, options);
                return new C1551n(str, l, options.outWidth, options.outHeight);
            } catch (Throwable e) {
                C1457c.m5546h().mo819e("Fabric", "Failed to load icon", e);
            }
        }
        return null;
    }
}
