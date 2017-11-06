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

/* compiled from: CustomAdapter */
public class C1381a extends ArrayAdapter<C1385c> {
    Context f3258a;
    private ArrayList<C1385c> f3259b;

    /* compiled from: CustomAdapter */
    private static class C1380a {
        TextView f3251a;
        TextView f3252b;
        TextView f3253c;
        ImageView f3254d;
        LinearLayout f3255e;
        LinearLayout f3256f;
        LinearLayout f3257g;

        private C1380a() {
        }
    }

    public /* synthetic */ Object getItem(int i) {
        return m5281a(i);
    }

    public C1381a(ArrayList<C1385c> arrayList, Context context) {
        super(context, 2130968620, arrayList);
        this.f3259b = arrayList;
        this.f3258a = context;
    }

    public int getCount() {
        return this.f3259b.size();
    }

    public C1385c m5281a(int i) {
        return (C1385c) this.f3259b.get(i);
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
        C1380a c1380a;
        C1385c a = m5281a(i);
        if (view == null) {
            C1380a c1380a2 = new C1380a();
            view = LayoutInflater.from(getContext()).inflate(2130968620, viewGroup, false);
            c1380a2.f3251a = (TextView) view.findViewById(2131558554);
            c1380a2.f3252b = (TextView) view.findViewById(2131558557);
            c1380a2.f3253c = (TextView) view.findViewById(2131558558);
            c1380a2.f3256f = (LinearLayout) view.findViewById(2131558553);
            c1380a2.f3255e = (LinearLayout) view.findViewById(2131558552);
            c1380a2.f3257g = (LinearLayout) view.findViewById(2131558555);
            c1380a2.f3254d = (ImageView) view.findViewById(2131558556);
            view.setTag(c1380a2);
            c1380a = c1380a2;
        } else {
            c1380a = (C1380a) view.getTag();
        }
        c1380a.f3252b.setText(a.m5287b());
        c1380a.f3253c.setText(a.m5288c());
        if (a.m5289d().booleanValue()) {
            c1380a.f3251a.setVisibility(8);
            c1380a.f3254d.setVisibility(0);
            c1380a.f3256f.setVisibility(8);
            c1380a.f3257g.setVisibility(0);
        } else {
            c1380a.f3251a.setText(a.m5283a());
            c1380a.f3251a.setVisibility(0);
            c1380a.f3254d.setVisibility(8);
            c1380a.f3256f.setVisibility(0);
            c1380a.f3257g.setVisibility(8);
        }
        return view;
    }
}
