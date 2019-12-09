package com.alany.analysejvm.lecture9.demo3;

import java.util.stream.IntStream;

/**
 * @author yinxing
 * @date 2019/12/9
 */

public class Lambda {

    public static void main(String[] args) {
        int x = 2;
        long sum = IntStream.of(1, 2, 3).map(i -> i * 2).map(i -> i * x).sum();
        System.out.println(sum);
    }
}
