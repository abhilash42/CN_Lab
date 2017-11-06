package in.juspay.widget.qrscanner.com.google.zxing;

public abstract class ReaderException extends Exception {
    protected static final boolean f2652a;
    protected static final StackTraceElement[] f2653b = new StackTraceElement[0];

    static {
        boolean z;
        if (System.getProperty("surefire.test.class.path") != null) {
            z = true;
        } else {
            z = false;
        }
        f2652a = z;
    }

    ReaderException() {
    }

    public final synchronized Throwable fillInStackTrace() {
        return null;
    }
}
