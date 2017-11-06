package android.support.v4.widget;

import android.util.Log;
import android.widget.TextView;
import java.lang.reflect.Field;

/* compiled from: TextViewCompatDonut */
class C0428z {
    private static Field f685a;
    private static boolean f686b;
    private static Field f687c;
    private static boolean f688d;

    static int m1900a(TextView textView) {
        if (!f688d) {
            f687c = C0428z.m1902a("mMaxMode");
            f688d = true;
        }
        if (f687c != null && C0428z.m1901a(f687c, textView) == 1) {
            if (!f686b) {
                f685a = C0428z.m1902a("mMaximum");
                f686b = true;
            }
            if (f685a != null) {
                return C0428z.m1901a(f685a, textView);
            }
        }
        return -1;
    }

    private static Field m1902a(String str) {
        Field field = null;
        try {
            field = TextView.class.getDeclaredField(str);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException e) {
            Log.e("TextViewCompatDonut", "Could not retrieve " + str + " field.");
            return field;
        }
    }

    private static int m1901a(Field field, TextView textView) {
        try {
            return field.getInt(textView);
        } catch (IllegalAccessException e) {
            Log.d("TextViewCompatDonut", "Could not retrieve value of " + field.getName() + " field.");
            return -1;
        }
    }

    static void m1903a(TextView textView, int i) {
        textView.setTextAppearance(textView.getContext(), i);
    }
}
