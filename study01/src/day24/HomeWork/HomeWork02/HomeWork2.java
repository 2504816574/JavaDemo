package day24.HomeWork.HomeWork02;

import java.io.IOException;
import java.util.Properties;

/**
 *    java day24.HomeWork.HomeWork02
 */
public class HomeWork2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Properties properties = new Properties();
        properties.load(HomeWork2.class.getClassLoader().getResourceAsStream("config.properties"));
        Class<?> fruit = Class.forName(properties.getProperty("fruitName"));
        Fruit o =(Fruit) fruit.newInstance();
        new Juicer().run(o);

    }
}

interface Fruit {
    void squeeze();
}

class Juicer {
    public void run(Fruit fruit) {
        fruit.squeeze();
    }
}

class Apple implements Fruit {

    @Override
    public void squeeze() {
        System.out.println("苹果汁");
    }
}

class Banana implements Fruit {

    @Override
    public void squeeze() {
        System.out.println("香蕉汁");
    }
}