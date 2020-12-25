package day23.demoIO;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Scanner;


/**
 *
 */
public class demo01 {
    /**
     * 印流：输出流
     * （1） Printstream
     * 经典代表：
     * System.out
     * System err
     * <p>
     * new Printstream（文件名)
     * new Printstream（文件名，编码）
     * new Printstream（另一个字节输出流）
     * <p>
     * （2） PrintWriter
     * Web阶段学习时，从服务器端往客户端返回消息时用到 response, response.getWriter（）可以返回 PrintWriter对象。
     * 即Web服务器往客户端（例如：浏览器）返回htm1网页时，用的是 PrintWriter对象的输出方法。
     */
    @Test
    public void test01() throws FileNotFoundException {
        PrintStream printStream = new PrintStream("d:/1.txt");
        printStream.println(4154);
        printStream.println("adasdasdas");
        printStream.close();
    }

    /**
     * System.in：默认情况下是从键盘输入的数据中扫描
     *
     * @throws FileNotFoundException
     */
    @Test
    public void test02() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("d:/1.txt"));
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            System.out.println(s);
        }
        scanner.close();
    }

    @Test
    public void test03() throws FileNotFoundException {
        System.setOut(new PrintStream("d:/1.txt"));
        System.out.println("dasd");
        System.out.println("das");
        System.out.println("dd");
        System.out.println("asd");

    }

    /**
     * NIO
     * 非阻塞式IO
     * Path：类似于Fi1e
     * Paths：工具类，用来创建Path接口的对象
     *
     * @throws FileNotFoundException
     */
    @Test
    public void test04() throws FileNotFoundException {
        Path path = Paths.get("d:", "1.txt");
        int nameCount = path.getNameCount();//路径中有多少级
        Path name = path.getName(0);//获取某一级目录
    }

    /**
     * @throws FileNotFoundException Files
     *                               （1）Files. copy（src, dest, StandardCopyoption.REPLACE EXISTING）；
     *                               （2）delete（Path path）
     *                               功能类似于Fi1e类的 delete（
     *                               不同的地方是会报异常，当文件不存在时deleteIfExists（ Path path）功能相同于Fi1e类的 delete（）存在就删除，不存在就什么也不干
     *                               （3）move（ Path source, Path target, Copyoption.. options)剪切
     */
    @Test
    public void test05() throws IOException {
        Path src = Paths.get("d:", "1.txt");
        Path dest = Paths.get("d:", "2.txt");
        Path copy = Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING);//可以选择复制方法 覆盖...
        System.out.println(copy);
    }

    /**
     * List<string> readAllLines（Pathpath, Charset cs）读取文件
     *
     * @throws IOException
     */
    @Test
    public void test06() throws IOException {
        Path src = Paths.get("d:", "1.txt");
        List<String> list = Files.readAllLines(src, Charset.forName("UTF-8"));//指定编码集
        for (String s : list) {
            System.out.println(s);

        }
    }

}
