package org.npci.upi.security.pinactivitycomponent;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.p004a.C0023a;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;
import in.org.npci.commonlibrary.Message;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.C1597a.C1591c;
import org.npci.upi.security.pinactivitycomponent.C1597a.C1592d;
import org.npci.upi.security.pinactivitycomponent.C1597a.C1593e;
import org.npci.upi.security.pinactivitycomponent.C1597a.C1594f;
import org.npci.upi.security.pinactivitycomponent.widget.C1599o;
import org.npci.upi.security.pinactivitycomponent.widget.C1621c;
import org.npci.upi.security.pinactivitycomponent.widget.C1622a;
import org.npci.upi.security.pinactivitycomponent.widget.C1623b;

public class C1601b extends C1600h implements C1599o {
    private static final String ap = C1601b.class.getSimpleName();
    private HashMap aq = new HashMap();
    private int ar = 0;
    private boolean as = false;
    private ViewSwitcher at = null;

    private void m6523M() {
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
        if (!this.as) {
            this.as = true;
            while (i < this.f.size()) {
                try {
                    JSONObject jSONObject = (JSONObject) ((C1621c) this.f.get(i)).getFormDataTag();
                    inputValue = jSONObject.getString(CLConstants.FIELD_TYPE);
                    String string = jSONObject.getString(CLConstants.FIELD_SUBTYPE);
                    this.b.put(CLConstants.SALT_FIELD_CREDENTIAL, ((C1621c) this.f.get(i)).getInputValue());
                    Message a = ((GetCredential) this.ao).m6469o().m6577b().m6487a(((GetCredential) this.ao).m6469o().m6575a().m6567a(this.b), inputValue, string, this.b);
                    if (a != null) {
                        this.aq.put(string, ao.m6501a(a));
                    }
                } catch (Exception e) {
                    C1605g.m6534a(ap, e);
                }
                i++;
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable("credBlocks", this.aq);
            ((GetCredential) this.ao).m6469o().m6579d().send(1, bundle);
            ((GetCredential) this.ao).m6469o().m6578c().finish();
        }
    }

    private void m6524N() {
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
                c1621c.mo899a(a4, a, new C1619v(this, c1621c, a3, a4, a2, a), 0, true, true);
            }
        }
    }

    private void m6525a(View view) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C1592d.switcherLayout1);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(C1592d.switcherLayout2);
        this.at = (ViewSwitcher) view.findViewById(C1592d.view_switcher);
        if (this.c != null) {
            for (int i = 0; i < this.c.length(); i++) {
                try {
                    JSONObject jSONObject = this.c.getJSONObject(i);
                    String string = jSONObject.getString(CLConstants.FIELD_SUBTYPE);
                    int optInt = jSONObject.optInt(CLConstants.FIELD_DLENGTH) == 0 ? 6 : jSONObject.optInt(CLConstants.FIELD_DLENGTH);
                    View c1622a;
                    if (string.equals(CLConstants.CREDTYPE_MPIN)) {
                        C1623b a = m6512a(m139a(C1594f.npci_set_mpin_title), i, optInt);
                        C1623b a2 = m6512a(m139a(C1594f.npci_confirm_mpin_title), i, optInt);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(a);
                        arrayList.add(a2);
                        c1622a = new C1622a(m176h());
                        c1622a.m6598a(arrayList, (C1599o) this);
                        c1622a.setFormDataTag(jSONObject);
                        this.f.add(c1622a);
                        linearLayout2.addView(c1622a);
                    } else {
                        String str = "";
                        if (string.equals(CLConstants.CREDTYPE_ATMPIN)) {
                            str = m139a(C1594f.npci_atm_title);
                        } else if (CLConstants.CREDTYPE_OTP.equals(string) || CLConstants.CREDTYPE_SMS.equals(string) || CLConstants.CREDTYPE_EMAIL.equals(string) || CLConstants.CREDTYPE_HOTP.equals(string) || CLConstants.CREDTYPE_TOTP.equals(string)) {
                            string = m139a(C1594f.npci_otp_title);
                            this.g = i;
                            if ((m176h() instanceof GetCredential) && ((GetCredential) m176h()).m6468n()) {
                                m6521c(optInt);
                            }
                            str = string;
                        }
                        c1622a = m6512a(str, i, optInt);
                        c1622a.setFormDataTag(jSONObject);
                        this.f.add(c1622a);
                        linearLayout.addView(c1622a);
                    }
                } catch (Throwable e) {
                    Log.e(ap, "Error while inflating Layout", e);
                }
            }
        }
    }

    public View mo894a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(C1593e.fragment_atmpin, viewGroup, false);
    }

    public void mo895a() {
        if (this.ar == 0) {
            ((C1621c) this.f.get(this.ar + 1)).mo901d();
            this.ar++;
            return;
        }
        if (this.ar == 1) {
            if (((C1623b) this.f.get(0)).getInputLength() != ((C1621c) this.f.get(0)).getInputValue().length()) {
                m6519b((View) this.f.get(0), m139a(C1594f.npci_otp_title));
                return;
            } else if (((C1623b) this.f.get(1)).getInputLength() != ((C1621c) this.f.get(1)).getInputValue().length()) {
                m6519b((View) this.f.get(1), m139a(C1594f.npci_atm_title));
                return;
            } else if (this.at != null) {
                this.at.showNext();
                this.ar = 2;
                return;
            }
        }
        if (this.ar != 2) {
            m6523M();
        } else if (((C1621c) this.f.get(this.ar)).mo901d()) {
            m6523M();
        }
    }

    public void mo896a(int i, String str) {
        if (this.g != -1 && this.g == i && (this.f.get(this.g) instanceof C1623b)) {
            m6516a(this.i);
            ((C1623b) this.f.get(this.g)).m6617a(false);
            ((C1623b) this.f.get(this.g)).m6616a("", null, false, false);
            ((C1623b) this.f.get(this.g)).m6614a(C0023a.m77a(m176h(), C1591c.ic_tick_ok), true);
        }
    }

    public void mo892a(View view, Bundle bundle) {
        super.mo892a(view, bundle);
        m6509K();
        m6525a(view);
        m6524N();
    }

    public void mo897a(View view, String str) {
        m6519b(view, str);
    }

    public void mo898b(int i) {
        if (!(this.f.get(i) instanceof C1622a)) {
            this.ar = i;
        }
    }
}
