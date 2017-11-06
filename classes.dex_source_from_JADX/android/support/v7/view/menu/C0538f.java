package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.p004a.C0023a;
import android.support.v4.p006c.p007a.C0171a;
import android.support.v4.view.C0321d;
import android.support.v4.view.C0353p;
import android.support.v7.p013b.C0509a.C0499b;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MenuBuilder */
public class C0538f implements C0171a {
    private static final int[] f1114d = new int[]{1, 4, 5, 3, 2, 0};
    CharSequence f1115a;
    Drawable f1116b;
    View f1117c;
    private final Context f1118e;
    private final Resources f1119f;
    private boolean f1120g;
    private boolean f1121h;
    private C0457a f1122i;
    private ArrayList<C0541h> f1123j;
    private ArrayList<C0541h> f1124k;
    private boolean f1125l;
    private ArrayList<C0541h> f1126m;
    private ArrayList<C0541h> f1127n;
    private boolean f1128o;
    private int f1129p = 0;
    private ContextMenuInfo f1130q;
    private boolean f1131r = false;
    private boolean f1132s = false;
    private boolean f1133t = false;
    private boolean f1134u = false;
    private ArrayList<C0541h> f1135v = new ArrayList();
    private CopyOnWriteArrayList<WeakReference<C0532l>> f1136w = new CopyOnWriteArrayList();
    private C0541h f1137x;
    private boolean f1138y;

    /* compiled from: MenuBuilder */
    public interface C0457a {
        void mo375a(C0538f c0538f);

        boolean mo379a(C0538f c0538f, MenuItem menuItem);
    }

    /* compiled from: MenuBuilder */
    public interface C0529b {
        boolean mo458a(C0541h c0541h);
    }

    public C0538f(Context context) {
        this.f1118e = context;
        this.f1119f = context.getResources();
        this.f1123j = new ArrayList();
        this.f1124k = new ArrayList();
        this.f1125l = true;
        this.f1126m = new ArrayList();
        this.f1127n = new ArrayList();
        this.f1128o = true;
        m2454e(true);
    }

    public C0538f m2456a(int i) {
        this.f1129p = i;
        return this;
    }

    public void m2466a(C0532l c0532l) {
        m2467a(c0532l, this.f1118e);
    }

    public void m2467a(C0532l c0532l, Context context) {
        this.f1136w.add(new WeakReference(c0532l));
        c0532l.mo470a(context, this);
        this.f1128o = true;
    }

    public void m2477b(C0532l c0532l) {
        Iterator it = this.f1136w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            C0532l c0532l2 = (C0532l) weakReference.get();
            if (c0532l2 == null || c0532l2 == c0532l) {
                this.f1136w.remove(weakReference);
            }
        }
    }

    private void m2453d(boolean z) {
        if (!this.f1136w.isEmpty()) {
            m2488g();
            Iterator it = this.f1136w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0532l c0532l = (C0532l) weakReference.get();
                if (c0532l == null) {
                    this.f1136w.remove(weakReference);
                } else {
                    c0532l.mo474b(z);
                }
            }
            m2489h();
        }
    }

    private boolean m2451a(C0553p c0553p, C0532l c0532l) {
        boolean z = false;
        if (this.f1136w.isEmpty()) {
            return false;
        }
        if (c0532l != null) {
            z = c0532l.mo473a(c0553p);
        }
        Iterator it = this.f1136w.iterator();
        boolean z2 = z;
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            C0532l c0532l2 = (C0532l) weakReference.get();
            if (c0532l2 == null) {
                this.f1136w.remove(weakReference);
                z = z2;
            } else if (z2) {
                z = z2;
            } else {
                z = c0532l2.mo473a(c0553p);
            }
            z2 = z;
        }
        return z2;
    }

    public void m2463a(Bundle bundle) {
        int size = size();
        int i = 0;
        SparseArray sparseArray = null;
        while (i < size) {
            MenuItem item = getItem(i);
            View a = C0353p.m1586a(item);
            if (!(a == null || a.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                a.saveHierarchyState(sparseArray);
                if (C0353p.m1590c(item)) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            SparseArray sparseArray2 = sparseArray;
            if (item.hasSubMenu()) {
                ((C0553p) item.getSubMenu()).m2463a(bundle);
            }
            i++;
            sparseArray = sparseArray2;
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(mo491a(), sparseArray);
        }
    }

    public void m2475b(Bundle bundle) {
        if (bundle != null) {
            MenuItem item;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(mo491a());
            int size = size();
            for (int i = 0; i < size; i++) {
                item = getItem(i);
                View a = C0353p.m1586a(item);
                if (!(a == null || a.getId() == -1)) {
                    a.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((C0553p) item.getSubMenu()).m2475b(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0) {
                item = findItem(i2);
                if (item != null) {
                    C0353p.m1589b(item);
                }
            }
        }
    }

    protected String mo491a() {
        return "android:menu:actionviewstates";
    }

    public void mo492a(C0457a c0457a) {
        this.f1122i = c0457a;
    }

    protected MenuItem m2461a(int i, int i2, int i3, CharSequence charSequence) {
        int d = C0538f.m2452d(i3);
        MenuItem a = m2448a(i, i2, i3, d, charSequence, this.f1129p);
        if (this.f1130q != null) {
            a.m2513a(this.f1130q);
        }
        this.f1123j.add(C0538f.m2447a(this.f1123j, d), a);
        m2478b(true);
        return a;
    }

    private C0541h m2448a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new C0541h(this, i, i2, i3, i4, charSequence, i5);
    }

    public MenuItem add(CharSequence charSequence) {
        return m2461a(0, 0, 0, charSequence);
    }

    public MenuItem add(int i) {
        return m2461a(0, 0, 0, this.f1119f.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m2461a(i, i2, i3, charSequence);
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return m2461a(i, i2, i3, this.f1119f.getString(i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f1119f.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        C0541h c0541h = (C0541h) m2461a(i, i2, i3, charSequence);
        C0553p c0553p = new C0553p(this.f1118e, this, c0541h);
        c0541h.m2512a(c0553p);
        return c0553p;
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f1119f.getString(i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.f1118e.getPackageManager();
        List queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            Intent intent2;
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivityOptions.get(i5);
            if (resolveInfo.specificIndex < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[resolveInfo.specificIndex];
            }
            Intent intent3 = new Intent(intent2);
            intent3.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent4 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent3);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent4;
            }
        }
        return size;
    }

    public void removeItem(int i) {
        m2450a(m2474b(i), true);
    }

    public void removeGroup(int i) {
        int c = m2480c(i);
        if (c >= 0) {
            int size = this.f1123j.size() - c;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || ((C0541h) this.f1123j.get(c)).getGroupId() != i) {
                    m2478b(true);
                } else {
                    m2450a(c, false);
                    i2 = i3;
                }
            }
            m2478b(true);
        }
    }

    private void m2450a(int i, boolean z) {
        if (i >= 0 && i < this.f1123j.size()) {
            this.f1123j.remove(i);
            if (z) {
                m2478b(true);
            }
        }
    }

    public void clear() {
        if (this.f1137x != null) {
            mo497d(this.f1137x);
        }
        this.f1123j.clear();
        m2478b(true);
    }

    void m2468a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f1123j.size();
        for (int i = 0; i < size; i++) {
            MenuItem menuItem2 = (C0541h) this.f1123j.get(i);
            if (menuItem2.getGroupId() == groupId && menuItem2.m2525g() && menuItem2.isCheckable()) {
                menuItem2.m2516b(menuItem2 == menuItem);
            }
        }
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f1123j.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0541h c0541h = (C0541h) this.f1123j.get(i2);
            if (c0541h.getGroupId() == i) {
                c0541h.m2514a(z2);
                c0541h.setCheckable(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.f1123j.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            boolean z3;
            C0541h c0541h = (C0541h) this.f1123j.get(i2);
            if (c0541h.getGroupId() == i && c0541h.m2519c(z)) {
                z3 = true;
            } else {
                z3 = z2;
            }
            i2++;
            z2 = z3;
        }
        if (z2) {
            m2478b(true);
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.f1123j.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0541h c0541h = (C0541h) this.f1123j.get(i2);
            if (c0541h.getGroupId() == i) {
                c0541h.setEnabled(z);
            }
        }
    }

    public boolean hasVisibleItems() {
        if (this.f1138y) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((C0541h) this.f1123j.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public MenuItem findItem(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            C0541h c0541h = (C0541h) this.f1123j.get(i2);
            if (c0541h.getItemId() == i) {
                return c0541h;
            }
            if (c0541h.hasSubMenu()) {
                MenuItem findItem = c0541h.getSubMenu().findItem(i);
                if (findItem != null) {
                    return findItem;
                }
            }
        }
        return null;
    }

    public int m2474b(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((C0541h) this.f1123j.get(i2)).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public int m2480c(int i) {
        return m2455a(i, 0);
    }

    public int m2455a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        for (int i3 = i2; i3 < size; i3++) {
            if (((C0541h) this.f1123j.get(i3)).getGroupId() == i) {
                return i3;
            }
        }
        return -1;
    }

    public int size() {
        return this.f1123j.size();
    }

    public MenuItem getItem(int i) {
        return (MenuItem) this.f1123j.get(i);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return m2460a(i, keyEvent) != null;
    }

    public void setQwertyMode(boolean z) {
        this.f1120g = z;
        m2478b(false);
    }

    private static int m2452d(int i) {
        int i2 = (-65536 & i) >> 16;
        if (i2 >= 0 && i2 < f1114d.length) {
            return (f1114d[i2] << 16) | (65535 & i);
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    boolean mo494b() {
        return this.f1120g;
    }

    private void m2454e(boolean z) {
        boolean z2 = true;
        if (!(z && this.f1119f.getConfiguration().keyboard != 1 && this.f1119f.getBoolean(C0499b.abc_config_showMenuShortcutsWhenKeyboardPresent))) {
            z2 = false;
        }
        this.f1121h = z2;
    }

    public boolean mo495c() {
        return this.f1121h;
    }

    Resources m2484d() {
        return this.f1119f;
    }

    public Context m2486e() {
        return this.f1118e;
    }

    boolean mo493a(C0538f c0538f, MenuItem menuItem) {
        return this.f1122i != null && this.f1122i.mo379a(c0538f, menuItem);
    }

    public void m2487f() {
        if (this.f1122i != null) {
            this.f1122i.mo375a(this);
        }
    }

    private static int m2447a(ArrayList<C0541h> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((C0541h) arrayList.get(size)).m2518c() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItem a = m2460a(i, keyEvent);
        boolean z = false;
        if (a != null) {
            z = m2472a(a, i2);
        }
        if ((i2 & 2) != 0) {
            m2470a(true);
        }
        return z;
    }

    void m2469a(List<C0541h> list, int i, KeyEvent keyEvent) {
        boolean b = mo494b();
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f1123j.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0541h c0541h = (C0541h) this.f1123j.get(i2);
                if (c0541h.hasSubMenu()) {
                    ((C0538f) c0541h.getSubMenu()).m2469a((List) list, i, keyEvent);
                }
                char alphabeticShortcut = b ? c0541h.getAlphabeticShortcut() : c0541h.getNumericShortcut();
                if ((metaState & 5) == 0 && alphabeticShortcut != '\u0000' && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (b && alphabeticShortcut == '\b' && i == 67)) && c0541h.isEnabled())) {
                    list.add(c0541h);
                }
            }
        }
    }

    C0541h m2460a(int i, KeyEvent keyEvent) {
        List list = this.f1135v;
        list.clear();
        m2469a(list, i, keyEvent);
        if (list.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        keyEvent.getKeyData(keyData);
        int size = list.size();
        if (size == 1) {
            return (C0541h) list.get(0);
        }
        boolean b = mo494b();
        for (int i2 = 0; i2 < size; i2++) {
            C0541h c0541h = (C0541h) list.get(i2);
            char alphabeticShortcut = b ? c0541h.getAlphabeticShortcut() : c0541h.getNumericShortcut();
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return c0541h;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return c0541h;
            }
            if (b && alphabeticShortcut == '\b' && i == 67) {
                return c0541h;
            }
        }
        return null;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return m2472a(findItem(i), i2);
    }

    public boolean m2472a(MenuItem menuItem, int i) {
        return m2473a(menuItem, null, i);
    }

    public boolean m2473a(MenuItem menuItem, C0532l c0532l, int i) {
        C0541h c0541h = (C0541h) menuItem;
        if (c0541h == null || !c0541h.isEnabled()) {
            return false;
        }
        boolean z;
        boolean b = c0541h.m2517b();
        C0321d a = c0541h.mo461a();
        if (a == null || !a.mo481e()) {
            z = false;
        } else {
            z = true;
        }
        boolean expandActionView;
        if (c0541h.m2532n()) {
            expandActionView = c0541h.expandActionView() | b;
            if (!expandActionView) {
                return expandActionView;
            }
            m2470a(true);
            return expandActionView;
        } else if (c0541h.hasSubMenu() || z) {
            m2470a(false);
            if (!c0541h.hasSubMenu()) {
                c0541h.m2512a(new C0553p(m2486e(), this, c0541h));
            }
            C0553p c0553p = (C0553p) c0541h.getSubMenu();
            if (z) {
                a.mo479a((SubMenu) c0553p);
            }
            expandActionView = m2451a(c0553p, c0532l) | b;
            if (expandActionView) {
                return expandActionView;
            }
            m2470a(true);
            return expandActionView;
        } else {
            if ((i & 1) == 0) {
                m2470a(true);
            }
            return b;
        }
    }

    public final void m2470a(boolean z) {
        if (!this.f1134u) {
            this.f1134u = true;
            Iterator it = this.f1136w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0532l c0532l = (C0532l) weakReference.get();
                if (c0532l == null) {
                    this.f1136w.remove(weakReference);
                } else {
                    c0532l.mo471a(this, z);
                }
            }
            this.f1134u = false;
        }
    }

    public void close() {
        m2470a(true);
    }

    public void m2478b(boolean z) {
        if (this.f1131r) {
            this.f1132s = true;
            return;
        }
        if (z) {
            this.f1125l = true;
            this.f1128o = true;
        }
        m2453d(z);
    }

    public void m2488g() {
        if (!this.f1131r) {
            this.f1131r = true;
            this.f1132s = false;
        }
    }

    public void m2489h() {
        this.f1131r = false;
        if (this.f1132s) {
            this.f1132s = false;
            m2478b(true);
        }
    }

    void m2465a(C0541h c0541h) {
        this.f1125l = true;
        m2478b(true);
    }

    void m2476b(C0541h c0541h) {
        this.f1128o = true;
        m2478b(true);
    }

    public ArrayList<C0541h> m2490i() {
        if (!this.f1125l) {
            return this.f1124k;
        }
        this.f1124k.clear();
        int size = this.f1123j.size();
        for (int i = 0; i < size; i++) {
            C0541h c0541h = (C0541h) this.f1123j.get(i);
            if (c0541h.isVisible()) {
                this.f1124k.add(c0541h);
            }
        }
        this.f1125l = false;
        this.f1128o = true;
        return this.f1124k;
    }

    public void m2491j() {
        ArrayList i = m2490i();
        if (this.f1128o) {
            Iterator it = this.f1136w.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                int i3;
                WeakReference weakReference = (WeakReference) it.next();
                C0532l c0532l = (C0532l) weakReference.get();
                if (c0532l == null) {
                    this.f1136w.remove(weakReference);
                    i3 = i2;
                } else {
                    i3 = c0532l.mo475b() | i2;
                }
                i2 = i3;
            }
            if (i2 != 0) {
                this.f1126m.clear();
                this.f1127n.clear();
                i2 = i.size();
                for (int i4 = 0; i4 < i2; i4++) {
                    C0541h c0541h = (C0541h) i.get(i4);
                    if (c0541h.m2528j()) {
                        this.f1126m.add(c0541h);
                    } else {
                        this.f1127n.add(c0541h);
                    }
                }
            } else {
                this.f1126m.clear();
                this.f1127n.clear();
                this.f1127n.addAll(m2490i());
            }
            this.f1128o = false;
        }
    }

    public ArrayList<C0541h> m2492k() {
        m2491j();
        return this.f1126m;
    }

    public ArrayList<C0541h> m2493l() {
        m2491j();
        return this.f1127n;
    }

    public void clearHeader() {
        this.f1116b = null;
        this.f1115a = null;
        this.f1117c = null;
        m2478b(false);
    }

    private void m2449a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources d = m2484d();
        if (view != null) {
            this.f1117c = view;
            this.f1115a = null;
            this.f1116b = null;
        } else {
            if (i > 0) {
                this.f1115a = d.getText(i);
            } else if (charSequence != null) {
                this.f1115a = charSequence;
            }
            if (i2 > 0) {
                this.f1116b = C0023a.m77a(m2486e(), i2);
            } else if (drawable != null) {
                this.f1116b = drawable;
            }
            this.f1117c = null;
        }
        m2478b(false);
    }

    protected C0538f m2459a(CharSequence charSequence) {
        m2449a(0, charSequence, 0, null, null);
        return this;
    }

    protected C0538f m2457a(Drawable drawable) {
        m2449a(0, null, 0, drawable, null);
        return this;
    }

    protected C0538f m2458a(View view) {
        m2449a(0, null, 0, null, view);
        return this;
    }

    public CharSequence m2494m() {
        return this.f1115a;
    }

    public Drawable m2495n() {
        return this.f1116b;
    }

    public View m2496o() {
        return this.f1117c;
    }

    public C0538f mo498p() {
        return this;
    }

    boolean m2498q() {
        return this.f1133t;
    }

    public boolean mo496c(C0541h c0541h) {
        boolean z = false;
        if (!this.f1136w.isEmpty()) {
            m2488g();
            Iterator it = this.f1136w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0532l c0532l = (C0532l) weakReference.get();
                if (c0532l == null) {
                    this.f1136w.remove(weakReference);
                    z = z2;
                } else {
                    z = c0532l.mo472a(this, c0541h);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            m2489h();
            if (z) {
                this.f1137x = c0541h;
            }
        }
        return z;
    }

    public boolean mo497d(C0541h c0541h) {
        boolean z = false;
        if (!this.f1136w.isEmpty() && this.f1137x == c0541h) {
            m2488g();
            Iterator it = this.f1136w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0532l c0532l = (C0532l) weakReference.get();
                if (c0532l == null) {
                    this.f1136w.remove(weakReference);
                    z = z2;
                } else {
                    z = c0532l.mo476b(this, c0541h);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            m2489h();
            if (z) {
                this.f1137x = null;
            }
        }
        return z;
    }

    public C0541h m2499r() {
        return this.f1137x;
    }

    public void m2481c(boolean z) {
        this.f1138y = z;
    }
}
