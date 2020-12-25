import java.util.*;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 */
public class T_00000349 {


    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                set2.add(i);
            }

        }
        int[] result = new int[set2.size()];
        Iterator it=set2.iterator();
        int i=0;
        while(it.hasNext()){
            result[i]=(Integer)it.next();
            i++;
        }
        return result;


    }
}
