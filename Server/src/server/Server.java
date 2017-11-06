package server;
import java.net.*;
import java.io.*;
public class Server {

    public static void main(String[] args) {
        try{
        int port=6320;   
        ServerSocket ss=new ServerSocket(port);
        Socket s=ss.accept();
        System.out.println("Server up");
        BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream forProxyServer=new DataOutputStream(s.getOutputStream());
        String rec1=br.readLine();
        System.out.println("Message from Client: "+rec1);
        System.out.print("Enter message for Client: ");
        String msg=b.readLine();
        forProxyServer.writeBytes(msg+"\n");
        }
        catch(Exception e){
            System.out.println("Server not responding");
        }
    }
    
}
