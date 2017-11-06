package com.crashlytics.android.core;

import android.os.Process;
import io.fabric.sdk.android.services.p020b.C1482i;
import io.fabric.sdk.android.services.p020b.C1493o;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

class CLSUUID {
    private static String _clsId;
    private static final AtomicLong _sequenceNumber = new AtomicLong(0);

    public CLSUUID(C1493o c1493o) {
        r0 = new byte[10];
        populateTime(r0);
        populateSequenceNumber(r0);
        populatePID(r0);
        String a = C1482i.m5647a(c1493o.m5696b());
        String a2 = C1482i.m5649a(r0);
        _clsId = String.format(Locale.US, "%s-%s-%s-%s", new Object[]{a2.substring(0, 12), a2.substring(12, 16), a2.subSequence(16, 20), a.substring(0, 12)}).toUpperCase(Locale.US);
    }

    private void populateTime(byte[] bArr) {
        long time = new Date().getTime();
        long j = time / 1000;
        time %= 1000;
        byte[] convertLongToFourByteBuffer = convertLongToFourByteBuffer(j);
        bArr[0] = convertLongToFourByteBuffer[0];
        bArr[1] = convertLongToFourByteBuffer[1];
        bArr[2] = convertLongToFourByteBuffer[2];
        bArr[3] = convertLongToFourByteBuffer[3];
        byte[] convertLongToTwoByteBuffer = convertLongToTwoByteBuffer(time);
        bArr[4] = convertLongToTwoByteBuffer[0];
        bArr[5] = convertLongToTwoByteBuffer[1];
    }

    private void populateSequenceNumber(byte[] bArr) {
        byte[] convertLongToTwoByteBuffer = convertLongToTwoByteBuffer(_sequenceNumber.incrementAndGet());
        bArr[6] = convertLongToTwoByteBuffer[0];
        bArr[7] = convertLongToTwoByteBuffer[1];
    }

    private void populatePID(byte[] bArr) {
        byte[] convertLongToTwoByteBuffer = convertLongToTwoByteBuffer((long) Integer.valueOf(Process.myPid()).shortValue());
        bArr[8] = convertLongToTwoByteBuffer[0];
        bArr[9] = convertLongToTwoByteBuffer[1];
    }

    private static byte[] convertLongToFourByteBuffer(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt((int) j);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    private static byte[] convertLongToTwoByteBuffer(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort((short) ((int) j));
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    public String toString() {
        return _clsId;
    }
}
