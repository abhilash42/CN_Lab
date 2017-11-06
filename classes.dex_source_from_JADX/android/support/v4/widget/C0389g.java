package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

/* compiled from: CursorFilter */
class C0389g extends Filter {
    C0387a f671a;

    /* compiled from: CursorFilter */
    interface C0387a {
        Cursor mo307a();

        Cursor mo308a(CharSequence charSequence);

        void mo309a(Cursor cursor);

        CharSequence mo310c(Cursor cursor);
    }

    C0389g(C0387a c0387a) {
        this.f671a = c0387a;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.f671a.mo310c((Cursor) obj);
    }

    protected FilterResults performFiltering(CharSequence charSequence) {
        Cursor a = this.f671a.mo308a(charSequence);
        FilterResults filterResults = new FilterResults();
        if (a != null) {
            filterResults.count = a.getCount();
            filterResults.values = a;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        Cursor a = this.f671a.mo307a();
        if (filterResults.values != null && filterResults.values != a) {
            this.f671a.mo309a((Cursor) filterResults.values);
        }
    }
}
