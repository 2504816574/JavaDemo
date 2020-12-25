package aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther Ashen One
 * @Date 2020/12/16
 */
public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("aop.xml");
        MathI mathImpl = classPathXmlApplicationContext.getBean("mathImpl", MathI.class);
        System.out.println(mathImpl.getClass().getName());
        int add = mathImpl.div(1, 1);
        System.out.println(add);

        // TestHandler testHandler = classPathXmlApplicationContext.getBean("testHandler", TestHandler.class);
        //  testHandler.test();
    }

}
