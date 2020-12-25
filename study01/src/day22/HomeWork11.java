package day22;

import java.io.File;

/**
 * 统计《尚硅谷_190513班_柴林燕_JavaSE》文件夹大小
 */
public class HomeWork11 {
    public static void main(String[] args) {
        File file = new File("F:\\IdeaProjects");
        long size = getsize(file);
        System.out.println(size);
    }

    private static long getsize(File file) {
        if (file.isFile()) {
            return file.length();
        } else if (file.isDirectory()) {
            File[] files = file.listFiles();
            long sum = 0L;
            for (File f : files) {
                sum += getsize(f);

            }
            return sum;
        }
        return 0;
    }
}
