package com.hqyj.jvm;

/**
 * 类加载器 实验
 *    演示反射、类模板...
 */
public class Car {

    public static void main(String[] args) {
        // 类是模板，对象是具体的
        // 生成类模板，不管生成多少都是 Car
        Class<Car> carClass = Car.class;

        // 实例化，名字在栈中（引用地址），真正的实例在堆中
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());
        System.out.println(car3.hashCode());

        // 转回类模板
        Class<? extends Car> aClass1 = car1.getClass();
        Class<? extends Car> aClass2 = car2.getClass();
        Class<? extends Car> aClass3 = car3.getClass();

        // 检验查看是否都是同一个类模板
        System.out.println(aClass1.hashCode());
        System.out.println(aClass2.hashCode());
        System.out.println(aClass3.hashCode());

        System.out.println("-----------------------");

        // 获取类加载器
        ClassLoader classLoader = aClass1.getClassLoader();
        System.out.println(classLoader); // AppClassLoader
        System.out.println(classLoader.getParent()); // ExtClassLoader ---> jre/lib/ext
        System.out.println(classLoader.getParent().getParent()); // null  1. 不存在 2.Java程序获取不到（底层C、C++）---> rt.jar
    }
}
