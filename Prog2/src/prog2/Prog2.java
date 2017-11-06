package prog2;
import java.net.*;


public class Prog2 {
    
    public static void main(String[] args){
        try {
            InetAddress ip,ipr;
            ip=InetAddress.getLocalHost();
            System.out.println(ip);
            for(int i=1;i<=1000;i++){
                Socket s;
                try{
                s = new Socket(ip, i);
                System.out.println("Port no. "+i);
                }
                catch(Exception e){
                    System.out.println("Port not connected on "+i);
                }
            }
            ipr=InetAddress.getByName("http://www.google.com");
            System.out.println(ipr);
            for(int i=0;i<=1000;i++){
                try{
                    Socket s1=new Socket(ipr, i);
                    System.out.println("Port no. "+i);
                }
                catch(Exception e){
                    System.out.println("Port not connected on "+i);
                }
            }
            
            
        } catch (UnknownHostException ex) {
            System.out.println("port not responsive");
        }
        
    }

}
