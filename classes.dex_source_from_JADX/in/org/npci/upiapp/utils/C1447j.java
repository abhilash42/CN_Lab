package in.org.npci.upiapp.utils;

import android.content.Context;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import in.org.npci.upiapp.p036a.C1380a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Utils */
public class C1447j {
    private static final String f3618a = C1447j.class.getName();

    public static String m5498a(Context context) {
        String deviceId;
        if (context != null) {
            try {
                deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            } catch (Throwable e) {
                Throwable th = e;
                deviceId = null;
                Throwable th2 = th;
                C1380a.m5276a(f3618a, "Error getting deviceId ", th2);
                return deviceId;
            }
        }
        deviceId = null;
        if (context != null && r0 == null) {
            try {
                deviceId = Secure.getString(context.getApplicationContext().getContentResolver(), "android_id");
            } catch (Exception e2) {
                th2 = e2;
                C1380a.m5276a(f3618a, "Error getting deviceId ", th2);
                return deviceId;
            }
        }
        return deviceId;
    }

    public static ArrayList m5499a(JSONArray jSONArray, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (str2.equalsIgnoreCase("Int")) {
                arrayList.add(Integer.valueOf(Integer.parseInt(jSONObject.getString(str))));
            } else {
                arrayList.add(jSONObject.getString(str));
            }
        }
        return arrayList;
    }
}
