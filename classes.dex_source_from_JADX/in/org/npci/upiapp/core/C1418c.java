package in.org.npci.upiapp.core;

import java.util.Date;

/* compiled from: OtpSms */
public class C1418c {
    private String f3519a;
    private String f3520b;
    private Date f3521c;
    private String f3522d;
    private String f3523e;

    public void m5358a(String str) {
        this.f3519a = str;
    }

    public String m5357a() {
        return this.f3520b;
    }

    public void m5361b(String str) {
        this.f3520b = str;
    }

    public Date m5360b() {
        return this.f3521c;
    }

    public void m5359a(Date date) {
        this.f3521c = date;
    }

    public String m5362c() {
        return this.f3522d;
    }

    public void m5363c(String str) {
        this.f3522d = str;
    }

    public String m5364d() {
        return this.f3523e;
    }

    public void m5365d(String str) {
        this.f3523e = str;
    }

    public String toString() {
        return "OtpSms{bank=" + this.f3519a + ", sms='" + this.f3520b + '\'' + ", receivedTime=" + this.f3521c + ", otp='" + this.f3522d + '\'' + ", id='" + this.f3523e + '\'' + '}';
    }
}
