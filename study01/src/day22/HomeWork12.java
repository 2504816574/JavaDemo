package day22;


import java.io.*;

/**
 * 实现文件夹的复制
 */
public class HomeWork12 {
    public static void main(String[] args) throws IOException {
        String ori = "G:/学习文件/其他";
        String des = "D:/a";
        CopyFile(ori, des);

    }


    /**
     * @param str  String  原地址
     * @param str2 String  目标地址
     * @throws IOException
     */
    public static void CopyFile(String str, String str2) throws IOException {
        // 用于读取源文件的子目录或子文件
        File file = new File(str);
        // 根据给定的正则表达式拆分源文件。
        String[] s = str.split("/");
        // 获取源文件的最后一个文件并拼接到目标文件
        String str3 = s[s.length - 1];
        String str4 = str2 + "/" + str3;
        // 用于把源文件的子目录或子文件写出到目标文件
        File file2 = new File(str4);
        // 判断源文件是否存在
        if (file.exists()) {
            // 判断源文件是否是目录
            if (file.isDirectory()) {
                // 在目标文件创建该目录
                file2.mkdir();
                // 获取源文件的子目录
                String[] f = file.list();
                for (String ss : f) {
                    // 递归本方法
                    CopyFile(str + "/" + ss, str4);
                }
            } else {
                // 在目标文件创建子文件
                file2.createNewFile();
                // 创建输入流管道
                InputStream input = new FileInputStream(file);
                // 创建输出流管道
                OutputStream output = new FileOutputStream(file2);
                byte[] by = new byte[1024];
                int count = 0;
                // 在源文件读取该文件的数据
                while ((count = input.read(by, 0, by.length)) != -1) {
                    // 在目标文件写入该文件的数据
                    output.write(by, 0, count);
                }
                // 关闭输入流
                input.close();
                // 关闭输出流前强制写出所有输出字节
                output.flush();
                // 关闭输出流
                output.close();
            }
        } else {
            System.out.println("文件不存在！");
        }
    }
}