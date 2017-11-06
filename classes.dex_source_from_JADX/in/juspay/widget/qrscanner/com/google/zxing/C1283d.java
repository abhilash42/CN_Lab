package in.juspay.widget.qrscanner.com.google.zxing;

import java.util.List;

public enum C1283d {
    OTHER(Object.class),
    PURE_BARCODE(Void.class),
    POSSIBLE_FORMATS(List.class),
    TRY_HARDER(Void.class),
    CHARACTER_SET(String.class),
    ALLOWED_LENGTHS(int[].class),
    ASSUME_CODE_39_CHECK_DIGIT(Void.class),
    ASSUME_GS1(Void.class),
    RETURN_CODABAR_START_END(Void.class),
    NEED_RESULT_POINT_CALLBACK(C1291n.class),
    ALLOWED_EAN_EXTENSIONS(int[].class);
    
    private final Class<?> f2897l;

    private C1283d(Class<?> cls) {
        this.f2897l = cls;
    }
}
