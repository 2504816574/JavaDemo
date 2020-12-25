package day22;

import java.io.*;

/**
 *把如下这些数据存放到一个data.dat文件中，并且再次读取显示
 *
 * int a = 10;
 * char c = 'a';
 * double d = 2.5;
 * boolean b = true;
 * String str = "尚硅谷";
 */
public class HomeWork05 {
    public static void main(String[] args) throws IOException {
        File file = new File("study01\\src\\day21\\data.dat");
        DataOutputStream dataOutputStream=new DataOutputStream(new FileOutputStream(file));
        int a = 10;
        char c = 'a';
        double d = 2.5;
        boolean b = true;
        String str = "尚硅谷";

        dataOutputStream.writeInt(a);
        dataOutputStream.writeChar(c);
        dataOutputStream.writeDouble(d);
        dataOutputStream.writeBoolean(b);
        dataOutputStream.writeUTF(str);
        dataOutputStream.close();


        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        System.out.println(dataInputStream.readInt());
        System.out.println(dataInputStream.readChar());
        System.out.println(dataInputStream.readDouble());
        System.out.println(dataInputStream.readBoolean());
        System.out.println(dataInputStream.readUTF());
        dataInputStream.close();

    }
}
