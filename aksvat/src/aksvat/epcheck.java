//1D EVEN PARITY CHECK
package aksvat;
import java.io.*;
import java.util.*;
class epcheck
{
    public static void main(String args[])
    {
        int cnt=0;
        Scanner inp=new Scanner(System.in);
        int send[]=new int[8];
        int rec[]=new int[8];
        System.out.println("SENT DATA");
        for(int i=0;i<7;i++)
        {
            send[i]=inp.nextInt();
            if(send[i]==1)
                cnt++;
        }
        if(cnt%2==0)
            send[7]=0;
        else
            send[7]=1;
        System.out.println("PARITY BIT "+send[7]);
        System.out.println("RECEIVED DATA");
        cnt=0;
        for(int i=0;i<8;i++)
        {
            rec[i]=inp.nextInt();
            if(rec[i]==1)
                cnt++;
        }
        System.out.println("SENT DATA");
        for(int i=0;i<8;i++)
            System.out.print(send[i]+" ");
        System.out.println("\nRECEIVED DATA");
        for(int i=0;i<8;i++)
            System.out.print(rec[i]+" ");
        if(cnt%2!=0)
            System.out.println("\nCORRUPT DATA");
        else
            System.out.println("\nCORRECT DATA");
    }
}
