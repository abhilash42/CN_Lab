package org.apache.xml.security.c14n.implementations;

import org.w3c.dom.Attr;

class NameSpaceSymbEntry implements Cloneable {
    int f4057a = 0;
    String f4058b;
    String f4059c;
    String f4060d = null;
    boolean f4061e = false;
    Attr f4062f;

    NameSpaceSymbEntry(String str, Attr attr, boolean z, String str2) {
        this.f4059c = str;
        this.f4061e = z;
        this.f4062f = attr;
        this.f4058b = str2;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
