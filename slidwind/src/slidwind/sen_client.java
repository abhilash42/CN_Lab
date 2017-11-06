package slidwind;
import java.io.*;
import java.util.*;
import java.net.*;
class sen_client
{
    public static void main(String srg[])
    {
        try
        {
        long l;
        Socket s=new Socket("localhost",6666);
        DataInputStream din=new DataInputStream(s.getInputStream());
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        String rwin=(String)din.readUTF();
        int rec_win=Integer.parseInt(rwin);
        System.out.println("MAXIMUM SENDER WINDOW SIZE "+rec_win);
        String ack=din.readUTF();
        if(ack.equals("ACKNOWLEDGMENT"))
        {
            long stopTime = System.currentTimeMillis();
            dout.writeUTF("START TIME");
            String stime=(String)din.readUTF();
            long startTime=Long.parseLong(stime);
            l=stopTime-startTime;
            System.out.println(l);
            if(l>1000)
            {
                System.out.println("CONGESTION OCCURS");
                System.out.println("NEW MAXIMUM WINDOW SIZE IS "+(rec_win-5));
            }
            else
                System.out.println("NO CONGESTION OCCURS");
        }
        din.close();
        dout.flush();
        dout.close();
        s.close();
        }catch(Exception e){e.printStackTrace();}
    }
}