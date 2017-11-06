package in.org.npci.upiapp;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.preference.PreferenceManager;
import in.org.npci.upiapp.utils.C1444g;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class AlarmBroadcastReceiver extends BroadcastReceiver {
    AlarmManager f3185a;

    public void onReceive(Context context, Intent intent) {
        this.f3185a = (AlarmManager) context.getSystemService("alarm");
        Bundle extras = intent.getExtras();
        try {
            JSONObject jSONObject = new JSONObject(extras.getString("intentData"));
            Intent intent2 = new Intent(context, HomeActivity.class);
            intent2.setFlags(603979776);
            intent2.putExtra("reminder", extras.getString("intentData"));
            PendingIntent activity = PendingIntent.getActivity(context, Integer.parseInt(jSONObject.getString("uid")), intent2, 134217728);
            PendingIntent broadcast = PendingIntent.getBroadcast(context, Integer.parseInt(jSONObject.getString("uid")), intent, 134217728);
            if (m5191a(intent).booleanValue()) {
                m5193a(context, broadcast, jSONObject);
            } else if (jSONObject.getString("Frequency").equals("ONCE")) {
                m5194a(context, jSONObject, activity);
                m5193a(context, broadcast, jSONObject);
            } else {
                Calendar a = C1444g.m5487a(C1444g.m5493b((String) jSONObject.get("startDate")), (String) jSONObject.get("Frequency"));
                if (a.after(C1444g.m5493b((String) jSONObject.get("endDate")))) {
                    m5193a(context, broadcast, jSONObject);
                } else {
                    C1444g.m5489a(this.f3185a, context, a, broadcast, jSONObject.toString());
                }
                m5194a(context, jSONObject, activity);
            }
        } catch (JSONException e) {
        }
    }

    public void m5193a(Context context, PendingIntent pendingIntent, JSONObject jSONObject) {
        if (pendingIntent != null) {
            pendingIntent.cancel();
            this.f3185a.cancel(pendingIntent);
            m5192a(context, Integer.parseInt(jSONObject.getString("uid")));
        }
    }

    public void m5192a(Context context, int i) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        JSONObject jSONObject = new JSONObject(defaultSharedPreferences.getString(context.getPackageName() + ":alarms_data_" + i, null));
        jSONObject.put("status", "expired");
        Editor edit = defaultSharedPreferences.edit();
        edit.putString(context.getPackageName() + ":alarms_data_" + i, jSONObject.toString());
        edit.apply();
    }

    @TargetApi(21)
    public void m5194a(Context context, JSONObject jSONObject, PendingIntent pendingIntent) {
        ((NotificationManager) context.getSystemService("notification")).notify(Integer.parseInt((String) jSONObject.get("uid")), new Builder(context).setContentTitle("Bharat Interface for Money").setContentText("Payment Reminder!").setSmallIcon(2130837756).setLargeIcon(BitmapFactory.decodeResource(context.getResources(), 2130837859)).setContentIntent(pendingIntent).setDefaults(1).setStyle(new BigTextStyle().bigText("You have a pending payment to " + jSONObject.getJSONObject(CLConstants.FIELD_DATA).getString("vpa"))).setAutoCancel(true).build());
    }

    public Boolean m5191a(Intent intent) {
        if (Calendar.getInstance().after(C1444g.m5493b((String) new JSONObject(intent.getExtras().getString("intentData")).get("endDate")))) {
            return Boolean.valueOf(true);
        }
        return Boolean.valueOf(false);
    }
}
