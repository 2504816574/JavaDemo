package day23.network.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


/**
 *
 */
public class TestReceive {
    public static void main(String[] args) throws IOException {
        //1、接收方也要socket
        //接收方的端口号，指定，IP自动获取
        DatagramSocket ds = new DatagramSocket(9999);

        //2、准备一个数据报，接收数据
        byte[] data = new byte[1024];
        DatagramPacket dp = new DatagramPacket(data, data.length);

        //3、接收数据
        ds.receive(dp);

        //4、把数据拆解出来
        byte[] bs = dp.getData();//接收的数据
        int len = dp.getLength();//接收的数据的实际长度
        System.out.println(new String(bs, 0, len));

        //5、断开
        ds.close();

    }
}
