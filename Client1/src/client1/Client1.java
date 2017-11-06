package client1;
import java.net.*;
import java.io.*;
public class Client1 {

    public static void main(String[] args) throws IOException{
        byte b0[]=new byte[5];
        b0[0]=127;
        b0[1]=0;
        b0[2]=0;
        b0[3]=2;
        InetAddress i=InetAddress.getByAddress("127.0.0.2", b0);
        DatagramSocket ds=new DatagramSocket();
        DatagramPacket d=new DatagramPacket(b0,1);
        ds.send(d);
        Socket s=new Socket();
        s.getInputStream();
        BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
        b.readLine();
        s.getOutputStream();
    }
    
}
