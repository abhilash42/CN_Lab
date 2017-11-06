package socket;
import java.net.*;


public class Socket {
    
    public static void main(String[] args){
        try {
            InetAddress ip;
            ip=InetAddress.getLocalHost();
            System.out.println(ip);
            for(int i=1;i<=1000;i++){
                Socket s;
                try{
                s = new Socket(ip, i);
                System.out.print("Port no. "+i);
                }
                catch(Exception e){
                    System.out.println("Port not connected on "+i);
                }
            }   
            
            
        } catch (UnknownHostException ex) {
            System.out.println("port not responsive");
        }
        
    }

    private Socket(InetAddress ip, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
