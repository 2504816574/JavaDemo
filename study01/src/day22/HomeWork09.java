package day22;

/**
 * ：猴子吃桃子问题，猴子第一天摘下若干个桃子，当即吃了快一半，还不过瘾，又多吃了一个。第二天又将仅剩下的桃子吃掉了一半，
 * 又多吃了一个。以后每天都吃了前一天剩下的一半多一个。到第十天，只剩下一个桃子。试求第一天共摘了多少桃子？
 */
public class HomeWork09 {
    public static void main(String[] args) {
        int n = method(1);
        System.out.println(n);
    }


    /**
     * @param n 天数
     * @return 总量
     * n个
     * 第一天  x/2 -1
     * 第二天  (x/2 -1)/2 -1
     * <p>
     * 第十天  (f(9))/2 -1 =1
     */

    private static int method(int n) {
        if (n>=10){
            return 1;
        }else {
            return (method(n+1)+1)*2;
        }

    }


}
