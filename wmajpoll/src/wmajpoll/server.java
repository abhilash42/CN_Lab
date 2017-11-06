package wmajpoll;
import java.io.*;
import java.util.*;
import java.net.*;
import java.math.*;
class server
{
    public static void main(String args[])
    {
        try
        {
        int ca=0,cb=0,cc=0,cd=0,n=1,sum;
        String ans,num,cs="CLIENT NO. ";
        ServerSocket ss=new ServerSocket(6666);
        Socket s=ss.accept();
        DataInputStream din=new DataInputStream(s.getInputStream());
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        String str="What is the capital of Chile?";
        dout.writeUTF(str);
        String opt1="1. Auckland";
        dout.writeUTF(opt1);
        String opt2="2. Tehran";
        dout.writeUTF(opt2);
        String opt3="3. Santiago";
        dout.writeUTF(opt3);
        String opt4="4. Paris";
        dout.writeUTF(opt4);
        while(n<=10)
        {
            num=Integer.toString(n);
            cs=cs+num;
            dout.writeUTF(cs);
            ans=(String)din.readUTF();
            if(ans.equals("1"))
            {
                if(n%2==0)
                    ca+=2;
                else
                    ca++;
            }
            else if(ans.equals("2"))
                {
                if(n%2==0)
                    cb+=2;
                else
                    cb++;
            }
            else if(ans.equals("3"))
                {
                if(n%2==0)
                    cc+=2;
                else
                    cc++;
            }
            else
               {
                if(n%2==0)
                    cd+=2;
                else
                    cd++;
            }
            n++;
        }
        din.close();
        dout.flush();
        dout.close();
        ss.close();
        sum=ca+cb+cc+cd;
        System.out.println("OPT 1 GETS "+(((float)ca/sum)*100)+"%");
        System.out.println("OPT 2 GETS "+(((float)cb/sum)*100)+"%");
        System.out.println("OPT 3 GETS "+(((float)cc/sum)*100)+"%");
        System.out.println("OPT 4 GETS "+(((float)cd/sum)*100)+"%");
        System.out.println("ACCORDING TO THE AUDIENCE");
        if(ca>cb&&ca>cc&&ca>cd)
            System.out.println("1. AUCKLAND");
        else if(cb>ca&&cb>cc&&cb>cd)
            System.out.println("2. TEHRAN");
        else if(cc>ca&&cc>cb&&cc>cd)
            System.out.println("3. SANTIAGO");
        else if(cd>ca&&cd>cb&&cd>cc)
            System.out.println("4. PARIS");
        else
            System.out.println("NO CLEAR CONCLUSION REACHED");
        }catch(Exception e){e.printStackTrace();}
    }
}