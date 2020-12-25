package ioc.life;

import ioc.scope.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther Ashen One
 * @Date 2020/12/15
 */
public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("life.xml");
        Person person = classPathXmlApplicationContext.getBean("life", Person.class);
        System.out.println(person);
        classPathXmlApplicationContext.close();
    }
}
