package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

public class C1004f implements OnClickListener {
    private final Activity f1962a;
    private final Fragment f1963b;
    private final Intent f1964c;
    private final int f1965d;

    public C1004f(Activity activity, Intent intent, int i) {
        this.f1962a = activity;
        this.f1963b = null;
        this.f1964c = intent;
        this.f1965d = i;
    }

    public C1004f(Fragment fragment, Intent intent, int i) {
        this.f1962a = null;
        this.f1963b = fragment;
        this.f1964c = intent;
        this.f1965d = i;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            if (this.f1964c != null && this.f1963b != null) {
                this.f1963b.m147a(this.f1964c, this.f1965d);
            } else if (this.f1964c != null) {
                this.f1962a.startActivityForResult(this.f1964c, this.f1965d);
            }
            dialogInterface.dismiss();
        } catch (ActivityNotFoundException e) {
            Log.e("SettingsRedirect", "Can't redirect to app settings for Google Play services");
        }
    }
}
