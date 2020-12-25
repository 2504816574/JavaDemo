package day23.network;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Java.net. InetAddress：用来包装工P地址对象的InetAddress有两个子类：
 * Inet4Address、Inet6Address
 * <p>
 * <p>
 * （1）InetAddress getLocalHost（）
 * 2）InetAddress.getByName（"Www.baIdu.com"）
 * （3）InetAddress getBy Address（addr）
 */
public class demo01 {
    /**
     * @throws UnknownHostException
     */
    @Test
    public void test03() throws UnknownHostException {
        byte[] address = {(byte) 192, (byte) 168, (byte) 0, (byte) 0};
        InetAddress byName = InetAddress.getByAddress(address);
        System.out.println(byName);
    }

    /**
     * 获取IP地址值
     *
     * @throws UnknownHostException
     */
    @Test
    public void test02() throws UnknownHostException {
        InetAddress byName = InetAddress.getByName("www.baidu.com");
        System.out.println(byName);
    }

    /**
     * 获取本地地址
     *
     * @throws UnknownHostException
     */
    @Test
    public void test01() throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
    }
}
