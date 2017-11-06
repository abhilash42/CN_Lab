package org.npci.upi.security.pinactivitycomponent;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C1614q {
    private static final String f4380b = C1614q.class.getName();
    JSONArray f4381a = null;
    private Context f4382c;
    private ap f4383d;
    private List f4384e;

    public C1614q(Context context) {
        this.f4382c = context;
        this.f4383d = new ap(this.f4382c);
        this.f4381a = new JSONArray();
        byte[] a = ae.m6489a("npci_otp_rules.json", context);
        if (a != null) {
            try {
                this.f4381a = new JSONArray(new String(a));
            } catch (Exception e) {
                C1605g.m6534a(f4380b, e);
            }
        }
    }

    public static String m6543a(String str) {
        String toLowerCase = str.toLowerCase();
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(toLowerCase.getBytes(), 0, toLowerCase.length());
            toLowerCase = new BigInteger(1, instance.digest()).toString(16);
            while (toLowerCase.length() < 32) {
                toLowerCase = "0" + toLowerCase;
            }
            return toLowerCase;
        } catch (Exception e) {
            C1605g.m6534a(f4380b, e);
            return null;
        }
    }

    private String m6544a(ArrayList arrayList) {
        if (arrayList.size() <= 0) {
            return null;
        }
        String str = "" + ((String) arrayList.get(0));
        int i = 1;
        while (i < arrayList.size()) {
            String str2 = str + "," + ((String) arrayList.get(i));
            i++;
            str = str2;
        }
        return str;
    }

    private C1613p m6545a(int i, String str, String str2, JSONObject jSONObject) {
        try {
            if (!m6547a(str2, jSONObject.getJSONArray("sender"))) {
                return null;
            }
            if (!m6546a(str, jSONObject.getString("message"))) {
                return null;
            }
            Matcher matcher = Pattern.compile(i != 0 ? "\\d{" + i + "}" : (String) jSONObject.get(CLConstants.OTP)).matcher(str);
            C1613p c1613p = new C1613p();
            c1613p.m6538a(str);
            if (!matcher.find() || 0 > matcher.groupCount()) {
                return null;
            }
            c1613p.m6540b(matcher.group(0));
            return c1613p;
        } catch (JSONException e) {
            return null;
        }
    }

    private boolean m6546a(String str, String str2) {
        return Pattern.compile(str2, 2).matcher(str).find();
    }

    private boolean m6547a(String str, JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            if (Pattern.compile(jSONArray.getString(i), 2).matcher(str).find()) {
                return true;
            }
        }
        return false;
    }

    private boolean m6548b(String str) {
        if (this.f4384e == null) {
            this.f4384e = Arrays.asList(this.f4383d.m6504b(CLConstants.MGS_ID_PREFERENCES, "").split(","));
        }
        return this.f4384e.contains(str);
    }

    private boolean m6549b(C1613p c1613p) {
        return (m6548b(c1613p.m6541c()) || m6548b(m6550c(c1613p))) ? false : true;
    }

    private String m6550c(C1613p c1613p) {
        return C1614q.m6543a(c1613p.m6537a());
    }

    private void m6551c(String str) {
        if (str != null) {
            ArrayList arrayList = new ArrayList(Arrays.asList(this.f4383d.m6504b(CLConstants.MGS_ID_PREFERENCES, "").split(",")));
            if (!arrayList.contains(str)) {
                if (arrayList.size() >= 10) {
                    arrayList.remove(0);
                }
                arrayList.add(str);
                this.f4383d.m6503a(CLConstants.MGS_ID_PREFERENCES, m6544a(arrayList));
            }
        }
    }

    public C1613p m6552a(int i, long j) {
        Cursor cursor;
        Exception e;
        Throwable th;
        Uri parse = Uri.parse("content://sms/inbox");
        String[] strArr = new String[]{"_id", "address", "body", "date"};
        String format = String.format("date > ?", new Object[0]);
        String str = "date DESC";
        Cursor query;
        try {
            query = this.f4382c.getContentResolver().query(parse, strArr, format, new String[]{"" + j}, str);
            while (query.moveToNext()) {
                try {
                    C1613p a = m6553a(i, query.getString(1), query.getString(2));
                    if (a != null) {
                        a.m6542c(String.valueOf(Long.valueOf(query.getLong(query.getColumnIndex("_id")))));
                        if (m6549b(a)) {
                            m6554a(a);
                            if (query == null) {
                                return a;
                            }
                            query.close();
                            return a;
                        }
                    }
                } catch (SecurityException e2) {
                    cursor = query;
                } catch (Exception e3) {
                    e = e3;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (SecurityException e4) {
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Exception e5) {
            e = e5;
            query = null;
            try {
                C1605g.m6534a(f4380b, e);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return null;
    }

    public C1613p m6553a(int i, String str, String str2) {
        int i2 = 0;
        while (i2 < this.f4381a.length()) {
            try {
                C1613p a = m6545a(i, str2, str, this.f4381a.getJSONObject(i2));
                if (a != null) {
                    return a;
                }
                i2++;
            } catch (Exception e) {
                C1605g.m6534a(f4380b, e);
                return null;
            }
        }
        return null;
    }

    public void m6554a(C1613p c1613p) {
        m6551c(c1613p.m6541c() != null ? c1613p.m6541c() : m6550c(c1613p));
    }
}
