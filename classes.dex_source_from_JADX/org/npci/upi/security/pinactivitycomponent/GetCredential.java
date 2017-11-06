package org.npci.upi.security.pinactivitycomponent;

import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.C0103r;
import android.support.v4.app.C0116p;
import android.support.v4.app.Fragment;
import android.support.v4.view.ag;
import android.support.v7.p012a.C0435b;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import io.fabric.sdk.android.services.p018c.C0670b;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.C1597a.C1592d;
import org.npci.upi.security.pinactivitycomponent.C1597a.C1593e;
import org.npci.upi.security.pinactivitycomponent.C1597a.C1594f;

public class GetCredential extends C0435b {
    private static final String f4293m = GetCredential.class.getSimpleName();
    private TransitionDrawable f4294A;
    private ImageView f4295B;
    private int f4296C;
    private boolean f4297D = false;
    private int f4298E = 0;
    private UncaughtExceptionHandler f4299F = null;
    private JSONObject f4300n = null;
    private JSONObject f4301o = null;
    private JSONObject f4302p = null;
    private JSONArray f4303q = null;
    private JSONArray f4304r = new JSONArray();
    private String f4305s = CLConstants.DEFAULT_LANGUAGE_PREFERENCE;
    private an f4306t;
    private C1620w f4307u;
    private C1600h f4308v = null;
    private final Context f4309w = this;
    private am f4310x;
    private View f4311y;
    private View f4312z;

    private int m6440a(float f) {
        return (int) (((float) (getResources().getDisplayMetrics().densityDpi / 160)) * f);
    }

    private void m6445b(boolean z) {
        float f = 0.0f;
        if (z) {
            m6461a(0.0f, 180.0f, 300, this.f4295B);
        } else {
            m6461a(180.0f, 0.0f, 300, this.f4295B);
        }
        if (VERSION.SDK_INT > 14) {
            int height = this.f4311y.getHeight();
            if (height == 0) {
                height = this.f4296C;
            }
            this.f4311y.clearAnimation();
            ViewPropertyAnimator y = this.f4311y.animate().y(z ? 0.0f : -1.0f * ((float) height));
            if (z) {
                f = 1.0f;
            }
            y.alpha(f).setDuration(300).setInterpolator(new AccelerateInterpolator()).setListener(new al(this, z, height));
            return;
        }
        this.f4311y.setVisibility(z ? 0 : 8);
    }

    private boolean m6453q() {
        String[] strArr = new String[]{CLConstants.CREDTYPE_ATMPIN, "SMS|EMAIL|HOTP|TOTP", CLConstants.CREDTYPE_MPIN};
        String[] strArr2 = new String[3];
        if (this.f4303q != null && this.f4303q.length() == 3) {
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < this.f4303q.length(); i4++) {
                try {
                    strArr2[i4] = ((JSONObject) this.f4303q.get(i4)).optString(CLConstants.FIELD_SUBTYPE, "");
                    if (strArr2[i4].matches(strArr[0])) {
                        i3 = true;
                    }
                    if (strArr2[i4].matches(strArr[1])) {
                        i2 = true;
                    }
                    if (strArr2[i4].matches(strArr[2])) {
                        i = true;
                    }
                } catch (Exception e) {
                    C1605g.m6534a(f4293m, e);
                }
            }
            if (!(i3 == 0 || r4 == 0 || r3 == 0)) {
                return true;
            }
        }
        return false;
    }

    private void m6454r() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            try {
                String string = extras.getString(CLConstants.INPUT_KEY_CONFIGURATION);
                if (string != null) {
                    this.f4300n = new JSONObject(string);
                }
                string = extras.getString(CLConstants.INPUT_KEY_CONTROLS);
                if (string != null) {
                    this.f4301o = new JSONObject(string);
                    if (this.f4301o != null) {
                        string = this.f4301o.getString(CLConstants.FIELD_CRED_ALLOWED);
                        if (string != null) {
                            this.f4303q = new JSONArray(string);
                        }
                    }
                }
                string = extras.getString(CLConstants.INPUT_KEY_SALT);
                if (string != null) {
                    this.f4302p = new JSONObject(string);
                }
                string = extras.getString(CLConstants.INPUT_KEY_PAY_INFO);
                if (string != null) {
                    this.f4304r = new JSONArray(string);
                }
                String string2 = extras.getString(CLConstants.INPUT_KEY_LANGUAGE_PREFERENCE);
                if (string2 != null) {
                    this.f4305s = string2;
                    String[] split = this.f4305s.split(C0670b.ROLL_OVER_FILE_NAME_SEPARATOR);
                    Locale locale = new Locale(this.f4305s);
                    if (split.length == 2) {
                        locale = new Locale(split[0], split[1]);
                    }
                    Locale.setDefault(locale);
                    Configuration configuration = new Configuration();
                    configuration.locale = locale;
                    getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
                }
            } catch (Exception e) {
                C1605g.m6534a(f4293m, e);
            }
        }
    }

    private void m6455s() {
        Keypad keypad = (Keypad) findViewById(C1592d.fragmentTelKeyboard);
        if (keypad != null) {
            keypad.setOnKeyPressCallback(new ah(this));
        }
    }

    private boolean m6456t() {
        return this.f4311y.getVisibility() == 0;
    }

    private void m6457u() {
        this.f4306t = new an();
        try {
            this.f4307u = new C1620w(getApplicationContext(), this.f4306t, this);
            this.f4306t.m6496a(getIntent().getExtras(), this);
        } catch (Throwable e) {
            Log.e(f4293m, e.m6532a(), e);
        } catch (Throwable e2) {
            Log.e(f4293m, "Error parsing and validating arguments to CL", e2);
        }
    }

    private void m6458v() {
        IntentFilter intentFilter = new IntentFilter();
        try {
            intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
            intentFilter.setPriority(999);
            registerReceiver(this.f4310x, intentFilter);
        } catch (Throwable th) {
            C1605g.m6535a(f4293m, "Failed to register SMS broadcast receiver (Ignoring)");
        }
    }

    private void m6459w() {
        try {
            if (this.f4310x != null) {
                unregisterReceiver(this.f4310x);
                this.f4310x = null;
            }
        } catch (Throwable th) {
            C1605g.m6535a(f4293m, "Failed to unregister SMS receiver (Ignoring)");
        }
    }

    private void m6460x() {
        Bundle bundle = new Bundle();
        bundle.putString(CLConstants.OUTPUT_KEY_ERROR, "USER_ABORTED");
        m6469o().m6579d().send(0, bundle);
        finish();
    }

    public void m6461a(float f, float f2, int i, View view) {
        Animation rotateAnimation = new RotateAnimation(f, f2, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setDuration((long) i);
        rotateAnimation.setFillEnabled(true);
        rotateAnimation.setFillAfter(true);
        view.startAnimation(rotateAnimation);
    }

    public void m6462a(C1600h c1600h) {
        this.f4308v = c1600h;
    }

    public void m6463a(C1600h c1600h, Bundle bundle, boolean z) {
        try {
            C0116p f = m428f();
            if (bundle != null) {
                c1600h.m175g(bundle);
            }
            C0103r a = f.mo77a();
            a.mo47a(C1592d.main_inner_layout, (Fragment) c1600h);
            if (z) {
                a.mo50a(c1600h.getClass().getSimpleName());
            }
            a.mo51b();
            m6462a(c1600h);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void m6464b(int i) {
        this.f4298E = i;
    }

    void m6465k() {
        String str = "";
        if (this.f4300n != null) {
            CharSequence optString = this.f4300n.optString(CLConstants.FIELD_PAYER_BANK_NAME);
        } else {
            Object obj = str;
        }
        if (this.f4302p == null) {
            C1603d c1603d = new C1603d(this, "l12", CLConstants.ERROR_MSG_SALT_MISSING);
            return;
        }
        CharSequence optString2;
        Object optString3;
        String optString4 = this.f4302p.optString("txnAmount");
        String str2 = "";
        if (str2.equals("")) {
            int i = 0;
            while (i < this.f4304r.length()) {
                try {
                    if (((JSONObject) this.f4304r.get(i)).optString(CLConstants.FIELD_PAY_INFO_NAME, "").equals("payeeName")) {
                        optString2 = ((JSONObject) this.f4304r.get(i)).optString(CLConstants.FIELD_PAY_INFO_VALUE, "");
                        break;
                    } else if (((JSONObject) this.f4304r.get(i)).optString(CLConstants.FIELD_PAY_INFO_NAME, "").equals("account")) {
                        optString3 = ((JSONObject) this.f4304r.get(i)).optString(CLConstants.FIELD_PAY_INFO_VALUE, "");
                        break;
                    } else if (((JSONObject) this.f4304r.get(i)).optString(CLConstants.FIELD_PAY_INFO_NAME, "").equals(CLConstants.SALT_FIELD_MOBILE_NUMBER)) {
                        optString3 = ((JSONObject) this.f4304r.get(i)).optString(CLConstants.LABEL_MOBILE_NUMBER, "");
                        break;
                    } else {
                        i++;
                    }
                } catch (Exception e) {
                    C1605g.m6534a(f4293m, e);
                }
            }
        }
        optString3 = str2;
        LinearLayout linearLayout = (LinearLayout) findViewById(C1592d.transaction_bar_root);
        TextView textView = (TextView) findViewById(C1592d.tv_acc_or_payee);
        TextView textView2 = (TextView) findViewById(C1592d.transaction_bar_title);
        TextView textView3 = (TextView) findViewById(C1592d.transaction_bar_info);
        this.f4295B = (ImageView) findViewById(C1592d.transaction_bar_arrow);
        textView2.setText(optString2);
        if (!optString.equals("")) {
            textView.setText(optString);
        }
        if (!optString4.equals("")) {
            textView3.setText("₹ " + optString4);
        }
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        if (VERSION.SDK_INT >= 13) {
            defaultDisplay.getSize(point);
            this.f4296C = point.y;
        } else {
            this.f4296C = defaultDisplay.getHeight();
        }
        linearLayout.setOnClickListener(new ai(this));
        this.f4311y = findViewById(C1592d.transaction_details_scroller);
        this.f4312z = findViewById(C1592d.transaction_details_expanded_space);
        this.f4311y.setOnTouchListener(new aj(this));
        if (this.f4312z != null) {
            this.f4312z.setOnTouchListener(new ak(this));
        }
        this.f4294A = (TransitionDrawable) findViewById(C1592d.transaction_info_root).getBackground();
        this.f4294A.setCrossFadeEnabled(true);
    }

    void m6466l() {
        LinearLayout linearLayout = (LinearLayout) findViewById(C1592d.transaction_details_root);
        for (int i = 0; i < this.f4304r.length(); i++) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this).inflate(C1593e.layout_transaction_details_item, linearLayout, false);
            TextView textView = (TextView) viewGroup.findViewById(C1592d.transaction_details_item_name);
            TextView textView2 = (TextView) viewGroup.findViewById(C1592d.transaction_details_item_value);
            JSONObject optJSONObject = this.f4304r.optJSONObject(i);
            textView.setText(optJSONObject.optString(CLConstants.FIELD_PAY_INFO_NAME).toUpperCase());
            textView2.setText(optJSONObject.optString(CLConstants.FIELD_PAY_INFO_VALUE));
            linearLayout.addView(viewGroup);
        }
        View view = new View(this);
        view.setLayoutParams(new LayoutParams(-1, m6440a(3.0f)));
        view.setBackgroundColor(-16777216);
        ag.m1275b(view, 0.33f);
        linearLayout.addView(view);
    }

    public boolean m6467m() {
        return checkCallingOrSelfPermission("android.permission.RECEIVE_SMS") == 0;
    }

    public boolean m6468n() {
        return checkCallingOrSelfPermission("android.permission.READ_SMS") == 0;
    }

    public C1620w m6469o() {
        return this.f4307u;
    }

    public void onBackPressed() {
        if (this.f4297D) {
            Bundle bundle = new Bundle();
            bundle.putString(CLConstants.OUTPUT_KEY_ERROR, "USER_ABORTED");
            m6469o().m6579d().send(0, bundle);
            super.onBackPressed();
            return;
        }
        this.f4297D = true;
        Toast.makeText(this, getString(C1594f.back_button_exit_message), 0).show();
        new Handler().postDelayed(new ag(this), 2000);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4299F = Thread.currentThread().getUncaughtExceptionHandler();
        Thread.currentThread().setUncaughtExceptionHandler(new ad());
        m6454r();
        setContentView(C1593e.activity_pin_activity_component);
        m6455s();
        m6457u();
        m6465k();
        m6466l();
        if (m6453q()) {
            m6463a(new C1601b(), getIntent().getExtras(), false);
        } else {
            m6463a(new C1615r(), getIntent().getExtras(), false);
        }
        TextView textView = (TextView) findViewById(C1592d.go_back);
        if (textView != null) {
            textView.setOnClickListener(new af(this));
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        Thread.currentThread().setUncaughtExceptionHandler(this.f4299F);
    }

    protected void onPause() {
        super.onPause();
        m6459w();
    }

    protected void onResume() {
        super.onResume();
        if (m6467m()) {
            this.f4310x = new am();
            m6458v();
            return;
        }
        Log.e(f4293m, "RECEIVE_SMS permission not provided by the App. This will affect Auto OTP detection feature of Common Library");
    }
}
