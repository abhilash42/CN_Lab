package io.fabric.sdk.android;

import io.fabric.sdk.android.services.concurrency.C1463f;
import io.fabric.sdk.android.services.concurrency.C1525e;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import io.fabric.sdk.android.services.p020b.C1502t;

/* compiled from: InitializationTask */
class C1464g<Result> extends C1463f<Void, Void, Result> {
    final C0653h<Result> f3672a;

    public C1464g(C0653h<Result> c0653h) {
        this.f3672a = c0653h;
    }

    protected void mo823a() {
        super.mo823a();
        C1502t a = m5585a("onPreExecute");
        try {
            boolean onPreExecute = this.f3672a.onPreExecute();
            a.m5742b();
            if (!onPreExecute) {
                m5576a(true);
            }
        } catch (UnmetDependencyException e) {
            throw e;
        } catch (Throwable e2) {
            C1457c.m5546h().mo819e("Fabric", "Failure onPreExecute()", e2);
            a.m5742b();
            m5576a(true);
        } catch (Throwable th) {
            a.m5742b();
            m5576a(true);
        }
    }

    protected Result m5587a(Void... voidArr) {
        C1502t a = m5585a("doInBackground");
        Result result = null;
        if (!m5581d()) {
            result = this.f3672a.doInBackground();
        }
        a.m5742b();
        return result;
    }

    protected void mo824a(Result result) {
        this.f3672a.onPostExecute(result);
        this.f3672a.initializationCallback.mo821a((Object) result);
    }

    protected void mo825b(Result result) {
        this.f3672a.onCancelled(result);
        this.f3672a.initializationCallback.mo820a(new InitializationException(this.f3672a.getIdentifier() + " Initialization was cancelled"));
    }

    public C1525e getPriority() {
        return C1525e.HIGH;
    }

    private C1502t m5585a(String str) {
        C1502t c1502t = new C1502t(this.f3672a.getIdentifier() + "." + str, "KitInitialization");
        c1502t.m5741a();
        return c1502t;
    }
}
