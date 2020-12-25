import java.util.Arrays;

/**
 *
 */
public class T_00000031 {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i > 0; i--) {
            Arrays.sort(nums,i,len);
            for (int j = i; j < len; j++) {
                if (nums[j]>nums[i-1]){
                    int temp = nums[j];
                    nums[j] = nums[i - 1];
                    nums[i - 1] = temp;
                    return;
                }

            }
        }
        Arrays.sort(nums);
    }


}