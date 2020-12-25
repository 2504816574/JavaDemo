import java.util.ArrayList;

/**
 *
 */
public class T_00000057 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];//插入数组左端点
        int right = newInterval[1];//插入数组右端点
        boolean is_placed=false;//是否
        ArrayList<int[]> ints = new ArrayList<>();
        for (int[] interval : intervals) {
            int left_temp = interval[0];//临时数组左端点
            int right_temp = interval[1];//临时数组右端点
            if(left_temp>right){//在要插入的区间左边且无交集
                if (!is_placed){
                    ints.add(new int[]{left,right});
                    is_placed=true;
                }
                ints.add(interval);
            }else if(right_temp<left){////在要插入的区间右边且无交集
                ints.add(interval);
            }else {//有交集找并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if(!is_placed){
            ints.add(new int[]{left, right});
        }
        int[][] final_intervals = new int[ints.size()][2];
        for (int i = 0; i < ints.size(); ++i) {
            final_intervals[i] = ints.get(i);
        }
        return final_intervals;


    }

}
