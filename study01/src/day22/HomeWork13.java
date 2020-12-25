package day22;

import java.io.File;

/**
 * ：删除当前项目的testIO文件夹
 */
public class HomeWork13 {

    public static void main(String[] args) {
        deleteDir(new File("D:\\b"));
    }

    /**
     *
     * @param dir   路径
     */
    public static void deleteDir(File dir) {
        if (dir.isDirectory()) {
            File[] listFiles = dir.listFiles();
            for (File sub : listFiles) {
                deleteDir(sub);
            }
        }
        dir.delete();
    }
}
