package in.org.npci.upiapp.core;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.telephony.SmsManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import in.org.npci.upiapp.p036a.C1380a;
import java.lang.reflect.Method;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SimUtil */
public class C1420e {
    @TargetApi(22)
    public static boolean m5385a(Context context, int i, String str, String str2, String str3, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        String str4;
        if (i == 0) {
            try {
                str4 = Build.MODEL.equals("Philips T939") ? "isms0" : "isms";
            } catch (Throwable e) {
                C1380a.m5278a(e);
                return false;
            }
        } else if (i == 1) {
            str4 = "isms2";
        } else {
            throw new Exception("can not get service which for sim '" + i + "', only 0,1 accepted as values");
        }
        Method declaredMethod = Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", new Class[]{String.class});
        declaredMethod.setAccessible(true);
        Object invoke = declaredMethod.invoke(null, new Object[]{str4});
        declaredMethod = Class.forName("com.android.internal.telephony.ISms$Stub").getDeclaredMethod("asInterface", new Class[]{IBinder.class});
        declaredMethod.setAccessible(true);
        invoke = declaredMethod.invoke(null, new Object[]{invoke});
        C1380a.m5275a("SimUtil", "send msg - " + str3);
        if (VERSION.SDK_INT < 18) {
            invoke.getClass().getMethod("sendText", new Class[]{String.class, String.class, String.class, PendingIntent.class, PendingIntent.class}).invoke(invoke, new Object[]{str, str2, str3, pendingIntent, pendingIntent2});
        } else if (C1420e.m5384a(context)) {
            ArrayList arrayList = new ArrayList();
            for (SubscriptionInfo subscriptionId : SubscriptionManager.from(context).getActiveSubscriptionInfoList()) {
                int subscriptionId2 = subscriptionId.getSubscriptionId();
                arrayList.add(Integer.valueOf(subscriptionId2));
                C1380a.m5275a("SimUtil", "SmsManager - subscriptionId: " + subscriptionId2);
            }
            SmsManager.getSmsManagerForSubscriptionId(((Integer) arrayList.get(i)).intValue()).sendTextMessage(str, null, str3, pendingIntent, pendingIntent2);
        } else {
            SmsManager.getDefault().sendTextMessage(str, null, str3, pendingIntent, pendingIntent2);
        }
        return true;
    }

    public static boolean m5384a(Context context) {
        if (VERSION.SDK_INT < 22) {
            return false;
        }
        if (SubscriptionManager.from(context).getActiveSubscriptionInfoCount() > 1) {
            return true;
        }
        return false;
    }

    public static boolean m5386b(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimState() != 1;
    }

    public static String m5387c(Context context) {
        try {
            JSONArray jSONArray = new JSONArray();
            if (VERSION.SDK_INT >= 22) {
                for (SubscriptionInfo subscriptionInfo : SubscriptionManager.from(context).getActiveSubscriptionInfoList()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("slotId", subscriptionInfo.getSimSlotIndex());
                        jSONObject.put("subscriptionId", subscriptionInfo.getSubscriptionId());
                        jSONObject.put("displayName", subscriptionInfo.getDisplayName());
                        jSONObject.put("carrierName", subscriptionInfo.getCarrierName());
                        jSONObject.put("phoneNumber", subscriptionInfo.getNumber());
                        jSONObject.put("simId", subscriptionInfo.getIccId());
                        jSONArray.put(jSONObject);
                    } catch (Throwable e) {
                        C1380a.m5276a("SimUtil", "Exception getting sim details for SDK >= 22", e);
                    }
                }
            } else {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("slotId", telephonyManager.getSimState());
                        jSONObject2.put("subscriptionId", telephonyManager.getSubscriberId());
                        jSONObject2.put("displayName", telephonyManager.getNetworkOperator());
                        jSONObject2.put("carrierName", telephonyManager.getNetworkOperatorName());
                        jSONObject2.put("phoneNumber", telephonyManager.getLine1Number());
                        jSONObject2.put("simId", telephonyManager.getSimSerialNumber());
                        jSONArray.put(jSONObject2);
                    } catch (Throwable e2) {
                        C1380a.m5276a("SimUtil", "Exception getting sim details for SDK < 22", e2);
                    }
                }
            }
            return jSONArray.toString();
        } catch (Exception e3) {
            C1380a.m5279b("SimUtil", "Not able to fetch Sim Cards");
            return null;
        }
    }
}
