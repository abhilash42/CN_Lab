package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.p002b.p003a.C0150a;
import android.support.v7.p014c.p015a.C0510a;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

/* compiled from: ListViewCompat */
public class ah extends ListView {
    private static final int[] f1440g = new int[]{0};
    final Rect f1441a = new Rect();
    int f1442b = 0;
    int f1443c = 0;
    int f1444d = 0;
    int f1445e = 0;
    protected int f1446f;
    private Field f1447h;
    private C0595a f1448i;

    /* compiled from: ListViewCompat */
    private static class C0595a extends C0510a {
        private boolean f1493a = true;

        public C0595a(Drawable drawable) {
            super(drawable);
        }

        void m2887a(boolean z) {
            this.f1493a = z;
        }

        public boolean setState(int[] iArr) {
            if (this.f1493a) {
                return super.setState(iArr);
            }
            return false;
        }

        public void draw(Canvas canvas) {
            if (this.f1493a) {
                super.draw(canvas);
            }
        }

        public void setHotspot(float f, float f2) {
            if (this.f1493a) {
                super.setHotspot(f, f2);
            }
        }

        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.f1493a) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        public boolean setVisible(boolean z, boolean z2) {
            if (this.f1493a) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    public ah(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        try {
            this.f1447h = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f1447h.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void setSelector(Drawable drawable) {
        this.f1448i = drawable != null ? new C0595a(drawable) : null;
        super.setSelector(this.f1448i);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f1442b = rect.left;
        this.f1443c = rect.top;
        this.f1444d = rect.right;
        this.f1445e = rect.bottom;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        setSelectorEnabled(true);
        m2845b();
    }

    protected void dispatchDraw(Canvas canvas) {
        m2843a(canvas);
        super.dispatchDraw(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f1446f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void m2845b() {
        Drawable selector = getSelector();
        if (selector != null && m2847c()) {
            selector.setState(getDrawableState());
        }
    }

    protected boolean m2847c() {
        return mo530a() && isPressed();
    }

    protected boolean mo530a() {
        return false;
    }

    protected void m2843a(Canvas canvas) {
        if (!this.f1441a.isEmpty()) {
            Drawable selector = getSelector();
            if (selector != null) {
                selector.setBounds(this.f1441a);
                selector.draw(canvas);
            }
        }
    }

    protected void m2842a(int i, View view, float f, float f2) {
        m2841a(i, view);
        Drawable selector = getSelector();
        if (selector != null && i != -1) {
            C0150a.m656a(selector, f, f2);
        }
    }

    protected void m2841a(int i, View view) {
        boolean z = true;
        Drawable selector = getSelector();
        boolean z2 = (selector == null || i == -1) ? false : true;
        if (z2) {
            selector.setVisible(false, false);
        }
        m2846b(i, view);
        if (z2) {
            Rect rect = this.f1441a;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z = false;
            }
            selector.setVisible(z, false);
            C0150a.m656a(selector, exactCenterX, exactCenterY);
        }
    }

    protected void m2846b(int i, View view) {
        Rect rect = this.f1441a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f1442b;
        rect.top -= this.f1443c;
        rect.right += this.f1444d;
        rect.bottom += this.f1445e;
        try {
            boolean z = this.f1447h.getBoolean(this);
            if (view.isEnabled() != z) {
                this.f1447h.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public int m2840a(int i, int i2, int i3, int i4, int i5) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        listPaddingBottom += listPaddingTop;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int i6 = 0;
        View view = null;
        int i7 = 0;
        int count = adapter.getCount();
        int i8 = 0;
        while (i8 < count) {
            View view2;
            listPaddingTop = adapter.getItemViewType(i8);
            if (listPaddingTop != i7) {
                int i9 = listPaddingTop;
                view2 = null;
                i7 = i9;
            } else {
                view2 = view;
            }
            view = adapter.getView(i8, view2, this);
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            if (layoutParams.height > 0) {
                listPaddingTop = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            } else {
                listPaddingTop = MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i, listPaddingTop);
            view.forceLayout();
            if (i8 > 0) {
                listPaddingTop = listPaddingBottom + dividerHeight;
            } else {
                listPaddingTop = listPaddingBottom;
            }
            listPaddingTop += view.getMeasuredHeight();
            if (listPaddingTop < i4) {
                if (i5 >= 0 && i8 >= i5) {
                    i6 = listPaddingTop;
                }
                i8++;
                listPaddingBottom = listPaddingTop;
            } else if (i5 < 0 || i8 <= i5 || i6 <= 0 || listPaddingTop == i4) {
                return i4;
            } else {
                return i6;
            }
        }
        return listPaddingBottom;
    }

    protected void setSelectorEnabled(boolean z) {
        if (this.f1448i != null) {
            this.f1448i.m2887a(z);
        }
    }
}
