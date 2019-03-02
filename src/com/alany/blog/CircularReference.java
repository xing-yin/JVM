package com.alany.blog;

/**
 * 引用计数算法(循环引用时，此回收算法失效)
 *
 * @author yinxing
 * @date 2019/2/25
 */

public class CircularReference {

    public Object instance = null;

    /**
     * 循环引用时，此回收算法失效，变量a,b均不能回收
     *
     * @param args
     */
    public static void main(String[] args) {
        CircularReference a = new CircularReference();
        CircularReference b = new CircularReference();
        a.instance = b;
        b.instance = a;
        System.out.println("a.instance " + a.instance);
        System.out.println("b.instance " + b.instance);

    }

}
