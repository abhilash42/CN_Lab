import java.net.*;
import java.io.*;
import java.util.*;
import static java.lang.System.out;

public class aks002 {

    public static void main(String args[]) throws SocketException {
        int cnt=0;
        Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        for (NetworkInterface netint : Collections.list(nets))
        {
            displayInterfaceInformation(netint);
            cnt++;
        }
           System.out.println("NUMBER IS "+cnt);        
    }

    static void displayInterfaceInformation(NetworkInterface netint) throws SocketException {
        out.printf("Display name: %s\n", netint.getDisplayName());
        out.printf("Name: %s\n", netint.getName());
        Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
        for (InetAddress inetAddress : Collections.list(inetAddresses)) {
            out.printf("InetAddress: %s\n", inetAddress);
        }
        out.printf("\n");
     }
}  