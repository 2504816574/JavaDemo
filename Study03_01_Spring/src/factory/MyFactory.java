package factory;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Auther Ashen One
 * @Date 2020/12/14
 */
public class MyFactory implements FactoryBean<Car> {
    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        car.setBrand("奔驰");
        car.setPrice(200000.0);
        return car;

    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
