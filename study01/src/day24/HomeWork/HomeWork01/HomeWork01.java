package day24.HomeWork.HomeWork01;


import org.junit.Test;

import java.lang.reflect.*;
import java.util.Arrays;

/**
 *
 */
public class HomeWork01 {
    Class c = School.class;

    /**
     * 获取类加载器
     */
    @Test
    public void test01() {
        ClassLoader classLoader = c.getClassLoader();
        System.out.println("类加载器" + classLoader);

    }

    /**
     * 包名
     */
    @Test
    public void test02() {
        Package aPackage = c.getPackage();
        //System.out.println(aPackage);//package day24.HomeWork.HomeWork01
        System.out.println("包名" + aPackage.getName());//day24.HomeWork.HomeWork01

    }

    /**
     * 类名
     */
    @Test
    public void test03_1() {
        String s = c.getClass().toString();
        System.out.println("类名" + s);

    }

    /**
     * 类的修饰符
     */

    @Test
    public void test03_2() {
        int modifiers = c.getModifiers();
        String s = Modifier.toString(modifiers);
        System.out.println("类的修饰符" + s);

    }

    /**
     * 父类名
     */
    @Test
    public void test04() {
        String name = c.getSuperclass().getName();
        System.out.println("父类名" + name);

    }

    /**
     * 接口们
     */
    @Test
    public void test05() {
        Class[] interfaces = c.getInterfaces();
        System.out.println("接口" + Arrays.toString(interfaces));

    }

    /**
     * 属性
     */
    @Test
    public void test06() {
        Field[] declaredField = c.getDeclaredFields();
        for (Field f : declaredField) {
            System.out.println("修饰符：" + Modifier.toString(f.getModifiers()));//修饰符
            System.out.println("数据类型：" + f.getType().getName());//数据类型
            System.out.println("属性名：" + f.getName());//名字


        }
    }

    /**
     * 构造器
     */
    @Test
    public void test07() {
        Constructor[] declaredConstructors = c.getDeclaredConstructors();
        for (Constructor d : declaredConstructors) {
            System.out.println("修饰符：" + Modifier.toString(d.getModifiers()));//修饰符
            System.out.println("属性名：" + d.getName());//名字
            System.out.println("形参列表" + Arrays.toString(d.getParameterTypes()));
        }
    }


    /**
     * 成员方法
     */
    @Test
    public void test08() {
        Method[] declaredMethods = c.getDeclaredMethods();
        for (Method d : declaredMethods) {
            System.out.println("修饰符" + Modifier.toString(d.getModifiers()));
            System.out.println("返回值类型" + d.getReturnType());
            System.out.println("方法名" + d.getName());
            System.out.println("形参列表" + Arrays.toString(d.getParameterTypes()));

        }
    }

    /**
     * 用反射获取school的值，并修改school的值为“尚硅谷大学”，然后再获取school的值
     */
    @Test
    public void test09() throws NoSuchFieldException, IllegalAccessException {
        Field school = c.getDeclaredField("school");
        school.setAccessible(true);
        Object o = school.get(null);
        System.out.println(o);
        school.set(null, "财经大学");
        o = school.get(null);
        System.out.println(o);

    }


    /**
     * 用反射创建AtguiguDemo类的对象，并设置班级名称className属性的值，并获取它的值
     */
    @Test
    public void test10() throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Object o = c.newInstance();
        Field className = c.getDeclaredField("className");
        className.setAccessible(true);
        Object classname = className.get(o);
        System.out.println(classname);
        className.set(o, "信息管理与信息系统");
        classname = className.get(o);
        System.out.println(classname);
    }


    /**
     * 用反射获取有参构造创建2个AtguiguDemo类的对象，并获取compareTo方法，调用compareTo方法，比较大小。
     */
    @Test
    public void test11() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = c.getDeclaredConstructor(String.class);
        Object sh1 = constructor.newInstance("2504816574");
        Object o = constructor.newInstance("15725397437班");
        Object sh2 = o;

        Method compareTo = c.getDeclaredMethod("compareTo", School.class);
        System.out.println(sh1 + "与" + sh2 + ":" + compareTo.invoke(sh1, sh2));


    }

}