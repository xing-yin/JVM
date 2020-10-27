package com.alany.analysejvm.lecture3;

/**
 * 单例模式:
 *
 * @author Alan Yin
 * @date 2020/4/2
 */

/**
 * 这段代码是在著名的单例延迟初始化例子中，只有当调用 Singleton.getInstance 时，
 * 程序才会访问 LazyHolder.INSTANCE，才会触发对 LazyHolder 的初始化。
 * 即遇到访问静态字段/方法的指令时，初始化该静态字段所在的类，继而新建一个 Singleton 的实例。
 * <p>
 * 由于类初始化是线程安全的，并且仅被执行一次，因此程序可以确保多线程环境下有且仅有一个 Singleton 实例。
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

    public static Singleton getInstance() {
        System.out.println("instance");
        return LazyHolder.SINGLETON;
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
    }
}
