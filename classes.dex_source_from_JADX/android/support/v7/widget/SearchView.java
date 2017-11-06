package android.support.v7.widget;

import android.annotation.TargetApi;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.support.v4.widget.C0388f;
import android.support.v7.p013b.C0509a.C0498a;
import android.support.v7.p013b.C0509a.C0501d;
import android.support.v7.view.C0514c;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends af implements C0514c {
    static final C0571a f1339a = new C0571a();
    private static final boolean f1340b;
    private boolean f1341A;
    private boolean f1342B;
    private int f1343C;
    private boolean f1344D;
    private CharSequence f1345E;
    private boolean f1346F;
    private int f1347G;
    private SearchableInfo f1348H;
    private Bundle f1349I;
    private Runnable f1350J;
    private final Runnable f1351K;
    private Runnable f1352L;
    private final WeakHashMap<String, ConstantState> f1353M;
    private final SearchAutoComplete f1354c;
    private final View f1355d;
    private final View f1356e;
    private final ImageView f1357f;
    private final ImageView f1358g;
    private final ImageView f1359h;
    private final ImageView f1360i;
    private final ImageView f1361j;
    private final Drawable f1362k;
    private final int f1363l;
    private final int f1364m;
    private final Intent f1365n;
    private final Intent f1366o;
    private final CharSequence f1367p;
    private C0573c f1368q;
    private C0572b f1369r;
    private OnFocusChangeListener f1370s;
    private C0574d f1371t;
    private OnClickListener f1372u;
    private boolean f1373v;
    private boolean f1374w;
    private C0388f f1375x;
    private boolean f1376y;
    private CharSequence f1377z;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C05691();
        boolean f1328a;

        static class C05691 implements Creator<SavedState> {
            C05691() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m2711a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m2712a(i);
            }

            public SavedState m2711a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m2712a(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f1328a = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.f1328a));
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f1328a + "}";
        }
    }

    public static class SearchAutoComplete extends C0570f {
        private int f1333a;
        private SearchView f1334b;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, C0498a.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f1333a = getThreshold();
        }

        void setSearchView(SearchView searchView) {
            this.f1334b = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f1333a = i;
        }

        protected void replaceText(CharSequence charSequence) {
        }

        public void performCompletion() {
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f1334b.hasFocus() && getVisibility() == 0) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                if (SearchView.m2722a(getContext())) {
                    SearchView.f1339a.m2714a(this, true);
                }
            }
        }

        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.f1334b.m2743d();
        }

        public boolean enoughToFilter() {
            return this.f1333a <= 0 || super.enoughToFilter();
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                DispatcherState keyDispatcherState;
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState == null) {
                        return true;
                    }
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f1334b.clearFocus();
                        this.f1334b.setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }
    }

    private static class C0571a {
        private Method f1335a;
        private Method f1336b;
        private Method f1337c;
        private Method f1338d;

        C0571a() {
            try {
                this.f1335a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f1335a.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            try {
                this.f1336b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f1336b.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            try {
                this.f1337c = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.f1337c.setAccessible(true);
            } catch (NoSuchMethodException e3) {
            }
            try {
                this.f1338d = InputMethodManager.class.getMethod("showSoftInputUnchecked", new Class[]{Integer.TYPE, ResultReceiver.class});
                this.f1338d.setAccessible(true);
            } catch (NoSuchMethodException e4) {
            }
        }

        void m2713a(AutoCompleteTextView autoCompleteTextView) {
            if (this.f1335a != null) {
                try {
                    this.f1335a.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        void m2715b(AutoCompleteTextView autoCompleteTextView) {
            if (this.f1336b != null) {
                try {
                    this.f1336b.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        void m2714a(AutoCompleteTextView autoCompleteTextView, boolean z) {
            if (this.f1337c != null) {
                try {
                    this.f1337c.invoke(autoCompleteTextView, new Object[]{Boolean.valueOf(z)});
                } catch (Exception e) {
                }
            }
        }
    }

    public interface C0572b {
        boolean m2716a();
    }

    public interface C0573c {
        boolean m2717a(String str);
    }

    public interface C0574d {
    }

    static {
        boolean z;
        if (VERSION.SDK_INT >= 8) {
            z = true;
        } else {
            z = false;
        }
        f1340b = z;
    }

    int getSuggestionRowLayout() {
        return this.f1363l;
    }

    int getSuggestionCommitIconResId() {
        return this.f1364m;
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f1348H = searchableInfo;
        if (this.f1348H != null) {
            if (f1340b) {
                m2732l();
            }
            m2731k();
        }
        boolean z = f1340b && m2726e();
        this.f1344D = z;
        if (this.f1344D) {
            this.f1354c.setPrivateImeOptions("nm");
        }
        m2721a(m2742c());
    }

    public void setAppSearchData(Bundle bundle) {
        this.f1349I = bundle;
    }

    public void setImeOptions(int i) {
        this.f1354c.setImeOptions(i);
    }

    public int getImeOptions() {
        return this.f1354c.getImeOptions();
    }

    public void setInputType(int i) {
        this.f1354c.setInputType(i);
    }

    public int getInputType() {
        return this.f1354c.getInputType();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.f1342B || !isFocusable()) {
            return false;
        }
        if (m2742c()) {
            return super.requestFocus(i, rect);
        }
        boolean requestFocus = this.f1354c.requestFocus(i, rect);
        if (requestFocus) {
            m2721a(false);
        }
        return requestFocus;
    }

    public void clearFocus() {
        this.f1342B = true;
        setImeVisibility(false);
        super.clearFocus();
        this.f1354c.clearFocus();
        this.f1342B = false;
    }

    public void setOnQueryTextListener(C0573c c0573c) {
        this.f1368q = c0573c;
    }

    public void setOnCloseListener(C0572b c0572b) {
        this.f1369r = c0572b;
    }

    public void setOnQueryTextFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.f1370s = onFocusChangeListener;
    }

    public void setOnSuggestionListener(C0574d c0574d) {
        this.f1371t = c0574d;
    }

    public void setOnSearchClickListener(OnClickListener onClickListener) {
        this.f1372u = onClickListener;
    }

    public CharSequence getQuery() {
        return this.f1354c.getText();
    }

    public void m2740a(CharSequence charSequence, boolean z) {
        this.f1354c.setText(charSequence);
        if (charSequence != null) {
            this.f1354c.setSelection(this.f1354c.length());
            this.f1345E = charSequence;
        }
        if (z && !TextUtils.isEmpty(charSequence)) {
            m2733m();
        }
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f1377z = charSequence;
        m2731k();
    }

    public CharSequence getQueryHint() {
        if (this.f1377z != null) {
            return this.f1377z;
        }
        if (!f1340b || this.f1348H == null || this.f1348H.getHintId() == 0) {
            return this.f1367p;
        }
        return getContext().getText(this.f1348H.getHintId());
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.f1373v != z) {
            this.f1373v = z;
            m2721a(z);
            m2731k();
        }
    }

    public void setIconified(boolean z) {
        if (z) {
            m2735o();
        } else {
            m2736p();
        }
    }

    public boolean m2742c() {
        return this.f1374w;
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.f1376y = z;
        m2721a(m2742c());
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.f1341A = z;
        if (this.f1375x instanceof al) {
            ((al) this.f1375x).m2925a(z ? 2 : 1);
        }
    }

    public void setSuggestionsAdapter(C0388f c0388f) {
        this.f1375x = c0388f;
        this.f1354c.setAdapter(this.f1375x);
    }

    public C0388f getSuggestionsAdapter() {
        return this.f1375x;
    }

    public void setMaxWidth(int i) {
        this.f1343C = i;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.f1343C;
    }

    protected void onMeasure(int i, int i2) {
        if (m2742c()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                if (this.f1343C <= 0) {
                    size = Math.min(getPreferredWidth(), size);
                    break;
                } else {
                    size = Math.min(this.f1343C, size);
                    break;
                }
            case 0:
                if (this.f1343C <= 0) {
                    size = getPreferredWidth();
                    break;
                } else {
                    size = this.f1343C;
                    break;
                }
            case 1073741824:
                if (this.f1343C > 0) {
                    size = Math.min(this.f1343C, size);
                    break;
                }
                break;
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(C0501d.abc_search_view_preferred_width);
    }

    private void m2721a(boolean z) {
        boolean z2;
        boolean z3 = true;
        int i = 8;
        this.f1374w = z;
        int i2 = z ? 0 : 8;
        if (TextUtils.isEmpty(this.f1354c.getText())) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.f1357f.setVisibility(i2);
        m2724b(z2);
        View view = this.f1355d;
        if (z) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        view.setVisibility(i2);
        if (!(this.f1361j.getDrawable() == null || this.f1373v)) {
            i = 0;
        }
        this.f1361j.setVisibility(i);
        m2729h();
        if (z2) {
            z3 = false;
        }
        m2725c(z3);
        m2728g();
    }

    @TargetApi(8)
    private boolean m2726e() {
        if (this.f1348H == null || !this.f1348H.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.f1348H.getVoiceSearchLaunchWebSearch()) {
            intent = this.f1365n;
        } else if (this.f1348H.getVoiceSearchLaunchRecognizer()) {
            intent = this.f1366o;
        }
        if (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) {
            return false;
        }
        return true;
    }

    private boolean m2727f() {
        return (this.f1376y || this.f1344D) && !m2742c();
    }

    private void m2724b(boolean z) {
        int i = 8;
        if (this.f1376y && m2727f() && hasFocus() && (z || !this.f1344D)) {
            i = 0;
        }
        this.f1358g.setVisibility(i);
    }

    private void m2728g() {
        int i = 8;
        if (m2727f() && (this.f1358g.getVisibility() == 0 || this.f1360i.getVisibility() == 0)) {
            i = 0;
        }
        this.f1356e.setVisibility(i);
    }

    private void m2729h() {
        int i = 1;
        int i2 = 0;
        int i3 = !TextUtils.isEmpty(this.f1354c.getText()) ? 1 : 0;
        if (i3 == 0 && (!this.f1373v || this.f1346F)) {
            i = 0;
        }
        ImageView imageView = this.f1359h;
        if (i == 0) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Drawable drawable = this.f1359h.getDrawable();
        if (drawable != null) {
            drawable.setState(i3 != 0 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void m2730i() {
        post(this.f1351K);
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.f1351K);
        post(this.f1352L);
        super.onDetachedFromWindow();
    }

    private void setImeVisibility(boolean z) {
        if (z) {
            post(this.f1350J);
            return;
        }
        removeCallbacks(this.f1350J);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    void m2739a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    private CharSequence m2723b(CharSequence charSequence) {
        if (!this.f1373v || this.f1362k == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.f1354c.getTextSize()) * 1.25d);
        this.f1362k.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f1362k), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private void m2731k() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f1354c;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(m2723b(queryHint));
    }

    @TargetApi(8)
    private void m2732l() {
        int i = 1;
        this.f1354c.setThreshold(this.f1348H.getSuggestThreshold());
        this.f1354c.setImeOptions(this.f1348H.getImeOptions());
        int inputType = this.f1348H.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f1348H.getSuggestAuthority() != null) {
                inputType = (inputType | 65536) | 524288;
            }
        }
        this.f1354c.setInputType(inputType);
        if (this.f1375x != null) {
            this.f1375x.mo309a(null);
        }
        if (this.f1348H.getSuggestAuthority() != null) {
            this.f1375x = new al(getContext(), this, this.f1348H, this.f1353M);
            this.f1354c.setAdapter(this.f1375x);
            al alVar = (al) this.f1375x;
            if (this.f1341A) {
                i = 2;
            }
            alVar.m2925a(i);
        }
    }

    private void m2725c(boolean z) {
        int i;
        if (this.f1344D && !m2742c() && z) {
            i = 0;
            this.f1358g.setVisibility(8);
        } else {
            i = 8;
        }
        this.f1360i.setVisibility(i);
    }

    private void m2733m() {
        CharSequence text = this.f1354c.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.f1368q == null || !this.f1368q.m2717a(text.toString())) {
                if (this.f1348H != null) {
                    m2719a(0, null, text.toString());
                }
                setImeVisibility(false);
                m2734n();
            }
        }
    }

    private void m2734n() {
        this.f1354c.dismissDropDown();
    }

    private void m2735o() {
        if (!TextUtils.isEmpty(this.f1354c.getText())) {
            this.f1354c.setText("");
            this.f1354c.requestFocus();
            setImeVisibility(true);
        } else if (!this.f1373v) {
        } else {
            if (this.f1369r == null || !this.f1369r.m2716a()) {
                clearFocus();
                m2721a(true);
            }
        }
    }

    private void m2736p() {
        m2721a(false);
        this.f1354c.requestFocus();
        setImeVisibility(true);
        if (this.f1372u != null) {
            this.f1372u.onClick(this);
        }
    }

    void m2743d() {
        m2721a(m2742c());
        m2730i();
        if (this.f1354c.hasFocus()) {
            m2737q();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m2730i();
    }

    public void mo483b() {
        m2740a((CharSequence) "", false);
        clearFocus();
        m2721a(true);
        this.f1354c.setImeOptions(this.f1347G);
        this.f1346F = false;
    }

    public void mo482a() {
        if (!this.f1346F) {
            this.f1346F = true;
            this.f1347G = this.f1354c.getImeOptions();
            this.f1354c.setImeOptions(this.f1347G | 33554432);
            this.f1354c.setText("");
            setIconified(false);
        }
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1328a = m2742c();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            m2721a(savedState.f1328a);
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private void setQuery(CharSequence charSequence) {
        this.f1354c.setText(charSequence);
        this.f1354c.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    private void m2719a(int i, String str, String str2) {
        getContext().startActivity(m2718a("android.intent.action.SEARCH", null, null, str2, i, str));
    }

    private Intent m2718a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f1345E);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.f1349I != null) {
            intent.putExtra("app_data", this.f1349I);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        if (f1340b) {
            intent.setComponent(this.f1348H.getSearchActivity());
        }
        return intent;
    }

    private void m2737q() {
        f1339a.m2713a(this.f1354c);
        f1339a.m2715b(this.f1354c);
    }

    static boolean m2722a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }
}
