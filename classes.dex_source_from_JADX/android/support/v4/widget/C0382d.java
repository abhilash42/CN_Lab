package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* compiled from: CompoundButtonCompatDonut */
class C0382d {
    private static Field f658a;
    private static boolean f659b;

    static void m1739a(CompoundButton compoundButton, ColorStateList colorStateList) {
        if (compoundButton instanceof ab) {
            ((ab) compoundButton).setSupportButtonTintList(colorStateList);
        }
    }

    static void m1740a(CompoundButton compoundButton, Mode mode) {
        if (compoundButton instanceof ab) {
            ((ab) compoundButton).setSupportButtonTintMode(mode);
        }
    }

    static Drawable m1738a(CompoundButton compoundButton) {
        if (!f659b) {
            try {
                f658a = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f658a.setAccessible(true);
            } catch (Throwable e) {
                Log.i("CompoundButtonCompatDonut", "Failed to retrieve mButtonDrawable field", e);
            }
            f659b = true;
        }
        if (f658a != null) {
            try {
                return (Drawable) f658a.get(compoundButton);
            } catch (Throwable e2) {
                Log.i("CompoundButtonCompatDonut", "Failed to get button drawable via reflection", e2);
                f658a = null;
            }
        }
        return null;
    }
}
