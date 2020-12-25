package ioc.userMod.service;

import ioc.userMod.dao.UserDao;
import ioc.userMod.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther Ashen One
 * @Date 2020/12/15
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;


    /*@Autowired
    @Qualifier(value="userDaoMybatisImpl")//作用于参数
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/
    public UserServiceImpl() {
        System.out.println("UserServiceImpl");
    }

    @Override
    public void addUser() {
        userDao.addUser();
    }
}
