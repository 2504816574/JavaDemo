package day25;

/**
 * 1、定义一个函数式接口IntCalc,其中抽象方法int cal(int a , int b)，使用注解@FunctionalInterface
 * 2、在测试类中定义public static void getProduct(int a , int b ,IntCalc tools), 该方法的预期行为打印使用tools的cal(a,b)的计算结果
 * 3、测试getProduct(),通过lambda表达式完成需求，其中a =1,b = 2
 * （1）实现一：求a,b的和
 * （2）实现二：求a,b的差
 * （3）实现三：求a,b的积
 * （4）实现四：求a,b的商
 * （5）实现五：求a,b的按位与
 * （6）实现六：求a<<b
 */
public class HomeWork02 {
    public static void main(String[] args) {
        getProduct(1, 2, (a, b) -> a + b);
        getProduct(1, 2, (a, b) -> a - b);
        getProduct(1, 2, (a, b) -> a * b);
        getProduct(1, 2, (a, b) -> a / b);
        getProduct(1, 2, (a, b) -> a & b);
        getProduct(1, 2, (a, b) -> a << b);
    }

    public static void getProduct(int a, int b, IntCalc tools) {
        System.out.println("结果：" + tools.cal(a, b));
    }
}

@FunctionalInterface
interface IntCalc {
    int cal(int a, int b);
}
