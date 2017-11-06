package in.juspay.mystique;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import io.fabric.sdk.android.services.p018c.C0670b;
import io.fabric.sdk.android.services.p020b.C0671a;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class C1191g {
    static HashMap<C1190a, Method> f2568a = new HashMap();
    private static float f2569b;
    private static float f2570c;
    private static float f2571d;
    private static float f2572e;
    private static HashMap<String, Object> f2573i = new HashMap();
    private static final String f2574j = C1191g.class.getName();
    private static final Map<Class, Class> f2575w = new Hashtable();
    private Activity f2576f;
    private PopupMenu f2577g;
    private C1179e f2578h;
    private String f2579k = "-1";
    private String f2580l = "";
    private String f2581m = "";
    private String f2582n = "";
    private C1178d f2583o;
    private String f2584p = ":";
    private String f2585q = ",";
    private Pattern f2586r = Pattern.compile("(?<!\\\\)" + Pattern.quote(","));
    private String f2587s = "->";
    private String f2588t = C0670b.ROLL_OVER_FILE_NAME_SEPARATOR;
    private String f2589u = "=";
    private Pattern f2590v = Pattern.compile("(?<!\\\\)" + Pattern.quote(";"));
    private C1172c f2591x;

    class C11855 implements Runnable {
        final /* synthetic */ C1191g f2554a;

        C11855(C1191g c1191g) {
            this.f2554a = c1191g;
        }

        public void run() {
            this.f2554a.f2577g.dismiss();
        }
    }

    static class C1190a {
        Class f2565a;
        String f2566b;
        Class[] f2567c;

        public C1190a(Class cls, String str, Class[] clsArr) {
            this.f2565a = cls;
            this.f2566b = str;
            this.f2567c = clsArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C1190a c1190a = (C1190a) obj;
            if (this.f2565a.equals(c1190a.f2565a) && this.f2566b.equals(c1190a.f2566b)) {
                return Arrays.equals(this.f2567c, c1190a.f2567c);
            }
            return false;
        }

        public int hashCode() {
            return (this.f2567c != null ? Arrays.hashCode(this.f2567c) : 0) + (((this.f2565a.hashCode() * 31) + this.f2566b.hashCode()) * 31);
        }
    }

    static {
        f2575w.put(Boolean.class, Boolean.TYPE);
        f2575w.put(Character.class, Character.TYPE);
        f2575w.put(Byte.class, Byte.TYPE);
        f2575w.put(Short.class, Short.TYPE);
        f2575w.put(Integer.class, Integer.TYPE);
        f2575w.put(Long.class, Long.TYPE);
        f2575w.put(Float.class, Float.TYPE);
        f2575w.put(Double.class, Double.TYPE);
        f2575w.put(Void.class, Void.TYPE);
    }

    C1191g(Activity activity, C1172c c1172c, C1179e c1179e, C1178d c1178d) {
        this.f2583o = c1178d;
        this.f2576f = activity;
        this.f2591x = c1172c;
        this.f2578h = c1179e;
        f2573i.put("duiObj", c1178d);
    }

    public static boolean m4588a(Class<?> cls) {
        return f2575w.containsKey(cls);
    }

    public String m4610a() {
        return this.f2579k + " - " + this.f2581m + "-" + this.f2582n + " - " + this.f2580l;
    }

    private Object[] m4599d(String str) {
        int i = 0;
        ArrayList arrayList = new ArrayList();
        if (m4581a(str, this.f2585q, 0) == -1) {
            arrayList.add(m4605g(str));
        } else {
            String[] split = this.f2586r.split(str);
            int length = split.length;
            while (i < length) {
                arrayList.add(m4605g(split[i]));
                i++;
            }
        }
        return arrayList.toArray();
    }

    private Class[] m4602e(String str) {
        int i = 0;
        if (str == null) {
            return null;
        }
        if (m4581a(str, this.f2585q, 0) != -1) {
            String[] split = this.f2586r.split(str);
            if (split.length > 1) {
                Class[] clsArr = new Class[split.length];
                while (i < split.length) {
                    clsArr[i] = (Class) m4604f(split[i]);
                    i++;
                }
                return clsArr;
            }
        }
        return new Class[]{(Class) m4604f(str)};
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <Any> Any m4604f(java.lang.String r7) {
        /*
        r6 = this;
        r2 = 1;
        r0 = 0;
        if (r7 == 0) goto L_0x0131;
    L_0x0004:
        r1 = r6.f2588t;
        r3 = r6.m4590a(r7, r1);
        r4 = r3[r0];
        r1 = -1;
        r5 = r4.hashCode();
        switch(r5) {
            case -891988091: goto L_0x0075;
            case 98: goto L_0x0024;
            case 102: goto L_0x0038;
            case 105: goto L_0x001b;
            case 108: goto L_0x0056;
            case 115: goto L_0x008b;
            case 3184: goto L_0x002e;
            case 3212: goto L_0x0042;
            case 3677: goto L_0x004c;
            case 98855: goto L_0x0080;
            case 99674: goto L_0x006a;
            case 102230: goto L_0x0060;
            case 3392903: goto L_0x0096;
            default: goto L_0x0014;
        };
    L_0x0014:
        r0 = r1;
    L_0x0015:
        switch(r0) {
            case 0: goto L_0x00a2;
            case 1: goto L_0x00a6;
            case 2: goto L_0x00aa;
            case 3: goto L_0x00ae;
            case 4: goto L_0x00b2;
            case 5: goto L_0x00b6;
            case 6: goto L_0x00ba;
            case 7: goto L_0x00be;
            case 8: goto L_0x011e;
            case 9: goto L_0x0122;
            case 10: goto L_0x0126;
            case 11: goto L_0x012a;
            case 12: goto L_0x012e;
            default: goto L_0x0018;
        };
    L_0x0018:
        r0 = java.lang.String.class;
    L_0x001a:
        return r0;
    L_0x001b:
        r5 = "i";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x0014;
    L_0x0023:
        goto L_0x0015;
    L_0x0024:
        r0 = "b";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x0014;
    L_0x002c:
        r0 = r2;
        goto L_0x0015;
    L_0x002e:
        r0 = "cs";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x0014;
    L_0x0036:
        r0 = 2;
        goto L_0x0015;
    L_0x0038:
        r0 = "f";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x0014;
    L_0x0040:
        r0 = 3;
        goto L_0x0015;
    L_0x0042:
        r0 = "dp";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x0014;
    L_0x004a:
        r0 = 4;
        goto L_0x0015;
    L_0x004c:
        r0 = "sp";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x0014;
    L_0x0054:
        r0 = 5;
        goto L_0x0015;
    L_0x0056:
        r0 = "l";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x0014;
    L_0x005e:
        r0 = 6;
        goto L_0x0015;
    L_0x0060:
        r0 = "get";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x0014;
    L_0x0068:
        r0 = 7;
        goto L_0x0015;
    L_0x006a:
        r0 = "dpf";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x0014;
    L_0x0072:
        r0 = 8;
        goto L_0x0015;
    L_0x0075:
        r0 = "strget";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x0014;
    L_0x007d:
        r0 = 9;
        goto L_0x0015;
    L_0x0080:
        r0 = "ctx";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x0014;
    L_0x0088:
        r0 = 10;
        goto L_0x0015;
    L_0x008b:
        r0 = "s";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x0014;
    L_0x0093:
        r0 = 11;
        goto L_0x0015;
    L_0x0096:
        r0 = "null";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x0014;
    L_0x009e:
        r0 = 12;
        goto L_0x0015;
    L_0x00a2:
        r0 = java.lang.Integer.TYPE;
        goto L_0x001a;
    L_0x00a6:
        r0 = java.lang.Boolean.TYPE;
        goto L_0x001a;
    L_0x00aa:
        r0 = java.lang.CharSequence.class;
        goto L_0x001a;
    L_0x00ae:
        r0 = java.lang.Float.TYPE;
        goto L_0x001a;
    L_0x00b2:
        r0 = java.lang.Integer.TYPE;
        goto L_0x001a;
    L_0x00b6:
        r0 = java.lang.Float.class;
        goto L_0x001a;
    L_0x00ba:
        r0 = java.lang.Long.TYPE;
        goto L_0x001a;
    L_0x00be:
        r0 = f2573i;
        r1 = r3[r2];
        r0 = r0.get(r1);
        if (r0 == 0) goto L_0x00ce;
    L_0x00c8:
        r0 = r0.getClass();
        goto L_0x001a;
    L_0x00ce:
        r0 = r6.f2591x;
        r1 = "WARNING";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = " isNull : fn__getClassType - ";
        r2 = r2.append(r3);
        r2 = r2.append(r7);
        r3 = " ";
        r2 = r2.append(r3);
        r3 = r6.m4610a();
        r2 = r2.append(r3);
        r2 = r2.toString();
        r0.mo760b(r1, r2);
        r0 = r6.f2578h;
        r1 = "WARNING";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = " isNull : fn__getClassType - ";
        r2 = r2.append(r3);
        r2 = r2.append(r7);
        r3 = " ";
        r2 = r2.append(r3);
        r3 = r6.m4610a();
        r2 = r2.append(r3);
        r2 = r2.toString();
        r0.mo786a(r1, r2);
    L_0x011e:
        r0 = java.lang.Float.TYPE;
        goto L_0x001a;
    L_0x0122:
        r0 = java.lang.CharSequence.class;
        goto L_0x001a;
    L_0x0126:
        r0 = android.content.Context.class;
        goto L_0x001a;
    L_0x012a:
        r0 = java.lang.String.class;
        goto L_0x001a;
    L_0x012e:
        r0 = 0;
        goto L_0x001a;
    L_0x0131:
        r0 = r6.f2591x;
        r1 = "WARNING";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = " isNull : fn__getClassType -  toConvert ";
        r2 = r2.append(r3);
        r3 = r6.m4610a();
        r2 = r2.append(r3);
        r2 = r2.toString();
        r0.mo760b(r1, r2);
        r0 = r6.f2578h;
        r1 = "WARNING";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = " isNull : fn__getClassType -  toConvert ";
        r2 = r2.append(r3);
        r3 = r6.m4610a();
        r2 = r2.append(r3);
        r2 = r2.toString();
        r0.mo786a(r1, r2);
        goto L_0x0018;
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.mystique.g.f(java.lang.String):Any");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <Any> Any m4605g(java.lang.String r10) {
        /*
        r9 = this;
        r1 = 0;
        r4 = 1;
        r2 = 0;
        r8 = 92;
        r3 = -1;
        if (r10 == 0) goto L_0x01d3;
    L_0x0008:
        r0 = r9.f2591x;
        r5 = "getValue!";
        r0.mo759a(r5, r10);
        r0 = r9.f2588t;
        r0 = r9.m4590a(r10, r0);
        r5 = r0[r2];
        r0 = r0[r4];
        r6 = r0.indexOf(r8);
        if (r6 == r3) goto L_0x002f;
    L_0x001f:
        r6 = ";";
        r6 = r0.indexOf(r6);
        if (r6 == r3) goto L_0x002f;
    L_0x0027:
        r6 = "\\\\;";
        r7 = ";";
        r0 = r0.replace(r6, r7);
    L_0x002f:
        r6 = r0.indexOf(r8);
        if (r6 == r3) goto L_0x0045;
    L_0x0035:
        r6 = "_";
        r6 = r0.indexOf(r6);
        if (r6 == r3) goto L_0x0045;
    L_0x003d:
        r6 = "\\\\_";
        r7 = "_";
        r0 = r0.replace(r6, r7);
    L_0x0045:
        r6 = r0.indexOf(r8);
        if (r6 == r3) goto L_0x005b;
    L_0x004b:
        r6 = ":";
        r6 = r0.indexOf(r6);
        if (r6 == r3) goto L_0x005b;
    L_0x0053:
        r6 = "\\\\:";
        r7 = ":";
        r0 = r0.replace(r6, r7);
    L_0x005b:
        r6 = r0.indexOf(r8);
        if (r6 == r3) goto L_0x0071;
    L_0x0061:
        r6 = ",";
        r6 = r0.indexOf(r6);
        if (r6 == r3) goto L_0x0071;
    L_0x0069:
        r6 = "\\\\,";
        r7 = ",";
        r0 = r0.replace(r6, r7);
    L_0x0071:
        r6 = r0.indexOf(r8);
        if (r6 == r3) goto L_0x0087;
    L_0x0077:
        r6 = "=";
        r6 = r0.indexOf(r6);
        if (r6 == r3) goto L_0x0087;
    L_0x007f:
        r6 = "\\\\=";
        r7 = "=";
        r0 = r0.replace(r6, r7);
    L_0x0087:
        if (r0 == 0) goto L_0x0195;
    L_0x0089:
        r6 = r5.hashCode();
        switch(r6) {
            case -891988091: goto L_0x0105;
            case 98: goto L_0x009e;
            case 102: goto L_0x00a8;
            case 105: goto L_0x0095;
            case 108: goto L_0x00da;
            case 115: goto L_0x00b2;
            case 3212: goto L_0x00c6;
            case 3677: goto L_0x00bc;
            case 98855: goto L_0x00ef;
            case 99674: goto L_0x00d0;
            case 102230: goto L_0x00e4;
            case 3392903: goto L_0x00fa;
            default: goto L_0x0090;
        };
    L_0x0090:
        r2 = r3;
    L_0x0091:
        switch(r2) {
            case 0: goto L_0x0110;
            case 1: goto L_0x011a;
            case 2: goto L_0x0124;
            case 3: goto L_0x0094;
            case 4: goto L_0x012e;
            case 5: goto L_0x0145;
            case 6: goto L_0x0153;
            case 7: goto L_0x0161;
            case 8: goto L_0x016b;
            case 9: goto L_0x0173;
            case 10: goto L_0x0177;
            case 11: goto L_0x017a;
            default: goto L_0x0094;
        };
    L_0x0094:
        return r0;
    L_0x0095:
        r4 = "i";
        r4 = r5.equals(r4);
        if (r4 == 0) goto L_0x0090;
    L_0x009d:
        goto L_0x0091;
    L_0x009e:
        r2 = "b";
        r2 = r5.equals(r2);
        if (r2 == 0) goto L_0x0090;
    L_0x00a6:
        r2 = r4;
        goto L_0x0091;
    L_0x00a8:
        r2 = "f";
        r2 = r5.equals(r2);
        if (r2 == 0) goto L_0x0090;
    L_0x00b0:
        r2 = 2;
        goto L_0x0091;
    L_0x00b2:
        r2 = "s";
        r2 = r5.equals(r2);
        if (r2 == 0) goto L_0x0090;
    L_0x00ba:
        r2 = 3;
        goto L_0x0091;
    L_0x00bc:
        r2 = "sp";
        r2 = r5.equals(r2);
        if (r2 == 0) goto L_0x0090;
    L_0x00c4:
        r2 = 4;
        goto L_0x0091;
    L_0x00c6:
        r2 = "dp";
        r2 = r5.equals(r2);
        if (r2 == 0) goto L_0x0090;
    L_0x00ce:
        r2 = 5;
        goto L_0x0091;
    L_0x00d0:
        r2 = "dpf";
        r2 = r5.equals(r2);
        if (r2 == 0) goto L_0x0090;
    L_0x00d8:
        r2 = 6;
        goto L_0x0091;
    L_0x00da:
        r2 = "l";
        r2 = r5.equals(r2);
        if (r2 == 0) goto L_0x0090;
    L_0x00e2:
        r2 = 7;
        goto L_0x0091;
    L_0x00e4:
        r2 = "get";
        r2 = r5.equals(r2);
        if (r2 == 0) goto L_0x0090;
    L_0x00ec:
        r2 = 8;
        goto L_0x0091;
    L_0x00ef:
        r2 = "ctx";
        r2 = r5.equals(r2);
        if (r2 == 0) goto L_0x0090;
    L_0x00f7:
        r2 = 9;
        goto L_0x0091;
    L_0x00fa:
        r2 = "null";
        r2 = r5.equals(r2);
        if (r2 == 0) goto L_0x0090;
    L_0x0102:
        r2 = 10;
        goto L_0x0091;
    L_0x0105:
        r2 = "strget";
        r2 = r5.equals(r2);
        if (r2 == 0) goto L_0x0090;
    L_0x010d:
        r2 = 11;
        goto L_0x0091;
    L_0x0110:
        r0 = java.lang.Integer.parseInt(r0);
        r0 = java.lang.Integer.valueOf(r0);
        goto L_0x0094;
    L_0x011a:
        r0 = java.lang.Boolean.parseBoolean(r0);
        r0 = java.lang.Boolean.valueOf(r0);
        goto L_0x0094;
    L_0x0124:
        r0 = java.lang.Float.parseFloat(r0);
        r0 = java.lang.Float.valueOf(r0);
        goto L_0x0094;
    L_0x012e:
        r0 = java.lang.Float.parseFloat(r0);
        r1 = r9.f2576f;
        r1 = r1.getResources();
        r1 = r1.getDisplayMetrics();
        r1 = r1.scaledDensity;
        r0 = r0 * r1;
        r0 = java.lang.Float.valueOf(r0);
        goto L_0x0094;
    L_0x0145:
        r0 = java.lang.Integer.parseInt(r0);
        r0 = r9.m4608a(r0);
        r0 = java.lang.Integer.valueOf(r0);
        goto L_0x0094;
    L_0x0153:
        r0 = java.lang.Float.parseFloat(r0);
        r0 = r9.m4607a(r0);
        r0 = java.lang.Float.valueOf(r0);
        goto L_0x0094;
    L_0x0161:
        r0 = java.lang.Long.parseLong(r0);
        r0 = java.lang.Long.valueOf(r0);
        goto L_0x0094;
    L_0x016b:
        r1 = f2573i;
        r0 = r1.get(r0);
        goto L_0x0094;
    L_0x0173:
        r0 = r9.f2576f;
        goto L_0x0094;
    L_0x0177:
        r0 = r1;
        goto L_0x0094;
    L_0x017a:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = f2573i;
        r0 = r2.get(r0);
        r0 = r1.append(r0);
        r1 = "";
        r0 = r0.append(r1);
        r0 = r0.toString();
        goto L_0x0094;
    L_0x0195:
        r1 = r9.f2591x;
        r2 = "WARNING";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = " isNull : fn__getValue - value ";
        r3 = r3.append(r4);
        r4 = r9.m4610a();
        r3 = r3.append(r4);
        r3 = r3.toString();
        r1.mo760b(r2, r3);
        r1 = r9.f2578h;
        r2 = "WARNING";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = " isNull : fn__getValue - value ";
        r3 = r3.append(r4);
        r4 = r9.m4610a();
        r3 = r3.append(r4);
        r3 = r3.toString();
        r1.mo786a(r2, r3);
        goto L_0x0094;
    L_0x01d3:
        r0 = r9.f2591x;
        r2 = "WARNING";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = " isNull : fn__getValue - value ";
        r3 = r3.append(r4);
        r4 = r9.m4610a();
        r3 = r3.append(r4);
        r3 = r3.toString();
        r0.mo760b(r2, r3);
        r0 = r9.f2578h;
        r2 = "WARNING";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = " isNull : fn__getValue - value ";
        r3 = r3.append(r4);
        r4 = r9.m4610a();
        r3 = r3.append(r4);
        r3 = r3.toString();
        r0.mo786a(r2, r3);
        r0 = r1;
        goto L_0x0094;
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.mystique.g.g(java.lang.String):Any");
    }

    public int m4608a(int i) {
        if (i <= 0) {
            return 0;
        }
        return Math.round(this.f2576f.getResources().getDisplayMetrics().density * ((float) i));
    }

    public float m4607a(float f) {
        if (f > 0.0f) {
            return (float) Math.round(this.f2576f.getResources().getDisplayMetrics().density * f);
        }
        return 0.0f;
    }

    private int m4581a(String str, String str2, int i) {
        int indexOf = str.substring(i).indexOf(str2);
        if (indexOf == -1 || indexOf == 0 || indexOf >= str.length() || str.charAt((indexOf + i) - 1) != '\\') {
            return indexOf != -1 ? indexOf + i : indexOf;
        } else {
            return m4581a(str, str2, (indexOf + i) + str2.length());
        }
    }

    private String[] m4590a(String str, String str2) {
        if (m4581a(str, str2, 0) == -1) {
            return new String[]{str};
        }
        return new String[]{str.substring(0, m4581a(str, str2, 0)), str.substring(m4581a(str, str2, 0) + str2.length())};
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object m4583a(java.lang.Object r12, java.lang.Object r13, java.lang.String r14) {
        /*
        r11 = this;
        r7 = 3;
        r8 = -1;
        r1 = 0;
        r9 = 1;
        r6 = 0;
        r11.f2580l = r14;
        r0 = r11.f2587s;
        r0 = r11.m4581a(r14, r0, r6);
        if (r0 == r8) goto L_0x0507;
    L_0x000f:
        r0 = r11.f2587s;
        r0 = r11.m4590a(r14, r0);
        r0 = r0[r6];
        r2 = r11.f2588t;
        r2 = r11.m4581a(r0, r2, r6);
        if (r2 == r8) goto L_0x0569;
    L_0x001f:
        r2 = r0.substring(r6, r7);
        r3 = "get";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0569;
    L_0x002b:
        r2 = r11.f2588t;
        r2 = r11.m4590a(r0, r2);
        r0 = r2[r9];
        r2 = r2[r6];
    L_0x0035:
        r3 = r11.f2584p;
        r3 = r11.m4581a(r14, r3, r6);
        if (r3 == r8) goto L_0x0085;
    L_0x003d:
        r3 = r11.f2587s;
        r3 = r11.m4590a(r14, r3);
        r4 = r3[r9];
        r3 = r11.f2584p;
        r5 = r11.m4590a(r4, r3);
        r3 = r5[r6];
        r5 = r5[r9];
    L_0x004f:
        r10 = r2.hashCode();
        switch(r10) {
            case -995424086: goto L_0x009a;
            case 98855: goto L_0x00a4;
            case 102230: goto L_0x00ae;
            case 3559070: goto L_0x0090;
            default: goto L_0x0056;
        };
    L_0x0056:
        r7 = r8;
    L_0x0057:
        switch(r7) {
            case 0: goto L_0x00b7;
            case 1: goto L_0x0180;
            case 2: goto L_0x024a;
            case 3: goto L_0x031c;
            default: goto L_0x005a;
        };
    L_0x005a:
        r0 = "var_";
        r0 = r11.m4581a(r3, r0, r6);
        if (r0 == r8) goto L_0x0468;
    L_0x0062:
        r0 = r11.f2588t;
        r0 = r11.m4590a(r3, r0);
        r0 = r0[r9];
        r2 = java.lang.Class.forName(r3);
        r0 = r2.getDeclaredField(r0);
        r0.setAccessible(r9);
        r2 = r11.f2584p;
        r2 = r11.m4590a(r4, r2);
        r2 = r2[r9];
        r2 = r11.m4605g(r2);
        r0.set(r1, r2);
    L_0x0084:
        return r13;
    L_0x0085:
        r3 = r11.f2587s;
        r3 = r11.m4590a(r14, r3);
        r3 = r3[r9];
        r4 = r3;
        r5 = r1;
        goto L_0x004f;
    L_0x0090:
        r7 = "this";
        r7 = r2.equals(r7);
        if (r7 == 0) goto L_0x0056;
    L_0x0098:
        r7 = r6;
        goto L_0x0057;
    L_0x009a:
        r7 = "parent";
        r7 = r2.equals(r7);
        if (r7 == 0) goto L_0x0056;
    L_0x00a2:
        r7 = r9;
        goto L_0x0057;
    L_0x00a4:
        r7 = "ctx";
        r7 = r2.equals(r7);
        if (r7 == 0) goto L_0x0056;
    L_0x00ac:
        r7 = 2;
        goto L_0x0057;
    L_0x00ae:
        r10 = "get";
        r10 = r2.equals(r10);
        if (r10 == 0) goto L_0x0056;
    L_0x00b6:
        goto L_0x0057;
    L_0x00b7:
        if (r5 == 0) goto L_0x011e;
    L_0x00b9:
        r0 = r12.getClass();
        r0 = r11.m4585a(r0, r4);
        if (r0 == 0) goto L_0x00cc;
    L_0x00c3:
        r1 = r11.m4599d(r5);
        r13 = r0.invoke(r12, r1);
        goto L_0x0084;
    L_0x00cc:
        r0 = r11.f2591x;
        r1 = "WARNING";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = " isNull : fn__runCommand - classMethodDetails  ";
        r2 = r2.append(r3);
        r2 = r2.append(r4);
        r3 = " ";
        r2 = r2.append(r3);
        r3 = r11.m4610a();
        r2 = r2.append(r3);
        r2 = r2.toString();
        r0.mo760b(r1, r2);
        r0 = r11.f2578h;
        r1 = "WARNING";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = " isNull : fn__runCommand - classMethodDetails  ";
        r2 = r2.append(r3);
        r2 = r2.append(r4);
        r3 = " ";
        r2 = r2.append(r3);
        r3 = r11.m4610a();
        r2 = r2.append(r3);
        r2 = r2.toString();
        r0.mo786a(r1, r2);
        goto L_0x0084;
    L_0x011e:
        r0 = r12.getClass();
        r0 = r11.m4585a(r0, r4);
        if (r0 == 0) goto L_0x012e;
    L_0x0128:
        r13 = r0.invoke(r12, r1);
        goto L_0x0084;
    L_0x012e:
        r0 = r11.f2591x;
        r1 = "WARNING";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = " isNull : fn__runCommand - this  classMethodDetails ";
        r2 = r2.append(r3);
        r2 = r2.append(r4);
        r3 = " ";
        r2 = r2.append(r3);
        r3 = r11.m4610a();
        r2 = r2.append(r3);
        r2 = r2.toString();
        r0.mo760b(r1, r2);
        r0 = r11.f2578h;
        r1 = "WARNING";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = " isNull : fn__runCommand - this  classMethodDetails ";
        r2 = r2.append(r3);
        r2 = r2.append(r4);
        r3 = " ";
        r2 = r2.append(r3);
        r3 = r11.m4610a();
        r2 = r2.append(r3);
        r2 = r2.toString();
        r0.mo786a(r1, r2);
        goto L_0x0084;
    L_0x0180:
        if (r5 == 0) goto L_0x01e8;
    L_0x0182:
        r0 = r12.getClass();
        r0 = r11.m4585a(r0, r4);
        if (r0 == 0) goto L_0x0196;
    L_0x018c:
        r1 = r11.m4599d(r5);
        r13 = r0.invoke(r12, r1);
        goto L_0x0084;
    L_0x0196:
        r0 = r11.f2591x;
        r1 = "WARNING";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = " isNull : fn__runCommand - parent  classMethodDetails ";
        r2 = r2.append(r3);
        r2 = r2.append(r4);
        r3 = " ";
        r2 = r2.append(r3);
        r3 = r11.m4610a();
        r2 = r2.append(r3);
        r2 = r2.toString();
        r0.mo760b(r1, r2);
        r0 = r11.f2578h;
        r1 = "WARNING";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = " isNull : fn__runCommand - parent  classMethodDetails ";
        r2 = r2.append(r3);
        r2 = r2.append(r4);
        r3 = " ";
        r2 = r2.append(r3);
        r3 = r11.m4610a();
        r2 = r2.append(r3);
        r2 = r2.toString();
        r0.mo786a(r1, r2);
        goto L_0x0084;
    L_0x01e8:
        r0 = r12.getClass();
        r0 = r11.m4585a(r0, r4);
        if (r0 == 0) goto L_0x01f8;
    L_0x01f2:
        r13 = r0.invoke(r12, r1);
        goto L_0x0084;
    L_0x01f8:
        r0 = r11.f2591x;
        r1 = "WARNING";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = " isNull : fn__runCommand - parent  classMethodDetails ";
        r2 = r2.append(r3);
        r2 = r2.append(r4);
        r3 = " ";
        r2 = r2.append(r3);
        r3 = r11.m4610a();
        r2 = r2.append(r3);
        r2 = r2.toString();
        r0.mo760b(r1, r2);
        r0 = r11.f2578h;
        r1 = "WARNING";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = " isNull : fn__runCommand - parent classMethodDetails  ";
        r2 = r2.append(r3);
        r2 = r2.append(r4);
        r3 = " ";
        r2 = r2.append(r3);
        r3 = r11.m4610a();
        r2 = r2.append(r3);
        r2 = r2.toString();
        r0.mo786a(r1, r2);
        goto L_0x0084;
    L_0x024a:
        if (r5 == 0) goto L_0x02b6;
    L_0x024c:
        r0 = r11.f2576f;
        r0 = r0.getClass();
        r0 = r11.m4585a(r0, r4);
        if (r0 == 0) goto L_0x0264;
    L_0x0258:
        r1 = r11.f2576f;
        r2 = r11.m4599d(r5);
        r13 = r0.invoke(r1, r2);
        goto L_0x0084;
    L_0x0264:
        r0 = r11.f2591x;
        r1 = "WARNING";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = " isNull : fn__runCommand - ctx  classMethodDetails ";
        r2 = r2.append(r3);
        r2 = r2.append(r4);
        r3 = " ";
        r2 = r2.append(r3);
        r3 = r11.m4610a();
        r2 = r2.append(r3);
        r2 = r2.toString();
        r0.mo760b(r1, r2);
        r0 = r11.f2578h;
        r1 = "WARNING";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = " isNull : fn__runCommand - ctx  classMethodDetails ";
        r2 = r2.append(r3);
        r2 = r2.append(r4);
        r3 = " ";
        r2 = r2.append(r3);
        r3 = r11.m4610a();
        r2 = r2.append(r3);
        r2 = r2.toString();
        r0.mo786a(r1, r2);
        goto L_0x0084;
    L_0x02b6:
        r0 = r11.f2576f;
        r0 = r0.getClass();
        r0 = r11.m4585a(r0, r4);
        if (r0 == 0) goto L_0x02ca;
    L_0x02c2:
        r2 = r11.f2576f;
        r13 = r0.invoke(r2, r1);
        goto L_0x0084;
    L_0x02ca:
        r0 = r11.f2591x;
        r1 = "WARNING";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = " isNull : fn__runCommand - ctx classMethodDetails  ";
        r2 = r2.append(r3);
        r2 = r2.append(r4);
        r3 = " ";
        r2 = r2.append(r3);
        r3 = r11.m4610a();
        r2 = r2.append(r3);
        r2 = r2.toString();
        r0.mo760b(r1, r2);
        r0 = r11.f2578h;
        r1 = "WARNING";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = " isNull : fn__runCommand - ctx classMethodDetails  ";
        r2 = r2.append(r3);
        r2 = r2.append(r4);
        r3 = " ";
        r2 = r2.append(r3);
        r3 = r11.m4610a();
        r2 = r2.append(r3);
        r2 = r2.toString();
        r0.mo786a(r1, r2);
        goto L_0x0084;
    L_0x031c:
        if (r0 == 0) goto L_0x0084;
    L_0x031e:
        r2 = f2573i;
        r2 = r2.get(r0);
        r7 = r11.f2588t;
        r6 = r11.m4581a(r3, r7, r6);
        if (r6 != r8) goto L_0x03f8;
    L_0x032c:
        if (r2 == 0) goto L_0x03f8;
    L_0x032e:
        if (r5 == 0) goto L_0x0396;
    L_0x0330:
        r0 = r2.getClass();
        r0 = r11.m4585a(r0, r4);
        if (r0 == 0) goto L_0x0344;
    L_0x033a:
        r1 = r11.m4599d(r5);
        r13 = r0.invoke(r2, r1);
        goto L_0x0084;
    L_0x0344:
        r0 = r11.f2591x;
        r1 = "WARNING";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = " isNull : fn__runCommand - get classMethodDetails ";
        r2 = r2.append(r3);
        r2 = r2.append(r4);
        r3 = " ";
        r2 = r2.append(r3);
        r3 = r11.m4610a();
        r2 = r2.append(r3);
        r2 = r2.toString();
        r0.mo760b(r1, r2);
        r0 = r11.f2578h;
        r1 = "WARNING";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = " isNull : fn__runCommand - get classMethodDetails ";
        r2 = r2.append(r3);
        r2 = r2.append(r4);
        r3 = " ";
        r2 = r2.append(r3);
        r3 = r11.m4610a();
        r2 = r2.append(r3);
        r2 = r2.toString();
        r0.mo786a(r1, r2);
        goto L_0x0084;
    L_0x0396:
        r0 = r2.getClass();
        r0 = r11.m4585a(r0, r4);
        if (r0 == 0) goto L_0x03a6;
    L_0x03a0:
        r13 = r0.invoke(r2, r1);
        goto L_0x0084;
    L_0x03a6:
        r0 = r11.f2591x;
        r1 = "WARNING";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = " isNull : fn__runCommand - get classMethodDetails : ";
        r2 = r2.append(r3);
        r2 = r2.append(r4);
        r3 = " ";
        r2 = r2.append(r3);
        r3 = r11.m4610a();
        r2 = r2.append(r3);
        r2 = r2.toString();
        r0.mo760b(r1, r2);
        r0 = r11.f2578h;
        r1 = "WARNING";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = " isNull : fn__runCommand - get classMethodDetails : ";
        r2 = r2.append(r3);
        r2 = r2.append(r4);
        r3 = " ";
        r2 = r2.append(r3);
        r3 = r11.m4610a();
        r2 = r2.append(r3);
        r2 = r2.toString();
        r0.mo786a(r1, r2);
        goto L_0x0084;
    L_0x03f8:
        if (r2 == 0) goto L_0x0416;
    L_0x03fa:
        r1 = r11.f2588t;
        r1 = r11.m4590a(r3, r1);
        r1 = r1[r9];
        r2 = f2573i;
        r0 = r2.get(r0);
        r2 = r11.f2584p;
        r2 = r11.m4590a(r4, r2);
        r2 = r2[r9];
        r13 = r11.m4584a(r0, r1, r2);
        goto L_0x0084;
    L_0x0416:
        r1 = r11.f2591x;
        r2 = "WARNING";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = " isNull : fn__runCommand - get_";
        r3 = r3.append(r4);
        r3 = r3.append(r0);
        r4 = " is null ";
        r3 = r3.append(r4);
        r4 = r11.m4610a();
        r3 = r3.append(r4);
        r3 = r3.toString();
        r1.mo760b(r2, r3);
        r1 = r11.f2578h;
        r2 = "WARNING";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = " isNull : fn__runCommand - get_";
        r3 = r3.append(r4);
        r0 = r3.append(r0);
        r3 = " is null ";
        r0 = r0.append(r3);
        r3 = r11.m4610a();
        r0 = r0.append(r3);
        r0 = r0.toString();
        r1.mo786a(r2, r0);
        goto L_0x0084;
    L_0x0468:
        r0 = "new";
        r0 = r4.equals(r0);
        if (r0 != 0) goto L_0x0480;
    L_0x0470:
        r0 = r11.f2584p;
        r0 = r11.m4590a(r4, r0);
        r0 = r0[r6];
        r3 = "new";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x04db;
    L_0x0480:
        if (r5 == 0) goto L_0x04d1;
    L_0x0482:
        r0 = "in.juspay.mystique.DuiInvocationHandler";
        r0 = r2.equals(r0);
        if (r0 == 0) goto L_0x0499;
    L_0x048a:
        r0 = r11.m4599d(r5);
        r13 = new in.juspay.mystique.b;
        r0 = r0[r6];
        r1 = r11.f2583o;
        r13.<init>(r0, r1);
        goto L_0x0084;
    L_0x0499:
        r1 = r11.m4602e(r5);
        r0 = java.lang.Class.forName(r2);
        r2 = r0.getConstructors();
        r0 = r6;
    L_0x04a6:
        r3 = r2.length;
        if (r0 >= r3) goto L_0x0084;
    L_0x04a9:
        r3 = r2[r0];
        r3 = r3.getParameterTypes();
        r3 = r3.length;
        r4 = r11.m4606h(r5);
        if (r3 != r4) goto L_0x04ce;
    L_0x04b6:
        r3 = r2[r0];
        r3 = r3.getParameterTypes();
        r3 = r11.m4589a(r3, r1);
        if (r3 == 0) goto L_0x04ce;
    L_0x04c2:
        r0 = r2[r0];
        r1 = r11.m4599d(r5);
        r13 = r0.newInstance(r1);
        goto L_0x0084;
    L_0x04ce:
        r0 = r0 + 1;
        goto L_0x04a6;
    L_0x04d1:
        r0 = java.lang.Class.forName(r2);
        r13 = r0.newInstance();
        goto L_0x0084;
    L_0x04db:
        r0 = java.lang.Class.forName(r2);
        r0 = r11.m4585a(r0, r4);
        if (r0 == 0) goto L_0x0084;
    L_0x04e5:
        r2 = r0.getName();
        r3 = "forName";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x04fd;
    L_0x04f1:
        r0 = r11.m4605g(r5);
        r0 = (java.lang.String) r0;
        r13 = java.lang.Class.forName(r0);
        goto L_0x0084;
    L_0x04fd:
        r2 = r11.m4599d(r5);
        r13 = r0.invoke(r1, r2);
        goto L_0x0084;
    L_0x0507:
        if (r13 != 0) goto L_0x0539;
    L_0x0509:
        r0 = r11.f2584p;
        r0 = r11.m4581a(r14, r0, r6);
        if (r0 == r8) goto L_0x052b;
    L_0x0511:
        r0 = r11.f2584p;
        r0 = r11.m4590a(r14, r0);
        r0 = r0[r9];
        r1 = r12.getClass();
        r1 = r11.m4585a(r1, r14);
        r0 = r11.m4599d(r0);
        r13 = r1.invoke(r12, r0);
        goto L_0x0084;
    L_0x052b:
        r0 = r12.getClass();
        r0 = r11.m4585a(r0, r14);
        r13 = r0.invoke(r12, r1);
        goto L_0x0084;
    L_0x0539:
        r0 = r11.f2584p;
        r0 = r11.m4581a(r14, r0, r6);
        if (r0 == r8) goto L_0x055b;
    L_0x0541:
        r0 = r11.f2584p;
        r0 = r11.m4590a(r14, r0);
        r0 = r0[r9];
        r1 = r13.getClass();
        r1 = r11.m4585a(r1, r14);
        r0 = r11.m4599d(r0);
        r13 = r1.invoke(r13, r0);
        goto L_0x0084;
    L_0x055b:
        r0 = r13.getClass();
        r0 = r11.m4585a(r0, r14);
        r13 = r0.invoke(r13, r1);
        goto L_0x0084;
    L_0x0569:
        r2 = r0;
        r0 = r1;
        goto L_0x0035;
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.mystique.g.a(java.lang.Object, java.lang.Object, java.lang.String):java.lang.Object");
    }

    public Object m4609a(Object obj, String str) {
        Object obj2 = null;
        for (String str2 : this.f2590v.split(str)) {
            if (!str2.equals("")) {
                if (m4581a(str2, this.f2589u, 0) != -1) {
                    String[] a = m4590a(str2, this.f2589u);
                    String str3 = m4590a(a[0], this.f2588t)[1];
                    Object a2 = m4583a(obj, obj2, a[1]);
                    f2573i.put(str3, a2);
                    this.f2591x.mo759a(f2574j, "setting " + str3 + " to " + a2);
                } else {
                    obj2 = m4583a(obj, obj2, str2);
                }
            }
        }
        return obj;
    }

    private int m4606h(String str) {
        return this.f2586r.split(str).length;
    }

    private boolean m4589a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        int i = 0;
        while (i < clsArr.length) {
            if (!(clsArr2[i] == null || clsArr[i] == null || ((clsArr[i].equals(Object.class) && !clsArr2[i].isPrimitive()) || clsArr[i].equals(clsArr2[i])))) {
                if (clsArr[i].isPrimitive() && !clsArr2[i].isArray()) {
                    try {
                        if (!((Class) clsArr2[i].getField("TYPE").get(null)).equals(clsArr[i])) {
                            return false;
                        }
                    } catch (Exception e) {
                        if (e.getMessage().equals("java.lang.NoSuchFieldException")) {
                            return false;
                        }
                    }
                } else if (clsArr[i].equals(ClassLoader.class)) {
                    if (clsArr2[i].getName().equals("dalvik.system.PathClassLoader")) {
                        return true;
                    }
                } else if (!clsArr[i].equals(clsArr2[i])) {
                    return false;
                } else {
                    if (!clsArr[i].isAssignableFrom(clsArr2[i])) {
                        return false;
                    }
                }
            }
            i++;
        }
        return true;
    }

    private Method m4587a(Class cls, String str, Class[] clsArr) {
        return cls.getMethod(str, clsArr);
    }

    private Method m4586a(Class cls, String str, Class cls2) {
        if (C1191g.m4588a(cls2)) {
            try {
                return cls.getMethod(str, new Class[]{(Class) f2575w.get(cls2)});
            } catch (NoSuchMethodException e) {
            }
        }
        do {
            int i = 0;
            while (i < cls2.getInterfaces().length) {
                try {
                    return cls.getMethod(str, new Class[]{cls2.getInterfaces()[i]});
                } catch (NoSuchMethodException e2) {
                    i++;
                }
            }
            try {
                return cls.getMethod(str, new Class[]{cls2});
            } catch (NoSuchMethodException e3) {
                cls2 = cls2.getSuperclass();
                if (cls2 == null) {
                    this.f2591x.mo760b(f2574j, "Never reach here");
                    return null;
                }
            }
        } while (cls2 == null);
        this.f2591x.mo760b(f2574j, "Never reach here");
        return null;
    }

    private Method m4593b(Class cls, String str, Class[] clsArr) {
        for (Method method : cls.getMethods()) {
            if (method.getName().equals(str) && clsArr != null && method.getParameterTypes().length == clsArr.length && m4589a(method.getParameterTypes(), clsArr)) {
                return method;
            }
        }
        return null;
    }

    private Method m4585a(Class cls, String str) {
        Class[] clsArr = null;
        if (cls == null) {
            return null;
        }
        String str2;
        if (m4581a(str, this.f2584p, 0) != -1) {
            String[] a = m4590a(str, this.f2584p);
            str = a[0];
            str2 = a[1];
        } else {
            str2 = null;
        }
        if (str2 != null) {
            clsArr = m4602e(str2);
        }
        C1190a c1190a = new C1190a(cls, str, clsArr);
        if (f2568a.containsKey(c1190a)) {
            return (Method) f2568a.get(c1190a);
        }
        Method a2;
        try {
            a2 = m4587a(cls, str, clsArr);
        } catch (NoSuchMethodException e) {
            if (clsArr == null || clsArr.length != 1) {
                a2 = m4593b(cls, str, clsArr);
            } else {
                a2 = m4586a(cls, str, clsArr[0]);
            }
        }
        f2568a.put(c1190a, a2);
        return a2;
    }

    private Object m4584a(Object obj, String str, String str2) {
        Field field = null;
        try {
            field = obj.getClass().getField(str);
        } catch (NoSuchFieldException e) {
            Field[] fields = obj.getClass().getFields();
            int length = fields.length;
            int i = 0;
            while (i < length) {
                Field field2 = fields[i];
                if (!field2.getName().equals(str)) {
                    field2 = field;
                }
                i++;
                field = field2;
            }
        }
        if (field != null) {
            field.set(obj, m4605g(str2));
        } else {
            this.f2591x.mo759a(f2574j, "Couldn't set field for " + str);
        }
        return obj;
    }

    public void m4611a(String str) {
        this.f2579k = str;
    }

    public void m4615b(String str) {
        this.f2581m = str;
    }

    public void m4616c(String str) {
        this.f2582n = str;
    }

    public void m4613a(String str, JSONObject jSONObject, Object obj) {
        try {
            Method method;
            final String str2;
            int i;
            final String string;
            Method method2;
            final String string2;
            Bitmap bitmap;
            if (str.equals("pattern")) {
                method = obj.getClass().getMethod("setFilters", new Class[]{InputFilter[].class});
                String[] split = jSONObject.getString("pattern").split(",");
                str2 = split[0];
                if (split.length == 1) {
                    i = C0671a.DEFAULT_TIMEOUT;
                } else {
                    i = Integer.parseInt(split[1].trim());
                }
                C11811 c11811 = new InputFilter(this) {
                    final /* synthetic */ C1191g f2547b;

                    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                        while (i < i2) {
                            if (!Pattern.compile(str2).matcher(String.valueOf(charSequence.charAt(i))).matches()) {
                                return "";
                            }
                            i++;
                        }
                        return null;
                    }
                };
                InputFilter[] inputFilterArr = new InputFilter[]{c11811, new LengthFilter(i)};
                method.invoke(obj, new Object[]{inputFilterArr});
            }
            if (str.equals("onKeyUp")) {
                string = jSONObject.getString("onKeyUp");
                obj.getClass().getMethod("setOnKeyListener", new Class[]{OnKeyListener.class}).invoke(obj, new Object[]{new OnKeyListener(this) {
                    final /* synthetic */ C1191g f2560b;

                    public boolean onKey(View view, int i, KeyEvent keyEvent) {
                        this.f2560b.f2583o.m4567a("window.callUICallback('" + string + "','" + i + "');");
                        return false;
                    }
                }});
            }
            if (str.equals("onLongPress")) {
                string = jSONObject.getString("onLongPress");
                obj.getClass().getMethod("setOnLongClickListener", new Class[]{OnLongClickListener.class}).invoke(obj, new Object[]{new OnLongClickListener(this) {
                    final /* synthetic */ C1191g f2562b;

                    public boolean onLongClick(View view) {
                        this.f2562b.f2583o.m4567a("window.callUICallback('" + string + "');");
                        return false;
                    }
                }});
            }
            if (str.equals("onClick")) {
                string = jSONObject.getString("onClick");
                obj.getClass().getMethod("setOnClickListener", new Class[]{OnClickListener.class}).invoke(obj, new Object[]{new OnClickListener(this) {
                    final /* synthetic */ C1191g f2564b;

                    public void onClick(View view) {
                        this.f2564b.f2583o.m4567a("window.callUICallback('" + string + "');");
                    }
                }});
            }
            if (str.equals("onItemClick")) {
                string = jSONObject.getString("onItemClick");
                obj.getClass().getMethod("setOnItemSelectedListener", new Class[]{OnItemSelectedListener.class}).invoke(obj, new Object[]{new OnItemSelectedListener(this) {
                    final /* synthetic */ C1191g f2537b;

                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                        this.f2537b.f2583o.m4567a("window.callUICallback('" + string + "', '" + adapterView.getId() + "' ,'" + view.getId() + "','" + i + "', '" + j + "');");
                    }

                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }
                }});
            }
            if (str.equals("onChange")) {
                method2 = obj.getClass().getMethod("addTextChangedListener", new Class[]{TextWatcher.class});
                string2 = jSONObject.getString("onChange");
                method2.invoke(obj, new Object[]{new TextWatcher(this) {
                    final /* synthetic */ C1191g f2539b;

                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        this.f2539b.f2583o.m4567a("window.callUICallback('" + string2 + "', '" + charSequence + "');");
                    }

                    public void afterTextChanged(Editable editable) {
                    }
                }});
            }
            if (str.equals("onFocus")) {
                method2 = obj.getClass().getMethod("setOnFocusChangeListener", new Class[]{OnFocusChangeListener.class});
                string2 = jSONObject.getString("onFocus");
                method2.invoke(obj, new Object[]{new OnFocusChangeListener(this) {
                    final /* synthetic */ C1191g f2541b;

                    public void onFocusChange(View view, boolean z) {
                        this.f2541b.f2583o.m4567a("window.callUICallback('" + string2 + "','" + z + "');");
                    }
                }});
            }
            if (str.equals("onTouch")) {
                string = jSONObject.getString("onTouch");
                obj.getClass().getMethod("setOnTouchListener", new Class[]{OnTouchListener.class}).invoke(obj, new Object[]{new OnTouchListener(this) {
                    final /* synthetic */ C1191g f2543b;

                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        this.f2543b.f2583o.m4567a("window.callUICallback('" + string + "','" + motionEvent.getX() + "','" + motionEvent.getY() + "');");
                        return false;
                    }
                }});
            }
            if (str.equals("onDateChange")) {
                string = jSONObject.getString("onDateChange");
                method = obj.getClass().getMethod("setOnDateChangeListener", new Class[]{OnDateChangeListener.class});
                if (VERSION.SDK_INT >= 11) {
                    method.invoke(obj, new Object[]{new OnDateChangeListener(this) {
                        final /* synthetic */ C1191g f2545b;

                        public void onSelectedDayChange(CalendarView calendarView, int i, int i2, int i3) {
                            this.f2545b.f2583o.m4567a("window.callUICallback('" + string + "','" + i + "','" + i2 + "','" + i3 + "');");
                        }
                    }});
                }
            }
            if (str.equals("onSwipe")) {
                string = jSONObject.getString("onSwipe");
                obj.getClass().getMethod("setOnTouchListener", new Class[]{OnTouchListener.class}).invoke(obj, new Object[]{new OnTouchListener(this) {
                    final /* synthetic */ C1191g f2549b;

                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        String str = "0";
                        switch (motionEvent.getAction()) {
                            case 0:
                                C1191g.f2569b = motionEvent.getX();
                                C1191g.f2571d = motionEvent.getY();
                                break;
                            case 1:
                                C1191g.f2570c = motionEvent.getX();
                                C1191g.f2572e = motionEvent.getY();
                                float toDegrees = (float) Math.toDegrees(Math.atan2((double) (C1191g.f2572e - C1191g.f2571d), (double) (C1191g.f2570c - C1191g.f2569b)));
                                if (toDegrees < 0.0f) {
                                    toDegrees += 360.0f;
                                }
                                if ((toDegrees >= 45.0f && toDegrees <= 135.0f) || (toDegrees >= 225.0f && toDegrees <= 315.0f)) {
                                    if (C1191g.f2572e - C1191g.f2571d <= 100.0f) {
                                        if (C1191g.f2571d - C1191g.f2572e > 100.0f) {
                                            str = "-2";
                                            break;
                                        }
                                    }
                                    str = "2";
                                    break;
                                } else if (C1191g.f2570c - C1191g.f2569b <= 100.0f) {
                                    if (C1191g.f2569b - C1191g.f2570c > 100.0f) {
                                        str = "-1";
                                        break;
                                    }
                                } else {
                                    str = "1";
                                    break;
                                }
                                break;
                        }
                        this.f2549b.f2583o.m4567a("window.callUICallback('" + string + "','" + str + "');");
                        return true;
                    }
                }});
            }
            if (str.equals("popupMenu") && VERSION.SDK_INT >= 11) {
                String[] split2 = jSONObject.getString("popupMenu").split(this.f2586r.toString());
                str2 = jSONObject.getString("onMenuItemClick");
                this.f2577g = new PopupMenu(this.f2576f, (View) obj);
                i = 0;
                while (i < split2.length) {
                    if (!(split2[i].indexOf("\\") == -1 || split2[i].indexOf(",") == -1)) {
                        split2[i] = split2[i].replace("\\\\,", ",");
                    }
                    this.f2577g.getMenu().add(0, i, 0, split2[i]);
                    i++;
                }
                this.f2577g.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ C1191g f2551b;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f2551b.f2583o.m4567a("window.callUICallback('" + str2 + "', '" + menuItem.getItemId() + "');");
                        return true;
                    }
                });
                final PopupMenu popupMenu = this.f2577g;
                Log.d(f2574j, "parseKeys: " + ((View) obj));
                ((View) obj).setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ C1191g f2553b;

                    public void onClick(View view) {
                        if (VERSION.SDK_INT >= 11) {
                            popupMenu.show();
                        }
                    }
                });
            }
            if (str.equals("localImage")) {
                String[] split3 = jSONObject.getString("localImage").split(",");
                int i2 = 0;
                bitmap = null;
                while (i2 < split3.length && bitmap == null) {
                    Bitmap decodeByteArray;
                    byte[] c;
                    if (split3[i2].startsWith("assets")) {
                        c = C1180f.m4580c(this.f2576f, split3[i2].split("/")[1]);
                        decodeByteArray = BitmapFactory.decodeByteArray(c, 0, c.length);
                    } else if (split3[i2].startsWith("drawable")) {
                        decodeByteArray = BitmapFactory.decodeResource(this.f2576f.getResources(), this.f2576f.getResources().getIdentifier(split3[i2].split("/")[1], "drawable", this.f2576f.getPackageName()));
                    } else if (split3[i2].startsWith("internal")) {
                        c = C1180f.m4579b(this.f2576f, split3[i2].split("/")[1]);
                        decodeByteArray = BitmapFactory.decodeByteArray(c, 0, c.length);
                    } else {
                        if (split3[i2].startsWith("http")) {
                            m4612a(split3[i2], obj, split3[i2].substring(split3[i2].lastIndexOf("/") + 1));
                        }
                        decodeByteArray = bitmap;
                    }
                    i2++;
                    bitmap = decodeByteArray;
                }
                ((ImageView) obj).setImageBitmap(bitmap);
            }
            if (str.equals("localBackgoundImage")) {
                String[] split4 = jSONObject.getString("localImage").split(",");
                bitmap = null;
                for (i = 0; i < split4.length && bitmap == null; i++) {
                    bitmap = BitmapFactory.decodeFile(split4[i]);
                }
                if (VERSION.SDK_INT >= 16) {
                    ((View) obj).setBackground(new BitmapDrawable(this.f2576f.getResources(), bitmap));
                } else {
                    ((View) obj).setBackgroundDrawable(new BitmapDrawable(this.f2576f.getResources(), bitmap));
                }
            }
            if (str.equals("runInUI")) {
                m4609a(obj, jSONObject.getString(str));
            }
            if (str.equals("afterRender")) {
                this.f2583o.m4567a("javascript:window.callUICallback('" + jSONObject.getString("afterRender") + "', '" + jSONObject.getString("id") + "');");
            }
        } catch (Exception e) {
            if (e != null) {
                this.f2578h.mo786a("WARNING", " excep: fn__parseKeys  - " + e.getClass().getName() + " - " + m4610a());
            }
        }
    }

    @TargetApi(14)
    public void m4614b() {
        this.f2576f.runOnUiThread(new C11855(this));
    }

    public void m4612a(final String str, final Object obj, final String str2) {
        new AsyncTask(this) {
            final /* synthetic */ C1191g f2558d;

            protected Object doInBackground(Object[] objArr) {
                try {
                    C1203i.m4626a(this.f2558d.f2576f, str);
                    return "SUCCESS";
                } catch (Exception e) {
                    return "FAILURE : " + e.getMessage();
                }
            }

            protected void onPostExecute(Object obj) {
                if (obj == "SUCCESS") {
                    try {
                        byte[] b = C1180f.m4579b(this.f2558d.f2576f, str2);
                        ((ImageView) obj).setImageBitmap(BitmapFactory.decodeByteArray(b, 0, b.length));
                    } catch (IOException e) {
                    }
                }
            }
        }.execute(new Object[0]);
    }
}
