package in.org.npci.commonlibrary;

import java.io.Serializable;

public class Data implements Serializable {
    private static final long serialVersionUID = 5218660121564017090L;
    private String code;
    private String encryptedBase64String;
    private String hmac;
    private String ki;
    private String pid;
    private String skey;
    private String type;

    Data(String str, String str2, String str3) {
        this.ki = str;
        this.code = str2;
        this.encryptedBase64String = str3;
    }

    Data(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.ki = str;
        this.code = str2;
        this.skey = str3;
        this.type = str4;
        this.pid = str5;
        this.hmac = str6;
        this.encryptedBase64String = str7;
    }

    public String getCode() {
        return this.code;
    }

    public String getEncryptedBase64String() {
        return this.encryptedBase64String;
    }

    public String getHmac() {
        return this.hmac;
    }

    public String getKi() {
        return this.ki;
    }

    public String getPid() {
        return this.pid;
    }

    public String getSkey() {
        return this.skey;
    }

    public String getType() {
        return this.type;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setEncryptedBase64String(String str) {
        this.encryptedBase64String = str;
    }

    public void setHmac(String str) {
        this.hmac = str;
    }

    public void setKi(String str) {
        this.ki = str;
    }

    public void setPid(String str) {
        this.pid = str;
    }

    public void setSkey(String str) {
        this.skey = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
