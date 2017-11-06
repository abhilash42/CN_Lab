package in.org.npci.upiapp.gcm;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.aa.C0055p;
import android.support.v4.app.aa.C0057c;
import android.support.v4.app.aa.C0058d;
import android.support.v4.p004a.C0040i;
import com.google.android.gms.gcm.C1043a;
import in.org.npci.upiapp.HomeActivity;
import in.org.npci.upiapp.p036a.C1380a;
import in.org.npci.upiapp.utils.C1445h;
import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class GalileoListenerService extends C1043a {
    public void mo803a(String str, Bundle bundle) {
        String string = bundle.getString("heading");
        String string2 = bundle.getString("body");
        if (string == null && string2 == null) {
            m5411c(bundle);
        } else {
            m5409b(bundle);
        }
    }

    private void m5409b(Bundle bundle) {
        try {
            CharSequence string = bundle.getString("heading");
            CharSequence string2 = bundle.getString("body");
            if (string2 == null) {
                string2 = "A new notification has arrived";
            }
            int nextInt = new SecureRandom().nextInt(1000);
            Intent intent = new Intent(this, HomeActivity.class);
            intent.setFlags(402653184);
            intent.putExtra("notification", m5412d(bundle));
            intent.setAction(System.currentTimeMillis() + "");
            PendingIntent activity = PendingIntent.getActivity(this, nextInt, intent, 134217728);
            Uri defaultUri = RingtoneManager.getDefaultUri(2);
            C0055p c0057c = new C0057c();
            c0057c.m219a(string);
            c0057c.m220b(string2);
            ((NotificationManager) getSystemService("notification")).notify(nextInt, new C0058d(this).m224a(2130837756).m227a(BitmapFactory.decodeResource(getResources(), 2130837859)).m232b(Color.parseColor("#1b3281")).m230a(string).m234b(string2).m229a(c0057c).m231a(true).m228a(defaultUri).m226a(activity).m223a());
            Intent intent2 = new Intent("in.org.npci.upiapp.uibroadcastreceiver");
            intent2.putExtra("onNotificationReceived", m5412d(bundle));
            C0040i.m106a((Context) this).m111a(intent2);
        } catch (Throwable e) {
            C1380a.m5276a("GalileoListenerService", "Exception while showing notification", e);
        }
    }

    private void m5411c(Bundle bundle) {
        try {
            JSONArray jSONArray = new JSONObject(bundle.getString(CLConstants.FIELD_DATA)).getJSONObject(CLConstants.FIELD_DATA).getJSONArray("tasks");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString(CLConstants.OUTPUT_KEY_ACTION);
                if (string.equals("download")) {
                    m5410b(jSONObject);
                } else if (string.equals("editSharedPref")) {
                    m5407a(jSONObject);
                }
            }
        } catch (Throwable e) {
            C1380a.m5276a("GalileoListenerService", "Exception", e);
        }
    }

    private void m5407a(JSONObject jSONObject) {
        try {
            SharedPreferences sharedPreferences = getSharedPreferences("BHIMPreferences", 0);
            if (sharedPreferences != null) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("keyPairs");
                Iterator keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    String string = jSONObject2.getString(str);
                    if (string.equals("null")) {
                        sharedPreferences.edit().remove(str).apply();
                    } else {
                        sharedPreferences.edit().putString(str, string).apply();
                    }
                }
            }
        } catch (Throwable e) {
            C1380a.m5276a("GalileoListenerService", "Exception", e);
        }
    }

    private void m5410b(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("request");
            final String string = jSONObject2.getString("url");
            jSONObject2.optString("method", "GET");
            jSONObject2.getJSONObject("headers");
            final boolean booleanValue = Boolean.valueOf(jSONObject2.optString("isSignedJsa", "false")).booleanValue();
            if (string != null) {
                new AsyncTask(this) {
                    final /* synthetic */ GalileoListenerService f3551c;

                    protected Object doInBackground(Object[] objArr) {
                        try {
                            C1445h.m5495a(this.f3551c.getApplicationContext(), string, booleanValue);
                            return "SUCCESS";
                        } catch (Exception e) {
                            C1380a.m5275a("GalileoListenerService", e.getMessage());
                            return "FAILURE";
                        }
                    }

                    protected void onPostExecute(Object obj) {
                    }
                }.execute(new Object[0]);
            }
        } catch (Throwable e) {
            C1380a.m5276a("GalileoListenerService", "Exception", e);
        }
    }

    private String m5412d(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            bundle.get(str);
            try {
                jSONObject.put(str, m5406a(bundle.get(str)));
            } catch (Throwable e) {
                C1380a.m5276a("GalileoListenerService", "Exception in getJson", e);
            }
        }
        return jSONObject.toString();
    }

    public static Object m5406a(Object obj) {
        if (obj == null) {
            return JSONObject.NULL;
        }
        if ((obj instanceof JSONArray) || (obj instanceof JSONObject) || obj.equals(JSONObject.NULL)) {
            return obj;
        }
        try {
            if (obj instanceof Collection) {
                return new JSONArray((Collection) obj);
            }
            if (obj.getClass().isArray()) {
                return m5408b(obj);
            }
            if (obj instanceof Map) {
                return new JSONObject((Map) obj);
            }
            if ((obj instanceof Boolean) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Short) || (obj instanceof String)) {
                return obj;
            }
            if (obj.getClass().getPackage().getName().startsWith("java.")) {
                return obj.toString();
            }
            return null;
        } catch (Exception e) {
        }
    }

    public static JSONArray m5408b(Object obj) {
        JSONArray jSONArray = new JSONArray();
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                jSONArray.put(m5406a(Array.get(obj, i)));
            }
            return jSONArray;
        }
        throw new JSONException("Not a primitive array: " + obj.getClass());
    }
}
