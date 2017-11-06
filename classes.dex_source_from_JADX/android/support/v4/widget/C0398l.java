package android.support.v4.widget;

import android.os.Build.VERSION;
import android.widget.ListView;

/* compiled from: ListViewCompat */
public final class C0398l {
    public static void m1805a(ListView listView, int i) {
        if (VERSION.SDK_INT >= 19) {
            C0400n.m1807a(listView, i);
        } else {
            C0399m.m1806a(listView, i);
        }
    }
}
