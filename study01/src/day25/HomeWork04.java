package day25;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

/**
 * * 打印谷天洛的分数
 * * 打印最高分
 * * 分别以60分和70分为及格线，打印及格的人的名字(组合型消费)
 */
public class HomeWork04 {

    public static <T> void doJob(T t, Consumer<T> consumer) {
        consumer.accept(t);
    }

    public static <T> void doJob(T t, Consumer<T> consumer1, Consumer<T> consumer2) {
        consumer1.andThen(consumer2).accept(t);
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // key:姓名 value:成绩
        map.put("岑小村", 59);
        map.put("谷天洛", 82);
        map.put("渣渣辉", 98);
        map.put("蓝小月", 65);
        map.put("皮几万", 70);


        doJob(map, (m) -> System.out.println(m.get("谷天洛")));

        doJob(map, (m) -> System.out.println(Collections.max(m.values())));
        doJob(map, (m) -> {
            System.out.println("60");
            Set<Map.Entry<String, Integer>> entries = m.entrySet();
            for (Map.Entry<String, Integer> entry : entries) {
                if (entry.getValue() > 60) {
                    System.out.println(entry.getKey());
                }

            }
        }, (m) -> {
            System.out.println("70");
            Set<Map.Entry<String, Integer>> entries = m.entrySet();
            for (Map.Entry<String, Integer> entry : entries) {
                if (entry.getValue() > 70) {
                    System.out.println(entry.getKey());
                }

            }
        });
    }
}
