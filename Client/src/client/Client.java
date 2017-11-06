package client;
import java.net.*;
import java.io.*;
public class Client {

    public static void main(String[] args) throws IOException{
        
        String s4,s5;
        BufferedReader inFromClient=new BufferedReader(new InputStreamReader(System.in));
        Socket s6=new Socket("127.0.0.2",6900);
        DataOutputStream outToServer=new DataOutputStream(s6.getOutputStream());
        BufferedReader y=new BufferedReader(new InputStreamReader(s6.getInputStream()));
        s4=inFromClient.readLine();
        outToServer.writeBytes(s4+"\n");
        s5=y.readLine();
        System.out.println("Message from Server: "+s5);
    }
    
}
