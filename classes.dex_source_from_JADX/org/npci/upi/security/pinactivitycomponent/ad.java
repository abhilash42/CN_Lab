package org.npci.upi.security.pinactivitycomponent;

import android.os.Process;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;

public class ad implements UncaughtExceptionHandler {
    String f4324a = "\n";

    public void uncaughtException(Thread thread, Throwable th) {
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("************ LOCATION OF ERROR ************\n\n");
        stringBuilder.append("NPCI Common Library");
        stringBuilder.append(this.f4324a);
        stringBuilder.append("\n************ CAUSE OF ERROR ************\n\n");
        stringBuilder.append(stringWriter.toString());
        stringBuilder.append(this.f4324a);
        Log.e("Exception!!!", stringBuilder.toString());
        Process.killProcess(Process.myPid());
    }
}
