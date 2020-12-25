package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Auther Ashen One
 * @Date 2020/12/16
 */
@Component
@Aspect//标记当前页面为切面
@Order(1)//定义切面作用的优先级，值越小优先级越高，默认值为int的最大值
public class MyloggerAspect {
    @Pointcut(value = "execution(* aop.*.*(.. ))")
    public void test() {

    }

    /**
     * @Before:将方法指定为前置通知 必须设置value，其值为切入点表达式
     * 前置通知：作用于方法执行之前
     * @Before(value="execution(* aop.*.*(..))")
     * 第一个*代表任意的访问修饰符和返回值类型
     * 第二个*代表任意类
     * 第三个*代表类中任意方法
     * ..代表任意的参数列表
     */
    // @Before(value = "execution(public int MathImpl.add(int ,int ))")
    // @Before(value = "execution(* aop.*.*(.. ))")
    @Before(value = "test()")
    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println("前置通知");
        Object[] args = joinPoint.getArgs();//获取参数
        String name = joinPoint.getSignature().getName();//获取方法名
        System.out.println(name + "------" + Arrays.toString(args));

    }

    /**
     * @After:将方法标注为后置通知 后置通知：作用于方法的finally语句块，即不管有没有异常都会执行
     */
    // @After(value = "execution(* aop.*.*(.. ))")
    @After(value = "test()")
    public void afterMethod(JoinPoint joinPoint) {
        System.out.println("后置通知");

    }

    /**
     * @AfterReturning:将方法标注为返回通知 返回通知：作用于方法执行之后
     * 可通过returning设置接收方法返回值的变量名
     * 要想在方法中使用，必须在方法的形参中设置和变量名相同的参数名的参数
     */
    // @AfterReturning(value = " execution(* aop.*.*(.. ))", returning = "result")
    @AfterReturning(value = " test()", returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        System.out.println("返回通知");
        String methodName = joinPoint.getSignature().getName();
        System.out.println("method:" + methodName + ",result:" + result);
    }

    /**
     * @AfterThrowing:将方法标注为异常通知（例外通知） 异常通知（例外通知）:作用于方法抛出异常时
     * 可通过throwing设置接收方法返回的异常信息
     * 在参数列表中课通过具体的异常类型，来对指定的异常信息进行操作
     */
    //@AfterThrowing(value="execution(* com.atguigu.spring.aop.*.*(..))", throwing="ex")
    // @AfterThrowing(value = " execution(* aop.*.*(.. ))", throwing = "ex")
    @AfterThrowing(value = " test()", throwing = "ex")
    public void afterThrowingMethod(ArithmeticException ex) {
        System.out.println("有异常了，messages：" + ex);
    }

    // @Around(value = "execution(* aop.*.*(..))")
    @Around(value = "test()")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) {

        Object result = null;

        try {
            //前置通知
            System.out.println("环绕通知：前置通知");
            result = joinPoint.proceed();//执行方法
            //返回通知
            System.out.println("环绕通知：返回通知");
            return result;
        } catch (Throwable e) {
            e.printStackTrace();
            //异常通知
            System.out.println("环绕通知：异常通知");
        } finally {
            //后置通知
            System.out.println("环绕通知：后置通知");
        }

        return -1;
    }


}
