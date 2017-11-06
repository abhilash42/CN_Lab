package in.juspay.mystique;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Environment;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.JavascriptInterface;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.Toast;
import in.juspay.mystique.C1202h.11.C11921;
import in.juspay.mystique.h.AnonymousClass11;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class C1202h {
    private static final String f2635h = C1202h.class.getName();
    private Activity f2636a;
    private C1204j f2637b;
    private ViewGroup f2638c;
    private C1172c f2639d = C1178d.m4562c();
    private C1179e f2640e;
    private String f2641f;
    private C1178d f2642g;

    class C11953 implements Runnable {
        final /* synthetic */ C1202h f2609a;

        C11953(C1202h c1202h) {
            this.f2609a = c1202h;
        }

        public void run() {
        }
    }

    C1202h(Activity activity, ViewGroup viewGroup, C1178d c1178d) {
        this.f2636a = activity;
        this.f2642g = c1178d;
        this.f2637b = new C1204j(this.f2636a, c1178d);
        this.f2638c = viewGroup;
        this.f2640e = c1178d.m4571d();
    }

    public C1204j m4623a() {
        return this.f2637b;
    }

    @JavascriptInterface
    public void Render(final String str, final String str2) {
        this.f2636a.runOnUiThread(new Runnable(this) {
            final /* synthetic */ C1202h f2605c;

            public void run() {
                try {
                    this.f2605c.f2637b.m4633a(str, this.f2605c.f2638c);
                    if (str2 != null) {
                        this.f2605c.f2642g.m4567a("window.callUICallback(" + str2 + ",'success');");
                    }
                } catch (Exception e) {
                    if (e != null) {
                        String name = e.getClass().getName();
                        this.f2605c.f2639d.mo760b("ERROR", " excep: fn__Render  - " + name + " - " + this.f2605c.f2637b.m4636b());
                        this.f2605c.f2640e.mo786a("ERROR", " excep: fn__Render  - " + name + " - " + this.f2605c.f2637b.m4636b());
                    }
                    if (str2 != null) {
                        this.f2605c.f2642g.m4567a("window.callUICallback(" + str2 + ",'failure');");
                    }
                }
            }
        });
    }

    @JavascriptInterface
    public void dismissPopUp() {
        this.f2637b.m4632a();
    }

    @JavascriptInterface
    public void throwError(String str) {
        this.f2639d.mo760b("throwError", str);
    }

    @JavascriptInterface
    public void addViewToParent(String str, String str2, int i, String str3, boolean z) {
        final String str4 = str;
        final String str5 = str2;
        final int i2 = i;
        final boolean z2 = z;
        final String str6 = str3;
        this.f2636a.runOnUiThread(new Runnable(this) {
            final /* synthetic */ C1202h f2620f;

            public void run() {
                try {
                    this.f2620f.f2637b.m4635a(str4, new JSONObject(str5), i2, z2);
                    if (str6 != null) {
                        this.f2620f.f2642g.m4567a("window.callUICallback('" + str6 + "','success');");
                    }
                } catch (Exception e) {
                    if (e != null) {
                        String name = e.getClass().getName();
                        this.f2620f.f2639d.mo760b("ERROR", " excep: fn__addViewToParent  - " + name + " - " + this.f2620f.f2637b.m4636b());
                        this.f2620f.f2640e.mo786a("ERROR", " excep: fn__addViewToParent  - " + name + " - " + this.f2620f.f2637b.m4636b());
                    }
                    if (str6 != null) {
                        this.f2620f.f2642g.m4567a("window.callUICallback('" + str6 + "','failure');");
                    }
                }
            }
        });
    }

    @JavascriptInterface
    public void addViewToParent(String str, String str2, int i, String str3) {
        addViewToParent(str, str2, i, str3, false);
    }

    @JavascriptInterface
    public void runInUI(String str, String str2, String str3, String str4) {
        final String str5 = str;
        final String str6 = str3;
        final String str7 = str4;
        final String str8 = str2;
        this.f2636a.runOnUiThread(new Runnable(this) {
            final /* synthetic */ C1202h f2625e;

            public void run() {
                try {
                    this.f2625e.f2637b.m4631a(this.f2625e.f2636a, str5, str6, str7);
                    if (str8 != null) {
                        this.f2625e.f2642g.m4567a("window.callUICallback(" + str8 + ",'success');");
                    }
                } catch (Exception e) {
                    if (e != null) {
                        String name = e.getClass().getName();
                        this.f2625e.f2639d.mo760b("ERROR", " excep: fn__runInUI  - " + name + " - " + this.f2625e.f2637b.m4636b());
                        this.f2625e.f2640e.mo786a("ERROR", " excep: fn__runInUI  - " + name + " - " + this.f2625e.f2637b.m4636b());
                    }
                    if (str8 != null) {
                        this.f2625e.f2642g.m4567a("window.callUICallback(" + str8 + ",'failure');");
                    }
                }
            }
        });
    }

    @JavascriptInterface
    public void runInUI(final String str, final String str2) {
        this.f2636a.runOnUiThread(new Runnable(this) {
            final /* synthetic */ C1202h f2628c;

            public void run() {
                try {
                    this.f2628c.f2637b.m4631a(this.f2628c.f2636a, str, "", "");
                    if (str2 != null) {
                        this.f2628c.f2642g.m4567a("window.callUICallback(" + str2 + ",'success');");
                    }
                } catch (Exception e) {
                    if (e != null) {
                        String name = e.getClass().getName();
                        this.f2628c.f2639d.mo760b("ERROR", " excep: fn__runInUI  - " + name + " - " + this.f2628c.f2637b.m4636b());
                        this.f2628c.f2640e.mo786a("ERROR", " excep: fn__runInUI  - " + name + " - " + this.f2628c.f2637b.m4636b());
                    }
                    if (str2 != null) {
                        this.f2628c.f2642g.m4567a("window.callUICallback(" + str2 + ",'failure');");
                    }
                }
            }
        });
    }

    public void m4624a(final View view, final String str) {
        this.f2636a.runOnUiThread(new Runnable(this) {
            final /* synthetic */ C1202h f2631c;

            public void run() {
                try {
                    this.f2631c.f2637b.m4631a(view, str, "", "");
                } catch (Exception e) {
                    if (e != null) {
                        String name = e.getClass().getName();
                        this.f2631c.f2639d.mo760b("ERROR", " excep: fn__runInUI  - " + name + " - " + this.f2631c.f2637b.m4636b());
                        this.f2631c.f2640e.mo786a("ERROR", " excep: fn__runInUI  - " + name + " - " + this.f2631c.f2637b.m4636b());
                    }
                }
            }
        });
    }

    @JavascriptInterface
    public void run(String str, String str2) {
        try {
            this.f2637b.m4631a(this.f2636a, str, "", "");
            if (str2 != null) {
                this.f2642g.m4567a("window.callUICallback(" + str2 + ",'success');");
            }
        } catch (Exception e) {
            if (e != null) {
                String name = e.getClass().getName();
                this.f2639d.mo760b("runInUI", name);
                this.f2640e.mo786a("runInUI", name + " - " + this.f2637b.m4636b());
            }
            if (str2 != null) {
                this.f2642g.m4567a("window.callUICallback(" + str2 + ",'failure');");
            }
        }
    }

    @JavascriptInterface
    public void saveState(String str) {
        this.f2641f = str;
    }

    @JavascriptInterface
    public String getState() {
        if (this.f2641f != null) {
            return this.f2641f;
        }
        return "{}";
    }

    @JavascriptInterface
    public void setImage(final int i, final String str) {
        this.f2636a.runOnUiThread(new Runnable(this) {
            final /* synthetic */ C1202h f2634c;

            public void run() {
                try {
                    ImageView imageView = (ImageView) this.f2634c.f2636a.findViewById(i);
                    byte[] decode = Base64.decode(str, 0);
                    imageView.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
                } catch (Exception e) {
                    if (e != null) {
                        String name = e.getClass().getName();
                        this.f2634c.f2639d.mo760b("ERROR", " excep: fn__setImage  - " + name + " - " + this.f2634c.f2637b.m4636b());
                        this.f2634c.f2640e.mo786a("ERROR", " excep: fn__setImage  - " + name + " - " + this.f2634c.f2637b.m4636b());
                    }
                }
            }
        });
    }

    @JavascriptInterface
    public void setState(String str) {
        this.f2641f = str;
    }

    @JavascriptInterface
    public String fetchData(String str) {
        return this.f2636a.getSharedPreferences("DUI", 0).getString(str, "null");
    }

    @JavascriptInterface
    public void saveData(String str, String str2) {
        this.f2636a.getSharedPreferences("DUI", 0).edit().putString(str, str2).commit();
    }

    @JavascriptInterface
    public String getScreenDimensions() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f2636a.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return "{\"width\":" + displayMetrics.widthPixels + ",\"height\":" + displayMetrics.heightPixels + " }";
    }

    @JavascriptInterface
    public void toggleKeyboard(final int i, final String str) {
        this.f2636a.runOnUiThread(new Runnable(this) {
            final /* synthetic */ C1202h f2594c;

            public void run() {
                View findViewById = this.f2594c.f2636a.findViewById(i);
                InputMethodManager inputMethodManager = (InputMethodManager) this.f2594c.f2636a.getSystemService("input_method");
                if (str.equals("show")) {
                    inputMethodManager.showSoftInput(findViewById, 1);
                } else {
                    inputMethodManager.hideSoftInputFromWindow(findViewById.getWindowToken(), 0);
                }
            }
        });
    }

    @JavascriptInterface
    public void generateUIElement(String str, int i, String[] strArr, String str2) {
        final String str3 = str;
        final int i2 = i;
        final String[] strArr2 = strArr;
        final String str4 = str2;
        this.f2636a.runOnUiThread(new Runnable(this) {
            final /* synthetic */ C1202h f2600e;

            class C11921 implements OnClickListener {
                final /* synthetic */ AnonymousClass11 f2595a;

                C11921(AnonymousClass11 anonymousClass11) {
                    this.f2595a = anonymousClass11;
                }

                public void onClick(View view) {
                    this.f2595a.f2600e.m4625a(view, strArr2, str4);
                }
            }

            public void run() {
                if (str3.equals("PopupMenu")) {
                    this.f2600e.f2636a.findViewById(i2).setOnClickListener(new C11921(this));
                }
            }
        });
    }

    public void m4625a(View view, String[] strArr, final String str) {
        if (VERSION.SDK_INT >= 11) {
            PopupMenu popupMenu = new PopupMenu(this.f2636a, view);
            for (Integer valueOf = Integer.valueOf(0); valueOf.intValue() < strArr.length; valueOf = Integer.valueOf(valueOf.intValue() + 1)) {
                popupMenu.getMenu().add(0, valueOf.intValue(), 0, strArr[valueOf.intValue()]);
            }
            popupMenu.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ C1202h f2602b;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    this.f2602b.f2642g.m4567a("window.callUICallback('" + str + "', '" + menuItem.getItemId() + "');");
                    Toast.makeText(this.f2602b.f2636a, "You Clicked : " + menuItem.getTitle(), 0).show();
                    return true;
                }
            });
            popupMenu.show();
        }
    }

    @JavascriptInterface
    public String getInternalStorageBaseFilePath() {
        return this.f2636a.getDir("juspay", 0).getAbsolutePath();
    }

    @JavascriptInterface
    public String getAssetBaseFilePath() {
        return "/android_asset";
    }

    @JavascriptInterface
    public String getExternalStorageBaseFilePath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    @JavascriptInterface
    public String loadFileFromExternalStorage(String str, String str2) {
        try {
            return new String(C1180f.m4578a(str, str2));
        } catch (Exception e) {
            return "";
        }
    }

    @JavascriptInterface
    public String loadFile(String str) {
        try {
            byte[] a = C1180f.m4577a(this.f2636a, str);
            if (a == null) {
                return "";
            }
            return new String(a);
        } catch (Exception e) {
            return "";
        }
    }

    @JavascriptInterface
    public void downloadFile(final String str, final String str2) {
        new AsyncTask(this) {
            final /* synthetic */ C1202h f2608c;

            protected Object doInBackground(Object[] objArr) {
                try {
                    C1203i.m4626a(this.f2608c.f2636a.getApplicationContext(), str);
                    return "SUCCESS";
                } catch (Exception e) {
                    return "FAILURE : " + e.getMessage();
                }
            }

            protected void onPostExecute(Object obj) {
                if (str2 != null) {
                    this.f2608c.f2642g.m4567a("window." + str2 + "(\"" + ((String) obj) + "\", \"" + str + "\");");
                }
            }
        }.execute(new Object[0]);
    }

    @JavascriptInterface
    public String saveFileToInternalStorage(String str, String str2, String str3) {
        try {
            C1180f.m4576a(this.f2636a, str, str2.getBytes());
            return "SUCCESS";
        } catch (Exception e) {
            return "FAILURE : " + e.getMessage();
        }
    }

    @JavascriptInterface
    public boolean isFilePresent(String str) {
        return new File(str).exists();
    }

    @JavascriptInterface
    public void showLoading() {
        this.f2636a.runOnUiThread(new C11953(this));
    }

    @JavascriptInterface
    public void callAPI(String str, String str2, String str3, String str4) {
        final String str5 = str4;
        final String str6 = str3;
        final String str7 = str;
        final String str8 = str2;
        new AsyncTask(this) {
            final /* synthetic */ C1202h f2614e;

            protected void onPostExecute(Object obj) {
                if (obj == null) {
                    return;
                }
                if (((String) obj).startsWith("ERR:")) {
                    this.f2614e.f2642g.m4567a("window.callUICallback(\"" + str5 + "\", 'error' ,\"" + obj + "\");");
                } else {
                    this.f2614e.f2642g.m4567a("window.callUICallback(\"" + str5 + "\", " + obj + ");");
                }
            }

            protected Object doInBackground(Object[] objArr) {
                HashMap hashMap = new HashMap();
                try {
                    JSONObject jSONObject = new JSONObject(str6);
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String str = (String) keys.next();
                        hashMap.put(str, jSONObject.getString(str));
                    }
                    return new String(RestClient.m4550a(str7, str8, hashMap));
                } catch (JSONException e) {
                    return "ERR: " + e.getLocalizedMessage();
                } catch (Exception e2) {
                    return "ERR: " + e2.getLocalizedMessage();
                }
            }
        }.execute(new Object[0]);
    }
}
