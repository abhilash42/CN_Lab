package android.support.v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.p004a.C0023a;
import android.support.v4.widget.C0412t;
import android.support.v7.p013b.C0509a.C0498a;
import android.support.v7.p013b.C0509a.C0503f;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* compiled from: SuggestionsAdapter */
class al extends C0412t implements OnClickListener {
    private final SearchManager f1528j = ((SearchManager) this.d.getSystemService("search"));
    private final SearchView f1529k;
    private final SearchableInfo f1530l;
    private final Context f1531m;
    private final WeakHashMap<String, ConstantState> f1532n;
    private final int f1533o;
    private boolean f1534p = false;
    private int f1535q = 1;
    private ColorStateList f1536r;
    private int f1537s = -1;
    private int f1538t = -1;
    private int f1539u = -1;
    private int f1540v = -1;
    private int f1541w = -1;
    private int f1542x = -1;

    /* compiled from: SuggestionsAdapter */
    private static final class C0600a {
        public final TextView f1523a;
        public final TextView f1524b;
        public final ImageView f1525c;
        public final ImageView f1526d;
        public final ImageView f1527e;

        public C0600a(View view) {
            this.f1523a = (TextView) view.findViewById(16908308);
            this.f1524b = (TextView) view.findViewById(16908309);
            this.f1525c = (ImageView) view.findViewById(16908295);
            this.f1526d = (ImageView) view.findViewById(16908296);
            this.f1527e = (ImageView) view.findViewById(C0503f.edit_query);
        }
    }

    public al(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f1529k = searchView;
        this.f1530l = searchableInfo;
        this.f1533o = searchView.getSuggestionCommitIconResId();
        this.f1531m = context;
        this.f1532n = weakHashMap;
    }

    public void m2925a(int i) {
        this.f1535q = i;
    }

    public boolean hasStableIds() {
        return false;
    }

    public Cursor mo308a(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.f1529k.getVisibility() != 0 || this.f1529k.getWindowVisibility() != 0) {
            return null;
        }
        try {
            Cursor a = m2921a(this.f1530l, charSequence2, 50);
            if (a != null) {
                a.getCount();
                return a;
            }
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
        }
        return null;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        m2917d(mo307a());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        m2917d(mo307a());
    }

    private void m2917d(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null && !extras.getBoolean("in_progress")) {
        }
    }

    public void mo309a(Cursor cursor) {
        if (this.f1534p) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.mo309a(cursor);
            if (cursor != null) {
                this.f1537s = cursor.getColumnIndex("suggest_text_1");
                this.f1538t = cursor.getColumnIndex("suggest_text_2");
                this.f1539u = cursor.getColumnIndex("suggest_text_2_url");
                this.f1540v = cursor.getColumnIndex("suggest_icon_1");
                this.f1541w = cursor.getColumnIndex("suggest_icon_2");
                this.f1542x = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Throwable e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    public View mo326a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View a = super.mo326a(context, cursor, viewGroup);
        a.setTag(new C0600a(a));
        ((ImageView) a.findViewById(C0503f.edit_query)).setImageResource(this.f1533o);
        return a;
    }

    public void mo538a(View view, Context context, Cursor cursor) {
        C0600a c0600a = (C0600a) view.getTag();
        int i;
        if (this.f1542x != -1) {
            i = cursor.getInt(this.f1542x);
        } else {
            i = 0;
        }
        if (c0600a.f1523a != null) {
            m2911a(c0600a.f1523a, m2908a(cursor, this.f1537s));
        }
        if (c0600a.f1524b != null) {
            CharSequence a = m2908a(cursor, this.f1539u);
            if (a != null) {
                a = m2916b(a);
            } else {
                a = m2908a(cursor, this.f1538t);
            }
            if (TextUtils.isEmpty(a)) {
                if (c0600a.f1523a != null) {
                    c0600a.f1523a.setSingleLine(false);
                    c0600a.f1523a.setMaxLines(2);
                }
            } else if (c0600a.f1523a != null) {
                c0600a.f1523a.setSingleLine(true);
                c0600a.f1523a.setMaxLines(1);
            }
            m2911a(c0600a.f1524b, a);
        }
        if (c0600a.f1525c != null) {
            m2910a(c0600a.f1525c, m2918e(cursor), 4);
        }
        if (c0600a.f1526d != null) {
            m2910a(c0600a.f1526d, m2919f(cursor), 8);
        }
        if (this.f1535q == 2 || (this.f1535q == 1 && (r1 & 1) != 0)) {
            c0600a.f1527e.setVisibility(0);
            c0600a.f1527e.setTag(c0600a.f1523a.getText());
            c0600a.f1527e.setOnClickListener(this);
            return;
        }
        c0600a.f1527e.setVisibility(8);
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f1529k.m2739a((CharSequence) tag);
        }
    }

    private CharSequence m2916b(CharSequence charSequence) {
        if (this.f1536r == null) {
            TypedValue typedValue = new TypedValue();
            this.d.getTheme().resolveAttribute(C0498a.textColorSearchUrl, typedValue, true);
            this.f1536r = this.d.getResources().getColorStateList(typedValue.resourceId);
        }
        CharSequence spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f1536r, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private void m2911a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private Drawable m2918e(Cursor cursor) {
        if (this.f1540v == -1) {
            return null;
        }
        Drawable a = m2907a(cursor.getString(this.f1540v));
        return a == null ? m2920g(cursor) : a;
    }

    private Drawable m2919f(Cursor cursor) {
        if (this.f1541w == -1) {
            return null;
        }
        return m2907a(cursor.getString(this.f1541w));
    }

    private void m2910a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    public CharSequence mo310c(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        String a = m2909a(cursor, "suggest_intent_query");
        if (a != null) {
            return a;
        }
        if (this.f1530l.shouldRewriteQueryFromData()) {
            a = m2909a(cursor, "suggest_intent_data");
            if (a != null) {
                return a;
            }
        }
        if (!this.f1530l.shouldRewriteQueryFromText()) {
            return null;
        }
        a = m2909a(cursor, "suggest_text_1");
        if (a != null) {
            return a;
        }
        return null;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View a = mo326a(this.d, this.c, viewGroup);
            if (a != null) {
                ((C0600a) a.getTag()).f1523a.setText(e.toString());
            }
            return a;
        }
    }

    private Drawable m2907a(String str) {
        if (str == null || str.length() == 0 || "0".equals(str)) {
            return null;
        }
        Drawable b;
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f1531m.getPackageName() + "/" + parseInt;
            b = m2915b(str2);
            if (b != null) {
                return b;
            }
            b = C0023a.m77a(this.f1531m, parseInt);
            m2912a(str2, b);
            return b;
        } catch (NumberFormatException e) {
            b = m2915b(str);
            if (b != null) {
                return b;
            }
            b = m2914b(Uri.parse(str));
            m2912a(str, b);
            return b;
        } catch (NotFoundException e2) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        }
    }

    private Drawable m2914b(Uri uri) {
        InputStream openInputStream;
        try {
            if ("android.resource".equals(uri.getScheme())) {
                return m2923a(uri);
            }
            openInputStream = this.f1531m.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
            try {
                openInputStream.close();
                return createFromStream;
            } catch (Throwable e) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e);
                return createFromStream;
            }
        } catch (NotFoundException e2) {
            throw new FileNotFoundException("Resource does not exist: " + uri);
        } catch (FileNotFoundException e3) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
            return null;
        } catch (Throwable th) {
            try {
                openInputStream.close();
            } catch (Throwable e4) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e4);
            }
        }
    }

    private Drawable m2915b(String str) {
        ConstantState constantState = (ConstantState) this.f1532n.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private void m2912a(String str, Drawable drawable) {
        if (drawable != null) {
            this.f1532n.put(str, drawable.getConstantState());
        }
    }

    private Drawable m2920g(Cursor cursor) {
        Drawable a = m2906a(this.f1530l.getSearchActivity());
        return a != null ? a : this.d.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable m2906a(ComponentName componentName) {
        Object obj = null;
        String flattenToShortString = componentName.flattenToShortString();
        if (this.f1532n.containsKey(flattenToShortString)) {
            ConstantState constantState = (ConstantState) this.f1532n.get(flattenToShortString);
            return constantState == null ? null : constantState.newDrawable(this.f1531m.getResources());
        } else {
            Drawable b = m2913b(componentName);
            if (b != null) {
                obj = b.getConstantState();
            }
            this.f1532n.put(flattenToShortString, obj);
            return b;
        }
    }

    private Drawable m2913b(ComponentName componentName) {
        PackageManager packageManager = this.d.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (NameNotFoundException e) {
            Log.w("SuggestionsAdapter", e.toString());
            return null;
        }
    }

    public static String m2909a(Cursor cursor, String str) {
        return m2908a(cursor, cursor.getColumnIndex(str));
    }

    private static String m2908a(Cursor cursor, int i) {
        String str = null;
        if (i != -1) {
            try {
                str = cursor.getString(i);
            } catch (Throwable e) {
                Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            }
        }
        return str;
    }

    Drawable m2923a(Uri uri) {
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.d.getPackageManager().getResourcesForApplication(authority);
            List pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    size = Integer.parseInt((String) pathSegments.get(0));
                } catch (NumberFormatException e) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else if (size == 2) {
                size = resourcesForApplication.getIdentifier((String) pathSegments.get(1), (String) pathSegments.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + uri);
            }
            if (size != 0) {
                return resourcesForApplication.getDrawable(size);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (NameNotFoundException e2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    Cursor m2921a(SearchableInfo searchableInfo, String str, int i) {
        if (searchableInfo == null) {
            return null;
        }
        String suggestAuthority = searchableInfo.getSuggestAuthority();
        if (suggestAuthority == null) {
            return null;
        }
        String[] strArr;
        Builder fragment = new Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
            strArr = null;
        }
        if (i > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.d.getContentResolver().query(fragment.build(), null, suggestSelection, strArr, null);
    }
}
