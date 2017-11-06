package networkday2;

import java.io.IOException;
import java.net.*;
public class NetworkDay2 {

    public static void main(String[] args) throws MalformedURLException, IOException{
        URL u;
        u = new URL("file:///C:/jdk-8u131-docs-all/docs/api/java/net/URL.html");
        Object v;
        v=u.getContent();
        String s,s0,s1,s2,s3,s4,s5,s6;
        s=u.getFile();
        int p;
        p=u.getPort();
        s0=u.getAuthority();
        s1=u.getHost();
        s2=u.getPath();
        s3=u.getProtocol();
        s4=u.getQuery();
        s5=u.getRef();
        s6=u.getUserInfo();
        System.out.println(s0);
        System.out.println(v);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);
        System.out.println(p);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
