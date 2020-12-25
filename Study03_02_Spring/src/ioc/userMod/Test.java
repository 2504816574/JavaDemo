package ioc.userMod;

import ioc.userMod.controller.UserController;
import ioc.userMod.dao.UserDaoImpl;
import ioc.userMod.service.UserService;
import ioc.userMod.service.UserServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther Ashen One
 * @Date 2020/12/15
 */
public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("user.xml");
        UserController userController = classPathXmlApplicationContext.getBean("userController", UserController.class);
        System.out.println(userController);
        UserServiceImpl userService = classPathXmlApplicationContext.getBean("userServiceImpl", UserServiceImpl.class);
        System.out.println(userService);
        UserDaoImpl userDao = classPathXmlApplicationContext.getBean("userDaoImpl", UserDaoImpl.class);
        System.out.println(userDao);
        userController.addUser();
    }
}
