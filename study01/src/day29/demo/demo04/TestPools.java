package day29.demo.demo04;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 */
public class TestPools {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        //TestPools.class：得到当前类的Class对象
        //xx.getClassLoader()：获取类加载器对象
        //类加载器对象.getResourceAsStream()：加载资源文件，并且把配置文件中的数据封装到Properties对象
        //这个资源文件格式：key=value
        properties.load(TestPools.class.getClassLoader().getResourceAsStream("druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        //从数据库连接池中拿连接
        for (int i = 1; i <=30; i++) {
            new Thread(i+""){
                @Override
                public void run(){
                    try {
                        Connection conn = dataSource.getConnection();
                        System.out.println("第" + getName() +"个连接：" + conn);

                        Thread.sleep(500);

                        conn.close();//还给它了
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }.start();
        }
        Thread.sleep(100000);
    }
}
