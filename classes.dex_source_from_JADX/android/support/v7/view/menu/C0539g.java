package android.support.v7.view.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.IBinder;
import android.support.v7.p012a.C0452d;
import android.support.v7.p012a.C0452d.C0450a;
import android.support.v7.p013b.C0509a.C0505h;
import android.support.v7.view.menu.C0532l.C0473a;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

/* compiled from: MenuDialogHelper */
class C0539g implements OnClickListener, OnDismissListener, OnKeyListener, C0473a {
    C0537e f1139a;
    private C0538f f1140b;
    private C0452d f1141c;
    private C0473a f1142d;

    public C0539g(C0538f c0538f) {
        this.f1140b = c0538f;
    }

    public void m2501a(IBinder iBinder) {
        C0538f c0538f = this.f1140b;
        C0450a c0450a = new C0450a(c0538f.m2486e());
        this.f1139a = new C0537e(c0450a.m1989a(), C0505h.abc_list_menu_item_layout);
        this.f1139a.m2441a((C0473a) this);
        this.f1140b.m2466a(this.f1139a);
        c0450a.m1993a(this.f1139a.m2438a(), this);
        View o = c0538f.m2496o();
        if (o != null) {
            c0450a.m1992a(o);
        } else {
            c0450a.m1991a(c0538f.m2495n()).m1994a(c0538f.m2494m());
        }
        c0450a.m1990a((OnKeyListener) this);
        this.f1141c = c0450a.m1995b();
        this.f1141c.setOnDismissListener(this);
        LayoutParams attributes = this.f1141c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f1141c.show();
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 82 || i == 4) {
            Window window;
            View decorView;
            DispatcherState keyDispatcherState;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                window = this.f1141c.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null) {
                            keyDispatcherState.startTracking(keyEvent, this);
                            return true;
                        }
                    }
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled()) {
                window = this.f1141c.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null && keyDispatcherState.isTracking(keyEvent)) {
                            this.f1140b.m2470a(true);
                            dialogInterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.f1140b.performShortcut(i, keyEvent, 0);
    }

    public void m2500a() {
        if (this.f1141c != null) {
            this.f1141c.dismiss();
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f1139a.mo471a(this.f1140b, true);
    }

    public void mo401a(C0538f c0538f, boolean z) {
        if (z || c0538f == this.f1140b) {
            m2500a();
        }
        if (this.f1142d != null) {
            this.f1142d.mo401a(c0538f, z);
        }
    }

    public boolean mo402a(C0538f c0538f) {
        if (this.f1142d != null) {
            return this.f1142d.mo402a(c0538f);
        }
        return false;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1140b.m2472a((C0541h) this.f1139a.m2438a().getItem(i), 0);
    }
}
