package in.org.npci.upiapp.core;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Profile;
import android.provider.MediaStore.Images.Media;
import android.support.v4.app.C0050a;
import android.support.v4.p004a.C0023a;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.C0223f;
import android.support.v4.view.p011b.C0315a;
import android.text.ClipboardManager;
import android.text.TextUtils.TruncateAt;
import android.util.Base64;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.DatePicker;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import com.google.android.gms.common.C0747b;
import in.juspay.mystique.C1178d;
import in.org.npci.upiapp.C1381a;
import in.org.npci.upiapp.C1384b;
import in.org.npci.upiapp.C1385c;
import in.org.npci.upiapp.C1422d;
import in.org.npci.upiapp.C1425e;
import in.org.npci.upiapp.C1431i;
import in.org.npci.upiapp.HomeActivity;
import in.org.npci.upiapp.TabLayout;
import in.org.npci.upiapp.gcm.RegistrationIntentService;
import in.org.npci.upiapp.models.ApiResponse;
import in.org.npci.upiapp.p036a.C1380a;
import in.org.npci.upiapp.utils.C1435a;
import in.org.npci.upiapp.utils.C1436b;
import in.org.npci.upiapp.utils.C1440c;
import in.org.npci.upiapp.utils.C1440c.C1390b;
import in.org.npci.upiapp.utils.C1441d;
import in.org.npci.upiapp.utils.C1442e;
import in.org.npci.upiapp.utils.C1445h;
import in.org.npci.upiapp.utils.C1447j;
import in.org.npci.upiapp.utils.RestClient;
import io.fabric.sdk.android.services.p018c.C0670b;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class JsInterface {
    private static final String f3435h = JsInterface.class.getName();
    private static C1381a f3436s;
    private static C1384b f3437t;
    Cursor f3438a = null;
    ArrayList<String> f3439b = new ArrayList();
    C1435a f3440c;
    WebView f3441d = null;
    HashMap<Integer, ArrayList<C1385c>> f3442e = new HashMap();
    HashMap<Integer, ArrayList<C1422d>> f3443f = new HashMap();
    private C1442e f3444g;
    private Context f3445i;
    private Activity f3446j;
    private C1178d f3447k;
    private BroadcastReceiver f3448l;
    private BroadcastReceiver f3449m;
    private final int f3450n = 1;
    private String f3451o;
    private DatePickerDialog f3452p;
    private final String[] f3453q;
    private int f3454r = 88;

    class C14007 extends BroadcastReceiver {
        final /* synthetic */ JsInterface f3431a;

        C14007(JsInterface jsInterface) {
            this.f3431a = jsInterface;
        }

        public void onReceive(Context context, Intent intent) {
            switch (getResultCode()) {
            }
        }
    }

    class C14018 implements Runnable {
        final /* synthetic */ JsInterface f3432a;

        C14018(JsInterface jsInterface) {
            this.f3432a = jsInterface;
        }

        public void run() {
            this.f3432a.f3446j.getWindow().setSoftInputMode(3);
        }
    }

    public JsInterface(Activity activity, C1178d c1178d) {
        this.f3445i = activity.getApplicationContext();
        this.f3446j = activity;
        this.f3447k = c1178d;
        this.f3444g = new C1442e(this.f3445i);
        this.f3453q = new String[]{"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};
        this.f3440c = new C1435a(this.f3445i);
    }

    @JavascriptInterface
    public String getIntentData() {
        JSONObject jSONObject = new JSONObject();
        if (!(this.f3446j == null || this.f3446j.getIntent() == null)) {
            String k = ((HomeActivity) this.f3446j).m5230k();
            String l = ((HomeActivity) this.f3446j).m5231l();
            if (k != null) {
                try {
                    jSONObject.put(CLConstants.FIELD_TYPE, "GCM");
                    jSONObject.put(CLConstants.FIELD_DATA, k);
                } catch (Throwable e) {
                    C1380a.m5276a(f3435h, "Exception", e);
                }
            } else {
                String n = ((HomeActivity) this.f3446j).m5233n();
                if (n != null) {
                    jSONObject.put(CLConstants.FIELD_TYPE, "MERCHANT");
                    jSONObject.put(CLConstants.FIELD_DATA, n);
                }
            }
            if (l != null) {
                jSONObject.put(CLConstants.FIELD_TYPE, "REMINDER");
                jSONObject.put(CLConstants.FIELD_DATA, l);
            }
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public String getDeviceId() {
        try {
            return C1447j.m5498a(this.f3446j);
        } catch (Throwable e) {
            C1380a.m5276a(f3435h, "Error getting deviceId", e);
            return null;
        }
    }

    @JavascriptInterface
    public String getPackageName() {
        try {
            return this.f3446j.getPackageName();
        } catch (Throwable e) {
            C1380a.m5276a(f3435h, "Error getting package name", e);
            return null;
        }
    }

    @JavascriptInterface
    public void viewPagerAdapter(String str, String str2, String str3, String str4, String str5) {
        int parseInt = Integer.parseInt(str);
        int parseInt2 = Integer.parseInt(str2);
        ViewPager viewPager = (ViewPager) this.f3446j.findViewById(parseInt);
        JSONArray jSONArray = new JSONArray(str3);
        JSONArray jSONArray2 = new JSONArray(str4);
        ArrayList a = C1447j.m5499a(jSONArray, "view", "String");
        C1431i c1431i = new C1431i(this.f3445i, C1447j.m5499a(jSONArray, CLConstants.FIELD_PAY_INFO_VALUE, "String"), a, C1447j.m5499a(jSONArray2, CLConstants.FIELD_PAY_INFO_VALUE, "String"), this.f3447k);
        final TabLayout tabLayout = (TabLayout) this.f3446j.findViewById(parseInt2);
        final ViewPager viewPager2 = viewPager;
        final C1431i c1431i2 = c1431i;
        final String str6 = str5;
        this.f3446j.runOnUiThread(new Runnable(this) {
            final /* synthetic */ JsInterface f3321e;

            class C13861 implements C0223f {
                final /* synthetic */ C13871 f3277a;

                C13861(C13871 c13871) {
                    this.f3277a = c13871;
                }

                public void mo794a(int i, float f, int i2) {
                }

                public void mo793a(int i) {
                    this.f3277a.f3321e.f3447k.m4567a(String.format("window.callJSCallback('%s','%s');", new Object[]{str6, Integer.valueOf(i)}));
                }

                public void mo795b(int i) {
                }
            }

            public void run() {
                viewPager2.setAdapter(c1431i2);
                viewPager2.setOffscreenPageLimit(5);
                tabLayout.setupWithViewPager(viewPager2);
                viewPager2.addOnPageChangeListener(new C13861(this));
            }
        });
    }

    @JavascriptInterface
    public void scrollDirection(final int i, final int i2) {
        this.f3446j.runOnUiThread(new Runnable(this) {
            final /* synthetic */ JsInterface f3289c;

            public void run() {
                ViewPager viewPager = (ViewPager) this.f3289c.f3446j.findViewById(i);
                if (viewPager != null) {
                    viewPager.setCurrentItem(i2);
                }
            }
        });
    }

    @JavascriptInterface
    public String loadFile(String str) {
        try {
            byte[] a = C1441d.m5475a(this.f3446j, str);
            if (a == null) {
                return "";
            }
            return new String(a, "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }

    @JavascriptInterface
    @TargetApi(23)
    public void rangeSeekBar(final String str, String str2, String str3, String str4, String str5, final String str6) {
        final C1440c c1440c = new C1440c(this.f3446j);
        c1440c.m5470a(Integer.valueOf(Integer.parseInt(str2)), Integer.valueOf(Integer.parseInt(str3)));
        c1440c.setSelectedMinValue(Integer.valueOf(Integer.parseInt(str4)));
        c1440c.setSelectedMaxValue(Integer.valueOf(Integer.parseInt(str5)));
        c1440c.setOnRangeSeekBarChangeListener(new C1390b<Integer>(this) {
            final /* synthetic */ JsInterface f3339c;

            public void m5296a(C1440c<?> c1440c, Integer num, Integer num2) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (num.intValue() == 0) {
                        c1440c.setSelectedMinValue(Integer.valueOf(1));
                        jSONObject.put("min", "1");
                        jSONObject.put("max", num2.toString());
                        this.f3339c.f3447k.m4567a("window.callUICallback(\"" + str6 + "\", " + jSONObject.toString() + ");");
                        return;
                    }
                    jSONObject.put("min", num.toString());
                    jSONObject.put("max", num2.toString());
                    this.f3339c.f3447k.m4567a("window.callUICallback(\"" + str6 + "\", " + jSONObject.toString() + ");");
                } catch (JSONException e) {
                }
            }
        });
        this.f3446j.runOnUiThread(new Runnable(this) {
            final /* synthetic */ JsInterface f3389c;

            public void run() {
                ((LinearLayout) this.f3389c.f3446j.findViewById(Integer.parseInt(str))).addView(c1440c);
            }
        });
    }

    private byte[] m5303a(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        GZIPInputStream gZIPInputStream;
        Throwable e;
        Throwable th;
        byte[] bArr2 = null;
        byte[] bArr3 = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    gZIPInputStream = new GZIPInputStream(byteArrayInputStream, 1024);
                    while (true) {
                        try {
                            int read = gZIPInputStream.read(bArr3);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr3, 0, read);
                        } catch (IOException e2) {
                            e = e2;
                        }
                    }
                    bArr2 = byteArrayOutputStream.toByteArray();
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                } catch (IOException e6) {
                    e = e6;
                    gZIPInputStream = bArr2;
                    try {
                        C1380a.m5276a(f3435h, "Exception while gunzipping - ", e);
                        if (gZIPInputStream != null) {
                            try {
                                gZIPInputStream.close();
                            } catch (IOException e7) {
                            }
                        }
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (IOException e8) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e9) {
                            }
                        }
                        return bArr2;
                    } catch (Throwable th2) {
                        th = th2;
                        if (gZIPInputStream != null) {
                            try {
                                gZIPInputStream.close();
                            } catch (IOException e10) {
                            }
                        }
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (IOException e11) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e12) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable e13) {
                    gZIPInputStream = bArr2;
                    th = e13;
                    if (gZIPInputStream != null) {
                        gZIPInputStream.close();
                    }
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            } catch (IOException e14) {
                e13 = e14;
                gZIPInputStream = bArr2;
                byteArrayOutputStream = bArr2;
                C1380a.m5276a(f3435h, "Exception while gunzipping - ", e13);
                if (gZIPInputStream != null) {
                    gZIPInputStream.close();
                }
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return bArr2;
            } catch (Throwable e132) {
                gZIPInputStream = bArr2;
                byteArrayOutputStream = bArr2;
                th = e132;
                if (gZIPInputStream != null) {
                    gZIPInputStream.close();
                }
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        } catch (IOException e15) {
            e132 = e15;
            gZIPInputStream = bArr2;
            byteArrayOutputStream = bArr2;
            byteArrayInputStream = bArr2;
            C1380a.m5276a(f3435h, "Exception while gunzipping - ", e132);
            if (gZIPInputStream != null) {
                gZIPInputStream.close();
            }
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            return bArr2;
        } catch (Throwable e1322) {
            gZIPInputStream = bArr2;
            byteArrayOutputStream = bArr2;
            byteArrayInputStream = bArr2;
            th = e1322;
            if (gZIPInputStream != null) {
                gZIPInputStream.close();
            }
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            throw th;
        }
        return bArr2;
    }

    private String m5306b(byte[] bArr) {
        int i = 0;
        try {
            r4 = new byte[8];
            byte[] bArr2 = new byte[(bArr.length - 8)];
            int length = bArr.length;
            r4[0] = bArr[9];
            r4[1] = bArr[19];
            r4[2] = bArr[29];
            r4[3] = bArr[39];
            r4[4] = bArr[49];
            r4[5] = bArr[59];
            r4[6] = bArr[69];
            r4[7] = bArr[79];
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                if (i2 <= 0 || i2 % 10 != 9 || i3 >= 8) {
                    bArr2[i] = (byte) (bArr[i2] ^ r4[i % 8]);
                    i++;
                } else {
                    i3++;
                }
                i2++;
            }
            return new String(m5303a(bArr2), "UTF-8");
        } catch (Throwable e) {
            C1380a.m5276a(f3435h, "Exception while decrypting - ", e);
            return null;
        }
    }

    @JavascriptInterface
    public String decryptAndloadFile(String str) {
        C1380a.m5275a(f3435h, "Processing File - " + str);
        try {
            byte[] a = C1441d.m5476a(this.f3446j, str, "galileo");
            if (!str.endsWith(".jsa") || a == null) {
                return null;
            }
            try {
                return new String(m5306b(a));
            } catch (Exception e) {
                return "";
            }
        } catch (Exception e2) {
            return "";
        }
    }

    @JavascriptInterface
    public void getGCMToken() {
        this.f3446j.runOnUiThread(new Runnable(this) {
            final /* synthetic */ JsInterface f3390a;

            {
                this.f3390a = r1;
            }

            public void run() {
                try {
                    if (this.f3390a.m5311d()) {
                        this.f3390a.f3446j.startService(new Intent(this.f3390a.f3446j, RegistrationIntentService.class));
                    }
                } catch (Throwable e) {
                    C1380a.m5276a(JsInterface.f3435h, "Exception while calling GCM Token", e);
                }
            }
        });
    }

    @JavascriptInterface
    public void contactListViewAdapter(String str, String str2, String str3, String str4, String str5) {
        final int parseInt = Integer.parseInt(str);
        JSONArray jSONArray = new JSONArray(str2);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        final ListView listView = (ListView) this.f3446j.findViewById(parseInt);
        if (str5.equals("IFSC")) {
            if (listView != null) {
                this.f3443f.put(Integer.valueOf(parseInt), arrayList2);
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                arrayList2.add(new C1422d(jSONObject.getString("avatar"), jSONObject.getString("accountNumber"), jSONObject.getString(CLConstants.FIELD_PAY_INFO_NAME), jSONObject.getString("bankName"), jSONObject.getString("ifscCode")));
            }
            f3437t = new C1384b(arrayList2, this.f3446j.getApplicationContext());
            final String str6 = str3;
            this.f3446j.runOnUiThread(new Runnable(this) {
                final /* synthetic */ JsInterface f3395d;

                class C13931 implements OnItemClickListener {
                    final /* synthetic */ AnonymousClass36 f3391a;

                    C13931(AnonymousClass36 anonymousClass36) {
                        this.f3391a = anonymousClass36;
                    }

                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        JSONObject jSONObject = new JSONObject();
                        C1422d c1422d = (C1422d) ((ArrayList) this.f3391a.f3395d.f3443f.get(Integer.valueOf(parseInt))).get(i);
                        c1422d.m5391a(j);
                        c1422d.m5392a(view);
                        try {
                            jSONObject.put("number", c1422d.m5395c().toString());
                            jSONObject.put(CLConstants.FIELD_PAY_INFO_NAME, c1422d.m5394b().toString());
                            jSONObject.put("bankName", c1422d.m5396d().toString());
                            jSONObject.put("ifscCode", c1422d.m5397e().toString());
                            jSONObject.put("position", i);
                            this.f3391a.f3395d.f3447k.m4567a("window.callUICallback(\"" + str6 + "\", " + jSONObject.toString() + ");");
                        } catch (JSONException e) {
                        }
                    }
                }

                public void run() {
                    listView.setAdapter(JsInterface.f3437t);
                    listView.setOnItemClickListener(new C13931(this));
                }
            });
            return;
        }
        if (listView != null) {
            this.f3442e.put(Integer.valueOf(parseInt), arrayList);
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
            arrayList.add(new C1385c(jSONObject2.getString("avatar"), jSONObject2.getString(CLConstants.FIELD_PAY_INFO_NAME), jSONObject2.getString("number")));
        }
        f3436s = new C1381a(arrayList, this.f3446j.getApplicationContext());
        str6 = str3;
        this.f3446j.runOnUiThread(new Runnable(this) {
            final /* synthetic */ JsInterface f3400d;

            class C13941 implements OnItemClickListener {
                final /* synthetic */ AnonymousClass37 f3396a;

                C13941(AnonymousClass37 anonymousClass37) {
                    this.f3396a = anonymousClass37;
                }

                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    JSONObject jSONObject = new JSONObject();
                    C1385c c1385c = (C1385c) ((ArrayList) this.f3396a.f3400d.f3442e.get(Integer.valueOf(parseInt))).get(i);
                    c1385c.m5284a(j);
                    c1385c.m5285a(view);
                    try {
                        jSONObject.put("number", c1385c.m5288c().toString());
                        jSONObject.put("position", i);
                        this.f3396a.f3400d.f3447k.m4567a("window.callUICallback(\"" + str6 + "\", " + jSONObject.toString() + ");");
                    } catch (JSONException e) {
                    }
                }
            }

            public void run() {
                listView.setAdapter(JsInterface.f3436s);
                listView.setOnItemClickListener(new C13941(this));
            }
        });
    }

    @JavascriptInterface
    public void toggleSelection(int i, int i2, String str) {
        ArrayList arrayList = (ArrayList) this.f3442e.get(Integer.valueOf(i));
        ArrayList arrayList2 = (ArrayList) this.f3443f.get(Integer.valueOf(i));
        if (str.equals("IFSC")) {
            if (arrayList2 != null) {
                final C1422d c1422d = (C1422d) arrayList2.get(i2);
                if (c1422d.m5399g() != null) {
                    this.f3446j.runOnUiThread(new Runnable(this) {
                        ImageView f3401a = ((ImageView) c1422d.m5399g().findViewById(2131558556));
                        ImageView f3402b = ((ImageView) c1422d.m5399g().findViewById(2131558559));
                        LinearLayout f3403c = ((LinearLayout) c1422d.m5399g().findViewById(2131558553));
                        LinearLayout f3404d = ((LinearLayout) c1422d.m5399g().findViewById(2131558555));
                        final /* synthetic */ JsInterface f3406f;

                        public void run() {
                            if (this.f3401a.getVisibility() == 8) {
                                this.f3402b.setVisibility(8);
                                this.f3403c.setVisibility(8);
                                this.f3401a.setVisibility(0);
                                this.f3404d.setVisibility(0);
                                c1422d.m5393a(Boolean.valueOf(true));
                                return;
                            }
                            this.f3402b.setVisibility(0);
                            this.f3403c.setVisibility(0);
                            this.f3401a.setVisibility(8);
                            this.f3404d.setVisibility(8);
                            c1422d.m5393a(Boolean.valueOf(false));
                        }
                    });
                }
            }
        } else if (arrayList != null) {
            final C1385c c1385c = (C1385c) arrayList.get(i2);
            if (c1385c.m5290e() != null) {
                this.f3446j.runOnUiThread(new Runnable(this) {
                    ImageView f3407a = ((ImageView) c1385c.m5290e().findViewById(2131558556));
                    TextView f3408b = ((TextView) c1385c.m5290e().findViewById(2131558554));
                    LinearLayout f3409c = ((LinearLayout) c1385c.m5290e().findViewById(2131558553));
                    LinearLayout f3410d = ((LinearLayout) c1385c.m5290e().findViewById(2131558555));
                    final /* synthetic */ JsInterface f3412f;

                    public void run() {
                        if (this.f3407a.getVisibility() == 8) {
                            this.f3408b.setVisibility(8);
                            this.f3409c.setVisibility(8);
                            this.f3407a.setVisibility(0);
                            this.f3410d.setVisibility(0);
                            c1385c.m5286a(Boolean.valueOf(true));
                            return;
                        }
                        this.f3408b.setVisibility(0);
                        this.f3409c.setVisibility(0);
                        this.f3407a.setVisibility(8);
                        this.f3410d.setVisibility(8);
                        c1385c.m5286a(Boolean.valueOf(false));
                    }
                });
            }
        }
    }

    @JavascriptInterface
    public void toggleDeSelection(int i, String str) {
        int i2 = 0;
        ArrayList arrayList = (ArrayList) this.f3442e.get(Integer.valueOf(i));
        ArrayList arrayList2 = (ArrayList) this.f3443f.get(Integer.valueOf(i));
        int size;
        if (str.equals("IFSC")) {
            if (arrayList2 != null) {
                size = arrayList2.size();
                while (i2 < size) {
                    final C1422d c1422d = (C1422d) arrayList2.get(i2);
                    if (c1422d.m5399g() != null) {
                        this.f3446j.runOnUiThread(new Runnable(this) {
                            ImageView f3361a = ((ImageView) c1422d.m5399g().findViewById(2131558556));
                            ImageView f3362b = ((ImageView) c1422d.m5399g().findViewById(2131558559));
                            LinearLayout f3363c = ((LinearLayout) c1422d.m5399g().findViewById(2131558553));
                            LinearLayout f3364d = ((LinearLayout) c1422d.m5399g().findViewById(2131558555));
                            final /* synthetic */ JsInterface f3366f;

                            public void run() {
                                if (this.f3361a.getVisibility() != 8) {
                                    this.f3362b.setVisibility(0);
                                    this.f3363c.setVisibility(0);
                                    this.f3361a.setVisibility(8);
                                    this.f3364d.setVisibility(8);
                                }
                                c1422d.m5393a(Boolean.valueOf(false));
                            }
                        });
                    }
                    i2++;
                }
            }
        } else if (arrayList != null) {
            size = arrayList.size();
            while (i2 < size) {
                final C1385c c1385c = (C1385c) arrayList.get(i2);
                if (c1385c.m5290e() != null) {
                    this.f3446j.runOnUiThread(new Runnable(this) {
                        ImageView f3413a = ((ImageView) c1385c.m5290e().findViewById(2131558556));
                        TextView f3414b = ((TextView) c1385c.m5290e().findViewById(2131558554));
                        LinearLayout f3415c = ((LinearLayout) c1385c.m5290e().findViewById(2131558553));
                        LinearLayout f3416d = ((LinearLayout) c1385c.m5290e().findViewById(2131558555));
                        final /* synthetic */ JsInterface f3418f;

                        public void run() {
                            if (this.f3413a.getVisibility() != 8) {
                                this.f3414b.setVisibility(0);
                                this.f3415c.setVisibility(0);
                                this.f3413a.setVisibility(8);
                                this.f3416d.setVisibility(8);
                            }
                            c1385c.m5286a(Boolean.valueOf(false));
                        }
                    });
                }
                i2++;
            }
        }
    }

    @JavascriptInterface
    @TargetApi(11)
    public void calendar(final String str, final int i, final int i2) {
        this.f3446j.runOnUiThread(new Runnable(this) {
            final /* synthetic */ JsInterface f3424d;

            public void run() {
                final Calendar instance = Calendar.getInstance();
                this.f3424d.f3452p = new DatePickerDialog(this.f3424d.f3446j, new OnDateSetListener(this) {
                    final /* synthetic */ C13974 f3420b;

                    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                        instance.set(1, i);
                        instance.set(2, i2);
                        instance.set(5, i3);
                        this.f3420b.f3424d.f3447k.m4567a(String.format("window.callJSCallback('%s','%s');", new Object[]{str, i + "/" + (i2 + 1) + "/" + i3}));
                    }
                }, instance.get(1), instance.get(2), instance.get(5));
                if (i != Integer.MIN_VALUE) {
                    this.f3424d.f3452p.getDatePicker().setMinDate((System.currentTimeMillis() - 1000) - TimeUnit.DAYS.toMillis((long) i));
                }
                if (i2 != Integer.MAX_VALUE) {
                    instance.add(5, i2);
                    this.f3424d.f3452p.getDatePicker().setMaxDate(instance.getTimeInMillis());
                }
                this.f3424d.f3452p.show();
            }
        });
    }

    private boolean m5311d() {
        C0747b a = C0747b.m3202a();
        int a2 = a.m3204a(this.f3446j);
        if (a2 == 0) {
            return true;
        }
        if (a.m3209a(a2)) {
            a.m3205a(this.f3446j, a2, 9000).show();
        }
        return false;
    }

    @JavascriptInterface
    public void downloadFile(final String str, final boolean z, final String str2) {
        C1380a.m5275a(f3435h, "Download File - " + str);
        new AsyncTask(this) {
            final /* synthetic */ JsInterface f3428d;

            protected Object doInBackground(Object[] objArr) {
                Boolean.valueOf(false);
                try {
                    Boolean a = C1445h.m5495a(this.f3428d.f3446j.getApplicationContext(), str, z);
                    C1380a.m5275a(JsInterface.f3435h, a.toString() + " " + str);
                    return a.toString();
                } catch (Exception e) {
                    C1380a.m5275a(JsInterface.f3435h, e.getMessage());
                    return "FAILURE";
                }
            }

            protected void onPostExecute(Object obj) {
                if (str2 != null) {
                    this.f3428d.f3447k.m4567a("window." + str2 + "(\"" + ((String) obj) + "\", \"" + str + "\");");
                }
            }
        }.execute(new Object[0]);
    }

    @JavascriptInterface
    public boolean isDualSIM() {
        return C1420e.m5384a(this.f3446j);
    }

    @JavascriptInterface
    public String getDeviceDetails() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CLConstants.SALT_FIELD_DEVICE_ID, C1447j.m5498a(this.f3446j));
            jSONObject.put("os", "ANDROID");
            jSONObject.put("version", VERSION.RELEASE);
            jSONObject.put("manufacturer", Build.MANUFACTURER);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("packageName", this.f3446j.getPackageName());
        } catch (Throwable e) {
            C1380a.m5278a(e);
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public int AndroidVersion() {
        return VERSION.SDK_INT;
    }

    @JavascriptInterface
    public String getsymbols(String str) {
        Object obj = -1;
        switch (str.hashCode()) {
            case 3559837:
                if (str.equals("tick")) {
                    obj = null;
                    break;
                }
                break;
            case 108877805:
                if (str.equals("rupee")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                return "✓";
            case 1:
                return "₹";
            default:
                return "symbol";
        }
    }

    @JavascriptInterface
    public void restart() {
        Intent launchIntentForPackage = this.f3446j.getBaseContext().getPackageManager().getLaunchIntentForPackage(this.f3446j.getBaseContext().getPackageName());
        launchIntentForPackage.addFlags(67108864);
        this.f3446j.startActivity(launchIntentForPackage);
    }

    @SuppressLint({"NewApi"})
    public void m5316a(int i, String[] strArr, int[] iArr) {
        C1380a.m5275a(f3435h, "Permission Granted - " + String.valueOf(i));
        if (this.f3447k == null) {
            C1380a.m5275a(f3435h, "DUI is null");
            return;
        }
        switch (i) {
            case 1:
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (int i2 = 0; i2 < iArr.length; i2++) {
                        if (iArr[i2] != -1) {
                            jSONObject.put(strArr[i2], "GRANTED");
                            C1421f.m5388a().m5389a("PERMISSION", strArr[i2] + "_GRANTED");
                        } else if (this.f3446j.shouldShowRequestPermissionRationale(strArr[i2])) {
                            jSONObject.put(strArr[i2], "DENIED");
                            C1421f.m5388a().m5389a("PERMISSION", strArr[i2] + "_DENIED");
                        } else {
                            jSONObject.put(strArr[i2], "EVERDENIED");
                            C1421f.m5388a().m5389a("PERMISSION", strArr[i2] + "_EVERDENIED");
                        }
                    }
                    this.f3447k.m4567a("window.callUICallback(\"" + this.f3451o + "\", " + jSONObject.toString() + ");");
                    return;
                } catch (Exception e) {
                    this.f3447k.m4567a("window.callUICallback(\"" + this.f3451o + "\", \"ERROR\");");
                    return;
                }
            default:
                return;
        }
    }

    @JavascriptInterface
    public void sendSMS(String str, String str2, String str3, final String str4) {
        this.f3448l = new BroadcastReceiver(this) {
            final /* synthetic */ JsInterface f3430b;

            public void onReceive(Context context, Intent intent) {
                switch (getResultCode()) {
                    case -1:
                        this.f3430b.f3447k.m4567a("window.callUICallback(\"" + str4 + "\", \"SUCCESS\")");
                        break;
                    case 1:
                        this.f3430b.f3447k.m4567a("window.callUICallback(\"" + str4 + "\", \"Sms Sending Failed\", \"837\")");
                        break;
                    case 2:
                        this.f3430b.f3447k.m4567a("window.callUICallback(\"" + str4 + "\", \"Sms Sending Failed. Airplane Mode ON\", \"840\")");
                        break;
                    case 3:
                        this.f3430b.f3447k.m4567a("window.callUICallback(\"" + str4 + "\", \"Sms Sending Failed\", \"839\")");
                        break;
                    case 4:
                        this.f3430b.f3447k.m4567a("window.callUICallback(\"" + str4 + "\", \"Sms Sending Failed. No service\", \"838\")");
                        break;
                    default:
                        this.f3430b.f3447k.m4567a("window.callUICallback(\"" + str4 + "\", \"Sms Sending Failed\", \"837\")");
                        break;
                }
                if (getResultCode() == -1) {
                    C1421f.m5388a().m5389a("INFO", "SMS_SENT_VERIFY_MOBILE");
                } else {
                    C1421f.m5388a().m5389a("INFO", "SMS_SENDING_FAILED_VERIFY_MOBILE");
                }
            }
        };
        this.f3449m = new C14007(this);
        PendingIntent broadcast = PendingIntent.getBroadcast(this.f3446j, 0, new Intent("SMS_SENT"), 0);
        PendingIntent broadcast2 = PendingIntent.getBroadcast(this.f3446j, 0, new Intent("SMS_DELIVERED"), 0);
        this.f3446j.registerReceiver(this.f3448l, new IntentFilter("SMS_SENT"));
        this.f3446j.registerReceiver(this.f3449m, new IntentFilter("SMS_DELIVERED"));
        C1420e.m5385a(this.f3446j, Integer.parseInt(str), str2, null, str3, broadcast, broadcast2);
    }

    @JavascriptInterface
    public void unregisterReceiver() {
        if (this.f3448l != null && this.f3449m != null) {
            this.f3446j.unregisterReceiver(this.f3448l);
            this.f3446j.unregisterReceiver(this.f3449m);
        }
    }

    @JavascriptInterface
    public void showKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.f3446j.getApplicationContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.toggleSoftInput(1, 0);
        }
    }

    @JavascriptInterface
    public void hideKeyboard() {
        if (this.f3446j.getCurrentFocus() != null) {
            ((InputMethodManager) this.f3446j.getApplicationContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f3446j.getCurrentFocus().getWindowToken(), 0);
        }
    }

    @JavascriptInterface
    public void suppressKeyboard() {
        this.f3446j.runOnUiThread(new C14018(this));
    }

    @JavascriptInterface
    public String getKey(String str, String str2) {
        return this.f3444g.m5484b(str, str2);
    }

    @JavascriptInterface
    public void removeKey(String str) {
        this.f3444g.m5482a(str);
    }

    @JavascriptInterface
    public void minimizeApp() {
        hideKeyboard();
        this.f3446j.moveTaskToBack(true);
    }

    @JavascriptInterface
    public boolean isPermissionGranted(String[] strArr) {
        boolean z = true;
        for (String a : strArr) {
            if (C0023a.m76a(this.f3446j, a) != 0) {
                z &= 0;
            } else {
                z &= 1;
            }
        }
        return z;
    }

    @JavascriptInterface
    public void checkPermission(final String[] strArr, String str) {
        this.f3451o = str;
        if (VERSION.SDK_INT >= 23) {
            this.f3446j.runOnUiThread(new Runnable(this) {
                final /* synthetic */ JsInterface f3434b;

                public void run() {
                    JSONObject jSONObject = new JSONObject();
                    List arrayList = new ArrayList();
                    String[] strArr = strArr;
                    int length = strArr.length;
                    int i = 0;
                    int i2 = 1;
                    while (i < length) {
                        int i3;
                        String str = strArr[i];
                        if (C0023a.m76a(this.f3434b.f3446j, str) != 0) {
                            arrayList.add(str);
                            i3 = 0;
                        } else {
                            try {
                                jSONObject.put(str, "GRANTED");
                                i3 = i2;
                            } catch (Exception e) {
                                i3 = i2;
                            }
                        }
                        i++;
                        i2 = i3;
                    }
                    String[] strArr2 = (String[]) arrayList.toArray(new String[arrayList.size()]);
                    if (i2 != 0) {
                        this.f3434b.f3447k.m4567a("window.callUICallback(\"" + this.f3434b.f3451o + "\", " + jSONObject.toString() + ");");
                    }
                    if (arrayList.size() != 0) {
                        C0050a.m206a(this.f3434b.f3446j, strArr2, 1);
                    }
                }
            });
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("STATUS", "SUCCESS");
            this.f3447k.m4567a("window.callUICallback(\"" + this.f3451o + "\", " + jSONObject.toString() + ");");
        } catch (Exception e) {
            this.f3447k.m4567a("window.callUICallback(\"" + this.f3451o + "\", \"ERROR\");");
        }
    }

    @JavascriptInterface
    public boolean isNetworkAvailable() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f3446j.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @JavascriptInterface
    public boolean isSimSupport() {
        return C1420e.m5386b(this.f3446j);
    }

    @JavascriptInterface
    public void setKey(String str, String str2) {
        this.f3444g.m5483a(str, str2);
    }

    @JavascriptInterface
    public void clearPreferences() {
        this.f3444g.m5481a(this.f3446j);
    }

    @JavascriptInterface
    public void closeApp() {
        this.f3446j.finish();
    }

    @JavascriptInterface
    public String getResource(String str) {
        int identifier = this.f3446j.getResources().getIdentifier(str, "string", this.f3446j.getPackageName());
        if (identifier != 0) {
            return this.f3446j.getResources().getString(identifier);
        }
        return null;
    }

    @JavascriptInterface
    public String getResource(String str, String str2) {
        int identifier = this.f3446j.getResources().getIdentifier(str, str2, this.f3446j.getPackageName());
        if (identifier != 0) {
            return this.f3446j.getResources().getString(identifier);
        }
        return null;
    }

    @JavascriptInterface
    public void shoutOut(String str) {
        C1380a.m5275a(f3435h, "Shoutout - " + str);
    }

    @JavascriptInterface
    public void logging(String str) {
        C1380a.m5279b("Console", str);
    }

    @JavascriptInterface
    public String name() {
        String str = "";
        Cursor query = this.f3446j.getApplication().getContentResolver().query(Profile.CONTENT_URI, null, null, null, null);
        if (query == null) {
            return str;
        }
        query.moveToFirst();
        String string = query.getString(query.getColumnIndex("display_name"));
        query.close();
        return string;
    }

    @JavascriptInterface
    public String baseCheck(String str) {
        return Base64.encodeToString(str.getBytes("UTF-8"), 0);
    }

    public String m5315a(String str) {
        return new String(Base64.decode(str, 0), "UTF-8");
    }

    @JavascriptInterface
    public void callAPI(String str, String str2, String str3, String str4, boolean z, String str5) {
        final String a = m5315a(str4);
        final String a2 = m5315a(str3);
        final String str6 = str5;
        final String str7 = str2;
        final String str8 = str;
        final boolean z2 = z;
        new AsyncTask(this) {
            final /* synthetic */ JsInterface f3284g;

            protected /* synthetic */ Object doInBackground(Object[] objArr) {
                return m5294a(objArr);
            }

            protected void onPostExecute(Object obj) {
                if (obj != null) {
                    ApiResponse apiResponse = (ApiResponse) obj;
                    String str = "";
                    if (apiResponse.getStatusCode() < 200 || apiResponse.getStatusCode() > 304) {
                        str = "failure";
                    } else {
                        str = "success";
                    }
                    C1380a.m5275a(JsInterface.f3435h, "Response Success: " + str6);
                    byte[] data = apiResponse.getData();
                    if (data == null) {
                        try {
                            data = "{}".getBytes("UTF-8");
                        } catch (UnsupportedEncodingException e) {
                        }
                    }
                    String encodeToString = Base64.encodeToString(data, 2);
                    try {
                        str = String.format("window.callJSCallback('%s','%s','%s','%s','%s');", new Object[]{str6, str, encodeToString, Integer.valueOf(apiResponse.getStatusCode()), Base64.encodeToString(str7.getBytes("UTF-8"), 2)});
                    } catch (UnsupportedEncodingException e2) {
                        str = null;
                    }
                    C1380a.m5275a(JsInterface.f3435h, str);
                    this.f3284g.f3447k.m4567a(str);
                }
            }

            protected ApiResponse m5294a(Object[] objArr) {
                C1380a.m5275a(JsInterface.f3435h, "Now calling API :" + str7);
                C1380a.m5275a(JsInterface.f3435h, "API Request parameter : URL ->" + str7 + "- Method -> " + str8);
                C1380a.m5275a(JsInterface.f3435h, "API Request parameter : Data ->" + a2 + "- Header -> " + a);
                HashMap hashMap = new HashMap();
                try {
                    JSONObject jSONObject = new JSONObject(a);
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String str = (String) keys.next();
                        hashMap.put(str, jSONObject.getString(str));
                    }
                    C1380a.m5275a(JsInterface.f3435h, "API Request Header : Header -> " + hashMap);
                    if (str8.equalsIgnoreCase("POST")) {
                        C1380a.m5275a(JsInterface.f3435h, "METHOD - " + str8);
                        C1380a.m5275a(JsInterface.f3435h, "URL - " + str7);
                        C1380a.m5275a(JsInterface.f3435h, "REQUEST-BODY - " + a2);
                        C1380a.m5275a(JsInterface.f3435h, "HEADER - " + hashMap);
                        return RestClient.m5426a(str7, a2, hashMap, z2);
                    } else if (str8.equalsIgnoreCase("GET")) {
                        C1380a.m5275a(JsInterface.f3435h, "METHOD:  - " + str8);
                        C1380a.m5275a(JsInterface.f3435h, "URL - " + str7);
                        return RestClient.m5428a(str7, new HashMap(), hashMap, z2);
                    } else if (!str8.equalsIgnoreCase("DELETE")) {
                        return null;
                    } else {
                        C1380a.m5275a(JsInterface.f3435h, "METHOD:  - " + str8);
                        C1380a.m5275a(JsInterface.f3435h, "URL - " + str7);
                        return RestClient.m5439b(str7, new HashMap(), hashMap, z2);
                    }
                } catch (Throwable e) {
                    Throwable th = e;
                    C1380a.m5278a(th);
                    ApiResponse apiResponse = new ApiResponse();
                    apiResponse.setStatusCode(-1);
                    try {
                        apiResponse.setData(th.getLocalizedMessage().getBytes("UTF-8"));
                        return apiResponse;
                    } catch (UnsupportedEncodingException e2) {
                        return apiResponse;
                    }
                }
            }
        }.execute(new Object[0]);
    }

    @JavascriptInterface
    public void sendMerchantResponseIntent(final String str) {
        this.f3446j.runOnUiThread(new Runnable(this) {
            final /* synthetic */ JsInterface f3286b;

            public void run() {
                if (this.f3286b.f3446j instanceof HomeActivity) {
                    ((HomeActivity) this.f3286b.f3446j).m5227a(str);
                }
            }
        });
    }

    @JavascriptInterface
    public String getSIMOperators() {
        return C1420e.m5387c(this.f3446j);
    }

    @JavascriptInterface
    public void showQrCode(String str, String str2, String str3, boolean z) {
        final String str4 = str3;
        final String str5 = str2;
        final boolean z2 = z;
        final String str6 = str;
        this.f3446j.runOnUiThread(new Runnable(this) {
            final /* synthetic */ JsInterface f3294e;

            public void run() {
                if (this.f3294e.f3446j instanceof HomeActivity) {
                    try {
                        ((ImageView) this.f3294e.f3446j.findViewById(Integer.parseInt(str6))).setImageBitmap(((HomeActivity) this.f3294e.f3446j).m5224a(str4, str5, z2));
                    } catch (Throwable e) {
                        C1380a.m5276a(JsInterface.f3435h, "Exception showing QR Code", e);
                    }
                }
            }
        });
    }

    @JavascriptInterface
    public void loadImageForQr() {
        ((HomeActivity) this.f3446j).m5234o().closeQRScanner();
        this.f3446j.startActivityForResult(new Intent("android.intent.action.PICK", Media.EXTERNAL_CONTENT_URI), this.f3454r);
    }

    @JavascriptInterface
    public void deleteQrCode(String str) {
        removeInternalFilePath(str);
    }

    @JavascriptInterface
    public void sendEmail(final String str, final String str2) {
        this.f3446j.runOnUiThread(new Runnable(this) {
            final /* synthetic */ JsInterface f3297c;

            public void run() {
                if (this.f3297c.f3446j instanceof HomeActivity) {
                    Intent intent = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", str, null));
                    intent.putExtra("android.intent.extra.SUBJECT", str2);
                    this.f3297c.f3446j.startActivity(Intent.createChooser(intent, "Send email"));
                }
            }
        });
    }

    @JavascriptInterface
    public void shareQrCode(String str, String str2, String str3, String str4, boolean z) {
        final String str5 = str2;
        final boolean z2 = z;
        final String str6 = str;
        final String str7 = str4;
        final String str8 = str3;
        this.f3446j.runOnUiThread(new Runnable(this) {
            final /* synthetic */ JsInterface f3303f;

            public void run() {
                if (this.f3303f.f3446j instanceof HomeActivity) {
                    File saveToExternalStorage;
                    HomeActivity homeActivity = (HomeActivity) this.f3303f.f3446j;
                    File externalFilePath = this.f3303f.getExternalFilePath(str5);
                    if (z2 || !externalFilePath.exists()) {
                        homeActivity.m5224a(str5, str6, true);
                        saveToExternalStorage = this.f3303f.saveToExternalStorage(str5, this.f3303f.getInternalFilePath(str5).getAbsolutePath());
                    } else {
                        saveToExternalStorage = externalFilePath;
                    }
                    Parcelable fromFile = Uri.fromFile(saveToExternalStorage);
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("image/png");
                    intent.putExtra("android.intent.extra.STREAM", fromFile);
                    intent.putExtra("android.intent.extra.SUBJECT", str7);
                    intent.putExtra("android.intent.extra.TEXT", str8);
                    this.f3303f.f3446j.startActivity(Intent.createChooser(intent, "Share via"));
                }
            }
        });
    }

    @JavascriptInterface
    public void speakText(String str) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f3445i.getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(16384);
            obtain.setClassName(getClass().getName());
            obtain.setPackageName(this.f3445i.getPackageName());
            obtain.getText().add(str);
            accessibilityManager.sendAccessibilityEvent(obtain);
        }
    }

    @JavascriptInterface
    public void shareReferalCode(final String str, final String str2, boolean z) {
        this.f3446j.runOnUiThread(new Runnable(this) {
            final /* synthetic */ JsInterface f3306c;

            public void run() {
                if (this.f3306c.f3446j instanceof HomeActivity) {
                    HomeActivity homeActivity = (HomeActivity) this.f3306c.f3446j;
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("text/plain");
                    intent.putExtra("android.intent.extra.SUBJECT", str2);
                    intent.putExtra("android.intent.extra.TEXT", str);
                    this.f3306c.f3446j.startActivity(Intent.createChooser(intent, "Share via"));
                }
            }
        });
    }

    @JavascriptInterface
    public File getInternalFilePath(String str) {
        return new File(new ContextWrapper(this.f3446j).getDir("imageDir", 0), str);
    }

    @JavascriptInterface
    public File getExternalFilePath(String str) {
        new ContextWrapper(this.f3446j).getExternalFilesDir("imageDir");
        return new File((Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + getAppName()) + str);
    }

    @JavascriptInterface
    public void removeExternalFilePath(String str) {
        new ContextWrapper(this.f3446j).getExternalFilesDir("imageDir");
        new File((Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + getAppName()) + str).delete();
    }

    @JavascriptInterface
    public void removeInternalFilePath(String str) {
        new File(new ContextWrapper(this.f3446j).getDir("imageDir", 0), str).delete();
    }

    @JavascriptInterface
    public String getAppName() {
        return this.f3446j.getString(2131165239);
    }

    @JavascriptInterface
    public File saveToExternalStorage(String str, String str2) {
        try {
            new ContextWrapper(this.f3446j).getExternalFilesDir("imageDir");
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + getAppName());
            if (!file.exists()) {
                file.mkdirs();
            }
            new File(file, ".nomedia").createNewFile();
            File file2 = new File(file, str);
            copyFile(file2.getAbsolutePath(), str2);
            return file2;
        } catch (Throwable e) {
            C1380a.m5276a(f3435h, "Exception when saving to external storage", e);
            return null;
        }
    }

    @JavascriptInterface
    public void copyFile(String str, String str2) {
        InputStream fileInputStream = new FileInputStream(str2);
        OutputStream fileOutputStream = new FileOutputStream(str);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read != -1) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileInputStream.close();
                fileOutputStream.flush();
                fileOutputStream.close();
                return;
            }
        }
    }

    @JavascriptInterface
    public boolean isExternalStorageWritable() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    @JavascriptInterface
    public boolean isExternalStorageReadable() {
        String externalStorageState = Environment.getExternalStorageState();
        return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
    }

    @JavascriptInterface
    public String viewToImage(String str, String str2, String str3) {
        final String[] strArr = new String[]{null};
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        this.f3446j.runOnUiThread(new Runnable(this) {
            final /* synthetic */ JsInterface f3311e;

            public void run() {
                try {
                    LinearLayout linearLayout = (LinearLayout) this.f3311e.f3446j.findViewById(Integer.parseInt(str4));
                    linearLayout.setDrawingCacheEnabled(true);
                    linearLayout.buildDrawingCache();
                    new File(Environment.getExternalStorageDirectory() + File.separator + "Pictures").mkdirs();
                    new File(Environment.getExternalStorageDirectory() + File.separator + "DCIM/Camera").mkdirs();
                    strArr[0] = Media.insertImage(this.f3311e.f3446j.getContentResolver(), linearLayout.getDrawingCache(), str5, "");
                    this.f3311e.f3447k.m4567a(String.format("window.callJSCallback('%s','%s');", new Object[]{str6, "" + strArr[0]}));
                } catch (Throwable e) {
                    C1380a.m5276a(JsInterface.f3435h, "Exception", e);
                }
            }
        });
        return strArr[0];
    }

    @JavascriptInterface
    public String isDeviceRooted() {
        boolean z;
        JSONObject jSONObject = new JSONObject();
        String str = Build.TAGS;
        if (str == null || !str.contains("test-keys")) {
            z = false;
        } else {
            z = true;
        }
        jSONObject.put("buildTagStrategy", z);
        z = false;
        for (String str2 : this.f3453q) {
            z = new File(str2 + "/su").exists();
            if (z) {
                C1380a.m5277a(f3435h, str2 + " contains su binary", false);
                break;
            }
        }
        jSONObject.put("pathStrategy", z);
        return jSONObject.toString();
    }

    @JavascriptInterface
    public String getInstalledAccessiblityServices() {
        JSONArray jSONArray = new JSONArray();
        if (VERSION.SDK_INT >= 14) {
            for (AccessibilityServiceInfo accessibilityServiceInfo : ((AccessibilityManager) this.f3445i.getSystemService("accessibility")).getInstalledAccessibilityServiceList()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("package", accessibilityServiceInfo.packageNames);
                    jSONObject.put(CLConstants.FIELD_PAY_INFO_NAME, accessibilityServiceInfo.getId());
                    jSONArray.put(jSONObject);
                } catch (Throwable e) {
                    C1380a.m5276a(f3435h, "Exception in function getInstalledAccessiblityServices", e);
                }
            }
        }
        return jSONArray.toString();
    }

    @JavascriptInterface
    public String getAppsWithDrawOverOthers() {
        PackageManager packageManager = this.f3445i.getPackageManager();
        List<PackageInfo> installedPackages = packageManager.getInstalledPackages(CodedOutputStream.DEFAULT_BUFFER_SIZE);
        JSONArray jSONArray = new JSONArray();
        for (PackageInfo packageInfo : installedPackages) {
            if (packageInfo.requestedPermissions != null) {
                for (String str : packageInfo.requestedPermissions) {
                    if (str.equalsIgnoreCase("android.permission.SYSTEM_ALERT_WINDOW")) {
                        boolean z;
                        if (packageManager.checkPermission(str, packageInfo.packageName) == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("package", packageInfo.packageName);
                            jSONObject.put(CLConstants.FIELD_PAY_INFO_NAME, getAppNameFromPackage(packageInfo.packageName));
                            jSONObject.put("targetSdkVersion", packageInfo.applicationInfo.targetSdkVersion);
                            jSONObject.put("available", z);
                            jSONArray.put(jSONObject);
                            C1380a.m5275a(f3435h, "Permission matched for package = [" + packageInfo.packageName + "], [" + packageInfo.applicationInfo.targetSdkVersion + "], [" + z + "]");
                        } catch (Throwable e) {
                            C1380a.m5276a(f3435h, "Exception in function getAppsWithDrawOverOthers", e);
                        }
                    }
                }
            }
        }
        return jSONArray.toString();
    }

    @JavascriptInterface
    public void openGallery(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.parse(str), "image/*");
        this.f3446j.startActivity(intent);
    }

    @JavascriptInterface
    public String getAppNameFromPackage(String str) {
        ApplicationInfo applicationInfo;
        PackageManager packageManager = this.f3445i.getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(str, 0);
        } catch (NameNotFoundException e) {
            applicationInfo = null;
        }
        return (String) (applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo) : "(unknown)");
    }

    @JavascriptInterface
    public void setClickFeedback(final String str) {
        this.f3446j.runOnUiThread(new Runnable(this) {
            final /* synthetic */ JsInterface f3313b;

            public void run() {
                try {
                    Integer valueOf = Integer.valueOf(str);
                    View findViewById = this.f3313b.f3446j.findViewById(valueOf.intValue());
                    TypedValue typedValue = new TypedValue();
                    this.f3313b.f3446j.getTheme().resolveAttribute(2130772056, typedValue, true);
                    if (findViewById != null) {
                        findViewById.setBackgroundResource(typedValue.resourceId);
                    } else {
                        C1380a.m5279b(JsInterface.f3435h, "Unable to find view with resID - " + str + " : " + valueOf);
                    }
                } catch (Exception e) {
                }
            }
        });
    }

    @JavascriptInterface
    public void startInstalledAppDetailsActivity() {
        this.f3446j.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + this.f3446j.getPackageName())));
    }

    @JavascriptInterface
    public void saveToClipboard(String str) {
        if (VERSION.SDK_INT < 11) {
            ((ClipboardManager) this.f3446j.getSystemService("clipboard")).setText(str);
        } else {
            ((android.content.ClipboardManager) this.f3446j.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Copied Text", str));
        }
    }

    @JavascriptInterface
    public String getSha256MessageDigestInHex(String str) {
        return C1436b.m5450b(str);
    }

    @JavascriptInterface
    public void startCallIntent(final String str, final String str2) {
        this.f3446j.runOnUiThread(new Runnable(this) {
            final /* synthetic */ JsInterface f3316c;

            public void run() {
                try {
                    ((HomeActivity) this.f3316c.f3446j).m5228a(str, str2);
                } catch (SecurityException e) {
                    C1380a.m5279b(JsInterface.f3435h, "No permission to open this");
                }
            }
        });
    }

    @JavascriptInterface
    public void startDialIntent(String str) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:" + str));
        this.f3446j.startActivity(intent);
    }

    @JavascriptInterface
    @TargetApi(11)
    public void calender(final String str) {
        this.f3446j.runOnUiThread(new Runnable(this) {
            final /* synthetic */ JsInterface f3325b;

            public void run() {
                final Calendar instance = Calendar.getInstance();
                this.f3325b.f3452p = new DatePickerDialog(this.f3325b.f3446j, new OnDateSetListener(this) {
                    final /* synthetic */ AnonymousClass20 f3323b;

                    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                        instance.set(1, i);
                        instance.set(2, i2);
                        instance.set(5, i3);
                        this.f3323b.f3325b.f3447k.m4567a(String.format("window.callJSCallback('%s','%s');", new Object[]{str, i + "/" + (i2 + 1) + "/" + i3}));
                    }
                }, instance.get(1), instance.get(2), instance.get(5));
                this.f3325b.f3452p.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                instance.add(5, 45);
                this.f3325b.f3452p.getDatePicker().setMaxDate(instance.getTimeInMillis());
                this.f3325b.f3452p.show();
            }
        });
    }

    @JavascriptInterface
    @TargetApi(11)
    public void calenderTransaction(String str, String str2, String str3, String str4) {
        final String str5 = str;
        final String str6 = str4;
        final String str7 = str2;
        final String str8 = str3;
        this.f3446j.runOnUiThread(new Runnable(this) {
            final /* synthetic */ JsInterface f3332e;

            public void run() {
                final Calendar instance = Calendar.getInstance();
                OnDateSetListener c13891 = new OnDateSetListener(this) {
                    final /* synthetic */ AnonymousClass21 f3327b;

                    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                        instance.set(1, i);
                        instance.set(2, i2);
                        instance.set(5, i3);
                        this.f3327b.f3332e.f3447k.m4567a(String.format("window.callJSCallback('%s','%s');", new Object[]{str5, i + "/" + (i2 + 1) + "/" + i3}));
                    }
                };
                instance.setTimeInMillis(Long.valueOf(str6).longValue());
                this.f3332e.f3452p = new DatePickerDialog(this.f3332e.f3446j, c13891, instance.get(1), instance.get(2), instance.get(5));
                if (!(str7 == null || str7.isEmpty() || str7.equals("undefined"))) {
                    this.f3332e.f3452p.getDatePicker().setMinDate(Long.valueOf(str7).longValue());
                }
                if (!(str8 == null || str8.isEmpty() || str8.equals("undefined"))) {
                    this.f3332e.f3452p.getDatePicker().setMaxDate(Long.valueOf(str8).longValue());
                }
                this.f3332e.f3452p.show();
            }
        });
    }

    @JavascriptInterface
    @TargetApi(14)
    public void tada(final String str, final float f, final int i) {
        this.f3446j.runOnUiThread(new Runnable(this) {
            final /* synthetic */ JsInterface f3336d;

            public void run() {
                View findViewById = this.f3336d.f3446j.findViewById(Integer.parseInt(str));
                PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(View.SCALE_X, new Keyframe[]{Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.1f, 0.9f), Keyframe.ofFloat(0.2f, 0.9f), Keyframe.ofFloat(0.3f, 1.1f), Keyframe.ofFloat(0.4f, 1.1f), Keyframe.ofFloat(0.5f, 1.1f), Keyframe.ofFloat(0.6f, 1.1f), Keyframe.ofFloat(0.7f, 1.1f), Keyframe.ofFloat(0.8f, 1.1f), Keyframe.ofFloat(0.9f, 1.1f), Keyframe.ofFloat(1.0f, 1.0f)});
                PropertyValuesHolder ofKeyframe2 = PropertyValuesHolder.ofKeyframe(View.SCALE_Y, new Keyframe[]{Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.1f, 0.9f), Keyframe.ofFloat(0.2f, 0.9f), Keyframe.ofFloat(0.3f, 1.1f), Keyframe.ofFloat(0.4f, 1.1f), Keyframe.ofFloat(0.5f, 1.1f), Keyframe.ofFloat(0.6f, 1.1f), Keyframe.ofFloat(0.7f, 1.1f), Keyframe.ofFloat(0.8f, 1.1f), Keyframe.ofFloat(0.9f, 1.1f), Keyframe.ofFloat(1.0f, 1.0f)});
                PropertyValuesHolder ofKeyframe3 = PropertyValuesHolder.ofKeyframe(View.ROTATION, new Keyframe[]{Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.1f, f * -3.0f), Keyframe.ofFloat(0.2f, f * -3.0f), Keyframe.ofFloat(0.3f, 3.0f * f), Keyframe.ofFloat(0.4f, f * -3.0f), Keyframe.ofFloat(0.5f, 3.0f * f), Keyframe.ofFloat(0.6f, f * -3.0f), Keyframe.ofFloat(0.7f, 3.0f * f), Keyframe.ofFloat(0.8f, f * -3.0f), Keyframe.ofFloat(0.9f, 3.0f * f), Keyframe.ofFloat(1.0f, 0.0f)});
                ObjectAnimator.ofPropertyValuesHolder(findViewById, new PropertyValuesHolder[]{ofKeyframe, ofKeyframe2, ofKeyframe3}).setDuration((long) i).start();
            }
        });
    }

    @JavascriptInterface
    @TargetApi(14)
    public void nope(final String str, final int i, final int i2) {
        this.f3446j.runOnUiThread(new Runnable(this) {
            final /* synthetic */ JsInterface f3343d;

            public void run() {
                View findViewById = this.f3343d.f3446j.findViewById(Integer.parseInt(str));
                int a = this.f3343d.m5314a((float) i);
                PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(View.TRANSLATION_X, new Keyframe[]{Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.1f, (float) (-a)), Keyframe.ofFloat(0.26f, (float) a), Keyframe.ofFloat(0.42f, (float) (-a)), Keyframe.ofFloat(0.58f, (float) a), Keyframe.ofFloat(0.74f, (float) (-a)), Keyframe.ofFloat(0.9f, (float) a), Keyframe.ofFloat(1.0f, 0.0f)});
                ObjectAnimator.ofPropertyValuesHolder(findViewById, new PropertyValuesHolder[]{ofKeyframe}).setDuration((long) i2).start();
            }
        });
    }

    @JavascriptInterface
    @TargetApi(11)
    public void pulse(final String str, final float f, final int i) {
        this.f3446j.runOnUiThread(new Runnable(this) {
            final /* synthetic */ JsInterface f3347d;

            public void run() {
                try {
                    if (str == null) {
                        C1421f.m5388a().m5389a("INFO", "PULSE_EXCEPTION_VIEW_ID_NULL");
                        return;
                    }
                    View findViewById = this.f3347d.f3446j.findViewById(Integer.parseInt(str));
                    if (findViewById == null) {
                        C1421f.m5388a().m5389a("INFO", "PULSE_EXCEPTION_VIEW_NULL");
                        return;
                    }
                    r1 = new PropertyValuesHolder[2];
                    r1[0] = PropertyValuesHolder.ofFloat("scaleX", new float[]{f});
                    r1[1] = PropertyValuesHolder.ofFloat("scaleY", new float[]{f});
                    ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(findViewById, r1);
                    ofPropertyValuesHolder.setDuration((long) i);
                    ofPropertyValuesHolder.setRepeatCount(-1);
                    ofPropertyValuesHolder.setRepeatMode(2);
                    ofPropertyValuesHolder.setInterpolator(new C0315a());
                    ofPropertyValuesHolder.start();
                } catch (Throwable e) {
                    C1380a.m5278a(e);
                }
            }
        });
    }

    @JavascriptInterface
    public String getApplicationDetails() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("versionCode", 12);
            jSONObject.put("versionName", "1.4");
            jSONObject.put("applicationId", "in.org.npci.upiapp");
            jSONObject.put("configVersion", this.f3444g.m5484b("configVersion", ""));
            jSONObject.put("bundleVersion", this.f3444g.m5484b("bundleVersion", ""));
        } catch (Throwable e) {
            C1380a.m5278a(e);
        }
        return jSONObject.toString();
    }

    public int m5314a(float f) {
        return (int) (((float) (this.f3446j.getResources().getDisplayMetrics().densityDpi / 160)) * f);
    }

    @JavascriptInterface
    public void startBrowserIntent(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.f3446j.startActivity(intent);
    }

    @JavascriptInterface
    public String getHMACDigest(String str, String str2, String str3) {
        String str4 = null;
        try {
            Key secretKeySpec = new SecretKeySpec(str2.getBytes("UTF-8"), str3);
            Mac instance = Mac.getInstance(str3);
            instance.init(secretKeySpec);
            str4 = Base64.encodeToString(instance.doFinal(str.getBytes("ASCII")), 2);
        } catch (Throwable e) {
            C1380a.m5276a(f3435h, "Error encoding hmac ", e);
        } catch (Throwable e2) {
            C1380a.m5276a(f3435h, "Invalid HMAC key ", e2);
        } catch (Throwable e22) {
            C1380a.m5276a(f3435h, "NoSuchAlgorithmException ", e22);
        }
        return str4;
    }

    @JavascriptInterface
    public static String encryptAes(String str, String str2, String str3) {
        try {
            return C1436b.m5445a(str, str2, str3);
        } catch (Throwable e) {
            C1380a.m5276a(f3435h, "exception while encrypting AES token", e);
            return null;
        }
    }

    @JavascriptInterface
    public static String decryptAes(String str, String str2, String str3) {
        try {
            return C1436b.m5451b(str, str2, str3);
        } catch (Throwable e) {
            C1380a.m5276a(f3435h, "exception while decrypting AES token", e);
            return null;
        }
    }

    public String m5317b(String str) {
        return str.split("\\?")[0].split("#")[0].replaceAll("[^a-zA-Z0-9.]", C0670b.ROLL_OVER_FILE_NAME_SEPARATOR);
    }

    @JavascriptInterface
    public String getFileFromInternalStorage(String str) {
        try {
            return new String(C1441d.m5478b(m5317b(str), this.f3445i), "UTF-8");
        } catch (Throwable e) {
            C1380a.m5276a(f3435h, "Exception while loading bitmap file", e);
            return null;
        } catch (Throwable e2) {
            C1380a.m5276a(f3435h, "Exception while loading bitmap file", e2);
            return null;
        }
    }

    @JavascriptInterface
    public void saveFileToInternalStorage(String str, String str2) {
        FileOutputStream fileOutputStream;
        Throwable e;
        if (str == null || str.length() == 0 || str2 == null) {
            C1380a.m5275a(f3435h, "data missing. Not saving file");
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(new File(this.f3445i.getDir("juspay", 0), m5317b(str)));
            try {
                fileOutputStream.write(str2.getBytes("UTF-8"));
                fileOutputStream.flush();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                    }
                }
            } catch (FileNotFoundException e3) {
                e = e3;
                try {
                    C1380a.m5276a(f3435h, "File not found ", e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (Throwable th) {
                    e = th;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw e;
                }
            } catch (IOException e6) {
                e = e6;
                fileOutputStream2 = fileOutputStream;
                try {
                    C1380a.m5276a(f3435h, "IO exception ", e);
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e7) {
                        }
                    }
                } catch (Throwable th2) {
                    e = th2;
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw e;
                }
            }
        } catch (FileNotFoundException e8) {
            e = e8;
            fileOutputStream = null;
            C1380a.m5276a(f3435h, "File not found ", e);
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (IOException e9) {
            e = e9;
            C1380a.m5276a(f3435h, "IO exception ", e);
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        }
    }

    @JavascriptInterface
    public void viewHtml(String str) {
        File file = new File(str.substring(1, str.length()));
        Uri.fromFile(file);
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setDataAndType(Uri.fromFile(file), "text/html");
            this.f3446j.startActivity(Intent.createChooser(intent, "Open with"));
        } catch (Exception e) {
        }
    }

    @JavascriptInterface
    public String saveHTMLCode(String str, String str2) {
        FileOutputStream fileOutputStream;
        OutputStreamWriter outputStreamWriter;
        OutputStreamWriter outputStreamWriter2;
        Throwable th;
        Throwable th2;
        FileOutputStream fileOutputStream2 = null;
        File file = new File(Environment.getExternalStorageDirectory() + File.separator + "bhimTransactions");
        file.mkdirs();
        File file2 = new File(file, str);
        try {
            file2.createNewFile();
            fileOutputStream = new FileOutputStream(file2);
            try {
                outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                try {
                    outputStreamWriter.append(str2);
                    fileOutputStream.flush();
                    if (outputStreamWriter != null) {
                        try {
                            outputStreamWriter.close();
                        } catch (IOException e) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                } catch (Exception e3) {
                    outputStreamWriter2 = outputStreamWriter;
                    if (outputStreamWriter2 != null) {
                        try {
                            outputStreamWriter2.close();
                        } catch (IOException e4) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    return file2.getAbsolutePath();
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream2 = fileOutputStream;
                    th2 = th;
                    if (outputStreamWriter != null) {
                        try {
                            outputStreamWriter.close();
                        } catch (IOException e6) {
                        }
                    }
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e7) {
                        }
                    }
                    throw th2;
                }
            } catch (Exception e8) {
                if (outputStreamWriter2 != null) {
                    outputStreamWriter2.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return file2.getAbsolutePath();
            } catch (Throwable th4) {
                th = th4;
                outputStreamWriter = null;
                fileOutputStream2 = fileOutputStream;
                th2 = th;
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw th2;
            }
        } catch (Exception e9) {
            fileOutputStream = null;
            if (outputStreamWriter2 != null) {
                outputStreamWriter2.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return file2.getAbsolutePath();
        } catch (Throwable th5) {
            th2 = th5;
            outputStreamWriter = null;
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th2;
        }
        return file2.getAbsolutePath();
    }

    @JavascriptInterface
    public void sendSmsIntent(final String str, final String str2, final String str3) {
        this.f3446j.runOnUiThread(new Runnable(this) {
            final /* synthetic */ JsInterface f3351d;

            public void run() {
                try {
                    C1421f.m5388a().m5389a("INFO", "MESSENGER_OPENING_VERIFY_MOBILE");
                    ((HomeActivity) this.f3351d.f3446j).m5229a(str, str2, str3);
                } catch (SecurityException e) {
                    this.f3351d.f3447k.m4567a("window.callUICallback(\"" + str3 + "\", \"FAIlURE\")");
                    C1380a.m5279b(JsInterface.f3435h, "No permission to open this");
                }
            }
        });
    }

    @JavascriptInterface
    public String getWebviewUserAgentString() {
        return HomeActivity.f3193m;
    }

    @JavascriptInterface
    public String getUUID() {
        return UUID.randomUUID().toString();
    }

    @JavascriptInterface
    public void setEllipsize(int i) {
        ((TextView) this.f3446j.findViewById(i)).setEllipsize(TruncateAt.END);
    }

    @JavascriptInterface
    public void language_change(final String str) {
        this.f3446j.runOnUiThread(new Runnable(this) {
            final /* synthetic */ JsInterface f3353b;

            public void run() {
                String str = str;
                if (str.equals("ur")) {
                    ((HomeActivity) this.f3353b.f3446j).m5226a(Boolean.valueOf(true));
                } else {
                    ((HomeActivity) this.f3353b.f3446j).m5226a(Boolean.valueOf(false));
                }
                Locale locale = new Locale(str);
                Locale.setDefault(locale);
                Configuration configuration = new Configuration();
                configuration.locale = locale;
                this.f3353b.f3445i.getResources().updateConfiguration(configuration, this.f3353b.f3445i.getResources().getDisplayMetrics());
            }
        });
    }

    @JavascriptInterface
    public String getLayoutDirection() {
        if (((HomeActivity) this.f3446j).m5232m() == 1) {
            return "RTL";
        }
        return "LTR";
    }

    @JavascriptInterface
    public void setSwitch(String str, final String str2) {
        try {
            ((Switch) this.f3446j.findViewById(Integer.parseInt(str))).setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
                final /* synthetic */ JsInterface f3355b;

                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    this.f3355b.f3447k.m4567a(String.format("window.callJSCallback('%s','%s');", new Object[]{str2, Boolean.valueOf(z)}));
                }
            });
        } catch (Throwable e) {
            C1380a.m5276a(f3435h, "Exception in Set Switch", e);
        }
    }

    @JavascriptInterface
    public void listViewAdapter(String str, String str2, String str3, int i, String str4, String str5) {
        ListView listView = (ListView) this.f3446j.findViewById(Integer.parseInt(str));
        JSONArray jSONArray = new JSONArray(str2);
        ArrayList a = C1447j.m5499a(jSONArray, "view", "String");
        int i2 = i;
        C1425e c1425e = new C1425e(this.f3445i, i2, C1447j.m5499a(jSONArray, CLConstants.FIELD_PAY_INFO_VALUE, "String"), a, C1447j.m5499a(jSONArray, "viewType", "Int"), this.f3447k, str3);
        final String str6 = str5;
        final C1425e c1425e2 = c1425e;
        final ListView listView2 = listView;
        final String str7 = str4;
        this.f3446j.runOnUiThread(new Runnable(this) {
            final /* synthetic */ JsInterface f3360e;

            public void run() {
                try {
                    if (!(str6 == null || str6.isEmpty())) {
                        listView2.addFooterView(c1425e2.m5403a(str6));
                    }
                    listView2.setAdapter(c1425e2);
                    this.f3360e.m5308c(str7);
                } catch (Exception e) {
                    C1380a.m5275a(JsInterface.f3435h, "Error in rendering listview");
                    this.f3360e.m5308c(str7);
                }
            }
        });
    }

    @JavascriptInterface
    public void addItemsToListView(String str, String str2, String str3, int i, String str4) {
        final ListView listView = (ListView) this.f3446j.findViewById(Integer.parseInt(str));
        JSONArray jSONArray = new JSONArray(str2);
        final ArrayList a = C1447j.m5499a(jSONArray, "view", "String");
        final ArrayList a2 = C1447j.m5499a(jSONArray, CLConstants.FIELD_PAY_INFO_VALUE, "String");
        final ArrayList a3 = C1447j.m5499a(jSONArray, "viewType", "Int");
        final int i2 = i;
        final String str5 = str4;
        this.f3446j.runOnUiThread(new Runnable(this) {
            final /* synthetic */ JsInterface f3373g;

            public void run() {
                try {
                    C1425e c1425e;
                    ListAdapter adapter = listView.getAdapter();
                    if (adapter instanceof HeaderViewListAdapter) {
                        c1425e = (C1425e) ((HeaderViewListAdapter) adapter).getWrappedAdapter();
                    } else {
                        c1425e = (C1425e) adapter;
                    }
                    c1425e.m5404a(i2, a2, a, a3);
                    c1425e.notifyDataSetChanged();
                    this.f3373g.m5308c(str5);
                } catch (Exception e) {
                    C1380a.m5275a(JsInterface.f3435h, "Error in adding item to listview");
                    this.f3373g.m5308c(str5);
                }
            }
        });
    }

    private void m5308c(String str) {
        if (str != null && !str.isEmpty()) {
            this.f3447k.m4567a(String.format("window.callJSCallback('%s');", new Object[]{str}));
        }
    }

    @JavascriptInterface
    public String readContact(int i, int i2) {
        JSONArray jSONArray = new JSONArray();
        if (i == 0) {
            this.f3439b = new ArrayList();
            this.f3438a = null;
        }
        if (this.f3438a != null && this.f3438a.isLast()) {
            return jSONArray.toString();
        }
        try {
            if (this.f3438a == null) {
                this.f3438a = this.f3445i.getContentResolver().query(Phone.CONTENT_URI, null, null, null, "upper(display_name) ASC");
            }
            int i3 = 0;
            while (!this.f3438a.isLast() && i3 < i2 && this.f3438a.moveToNext()) {
                try {
                    Object string = this.f3438a.getString(this.f3438a.getColumnIndex("display_name"));
                    String string2 = this.f3438a.getString(this.f3438a.getColumnIndex("data1"));
                    if (string2 == null) {
                        continue;
                    } else {
                        if (string == null) {
                            string = "Unnamed";
                        }
                        string2 = string2.trim().replace("-", "").replace(")", "").replace("(", "").replace(" ", "").replace("+", "");
                        if (string2.length() >= 10) {
                            string2 = string2.substring(string2.length() - 10, string2.length());
                            if (!this.f3439b.contains(string2)) {
                                this.f3439b.add(string2);
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("nickName", string);
                                jSONObject.put("vpa", string2);
                                jSONObject.put(CLConstants.FIELD_TYPE, "MOBILE");
                                jSONObject.put("registeredName", string);
                                jSONArray.put(jSONObject);
                                i3++;
                            }
                        }
                    }
                } catch (Exception e) {
                }
            }
            return jSONArray.toString();
        } catch (Exception e2) {
            return jSONArray.toString();
        }
    }

    @JavascriptInterface
    public void editReminder(int i, String str) {
        this.f3440c.m5442a(this.f3445i, i, str);
    }

    @JavascriptInterface
    public String getLocation() {
        if (this.f3445i == null) {
            return null;
        }
        LocationManager locationManager = (LocationManager) this.f3445i.getSystemService("location");
        List allProviders = locationManager.getAllProviders();
        PackageManager packageManager = this.f3445i.getPackageManager();
        String packageName = this.f3445i.getPackageName();
        int checkPermission = packageManager.checkPermission("android.permission.ACCESS_COARSE_LOCATION", packageName);
        int checkPermission2 = packageManager.checkPermission("android.permission.ACCESS_FINE_LOCATION", packageName);
        JSONObject jSONObject = new JSONObject();
        if (checkPermission == 0 || checkPermission2 == 0) {
            try {
                JSONObject a;
                Object obj;
                for (checkPermission = allProviders.size() - 1; checkPermission >= 0; checkPermission--) {
                    if (((String) allProviders.get(checkPermission)).equals("network")) {
                        Location lastKnownLocation = locationManager.getLastKnownLocation((String) allProviders.get(checkPermission));
                        if (lastKnownLocation != null) {
                            a = m5301a(lastKnownLocation, (String) allProviders.get(checkPermission));
                            obj = 1;
                            break;
                        }
                    }
                }
                a = jSONObject;
                obj = null;
                jSONObject = obj == null ? a : a;
            } catch (Exception e) {
            }
        }
        return jSONObject.toString();
    }

    private JSONObject m5301a(Location location, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("Latitude", location.getLatitude());
            jSONObject.put("Longitude", location.getLongitude());
            jSONObject.put("Provider", str);
        } catch (Throwable e) {
            C1380a.m5276a(f3435h, "Exception while creating location json", e);
        }
        return jSONObject;
    }

    @JavascriptInterface
    public void setAlarm(String str) {
        this.f3440c.m5443a(this.f3445i, str);
    }

    @JavascriptInterface
    public String getAllAlarmInfo() {
        return this.f3440c.m5441a(this.f3445i);
    }

    @JavascriptInterface
    public void deleteAlarm(String[] strArr) {
        this.f3440c.m5444a(this.f3445i, strArr);
    }

    @JavascriptInterface
    public void forceUpdate() {
        String packageName = this.f3446j.getPackageName();
        try {
            this.f3446j.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName)));
        } catch (ActivityNotFoundException e) {
            this.f3446j.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + packageName)));
        }
    }

    @JavascriptInterface
    public void setWebView(final String str, final String str2) {
        this.f3446j.runOnUiThread(new Runnable(this) {
            final /* synthetic */ JsInterface f3376c;

            public void run() {
                ((WebView) this.f3376c.f3446j.findViewById(Integer.parseInt(str))).loadData(str2, "text/html", "UTF-8");
            }
        });
    }

    @JavascriptInterface
    public void removeHighlighted(String str, String str2) {
        final ViewGroup viewGroup = (ViewGroup) this.f3446j.findViewById(Integer.parseInt(str2));
        final View findViewById = this.f3446j.findViewById(Integer.parseInt(str) + 10000000);
        this.f3446j.runOnUiThread(new Runnable(this) {
            final /* synthetic */ JsInterface f3379c;

            public void run() {
                viewGroup.removeView(findViewById);
            }
        });
    }

    @JavascriptInterface
    public void highlightView(String str, String str2, String str3) {
        final ViewGroup viewGroup = (ViewGroup) this.f3446j.findViewById(Integer.parseInt(str2));
        final View findViewById = this.f3446j.findViewById(Integer.parseInt(str));
        final int[] iArr = new int[2];
        findViewById.getLocationOnScreen(iArr);
        final String str4 = str;
        final String str5 = str3;
        this.f3446j.runOnUiThread(new Runnable(this) {
            final /* synthetic */ JsInterface f3386f;

            class C13921 implements OnClickListener {
                final /* synthetic */ AnonymousClass33 f3380a;

                C13921(AnonymousClass33 anonymousClass33) {
                    this.f3380a = anonymousClass33;
                }

                public void onClick(View view) {
                    this.f3380a.f3386f.f3447k.m4567a("window.callUICallback(\"" + str5 + "\", \"SUCCESS\");");
                }
            }

            public void run() {
                new String[1][0] = null;
                int a = this.f3386f.m5314a(24.0f);
                View imageView = new ImageView(this.f3386f.f3445i);
                imageView.setId(Integer.parseInt(str4) + 10000000);
                imageView.setLayoutParams(new LayoutParams(findViewById.getWidth(), findViewById.getHeight()));
                imageView.setX((float) iArr[0]);
                imageView.setY((float) (iArr[1] - a));
                findViewById.setDrawingCacheEnabled(true);
                findViewById.buildDrawingCache();
                imageView.setImageBitmap(findViewById.getDrawingCache());
                imageView.setOnClickListener(new C13921(this));
                viewGroup.addView(imageView, viewGroup.getChildCount());
            }
        });
    }
}
