import java.io.*;
import java.util.*;
class javaapplication1
{
    public static void main(String args[])throws IOException
    {
        String u;
        int a,i,j,k,l,ind=0;
        int arr[]=new int[4];
        Scanner inp=new Scanner(System.in);
        String name=inp.next();
        StringTokenizer st=new StringTokenizer(name,".");
        while(st.hasMoreTokens())
        {
            u=st.nextToken();
            a=Integer.parseInt(u);
            arr[ind]=a;
            ind++;
        }
        i=arr[0];
        j=arr[1];
        k=arr[2];
        l=arr[3];
        if(i>=1&&i<=126&&j>=0&&j<=255&&k>=0&&k<=255&&l>=1&&l<=254)
            System.out.println("Class A");
        else if(i>=128&&i<=191&&j>=1&&j<=255&&k>=0&&k<=255&&l>=1&&l<=254)
            System.out.println("Class B");
        else if(i>=192&&i<=223&&j>=0&&j<=255&&k>=1&&k<=254&&l>=1&&l<=254)
            System.out.println("Class C");
        else if(i>=224&&i<=239&&j>=0&&j<=255&&k>=0&&k<=255&&l>=0&&l<=255)
            System.out.println("Class D");
    }
}