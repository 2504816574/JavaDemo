package day22;

import java.io.File;
import java.nio.file.Files;

/**
 *
 */
public class demo01 {
    public static void main(String[] args) {
        File file = new File("G:/迅雷下载/javaee19年10月毕业班/javaEE 19年10月毕业班/01java基础");
        long size = method(file);
        System.out.println(size);
    }

    private static long method(File file) {
        if (file.isFile()) {
            return file.length();

        } else if (file.isDirectory()) {
            long sum = 0;
            File[] files = file.listFiles();
            for (File f : files) {
                sum += method(f);
            }
            return sum;

        } else {
            return 0;
        }
    }
}
