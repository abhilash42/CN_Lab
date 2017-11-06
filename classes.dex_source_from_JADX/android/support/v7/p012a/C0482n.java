package android.support.v7.p012a;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.p009e.C0189a;
import android.support.v4.view.ag;
import android.support.v7.p013b.C0509a.C0508k;
import android.support.v7.view.C0515d;
import android.support.v7.widget.C0570f;
import android.support.v7.widget.C0610p;
import android.support.v7.widget.C0623h;
import android.support.v7.widget.C0624i;
import android.support.v7.widget.C0625j;
import android.support.v7.widget.C0633m;
import android.support.v7.widget.C0634n;
import android.support.v7.widget.C0636q;
import android.support.v7.widget.C0640t;
import android.support.v7.widget.C0641u;
import android.support.v7.widget.C0642v;
import android.support.v7.widget.C0650x;
import android.support.v7.widget.aa;
import android.support.v7.widget.ao;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

/* compiled from: AppCompatViewInflater */
class C0482n {
    private static final Class<?>[] f897a = new Class[]{Context.class, AttributeSet.class};
    private static final int[] f898b = new int[]{16843375};
    private static final String[] f899c = new String[]{"android.widget.", "android.view.", "android.webkit."};
    private static final Map<String, Constructor<? extends View>> f900d = new C0189a();
    private final Object[] f901e = new Object[2];

    /* compiled from: AppCompatViewInflater */
    private static class C0481a implements OnClickListener {
        private final View f893a;
        private final String f894b;
        private Method f895c;
        private Context f896d;

        public C0481a(View view, String str) {
            this.f893a = view;
            this.f894b = str;
        }

        public void onClick(View view) {
            if (this.f895c == null) {
                m2164a(this.f893a.getContext(), this.f894b);
            }
            try {
                this.f895c.invoke(this.f896d, new Object[]{view});
            } catch (Throwable e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (Throwable e2) {
                throw new IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }

        private void m2164a(Context context, String str) {
            Context context2 = context;
            while (context2 != null) {
                try {
                    if (!context2.isRestricted()) {
                        Method method = context2.getClass().getMethod(this.f894b, new Class[]{View.class});
                        if (method != null) {
                            this.f895c = method;
                            this.f896d = context2;
                            return;
                        }
                    }
                } catch (NoSuchMethodException e) {
                }
                if (context2 instanceof ContextWrapper) {
                    context2 = ((ContextWrapper) context2).getBaseContext();
                } else {
                    context2 = null;
                }
            }
            int id = this.f893a.getId();
            throw new IllegalStateException("Could not find method " + this.f894b + "(View) in a parent or ancestor Context for android:onClick " + "attribute defined on view " + this.f893a.getClass() + (id == -1 ? "" : " with id '" + this.f893a.getContext().getResources().getResourceEntryName(id) + "'"));
        }
    }

    C0482n() {
    }

    public final View m2169a(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        Context context2;
        View view2;
        if (!z || view == null) {
            context2 = context;
        } else {
            context2 = view.getContext();
        }
        if (z2 || z3) {
            context2 = C0482n.m2165a(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = ao.m2936a(context2);
        }
        View view3 = null;
        Object obj = -1;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    obj = 11;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    obj = 8;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    obj = 10;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    obj = null;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    obj = 5;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    obj = 12;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    obj = 4;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    obj = 7;
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    obj = 1;
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    obj = 9;
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    obj = 6;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    obj = 3;
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                view3 = new aa(context2, attributeSet);
                break;
            case 1:
                view3 = new C0610p(context2, attributeSet);
                break;
            case 2:
                view3 = new C0623h(context2, attributeSet);
                break;
            case 3:
                view3 = new C0633m(context2, attributeSet);
                break;
            case 4:
                view3 = new C0650x(context2, attributeSet);
                break;
            case 5:
                view3 = new C0634n(context2, attributeSet);
                break;
            case 6:
                view3 = new C0624i(context2, attributeSet);
                break;
            case 7:
                view3 = new C0640t(context2, attributeSet);
                break;
            case 8:
                view3 = new C0625j(context2, attributeSet);
                break;
            case 9:
                view3 = new C0570f(context2, attributeSet);
                break;
            case 10:
                view3 = new C0636q(context2, attributeSet);
                break;
            case 11:
                view3 = new C0641u(context2, attributeSet);
                break;
            case 12:
                view3 = new C0642v(context2, attributeSet);
                break;
        }
        if (view3 != null || context == context2) {
            view2 = view3;
        } else {
            view2 = m2166a(context2, str, attributeSet);
        }
        if (view2 != null) {
            m2168a(view2, attributeSet);
        }
        return view2;
    }

    private View m2166a(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.f901e[0] = context;
            this.f901e[1] = attributeSet;
            View a;
            if (-1 == str.indexOf(46)) {
                for (String a2 : f899c) {
                    a = m2167a(context, str, a2);
                    if (a != null) {
                        return a;
                    }
                }
                this.f901e[0] = null;
                this.f901e[1] = null;
                return null;
            }
            a = m2167a(context, str, null);
            this.f901e[0] = null;
            this.f901e[1] = null;
            return a;
        } catch (Exception e) {
            return null;
        } finally {
            this.f901e[0] = null;
            this.f901e[1] = null;
        }
    }

    private void m2168a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (!(context instanceof ContextWrapper)) {
            return;
        }
        if (VERSION.SDK_INT < 15 || ag.m1301w(view)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f898b);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new C0481a(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    private View m2167a(Context context, String str, String str2) {
        Constructor constructor = (Constructor) f900d.get(str);
        if (constructor == null) {
            try {
                constructor = context.getClassLoader().loadClass(str2 != null ? str2 + str : str).asSubclass(View.class).getConstructor(f897a);
                f900d.put(str, constructor);
            } catch (Exception e) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f901e);
    }

    private static Context m2165a(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        int resourceId;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0508k.View, 0, 0);
        if (z) {
            resourceId = obtainStyledAttributes.getResourceId(C0508k.View_android_theme, 0);
        } else {
            resourceId = 0;
        }
        if (z2 && r0 == 0) {
            resourceId = obtainStyledAttributes.getResourceId(C0508k.View_theme, 0);
            if (resourceId != 0) {
                Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
            }
        }
        int i = resourceId;
        obtainStyledAttributes.recycle();
        if (i == 0) {
            return context;
        }
        if ((context instanceof C0515d) && ((C0515d) context).m2304a() == i) {
            return context;
        }
        return new C0515d(context, i);
    }
}
