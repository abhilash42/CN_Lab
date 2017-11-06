package majpoll;
import java.io.*;
import java.awt.*;
import java.applet.*;
import java.net.*;
public class server extends Applet
{
    int ca,cb,cc,cd;
    public void init()
    {
        try
        {
        int n=1;
        ca=cb=cc=cd=0;
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
                ca++;
            else if(ans.equals("2"))
                cb++;
            else if(ans.equals("3"))
                cc++;
            else
                cd++;
            n++;
        }
        din.close();
        dout.flush();
        dout.close();
        ss.close();
        System.out.println("OPT 1 GETS "+ca*10+"%");
        System.out.println("OPT 2 GETS "+cb*10+"%");
        System.out.println("OPT 3 GETS "+cc*10+"%");
        System.out.println("OPT 4 GETS "+cd*10+"%");
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
    public void paint(Graphics g)
    {
        int x=110;
        g.setColor(Color.BLACK);
        g.drawLine(50, 600, 800, 600);
        g.drawLine(50,50,50,600);
        ca=ca*6;
        cb=cb*6;
        cc=cc*6;
        cd=cd*6;
        g.drawLine(x,600,x,600-ca);
        g.drawLine(x+60, 600, x+60, 600-ca);
        g.drawLine(x,600-ca, x+60, 600-ca);
        x+=120;
        g.drawLine(x,600,x,600-cb);
        g.drawLine(x+60, 600, x+60, 600-cb);
        g.drawLine(x,600-cb, x+60, 600-cb);
        x+=120;
        g.drawLine(x,600,x,600-cc);
        g.drawLine(x+60, 600, x+60, 600-cc);
        g.drawLine(x,600-cc, x+60, 600-cc);
        x+=120;
        g.drawLine(x,600,x,600-cd);
        g.drawLine(x+60, 600, x+60, 600-cd);
        g.drawLine(x,600-cd, x+60, 600-cd);
        g.drawString("A", 140, 650);
        g.drawString("B", 260, 650);
        g.drawString("C", 380, 650);
        g.drawString("D", 500, 650);
    }
}