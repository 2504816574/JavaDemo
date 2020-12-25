package day29.demo.demo03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 事务：
 *
 * 需求：
 *   删除某个订单
 *   （1）删除订单表的记录
 *   （2）删除订单明细表的记录
 *
 *   如果在订单明细表建立外键时  指定on delete cascade，那么在删除订单时，会自动把对应的订单明细表的记录删除。
 *   如果没有建立外键，那么那么在删除订单时，不会自动对应的订单明细表的记录。那么就需要程序员，再编写对应的sql去删除订单明细表的记录。
 *
 *   假设，现在要删除“15294258455691”的订单
 *
 * 如何处理事务？
 * （1）在获取完连接后，在使用这个连接来创建PreparedStatement对象之前，要设置当前连接为手动提交事务
 *  conn.setAutoCommit(false);
 *
 * （2）在执行成功时，应该提交  conn.commit();
 *     在执行失败或异常时，应该回滚  conn.rollback();
 *
 * （3）在关闭连接之前，把手动提交模式修改重新修改为自动提交模式
 * 因为你后面获取的连接基本上是从数据库连接池中获取的连接，这种连接是“重复”使用的，那么如果你把它修改为“手动”提交了，
 * 然后没有“还原”，当你把这个连接还给连接池时，这个连接可能会被其他人拿到，而他以为是自动提交的，然后操作完它的sql后，没有commit，结果是没有生效。
 * conn.setAutoCommit(true);
 */
public class TestTransaction {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //1、注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2、获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql:///mysql-study", "root", "root");
        //3、编写sql
        String sql = "INSERT INTO t_department VALUES(NULL,?,?)";

        //3、编写sql
        //删除订单表
        String sql1 = "DELETE FROM orders WHERE id = ?";
        String sql2 = "DELETE FROM order_items where order_id = ?";//故意把这条sql写错，使得sql2执行失败，这里故意省略where

        //4，创建PreparedStatement
        PreparedStatement pst1 = connection.prepareStatement(sql1);
        pst1.setObject(1, "15275760194821");

        PreparedStatement pst2 = connection.prepareStatement(sql2);
        pst2.setObject(1, "15275760194821");

        //5、执行sql
        boolean flag = true;//假设成功
        try {
            int len1 = pst1.executeUpdate();

            if(!(len1 > 0)){
                flag = false;
            }

            if(flag){
                int len2 = pst2.executeUpdate();
                if(!(len2>0) ){
                    flag = false;
                }
            }

            if(flag){
                System.out.println("成功了");
                connection.commit();
            }else{
                System.out.println("失败了");
                connection.rollback();
            }
        } catch (Exception e) {
            System.out.println("异常了");
            connection.rollback();
        }


        //6、关闭
        pst1.close();
        pst2.close();
        connection.setAutoCommit(true);//好的习惯
        connection.close();

    }
}
