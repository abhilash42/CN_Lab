package io.fabric.sdk.android;

import android.content.Context;
import io.fabric.sdk.android.services.concurrency.C0687l;
import io.fabric.sdk.android.services.concurrency.C1524d;
import io.fabric.sdk.android.services.p020b.C1493o;
import java.io.File;
import java.util.Collection;

/* compiled from: Kit */
public abstract class C0653h<Result> implements Comparable<C0653h> {
    Context context;
    final C1524d dependsOnAnnotation = ((C1524d) getClass().getAnnotation(C1524d.class));
    C1457c fabric;
    C1493o idManager;
    C1454f<Result> initializationCallback;
    C1464g<Result> initializationTask = new C1464g(this);

    protected abstract Result doInBackground();

    public abstract String getIdentifier();

    public abstract String getVersion();

    void injectParameters(Context context, C1457c c1457c, C1454f<Result> c1454f, C1493o c1493o) {
        this.fabric = c1457c;
        this.context = new C1458d(context, getIdentifier(), getPath());
        this.initializationCallback = c1454f;
        this.idManager = c1493o;
    }

    final void initialize() {
        this.initializationTask.m5583a(this.fabric.m5558f(), (Void) null);
    }

    protected boolean onPreExecute() {
        return true;
    }

    protected void onPostExecute(Result result) {
    }

    protected void onCancelled(Result result) {
    }

    protected C1493o getIdManager() {
        return this.idManager;
    }

    public Context getContext() {
        return this.context;
    }

    public C1457c getFabric() {
        return this.fabric;
    }

    public String getPath() {
        return ".Fabric" + File.separator + getIdentifier();
    }

    public int compareTo(C0653h c0653h) {
        if (containsAnnotatedDependency(c0653h)) {
            return 1;
        }
        if (c0653h.containsAnnotatedDependency(this)) {
            return -1;
        }
        if (hasAnnotatedDependency() && !c0653h.hasAnnotatedDependency()) {
            return 1;
        }
        if (hasAnnotatedDependency() || !c0653h.hasAnnotatedDependency()) {
            return 0;
        }
        return -1;
    }

    boolean containsAnnotatedDependency(C0653h c0653h) {
        if (!hasAnnotatedDependency()) {
            return false;
        }
        for (Class isAssignableFrom : this.dependsOnAnnotation.m5780a()) {
            if (isAssignableFrom.isAssignableFrom(c0653h.getClass())) {
                return true;
            }
        }
        return false;
    }

    boolean hasAnnotatedDependency() {
        return this.dependsOnAnnotation != null;
    }

    protected Collection<C0687l> getDependencies() {
        return this.initializationTask.getDependencies();
    }
}
