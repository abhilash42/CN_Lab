package android.support.v4.widget;

import android.view.View;
import android.widget.ListView;

/* compiled from: ListViewCompatDonut */
class C0399m {
    static void m1806a(ListView listView, int i) {
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (firstVisiblePosition != -1) {
            View childAt = listView.getChildAt(0);
            if (childAt != null) {
                listView.setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i);
            }
        }
    }
}
