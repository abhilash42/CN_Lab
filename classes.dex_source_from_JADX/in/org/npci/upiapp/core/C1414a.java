package in.org.npci.upiapp.core;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import in.juspay.mystique.C1178d;
import in.org.npci.upiapp.HomeActivity;
import in.org.npci.upiapp.p036a.C1380a;
import org.json.JSONObject;

/* compiled from: OtpJsInterface */
public class C1414a {
    private static final String f3502a = JsInterface.class.getName();
    private final Activity f3503b;
    private C1178d f3504c;
    private JSONObject f3505d;

    public C1414a(Activity activity, C1178d c1178d) {
        this.f3503b = activity;
        this.f3504c = c1178d;
    }

    @JavascriptInterface
    public void startOtpAutoRead(String str, String str2, String str3, String str4) {
        HomeActivity.m5206b(str);
        HomeActivity.m5207c(str2);
        HomeActivity.m5208d(str3);
        HomeActivity.m5209e(str4);
        C1417b.m5346b().m5348a(this.f3503b, this);
    }

    @JavascriptInterface
    public void stopOtpAutoRead() {
        C1417b.m5346b().m5351c();
    }

    @JavascriptInterface
    public JSONObject getOtpRules() {
        return this.f3505d;
    }

    @JavascriptInterface
    public void setOtpRules(String str) {
        try {
            this.f3505d = new JSONObject(str);
        } catch (Throwable e) {
            C1380a.m5276a("OTPJsInterface", "Exception in setOtpRules", e);
        }
    }

    @JavascriptInterface
    public void onOtpReceived() {
        this.f3504c.m4567a("__ROOTSCREEN.onOtpReceived('" + C1417b.m5346b().m5356h() + "');");
    }

    @JavascriptInterface
    public void setSessionStartForOtp(String str) {
        HomeActivity.m5210f(str);
    }
}
