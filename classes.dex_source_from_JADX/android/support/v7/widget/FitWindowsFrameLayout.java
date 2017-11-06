package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.ae.C0466a;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class FitWindowsFrameLayout extends FrameLayout implements ae {
    private C0466a f1326a;

    public FitWindowsFrameLayout(Context context) {
        super(context);
    }

    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnFitSystemWindowsListener(C0466a c0466a) {
        this.f1326a = c0466a;
    }

    protected boolean fitSystemWindows(Rect rect) {
        if (this.f1326a != null) {
            this.f1326a.mo398a(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
