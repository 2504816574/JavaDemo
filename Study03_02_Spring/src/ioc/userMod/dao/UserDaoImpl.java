package ioc.userMod.dao;

import org.springframework.stereotype.Repository;

/**
 * @Auther Ashen One
 * @Date 2020/12/15
 */
@Repository
public class UserDaoImpl implements UserDao{
    public UserDaoImpl() {
        System.out.println("UserDaoImpl");
    }

    @Override
    public void addUser() {
        System.out.println("添加成功");
    }
}
