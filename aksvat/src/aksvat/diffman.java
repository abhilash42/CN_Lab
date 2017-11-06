// DIFFERENTIAL-MANCHESTER
package aksvat;
import java.io.*;
import java.util.*;
import java.applet.*;
import java.awt.*;
public class diffman extends Applet
{
    int ele,rem,ind,t,b,x,x1,y1,x2,y2,in=0;
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
       if(bit[0]==0)
       {
           bits[in]=1;
           in++;
           bits[in]=0;
           in++;
       }
       else
       {
           bits[in]=0;
           in++;
           bits[in]=1;
           in++;
       }
       for(int i=1;i<20;i++)
       {
           if(bit[i]==0)
           {
               if(bits[in-1]==0)
               {
                   bits[in]=1;
                   in++;
                   bits[in]=0;
                   in++;
               }
               else
               {
                   bits[in]=0;
                   in++;
                   bits[in]=1;
                   in++;
               }
           }
           else
           {
               if(bits[in-1]==0)
               {
                   bits[in]=0;
                   in++;
                   bits[in]=1;
                   in++;
               }
               else
               {
                   bits[in]=1;
                   in++;
                   bits[in]=0;
                   in++;
               }
           }
       }
    }
    public void paint(Graphics g)
    {
        g.drawString("DIFFERENTIAL MANCHESTER", 400, 10);
        g.drawLine(20,20,20,600);
        g.drawLine(10,310,900,310);
        b=560;
        t=60;
        x=20;
        g.setColor(Color.RED);
        if(bits[0]==1)
         g.drawLine(20,t,20,b);    
        for(int i=0;i<40;i++)
        {
            x1=x;
            x+=20;
            x2=x;
            if(bits[i]==1)
                y1=y2=b;
            else
            {
                y1=y2=t;
                if(i>0&&bits[i-1]==1)
                    g.drawLine(x1, t, x1, b);
                if(i<39&&bits[i+1]==1)
                    g.drawLine(x2,t,x2,b);
            }
            g.drawLine(x1,y1,x2,y2);
        }
    }
}