package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v4.p006c.p007a.C0171a;
import android.support.v4.view.C0321d;
import android.support.v4.view.C0353p;
import android.support.v7.p013b.C0509a.C0508k;
import android.support.v7.view.menu.C0541h;
import android.support.v7.view.menu.C0546i;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* compiled from: SupportMenuInflater */
public class C0521g extends MenuInflater {
    private static final Class<?>[] f1018a = new Class[]{Context.class};
    private static final Class<?>[] f1019b = f1018a;
    private final Object[] f1020c;
    private final Object[] f1021d = this.f1020c;
    private Context f1022e;
    private Object f1023f;

    /* compiled from: SupportMenuInflater */
    private static class C0519a implements OnMenuItemClickListener {
        private static final Class<?>[] f989a = new Class[]{MenuItem.class};
        private Object f990b;
        private Method f991c;

        public C0519a(Object obj, String str) {
            this.f990b = obj;
            Class cls = obj.getClass();
            try {
                this.f991c = cls.getMethod(str, f989a);
            } catch (Throwable e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f991c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f991c.invoke(this.f990b, new Object[]{menuItem})).booleanValue();
                }
                this.f991c.invoke(this.f990b, new Object[]{menuItem});
                return true;
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* compiled from: SupportMenuInflater */
    private class C0520b {
        final /* synthetic */ C0521g f992a;
        private Menu f993b;
        private int f994c;
        private int f995d;
        private int f996e;
        private int f997f;
        private boolean f998g;
        private boolean f999h;
        private boolean f1000i;
        private int f1001j;
        private int f1002k;
        private CharSequence f1003l;
        private CharSequence f1004m;
        private int f1005n;
        private char f1006o;
        private char f1007p;
        private int f1008q;
        private boolean f1009r;
        private boolean f1010s;
        private boolean f1011t;
        private int f1012u;
        private int f1013v;
        private String f1014w;
        private String f1015x;
        private String f1016y;
        private C0321d f1017z;

        public C0520b(C0521g c0521g, Menu menu) {
            this.f992a = c0521g;
            this.f993b = menu;
            m2332a();
        }

        public void m2332a() {
            this.f994c = 0;
            this.f995d = 0;
            this.f996e = 0;
            this.f997f = 0;
            this.f998g = true;
            this.f999h = true;
        }

        public void m2333a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = this.f992a.f1022e.obtainStyledAttributes(attributeSet, C0508k.MenuGroup);
            this.f994c = obtainStyledAttributes.getResourceId(C0508k.MenuGroup_android_id, 0);
            this.f995d = obtainStyledAttributes.getInt(C0508k.MenuGroup_android_menuCategory, 0);
            this.f996e = obtainStyledAttributes.getInt(C0508k.MenuGroup_android_orderInCategory, 0);
            this.f997f = obtainStyledAttributes.getInt(C0508k.MenuGroup_android_checkableBehavior, 0);
            this.f998g = obtainStyledAttributes.getBoolean(C0508k.MenuGroup_android_visible, true);
            this.f999h = obtainStyledAttributes.getBoolean(C0508k.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void m2335b(AttributeSet attributeSet) {
            boolean z = true;
            TypedArray obtainStyledAttributes = this.f992a.f1022e.obtainStyledAttributes(attributeSet, C0508k.MenuItem);
            this.f1001j = obtainStyledAttributes.getResourceId(C0508k.MenuItem_android_id, 0);
            this.f1002k = (obtainStyledAttributes.getInt(C0508k.MenuItem_android_menuCategory, this.f995d) & -65536) | (obtainStyledAttributes.getInt(C0508k.MenuItem_android_orderInCategory, this.f996e) & 65535);
            this.f1003l = obtainStyledAttributes.getText(C0508k.MenuItem_android_title);
            this.f1004m = obtainStyledAttributes.getText(C0508k.MenuItem_android_titleCondensed);
            this.f1005n = obtainStyledAttributes.getResourceId(C0508k.MenuItem_android_icon, 0);
            this.f1006o = m2328a(obtainStyledAttributes.getString(C0508k.MenuItem_android_alphabeticShortcut));
            this.f1007p = m2328a(obtainStyledAttributes.getString(C0508k.MenuItem_android_numericShortcut));
            if (obtainStyledAttributes.hasValue(C0508k.MenuItem_android_checkable)) {
                this.f1008q = obtainStyledAttributes.getBoolean(C0508k.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.f1008q = this.f997f;
            }
            this.f1009r = obtainStyledAttributes.getBoolean(C0508k.MenuItem_android_checked, false);
            this.f1010s = obtainStyledAttributes.getBoolean(C0508k.MenuItem_android_visible, this.f998g);
            this.f1011t = obtainStyledAttributes.getBoolean(C0508k.MenuItem_android_enabled, this.f999h);
            this.f1012u = obtainStyledAttributes.getInt(C0508k.MenuItem_showAsAction, -1);
            this.f1016y = obtainStyledAttributes.getString(C0508k.MenuItem_android_onClick);
            this.f1013v = obtainStyledAttributes.getResourceId(C0508k.MenuItem_actionLayout, 0);
            this.f1014w = obtainStyledAttributes.getString(C0508k.MenuItem_actionViewClass);
            this.f1015x = obtainStyledAttributes.getString(C0508k.MenuItem_actionProviderClass);
            if (this.f1015x == null) {
                z = false;
            }
            if (z && this.f1013v == 0 && this.f1014w == null) {
                this.f1017z = (C0321d) m2330a(this.f1015x, C0521g.f1019b, this.f992a.f1021d);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f1017z = null;
            }
            obtainStyledAttributes.recycle();
            this.f1000i = false;
        }

        private char m2328a(String str) {
            if (str == null) {
                return '\u0000';
            }
            return str.charAt(0);
        }

        private void m2331a(MenuItem menuItem) {
            boolean z = true;
            menuItem.setChecked(this.f1009r).setVisible(this.f1010s).setEnabled(this.f1011t).setCheckable(this.f1008q >= 1).setTitleCondensed(this.f1004m).setIcon(this.f1005n).setAlphabeticShortcut(this.f1006o).setNumericShortcut(this.f1007p);
            if (this.f1012u >= 0) {
                C0353p.m1587a(menuItem, this.f1012u);
            }
            if (this.f1016y != null) {
                if (this.f992a.f1022e.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new C0519a(this.f992a.m2344c(), this.f1016y));
            }
            if (menuItem instanceof C0541h) {
                C0541h c0541h = (C0541h) menuItem;
            }
            if (this.f1008q >= 2) {
                if (menuItem instanceof C0541h) {
                    ((C0541h) menuItem).m2514a(true);
                } else if (menuItem instanceof C0546i) {
                    ((C0546i) menuItem).m2543a(true);
                }
            }
            if (this.f1014w != null) {
                C0353p.m1585a(menuItem, (View) m2330a(this.f1014w, C0521g.f1018a, this.f992a.f1020c));
            } else {
                z = false;
            }
            if (this.f1013v > 0) {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    C0353p.m1588b(menuItem, this.f1013v);
                }
            }
            if (this.f1017z != null) {
                C0353p.m1584a(menuItem, this.f1017z);
            }
        }

        public void m2334b() {
            this.f1000i = true;
            m2331a(this.f993b.add(this.f994c, this.f1001j, this.f1002k, this.f1003l));
        }

        public SubMenu m2336c() {
            this.f1000i = true;
            SubMenu addSubMenu = this.f993b.addSubMenu(this.f994c, this.f1001j, this.f1002k, this.f1003l);
            m2331a(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean m2337d() {
            return this.f1000i;
        }

        private <T> T m2330a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor constructor = this.f992a.f1022e.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Throwable e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }
    }

    public C0521g(Context context) {
        super(context);
        this.f1022e = context;
        this.f1020c = new Object[]{context};
    }

    public void inflate(int i, Menu menu) {
        if (menu instanceof C0171a) {
            XmlResourceParser xmlResourceParser = null;
            try {
                xmlResourceParser = this.f1022e.getResources().getLayout(i);
                m2340a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            } catch (Throwable e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (Throwable e2) {
                throw new InflateException("Error inflating menu XML", e2);
            } catch (Throwable th) {
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            }
        } else {
            super.inflate(i, menu);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2340a(org.xmlpull.v1.XmlPullParser r11, android.util.AttributeSet r12, android.view.Menu r13) {
        /*
        r10 = this;
        r4 = 0;
        r1 = 1;
        r6 = 0;
        r7 = new android.support.v7.view.g$b;
        r7.<init>(r10, r13);
        r0 = r11.getEventType();
    L_0x000c:
        r2 = 2;
        if (r0 != r2) goto L_0x004a;
    L_0x000f:
        r0 = r11.getName();
        r2 = "menu";
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x0031;
    L_0x001b:
        r0 = r11.next();
    L_0x001f:
        r2 = r4;
        r5 = r6;
        r3 = r0;
        r0 = r6;
    L_0x0023:
        if (r0 != 0) goto L_0x00e1;
    L_0x0025:
        switch(r3) {
            case 1: goto L_0x00d9;
            case 2: goto L_0x0051;
            case 3: goto L_0x0087;
            default: goto L_0x0028;
        };
    L_0x0028:
        r3 = r5;
    L_0x0029:
        r5 = r11.next();
        r9 = r3;
        r3 = r5;
        r5 = r9;
        goto L_0x0023;
    L_0x0031:
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Expecting menu, got ";
        r2 = r2.append(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x004a:
        r0 = r11.next();
        if (r0 != r1) goto L_0x000c;
    L_0x0050:
        goto L_0x001f;
    L_0x0051:
        if (r5 == 0) goto L_0x0055;
    L_0x0053:
        r3 = r5;
        goto L_0x0029;
    L_0x0055:
        r3 = r11.getName();
        r8 = "group";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x0066;
    L_0x0061:
        r7.m2333a(r12);
        r3 = r5;
        goto L_0x0029;
    L_0x0066:
        r8 = "item";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x0073;
    L_0x006e:
        r7.m2335b(r12);
        r3 = r5;
        goto L_0x0029;
    L_0x0073:
        r8 = "menu";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x0084;
    L_0x007b:
        r3 = r7.m2336c();
        r10.m2340a(r11, r12, r3);
        r3 = r5;
        goto L_0x0029;
    L_0x0084:
        r2 = r3;
        r3 = r1;
        goto L_0x0029;
    L_0x0087:
        r3 = r11.getName();
        if (r5 == 0) goto L_0x0096;
    L_0x008d:
        r8 = r3.equals(r2);
        if (r8 == 0) goto L_0x0096;
    L_0x0093:
        r2 = r4;
        r3 = r6;
        goto L_0x0029;
    L_0x0096:
        r8 = "group";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x00a3;
    L_0x009e:
        r7.m2332a();
        r3 = r5;
        goto L_0x0029;
    L_0x00a3:
        r8 = "item";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x00cd;
    L_0x00ab:
        r3 = r7.m2337d();
        if (r3 != 0) goto L_0x0028;
    L_0x00b1:
        r3 = r7.f1017z;
        if (r3 == 0) goto L_0x00c7;
    L_0x00b7:
        r3 = r7.f1017z;
        r3 = r3.mo481e();
        if (r3 == 0) goto L_0x00c7;
    L_0x00c1:
        r7.m2336c();
        r3 = r5;
        goto L_0x0029;
    L_0x00c7:
        r7.m2334b();
        r3 = r5;
        goto L_0x0029;
    L_0x00cd:
        r8 = "menu";
        r3 = r3.equals(r8);
        if (r3 == 0) goto L_0x0028;
    L_0x00d5:
        r0 = r1;
        r3 = r5;
        goto L_0x0029;
    L_0x00d9:
        r0 = new java.lang.RuntimeException;
        r1 = "Unexpected end of document";
        r0.<init>(r1);
        throw r0;
    L_0x00e1:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.view.g.a(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    private Object m2344c() {
        if (this.f1023f == null) {
            this.f1023f = m2339a(this.f1022e);
        }
        return this.f1023f;
    }

    private Object m2339a(Object obj) {
        if (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) {
            return m2339a(((ContextWrapper) obj).getBaseContext());
        }
        return obj;
    }
}
