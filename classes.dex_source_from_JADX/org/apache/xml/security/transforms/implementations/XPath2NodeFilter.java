package org.apache.xml.security.transforms.implementations;

import java.util.Set;
import org.apache.xml.security.signature.NodeFilter;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Node;

class XPath2NodeFilter implements NodeFilter {
    boolean f4197a;
    boolean f4198b;
    boolean f4199c;
    Set f4200d;
    Set f4201e;
    Set f4202f;
    int f4203g = -1;
    int f4204h = -1;
    int f4205i = -1;

    XPath2NodeFilter(Set set, Set set2, Set set3) {
        boolean z = true;
        this.f4200d = set;
        this.f4197a = !set.isEmpty();
        this.f4201e = set2;
        this.f4198b = !set2.isEmpty();
        this.f4202f = set3;
        if (set3.isEmpty()) {
            z = false;
        }
        this.f4199c = z;
    }

    static boolean m6301a(Node node, Set set) {
        if (set.contains(node)) {
            return true;
        }
        for (Node a : set) {
            if (XMLUtils.m6390a(a, node)) {
                return true;
            }
        }
        return false;
    }

    static boolean m6302b(Node node, Set set) {
        return set.contains(node);
    }

    public int mo885a(Node node) {
        int i = (this.f4198b && m6301a(node, this.f4201e)) ? -1 : (!this.f4199c || m6301a(node, this.f4202f)) ? 1 : 0;
        return i == 1 ? 1 : this.f4197a ? m6301a(node, this.f4200d) ? 1 : 0 : i;
    }

    public int mo886a(Node node, int i) {
        int i2;
        if (this.f4198b) {
            if (this.f4203g == -1 || i <= this.f4203g) {
                if (m6302b(node, this.f4201e)) {
                    this.f4203g = i;
                } else {
                    this.f4203g = -1;
                }
            }
            if (this.f4203g != -1) {
                i2 = -1;
                if (i2 != -1 && this.f4199c && (this.f4204h == -1 || i <= this.f4204h)) {
                    if (m6302b(node, this.f4202f)) {
                        this.f4204h = -1;
                        i2 = 0;
                    } else {
                        this.f4204h = i;
                    }
                }
                if (i <= this.f4205i) {
                    this.f4205i = -1;
                }
                if (i2 == 1) {
                    return 1;
                }
                if (this.f4197a) {
                    return i2;
                }
                if (this.f4205i == -1 && m6302b(node, this.f4200d)) {
                    this.f4205i = i;
                }
                return this.f4205i == -1 ? 1 : 0;
            }
        }
        i2 = 1;
        if (m6302b(node, this.f4202f)) {
            this.f4204h = i;
        } else {
            this.f4204h = -1;
            i2 = 0;
        }
        if (i <= this.f4205i) {
            this.f4205i = -1;
        }
        if (i2 == 1) {
            return 1;
        }
        if (this.f4197a) {
            return i2;
        }
        this.f4205i = i;
        if (this.f4205i == -1) {
        }
    }
}
