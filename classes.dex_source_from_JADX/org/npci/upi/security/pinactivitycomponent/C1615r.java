package org.npci.upi.security.pinactivitycomponent;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.p004a.C0023a;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import in.org.npci.commonlibrary.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.C1597a.C1591c;
import org.npci.upi.security.pinactivitycomponent.C1597a.C1592d;
import org.npci.upi.security.pinactivitycomponent.C1597a.C1593e;
import org.npci.upi.security.pinactivitycomponent.C1597a.C1594f;
import org.npci.upi.security.pinactivitycomponent.widget.C1599o;
import org.npci.upi.security.pinactivitycomponent.widget.C1621c;
import org.npci.upi.security.pinactivitycomponent.widget.C1622a;
import org.npci.upi.security.pinactivitycomponent.widget.C1623b;

public class C1615r extends C1600h implements C1599o {
    private static final String ar = C1600h.class.getSimpleName();
    LinearLayout ap;
    LinearLayout aq;
    private int as = 0;
    private Timer at = null;
    private Boolean au = null;
    private HashMap av = new HashMap();
    private boolean aw = false;

    private void m6555M() {
        C1623b c1623b;
        String inputValue;
        int i = 0;
        if (this.g != -1 && (this.f.get(this.g) instanceof C1623b)) {
            c1623b = (C1623b) this.f.get(this.g);
            inputValue = c1623b.getInputValue();
            if (inputValue == null || inputValue.length() != c1623b.getInputLength()) {
                m6519b(c1623b, m139a(C1594f.invalid_otp));
                return;
            }
        }
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            if (this.f.get(i2) instanceof C1623b) {
                c1623b = (C1623b) this.f.get(i2);
                if (c1623b.getInputValue().length() != c1623b.getInputLength()) {
                    m6519b(c1623b, m139a(C1594f.componentMessage));
                    return;
                }
            }
        }
        if (!this.aw) {
            this.aw = true;
            while (i < this.f.size()) {
                try {
                    JSONObject jSONObject = (JSONObject) ((C1621c) this.f.get(i)).getFormDataTag();
                    inputValue = jSONObject.getString(CLConstants.FIELD_TYPE);
                    String string = jSONObject.getString(CLConstants.FIELD_SUBTYPE);
                    this.b.put(CLConstants.SALT_FIELD_CREDENTIAL, ((C1621c) this.f.get(i)).getInputValue());
                    Message a = ((GetCredential) this.ao).m6469o().m6577b().m6487a(((GetCredential) this.ao).m6469o().m6575a().m6567a(this.b), inputValue, string, this.b);
                    if (a != null) {
                        this.av.put(string, ao.m6501a(a));
                    }
                } catch (Exception e) {
                    C1605g.m6534a(ar, e);
                }
                i++;
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable("credBlocks", this.av);
            ((GetCredential) this.ao).m6469o().m6579d().send(1, bundle);
            ((GetCredential) this.ao).m6469o().m6578c().finish();
        }
    }

    private boolean m6556N() {
        if (this.au != null) {
            return this.au.booleanValue();
        }
        if (this.c != null) {
            List arrayList = new ArrayList();
            for (int i = 0; i < this.c.length(); i++) {
                try {
                    String string = this.c.getJSONObject(i).getString(CLConstants.FIELD_SUBTYPE);
                    if (string != null) {
                        arrayList.add(string);
                    }
                } catch (Exception e) {
                    C1605g.m6534a(ar, e);
                }
            }
            if (arrayList.contains(CLConstants.CREDTYPE_OTP) || arrayList.contains(CLConstants.CREDTYPE_SMS) || arrayList.contains(CLConstants.CREDTYPE_EMAIL) || arrayList.contains(CLConstants.CREDTYPE_HOTP) || (arrayList.contains(CLConstants.CREDTYPE_TOTP) && arrayList.contains(CLConstants.CREDTYPE_MPIN))) {
                this.au = Boolean.valueOf(true);
                return this.au.booleanValue();
            }
        }
        this.au = Boolean.valueOf(false);
        return this.au.booleanValue();
    }

    private void m6557O() {
        if (this.g != -1 && (this.f.get(this.g) instanceof C1623b)) {
            C1623b c1623b = (C1623b) this.f.get(this.g);
            m6518a(c1623b);
            c1623b.m6612a();
        }
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            if (i != this.g) {
                C1621c c1621c = (C1621c) this.f.get(i);
                Drawable a = C0023a.m77a(m176h(), C1591c.ic_visibility_on);
                Drawable a2 = C0023a.m77a(m176h(), C1591c.ic_visibility_off);
                String a3 = m139a(C1594f.action_hide);
                String a4 = m139a(C1594f.action_show);
                c1621c.mo899a(a4, a, new C1616s(this, c1621c, a3, a4, a2, a), 0, true, true);
            }
        }
    }

    private void m6558a(View view) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C1592d.main_inner_layout);
        if (this.c != null) {
            int i = 0;
            while (i < this.c.length()) {
                try {
                    JSONObject jSONObject = this.c.getJSONObject(i);
                    String string = jSONObject.getString(CLConstants.FIELD_SUBTYPE);
                    int optInt = jSONObject.optInt(CLConstants.FIELD_DLENGTH) == 0 ? 6 : jSONObject.optInt(CLConstants.FIELD_DLENGTH);
                    if (!string.equals(CLConstants.CREDTYPE_MPIN) && !string.equals(CLConstants.CREDTYPE_NMPIN) && !CLConstants.CREDTYPE_ATMPIN.equals(string) && !CLConstants.CREDTYPE_OTP.equals(string) && !CLConstants.CREDTYPE_SMS.equals(string) && !CLConstants.CREDTYPE_EMAIL.equals(string) && !CLConstants.CREDTYPE_HOTP.equals(string) && !CLConstants.CREDTYPE_TOTP.equals(string)) {
                        i++;
                    } else if (string.equals(CLConstants.CREDTYPE_NMPIN) || (string.equals(CLConstants.CREDTYPE_MPIN) && m6556N())) {
                        C1623b a = m6512a(m139a(C1594f.npci_set_mpin_title), i, optInt);
                        C1623b a2 = m6512a(m139a(C1594f.npci_confirm_mpin_title), i, optInt);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(a);
                        arrayList.add(a2);
                        r1 = new C1622a(m176h());
                        r1.m6598a(arrayList, (C1599o) this);
                        r1.setFormDataTag(jSONObject);
                        this.f.add(r1);
                        linearLayout.addView(r1);
                        i++;
                    } else {
                        String str = "";
                        if (string.equals(CLConstants.CREDTYPE_MPIN)) {
                            str = m139a(C1594f.npci_mpin_title);
                        } else if (CLConstants.CREDTYPE_OTP.equals(string) || CLConstants.CREDTYPE_SMS.equals(string) || CLConstants.CREDTYPE_EMAIL.equals(string) || CLConstants.CREDTYPE_HOTP.equals(string) || CLConstants.CREDTYPE_TOTP.equals(string)) {
                            string = m139a(C1594f.npci_otp_title);
                            this.g = i;
                            if ((m176h() instanceof GetCredential) && ((GetCredential) m176h()).m6468n()) {
                                m6521c(optInt);
                                str = string;
                            } else {
                                str = string;
                            }
                        } else if (CLConstants.CREDTYPE_ATMPIN.equals(string)) {
                            str = m139a(C1594f.npci_atm_title);
                        }
                        r1 = m6512a(str, i, optInt);
                        r1.setFormDataTag(jSONObject);
                        this.f.add(r1);
                        linearLayout.addView(r1);
                        i++;
                    }
                } catch (Throwable e) {
                    Log.e(ar, "Error while inflating Layout", e);
                }
            }
        }
    }

    public View mo894a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(C1593e.fragment_pin, viewGroup, false);
    }

    public void mo895a() {
        if (this.as >= this.f.size() - 1) {
            m6555M();
        } else if (((C1621c) this.f.get(this.as + 1)).mo901d()) {
            this.as++;
            if (this.as >= this.f.size() - 1) {
                m6555M();
            }
        }
    }

    public void mo896a(int i, String str) {
        if (this.g != -1 && this.g == i && (this.f.get(this.g) instanceof C1623b)) {
            m6516a(this.at);
            ((C1623b) this.f.get(this.g)).m6617a(false);
            ((C1623b) this.f.get(this.g)).m6616a("", null, false, false);
            ((C1623b) this.f.get(this.g)).m6614a(C0023a.m77a(m176h(), C1591c.ic_tick_ok), true);
        }
    }

    public void mo892a(View view, Bundle bundle) {
        super.mo892a(view, bundle);
        this.aq = (LinearLayout) view.findViewById(C1592d.main_inner_layout);
        this.ap = (LinearLayout) view.findViewById(C1592d.main_layout);
        m6509K();
        m6558a(view);
        m6557O();
    }

    public void mo897a(View view, String str) {
        m6519b(view, str);
    }

    public void mo898b(int i) {
        if (!(this.f.get(i) instanceof C1622a)) {
            this.as = i;
        }
    }
}
