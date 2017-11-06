package in.org.npci.upiapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

/* compiled from: CustomAdapterIfsc */
public class C1384b extends ArrayAdapter<C1422d> {
    Context f3269a;
    private ArrayList<C1422d> f3270b;

    /* compiled from: CustomAdapterIfsc */
    private static class C1383a {
        ImageView f3260a;
        TextView f3261b;
        TextView f3262c;
        TextView f3263d;
        TextView f3264e;
        ImageView f3265f;
        LinearLayout f3266g;
        LinearLayout f3267h;
        LinearLayout f3268i;

        private C1383a() {
        }
    }

    public /* synthetic */ Object getItem(int i) {
        return m5282a(i);
    }

    public C1384b(ArrayList<C1422d> arrayList, Context context) {
        super(context, 2130968621, arrayList);
        this.f3270b = arrayList;
        this.f3269a = context;
    }

    public int getCount() {
        return this.f3270b.size();
    }

    public C1422d m5282a(int i) {
        return (C1422d) this.f3270b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public int getItemViewType(int i) {
        return 1;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C1383a c1383a;
        C1422d a = m5282a(i);
        if (view == null) {
            C1383a c1383a2 = new C1383a();
            view = LayoutInflater.from(getContext()).inflate(2130968621, viewGroup, false);
            c1383a2.f3260a = (ImageView) view.findViewById(2131558559);
            c1383a2.f3261b = (TextView) view.findViewById(2131558557);
            c1383a2.f3262c = (TextView) view.findViewById(2131558560);
            c1383a2.f3263d = (TextView) view.findViewById(2131558561);
            c1383a2.f3264e = (TextView) view.findViewById(2131558562);
            c1383a2.f3267h = (LinearLayout) view.findViewById(2131558553);
            c1383a2.f3266g = (LinearLayout) view.findViewById(2131558552);
            c1383a2.f3268i = (LinearLayout) view.findViewById(2131558555);
            c1383a2.f3265f = (ImageView) view.findViewById(2131558556);
            view.setTag(c1383a2);
            c1383a = c1383a2;
        } else {
            c1383a = (C1383a) view.getTag();
        }
        c1383a.f3262c.setText(a.m5395c());
        c1383a.f3261b.setText(a.m5394b());
        c1383a.f3263d.setText(a.m5396d());
        c1383a.f3264e.setText(a.m5397e());
        int identifier = this.f3269a.getResources().getIdentifier(this.f3269a.getPackageName() + ":drawable/" + a.m5390a(), null, null);
        c1383a.f3260a.setImageResource(identifier);
        if (a.m5398f().booleanValue()) {
            c1383a.f3260a.setVisibility(8);
            c1383a.f3265f.setVisibility(0);
            c1383a.f3267h.setVisibility(8);
            c1383a.f3268i.setVisibility(0);
        } else {
            c1383a.f3260a.setImageResource(identifier);
            c1383a.f3260a.setVisibility(0);
            c1383a.f3265f.setVisibility(8);
            c1383a.f3267h.setVisibility(0);
            c1383a.f3268i.setVisibility(8);
        }
        return view;
    }
}
