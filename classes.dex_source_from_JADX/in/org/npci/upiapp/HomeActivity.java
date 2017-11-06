package in.org.npci.upiapp;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.p004a.C0040i;
import android.support.v7.p012a.C0434e;
import android.text.TextUtils;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.crashlytics.android.Crashlytics;
import com.google.android.gms.common.C0747b;
import in.juspay.mystique.C1178d;
import in.juspay.mystique.C1179e;
import in.juspay.widget.qrscanner.com.google.zxing.C1223a;
import in.juspay.widget.qrscanner.com.google.zxing.C1284e;
import in.juspay.widget.qrscanner.com.google.zxing.common.C1268b;
import in.juspay.widget.qrscanner.com.google.zxing.p029b.C1256b;
import in.juspay.widget.qrscanner.com.google.zxing.p029b.p030a.C1237f;
import in.org.npci.upiapp.core.C1414a;
import in.org.npci.upiapp.core.C1421f;
import in.org.npci.upiapp.core.JsInterface;
import in.org.npci.upiapp.core.NPCIJSInterface;
import in.org.npci.upiapp.core.QRScannerInterface;
import in.org.npci.upiapp.gcm.RegistrationIntentService;
import in.org.npci.upiapp.p036a.C1380a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class HomeActivity extends C0434e {
    private static Integer f3189A = null;
    private static Integer f3190B = null;
    private static Integer f3191C = null;
    private static String f3192D = "unknown_bank";
    public static String f3193m;
    static final /* synthetic */ boolean f3194n = (!HomeActivity.class.desiredAssertionStatus());
    private static String f3195p = "";
    private static HomeActivity f3196y;
    private static Long f3197z;
    private String f3198E;
    private String f3199F;
    private int f3200G = 88;
    private C1367a f3201o;
    private C1178d f3202q;
    private JsInterface f3203r;
    private C1421f f3204s;
    private C1414a f3205t;
    private NPCIJSInterface f3206u;
    private QRScannerInterface f3207v;
    private String f3208w;
    private String f3209x;

    class C13631 implements OnClickListener {
        final /* synthetic */ HomeActivity f3186a;

        C13631(HomeActivity homeActivity) {
            this.f3186a = homeActivity;
        }

        public void onClick(View view) {
            this.f3186a.recreate();
        }
    }

    class C13642 implements C1179e {
        final /* synthetic */ HomeActivity f3187a;

        C13642(HomeActivity homeActivity) {
            this.f3187a = homeActivity;
        }

        public void mo786a(String str, String str2) {
            this.f3187a.f3202q.m4567a("window.onAndroidError('" + str2 + "');");
        }
    }

    static class C13653 implements DialogInterface.OnClickListener {
        C13653() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=in.org.npci.upiapp&hl=en"));
            HomeActivity.f3196y.startActivity(intent);
            HomeActivity.f3196y.finish();
            HomeActivity.f3196y = null;
        }
    }

    static class C13664 implements DialogInterface.OnClickListener {
        C13664() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            HomeActivity.f3196y.finish();
            HomeActivity.f3196y = null;
        }
    }

    private class C1367a extends BroadcastReceiver {
        final /* synthetic */ HomeActivity f3188a;

        private C1367a(HomeActivity homeActivity) {
            this.f3188a = homeActivity;
        }

        public void onReceive(Context context, Intent intent) {
            if (this.f3188a.f3202q != null) {
                try {
                    String stringExtra = intent.getStringExtra("onNotificationReceived");
                    String stringExtra2 = intent.getStringExtra("onTokenReceived");
                    String stringExtra3 = intent.getStringExtra("onTokenRefreshed");
                    String stringExtra4 = intent.getStringExtra("reminder");
                    if (stringExtra != null) {
                        this.f3188a.f3202q.m4569b("javascript: window.onNotificationReceived(" + stringExtra + ");");
                    }
                    if (stringExtra2 != null) {
                        this.f3188a.f3202q.m4569b("javascript: window.onTokenReceived('" + stringExtra2 + "');");
                    }
                    if (stringExtra3 != null) {
                        this.f3188a.f3202q.m4569b("javascript: window.onTokenRefreshed('" + stringExtra3 + "');");
                    }
                    if (stringExtra4 != null) {
                        this.f3188a.f3202q.m4569b("javascript: window.onReminderNotificationReceived('" + stringExtra4 + "');");
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Object stringExtra = getIntent().getStringExtra("notification");
        Object stringExtra2 = getIntent().getStringExtra("reminder");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.f3198E = stringExtra;
        }
        if (!TextUtils.isEmpty(stringExtra2)) {
            this.f3199F = stringExtra2;
        }
        m5225a(bundle);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Object stringExtra = intent.getStringExtra("notification");
        Object stringExtra2 = intent.getStringExtra("reminder");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.f3198E = stringExtra;
        }
        if (!TextUtils.isEmpty(stringExtra2)) {
            this.f3199F = stringExtra2;
        }
        m5225a(null);
    }

    public String m5230k() {
        return this.f3198E;
    }

    public String m5231l() {
        return this.f3199F;
    }

    protected void m5225a(Bundle bundle) {
        m5222z();
        m5220x();
        m5221y();
        this.f3204s = new C1421f(this);
        m5196A();
        setContentView(2130968601);
        ImageView imageView = (ImageView) findViewById(2131558506);
        if (f3194n || imageView != null) {
            TextView textView = (TextView) findViewById(2131558507);
            if (f3194n || textView != null) {
                Button button = (Button) findViewById(2131558508);
                if (f3194n || button != null) {
                    button.setOnClickListener(new C13631(this));
                    if (m5219w()) {
                        button.setVisibility(8);
                        textView.setVisibility(8);
                        imageView.setVisibility(0);
                    } else {
                        textView.setVisibility(0);
                        imageView.setVisibility(0);
                        button.setVisibility(0);
                    }
                    f3196y = this;
                    f3195p = getString(2131165262);
                    m5205b(bundle);
                    this.f3202q.m4569b(f3195p);
                    try {
                        f3193m = new WebView(this).getSettings().getUserAgentString();
                        return;
                    } catch (Exception e) {
                        f3193m = "";
                        return;
                    }
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public void m5226a(Boolean bool) {
        FrameLayout frameLayout = (FrameLayout) findViewById(2131558505);
        if (frameLayout != null && VERSION.SDK_INT >= 19) {
            if (bool.booleanValue()) {
                frameLayout.setLayoutDirection(1);
            } else {
                frameLayout.setLayoutDirection(0);
            }
        }
    }

    public int m5232m() {
        FrameLayout frameLayout = (FrameLayout) findViewById(2131558505);
        if (frameLayout == null || VERSION.SDK_INT < 19) {
            return 0;
        }
        return frameLayout.getLayoutDirection();
    }

    private boolean m5219w() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            NetworkInfo networkInfo3 = connectivityManager.getNetworkInfo(7);
            NetworkInfo networkInfo4 = connectivityManager.getNetworkInfo(9);
            if (networkInfo.isAvailable() && networkInfo.getDetailedState() == DetailedState.CONNECTED) {
                return true;
            }
            if (networkInfo2.isAvailable() && networkInfo2.getDetailedState() == DetailedState.CONNECTED) {
                return true;
            }
            if (networkInfo3.isAvailable() && networkInfo3.getDetailedState() == DetailedState.CONNECTED) {
                return true;
            }
            if (networkInfo4.isAvailable() && networkInfo4.getDetailedState() == DetailedState.CONNECTED) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    private void m5220x() {
        int i = 0;
        try {
            SharedPreferences sharedPreferences = getSharedPreferences("NPCI", 0);
            if (sharedPreferences != null) {
                String str = "LAST_APP_VERSION";
                int i2 = sharedPreferences.getInt("LAST_APP_VERSION", -1);
                if (i2 == -1) {
                    sharedPreferences.edit().putInt("LAST_APP_VERSION", 12).apply();
                }
                if (12 > i2) {
                    File[] listFiles = getDir("bhim", 0).listFiles();
                    while (listFiles != null && i < listFiles.length) {
                        listFiles[i].delete();
                        i++;
                    }
                    sharedPreferences.edit().putInt("LAST_APP_VERSION", 12).apply();
                }
            }
        } catch (Throwable e) {
            C1380a.m5276a("HomeActivity", "Exception: resetInternalStorageIfAppUpdated", e);
        }
    }

    public int m5223a(float f) {
        return (int) (((float) (getResources().getDisplayMetrics().densityDpi / 160)) * f);
    }

    private void m5221y() {
        if (m5198C()) {
            startService(new Intent(this, RegistrationIntentService.class));
        }
    }

    private void m5222z() {
        if ("PRODUCTION".equals("PRODUCTION") && m5197B()) {
            throw new RuntimeException("Debuggable mode wont work. Please download app from playstore");
        }
    }

    private void m5196A() {
        Crashlytics.setUserIdentifier(getString(2131165239));
    }

    private boolean m5197B() {
        return (getApplicationInfo().flags & 2) != 0;
    }

    public Bitmap m5224a(String str, String str2, boolean z) {
        Bitmap g = m5211g(str);
        if (g != null) {
            return g;
        }
        Map hashMap = new HashMap();
        hashMap.put(C1284e.ERROR_CORRECTION, C1237f.H);
        try {
            int i;
            C1268b a = new C1256b().m4778a(str2, C1223a.QR_CODE, 512, 512, hashMap);
            int c = a.m4868c();
            int d = a.m4870d();
            g = Bitmap.createBitmap(c, d, Config.RGB_565);
            for (i = 0; i < c; i++) {
                for (int i2 = 0; i2 < d; i2++) {
                    g.setPixel(i, i2, a.m4864a(i, i2) ? -16777216 : -1);
                }
            }
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), 2130837871, options);
            options.inJustDecodeBounds = false;
            options.inSampleSize = m5199a(options, m5223a(20.0f));
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), 2130837871, options);
            Canvas canvas = new Canvas(g);
            i = canvas.getWidth();
            int height = canvas.getHeight();
            canvas.drawBitmap(g, new Matrix(), null);
            canvas.drawBitmap(decodeResource, (float) ((i - decodeResource.getWidth()) / 2), (float) ((height - decodeResource.getHeight()) / 2), null);
            if (!z) {
                return g;
            }
            m5201a(str, g);
            return g;
        } catch (Throwable e) {
            C1380a.m5276a("HomeActivity", "Exception in generateAndSaveQrBitmap", e);
            return null;
        }
    }

    private String m5201a(String str, Bitmap bitmap) {
        Throwable e;
        File file = new File(new ContextWrapper(getApplicationContext()).getDir("imageDir", 0), str);
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable e2) {
                        C1380a.m5276a("HomeActivity", "Exception when closing output stream", e2);
                    }
                }
            } catch (Exception e3) {
                e2 = e3;
                try {
                    C1380a.m5276a("HomeActivity", "Exception when saving QR image", e2);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e22) {
                            C1380a.m5276a("HomeActivity", "Exception when closing output stream", e22);
                        }
                    }
                    return file.getAbsolutePath();
                } catch (Throwable th) {
                    e22 = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e4) {
                            C1380a.m5276a("HomeActivity", "Exception when closing output stream", e4);
                        }
                    }
                    throw e22;
                }
            }
        } catch (Exception e5) {
            e22 = e5;
            fileOutputStream = null;
            C1380a.m5276a("HomeActivity", "Exception when saving QR image", e22);
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return file.getAbsolutePath();
        } catch (Throwable th2) {
            e22 = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e22;
        }
        return file.getAbsolutePath();
    }

    private Bitmap m5211g(String str) {
        try {
            InputStream fileInputStream = new FileInputStream(new File(new ContextWrapper(this).getDir("imageDir", 0), str));
            Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream);
            fileInputStream.close();
            return decodeStream;
        } catch (Throwable e) {
            C1380a.m5278a(e);
            return null;
        }
    }

    public static int m5199a(Options options, int i) {
        int i2 = options.outHeight;
        int i3 = 1;
        if (i2 > i) {
            while ((i2 / 2) / i3 >= i) {
                i3 *= 2;
            }
        }
        return i3;
    }

    public String m5233n() {
        Intent intent = getIntent();
        String action = intent.getAction();
        Uri data = intent.getData();
        if (!(action == null || !action.equals("android.intent.action.VIEW") || data == null)) {
            try {
                return new String(Base64.encode(data.toString().getBytes("UTF-8"), 0), "UTF-8");
            } catch (UnsupportedEncodingException e) {
            }
        }
        return null;
    }

    private void m5205b(Bundle bundle) {
        this.f3202q = new C1178d(this, (FrameLayout) findViewById(2131558505), null, new C13642(this));
        this.f3203r = new JsInterface(this, this.f3202q);
        this.f3205t = new C1414a(this, this.f3202q);
        this.f3202q.m4566a(this.f3203r, "JBridge");
        this.f3202q.m4566a(this.f3205t, "OtpJBridge");
        this.f3202q.m4566a(this.f3204s, "Tracker");
        if (bundle != null) {
            try {
                this.f3202q.m4570c(bundle.getString("currentAppState"));
            } catch (Throwable e) {
                C1380a.m5278a(e);
                return;
            }
        }
        this.f3203r = new JsInterface(this, this.f3202q);
        this.f3202q.m4566a(this.f3203r, "JBridge");
        this.f3206u = new NPCIJSInterface(this, this.f3202q);
        this.f3202q.m4566a(this.f3206u, "NPCICL");
        this.f3207v = new QRScannerInterface(this, this.f3202q);
        this.f3202q.m4566a(this.f3207v, "QRScanner");
        if (getResources().getBoolean(2131230728) && VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.f3203r.m5316a(i, strArr, iArr);
        if (this.f3207v != null) {
            this.f3207v.m5339a(i, strArr, iArr);
        }
    }

    private void m5202a(BroadcastReceiver broadcastReceiver) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("in.org.npci.upiapp.uibroadcastreceiver");
            C0040i.m106a((Context) this).m110a(broadcastReceiver, intentFilter);
        } catch (Exception e) {
        }
    }

    private void m5204b(BroadcastReceiver broadcastReceiver) {
        try {
            C0040i.m106a((Context) this).m109a(broadcastReceiver);
        } catch (Exception e) {
        }
    }

    protected void onResume() {
        if (this.f3203r != null) {
            this.f3203r.hideKeyboard();
        }
        super.onResume();
        this.f3201o = new C1367a();
        m5202a(this.f3201o);
        if (this.f3206u != null) {
            C1380a.m5275a("HomeActivity", "Lifecycle - onResume Called");
            this.f3206u.m5326a();
        }
        this.f3202q.m4572d("onResume");
    }

    protected void onPause() {
        super.onPause();
        m5204b(this.f3201o);
        this.f3202q.m4572d("onPause");
    }

    protected void onDestroy() {
        f3196y = null;
        super.onDestroy();
        m5204b(this.f3201o);
        this.f3202q.m4572d("onDestroy");
        this.f3202q.m4565a();
    }

    public void onBackPressed() {
        this.f3202q.m4567a("window.onBackpressed()");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 3) {
            this.f3202q.m4567a("window.onHomepressed()");
            moveTaskToBack(true);
            return true;
        } else if (i == 4) {
            this.f3202q.m4567a("window.onBackpressed()");
            return true;
        } else if (i != 82) {
            return false;
        } else {
            this.f3202q.m4567a("window.onMenupressed()");
            moveTaskToBack(true);
            return true;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 8) {
            if (i2 == -1) {
                this.f3202q.m4567a("window.callUICallback(\"" + this.f3208w + "\", \"SUCCESS\")");
            } else if (i2 == 0) {
                this.f3202q.m4567a("window.callUICallback(\"" + this.f3208w + "\", \"SUCCESS\")");
            }
        } else if (i == 12) {
            if (i2 == -1) {
                this.f3202q.m4567a("window.callUICallback(\"" + this.f3209x + "\", \"SUCCESS\")");
            } else if (i2 == 0) {
                this.f3202q.m4567a("window.callUICallback(\"" + this.f3209x + "\", \"FAILURE\")");
            }
        }
        try {
            if (i == this.f3200G && i2 == -1 && intent != null) {
                String path;
                this.f3207v.m5338a();
                String str = "";
                Uri data = intent.getData();
                if (data != null) {
                    if (data.toString().startsWith("file:")) {
                        path = data.getPath();
                    } else {
                        Cursor query = getContentResolver().query(data, null, null, null, null);
                        if (query != null && query.moveToFirst()) {
                            int columnIndex = query.getColumnIndex("_data");
                            if (columnIndex != -1) {
                                path = query.getString(columnIndex);
                            }
                        }
                    }
                    this.f3207v.m5337a(BitmapFactory.decodeStream(new FileInputStream(new File(path))));
                }
                path = str;
                try {
                    this.f3207v.m5337a(BitmapFactory.decodeStream(new FileInputStream(new File(path))));
                } catch (Throwable e) {
                    C1380a.m5276a("HomeActivity", "File not found exception", e);
                }
            }
        } catch (Throwable e2) {
            C1380a.m5276a("HomeActivity", "Exception in onActivity Result", e2);
        }
        super.onActivityResult(i, i2, intent);
        C1380a.m5275a("HomeActivity", "Activity Result is " + i);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 2:
                this.f3202q.m4572d("onTouch");
                break;
            case 8:
                this.f3202q.m4572d("onTouch");
                break;
            case 11:
                this.f3202q.m4572d("onTouch");
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void m5227a(String str) {
        Intent intent = new Intent();
        intent.putExtra("response", str);
        setResult(-1, intent);
        finish();
    }

    public void m5229a(String str, String str2, String str3) {
        this.f3208w = str3;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.fromParts("sms", str2, null));
        intent.putExtra("sms_body", str);
        intent.putExtra("exit_on_sent", true);
        startActivityForResult(intent, 8);
    }

    public void m5228a(String str, String str2) {
        this.f3209x = str2;
        Intent intent = new Intent("android.intent.action.CALL");
        intent.setData(Uri.parse("tel:" + str));
        startActivityForResult(intent, 12);
    }

    public QRScannerInterface m5234o() {
        return this.f3207v;
    }

    private boolean m5198C() {
        C0747b a = C0747b.m3202a();
        int a2 = a.m3204a((Context) this);
        if (a2 == 0) {
            return true;
        }
        if (a.m3209a(a2)) {
            a.m3205a((Activity) this, a2, 9000).show();
        }
        return false;
    }

    public static void m5212p() {
        try {
            Builder builder = new Builder(f3196y);
            builder.setTitle("App Update");
            builder.setMessage("App has expired. This version will not work anymore. Please update the app from Play Store");
            builder.setCancelable(false);
            builder.setPositiveButton("Update", new C13653());
            builder.setNegativeButton("Close", new C13664());
            builder.create();
            builder.show();
        } catch (Throwable e) {
            C1380a.m5278a(e);
        }
    }

    public static Long m5213q() {
        return f3197z;
    }

    public static Integer m5214r() {
        return f3189A;
    }

    public static void m5206b(String str) {
        f3189A = Integer.valueOf(Integer.parseInt(str));
    }

    public static Integer m5215s() {
        return f3190B;
    }

    public static void m5207c(String str) {
        f3190B = Integer.valueOf(Integer.parseInt(str));
    }

    public static Integer m5216t() {
        return f3191C;
    }

    public static void m5208d(String str) {
        f3191C = Integer.valueOf(Integer.parseInt(str));
    }

    public static String m5217u() {
        return f3192D;
    }

    public static void m5209e(String str) {
        f3192D = str;
    }

    public static void m5210f(String str) {
        try {
            f3197z = Long.valueOf(Long.parseLong(str));
        } catch (Throwable e) {
            C1380a.m5276a("HomeActivity", "NumberformatExceptin in setSessionStartForOtp", e);
        }
    }
}
