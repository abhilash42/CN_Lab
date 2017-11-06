package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C1032p;
import com.google.android.gms.internal.C1075e;
import com.google.android.gms.measurement.C1101b;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

public class C1142r extends ab {
    private static final X500Principal f2396a = new X500Principal("CN=Android Debug,O=Android,C=US");
    private String f2397b;
    private String f2398c;
    private String f2399d;
    private String f2400e;
    private long f2401f;
    private String f2402h;

    C1142r(C1164y c1164y) {
        super(c1164y);
    }

    static long m4365a(byte[] bArr) {
        long j = null;
        C1032p.m3678a((Object) bArr);
        C1032p.m3682a(bArr.length > 0);
        long j2 = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j2 += (((long) bArr[length]) & 255) << j;
            j += 8;
            length--;
        }
        return j2;
    }

    AppMetadata m4366a(String str) {
        return new AppMetadata(this.f2397b, m4368b(), this.f2398c, this.f2399d, mo745n().m4245B(), m4381o(), str, mo744m().m4465r());
    }

    protected void mo733a() {
        String str = "Unknown";
        String str2 = "Unknown";
        PackageManager packageManager = mo740i().getPackageManager();
        String packageName = mo740i().getPackageName();
        String installerPackageName = packageManager.getInstallerPackageName(packageName);
        if (installerPackageName == null) {
            installerPackageName = "manual_install";
        } else if (GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE.equals(installerPackageName)) {
            installerPackageName = "";
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(mo740i().getPackageName(), 0);
            if (packageInfo != null) {
                CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                if (!TextUtils.isEmpty(applicationLabel)) {
                    str2 = applicationLabel.toString();
                }
                str = packageInfo.versionName;
            }
        } catch (NameNotFoundException e) {
            mo743l().m4399b().m4388a("Error retrieving package info: appName", str2);
        }
        this.f2397b = packageName;
        this.f2399d = installerPackageName;
        this.f2398c = str;
        this.f2400e = str2;
        long j = 0;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            if (!m4382p()) {
                PackageInfo packageInfo2 = packageManager.getPackageInfo(mo740i().getPackageName(), 64);
                if (!(instance == null || packageInfo2.signatures == null || packageInfo2.signatures.length <= 0)) {
                    j = C1142r.m4365a(instance.digest(packageInfo2.signatures[0].toByteArray()));
                }
            }
        } catch (NoSuchAlgorithmException e2) {
            mo743l().m4399b().m4388a("Could not get MD5 instance", e2);
        } catch (NameNotFoundException e3) {
            mo743l().m4399b().m4388a("Package name not found", e3);
        }
        this.f2401f = j;
    }

    String m4368b() {
        m4091y();
        if (mo745n().m4246C()) {
            return "";
        }
        if (this.f2402h == null) {
            Status a = C1101b.m4059a(mo740i());
            if (a == null || !a.m3187d()) {
                this.f2402h = "";
                mo743l().m4399b().m4388a("getGoogleAppId failed with status", Integer.valueOf(a == null ? 0 : a.m3188e()));
                if (!(a == null || a.m3185b() == null)) {
                    mo743l().m4416s().m4387a(a.m3185b());
                }
            } else {
                try {
                    if (C1101b.m4061c()) {
                        String a2 = C1101b.m4060a();
                        if (TextUtils.isEmpty(a2)) {
                            a2 = "";
                        }
                        this.f2402h = a2;
                    } else {
                        this.f2402h = "";
                    }
                } catch (IllegalStateException e) {
                    this.f2402h = "";
                    mo743l().m4399b().m4388a("getGoogleAppId or isMeasurementEnabled failed with exception", e);
                }
            }
        }
        return this.f2402h;
    }

    public /* bridge */ /* synthetic */ void mo734c() {
        super.mo734c();
    }

    public /* bridge */ /* synthetic */ void mo735d() {
        super.mo735d();
    }

    public /* bridge */ /* synthetic */ void mo736e() {
        super.mo736e();
    }

    public /* bridge */ /* synthetic */ C1142r mo737f() {
        return super.mo737f();
    }

    public /* bridge */ /* synthetic */ ae mo738g() {
        return super.mo738g();
    }

    public /* bridge */ /* synthetic */ C1075e mo739h() {
        return super.mo739h();
    }

    public /* bridge */ /* synthetic */ Context mo740i() {
        return super.mo740i();
    }

    public /* bridge */ /* synthetic */ C1126f mo741j() {
        return super.mo741j();
    }

    public /* bridge */ /* synthetic */ C1161x mo742k() {
        return super.mo742k();
    }

    public /* bridge */ /* synthetic */ C1146t mo743l() {
        return super.mo743l();
    }

    public /* bridge */ /* synthetic */ C1157w mo744m() {
        return super.mo744m();
    }

    public /* bridge */ /* synthetic */ C1128h mo745n() {
        return super.mo745n();
    }

    long m4381o() {
        m4091y();
        return this.f2401f;
    }

    boolean m4382p() {
        try {
            PackageInfo packageInfo = mo740i().getPackageManager().getPackageInfo(mo740i().getPackageName(), 64);
            if (!(packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0)) {
                return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(f2396a);
            }
        } catch (CertificateException e) {
            mo743l().m4399b().m4388a("Error obtaining certificate", e);
        } catch (NameNotFoundException e2) {
            mo743l().m4399b().m4388a("Package name not found", e2);
        }
        return true;
    }
}
