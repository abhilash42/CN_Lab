package android.support.v7.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.support.v4.p002b.p003a.C0158i;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import io.fabric.sdk.android.services.p020b.C0671a;

/* compiled from: AppCompatProgressBarHelper */
class C0639s {
    private static final int[] f1697b = new int[]{16843067, 16843068};
    final C0632l f1698a;
    private final ProgressBar f1699c;
    private Bitmap f1700d;

    C0639s(ProgressBar progressBar, C0632l c0632l) {
        this.f1699c = progressBar;
        this.f1698a = c0632l;
    }

    void mo584a(AttributeSet attributeSet, int i) {
        ar a = ar.m2940a(this.f1699c.getContext(), attributeSet, f1697b, i, 0);
        Drawable b = a.m2947b(0);
        if (b != null) {
            this.f1699c.setIndeterminateDrawable(m3141a(b));
        }
        b = a.m2947b(1);
        if (b != null) {
            this.f1699c.setProgressDrawable(m3142a(b, false));
        }
        a.m2944a();
    }

    private Drawable m3142a(Drawable drawable, boolean z) {
        int i = 0;
        Drawable a;
        if (drawable instanceof C0158i) {
            a = ((C0158i) drawable).mo103a();
            if (a != null) {
                ((C0158i) drawable).mo104a(m3142a(a, z));
            }
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                boolean z2;
                int id = layerDrawable.getId(i2);
                Drawable drawable2 = layerDrawable.getDrawable(i2);
                if (id == 16908301 || id == 16908303) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                drawableArr[i2] = m3142a(drawable2, z2);
            }
            a = new LayerDrawable(drawableArr);
            while (i < numberOfLayers) {
                a.setId(i, layerDrawable.getId(i));
                i++;
            }
            return a;
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.f1700d == null) {
                this.f1700d = bitmap;
            }
            Drawable shapeDrawable = new ShapeDrawable(m3143b());
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, TileMode.REPEAT, TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
        }
        return drawable;
    }

    private Drawable m3141a(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        Drawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int i = 0; i < numberOfFrames; i++) {
            Drawable a = m3142a(animationDrawable.getFrame(i), true);
            a.setLevel(C0671a.DEFAULT_TIMEOUT);
            animationDrawable2.addFrame(a, animationDrawable.getDuration(i));
        }
        animationDrawable2.setLevel(C0671a.DEFAULT_TIMEOUT);
        return animationDrawable2;
    }

    private Shape m3143b() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    Bitmap m3144a() {
        return this.f1700d;
    }
}
