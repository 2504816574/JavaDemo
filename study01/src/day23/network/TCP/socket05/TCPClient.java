package day23.network.TCP.socket05;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 群聊
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        //1、连接服务器
        Socket socket = new Socket("127.0.0.1", 9999);

        //2、开启两个线程，一个收消息，一个发消息
        SendThread st = new SendThread(socket);
        ReceiveThread rt = new ReceiveThread(socket);

        st.start();
        rt.start();
        //等发送线程停下来再往下走
        try {
            st.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //让接收数据的线程停下
        rt.setFlag(false);

        //等接收线程停下来，再往下走，断开连接
        try {
            rt.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        socket.close();
    }
}

class SendThread extends Thread {
    private Socket socket;

    public SendThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            OutputStream outputStream = socket.getOutputStream();
            PrintStream printStream = new PrintStream(outputStream);
            while (true) {
                 //System.out.println("输入发送的信息");
                String s = scanner.nextLine();
                //System.out.println(s);
                System.out.println("----------------------------------");

                printStream.println(s);
                if ("-1".equals(s)) {
                    break;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ReceiveThread extends Thread {
    private Socket socket;
    private boolean flag = true;

    public ReceiveThread(Socket socket) {
        this.socket = socket;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (flag) {
                String s = bufferedReader.readLine();
                System.out.println(s);
                System.out.println("----------------------------------------");
                if ("-1".equals(s)) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}