package com.alany.blog.invokXXX;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * JVM指令之 invokestatic,invokespecial,invokeinterface,invokevirtual,invokedynamic
 *
 * @author yinxing
 * @date 2019/12/2
 */

public class JVMInstuctionTest implements Runnable {

    public JVMInstuctionTest() {
        System.out.println("construct method ==> invoke special");
    }

    private void invokeSpecialMethod() {
        System.out.println("private method ==> invoke special");
    }

    void invokeVirtualMethod() {
        System.out.println("instance method ==> invoke virtual");
    }

    static void invokeStaticMethod() {
        System.out.println("static method ==> invoke static");
    }

    @Override
    public void run() {
        System.out.println("invoke interface");
    }

    /**
     * 以下为使用 MethodHandle
     *
     * @param s
     */
    public void methodHandle(String s) {
        System.out.println("for method handle " + s + " ==> invokedynamic");
    }

    public static void staticMethodHandle(String s) {
        System.out.println("static for method handle " + s + " ==> invokestatic");
    }


    public static void main(String[] args) throws Throwable {
        // I.使用 invoke 指令
        /**
         * invokespecial
         */
        JVMInstuctionTest test = new JVMInstuctionTest();
        /**
         * invokespecial
         */
        test.invokeSpecialMethod();
        /**
         * invokevirtual
         */
        test.invokeVirtualMethod();
        /**
         * invokestatic
         */
        invokeStaticMethod();
        /**
         * invokeinterface
         */
        Runnable runnable = new JVMInstuctionTest();
        runnable.run();
        /**
         * invokedynamic
         * Java 8中，lambda表达式和默认方法时，底层会生成和使用invoke dynamic
         */
        List<Integer> list = Arrays.asList(1, 2, 3);
        list.stream().forEach(System.out::println);
        System.out.println("==============");

        // II.使用 MethodHandle
        /**
         * invokedynamic
         */
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh = lookup.findVirtual(JVMInstuctionTest.class,
                "methodHandle",
                MethodType.methodType(void.class,String.class));
        System.out.println(mh);
        mh.bindTo(test).invoke("no static string");

        mh = lookup.findStatic(JVMInstuctionTest.class,
                "staticMethodHandle",
                MethodType.methodType(void.class,String.class));
        mh.invoke("static string");
        System.out.println("==============");

        // III.使用 reflect
        Class clazz = Class.forName("com.alany.blog.invokXXX.JVMInstuctionTest");
        Object obj = clazz.newInstance();
        Method method = clazz.getMethod("methodHandle",String.class);
        method.invoke(obj,"aaa");
    }
}
