package android.support.v4.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.app.C0050a.C0049a;
import android.support.v4.app.C0089b.C0088a;
import android.support.v4.p009e.C0188i;
import android.support.v4.p009e.C0204j;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import io.fabric.sdk.android.services.p020b.C0671a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* compiled from: FragmentActivity */
public class C0113l extends C0107j implements C0049a, C0088a {
    final Handler f332a = new C01091(this);
    final C0114n f333b = C0114n.m429a(new C0111a(this));
    boolean f334c;
    boolean f335d;
    boolean f336e;
    boolean f337f;
    boolean f338g;
    boolean f339h;
    boolean f340i;
    int f341j;
    boolean f342k;
    C0204j<String> f343l;

    /* compiled from: FragmentActivity */
    class C01091 extends Handler {
        final /* synthetic */ C0113l f317a;

        C01091(C0113l c0113l) {
            this.f317a = c0113l;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (this.f317a.f336e) {
                        this.f317a.m422a(false);
                        return;
                    }
                    return;
                case 2:
                    this.f317a.m424b();
                    this.f317a.f333b.m456n();
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    /* compiled from: FragmentActivity */
    class C0111a extends C0110o<C0113l> {
        final /* synthetic */ C0113l f328a;

        public C0111a(C0113l c0113l) {
            this.f328a = c0113l;
            super(c0113l);
        }

        public void mo63a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            this.f328a.dump(str, fileDescriptor, printWriter, strArr);
        }

        public boolean mo64a(Fragment fragment) {
            return !this.f328a.isFinishing();
        }

        public LayoutInflater mo65b() {
            return this.f328a.getLayoutInflater().cloneInContext(this.f328a);
        }

        public void mo67c() {
            this.f328a.mo346d();
        }

        public void mo62a(Fragment fragment, Intent intent, int i, Bundle bundle) {
            this.f328a.m421a(fragment, intent, i, bundle);
        }

        public boolean mo68d() {
            return this.f328a.getWindow() != null;
        }

        public int mo69e() {
            Window window = this.f328a.getWindow();
            return window == null ? 0 : window.getAttributes().windowAnimations;
        }

        public void mo66b(Fragment fragment) {
            this.f328a.m420a(fragment);
        }

        public View mo27a(int i) {
            return this.f328a.findViewById(i);
        }

        public boolean mo28a() {
            Window window = this.f328a.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }
    }

    /* compiled from: FragmentActivity */
    static final class C0112b {
        Object f329a;
        List<Fragment> f330b;
        C0188i<String, C0133t> f331c;

        C0112b() {
        }
    }

    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.f333b.m442b();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String str = (String) this.f343l.m808a(i4);
            this.f343l.m814c(i4);
            if (str == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment a = this.f333b.m430a(str);
            if (a == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
                return;
            } else {
                a.m140a(65535 & i, i2, intent);
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (!this.f333b.m431a().mo81b()) {
            a_();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f333b.m433a(configuration);
    }

    protected void onCreate(Bundle bundle) {
        this.f333b.m435a(null);
        super.onCreate(bundle);
        C0112b c0112b = (C0112b) getLastNonConfigurationInstance();
        if (c0112b != null) {
            this.f333b.m436a(c0112b.f331c);
        }
        if (bundle != null) {
            this.f333b.m434a(bundle.getParcelable("android:support:fragments"), c0112b != null ? c0112b.f330b : null);
            if (bundle.containsKey("android:support:next_request_index")) {
                this.f341j = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.f343l = new C0204j(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.f343l.m812b(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.f343l == null) {
            this.f343l = new C0204j();
            this.f341j = 0;
        }
        this.f333b.m447e();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu) | this.f333b.m440a(menu, getMenuInflater());
        if (VERSION.SDK_INT >= 11) {
            return onCreatePanelMenu;
        }
        return true;
    }

    final View mo70a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f333b.m432a(view, str, context, attributeSet);
    }

    protected void onDestroy() {
        super.onDestroy();
        m422a(false);
        this.f333b.m454l();
        this.f333b.m458p();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (VERSION.SDK_INT >= 5 || i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.f333b.m455m();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.f333b.m441a(menuItem);
            case 6:
                return this.f333b.m444b(menuItem);
            default:
                return false;
        }
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.f333b.m443b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    protected void onPause() {
        super.onPause();
        this.f335d = false;
        if (this.f332a.hasMessages(2)) {
            this.f332a.removeMessages(2);
            m424b();
        }
        this.f333b.m451i();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f333b.m442b();
    }

    public void onStateNotSaved() {
        this.f333b.m442b();
    }

    protected void onResume() {
        super.onResume();
        this.f332a.sendEmptyMessage(2);
        this.f335d = true;
        this.f333b.m456n();
    }

    protected void onPostResume() {
        super.onPostResume();
        this.f332a.removeMessages(2);
        m424b();
        this.f333b.m456n();
    }

    protected void m424b() {
        this.f333b.m450h();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.f339h) {
            this.f339h = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return m423a(view, menu) | this.f333b.m439a(menu);
    }

    protected boolean m423a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public final Object onRetainNonConfigurationInstance() {
        if (this.f336e) {
            m422a(true);
        }
        Object c = m425c();
        List d = this.f333b.m446d();
        C0188i r = this.f333b.m460r();
        if (d == null && r == null && c == null) {
            return null;
        }
        Object c0112b = new C0112b();
        c0112b.f329a = c;
        c0112b.f330b = d;
        c0112b.f331c = r;
        return c0112b;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable c = this.f333b.m445c();
        if (c != null) {
            bundle.putParcelable("android:support:fragments", c);
        }
        if (this.f343l.m810b() > 0) {
            bundle.putInt("android:support:next_request_index", this.f341j);
            int[] iArr = new int[this.f343l.m810b()];
            String[] strArr = new String[this.f343l.m810b()];
            for (int i = 0; i < this.f343l.m810b(); i++) {
                iArr[i] = this.f343l.m815d(i);
                strArr[i] = (String) this.f343l.m816e(i);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    protected void onStart() {
        super.onStart();
        this.f336e = false;
        this.f337f = false;
        this.f332a.removeMessages(1);
        if (!this.f334c) {
            this.f334c = true;
            this.f333b.m448f();
        }
        this.f333b.m442b();
        this.f333b.m456n();
        this.f333b.m457o();
        this.f333b.m449g();
        this.f333b.m459q();
    }

    protected void onStop() {
        super.onStop();
        this.f336e = true;
        this.f332a.sendEmptyMessage(1);
        this.f333b.m452j();
    }

    public Object m425c() {
        return null;
    }

    public void mo346d() {
        if (VERSION.SDK_INT >= 11) {
            C0090c.m304a(this);
        } else {
            this.f339h = true;
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2;
        if (VERSION.SDK_INT >= 11) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.f334c);
            printWriter.print("mResumed=");
            printWriter.print(this.f335d);
            printWriter.print(" mStopped=");
            printWriter.print(this.f336e);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.f337f);
            this.f333b.m437a(str2, fileDescriptor, printWriter, strArr);
            this.f333b.m431a().mo80a(str, fileDescriptor, printWriter, strArr);
            printWriter.print(str);
            printWriter.println("View Hierarchy:");
            m416a(str + "  ", printWriter, getWindow().getDecorView());
        } else {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.f334c);
            printWriter.print("mResumed=");
            printWriter.print(this.f335d);
            printWriter.print(" mStopped=");
            printWriter.print(this.f336e);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.f337f);
            this.f333b.m437a(str2, fileDescriptor, printWriter, strArr);
            this.f333b.m431a().mo80a(str, fileDescriptor, printWriter, strArr);
            printWriter.print(str);
            printWriter.println("View Hierarchy:");
            m416a(str + "  ", printWriter, getWindow().getDecorView());
        }
    }

    private static String m415a(View view) {
        char c;
        char c2 = 'F';
        char c3 = '.';
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(view.getClass().getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(view)));
        stringBuilder.append(' ');
        switch (view.getVisibility()) {
            case 0:
                stringBuilder.append('V');
                break;
            case 4:
                stringBuilder.append('I');
                break;
            case 8:
                stringBuilder.append('G');
                break;
            default:
                stringBuilder.append('.');
                break;
        }
        if (view.isFocusable()) {
            c = 'F';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isEnabled()) {
            c = 'E';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(view.willNotDraw() ? '.' : 'D');
        if (view.isHorizontalScrollBarEnabled()) {
            c = 'H';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isVerticalScrollBarEnabled()) {
            c = 'V';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isClickable()) {
            c = 'C';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isLongClickable()) {
            c = 'L';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(' ');
        if (!view.isFocused()) {
            c2 = '.';
        }
        stringBuilder.append(c2);
        if (view.isSelected()) {
            c = 'S';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isPressed()) {
            c3 = 'P';
        }
        stringBuilder.append(c3);
        stringBuilder.append(' ');
        stringBuilder.append(view.getLeft());
        stringBuilder.append(',');
        stringBuilder.append(view.getTop());
        stringBuilder.append('-');
        stringBuilder.append(view.getRight());
        stringBuilder.append(',');
        stringBuilder.append(view.getBottom());
        int id = view.getId();
        if (id != -1) {
            stringBuilder.append(" #");
            stringBuilder.append(Integer.toHexString(id));
            Resources resources = view.getResources();
            if (!(id == 0 || resources == null)) {
                String str;
                switch (-16777216 & id) {
                    case 16777216:
                        str = C0671a.ANDROID_CLIENT_TYPE;
                        break;
                    case 2130706432:
                        str = "app";
                        break;
                    default:
                        try {
                            str = resources.getResourcePackageName(id);
                            break;
                        } catch (NotFoundException e) {
                            break;
                        }
                }
                String resourceTypeName = resources.getResourceTypeName(id);
                String resourceEntryName = resources.getResourceEntryName(id);
                stringBuilder.append(" ");
                stringBuilder.append(str);
                stringBuilder.append(":");
                stringBuilder.append(resourceTypeName);
                stringBuilder.append("/");
                stringBuilder.append(resourceEntryName);
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private void m416a(String str, PrintWriter printWriter, View view) {
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(C0113l.m415a(view));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                String str2 = str + "  ";
                for (int i = 0; i < childCount; i++) {
                    m416a(str2, printWriter, viewGroup.getChildAt(i));
                }
            }
        }
    }

    void m422a(boolean z) {
        if (!this.f337f) {
            this.f337f = true;
            this.f338g = z;
            this.f332a.removeMessages(1);
            m427e();
        }
    }

    void m427e() {
        this.f333b.m438a(this.f338g);
        this.f333b.m453k();
    }

    public void m420a(Fragment fragment) {
    }

    public C0116p m428f() {
        return this.f333b.m431a();
    }

    public void startActivityForResult(Intent intent, int i) {
        if (this.f342k || i == -1 || (-65536 & i) == 0) {
            super.startActivityForResult(intent, i);
            return;
        }
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }

    public final void mo71a(int i) {
        if (!this.f340i && i != -1 && (-65536 & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String str = (String) this.f343l.m808a(i3);
            this.f343l.m814c(i3);
            if (str == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment a = this.f333b.m430a(str);
            if (a == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
            } else {
                a.m142a(i & 65535, strArr, iArr);
            }
        }
    }

    public void m421a(Fragment fragment, Intent intent, int i, Bundle bundle) {
        this.f342k = true;
        if (i == -1) {
            try {
                C0050a.m205a(this, intent, -1, bundle);
            } finally {
                this.f342k = false;
            }
        } else if ((-65536 & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } else {
            C0050a.m205a(this, intent, ((m417b(fragment) + 1) << 16) + (65535 & i), bundle);
            this.f342k = false;
        }
    }

    private int m417b(Fragment fragment) {
        if (this.f343l.m810b() >= 65534) {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
        while (this.f343l.m817f(this.f341j) >= 0) {
            this.f341j = (this.f341j + 1) % 65534;
        }
        int i = this.f341j;
        this.f343l.m812b(i, fragment.f159q);
        this.f341j = (this.f341j + 1) % 65534;
        return i;
    }
}
