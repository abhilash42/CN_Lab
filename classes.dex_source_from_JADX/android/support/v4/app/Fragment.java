package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.p009e.C0188i;
import android.support.v4.p009e.C0191c;
import android.support.v4.view.C0337i;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Fragment implements ComponentCallbacks, OnCreateContextMenuListener {
    private static final C0188i<String, Class<?>> f125a = new C0188i();
    static final Object f126j = new Object();
    int f127A;
    C0125q f128B;
    C0110o f129C;
    C0125q f130D;
    Fragment f131E;
    int f132F;
    int f133G;
    String f134H;
    boolean f135I;
    boolean f136J;
    boolean f137K;
    boolean f138L;
    boolean f139M;
    boolean f140N = true;
    boolean f141O;
    int f142P;
    ViewGroup f143Q;
    View f144R;
    View f145S;
    boolean f146T;
    boolean f147U = true;
    C0135u f148V;
    boolean f149W;
    boolean f150X;
    Object f151Y = null;
    Object f152Z = f126j;
    Object aa = null;
    Object ab = f126j;
    Object ac = null;
    Object ad = f126j;
    Boolean ae;
    Boolean af;
    an ag = null;
    an ah = null;
    int f153k = 0;
    View f154l;
    int f155m;
    Bundle f156n;
    SparseArray<Parcelable> f157o;
    int f158p = -1;
    String f159q;
    Bundle f160r;
    Fragment f161s;
    int f162t = -1;
    int f163u;
    boolean f164v;
    boolean f165w;
    boolean f166x;
    boolean f167y;
    boolean f168z;

    class C00451 extends C0044m {
        final /* synthetic */ Fragment f124a;

        C00451(Fragment fragment) {
            this.f124a = fragment;
        }

        public View mo27a(int i) {
            if (this.f124a.f144R != null) {
                return this.f124a.f144R.findViewById(i);
            }
            throw new IllegalStateException("Fragment does not have a view");
        }

        public boolean mo28a() {
            return this.f124a.f144R != null;
        }
    }

    public static class InstantiationException extends RuntimeException {
        public InstantiationException(String str, Exception exception) {
            super(str, exception);
        }
    }

    public static Fragment m123a(Context context, String str) {
        return m124a(context, str, null);
    }

    public static Fragment m124a(Context context, String str, Bundle bundle) {
        try {
            Class cls = (Class) f125a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f125a.put(str, cls);
            }
            Fragment fragment = (Fragment) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.f160r = bundle;
            }
            return fragment;
        } catch (Exception e) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e);
        } catch (Exception e2) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e2);
        } catch (Exception e22) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e22);
        }
    }

    static boolean m125b(Context context, String str) {
        try {
            Class cls = (Class) f125a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f125a.put(str, cls);
            }
            return Fragment.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    final void m172f(Bundle bundle) {
        if (this.f157o != null) {
            this.f145S.restoreHierarchyState(this.f157o);
            this.f157o = null;
        }
        this.f141O = false;
        m177h(bundle);
        if (!this.f141O) {
            throw new ao("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    final void m141a(int i, Fragment fragment) {
        this.f158p = i;
        if (fragment != null) {
            this.f159q = fragment.f159q + ":" + this.f158p;
        } else {
            this.f159q = "android:fragment:" + this.f158p;
        }
    }

    final boolean m173f() {
        return this.f127A > 0;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        C0191c.m779a(this, stringBuilder);
        if (this.f158p >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f158p);
        }
        if (this.f132F != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.f132F));
        }
        if (this.f134H != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f134H);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void m175g(Bundle bundle) {
        if (this.f158p >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        this.f160r = bundle;
    }

    public final Bundle m174g() {
        return this.f160r;
    }

    public final C0113l m176h() {
        return this.f129C == null ? null : (C0113l) this.f129C.m396f();
    }

    public final Resources m178i() {
        if (this.f129C != null) {
            return this.f129C.m397g().getResources();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final String m139a(int i) {
        return m178i().getString(i);
    }

    public final C0116p m180j() {
        return this.f128B;
    }

    public final C0116p m182k() {
        if (this.f130D == null) {
            m127B();
            if (this.f153k >= 5) {
                this.f130D.m527m();
            } else if (this.f153k >= 4) {
                this.f130D.m526l();
            } else if (this.f153k >= 2) {
                this.f130D.m525k();
            } else if (this.f153k >= 1) {
                this.f130D.m524j();
            }
        }
        return this.f130D;
    }

    public final boolean m184l() {
        return this.f129C != null && this.f164v;
    }

    public final boolean m185m() {
        return this.f135I;
    }

    public void m163c(boolean z) {
    }

    public void m147a(Intent intent, int i) {
        m148a(intent, i, null);
    }

    public void m148a(Intent intent, int i, Bundle bundle) {
        if (this.f129C == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.f129C.mo62a(this, intent, i, bundle);
    }

    public void m140a(int i, int i2, Intent intent) {
    }

    public void m142a(int i, String[] strArr, int[] iArr) {
    }

    public LayoutInflater mo55b(Bundle bundle) {
        LayoutInflater b = this.f129C.mo65b();
        m182k();
        C0337i.m1546a(b, this.f130D.m534t());
        return b;
    }

    public void m146a(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.f141O = true;
        Activity f = this.f129C == null ? null : this.f129C.m396f();
        if (f != null) {
            this.f141O = false;
            m144a(f, attributeSet, bundle);
        }
    }

    @Deprecated
    public void m144a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.f141O = true;
    }

    public void mo891a(Context context) {
        this.f141O = true;
        Activity f = this.f129C == null ? null : this.f129C.m396f();
        if (f != null) {
            this.f141O = false;
            mo53a(f);
        }
    }

    @Deprecated
    public void mo53a(Activity activity) {
        this.f141O = true;
    }

    public Animation m138a(int i, boolean z, int i2) {
        return null;
    }

    public void mo54a(Bundle bundle) {
        this.f141O = true;
    }

    public View mo894a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public void mo892a(View view, Bundle bundle) {
    }

    public View m186n() {
        return this.f144R;
    }

    public void mo59d(Bundle bundle) {
        this.f141O = true;
    }

    public void m177h(Bundle bundle) {
        this.f141O = true;
    }

    public void mo57c() {
        this.f141O = true;
        if (!this.f149W) {
            this.f149W = true;
            if (!this.f150X) {
                this.f150X = true;
                this.f148V = this.f129C.m381a(this.f159q, this.f149W, false);
            }
            if (this.f148V != null) {
                this.f148V.m574b();
            }
        }
    }

    public void m187o() {
        this.f141O = true;
    }

    public void mo61e(Bundle bundle) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.f141O = true;
    }

    public void m188p() {
        this.f141O = true;
    }

    public void mo58d() {
        this.f141O = true;
    }

    public void onLowMemory() {
        this.f141O = true;
    }

    public void mo60e() {
        this.f141O = true;
    }

    public void mo893q() {
        this.f141O = true;
        if (!this.f150X) {
            this.f150X = true;
            this.f148V = this.f129C.m381a(this.f159q, this.f149W, false);
        }
        if (this.f148V != null) {
            this.f148V.m580h();
        }
    }

    void m190r() {
        this.f158p = -1;
        this.f159q = null;
        this.f164v = false;
        this.f165w = false;
        this.f166x = false;
        this.f167y = false;
        this.f168z = false;
        this.f127A = 0;
        this.f128B = null;
        this.f130D = null;
        this.f129C = null;
        this.f132F = 0;
        this.f133G = 0;
        this.f134H = null;
        this.f135I = false;
        this.f136J = false;
        this.f138L = false;
        this.f148V = null;
        this.f149W = false;
        this.f150X = false;
    }

    public void mo56b() {
        this.f141O = true;
    }

    public void m152a(Menu menu, MenuInflater menuInflater) {
    }

    public void m151a(Menu menu) {
    }

    public void m191s() {
    }

    public boolean m155a(MenuItem menuItem) {
        return false;
    }

    public void m159b(Menu menu) {
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        m176h().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public boolean m161b(MenuItem menuItem) {
        return false;
    }

    public Object m192t() {
        return this.f151Y;
    }

    public Object m193u() {
        return this.f152Z == f126j ? m192t() : this.f152Z;
    }

    public Object m194v() {
        return this.aa;
    }

    public Object m195w() {
        return this.ab == f126j ? m194v() : this.ab;
    }

    public Object m196x() {
        return this.ac;
    }

    public Object m197y() {
        return this.ad == f126j ? m196x() : this.ad;
    }

    public boolean m198z() {
        return this.af == null ? true : this.af.booleanValue();
    }

    public boolean m126A() {
        return this.ae == null ? true : this.ae.booleanValue();
    }

    public void m154a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f132F));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f133G));
        printWriter.print(" mTag=");
        printWriter.println(this.f134H);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f153k);
        printWriter.print(" mIndex=");
        printWriter.print(this.f158p);
        printWriter.print(" mWho=");
        printWriter.print(this.f159q);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f127A);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f164v);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f165w);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f166x);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f167y);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f135I);
        printWriter.print(" mDetached=");
        printWriter.print(this.f136J);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.f140N);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.f139M);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.f137K);
        printWriter.print(" mRetaining=");
        printWriter.print(this.f138L);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.f147U);
        if (this.f128B != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f128B);
        }
        if (this.f129C != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f129C);
        }
        if (this.f131E != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f131E);
        }
        if (this.f160r != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f160r);
        }
        if (this.f156n != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f156n);
        }
        if (this.f157o != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f157o);
        }
        if (this.f161s != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.f161s);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f163u);
        }
        if (this.f142P != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(this.f142P);
        }
        if (this.f143Q != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.f143Q);
        }
        if (this.f144R != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.f144R);
        }
        if (this.f145S != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.f144R);
        }
        if (this.f154l != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.f154l);
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.f155m);
        }
        if (this.f148V != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            this.f148V.m572a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.f130D != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.f130D + ":");
            this.f130D.mo80a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    Fragment m136a(String str) {
        if (str.equals(this.f159q)) {
            return this;
        }
        if (this.f130D != null) {
            return this.f130D.m502b(str);
        }
        return null;
    }

    void m127B() {
        this.f130D = new C0125q();
        this.f130D.m495a(this.f129C, new C00451(this), this);
    }

    void m179i(Bundle bundle) {
        if (this.f130D != null) {
            this.f130D.m523i();
        }
        this.f153k = 1;
        this.f141O = false;
        mo54a(bundle);
        if (!this.f141O) {
            throw new ao("Fragment " + this + " did not call through to super.onCreate()");
        } else if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            if (parcelable != null) {
                if (this.f130D == null) {
                    m127B();
                }
                this.f130D.m490a(parcelable, null);
                this.f130D.m524j();
            }
        }
    }

    View m157b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f130D != null) {
            this.f130D.m523i();
        }
        return mo894a(layoutInflater, viewGroup, bundle);
    }

    void m181j(Bundle bundle) {
        if (this.f130D != null) {
            this.f130D.m523i();
        }
        this.f153k = 2;
        this.f141O = false;
        mo59d(bundle);
        if (!this.f141O) {
            throw new ao("Fragment " + this + " did not call through to super.onActivityCreated()");
        } else if (this.f130D != null) {
            this.f130D.m525k();
        }
    }

    void m128C() {
        if (this.f130D != null) {
            this.f130D.m523i();
            this.f130D.m518e();
        }
        this.f153k = 4;
        this.f141O = false;
        mo57c();
        if (this.f141O) {
            if (this.f130D != null) {
                this.f130D.m526l();
            }
            if (this.f148V != null) {
                this.f148V.m579g();
                return;
            }
            return;
        }
        throw new ao("Fragment " + this + " did not call through to super.onStart()");
    }

    void m129D() {
        if (this.f130D != null) {
            this.f130D.m523i();
            this.f130D.m518e();
        }
        this.f153k = 5;
        this.f141O = false;
        m187o();
        if (!this.f141O) {
            throw new ao("Fragment " + this + " did not call through to super.onResume()");
        } else if (this.f130D != null) {
            this.f130D.m527m();
            this.f130D.m518e();
        }
    }

    void m149a(Configuration configuration) {
        onConfigurationChanged(configuration);
        if (this.f130D != null) {
            this.f130D.m488a(configuration);
        }
    }

    void m130E() {
        onLowMemory();
        if (this.f130D != null) {
            this.f130D.m533s();
        }
    }

    boolean m160b(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.f135I) {
            return false;
        }
        if (this.f139M && this.f140N) {
            z = true;
            m152a(menu, menuInflater);
        }
        if (this.f130D != null) {
            return z | this.f130D.m500a(menu, menuInflater);
        }
        return z;
    }

    boolean m164c(Menu menu) {
        boolean z = false;
        if (this.f135I) {
            return false;
        }
        if (this.f139M && this.f140N) {
            z = true;
            m151a(menu);
        }
        if (this.f130D != null) {
            return z | this.f130D.m499a(menu);
        }
        return z;
    }

    boolean m165c(MenuItem menuItem) {
        if (!this.f135I) {
            if (this.f139M && this.f140N && m155a(menuItem)) {
                return true;
            }
            if (this.f130D != null && this.f130D.m501a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    boolean m169d(MenuItem menuItem) {
        if (!this.f135I) {
            if (m161b(menuItem)) {
                return true;
            }
            if (this.f130D != null && this.f130D.m509b(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void m168d(Menu menu) {
        if (!this.f135I) {
            if (this.f139M && this.f140N) {
                m159b(menu);
            }
            if (this.f130D != null) {
                this.f130D.m507b(menu);
            }
        }
    }

    void m183k(Bundle bundle) {
        mo61e(bundle);
        if (this.f130D != null) {
            Parcelable h = this.f130D.m522h();
            if (h != null) {
                bundle.putParcelable("android:support:fragments", h);
            }
        }
    }

    void m131F() {
        if (this.f130D != null) {
            this.f130D.m528n();
        }
        this.f153k = 4;
        this.f141O = false;
        m188p();
        if (!this.f141O) {
            throw new ao("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    void m132G() {
        if (this.f130D != null) {
            this.f130D.m529o();
        }
        this.f153k = 3;
        this.f141O = false;
        mo58d();
        if (!this.f141O) {
            throw new ao("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    void m133H() {
        if (this.f130D != null) {
            this.f130D.m530p();
        }
        this.f153k = 2;
        if (this.f149W) {
            this.f149W = false;
            if (!this.f150X) {
                this.f150X = true;
                this.f148V = this.f129C.m381a(this.f159q, this.f149W, false);
            }
            if (this.f148V == null) {
                return;
            }
            if (this.f129C.m400j()) {
                this.f148V.m576d();
            } else {
                this.f148V.m575c();
            }
        }
    }

    void m134I() {
        if (this.f130D != null) {
            this.f130D.m531q();
        }
        this.f153k = 1;
        this.f141O = false;
        mo60e();
        if (!this.f141O) {
            throw new ao("Fragment " + this + " did not call through to super.onDestroyView()");
        } else if (this.f148V != null) {
            this.f148V.m578f();
        }
    }

    void m135J() {
        if (this.f130D != null) {
            this.f130D.m532r();
        }
        this.f153k = 0;
        this.f141O = false;
        mo893q();
        if (!this.f141O) {
            throw new ao("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }
}
