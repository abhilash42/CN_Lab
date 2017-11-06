package in.org.npci.upiapp;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.IBinder;
import android.preference.PreferenceManager;
import in.org.npci.upiapp.utils.C1435a;
import in.org.npci.upiapp.utils.C1444g;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StartOnBootService extends Service {
    Context f3210a;
    C1435a f3211b;
    C1444g f3212c;

    public void onCreate() {
        this.f3210a = getApplicationContext();
        this.f3211b = new C1435a(this.f3210a);
        this.f3212c = new C1444g(this.f3210a);
        super.onCreate();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            JSONArray jSONArray = new JSONArray(this.f3211b.m5441a(this.f3210a));
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                if (m5235a(jSONObject).booleanValue()) {
                    m5236a(this.f3210a, Integer.parseInt(jSONObject.getString("uid")));
                } else {
                    this.f3212c.m5494a(jSONObject.toString());
                }
            }
        } catch (JSONException e) {
        }
        return super.onStartCommand(intent, i, i2);
    }

    public void m5236a(Context context, int i) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        JSONObject jSONObject = new JSONObject(defaultSharedPreferences.getString(context.getPackageName() + ":alarms_data_" + i, null));
        jSONObject.put("status", "expired");
        Editor edit = defaultSharedPreferences.edit();
        edit.putString(context.getPackageName() + ":alarms_data_" + i, jSONObject.toString());
        edit.apply();
    }

    public Boolean m5235a(JSONObject jSONObject) {
        if (Calendar.getInstance().after(C1444g.m5493b((String) jSONObject.get("endDate")))) {
            return Boolean.valueOf(true);
        }
        return Boolean.valueOf(false);
    }
}
