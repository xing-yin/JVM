package com.alany.analysejvm.lecture14.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型和类型擦除
 *
 * @author yinxing
 * @date 2019/12/12
 */

public class GenericTest<T extends Number> {

    T foo(T t) {
        return t;
    }

    public static void main(String[] args) {
        // 尽管经过类型擦除后，ArrayList.add 方法所接收的参数是 Object 类型，
        // 但是往泛型参数为 Integer 类型的 ArrayList 中添加字符串对象，Java 编译器是会报错的。
        List<Integer> list = new ArrayList<>(2);
        // list.add("2");
    }
}

/**
 *   T foo(T);
         descriptor: (Ljava/lang/Number;)Ljava/lang/Number;
         flags:
         Code:
         stack=1, locals=2, args_size=2
         0: aload_1
         1: areturn
         LineNumberTable:
         line 13: 0
         Signature: #11                          // (TT;)TT;
 */
