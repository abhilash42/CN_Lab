package mainserver;
import java.net.*;
import java.io.*;
public class MainServer {

    public static void main(String[] args) throws IOException{
        String ques[]=new String[5];
        String opt0[]=new String[4];
        String opt1[]=new String[4];
        String opt2[]=new String[4];
        String opt3[]=new String[4];
        String opt4[]=new String[4];
        String correct[]=new String[5];
        ques[0]="Which cartoon character is shown as a scientist?";
        ques[1]="Which year was the movie 'Deathnote' released based on the anime 'Deathnote'?";
        ques[2]="Which year was the game of chess formulated for computer systems?";
        ques[3]="Which incident in the history of America made a huge impact on the American Revolution where people threw tea crates in the sea?";
        ques[4]="Who is the present Vice President of India?";
        opt0[0]="Johnny Bravo";
        opt0[1]="Dexter";
        opt0[2]="Bugs Bunny";
        opt0[3]="Shaggy";
        opt1[0]="2013";
        opt1[1]="2015";
        opt1[2]="2017";
        opt1[3]="2012";
        opt2[0]="1960";
        opt2[1]="1984";
        opt2[2]="1965";
        opt2[3]="1976";
        opt3[0]="The Boston Tea Party";
        opt3[1]="The Washington Tea Party";
        opt3[2]="The New York Tea Party";
        opt3[3]="The Detroit Tea Party";
        opt4[0]="L.K. Advani";
        opt4[1]="Rajnath Singh";
        opt4[2]="Sushma Swaraj";
        opt4[3]="M. Venkaiyah Naidu";
        correct[0]=opt0[1];
        correct[1]=opt1[2];
        correct[2]=opt2[2];
        correct[3]=opt3[0];
        correct[4]=opt4[3];
        String question1[]=new String[5];
        String question2[]=new String[5];
        String question3[]=new String[5];
        String question4[]=new String[5];
        String question5[]=new String[5];
        question1[0]=ques[0];
        question1[1]=opt0[0];
        question1[2]=opt0[1];
        question1[3]=opt0[2];
        question1[4]=opt0[3];
        question2[0]=ques[1];
        question2[1]=opt1[0];
        question2[2]=opt1[1];
        question2[3]=opt1[2];
        question2[4]=opt1[3];
        question3[0]=ques[2];
        question3[1]=opt2[0];
        question3[2]=opt2[1];
        question3[3]=opt2[2];
        question3[4]=opt2[3];
        question4[0]=ques[3];
        question4[1]=opt3[0];
        question4[2]=opt3[1];
        question4[3]=opt3[2];
        question4[4]=opt3[3];
        question5[0]=ques[4];
        question5[1]=opt4[0];
        question5[2]=opt4[1];
        question5[3]=opt4[2];
        question5[4]=opt4[3];
        byte b[]=new byte[5];
        b[0]=127;
        b[1]=0;
        b[2]=0;
        b[3]=1;
        InetAddress ip=InetAddress.getByName("localhost");
        ServerSocket ss=new ServerSocket(6001);
        Socket s=new Socket();
        System.out.println("Server up. ready for the questions...");
        s=ss.accept();
        MulticastSocket ms=new MulticastSocket(6001);
        ms.joinGroup(ip);
        ms.connect(ip, 6001);
        
        
        
    }
    
}
