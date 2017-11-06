package org.npci.upi.security.pinactivitycomponent;

import android.content.Context;
import android.util.Base64;
import in.org.npci.commonlibrary.C1362l;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;

public class C1639z {
    private Context f4479a;
    private String f4480b = "";
    private ab f4481c = null;
    private aa f4482d;
    private String f4483e = "";

    public C1639z(Context context) {
        try {
            this.f4479a = context;
            this.f4481c = new ab(context);
            this.f4482d = new aa();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private boolean m6629b(String str, String str2, String str3, String str4) {
        try {
            String b = this.f4481c.m6484b();
            C1605g.m6536b("Token in CL", b);
            b = Base64.encodeToString(this.f4482d.m6479b(Base64.decode(str, 0), this.f4482d.m6478b(b)), 0);
            String str5 = str2 + CLConstants.SALT_DELIMETER + str3 + CLConstants.SALT_DELIMETER + str4;
            C1605g.m6536b("CL Hmac Msg", str5);
            str5 = Base64.encodeToString(this.f4482d.m6476a(str5), 0);
            C1605g.m6536b("CL Hash", str5);
            return str5.equalsIgnoreCase(b);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        } catch (IllegalBlockSizeException e2) {
            e2.printStackTrace();
            return false;
        } catch (BadPaddingException e3) {
            e3.printStackTrace();
            return false;
        } catch (InvalidAlgorithmParameterException e4) {
            e4.printStackTrace();
            return false;
        } catch (InvalidKeyException e5) {
            e5.printStackTrace();
            return false;
        } catch (UnsupportedEncodingException e6) {
            e6.printStackTrace();
            return false;
        } catch (Exception e7) {
            e7.printStackTrace();
            return false;
        }
    }

    public String m6630a() {
        String str = "";
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(256);
            return this.f4482d.m6475a(instance.generateKey().getEncoded());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String m6631a(String str, String str2) {
        String a;
        Exception e;
        String str3 = "";
        String str4 = "";
        String format = new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis()));
        try {
            this.f4480b = m6633b();
            str3 = m6630a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            aa aaVar = new aa();
            if (str.equalsIgnoreCase(CLConstants.MODE_INITIAL)) {
                this.f4481c.m6485c();
                if (this.f4481c.m6481a().size() > 0) {
                    this.f4481c.m6483b(new C1618u(str3, this.f4480b, format));
                } else {
                    this.f4481c.m6482a(new C1618u(str3, this.f4480b, format));
                }
                a = aaVar.m6474a(this.f4480b + CLConstants.SALT_DELIMETER + str3 + CLConstants.SALT_DELIMETER + str2, C1362l.m5190a());
                try {
                    C1605g.m6536b("K0 in Challenge", str3);
                    C1605g.m6536b("token in Challenge", this.f4480b);
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    return a;
                }
                return a;
            }
            a = ((C1618u) this.f4481c.m6481a().get(0)).m6568a();
            str4 = this.f4480b + CLConstants.SALT_DELIMETER + str3 + CLConstants.SALT_DELIMETER + str2;
            C1605g.m6536b("K0 in Challenge", str3);
            C1605g.m6536b("token in Challenge", this.f4480b);
            a = Base64.encodeToString(aaVar.m6477a(str4.getBytes(), aaVar.m6478b(a)), 0);
            this.f4481c.m6485c();
            this.f4481c.m6482a(new C1618u(str3, this.f4480b, format));
            return a;
        } catch (Exception e22) {
            Exception exception = e22;
            a = str4;
            e = exception;
            e.printStackTrace();
            return a;
        }
    }

    public boolean m6632a(String str, String str2, String str3, String str4) {
        C1605g.m6536b("hmac", str4);
        return m6629b(str4, str, str2, str3);
    }

    public String m6633b() {
        String str = "";
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(256);
            return this.f4482d.m6475a(instance.generateKey().getEncoded());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
