package android.support.v4.p002b.p003a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.p002b.p003a.C0161j.C0159a;

/* compiled from: DrawableWrapperHoneycomb */
class C0165l extends C0161j {

    /* compiled from: DrawableWrapperHoneycomb */
    private static class C0164a extends C0159a {
        C0164a(C0159a c0159a, Resources resources) {
            super(c0159a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0165l(this, resources);
        }
    }

    C0165l(Drawable drawable) {
        super(drawable);
    }

    C0165l(C0159a c0159a, Resources resources) {
        super(c0159a, resources);
    }

    public void jumpToCurrentState() {
        this.c.jumpToCurrentState();
    }

    C0159a mo106b() {
        return new C0164a(this.b, null);
    }
}
