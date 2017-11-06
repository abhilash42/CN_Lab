// UNIPOLAR NRZ
package aksvat;
import java.io.*;
import java.util.*;
import java.applet.*;
import java.awt.*;
public class unipolar extends Applet
{
    int ele,rem,ind,t,b,x,x1,y1,x2,y2;
    int arr[]=new int[5];
    int bit[]=new int[20];
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
    }
    public void paint(Graphics g)
    {
        g.drawString("UNIPOLAR NRZ", 400, 10);
        g.drawLine(20,20,20,600);
        g.drawLine(20,600,900,600);
        b=600;
        t=20;
        x=20;
        g.setColor(Color.RED);
        for(int i=0;i<20;i++)
        {
            x1=x;
            x+=40;
            x2=x;
            if(bit[i]==0)
             y1=y2=b;
            else
            {
                y1=y2=t;
                if(i>0&&bit[i-1]!=1)
                g.drawLine(x1, t, x1, b);
                if(i<19&&bit[i+1]!=1)
                    g.drawLine(x2, t, x2, b);
            }
            g.drawLine(x1, y1, x2, y2);
        }
    }
}