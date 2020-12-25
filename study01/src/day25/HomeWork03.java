package day25;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Random;
import java.util.function.Supplier;

/**
 * 2、分别使用lambda表达式获得以下对象：
 * <p>
 * * 长度为5的String数组
 * * 包含5个1-20(含1和20)之间随机数的HashSet<Integer>集合
 * * 一个代表2018年4月1日的Calendar对象
 */
public class HomeWork03 {

    public static <T> T getObj(Supplier<T> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {
        String[] arr1 = getObj(() -> new String[5]);
        HashSet<Integer> arr2 = getObj(() -> {
            Random random = new Random();
            HashSet<Integer> hashSet = new HashSet<>();
            while (hashSet.size() < 5) {
                hashSet.add(random.nextInt(20) + 1);
            }
            return hashSet;
        });

  /*      Calendar calendar = getObj(() -> {
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, 2018);
            cal.set(Calendar.MONTH, 4);
            cal.set(Calendar.DAY_OF_MONTH, 1);
            return cal;
        });*/

        GregorianCalendar calendar = getObj(() -> new GregorianCalendar(2019,5,13));
        System.out.println(arr1);
        System.out.println(arr2);
        System.out.println(calendar);

    }
}
