package in.org.npci.commonlibrary;

import java.io.Serializable;

public class Message implements Serializable {
    private static final long serialVersionUID = -8585407394073013324L;
    private Data data;
    private String subType;
    private String type;

    public Message(String str, String str2, Data data) {
        this.type = str;
        this.subType = str2;
        this.data = data;
    }

    public Data getData() {
        return this.data;
    }

    public String getSubType() {
        return this.subType;
    }

    public String getType() {
        return this.type;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void setSubType(String str) {
        this.subType = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
