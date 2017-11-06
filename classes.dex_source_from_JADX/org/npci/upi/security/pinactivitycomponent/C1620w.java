package org.npci.upi.security.pinactivitycomponent;

import android.app.Activity;
import android.content.Context;
import android.os.ResultReceiver;
import in.org.npci.commonlibrary.C1355e;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

public class C1620w {
    private Map f4402a = new HashMap();
    private Context f4403b;
    private Properties f4404c;
    private Properties f4405d;
    private Properties f4406e;
    private C1617t f4407f;
    private ac f4408g;
    private Locale f4409h;
    private C1355e f4410i;
    private Activity f4411j;
    private an f4412k;
    private ab f4413l;

    public C1620w(Context context, an anVar, Activity activity) {
        this.f4412k = anVar;
        this.f4409h = anVar.m6497b();
        this.f4403b = context;
        this.f4410i = anVar.m6498c();
        this.f4411j = activity;
        this.f4406e = m6574a(CLConstants.CL_PROPERTIES);
        this.f4404c = m6574a(CLConstants.VALIDATION_PROPERTIES);
        this.f4405d = m6574a(CLConstants.VERSION_PROPERTIES);
        if (this.f4409h != null) {
            this.f4402a.put(this.f4409h.getLanguage(), m6574a("cl-messages_" + this.f4409h.getLanguage() + ".properties"));
        } else {
            Locale locale = new Locale(CLConstants.DEFAULT_LANGUAGE_PREFERENCE);
            this.f4402a.put(locale.getLanguage(), m6574a("cl-messages_" + locale.getLanguage() + ".properties"));
        }
        this.f4413l = anVar.m6499d();
        this.f4407f = new C1617t(this);
        if (anVar != null && anVar.m6498c() != null && anVar.m6495a() != null) {
            this.f4408g = new ac(this.f4410i, this.f4413l, anVar.m6495a());
        }
    }

    public Properties m6574a(String str) {
        Properties properties = new Properties();
        try {
            properties.load(this.f4403b.getAssets().open(str));
        } catch (IOException e) {
            C1605g.m6535a("AssetsPropertyReader", e.toString());
        }
        return properties;
    }

    public C1617t m6575a() {
        return this.f4407f;
    }

    public String m6576b(String str) {
        return this.f4405d != null ? this.f4405d.getProperty(str) : null;
    }

    public ac m6577b() {
        String str = null;
        if (this.f4408g == null && this.f4412k != null) {
            this.f4410i = this.f4412k.m6498c();
            this.f4408g = new ac(this.f4412k.m6498c(), this.f4412k.m6499d(), this.f4412k.m6495a());
        }
        C1605g.m6536b("Common Library", "get Encryptor");
        C1605g.m6536b("Common Library", "Input Analyzer :" + this.f4412k);
        C1605g.m6536b("Common Library", new StringBuilder().append("Input Analyzer Key Code:").append(this.f4412k).toString() == null ? null : this.f4412k.m6495a());
        String str2 = "Common Library";
        if (("Input Analyzer Common Library:" + this.f4412k) != null) {
            str = this.f4412k.m6498c().toString();
        }
        C1605g.m6536b(str2, str);
        return this.f4408g;
    }

    public Activity m6578c() {
        return this.f4411j;
    }

    public ResultReceiver m6579d() {
        return this.f4412k == null ? null : this.f4412k.m6500e();
    }
}
