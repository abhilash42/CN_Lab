package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.C0104g.C0102b;
import android.support.v4.app.C0116p.C0115a;
import android.support.v4.p009e.C0191c;
import android.support.v4.p009e.C0192d;
import android.support.v4.view.C0124m;
import android.support.v4.view.ag;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: FragmentManager */
final class C0125q extends C0116p implements C0124m {
    static final Interpolator f357A = new DecelerateInterpolator(2.5f);
    static final Interpolator f358B = new DecelerateInterpolator(1.5f);
    static final Interpolator f359C = new AccelerateInterpolator(2.5f);
    static final Interpolator f360D = new AccelerateInterpolator(1.5f);
    static boolean f361a = false;
    static final boolean f362b;
    static Field f363r = null;
    ArrayList<Runnable> f364c;
    Runnable[] f365d;
    boolean f366e;
    ArrayList<Fragment> f367f;
    ArrayList<Fragment> f368g;
    ArrayList<Integer> f369h;
    ArrayList<C0104g> f370i;
    ArrayList<Fragment> f371j;
    ArrayList<C0104g> f372k;
    ArrayList<Integer> f373l;
    ArrayList<C0115a> f374m;
    int f375n = 0;
    C0110o f376o;
    C0044m f377p;
    Fragment f378q;
    boolean f379s;
    boolean f380t;
    boolean f381u;
    String f382v;
    boolean f383w;
    Bundle f384x = null;
    SparseArray<Parcelable> f385y = null;
    Runnable f386z = new C01171(this);

    /* compiled from: FragmentManager */
    class C01171 implements Runnable {
        final /* synthetic */ C0125q f345a;

        C01171(C0125q c0125q) {
            this.f345a = c0125q;
        }

        public void run() {
            this.f345a.m518e();
        }
    }

    /* compiled from: FragmentManager */
    static class C0119a implements AnimationListener {
        private AnimationListener f349a = null;
        private boolean f350b = false;
        private View f351c = null;

        /* compiled from: FragmentManager */
        class C01211 implements Runnable {
            final /* synthetic */ C0119a f354a;

            C01211(C0119a c0119a) {
                this.f354a = c0119a;
            }

            public void run() {
                ag.m1264a(this.f354a.f351c, 2, null);
            }
        }

        /* compiled from: FragmentManager */
        class C01222 implements Runnable {
            final /* synthetic */ C0119a f355a;

            C01222(C0119a c0119a) {
                this.f355a = c0119a;
            }

            public void run() {
                ag.m1264a(this.f355a.f351c, 0, null);
            }
        }

        public C0119a(View view, Animation animation) {
            if (view != null && animation != null) {
                this.f351c = view;
            }
        }

        public C0119a(View view, Animation animation, AnimationListener animationListener) {
            if (view != null && animation != null) {
                this.f349a = animationListener;
                this.f351c = view;
            }
        }

        public void onAnimationStart(Animation animation) {
            if (this.f351c != null) {
                this.f350b = C0125q.m471a(this.f351c, animation);
                if (this.f350b) {
                    this.f351c.post(new C01211(this));
                }
            }
            if (this.f349a != null) {
                this.f349a.onAnimationStart(animation);
            }
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f351c != null && this.f350b) {
                this.f351c.post(new C01222(this));
            }
            if (this.f349a != null) {
                this.f349a.onAnimationEnd(animation);
            }
        }

        public void onAnimationRepeat(Animation animation) {
            if (this.f349a != null) {
                this.f349a.onAnimationRepeat(animation);
            }
        }
    }

    /* compiled from: FragmentManager */
    static class C0123b {
        public static final int[] f356a = new int[]{16842755, 16842960, 16842961};
    }

    C0125q() {
    }

    static {
        boolean z = false;
        if (VERSION.SDK_INT >= 11) {
            z = true;
        }
        f362b = z;
    }

    static boolean m472a(Animation animation) {
        if (animation instanceof AlphaAnimation) {
            return true;
        }
        if (!(animation instanceof AnimationSet)) {
            return false;
        }
        List animations = ((AnimationSet) animation).getAnimations();
        for (int i = 0; i < animations.size(); i++) {
            if (animations.get(i) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    static boolean m471a(View view, Animation animation) {
        return VERSION.SDK_INT >= 19 && ag.m1281d(view) == 0 && ag.m1295q(view) && C0125q.m472a(animation);
    }

    private void m470a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new C0192d("FragmentManager"));
        if (this.f376o != null) {
            try {
                this.f376o.mo63a("  ", null, printWriter, new String[0]);
            } catch (Throwable e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                mo80a("  ", null, printWriter, new String[0]);
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    public C0103r mo77a() {
        return new C0104g(this);
    }

    public boolean m512c() {
        return m518e();
    }

    public boolean mo81b() {
        m476u();
        m512c();
        return m498a(this.f376o.m398h(), null, -1, 0);
    }

    public void mo79a(final int i, final int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        m496a(new Runnable(this) {
            final /* synthetic */ C0125q f348c;

            public void run() {
                this.f348c.m498a(this.f348c.f376o.m398h(), null, i, i2);
            }
        }, false);
    }

    public void m489a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.f158p < 0) {
            m470a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.f158p);
    }

    public Fragment m479a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.f367f.size()) {
            m470a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        }
        Fragment fragment = (Fragment) this.f367f.get(i);
        if (fragment != null) {
            return fragment;
        }
        m470a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        return fragment;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.f378q != null) {
            C0191c.m779a(this.f378q, stringBuilder);
        } else {
            C0191c.m779a(this.f376o, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void mo80a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        Fragment fragment;
        int i2 = 0;
        String str2 = str + "    ";
        if (this.f367f != null) {
            size = this.f367f.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f367f.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment);
                    if (fragment != null) {
                        fragment.m154a(str2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        if (this.f368g != null) {
            size = this.f368g.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f368g.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.f371j != null) {
            size = this.f371j.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f371j.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.f370i != null) {
            size = this.f370i.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    C0104g c0104g = (C0104g) this.f370i.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0104g.toString());
                    c0104g.m361a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        synchronized (this) {
            if (this.f372k != null) {
                int size2 = this.f372k.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (i = 0; i < size2; i++) {
                        c0104g = (C0104g) this.f372k.get(i);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(c0104g);
                    }
                }
            }
            if (this.f373l != null && this.f373l.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f373l.toArray()));
            }
        }
        if (this.f364c != null) {
            i = this.f364c.size();
            if (i > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < i) {
                    Runnable runnable = (Runnable) this.f364c.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(runnable);
                    i2++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f376o);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f377p);
        if (this.f378q != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f378q);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f375n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f380t);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f381u);
        if (this.f379s) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f379s);
        }
        if (this.f382v != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.f382v);
        }
        if (this.f369h != null && this.f369h.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.f369h.toArray()));
        }
    }

    static Animation m469a(Context context, float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f357A);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        scaleAnimation = new AlphaAnimation(f3, f4);
        scaleAnimation.setInterpolator(f358B);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    static Animation m468a(Context context, float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(f358B);
        alphaAnimation.setDuration(220);
        return alphaAnimation;
    }

    Animation m483a(Fragment fragment, int i, boolean z, int i2) {
        Animation a = fragment.m138a(i, z, fragment.f142P);
        if (a != null) {
            return a;
        }
        if (fragment.f142P != 0) {
            a = AnimationUtils.loadAnimation(this.f376o.m397g(), fragment.f142P);
            if (a != null) {
                return a;
            }
        }
        if (i == 0) {
            return null;
        }
        int b = C0125q.m473b(i, z);
        if (b < 0) {
            return null;
        }
        switch (b) {
            case 1:
                return C0125q.m469a(this.f376o.m397g(), 1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return C0125q.m469a(this.f376o.m397g(), 1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return C0125q.m469a(this.f376o.m397g(), 0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return C0125q.m469a(this.f376o.m397g(), 1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return C0125q.m468a(this.f376o.m397g(), 0.0f, 1.0f);
            case 6:
                return C0125q.m468a(this.f376o.m397g(), 1.0f, 0.0f);
            default:
                if (i2 == 0 && this.f376o.mo68d()) {
                    i2 = this.f376o.mo69e();
                }
                if (i2 == 0) {
                    return null;
                }
                return null;
        }
    }

    public void m491a(Fragment fragment) {
        if (!fragment.f146T) {
            return;
        }
        if (this.f366e) {
            this.f383w = true;
            return;
        }
        fragment.f146T = false;
        m493a(fragment, this.f375n, 0, 0, false);
    }

    private void m474b(View view, Animation animation) {
        if (view != null && animation != null && C0125q.m471a(view, animation)) {
            AnimationListener animationListener;
            try {
                if (f363r == null) {
                    f363r = Animation.class.getDeclaredField("mListener");
                    f363r.setAccessible(true);
                }
                animationListener = (AnimationListener) f363r.get(animation);
            } catch (Throwable e) {
                Log.e("FragmentManager", "No field with the name mListener is found in Animation class", e);
                animationListener = null;
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Cannot access Animation's mListener field", e2);
                animationListener = null;
            }
            animation.setAnimationListener(new C0119a(view, animation, animationListener));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m493a(final android.support.v4.app.Fragment r11, int r12, int r13, int r14, boolean r15) {
        /*
        r10 = this;
        r9 = 4;
        r6 = 3;
        r5 = 1;
        r3 = 0;
        r7 = 0;
        r0 = r11.f164v;
        if (r0 == 0) goto L_0x000d;
    L_0x0009:
        r0 = r11.f136J;
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        if (r12 <= r5) goto L_0x0010;
    L_0x000f:
        r12 = r5;
    L_0x0010:
        r0 = r11.f165w;
        if (r0 == 0) goto L_0x001a;
    L_0x0014:
        r0 = r11.f153k;
        if (r12 <= r0) goto L_0x001a;
    L_0x0018:
        r12 = r11.f153k;
    L_0x001a:
        r0 = r11.f146T;
        if (r0 == 0) goto L_0x0025;
    L_0x001e:
        r0 = r11.f153k;
        if (r0 >= r9) goto L_0x0025;
    L_0x0022:
        if (r12 <= r6) goto L_0x0025;
    L_0x0024:
        r12 = r6;
    L_0x0025:
        r0 = r11.f153k;
        if (r0 >= r12) goto L_0x02aa;
    L_0x0029:
        r0 = r11.f166x;
        if (r0 == 0) goto L_0x0032;
    L_0x002d:
        r0 = r11.f167y;
        if (r0 != 0) goto L_0x0032;
    L_0x0031:
        return;
    L_0x0032:
        r0 = r11.f154l;
        if (r0 == 0) goto L_0x0040;
    L_0x0036:
        r11.f154l = r7;
        r2 = r11.f155m;
        r0 = r10;
        r1 = r11;
        r4 = r3;
        r0.m493a(r1, r2, r3, r4, r5);
    L_0x0040:
        r0 = r11.f153k;
        switch(r0) {
            case 0: goto L_0x0080;
            case 1: goto L_0x0176;
            case 2: goto L_0x0247;
            case 3: goto L_0x0247;
            case 4: goto L_0x0268;
            default: goto L_0x0045;
        };
    L_0x0045:
        r0 = r11.f153k;
        if (r0 == r12) goto L_0x0031;
    L_0x0049:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveToState: Fragment state for ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " not updated inline; ";
        r1 = r1.append(r2);
        r2 = "expected state ";
        r1 = r1.append(r2);
        r1 = r1.append(r12);
        r2 = " found ";
        r1 = r1.append(r2);
        r2 = r11.f153k;
        r1 = r1.append(r2);
        r1 = r1.toString();
        android.util.Log.w(r0, r1);
        r11.f153k = r12;
        goto L_0x0031;
    L_0x0080:
        r0 = f361a;
        if (r0 == 0) goto L_0x009c;
    L_0x0084:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x009c:
        r0 = r11.f156n;
        if (r0 == 0) goto L_0x00e4;
    L_0x00a0:
        r0 = r11.f156n;
        r1 = r10.f376o;
        r1 = r1.m397g();
        r1 = r1.getClassLoader();
        r0.setClassLoader(r1);
        r0 = r11.f156n;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r11.f157o = r0;
        r0 = r11.f156n;
        r1 = "android:target_state";
        r0 = r10.m479a(r0, r1);
        r11.f161s = r0;
        r0 = r11.f161s;
        if (r0 == 0) goto L_0x00d1;
    L_0x00c7:
        r0 = r11.f156n;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r3);
        r11.f163u = r0;
    L_0x00d1:
        r0 = r11.f156n;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r5);
        r11.f147U = r0;
        r0 = r11.f147U;
        if (r0 != 0) goto L_0x00e4;
    L_0x00df:
        r11.f146T = r5;
        if (r12 <= r6) goto L_0x00e4;
    L_0x00e3:
        r12 = r6;
    L_0x00e4:
        r0 = r10.f376o;
        r11.f129C = r0;
        r0 = r10.f378q;
        r11.f131E = r0;
        r0 = r10.f378q;
        if (r0 == 0) goto L_0x0124;
    L_0x00f0:
        r0 = r10.f378q;
        r0 = r0.f130D;
    L_0x00f4:
        r11.f128B = r0;
        r11.f141O = r3;
        r0 = r10.f376o;
        r0 = r0.m397g();
        r11.mo891a(r0);
        r0 = r11.f141O;
        if (r0 != 0) goto L_0x012b;
    L_0x0105:
        r0 = new android.support.v4.app.ao;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onAttach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0124:
        r0 = r10.f376o;
        r0 = r0.m399i();
        goto L_0x00f4;
    L_0x012b:
        r0 = r11.f131E;
        if (r0 != 0) goto L_0x0134;
    L_0x012f:
        r0 = r10.f376o;
        r0.mo66b(r11);
    L_0x0134:
        r0 = r11.f138L;
        if (r0 != 0) goto L_0x013d;
    L_0x0138:
        r0 = r11.f156n;
        r11.m179i(r0);
    L_0x013d:
        r11.f138L = r3;
        r0 = r11.f166x;
        if (r0 == 0) goto L_0x0176;
    L_0x0143:
        r0 = r11.f156n;
        r0 = r11.mo55b(r0);
        r1 = r11.f156n;
        r0 = r11.m157b(r0, r7, r1);
        r11.f144R = r0;
        r0 = r11.f144R;
        if (r0 == 0) goto L_0x0299;
    L_0x0155:
        r0 = r11.f144R;
        r11.f145S = r0;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 11;
        if (r0 < r1) goto L_0x028f;
    L_0x015f:
        r0 = r11.f144R;
        android.support.v4.view.ag.m1271a(r0, r3);
    L_0x0164:
        r0 = r11.f135I;
        if (r0 == 0) goto L_0x016f;
    L_0x0168:
        r0 = r11.f144R;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x016f:
        r0 = r11.f144R;
        r1 = r11.f156n;
        r11.mo892a(r0, r1);
    L_0x0176:
        if (r12 <= r5) goto L_0x0247;
    L_0x0178:
        r0 = f361a;
        if (r0 == 0) goto L_0x0194;
    L_0x017c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0194:
        r0 = r11.f166x;
        if (r0 != 0) goto L_0x0237;
    L_0x0198:
        r0 = r11.f133G;
        if (r0 == 0) goto L_0x0408;
    L_0x019c:
        r0 = r10.f377p;
        r1 = r11.f133G;
        r0 = r0.mo27a(r1);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x01eb;
    L_0x01a8:
        r1 = r11.f168z;
        if (r1 != 0) goto L_0x01eb;
    L_0x01ac:
        r1 = new java.lang.IllegalArgumentException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r4 = "No view found for id 0x";
        r2 = r2.append(r4);
        r4 = r11.f133G;
        r4 = java.lang.Integer.toHexString(r4);
        r2 = r2.append(r4);
        r4 = " (";
        r2 = r2.append(r4);
        r4 = r11.m178i();
        r8 = r11.f133G;
        r4 = r4.getResourceName(r8);
        r2 = r2.append(r4);
        r4 = ") for fragment ";
        r2 = r2.append(r4);
        r2 = r2.append(r11);
        r2 = r2.toString();
        r1.<init>(r2);
        r10.m470a(r1);
    L_0x01eb:
        r11.f143Q = r0;
        r1 = r11.f156n;
        r1 = r11.mo55b(r1);
        r2 = r11.f156n;
        r1 = r11.m157b(r1, r0, r2);
        r11.f144R = r1;
        r1 = r11.f144R;
        if (r1 == 0) goto L_0x02a7;
    L_0x01ff:
        r1 = r11.f144R;
        r11.f145S = r1;
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 11;
        if (r1 < r2) goto L_0x029d;
    L_0x0209:
        r1 = r11.f144R;
        android.support.v4.view.ag.m1271a(r1, r3);
    L_0x020e:
        if (r0 == 0) goto L_0x0225;
    L_0x0210:
        r1 = r10.m483a(r11, r13, r5, r14);
        if (r1 == 0) goto L_0x0220;
    L_0x0216:
        r2 = r11.f144R;
        r10.m474b(r2, r1);
        r2 = r11.f144R;
        r2.startAnimation(r1);
    L_0x0220:
        r1 = r11.f144R;
        r0.addView(r1);
    L_0x0225:
        r0 = r11.f135I;
        if (r0 == 0) goto L_0x0230;
    L_0x0229:
        r0 = r11.f144R;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x0230:
        r0 = r11.f144R;
        r1 = r11.f156n;
        r11.mo892a(r0, r1);
    L_0x0237:
        r0 = r11.f156n;
        r11.m181j(r0);
        r0 = r11.f144R;
        if (r0 == 0) goto L_0x0245;
    L_0x0240:
        r0 = r11.f156n;
        r11.m172f(r0);
    L_0x0245:
        r11.f156n = r7;
    L_0x0247:
        if (r12 <= r6) goto L_0x0268;
    L_0x0249:
        r0 = f361a;
        if (r0 == 0) goto L_0x0265;
    L_0x024d:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0265:
        r11.m128C();
    L_0x0268:
        if (r12 <= r9) goto L_0x0045;
    L_0x026a:
        r0 = f361a;
        if (r0 == 0) goto L_0x0286;
    L_0x026e:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0286:
        r11.m129D();
        r11.f156n = r7;
        r11.f157o = r7;
        goto L_0x0045;
    L_0x028f:
        r0 = r11.f144R;
        r0 = android.support.v4.app.C0141x.m604a(r0);
        r11.f144R = r0;
        goto L_0x0164;
    L_0x0299:
        r11.f145S = r7;
        goto L_0x0176;
    L_0x029d:
        r1 = r11.f144R;
        r1 = android.support.v4.app.C0141x.m604a(r1);
        r11.f144R = r1;
        goto L_0x020e;
    L_0x02a7:
        r11.f145S = r7;
        goto L_0x0237;
    L_0x02aa:
        r0 = r11.f153k;
        if (r0 <= r12) goto L_0x0045;
    L_0x02ae:
        r0 = r11.f153k;
        switch(r0) {
            case 1: goto L_0x02b5;
            case 2: goto L_0x0333;
            case 3: goto L_0x0312;
            case 4: goto L_0x02f1;
            case 5: goto L_0x02cf;
            default: goto L_0x02b3;
        };
    L_0x02b3:
        goto L_0x0045;
    L_0x02b5:
        if (r12 >= r5) goto L_0x0045;
    L_0x02b7:
        r0 = r10.f381u;
        if (r0 == 0) goto L_0x02c6;
    L_0x02bb:
        r0 = r11.f154l;
        if (r0 == 0) goto L_0x02c6;
    L_0x02bf:
        r0 = r11.f154l;
        r11.f154l = r7;
        r0.clearAnimation();
    L_0x02c6:
        r0 = r11.f154l;
        if (r0 == 0) goto L_0x03a2;
    L_0x02ca:
        r11.f155m = r12;
        r12 = r5;
        goto L_0x0045;
    L_0x02cf:
        r0 = 5;
        if (r12 >= r0) goto L_0x02f1;
    L_0x02d2:
        r0 = f361a;
        if (r0 == 0) goto L_0x02ee;
    L_0x02d6:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02ee:
        r11.m131F();
    L_0x02f1:
        if (r12 >= r9) goto L_0x0312;
    L_0x02f3:
        r0 = f361a;
        if (r0 == 0) goto L_0x030f;
    L_0x02f7:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x030f:
        r11.m132G();
    L_0x0312:
        if (r12 >= r6) goto L_0x0333;
    L_0x0314:
        r0 = f361a;
        if (r0 == 0) goto L_0x0330;
    L_0x0318:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STOPPED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0330:
        r11.m133H();
    L_0x0333:
        r0 = 2;
        if (r12 >= r0) goto L_0x02b5;
    L_0x0336:
        r0 = f361a;
        if (r0 == 0) goto L_0x0352;
    L_0x033a:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0352:
        r0 = r11.f144R;
        if (r0 == 0) goto L_0x0365;
    L_0x0356:
        r0 = r10.f376o;
        r0 = r0.mo64a(r11);
        if (r0 == 0) goto L_0x0365;
    L_0x035e:
        r0 = r11.f157o;
        if (r0 != 0) goto L_0x0365;
    L_0x0362:
        r10.m516e(r11);
    L_0x0365:
        r11.m134I();
        r0 = r11.f144R;
        if (r0 == 0) goto L_0x039a;
    L_0x036c:
        r0 = r11.f143Q;
        if (r0 == 0) goto L_0x039a;
    L_0x0370:
        r0 = r10.f375n;
        if (r0 <= 0) goto L_0x0405;
    L_0x0374:
        r0 = r10.f381u;
        if (r0 != 0) goto L_0x0405;
    L_0x0378:
        r0 = r10.m483a(r11, r13, r3, r14);
    L_0x037c:
        if (r0 == 0) goto L_0x0393;
    L_0x037e:
        r1 = r11.f144R;
        r11.f154l = r1;
        r11.f155m = r12;
        r1 = r11.f144R;
        r2 = new android.support.v4.app.q$3;
        r2.<init>(r10, r1, r0, r11);
        r0.setAnimationListener(r2);
        r1 = r11.f144R;
        r1.startAnimation(r0);
    L_0x0393:
        r0 = r11.f143Q;
        r1 = r11.f144R;
        r0.removeView(r1);
    L_0x039a:
        r11.f143Q = r7;
        r11.f144R = r7;
        r11.f145S = r7;
        goto L_0x02b5;
    L_0x03a2:
        r0 = f361a;
        if (r0 == 0) goto L_0x03be;
    L_0x03a6:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x03be:
        r0 = r11.f138L;
        if (r0 != 0) goto L_0x03ed;
    L_0x03c2:
        r11.m135J();
    L_0x03c5:
        r11.f141O = r3;
        r11.mo56b();
        r0 = r11.f141O;
        if (r0 != 0) goto L_0x03f0;
    L_0x03ce:
        r0 = new android.support.v4.app.ao;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onDetach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x03ed:
        r11.f153k = r3;
        goto L_0x03c5;
    L_0x03f0:
        if (r15 != 0) goto L_0x0045;
    L_0x03f2:
        r0 = r11.f138L;
        if (r0 != 0) goto L_0x03fb;
    L_0x03f6:
        r10.m514d(r11);
        goto L_0x0045;
    L_0x03fb:
        r11.f129C = r7;
        r11.f131E = r7;
        r11.f128B = r7;
        r11.f130D = r7;
        goto L_0x0045;
    L_0x0405:
        r0 = r7;
        goto L_0x037c;
    L_0x0408:
        r0 = r7;
        goto L_0x01eb;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.q.a(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    void m504b(Fragment fragment) {
        m493a(fragment, this.f375n, 0, 0, false);
    }

    void m487a(int i, boolean z) {
        m485a(i, 0, 0, z);
    }

    void m485a(int i, int i2, int i3, boolean z) {
        if (this.f376o == null && i != 0) {
            throw new IllegalStateException("No host");
        } else if (z || this.f375n != i) {
            this.f375n = i;
            if (this.f367f != null) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < this.f367f.size()) {
                    int a;
                    Fragment fragment = (Fragment) this.f367f.get(i4);
                    if (fragment != null) {
                        m493a(fragment, i, i2, i3, false);
                        if (fragment.f148V != null) {
                            a = i5 | fragment.f148V.mo82a();
                            i4++;
                            i5 = a;
                        }
                    }
                    a = i5;
                    i4++;
                    i5 = a;
                }
                if (i5 == 0) {
                    m513d();
                }
                if (this.f379s && this.f376o != null && this.f375n == 5) {
                    this.f376o.mo67c();
                    this.f379s = false;
                }
            }
        }
    }

    void m513d() {
        if (this.f367f != null) {
            for (int i = 0; i < this.f367f.size(); i++) {
                Fragment fragment = (Fragment) this.f367f.get(i);
                if (fragment != null) {
                    m491a(fragment);
                }
            }
        }
    }

    void m510c(Fragment fragment) {
        if (fragment.f158p < 0) {
            if (this.f369h == null || this.f369h.size() <= 0) {
                if (this.f367f == null) {
                    this.f367f = new ArrayList();
                }
                fragment.m141a(this.f367f.size(), this.f378q);
                this.f367f.add(fragment);
            } else {
                fragment.m141a(((Integer) this.f369h.remove(this.f369h.size() - 1)).intValue(), this.f378q);
                this.f367f.set(fragment.f158p, fragment);
            }
            if (f361a) {
                Log.v("FragmentManager", "Allocated fragment index " + fragment);
            }
        }
    }

    void m514d(Fragment fragment) {
        if (fragment.f158p >= 0) {
            if (f361a) {
                Log.v("FragmentManager", "Freeing fragment index " + fragment);
            }
            this.f367f.set(fragment.f158p, null);
            if (this.f369h == null) {
                this.f369h = new ArrayList();
            }
            this.f369h.add(Integer.valueOf(fragment.f158p));
            this.f376o.m385a(fragment.f159q);
            fragment.m190r();
        }
    }

    public void m494a(Fragment fragment, boolean z) {
        if (this.f368g == null) {
            this.f368g = new ArrayList();
        }
        if (f361a) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        m510c(fragment);
        if (!fragment.f136J) {
            if (this.f368g.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            this.f368g.add(fragment);
            fragment.f164v = true;
            fragment.f165w = false;
            if (fragment.f139M && fragment.f140N) {
                this.f379s = true;
            }
            if (z) {
                m504b(fragment);
            }
        }
    }

    public void m492a(Fragment fragment, int i, int i2) {
        if (f361a) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.f127A);
        }
        boolean z = !fragment.m173f();
        if (!fragment.f136J || z) {
            int i3;
            if (this.f368g != null) {
                this.f368g.remove(fragment);
            }
            if (fragment.f139M && fragment.f140N) {
                this.f379s = true;
            }
            fragment.f164v = false;
            fragment.f165w = true;
            if (z) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            m493a(fragment, i3, i, i2, false);
        }
    }

    public void m505b(Fragment fragment, int i, int i2) {
        if (f361a) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.f135I) {
            fragment.f135I = true;
            if (fragment.f144R != null) {
                Animation a = m483a(fragment, i, false, i2);
                if (a != null) {
                    m474b(fragment.f144R, a);
                    fragment.f144R.startAnimation(a);
                }
                fragment.f144R.setVisibility(8);
            }
            if (fragment.f164v && fragment.f139M && fragment.f140N) {
                this.f379s = true;
            }
            fragment.m163c(true);
        }
    }

    public void m511c(Fragment fragment, int i, int i2) {
        if (f361a) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.f135I) {
            fragment.f135I = false;
            if (fragment.f144R != null) {
                Animation a = m483a(fragment, i, true, i2);
                if (a != null) {
                    m474b(fragment.f144R, a);
                    fragment.f144R.startAnimation(a);
                }
                fragment.f144R.setVisibility(0);
            }
            if (fragment.f164v && fragment.f139M && fragment.f140N) {
                this.f379s = true;
            }
            fragment.m163c(false);
        }
    }

    public void m515d(Fragment fragment, int i, int i2) {
        if (f361a) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.f136J) {
            fragment.f136J = true;
            if (fragment.f164v) {
                if (this.f368g != null) {
                    if (f361a) {
                        Log.v("FragmentManager", "remove from detach: " + fragment);
                    }
                    this.f368g.remove(fragment);
                }
                if (fragment.f139M && fragment.f140N) {
                    this.f379s = true;
                }
                fragment.f164v = false;
                m493a(fragment, 1, i, i2, false);
            }
        }
    }

    public void m517e(Fragment fragment, int i, int i2) {
        if (f361a) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.f136J) {
            fragment.f136J = false;
            if (!fragment.f164v) {
                if (this.f368g == null) {
                    this.f368g = new ArrayList();
                }
                if (this.f368g.contains(fragment)) {
                    throw new IllegalStateException("Fragment already added: " + fragment);
                }
                if (f361a) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                this.f368g.add(fragment);
                fragment.f164v = true;
                if (fragment.f139M && fragment.f140N) {
                    this.f379s = true;
                }
                m493a(fragment, this.f375n, i, i2, false);
            }
        }
    }

    public Fragment m478a(int i) {
        int size;
        Fragment fragment;
        if (this.f368g != null) {
            for (size = this.f368g.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f368g.get(size);
                if (fragment != null && fragment.f132F == i) {
                    return fragment;
                }
            }
        }
        if (this.f367f != null) {
            for (size = this.f367f.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f367f.get(size);
                if (fragment != null && fragment.f132F == i) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public Fragment m480a(String str) {
        int size;
        Fragment fragment;
        if (!(this.f368g == null || str == null)) {
            for (size = this.f368g.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f368g.get(size);
                if (fragment != null && str.equals(fragment.f134H)) {
                    return fragment;
                }
            }
        }
        if (!(this.f367f == null || str == null)) {
            for (size = this.f367f.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f367f.get(size);
                if (fragment != null && str.equals(fragment.f134H)) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public Fragment m502b(String str) {
        if (!(this.f367f == null || str == null)) {
            for (int size = this.f367f.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.f367f.get(size);
                if (fragment != null) {
                    fragment = fragment.m136a(str);
                    if (fragment != null) {
                        return fragment;
                    }
                }
            }
        }
        return null;
    }

    private void m476u() {
        if (this.f380t) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.f382v != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.f382v);
        }
    }

    public void m496a(Runnable runnable, boolean z) {
        if (!z) {
            m476u();
        }
        synchronized (this) {
            if (this.f381u || this.f376o == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.f364c == null) {
                this.f364c = new ArrayList();
            }
            this.f364c.add(runnable);
            if (this.f364c.size() == 1) {
                this.f376o.m398h().removeCallbacks(this.f386z);
                this.f376o.m398h().post(this.f386z);
            }
        }
    }

    public int m477a(C0104g c0104g) {
        int size;
        synchronized (this) {
            if (this.f373l == null || this.f373l.size() <= 0) {
                if (this.f372k == null) {
                    this.f372k = new ArrayList();
                }
                size = this.f372k.size();
                if (f361a) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + c0104g);
                }
                this.f372k.add(c0104g);
            } else {
                size = ((Integer) this.f373l.remove(this.f373l.size() - 1)).intValue();
                if (f361a) {
                    Log.v("FragmentManager", "Adding back stack index " + size + " with " + c0104g);
                }
                this.f372k.set(size, c0104g);
            }
        }
        return size;
    }

    public void m486a(int i, C0104g c0104g) {
        synchronized (this) {
            if (this.f372k == null) {
                this.f372k = new ArrayList();
            }
            int size = this.f372k.size();
            if (i < size) {
                if (f361a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + c0104g);
                }
                this.f372k.set(i, c0104g);
            } else {
                while (size < i) {
                    this.f372k.add(null);
                    if (this.f373l == null) {
                        this.f373l = new ArrayList();
                    }
                    if (f361a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f373l.add(Integer.valueOf(size));
                    size++;
                }
                if (f361a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + c0104g);
                }
                this.f372k.add(c0104g);
            }
        }
    }

    public void m503b(int i) {
        synchronized (this) {
            this.f372k.set(i, null);
            if (this.f373l == null) {
                this.f373l = new ArrayList();
            }
            if (f361a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.f373l.add(Integer.valueOf(i));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m518e() {
        /*
        r6 = this;
        r0 = 1;
        r2 = 0;
        r1 = r6.f366e;
        if (r1 == 0) goto L_0x000e;
    L_0x0006:
        r0 = new java.lang.IllegalStateException;
        r1 = "Recursive entry to executePendingTransactions";
        r0.<init>(r1);
        throw r0;
    L_0x000e:
        r1 = android.os.Looper.myLooper();
        r3 = r6.f376o;
        r3 = r3.m398h();
        r3 = r3.getLooper();
        if (r1 == r3) goto L_0x0026;
    L_0x001e:
        r0 = new java.lang.IllegalStateException;
        r1 = "Must be called from main thread of process";
        r0.<init>(r1);
        throw r0;
    L_0x0026:
        r1 = r2;
    L_0x0027:
        monitor-enter(r6);
        r3 = r6.f364c;	 Catch:{ all -> 0x009b }
        if (r3 == 0) goto L_0x0034;
    L_0x002c:
        r3 = r6.f364c;	 Catch:{ all -> 0x009b }
        r3 = r3.size();	 Catch:{ all -> 0x009b }
        if (r3 != 0) goto L_0x005c;
    L_0x0034:
        monitor-exit(r6);	 Catch:{ all -> 0x009b }
        r0 = r6.f383w;
        if (r0 == 0) goto L_0x00a9;
    L_0x0039:
        r3 = r2;
        r4 = r2;
    L_0x003b:
        r0 = r6.f367f;
        r0 = r0.size();
        if (r3 >= r0) goto L_0x00a2;
    L_0x0043:
        r0 = r6.f367f;
        r0 = r0.get(r3);
        r0 = (android.support.v4.app.Fragment) r0;
        if (r0 == 0) goto L_0x0058;
    L_0x004d:
        r5 = r0.f148V;
        if (r5 == 0) goto L_0x0058;
    L_0x0051:
        r0 = r0.f148V;
        r0 = r0.mo82a();
        r4 = r4 | r0;
    L_0x0058:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x003b;
    L_0x005c:
        r1 = r6.f364c;	 Catch:{ all -> 0x009b }
        r3 = r1.size();	 Catch:{ all -> 0x009b }
        r1 = r6.f365d;	 Catch:{ all -> 0x009b }
        if (r1 == 0) goto L_0x006b;
    L_0x0066:
        r1 = r6.f365d;	 Catch:{ all -> 0x009b }
        r1 = r1.length;	 Catch:{ all -> 0x009b }
        if (r1 >= r3) goto L_0x006f;
    L_0x006b:
        r1 = new java.lang.Runnable[r3];	 Catch:{ all -> 0x009b }
        r6.f365d = r1;	 Catch:{ all -> 0x009b }
    L_0x006f:
        r1 = r6.f364c;	 Catch:{ all -> 0x009b }
        r4 = r6.f365d;	 Catch:{ all -> 0x009b }
        r1.toArray(r4);	 Catch:{ all -> 0x009b }
        r1 = r6.f364c;	 Catch:{ all -> 0x009b }
        r1.clear();	 Catch:{ all -> 0x009b }
        r1 = r6.f376o;	 Catch:{ all -> 0x009b }
        r1 = r1.m398h();	 Catch:{ all -> 0x009b }
        r4 = r6.f386z;	 Catch:{ all -> 0x009b }
        r1.removeCallbacks(r4);	 Catch:{ all -> 0x009b }
        monitor-exit(r6);	 Catch:{ all -> 0x009b }
        r6.f366e = r0;
        r1 = r2;
    L_0x008a:
        if (r1 >= r3) goto L_0x009e;
    L_0x008c:
        r4 = r6.f365d;
        r4 = r4[r1];
        r4.run();
        r4 = r6.f365d;
        r5 = 0;
        r4[r1] = r5;
        r1 = r1 + 1;
        goto L_0x008a;
    L_0x009b:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x009b }
        throw r0;
    L_0x009e:
        r6.f366e = r2;
        r1 = r0;
        goto L_0x0027;
    L_0x00a2:
        if (r4 != 0) goto L_0x00a9;
    L_0x00a4:
        r6.f383w = r2;
        r6.m513d();
    L_0x00a9:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.q.e():boolean");
    }

    void m520f() {
        if (this.f374m != null) {
            for (int i = 0; i < this.f374m.size(); i++) {
                ((C0115a) this.f374m.get(i)).m461a();
            }
        }
    }

    void m506b(C0104g c0104g) {
        if (this.f370i == null) {
            this.f370i = new ArrayList();
        }
        this.f370i.add(c0104g);
        m520f();
    }

    boolean m498a(Handler handler, String str, int i, int i2) {
        if (this.f370i == null) {
            return false;
        }
        int size;
        C0104g c0104g;
        if (str == null && i < 0 && (i2 & 1) == 0) {
            size = this.f370i.size() - 1;
            if (size < 0) {
                return false;
            }
            c0104g = (C0104g) this.f370i.remove(size);
            SparseArray sparseArray = new SparseArray();
            SparseArray sparseArray2 = new SparseArray();
            c0104g.m360a(sparseArray, sparseArray2);
            c0104g.m352a(true, null, sparseArray, sparseArray2);
            m520f();
        } else {
            int size2;
            size = -1;
            if (str != null || i >= 0) {
                size2 = this.f370i.size() - 1;
                while (size2 >= 0) {
                    c0104g = (C0104g) this.f370i.get(size2);
                    if ((str != null && str.equals(c0104g.m364c())) || (i >= 0 && i == c0104g.f301p)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size2--;
                    while (size2 >= 0) {
                        c0104g = (C0104g) this.f370i.get(size2);
                        if ((str == null || !str.equals(c0104g.m364c())) && (i < 0 || i != c0104g.f301p)) {
                            break;
                        }
                        size2--;
                    }
                }
                size = size2;
            }
            if (size == this.f370i.size() - 1) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (size2 = this.f370i.size() - 1; size2 > size; size2--) {
                arrayList.add(this.f370i.remove(size2));
            }
            int size3 = arrayList.size() - 1;
            SparseArray sparseArray3 = new SparseArray();
            SparseArray sparseArray4 = new SparseArray();
            for (size2 = 0; size2 <= size3; size2++) {
                ((C0104g) arrayList.get(size2)).m360a(sparseArray3, sparseArray4);
            }
            C0102b c0102b = null;
            int i3 = 0;
            while (i3 <= size3) {
                boolean z;
                if (f361a) {
                    Log.v("FragmentManager", "Popping back stack state: " + arrayList.get(i3));
                }
                c0104g = (C0104g) arrayList.get(i3);
                if (i3 == size3) {
                    z = true;
                } else {
                    z = false;
                }
                i3++;
                c0102b = c0104g.m352a(z, c0102b, sparseArray3, sparseArray4);
            }
            m520f();
        }
        return true;
    }

    ArrayList<Fragment> m521g() {
        ArrayList<Fragment> arrayList = null;
        if (this.f367f != null) {
            for (int i = 0; i < this.f367f.size(); i++) {
                Fragment fragment = (Fragment) this.f367f.get(i);
                if (fragment != null && fragment.f137K) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                    fragment.f138L = true;
                    fragment.f162t = fragment.f161s != null ? fragment.f161s.f158p : -1;
                    if (f361a) {
                        Log.v("FragmentManager", "retainNonConfig: keeping retained " + fragment);
                    }
                }
            }
        }
        return arrayList;
    }

    void m516e(Fragment fragment) {
        if (fragment.f145S != null) {
            if (this.f385y == null) {
                this.f385y = new SparseArray();
            } else {
                this.f385y.clear();
            }
            fragment.f145S.saveHierarchyState(this.f385y);
            if (this.f385y.size() > 0) {
                fragment.f157o = this.f385y;
                this.f385y = null;
            }
        }
    }

    Bundle m519f(Fragment fragment) {
        Bundle bundle;
        if (this.f384x == null) {
            this.f384x = new Bundle();
        }
        fragment.m183k(this.f384x);
        if (this.f384x.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.f384x;
            this.f384x = null;
        }
        if (fragment.f144R != null) {
            m516e(fragment);
        }
        if (fragment.f157o != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.f157o);
        }
        if (!fragment.f147U) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.f147U);
        }
        return bundle;
    }

    Parcelable m522h() {
        BackStackState[] backStackStateArr = null;
        m518e();
        if (f362b) {
            this.f380t = true;
        }
        if (this.f367f == null || this.f367f.size() <= 0) {
            return null;
        }
        int size = this.f367f.size();
        FragmentState[] fragmentStateArr = new FragmentState[size];
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            Fragment fragment = (Fragment) this.f367f.get(i);
            if (fragment != null) {
                if (fragment.f158p < 0) {
                    m470a(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.f158p));
                }
                FragmentState fragmentState = new FragmentState(fragment);
                fragmentStateArr[i] = fragmentState;
                if (fragment.f153k <= 0 || fragmentState.f181j != null) {
                    fragmentState.f181j = fragment.f156n;
                } else {
                    fragmentState.f181j = m519f(fragment);
                    if (fragment.f161s != null) {
                        if (fragment.f161s.f158p < 0) {
                            m470a(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.f161s));
                        }
                        if (fragmentState.f181j == null) {
                            fragmentState.f181j = new Bundle();
                        }
                        m489a(fragmentState.f181j, "android:target_state", fragment.f161s);
                        if (fragment.f163u != 0) {
                            fragmentState.f181j.putInt("android:target_req_state", fragment.f163u);
                        }
                    }
                }
                if (f361a) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragmentState.f181j);
                }
                z2 = true;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        if (z) {
            int[] iArr;
            int i2;
            FragmentManagerState fragmentManagerState;
            if (this.f368g != null) {
                i = this.f368g.size();
                if (i > 0) {
                    iArr = new int[i];
                    for (i2 = 0; i2 < i; i2++) {
                        iArr[i2] = ((Fragment) this.f368g.get(i2)).f158p;
                        if (iArr[i2] < 0) {
                            m470a(new IllegalStateException("Failure saving state: active " + this.f368g.get(i2) + " has cleared index: " + iArr[i2]));
                        }
                        if (f361a) {
                            Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.f368g.get(i2));
                        }
                    }
                    if (this.f370i != null) {
                        i = this.f370i.size();
                        if (i > 0) {
                            backStackStateArr = new BackStackState[i];
                            for (i2 = 0; i2 < i; i2++) {
                                backStackStateArr[i2] = new BackStackState((C0104g) this.f370i.get(i2));
                                if (f361a) {
                                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f370i.get(i2));
                                }
                            }
                        }
                    }
                    fragmentManagerState = new FragmentManagerState();
                    fragmentManagerState.f169a = fragmentStateArr;
                    fragmentManagerState.f170b = iArr;
                    fragmentManagerState.f171c = backStackStateArr;
                    return fragmentManagerState;
                }
            }
            iArr = null;
            if (this.f370i != null) {
                i = this.f370i.size();
                if (i > 0) {
                    backStackStateArr = new BackStackState[i];
                    for (i2 = 0; i2 < i; i2++) {
                        backStackStateArr[i2] = new BackStackState((C0104g) this.f370i.get(i2));
                        if (f361a) {
                            Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f370i.get(i2));
                        }
                    }
                }
            }
            fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.f169a = fragmentStateArr;
            fragmentManagerState.f170b = iArr;
            fragmentManagerState.f171c = backStackStateArr;
            return fragmentManagerState;
        } else if (!f361a) {
            return null;
        } else {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
    }

    void m490a(Parcelable parcelable, List<Fragment> list) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.f169a != null) {
                int i;
                Fragment fragment;
                int i2;
                if (list != null) {
                    for (i = 0; i < list.size(); i++) {
                        fragment = (Fragment) list.get(i);
                        if (f361a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                        }
                        FragmentState fragmentState = fragmentManagerState.f169a[fragment.f158p];
                        fragmentState.f182k = fragment;
                        fragment.f157o = null;
                        fragment.f127A = 0;
                        fragment.f167y = false;
                        fragment.f164v = false;
                        fragment.f161s = null;
                        if (fragmentState.f181j != null) {
                            fragmentState.f181j.setClassLoader(this.f376o.m397g().getClassLoader());
                            fragment.f157o = fragmentState.f181j.getSparseParcelableArray("android:view_state");
                            fragment.f156n = fragmentState.f181j;
                        }
                    }
                }
                this.f367f = new ArrayList(fragmentManagerState.f169a.length);
                if (this.f369h != null) {
                    this.f369h.clear();
                }
                for (i2 = 0; i2 < fragmentManagerState.f169a.length; i2++) {
                    FragmentState fragmentState2 = fragmentManagerState.f169a[i2];
                    if (fragmentState2 != null) {
                        Fragment a = fragmentState2.m203a(this.f376o, this.f378q);
                        if (f361a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i2 + ": " + a);
                        }
                        this.f367f.add(a);
                        fragmentState2.f182k = null;
                    } else {
                        this.f367f.add(null);
                        if (this.f369h == null) {
                            this.f369h = new ArrayList();
                        }
                        if (f361a) {
                            Log.v("FragmentManager", "restoreAllState: avail #" + i2);
                        }
                        this.f369h.add(Integer.valueOf(i2));
                    }
                }
                if (list != null) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        fragment = (Fragment) list.get(i3);
                        if (fragment.f162t >= 0) {
                            if (fragment.f162t < this.f367f.size()) {
                                fragment.f161s = (Fragment) this.f367f.get(fragment.f162t);
                            } else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + fragment + " target no longer exists: " + fragment.f162t);
                                fragment.f161s = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.f170b != null) {
                    this.f368g = new ArrayList(fragmentManagerState.f170b.length);
                    for (i = 0; i < fragmentManagerState.f170b.length; i++) {
                        fragment = (Fragment) this.f367f.get(fragmentManagerState.f170b[i]);
                        if (fragment == null) {
                            m470a(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.f170b[i]));
                        }
                        fragment.f164v = true;
                        if (f361a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + i + ": " + fragment);
                        }
                        if (this.f368g.contains(fragment)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.f368g.add(fragment);
                    }
                } else {
                    this.f368g = null;
                }
                if (fragmentManagerState.f171c != null) {
                    this.f370i = new ArrayList(fragmentManagerState.f171c.length);
                    for (i2 = 0; i2 < fragmentManagerState.f171c.length; i2++) {
                        C0104g a2 = fragmentManagerState.f171c[i2].m118a(this);
                        if (f361a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + a2.f301p + "): " + a2);
                            a2.m362a("  ", new PrintWriter(new C0192d("FragmentManager")), false);
                        }
                        this.f370i.add(a2);
                        if (a2.f301p >= 0) {
                            m486a(a2.f301p, a2);
                        }
                    }
                    return;
                }
                this.f370i = null;
            }
        }
    }

    public void m495a(C0110o c0110o, C0044m c0044m, Fragment fragment) {
        if (this.f376o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f376o = c0110o;
        this.f377p = c0044m;
        this.f378q = fragment;
    }

    public void m523i() {
        this.f380t = false;
    }

    public void m524j() {
        this.f380t = false;
        m487a(1, false);
    }

    public void m525k() {
        this.f380t = false;
        m487a(2, false);
    }

    public void m526l() {
        this.f380t = false;
        m487a(4, false);
    }

    public void m527m() {
        this.f380t = false;
        m487a(5, false);
    }

    public void m528n() {
        m487a(4, false);
    }

    public void m529o() {
        this.f380t = true;
        m487a(3, false);
    }

    public void m530p() {
        m487a(2, false);
    }

    public void m531q() {
        m487a(1, false);
    }

    public void m532r() {
        this.f381u = true;
        m518e();
        m487a(0, false);
        this.f376o = null;
        this.f377p = null;
        this.f378q = null;
    }

    public void m488a(Configuration configuration) {
        if (this.f368g != null) {
            for (int i = 0; i < this.f368g.size(); i++) {
                Fragment fragment = (Fragment) this.f368g.get(i);
                if (fragment != null) {
                    fragment.m149a(configuration);
                }
            }
        }
    }

    public void m533s() {
        if (this.f368g != null) {
            for (int i = 0; i < this.f368g.size(); i++) {
                Fragment fragment = (Fragment) this.f368g.get(i);
                if (fragment != null) {
                    fragment.m130E();
                }
            }
        }
    }

    public boolean m500a(Menu menu, MenuInflater menuInflater) {
        boolean z;
        Fragment fragment;
        int i = 0;
        ArrayList arrayList = null;
        if (this.f368g != null) {
            int i2 = 0;
            z = false;
            while (i2 < this.f368g.size()) {
                fragment = (Fragment) this.f368g.get(i2);
                if (fragment != null && fragment.m160b(menu, menuInflater)) {
                    z = true;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                }
                i2++;
                z = z;
            }
        } else {
            z = false;
        }
        if (this.f371j != null) {
            while (i < this.f371j.size()) {
                fragment = (Fragment) this.f371j.get(i);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    fragment.m191s();
                }
                i++;
            }
        }
        this.f371j = arrayList;
        return z;
    }

    public boolean m499a(Menu menu) {
        if (this.f368g == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.f368g.size(); i++) {
            Fragment fragment = (Fragment) this.f368g.get(i);
            if (fragment != null && fragment.m164c(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean m501a(MenuItem menuItem) {
        if (this.f368g == null) {
            return false;
        }
        for (int i = 0; i < this.f368g.size(); i++) {
            Fragment fragment = (Fragment) this.f368g.get(i);
            if (fragment != null && fragment.m165c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean m509b(MenuItem menuItem) {
        if (this.f368g == null) {
            return false;
        }
        for (int i = 0; i < this.f368g.size(); i++) {
            Fragment fragment = (Fragment) this.f368g.get(i);
            if (fragment != null && fragment.m169d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void m507b(Menu menu) {
        if (this.f368g != null) {
            for (int i = 0; i < this.f368g.size(); i++) {
                Fragment fragment = (Fragment) this.f368g.get(i);
                if (fragment != null) {
                    fragment.m168d(menu);
                }
            }
        }
    }

    public static int m475c(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    public static int m473b(int i, boolean z) {
        switch (i) {
            case 4097:
                return z ? 1 : 2;
            case 4099:
                return z ? 5 : 6;
            case 8194:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }

    public View mo78a(View view, String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String string;
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0123b.f356a);
        if (attributeValue == null) {
            string = obtainStyledAttributes.getString(0);
        } else {
            string = attributeValue;
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string2 = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!Fragment.m125b(this.f376o.m397g(), string)) {
            return null;
        }
        int id;
        if (view != null) {
            id = view.getId();
        } else {
            id = 0;
        }
        if (id == -1 && resourceId == -1 && string2 == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
        }
        Fragment fragment;
        Fragment a = resourceId != -1 ? m478a(resourceId) : null;
        if (a == null && string2 != null) {
            a = m480a(string2);
        }
        if (a == null && id != -1) {
            a = m478a(id);
        }
        if (f361a) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + string + " existing=" + a);
        }
        if (a == null) {
            Fragment a2 = Fragment.m123a(context, string);
            a2.f166x = true;
            a2.f132F = resourceId != 0 ? resourceId : id;
            a2.f133G = id;
            a2.f134H = string2;
            a2.f167y = true;
            a2.f128B = this;
            a2.f129C = this.f376o;
            a2.m146a(this.f376o.m397g(), attributeSet, a2.f156n);
            m494a(a2, true);
            fragment = a2;
        } else if (a.f167y) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
        } else {
            a.f167y = true;
            a.f129C = this.f376o;
            if (!a.f138L) {
                a.m146a(this.f376o.m397g(), attributeSet, a.f156n);
            }
            fragment = a;
        }
        if (this.f375n >= 1 || !fragment.f166x) {
            m504b(fragment);
        } else {
            m493a(fragment, 1, 0, 0, false);
        }
        if (fragment.f144R == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            fragment.f144R.setId(resourceId);
        }
        if (fragment.f144R.getTag() == null) {
            fragment.f144R.setTag(string2);
        }
        return fragment.f144R;
    }

    C0124m m534t() {
        return this;
    }
}
