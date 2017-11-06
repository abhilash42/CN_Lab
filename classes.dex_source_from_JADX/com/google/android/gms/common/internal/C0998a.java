package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.C0996l.C0997a;

public class C0998a extends C0997a {
    int f1948a;
    private Account f1949b;
    private Context f1950c;

    public static Account m3468a(C0996l c0996l) {
        Account account = null;
        if (c0996l != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = c0996l.mo662a();
            } catch (RemoteException e) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return account;
    }

    public Account mo662a() {
        int callingUid = Binder.getCallingUid();
        if (callingUid == this.f1948a) {
            return this.f1949b;
        }
        if (GooglePlayServicesUtil.zze(this.f1950c, callingUid)) {
            this.f1948a = callingUid;
            return this.f1949b;
        }
        throw new SecurityException("Caller is not GooglePlayServices");
    }

    public boolean equals(Object obj) {
        return this == obj ? true : !(obj instanceof C0998a) ? false : this.f1949b.equals(((C0998a) obj).f1949b);
    }
}
