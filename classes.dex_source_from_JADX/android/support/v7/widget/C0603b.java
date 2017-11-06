package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* compiled from: ActionBarBackgroundDrawable */
class C0603b extends Drawable {
    final ActionBarContainer f1588a;

    public C0603b(ActionBarContainer actionBarContainer) {
        this.f1588a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        if (!this.f1588a.f1204d) {
            if (this.f1588a.f1201a != null) {
                this.f1588a.f1201a.draw(canvas);
            }
            if (this.f1588a.f1202b != null && this.f1588a.f1205e) {
                this.f1588a.f1202b.draw(canvas);
            }
        } else if (this.f1588a.f1203c != null) {
            this.f1588a.f1203c.draw(canvas);
        }
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
