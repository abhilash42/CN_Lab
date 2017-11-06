package android.support.v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.View;

/* compiled from: LayoutInflaterCompatBase */
class C0339j {

    /* compiled from: LayoutInflaterCompatBase */
    static class C0338a implements Factory {
        final C0124m f587a;

        C0338a(C0124m c0124m) {
            this.f587a = c0124m;
        }

        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.f587a.mo78a(null, str, context, attributeSet);
        }

        public String toString() {
            return getClass().getName() + "{" + this.f587a + "}";
        }
    }

    static void m1548a(LayoutInflater layoutInflater, C0124m c0124m) {
        layoutInflater.setFactory(c0124m != null ? new C0338a(c0124m) : null);
    }

    static C0124m m1547a(LayoutInflater layoutInflater) {
        Factory factory = layoutInflater.getFactory();
        if (factory instanceof C0338a) {
            return ((C0338a) factory).f587a;
        }
        return null;
    }
}
