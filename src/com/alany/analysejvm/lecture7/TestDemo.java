package com.alany.analysejvm.lecture7;

/**
 * @author yinxing
 * @date 2019/10/23
 */
public class TestDemo {

    private String name;

    private int count;

    public String publicString="test";

    public TestDemo(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public void test1() {
        System.out.println("test1");
    }

    public void test2() {
        System.out.println("test2");
    }

    private void test3() {
        System.out.println("test3");
    }
}
