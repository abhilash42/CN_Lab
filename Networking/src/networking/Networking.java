package networking;
import java.net.*;

public class Networking {

    public static void main(String[] args) throws UnknownHostException, SocketException {
        InetAddress ob=InetAddress.getLocalHost();
		String hostname=ob.getHostName();
		hostname=ob.getHostName();
		System.out.println("Hostname: "+hostname);
                String ip=ob.getHostAddress();
                System.out.println("IP Address: "+ip);
                InetAddress ob3=InetAddress.getByName("www.google.com");
                System.out.println("IP of remote host: "+ob3);
                byte b[]=new byte[4];
                b[0]=(byte)216;
                b[1]=(byte)58;
                b[2]=(byte)199;
                b[3]=(byte)132;
                InetAddress ob2=InetAddress.getByAddress(b);
                System.out.println("Remote Host name: "+ob2.getHostName());
                InetAddress mac;
                mac=InetAddress.getLocalHost();
                NetworkInterface network=NetworkInterface.getByInetAddress(mac);
                byte[] add = network.getHardwareAddress();
                System.out.print("Current MAC address : ");

		StringBuilder sb;
                sb = new StringBuilder();
		for (int i = 0; i < add.length; i++) {
			sb.append(String.format("%02X%s", add[i], (i < add.length - 1) ? "-" : ""));
		}
		System.out.println(sb.toString());

                
                
    }
    
}
