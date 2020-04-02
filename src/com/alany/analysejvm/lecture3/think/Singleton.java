package com.alany.analysejvm.lecture3.think;

/**
 * 单例模式:
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
        if (flag){
            return new LazyHolder[2];
        }
        return LazyHolder.SINGLETON;
    }

    public static void main(String[] args) {
        getInstance(true);
        System.out.println("=========");
        getInstance(false);
    }
}
