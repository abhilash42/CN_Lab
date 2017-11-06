package majpoll;
import java.io.*;
import java.net.*;
import java.util.*;
import java.math.*;
class client1
{
    public static void main(String args[])
    {
        try
        {
            String ans,cno;
            int r,n=10;
            Socket s=new Socket("localhost",6666);
            DataInputStream din=new DataInputStream(s.getInputStream());
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            String str=(String)din.readUTF();
            String opt1=(String)din.readUTF();
            String opt2=(String)din.readUTF();
            String opt3=(String)din.readUTF();
            String opt4=(String)din.readUTF();
            while(n!=0)
            {
                cno=(String)din.readUTF();
                r=(int)(Math.random()*4+1);
                ans=Integer.toString(r);
                n--;
                dout.writeUTF(ans);
            }
            din.close();
            dout.flush();
            dout.close();
            s.close();
        }catch(Exception e){e.printStackTrace();}
    }
}
