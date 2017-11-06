package hosta;
import java.net.*;
import java.io.*;
public class HostA {

    public static void main(String[] args) {
        try{
            InetAddress ip=InetAddress.getByName("localhost");
            String a[]=new String[8];
            a[0]="First";
            a[1]="Second";
            a[2]="Third";
            a[3]="Fourth";
            a[4]="Fifth";
            a[5]="Sixth";
            a[6]="Seventh";
            a[7]="Ëighth";
            int port = 6001;
            int arr[]=new int[8];
            for(int i=0;i<arr.length;i++){
                arr[i]=0;
            }
            int rand=0;
            int maxWind=4, minWind=0;
            while(arr[rand]!=0){
                rand=(int)(minWind+(Math.random()*(maxWind-minWind)));
            }
            byte b[]=new byte[256];
            DatagramPacket dp=new DatagramPacket(b,4,ip,6001);
            DatagramSocket ss= new DatagramSocket(port);
            ss.send(dp);
            for(int j=0;j<a.length;j++) {
                DatagramPacket d=new DatagramPacket(b,1);
                System.out.println("Acknowledgement no "+b+" received");
            }
        }
        catch(Exception e){
            System.out.println("Sender not responding");
        }
    }
}
