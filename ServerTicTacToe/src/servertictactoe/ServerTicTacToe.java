package servertictactoe;

import java.net.*;
import java.io.*;
import java.lang.*;

public class ServerTicTacToe {

    public static void main(String[] args) {
        try{
            int port;
            port=6003;
            Socket s;
            ServerSocket ss=new ServerSocket(port);
            s=ss.accept();
            System.out.println("Server up!!");
            int board[]=new int[9];
            DataInputStream is=new DataInputStream(s.getInputStream());
            DataInputStream dis=new DataInputStream(s.getInputStream());
            DataOutputStream os=new DataOutputStream(s.getOutputStream());
            char x;
            int y;
            int m=0,n=0;
            x=is.readChar();
            y=dis.readChar();
            for(int i=0;i<8;i++){
                board[i]=0;
            }
            if((board[0]==1 && board[1]==1 && board[2]==1) || 
               (board[0]==1 && board[3]==1 && board[6]==1) || 
               (board[0]==1 && board[4]==1 && board[8]==1) || 
               (board[3]==1 && board[4]==1 && board[5]==1) || 
               (board[6]==1 && board[7]==1 && board[8]==1) || 
               (board[1]==1 && board[4]==1 && board[7]==1) || 
               (board[2]==1 && board[5]==1 && board[8]==1)){
                m=1;
                System.out.println("Player 1 wins!!");
            }
            else if((board[0]==1 && board[1]==1 && board[2]==2) || 
                    (board[0]==1 && board[3]==1 && board[6]==2) || 
                    (board[0]==1 && board[4]==1 && board[8]==2) || 
                    (board[3]==1 && board[4]==1 && board[5]==2) || 
                    (board[6]==1 && board[7]==1 && board[8]==2) || 
                    (board[1]==1 && board[4]==1 && board[7]==2) || 
                    (board[2]==1 && board[5]==1 && board[8]==2)){
                n=1;
                System.out.println("Player 2 wins!!");
            }
            else if(board[0]!=0 && board[1]!=0 && board[2]!=0
                    &&board[3]!=0 && board[4]!=0 && board[5]!=0
                    &&board[6]!=0 && board[7]!=0 && board[8]!=0 && m==0 && n==0){
                System.out.println("Draw");
            }
            if(board[x]!=0){
                System.out.println("Not a valid move");
            }
            else{
                board[x]=y;
                System.out.println("Valid move");
            }
            for(int i=0;i<8;i++){
                if(i==2 || i==5){
                    System.out.print("\n");
                }
                System.out.print(board[i]+ " ");
            }
                            
            
            
            
            
        }
        catch(Exception e){
            System.out.println("Server down");
        }
    }
    
}
