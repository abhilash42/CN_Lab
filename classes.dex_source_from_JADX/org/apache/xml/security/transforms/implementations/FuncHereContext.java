package org.apache.xml.security.transforms.implementations;

import org.apache.xml.dtm.DTMManager;
import org.apache.xml.security.utils.I18n;
import org.apache.xpath.XPathContext;
import org.w3c.dom.Node;

public class FuncHereContext extends XPathContext {
    private FuncHereContext() {
    }

    public FuncHereContext(Node node, DTMManager dTMManager) {
        super(node);
        try {
            this.m_dtmManager = dTMManager;
        } catch (IllegalAccessError e) {
            throw new IllegalAccessError(new StringBuffer().append(I18n.m6349a("endorsed.jdk1.4.0")).append(" Original message was \"").append(e.getMessage()).append("\"").toString());
        }
    }
}
