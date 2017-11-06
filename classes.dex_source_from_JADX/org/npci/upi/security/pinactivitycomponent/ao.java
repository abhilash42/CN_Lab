package org.npci.upi.security.pinactivitycomponent;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;

public class ao {
    public static String m6501a(Object obj) {
        StringBuilder stringBuilder = new StringBuilder();
        m6502a(obj, stringBuilder);
        return stringBuilder.toString();
    }

    private static void m6502a(Object obj, StringBuilder stringBuilder) {
        int i = 0;
        if (obj == null) {
            stringBuilder.append("null");
            return;
        }
        Class cls = obj.getClass();
        if (cls.isArray()) {
            stringBuilder.append("[");
            while (i < Array.getLength(obj)) {
                m6502a(Array.get(obj, i), stringBuilder);
                stringBuilder.append(",");
                i++;
            }
            stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "]");
        } else if (cls.equals(String.class)) {
            stringBuilder.append("\"").append(obj).append("\"");
        } else if (cls.isPrimitive() || cls.equals(Integer.class) || cls.equals(Long.class) || cls.equals(Short.class) || cls.equals(Double.class) || cls.equals(Float.class) || cls.equals(BigDecimal.class)) {
            stringBuilder.append(String.valueOf(obj));
        } else {
            try {
                stringBuilder.append("{");
                Field[] declaredFields = cls.getDeclaredFields();
                int length = declaredFields.length;
                while (i < length) {
                    Field field = declaredFields[i];
                    if (!Modifier.isStatic(field.getModifiers())) {
                        field.setAccessible(true);
                        stringBuilder.append("\"").append(field.getName()).append("\"").append(":");
                        m6502a(field.get(obj), stringBuilder);
                        stringBuilder.append(",");
                    }
                    i++;
                }
                stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "}");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
