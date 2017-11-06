package org.apache.xml.security.utils;

import java.util.ArrayList;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class HelperNodeList implements NodeList {
    ArrayList f4231a;
    boolean f4232b;

    public HelperNodeList() {
        this(false);
    }

    public HelperNodeList(boolean z) {
        this.f4231a = new ArrayList(20);
        this.f4232b = false;
        this.f4232b = z;
    }

    public int getLength() {
        return this.f4231a.size();
    }

    public Node item(int i) {
        return (Node) this.f4231a.get(i);
    }
}
