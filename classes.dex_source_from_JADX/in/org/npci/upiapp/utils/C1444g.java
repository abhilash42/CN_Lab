package in.org.npci.upiapp.utils;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import in.org.npci.upiapp.AlarmBroadcastReceiver;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Reminder */
public class C1444g {
    AlarmManager f3610a;
    ArrayList<Object> f3611b = null;
    private Context f3612c;

    public C1444g(Context context) {
        this.f3612c = context;
        this.f3611b = new ArrayList();
    }

    @TargetApi(19)
    public void m5494a(String str) {
        JSONObject jSONObject = new JSONObject(str);
        Intent intent = new Intent(this.f3612c, AlarmBroadcastReceiver.class);
        intent.putExtra("intentData", jSONObject.toString());
        PendingIntent broadcast = PendingIntent.getBroadcast(this.f3612c, Integer.parseInt(jSONObject.getString("uid")), intent, 134217728);
        C1444g.m5489a(this.f3610a, this.f3612c, C1444g.m5487a(C1444g.m5493b(jSONObject.getString("startDate")), jSONObject.getString("Frequency")), broadcast, str);
    }

    public static void m5489a(AlarmManager alarmManager, Context context, Calendar calendar, PendingIntent pendingIntent, String str) {
        ((AlarmManager) context.getSystemService("alarm")).set(0, calendar.getTimeInMillis(), pendingIntent);
        C1444g.m5491a(context, Integer.parseInt(new JSONObject(str).getString("uid")), str.toString());
    }

    public static Calendar m5493b(String str) {
        int i;
        String[] split = str.split("-");
        Calendar instance = Calendar.getInstance();
        if (split[7].equals("AM")) {
            i = 0;
        } else {
            i = 1;
        }
        instance.set(5, Integer.parseInt(split[0]));
        instance.set(2, Integer.parseInt(split[1]) - 1);
        instance.set(1, Integer.parseInt(split[2]));
        instance.set(10, Integer.parseInt(split[3]));
        instance.set(12, Integer.parseInt(split[4]));
        instance.set(13, Integer.parseInt(split[5]));
        instance.set(14, Integer.parseInt(split[6]));
        instance.set(9, i);
        return instance;
    }

    private static void m5491a(Context context, int i, String str) {
        List a = C1444g.m5488a(context);
        if (!a.contains(Integer.valueOf(i))) {
            a.add(Integer.valueOf(i));
            Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
            edit.putString(context.getPackageName() + ":alarms" + "_data_" + i, str);
            edit.apply();
            C1444g.m5492a(context, a);
        }
    }

    public static void m5490a(Context context, int i) {
        List a = C1444g.m5488a(context);
        for (int i2 = 0; i2 < a.size(); i2++) {
            if (((Integer) a.get(i2)).intValue() == i) {
                a.remove(i2);
                Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
                edit.remove(context.getPackageName() + ":alarms" + "_data_" + i);
                edit.apply();
            }
        }
        C1444g.m5492a(context, a);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Calendar m5487a(java.util.Calendar r9, java.lang.String r10) {
        /*
        r6 = 4;
        r5 = 3;
        r1 = 0;
        r4 = 2;
        r3 = 1;
        r7 = java.util.Calendar.getInstance();
        r0 = r9.clone();
        r0 = (java.util.Calendar) r0;
        r2 = -1;
        r8 = r10.hashCode();
        switch(r8) {
            case -2020697580: goto L_0x0025;
            case -1877629930: goto L_0x0057;
            case -1738378111: goto L_0x0039;
            case 2430593: goto L_0x001b;
            case 64808441: goto L_0x002f;
            case 137950124: goto L_0x0061;
            case 1720567065: goto L_0x004d;
            case 1954618349: goto L_0x0043;
            default: goto L_0x0017;
        };
    L_0x0017:
        switch(r2) {
            case 0: goto L_0x001a;
            case 1: goto L_0x006b;
            case 2: goto L_0x0077;
            case 3: goto L_0x0082;
            case 4: goto L_0x008c;
            case 5: goto L_0x00a2;
            case 6: goto L_0x00b8;
            case 7: goto L_0x00cf;
            default: goto L_0x001a;
        };
    L_0x001a:
        return r0;
    L_0x001b:
        r8 = "ONCE";
        r8 = r10.equals(r8);
        if (r8 == 0) goto L_0x0017;
    L_0x0023:
        r2 = r1;
        goto L_0x0017;
    L_0x0025:
        r8 = "MINUTE";
        r8 = r10.equals(r8);
        if (r8 == 0) goto L_0x0017;
    L_0x002d:
        r2 = r3;
        goto L_0x0017;
    L_0x002f:
        r8 = "DAILY";
        r8 = r10.equals(r8);
        if (r8 == 0) goto L_0x0017;
    L_0x0037:
        r2 = r4;
        goto L_0x0017;
    L_0x0039:
        r8 = "WEEKLY";
        r8 = r10.equals(r8);
        if (r8 == 0) goto L_0x0017;
    L_0x0041:
        r2 = r5;
        goto L_0x0017;
    L_0x0043:
        r8 = "MONTHLY";
        r8 = r10.equals(r8);
        if (r8 == 0) goto L_0x0017;
    L_0x004b:
        r2 = r6;
        goto L_0x0017;
    L_0x004d:
        r8 = "QUARTERLY";
        r8 = r10.equals(r8);
        if (r8 == 0) goto L_0x0017;
    L_0x0055:
        r2 = 5;
        goto L_0x0017;
    L_0x0057:
        r8 = "HALF_YEARLY";
        r8 = r10.equals(r8);
        if (r8 == 0) goto L_0x0017;
    L_0x005f:
        r2 = 6;
        goto L_0x0017;
    L_0x0061:
        r8 = "ANNUALLY";
        r8 = r10.equals(r8);
        if (r8 == 0) goto L_0x0017;
    L_0x0069:
        r2 = 7;
        goto L_0x0017;
    L_0x006b:
        r1 = r0.before(r7);
        if (r1 == 0) goto L_0x001a;
    L_0x0071:
        r1 = 12;
        r0.add(r1, r3);
        goto L_0x006b;
    L_0x0077:
        r1 = r0.before(r7);
        if (r1 == 0) goto L_0x001a;
    L_0x007d:
        r1 = 5;
        r0.add(r1, r3);
        goto L_0x0077;
    L_0x0082:
        r1 = r0.before(r7);
        if (r1 == 0) goto L_0x001a;
    L_0x0088:
        r0.add(r6, r3);
        goto L_0x0082;
    L_0x008c:
        r2 = r0.before(r7);
        if (r2 == 0) goto L_0x0097;
    L_0x0092:
        r0.add(r4, r3);
        r1 = r1 + r3;
        goto L_0x008c;
    L_0x0097:
        r0 = r9.clone();
        r0 = (java.util.Calendar) r0;
        r0.add(r4, r1);
        goto L_0x001a;
    L_0x00a2:
        r2 = r0.before(r7);
        if (r2 == 0) goto L_0x00ad;
    L_0x00a8:
        r0.add(r4, r5);
        r1 = r1 + r5;
        goto L_0x00a2;
    L_0x00ad:
        r0 = r9.clone();
        r0 = (java.util.Calendar) r0;
        r0.add(r4, r1);
        goto L_0x001a;
    L_0x00b8:
        r2 = 6;
    L_0x00b9:
        r3 = r0.before(r7);
        if (r3 == 0) goto L_0x00c4;
    L_0x00bf:
        r0.add(r4, r2);
        r1 = r1 + r2;
        goto L_0x00b9;
    L_0x00c4:
        r0 = r9.clone();
        r0 = (java.util.Calendar) r0;
        r0.add(r4, r1);
        goto L_0x001a;
    L_0x00cf:
        r1 = r0.before(r7);
        if (r1 == 0) goto L_0x001a;
    L_0x00d5:
        r0.add(r3, r3);
        goto L_0x00cf;
        */
        throw new UnsupportedOperationException("Method not decompiled: in.org.npci.upiapp.utils.g.a(java.util.Calendar, java.lang.String):java.util.Calendar");
    }

    public static List<Integer> m5488a(Context context) {
        List<Integer> arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(PreferenceManager.getDefaultSharedPreferences(context).getString(context.getPackageName() + ":alarms", "[]"));
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(Integer.valueOf(jSONArray.getInt(i)));
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static void m5492a(Context context, List<Integer> list) {
        JSONArray jSONArray = new JSONArray();
        for (Integer put : list) {
            jSONArray.put(put);
        }
        Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(context.getPackageName() + ":alarms", jSONArray.toString());
        edit.apply();
    }
}
