//SERVER
package aksnet;
import java.io.*;
import java.net.*;
import java.util.*;
public class server
{
    public static void main(String args[]) throws IOException
    {       ServerSocket ss=new ServerSocket(6446);
            Socket s=ss.accept();
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            DataInputStream din=new DataInputStream(s.getInputStream());
        try
        {
            String str,str1,op;
            int a,b,c = 0;
            
            while(true){
            str=(String)din.readUTF();
            if(str == "close"){
                dout.close();
            din.close();
            s.close();
            ss.close();
            }
            StringTokenizer st=new StringTokenizer(str," ");
            str1=st.nextToken();
            a=Integer.parseInt(str1);
            str1=st.nextToken();
            op=str1;
            str1=st.nextToken();
            b=Integer.parseInt(str1);
            if(op.equals("+"))
                c=a+b;
            else if(op.equals("-"))
                c=a-b;
            else if(op.equals("*"))
                c=a*b;
            else if(op.equals("/"))
                c=a/b;
            else 
                c=a%b;
            str1=Integer.toString(c);
            dout.writeUTF(str1);
            dout.flush();}
            
        }catch(Exception e){e.printStackTrace();}
    }

   
    }
