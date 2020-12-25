package ioc.life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Auther Ashen One
 * @Date 2020/12/15
 */
public class AfterHandler implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("3,初始化之前");
        Person person = (Person) bean;
        if ("男".equals(person.getSex())){
            person.setName("张男");
        }else {
            person.setName("张女");
        }
        return person;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("5,初始化之后");
        return bean;
    }
}
