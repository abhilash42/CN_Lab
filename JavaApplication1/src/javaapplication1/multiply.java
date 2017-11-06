import java.io.*;
import java.util.*;
class multiply
{
    public static void main(String args[])
    {
        Scanner inp=new Scanner(System.in);
        int arr[][]=new int[3][3];
        int ans[][]=new int[3][3];
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                arr[i][j]=inp.nextInt();
            }
        }
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                for(int k=i;k<=j;k++)
                {
                    ans[i][j]*=
                }
            }
        }
    }
}