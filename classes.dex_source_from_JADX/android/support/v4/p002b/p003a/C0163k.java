package android.support.v4.p002b.p003a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v4.p002b.p003a.C0161j.C0159a;

/* compiled from: DrawableWrapperEclair */
class C0163k extends C0161j {

    /* compiled from: DrawableWrapperEclair */
    private static class C0162a extends C0159a {
        C0162a(C0159a c0159a, Resources resources) {
            super(c0159a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0163k(this, resources);
        }
    }

    C0163k(Drawable drawable) {
        super(drawable);
    }

    C0163k(C0159a c0159a, Resources resources) {
        super(c0159a, resources);
    }

    C0159a mo106b() {
        return new C0162a(this.b, null);
    }

    protected Drawable mo105a(ConstantState constantState, Resources resources) {
        return constantState.newDrawable(resources);
    }
}
