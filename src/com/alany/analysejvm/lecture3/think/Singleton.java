package com.alany.analysejvm.lecture3.think;

/**
 * JVM 加载类测试思考题:
 * <p>
 * 查看类加载的命令: java -XX: +TraceClassLoading Singleton
 * 通过 JVM 参数 -verbose:class 来打印类加载的先后顺序，并且在 LazyHolder 的初始化方法中打印特定字样。在命令行中运行下述指令（不包含提示符 $）：
 * <p>
 * - 问题 1：新建数组（第 31 行）会导致 LazyHolder 的加载吗？会导致它的初始化吗？
 * - 问题 2：新建数组会导致 LazyHolder 的链接吗？
 *
 * @author Alan Yin
 * @date 2020/4/2
 */

public class Singleton {

    private Singleton() {
    }

    private static class LazyHolder {
        private static final Singleton SINGLETON = new Singleton();

        static {
            System.out.println("LazyHolder.<clint>");
        }
    }

    public static Object getInstance(boolean flag) {
        if (flag) {
            return new LazyHolder[2];
        }
        return LazyHolder.SINGLETON;
    }

    public static void main(String[] args) {
        // 不会触发初始化: 不会打印 LazyHolder.<clint>(因为当遇到访问静态字段的指令时，初始化该静态字段所在的类；此处没有访问静态字段)
        getInstance(true);
        System.out.println("=========");
        // 触发初始化
        getInstance(false);
    }
}
