package ioc.userMod.controller;

import ioc.userMod.service.UserService;
import ioc.userMod.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Auther Ashen One
 * @Date 2020/12/15
 */




@Controller//不写默认userController
// @Controller("userController")//只有一个参数时默认是value
// @Controller(value = "aaa")//可以自定义


public class UserController {
    @Autowired
    UserService userService;

    public UserController() {
        System.out.println("UserController");
    }

    public void addUser() {
        userService.addUser();
    }
}
