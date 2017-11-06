package client1tictactoe;

import java.net.*;
import java.io.*;

public class Client1TicTacToe {

    public static void main(String[] args) {
        try{
        char s1='1';
        int s2;
        Socket s0=new Socket("127.0.0.1",6003);
        DataInputStream inFromUser = new DataInputStream(s0.getInputStream());
        DataOutputStream outToServer = new DataOutputStream(s0.getOutputStream());
        BufferedReader x = new BufferedReader(new InputStreamReader(s0.getInputStream()));
        s1=inFromUser.readChar();
        outToServer.writeBytes(s1+"\n");
        int rand=0;
            int max=8, min=0;
            while(rand!=0){
                rand=(int)(min+(Math.random()*(max-min)));
            }
        s2=rand;
        outToServer.write(s1);
        outToServer.write(s2);
        }
        catch(Exception e){
            System.out.println("Server not responding");
        }
    }
    
}
