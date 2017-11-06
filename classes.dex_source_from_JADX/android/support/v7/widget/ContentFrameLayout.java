package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.ag;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class ContentFrameLayout extends FrameLayout {
    private TypedValue f864a;
    private TypedValue f865b;
    private TypedValue f866c;
    private TypedValue f867d;
    private TypedValue f868e;
    private TypedValue f869f;
    private final Rect f870g;
    private C0468a f871h;

    public interface C0468a {
        void mo399a();

        void mo400b();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f870g = new Rect();
    }

    public void m2156a(Rect rect) {
        fitSystemWindows(rect);
    }

    public void setAttachListener(C0468a c0468a) {
        this.f871h = c0468a;
    }

    public void m2155a(int i, int i2, int i3, int i4) {
        this.f870g.set(i, i2, i3, i4);
        if (ag.m1299u(this)) {
            requestLayout();
        }
    }

    protected void onMeasure(int i, int i2) {
        TypedValue typedValue;
        int dimension;
        Object obj;
        TypedValue typedValue2;
        int dimension2;
        Object obj2 = null;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        Object obj3 = displayMetrics.widthPixels < displayMetrics.heightPixels ? 1 : null;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            typedValue = obj3 != null ? this.f867d : this.f866c;
            if (!(typedValue == null || typedValue.type == 0)) {
                if (typedValue.type == 5) {
                    dimension = (int) typedValue.getDimension(displayMetrics);
                } else if (typedValue.type == 6) {
                    dimension = (int) typedValue.getFraction((float) displayMetrics.widthPixels, (float) displayMetrics.widthPixels);
                } else {
                    dimension = 0;
                }
                if (dimension > 0) {
                    i = MeasureSpec.makeMeasureSpec(Math.min(dimension - (this.f870g.left + this.f870g.right), MeasureSpec.getSize(i)), 1073741824);
                    obj = 1;
                    if (mode2 == Integer.MIN_VALUE) {
                        typedValue = obj3 == null ? this.f868e : this.f869f;
                        if (!(typedValue == null || typedValue.type == 0)) {
                            if (typedValue.type == 5) {
                                dimension = (int) typedValue.getDimension(displayMetrics);
                            } else if (typedValue.type != 6) {
                                dimension = (int) typedValue.getFraction((float) displayMetrics.heightPixels, (float) displayMetrics.heightPixels);
                            } else {
                                dimension = 0;
                            }
                            if (dimension > 0) {
                                i2 = MeasureSpec.makeMeasureSpec(Math.min(dimension - (this.f870g.top + this.f870g.bottom), MeasureSpec.getSize(i2)), 1073741824);
                            }
                        }
                    }
                    super.onMeasure(i, i2);
                    mode2 = getMeasuredWidth();
                    dimension = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
                    if (obj == null && mode == Integer.MIN_VALUE) {
                        typedValue2 = obj3 == null ? this.f865b : this.f864a;
                        if (!(typedValue2 == null || typedValue2.type == 0)) {
                            dimension2 = typedValue2.type != 5 ? (int) typedValue2.getDimension(displayMetrics) : typedValue2.type != 6 ? (int) typedValue2.getFraction((float) displayMetrics.widthPixels, (float) displayMetrics.widthPixels) : 0;
                            if (dimension2 > 0) {
                                dimension2 -= this.f870g.left + this.f870g.right;
                            }
                            if (mode2 < dimension2) {
                                dimension2 = MeasureSpec.makeMeasureSpec(dimension2, 1073741824);
                                obj2 = 1;
                                if (obj2 == null) {
                                    super.onMeasure(dimension2, i2);
                                }
                            }
                        }
                    }
                    dimension2 = dimension;
                    if (obj2 == null) {
                        super.onMeasure(dimension2, i2);
                    }
                }
            }
        }
        obj = null;
        if (mode2 == Integer.MIN_VALUE) {
            if (obj3 == null) {
            }
            if (typedValue.type == 5) {
                dimension = (int) typedValue.getDimension(displayMetrics);
            } else if (typedValue.type != 6) {
                dimension = 0;
            } else {
                dimension = (int) typedValue.getFraction((float) displayMetrics.heightPixels, (float) displayMetrics.heightPixels);
            }
            if (dimension > 0) {
                i2 = MeasureSpec.makeMeasureSpec(Math.min(dimension - (this.f870g.top + this.f870g.bottom), MeasureSpec.getSize(i2)), 1073741824);
            }
        }
        super.onMeasure(i, i2);
        mode2 = getMeasuredWidth();
        dimension = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
        if (obj3 == null) {
        }
        if (typedValue2.type != 5) {
            if (typedValue2.type != 6) {
            }
        }
        if (dimension2 > 0) {
            dimension2 -= this.f870g.left + this.f870g.right;
        }
        if (mode2 < dimension2) {
            dimension2 = MeasureSpec.makeMeasureSpec(dimension2, 1073741824);
            obj2 = 1;
            if (obj2 == null) {
                super.onMeasure(dimension2, i2);
            }
        }
        dimension2 = dimension;
        if (obj2 == null) {
            super.onMeasure(dimension2, i2);
        }
    }

    public TypedValue getMinWidthMajor() {
        if (this.f864a == null) {
            this.f864a = new TypedValue();
        }
        return this.f864a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f865b == null) {
            this.f865b = new TypedValue();
        }
        return this.f865b;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f866c == null) {
            this.f866c = new TypedValue();
        }
        return this.f866c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f867d == null) {
            this.f867d = new TypedValue();
        }
        return this.f867d;
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f868e == null) {
            this.f868e = new TypedValue();
        }
        return this.f868e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f869f == null) {
            this.f869f = new TypedValue();
        }
        return this.f869f;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f871h != null) {
            this.f871h.mo399a();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f871h != null) {
            this.f871h.mo400b();
        }
    }
}
