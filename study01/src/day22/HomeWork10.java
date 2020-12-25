package day22;


import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

/**
 * ：获取D盘atguigu文件夹下所有的.java文件
 * <p>
 * （1）不包含子文件夹
 * <p>
 * （2）包含子文件夹
 */
public class HomeWork10 {


    /**
     * 不包含子文件夹中的
     */
    @Test
    public void method01() {
        File file = new File("F:\\IdeaProjects\\shangguigu\\study01\\src\\day21");
        File[] files = file.listFiles(pathname -> pathname.getName().endsWith(".java"));
        for (File f : files) {
            System.out.println(f);

        }
    }

    @Test
    public void method02_demo() {
        File file = new File("F:\\IdeaProjects\\JavaDemo");
        ArrayList<String> all = method02(file);
        for (String string : all) {
            System.out.println(string);
        }

    }
    public ArrayList<String> method02(File file){
        ArrayList<String> arr=new ArrayList<>();
        if (file.isFile()){
            if (file.getName().endsWith(".java")){
                arr.add(file.getPath());
            }
        }else if (file.isDirectory()){
            File[] listFiles = file.listFiles();
            for (File listFile : listFiles) {
            arr.addAll(method02(listFile));

            }
        }
        return arr;
    }

}
