package ioc.datasource;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Auther Ashen One
 * @Date 2020/12/15
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("datasource.xml");
        DataSource datasource = classPathXmlApplicationContext.getBean("datasource", DataSource.class);
        System.out.println(datasource.getConnection());
        classPathXmlApplicationContext.close();
    }
}
