package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: PagerAdapter */
public abstract class ab {
    private final DataSetObservable f546a = new DataSetObservable();
    private DataSetObserver f547b;

    public abstract int mo804a();

    public abstract boolean mo808a(View view, Object obj);

    public void m1099a(ViewGroup viewGroup) {
        m1097a((View) viewGroup);
    }

    public Object mo806a(ViewGroup viewGroup, int i) {
        return m1093a((View) viewGroup, i);
    }

    public void mo807a(ViewGroup viewGroup, int i, Object obj) {
        m1098a((View) viewGroup, i, obj);
    }

    public void m1108b(ViewGroup viewGroup, int i, Object obj) {
        m1106b((View) viewGroup, i, obj);
    }

    public void m1107b(ViewGroup viewGroup) {
        m1105b((View) viewGroup);
    }

    public void m1097a(View view) {
    }

    public Object m1093a(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public void m1098a(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void m1106b(View view, int i, Object obj) {
    }

    public void m1105b(View view) {
    }

    public Parcelable m1103b() {
        return null;
    }

    public void m1096a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public int m1091a(Object obj) {
        return -1;
    }

    public void m1095a(DataSetObserver dataSetObserver) {
        this.f546a.registerObserver(dataSetObserver);
    }

    public void m1104b(DataSetObserver dataSetObserver) {
        this.f546a.unregisterObserver(dataSetObserver);
    }

    void m1109c(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f547b = dataSetObserver;
        }
    }

    public CharSequence mo805a(int i) {
        return null;
    }

    public float m1102b(int i) {
        return 1.0f;
    }
}
