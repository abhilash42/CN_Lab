//2D EVEN PARITY CHECK
package aksvat;
import java.io.*;
import java.util.*;
class epcheck2d
{
    public static void main(String args[])
    {
        int cnt,flag=0;
        Scanner inp=new Scanner(System.in);
        int send[][]=new int[5][8];
        int rec[][]=new int[5][8];
        System.out.println("DATA SENT");
        for(int i=0;i<4;i++)
        {
            cnt=0;
            for(int j=0;j<7;j++)
            {
                send[i][j]=inp.nextInt();
                if(rec[i][j]==1)
                    cnt++;
            }
            if(cnt%2==0)
                send[i][7]=0;
            else
                send[i][7]=1;    
        }
        for(int i=0;i<8;i++)
        {
            cnt=0;
            for(int j=0;j<4;j++)
            {
                if(send[j][i]==1)
                    cnt++;
            }
            if(cnt%2==0)
                send[4][i]=0;
            else
                send[4][i]=1;
        }
        System.out.println("RECEIVED DATA");
        for(int i=0;i<5;i++)
        {
            cnt=0;
            for(int j=0;j<8;j++)
            {
                rec[i][j]=inp.nextInt();
                if(rec[i][j]==1)
                    cnt++;
            }
            if(cnt%2!=0)
                flag++;
        }
        System.out.println("\nDATA SENT");
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<8;j++)
            {
                System.out.print(send[i][j]);
            }
            System.out.print("  ");
        }
        System.out.println("\nDATA RECEIVED");
        for(int k=0;k<5;k++)
        {
            for(int l=0;l<8;l++)
            {
                System.out.print(rec[k][l]);
            }
            System.out.print("  ");
        }
        if(flag>0)
            System.out.println("\nCORRUPT DATA");
        else
        {
            flag=0;
            for(int i=0;i<8;i++)
            {
                cnt=0;
                for(int j=0;j<5;j++)
                {
                    if(rec[j][i]==1)
                        cnt++;
                }
                if(cnt%2!=0)
                {
                    flag++;
                    break;
                }
            }
            if(flag==0)
                System.out.println("\nCORRECT DATA");
            else
                System.out.println("\nCORRUPT DATA");
        }    
    }
}