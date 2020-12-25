package day23.network.TCP.socket04;


import java.io.*;
import java.net.Socket;

/*
文件上传
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        //1.创建一个客户端对象Socket,构造方法绑定服务器的IP地址和端口号
        Socket socket = new Socket("192.168.1.166", 9696);
        File file = new File("F:\\Linux\\CentOS-7-x86_64-DVD-1810.iso");
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        //发送“文件名.后缀名"
        dataOutputStream.writeUTF(file.getName());
        FileInputStream fileInputStream = new FileInputStream(file);
        int len;
        byte[] bytes = new byte[1024];
        while ((len = fileInputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }

        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        while ((len = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }

        socket.close();
        fileInputStream.close();

    }
}
