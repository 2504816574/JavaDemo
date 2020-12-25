import java.util.*;

/**
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * <p>
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 * <p>
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 */
public class T_00001207 {
    public static void main(String[] args) {


    }


    /**
     * @param arr int[] 一个整数数组
     * @return 是否是独一无二的
     */
    public boolean uniqueOccurrences(int[] arr) {
        if (arr == null || arr.length == 0) {
            return true;
        }
        //数组前半部分存储负数，后半部分存储非负数，记录出现次数
        int[] nums = new int[2001];
        for (int i = 0; i < arr.length; i++) {
            nums[arr[i]+1000]++;

        }
        //利用HashSet不能存重复数据进行判断
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                if (!hashSet.add(num)) {
                    return false;
                }
            }
        }
        return true;

    }
}


