package com.alany.topic.method_area;

/**
 * Integer 默认会缓存 -128～127 的数值
 *
 * @author Alan Yin
 * @date 2020/11/26
 */

public class IntegerCacheDemo {

    public static void main(String[] args) {
        Integer i1 = 100;
        Integer i2 = 100;
        System.out.println(i1 == i2); // true

        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println(i3 == i4); // false

        Integer i5 = 20;
        Integer i6 = new Integer(20);
        System.out.println(i5 == i6); // false
    }
}
