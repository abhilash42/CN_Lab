package javaapplication10;
import java.net.*;
import java.io.*;
public class JavaApplication10{

    public static void main(String[] args) throws IOException {
        String s1,s2;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket s0=new Socket("127.0.0.1",6782);
        DataOutputStream outToServer = new DataOutputStream(s0.getOutputStream());
        BufferedReader x = new BufferedReader(new InputStreamReader(s0.getInputStream()));
        s1=inFromUser.readLine();
        outToServer.writeBytes(s1+"\n");
        s2 = x.readLine();
        System.out.println("Message from server: "+s2);
    }
    
}
