package com.alany.analysejvm.lecture3;

/**
 * jvm 加载类
 *
 * @author Alan Yin
 * @date 2020/4/2
 */

public class ClassLoadDemo {

    private int a;

    private static int b = 1;

    private static int c;

    private static final int d = 3;

    static {
        c = 2;
    }

    public static void main(String[] args) {
        ClassLoadDemo demo = new ClassLoadDemo();
        System.out.println("a" + demo.a);
        System.out.println("b" + b);
        System.out.println("c" + c);
        System.out.println("d" + d);
    }

}
