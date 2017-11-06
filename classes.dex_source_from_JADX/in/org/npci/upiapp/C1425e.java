package in.org.npci.upiapp;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import in.juspay.mystique.C1178d;
import in.juspay.mystique.C1204j;
import in.org.npci.upiapp.p036a.C1380a;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: ListViewAdapter */
public class C1425e extends ArrayAdapter<String> {
    private int f3539a = 1;
    private ArrayList<String> f3540b;
    private final C1178d f3541c;
    private final C1204j f3542d;
    private ArrayList<String> f3543e;
    private ArrayList<Integer> f3544f;
    private final String f3545g;

    /* compiled from: ListViewAdapter */
    static class C1424a {
        public View f3538a;

        C1424a() {
        }
    }

    public C1425e(Context context, int i, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<Integer> arrayList3, C1178d c1178d, String str) {
        super(context, 2130968611, arrayList);
        this.f3539a = i;
        this.f3540b = arrayList;
        this.f3541c = c1178d;
        this.f3542d = c1178d.m4568b().m4623a();
        this.f3543e = arrayList2;
        this.f3544f = arrayList3;
        this.f3545g = str;
    }

    public View getView(final int i, View view, ViewGroup viewGroup) {
        View a;
        C1424a c1424a;
        if (view == null) {
            try {
                a = m5400a(viewGroup, i);
                c1424a = new C1424a();
                c1424a.f3538a = a;
                a.setTag(c1424a);
            } catch (Throwable e) {
                C1380a.m5276a("ListViewAdapter", "Exception in getView", e);
                return null;
            }
        }
        a = view;
        c1424a = (C1424a) a.getTag();
        this.f3541c.m4568b().m4624a(c1424a.f3538a, ((String) this.f3540b.get(i)).replace("ctx", "parent"));
        a.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ C1425e f3537b;

            public void onClick(View view) {
                this.f3537b.f3541c.m4567a(String.format("window.callJSCallback('%s','%s');", new Object[]{this.f3537b.f3545g, Integer.valueOf(i)}));
            }
        });
        return a;
    }

    public int getViewTypeCount() {
        return this.f3539a;
    }

    public int getItemViewType(int i) {
        return ((Integer) this.f3544f.get(i)).intValue();
    }

    public void m5404a(int i, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<Integer> arrayList3) {
        this.f3539a = i;
        this.f3540b.addAll(arrayList);
        this.f3543e.addAll(arrayList2);
        this.f3544f.addAll(arrayList3);
    }

    private View m5400a(ViewGroup viewGroup, int i) {
        return this.f3542d.m4630a(new JSONObject((String) this.f3543e.get(i)));
    }

    public View m5403a(String str) {
        try {
            return this.f3542d.m4630a(new JSONObject(str));
        } catch (Exception e) {
            return null;
        }
    }
}
