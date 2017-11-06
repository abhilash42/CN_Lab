package android.support.v4.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

/* compiled from: DialogFragment */
public class C0108k extends Fragment implements OnCancelListener, OnDismissListener {
    int f308a = 0;
    int f309b = 0;
    boolean f310c = true;
    boolean f311d = true;
    int f312e = -1;
    Dialog f313f;
    boolean f314g;
    boolean f315h;
    boolean f316i;

    public void mo657a(C0116p c0116p, String str) {
        this.f315h = false;
        this.f316i = true;
        C0103r a = c0116p.mo77a();
        a.mo49a((Fragment) this, str);
        a.mo46a();
    }

    void m371a(boolean z) {
        if (!this.f315h) {
            this.f315h = true;
            this.f316i = false;
            if (this.f313f != null) {
                this.f313f.dismiss();
                this.f313f = null;
            }
            this.f314g = true;
            if (this.f312e >= 0) {
                m180j().mo79a(this.f312e, 1);
                this.f312e = -1;
                return;
            }
            C0103r a = m180j().mo77a();
            a.mo48a((Fragment) this);
            if (z) {
                a.mo51b();
            } else {
                a.mo46a();
            }
        }
    }

    public int m366a() {
        return this.f309b;
    }

    public void m374b(boolean z) {
        this.f311d = z;
    }

    public void mo53a(Activity activity) {
        super.mo53a(activity);
        if (!this.f316i) {
            this.f315h = false;
        }
    }

    public void mo56b() {
        super.mo56b();
        if (!this.f316i && !this.f315h) {
            this.f315h = true;
        }
    }

    public void mo54a(Bundle bundle) {
        super.mo54a(bundle);
        this.f311d = this.G == 0;
        if (bundle != null) {
            this.f308a = bundle.getInt("android:style", 0);
            this.f309b = bundle.getInt("android:theme", 0);
            this.f310c = bundle.getBoolean("android:cancelable", true);
            this.f311d = bundle.getBoolean("android:showsDialog", this.f311d);
            this.f312e = bundle.getInt("android:backStackId", -1);
        }
    }

    public LayoutInflater mo55b(Bundle bundle) {
        if (!this.f311d) {
            return super.mo55b(bundle);
        }
        this.f313f = mo658c(bundle);
        if (this.f313f == null) {
            return (LayoutInflater) this.C.m397g().getSystemService("layout_inflater");
        }
        m368a(this.f313f, this.f308a);
        return (LayoutInflater) this.f313f.getContext().getSystemService("layout_inflater");
    }

    public void m368a(Dialog dialog, int i) {
        switch (i) {
            case 1:
            case 2:
                break;
            case 3:
                dialog.getWindow().addFlags(24);
                break;
            default:
                return;
        }
        dialog.requestWindowFeature(1);
    }

    public Dialog mo658c(Bundle bundle) {
        return new Dialog(m176h(), m366a());
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.f314g) {
            m371a(true);
        }
    }

    public void mo59d(Bundle bundle) {
        super.mo59d(bundle);
        if (this.f311d) {
            View n = m186n();
            if (n != null) {
                if (n.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                this.f313f.setContentView(n);
            }
            this.f313f.setOwnerActivity(m176h());
            this.f313f.setCancelable(this.f310c);
            this.f313f.setOnCancelListener(this);
            this.f313f.setOnDismissListener(this);
            if (bundle != null) {
                Bundle bundle2 = bundle.getBundle("android:savedDialogState");
                if (bundle2 != null) {
                    this.f313f.onRestoreInstanceState(bundle2);
                }
            }
        }
    }

    public void mo57c() {
        super.mo57c();
        if (this.f313f != null) {
            this.f314g = false;
            this.f313f.show();
        }
    }

    public void mo61e(Bundle bundle) {
        super.mo61e(bundle);
        if (this.f313f != null) {
            Bundle onSaveInstanceState = this.f313f.onSaveInstanceState();
            if (onSaveInstanceState != null) {
                bundle.putBundle("android:savedDialogState", onSaveInstanceState);
            }
        }
        if (this.f308a != 0) {
            bundle.putInt("android:style", this.f308a);
        }
        if (this.f309b != 0) {
            bundle.putInt("android:theme", this.f309b);
        }
        if (!this.f310c) {
            bundle.putBoolean("android:cancelable", this.f310c);
        }
        if (!this.f311d) {
            bundle.putBoolean("android:showsDialog", this.f311d);
        }
        if (this.f312e != -1) {
            bundle.putInt("android:backStackId", this.f312e);
        }
    }

    public void mo58d() {
        super.mo58d();
        if (this.f313f != null) {
            this.f313f.hide();
        }
    }

    public void mo60e() {
        super.mo60e();
        if (this.f313f != null) {
            this.f314g = true;
            this.f313f.dismiss();
            this.f313f = null;
        }
    }
}
