package android.support.v7.widget;

import android.graphics.Outline;

/* compiled from: ActionBarBackgroundDrawableV21 */
class C0604c extends C0603b {
    public C0604c(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    public void getOutline(Outline outline) {
        if (this.a.f1204d) {
            if (this.a.f1203c != null) {
                this.a.f1203c.getOutline(outline);
            }
        } else if (this.a.f1201a != null) {
            this.a.f1201a.getOutline(outline);
        }
    }
}
