package day22;


import org.junit.Test;

import java.io.*;

/**
 * 、声明一个Message类，包含：发送者、接收者、消息内容、发送时间
 * <p>
 * ​	2、创建一个Message对象，并写到message.dat文件中，并再次读取显示
 */
public class HomeWork06 {

    @Test
    public void test02() throws IOException, ClassNotFoundException {

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src\\day21\\message.dat"));
        Object object = objectInputStream.readObject();
        System.out.println(object);
        objectInputStream.close();

    }

    public void test01() throws IOException {
        Message message = new Message("张三", "李四", "111", System.currentTimeMillis());
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src\\day21\\message.dat"));
        objectOutputStream.writeObject(message);
        objectOutputStream.close();

        // ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\day21\\message.dat"));
        // oos.writeObject(message);
        // oos.close();
    }

}

class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    private String fromUser;
    private String toUser;

    @Override
    public String toString() {
        return "Message{" +
                "fromUser='" + fromUser + '\'' +
                ", toUser='" + toUser + '\'' +
                ", content='" + content + '\'' +
                ", sendTime=" + sendTime +
                '}';
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getSendTime() {
        return sendTime;
    }

    public void setSendTime(long sendTime) {
        this.sendTime = sendTime;
    }

    private String content;

    public Message(String fromUser, String toUser, String content, long sendTime) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.content = content;
        this.sendTime = sendTime;
    }

    public Message() {
    }

    private long sendTime;
}