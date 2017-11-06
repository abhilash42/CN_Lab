package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import in.juspay.widget.qrscanner.C1211a.C1206b;
import in.juspay.widget.qrscanner.C1211a.C1210f;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.p034a.C1310b;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.p034a.C1314d;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.p034a.C1315e;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.p034a.C1317l;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.p034a.C1318g;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.p034a.C1319h;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.p034a.C1320i;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.p034a.C1321j;
import java.util.ArrayList;
import java.util.List;

public class C1294c extends ViewGroup {
    private static final String f2943a = C1294c.class.getSimpleName();
    private final C1298a f2944A = new C13315(this);
    private C1310b f2945b;
    private WindowManager f2946c;
    private Handler f2947d;
    private boolean f2948e = false;
    private SurfaceView f2949f;
    private TextureView f2950g;
    private boolean f2951h = false;
    private C1345k f2952i;
    private int f2953j = -1;
    private List<C1298a> f2954k = new ArrayList();
    private C1319h f2955l;
    private C1314d f2956m = new C1314d();
    private C1346l f2957n;
    private C1346l f2958o;
    private Rect f2959p;
    private C1346l f2960q;
    private Rect f2961r = null;
    private Rect f2962s = null;
    private C1346l f2963t = null;
    private double f2964u = 0.1d;
    private C1317l f2965v = null;
    private boolean f2966w = false;
    private final Callback f2967x = new C13262(this);
    private final Handler.Callback f2968y = new C13273(this);
    private C1329j f2969z = new C13304(this);

    public interface C1298a {
        void mo775a();

        void mo776a(Exception exception);

        void mo777b();

        void mo778c();
    }

    class C13251 implements SurfaceTextureListener {
        final /* synthetic */ C1294c f3083a;

        C13251(C1294c c1294c) {
            this.f3083a = c1294c;
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.f3083a.f2960q = new C1346l(i, i2);
            this.f3083a.m4966k();
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    class C13262 implements Callback {
        final /* synthetic */ C1294c f3084a;

        C13262(C1294c c1294c) {
            this.f3084a = c1294c;
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            this.f3084a.f2960q = null;
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            if (surfaceHolder != null) {
                this.f3084a.f2960q = new C1346l(i2, i3);
                this.f3084a.m4966k();
            }
        }
    }

    class C13273 implements Handler.Callback {
        final /* synthetic */ C1294c f3085a;

        C13273(C1294c c1294c) {
            this.f3085a = c1294c;
        }

        public boolean handleMessage(Message message) {
            if (message.what == C1206b.zxing_prewiew_size_ready) {
                this.f3085a.m4960b((C1346l) message.obj);
                return true;
            }
            if (message.what == C1206b.zxing_camera_error) {
                Exception exception = (Exception) message.obj;
                if (this.f3085a.m4975f()) {
                    this.f3085a.mo772d();
                    this.f3085a.f2944A.mo776a(exception);
                }
            }
            return false;
        }
    }

    class C13304 implements C1329j {
        final /* synthetic */ C1294c f3087a;

        class C13281 implements Runnable {
            final /* synthetic */ C13304 f3086a;

            C13281(C13304 c13304) {
                this.f3086a = c13304;
            }

            public void run() {
                this.f3086a.f3087a.mo770b();
            }
        }

        C13304(C1294c c1294c) {
            this.f3087a = c1294c;
        }

        public void mo781a(int i) {
            this.f3087a.f2947d.postDelayed(new C13281(this), 250);
        }
    }

    class C13315 implements C1298a {
        final /* synthetic */ C1294c f3088a;

        C13315(C1294c c1294c) {
            this.f3088a = c1294c;
        }

        public void mo775a() {
            for (C1298a a : this.f3088a.f2954k) {
                a.mo775a();
            }
        }

        public void mo777b() {
            for (C1298a b : this.f3088a.f2954k) {
                b.mo777b();
            }
        }

        public void mo778c() {
            for (C1298a c : this.f3088a.f2954k) {
                c.mo778c();
            }
        }

        public void mo776a(Exception exception) {
            for (C1298a a : this.f3088a.f2954k) {
                a.mo776a(exception);
            }
        }
    }

    @TargetApi(14)
    private SurfaceTextureListener mo769a() {
        return new C13251(this);
    }

    public C1294c(Context context) {
        super(context);
        m4953a(context, null, 0, 0);
    }

    public C1294c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4953a(context, attributeSet, 0, 0);
    }

    public C1294c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4953a(context, attributeSet, i, 0);
    }

    private void m4953a(Context context, AttributeSet attributeSet, int i, int i2) {
        if (getBackground() == null) {
            setBackgroundColor(-16777216);
        }
        m4970a(attributeSet);
        this.f2946c = (WindowManager) context.getSystemService("window");
        this.f2947d = new Handler(this.f2968y);
        this.f2952i = new C1345k();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m4964i();
    }

    protected void m4970a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C1210f.zxing_camera_preview);
        int dimension = (int) obtainStyledAttributes.getDimension(C1210f.zxing_camera_preview_zxing_framing_rect_width, -1.0f);
        int dimension2 = (int) obtainStyledAttributes.getDimension(C1210f.zxing_camera_preview_zxing_framing_rect_height, -1.0f);
        if (dimension > 0 && dimension2 > 0) {
            this.f2963t = new C1346l(dimension, dimension2);
        }
        this.f2948e = obtainStyledAttributes.getBoolean(C1210f.zxing_camera_preview_zxing_use_texture_view, true);
        dimension = obtainStyledAttributes.getInteger(C1210f.zxing_camera_preview_zxing_preview_scaling_strategy, -1);
        if (dimension == 1) {
            this.f2965v = new C1318g();
        } else if (dimension == 2) {
            this.f2965v = new C1320i();
        } else if (dimension == 3) {
            this.f2965v = new C1321j();
        }
        obtainStyledAttributes.recycle();
    }

    private void mo770b() {
        if (m4975f() && getDisplayRotation() != this.f2953j) {
            mo772d();
            m4974e();
        }
    }

    @SuppressLint({"NewAPI"})
    private void m4964i() {
        if (!this.f2948e || VERSION.SDK_INT < 14) {
            this.f2949f = new SurfaceView(getContext());
            if (VERSION.SDK_INT < 11) {
                this.f2949f.getHolder().setType(3);
            }
            this.f2949f.getHolder().addCallback(this.f2967x);
            addView(this.f2949f);
            return;
        }
        this.f2950g = new TextureView(getContext());
        this.f2950g.setSurfaceTextureListener(mo769a());
        addView(this.f2950g);
    }

    public void m4971a(C1298a c1298a) {
        this.f2954k.add(c1298a);
    }

    private void m4965j() {
        if (this.f2957n == null || this.f2958o == null || this.f2955l == null) {
            this.f2962s = null;
            this.f2961r = null;
            this.f2959p = null;
            throw new IllegalStateException("containerSize or previewSize is not set yet");
        }
        int i = this.f2958o.f3130a;
        int i2 = this.f2958o.f3131b;
        int i3 = this.f2957n.f3130a;
        int i4 = this.f2957n.f3131b;
        this.f2959p = this.f2955l.m5088a(this.f2958o);
        this.f2961r = m4969a(new Rect(0, 0, i3, i4), this.f2959p);
        Rect rect = new Rect(this.f2961r);
        rect.offset(-this.f2959p.left, -this.f2959p.top);
        this.f2962s = new Rect((rect.left * i) / this.f2959p.width(), (rect.top * i2) / this.f2959p.height(), (i * rect.right) / this.f2959p.width(), (i2 * rect.bottom) / this.f2959p.height());
        if (this.f2962s.width() <= 0 || this.f2962s.height() <= 0) {
            this.f2962s = null;
            this.f2961r = null;
            return;
        }
        this.f2944A.mo775a();
    }

    public void setTorch(boolean z) {
        this.f2966w = z;
        if (this.f2945b != null) {
            this.f2945b.m5038a(z);
        }
    }

    private void m4956a(C1346l c1346l) {
        this.f2957n = c1346l;
        if (this.f2945b != null && this.f2945b.m5032a() == null) {
            this.f2955l = new C1319h(getDisplayRotation(), c1346l);
            this.f2955l.m5091a(getPreviewScalingStrategy());
            this.f2945b.m5036a(this.f2955l);
            this.f2945b.m5040c();
            if (this.f2966w) {
                this.f2945b.m5038a(this.f2966w);
            }
        }
    }

    public void setPreviewScalingStrategy(C1317l c1317l) {
        this.f2965v = c1317l;
    }

    public C1317l getPreviewScalingStrategy() {
        if (this.f2965v != null) {
            return this.f2965v;
        }
        if (this.f2950g != null) {
            return new C1318g();
        }
        return new C1320i();
    }

    private void m4960b(C1346l c1346l) {
        this.f2958o = c1346l;
        if (this.f2957n != null) {
            m4965j();
            requestLayout();
            m4966k();
        }
    }

    protected Matrix m4968a(C1346l c1346l, C1346l c1346l2) {
        float f = 1.0f;
        float f2 = ((float) c1346l.f3130a) / ((float) c1346l.f3131b);
        float f3 = ((float) c1346l2.f3130a) / ((float) c1346l2.f3131b);
        if (f2 < f3) {
            f2 = f3 / f2;
        } else {
            float f4 = f2 / f3;
            f2 = 1.0f;
            f = f4;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f2, f);
        matrix.postTranslate((((float) c1346l.f3130a) - (f2 * ((float) c1346l.f3130a))) / 2.0f, (((float) c1346l.f3131b) - (f * ((float) c1346l.f3131b))) / 2.0f);
        return matrix;
    }

    private void m4966k() {
        if (this.f2960q != null && this.f2958o != null && this.f2959p != null) {
            if (this.f2949f != null && this.f2960q.equals(new C1346l(this.f2959p.width(), this.f2959p.height()))) {
                m4954a(new C1315e(this.f2949f.getHolder()));
            } else if (this.f2950g != null && VERSION.SDK_INT >= 14 && this.f2950g.getSurfaceTexture() != null) {
                if (this.f2958o != null) {
                    this.f2950g.setTransform(m4968a(new C1346l(this.f2950g.getWidth(), this.f2950g.getHeight()), this.f2958o));
                }
                m4954a(new C1315e(this.f2950g.getSurfaceTexture()));
            }
        }
    }

    @SuppressLint({"DrawAllocation"})
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        m4956a(new C1346l(i3 - i, i4 - i2));
        if (this.f2949f != null) {
            if (this.f2959p == null) {
                this.f2949f.layout(0, 0, getWidth(), getHeight());
            } else {
                this.f2949f.layout(this.f2959p.left, this.f2959p.top, this.f2959p.right, this.f2959p.bottom);
            }
        } else if (this.f2950g != null && VERSION.SDK_INT >= 14) {
            this.f2950g.layout(0, 0, getWidth(), getHeight());
        }
    }

    public Rect getFramingRect() {
        return this.f2961r;
    }

    public Rect getPreviewFramingRect() {
        return this.f2962s;
    }

    public C1314d getCameraSettings() {
        return this.f2956m;
    }

    public void setCameraSettings(C1314d c1314d) {
        this.f2956m = c1314d;
    }

    public void m4974e() {
        C1348n.m5158a();
        m4967l();
        if (this.f2960q != null) {
            m4966k();
        } else if (this.f2949f != null) {
            this.f2949f.getHolder().addCallback(this.f2967x);
        } else if (this.f2950g != null && VERSION.SDK_INT >= 14) {
            if (this.f2950g.isAvailable()) {
                mo769a().onSurfaceTextureAvailable(this.f2950g.getSurfaceTexture(), this.f2950g.getWidth(), this.f2950g.getHeight());
            } else {
                this.f2950g.setSurfaceTextureListener(mo769a());
            }
        }
        requestLayout();
        this.f2952i.m5146a(getContext(), this.f2969z);
    }

    public void mo772d() {
        C1348n.m5158a();
        this.f2953j = -1;
        if (this.f2945b != null) {
            this.f2945b.m5042e();
            this.f2945b = null;
            this.f2951h = false;
        }
        if (this.f2960q == null && this.f2949f != null) {
            this.f2949f.getHolder().removeCallback(this.f2967x);
        }
        if (this.f2960q == null && this.f2950g != null && VERSION.SDK_INT >= 14) {
            this.f2950g.setSurfaceTextureListener(null);
        }
        this.f2957n = null;
        this.f2958o = null;
        this.f2962s = null;
        this.f2952i.m5145a();
        this.f2944A.mo778c();
    }

    public C1346l getFramingRectSize() {
        return this.f2963t;
    }

    public void setFramingRectSize(C1346l c1346l) {
        this.f2963t = c1346l;
    }

    public double getMarginFraction() {
        return this.f2964u;
    }

    public void setMarginFraction(double d) {
        if (d >= 0.5d) {
            throw new IllegalArgumentException("The margin fraction must be less than 0.5");
        }
        this.f2964u = d;
    }

    public void setUseTextureView(boolean z) {
        this.f2948e = z;
    }

    protected boolean m4975f() {
        return this.f2945b != null;
    }

    private int getDisplayRotation() {
        return this.f2946c.getDefaultDisplay().getRotation();
    }

    private void m4967l() {
        if (this.f2945b == null) {
            this.f2945b = m4976g();
            this.f2945b.m5033a(this.f2947d);
            this.f2945b.m5039b();
            this.f2953j = getDisplayRotation();
        }
    }

    protected C1310b m4976g() {
        C1310b c1310b = new C1310b(getContext());
        c1310b.m5034a(this.f2956m);
        return c1310b;
    }

    private void m4954a(C1315e c1315e) {
        if (!this.f2951h && this.f2945b != null) {
            this.f2945b.m5035a(c1315e);
            this.f2945b.m5041d();
            this.f2951h = true;
            mo771c();
            this.f2944A.mo777b();
        }
    }

    protected void mo771c() {
    }

    public C1310b getCameraInstance() {
        return this.f2945b;
    }

    public boolean m4977h() {
        return this.f2951h;
    }

    protected Rect m4969a(Rect rect, Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.intersect(rect2);
        if (this.f2963t != null) {
            rect3.inset(Math.max(0, (rect3.width() - this.f2963t.f3130a) / 2), Math.max(0, (rect3.height() - this.f2963t.f3131b) / 2));
        } else {
            int min = (int) Math.min(((double) rect3.width()) * this.f2964u, ((double) rect3.height()) * this.f2964u);
            rect3.inset(min, min);
            if (rect3.height() > rect3.width()) {
                rect3.inset(0, (rect3.height() - rect3.width()) / 2);
            }
        }
        return rect3;
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Parcelable bundle = new Bundle();
        bundle.putParcelable("super", onSaveInstanceState);
        bundle.putBoolean("torch", this.f2966w);
        return bundle;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            super.onRestoreInstanceState(bundle.getParcelable("super"));
            setTorch(bundle.getBoolean("torch"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }
}
