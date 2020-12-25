package day22;

import java.io.*;


/**
 * 把今天的作业文件夹day22_homework下的《我想对你说.txt》字符编码为GBK，
 * 复制到当前项目的testIO文件夹下的《柴老师的话.txt》字符编码为UTF-8
 */
public class HomeWork04 {
    public static void main(String[] args) throws IOException {
        File infile = new File("G:\\迅雷下载\\javaee19年10月毕业班\\javaEE 19年10月毕业班\\01java基础\\day22_全天上课资料\\day22_homework\\我想对你说.txt");
        File outfile = new File("study01\\src\\day21\\柴老师的话.txt");

        FileInputStream fileInputStream = new FileInputStream(infile);
        FileOutputStream fileOutputStream = new FileOutputStream(outfile);

        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        InputStreamReader inputStreamReader=new InputStreamReader(bufferedInputStream,"GBK");
        OutputStreamWriter outputStreamWriter =new OutputStreamWriter(bufferedOutputStream,"utf-8");

        try {
            char[] data =new char[1024];
            int len;
           while ((len=inputStreamReader.read(data))!=-1){
               outputStreamWriter.write(data,0,len);

           }
        } catch (IOException e) {
            e.printStackTrace();

        }finally {
            inputStreamReader.close();
            outputStreamWriter.close();
        }


    }
}
