//CHECKSUM
package aksvat;
import java.io.*;
import java.util.*;
class checksum
{
    public static void main(String args[])
    {
        int k,n,s,flag=0,cy=0;
        Scanner inp=new Scanner(System.in);
        System.out.println("NO. OF UNITS");
        k=inp.nextInt();
        System.out.println("NO. OF BITS PER UNIT");
        n=inp.nextInt();
        int send[][]=new int[k+1][n];
        System.out.println("ENTER DATA");
        for(int i=0;i<k;i++)
        {
            for(int j=0;j<n;j++)
            {
                send[i][j]=inp.nextInt();
            }
        }
        for(int i=n-1;i>=0;i--)
        {
            s=cy;
            for(int j=0;j<k;j++)
            {
                s+=send[j][i];
            }
            if(s%2==0)
            {
                send[k][i]=1;
                cy=s/2;
            }
            else
            {
                send[k][i]=0;
                cy=(s-1)/2;
            }
        }
        System.out.println("DATA SENT");
        for(int i=0;i<k+1;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(send[i][j]);
            }
            System.out.print("  ");
        }
        System.out.println("\nENTER DATA RECEIVED");
        int rec[][]=new int[k+2][n];
        for(int i=0;i<k+1;i++)
        {
            for(int j=0;j<n;j++)
            {
                rec[i][j]=inp.nextInt();
            }
        }
        cy=0;
        for(int i=n-1;i>=0;i--)
        {
            s=cy;
            for(int j=0;j<k+1;j++)
            {
                s+=rec[j][i];
            }
            if(s%2==0)
            {
                rec[k+1][i]=1;
                cy=s/2;
                flag++;
            }
            else
            {
                rec[k+1][i]=0;
                cy=(s-1)/2;
            }
        }
        System.out.println("CHECKED VALUE IN THE END");
        for(int j=0;j<n;j++)
            System.out.print(rec[k+1][j]);
        if(flag==0)
            System.out.println("\nDATA ACCEPTED");
        else
            System.out.println("\nDATA REJECTED");
    }
}