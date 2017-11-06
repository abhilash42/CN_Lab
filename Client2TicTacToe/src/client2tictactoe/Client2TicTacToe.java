package client2tictactoe;

import java.net.*;
import java.io.*;

public class Client2TicTacToe {

    public static void main(String[] args) {
        try{
            char s3='2';
        int s4;
        Socket s0=new Socket("127.0.0.1",6003);
        DataInputStream inFromUser = new DataInputStream(s0.getInputStream());
        DataOutputStream outToServer = new DataOutputStream(s0.getOutputStream());
        BufferedReader x = new BufferedReader(new InputStreamReader(s0.getInputStream()));
        s3=inFromUser.readChar();
        outToServer.writeBytes(s3+"\n");
        int rand=0;
            int max=8, min=0;
            while(rand!=0){
                rand=(int)(min+(Math.random()*(max-min)));
            }
        s4=rand;
        outToServer.write(s3);
        outToServer.write(s4);
        }
        catch(Exception e){
            System.out.println("Server not responding");
    }
    
}
}
