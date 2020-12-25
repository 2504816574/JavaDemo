package mod;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther Ashen One
 * @Date 2020/12/14
 */
public class TestBySpring {
    public static void main(String[] args) {
        //初始化容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取对象
        //方法一：通过id获取
        // Person person = (Person) applicationContext.getBean("person");


        //方法二：通过对象的类型获取
        //使用此方法获取对象时，要求 spring所管理的此类型的对象只能有一个
        // Person person = applicationContext.getBean(Person.class);

        //方法三：通过id和类型获取
        Person person = applicationContext.getBean("person1", Person.class);
        System.out.println(person);
        applicationContext.close();

    }
}
