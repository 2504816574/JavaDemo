package aopxml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther Ashen One
 * @Date 2020/12/17
 */
public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("aop-xml.xml");
        MathI mathImpl = classPathXmlApplicationContext.getBean("mathImpl", MathI.class);
        System.out.println(mathImpl.div(1,1));
    }
}
