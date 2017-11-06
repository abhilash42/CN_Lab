package android.support.v7.p012a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.C0050a;
import android.support.v4.app.C0113l;
import android.support.v4.app.C0139v;
import android.support.v4.app.ap;
import android.support.v4.app.ap.C0084a;
import android.support.v4.view.C0331g;
import android.support.v7.view.C0494b;
import android.support.v7.view.C0494b.C0476a;
import android.support.v7.widget.at;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

/* compiled from: AppCompatActivity */
public class C0434e extends C0113l implements C0084a, C0433f {
    private C0453g f690m;
    private int f691n = 0;
    private boolean f692o;
    private Resources f693p;

    protected void onCreate(Bundle bundle) {
        C0453g j = m1943j();
        j.mo390g();
        j.mo374a(bundle);
        if (j.mo369h() && this.f691n != 0) {
            if (VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.f691n, false);
            } else {
                setTheme(this.f691n);
            }
        }
        super.onCreate(bundle);
    }

    public void setTheme(int i) {
        super.setTheme(i);
        this.f691n = i;
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        m1943j().mo382b(bundle);
    }

    public C0432a m1940g() {
        return m1943j().mo364a();
    }

    public MenuInflater getMenuInflater() {
        return m1943j().mo366b();
    }

    public void setContentView(int i) {
        m1943j().mo381b(i);
    }

    public void setContentView(View view) {
        m1943j().mo376a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        m1943j().mo377a(view, layoutParams);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        m1943j().mo383b(view, layoutParams);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m1943j().mo373a(configuration);
        if (this.f693p != null) {
            this.f693p.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    protected void onStop() {
        super.onStop();
        m1943j().mo386c();
    }

    protected void onPostResume() {
        super.onPostResume();
        m1943j().mo388d();
    }

    public View findViewById(int i) {
        return m1943j().mo371a(i);
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        C0432a g = m1940g();
        if (menuItem.getItemId() != 16908332 || g == null || (g.mo407a() & 4) == 0) {
            return false;
        }
        return m1941h();
    }

    protected void onDestroy() {
        super.onDestroy();
        m1943j().mo368f();
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        m1943j().mo365a(charSequence);
    }

    public void mo346d() {
        m1943j().mo389e();
    }

    public void invalidateOptionsMenu() {
        m1943j().mo389e();
    }

    public void mo344a(C0494b c0494b) {
    }

    public void mo345b(C0494b c0494b) {
    }

    public C0494b mo343a(C0476a c0476a) {
        return null;
    }

    public void m1933a(ap apVar) {
        apVar.m297a((Activity) this);
    }

    public void m1937b(ap apVar) {
    }

    public boolean m1941h() {
        Intent a = mo342a();
        if (a == null) {
            return false;
        }
        if (m1935a(a)) {
            ap a2 = ap.m296a((Context) this);
            m1933a(a2);
            m1937b(a2);
            a2.m300a();
            try {
                C0050a.m204a(this);
            } catch (IllegalStateException e) {
                finish();
            }
        } else {
            m1936b(a);
        }
        return true;
    }

    public Intent mo342a() {
        return C0139v.m594a(this);
    }

    public boolean m1935a(Intent intent) {
        return C0139v.m596a((Activity) this, intent);
    }

    public void m1936b(Intent intent) {
        C0139v.m599b((Activity) this, intent);
    }

    public void onContentChanged() {
        m1942i();
    }

    @Deprecated
    public void m1942i() {
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        m1943j().mo367c(bundle);
    }

    public C0453g m1943j() {
        if (this.f690m == null) {
            this.f690m = C0453g.m2004a((Activity) this, (C0433f) this);
        }
        return this.f690m;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (C0331g.m1535a(keyEvent, CodedOutputStream.DEFAULT_BUFFER_SIZE) && keyEvent.getUnicodeChar(keyEvent.getMetaState() & -28673) == 60) {
            int action = keyEvent.getAction();
            if (action == 0) {
                C0432a g = m1940g();
                if (g != null && g.mo413b() && g.mo420g()) {
                    this.f692o = true;
                    return true;
                }
            } else if (action == 1 && this.f692o) {
                this.f692o = false;
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public Resources getResources() {
        if (this.f693p == null && at.m3008a()) {
            this.f693p = new at(this, super.getResources());
        }
        return this.f693p == null ? super.getResources() : this.f693p;
    }
}
