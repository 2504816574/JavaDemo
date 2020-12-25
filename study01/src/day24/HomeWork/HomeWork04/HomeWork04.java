package day24.HomeWork.HomeWork04;

import javax.xml.bind.Element;
import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * 在测试类Test04中，通过反射，获取User类以及每一个属性声明的注解，并获取注解值
 */
public class HomeWork04 {
    public static void main(String[] args) {
        Class user = User.class;
        Table table = (Table) user.getAnnotation(Table.class);
        String value = table.value();
        System.out.println("User类对应数据库表：" + value);

        Field[] declaredFields = user.getDeclaredFields();
        for (Field d : declaredFields) {
            Column column = d.getAnnotation(Column.class);
            String name = column.name();
            String type = column.type();
            System.out.println(d.getName() + "属性对应数据库表的字段：" + name + "，类型：" + type);


        }
    }

}

/**
 * 1、声明自定义注解@Table
 * <p>
 * （1）加上String类型的配置参数value
 * <p>
 * （2）并限定@Table的使用位置为类上
 * <p>
 * （3）并指定生命周期为“运行时”
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Table {
    String value();
}

/**
 * 2、声明自定义注解@Column
 * <p>
 * 1）加上String类型的配置参数name，表示表格的列名
 * <p>
 * 2）加上String类型的配置参数type，表示表格的列数据类型
 * <p>
 * 3）并限定@Column的使用位置在属性上
 * <p>
 * 4）并指定生命周期为“运行时”
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Column {
    String name();

    String type();
}

/**
 * 3、声明User类，
 * <p>
 * （1）属性：id, username, password, email
 * <p>
 * （2）在User类上，标记@Table注解，并为value赋值为"t_user"
 * <p>
 * （3）在User类的每一个属性上标记@Column，并为name和type赋值，例如：
 * <p>
 * id：name赋值为no，type赋值为int
 * <p>
 * username：name赋值为username，type赋值为varchar(20)
 * <p>
 * password：name赋值为pwd，type赋值为char(6)
 * <p>
 * email：name赋值为email，type赋值为varchar(50)
 */
@Table("t_user")
class User {
    @Column(name = "no", type = "int")
    private int name;
    @Column(name = "username", type = "varchar(20)")
    private String username;
    @Column(name = "pwd", type = "char(6)")
    private char password;
    @Column(name = "email", type = "varchar(50)")
    private String email;

    @Override
    public String toString() {
        return "User{" +
                "name=" + name +
                ", username='" + username + '\'' +
                ", password=" + password +
                ", email='" + email + '\'' +
                '}';
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char getPassword() {
        return password;
    }

    public void setPassword(char password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {
    }

    public User(int name, String username, char password, String email) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
