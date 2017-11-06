package android.support.v7.p014c.p015a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.v4.p002b.p003a.C0150a;

/* compiled from: DrawableWrapper */
public class C0510a extends Drawable implements Callback {
    private Drawable f970a;

    public C0510a(Drawable drawable) {
        m2291a(drawable);
    }

    public void draw(Canvas canvas) {
        this.f970a.draw(canvas);
    }

    protected void onBoundsChange(Rect rect) {
        this.f970a.setBounds(rect);
    }

    public void setChangingConfigurations(int i) {
        this.f970a.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        return this.f970a.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.f970a.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f970a.setFilterBitmap(z);
    }

    public void setAlpha(int i) {
        this.f970a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f970a.setColorFilter(colorFilter);
    }

    public boolean isStateful() {
        return this.f970a.isStateful();
    }

    public boolean setState(int[] iArr) {
        return this.f970a.setState(iArr);
    }

    public int[] getState() {
        return this.f970a.getState();
    }

    public void jumpToCurrentState() {
        C0150a.m655a(this.f970a);
    }

    public Drawable getCurrent() {
        return this.f970a.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f970a.setVisible(z, z2);
    }

    public int getOpacity() {
        return this.f970a.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.f970a.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.f970a.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.f970a.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.f970a.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.f970a.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.f970a.getPadding(rect);
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
        return this.f970a.setLevel(i);
    }

    public void setAutoMirrored(boolean z) {
        C0150a.m663a(this.f970a, z);
    }

    public boolean isAutoMirrored() {
        return C0150a.m664b(this.f970a);
    }

    public void setTint(int i) {
        C0150a.m657a(this.f970a, i);
    }

    public void setTintList(ColorStateList colorStateList) {
        C0150a.m659a(this.f970a, colorStateList);
    }

    public void setTintMode(Mode mode) {
        C0150a.m662a(this.f970a, mode);
    }

    public void setHotspot(float f, float f2) {
        C0150a.m656a(this.f970a, f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        C0150a.m658a(this.f970a, i, i2, i3, i4);
    }

    public Drawable m2290a() {
        return this.f970a;
    }

    public void m2291a(Drawable drawable) {
        if (this.f970a != null) {
            this.f970a.setCallback(null);
        }
        this.f970a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }
}
