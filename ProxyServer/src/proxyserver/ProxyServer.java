package proxyserver;
import java.net.*;
import java.io.*;
public class ProxyServer {

    public static void main(String[] args) {
        try{
        int port1=6900;
        ServerSocket s0=new ServerSocket(port1);
        Socket s3=s0.accept();
        BufferedReader br=new BufferedReader(new InputStreamReader(s3.getInputStream()));
        BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream forProxyServer=new DataOutputStream(s3.getOutputStream());
        String rec1=br.readLine();
        System.out.println("Message from Client: "+rec1);
        String message=b.readLine();
        forProxyServer.writeBytes(message+"\n");
        String s1,s2;
        BufferedReader inFromClient=new BufferedReader(new InputStreamReader(System.in));
        Socket s7=new Socket("127.0.0.1",6320);
        DataOutputStream outToServer=new DataOutputStream(s7.getOutputStream());
        BufferedReader y=new BufferedReader(new InputStreamReader(s7.getInputStream()));
        s1=inFromClient.readLine();
        outToServer.writeBytes(s1+"\n");
        s2=y.readLine();
        System.out.println("Message from Server: "+s2);
        }
        catch(Exception ex){
            System.out.println("Proxy Server is broken");
        }
    }
    
}
