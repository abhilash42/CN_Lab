package in.org.npci.commonlibrary;

public class C1356f extends Exception {
    private int f3162a;
    private String f3163b;

    public C1356f(C1357g c1357g) {
        super(c1357g.m5176a());
        this.f3162a = c1357g.m5177b();
        this.f3163b = c1357g.m5176a();
    }

    public String toString() {
        return "Error " + this.f3162a + " : " + this.f3163b;
    }
}
