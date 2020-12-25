package day22;

/**
 有n步台阶，一次只能上1步或2步，共有多少种走法？ 9 + 8 + 7+ 6 + 5 + 4 + 3 + 2 + 1，
 */
public class HomeWork15 {
    public static void main(String[] args) {
        System.out.println(f(10));
    }
    public static int f(int n) {
        if (n <= 2){
            return n;
        }
        return f(n - 1) + f(n - 2);
    }
}
