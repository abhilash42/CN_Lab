package org.npci.upi.security.pinactivitycomponent;

import in.org.npci.commonlibrary.C1355e;
import in.org.npci.commonlibrary.C1356f;
import in.org.npci.commonlibrary.Message;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class ac {
    private C1355e f4321a;
    private String f4322b;
    private ab f4323c;

    public ac(C1355e c1355e, ab abVar, String str) {
        this.f4321a = c1355e;
        this.f4322b = str;
        this.f4323c = abVar;
    }

    private Message m6486a(String str, String str2, String str3, String str4, String str5, String str6) {
        Message a;
        C1356f e;
        try {
            a = this.f4321a.m5174a(this.f4322b, str4, str5, str, str6);
            try {
                a.setType(str2);
                a.setSubType(str3);
                a.getData().setEncryptedBase64String("2.0|" + a.getData().getEncryptedBase64String());
            } catch (C1356f e2) {
                e = e2;
                e.printStackTrace();
                return a;
            }
        } catch (C1356f e3) {
            e = e3;
            a = null;
            e.printStackTrace();
            return a;
        }
        return a;
    }

    public Message m6487a(String str, String str2, String str3, JSONObject jSONObject) {
        try {
            Message a;
            String string = jSONObject.getString(CLConstants.SALT_FIELD_TXN_ID);
            String string2 = jSONObject.getString(CLConstants.SALT_FIELD_CREDENTIAL);
            String string3 = jSONObject.getString(CLConstants.SALT_FIELD_APP_ID);
            String string4 = jSONObject.getString(CLConstants.SALT_FIELD_DEVICE_ID);
            String string5 = jSONObject.getString(CLConstants.SALT_FIELD_MOBILE_NUMBER);
            C1605g.m6536b("DBH in encryptor", this.f4323c == null ? "null" : this.f4323c.toString());
            string5 = this.f4323c.m6480a(string3, string4, string5);
            C1605g.m6536b("K0 in encryptor", string5);
            Matcher matcher = Pattern.compile("\\{([^}]*)\\}").matcher(str);
            StringBuffer stringBuffer = new StringBuffer();
            if (matcher.find()) {
                String group = matcher.group();
                a = m6486a(group.substring(1, group.length() - 1), str2, str3, string, string2, string5);
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(a.getData().getEncryptedBase64String().replaceAll("\n", "")));
            } else {
                a = null;
            }
            if (stringBuffer.length() > 0) {
                matcher.appendTail(stringBuffer);
            }
            if (a == null) {
                return a;
            }
            String stringBuffer2 = stringBuffer.toString();
            C1605g.m6536b("CommonLibrary", "Encrypted Data: " + stringBuffer2);
            a.getData().setEncryptedBase64String(stringBuffer2);
            return a;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
