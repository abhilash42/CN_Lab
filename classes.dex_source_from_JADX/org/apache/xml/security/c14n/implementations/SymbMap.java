package org.apache.xml.security.c14n.implementations;

import java.util.ArrayList;
import java.util.List;

class SymbMap implements Cloneable {
    int f4068a = 23;
    NameSpaceSymbEntry[] f4069b = new NameSpaceSymbEntry[this.f4068a];
    String[] f4070c = new String[this.f4068a];

    SymbMap() {
    }

    protected int m6130a(Object obj) {
        String[] strArr = this.f4070c;
        int length = strArr.length;
        int hashCode = (obj.hashCode() & Integer.MAX_VALUE) % length;
        Object obj2 = strArr[hashCode];
        if (obj2 != null && !obj2.equals(obj)) {
            length--;
            do {
                hashCode = hashCode == length ? 0 : hashCode + 1;
                obj2 = strArr[hashCode];
                if (obj2 == null) {
                    break;
                }
            } while (!obj2.equals(obj));
        }
        return hashCode;
    }

    List m6131a() {
        List arrayList = new ArrayList();
        int i = 0;
        while (i < this.f4069b.length) {
            if (!(this.f4069b[i] == null || "".equals(this.f4069b[i].f4059c))) {
                arrayList.add(this.f4069b[i]);
            }
            i++;
        }
        return arrayList;
    }

    NameSpaceSymbEntry m6132a(String str) {
        return this.f4069b[m6130a((Object) str)];
    }

    protected void m6133a(int i) {
        int length = this.f4070c.length;
        String[] strArr = this.f4070c;
        NameSpaceSymbEntry[] nameSpaceSymbEntryArr = this.f4069b;
        this.f4070c = new String[i];
        this.f4069b = new NameSpaceSymbEntry[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (strArr[i2] != null) {
                Object obj = strArr[i2];
                int a = m6130a(obj);
                this.f4070c[a] = obj;
                this.f4069b[a] = nameSpaceSymbEntryArr[i2];
                length = i2;
            } else {
                length = i2;
            }
        }
    }

    void m6134a(String str, NameSpaceSymbEntry nameSpaceSymbEntry) {
        int a = m6130a((Object) str);
        Object obj = this.f4070c[a];
        this.f4070c[a] = str;
        this.f4069b[a] = nameSpaceSymbEntry;
        if (obj == null || !obj.equals(str)) {
            a = this.f4068a - 1;
            this.f4068a = a;
            if (a == 0) {
                this.f4068a = this.f4069b.length;
                m6133a(this.f4068a << 2);
            }
        }
    }

    protected Object clone() {
        try {
            SymbMap symbMap = (SymbMap) super.clone();
            symbMap.f4069b = new NameSpaceSymbEntry[this.f4069b.length];
            System.arraycopy(this.f4069b, 0, symbMap.f4069b, 0, this.f4069b.length);
            symbMap.f4070c = new String[this.f4070c.length];
            System.arraycopy(this.f4070c, 0, symbMap.f4070c, 0, this.f4070c.length);
            return symbMap;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
