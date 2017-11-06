package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: ResourceCursorAdapter */
public abstract class C0412t extends C0388f {
    private int f679j;
    private int f680k;
    private LayoutInflater f681l;

    public C0412t(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f680k = i;
        this.f679j = i;
        this.f681l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View mo326a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f681l.inflate(this.f679j, viewGroup, false);
    }

    public View mo327b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f681l.inflate(this.f680k, viewGroup, false);
    }
}
