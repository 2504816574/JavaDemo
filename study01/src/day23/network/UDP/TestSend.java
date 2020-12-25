package day23.network.UDP;

import java.io.IOException;
import java.net.*;

/**
 *
 */
public class TestSend {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        String s = "傻逼";
        byte[] bytes = s.getBytes();
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length, ip, 9999);
        datagramSocket.send(datagramPacket);
        datagramSocket.close();

    }
}
