package day25;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 1、定义一个函数式接口CurrentTimePrinter,其中抽象方法void printCurrentTime()，使用注解@FunctionalInterface
 * 2、在测试类中定义public static void showLongTime(CurrentTimePrinter timePrinter)，该方法的预期行为是使用timePrinter打印当前系统时间
 * 3、测试showLongTime(),通过lambda表达式完成需求
 * （1）实现一：打印当前系统时间毫秒值，用System. currentTimeMillis()
 * （2）实现二：打印当前系统时间，用Date
 * （3）实现三：打印本地化当前系统时间，用LocalDateTime
 */
public class HomeWork01 {
    public static void main(String[] args) {
        showLongTime(() -> System.out.println(System.currentTimeMillis()));
        showLongTime(() -> System.out.println(new Date()));
        showLongTime(() -> System.out.println(LocalDateTime.now()));



    }

    public static void showLongTime(CurrentTimePrinter timePrinter) {
        timePrinter.printCurrentTime();
    }
}

@FunctionalInterface
interface CurrentTimePrinter {
    void printCurrentTime();
}
