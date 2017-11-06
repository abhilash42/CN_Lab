package android.support.v4.view;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: NestedScrollingParentHelper */
public class C0368z {
    private final ViewGroup f597a;
    private int f598b;

    public C0368z(ViewGroup viewGroup) {
        this.f597a = viewGroup;
    }

    public void m1640a(View view, View view2, int i) {
        this.f598b = i;
    }

    public int m1638a() {
        return this.f598b;
    }

    public void m1639a(View view) {
        this.f598b = 0;
    }
}
