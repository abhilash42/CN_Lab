package in.org.npci.upiapp.core;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsMessage;
import in.org.npci.upiapp.HomeActivity;
import in.org.npci.upiapp.p036a.C1380a;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: OtpReader */
public class C1417b {
    private static boolean f3508a = true;
    private static C1417b f3509b;
    private static Map<String, Object> f3510c;
    private Long f3511d = Long.valueOf(0);
    private Timer f3512e;
    private C1418c f3513f;
    private C1418c f3514g = null;
    private String f3515h;
    private C1414a f3516i;
    private Activity f3517j;
    private C1416a f3518k;

    /* compiled from: OtpReader */
    class C14151 extends TimerTask {
        final /* synthetic */ C1417b f3506a;

        C14151(C1417b c1417b) {
            this.f3506a = c1417b;
        }

        public void run() {
            this.f3506a.m5350a(this.f3506a.f3511d, HomeActivity.m5217u());
            this.f3506a.f3511d = Long.valueOf(System.currentTimeMillis() - 100);
        }
    }

    /* compiled from: OtpReader */
    private class C1416a extends BroadcastReceiver {
        final /* synthetic */ C1417b f3507a;

        private C1416a(C1417b c1417b) {
            this.f3507a = c1417b;
        }

        public void onReceive(Context context, Intent intent) {
            try {
                if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
                    Bundle extras = intent.getExtras();
                    if (extras != null) {
                        Object[] objArr = (Object[]) extras.get("pdus");
                        SmsMessage[] smsMessageArr = new SmsMessage[objArr.length];
                        for (int i = 0; i < smsMessageArr.length; i++) {
                            smsMessageArr[i] = SmsMessage.createFromPdu((byte[]) objArr[i]);
                            String toUpperCase = smsMessageArr[i].getOriginatingAddress().toUpperCase();
                            String toUpperCase2 = smsMessageArr[i].getMessageBody().toUpperCase();
                            Date date = new Date(smsMessageArr[i].getTimestampMillis());
                            C1418c a = C1419d.m5375b().m5381a(toUpperCase, toUpperCase2, date, HomeActivity.m5217u(), this.f3507a.m5347a());
                            if (a == null) {
                                a = C1419d.m5375b().m5381a(toUpperCase, toUpperCase2, date, "BHIM", this.f3507a.m5347a());
                            }
                            if (a != null) {
                                this.f3507a.m5349a(a);
                            }
                        }
                    }
                }
            } catch (Throwable e) {
                C1380a.m5276a("OtpReader", "Exception in onOtpReceived", e);
            }
        }
    }

    public Map<String, Object> m5347a() {
        try {
            f3510c = (Map) C1417b.m5342a(this.f3516i.getOtpRules());
        } catch (Throwable e) {
            C1380a.m5276a("OtpReader", "Exception in getRule", e);
        }
        return f3510c;
    }

    public static C1417b m5346b() {
        if (f3509b == null) {
            C1417b c1417b = new C1417b();
        }
        return f3509b;
    }

    public C1417b() {
        f3509b = this;
    }

    public void m5348a(Activity activity, C1414a c1414a) {
        this.f3517j = activity;
        this.f3516i = c1414a;
        C1419d.m5370a();
        Long valueOf = Long.valueOf((long) activity.getApplicationContext().getResources().getInteger(2131427333));
        Long valueOf2 = Long.valueOf((long) HomeActivity.m5216t().intValue());
        if (HomeActivity.m5213q().longValue() - valueOf.longValue() > System.currentTimeMillis() - valueOf2.longValue()) {
            valueOf = Long.valueOf(HomeActivity.m5213q().longValue() - valueOf.longValue());
        } else {
            valueOf = Long.valueOf(System.currentTimeMillis() - valueOf2.longValue());
        }
        if (this.f3511d.longValue() < valueOf.longValue()) {
            this.f3511d = valueOf;
        }
        m5350a(this.f3511d, HomeActivity.m5217u());
        if (f3508a) {
            m5353e();
        }
        m5354f();
    }

    public void m5351c() {
        m5352d();
        m5355g();
        if (this.f3513f != null) {
            C1419d.m5375b().m5382a(this.f3517j.getApplication(), this.f3513f);
        }
        f3509b = null;
        C1419d.m5375b().m5383c();
    }

    public void m5350a(Long l, String str) {
        C1418c a = C1419d.m5375b().m5380a(this.f3517j.getApplicationContext(), str, m5347a(), l.longValue());
        if (a == null) {
            return;
        }
        if (this.f3514g == null || !this.f3514g.m5362c().equals(a.m5362c())) {
            m5349a(a);
        }
    }

    public void m5352d() {
        if (this.f3512e != null) {
            this.f3512e.cancel();
        }
    }

    public void m5353e() {
        int integer;
        int integer2;
        int intValue = HomeActivity.m5214r().intValue();
        int intValue2 = HomeActivity.m5215s().intValue();
        if (intValue == 0) {
            integer = this.f3517j.getApplicationContext().getResources().getInteger(2131427334);
        } else {
            integer = intValue;
        }
        if (intValue2 == 0) {
            integer2 = this.f3517j.getApplicationContext().getResources().getInteger(2131427335);
        } else {
            integer2 = intValue2;
        }
        this.f3512e = new Timer();
        this.f3512e.scheduleAtFixedRate(new C14151(this), (long) integer2, (long) integer);
    }

    public void m5354f() {
        if (this.f3517j != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
            intentFilter.setPriority(999);
            this.f3518k = new C1416a();
            this.f3517j.registerReceiver(this.f3518k, intentFilter);
        }
    }

    public void m5355g() {
        if (this.f3517j != null && this.f3518k != null) {
            this.f3517j.unregisterReceiver(this.f3518k);
            this.f3518k = null;
        }
    }

    private void m5345a(String str) {
        this.f3515h = str;
        this.f3514g = this.f3513f;
    }

    public void m5349a(C1418c c1418c) {
        m5345a(c1418c.m5362c());
        this.f3513f = c1418c;
        try {
            this.f3516i.onOtpReceived();
        } catch (Throwable e) {
            C1380a.m5276a("OtpReader", "Exception in onOtpReceived", e);
        }
    }

    public String m5356h() {
        return this.f3515h;
    }

    private static Object m5342a(Object obj) {
        if (obj == JSONObject.NULL) {
            return null;
        }
        if (obj instanceof JSONObject) {
            return C1417b.m5344a((JSONObject) obj);
        }
        if (obj instanceof JSONArray) {
            return C1417b.m5343a((JSONArray) obj);
        }
        return obj;
    }

    private static List m5343a(JSONArray jSONArray) {
        List arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(C1417b.m5342a(jSONArray.get(i)));
        }
        return arrayList;
    }

    private static Map<String, Object> m5344a(JSONObject jSONObject) {
        Map<String, Object> hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            hashMap.put(str, C1417b.m5342a(jSONObject.get(str)));
        }
        return hashMap;
    }
}
