package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.p004a.C0023a;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TaskStackBuilder */
public final class ap implements Iterable<Intent> {
    private static final C0085b f253a;
    private final ArrayList<Intent> f254b = new ArrayList();
    private final Context f255c;

    /* compiled from: TaskStackBuilder */
    public interface C0084a {
        Intent mo342a();
    }

    /* compiled from: TaskStackBuilder */
    interface C0085b {
    }

    /* compiled from: TaskStackBuilder */
    static class C0086c implements C0085b {
        C0086c() {
        }
    }

    /* compiled from: TaskStackBuilder */
    static class C0087d implements C0085b {
        C0087d() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            f253a = new C0087d();
        } else {
            f253a = new C0086c();
        }
    }

    private ap(Context context) {
        this.f255c = context;
    }

    public static ap m296a(Context context) {
        return new ap(context);
    }

    public ap m299a(Intent intent) {
        this.f254b.add(intent);
        return this;
    }

    public ap m297a(Activity activity) {
        Intent a;
        Intent intent = null;
        if (activity instanceof C0084a) {
            intent = ((C0084a) activity).mo342a();
        }
        if (intent == null) {
            a = C0139v.m594a(activity);
        } else {
            a = intent;
        }
        if (a != null) {
            ComponentName component = a.getComponent();
            if (component == null) {
                component = a.resolveActivity(this.f255c.getPackageManager());
            }
            m298a(component);
            m299a(a);
        }
        return this;
    }

    public ap m298a(ComponentName componentName) {
        int size = this.f254b.size();
        try {
            Intent a = C0139v.m595a(this.f255c, componentName);
            while (a != null) {
                this.f254b.add(size, a);
                a = C0139v.m595a(this.f255c, a.getComponent());
            }
            return this;
        } catch (Throwable e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public Iterator<Intent> iterator() {
        return this.f254b.iterator();
    }

    public void m300a() {
        m301a(null);
    }

    public void m301a(Bundle bundle) {
        if (this.f254b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f254b.toArray(new Intent[this.f254b.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (!C0023a.m79a(this.f255c, intentArr, bundle)) {
            Intent intent = new Intent(intentArr[intentArr.length - 1]);
            intent.addFlags(268435456);
            this.f255c.startActivity(intent);
        }
    }
}
