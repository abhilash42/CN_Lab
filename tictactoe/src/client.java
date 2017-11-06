import java.io.*;
import java.net.*;
import java.util.*;
import java.math.*;
class client
{
    public static void main(String args[])
    {
        try
        {
        Socket s=new Socket("localhost",6666);
        char ch[]=new char[9];
        int r;
        String str="---------";
        ch=str.toCharArray();
        while(true)
        {
             r=(int)(Math.random()*9);
             if(ch[r]=='-')
             {
               ch[r]='C';
               break;
             }
        }
        System.out.println("\nCURRENT SCENARIO");
                for(int i=0;i<9;i++)
            {
                System.out.print(ch[i]+" ");
                if((i+1)%3==0)
                    System.out.println();
            }
        str=String.valueOf(ch);
        DataInputStream din=new DataInputStream(s.getInputStream());
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        dout.writeUTF(str);
        dout.flush();
        while(true)
        {
            str=(String)din.readUTF();
            if(str.equals("CLOSE"))
            {
            dout.close();
            din.close();
            s.close();       
                break;
            }
            ch=str.toCharArray();
            while(true)
            {
                r=(int)(Math.random()*9);
                if(ch[r]=='-')
                {
                    ch[r]='C';
                    break;
                }
            }
            if((ch[0]==ch[3]&&ch[3]==ch[6]&&ch[0]=='C')||(ch[1]==ch[4]&&ch[4]==ch[7]&&ch[1]=='C')||(ch[2]==ch[5]&&ch[5]==ch[8]&&ch[2]=='C')||(ch[0]==ch[4]&&ch[4]==ch[8]&&ch[0]=='C')||(ch[2]==ch[4]&&ch[4]==ch[6]&&ch[2]=='C'))
            {
                System.out.println("\nCLIENT WINS");
            for(int i=0;i<9;i++)
            {
                System.out.print(ch[i]+" ");
                if((i+1)%3==0)
                    System.out.println();
            }
            dout.writeUTF("CLOSE");
            dout.flush();
            dout.close();
            din.close();
            s.close();       
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
