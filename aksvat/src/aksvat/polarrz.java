// POLAR RZ
package aksvat;
import java.io.*;
import java.util.*;
import java.applet.*;
import java.awt.*;
public class polarrz extends Applet
{
    int ele,rem,ind,t,b,x,x1,y1,x2,y2,in,m;
    int arr[]=new int[5];
    int bit[]=new int[20];
    int bits[]=new int[40];
    public void init()
    {
        for(int i=0;i<20;i++)
           bit[i]=0; 
        Scanner inp=new Scanner(System.in);
        System.out.println("ENTER THE ANALOG DATA ");
        for(int i=0;i<5;i++)
            arr[i]=inp.nextInt();
        for(int i=0;i<5;i++)
        {
            ele=arr[i];
            ind=4*i+3;
            while(ele!=0)
            {
                rem=ele%2;
                bit[ind]=rem;
                ind--;
                ele/=2;
            }
        }
        System.out.println("DIGITAL DATA IS ");
        for(int i=0;i<20;i++)
            System.out.print(bit[i]+" ");
       for(int i=1;i<40;i+=2)
           bits[i]=0;
        for(int i=0,j=0;i<40;i+=2,j++)
        {
            if(bit[j]==1)
                bits[i]=1;
            else
                bits[i]=-1;
        }
    }
    public void paint(Graphics g)
    {
        g.drawString("POLAR RZ", 400, 10);
        g.drawLine(10,310,900,310);
        b=600;
        m=310;
        t=20;
        x=20;
        g.setColor(Color.RED);
        for(int i=0;i<40;i++)
        {
            x1=x;
            x+=20;
            x2=x;
            if(bits[i]==0)
                g.drawLine(x1,m,x2,m);
            else if(bits[i]==1)
            {
                g.drawLine(x1, t, x2, t);
                g.drawLine(x1, t, x1, m);
                g.drawLine(x2, t, x2, m);
            }
            else
            {
                g.drawLine(x1, b, x2, b);
                g.drawLine(x1, b, x1, m);
                g.drawLine(x2, b, x2, m);
            }
            
        }
        g.setColor(Color.BLACK);
        g.drawLine(20, 20, 20, 600);
    }
}