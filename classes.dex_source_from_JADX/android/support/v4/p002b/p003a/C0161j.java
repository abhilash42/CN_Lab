package android.support.v4.p002b.p003a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

/* compiled from: DrawableWrapperDonut */
class C0161j extends Drawable implements Callback, C0158i, C0004o {
    static final Mode f439a = Mode.SRC_IN;
    C0159a f440b;
    Drawable f441c;
    private int f442d;
    private Mode f443e;
    private boolean f444f;
    private boolean f445g;

    /* compiled from: DrawableWrapperDonut */
    protected static abstract class C0159a extends ConstantState {
        int f435a;
        ConstantState f436b;
        ColorStateList f437c = null;
        Mode f438d = C0161j.f439a;

        public abstract Drawable newDrawable(Resources resources);

        C0159a(C0159a c0159a, Resources resources) {
            if (c0159a != null) {
                this.f435a = c0159a.f435a;
                this.f436b = c0159a.f436b;
                this.f437c = c0159a.f437c;
                this.f438d = c0159a.f438d;
            }
        }

        public Drawable newDrawable() {
            return newDrawable(null);
        }

        public int getChangingConfigurations() {
            return (this.f436b != null ? this.f436b.getChangingConfigurations() : 0) | this.f435a;
        }

        boolean m696a() {
            return this.f436b != null;
        }
    }

    /* compiled from: DrawableWrapperDonut */
    private static class C0160b extends C0159a {
        C0160b(C0159a c0159a, Resources resources) {
            super(c0159a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0161j(this, resources);
        }
    }

    C0161j(C0159a c0159a, Resources resources) {
        this.f440b = c0159a;
        m697a(resources);
    }

    C0161j(Drawable drawable) {
        this.f440b = mo106b();
        mo104a(drawable);
    }

    private void m697a(Resources resources) {
        if (this.f440b != null && this.f440b.f436b != null) {
            mo104a(mo105a(this.f440b.f436b, resources));
        }
    }

    protected Drawable mo105a(ConstantState constantState, Resources resources) {
        return constantState.newDrawable();
    }

    public void draw(Canvas canvas) {
        this.f441c.draw(canvas);
    }

    protected void onBoundsChange(Rect rect) {
        if (this.f441c != null) {
            this.f441c.setBounds(rect);
        }
    }

    public void setChangingConfigurations(int i) {
        this.f441c.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        return ((this.f440b != null ? this.f440b.getChangingConfigurations() : 0) | super.getChangingConfigurations()) | this.f441c.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.f441c.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f441c.setFilterBitmap(z);
    }

    public void setAlpha(int i) {
        this.f441c.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f441c.setColorFilter(colorFilter);
    }

    public boolean isStateful() {
        ColorStateList colorStateList = (!mo107c() || this.f440b == null) ? null : this.f440b.f437c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f441c.isStateful();
    }

    public boolean setState(int[] iArr) {
        return m698a(iArr) || this.f441c.setState(iArr);
    }

    public int[] getState() {
        return this.f441c.getState();
    }

    public Drawable getCurrent() {
        return this.f441c.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f441c.setVisible(z, z2);
    }

    public int getOpacity() {
        return this.f441c.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.f441c.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.f441c.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.f441c.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.f441c.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.f441c.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.f441c.getPadding(rect);
    }

    public ConstantState getConstantState() {
        if (this.f440b == null || !this.f440b.m696a()) {
            return null;
        }
        this.f440b.f435a = getChangingConfigurations();
        return this.f440b;
    }

    public Drawable mutate() {
        if (!this.f445g && super.mutate() == this) {
            this.f440b = mo106b();
            if (this.f441c != null) {
                this.f441c.mutate();
            }
            if (this.f440b != null) {
                this.f440b.f436b = this.f441c != null ? this.f441c.getConstantState() : null;
            }
            this.f445g = true;
        }
        return this;
    }

    C0159a mo106b() {
        return new C0160b(this.f440b, null);
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    protected boolean onLevelChange(int i) {
        return this.f441c.setLevel(i);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f440b.f437c = colorStateList;
        m698a(getState());
    }

    public void setTintMode(Mode mode) {
        this.f440b.f438d = mode;
        m698a(getState());
    }

    private boolean m698a(int[] iArr) {
        if (!mo107c()) {
            return false;
        }
        ColorStateList colorStateList = this.f440b.f437c;
        Mode mode = this.f440b.f438d;
        if (colorStateList == null || mode == null) {
            this.f444f = false;
            clearColorFilter();
            return false;
        }
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f444f && colorForState == this.f442d && mode == this.f443e) {
            return false;
        }
        setColorFilter(colorForState, mode);
        this.f442d = colorForState;
        this.f443e = mode;
        this.f444f = true;
        return true;
    }

    public final Drawable mo103a() {
        return this.f441c;
    }

    public final void mo104a(Drawable drawable) {
        if (this.f441c != null) {
            this.f441c.setCallback(null);
        }
        this.f441c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            drawable.setVisible(isVisible(), true);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (this.f440b != null) {
                this.f440b.f436b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    protected boolean mo107c() {
        return true;
    }
}
