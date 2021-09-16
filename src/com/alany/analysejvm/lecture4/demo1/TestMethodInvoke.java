package com.alany.analysejvm.lecture4.demo1;

/**
 * 通常不提倡可变长参数方法的重载，是因为 Java 编译器可能无法决定应该调用哪个目标方法。
 * 在这种情况下，编译器会报错，并且提示这个方法调用有二义性。
 *
 * @author Alan Yin
 * @date 2021/9/13
 */

public class TestMethodInvoke {

    void invoke(Object obj, Object... args) {
        System.out.println("invoke1");
    }

    void invoke(String s, Object obj, Object... args) {
        System.out.println("invoke2");
    }

    public static void main(String[] args) {
        TestMethodInvoke invoke = new TestMethodInvoke();
        // 调用第二个 invoke 方法(本意想调用第一个方法)
        invoke.invoke(null, 1);
        // 调用第二个 invoke 方法
        invoke.invoke(null, 1, 2);
        // 只有手动绕开可变长参数的语法糖，才能调用第一个 invoke 方法
        invoke.invoke(null, new Object[]{1});
    }
}
