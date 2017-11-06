package io.fabric.sdk.android.services.p037d;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import io.fabric.sdk.android.C0653h;

/* compiled from: PreferenceStoreImpl */
public class C1534d implements C1533c {
    private final SharedPreferences f3828a;
    private final String f3829b;
    private final Context f3830c;

    public C1534d(Context context, String str) {
        if (context == null) {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        }
        this.f3830c = context;
        this.f3829b = str;
        this.f3828a = this.f3830c.getSharedPreferences(this.f3829b, 0);
    }

    @Deprecated
    public C1534d(C0653h c0653h) {
        this(c0653h.getContext(), c0653h.getClass().getName());
    }

    public SharedPreferences mo843a() {
        return this.f3828a;
    }

    public Editor mo845b() {
        return this.f3828a.edit();
    }

    @TargetApi(9)
    public boolean mo844a(Editor editor) {
        if (VERSION.SDK_INT < 9) {
            return editor.commit();
        }
        editor.apply();
        return true;
    }
}
