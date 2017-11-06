package in.org.npci.commonlibrary;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class C1361k extends DefaultHandler {
    private static List f3181a = new ArrayList();
    private static C1360j f3182b = null;
    private static String f3183c = null;

    public C1361k(String str) {
        try {
            SAXParserFactory.newInstance().newSAXParser().parse(new InputSource(new StringReader(str)), this);
        } catch (ParserConfigurationException e) {
            throw new C1356f(C1357g.PARSER_MISCONFIG);
        } catch (SAXException e2) {
            throw new C1356f(C1357g.PARSER_MISCONFIG);
        } catch (IOException e3) {
            throw new C1356f(C1357g.PARSER_MISCONFIG);
        }
    }

    public List m5189a() {
        return f3181a;
    }

    public void characters(char[] cArr, int i, int i2) {
        f3183c = String.copyValueOf(cArr, i, i2).trim();
    }

    public void endElement(String str, String str2, String str3) {
        Object obj = -1;
        switch (str3.hashCode()) {
            case 106079:
                if (str3.equals("key")) {
                    obj = null;
                    break;
                }
                break;
            case 492250706:
                if (str3.equals("keyValue")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                f3181a.add(f3182b);
                return;
            case 1:
                f3182b.m5188c(f3183c);
                return;
            default:
                return;
        }
    }

    protected void finalize() {
        System.out.println("KeyParser Destroyed");
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) {
        Object obj = -1;
        switch (str3.hashCode()) {
            case 106079:
                if (str3.equals("key")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                f3182b = new C1360j();
                f3182b.m5184a(attributes.getValue(CLConstants.FIELD_KI));
                f3182b.m5186b(attributes.getValue("owner"));
                return;
            default:
                return;
        }
    }
}
