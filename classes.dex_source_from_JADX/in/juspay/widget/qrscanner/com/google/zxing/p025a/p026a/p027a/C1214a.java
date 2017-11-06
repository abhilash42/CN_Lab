package in.juspay.widget.qrscanner.com.google.zxing.p025a.p026a.p027a;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.hardware.Camera.Area;
import android.hardware.Camera.Parameters;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.p034a.C1314d.C1313a;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public final class C1214a {
    private static final Pattern f2660a = Pattern.compile(";");

    public static void m4646a(Parameters parameters, C1313a c1313a, boolean z) {
        Collection supportedFocusModes = parameters.getSupportedFocusModes();
        String str = null;
        if (z || c1313a == C1313a.AUTO) {
            str = C1214a.m4642a("focus mode", supportedFocusModes, "auto");
        } else if (c1313a == C1313a.CONTINUOUS) {
            str = C1214a.m4642a("focus mode", supportedFocusModes, "continuous-picture", "continuous-video", "auto");
        } else if (c1313a == C1313a.INFINITY) {
            str = C1214a.m4642a("focus mode", supportedFocusModes, "infinity");
        } else if (c1313a == C1313a.MACRO) {
            str = C1214a.m4642a("focus mode", supportedFocusModes, "macro");
        }
        if (!z && r0 == null) {
            str = C1214a.m4642a("focus mode", supportedFocusModes, "macro", "edof");
        }
        if (str != null && !str.equals(parameters.getFocusMode())) {
            parameters.setFocusMode(str);
        }
    }

    public static void m4647a(Parameters parameters, boolean z) {
        String a;
        Collection supportedFlashModes = parameters.getSupportedFlashModes();
        if (z) {
            a = C1214a.m4642a("flash mode", supportedFlashModes, "torch", "on");
        } else {
            a = C1214a.m4642a("flash mode", supportedFlashModes, "off");
        }
        if (a != null && !a.equals(parameters.getFlashMode())) {
            parameters.setFlashMode(a);
        }
    }

    public static void m4649b(Parameters parameters, boolean z) {
        float f = 0.0f;
        int minExposureCompensation = parameters.getMinExposureCompensation();
        int maxExposureCompensation = parameters.getMaxExposureCompensation();
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        if (!(minExposureCompensation == 0 && maxExposureCompensation == 0) && exposureCompensationStep > 0.0f) {
            if (!z) {
                f = 1.5f;
            }
            int round = Math.round(f / exposureCompensationStep);
            exposureCompensationStep *= (float) round;
            round = Math.max(Math.min(round, maxExposureCompensation), minExposureCompensation);
            if (parameters.getExposureCompensation() != round) {
                parameters.setExposureCompensation(round);
            }
        }
    }

    public static void m4644a(Parameters parameters) {
        C1214a.m4645a(parameters, 10, 20);
    }

    public static void m4645a(Parameters parameters, int i, int i2) {
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        if (supportedPreviewFpsRange != null && !supportedPreviewFpsRange.isEmpty()) {
            for (int[] iArr : supportedPreviewFpsRange) {
                int i3 = iArr[0];
                int i4 = iArr[1];
                if (i3 >= i * 1000 && i4 <= i2 * 1000) {
                    break;
                }
            }
            int[] iArr2 = null;
            if (iArr2 != null) {
                int[] iArr3 = new int[2];
                parameters.getPreviewFpsRange(iArr3);
                if (!Arrays.equals(iArr3, iArr2)) {
                    parameters.setPreviewFpsRange(iArr2[0], iArr2[1]);
                }
            }
        }
    }

    @TargetApi(15)
    public static void m4648b(Parameters parameters) {
        if (parameters.getMaxNumFocusAreas() > 0) {
            parameters.setFocusAreas(C1214a.m4643a(400));
        }
    }

    @TargetApi(15)
    public static void m4650c(Parameters parameters) {
        if (parameters.getMaxNumMeteringAreas() > 0) {
            parameters.setMeteringAreas(C1214a.m4643a(400));
        }
    }

    @TargetApi(15)
    private static List<Area> m4643a(int i) {
        return Collections.singletonList(new Area(new Rect(-i, -i, i, i), 1));
    }

    @TargetApi(15)
    public static void m4651d(Parameters parameters) {
        if (parameters.isVideoStabilizationSupported() && !parameters.getVideoStabilization()) {
            parameters.setVideoStabilization(true);
        }
    }

    public static void m4652e(Parameters parameters) {
        if (!"barcode".equals(parameters.getSceneMode())) {
            String a = C1214a.m4642a("scene mode", parameters.getSupportedSceneModes(), "barcode");
            if (a != null) {
                parameters.setSceneMode(a);
            }
        }
    }

    public static void m4653f(Parameters parameters) {
        if (!"negative".equals(parameters.getColorEffect())) {
            String a = C1214a.m4642a("color effect", parameters.getSupportedColorEffects(), "negative");
            if (a != null) {
                parameters.setColorEffect(a);
            }
        }
    }

    private static String m4642a(String str, Collection<String> collection, String... strArr) {
        if (collection != null) {
            for (String str2 : strArr) {
                if (collection.contains(str2)) {
                    return str2;
                }
            }
        }
        return null;
    }
}
