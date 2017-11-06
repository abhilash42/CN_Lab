package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.p000a.p001a.C0006b;
import android.support.p000a.p001a.C0020f;
import android.support.v4.p002b.C0170a;
import android.support.v4.p002b.p003a.C0150a;
import android.support.v4.p004a.C0023a;
import android.support.v4.p009e.C0189a;
import android.support.v4.p009e.C0193e;
import android.support.v4.p009e.C0194f;
import android.support.v7.p013b.C0509a.C0498a;
import android.support.v7.p013b.C0509a.C0502e;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: AppCompatDrawableManager */
public final class C0632l {
    private static final Mode f1666a = Mode.SRC_IN;
    private static C0632l f1667b;
    private static final C0630b f1668c = new C0630b(6);
    private static final int[] f1669d = new int[]{C0502e.abc_textfield_search_default_mtrl_alpha, C0502e.abc_textfield_default_mtrl_alpha, C0502e.abc_ab_share_pack_mtrl_alpha};
    private static final int[] f1670e = new int[]{C0502e.abc_ic_ab_back_mtrl_am_alpha, C0502e.abc_ic_go_search_api_mtrl_alpha, C0502e.abc_ic_search_api_mtrl_alpha, C0502e.abc_ic_commit_search_api_mtrl_alpha, C0502e.abc_ic_clear_mtrl_alpha, C0502e.abc_ic_menu_share_mtrl_alpha, C0502e.abc_ic_menu_copy_mtrl_am_alpha, C0502e.abc_ic_menu_cut_mtrl_alpha, C0502e.abc_ic_menu_selectall_mtrl_alpha, C0502e.abc_ic_menu_paste_mtrl_am_alpha, C0502e.abc_ic_menu_moreoverflow_mtrl_alpha, C0502e.abc_ic_voice_search_api_mtrl_alpha};
    private static final int[] f1671f = new int[]{C0502e.abc_textfield_activated_mtrl_alpha, C0502e.abc_textfield_search_activated_mtrl_alpha, C0502e.abc_cab_background_top_mtrl_alpha, C0502e.abc_text_cursor_material};
    private static final int[] f1672g = new int[]{C0502e.abc_popup_background_mtrl_mult, C0502e.abc_cab_background_internal_bg, C0502e.abc_menu_hardkey_panel_mtrl_mult};
    private static final int[] f1673h = new int[]{C0502e.abc_edit_text_material, C0502e.abc_tab_indicator_material, C0502e.abc_textfield_search_material, C0502e.abc_spinner_mtrl_am_alpha, C0502e.abc_spinner_textfield_background_material, C0502e.abc_ratingbar_full_material, C0502e.abc_switch_track_mtrl_alpha, C0502e.abc_switch_thumb_material, C0502e.abc_btn_default_mtrl_shape, C0502e.abc_btn_borderless_material};
    private static final int[] f1674i = new int[]{C0502e.abc_btn_check_material, C0502e.abc_btn_radio_material};
    private WeakHashMap<Context, SparseArray<ColorStateList>> f1675j;
    private C0189a<String, C0628c> f1676k;
    private SparseArray<String> f1677l;
    private final Object f1678m = new Object();
    private final WeakHashMap<Context, C0193e<WeakReference<ConstantState>>> f1679n = new WeakHashMap(0);
    private TypedValue f1680o;

    /* compiled from: AppCompatDrawableManager */
    private interface C0628c {
        Drawable mo583a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme);
    }

    /* compiled from: AppCompatDrawableManager */
    private static class C0629a implements C0628c {
        private C0629a() {
        }

        public Drawable mo583a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return C0006b.m3a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Throwable e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    /* compiled from: AppCompatDrawableManager */
    private static class C0630b extends C0194f<Integer, PorterDuffColorFilter> {
        public C0630b(int i) {
            super(i);
        }

        PorterDuffColorFilter m3101a(int i, Mode mode) {
            return (PorterDuffColorFilter) m791a((Object) Integer.valueOf(C0630b.m3100b(i, mode)));
        }

        PorterDuffColorFilter m3102a(int i, Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) m792a(Integer.valueOf(C0630b.m3100b(i, mode)), porterDuffColorFilter);
        }

        private static int m3100b(int i, Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }
    }

    /* compiled from: AppCompatDrawableManager */
    private static class C0631d implements C0628c {
        private C0631d() {
        }

        public Drawable mo583a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return C0020f.m66a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Throwable e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    public static C0632l m3110a() {
        if (f1667b == null) {
            f1667b = new C0632l();
            C0632l.m3114a(f1667b);
        }
        return f1667b;
    }

    private static void m3114a(C0632l c0632l) {
        int i = VERSION.SDK_INT;
        if (i < 23) {
            c0632l.m3115a("vector", new C0631d());
            if (i >= 11) {
                c0632l.m3115a("animated-vector", new C0629a());
            }
        }
    }

    public Drawable m3133a(Context context, int i) {
        return m3134a(context, i, false);
    }

    public Drawable m3134a(Context context, int i, boolean z) {
        Drawable d = m3123d(context, i);
        if (d == null) {
            d = m3121c(context, i);
        }
        if (d == null) {
            d = C0023a.m77a(context, i);
        }
        if (d != null) {
            d = m3108a(context, i, z, d);
        }
        if (d != null) {
            ad.m2836a(d);
        }
        return d;
    }

    private static long m3104a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private Drawable m3121c(Context context, int i) {
        if (this.f1680o == null) {
            this.f1680o = new TypedValue();
        }
        TypedValue typedValue = this.f1680o;
        context.getResources().getValue(i, typedValue, true);
        long a = C0632l.m3104a(typedValue);
        Drawable a2 = m3109a(context, a);
        if (a2 == null) {
            if (i == C0502e.abc_cab_background_top_material) {
                a2 = new LayerDrawable(new Drawable[]{m3133a(context, C0502e.abc_cab_background_internal_bg), m3133a(context, C0502e.abc_cab_background_top_mtrl_alpha)});
            }
            if (a2 != null) {
                a2.setChangingConfigurations(typedValue.changingConfigurations);
                m3117a(context, a, a2);
            }
        }
        return a2;
    }

    private Drawable m3108a(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList b = m3136b(context, i);
        if (b != null) {
            if (ad.m2837b(drawable)) {
                drawable = drawable.mutate();
            }
            drawable = C0150a.m668f(drawable);
            C0150a.m659a(drawable, b);
            Mode a = m3132a(i);
            if (a == null) {
                return drawable;
            }
            C0150a.m662a(drawable, a);
            return drawable;
        } else if (i == C0502e.abc_seekbar_track_material) {
            r0 = (LayerDrawable) drawable;
            C0632l.m3112a(r0.findDrawableByLayerId(16908288), am.m2929a(context, C0498a.colorControlNormal), f1666a);
            C0632l.m3112a(r0.findDrawableByLayerId(16908303), am.m2929a(context, C0498a.colorControlNormal), f1666a);
            C0632l.m3112a(r0.findDrawableByLayerId(16908301), am.m2929a(context, C0498a.colorControlActivated), f1666a);
            return drawable;
        } else if (i == C0502e.abc_ratingbar_indicator_material || i == C0502e.abc_ratingbar_small_material) {
            r0 = (LayerDrawable) drawable;
            C0632l.m3112a(r0.findDrawableByLayerId(16908288), am.m2933c(context, C0498a.colorControlNormal), f1666a);
            C0632l.m3112a(r0.findDrawableByLayerId(16908303), am.m2929a(context, C0498a.colorControlActivated), f1666a);
            C0632l.m3112a(r0.findDrawableByLayerId(16908301), am.m2929a(context, C0498a.colorControlActivated), f1666a);
            return drawable;
        } else if (C0632l.m3116a(context, i, drawable) || !z) {
            return drawable;
        } else {
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable m3123d(android.content.Context r10, int r11) {
        /*
        r9 = this;
        r1 = 0;
        r8 = 2;
        r7 = 1;
        r0 = r9.f1676k;
        if (r0 == 0) goto L_0x00bf;
    L_0x0007:
        r0 = r9.f1676k;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x00bf;
    L_0x000f:
        r0 = r9.f1677l;
        if (r0 == 0) goto L_0x002f;
    L_0x0013:
        r0 = r9.f1677l;
        r0 = r0.get(r11);
        r0 = (java.lang.String) r0;
        r2 = "appcompat_skip_skip";
        r2 = r2.equals(r0);
        if (r2 != 0) goto L_0x002d;
    L_0x0023:
        if (r0 == 0) goto L_0x0036;
    L_0x0025:
        r2 = r9.f1676k;
        r0 = r2.get(r0);
        if (r0 != 0) goto L_0x0036;
    L_0x002d:
        r0 = r1;
    L_0x002e:
        return r0;
    L_0x002f:
        r0 = new android.util.SparseArray;
        r0.<init>();
        r9.f1677l = r0;
    L_0x0036:
        r0 = r9.f1680o;
        if (r0 != 0) goto L_0x0041;
    L_0x003a:
        r0 = new android.util.TypedValue;
        r0.<init>();
        r9.f1680o = r0;
    L_0x0041:
        r2 = r9.f1680o;
        r0 = r10.getResources();
        r0.getValue(r11, r2, r7);
        r4 = android.support.v7.widget.C0632l.m3104a(r2);
        r1 = r9.m3109a(r10, r4);
        if (r1 == 0) goto L_0x0056;
    L_0x0054:
        r0 = r1;
        goto L_0x002e;
    L_0x0056:
        r3 = r2.string;
        if (r3 == 0) goto L_0x008a;
    L_0x005a:
        r3 = r2.string;
        r3 = r3.toString();
        r6 = ".xml";
        r3 = r3.endsWith(r6);
        if (r3 == 0) goto L_0x008a;
    L_0x0068:
        r3 = r0.getXml(r11);	 Catch:{ Exception -> 0x0082 }
        r6 = android.util.Xml.asAttributeSet(r3);	 Catch:{ Exception -> 0x0082 }
    L_0x0070:
        r0 = r3.next();	 Catch:{ Exception -> 0x0082 }
        if (r0 == r8) goto L_0x0078;
    L_0x0076:
        if (r0 != r7) goto L_0x0070;
    L_0x0078:
        if (r0 == r8) goto L_0x0095;
    L_0x007a:
        r0 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ Exception -> 0x0082 }
        r2 = "No start tag found";
        r0.<init>(r2);	 Catch:{ Exception -> 0x0082 }
        throw r0;	 Catch:{ Exception -> 0x0082 }
    L_0x0082:
        r0 = move-exception;
        r2 = "AppCompatDrawableManager";
        r3 = "Exception while inflating drawable";
        android.util.Log.e(r2, r3, r0);
    L_0x008a:
        r0 = r1;
    L_0x008b:
        if (r0 != 0) goto L_0x002e;
    L_0x008d:
        r1 = r9.f1677l;
        r2 = "appcompat_skip_skip";
        r1.append(r11, r2);
        goto L_0x002e;
    L_0x0095:
        r0 = r3.getName();	 Catch:{ Exception -> 0x0082 }
        r7 = r9.f1677l;	 Catch:{ Exception -> 0x0082 }
        r7.append(r11, r0);	 Catch:{ Exception -> 0x0082 }
        r7 = r9.f1676k;	 Catch:{ Exception -> 0x0082 }
        r0 = r7.get(r0);	 Catch:{ Exception -> 0x0082 }
        r0 = (android.support.v7.widget.C0632l.C0628c) r0;	 Catch:{ Exception -> 0x0082 }
        if (r0 == 0) goto L_0x00b0;
    L_0x00a8:
        r7 = r10.getTheme();	 Catch:{ Exception -> 0x0082 }
        r1 = r0.mo583a(r10, r3, r6, r7);	 Catch:{ Exception -> 0x0082 }
    L_0x00b0:
        if (r1 == 0) goto L_0x00bd;
    L_0x00b2:
        r0 = r2.changingConfigurations;	 Catch:{ Exception -> 0x0082 }
        r1.setChangingConfigurations(r0);	 Catch:{ Exception -> 0x0082 }
        r0 = r9.m3117a(r10, r4, r1);	 Catch:{ Exception -> 0x0082 }
        if (r0 == 0) goto L_0x00bd;
    L_0x00bd:
        r0 = r1;
        goto L_0x008b;
    L_0x00bf:
        r0 = r1;
        goto L_0x002e;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.l.d(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable m3109a(android.content.Context r5, long r6) {
        /*
        r4 = this;
        r2 = 0;
        r3 = r4.f1678m;
        monitor-enter(r3);
        r0 = r4.f1679n;	 Catch:{ all -> 0x002b }
        r0 = r0.get(r5);	 Catch:{ all -> 0x002b }
        r0 = (android.support.v4.p009e.C0193e) r0;	 Catch:{ all -> 0x002b }
        if (r0 != 0) goto L_0x0011;
    L_0x000e:
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        r0 = r2;
    L_0x0010:
        return r0;
    L_0x0011:
        r1 = r0.m784a(r6);	 Catch:{ all -> 0x002b }
        r1 = (java.lang.ref.WeakReference) r1;	 Catch:{ all -> 0x002b }
        if (r1 == 0) goto L_0x0031;
    L_0x0019:
        r1 = r1.get();	 Catch:{ all -> 0x002b }
        r1 = (android.graphics.drawable.Drawable.ConstantState) r1;	 Catch:{ all -> 0x002b }
        if (r1 == 0) goto L_0x002e;
    L_0x0021:
        r0 = r5.getResources();	 Catch:{ all -> 0x002b }
        r0 = r1.newDrawable(r0);	 Catch:{ all -> 0x002b }
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        goto L_0x0010;
    L_0x002b:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        throw r0;
    L_0x002e:
        r0.m788b(r6);	 Catch:{ all -> 0x002b }
    L_0x0031:
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        r0 = r2;
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.l.a(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    private boolean m3117a(Context context, long j, Drawable drawable) {
        ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        synchronized (this.f1678m) {
            C0193e c0193e = (C0193e) this.f1679n.get(context);
            if (c0193e == null) {
                c0193e = new C0193e();
                this.f1679n.put(context, c0193e);
            }
            c0193e.m789b(j, new WeakReference(constantState));
        }
        return true;
    }

    public final Drawable m3135a(Context context, at atVar, int i) {
        Drawable d = m3123d(context, i);
        if (d == null) {
            d = atVar.m3009a(i);
        }
        if (d != null) {
            return m3108a(context, i, false, d);
        }
        return null;
    }

    static boolean m3116a(Context context, int i, Drawable drawable) {
        int i2;
        Mode mode;
        boolean z;
        int i3;
        Mode mode2 = f1666a;
        if (C0632l.m3118a(f1669d, i)) {
            i2 = C0498a.colorControlNormal;
            mode = mode2;
            z = true;
            i3 = -1;
        } else if (C0632l.m3118a(f1671f, i)) {
            i2 = C0498a.colorControlActivated;
            mode = mode2;
            z = true;
            i3 = -1;
        } else if (C0632l.m3118a(f1672g, i)) {
            z = true;
            mode = Mode.MULTIPLY;
            i2 = 16842801;
            i3 = -1;
        } else if (i == C0502e.abc_list_divider_mtrl_alpha) {
            i2 = 16842800;
            i3 = Math.round(40.8f);
            mode = mode2;
            z = true;
        } else {
            i3 = -1;
            i2 = 0;
            mode = mode2;
            z = false;
        }
        if (!z) {
            return false;
        }
        if (ad.m2837b(drawable)) {
            drawable = drawable.mutate();
        }
        drawable.setColorFilter(C0632l.m3106a(am.m2929a(context, i2), mode));
        if (i3 == -1) {
            return true;
        }
        drawable.setAlpha(i3);
        return true;
    }

    private void m3115a(String str, C0628c c0628c) {
        if (this.f1676k == null) {
            this.f1676k = new C0189a();
        }
        this.f1676k.put(str, c0628c);
    }

    private static boolean m3118a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    final Mode m3132a(int i) {
        if (i == C0502e.abc_switch_thumb_material) {
            return Mode.MULTIPLY;
        }
        return null;
    }

    public final ColorStateList m3136b(Context context, int i) {
        ColorStateList e = m3125e(context, i);
        if (e == null) {
            if (i == C0502e.abc_edit_text_material) {
                e = m3124e(context);
            } else if (i == C0502e.abc_switch_track_mtrl_alpha) {
                e = m3120c(context);
            } else if (i == C0502e.abc_switch_thumb_material) {
                e = m3122d(context);
            } else if (i == C0502e.abc_btn_default_mtrl_shape) {
                e = m3126f(context);
            } else if (i == C0502e.abc_btn_borderless_material) {
                e = m3128g(context);
            } else if (i == C0502e.abc_btn_colored_material) {
                e = m3129h(context);
            } else if (i == C0502e.abc_spinner_mtrl_am_alpha || i == C0502e.abc_spinner_textfield_background_material) {
                e = m3130i(context);
            } else if (C0632l.m3118a(f1670e, i)) {
                e = am.m2932b(context, C0498a.colorControlNormal);
            } else if (C0632l.m3118a(f1673h, i)) {
                e = m3105a(context);
            } else if (C0632l.m3118a(f1674i, i)) {
                e = m3119b(context);
            } else if (i == C0502e.abc_seekbar_thumb_material) {
                e = m3131j(context);
            }
            if (e != null) {
                m3111a(context, i, e);
            }
        }
        return e;
    }

    private ColorStateList m3125e(Context context, int i) {
        if (this.f1675j == null) {
            return null;
        }
        SparseArray sparseArray = (SparseArray) this.f1675j.get(context);
        if (sparseArray != null) {
            return (ColorStateList) sparseArray.get(i);
        }
        return null;
    }

    private void m3111a(Context context, int i, ColorStateList colorStateList) {
        if (this.f1675j == null) {
            this.f1675j = new WeakHashMap();
        }
        SparseArray sparseArray = (SparseArray) this.f1675j.get(context);
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            this.f1675j.put(context, sparseArray);
        }
        sparseArray.append(i, colorStateList);
    }

    private ColorStateList m3105a(Context context) {
        int a = am.m2929a(context, C0498a.colorControlNormal);
        int a2 = am.m2929a(context, C0498a.colorControlActivated);
        r2 = new int[7][];
        int[] iArr = new int[]{am.f1543a, am.m2933c(context, C0498a.colorControlNormal), am.f1544b, a2, am.f1545c, a2, am.f1546d};
        iArr[3] = a2;
        r2[4] = am.f1547e;
        iArr[4] = a2;
        r2[5] = am.f1548f;
        iArr[5] = a2;
        r2[6] = am.f1550h;
        iArr[6] = a;
        return new ColorStateList(r2, iArr);
    }

    private ColorStateList m3119b(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{am.f1543a, am.m2933c(context, C0498a.colorControlNormal), am.f1547e};
        iArr[1] = am.m2929a(context, C0498a.colorControlActivated);
        r0[2] = am.f1550h;
        iArr[2] = am.m2929a(context, C0498a.colorControlNormal);
        return new ColorStateList(r0, iArr);
    }

    private ColorStateList m3120c(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{am.f1543a, am.m2930a(context, 16842800, 0.1f), am.f1547e};
        iArr[1] = am.m2930a(context, C0498a.colorControlActivated, 0.3f);
        r0[2] = am.f1550h;
        iArr[2] = am.m2930a(context, 16842800, 0.3f);
        return new ColorStateList(r0, iArr);
    }

    private ColorStateList m3122d(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList b = am.m2932b(context, C0498a.colorSwitchThumbNormal);
        if (b == null || !b.isStateful()) {
            iArr[0] = am.f1543a;
            iArr2[0] = am.m2933c(context, C0498a.colorSwitchThumbNormal);
            iArr[1] = am.f1547e;
            iArr2[1] = am.m2929a(context, C0498a.colorControlActivated);
            iArr[2] = am.f1550h;
            iArr2[2] = am.m2929a(context, C0498a.colorSwitchThumbNormal);
        } else {
            iArr[0] = am.f1543a;
            iArr2[0] = b.getColorForState(iArr[0], 0);
            iArr[1] = am.f1547e;
            iArr2[1] = am.m2929a(context, C0498a.colorControlActivated);
            iArr[2] = am.f1550h;
            iArr2[2] = b.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    private ColorStateList m3124e(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{am.f1543a, am.m2933c(context, C0498a.colorControlNormal), am.f1549g};
        iArr[1] = am.m2929a(context, C0498a.colorControlNormal);
        r0[2] = am.f1550h;
        iArr[2] = am.m2929a(context, C0498a.colorControlActivated);
        return new ColorStateList(r0, iArr);
    }

    private ColorStateList m3126f(Context context) {
        return m3127f(context, am.m2929a(context, C0498a.colorButtonNormal));
    }

    private ColorStateList m3128g(Context context) {
        return m3127f(context, 0);
    }

    private ColorStateList m3129h(Context context) {
        return m3127f(context, am.m2929a(context, C0498a.colorAccent));
    }

    private ColorStateList m3127f(Context context, int i) {
        r0 = new int[4][];
        r1 = new int[4];
        int a = am.m2929a(context, C0498a.colorControlHighlight);
        r0[0] = am.f1543a;
        r1[0] = am.m2933c(context, C0498a.colorButtonNormal);
        r0[1] = am.f1546d;
        r1[1] = C0170a.m710a(a, i);
        r0[2] = am.f1544b;
        r1[2] = C0170a.m710a(a, i);
        r0[3] = am.f1550h;
        r1[3] = i;
        return new ColorStateList(r0, r1);
    }

    private ColorStateList m3130i(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{am.f1543a, am.m2933c(context, C0498a.colorControlNormal), am.f1549g};
        iArr[1] = am.m2929a(context, C0498a.colorControlNormal);
        r0[2] = am.f1550h;
        iArr[2] = am.m2929a(context, C0498a.colorControlActivated);
        return new ColorStateList(r0, iArr);
    }

    private ColorStateList m3131j(Context context) {
        r0 = new int[2][];
        int[] iArr = new int[]{am.f1543a, am.m2933c(context, C0498a.colorControlActivated)};
        r0[1] = am.f1550h;
        iArr[1] = am.m2929a(context, C0498a.colorControlActivated);
        return new ColorStateList(r0, iArr);
    }

    public static void m3113a(Drawable drawable, ap apVar, int[] iArr) {
        if (!ad.m2837b(drawable) || drawable.mutate() == drawable) {
            if (apVar.f1559d || apVar.f1558c) {
                drawable.setColorFilter(C0632l.m3107a(apVar.f1559d ? apVar.f1556a : null, apVar.f1558c ? apVar.f1557b : f1666a, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Log.d("AppCompatDrawableManager", "Mutated drawable is not the same instance as the input.");
    }

    private static PorterDuffColorFilter m3107a(ColorStateList colorStateList, Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return C0632l.m3106a(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static PorterDuffColorFilter m3106a(int i, Mode mode) {
        PorterDuffColorFilter a = f1668c.m3101a(i, mode);
        if (a != null) {
            return a;
        }
        a = new PorterDuffColorFilter(i, mode);
        f1668c.m3102a(i, mode, a);
        return a;
    }

    private static void m3112a(Drawable drawable, int i, Mode mode) {
        if (ad.m2837b(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = f1666a;
        }
        drawable.setColorFilter(C0632l.m3106a(i, mode));
    }
}
