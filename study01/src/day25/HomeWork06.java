package day25;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 1、声明一个员工类型Employee，包含编号、姓名、薪资、年龄、性别
 * 2、声明一个员工管理类，
 * （1）管理类中使用ArrayList，来存储所有员工对象
 * （2）声明public void add(Employee emp)方法，添加员工
 * （3）声明public ArrayList get(Predicate<Employee> p)方法，可以根据条件筛选出符合要求的员工
 * （4）声明public void remove(Predicate<Employee> p)方法，可以根据条件删除
 * （5）声明public void update(Consumer<Employee> c)方法，对集合中的元素执行c指定的操作
 * 3、在测试类
 * （1）添加5个员工对象到管理的集合中
 * （2）筛选出
 * ①编号是偶数的员工
 * ②薪资低于10000的员工
 * ③年龄大于30岁的女员工
 * ④姓张的员工
 * ⑤所有员工
 * （3）删除
 * ①年龄大于30岁的女员工
 * ②删除“张三”这个员工
 * （4）给每个员工涨薪10%
 */
public class HomeWork06 {
    EmployeeService employeeService = new EmployeeService();

    @Before
    public void getEmployee() {
        employeeService.add(new Employee(1, "张三", 8000, 23, '男'));
        employeeService.add(new Employee(2, "王小二", 12000, 22, '男'));
        employeeService.add(new Employee(3, "李四", 12000, 24, '女'));
        employeeService.add(new Employee(4, "王五", 11000, 34, '女'));
        employeeService.add(new Employee(5, "赵六", 6000, 34, '女'));
    }


    @Test
    public void method01() {
        ArrayList<Employee> list1 = employeeService.get(employee -> employee.getId() % 2 == 0);
        System.out.println(list1);
        ArrayList<Employee> list2 = employeeService.get(employee -> employee.getSalary() < 10000);
        System.out.println(list2);
        ArrayList<Employee> list3 = employeeService.get(employee -> employee.getName().startsWith("张"));
        System.out.println(list3);
        ArrayList<Employee> list4 = employeeService.get(employee -> true);
        System.out.println(list4);

    }

    @Test
    public void method02() {
        employeeService.remove(employee -> employee.getGender() == '女' && employee.getAge() > 30);
        employeeService.printEmployee();
        employeeService.remove(employee -> employee.getName() == "张三");
        employeeService.printEmployee();
    }

    @Test
    public void method03() {
        employeeService.update(employee -> employee.setSalary(employee.getSalary()*1.1));
        employeeService.printEmployee();
    }
}

class Employee {
    public Employee() {
    }

    private int id;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    private String name;

    public Employee(int id, String name, double salary, int age, char gender) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.gender = gender;
    }

    private double salary;
    private int age;
    private char gender;
}

class EmployeeService {
    public EmployeeService(ArrayList<Employee> list) {
        this.list = list;
    }

    private ArrayList<Employee> list = new ArrayList<>();

    public EmployeeService() {
    }

    //添加员工
    public void add(Employee emp) {
        list.add(emp);

    }

    //可以根据条件筛选出符合要求的员工
    public ArrayList get(Predicate<Employee> p) {
        ArrayList<Employee> arrayList = new ArrayList<>();
        for (Employee employee : list) {
            if (p.test(employee)) {
                arrayList.add(employee);
            }

        }
        return arrayList;

    }

    //方法，可以根据条件删除
    public void remove(Predicate<Employee> p) {
        Iterator<Employee> iterator = list.iterator();
        while (iterator.hasNext()) {
            Employee next = iterator.next();
            if (p.test(next)) {
                iterator.remove();
            }
        }

    }

    public void printEmployee() {
        System.out.println(list);
    }

    //对集合中的元素执行c指定的操作
    public void update(Consumer<Employee> c) {

        for (Employee employee : list) {
            c.accept(employee);
        }

    }
}