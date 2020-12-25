package aop;

import org.springframework.stereotype.Component;

/**
 * @Auther Ashen One
 * @Date 2020/12/17
 */
@Component
public class TestHandler {
    public void test(){
        System.out.println("切入点测试");
    }
}
