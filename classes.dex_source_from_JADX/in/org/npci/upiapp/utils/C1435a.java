package in.org.npci.upiapp.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;
import in.org.npci.upiapp.AlarmBroadcastReceiver;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AlarmService */
public class C1435a {
    C1444g f3563a;

    public C1435a(Context context) {
        this.f3563a = new C1444g(context);
    }

    public void m5444a(Context context, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            PendingIntent broadcast = PendingIntent.getBroadcast(context, Integer.parseInt(strArr[i]), new Intent(context, AlarmBroadcastReceiver.class), 536870912);
            if (broadcast != null) {
                AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
                broadcast.cancel();
                alarmManager.cancel(broadcast);
            }
            C1444g.m5490a(context, Integer.parseInt(strArr[i]));
        }
    }

    public String m5441a(Context context) {
        List a = C1444g.m5488a(context);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < a.size(); i++) {
            String string = PreferenceManager.getDefaultSharedPreferences(context).getString(context.getPackageName() + ":alarms_data_" + a.get(i), null);
            if (string != null) {
                jSONArray.put(new JSONObject(string));
            }
        }
        return jSONArray.toString();
    }

    public void m5443a(Context context, String str) {
        if (!C1444g.m5488a(context).contains(String.valueOf(new JSONObject(str).getString("uid")))) {
            this.f3563a.m5494a(str);
        }
    }

    public void m5442a(Context context, int i, String str) {
        PendingIntent broadcast = PendingIntent.getBroadcast(context, i, new Intent(context, AlarmBroadcastReceiver.class), 536870912);
        if (broadcast != null) {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            broadcast.cancel();
            alarmManager.cancel(broadcast);
        }
        C1444g.m5490a(context, i);
        this.f3563a.m5494a(str);
    }
}
