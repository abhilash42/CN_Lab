package in.org.npci.upiapp.core;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.util.Base64;
import android.view.inputmethod.InputMethodManager;
import android.webkit.JavascriptInterface;
import in.juspay.mystique.C1178d;
import in.org.npci.upiapp.p036a.C1380a;
import in.org.npci.upiapp.utils.C1436b;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.npci.upi.security.services.CLRemoteResultReceiver;
import org.npci.upi.security.services.CLServices;
import org.npci.upi.security.services.ServiceConnectionStatusNotifier;

public class NPCIJSInterface {
    private static CLServices f3486b;
    private Activity f3487a;
    private C1178d f3488c;
    private String f3489d;

    class C14097 implements Runnable {
        final /* synthetic */ NPCIJSInterface f3485a;

        C14097(NPCIJSInterface nPCIJSInterface) {
            this.f3485a = nPCIJSInterface;
        }

        public void run() {
            if (this.f3485a.f3487a.getCurrentFocus() != null) {
                ((InputMethodManager) this.f3485a.f3487a.getApplicationContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f3485a.f3487a.getCurrentFocus().getWindowToken(), 0);
            }
        }
    }

    public NPCIJSInterface(Activity activity, C1178d c1178d) {
        this.f3487a = activity;
        this.f3488c = c1178d;
    }

    @JavascriptInterface
    public void initialiseNPCICL(final String str) {
        try {
            CLServices.initService(this.f3487a, new ServiceConnectionStatusNotifier(this) {
                final /* synthetic */ NPCIJSInterface f3456b;

                public void serviceConnected(CLServices cLServices) {
                    NPCIJSInterface.f3486b = cLServices;
                    this.f3456b.f3488c.m4567a("window.callUICallback(\"" + str + "\")");
                }

                public void serviceDisconnected() {
                    C1380a.m5279b("NPCIJSInterface", "Error Code : 843 - Description : NPCI Service Disconnected");
                }
            });
        } catch (Throwable e) {
            if ("Service already initiated".equals(e.getMessage())) {
                this.f3488c.m4567a("window.callUICallback(\"" + str + "\")");
            } else {
                C1380a.m5276a("NPCIJSInterface", "intialiseNPCICL", e);
            }
        }
    }

    @JavascriptInterface
    public void handleInit(String str, String str2, CLRemoteResultReceiver cLRemoteResultReceiver, String... strArr) {
        final String str3;
        try {
            str3 = str2;
            final String[] strArr2 = strArr;
            final String str4 = str;
            final CLRemoteResultReceiver cLRemoteResultReceiver2 = cLRemoteResultReceiver;
            CLServices.initService(this.f3487a, new ServiceConnectionStatusNotifier(this) {
                final /* synthetic */ NPCIJSInterface f3461e;

                public void serviceConnected(CLServices cLServices) {
                    NPCIJSInterface.f3486b = cLServices;
                    String str = str3;
                    int i = -1;
                    switch (str.hashCode()) {
                        case -2133316482:
                            if (str.equals("registerApp")) {
                                i = 1;
                                break;
                            }
                            break;
                        case -1531153537:
                            if (str.equals("unbindService")) {
                                i = 3;
                                break;
                            }
                            break;
                        case -981163955:
                            if (str.equals("getCredential")) {
                                i = 2;
                                break;
                            }
                            break;
                        case 1393028525:
                            if (str.equals("getChallenge")) {
                                i = 0;
                                break;
                            }
                            break;
                    }
                    switch (i) {
                        case 0:
                            this.f3461e.f3488c.m4567a("window.callUICallback(\"" + str4 + "\",\"" + NPCIJSInterface.f3486b.getChallenge(strArr2[0], strArr2[1]) + "\")");
                            return;
                        case 1:
                            this.f3461e.f3488c.m4567a("window.callUICallback(\"" + str4 + "\",\"" + Boolean.valueOf(NPCIJSInterface.f3486b.registerApp(strArr2[0], strArr2[1], strArr2[2], strArr2[3])) + "\")");
                            return;
                        case 2:
                            this.f3461e.f3489d = str4;
                            NPCIJSInterface.f3486b.getCredential(strArr2[0], strArr2[1], strArr2[2], strArr2[3], strArr2[4], strArr2[5], strArr2[6], strArr2[7], cLRemoteResultReceiver2);
                            return;
                        case 3:
                            try {
                                NPCIJSInterface.f3486b.unbindService();
                            } catch (Throwable e) {
                                C1380a.m5278a(e);
                            }
                            this.f3461e.f3488c.m4567a("window.callUICallback(\"" + str4 + "\")");
                            return;
                        default:
                            return;
                    }
                }

                public void serviceDisconnected() {
                    C1380a.m5279b("NPCIJSInterface", "Error Code : 843 - Description : NPCI Service Disconnected");
                }
            });
        } catch (RuntimeException e) {
            int i = -1;
            switch (str2.hashCode()) {
                case -2133316482:
                    if (str2.equals("registerApp")) {
                        i = 1;
                        break;
                    }
                    break;
                case -1531153537:
                    if (str2.equals("unbindService")) {
                        i = 3;
                        break;
                    }
                    break;
                case -981163955:
                    if (str2.equals("getCredential")) {
                        i = 2;
                        break;
                    }
                    break;
                case 1393028525:
                    if (str2.equals("getChallenge")) {
                        i = 0;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    this.f3488c.m4567a("window.callUICallback(\"" + str + "\",\"" + f3486b.getChallenge(strArr[0], strArr[1]) + "\")");
                    return;
                case 1:
                    this.f3488c.m4567a("window.callUICallback(\"" + str + "\",\"" + Boolean.valueOf(f3486b.registerApp(strArr[0], strArr[1], strArr[2], strArr[3])) + "\")");
                    return;
                case 2:
                    for (String str32 : strArr) {
                        C1380a.m5275a("NPCIJSInterface", "getCredentials - " + str32);
                    }
                    f3486b.getCredential(strArr[0], strArr[1], strArr[2], strArr[3], strArr[4], strArr[5], strArr[6], strArr[7], cLRemoteResultReceiver);
                    this.f3488c.m4567a("window.callUICallback(\"" + str + "\")");
                    return;
                case 3:
                    try {
                        f3486b.unbindService();
                    } catch (Throwable e2) {
                        C1380a.m5278a(e2);
                    }
                    this.f3488c.m4567a("window.callUICallback(\"" + str + "\")");
                    return;
                default:
                    return;
            }
        }
    }

    @JavascriptInterface
    public void getChallenge(final String str, final String str2, final String str3) {
        this.f3487a.runOnUiThread(new Runnable(this) {
            final /* synthetic */ NPCIJSInterface f3465d;

            public void run() {
                this.f3465d.handleInit(str3, "getChallenge", null, str, str2);
            }
        });
    }

    @JavascriptInterface
    public void registerApp(String str, String str2, String str3, String str4, String str5) {
        final String str6 = str5;
        final String str7 = str;
        final String str8 = str2;
        final String str9 = str3;
        final String str10 = str4;
        this.f3487a.runOnUiThread(new Runnable(this) {
            final /* synthetic */ NPCIJSInterface f3471f;

            public void run() {
                this.f3471f.handleInit(str6, "registerApp", null, str7, str8, str9, str10);
            }
        });
    }

    @JavascriptInterface
    public void getCredentials(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f3489d = str9;
        final String str10 = str9;
        final CLRemoteResultReceiver cLRemoteResultReceiver = new CLRemoteResultReceiver(new ResultReceiver(this, new Handler()) {
            final /* synthetic */ NPCIJSInterface f3473b;

            protected void onReceiveResult(int i, Bundle bundle) {
                C1380a.m5275a("NPCIJSInterface", "ResultCode is " + i);
                JSONObject jSONObject = new JSONObject();
                try {
                    super.onReceiveResult(i, bundle);
                    if (bundle != null) {
                        for (String str : bundle.keySet()) {
                            try {
                                jSONObject.put(str, this.f3473b.m5320a(bundle.get(str)));
                            } catch (Throwable e) {
                                C1380a.m5278a(e);
                            }
                        }
                        try {
                            jSONObject.put("resultCode", i);
                        } catch (Throwable e2) {
                            C1380a.m5278a(e2);
                        }
                    }
                } catch (Throwable e22) {
                    C1380a.m5278a(e22);
                }
                this.f3473b.f3488c.m4567a("window.callUICallback(\"" + str10 + "\", " + jSONObject.toString() + ");");
            }
        });
        final String str11 = str9;
        final String str12 = str;
        final String str13 = str2;
        final String str14 = str3;
        final String str15 = str4;
        final String str16 = str5;
        final String str17 = str6;
        final String str18 = str7;
        final String str19 = str8;
        this.f3487a.runOnUiThread(new Runnable(this) {
            final /* synthetic */ NPCIJSInterface f3484k;

            public void run() {
                this.f3484k.handleInit(str11, "getCredential", cLRemoteResultReceiver, str12, str13, str14, str15, str16, str17, str18, str19);
            }
        });
    }

    public void m5326a() {
        C1380a.m5275a("NPCIJSInterface", "Lifecycle - onResume Called");
        try {
            if (this.f3489d != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    C1380a.m5275a("NPCIJSInterface", "BACK_PRESSED - CALLBACK CALLED");
                    jSONObject.put("event", "back_pressed");
                } catch (Throwable e) {
                    C1380a.m5278a(e);
                }
                this.f3488c.m4567a("window.callUICallback(\"" + this.f3489d + "\", " + jSONObject.toString() + ");");
                this.f3489d = null;
            }
        } catch (Throwable e2) {
            C1380a.m5278a(e2);
        }
    }

    private Object m5320a(Object obj) {
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
                return m5324b(obj);
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

    private JSONArray m5324b(Object obj) {
        JSONArray jSONArray = new JSONArray();
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                jSONArray.put(m5320a(Array.get(obj, i)));
            }
            return jSONArray;
        }
        throw new JSONException("Not a primitive array: " + obj.getClass());
    }

    @JavascriptInterface
    public String fetchData(String str) {
        return this.f3487a.getSharedPreferences("NPCI", 0).getString(str, "NOT_FOUND");
    }

    @JavascriptInterface
    public void saveData(String str, String str2) {
        C1380a.m5275a("NPCIJSInterface", "Saving to local store : " + str + ", " + str2);
        this.f3487a.getSharedPreferences("NPCI", 0).edit().putString(str, str2).apply();
    }

    @JavascriptInterface
    public void unbindNPCICL(String str) {
        handleInit(str, "unbindService", null, new String[0]);
    }

    @JavascriptInterface
    public String populateHMAC(String str, String str2, String str3, String str4) {
        m5327b();
        String str5 = null;
        try {
            C1436b c1436b = new C1436b();
            String str6 = str + CLConstants.SALT_DELIMETER + str2 + CLConstants.SALT_DELIMETER + str4;
            C1380a.m5279b("NPCIJSInterface", "PSP Hmac Msg - " + str6);
            str5 = Base64.encodeToString(C1436b.m5449a(C1436b.m5447a(str6), Base64.decode(str3, 2)), 0);
        } catch (Throwable e) {
            C1380a.m5276a("NPCIJSInterface", "populateHMAC ", e);
        }
        return str5;
    }

    @JavascriptInterface
    public String trustCred(String str, String str2) {
        String str3 = null;
        try {
            C1436b c1436b = new C1436b();
            str3 = Base64.encodeToString(C1436b.m5449a(C1436b.m5447a(str), Base64.decode(str2, 2)), 2);
        } catch (Throwable e) {
            C1380a.m5278a(e);
        }
        return str3;
    }

    @JavascriptInterface
    public String decodeNPCIXmlKeys(String str) {
        return new String(Base64.decode(str, 2), "UTF-8");
    }

    public void m5327b() {
        this.f3487a.runOnUiThread(new C14097(this));
    }
}
