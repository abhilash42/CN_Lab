import java.io.*;
import java.net.*;
import java.util.*;
import java.math.*;
class server
{
    public static void main(String args[]) 
    {
        try
        {
        ServerSocket ss=new ServerSocket(6666);
        Socket s=ss.accept();
        String str;
        int r;
        char ch[]=new char[9];
        DataInputStream din=new DataInputStream(s.getInputStream());
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        while(true)
        {
        str=(String)din.readUTF();
        if(str.equals("CLOSE"))
        {
            dout.close();
            din.close();
              ss.close();
              break;
        }
        ch=str.toCharArray();
        while(true)
        {
            r=(int)(Math.random()*9);
            if(ch[r]=='-')
            {
                ch[r]='S';
                break;
            }
        }
        if((ch[0]==ch[3]&&ch[3]==ch[6]&&ch[0]=='S')||(ch[1]==ch[4]&&ch[4]==ch[7]&&ch[1]=='S')||(ch[2]==ch[5]&&ch[5]==ch[8]&&ch[2]=='S')||(ch[0]==ch[4]&&ch[4]==ch[8]&&ch[0]=='S')||(ch[2]==ch[4]&&ch[4]==ch[6]&&ch[2]=='S'))
        {
            System.out.println("\nSERVER WINS");
            for(int i=0;i<9;i++)
            {
                System.out.print(ch[i]+" ");
                if((i+1)%3==0)
                    System.out.println();
            }
            dout.writeUTF("OVER");
            dout.flush();
            dout.close();
            din.close();
              ss.close();
               break;
        } 
        else
        {
            System.out.println("\nCURRENT SCENARIO");
                for(int i=0;i<9;i++)
            {
                System.out.print(ch[i]+" ");
                if((i+1)%3==0)
                    System.out.println();
            }
            str=String.valueOf(ch);
            dout.writeUTF(str);
            dout.flush();
        }
    }
    }catch(Exception e){e.printStackTrace();}
}
}