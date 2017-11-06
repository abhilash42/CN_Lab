package com.google.android.gms.common;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.C0994f.C0754a;
import com.google.android.gms.common.C0994f.ab;

public class C0995g {
    private static final C0995g f1933a = new C0995g();

    private C0995g() {
    }

    public static C0995g m3451a() {
        return f1933a;
    }

    private boolean m3452a(PackageInfo packageInfo, boolean z) {
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return false;
        }
        C0754a abVar = new ab(packageInfo.signatures[0].toByteArray());
        if ((z ? C0994f.m3447a() : C0994f.m3450b()).contains(abVar)) {
            return true;
        }
        if (Log.isLoggable("GoogleSignatureVerifier", 2)) {
            Log.v("GoogleSignatureVerifier", "Signature not valid.  Found: \n" + Base64.encodeToString(abVar.mo660a(), 0));
        }
        return false;
    }

    C0754a m3453a(PackageInfo packageInfo, C0754a... c0754aArr) {
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        C0754a abVar = new ab(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < c0754aArr.length; i++) {
            if (c0754aArr[i].equals(abVar)) {
                return c0754aArr[i];
            }
        }
        if (Log.isLoggable("GoogleSignatureVerifier", 2)) {
            Log.v("GoogleSignatureVerifier", "Signature not valid.  Found: \n" + Base64.encodeToString(abVar.mo660a(), 0));
        }
        return null;
    }

    public boolean m3454a(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (GooglePlayServicesUtil.zzc(packageManager)) {
            return m3452a(packageInfo, true);
        }
        boolean a = m3452a(packageInfo, false);
        if (a || !m3452a(packageInfo, true)) {
            return a;
        }
        Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        return a;
    }

    public boolean m3455a(PackageManager packageManager, String str) {
        try {
            return m3454a(packageManager, packageManager.getPackageInfo(str, 64));
        } catch (NameNotFoundException e) {
            if (Log.isLoggable("GoogleSignatureVerifier", 3)) {
                Log.d("GoogleSignatureVerifier", "Package manager can't find package " + str + ", defaulting to false");
            }
            return false;
        }
    }
}
