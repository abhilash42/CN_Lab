package com.google.android.gms.internal;

import io.fabric.sdk.android.services.p018c.C0670b;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class C1095q {
    public static <T extends C1080p> String m3991a(T t) {
        if (t == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            C1095q.m3993a(null, t, new StringBuffer(), stringBuffer);
            return stringBuffer.toString();
        } catch (IllegalAccessException e) {
            return "Error printing proto: " + e.getMessage();
        } catch (InvocationTargetException e2) {
            return "Error printing proto: " + e2.getMessage();
        }
    }

    private static String m3992a(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (i == 0) {
                stringBuffer.append(Character.toLowerCase(charAt));
            } else if (Character.isUpperCase(charAt)) {
                stringBuffer.append('_').append(Character.toLowerCase(charAt));
            } else {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    private static void m3993a(String str, Object obj, StringBuffer stringBuffer, StringBuffer stringBuffer2) {
        if (obj != null) {
            if (obj instanceof C1080p) {
                int modifiers;
                int length = stringBuffer.length();
                if (str != null) {
                    stringBuffer2.append(stringBuffer).append(C1095q.m3992a(str)).append(" <\n");
                    stringBuffer.append("  ");
                }
                Class cls = obj.getClass();
                for (Field field : cls.getFields()) {
                    modifiers = field.getModifiers();
                    String name = field.getName();
                    if (!("cachedSize".equals(name) || (modifiers & 1) != 1 || (modifiers & 8) == 8 || name.startsWith(C0670b.ROLL_OVER_FILE_NAME_SEPARATOR) || name.endsWith(C0670b.ROLL_OVER_FILE_NAME_SEPARATOR))) {
                        Class type = field.getType();
                        Object obj2 = field.get(obj);
                        if (!type.isArray()) {
                            C1095q.m3993a(name, obj2, stringBuffer, stringBuffer2);
                        } else if (type.getComponentType() == Byte.TYPE) {
                            C1095q.m3993a(name, obj2, stringBuffer, stringBuffer2);
                        } else {
                            int length2 = obj2 == null ? 0 : Array.getLength(obj2);
                            for (modifiers = 0; modifiers < length2; modifiers++) {
                                C1095q.m3993a(name, Array.get(obj2, modifiers), stringBuffer, stringBuffer2);
                            }
                        }
                    }
                }
                for (Method name2 : cls.getMethods()) {
                    String name3 = name2.getName();
                    if (name3.startsWith("set")) {
                        String substring = name3.substring(3);
                        try {
                            if (((Boolean) cls.getMethod("has" + substring, new Class[0]).invoke(obj, new Object[0])).booleanValue()) {
                                try {
                                    C1095q.m3993a(substring, cls.getMethod("get" + substring, new Class[0]).invoke(obj, new Object[0]), stringBuffer, stringBuffer2);
                                } catch (NoSuchMethodException e) {
                                }
                            }
                        } catch (NoSuchMethodException e2) {
                        }
                    }
                }
                if (str != null) {
                    stringBuffer.setLength(length);
                    stringBuffer2.append(stringBuffer).append(">\n");
                    return;
                }
                return;
            }
            stringBuffer2.append(stringBuffer).append(C1095q.m3992a(str)).append(": ");
            if (obj instanceof String) {
                stringBuffer2.append("\"").append(C1095q.m3995b((String) obj)).append("\"");
            } else if (obj instanceof byte[]) {
                C1095q.m3994a((byte[]) obj, stringBuffer2);
            } else {
                stringBuffer2.append(obj);
            }
            stringBuffer2.append("\n");
        }
    }

    private static void m3994a(byte[] bArr, StringBuffer stringBuffer) {
        if (bArr == null) {
            stringBuffer.append("\"\"");
            return;
        }
        stringBuffer.append('\"');
        for (byte b : bArr) {
            int i = b & 255;
            if (i == 92 || i == 34) {
                stringBuffer.append('\\').append((char) i);
            } else if (i < 32 || i >= 127) {
                stringBuffer.append(String.format("\\%03o", new Object[]{Integer.valueOf(i)}));
            } else {
                stringBuffer.append((char) i);
            }
        }
        stringBuffer.append('\"');
    }

    private static String m3995b(String str) {
        if (!str.startsWith("http") && str.length() > 200) {
            str = str.substring(0, 200) + "[...]";
        }
        return C1095q.m3996c(str);
    }

    private static String m3996c(String str) {
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt < ' ' || charAt > '~' || charAt == '\"' || charAt == '\'') {
                stringBuilder.append(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
            } else {
                stringBuilder.append(charAt);
            }
        }
        return stringBuilder.toString();
    }
}
