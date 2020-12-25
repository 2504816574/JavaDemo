package until;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 */
public class JDBCToolsV2 {
    private static DataSource dataSource;
    private static ThreadLocal<Connection> connectionThreadLocal;

    static {
        try {
            //静态代码块
            Properties pro = new Properties();
            pro.load(JDBCToolsV2.class.getClassLoader().getResourceAsStream("druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(pro);
            connectionThreadLocal = new ThreadLocal<Connection>();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //抛出编译时异常
    public static Connection getConnection() throws SQLException {
        //方式一：DriverManager.getConnection()
        //方式二：连接池对象.getConnection()
        Connection connection = connectionThreadLocal.get();//获取当前线程中的共享的连接对象
        if (connection != null) {//当前线程没有拿过连接，第一个获取连接
            connection = dataSource.getConnection();//从连接池中拿一个新的
            connectionThreadLocal.set(connection);//放到当前线程共享变量中
        }
        return connection;
    }

    //把编译时异常转为运行时异常
    public static void free(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int update(String sql, Object... args) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
        }
        int i = preparedStatement.executeUpdate();
        preparedStatement.close();
        return i;
    }
}
