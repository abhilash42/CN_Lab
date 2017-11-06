package com.google.android.gms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.google.android.gms.common.internal.C1032p;

public class C0732a extends DialogFragment {
    private Dialog f1757a = null;
    private OnCancelListener f1758b = null;

    public static C0732a m3181a(Dialog dialog, OnCancelListener onCancelListener) {
        C0732a c0732a = new C0732a();
        Dialog dialog2 = (Dialog) C1032p.m3679a((Object) dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        c0732a.f1757a = dialog2;
        if (onCancelListener != null) {
            c0732a.f1758b = onCancelListener;
        }
        return c0732a;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.f1758b != null) {
            this.f1758b.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f1757a == null) {
            setShowsDialog(false);
        }
        return this.f1757a;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
