package factory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther Ashen One
 * @Date 2020/12/14
 */
public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("factory-bean.xml");
        Object factory = classPathXmlApplicationContext.getBean("factory");
        System.out.println(factory);
    }
}
