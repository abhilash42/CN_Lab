package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.support.v4.os.C0205a;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: ActivityChooserModel */
class C0621e extends DataSetObservable {
    private static final String f1630a = C0621e.class.getSimpleName();
    private static final Object f1631b = new Object();
    private static final Map<String, C0621e> f1632c = new HashMap();
    private final Object f1633d;
    private final List<C0616a> f1634e;
    private final List<C0618c> f1635f;
    private final Context f1636g;
    private final String f1637h;
    private Intent f1638i;
    private C0617b f1639j;
    private int f1640k;
    private boolean f1641l;
    private boolean f1642m;
    private boolean f1643n;
    private boolean f1644o;
    private C0619d f1645p;

    /* compiled from: ActivityChooserModel */
    public final class C0616a implements Comparable<C0616a> {
        public final ResolveInfo f1623a;
        public float f1624b;
        final /* synthetic */ C0621e f1625c;

        public /* synthetic */ int compareTo(Object obj) {
            return m3058a((C0616a) obj);
        }

        public C0616a(C0621e c0621e, ResolveInfo resolveInfo) {
            this.f1625c = c0621e;
            this.f1623a = resolveInfo;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f1624b) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            if (Float.floatToIntBits(this.f1624b) != Float.floatToIntBits(((C0616a) obj).f1624b)) {
                return false;
            }
            return true;
        }

        public int m3058a(C0616a c0616a) {
            return Float.floatToIntBits(c0616a.f1624b) - Float.floatToIntBits(this.f1624b);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("resolveInfo:").append(this.f1623a.toString());
            stringBuilder.append("; weight:").append(new BigDecimal((double) this.f1624b));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    /* compiled from: ActivityChooserModel */
    public interface C0617b {
        void m3059a(Intent intent, List<C0616a> list, List<C0618c> list2);
    }

    /* compiled from: ActivityChooserModel */
    public static final class C0618c {
        public final ComponentName f1626a;
        public final long f1627b;
        public final float f1628c;

        public C0618c(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public C0618c(ComponentName componentName, long j, float f) {
            this.f1626a = componentName;
            this.f1627b = j;
            this.f1628c = f;
        }

        public int hashCode() {
            return (((((this.f1626a == null ? 0 : this.f1626a.hashCode()) + 31) * 31) + ((int) (this.f1627b ^ (this.f1627b >>> 32)))) * 31) + Float.floatToIntBits(this.f1628c);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            C0618c c0618c = (C0618c) obj;
            if (this.f1626a == null) {
                if (c0618c.f1626a != null) {
                    return false;
                }
            } else if (!this.f1626a.equals(c0618c.f1626a)) {
                return false;
            }
            if (this.f1627b != c0618c.f1627b) {
                return false;
            }
            if (Float.floatToIntBits(this.f1628c) != Float.floatToIntBits(c0618c.f1628c)) {
                return false;
            }
            return true;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("; activity:").append(this.f1626a);
            stringBuilder.append("; time:").append(this.f1627b);
            stringBuilder.append("; weight:").append(new BigDecimal((double) this.f1628c));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    /* compiled from: ActivityChooserModel */
    public interface C0619d {
        boolean m3060a(C0621e c0621e, Intent intent);
    }

    /* compiled from: ActivityChooserModel */
    private final class C0620e extends AsyncTask<Object, Void, Void> {
        final /* synthetic */ C0621e f1629a;

        private C0620e(C0621e c0621e) {
            this.f1629a = c0621e;
        }

        public /* synthetic */ Object doInBackground(Object[] objArr) {
            return m3061a(objArr);
        }

        public Void m3061a(Object... objArr) {
            int i = 0;
            List list = (List) objArr[0];
            String str = (String) objArr[1];
            try {
                OutputStream openFileOutput = this.f1629a.f1636g.openFileOutput(str, 0);
                XmlSerializer newSerializer = Xml.newSerializer();
                try {
                    newSerializer.setOutput(openFileOutput, null);
                    newSerializer.startDocument("UTF-8", Boolean.valueOf(true));
                    newSerializer.startTag(null, "historical-records");
                    int size = list.size();
                    while (i < size) {
                        C0618c c0618c = (C0618c) list.remove(0);
                        newSerializer.startTag(null, "historical-record");
                        newSerializer.attribute(null, "activity", c0618c.f1626a.flattenToString());
                        newSerializer.attribute(null, "time", String.valueOf(c0618c.f1627b));
                        newSerializer.attribute(null, "weight", String.valueOf(c0618c.f1628c));
                        newSerializer.endTag(null, "historical-record");
                        i++;
                    }
                    newSerializer.endTag(null, "historical-records");
                    newSerializer.endDocument();
                    this.f1629a.f1641l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Throwable e2) {
                    Log.e(C0621e.f1630a, "Error writing historical recrod file: " + this.f1629a.f1637h, e2);
                    this.f1629a.f1641l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (Throwable e22) {
                    Log.e(C0621e.f1630a, "Error writing historical recrod file: " + this.f1629a.f1637h, e22);
                    this.f1629a.f1641l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (Throwable e222) {
                    Log.e(C0621e.f1630a, "Error writing historical recrod file: " + this.f1629a.f1637h, e222);
                    this.f1629a.f1641l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e5) {
                        }
                    }
                } catch (Throwable th) {
                    this.f1629a.f1641l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e6) {
                        }
                    }
                }
            } catch (Throwable e2222) {
                Log.e(C0621e.f1630a, "Error writing historical recrod file: " + str, e2222);
            }
            return null;
        }
    }

    public int m3074a() {
        int size;
        synchronized (this.f1633d) {
            m3068e();
            size = this.f1634e.size();
        }
        return size;
    }

    public ResolveInfo m3076a(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.f1633d) {
            m3068e();
            resolveInfo = ((C0616a) this.f1634e.get(i)).f1623a;
        }
        return resolveInfo;
    }

    public int m3075a(ResolveInfo resolveInfo) {
        synchronized (this.f1633d) {
            m3068e();
            List list = this.f1634e;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((C0616a) list.get(i)).f1623a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public Intent m3077b(int i) {
        synchronized (this.f1633d) {
            if (this.f1638i == null) {
                return null;
            }
            m3068e();
            C0616a c0616a = (C0616a) this.f1634e.get(i);
            ComponentName componentName = new ComponentName(c0616a.f1623a.activityInfo.packageName, c0616a.f1623a.activityInfo.name);
            Intent intent = new Intent(this.f1638i);
            intent.setComponent(componentName);
            if (this.f1645p != null) {
                if (this.f1645p.m3060a(this, new Intent(intent))) {
                    return null;
                }
            }
            m3063a(new C0618c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public ResolveInfo m3078b() {
        synchronized (this.f1633d) {
            m3068e();
            if (this.f1634e.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((C0616a) this.f1634e.get(0)).f1623a;
            return resolveInfo;
        }
    }

    public void m3079c(int i) {
        synchronized (this.f1633d) {
            float f;
            m3068e();
            C0616a c0616a = (C0616a) this.f1634e.get(i);
            C0616a c0616a2 = (C0616a) this.f1634e.get(0);
            if (c0616a2 != null) {
                f = (c0616a2.f1624b - c0616a.f1624b) + 5.0f;
            } else {
                f = 1.0f;
            }
            m3063a(new C0618c(new ComponentName(c0616a.f1623a.activityInfo.packageName, c0616a.f1623a.activityInfo.name), System.currentTimeMillis(), f));
        }
    }

    private void m3067d() {
        if (!this.f1642m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.f1643n) {
            this.f1643n = false;
            if (!TextUtils.isEmpty(this.f1637h)) {
                C0205a.m818a(new C0620e(), new ArrayList(this.f1635f), this.f1637h);
            }
        }
    }

    private void m3068e() {
        int g = m3070g() | m3071h();
        m3072i();
        if (g != 0) {
            m3069f();
            notifyChanged();
        }
    }

    private boolean m3069f() {
        if (this.f1639j == null || this.f1638i == null || this.f1634e.isEmpty() || this.f1635f.isEmpty()) {
            return false;
        }
        this.f1639j.m3059a(this.f1638i, this.f1634e, Collections.unmodifiableList(this.f1635f));
        return true;
    }

    private boolean m3070g() {
        if (!this.f1644o || this.f1638i == null) {
            return false;
        }
        this.f1644o = false;
        this.f1634e.clear();
        List queryIntentActivities = this.f1636g.getPackageManager().queryIntentActivities(this.f1638i, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.f1634e.add(new C0616a(this, (ResolveInfo) queryIntentActivities.get(i)));
        }
        return true;
    }

    private boolean m3071h() {
        if (!this.f1641l || !this.f1643n || TextUtils.isEmpty(this.f1637h)) {
            return false;
        }
        this.f1641l = false;
        this.f1642m = true;
        m3073j();
        return true;
    }

    private boolean m3063a(C0618c c0618c) {
        boolean add = this.f1635f.add(c0618c);
        if (add) {
            this.f1643n = true;
            m3072i();
            m3067d();
            m3069f();
            notifyChanged();
        }
        return add;
    }

    private void m3072i() {
        int size = this.f1635f.size() - this.f1640k;
        if (size > 0) {
            this.f1643n = true;
            for (int i = 0; i < size; i++) {
                C0618c c0618c = (C0618c) this.f1635f.remove(0);
            }
        }
    }

    private void m3073j() {
        try {
            InputStream openFileInput = this.f1636g.openFileInput(this.f1637h);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(openFileInput, "UTF-8");
                int i = 0;
                while (i != 1 && i != 2) {
                    i = newPullParser.next();
                }
                if ("historical-records".equals(newPullParser.getName())) {
                    List list = this.f1635f;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next == 1) {
                            break;
                        } else if (!(next == 3 || next == 4)) {
                            if ("historical-record".equals(newPullParser.getName())) {
                                list.add(new C0618c(newPullParser.getAttributeValue(null, "activity"), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
                            } else {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            }
                        }
                    }
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                            return;
                        } catch (IOException e) {
                            return;
                        }
                    }
                    return;
                }
                throw new XmlPullParserException("Share records file does not start with historical-records tag.");
            } catch (Throwable e2) {
                Log.e(f1630a, "Error reading historical recrod file: " + this.f1637h, e2);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable e22) {
                Log.e(f1630a, "Error reading historical recrod file: " + this.f1637h, e22);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e5) {
                    }
                }
            }
        } catch (FileNotFoundException e6) {
        }
    }
}
