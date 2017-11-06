package android.support.v7.p012a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ag;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.NestedScrollView.C0371b;
import android.support.v7.p013b.C0509a.C0498a;
import android.support.v7.p013b.C0509a.C0503f;
import android.support.v7.p013b.C0509a.C0508k;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* compiled from: AlertController */
class C0449c {
    private TextView f759A;
    private TextView f760B;
    private View f761C;
    private ListAdapter f762D;
    private int f763E = -1;
    private int f764F;
    private int f765G;
    private int f766H;
    private int f767I;
    private int f768J;
    private int f769K;
    private int f770L = 0;
    private Handler f771M;
    private final OnClickListener f772N = new C04361(this);
    private final Context f773a;
    private final C0451m f774b;
    private final Window f775c;
    private CharSequence f776d;
    private CharSequence f777e;
    private ListView f778f;
    private View f779g;
    private int f780h;
    private int f781i;
    private int f782j;
    private int f783k;
    private int f784l;
    private boolean f785m = false;
    private Button f786n;
    private CharSequence f787o;
    private Message f788p;
    private Button f789q;
    private CharSequence f790r;
    private Message f791s;
    private Button f792t;
    private CharSequence f793u;
    private Message f794v;
    private NestedScrollView f795w;
    private int f796x = 0;
    private Drawable f797y;
    private ImageView f798z;

    /* compiled from: AlertController */
    class C04361 implements OnClickListener {
        final /* synthetic */ C0449c f694a;

        C04361(C0449c c0449c) {
            this.f694a = c0449c;
        }

        public void onClick(View view) {
            Message obtain;
            if (view == this.f694a.f786n && this.f694a.f788p != null) {
                obtain = Message.obtain(this.f694a.f788p);
            } else if (view == this.f694a.f789q && this.f694a.f791s != null) {
                obtain = Message.obtain(this.f694a.f791s);
            } else if (view != this.f694a.f792t || this.f694a.f794v == null) {
                obtain = null;
            } else {
                obtain = Message.obtain(this.f694a.f794v);
            }
            if (obtain != null) {
                obtain.sendToTarget();
            }
            this.f694a.f771M.obtainMessage(1, this.f694a.f774b).sendToTarget();
        }
    }

    /* compiled from: AlertController */
    public static class C0446a {
        public int f719A;
        public boolean f720B = false;
        public boolean[] f721C;
        public boolean f722D;
        public boolean f723E;
        public int f724F = -1;
        public OnMultiChoiceClickListener f725G;
        public Cursor f726H;
        public String f727I;
        public String f728J;
        public OnItemSelectedListener f729K;
        public C0445a f730L;
        public boolean f731M = true;
        public final Context f732a;
        public final LayoutInflater f733b;
        public int f734c = 0;
        public Drawable f735d;
        public int f736e = 0;
        public CharSequence f737f;
        public View f738g;
        public CharSequence f739h;
        public CharSequence f740i;
        public DialogInterface.OnClickListener f741j;
        public CharSequence f742k;
        public DialogInterface.OnClickListener f743l;
        public CharSequence f744m;
        public DialogInterface.OnClickListener f745n;
        public boolean f746o;
        public OnCancelListener f747p;
        public OnDismissListener f748q;
        public OnKeyListener f749r;
        public CharSequence[] f750s;
        public ListAdapter f751t;
        public DialogInterface.OnClickListener f752u;
        public int f753v;
        public View f754w;
        public int f755x;
        public int f756y;
        public int f757z;

        /* compiled from: AlertController */
        public interface C0445a {
            void m1945a(ListView listView);
        }

        public C0446a(Context context) {
            this.f732a = context;
            this.f746o = true;
            this.f733b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public void m1947a(C0449c c0449c) {
            if (this.f738g != null) {
                c0449c.m1984b(this.f738g);
            } else {
                if (this.f737f != null) {
                    c0449c.m1981a(this.f737f);
                }
                if (this.f735d != null) {
                    c0449c.m1979a(this.f735d);
                }
                if (this.f734c != 0) {
                    c0449c.m1983b(this.f734c);
                }
                if (this.f736e != 0) {
                    c0449c.m1983b(c0449c.m1987c(this.f736e));
                }
            }
            if (this.f739h != null) {
                c0449c.m1985b(this.f739h);
            }
            if (this.f740i != null) {
                c0449c.m1978a(-1, this.f740i, this.f741j, null);
            }
            if (this.f742k != null) {
                c0449c.m1978a(-2, this.f742k, this.f743l, null);
            }
            if (this.f744m != null) {
                c0449c.m1978a(-3, this.f744m, this.f745n, null);
            }
            if (!(this.f750s == null && this.f726H == null && this.f751t == null)) {
                m1946b(c0449c);
            }
            if (this.f754w != null) {
                if (this.f720B) {
                    c0449c.m1980a(this.f754w, this.f755x, this.f756y, this.f757z, this.f719A);
                    return;
                }
                c0449c.m1988c(this.f754w);
            } else if (this.f753v != 0) {
                c0449c.m1977a(this.f753v);
            }
        }

        private void m1946b(final C0449c c0449c) {
            ListAdapter simpleCursorAdapter;
            final ListView listView = (ListView) this.f733b.inflate(c0449c.f766H, null);
            if (!this.f722D) {
                int m;
                if (this.f723E) {
                    m = c0449c.f768J;
                } else {
                    m = c0449c.f769K;
                }
                if (this.f726H != null) {
                    simpleCursorAdapter = new SimpleCursorAdapter(this.f732a, m, this.f726H, new String[]{this.f727I}, new int[]{16908308});
                } else if (this.f751t != null) {
                    simpleCursorAdapter = this.f751t;
                } else {
                    simpleCursorAdapter = new C0448c(this.f732a, m, 16908308, this.f750s);
                }
            } else if (this.f726H == null) {
                simpleCursorAdapter = new ArrayAdapter<CharSequence>(this, this.f732a, c0449c.f767I, 16908308, this.f750s) {
                    final /* synthetic */ C0446a f708b;

                    public View getView(int i, View view, ViewGroup viewGroup) {
                        View view2 = super.getView(i, view, viewGroup);
                        if (this.f708b.f721C != null && this.f708b.f721C[i]) {
                            listView.setItemChecked(i, true);
                        }
                        return view2;
                    }
                };
            } else {
                final C0449c c0449c2 = c0449c;
                Object c04422 = new CursorAdapter(this, this.f732a, this.f726H, false) {
                    final /* synthetic */ C0446a f711c;
                    private final int f712d;
                    private final int f713e;

                    public void bindView(View view, Context context, Cursor cursor) {
                        ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f712d));
                        listView.setItemChecked(cursor.getPosition(), cursor.getInt(this.f713e) == 1);
                    }

                    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                        return this.f711c.f733b.inflate(c0449c2.f767I, viewGroup, false);
                    }
                };
            }
            if (this.f730L != null) {
                this.f730L.m1945a(listView);
            }
            c0449c.f762D = simpleCursorAdapter;
            c0449c.f763E = this.f724F;
            if (this.f752u != null) {
                listView.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ C0446a f715b;

                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        this.f715b.f752u.onClick(c0449c.f774b, i);
                        if (!this.f715b.f723E) {
                            c0449c.f774b.dismiss();
                        }
                    }
                });
            } else if (this.f725G != null) {
                listView.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ C0446a f718c;

                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        if (this.f718c.f721C != null) {
                            this.f718c.f721C[i] = listView.isItemChecked(i);
                        }
                        this.f718c.f725G.onClick(c0449c.f774b, i, listView.isItemChecked(i));
                    }
                });
            }
            if (this.f729K != null) {
                listView.setOnItemSelectedListener(this.f729K);
            }
            if (this.f723E) {
                listView.setChoiceMode(1);
            } else if (this.f722D) {
                listView.setChoiceMode(2);
            }
            c0449c.f778f = listView;
        }
    }

    /* compiled from: AlertController */
    private static final class C0447b extends Handler {
        private WeakReference<DialogInterface> f758a;

        public C0447b(DialogInterface dialogInterface) {
            this.f758a = new WeakReference(dialogInterface);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case -3:
                case -2:
                case -1:
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f758a.get(), message.what);
                    return;
                case 1:
                    ((DialogInterface) message.obj).dismiss();
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: AlertController */
    private static class C0448c extends ArrayAdapter<CharSequence> {
        public C0448c(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        public boolean hasStableIds() {
            return true;
        }

        public long getItemId(int i) {
            return (long) i;
        }
    }

    public C0449c(Context context, C0451m c0451m, Window window) {
        this.f773a = context;
        this.f774b = c0451m;
        this.f775c = window;
        this.f771M = new C0447b(c0451m);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, C0508k.AlertDialog, C0498a.alertDialogStyle, 0);
        this.f764F = obtainStyledAttributes.getResourceId(C0508k.AlertDialog_android_layout, 0);
        this.f765G = obtainStyledAttributes.getResourceId(C0508k.AlertDialog_buttonPanelSideLayout, 0);
        this.f766H = obtainStyledAttributes.getResourceId(C0508k.AlertDialog_listLayout, 0);
        this.f767I = obtainStyledAttributes.getResourceId(C0508k.AlertDialog_multiChoiceItemLayout, 0);
        this.f768J = obtainStyledAttributes.getResourceId(C0508k.AlertDialog_singleChoiceItemLayout, 0);
        this.f769K = obtainStyledAttributes.getResourceId(C0508k.AlertDialog_listItemLayout, 0);
        obtainStyledAttributes.recycle();
        c0451m.m2000a(1);
    }

    static boolean m1956a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (C0449c.m1956a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public void m1976a() {
        this.f774b.setContentView(m1957b());
        m1962c();
    }

    private int m1957b() {
        if (this.f765G == 0) {
            return this.f764F;
        }
        if (this.f770L == 1) {
            return this.f765G;
        }
        return this.f764F;
    }

    public void m1981a(CharSequence charSequence) {
        this.f776d = charSequence;
        if (this.f759A != null) {
            this.f759A.setText(charSequence);
        }
    }

    public void m1984b(View view) {
        this.f761C = view;
    }

    public void m1985b(CharSequence charSequence) {
        this.f777e = charSequence;
        if (this.f760B != null) {
            this.f760B.setText(charSequence);
        }
    }

    public void m1977a(int i) {
        this.f779g = null;
        this.f780h = i;
        this.f785m = false;
    }

    public void m1988c(View view) {
        this.f779g = view;
        this.f780h = 0;
        this.f785m = false;
    }

    public void m1980a(View view, int i, int i2, int i3, int i4) {
        this.f779g = view;
        this.f780h = 0;
        this.f785m = true;
        this.f781i = i;
        this.f782j = i2;
        this.f783k = i3;
        this.f784l = i4;
    }

    public void m1978a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        if (message == null && onClickListener != null) {
            message = this.f771M.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.f793u = charSequence;
                this.f794v = message;
                return;
            case -2:
                this.f790r = charSequence;
                this.f791s = message;
                return;
            case -1:
                this.f787o = charSequence;
                this.f788p = message;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void m1983b(int i) {
        this.f797y = null;
        this.f796x = i;
        if (this.f798z == null) {
            return;
        }
        if (i != 0) {
            this.f798z.setVisibility(0);
            this.f798z.setImageResource(this.f796x);
            return;
        }
        this.f798z.setVisibility(8);
    }

    public void m1979a(Drawable drawable) {
        this.f797y = drawable;
        this.f796x = 0;
        if (this.f798z == null) {
            return;
        }
        if (drawable != null) {
            this.f798z.setVisibility(0);
            this.f798z.setImageDrawable(drawable);
            return;
        }
        this.f798z.setVisibility(8);
    }

    public int m1987c(int i) {
        TypedValue typedValue = new TypedValue();
        this.f773a.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public boolean m1982a(int i, KeyEvent keyEvent) {
        return this.f795w != null && this.f795w.m1671a(keyEvent);
    }

    public boolean m1986b(int i, KeyEvent keyEvent) {
        return this.f795w != null && this.f795w.m1671a(keyEvent);
    }

    private ViewGroup m1949a(View view, View view2) {
        View inflate;
        if (view == null) {
            if (view2 instanceof ViewStub) {
                inflate = ((ViewStub) view2).inflate();
            } else {
                inflate = view2;
            }
            return (ViewGroup) inflate;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            inflate = ((ViewStub) view).inflate();
        } else {
            inflate = view;
        }
        return (ViewGroup) inflate;
    }

    private void m1962c() {
        boolean z;
        boolean z2;
        View findViewById = this.f775c.findViewById(C0503f.parentPanel);
        View findViewById2 = findViewById.findViewById(C0503f.topPanel);
        View findViewById3 = findViewById.findViewById(C0503f.contentPanel);
        View findViewById4 = findViewById.findViewById(C0503f.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(C0503f.customPanel);
        m1954a(viewGroup);
        View findViewById5 = viewGroup.findViewById(C0503f.topPanel);
        View findViewById6 = viewGroup.findViewById(C0503f.contentPanel);
        View findViewById7 = viewGroup.findViewById(C0503f.buttonPanel);
        ViewGroup a = m1949a(findViewById5, findViewById2);
        ViewGroup a2 = m1949a(findViewById6, findViewById3);
        ViewGroup a3 = m1949a(findViewById7, findViewById4);
        m1963c(a2);
        m1965d(a3);
        m1960b(a);
        boolean z3 = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        if (a == null || a.getVisibility() == 8) {
            z = false;
        } else {
            z = true;
        }
        if (a3 == null || a3.getVisibility() == 8) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!(z2 || a2 == null)) {
            findViewById3 = a2.findViewById(C0503f.textSpacerNoButtons);
            if (findViewById3 != null) {
                findViewById3.setVisibility(0);
            }
        }
        if (z && this.f795w != null) {
            this.f795w.setClipToPadding(true);
        }
        if (!z3) {
            findViewById3 = this.f778f != null ? this.f778f : this.f795w;
            if (findViewById3 != null) {
                int i;
                if (z) {
                    i = 1;
                } else {
                    i = 0;
                }
                m1955a(a2, findViewById3, (z2 ? 2 : 0) | i, 3);
            }
        }
        ListView listView = this.f778f;
        if (listView != null && this.f762D != null) {
            listView.setAdapter(this.f762D);
            int i2 = this.f763E;
            if (i2 > -1) {
                listView.setItemChecked(i2, true);
                listView.setSelection(i2);
            }
        }
    }

    private void m1955a(ViewGroup viewGroup, View view, int i, int i2) {
        View view2 = null;
        View findViewById = this.f775c.findViewById(C0503f.scrollIndicatorUp);
        View findViewById2 = this.f775c.findViewById(C0503f.scrollIndicatorDown);
        if (VERSION.SDK_INT >= 23) {
            ag.m1262a(view, i, i2);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 == null || (i & 2) != 0) {
            view2 = findViewById2;
        } else {
            viewGroup.removeView(findViewById2);
        }
        if (findViewById != null || view2 != null) {
            if (this.f777e != null) {
                this.f795w.setOnScrollChangeListener(new C0371b(this) {
                    final /* synthetic */ C0449c f697c;

                    public void mo354a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                        C0449c.m1959b(nestedScrollView, findViewById, view2);
                    }
                });
                this.f795w.post(new Runnable(this) {
                    final /* synthetic */ C0449c f700c;

                    public void run() {
                        C0449c.m1959b(this.f700c.f795w, findViewById, view2);
                    }
                });
            } else if (this.f778f != null) {
                this.f778f.setOnScrollListener(new OnScrollListener(this) {
                    final /* synthetic */ C0449c f703c;

                    public void onScrollStateChanged(AbsListView absListView, int i) {
                    }

                    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                        C0449c.m1959b(absListView, findViewById, view2);
                    }
                });
                this.f778f.post(new Runnable(this) {
                    final /* synthetic */ C0449c f706c;

                    public void run() {
                        C0449c.m1959b(this.f706c.f778f, findViewById, view2);
                    }
                });
            } else {
                if (findViewById != null) {
                    viewGroup.removeView(findViewById);
                }
                if (view2 != null) {
                    viewGroup.removeView(view2);
                }
            }
        }
    }

    private void m1954a(ViewGroup viewGroup) {
        View view;
        boolean z = false;
        if (this.f779g != null) {
            view = this.f779g;
        } else if (this.f780h != 0) {
            view = LayoutInflater.from(this.f773a).inflate(this.f780h, viewGroup, false);
        } else {
            view = null;
        }
        if (view != null) {
            z = true;
        }
        if (!(z && C0449c.m1956a(view))) {
            this.f775c.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.f775c.findViewById(C0503f.custom);
            frameLayout.addView(view, new LayoutParams(-1, -1));
            if (this.f785m) {
                frameLayout.setPadding(this.f781i, this.f782j, this.f783k, this.f784l);
            }
            if (this.f778f != null) {
                ((LinearLayout.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void m1960b(ViewGroup viewGroup) {
        if (this.f761C != null) {
            viewGroup.addView(this.f761C, 0, new LayoutParams(-1, -2));
            this.f775c.findViewById(C0503f.title_template).setVisibility(8);
            return;
        }
        this.f798z = (ImageView) this.f775c.findViewById(16908294);
        if ((!TextUtils.isEmpty(this.f776d) ? 1 : 0) != 0) {
            this.f759A = (TextView) this.f775c.findViewById(C0503f.alertTitle);
            this.f759A.setText(this.f776d);
            if (this.f796x != 0) {
                this.f798z.setImageResource(this.f796x);
                return;
            } else if (this.f797y != null) {
                this.f798z.setImageDrawable(this.f797y);
                return;
            } else {
                this.f759A.setPadding(this.f798z.getPaddingLeft(), this.f798z.getPaddingTop(), this.f798z.getPaddingRight(), this.f798z.getPaddingBottom());
                this.f798z.setVisibility(8);
                return;
            }
        }
        this.f775c.findViewById(C0503f.title_template).setVisibility(8);
        this.f798z.setVisibility(8);
        viewGroup.setVisibility(8);
    }

    private void m1963c(ViewGroup viewGroup) {
        this.f795w = (NestedScrollView) this.f775c.findViewById(C0503f.scrollView);
        this.f795w.setFocusable(false);
        this.f795w.setNestedScrollingEnabled(false);
        this.f760B = (TextView) viewGroup.findViewById(16908299);
        if (this.f760B != null) {
            if (this.f777e != null) {
                this.f760B.setText(this.f777e);
                return;
            }
            this.f760B.setVisibility(8);
            this.f795w.removeView(this.f760B);
            if (this.f778f != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.f795w.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.f795w);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.f778f, indexOfChild, new LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    private static void m1959b(View view, View view2, View view3) {
        int i = 0;
        if (view2 != null) {
            view2.setVisibility(ag.m1277b(view, -1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!ag.m1277b(view, 1)) {
                i = 4;
            }
            view3.setVisibility(i);
        }
    }

    private void m1965d(ViewGroup viewGroup) {
        int i;
        int i2 = 1;
        this.f786n = (Button) viewGroup.findViewById(16908313);
        this.f786n.setOnClickListener(this.f772N);
        if (TextUtils.isEmpty(this.f787o)) {
            this.f786n.setVisibility(8);
            i = 0;
        } else {
            this.f786n.setText(this.f787o);
            this.f786n.setVisibility(0);
            i = 1;
        }
        this.f789q = (Button) viewGroup.findViewById(16908314);
        this.f789q.setOnClickListener(this.f772N);
        if (TextUtils.isEmpty(this.f790r)) {
            this.f789q.setVisibility(8);
        } else {
            this.f789q.setText(this.f790r);
            this.f789q.setVisibility(0);
            i |= 2;
        }
        this.f792t = (Button) viewGroup.findViewById(16908315);
        this.f792t.setOnClickListener(this.f772N);
        if (TextUtils.isEmpty(this.f793u)) {
            this.f792t.setVisibility(8);
        } else {
            this.f792t.setText(this.f793u);
            this.f792t.setVisibility(0);
            i |= 4;
        }
        if (i == 0) {
            i2 = 0;
        }
        if (i2 == 0) {
            viewGroup.setVisibility(8);
        }
    }
}
