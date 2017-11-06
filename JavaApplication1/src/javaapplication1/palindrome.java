import java.io.*;
import java.util.*;
class palindrome
{
    public static void main(String args[])
    {
        String s;
        int flag=0;
        Scanner inp=new Scanner(System.in);
        s=inp.nextLine();
        for(int i=0,j=s.length()-1;i<s.length()/2;i++,j--)
        {
            if(s.charAt(i)!=s.charAt(j))
            {
                flag++;
                break;
            }
        }
         if(flag==1)
             System.out.println("NOT PALINDROME");
         else 
             System.out.println("PALINDROME");
        
    }
}