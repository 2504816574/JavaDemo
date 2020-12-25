import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 * <p>
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 * <p>
 * 请你返回排序后的数组。
 */
public class T_00001356 {


    public int[] sortByBits(int[] arr) {
        Integer[] integers = new Integer[arr.length];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = arr[i];
        }
        Arrays.sort(integers, ((o1, o2) -> {
            int bitCountA = Integer.bitCount(o1);
            int bitCountB = Integer.bitCount(o2);
            return bitCountA == bitCountB ? o1 - o2 : bitCountA - bitCountB;
        }));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = integers[i];
        }
        return arr;


    }


}
