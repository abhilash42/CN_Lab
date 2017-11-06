package in.org.npci.upiapp.core;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import in.org.npci.upiapp.p036a.C1380a;
import in.org.npci.upiapp.utils.C1436b;
import in.org.npci.upiapp.utils.C1442e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* compiled from: OtpUtils */
public class C1419d {
    private static final String f3524a = C1419d.class.getName();
    private static C1419d f3525b;
    private List<String> f3526c;

    private C1419d() {
    }

    public static void m5370a() {
        f3525b = null;
        C1419d.m5375b();
    }

    public static C1419d m5375b() {
        if (f3525b == null) {
            f3525b = new C1419d();
        }
        return f3525b;
    }

    private boolean m5371a(Context context, String str) {
        if (this.f3526c == null) {
            this.f3526c = Arrays.asList(new C1442e(context).m5484b(CLConstants.MGS_ID_PREFERENCES, "").split(","));
        }
        return this.f3526c.contains(str);
    }

    private boolean m5377b(Context context, C1418c c1418c) {
        return (m5371a(context, c1418c.m5364d()) || m5371a(context, m5367a(c1418c))) ? false : true;
    }

    private void m5376b(Context context, String str) {
        if (str != null) {
            C1442e c1442e = new C1442e(context);
            ArrayList arrayList = new ArrayList(Arrays.asList(c1442e.m5484b(CLConstants.MGS_ID_PREFERENCES, "").split(",")));
            if (!arrayList.contains(str)) {
                if (arrayList.size() >= 10) {
                    arrayList.remove(0);
                }
                arrayList.add(str);
                c1442e.m5483a(CLConstants.MGS_ID_PREFERENCES, m5368a(arrayList));
            }
        }
    }

    private String m5368a(ArrayList<String> arrayList) {
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

    private boolean m5374a(String str, Map<String, Object> map) {
        return str.equalsIgnoreCase(m5369a((Map) map));
    }

    private boolean m5378b(String str, Map<String, Object> map) {
        List list = (List) ((Map) map.get("matches")).get("sender");
        if (list != null) {
            return m5373a(str, list);
        }
        return false;
    }

    private boolean m5379c(String str, Map<String, Object> map) {
        String str2 = (String) ((Map) map.get("matches")).get("message");
        if (str2 != null) {
            return m5372a(str, str2);
        }
        return false;
    }

    public C1418c m5381a(String str, String str2, Date date, String str3, Map<String, Object> map) {
        Object obj = 1;
        try {
            boolean a = m5374a(str3, (Map) map);
            Object obj2 = (a && m5378b(str, (Map) map)) ? 1 : null;
            if (obj2 == null || !m5379c(str2, map)) {
                obj = null;
            }
            if (obj != null) {
                return m5366a(str2, map, date);
            }
            if (!a && "unknown_bank".equals(str3) && m5378b(str, (Map) map) && m5379c(str2, map)) {
                return m5366a(str2, map, date);
            }
            return null;
        } catch (Throwable e) {
            C1380a.m5276a(f3524a, "Exception while extracting OTP", e);
        }
    }

    private String m5369a(Map<String, Object> map) {
        if (map.get("bank") != null) {
            return map.get("bank").toString().toUpperCase();
        }
        return null;
    }

    private C1418c m5366a(String str, Map<String, Object> map, Date date) {
        int intValue;
        String str2 = (String) map.get(CLConstants.OTP);
        String toUpperCase = ((String) map.get("bank")).toUpperCase();
        Matcher matcher = Pattern.compile(str2).matcher(str);
        if (map.containsKey("group")) {
            intValue = ((Integer) map.get("group")).intValue();
        } else {
            intValue = 0;
        }
        C1418c c1418c = new C1418c();
        c1418c.m5361b(str);
        c1418c.m5359a(date);
        if (!matcher.find() || intValue > matcher.groupCount()) {
            return null;
        }
        c1418c.m5358a(toUpperCase);
        c1418c.m5363c(matcher.group(intValue));
        return c1418c;
    }

    private boolean m5372a(String str, String str2) {
        return Pattern.compile(str2, 2).matcher(str).find();
    }

    private boolean m5373a(String str, List<String> list) {
        for (String compile : list) {
            if (Pattern.compile(compile, 2).matcher(str).find()) {
                return true;
            }
        }
        return false;
    }

    public C1418c m5380a(Context context, String str, Map<String, Object> map, long j) {
        Throwable e;
        Cursor cursor;
        Uri parse = Uri.parse("content://sms/inbox");
        String[] strArr = new String[]{"_id", "address", "body", "date"};
        String str2 = "date > ?";
        String str3 = "date DESC";
        Cursor query;
        try {
            query = context.getContentResolver().query(parse, strArr, str2, new String[]{"" + j}, str3);
            while (query.moveToNext()) {
                try {
                    String string = query.getString(1);
                    String string2 = query.getString(2);
                    C1418c a = m5381a(string, string2, new Date(query.getLong(3)), str, map);
                    if (a == null) {
                        a = m5381a(string, string2, new Date(query.getLong(3)), "BHIM", map);
                    }
                    if (a != null) {
                        a.m5365d(String.valueOf(Long.valueOf(query.getLong(query.getColumnIndex("_id")))));
                        if (!m5377b(context, a)) {
                            C1380a.m5275a(f3524a, "Processed Message:  - " + a);
                        } else if (query == null) {
                            return a;
                        } else {
                            query.close();
                            return a;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = query;
                } catch (Throwable th) {
                    e = th;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
            try {
                C1380a.m5276a(f3524a, "Exception while reading sms", e);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th2) {
                e = th2;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw e;
            }
        } catch (Throwable th3) {
            e = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw e;
        }
        return null;
    }

    public void m5382a(Context context, C1418c c1418c) {
        m5376b(context, c1418c.m5364d() != null ? c1418c.m5364d() : m5367a(c1418c));
    }

    private String m5367a(C1418c c1418c) {
        return C1436b.m5450b(c1418c.m5357a() + c1418c.m5360b().getTime());
    }

    public void m5383c() {
        f3525b = null;
        if (this.f3526c != null) {
            this.f3526c = null;
        }
    }
}
