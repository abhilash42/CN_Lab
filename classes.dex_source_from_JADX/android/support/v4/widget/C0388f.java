package android.support.v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.support.v4.widget.C0389g.C0387a;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

/* compiled from: CursorAdapter */
public abstract class C0388f extends BaseAdapter implements C0387a, Filterable {
    protected boolean f662a;
    protected boolean f663b;
    protected Cursor f664c;
    protected Context f665d;
    protected int f666e;
    protected C0385a f667f;
    protected DataSetObserver f668g;
    protected C0389g f669h;
    protected FilterQueryProvider f670i;

    /* compiled from: CursorAdapter */
    private class C0385a extends ContentObserver {
        final /* synthetic */ C0388f f660a;

        public C0385a(C0388f c0388f) {
            this.f660a = c0388f;
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            this.f660a.m1755b();
        }
    }

    /* compiled from: CursorAdapter */
    private class C0386b extends DataSetObserver {
        final /* synthetic */ C0388f f661a;

        private C0386b(C0388f c0388f) {
            this.f661a = c0388f;
        }

        public void onChanged() {
            this.f661a.f662a = true;
            this.f661a.notifyDataSetChanged();
        }

        public void onInvalidated() {
            this.f661a.f662a = false;
            this.f661a.notifyDataSetInvalidated();
        }
    }

    public abstract View mo326a(Context context, Cursor cursor, ViewGroup viewGroup);

    public abstract void mo538a(View view, Context context, Cursor cursor);

    public C0388f(Context context, Cursor cursor, boolean z) {
        m1750a(context, cursor, z ? 1 : 2);
    }

    void m1750a(Context context, Cursor cursor, int i) {
        boolean z = true;
        if ((i & 1) == 1) {
            i |= 2;
            this.f663b = true;
        } else {
            this.f663b = false;
        }
        if (cursor == null) {
            z = false;
        }
        this.f664c = cursor;
        this.f662a = z;
        this.f665d = context;
        this.f666e = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.f667f = new C0385a(this);
            this.f668g = new C0386b();
        } else {
            this.f667f = null;
            this.f668g = null;
        }
        if (z) {
            if (this.f667f != null) {
                cursor.registerContentObserver(this.f667f);
            }
            if (this.f668g != null) {
                cursor.registerDataSetObserver(this.f668g);
            }
        }
    }

    public Cursor mo307a() {
        return this.f664c;
    }

    public int getCount() {
        if (!this.f662a || this.f664c == null) {
            return 0;
        }
        return this.f664c.getCount();
    }

    public Object getItem(int i) {
        if (!this.f662a || this.f664c == null) {
            return null;
        }
        this.f664c.moveToPosition(i);
        return this.f664c;
    }

    public long getItemId(int i) {
        if (this.f662a && this.f664c != null && this.f664c.moveToPosition(i)) {
            return this.f664c.getLong(this.f666e);
        }
        return 0;
    }

    public boolean hasStableIds() {
        return true;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f662a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f664c.moveToPosition(i)) {
            if (view == null) {
                view = mo326a(this.f665d, this.f664c, viewGroup);
            }
            mo538a(view, this.f665d, this.f664c);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f662a) {
            return null;
        }
        this.f664c.moveToPosition(i);
        if (view == null) {
            view = mo327b(this.f665d, this.f664c, viewGroup);
        }
        mo538a(view, this.f665d, this.f664c);
        return view;
    }

    public View mo327b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return mo326a(context, cursor, viewGroup);
    }

    public void mo309a(Cursor cursor) {
        Cursor b = m1753b(cursor);
        if (b != null) {
            b.close();
        }
    }

    public Cursor m1753b(Cursor cursor) {
        if (cursor == this.f664c) {
            return null;
        }
        Cursor cursor2 = this.f664c;
        if (cursor2 != null) {
            if (this.f667f != null) {
                cursor2.unregisterContentObserver(this.f667f);
            }
            if (this.f668g != null) {
                cursor2.unregisterDataSetObserver(this.f668g);
            }
        }
        this.f664c = cursor;
        if (cursor != null) {
            if (this.f667f != null) {
                cursor.registerContentObserver(this.f667f);
            }
            if (this.f668g != null) {
                cursor.registerDataSetObserver(this.f668g);
            }
            this.f666e = cursor.getColumnIndexOrThrow("_id");
            this.f662a = true;
            notifyDataSetChanged();
            return cursor2;
        }
        this.f666e = -1;
        this.f662a = false;
        notifyDataSetInvalidated();
        return cursor2;
    }

    public CharSequence mo310c(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public Cursor mo308a(CharSequence charSequence) {
        if (this.f670i != null) {
            return this.f670i.runQuery(charSequence);
        }
        return this.f664c;
    }

    public Filter getFilter() {
        if (this.f669h == null) {
            this.f669h = new C0389g(this);
        }
        return this.f669h;
    }

    protected void m1755b() {
        if (this.f663b && this.f664c != null && !this.f664c.isClosed()) {
            this.f662a = this.f664c.requery();
        }
    }
}
