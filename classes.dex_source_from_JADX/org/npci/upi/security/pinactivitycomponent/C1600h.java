package org.npci.upi.security.pinactivitycomponent;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.p004a.C0023a;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Timer;
import org.json.JSONArray;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.C1597a.C1590b;
import org.npci.upi.security.pinactivitycomponent.C1597a.C1592d;
import org.npci.upi.security.pinactivitycomponent.C1597a.C1593e;
import org.npci.upi.security.pinactivitycomponent.C1597a.C1594f;
import org.npci.upi.security.pinactivitycomponent.C1597a.C1595g;
import org.npci.upi.security.pinactivitycomponent.widget.C1599o;
import org.npci.upi.security.pinactivitycomponent.widget.C1621c;
import org.npci.upi.security.pinactivitycomponent.widget.C1623b;

public abstract class C1600h extends Fragment implements C1599o {
    protected JSONObject f4350a = null;
    protected Timer ai;
    protected Handler aj;
    protected Runnable ak;
    protected JSONObject al = null;
    protected JSONArray am = new JSONArray();
    protected long an = 3000;
    protected Context ao;
    private boolean ap = false;
    protected JSONObject f4351b = null;
    protected JSONArray f4352c = null;
    protected Timer f4353d = null;
    protected long f4354e = 45000;
    protected ArrayList f4355f = new ArrayList();
    protected int f4356g = -1;
    protected PopupWindow f4357h;
    protected Timer f4358i = null;

    private void m6508M() {
        JSONObject jSONObject = null;
        Collection arrayList = new ArrayList();
        int i = 0;
        Object obj = null;
        Object obj2 = null;
        Object obj3 = null;
        while (i < this.f4352c.length()) {
            JSONObject jSONObject2;
            Object obj4;
            try {
                String optString = ((JSONObject) this.f4352c.get(i)).optString(CLConstants.FIELD_SUBTYPE, "");
                if (optString.equals(CLConstants.CREDTYPE_ATMPIN)) {
                    obj3 = this.f4352c.getJSONObject(i);
                }
                if (optString.matches("OTP|SMS|HOTP|TOTP")) {
                    obj2 = this.f4352c.getJSONObject(i);
                }
                if (optString.equals(CLConstants.CREDTYPE_MPIN)) {
                    obj = this.f4352c.getJSONObject(i);
                }
                jSONObject2 = optString.equals(CLConstants.CREDTYPE_NMPIN) ? this.f4352c.getJSONObject(i) : jSONObject;
                obj4 = obj;
                obj = obj2;
                obj2 = obj3;
            } catch (Exception e) {
                Exception exception = e;
                Object obj5 = obj;
                obj = obj2;
                obj2 = obj3;
                C1605g.m6534a("NPCIFragment", exception);
                JSONObject jSONObject3 = jSONObject;
                obj4 = obj5;
                jSONObject2 = jSONObject3;
            }
            i++;
            obj3 = obj2;
            obj2 = obj;
            obj = obj4;
            jSONObject = jSONObject2;
        }
        if (!(this.f4352c.length() != 3 || obj3 == null || obj2 == null || obj == null)) {
            arrayList.add(obj2);
            arrayList.add(obj3);
            arrayList.add(obj);
        }
        if (!(this.f4352c.length() != 2 || obj2 == null || obj == null)) {
            arrayList.add(obj2);
            arrayList.add(obj);
        }
        if (!(this.f4352c.length() != 2 || obj == null || jSONObject == null)) {
            arrayList.add(obj);
            arrayList.add(jSONObject);
        }
        if (arrayList.size() > 0) {
            this.f4352c = new JSONArray(arrayList);
        }
    }

    protected void m6509K() {
        Bundle g = m174g();
        if (g != null) {
            try {
                String string = g.getString(CLConstants.INPUT_KEY_CONFIGURATION);
                if (string != null) {
                    this.f4350a = new JSONObject(string);
                }
                string = g.getString(CLConstants.INPUT_KEY_CONTROLS);
                if (string != null) {
                    this.al = new JSONObject(string);
                    string = this.al.getString(CLConstants.FIELD_CRED_ALLOWED);
                    if (string != null) {
                        this.f4352c = new JSONArray(string);
                        m6508M();
                    }
                }
                string = g.getString(CLConstants.INPUT_KEY_SALT);
                if (string != null) {
                    this.f4351b = new JSONObject(string);
                }
                String string2 = g.getString(CLConstants.INPUT_KEY_PAY_INFO);
                if (string2 != null) {
                    this.am = new JSONArray(string2);
                }
            } catch (Throwable e) {
                Log.e("NPCIFragment", "Error while reading Arguments", e);
            }
        }
    }

    protected void m6510L() {
        if (!this.f4350a.optString(CLConstants.CONFIGURATION_RESEND_OTP_FEATURE, "false").equals("false") && !this.ap) {
            m176h().runOnUiThread(new C1610m(this));
        }
    }

    int m6511a(float f) {
        return (int) (((float) (m178i().getDisplayMetrics().densityDpi / 160)) * f);
    }

    protected C1623b m6512a(String str, int i, int i2) {
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        C1623b c1623b = new C1623b(m176h());
        if (this.f4352c.length() == 1) {
            c1623b.setActionBarPositionTop(true);
            layoutParams.width = m6511a(240.0f);
            layoutParams.topMargin = m6511a(40.0f);
            c1623b.getFormInputView().setCharSize(0.0f);
            c1623b.getFormInputView().setSpace((float) m6511a(15.0f));
            c1623b.getFormInputView().setFontSize((float) m6511a(32.0f));
            c1623b.getFormInputView().setPadding(0, m6511a(32.0f), 0, 0);
            c1623b.getFormInputView().setMargin(new int[]{0, m6511a(32.0f), 0, 0});
            c1623b.getFormInputView().setLineStrokeCentered(true);
            c1623b.getFormInputView().setLineStrokeSelected((float) m6511a(2.0f));
            c1623b.getFormInputView().setColorStates(C0023a.m80b(m176h(), C1590b.form_item_input_colors_transparent));
        }
        c1623b.setLayoutParams(layoutParams);
        c1623b.setInputLength(i2);
        c1623b.setFormItemListener(this);
        c1623b.setTitle(str);
        c1623b.setFormItemTag(i);
        return c1623b;
    }

    public abstract void mo895a();

    public void mo891a(Context context) {
        super.mo891a(context);
        this.ao = context;
    }

    public void mo892a(View view, Bundle bundle) {
        super.mo892a(view, bundle);
        if (m176h() instanceof GetCredential) {
            ((GetCredential) m176h()).m6462a(this);
        }
    }

    protected void m6516a(Timer timer) {
        if (timer != null) {
            try {
                timer.cancel();
            } catch (Exception e) {
                C1605g.m6534a("NPCIFragment", e);
            }
        }
    }

    protected void m6517a(C1613p c1613p) {
        try {
            if (this.f4356g != -1) {
                this.ap = true;
                ((C1621c) this.f4355f.get(this.f4356g)).setText(c1613p.m6539b());
            }
        } catch (Exception e) {
        }
    }

    protected void m6518a(C1623b c1623b) {
        this.f4358i = new Timer();
        this.f4358i.schedule(new C1612o(this), this.f4354e);
        c1623b.mo899a("", null, null, 0, false, false);
        c1623b.m6614a(null, false);
        c1623b.m6616a(m139a(C1594f.detecting_otp), null, true, false);
        c1623b.m6617a(true);
    }

    protected void m6519b(View view, String str) {
        if (this.f4357h != null) {
            this.f4357h.dismiss();
        }
        View inflate = m176h().getLayoutInflater().inflate(C1593e.layout_popup_view, null);
        ((TextView) inflate.findViewById(C1592d.popup_text)).setText(str);
        this.f4357h = new PopupWindow(inflate, -2, m6511a(60.0f));
        this.f4357h.setAnimationStyle(C1595g.PopupAnimation);
        this.f4357h.showAtLocation(view, 17, 0, 0);
        inflate.findViewById(C1592d.popup_button).setOnClickListener(new C1608k(this));
        this.ai = new Timer();
        this.aj = new Handler(Looper.getMainLooper());
        this.ak = new C1609l(this);
        this.aj.postDelayed(this.ak, this.an);
    }

    public void m6520b(C1613p c1613p) {
        m6517a(c1613p);
    }

    public void m6521c(int i) {
        if (m176h() != null && (m176h() instanceof GetCredential)) {
            ((GetCredential) m176h()).m6464b(i);
        }
        C1614q c1614q = new C1614q(m176h());
        this.f4353d = new Timer();
        this.f4353d.scheduleAtFixedRate(new C1606i(this, c1614q, i), 100, 2000);
    }

    public void mo893q() {
        super.mo893q();
        m6516a(this.f4353d);
        m6516a(this.f4358i);
        m6516a(this.ai);
        if (!(this.aj == null || this.ak == null)) {
            this.aj.removeCallbacks(this.ak);
        }
        if (this.f4357h != null) {
            this.f4357h.dismiss();
        }
    }
}
