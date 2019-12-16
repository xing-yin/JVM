package com.alany.blog.temp;

/**
 * @author yinxing
 * @date 2019/12/16
 */

public class Sub2 implements Parent {

    @Override
    public String say() {
        return "sub2";
    }

    public static void main(String[] args) {
        Parent p1 = new Sub1();
        Parent p2 = new Sub2();
        System.out.println(p1.say());
        System.out.println(p2.say());
    }
}
