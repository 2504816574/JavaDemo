package day25;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 学生类:
 * （1）成员变量 姓名：String name;
 * （2）成员变量 成绩：int score；
 * （3）无参及全参构造
 * （4）重写toString()
 * <p>
 * 2、在测试类中完成如下要求
 * （1）将五名学生添加到ArrayList集合
 * （2）使用Collections.sort(List<T> list, Comparator<? super T> c)方法将学生成绩从小到大进行排序，分别使用以下三种形式实现：
 * a、使用匿名内部类
 * b、使用Lambda表达式
 * c、使用方法引用	//tips:借助Comparator接口中静态方法comparingInt()方法
 */
public class HomeWork05 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("谢霆锋", 85));
        list.add(new Student("章子怡", 63));
        list.add(new Student("刘亦菲", 77));
        list.add(new Student("黄晓明", 33));
        list.add(new Student("岑小村", 92));
        //使用匿名内部类将成绩从小到大排序
  /*      Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getSource() - o2.getSource();
            }
        });*/
        // 使用Lambda为英语成绩从小到大排序
        Collections.sort(list, (o1, o2) -> o1.getSource()-o2.getSource());

        // 借助comparingInt()使用方法引用
        Collections.sort(list, Comparator.comparingInt(Student::getSource));
    }
}

class Student {
    private String name;

    public Student(String s) {
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", source=" + source +
                '}';
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public Student(String name, int source) {
        this.name = name;
        this.source = source;
    }

    private int source;
}