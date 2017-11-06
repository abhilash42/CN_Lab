package javaapplication9;
import java.net.*;
import java.io.*;
public class JavaApplication9 {

    public static void main(String[] args) {
        try{
        int port=6782;
        ServerSocket ss= new ServerSocket(port);
        Socket s=ss.accept();
        System.out.println("Server up");
        BufferedReader bo= new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream forClient = new DataOutputStream(s.getOutputStream());
        String rec;
        rec=bo.readLine();
        System.out.println("Message from Client: "+rec);
        System.out.print("Enter message for Client: ");
        String message = br.readLine();
        forClient.writeBytes(message+"\n");
        }
        catch(Exception e){
            System.out.println("Server not responding");
        }
        }
    
}
