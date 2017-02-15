package bowler.iplocator;

import javax.swing.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

public class IP extends JFrame {

    public static void main(String[] args) {
        final IP ip = new IP();
        SwingUtilities.invokeLater(() -> ip.setVisible(true));
    }

    public IP() {
        setResizable(false);
        setSize(200, 100);
        setTitle("IP Address");
        // setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        try {
            NetworkInterface ni = NetworkInterface.getNetworkInterfaces().nextElement();
            Enumeration<InetAddress> inetAddresses = ni.getInetAddresses();
            for(InetAddress inetAddress : Collections.list(inetAddresses)) {
                if(inetAddress instanceof Inet4Address) {
                    add(new JLabel(inetAddress.getHostAddress(), SwingConstants.CENTER));
                }
            }
        }
        catch(SocketException se) {
            System.out.println("Uhhhhhhhhhhhhhhh");
        }
    }
}
