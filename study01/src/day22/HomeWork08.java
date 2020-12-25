package day22;

/**
 *用递归实现不死神兔：故事得从西元1202年说起，话说有一位意大利青年，名叫斐波那契。
 *
 * 在他的一部著作中提出了一个有趣的问题：假设一对刚出生的小兔一个月后就能长成大兔，
 *
 * 再过一个月就能生下一对小兔，并且此后每个月都生一对小兔，没有发生死亡，
 *
 * 问：现有一对刚出生的兔子2年后(24个月)会有多少对兔子?
 */
public class HomeWork08 {
    public static void main(String[] args) {
        int i = method01(24);
        System.out.println(i);
    }


    /**
     *
     * @param n 月份
     * @return 2年后的数量
     *
     * 第一个月  1
     * 第二个月  1
     * 第三个月  1+1  2
     * 第四个月  1+2  3
     * 第五个月  2+3  5
     * 第六个月  3+5  8
     *
     * 第n个月   第n-1天+第n-2天
     */
    private static int method01(int n) {
        if (n==1||n==2){
            return 1;
        }else {
            return method01(n-1)+method01(n-2);
        }


    }
}
