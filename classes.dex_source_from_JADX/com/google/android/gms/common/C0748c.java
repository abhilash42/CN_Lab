package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.C0108k;
import android.support.v4.app.C0116p;
import com.google.android.gms.common.internal.C1032p;

public class C0748c extends C0108k {
    private Dialog ai = null;
    private OnCancelListener aj = null;

    public static C0748c m3210a(Dialog dialog, OnCancelListener onCancelListener) {
        C0748c c0748c = new C0748c();
        Dialog dialog2 = (Dialog) C1032p.m3679a((Object) dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        c0748c.ai = dialog2;
        if (onCancelListener != null) {
            c0748c.aj = onCancelListener;
        }
        return c0748c;
    }

    public void mo657a(C0116p c0116p, String str) {
        super.mo657a(c0116p, str);
    }

    public Dialog mo658c(Bundle bundle) {
        if (this.ai == null) {
            m374b(false);
        }
        return this.ai;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.aj != null) {
            this.aj.onCancel(dialogInterface);
        }
    }
}
