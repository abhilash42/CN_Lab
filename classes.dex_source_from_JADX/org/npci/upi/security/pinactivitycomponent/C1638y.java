package org.npci.upi.security.pinactivitycomponent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import org.npci.upi.security.services.C1637b;
import org.npci.upi.security.services.C1640d;

class C1638y extends C1637b {
    final /* synthetic */ CLRemoteServiceImpl f4477a;
    private Context f4478b;

    private C1638y(CLRemoteServiceImpl cLRemoteServiceImpl, Context context) {
        this.f4477a = cLRemoteServiceImpl;
        this.f4478b = null;
        this.f4478b = context;
    }

    public String mo905a(String str, String str2) {
        return this.f4477a.f4291b.m6631a(str, str2);
    }

    public void mo906a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, C1640d c1640d) {
        Bundle a = this.f4477a.m6437a(str, str2, str3, str4, str5, str6, str7, str8, c1640d);
        Intent intent = new Intent(this.f4478b, GetCredential.class);
        intent.setFlags(268435456);
        intent.putExtras(a);
        this.f4478b.startActivity(intent);
    }

    public boolean mo907a(String str, String str2, String str3, String str4) {
        return this.f4477a.f4291b.m6632a(str, str2, str3, str4);
    }
}
