package slidwind;
import java.io.*;
import java.util.*;
import java.net.*;
import java.math.*;
class rec_server
{
    public static void main(String srg[])
    {
        try
        {
        int i=-2147483648;
        ServerSocket ss=new ServerSocket(6666);
        Socket s=ss.accept();
        DataInputStream din=new DataInputStream(s.getInputStream());
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        int rec_win=(int)(Math.random()*51+5);
        String rwin=Integer.toString(rec_win);
        dout.writeUTF(rwin);
        long startTime = System.currentTimeMillis();
        String ack="ACKNOWLEDGMENT";
        while(i!= 2147456756)
            i++;
        dout.writeUTF(ack);
        String st=(String)din.readUTF();
        if(st.equals("START TIME"))
        {
            String stime=Long.toString(startTime);
            dout.writeUTF(stime);
        }
        din.close();
        dout.flush();
        dout.close();
        s.close();
        ss.close();
        }catch(Exception e){e.printStackTrace();}
    }
}