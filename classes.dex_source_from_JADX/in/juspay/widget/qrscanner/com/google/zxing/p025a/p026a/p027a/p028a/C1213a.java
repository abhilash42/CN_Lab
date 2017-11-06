package in.juspay.widget.qrscanner.com.google.zxing.p025a.p026a.p027a.p028a;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;

public final class C1213a {
    private static final String f2659a = C1213a.class.getName();

    private C1213a() {
    }

    public static int m4640a(int i) {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            return -1;
        }
        int i2;
        Object obj = i >= 0 ? 1 : null;
        if (obj == null) {
            i2 = 0;
            while (i2 < numberOfCameras) {
                CameraInfo cameraInfo = new CameraInfo();
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == 0) {
                    break;
                }
                i2++;
            }
        } else {
            i2 = i;
        }
        if (i2 < numberOfCameras) {
            return i2;
        }
        if (obj == null) {
            return 0;
        }
        return -1;
    }

    public static Camera m4641b(int i) {
        int a = C1213a.m4640a(i);
        if (a == -1) {
            return null;
        }
        return Camera.open(a);
    }
}
