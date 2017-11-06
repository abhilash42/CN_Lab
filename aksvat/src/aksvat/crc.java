//CYCLIC REDUNDANCY CHECK
package aksvat;
import java.io.*;
import java.util.*;
class crc
{
    public static void main(String args[])
    {
        int n,k,ptr1,ptr2,v;
        Scanner inp=new Scanner(System.in);
        System.out.println("N AND K");
        n=inp.nextInt();
        k=inp.nextInt();
        int dvs[]=new int[n+1];
        int div[]=new int[n+k];
        int temp[]=new int[n+k];
        System.out.println("DIVISOR");
        for(int i=0;i<n+1;i++)
            dvs[i]=inp.nextInt();
        System.out.println("DATAWORD");
        for(int i=0;i<k;i++)
            div[i]=inp.nextInt();
        for(int i=k;i<k+n;i++)
            div[i]=0;
        for(int i=0;i<n+k;i++)
            temp[i]=div[i];
        ptr1=0;
        ptr2=n;
        while(ptr2!=n+k)
        {
            if(temp[ptr1]==1)
            {
                for(int i=ptr1;i<=ptr2;i++)
                {
                    v=dvs[i-ptr1];
                    if(v==1)
                    {
                        if(temp[i]==0)
                            temp[i]=1;
                        else
                            temp[i]=0;
                    }
                }
            }
            ptr1++;
            ptr2++;
        }
        for(int i=k;i<k+n;i++)
            div[i]=temp[i];
        System.out.println("CODEWORD");
        for(int i=0;i<k+n;i++)
            System.out.print(div[i]);
        System.out.println("\nDATA RECEIVED");
        for(int i=0;i<n+k;i++)
            temp[i]=inp.nextInt();
        ptr1=0;
        ptr2=n;
        while(ptr2!=n+k)
        {
            if(temp[ptr1]==1)
            {
                for(int i=ptr1;i<=ptr2;i++)
                {
                    v=dvs[i-ptr1];
                    if(v==1)
                    {
                        if(temp[i]==0)
                            temp[i]=1;
                        else
                            temp[i]=0;
                    }
                }
            }
            ptr1++;
            ptr2++;
    }
        int flag=0;
        for(int i=k;i<n+k;i++)
        {
            if(temp[i]==1)
            {
                flag++;
                break;
            }
        }
        if(flag==0)
            System.out.println("ACCEPTED");
        else
            System.out.println("REJECTED");
}
}