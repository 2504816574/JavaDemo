package day23.network.TCP.socket03;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端一直输入
 * 服务端返回字符串反转
 * 客户端输入bye结束
 * <p>
 * <p>
 * 多个客户端
 */
public class TCPClient03 {
    public static void main(String[] args) throws IOException {
        //1.创建一个客户端对象Socket,构造方法绑定服务器的IP地址和端口号
        Socket socket = new Socket("127.0.0.1", 9999);
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        //PrintStream printStream = new PrintStream(socket.getOutputStream());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while (true) {
            System.out.println("-----------------");
            String s = scanner.nextLine();
            //printStream.println(s);

            bufferedWriter.write(s);
            //bufferedWriter.newLine();
            //bufferedWriter.flush();
            if ("bye".equals(s)) {
                break;
            }
            String result = bufferedReader.readLine();
            System.out.println(result);
        }
        //6.释放资源(Socket)
        scanner.close();
        socket.close();


    }
}
