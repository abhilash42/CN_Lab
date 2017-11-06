package in.org.npci.upiapp.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.C0610p;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import in.org.npci.upiapp.C1427f.C1426a;
import java.math.BigDecimal;

/* compiled from: CustomRangeSeekBar */
public class C1440c<T extends Number> extends C0610p {
    public static final Integer f3577a = Integer.valueOf(0);
    public static final Integer f3578b = Integer.valueOf(100);
    public static final int f3579c = Color.parseColor("#1B3281");
    private boolean f3580A;
    private int f3581B;
    private int f3582C;
    private int f3583D;
    private RectF f3584E;
    private boolean f3585F;
    private final int f3586d = 3;
    private final Paint f3587e = new Paint(1);
    private final Bitmap f3588f = BitmapFactory.decodeResource(getResources(), 2130837586);
    private final Bitmap f3589g = BitmapFactory.decodeResource(getResources(), 2130837586);
    private final Bitmap f3590h = BitmapFactory.decodeResource(getResources(), 2130837586);
    private final float f3591i = ((float) this.f3588f.getWidth());
    private final float f3592j = (this.f3591i * 0.5f);
    private final float f3593k = (((float) this.f3588f.getHeight()) * 0.5f);
    private float f3594l;
    private float f3595m;
    private T f3596n;
    private T f3597o;
    private C1438a f3598p;
    private double f3599q;
    private double f3600r;
    private double f3601s = 0.0d;
    private double f3602t = 1.0d;
    private C1439c f3603u = null;
    private boolean f3604v = false;
    private C1390b<T> f3605w;
    private float f3606x;
    private int f3607y = 255;
    private int f3608z;

    /* compiled from: CustomRangeSeekBar */
    public interface C1390b<T> {
        void mo799a(C1440c<?> c1440c, T t, T t2);
    }

    /* compiled from: CustomRangeSeekBar */
    private enum C1438a {
        LONG,
        DOUBLE,
        INTEGER,
        FLOAT,
        SHORT,
        BYTE,
        BIG_DECIMAL;

        public static <E extends Number> C1438a m5453a(E e) {
            if (e instanceof Long) {
                return LONG;
            }
            if (e instanceof Double) {
                return DOUBLE;
            }
            if (e instanceof Integer) {
                return INTEGER;
            }
            if (e instanceof Float) {
                return FLOAT;
            }
            if (e instanceof Short) {
                return SHORT;
            }
            if (e instanceof Byte) {
                return BYTE;
            }
            if (e instanceof BigDecimal) {
                return BIG_DECIMAL;
            }
            throw new IllegalArgumentException("Number class '" + e.getClass().getName() + "' is not supported");
        }

        public Number m5454a(double d) {
            switch (this) {
                case LONG:
                    return Long.valueOf((long) d);
                case DOUBLE:
                    return Double.valueOf(d);
                case INTEGER:
                    return Integer.valueOf((int) d);
                case FLOAT:
                    return Float.valueOf((float) d);
                case SHORT:
                    return Short.valueOf((short) ((int) d));
                case BYTE:
                    return Byte.valueOf((byte) ((int) d));
                case BIG_DECIMAL:
                    return BigDecimal.valueOf(d);
                default:
                    throw new InstantiationError("can't convert " + this + " to a Number object");
            }
        }
    }

    /* compiled from: CustomRangeSeekBar */
    private enum C1439c {
        MIN,
        MAX
    }

    public C1440c(Context context) {
        super(context);
        m5460a(context, null);
    }

    private T m5458a(TypedArray typedArray, int i, int i2) {
        TypedValue peekValue = typedArray.peekValue(i);
        if (peekValue == null) {
            return Integer.valueOf(i2);
        }
        if (peekValue.type == 4) {
            return Float.valueOf(typedArray.getFloat(i, (float) i2));
        }
        return Integer.valueOf(typedArray.getInteger(i, i2));
    }

    private void m5460a(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            m5466c();
        } else {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C1426a.RangeSeekBar, 0, 0);
            m5470a(m5458a(obtainStyledAttributes, 0, f3577a.intValue()), m5458a(obtainStyledAttributes, 1, f3578b.intValue()));
            this.f3585F = obtainStyledAttributes.getBoolean(2, false);
            obtainStyledAttributes.recycle();
        }
        m5467d();
        this.f3594l = (float) C1443f.m5486a(context, 20);
        this.f3582C = C1443f.m5486a(context, 14);
        this.f3583D = C1443f.m5486a(context, 8);
        this.f3581B = (this.f3582C + C1443f.m5486a(context, 8)) + this.f3583D;
        float a = (float) C1443f.m5486a(context, 3);
        this.f3584E = new RectF(this.f3595m, (((float) this.f3581B) + this.f3593k) - (a / 2.0f), ((float) getWidth()) - this.f3595m, (a / 2.0f) + (((float) this.f3581B) + this.f3593k));
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.f3608z = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public void m5470a(T t, T t2) {
        this.f3596n = t;
        this.f3597o = t2;
        m5467d();
    }

    private void m5466c() {
        this.f3596n = f3577a;
        this.f3597o = f3578b;
        m5467d();
    }

    private void m5467d() {
        this.f3599q = this.f3596n.doubleValue();
        this.f3600r = this.f3597o.doubleValue();
        this.f3598p = C1438a.m5453a(this.f3596n);
    }

    public void setNotifyWhileDragging(boolean z) {
        this.f3604v = z;
    }

    public T getAbsoluteMinValue() {
        return this.f3596n;
    }

    public T getAbsoluteMaxValue() {
        return this.f3597o;
    }

    public T getSelectedMinValue() {
        return m5457a(this.f3601s);
    }

    public void setSelectedMinValue(T t) {
        if (0.0d == this.f3600r - this.f3599q) {
            setNormalizedMinValue(0.0d);
        } else {
            setNormalizedMinValue(m5455a((Number) t));
        }
    }

    public T getSelectedMaxValue() {
        return m5457a(this.f3602t);
    }

    public void setSelectedMaxValue(T t) {
        if (0.0d == this.f3600r - this.f3599q) {
            setNormalizedMaxValue(1.0d);
        } else {
            setNormalizedMaxValue(m5455a((Number) t));
        }
    }

    public void setOnRangeSeekBarChangeListener(C1390b<T> c1390b) {
        this.f3605w = c1390b;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.f3607y = motionEvent.getPointerId(motionEvent.getPointerCount() - 1);
                this.f3606x = motionEvent.getX(motionEvent.findPointerIndex(this.f3607y));
                this.f3603u = m5456a(this.f3606x);
                if (this.f3603u != null) {
                    setPressed(true);
                    invalidate();
                    m5469a();
                    m5465b(motionEvent);
                    m5468e();
                    break;
                }
                return super.onTouchEvent(motionEvent);
            case 1:
                if (this.f3580A) {
                    m5465b(motionEvent);
                    m5471b();
                    setPressed(false);
                } else {
                    m5469a();
                    m5465b(motionEvent);
                    m5471b();
                }
                this.f3603u = null;
                invalidate();
                if (this.f3605w != null) {
                    this.f3605w.mo799a(this, getSelectedMinValue(), getSelectedMaxValue());
                    break;
                }
                break;
            case 2:
                if (this.f3603u != null) {
                    if (this.f3580A) {
                        m5465b(motionEvent);
                    } else if (Math.abs(motionEvent.getX(motionEvent.findPointerIndex(this.f3607y)) - this.f3606x) > ((float) this.f3608z)) {
                        setPressed(true);
                        invalidate();
                        m5469a();
                        m5465b(motionEvent);
                        m5468e();
                    }
                    if (this.f3604v && this.f3605w != null) {
                        this.f3605w.mo799a(this, getSelectedMinValue(), getSelectedMaxValue());
                        break;
                    }
                }
                break;
            case 3:
                if (this.f3580A) {
                    m5471b();
                    setPressed(false);
                }
                invalidate();
                break;
            case 5:
                int pointerCount = motionEvent.getPointerCount() - 1;
                this.f3606x = motionEvent.getX(pointerCount);
                this.f3607y = motionEvent.getPointerId(pointerCount);
                invalidate();
                break;
            case 6:
                m5461a(motionEvent);
                invalidate();
                break;
        }
        return true;
    }

    private final void m5461a(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.f3607y) {
            action = action == 0 ? 1 : 0;
            this.f3606x = motionEvent.getX(action);
            this.f3607y = motionEvent.getPointerId(action);
        }
    }

    private final void m5465b(MotionEvent motionEvent) {
        float x = motionEvent.getX(motionEvent.findPointerIndex(this.f3607y));
        if (C1439c.MIN.equals(this.f3603u) && !this.f3585F) {
            setNormalizedMinValue(m5463b(x));
        } else if (C1439c.MAX.equals(this.f3603u)) {
            setNormalizedMaxValue(m5463b(x));
        }
    }

    private void m5468e() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    void m5469a() {
        this.f3580A = true;
    }

    void m5471b() {
        this.f3580A = false;
    }

    protected synchronized void onMeasure(int i, int i2) {
        int size;
        if (MeasureSpec.getMode(i) != 0) {
            size = MeasureSpec.getSize(i);
        } else {
            size = 200;
        }
        int height = this.f3588f.getHeight() + C1443f.m5486a(getContext(), 30);
        if (MeasureSpec.getMode(i2) != 0) {
            height = Math.min(height, MeasureSpec.getSize(i2));
        }
        setMeasuredDimension(size, height);
    }

    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f3587e.setTextSize((float) this.f3582C);
        this.f3587e.setStyle(Style.FILL);
        this.f3587e.setColor(-7829368);
        this.f3587e.setAntiAlias(true);
        String str = "";
        String str2 = "";
        float max = Math.max(this.f3587e.measureText(str), this.f3587e.measureText(str2));
        float f = (((float) this.f3581B) + this.f3593k) + ((float) (this.f3582C / 3));
        canvas.drawText(str, 0.0f, f, this.f3587e);
        canvas.drawText(str2, ((float) getWidth()) - max, f, this.f3587e);
        this.f3595m = (this.f3594l + max) + this.f3592j;
        this.f3584E.left = this.f3595m;
        this.f3584E.right = ((float) getWidth()) - this.f3595m;
        canvas.drawRect(this.f3584E, this.f3587e);
        boolean z = getSelectedMinValue().equals(getAbsoluteMinValue()) && getSelectedMaxValue().equals(getAbsoluteMaxValue());
        int parseColor = z ? Color.parseColor("#FF061084") : f3579c;
        this.f3584E.left = m5464b(this.f3601s);
        this.f3584E.right = m5464b(this.f3602t);
        this.f3587e.setColor(parseColor);
        canvas.drawRect(this.f3584E, this.f3587e);
        if (!this.f3585F) {
            m5459a(m5464b(this.f3601s), C1439c.MIN.equals(this.f3603u), canvas, z);
        }
        m5459a(m5464b(this.f3602t), C1439c.MAX.equals(this.f3603u), canvas, z);
        if (!z) {
            this.f3587e.setTextSize((float) this.f3582C);
            this.f3587e.setColor(-16777216);
            parseColor = C1443f.m5486a(getContext(), 5);
            str = String.valueOf(getSelectedMinValue());
            str2 = String.valueOf(getSelectedMaxValue());
            max = this.f3587e.measureText(str) + ((float) parseColor);
            float measureText = ((float) parseColor) + this.f3587e.measureText(str2);
            if (!this.f3585F) {
                canvas.drawText(str, m5464b(this.f3601s) - (max * 0.5f), (float) (this.f3583D + this.f3582C), this.f3587e);
            }
            canvas.drawText(str2, m5464b(this.f3602t) - (measureText * 0.5f), (float) (this.f3583D + this.f3582C), this.f3587e);
        }
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        bundle.putParcelable("SUPER", super.onSaveInstanceState());
        bundle.putDouble("MIN", this.f3601s);
        bundle.putDouble("MAX", this.f3602t);
        return bundle;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("SUPER"));
        this.f3601s = bundle.getDouble("MIN");
        this.f3602t = bundle.getDouble("MAX");
    }

    private void m5459a(float f, boolean z, Canvas canvas, boolean z2) {
        Bitmap bitmap = z2 ? this.f3590h : z ? this.f3589g : this.f3588f;
        canvas.drawBitmap(bitmap, f - this.f3592j, (float) this.f3581B, this.f3587e);
    }

    private C1439c m5456a(float f) {
        boolean a = m5462a(f, this.f3601s);
        boolean a2 = m5462a(f, this.f3602t);
        if (a && a2) {
            return f / ((float) getWidth()) > 0.5f ? C1439c.MIN : C1439c.MAX;
        } else {
            if (a) {
                return C1439c.MIN;
            }
            if (a2) {
                return C1439c.MAX;
            }
            return null;
        }
    }

    private boolean m5462a(float f, double d) {
        return Math.abs(f - m5464b(d)) <= this.f3592j;
    }

    private void setNormalizedMinValue(double d) {
        this.f3601s = Math.max(0.0d, Math.min(1.0d, Math.min(d, this.f3602t)));
        invalidate();
    }

    private void setNormalizedMaxValue(double d) {
        this.f3602t = Math.max(0.0d, Math.min(1.0d, Math.max(d, this.f3601s)));
        invalidate();
    }

    private T m5457a(double d) {
        return this.f3598p.m5454a(((double) Math.round((this.f3599q + ((this.f3600r - this.f3599q) * d)) * 100.0d)) / 100.0d);
    }

    private double m5455a(T t) {
        if (0.0d == this.f3600r - this.f3599q) {
            return 0.0d;
        }
        return (t.doubleValue() - this.f3599q) / (this.f3600r - this.f3599q);
    }

    private float m5464b(double d) {
        return (float) (((double) this.f3595m) + (((double) (((float) getWidth()) - (2.0f * this.f3595m))) * d));
    }

    private double m5463b(float f) {
        int width = getWidth();
        if (((float) width) <= this.f3595m * 2.0f) {
            return 0.0d;
        }
        return Math.min(1.0d, Math.max(0.0d, (double) ((f - this.f3595m) / (((float) width) - (this.f3595m * 2.0f)))));
    }
}
