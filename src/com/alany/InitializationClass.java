package com.alany;

/**
 * 初始化
 * @author yinxing
 * @date 2019/2/27
 */

public class InitializationClass {

    static class Parent{
        public static int A = 1;
        static{
            A = 2;
        }
    }

    static class Sub extends Parent{
        public static int B=A;
    }

    public static void main(String[] args) {
        /**
         * 由于父类的 <clinit>() 方法先执行，也就意味着父类中定义的静态语句块的执行要优先于子类。
         */
        // 2
        System.out.println(Sub.B);
    }

}
