package android.support.v4.p004a;

import android.support.v4.p009e.C0191c;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: Loader */
public class C0036h<D> {
    int f90a;
    C0035b<D> f91b;
    C0034a<D> f92c;
    boolean f93d;
    boolean f94e;
    boolean f95f;
    boolean f96g;
    boolean f97h;

    /* compiled from: Loader */
    public interface C0034a<D> {
    }

    /* compiled from: Loader */
    public interface C0035b<D> {
    }

    public void m96a(int i, C0035b<D> c0035b) {
        if (this.f91b != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f91b = c0035b;
        this.f90a = i;
    }

    public void m98a(C0035b<D> c0035b) {
        if (this.f91b == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f91b != c0035b) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f91b = null;
        }
    }

    public void m97a(C0034a<D> c0034a) {
        if (this.f92c != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f92c = c0034a;
    }

    public void m101b(C0034a<D> c0034a) {
        if (this.f92c == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f92c != c0034a) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f92c = null;
        }
    }

    public final void m95a() {
        this.f93d = true;
        this.f95f = false;
        this.f94e = false;
        m100b();
    }

    protected void m100b() {
    }

    public void m102c() {
        this.f93d = false;
        m103d();
    }

    protected void m103d() {
    }

    public void m104e() {
        m105f();
        this.f95f = true;
        this.f93d = false;
        this.f94e = false;
        this.f96g = false;
        this.f97h = false;
    }

    protected void m105f() {
    }

    public String m94a(D d) {
        StringBuilder stringBuilder = new StringBuilder(64);
        C0191c.m779a(d, stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        C0191c.m779a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.f90a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void m99a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f90a);
        printWriter.print(" mListener=");
        printWriter.println(this.f91b);
        if (this.f93d || this.f96g || this.f97h) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f93d);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f96g);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f97h);
        }
        if (this.f94e || this.f95f) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f94e);
            printWriter.print(" mReset=");
            printWriter.println(this.f95f);
        }
    }
}
