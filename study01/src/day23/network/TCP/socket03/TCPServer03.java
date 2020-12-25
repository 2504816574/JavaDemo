package day23.network.TCP.socket03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 */
public class TCPServer03 {
    public static void main(String[] args) throws IOException {
        //1.创建服务器ServerSocket对象和系统要指定的端口号
        ServerSocket serverSocket = new ServerSocket(9999);
        boolean flag = true;

        while (flag) {
            //2.使用ServerSocket对象中的方法accept,获取到请求的客户端对象Socket
            Socket socket = serverSocket.accept();
            MyThread myThread = new MyThread(socket);
            myThread.start();
        }


        //7.释放资源(Socket,ServerSocket)
        serverSocket.close();
    }
}

class MyThread extends Thread {
    private Socket socket;

    public MyThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //3.使用Socket对象中的方法getInputStream()获取网络字节输入流InputStream对象
            InputStream inputStream = socket.getInputStream();
            //将字节流转为字符流
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            //利用BufferedReader进行换行读取
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            //为返回到客户端做准备
            OutputStream outputStream = socket.getOutputStream();
            PrintStream printStream = new PrintStream(outputStream);

            // OutputStreamWriter writer = new OutputStreamWriter(outputStream);
            // BufferedWriter bufferedWriter=new BufferedWriter(writer);
            String word;
            while ((word = bufferedReader.readLine()) != null) {
                //读取到bye 退出
                if ("bye".equals(word)) {
                    break;
                }
                //利用StringBuilder的reverse方法进行反转
                StringBuilder stringBuilder = new StringBuilder(word);
                stringBuilder.reverse();
                printStream.println(stringBuilder.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}