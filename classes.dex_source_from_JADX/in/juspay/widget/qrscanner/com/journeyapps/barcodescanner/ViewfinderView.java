package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import in.juspay.widget.qrscanner.C1211a.C1205a;
import in.juspay.widget.qrscanner.C1211a.C1210f;
import in.juspay.widget.qrscanner.com.google.zxing.C1246m;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.C1294c.C1298a;
import java.util.ArrayList;
import java.util.List;

public class ViewfinderView extends View {
    protected static final String f2983a = ViewfinderView.class.getSimpleName();
    protected static final int[] f2984b = new int[]{0, 64, 128, 192, 255, 192, 128, 64};
    protected final Paint f2985c = new Paint(1);
    protected Bitmap f2986d;
    protected final int f2987e;
    protected final int f2988f;
    protected final int f2989g;
    protected final int f2990h;
    protected int f2991i;
    protected List<C1246m> f2992j;
    protected List<C1246m> f2993k;
    protected C1294c f2994l;
    protected Rect f2995m;
    protected Rect f2996n;

    class C12991 implements C1298a {
        final /* synthetic */ ViewfinderView f2982a;

        C12991(ViewfinderView viewfinderView) {
            this.f2982a = viewfinderView;
        }

        public void mo775a() {
            this.f2982a.m5011a();
            this.f2982a.invalidate();
        }

        public void mo777b() {
        }

        public void mo778c() {
        }

        public void mo776a(Exception exception) {
        }
    }

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources = getResources();
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C1210f.zxing_finder);
        this.f2987e = obtainStyledAttributes.getColor(C1210f.zxing_finder_zxing_viewfinder_mask, resources.getColor(C1205a.zxing_viewfinder_mask));
        this.f2988f = obtainStyledAttributes.getColor(C1210f.zxing_finder_zxing_result_view, resources.getColor(C1205a.zxing_result_view));
        this.f2989g = obtainStyledAttributes.getColor(C1210f.zxing_finder_zxing_viewfinder_laser, resources.getColor(C1205a.zxing_viewfinder_laser));
        this.f2990h = obtainStyledAttributes.getColor(C1210f.zxing_finder_zxing_possible_result_points, resources.getColor(C1205a.zxing_possible_result_points));
        obtainStyledAttributes.recycle();
        this.f2991i = 0;
        this.f2992j = new ArrayList(5);
        this.f2993k = null;
    }

    public void setCameraPreview(C1294c c1294c) {
        this.f2994l = c1294c;
        c1294c.m4971a(new C12991(this));
    }

    protected void m5011a() {
        if (this.f2994l != null) {
            Rect framingRect = this.f2994l.getFramingRect();
            Rect previewFramingRect = this.f2994l.getPreviewFramingRect();
            if (framingRect != null && previewFramingRect != null) {
                this.f2995m = framingRect;
                this.f2996n = previewFramingRect;
            }
        }
    }

    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        m5011a();
        if (this.f2995m != null && this.f2996n != null) {
            Rect rect = this.f2995m;
            Rect rect2 = this.f2996n;
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            this.f2985c.setColor(this.f2986d != null ? this.f2988f : this.f2987e);
            canvas.drawRect(0.0f, 0.0f, (float) width, (float) rect.top, this.f2985c);
            canvas.drawRect(0.0f, (float) rect.top, (float) rect.left, (float) (rect.bottom + 1), this.f2985c);
            canvas.drawRect((float) (rect.right + 1), (float) rect.top, (float) width, (float) (rect.bottom + 1), this.f2985c);
            canvas.drawRect(0.0f, (float) (rect.bottom + 1), (float) width, (float) height, this.f2985c);
            if (this.f2986d != null) {
                this.f2985c.setAlpha(160);
                canvas.drawBitmap(this.f2986d, null, rect, this.f2985c);
                return;
            }
            this.f2985c.setColor(this.f2989g);
            this.f2985c.setAlpha(f2984b[this.f2991i]);
            this.f2991i = (this.f2991i + 1) % f2984b.length;
            int height2 = (rect.height() / 2) + rect.top;
            canvas.drawRect((float) (rect.left + 2), (float) (height2 - 1), (float) (rect.right - 1), (float) (height2 + 2), this.f2985c);
            float width2 = ((float) rect.width()) / ((float) rect2.width());
            float height3 = ((float) rect.height()) / ((float) rect2.height());
            List<C1246m> list = this.f2992j;
            List<C1246m> list2 = this.f2993k;
            int i = rect.left;
            int i2 = rect.top;
            if (list.isEmpty()) {
                this.f2993k = null;
            } else {
                this.f2992j = new ArrayList(5);
                this.f2993k = list;
                this.f2985c.setAlpha(160);
                this.f2985c.setColor(this.f2990h);
                for (C1246m c1246m : list) {
                    canvas.drawCircle((float) (((int) (c1246m.m4738a() * width2)) + i), (float) (((int) (c1246m.m4739b() * height3)) + i2), 6.0f, this.f2985c);
                }
            }
            if (list2 != null) {
                this.f2985c.setAlpha(80);
                this.f2985c.setColor(this.f2990h);
                for (C1246m c1246m2 : list2) {
                    canvas.drawCircle((float) (((int) (c1246m2.m4738a() * width2)) + i), (float) (((int) (c1246m2.m4739b() * height3)) + i2), 3.0f, this.f2985c);
                }
            }
            postInvalidateDelayed(80, rect.left - 6, rect.top - 6, rect.right + 6, rect.bottom + 6);
        }
    }

    public void m5012a(C1246m c1246m) {
        List list = this.f2992j;
        list.add(c1246m);
        int size = list.size();
        if (size > 20) {
            list.subList(0, size - 10).clear();
        }
    }
}
