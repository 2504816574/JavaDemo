package day23.network.TCP.socket05;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 */
public class TCPServer {
    private static ArrayList<Socket> onlineList = new ArrayList<Socket>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            while (true) {
                Socket accept = serverSocket.accept();
                onlineList.add(accept);
                //每一个客户端独立的线程
                MessageHandler mh = new MessageHandler(accept);
                mh.start();

            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("服务器炸了");
        }

    }

    private static class MessageHandler extends Thread {
        private Socket socket;
        private String ip;

        public MessageHandler(Socket socket) {
            this.socket = socket;
            this.ip = socket.getInetAddress().getHostAddress();
        }

        @Override
        public void run() {
            sendToOthers(ip + "上线了");
            try {
                InputStream inputStream = socket.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String count;
                while ((count = bufferedReader.readLine()) != null) {
                    if ("-1".equals(count)) {
                        //给自己发一句bye
                        OutputStream out = socket.getOutputStream();
                        PrintStream ps = new PrintStream(out);
                        ps.println("-1");

                        break;
                    }
                    sendToOthers(ip + ":" + count);
                }
                sendToOthers(ip + "下线了");
            } catch (IOException e) {
                sendToOthers(ip + "掉线了");
            }

        }

        //因为转发的代码也很长，独立为一个方法
        private void sendToOthers(String str) {
            Iterator<Socket> iterator = onlineList.iterator();
            while (iterator.hasNext()) {
                Socket next = iterator.next();
                if (!next.equals(socket)) {//只给其他客户端转发
                    try {
                        OutputStream outputStream = next.getOutputStream();
                        PrintStream printStream = new PrintStream(outputStream);
                        printStream.println(str);
                    } catch (IOException e) {
                        onlineList.remove(next);//此人不在线
                    }

                }
            }
        }

    }
}
