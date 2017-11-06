package in.org.npci.upiapp;

import android.content.Context;
import android.support.v4.view.ab;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import in.juspay.mystique.C1178d;
import in.juspay.mystique.C1204j;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: ViewPagerAdapter */
public class C1431i extends ab {
    private Context f3554a;
    private ArrayList<String> f3555b = new ArrayList();
    private C1178d f3556c;
    private C1204j f3557d;
    private ArrayList<String> f3558e;
    private ArrayList<String> f3559f;

    public C1431i(Context context, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, C1178d c1178d) {
        this.f3554a = context;
        this.f3555b = arrayList;
        this.f3556c = c1178d;
        this.f3557d = c1178d.m4568b().m4623a();
        this.f3558e = arrayList2;
        this.f3559f = arrayList3;
    }

    public int mo804a() {
        return this.f3555b.size();
    }

    public boolean mo808a(View view, Object obj) {
        return view == obj;
    }

    public Object mo806a(ViewGroup viewGroup, int i) {
        View c = m5419c(i);
        viewGroup.addView(c);
        this.f3556c.m4568b().m4624a(c, ((String) this.f3555b.get(i)).replace("ctx", "parent"));
        return c;
    }

    public CharSequence mo805a(int i) {
        return new SpannableString((CharSequence) this.f3559f.get(i));
    }

    public void mo807a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    private View m5419c(int i) {
        try {
            return this.f3557d.m4630a(new JSONObject((String) this.f3558e.get(i)));
        } catch (Exception e) {
            return null;
        }
    }
}
