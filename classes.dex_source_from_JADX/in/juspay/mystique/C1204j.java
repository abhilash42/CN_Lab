package in.juspay.mystique;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class C1204j {
    private C1191g f2644a;
    private Activity f2645b;
    private View f2646c;
    private View f2647d;
    private ViewGroup f2648e;
    private C1179e f2649f;
    private C1178d f2650g;
    private C1172c f2651h = C1178d.m4562c();

    public void m4632a() {
        this.f2644a.m4614b();
    }

    C1204j(Activity activity, C1178d c1178d) {
        this.f2650g = c1178d;
        System.currentTimeMillis();
        this.f2645b = activity;
        this.f2649f = c1178d.m4571d();
        this.f2644a = new C1191g(this.f2645b, this.f2651h, this.f2649f, c1178d);
    }

    public void m4633a(String str, ViewGroup viewGroup) {
        this.f2648e = viewGroup;
        this.f2646c = m4630a(new JSONObject(str));
        if (!(this.f2647d == null || this.f2647d == this.f2646c)) {
            m4629b(this.f2647d);
        }
        m4628a(this.f2646c);
        this.f2647d = this.f2646c;
    }

    public void m4635a(String str, JSONObject jSONObject, int i, boolean z) {
        int identifier = this.f2645b.getResources().getIdentifier(str, "id", this.f2645b.getPackageName());
        if (i >= 0) {
            ViewGroup viewGroup = (ViewGroup) this.f2645b.findViewById(identifier);
            if (z) {
                viewGroup.removeAllViews();
            }
            View a = m4630a(jSONObject);
            if (a != null) {
                viewGroup.addView(a, i);
                return;
            } else {
                this.f2649f.mo786a("ERROR", " isNull : fn__addViewToParent - child null " + m4636b());
                return;
            }
        }
        if (jSONObject.has("props")) {
            m4634a(jSONObject.getString(CLConstants.FIELD_TYPE), jSONObject.getJSONObject("props"));
        }
        this.f2649f.mo786a("ERROR", " isNull : fn__addViewToParent - negative index " + m4636b());
    }

    public void m4634a(String str, JSONObject jSONObject) {
        this.f2644a.m4615b(str);
        if (jSONObject.has("node_id")) {
            this.f2644a.m4611a(jSONObject.getString("node_id"));
        }
        if (jSONObject.has("__filename")) {
            this.f2644a.m4616c(jSONObject.getString("__filename"));
        }
    }

    public View m4630a(JSONObject jSONObject) {
        String string = jSONObject.getString(CLConstants.FIELD_TYPE);
        JSONObject jSONObject2 = jSONObject.getJSONObject("props");
        if (jSONObject.has("props")) {
            m4634a(string, jSONObject2);
        }
        Class cls = Class.forName(string);
        Object newInstance = cls.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.f2645b});
        Iterator keys = jSONObject2.keys();
        while (keys.hasNext()) {
            this.f2644a.m4613a((String) keys.next(), jSONObject2, newInstance);
        }
        JSONArray jSONArray = jSONObject.getJSONArray("children");
        if (!(jSONArray == null || jSONArray.length() == 0)) {
            for (int i = 0; i < jSONArray.length(); i++) {
                if (m4630a(jSONArray.getJSONObject(i)) != null) {
                    cls.getMethod("addView", new Class[]{View.class}).invoke(newInstance, new Object[]{r5});
                }
            }
        }
        return (View) newInstance;
    }

    private View m4628a(View view) {
        if (view != null) {
            this.f2648e.addView(view);
        } else {
            this.f2649f.mo786a("ERROR", " isNull : fn__Render -  instance null " + m4636b());
        }
        return this.f2648e;
    }

    private void m4629b(View view) {
        this.f2648e.removeViewAt(this.f2648e.indexOfChild(view));
    }

    public String m4636b() {
        return this.f2644a.m4610a();
    }

    public Object m4631a(Object obj, String str, String str2, String str3) {
        this.f2644a.m4615b("modifyDom");
        this.f2644a.m4611a("");
        this.f2644a.m4616c("ln: " + str2 + " " + str3);
        return this.f2644a.m4609a(obj, str);
    }
}
