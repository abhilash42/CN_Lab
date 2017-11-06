package in.juspay.mystique;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class C1174b implements InvocationHandler {
    private Object f2521a;
    private boolean f2522b = true;
    private C1178d f2523c;

    C1174b(Object obj, C1178d c1178d) {
        this.f2521a = obj;
        this.f2523c = c1178d;
    }

    public Object invoke(Object obj, Method method, Object[] objArr) {
        Object obj2;
        Exception exception;
        Exception exception2;
        Object obj3 = null;
        try {
            String str;
            if (this.f2522b) {
                obj3 = method.invoke(this.f2521a, objArr);
            }
            if (obj3 == null) {
                try {
                    obj2 = "null";
                } catch (Exception e) {
                    exception = e;
                    obj2 = obj3;
                    exception2 = exception;
                    this.f2523c.m4571d().mo786a("InvocationHandler", exception2.getMessage() + "-" + (this.f2521a.getClass().getName() + "-" + method.getName()));
                    return obj2;
                }
            }
            obj2 = obj3;
            if (objArr != null) {
                try {
                    String str2 = "\"";
                    str = ",";
                    for (int i = 0; i < objArr.length; i++) {
                        if (i == objArr.length - 1) {
                            str = "";
                        }
                        str2 = str2 + objArr[i] + str;
                    }
                    str = str2 + "\"";
                } catch (Exception e2) {
                    exception2 = e2;
                    this.f2523c.m4571d().mo786a("InvocationHandler", exception2.getMessage() + "-" + (this.f2521a.getClass().getName() + "-" + method.getName()));
                    return obj2;
                }
            }
            str = "''";
            this.f2523c.m4567a("window.duiProxyCallback('" + obj2 + "','" + this.f2521a.getClass().getName() + "','" + method.getName() + "'," + str + ");");
        } catch (Exception e3) {
            exception = e3;
            obj2 = null;
            exception2 = exception;
            this.f2523c.m4571d().mo786a("InvocationHandler", exception2.getMessage() + "-" + (this.f2521a.getClass().getName() + "-" + method.getName()));
            return obj2;
        }
        return obj2;
    }
}
