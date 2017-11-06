package android.support.v4.p002b.p003a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.p002b.p003a.C0161j.C0159a;

/* compiled from: DrawableWrapperKitKat */
class C0167m extends C0165l {

    /* compiled from: DrawableWrapperKitKat */
    private static class C0166a extends C0159a {
        C0166a(C0159a c0159a, Resources resources) {
            super(c0159a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0167m(this, resources);
        }
    }

    C0167m(Drawable drawable) {
        super(drawable);
    }

    C0167m(C0159a c0159a, Resources resources) {
        super(c0159a, resources);
    }

    public void setAutoMirrored(boolean z) {
        this.c.setAutoMirrored(z);
    }

    public boolean isAutoMirrored() {
        return this.c.isAutoMirrored();
    }

    C0159a mo106b() {
        return new C0166a(this.b, null);
    }
}
