package org.apache.xml.security.c14n.implementations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.w3c.dom.Attr;
import org.w3c.dom.Node;

public class NameSpaceSymbTable {
    static final SymbMap f4063e = new SymbMap();
    SymbMap f4064a = ((SymbMap) f4063e.clone());
    int f4065b = 0;
    List f4066c = new ArrayList(10);
    boolean f4067d = true;

    static {
        NameSpaceSymbEntry nameSpaceSymbEntry = new NameSpaceSymbEntry("", null, true, "xmlns");
        nameSpaceSymbEntry.f4060d = "";
        f4063e.m6134a("xmlns", nameSpaceSymbEntry);
    }

    public Attr m6116a(String str) {
        NameSpaceSymbEntry a = this.f4064a.m6132a(str);
        if (a == null || a.f4061e) {
            return null;
        }
        NameSpaceSymbEntry nameSpaceSymbEntry = (NameSpaceSymbEntry) a.clone();
        m6127e();
        this.f4064a.m6134a(str, nameSpaceSymbEntry);
        nameSpaceSymbEntry.f4061e = true;
        nameSpaceSymbEntry.f4057a = this.f4065b;
        nameSpaceSymbEntry.f4060d = nameSpaceSymbEntry.f4059c;
        return nameSpaceSymbEntry.f4062f;
    }

    public void m6117a() {
        this.f4065b++;
        m6123c();
    }

    public void m6118a(Collection collection) {
        for (NameSpaceSymbEntry nameSpaceSymbEntry : this.f4064a.m6131a()) {
            NameSpaceSymbEntry nameSpaceSymbEntry2;
            if (!(nameSpaceSymbEntry2.f4061e || nameSpaceSymbEntry2.f4062f == null)) {
                nameSpaceSymbEntry2 = (NameSpaceSymbEntry) nameSpaceSymbEntry2.clone();
                m6127e();
                this.f4064a.m6134a(nameSpaceSymbEntry2.f4058b, nameSpaceSymbEntry2);
                nameSpaceSymbEntry2.f4060d = nameSpaceSymbEntry2.f4059c;
                nameSpaceSymbEntry2.f4061e = true;
                collection.add(nameSpaceSymbEntry2.f4062f);
            }
        }
    }

    public boolean m6119a(String str, String str2, Attr attr) {
        NameSpaceSymbEntry a = this.f4064a.m6132a(str);
        if (a != null && str2.equals(a.f4059c)) {
            return false;
        }
        NameSpaceSymbEntry nameSpaceSymbEntry = new NameSpaceSymbEntry(str2, attr, false, str);
        m6127e();
        this.f4064a.m6134a(str, nameSpaceSymbEntry);
        if (a != null) {
            nameSpaceSymbEntry.f4060d = a.f4060d;
            if (a.f4060d != null && a.f4060d.equals(str2)) {
                nameSpaceSymbEntry.f4061e = true;
            }
        }
        return true;
    }

    public Attr m6120b(String str) {
        NameSpaceSymbEntry a = this.f4064a.m6132a(str);
        return (a == null || a.f4061e) ? null : a.f4062f;
    }

    public Node m6121b(String str, String str2, Attr attr) {
        NameSpaceSymbEntry a = this.f4064a.m6132a(str);
        if (a == null || !str2.equals(a.f4059c)) {
            NameSpaceSymbEntry nameSpaceSymbEntry = new NameSpaceSymbEntry(str2, attr, true, str);
            nameSpaceSymbEntry.f4060d = str2;
            m6127e();
            this.f4064a.m6134a(str, nameSpaceSymbEntry);
            if (a == null || a.f4060d == null || !a.f4060d.equals(str2)) {
                return nameSpaceSymbEntry.f4062f;
            }
            nameSpaceSymbEntry.f4061e = true;
            return null;
        } else if (a.f4061e) {
            return null;
        } else {
            NameSpaceSymbEntry nameSpaceSymbEntry2 = (NameSpaceSymbEntry) a.clone();
            m6127e();
            this.f4064a.m6134a(str, nameSpaceSymbEntry2);
            nameSpaceSymbEntry2.f4060d = str2;
            nameSpaceSymbEntry2.f4061e = true;
            return nameSpaceSymbEntry2.f4062f;
        }
    }

    public void m6122b() {
        this.f4065b--;
        m6125d();
    }

    public void m6123c() {
        this.f4066c.add(null);
        this.f4067d = false;
    }

    public void m6124c(String str) {
        if (this.f4064a.m6132a(str) != null) {
            m6127e();
            this.f4064a.m6134a(str, null);
        }
    }

    public void m6125d() {
        int size = this.f4066c.size() - 1;
        Object remove = this.f4066c.remove(size);
        if (remove != null) {
            this.f4064a = (SymbMap) remove;
            if (size == 0) {
                this.f4067d = false;
                return;
            } else {
                this.f4067d = this.f4066c.get(size + -1) != this.f4064a;
                return;
            }
        }
        this.f4067d = false;
    }

    public void m6126d(String str) {
        NameSpaceSymbEntry a = this.f4064a.m6132a(str);
        if (a != null && !a.f4061e) {
            m6127e();
            this.f4064a.m6134a(str, null);
        }
    }

    final void m6127e() {
        if (!this.f4067d) {
            this.f4066c.set(this.f4066c.size() - 1, this.f4064a);
            this.f4064a = (SymbMap) this.f4064a.clone();
            this.f4067d = true;
        }
    }

    public boolean m6128e(String str) {
        NameSpaceSymbEntry a = this.f4064a.m6132a(str);
        if (a != null && a.f4061e) {
            m6127e();
            this.f4064a.m6134a(str, null);
        }
        return false;
    }

    public int m6129f() {
        return this.f4066c.size();
    }
}
