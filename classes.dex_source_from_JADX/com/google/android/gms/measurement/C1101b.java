package com.google.android.gms.measurement;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.C0729a.C0726b;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C1032p;

public final class C1101b {
    private static volatile C1101b f2248d;
    private final String f2249a;
    private final Status f2250b;
    private final boolean f2251c;

    C1101b(Context context) {
        boolean z = true;
        Resources resources = context.getResources();
        String resourcePackageName = resources.getResourcePackageName(C0726b.common_google_play_services_unknown_issue);
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resourcePackageName);
        if (identifier != 0 && resources.getInteger(identifier) == 0) {
            z = false;
        }
        this.f2251c = z;
        int identifier2 = resources.getIdentifier("google_app_id", "string", resourcePackageName);
        if (identifier2 == 0) {
            if (this.f2251c) {
                this.f2250b = new Status(10, "Missing an expected resource: 'R.string.google_app_id' for initializing Google services.  Possible causes are missing google-services.json or com.google.gms.google-services gradle plugin.");
            } else {
                this.f2250b = Status.f1761a;
            }
            this.f2249a = null;
            return;
        }
        String string = resources.getString(identifier2);
        if (TextUtils.isEmpty(string)) {
            if (this.f2251c) {
                this.f2250b = new Status(10, "The resource 'R.string.google_app_id' is invalid, expected an app  identifier and found: '" + string + "'.");
            } else {
                this.f2250b = Status.f1761a;
            }
            this.f2249a = null;
            return;
        }
        this.f2249a = string;
        this.f2250b = Status.f1761a;
    }

    public static Status m4059a(Context context) {
        C1032p.m3679a((Object) context, (Object) "Context must not be null.");
        if (f2248d == null) {
            synchronized (C1101b.class) {
                if (f2248d == null) {
                    f2248d = new C1101b(context);
                }
            }
        }
        return f2248d.f2250b;
    }

    public static String m4060a() {
        if (f2248d == null) {
            synchronized (C1101b.class) {
                if (f2248d == null) {
                    throw new IllegalStateException("Initialize must be called before getGoogleAppId.");
                }
            }
        }
        return f2248d.m4062b();
    }

    public static boolean m4061c() {
        if (f2248d == null) {
            synchronized (C1101b.class) {
                if (f2248d == null) {
                    throw new IllegalStateException("Initialize must be called before isMeasurementEnabled.");
                }
            }
        }
        return f2248d.m4063d();
    }

    String m4062b() {
        if (this.f2250b.m3187d()) {
            return this.f2249a;
        }
        throw new IllegalStateException("Initialize must be successful before calling getGoogleAppId.  The result of the previous call to initialize was: '" + this.f2250b + "'.");
    }

    boolean m4063d() {
        if (this.f2250b.m3187d()) {
            return this.f2251c;
        }
        throw new IllegalStateException("Initialize must be successful before calling isMeasurementEnabledInternal.  The result of the previous call to initialize was: '" + this.f2250b + "'.");
    }
}
