package com.alany.topic.reflect;

/**
 * Class.forName 和 classloader 的区别
 *
 * @author Alan Yin
 * @date 2020/12/3
 */

public class ClassloaderAndForNameTest {

    public static void main(String[] args) {
        String wholeNameLine = "com.alany.topic.reflect.Line";
        String wholeNamePoint = "com.alany.topic.reflect.Point";
        System.out.println("下面测试 classloader 效果");
        testClassloader(wholeNameLine, wholeNamePoint);
        System.out.println("-------------------");
        System.out.println("下面测试 Class.forName 效果");
        testClassForName(wholeNameLine, wholeNamePoint);
    }

    private static void testClassForName(String wholeNameLine, String wholeNamePoint) {
        try {
            Class line = Class.forName(wholeNameLine);
            Class point = Class.forName(wholeNamePoint);
            System.out.println("line:" + line.getName());
            System.out.println("point:" + point.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void testClassloader(String wholeNameLine, String wholeNamePoint) {
        Class<?> line;
        Class<?> point;
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        try {
            line = loader.loadClass(wholeNameLine);
            point = loader.loadClass(wholeNamePoint);
            System.out.println("line:" + line.getName());
            System.out.println("point:" + point.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

/**
 * 共同点: java 中 class.forName() 和 classLoader 都可用来对类进行加载。
 * <p>
 * 不同点:
 * - class.forName() 除了将类的 .class 文件加载到 jvm 中之外，还会对类进行解释，执行类中的 static 块。
 * - classLoader 只干一件事情，就是将 .class 文件加载到 jvm  中，不会执行 static 中的内容,只有在 newInstance 才会去执行 static 块。
 * <p>
 * > Class.forName(name, initialize, loader)带参函数也可控制是否加载static块。并且只有调用了newInstance()方法采用调用构造函数，创建类的对象
 */
