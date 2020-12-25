package day22;

import java.io.*;

/**
 * 1、把老师的word笔记文档《第14章 IO流.docx》，复制到当前项目的testIO文件夹下。
 * <p>
 * 2、要求使用缓冲流和文件流一起实现
 */
public class HomeWork03 {
    public static void main(String[] args) throws IOException {

        try (
                BufferedInputStream bf = new BufferedInputStream(new FileInputStream("d:/a.txt"));
                BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream("study01\\src\\day21\\a.txt"))
        ) {
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bf.read(bytes)) != -1) {
                bs.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
