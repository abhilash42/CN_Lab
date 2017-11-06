package android.support.v4.app;

import android.os.Build.VERSION;
import android.support.v4.app.C0131s.C0097b;
import android.support.v4.app.C0131s.C0130a;
import android.support.v4.p009e.C0189a;
import android.support.v4.p009e.C0192d;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: BackStackRecord */
final class C0104g extends C0103r implements Runnable {
    static final boolean f286a = (VERSION.SDK_INT >= 21);
    final C0125q f287b;
    C0101a f288c;
    C0101a f289d;
    int f290e;
    int f291f;
    int f292g;
    int f293h;
    int f294i;
    int f295j;
    int f296k;
    boolean f297l;
    boolean f298m = true;
    String f299n;
    boolean f300o;
    int f301p = -1;
    int f302q;
    CharSequence f303r;
    int f304s;
    CharSequence f305t;
    ArrayList<String> f306u;
    ArrayList<String> f307v;

    /* compiled from: BackStackRecord */
    static final class C0101a {
        C0101a f272a;
        C0101a f273b;
        int f274c;
        Fragment f275d;
        int f276e;
        int f277f;
        int f278g;
        int f279h;
        ArrayList<Fragment> f280i;

        C0101a() {
        }
    }

    /* compiled from: BackStackRecord */
    public class C0102b {
        public C0189a<String, String> f281a = new C0189a();
        public ArrayList<View> f282b = new ArrayList();
        public C0130a f283c = new C0130a();
        public View f284d;
        final /* synthetic */ C0104g f285e;

        public C0102b(C0104g c0104g) {
            this.f285e = c0104g;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f301p >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f301p);
        }
        if (this.f299n != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f299n);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void m361a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        m362a(str, printWriter, true);
    }

    public void m362a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f299n);
            printWriter.print(" mIndex=");
            printWriter.print(this.f301p);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f300o);
            if (this.f295j != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f295j));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f296k));
            }
            if (!(this.f291f == 0 && this.f292g == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f291f));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f292g));
            }
            if (!(this.f293h == 0 && this.f294i == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f293h));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f294i));
            }
            if (!(this.f302q == 0 && this.f303r == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f302q));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f303r);
            }
            if (!(this.f304s == 0 && this.f305t == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f304s));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f305t);
            }
        }
        if (this.f288c != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str2 = str + "    ";
            int i = 0;
            C0101a c0101a = this.f288c;
            while (c0101a != null) {
                String str3;
                switch (c0101a.f274c) {
                    case 0:
                        str3 = "NULL";
                        break;
                    case 1:
                        str3 = "ADD";
                        break;
                    case 2:
                        str3 = "REPLACE";
                        break;
                    case 3:
                        str3 = "REMOVE";
                        break;
                    case 4:
                        str3 = "HIDE";
                        break;
                    case 5:
                        str3 = "SHOW";
                        break;
                    case 6:
                        str3 = "DETACH";
                        break;
                    case 7:
                        str3 = "ATTACH";
                        break;
                    default:
                        str3 = "cmd=" + c0101a.f274c;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str3);
                printWriter.print(" ");
                printWriter.println(c0101a.f275d);
                if (z) {
                    if (!(c0101a.f276e == 0 && c0101a.f277f == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(c0101a.f276e));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(c0101a.f277f));
                    }
                    if (!(c0101a.f278g == 0 && c0101a.f279h == 0)) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(c0101a.f278g));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(c0101a.f279h));
                    }
                }
                if (c0101a.f280i != null && c0101a.f280i.size() > 0) {
                    for (int i2 = 0; i2 < c0101a.f280i.size(); i2++) {
                        printWriter.print(str2);
                        if (c0101a.f280i.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str2);
                            printWriter.print("  #");
                            printWriter.print(i2);
                            printWriter.print(": ");
                        }
                        printWriter.println(c0101a.f280i.get(i2));
                    }
                }
                c0101a = c0101a.f272a;
                i++;
            }
        }
    }

    public C0104g(C0125q c0125q) {
        this.f287b = c0125q;
    }

    void m359a(C0101a c0101a) {
        if (this.f288c == null) {
            this.f289d = c0101a;
            this.f288c = c0101a;
        } else {
            c0101a.f273b = this.f289d;
            this.f289d.f272a = c0101a;
            this.f289d = c0101a;
        }
        c0101a.f276e = this.f291f;
        c0101a.f277f = this.f292g;
        c0101a.f278g = this.f293h;
        c0101a.f279h = this.f294i;
        this.f290e++;
    }

    public C0103r mo49a(Fragment fragment, String str) {
        m331a(0, fragment, str, 1);
        return this;
    }

    private void m331a(int i, Fragment fragment, String str, int i2) {
        fragment.f128B = this.f287b;
        if (str != null) {
            if (fragment.f134H == null || str.equals(fragment.f134H)) {
                fragment.f134H = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.f134H + " now " + str);
            }
        }
        if (i != 0) {
            if (fragment.f132F == 0 || fragment.f132F == i) {
                fragment.f132F = i;
                fragment.f133G = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.f132F + " now " + i);
            }
        }
        C0101a c0101a = new C0101a();
        c0101a.f274c = i2;
        c0101a.f275d = fragment;
        m359a(c0101a);
    }

    public C0103r mo47a(int i, Fragment fragment) {
        return m354a(i, fragment, null);
    }

    public C0103r m354a(int i, Fragment fragment, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        m331a(i, fragment, str, 2);
        return this;
    }

    public C0103r mo48a(Fragment fragment) {
        C0101a c0101a = new C0101a();
        c0101a.f274c = 3;
        c0101a.f275d = fragment;
        m359a(c0101a);
        return this;
    }

    public C0103r mo50a(String str) {
        if (this.f298m) {
            this.f297l = true;
            this.f299n = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    void m358a(int i) {
        if (this.f297l) {
            if (C0125q.f361a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            for (C0101a c0101a = this.f288c; c0101a != null; c0101a = c0101a.f272a) {
                Fragment fragment;
                if (c0101a.f275d != null) {
                    fragment = c0101a.f275d;
                    fragment.f127A += i;
                    if (C0125q.f361a) {
                        Log.v("FragmentManager", "Bump nesting of " + c0101a.f275d + " to " + c0101a.f275d.f127A);
                    }
                }
                if (c0101a.f280i != null) {
                    for (int size = c0101a.f280i.size() - 1; size >= 0; size--) {
                        fragment = (Fragment) c0101a.f280i.get(size);
                        fragment.f127A += i;
                        if (C0125q.f361a) {
                            Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.f127A);
                        }
                    }
                }
            }
        }
    }

    public int mo46a() {
        return m351a(false);
    }

    public int mo51b() {
        return m351a(true);
    }

    int m351a(boolean z) {
        if (this.f300o) {
            throw new IllegalStateException("commit already called");
        }
        if (C0125q.f361a) {
            Log.v("FragmentManager", "Commit: " + this);
            m361a("  ", null, new PrintWriter(new C0192d("FragmentManager")), null);
        }
        this.f300o = true;
        if (this.f297l) {
            this.f301p = this.f287b.m477a(this);
        } else {
            this.f301p = -1;
        }
        this.f287b.m496a((Runnable) this, z);
        return this.f301p;
    }

    public void run() {
        if (C0125q.f361a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        if (!this.f297l || this.f301p >= 0) {
            C0102b c0102b;
            m358a(1);
            if (!f286a || this.f287b.f375n < 1) {
                c0102b = null;
            } else {
                SparseArray sparseArray = new SparseArray();
                SparseArray sparseArray2 = new SparseArray();
                m348b(sparseArray, sparseArray2);
                c0102b = m323a(sparseArray, sparseArray2, false);
            }
            int i = c0102b != null ? 0 : this.f296k;
            int i2 = c0102b != null ? 0 : this.f295j;
            C0101a c0101a = this.f288c;
            while (c0101a != null) {
                int i3 = c0102b != null ? 0 : c0101a.f276e;
                int i4 = c0102b != null ? 0 : c0101a.f277f;
                Fragment fragment;
                switch (c0101a.f274c) {
                    case 1:
                        fragment = c0101a.f275d;
                        fragment.f142P = i3;
                        this.f287b.m494a(fragment, false);
                        break;
                    case 2:
                        Fragment fragment2 = c0101a.f275d;
                        int i5 = fragment2.f133G;
                        if (this.f287b.f368g != null) {
                            int size = this.f287b.f368g.size() - 1;
                            while (size >= 0) {
                                fragment = (Fragment) this.f287b.f368g.get(size);
                                if (C0125q.f361a) {
                                    Log.v("FragmentManager", "OP_REPLACE: adding=" + fragment2 + " old=" + fragment);
                                }
                                if (fragment.f133G == i5) {
                                    if (fragment == fragment2) {
                                        fragment = null;
                                        c0101a.f275d = null;
                                        size--;
                                        fragment2 = fragment;
                                    } else {
                                        if (c0101a.f280i == null) {
                                            c0101a.f280i = new ArrayList();
                                        }
                                        c0101a.f280i.add(fragment);
                                        fragment.f142P = i4;
                                        if (this.f297l) {
                                            fragment.f127A++;
                                            if (C0125q.f361a) {
                                                Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.f127A);
                                            }
                                        }
                                        this.f287b.m492a(fragment, i2, i);
                                    }
                                }
                                fragment = fragment2;
                                size--;
                                fragment2 = fragment;
                            }
                        }
                        if (fragment2 == null) {
                            break;
                        }
                        fragment2.f142P = i3;
                        this.f287b.m494a(fragment2, false);
                        break;
                    case 3:
                        fragment = c0101a.f275d;
                        fragment.f142P = i4;
                        this.f287b.m492a(fragment, i2, i);
                        break;
                    case 4:
                        fragment = c0101a.f275d;
                        fragment.f142P = i4;
                        this.f287b.m505b(fragment, i2, i);
                        break;
                    case 5:
                        fragment = c0101a.f275d;
                        fragment.f142P = i3;
                        this.f287b.m511c(fragment, i2, i);
                        break;
                    case 6:
                        fragment = c0101a.f275d;
                        fragment.f142P = i4;
                        this.f287b.m515d(fragment, i2, i);
                        break;
                    case 7:
                        fragment = c0101a.f275d;
                        fragment.f142P = i3;
                        this.f287b.m517e(fragment, i2, i);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + c0101a.f274c);
                }
                c0101a = c0101a.f272a;
            }
            this.f287b.m485a(this.f287b.f375n, i2, i, true);
            if (this.f297l) {
                this.f287b.m506b(this);
                return;
            }
            return;
        }
        throw new IllegalStateException("addToBackStack() called after commit()");
    }

    private static void m342a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.f133G;
            if (i != 0 && !fragment.m185m()) {
                if (fragment.m184l() && fragment.m186n() != null && sparseArray.get(i) == null) {
                    sparseArray.put(i, fragment);
                }
                if (sparseArray2.get(i) == fragment) {
                    sparseArray2.remove(i);
                }
            }
        }
    }

    private void m349b(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.f133G;
            if (i != 0) {
                if (!fragment.m184l()) {
                    sparseArray2.put(i, fragment);
                }
                if (sparseArray.get(i) == fragment) {
                    sparseArray.remove(i);
                }
            }
            if (fragment.f153k < 1 && this.f287b.f375n >= 1) {
                this.f287b.m510c(fragment);
                this.f287b.m493a(fragment, 1, 0, 0, false);
            }
        }
    }

    private void m348b(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.f287b.f377p.mo28a()) {
            for (C0101a c0101a = this.f288c; c0101a != null; c0101a = c0101a.f272a) {
                switch (c0101a.f274c) {
                    case 1:
                        m349b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0101a.f275d);
                        break;
                    case 2:
                        Fragment fragment = c0101a.f275d;
                        if (this.f287b.f368g != null) {
                            Fragment fragment2 = fragment;
                            for (int i = 0; i < this.f287b.f368g.size(); i++) {
                                Fragment fragment3 = (Fragment) this.f287b.f368g.get(i);
                                if (fragment2 == null || fragment3.f133G == fragment2.f133G) {
                                    if (fragment3 == fragment2) {
                                        fragment2 = null;
                                        sparseArray2.remove(fragment3.f133G);
                                    } else {
                                        C0104g.m342a((SparseArray) sparseArray, (SparseArray) sparseArray2, fragment3);
                                    }
                                }
                            }
                        }
                        m349b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0101a.f275d);
                        break;
                    case 3:
                        C0104g.m342a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0101a.f275d);
                        break;
                    case 4:
                        C0104g.m342a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0101a.f275d);
                        break;
                    case 5:
                        m349b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0101a.f275d);
                        break;
                    case 6:
                        C0104g.m342a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0101a.f275d);
                        break;
                    case 7:
                        m349b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0101a.f275d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void m360a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.f287b.f377p.mo28a()) {
            for (C0101a c0101a = this.f289d; c0101a != null; c0101a = c0101a.f273b) {
                switch (c0101a.f274c) {
                    case 1:
                        C0104g.m342a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0101a.f275d);
                        break;
                    case 2:
                        if (c0101a.f280i != null) {
                            for (int size = c0101a.f280i.size() - 1; size >= 0; size--) {
                                m349b((SparseArray) sparseArray, (SparseArray) sparseArray2, (Fragment) c0101a.f280i.get(size));
                            }
                        }
                        C0104g.m342a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0101a.f275d);
                        break;
                    case 3:
                        m349b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0101a.f275d);
                        break;
                    case 4:
                        m349b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0101a.f275d);
                        break;
                    case 5:
                        C0104g.m342a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0101a.f275d);
                        break;
                    case 6:
                        m349b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0101a.f275d);
                        break;
                    case 7:
                        C0104g.m342a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0101a.f275d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public C0102b m352a(boolean z, C0102b c0102b, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (C0125q.f361a) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            m361a("  ", null, new PrintWriter(new C0192d("FragmentManager")), null);
        }
        if (f286a && this.f287b.f375n >= 1) {
            if (c0102b == null) {
                if (!(sparseArray.size() == 0 && sparseArray2.size() == 0)) {
                    c0102b = m323a((SparseArray) sparseArray, (SparseArray) sparseArray2, true);
                }
            } else if (!z) {
                C0104g.m336a(c0102b, this.f307v, this.f306u);
            }
        }
        m358a(-1);
        int i = c0102b != null ? 0 : this.f296k;
        int i2 = c0102b != null ? 0 : this.f295j;
        C0101a c0101a = this.f289d;
        while (c0101a != null) {
            int i3 = c0102b != null ? 0 : c0101a.f278g;
            int i4 = c0102b != null ? 0 : c0101a.f279h;
            Fragment fragment;
            Fragment fragment2;
            switch (c0101a.f274c) {
                case 1:
                    fragment = c0101a.f275d;
                    fragment.f142P = i4;
                    this.f287b.m492a(fragment, C0125q.m475c(i2), i);
                    break;
                case 2:
                    fragment = c0101a.f275d;
                    if (fragment != null) {
                        fragment.f142P = i4;
                        this.f287b.m492a(fragment, C0125q.m475c(i2), i);
                    }
                    if (c0101a.f280i == null) {
                        break;
                    }
                    for (int i5 = 0; i5 < c0101a.f280i.size(); i5++) {
                        fragment2 = (Fragment) c0101a.f280i.get(i5);
                        fragment2.f142P = i3;
                        this.f287b.m494a(fragment2, false);
                    }
                    break;
                case 3:
                    fragment2 = c0101a.f275d;
                    fragment2.f142P = i3;
                    this.f287b.m494a(fragment2, false);
                    break;
                case 4:
                    fragment2 = c0101a.f275d;
                    fragment2.f142P = i3;
                    this.f287b.m511c(fragment2, C0125q.m475c(i2), i);
                    break;
                case 5:
                    fragment = c0101a.f275d;
                    fragment.f142P = i4;
                    this.f287b.m505b(fragment, C0125q.m475c(i2), i);
                    break;
                case 6:
                    fragment2 = c0101a.f275d;
                    fragment2.f142P = i3;
                    this.f287b.m517e(fragment2, C0125q.m475c(i2), i);
                    break;
                case 7:
                    fragment2 = c0101a.f275d;
                    fragment2.f142P = i3;
                    this.f287b.m515d(fragment2, C0125q.m475c(i2), i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0101a.f274c);
            }
            c0101a = c0101a.f273b;
        }
        if (z) {
            this.f287b.m485a(this.f287b.f375n, C0125q.m475c(i2), i, true);
            c0102b = null;
        }
        if (this.f301p >= 0) {
            this.f287b.m503b(this.f301p);
            this.f301p = -1;
        }
        return c0102b;
    }

    public String m364c() {
        return this.f299n;
    }

    private C0102b m323a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, boolean z) {
        int i = 0;
        C0102b c0102b = new C0102b(this);
        c0102b.f284d = new View(this.f287b.f376o.m397g());
        int i2 = 0;
        int i3 = 0;
        while (i2 < sparseArray.size()) {
            int i4;
            if (m344a(sparseArray.keyAt(i2), c0102b, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i4 = 1;
            } else {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        while (i < sparseArray2.size()) {
            i4 = sparseArray2.keyAt(i);
            if (sparseArray.get(i4) == null && m344a(i4, c0102b, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i3 = 1;
            }
            i++;
        }
        if (i3 == 0) {
            return null;
        }
        return c0102b;
    }

    private static Object m329a(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return C0131s.m535a(z ? fragment.m195w() : fragment.m192t());
    }

    private static Object m346b(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return C0131s.m535a(z ? fragment.m193u() : fragment.m194v());
    }

    private static Object m328a(Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return C0131s.m554b(z ? fragment2.m197y() : fragment.m196x());
    }

    private static Object m330a(Object obj, Fragment fragment, ArrayList<View> arrayList, C0189a<String, View> c0189a, View view) {
        if (obj != null) {
            return C0131s.m536a(obj, fragment.m186n(), arrayList, c0189a, view);
        }
        return obj;
    }

    private C0189a<String, View> m324a(C0102b c0102b, Fragment fragment, boolean z) {
        C0189a c0189a = new C0189a();
        if (this.f306u != null) {
            C0131s.m549a((Map) c0189a, fragment.m186n());
            if (z) {
                c0189a.m772a(this.f307v);
            } else {
                c0189a = C0104g.m327a(this.f306u, this.f307v, c0189a);
            }
        }
        if (z) {
            if (fragment.ag != null) {
                fragment.ag.m293a(this.f307v, c0189a);
            }
            m334a(c0102b, c0189a, false);
        } else {
            if (fragment.ah != null) {
                fragment.ah.m293a(this.f307v, c0189a);
            }
            m347b(c0102b, c0189a, false);
        }
        return c0189a;
    }

    private boolean m344a(int i, C0102b c0102b, boolean z, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        View view = (ViewGroup) this.f287b.f377p.mo27a(i);
        if (view == null) {
            return false;
        }
        Object obj;
        ArrayList arrayList;
        Object a;
        View view2;
        C0097b c00981;
        ArrayList arrayList2;
        Map c0189a;
        boolean z2;
        Object a2;
        final Fragment fragment = (Fragment) sparseArray2.get(i);
        Fragment fragment2 = (Fragment) sparseArray.get(i);
        Object a3 = C0104g.m329a(fragment, z);
        Object a4 = C0104g.m328a(fragment, fragment2, z);
        Object b = C0104g.m346b(fragment2, z);
        Map map = null;
        ArrayList arrayList3 = new ArrayList();
        if (a4 != null) {
            map = m324a(c0102b, fragment2, z);
            if (map.isEmpty()) {
                map = null;
                obj = null;
                if (a3 != null && obj == null && b == null) {
                    return false;
                }
                arrayList = new ArrayList();
                a = C0104g.m330a(b, fragment2, arrayList, (C0189a) map, c0102b.f284d);
                if (!(this.f307v == null || map == null)) {
                    view2 = (View) map.get(this.f307v.get(0));
                    if (view2 != null) {
                        if (a != null) {
                            C0131s.m542a(a, view2);
                        }
                        if (obj != null) {
                            C0131s.m542a(obj, view2);
                        }
                    }
                }
                c00981 = new C0097b(this) {
                    final /* synthetic */ C0104g f258b;

                    public View mo45a() {
                        return fragment.m186n();
                    }
                };
                arrayList2 = new ArrayList();
                c0189a = new C0189a();
                z2 = true;
                if (fragment != null) {
                    z2 = z ? fragment.m126A() : fragment.m198z();
                }
                a2 = C0131s.m537a(a3, a, obj, z2);
                if (a2 != null) {
                    C0131s.m545a(a3, obj, view, c00981, c0102b.f284d, c0102b.f283c, (Map) c0102b.f281a, arrayList2, map, c0189a, arrayList3);
                    m343a(view, c0102b, i, a2);
                    C0131s.m544a(a2, c0102b.f284d, true);
                    m332a(c0102b, i, a2);
                    C0131s.m541a((ViewGroup) view, a2);
                    C0131s.m540a(view, c0102b.f284d, a3, arrayList2, a, arrayList, obj, arrayList3, a2, c0102b.f282b, c0189a);
                }
                if (a2 == null) {
                    return true;
                }
                return false;
            }
            an anVar = z ? fragment2.ag : fragment.ag;
            if (anVar != null) {
                anVar.m292a(new ArrayList(map.keySet()), new ArrayList(map.values()), null);
            }
            m335a(c0102b, view, a4, fragment, fragment2, z, arrayList3);
        }
        obj = a4;
        if (a3 != null) {
        }
        arrayList = new ArrayList();
        a = C0104g.m330a(b, fragment2, arrayList, (C0189a) map, c0102b.f284d);
        view2 = (View) map.get(this.f307v.get(0));
        if (view2 != null) {
            if (a != null) {
                C0131s.m542a(a, view2);
            }
            if (obj != null) {
                C0131s.m542a(obj, view2);
            }
        }
        c00981 = /* anonymous class already generated */;
        arrayList2 = new ArrayList();
        c0189a = new C0189a();
        z2 = true;
        if (fragment != null) {
            if (z) {
            }
        }
        a2 = C0131s.m537a(a3, a, obj, z2);
        if (a2 != null) {
            C0131s.m545a(a3, obj, view, c00981, c0102b.f284d, c0102b.f283c, (Map) c0102b.f281a, arrayList2, map, c0189a, arrayList3);
            m343a(view, c0102b, i, a2);
            C0131s.m544a(a2, c0102b.f284d, true);
            m332a(c0102b, i, a2);
            C0131s.m541a((ViewGroup) view, a2);
            C0131s.m540a(view, c0102b.f284d, a3, arrayList2, a, arrayList, obj, arrayList3, a2, c0102b.f282b, c0189a);
        }
        if (a2 == null) {
            return false;
        }
        return true;
    }

    private void m335a(C0102b c0102b, View view, Object obj, Fragment fragment, Fragment fragment2, boolean z, ArrayList<View> arrayList) {
        final View view2 = view;
        final Object obj2 = obj;
        final ArrayList<View> arrayList2 = arrayList;
        final C0102b c0102b2 = c0102b;
        final boolean z2 = z;
        final Fragment fragment3 = fragment;
        final Fragment fragment4 = fragment2;
        view.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
            final /* synthetic */ C0104g f266h;

            public boolean onPreDraw() {
                view2.getViewTreeObserver().removeOnPreDrawListener(this);
                if (obj2 != null) {
                    C0131s.m546a(obj2, arrayList2);
                    arrayList2.clear();
                    C0189a a = this.f266h.m325a(c0102b2, z2, fragment3);
                    C0131s.m543a(obj2, c0102b2.f284d, (Map) a, arrayList2);
                    this.f266h.m340a(a, c0102b2);
                    this.f266h.m333a(c0102b2, fragment3, fragment4, z2, a);
                }
                return true;
            }
        });
    }

    private void m333a(C0102b c0102b, Fragment fragment, Fragment fragment2, boolean z, C0189a<String, View> c0189a) {
        an anVar = z ? fragment2.ag : fragment.ag;
        if (anVar != null) {
            anVar.m294b(new ArrayList(c0189a.keySet()), new ArrayList(c0189a.values()), null);
        }
    }

    private void m340a(C0189a<String, View> c0189a, C0102b c0102b) {
        if (this.f307v != null && !c0189a.isEmpty()) {
            View view = (View) c0189a.get(this.f307v.get(0));
            if (view != null) {
                c0102b.f283c.f408a = view;
            }
        }
    }

    private C0189a<String, View> m325a(C0102b c0102b, boolean z, Fragment fragment) {
        C0189a b = m345b(c0102b, fragment, z);
        if (z) {
            if (fragment.ah != null) {
                fragment.ah.m293a(this.f307v, b);
            }
            m334a(c0102b, b, true);
        } else {
            if (fragment.ag != null) {
                fragment.ag.m293a(this.f307v, b);
            }
            m347b(c0102b, b, true);
        }
        return b;
    }

    private static C0189a<String, View> m327a(ArrayList<String> arrayList, ArrayList<String> arrayList2, C0189a<String, View> c0189a) {
        if (c0189a.isEmpty()) {
            return c0189a;
        }
        C0189a<String, View> c0189a2 = new C0189a();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) c0189a.get(arrayList.get(i));
            if (view != null) {
                c0189a2.put(arrayList2.get(i), view);
            }
        }
        return c0189a2;
    }

    private C0189a<String, View> m345b(C0102b c0102b, Fragment fragment, boolean z) {
        C0189a c0189a = new C0189a();
        View n = fragment.m186n();
        if (n == null || this.f306u == null) {
            return c0189a;
        }
        C0131s.m549a((Map) c0189a, n);
        if (z) {
            return C0104g.m327a(this.f306u, this.f307v, c0189a);
        }
        c0189a.m772a(this.f307v);
        return c0189a;
    }

    private void m343a(View view, C0102b c0102b, int i, Object obj) {
        final View view2 = view;
        final C0102b c0102b2 = c0102b;
        final int i2 = i;
        final Object obj2 = obj;
        view.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
            final /* synthetic */ C0104g f271e;

            public boolean onPreDraw() {
                view2.getViewTreeObserver().removeOnPreDrawListener(this);
                this.f271e.m332a(c0102b2, i2, obj2);
                return true;
            }
        });
    }

    private void m332a(C0102b c0102b, int i, Object obj) {
        if (this.f287b.f368g != null) {
            for (int i2 = 0; i2 < this.f287b.f368g.size(); i2++) {
                Fragment fragment = (Fragment) this.f287b.f368g.get(i2);
                if (!(fragment.f144R == null || fragment.f143Q == null || fragment.f133G != i)) {
                    if (!fragment.f135I) {
                        C0131s.m544a(obj, fragment.f144R, false);
                        c0102b.f282b.remove(fragment.f144R);
                    } else if (!c0102b.f282b.contains(fragment.f144R)) {
                        C0131s.m544a(obj, fragment.f144R, true);
                        c0102b.f282b.add(fragment.f144R);
                    }
                }
            }
        }
    }

    private static void m341a(C0189a<String, String> c0189a, String str, String str2) {
        if (str != null && str2 != null) {
            for (int i = 0; i < c0189a.size(); i++) {
                if (str.equals(c0189a.m769c(i))) {
                    c0189a.m765a(i, (Object) str2);
                    return;
                }
            }
            c0189a.put(str, str2);
        }
    }

    private static void m336a(C0102b c0102b, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                C0104g.m341a(c0102b.f281a, (String) arrayList.get(i), (String) arrayList2.get(i));
            }
        }
    }

    private void m334a(C0102b c0102b, C0189a<String, View> c0189a, boolean z) {
        int size = this.f307v == null ? 0 : this.f307v.size();
        for (int i = 0; i < size; i++) {
            String str = (String) this.f306u.get(i);
            View view = (View) c0189a.get((String) this.f307v.get(i));
            if (view != null) {
                String a = C0131s.m538a(view);
                if (z) {
                    C0104g.m341a(c0102b.f281a, str, a);
                } else {
                    C0104g.m341a(c0102b.f281a, a, str);
                }
            }
        }
    }

    private void m347b(C0102b c0102b, C0189a<String, View> c0189a, boolean z) {
        int size = c0189a.size();
        for (int i = 0; i < size; i++) {
            String str = (String) c0189a.m768b(i);
            String a = C0131s.m538a((View) c0189a.m769c(i));
            if (z) {
                C0104g.m341a(c0102b.f281a, str, a);
            } else {
                C0104g.m341a(c0102b.f281a, a, str);
            }
        }
    }
}
