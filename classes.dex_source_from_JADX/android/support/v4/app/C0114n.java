package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.support.v4.p009e.C0188i;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* compiled from: FragmentController */
public class C0114n {
    private final C0110o<?> f344a;

    public static final C0114n m429a(C0110o<?> c0110o) {
        return new C0114n(c0110o);
    }

    private C0114n(C0110o<?> c0110o) {
        this.f344a = c0110o;
    }

    public C0116p m431a() {
        return this.f344a.m399i();
    }

    Fragment m430a(String str) {
        return this.f344a.f321d.m502b(str);
    }

    public void m435a(Fragment fragment) {
        this.f344a.f321d.m495a(this.f344a, this.f344a, fragment);
    }

    public View m432a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f344a.f321d.mo78a(view, str, context, attributeSet);
    }

    public void m442b() {
        this.f344a.f321d.m523i();
    }

    public Parcelable m445c() {
        return this.f344a.f321d.m522h();
    }

    public void m434a(Parcelable parcelable, List<Fragment> list) {
        this.f344a.f321d.m490a(parcelable, (List) list);
    }

    public List<Fragment> m446d() {
        return this.f344a.f321d.m521g();
    }

    public void m447e() {
        this.f344a.f321d.m524j();
    }

    public void m448f() {
        this.f344a.f321d.m525k();
    }

    public void m449g() {
        this.f344a.f321d.m526l();
    }

    public void m450h() {
        this.f344a.f321d.m527m();
    }

    public void m451i() {
        this.f344a.f321d.m528n();
    }

    public void m452j() {
        this.f344a.f321d.m529o();
    }

    public void m453k() {
        this.f344a.f321d.m530p();
    }

    public void m454l() {
        this.f344a.f321d.m532r();
    }

    public void m433a(Configuration configuration) {
        this.f344a.f321d.m488a(configuration);
    }

    public void m455m() {
        this.f344a.f321d.m533s();
    }

    public boolean m440a(Menu menu, MenuInflater menuInflater) {
        return this.f344a.f321d.m500a(menu, menuInflater);
    }

    public boolean m439a(Menu menu) {
        return this.f344a.f321d.m499a(menu);
    }

    public boolean m441a(MenuItem menuItem) {
        return this.f344a.f321d.m501a(menuItem);
    }

    public boolean m444b(MenuItem menuItem) {
        return this.f344a.f321d.m509b(menuItem);
    }

    public void m443b(Menu menu) {
        this.f344a.f321d.m507b(menu);
    }

    public boolean m456n() {
        return this.f344a.f321d.m518e();
    }

    public void m457o() {
        this.f344a.m401k();
    }

    public void m438a(boolean z) {
        this.f344a.m387a(z);
    }

    public void m458p() {
        this.f344a.m402l();
    }

    public void m459q() {
        this.f344a.m403m();
    }

    public C0188i<String, C0133t> m460r() {
        return this.f344a.m404n();
    }

    public void m436a(C0188i<String, C0133t> c0188i) {
        this.f344a.m384a((C0188i) c0188i);
    }

    public void m437a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f344a.m392b(str, fileDescriptor, printWriter, strArr);
    }
}
