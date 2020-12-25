package day23.network.TCP.socket04;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*

 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //1.创建服务器ServerSocket对象和系统要指定的端口号
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(() -> {
                try {
                    File file = new File("d:/server");
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    InputStream inputStream = socket.getInputStream();

                    DataInputStream dataInputStream = new DataInputStream(inputStream);
                    String fileName = dataInputStream.readUTF();
                    long timestamp = System.currentTimeMillis();
                    //.的下标
                    int index = fileName.lastIndexOf(".");
                    //获取后缀名
                    String ext = fileName.substring(index);
                    String name = fileName.substring(0, index);
                    String newFileName = file + "/" + name + timestamp + ext;

                    //5.创建一个本地字节输出流FileOutputStream对象,构造方法中绑定要输出的目的地
                    FileOutputStream fileOutputStream = new FileOutputStream(newFileName);

                    int len;
                    byte[] bytes = new byte[1024];
                    while ((len = inputStream.read(bytes)) != -1) {
                        fileOutputStream.write(bytes, 0, len);
                    }


                    //使用网络字节输出流OutputStream对象中的方法write, 给客户端回写 "上传成功"
                    socket.getOutputStream().write("上传成功".getBytes());
                    fileOutputStream.close();


                } catch (IOException e) {
                    e.printStackTrace();

                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }
}
