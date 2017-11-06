package org.npci.upi.security.pinactivitycomponent;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.npci.upi.security.pinactivitycomponent.C1597a.C1592d;
import org.npci.upi.security.pinactivitycomponent.C1597a.C1594f;

public class C1603d extends Exception {
    String f4360a = "CLException";
    private String f4361b;
    private String f4362c;
    private Context f4363d;

    public C1603d(Context context, String str, String str2) {
        this.f4361b = str;
        this.f4362c = str2;
        this.f4363d = context;
        m6533a(context, str2);
    }

    public C1603d(Context context, String str, String str2, Throwable th) {
        super(th);
        this.f4361b = str;
        this.f4362c = str2;
        this.f4363d = context;
        m6533a(context, str2);
    }

    public String m6532a() {
        return this.f4362c;
    }

    public void m6533a(Context context, String str) {
        InputStream open;
        Properties properties = new Properties();
        try {
            open = context.getAssets().open("cl-messages_en_us.properties");
        } catch (IOException e) {
            Log.e(this.f4360a, e.getLocalizedMessage());
            open = null;
        }
        try {
            properties.load(open);
        } catch (IOException e2) {
            Log.e(this.f4360a, e2.getLocalizedMessage());
        }
        Log.e(this.f4360a, "ErrorMsg: " + properties.getProperty(str));
        CharSequence string = context.getResources().getString(C1594f.error_msg);
        TextView textView = (TextView) ((Activity) context).findViewById(C1592d.error_message);
        ((RelativeLayout) ((Activity) context).findViewById(C1592d.error_layout)).setVisibility(0);
        textView.setText(string);
    }
}
