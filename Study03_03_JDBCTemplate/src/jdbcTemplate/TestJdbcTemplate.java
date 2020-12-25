package jdbcTemplate;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

/**
 * @Auther Ashen One
 * @Date 2020/12/17
 */
public class TestJdbcTemplate {
    ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("jdbc.xml");
    JdbcTemplate jdbcTemplate = classPathXmlApplicationContext.getBean("jdbcTemplate", JdbcTemplate.class);

    @Test
    public void testUpdate() {
        // jdbcTemplate.update("insert into users values(null ,'test02','12345','11@qq.com',1) ");

        // 增
/*        String sql = "insert into users values(null ,?,?,?,?) ";
        int update = jdbcTemplate.update(sql, "test03", "12345", "t3@qq.com", 1);
        System.out.println(update);*/

        //删
/*        String ids = "3,4,5,6";
        String sql = "delete from users where id in("+ids+")";
        int update = jdbcTemplate.update(sql);
        System.out.println(update );*/


        //模糊查询
        // String sql = "select * from users where email like '%?%'";//不能使用
        String sql = "select * from users where email like concat('%',?,'%')";
        Object[] mohu ={"t"};
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, mohu);
        for (Map<String, Object> map : maps) {
            Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<String, Object> next = iterator.next();
                System.out.println(next.getKey()+"----"+next.getValue());
            }
        }
    }

    @Test
    public void testBathUpdate() {
        String sql = "insert into users values(null ,?,?,?,?) ";
        ArrayList<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"test04", "12345", "t4@qq.com", 0});
        list.add(new Object[]{"test05", "12345", "t5@qq.com", 0});
        list.add(new Object[]{"test06", "12345", "t6@qq.com", 0});
        list.add(new Object[]{"test07", "12345", "t7@qq.com", 0});
        int[] ints = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(ints));
    }
    @Test
    public void testQueryForObject(){
        //jdbcTemplate.queryForObject(sql, requiredType)用来获取单个的值
        //jdbcTemplate.queryForObject(sql, rowMapper)用来获取单条数据
 /*       String sql = "select * from users where id = ?";
        RowMapper<jdbcTemplate.User> rowMapper = new BeanPropertyRowMapper<>(jdbcTemplate.User.class);
        jdbcTemplate.User user = jdbcTemplate.queryForObject(sql, new Object[]{1}, rowMapper);//将列名（字段名或字段名的别名）与属性名进行映射
        System.out.println(user);*/


        String sql = "select count(*) from users";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }

    @Test
    public void testQuery(){
        String sql="select * from users ";
        BeanPropertyRowMapper<User> userBeanPropertyRowMapper = new BeanPropertyRowMapper<>(User.class);
        List<User> query = jdbcTemplate.query(sql, userBeanPropertyRowMapper);
        for (User user : query) {
            System.out.println(user);

        }
    }
}
