package android.support.v4.widget;

import android.widget.ListView;

/* compiled from: ListViewAutoScrollHelper */
public class C0397k extends C0375a {
    private final ListView f674a;

    public C0397k(ListView listView) {
        super(listView);
        this.f674a = listView;
    }

    public void mo320a(int i, int i2) {
        C0398l.m1805a(this.f674a, i2);
    }

    public boolean mo321e(int i) {
        return false;
    }

    public boolean mo322f(int i) {
        ListView listView = this.f674a;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i2 = firstVisiblePosition + childCount;
        if (i > 0) {
            if (i2 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else if (i >= 0) {
            return false;
        } else {
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }
}
