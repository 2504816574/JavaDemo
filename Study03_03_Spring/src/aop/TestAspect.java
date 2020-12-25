package aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Auther Ashen One
 * @Date 2020/12/17
 */
@Component
@Aspect
@Order(0)
public class TestAspect {
    @Before(value = "execution(* aop.*.*(.. ))")
    public void before(){
        System.out.println("TestAspect=>前置通知");

    }
}
