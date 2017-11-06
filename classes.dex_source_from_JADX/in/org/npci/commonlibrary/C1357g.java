package in.org.npci.commonlibrary;

public enum C1357g {
    KEY_CODE_EMPTY(1001, "Your organization key is empty. Please provide a organization key."),
    KEY_CODE_INVALID(1002, "Your organization key is invalid. Please contact your system administrator or UPI support team."),
    PUBLICKEY_NOT_FOUND(1003, "Public key file not found please contact your system administrator UPI support team"),
    PARSER_MISCONFIG(1004, "XML Parser configuration error.Keys.xml may not be formatted correctly."),
    XML_PATH_ERROR(1005, "XML File is not found or cannot be read."),
    KEYS_NOT_VALID(1006, "Keys are not valid. Please contact your system administrator UPI support team"),
    UNKNOWN_ERROR(1007, "Unknown error occurred."),
    TRUST_NOT_VALID(1008, "Trust is not valid");
    
    private final int f3173i;
    private final String f3174j;

    private C1357g(int i, String str) {
        this.f3173i = i;
        this.f3174j = str;
    }

    public String m5176a() {
        return this.f3174j;
    }

    public int m5177b() {
        return this.f3173i;
    }

    public String toString() {
        return this.f3173i + ": " + this.f3174j;
    }
}
