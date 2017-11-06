package android.support.v4.view;

import android.content.Context;
import android.support.v4.view.C0339j.C0338a;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import java.lang.reflect.Field;

/* compiled from: LayoutInflaterCompatHC */
class C0341k {
    private static Field f588a;
    private static boolean f589b;

    /* compiled from: LayoutInflaterCompatHC */
    static class C0340a extends C0338a implements Factory2 {
        C0340a(C0124m c0124m) {
            super(c0124m);
        }

        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.a.mo78a(view, str, context, attributeSet);
        }
    }

    static void m1549a(LayoutInflater layoutInflater, C0124m c0124m) {
        Factory2 c0340a;
        if (c0124m != null) {
            c0340a = new C0340a(c0124m);
        } else {
            c0340a = null;
        }
        layoutInflater.setFactory2(c0340a);
        Factory factory = layoutInflater.getFactory();
        if (factory instanceof Factory2) {
            C0341k.m1550a(layoutInflater, (Factory2) factory);
        } else {
            C0341k.m1550a(layoutInflater, c0340a);
        }
    }

    static void m1550a(LayoutInflater layoutInflater, Factory2 factory2) {
        if (!f589b) {
            try {
                f588a = LayoutInflater.class.getDeclaredField("mFactory2");
                f588a.setAccessible(true);
            } catch (Throwable e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            f589b = true;
        }
        if (f588a != null) {
            try {
                f588a.set(layoutInflater, factory2);
            } catch (Throwable e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }
}
