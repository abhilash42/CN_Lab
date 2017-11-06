package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.C1032p;
import com.google.android.gms.measurement.internal.C1139q.C1141a;

public class C1171z extends C1141a {
    private final C1164y f2514a;
    private final boolean f2515b;

    public C1171z(C1164y c1164y) {
        C1032p.m3678a((Object) c1164y);
        this.f2514a = c1164y;
        this.f2515b = false;
    }

    public C1171z(C1164y c1164y, boolean z) {
        C1032p.m3678a((Object) c1164y);
        this.f2514a = c1164y;
        this.f2515b = z;
    }

    private void m4539b(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f2514a.m4518f().m4399b().m4387a("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        try {
            m4540c(str);
        } catch (SecurityException e) {
            this.f2514a.m4518f().m4399b().m4388a("Measurement Service called with invalid calling package", str);
            throw e;
        }
    }

    private void m4540c(String str) {
        int myUid = this.f2515b ? Process.myUid() : Binder.getCallingUid();
        if (!GooglePlayServicesUtil.zzb(this.f2514a.m4526n(), myUid, str)) {
            if (!GooglePlayServicesUtil.zze(this.f2514a.m4526n(), myUid) || this.f2514a.m4534v()) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
        }
    }

    public void mo750a(final AppMetadata appMetadata) {
        C1032p.m3678a((Object) appMetadata);
        m4539b(appMetadata.f2253b);
        this.f2514a.m4519g().m4478a(new Runnable(this) {
            final /* synthetic */ C1171z f2513b;

            public void run() {
                this.f2513b.m4545a(appMetadata.f2259h);
                this.f2513b.f2514a.m4512b(appMetadata);
            }
        });
    }

    public void mo751a(final EventParcel eventParcel, final AppMetadata appMetadata) {
        C1032p.m3678a((Object) eventParcel);
        C1032p.m3678a((Object) appMetadata);
        m4539b(appMetadata.f2253b);
        this.f2514a.m4519g().m4478a(new Runnable(this) {
            final /* synthetic */ C1171z f2501c;

            public void run() {
                this.f2501c.m4545a(appMetadata.f2259h);
                this.f2501c.f2514a.m4507a(eventParcel, appMetadata);
            }
        });
    }

    public void mo752a(final EventParcel eventParcel, final String str, final String str2) {
        C1032p.m3678a((Object) eventParcel);
        C1032p.m3680a(str);
        m4539b(str);
        this.f2514a.m4519g().m4478a(new Runnable(this) {
            final /* synthetic */ C1171z f2505d;

            public void run() {
                this.f2505d.m4545a(str2);
                this.f2505d.f2514a.m4508a(eventParcel, str);
            }
        });
    }

    public void mo753a(final UserAttributeParcel userAttributeParcel, final AppMetadata appMetadata) {
        C1032p.m3678a((Object) userAttributeParcel);
        C1032p.m3678a((Object) appMetadata);
        m4539b(appMetadata.f2253b);
        if (userAttributeParcel.m4069a() == null) {
            this.f2514a.m4519g().m4478a(new Runnable(this) {
                final /* synthetic */ C1171z f2508c;

                public void run() {
                    this.f2508c.m4545a(appMetadata.f2259h);
                    this.f2508c.f2514a.m4513b(userAttributeParcel, appMetadata);
                }
            });
        } else {
            this.f2514a.m4519g().m4478a(new Runnable(this) {
                final /* synthetic */ C1171z f2511c;

                public void run() {
                    this.f2511c.m4545a(appMetadata.f2259h);
                    this.f2511c.f2514a.m4509a(userAttributeParcel, appMetadata);
                }
            });
        }
    }

    void m4545a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(":", 2);
            if (split.length == 2) {
                try {
                    long longValue = Long.valueOf(split[0]).longValue();
                    if (longValue > 0) {
                        this.f2514a.m4517e().f2446b.m4452a(split[1], longValue);
                    } else {
                        this.f2514a.m4518f().m4412o().m4388a("Combining sample with a non-positive weight", Long.valueOf(longValue));
                    }
                } catch (NumberFormatException e) {
                    this.f2514a.m4518f().m4412o().m4388a("Combining sample with a non-number weight", split[0]);
                }
            }
        }
    }

    public void mo754b(final AppMetadata appMetadata) {
        C1032p.m3678a((Object) appMetadata);
        m4539b(appMetadata.f2253b);
        this.f2514a.m4519g().m4478a(new Runnable(this) {
            final /* synthetic */ C1171z f2498b;

            public void run() {
                this.f2498b.m4545a(appMetadata.f2259h);
                this.f2498b.f2514a.m4506a(appMetadata);
            }
        });
    }
}
