/**
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 * <p>
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 */
public class T_00000941 {
    public static void main(String[] args) {
        int[] A = {2, 1};
        boolean b = validMountainArray(A);
        System.out.println(b);
    }

    public static boolean validMountainArray(int[] A) {
        int left = 0;
        int right = A.length - 1;
        while (left + 1 < A.length && A[left] < A[left + 1]) {
            left++;
        }
        while (right > 0 && A[right - 1] > A[right]) {
            right--;
        }
        return left > 0 && right < A.length - 1 && left == right;
    }
}
