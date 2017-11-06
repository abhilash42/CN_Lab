package org.npci.upi.security.pinactivitycomponent;

import android.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class C1617t {
    private String f4391a = m6565a("MS03LTItNA==");
    private C1620w f4392b;

    C1617t(C1620w c1620w) {
        this.f4392b = c1620w;
    }

    private String m6565a(String str) {
        String str2 = "";
        for (String b : new String(Base64.decode(str, -1)).split("-")) {
            str2 = str2 + this.f4392b.m6576b(b);
        }
        return new String(Base64.decode(str2, -1));
    }

    private void m6566b(JSONObject jSONObject) {
    }

    public String m6567a(JSONObject jSONObject) {
        try {
            m6566b(jSONObject);
            StringBuilder stringBuilder = new StringBuilder();
            C1605g.m6536b("Common Library", "Salt Format: " + this.f4391a);
            CharSequence charSequence = this.f4391a;
            C1605g.m6536b("Common Library", "Temp Salt Format: " + charSequence);
            if (!(charSequence == null || charSequence.isEmpty())) {
                Matcher matcher = Pattern.compile("\\[([^\\]]*)\\]").matcher(charSequence);
                StringBuffer stringBuffer = new StringBuffer(1000);
                while (matcher.find()) {
                    String group = matcher.group();
                    matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(jSONObject.optString(group.substring(1, group.length() - 1))));
                }
                matcher.appendTail(stringBuffer);
                String stringBuffer2 = stringBuffer.toString();
                C1605g.m6536b("Common Library", "Output Salt: " + stringBuffer2);
                return stringBuffer2;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
