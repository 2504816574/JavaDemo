package day23.demoIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 */
public class aaa {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(new File("d:/a.txt")));
        PrintStream printStream = new PrintStream("d:/b.txt");
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            printStream.println(s);
        }

    }
}
