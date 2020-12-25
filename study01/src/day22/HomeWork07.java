package day22;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * 、使用从键盘输入三句话，用PrintStream打印到一个words.txt文件中
 * <p>
 * ​	2、再用Scanner一行一行读取显示
 */
public class HomeWork07 {
    public static void main(String[] args) throws FileNotFoundException {
        test01();
        test02();
    }


    public static void test02() throws FileNotFoundException {
        Scanner scanner=new Scanner(new File("study01\\src\\day21\\words.txt"));
        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }

    public static void test01() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        PrintStream printStream = new PrintStream("study01\\src\\day21\\words.txt");
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入第" + (i + 1) + "句话：");
            String word = scanner.nextLine();
            printStream.println(word);

        }
        printStream.close();
        scanner.close();
    }
}
