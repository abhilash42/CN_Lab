package android.support.v7.p012a;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.view.ag;
import android.support.v7.p012a.C0432a.C0430b;
import android.support.v7.view.menu.C0532l.C0473a;
import android.support.v7.view.menu.C0538f;
import android.support.v7.view.menu.C0538f.C0457a;
import android.support.v7.widget.ac;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window.Callback;
import java.util.ArrayList;

/* compiled from: ToolbarActionBar */
class C0486o extends C0432a {
    private ac f906a;
    private Callback f907b;
    private boolean f908c;
    private boolean f909d;
    private ArrayList<C0430b> f910e;
    private final Runnable f911f;

    /* compiled from: ToolbarActionBar */
    class C04831 implements Runnable {
        final /* synthetic */ C0486o f902a;

        public void run() {
            this.f902a.m2192i();
        }
    }

    /* compiled from: ToolbarActionBar */
    private final class C0484a implements C0473a {
        final /* synthetic */ C0486o f903a;
        private boolean f904b;

        private C0484a(C0486o c0486o) {
            this.f903a = c0486o;
        }

        public boolean mo402a(C0538f c0538f) {
            if (this.f903a.f907b == null) {
                return false;
            }
            this.f903a.f907b.onMenuOpened(108, c0538f);
            return true;
        }

        public void mo401a(C0538f c0538f, boolean z) {
            if (!this.f904b) {
                this.f904b = true;
                this.f903a.f906a.mo567n();
                if (this.f903a.f907b != null) {
                    this.f903a.f907b.onPanelClosed(108, c0538f);
                }
                this.f904b = false;
            }
        }
    }

    /* compiled from: ToolbarActionBar */
    private final class C0485b implements C0457a {
        final /* synthetic */ C0486o f905a;

        private C0485b(C0486o c0486o) {
            this.f905a = c0486o;
        }

        public boolean mo379a(C0538f c0538f, MenuItem menuItem) {
            return false;
        }

        public void mo375a(C0538f c0538f) {
            if (this.f905a.f907b == null) {
                return;
            }
            if (this.f905a.f906a.mo562i()) {
                this.f905a.f907b.onPanelClosed(108, c0538f);
            } else if (this.f905a.f907b.onPreparePanel(0, null, c0538f)) {
                this.f905a.f907b.onMenuOpened(108, c0538f);
            }
        }
    }

    void m2192i() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0030 in list [B:12:0x002d]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r5 = this;
        r0 = 0;
        r1 = r5.m2176j();
        r2 = r1 instanceof android.support.v7.view.menu.C0538f;
        if (r2 == 0) goto L_0x0031;
    L_0x0009:
        r0 = r1;
        r0 = (android.support.v7.view.menu.C0538f) r0;
        r2 = r0;
    L_0x000d:
        if (r2 == 0) goto L_0x0012;
    L_0x000f:
        r2.m2488g();
    L_0x0012:
        r1.clear();	 Catch:{ all -> 0x0033 }
        r0 = r5.f907b;	 Catch:{ all -> 0x0033 }
        r3 = 0;	 Catch:{ all -> 0x0033 }
        r0 = r0.onCreatePanelMenu(r3, r1);	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x0028;	 Catch:{ all -> 0x0033 }
    L_0x001e:
        r0 = r5.f907b;	 Catch:{ all -> 0x0033 }
        r3 = 0;	 Catch:{ all -> 0x0033 }
        r4 = 0;	 Catch:{ all -> 0x0033 }
        r0 = r0.onPreparePanel(r3, r4, r1);	 Catch:{ all -> 0x0033 }
        if (r0 != 0) goto L_0x002b;	 Catch:{ all -> 0x0033 }
    L_0x0028:
        r1.clear();	 Catch:{ all -> 0x0033 }
    L_0x002b:
        if (r2 == 0) goto L_0x0030;
    L_0x002d:
        r2.m2489h();
    L_0x0030:
        return;
    L_0x0031:
        r2 = r0;
        goto L_0x000d;
    L_0x0033:
        r0 = move-exception;
        if (r2 == 0) goto L_0x0039;
    L_0x0036:
        r2.m2489h();
    L_0x0039:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.a.o.i():void");
    }

    public void mo411a(boolean z) {
    }

    public void mo408a(float f) {
        ag.m1282d(this.f906a.mo543a(), f);
    }

    public Context mo414c() {
        return this.f906a.mo552b();
    }

    public void mo415c(boolean z) {
    }

    public void mo416d(boolean z) {
    }

    public void mo409a(Configuration configuration) {
        super.mo409a(configuration);
    }

    public void mo410a(CharSequence charSequence) {
        this.f906a.mo550a(charSequence);
    }

    public boolean mo420g() {
        ViewGroup a = this.f906a.mo543a();
        if (a == null || a.hasFocus()) {
            return false;
        }
        a.requestFocus();
        return true;
    }

    public int mo407a() {
        return this.f906a.mo568o();
    }

    public boolean mo413b() {
        return this.f906a.mo570q() == 0;
    }

    public boolean mo418e() {
        this.f906a.mo543a().removeCallbacks(this.f911f);
        ag.m1269a(this.f906a.mo543a(), this.f911f);
        return true;
    }

    public boolean mo419f() {
        if (!this.f906a.mo556c()) {
            return false;
        }
        this.f906a.mo557d();
        return true;
    }

    public boolean mo412a(int i, KeyEvent keyEvent) {
        Menu j = m2176j();
        if (j != null) {
            boolean z;
            if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1) {
                z = true;
            } else {
                z = false;
            }
            j.setQwertyMode(z);
            j.performShortcut(i, keyEvent, 0);
        }
        return true;
    }

    void mo421h() {
        this.f906a.mo543a().removeCallbacks(this.f911f);
    }

    public void mo417e(boolean z) {
        if (z != this.f909d) {
            this.f909d = z;
            int size = this.f910e.size();
            for (int i = 0; i < size; i++) {
                ((C0430b) this.f910e.get(i)).m1904a(z);
            }
        }
    }

    private Menu m2176j() {
        if (!this.f908c) {
            this.f906a.mo546a(new C0484a(), new C0485b());
            this.f908c = true;
        }
        return this.f906a.mo571r();
    }
}
