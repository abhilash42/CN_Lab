package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.ae.C0466a;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class FitWindowsLinearLayout extends LinearLayout implements ae {
    private C0466a f1327a;

    public FitWindowsLinearLayout(Context context) {
        super(context);
    }

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnFitSystemWindowsListener(C0466a c0466a) {
        this.f1327a = c0466a;
    }

    protected boolean fitSystemWindows(Rect rect) {
        if (this.f1327a != null) {
            this.f1327a.mo398a(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
