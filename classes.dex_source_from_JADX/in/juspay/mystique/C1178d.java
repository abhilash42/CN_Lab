package in.juspay.mystique;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

public final class C1178d {
    private static C1172c f2529b;
    private WebView f2530a;
    private Activity f2531c;
    private C1179e f2532d;
    private C1202h f2533e;
    private FrameLayout f2534f;

    class C11751 extends WebChromeClient {
        final /* synthetic */ C1178d f2524a;

        C11751(C1178d c1178d) {
            this.f2524a = c1178d;
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return true;
        }
    }

    public C1178d(Activity activity, FrameLayout frameLayout, Bundle bundle, C1179e c1179e) {
        f2529b = new C1173a();
        this.f2532d = c1179e;
        if (activity == null || frameLayout == null) {
            f2529b.mo760b("DynamicUI", "container or activity null");
            return;
        }
        this.f2531c = activity;
        this.f2534f = frameLayout;
        this.f2530a = new WebView(activity.getApplicationContext());
        m4564f();
        this.f2530a.setVisibility(8);
        this.f2534f.addView(this.f2530a);
        this.f2530a.getSettings().setJavaScriptEnabled(true);
        this.f2533e = new C1202h(activity, frameLayout, this);
        this.f2530a.addJavascriptInterface(this.f2533e, "Android");
    }

    private void m4564f() {
        if (this.f2531c != null) {
            int identifier = this.f2531c.getResources().getIdentifier("is_dui_debuggable", "string", this.f2531c.getPackageName());
            if (identifier != 0) {
                String string = this.f2531c.getString(identifier);
                if (string == null || !string.equalsIgnoreCase("true")) {
                    this.f2530a.setWebChromeClient(new C11751(this));
                } else {
                    if (VERSION.SDK_INT >= 19) {
                        WebView.setWebContentsDebuggingEnabled(true);
                    }
                    this.f2530a.setWebChromeClient(new WebChromeClient());
                    this.f2530a.setWebViewClient(new WebViewClient());
                }
            }
            if (VERSION.SDK_INT >= 16) {
                this.f2530a.getSettings().setAllowFileAccessFromFileURLs(true);
                this.f2530a.getSettings().setAllowUniversalAccessFromFileURLs(true);
            }
        }
    }

    public void m4565a() {
        this.f2530a.loadDataWithBaseURL("http://juspay.in", "<html></html>", "text/html", "utf-8", null);
        this.f2534f.removeView(this.f2530a);
        this.f2530a.removeAllViews();
        this.f2530a.destroy();
        this.f2531c = null;
    }

    public void m4567a(final String str) {
        if (this.f2531c != null) {
            this.f2531c.runOnUiThread(new Runnable(this) {
                final /* synthetic */ C1178d f2526b;

                public void run() {
                    try {
                        if (this.f2526b.f2530a != null) {
                            this.f2526b.f2530a.loadUrl("javascript:" + str);
                        } else {
                            C1178d.f2529b.mo760b("DynamicUI", "browser null, call start first");
                        }
                    } catch (Object e) {
                        C1178d.f2529b.mo760b("DynamicUI", "OutOfMemoryError :" + this.f2526b.m4560a(e));
                        this.f2526b.f2532d.mo786a("addJsToWebView", "" + this.f2526b.m4560a(e));
                    } catch (Object e2) {
                        C1178d.f2529b.mo760b("DynamicUI", "Exception :" + this.f2526b.m4560a(e2));
                        this.f2526b.f2532d.mo786a("addJsToWebView", "" + this.f2526b.m4560a(e2));
                    }
                }
            });
        }
    }

    private String m4560a(Object obj) {
        String str = "";
        for (StackTraceElement stackTraceElement : ((Exception) obj).getStackTrace()) {
            str = str + stackTraceElement.toString() + "\n";
        }
        return str;
    }

    public void m4569b(final String str) {
        if (this.f2531c != null) {
            this.f2531c.runOnUiThread(new Runnable(this) {
                final /* synthetic */ C1178d f2528b;

                public void run() {
                    this.f2528b.f2530a.loadUrl(str);
                }
            });
        }
    }

    public C1202h m4568b() {
        return this.f2533e;
    }

    @SuppressLint({"JavascriptInterface"})
    public void m4566a(Object obj, String str) {
        this.f2530a.addJavascriptInterface(obj, str);
    }

    public static C1172c m4562c() {
        return f2529b;
    }

    public C1179e m4571d() {
        return this.f2532d;
    }

    public void m4570c(String str) {
        if (this.f2533e != null) {
            this.f2533e.setState(str);
            return;
        }
        throw new Exception("JS-Interface not initailised");
    }

    public void m4572d(String str) {
        m4567a("window.onActivityLifeCycleEvent('" + str + "')");
    }
}
