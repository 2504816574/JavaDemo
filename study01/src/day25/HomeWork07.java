package day25;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 *
 */
public class HomeWork07 {
    public static void main(String[] args) {
        //将学生姓名和成绩封装到map中
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        map.put("岑小村", 59);
        map.put("谷天洛", 82);
        map.put("渣渣辉", 98);
        map.put("蓝小月", 65);
        map.put("皮几万", 70);
        Function<Map<String,Integer>, ArrayList<Integer>> function1 = (m) -> {
            ArrayList<Integer> arrayList=new ArrayList<>();
            arrayList.addAll(m.values());
            return arrayList;
        };

        //求Integer类型ArrayList中所有元素的平均数
        Function<ArrayList<Integer>,Double> function2 = (list)->{
            double sum = 0;
            for (Integer i : list) {
                sum+=i;
            }
            return sum/list.size();
        };

        //利用Function求平均成绩
        Double avg = function1.andThen(function2).apply(map);
        System.out.println("学生平均成绩为："+avg);

    }
}
