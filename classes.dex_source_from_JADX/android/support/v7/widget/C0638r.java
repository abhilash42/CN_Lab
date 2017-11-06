package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.widget.C0407o;
import android.support.v7.p013b.C0509a.C0508k;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* compiled from: AppCompatPopupWindow */
public class C0638r extends PopupWindow {
    private static final boolean f1695a = (VERSION.SDK_INT < 21);
    private boolean f1696b;

    public C0638r(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ar a = ar.m2940a(context, attributeSet, C0508k.PopupWindow, i, 0);
        if (a.m2955f(C0508k.PopupWindow_overlapAnchor)) {
            m3140a(a.m2945a(C0508k.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(a.m2943a(C0508k.PopupWindow_android_popupBackground));
        a.m2944a();
        if (VERSION.SDK_INT < 14) {
            C0638r.m3139a((PopupWindow) this);
        }
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (f1695a && this.f1696b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @TargetApi(19)
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f1695a && this.f1696b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        int height;
        if (f1695a && this.f1696b) {
            height = i2 - view.getHeight();
        } else {
            height = i2;
        }
        super.update(view, i, height, i3, i4);
    }

    private static void m3139a(final PopupWindow popupWindow) {
        try {
            final Field declaredField = PopupWindow.class.getDeclaredField("mAnchor");
            declaredField.setAccessible(true);
            Field declaredField2 = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
            declaredField2.setAccessible(true);
            final OnScrollChangedListener onScrollChangedListener = (OnScrollChangedListener) declaredField2.get(popupWindow);
            declaredField2.set(popupWindow, new OnScrollChangedListener() {
                public void onScrollChanged() {
                    try {
                        WeakReference weakReference = (WeakReference) declaredField.get(popupWindow);
                        if (weakReference != null && weakReference.get() != null) {
                            onScrollChangedListener.onScrollChanged();
                        }
                    } catch (IllegalAccessException e) {
                    }
                }
            });
        } catch (Throwable e) {
            Log.d("AppCompatPopupWindow", "Exception while installing workaround OnScrollChangedListener", e);
        }
    }

    public void m3140a(boolean z) {
        if (f1695a) {
            this.f1696b = z;
        } else {
            C0407o.m1821a((PopupWindow) this, z);
        }
    }
}
